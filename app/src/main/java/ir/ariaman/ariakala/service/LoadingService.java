package ir.ariaman.ariakala.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import ir.ariaman.ariakala.event.NetworkConnectionErrorEvent;
import ir.ariaman.ariakala.event.RetrySettingDataEvent;
import ir.ariaman.ariakala.event.SettingPreDataFinishedEvent;
import ir.ariaman.ariakala.model.Repository;
import ir.ariaman.ariakala.model.jsonschema.Category;
import ir.ariaman.ariakala.model.jsonschema.Product;
import ir.ariaman.ariakala.model.retrofit.GetDataService;
import ir.ariaman.ariakala.model.retrofit.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadingService extends Service {
    GetDataService dataService;
    Call<List<Product>> productsCall;
    Call<List<Category>> categoriesCall;

    public LoadingService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        EventBus.getDefault().register(this);
        setData();
        return START_STICKY;
    }

    private void setData() {
        initRetrofit();
        setProducts();
    }

    private void setProducts() {
        productsCall.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    Repository.getInstance().setProducts(response.body());
                    setCategories();
                }else {
                    NetworkConnectionErrorEvent.postNetworkConnectionError(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                NetworkConnectionErrorEvent.postNetworkConnectionError(t.getMessage());
            }
        });
    }

    private void setCategories() {
        categoriesCall.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {
                    Repository.getInstance().setCategories(response.body());
                    SettingPreDataFinishedEvent.postSettingPreDataFinishedEvent();
                    stopSelf();
                }
                else {
                    NetworkConnectionErrorEvent.postNetworkConnectionError(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                NetworkConnectionErrorEvent.postNetworkConnectionError(t.getMessage());
            }
        });
    }

    private void initRetrofit() {
        dataService = RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService.class);
        productsCall = dataService.getProductsDatas();
        categoriesCall = dataService.getProductCategories();
    }

    @Subscribe
    public void retrySettingData(RetrySettingDataEvent event) {
        setData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
