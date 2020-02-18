package ir.ariaman.ariakala.model.retrofit;

import java.util.List;

import ir.ariaman.ariakala.model.jsonschema.category.Category;
import ir.ariaman.ariakala.model.jsonschema.product.Product;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("products?consumer_key=ck_e649ccf09f6c55391b196c11747a6881b651dd41&consumer_secret=cs_386c57bfe7de869709e0b3f98bca137e37a8a62d")
    Call<List<Product>> getProductsDatas();
    @GET("products/categories?consumer_key=ck_e649ccf09f6c55391b196c11747a6881b651dd41&consumer_secret=cs_386c57bfe7de869709e0b3f98bca137e37a8a62d")
    Call<List<Category>> getProductCategories();
}