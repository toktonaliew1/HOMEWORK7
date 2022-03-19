package com.example.homework7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.homework7.adapter.OnBoardingAdapter;
import com.example.homework7.databinding.ActivityOnBoardBinding;

import java.util.ArrayList;
import java.util.List;

public class OnBoardActivity extends AppCompatActivity {

    private ActivityOnBoardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupData();
        setupListener();
        pagerListener();
    }




    private void setupData() {
        List<OnBoardModel> list = new ArrayList<>();
        list.add(new OnBoardModel(R.drawable.wallet, "Smart Wallet"));
        list.add(new OnBoardModel(R.drawable.ic_launcher_foreground, "Effortless Budgeting"));
        list.add(new OnBoardModel(R.drawable.ic_launcher_foreground, "Automatic Savings"));
        OnBoardingAdapter onBoardingAdapter = new OnBoardingAdapter(getSupportFragmentManager(), getLifecycle(), list);
        binding.pager.setAdapter(onBoardingAdapter);
    }

    private void setupListener() {
        binding.btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.btnText.getText() == "start"){
                    Intent intent = new Intent(OnBoardActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                }
                else {
                    binding.pager.setCurrentItem(binding.pager.getCurrentItem() + 1);
                }

            }

        });
        binding.btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnBoardActivity.this,MainActivity.class);
                startActivity(intent);


            }
        });
    }
    private void pagerListener() {
        binding.pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 2 ){
                    binding.btnText.setText("start");
                }
                else {
                    binding.btnText.setText("next");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

    }

}