package com.mfb.frennpaylibrary.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mfb.frennpaylibrary.ExistingUserFragment;
import com.mfb.frennpaylibrary.NewUserFragment;

public class HomePageAdapter extends FragmentPagerAdapter {
    int totalTabs;

    public HomePageAdapter(FragmentManager fm, int totalTabs) {
        super(fm);
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ExistingUserFragment existingUserFragment = new ExistingUserFragment();
                return existingUserFragment;
            default:
                NewUserFragment newUserFragment = new NewUserFragment();
                return newUserFragment;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
