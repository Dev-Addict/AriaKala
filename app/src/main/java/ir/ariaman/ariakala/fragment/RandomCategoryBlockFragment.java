package ir.ariaman.ariakala.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ir.ariaman.ariakala.R;
import ir.ariaman.ariakala.model.Repository;
import ir.ariaman.ariakala.model.jsonschema.category.Category;

public class RandomCategoryBlockFragment extends Fragment {
    private List<FrameLayout> frameLayouts;
    private List<View> blocks;
    private List<Integer> backgrounds;

    private List<Category> categories;

    public RandomCategoryBlockFragment() {
    }

    public static RandomCategoryBlockFragment newInstance() {
        RandomCategoryBlockFragment fragment = new RandomCategoryBlockFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Category> allCategories = new ArrayList<>();
        for (Category category : Repository.getInstance().getCategories()) {
            if (category.getId() != 119) {
                allCategories.add(category);
            }
        }
        Collections.shuffle(allCategories);
        if (allCategories.size() >= 4) {
            categories = allCategories.subList(0, 4);
        } else {
            categories = allCategories;
        }
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_random_category_block, container, false);
        frameLayouts = new ArrayList<>();
        frameLayouts.add(
                view.findViewById(R.id.fragment_random_category_block_block_one_frame_layout));
        frameLayouts.add(
                view.findViewById(R.id.fragment_random_category_block_block_two_frame_layout));
        frameLayouts.add(
                view.findViewById(R.id.fragment_random_category_block_block_three_frame_layout));
        frameLayouts.add(
                view.findViewById(R.id.fragment_random_category_block_block_four_frame_layout));
        blocks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            @SuppressLint("InflateParams") View block =
                    inflater.inflate(R.layout.category_block, null);
            blocks.add(block);
        }
        backgrounds = new ArrayList<>();
        backgrounds.add(R.drawable.slide_blue_background);
        backgrounds.add(R.drawable.slide_pink_background);
        backgrounds.add(R.drawable.slide_purple_background);
        backgrounds.add(R.drawable.slide_spray_background);
        for (int i = 0; i < categories.size(); i++) {
            blocks.get(i).setBackgroundResource(backgrounds.get(i));
            TextView categoryNameTextView =
                    blocks.get(i).findViewById(R.id.category_block_category_name_text_view);
            ImageView categoryImageImageView =
                    blocks.get(i).findViewById(R.id.category_block_category_image_image_view);
            categoryNameTextView.setText(categories.get(i).getName());
            Picasso
                    .with(getActivity())
                    .load(categories.get(i).getImage().getSrc())
                    .fit()
                    .placeholder(R.drawable.ic_action_loading)
                    .centerCrop()
                    .error(R.drawable.ic_action_error)
                    .into(categoryImageImageView);
            frameLayouts.get(i).removeAllViews();
            frameLayouts.get(i).addView(blocks.get(i));
        }
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
