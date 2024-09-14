package vn.edu.usth.mobile_project.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import vn.edu.usth.mobile_project.Adapter.ViewPagerAdapter;
import vn.edu.usth.mobile_project.Fragment.FloderFragment;
import vn.edu.usth.mobile_project.Fragment.InboxFragment;
import vn.edu.usth.mobile_project.Fragment.StatterdFragment;
import vn.edu.usth.mobile_project.R;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);

        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);
        frameLayout = findViewById(R.id.frameLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);
                viewPager2.setCurrentItem(tab.getPosition());

                if (tab.getIcon() != null) {
                    tab.getIcon().setTint(getResources().getColor(R.color.red));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getIcon() != null) {
                    tab.getIcon().setTint(getResources().getColor(R.color.btn_bg)); // Set your default color here
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager2.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.red));
                        break;
                    case 1:
                        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.red));
                        break;
                    case 2:
                        tabLayout.getTabAt(position).select();
                }
                super.onPageSelected(position);
            }
        });


        ImageButton btnSetting = findViewById(R.id.btnSetting);

//        btnSetting.setOnClickListener(v -> {
////            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
//            startActivity(intent);
//            finish();
//        });


        ImageButton button = findViewById(R.id.btnSearch);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });


    }


}