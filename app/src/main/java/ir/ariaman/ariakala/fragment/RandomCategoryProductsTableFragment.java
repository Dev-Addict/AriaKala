package ir.ariaman.ariakala.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import ir.ariaman.ariakala.R;
import ir.ariaman.ariakala.model.Repository;
import ir.ariaman.ariakala.model.jsonschema.category.Category;
import ir.ariaman.ariakala.model.jsonschema.product.Product;

public class RandomCategoryProductsTableFragment extends Fragment {
    private final static String PARAMS_CATEGORY_ID = "CATEGORY_ID";

    private int categoryId;
    private Category category;
    private List<Product> products, rightProducts;
    private List<LinearLayout> tableRowsLinearLayouts;
    private TextView titleTextView, seeMoreTextView;

    public RandomCategoryProductsTableFragment() {
    }

    public static RandomCategoryProductsTableFragment newInstance(int categoryId) {
        RandomCategoryProductsTableFragment fragment = new RandomCategoryProductsTableFragment();
        Bundle args = new Bundle();
        args.putInt(PARAMS_CATEGORY_ID, categoryId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            categoryId = getArguments().getInt(PARAMS_CATEGORY_ID);
            boolean isCategorySeted = false;
            for (Category category : Repository.getInstance().getCategories()) {
                if (category.getId().equals(categoryId)) {
                    this.category = category;
                    isCategorySeted = true;
                    break;
                }
            }
            if (!isCategorySeted) {
                setCategoryRandom();
            }
        } else {
            setCategoryRandom();
        }
        List<Product> rightProducts = new ArrayList<>();
        for (Product product : Repository.getInstance().getProducts()) {
            for (ir.ariaman.ariakala.model.jsonschema.product.Category productCategory :
                    product.getCategories()) {
                if (productCategory.getId().equals(categoryId)) {
                    rightProducts.add(product);
                }
            }
        }
        this.rightProducts = rightProducts;
        if (rightProducts.size() >= 9) {
            products = rightProducts.subList(0, 9);
        } else {
            products = rightProducts;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_random_category_products_table, container, false);
        titleTextView =
                view.findViewById(
                        R.id.fragment_random_category_products_table_category_title_text_view);
        seeMoreTextView =
                view.findViewById(
                        R.id.fragment_random_category_products_table_see_more_text_view);
        titleTextView.setText(category.getName());
        tableRowsLinearLayouts = new ArrayList<>();
        tableRowsLinearLayouts
                .add(view.findViewById(
                        R.id.fragment_random_category_products_table_products_table_first_row_linear_layout));
        tableRowsLinearLayouts
                .add(view.findViewById(
                        R.id.fragment_random_category_products_table_products_table_second_row_linear_layout));
        tableRowsLinearLayouts
                .add(view.findViewById(
                        R.id.fragment_random_category_products_table_products_table_third_row_linear_layout));
        for (int i = 0; i < products.size(); i++) {
            Picasso
                    .with(getActivity())
                    .load(products.get(i).getImages().get(0).getSrc())
                    .fit()
                    .placeholder(R.drawable.ic_action_loading)
                    .centerCrop()
                    .error(R.drawable.ic_action_error)
                    .into(((ImageView) tableRowsLinearLayouts.get(i / 3).getChildAt(i % 3)));
        }
        if (rightProducts.size() < 10) {
            seeMoreTextView.setText("see some products in this category  >");
        } else if (rightProducts.size() < 100) {
            int roundAmountOverTen = rightProducts.size() - rightProducts.size() % 10;
            seeMoreTextView.setText(
                    String.format("see more than %d products  >", roundAmountOverTen));
        } else {
            int roundAmountOverHundred = rightProducts.size() - rightProducts.size() % 100;
            seeMoreTextView.setText(
                    String.format("see more than %d products  >", roundAmountOverHundred));
        }
        return view;
    }

    private void setCategoryRandom() {
        Random random = new Random(new Date().getTime());
        List<Category> categories = Repository.getInstance().getCategories();
        int index = random.nextInt(categories.size());
        category = categories.get(index);
        categoryId = category.getId();
    }
}
