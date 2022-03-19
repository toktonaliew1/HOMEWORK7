package com.example.homework7.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.homework7.OnBoardModel;
import com.example.homework7.fragment.OnBoardFragment;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingAdapter extends FragmentStateAdapter {
    List<OnBoardModel> list = new ArrayList<>();

    public OnBoardingAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, List<OnBoardModel> list) {
        super(fragmentManager, lifecycle);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new OnBoardFragment();
        Bundle bundle = new Bundle();
        bundle.putString(OnBoardFragment.TITLE, list.get(position).getTitle());
        bundle.putString(OnBoardFragment.TITLE, list.get(position).getTitle());
        bundle.putString(OnBoardFragment.TITLE, list.get(position).getTitle());
        bundle.putInt(OnBoardFragment.IMAGE, list.get(position).getImage());
        bundle.putInt(OnBoardFragment.IMAGE, list.get(position).getImage());
        bundle.putInt(OnBoardFragment.IMAGE, list.get(position).getImage());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
