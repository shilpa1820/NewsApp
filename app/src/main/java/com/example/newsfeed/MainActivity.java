package com.example.newsfeed;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
TabLayout tabLayout;
TabItem ihome , iscience,ihealth, itech,ientertainment,isports;
PagerAdapter pagerAdapter;
Toolbar itoolbar;
String api="62267259a3494ee19d1694eab3d83c29";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itoolbar=findViewById(R.id.toolbar);
        setSupportActionBar(itoolbar);

        ihome=findViewById(R.id.home);
        iscience= findViewById(R.id.science);
        isports=findViewById(R.id.sports);
        itech=findViewById(R.id.technology);
        ientertainment=findViewById(R.id.entertainment);
        ihealth=findViewById(R.id.health);
        ViewPager viewPager= findViewById(R.id.fragment_container);
        tabLayout = findViewById(R.id.include);

        pagerAdapter = new PagerAdapter((getSupportFragmentManager()),6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()>=0)
                {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }
}