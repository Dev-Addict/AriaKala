package ir.ariaman.ariakala.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ir.ariaman.ariakala.R;
import ir.ariaman.ariakala.adapter.SliderAdapter;

public class HomePageSliderFragment extends Fragment {
    private ViewPager viewPager;
    private List<View> slides;
    private List<Integer> slidesBackgroundRes;
    private LayoutInflater inflater;
    private PagerAdapter sliderAdapter;
    private Handler autoPlayHandler;
    private Runnable runnable;
    private int miliSeconds, currentPos;
    private boolean isPlaying;
    private List<String> slidesText;
    private List<String> slidesFont;

    public HomePageSliderFragment() {
    }

    public static HomePageSliderFragment newInstance() {
        HomePageSliderFragment fragment = new HomePageSliderFragment();
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

    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page_slider, container, false);
        init(inflater, view);
        return view;
    }

    private void init(LayoutInflater inflater, View view) {
        this.inflater = inflater;
        initSlider(view);
    }

    @SuppressLint("InflateParams")
    private void initSlider(View view) {
        currentPos = 0;
        isPlaying = false;
        viewPager = view.findViewById(R.id.fragment_home_page_slider_slider_view_pager);
        slides = new ArrayList<>();
        slides.add(inflater.inflate(R.layout.home_page_slide_audiowide, null));
        slides.add(inflater.inflate(R.layout.home_page_slide_cakar, null));
        slides.add(inflater.inflate(R.layout.home_page_slide_fusena_sans, null));
        slidesBackgroundRes = new ArrayList<>();
        slidesBackgroundRes.add(R.drawable.slide_blue_background);
        slidesBackgroundRes.add(R.drawable.slide_pink_background);
        slidesBackgroundRes.add(R.drawable.slide_purple_background);
        slidesText = new ArrayList<>();
        slidesText.add("Most Viewed Products");
        slidesText.add("newest products");
        slidesText.add("best seller products");
        slidesFont = new ArrayList<>();
        slidesFont.add("anoxic");
        slidesFont.add("cakar_monyet_bold");
        slidesFont.add("fusena");
        for (int i = 0; i < 3; i++) {
            TextView slideTextView = slides.get(i).findViewById(R.id.home_page_slide_text_view);
            slideTextView.setBackgroundResource(slidesBackgroundRes.get(i));
            slideTextView.setText(slidesText.get(i));
        }
        sliderAdapter = new SliderAdapter(getActivity(), slides);
        viewPager.setAdapter(sliderAdapter);
        viewPager.setOffscreenPageLimit(slides.size());
        miliSeconds = 5000;
        startAutoPlay();
        viewPager.setClipToPadding(false);
        viewPager.setPadding(96, 0, 96, 0);
        viewPager.setPageMargin(48);
    }

    private void goToNextPageAuto() {
        viewPager.setCurrentItem((
                viewPager.getCurrentItem() + 1) % sliderAdapter.getCount());
        autoPlayHandler.postDelayed(runnable, miliSeconds);
    }

    public void startAutoPlay() {
        isPlaying = true;
        autoPlayHandler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                goToNextPageAuto();
            }
        };
        autoPlayHandler.postDelayed(runnable, miliSeconds);
    }

    public void stopAutoPlay() {
        isPlaying = false;
        autoPlayHandler.removeCallbacks(runnable);
    }
}
