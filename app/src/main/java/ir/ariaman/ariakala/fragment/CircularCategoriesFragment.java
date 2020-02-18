package ir.ariaman.ariakala.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.ariaman.ariakala.R;
import ir.ariaman.ariakala.adapter.CircularCategoriesAdapter;

public class CircularCategoriesFragment extends Fragment {
    private RecyclerView recyclerView;
    private LayoutManager layoutManager;
    private Adapter circularCategoriesAdapter;

    public static CircularCategoriesFragment newInstance() {
        CircularCategoriesFragment fragment = new CircularCategoriesFragment();
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
        View view = inflater.inflate(R.layout.fragment_circular_categories, container, false);
        recyclerView = view.findViewById(R.id.fragment_circular_categories_recycler_view);
        layoutManager = new LinearLayoutManager(
                getActivity(),
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(layoutManager);
        circularCategoriesAdapter = new CircularCategoriesAdapter(getActivity());
        recyclerView.setAdapter(circularCategoriesAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setItemViewCacheSize(circularCategoriesAdapter.getItemCount());
        return view;
    }
}
