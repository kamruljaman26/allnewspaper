package com.example.bdallnewspaper.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.bdallnewspaper.admob.AdService;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragments = new ArrayList<>();

    private  final ArrayList<String> stringsFragmet = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public  void AddFragment (Fragment fragment, String title){
        fragments.add(fragment);
        stringsFragmet.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringsFragmet.get(position);
    }


}
