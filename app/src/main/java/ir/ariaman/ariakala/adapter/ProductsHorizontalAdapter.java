package ir.ariaman.ariakala.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import  ir.ariaman.ariakala.R;
import ir.ariaman.ariakala.model.Repository;
import ir.ariaman.ariakala.model.jsonschema.product.Category;
import ir.ariaman.ariakala.model.jsonschema.product.Product;

public class ProductsHorizontalAdapter
        extends RecyclerView.Adapter<ProductsHorizontalAdapter.ProductsHorizontalViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<Product> products;
    private int cardWidth;
    private int cardHeight;

    public ProductsHorizontalAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        List<Product> allProducts = Repository.getInstance().getProducts();
        allProducts.removeIf(product -> {
            List<Category> categories = product.getCategories();
            for (Category category : categories) {
                if (category.getId() == 119) {
                    return true;
                }
            }
            return false;
        });
        Collections.shuffle(allProducts);
        if (allProducts.size() >= 10) {
            products = allProducts.subList(0, 10);
        } else {
            products = allProducts.subList(0, allProducts.size());
        }
    }

    @NonNull
    @Override
    public ProductsHorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view =
                inflater.inflate(R.layout.horizontal_product_card, null);
        return new ProductsHorizontalViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ProductsHorizontalViewHolder holder, int position) {
        if (position == products.size() + 1) {
            ((FrameLayout) holder.view).removeAllViews();
            @SuppressLint("InflateParams") View seeAllView =
                    inflater.inflate(R.layout.see_all_products_option, null);
            holder.view.setMinimumWidth(cardWidth);
            holder.view.setMinimumHeight(cardHeight);
            seeAllView.setMinimumWidth(cardWidth);
            seeAllView.setMinimumHeight(cardHeight);
            ((FrameLayout) seeAllView).getChildAt(0).setMinimumWidth(cardWidth);
            ((FrameLayout) seeAllView).getChildAt(0).setMinimumHeight(cardHeight);
            ((FrameLayout) holder.view).addView(seeAllView);
        } else if (position == 0) {
            ((FrameLayout) holder.view).removeAllViews();
            ((FrameLayout) holder.view).setPadding(0, 0, 0, 0);
            @SuppressLint("InflateParams") View seeMore =
                    inflater.inflate(R.layout.see_more_amazing_products, null);
            ((FrameLayout) holder.view).addView(seeMore);
        } else {
            Product product = products.get(position - 1);
            Picasso
                    .with(context)
                    .load(product.getImages().get(0).getSrc())
                    .fit()
                    .placeholder(R.drawable.ic_action_loading)
                    .centerCrop()
                    .error(R.drawable.ic_action_error)
                    .into(holder.productImageImageView);
            if (parseHTML(product.getShortDescription()).equals("")) {
                holder.productTitleTextView.setText(parseHTML(product.getShortDescription()));
            } else {
                holder.productTitleTextView.setText(product.getName());
            }
            if (product.getOnSale() && product.getDateOnSaleFrom() != null) {
                int present = ((Integer.parseInt(product.getPrice()) -
                        Integer.parseInt(product.getRegularPrice())) /
                        Integer.parseInt(product.getPrice()));
                holder.productDiscountTextView.setText(present + "%");
                updateDiscountTime(holder, product, position);
                holder.productPriceTextView.setText(product.getRegularPrice());
                holder.productPriceTextView
                        .setPaintFlags(holder.productPriceTextView.getPaintFlags() |
                                Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                holder.productDiscountTextView.setVisibility(View.INVISIBLE);
                holder.productDiscountTimeTextView.setVisibility(View.INVISIBLE);
                holder.productPriceTextView.setVisibility(View.INVISIBLE);
            }
            holder.productCurrentPriceTextView.setText(product.getPrice());
            cardWidth = holder.view.getWidth();
            cardHeight = holder.view.getHeight();
        }
    }

    private void updateDiscountTime(@NonNull ProductsHorizontalViewHolder holder,
                                    Product product,
                                    int position) {
        Handler handler = new Handler();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateParser =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        Date endDiscountDate = new Date();
        try {
            endDiscountDate = dateParser.parse(product.getDateOnSaleFrom().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert endDiscountDate != null;
        long discountTime =
                (currentDate.getTime() - endDiscountDate.getTime()) / 1000;
        int discountSeconds = (int) (discountTime % 60);
        int discountMinutes = (int) (((discountTime - discountSeconds) / 60) % 60);
        int discountHour =
                (int) ((discountTime - discountMinutes * 60 - discountSeconds) / 3600);
        String finalSeconds = discountSeconds < 10 ?
                "0" + discountSeconds :
                "" + discountSeconds;
        String finalMinutes = discountMinutes < 10 ?
                "0" + discountMinutes :
                "" + discountMinutes;
        String finalHour = discountHour < 10 ?
                "0" + discountHour :
                "" + discountHour;
        holder.productDiscountTimeTextView.setText(
                String.format("%s:%s:%s", finalHour, finalMinutes, finalSeconds));
        if (discountTime != 0) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    updateDiscountTime(holder, product, position);
                }
            }, 1000);
        } else {
            notifyItemChanged(position);
        }

    }

    @Override
    public int getItemCount() {
        return products.size() + 2;
    }

    public class ProductsHorizontalViewHolder extends RecyclerView.ViewHolder {
        ImageView productImageImageView;
        TextView productTitleTextView,
                productDiscountTextView,
                productCurrentPriceTextView,
                productPriceTextView,
                productDiscountTimeTextView;
        View view;

        public ProductsHorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            productImageImageView =
                    itemView.findViewById(
                            R.id.horizontal_product_card_product_image_image_view);
            productTitleTextView =
                    itemView.findViewById(
                            R.id.horizontal_product_card_product_title_text_view);
            productDiscountTextView =
                    itemView.findViewById(
                            R.id.horizontal_product_card_product_discount_text_view);
            productCurrentPriceTextView =
                    itemView.findViewById(
                            R.id.horizontal_product_card_product_current_price_text_view);
            productPriceTextView =
                    itemView.findViewById(
                            R.id.horizontal_product_card_product_price_text_view);
            productDiscountTimeTextView =
                    itemView.findViewById(
                            R.id.horizontal_product_card_product_discount_time_text_view);
        }
    }

    public String parseHTML(String stringWithHTML) {
        return Jsoup.parse(stringWithHTML).text();
    }
}
