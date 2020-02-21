package ir.ariaman.ariakala.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Date;
import java.util.List;
import java.util.Random;

import ir.ariaman.ariakala.R;
import ir.ariaman.ariakala.adapter.ProductsHorizontalAdapter;
import ir.ariaman.ariakala.model.Repository;
import ir.ariaman.ariakala.model.jsonschema.category.Category;

public class ProductsHorizontalRecyclerFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter productsHorizontalAdapter;
    private final static String PARAMS_CATEGORY_ID = "CATEGORY_ID";
    private final static String PARAMS_IS_SOME_CATEGORY = "IS_SOME_CATEGORY";
    private Category category;
    private int categoryId;
    private boolean isSomeCategory;

    public ProductsHorizontalRecyclerFragment() {
    }

    public static ProductsHorizontalRecyclerFragment newInstance() {
        ProductsHorizontalRecyclerFragment fragment = new ProductsHorizontalRecyclerFragment();
        Bundle args = new Bundle();
        args.putBoolean(PARAMS_IS_SOME_CATEGORY, false);
        fragment.setArguments(args);
        return fragment;
    }

    public static ProductsHorizontalRecyclerFragment newInstance(int categoryID) {
        ProductsHorizontalRecyclerFragment fragment = new ProductsHorizontalRecyclerFragment();
        Bundle args = new Bundle();
        args.putInt(PARAMS_CATEGORY_ID, categoryID);
        args.putBoolean(PARAMS_IS_SOME_CATEGORY, true);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            if (getArguments().getBoolean(PARAMS_IS_SOME_CATEGORY)){
                isSomeCategory = true;
                categoryId = getArguments().getInt(PARAMS_CATEGORY_ID);
            } else {
                isSomeCategory = false;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products_horizontal_recycler, container, false);
        recyclerView = view.findViewById(R.id.fragment_products_horizontal_recycler_recycler_view);
        layoutManager = new LinearLayoutManager(
                getActivity(),
                RecyclerView.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(layoutManager);
        if (isSomeCategory) {
            for (Category category : Repository.getInstance().getCategories()) {
                if (category.getId().equals(categoryId)) {
                    this.category = category;
                }
            }
            if (category == null) {
                List<Category> allCategories = Repository.getInstance().getCategories();
                int index = new Random(new Date().getTime()).nextInt(allCategories.size());
                category = allCategories.get(index);
            }
            productsHorizontalAdapter = new ProductsHorizontalAdapter(getActivity(), category.getId(), category);
            view.setBackgroundResource(R.color.colorApple);
        } else {
            productsHorizontalAdapter = new ProductsHorizontalAdapter(getActivity());
        }
        recyclerView.setAdapter(productsHorizontalAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setItemViewCacheSize(productsHorizontalAdapter.getItemCount());
        return view;
    }
}
