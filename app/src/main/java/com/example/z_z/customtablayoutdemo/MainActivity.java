package com.example.z_z.customtablayoutdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CustomTabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
      mTabLayout = findViewById(R.id.tabLayout_main);
      mViewPager = findViewById(R.id.viewPager_main);
      String[] tabTitles = getResources().getStringArray(R.array.arrTabTitles);
        for (int i = 0; i < tabTitles.length; i++) {
            DummyFragment fragment = DummyFragment.newInstance(i);
            mFragmentList.add(fragment);
        }

        mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),mFragmentList,tabTitles));
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
