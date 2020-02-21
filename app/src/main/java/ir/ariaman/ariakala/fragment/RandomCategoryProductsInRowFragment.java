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

public class RandomCategoryProductsInRowFragment extends Fragment {
    private final static String PARAMS_CATEGORY_ID = "CATEGORY_ID";

    private int categoryId;
    private Category category;
    private List<Product> products;
    private LinearLayout rowLinearLayout;
    private List<Integer> backgrounds;
    private TextView titleTextView;

    public RandomCategoryProductsInRowFragment() {
    }

    public static RandomCategoryProductsInRowFragment newInstance(int categoryId) {
        RandomCategoryProductsInRowFragment fragment = new RandomCategoryProductsInRowFragment();
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
        if (rightProducts.size() >= 3) {
            products = rightProducts.subList(0, 3);
        } else {
            products = rightProducts;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_random_category_products_in_row, container, false);
        rowLinearLayout = view.findViewById(
                        R.id.fragment_random_category_products_in_row_image_row_linear_layout);
        titleTextView = view.findViewById(
                R.id.fragment_random_category_products_in_row_category_title);
        backgrounds = new ArrayList<>();
        backgrounds.add(R.color.colorMalibu);
        backgrounds.add(R.color.colorPortage);
        backgrounds.add(R.color.colorBittersweet);
        backgrounds.add(R.color.colorTickleMePink);
        backgrounds.add(R.color.colorDollyAlpha);
        backgrounds.add(R.color.colorRedRibbon);
        backgrounds.add(R.color.colorApple);
        for (int i = 0; i < 3; i++) {
            rowLinearLayout.getChildAt(i)
                    .setBackgroundResource(backgrounds.get(new Random().nextInt(7)));
        }
        for (int i = 0; i < products.size(); i++) {
            Picasso
                    .with(getActivity())
                    .load(products.get(i).getImages().get(0).getSrc())
                    .fit()
                    .placeholder(R.drawable.ic_action_loading)
                    .centerCrop()
                    .error(R.drawable.ic_action_error)
                    .into(((ImageView) rowLinearLayout.getChildAt(i)));
        }
        titleTextView.setText(String.format("%s  >", category.getName()));
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
