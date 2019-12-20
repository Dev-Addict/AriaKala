package ir.ariaman.ariakala.model.retrofit;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit = new Builder()
            .baseUrl("https://woocommerce.maktabsharif.ir/wp-json/wc/v3/")
            .addConverterFactory(
                    GsonConverterFactory
                            .create())
            .build();;
    public static Retrofit getRetrofitInstance(){
        return retrofit;
    }
}