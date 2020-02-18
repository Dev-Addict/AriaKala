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

import ir.ariaman.ariakala.R;

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
        initSlider();
        initCircularCategories();
    }

    private void initCircularCategories() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(
                R.id.fragment_home_page_circular_categories_frame_layout,
                CircularCategoriesFragment.newInstance())
                .commit();
    }

    private void initSlider() {
        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(
                R.id.fragment_home_page_slider_frame_layout,
                HomePageSliderFragment.newInstance())
                .commit();
    }
}
