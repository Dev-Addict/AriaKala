package ir.ariaman.ariakala.model;

import java.util.List;

import ir.ariaman.ariakala.model.jsonschema.category.Category;
import ir.ariaman.ariakala.model.jsonschema.product.Product;

public class Repository {
    private static final Repository ourInstance = new Repository();
    private List<Product> products;
    private List<Category> categories;

    public static Repository getInstance() {
        return ourInstance;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static Repository getOurInstance() {
        return ourInstance;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    private Repository() {
    }
}
