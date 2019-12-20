package ir.ariaman.ariakala.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import ir.ariaman.ariakala.R;
import ir.ariaman.ariakala.event.NetworkConnectionErrorEvent;
import ir.ariaman.ariakala.event.RetrySettingDataEvent;

public class LoadingFragment extends Fragment {
    private LottieAnimationView loadingLottieAnimationView;
    private TextView networkConnectionErrorTextView;
    private ImageView retryImageView;

    public LoadingFragment() {
    }

    public static LoadingFragment newInstance() {
        LoadingFragment fragment = new LoadingFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loading, container, false);
        initComponents(view);
        return view;
    }

    private void initComponents(View view) {
        loadingLottieAnimationView =
                view.findViewById(R.id.fragment_loading_loading_lottie_animation_view);
        networkConnectionErrorTextView =
                view.findViewById(R.id.fragment_loading_network_connection_error_text_view);
        retryImageView
                = view.findViewById(R.id.fragment_loading_retry_image_view);
        retryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrySettingDataEvent.postRetrySettingDataEvent();
                retryImageView.setVisibility(View.INVISIBLE);
                networkConnectionErrorTextView.setVisibility(View.INVISIBLE);
                loadingLottieAnimationView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Subscribe
    public void getNetworkConnectionError(NetworkConnectionErrorEvent event) {
        loadingLottieAnimationView.setVisibility(View.INVISIBLE);
        networkConnectionErrorTextView.setVisibility(View.VISIBLE);
        retryImageView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }
}
