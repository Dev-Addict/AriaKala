package ir.ariaman.ariakala.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
    private List<Integer> backgrounds;

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
        backgrounds = new ArrayList<>();
        backgrounds.add(R.drawable.circle_image_view_bittersweet);
        backgrounds.add(R.drawable.circle_image_view_portage);
        backgrounds.add(R.drawable.circle_image_view_malibu);
        backgrounds.add(R.drawable.circle_image_view_spray);
        backgrounds.add(R.drawable.circle_image_view_tickle_me_pink);
    }

    @NonNull
    @Override
    public CircularCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.circular_categories_item, null);
        return new CircularCategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CircularCategoriesViewHolder holder, int position) {
        holder.imageView.setBackgroundResource(backgrounds.get(position % backgrounds.size()));
        Picasso
                .with(context)
                .load(categories.get(position).getImage().getSrc())
                .fit()
                .placeholder(R.drawable.ic_action_loading)
                .centerCrop().error(R.drawable.ic_action_error)
                .into(holder.imageView);
        holder.textView.setText(categories.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CircularCategoriesViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public CircularCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.circular_categories_item_image_view);
            textView = itemView.findViewById(R.id.circular_categories_item_text_view);
        }
    }
}
