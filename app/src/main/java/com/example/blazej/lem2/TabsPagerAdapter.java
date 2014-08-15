package com.example.blazej.lem2;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


/**
 * Created by blazej on 03.08.14.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new Dashboard();
            case 1:
                // Games fragment activity
                //return new GamesFragment();
                return new Map();
            case 2:
                // Movies fragment activity
                //return new MoviesFragment();
                return new Patameters();
            case 3:
                // Movies fragment activity
                //return new MoviesFragment();
                return new Settings();
            case 4:
                // Movies fragment activity
                //return new MoviesFragment();
                return new Logout();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 5;
    }

}
