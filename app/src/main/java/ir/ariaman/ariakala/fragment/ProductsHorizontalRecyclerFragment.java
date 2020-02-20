package ir.ariaman.ariakala.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.ariaman.ariakala.R;
import ir.ariaman.ariakala.adapter.ProductsHorizontalAdapter;

public class ProductsHorizontalRecyclerFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter productsHorizontalAdapter;

    public ProductsHorizontalRecyclerFragment() {
    }

    public static ProductsHorizontalRecyclerFragment newInstance() {
        ProductsHorizontalRecyclerFragment fragment = new ProductsHorizontalRecyclerFragment();
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
        View view = inflater.inflate(R.layout.fragment_products_horizontal_recycler, container, false);
        recyclerView = view.findViewById(R.id.fragment_products_horizontal_recycler_recycler_view);
        layoutManager = new LinearLayoutManager(
                getActivity(),
                RecyclerView.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(layoutManager);
        productsHorizontalAdapter =new ProductsHorizontalAdapter(getActivity());
        recyclerView.setAdapter(productsHorizontalAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setItemViewCacheSize(productsHorizontalAdapter.getItemCount());
        return view;
    }
}
