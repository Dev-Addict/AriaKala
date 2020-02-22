package ir.ariaman.ariakala.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import ir.ariaman.ariakala.R;

public class MainFragment extends Fragment implements View.OnClickListener {
    private ArrayList<Integer> tabsSelectedDrawableResId,
            tabsNotSelectedDrawableResId;
    private ArrayList<LinearLayout> tabsLinearLayout;
    private ArrayList<ImageView> tabsImageView;
    private ArrayList<TextView> tabsTextView;
    private ArrayList<Fragment> tabsFragment;
    private ArrayList<Integer> tabsFragmentState;
    private FrameLayout fragmentFrameLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private int lastFragmentIndex;

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        init(view);
        return view;
    }

    public void init(View view) {
        initTabs(view);
        initFragmentSystem(view);
        setFragment(0);
    }

    public void initTabs(View view) {
        tabsSelectedDrawableResId = new ArrayList<>();
        tabsNotSelectedDrawableResId = new ArrayList<>();
        tabsLinearLayout = new ArrayList<>();
        tabsImageView = new ArrayList<>();
        tabsTextView = new ArrayList<>();
        tabsFragment = new ArrayList<>();
        tabsFragmentState = new ArrayList<>();
        tabsSelectedDrawableResId.add(R.drawable.ic_action_home_selected);
        tabsNotSelectedDrawableResId.add(R.drawable.ic_action_home_not_selected);
        tabsSelectedDrawableResId.add(R.drawable.ic_action_category_selected);
        tabsNotSelectedDrawableResId.add(R.drawable.ic_action_category_not_selected);
        tabsSelectedDrawableResId.add(R.drawable.ic_action_cart_selected);
        tabsNotSelectedDrawableResId.add(R.drawable.ic_action_cart_not_selected);
        tabsSelectedDrawableResId.add(R.drawable.ic_action_user_selected);
        tabsNotSelectedDrawableResId.add(R.drawable.ic_action_user_not_selected);
        tabsLinearLayout.add(view.findViewById(R.id.fragment_main_home_linear_layout));
        tabsLinearLayout.add(view.findViewById(R.id.fragment_main_category_linear_layout));
        tabsLinearLayout.add(view.findViewById(R.id.fragment_main_cart_linear_layout));
        tabsLinearLayout.add(view.findViewById(R.id.fragment_main_user_linear_layout));
        tabsImageView.add(view.findViewById(R.id.fragment_main_home_image_view));
        tabsImageView.add(view.findViewById(R.id.fragment_main_category_image_view));
        tabsImageView.add(view.findViewById(R.id.fragment_main_cart_image_view));
        tabsImageView.add(view.findViewById(R.id.fragment_main_user_image_view));
        tabsTextView.add(view.findViewById(R.id.fragment_main_home_text_view));
        tabsTextView.add(view.findViewById(R.id.fragment_main_category_text_view));
        tabsTextView.add(view.findViewById(R.id.fragment_main_cart_text_view));
        tabsTextView.add(view.findViewById(R.id.fragment_main_user_text_view));
        tabsFragmentState.add(0);
        tabsFragmentState.add(0);
        tabsFragmentState.add(0);
        tabsFragmentState.add(0);
        lastFragmentIndex = 0;
        for (LinearLayout linearLayout : tabsLinearLayout) {
            linearLayout.setOnClickListener(this);
        }
    }

    public void initFragmentSystem(View view) {
        fragmentFrameLayout = view.findViewById(R.id.fragment_main_fragment_frame_layout);
        fragmentManager = getActivity().getSupportFragmentManager();
        tabsFragment.add(HomePageFragment.newInstance());
        tabsFragment.add(HomePageFragment.newInstance());
        tabsFragment.add(HomePageFragment.newInstance());
        tabsFragment.add(HomePageFragment.newInstance());
    }

    @Override
    public void onClick(View v) {
        setTab(tabsLinearLayout.indexOf(v));
    }

    public void setTab(int tabIndex) {
        for (int i = 0; i < tabsImageView.size(); i++) {
            tabsImageView.get(i).setImageResource(tabsNotSelectedDrawableResId.get(i));
            tabsTextView.get(i).setTextColor(ContextCompat
                    .getColor(getActivity(), R.color.colorSantaGray));
        }
        tabsImageView.get(tabIndex).setImageResource(tabsSelectedDrawableResId.get(tabIndex));
        tabsTextView.get(tabIndex).setTextColor(ContextCompat
                .getColor(getActivity(), R.color.colorGunPowder));
        setFragment(tabIndex);
    }

    public void setFragment(int tabIndex) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(
                R.id.fragment_main_fragment_frame_layout,
                tabsFragment.get(tabIndex))
                .commit();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
