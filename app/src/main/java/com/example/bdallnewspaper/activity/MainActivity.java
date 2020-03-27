package com.example.bdallnewspaper.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bdallnewspaper.R;
import com.example.bdallnewspaper.adapter.ViewPager_Adapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private long backpressedTime;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private MenuItem menuItemShare,menuItemRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news_paper__profile);

        toolbar = findViewById(R.id.toolbar_id);

        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewPager_id);
        navigationView = findViewById(R.id.navigation_view_id);
        drawerLayout =findViewById(R.id.drawer_layout_id);
        menuItemRate = findViewById(R.id.rate_app_id);
        menuItemShare = findViewById(R.id.share_app_id);

        setSupportActionBar(toolbar);
        SetViewPageAddapter (viewPager);
        tabLayout.setupWithViewPager(viewPager);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        //actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {

        if(backpressedTime + 2000>System.currentTimeMillis()){

            super.onBackPressed();
            return;
        }
        else{

            Toast.makeText(getApplicationContext(),"Press back again to exit",Toast.LENGTH_SHORT).show();

        }
        backpressedTime = System.currentTimeMillis();
    }

    public void SetViewPageAddapter (ViewPager viewPager){

        ViewPager_Adapter viewPager_adapter = new ViewPager_Adapter(getSupportFragmentManager());
        viewPager_adapter.AddFragment(new BanglaFragment(),"Bangla");
        viewPager_adapter.AddFragment(new English(),"English");
        viewPager_adapter.AddFragment(new TopPortal(),"Top Portal");
        viewPager_adapter.AddFragment(new AllPortalBangladesh(),"All Portal");

        viewPager.setAdapter(viewPager_adapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        if (menuItem.getItemId()==R.id.share_app_id){


        }

        else if (menuItem.getItemId()==R.id.rate_app_id){


        }


        return true;
    }
}
