package ir.ariaman.ariakala.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import ir.ariaman.ariakala.R;
import ir.ariaman.ariakala.event.SettingPreDataFinishedEvent;
import ir.ariaman.ariakala.fragment.LoadingFragment;
import ir.ariaman.ariakala.service.LoadingService;

public class LoadingActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        initFragment();
        startLoadingService();
    }

    private void startLoadingService() {
        Intent loadingServiceIntent = new Intent(this, LoadingService.class);
        startService(loadingServiceIntent);
    }

    private void initFragment() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity_loading_fragment_frame_layout, LoadingFragment.newInstance()).commit();
    }

    @Subscribe
    public void startNextActivity(SettingPreDataFinishedEvent event) {
        Intent mainActivityIntent = new Intent(LoadingActivity.this, MainActivity.class);
        startActivity(mainActivityIntent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
