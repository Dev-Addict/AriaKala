package ir.ariaman.ariakala.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ir.ariaman.ariakala.R;
import ir.ariaman.ariakala.model.Repository;
import ir.ariaman.ariakala.model.jsonschema.category.Category;

public class CircularCategoriesAdapter extends RecyclerView.Adapter<CircularCategoriesAdapter.CircularCategoriesViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<Category> categories;

    public CircularCategoriesAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        categories = new ArrayList<>();
        List<Category> allCategories = Repository.getInstance().getCategories();
        for (Category category : allCategories) {
            if (category.getParent() == 0) {
                categories.add(category);
            }
        }
    }

    @NonNull
    @Override
    public CircularCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.circular_categories_item, null);
        return new CircularCategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CircularCategoriesViewHolder holder, int position) {
        Picasso
                .with(context)
                .load(categories.get(position).getImage().getSrc())
                .fit()
                .placeholder(R.drawable.ic_action_loading)
                .centerCrop().error(R.drawable.ic_action_error)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CircularCategoriesViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public CircularCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.circular_categories_item_image_view);
        }
    }
}
