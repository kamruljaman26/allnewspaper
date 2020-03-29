package com.example.bdallnewspaper.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import com.example.bdallnewspaper.R;
import com.example.bdallnewspaper.adapter.ViewPagerAdapter;
import com.example.bdallnewspaper.admob.AdService;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news_paper__profile);

        toolbar = findViewById(R.id.toolbar_id);

        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewPager_id);
        navigationView = findViewById(R.id.navigation_view_id);
        drawerLayout =findViewById(R.id.drawer_layout_id);

        //ads
        LinearLayout adContainer = findViewById(R.id.banner_ad_container);
        AdService.adService.addBannerAd(adContainer);

        setSupportActionBar(toolbar);
        setViewPageAddapter ();

        tabLayout.setupWithViewPager(viewPager);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    /**
     * On Back Pressed
     */
    @Override
    public void onBackPressed() {
        exitConfirmation();
    }

    /**
     * Exit Confirmation Dialog
     */
    private void exitConfirmation(){
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(true)
                .setNeutralButton("Rate App", ((dialog,which) -> {
                    shareApp();
                }))
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .show();
    }

    /**
     * Set Adapter
     */
    public void setViewPageAddapter (){
        ViewPagerAdapter viewPager_adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager_adapter.AddFragment(new BanglaFragment(),"বাংলা");
        viewPager_adapter.AddFragment(new EnglishFragment(),"ইংরেজি");
        viewPager_adapter.AddFragment(new TopPortalFragment(),"টপ পোর্টাল");
        viewPager_adapter.AddFragment(new AllPortalFragment(),"সব পোর্টাল");

        viewPager.setAdapter(viewPager_adapter);
    }

    /**
     * Navigation Item Clcik
     * @param menuItem
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        if (menuItem.getItemId()==R.id.share_app_id){
            shareApp();
        }else if (menuItem.getItemId()==R.id.rate_app_id){
            rateApp();
        }

        return true;
    }

    /**
     * Will Show share app popup
     */
    private void shareApp(){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Application Link : https://play.google.com/store/apps/details?id=${App.context.getPackageName()}";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "App Link");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share App Link Via :"));
    }

    /**
     * Will goto playstore for rate the app.
     */
    private void rateApp(){
        Context context = getApplicationContext();
        Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
        }
    }



}
