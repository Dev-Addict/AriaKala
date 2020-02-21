package ir.ariaman.ariakala.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import ir.ariaman.ariakala.R;
import ir.ariaman.ariakala.model.Repository;
import ir.ariaman.ariakala.model.jsonschema.category.Category;

public class HomePageFragment extends Fragment {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    public HomePageFragment() {
    }

    public static HomePageFragment newInstance() {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        init(view);
        return view;
    }

    public void init(View view) {
        fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
        initSlider();
        initCircularCategories();
        initAmazingProducts();
        initRandomCategoriesBlock();
        initRandomCateogryHorizontalProducts();
    }

    private void initCircularCategories() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(
                R.id.fragment_home_page_circular_categories_frame_layout,
                CircularCategoriesFragment.newInstance())
                .commit();
    }

    private void initSlider() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(
                R.id.fragment_home_page_slider_frame_layout,
                HomePageSliderFragment.newInstance())
                .commit();
    }

    private void initAmazingProducts() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(
                R.id.fragment_home_page_amazing_products_frame_layout,
                ProductsHorizontalRecyclerFragment.newInstance())
                .commit();
    }

    private void initRandomCategoriesBlock() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(
                R.id.fragment_home_page_random_categories_block_frame_layout,
                RandomCategoryBlockFragment.newInstance())
                .commit();
    }

    private void initRandomCateogryHorizontalProducts() {
        List<Category> allCategories = Repository.getInstance().getCategories();
        allCategories.removeIf(category -> category.getId().equals(119));
        Random random = new Random();
        int index = random.nextInt(allCategories.size());
        Category category = allCategories.get(index);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(
                R.id.fragment_home_page_random_category_horizontal_products_frame_layout,
                ProductsHorizontalRecyclerFragment.newInstance(category.getId()))
                .commit();
    }
}
