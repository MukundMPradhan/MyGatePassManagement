package in.app.myandroid.mygatepassmanagement.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import in.app.myandroid.mygatepassmanagement.fragments.AcceptedPassesListFragment;
import in.app.myandroid.mygatepassmanagement.fragments.AllPassesListFragment;
import in.app.myandroid.mygatepassmanagement.fragments.PendingPassesListFragment;

/**
 * Created by mukund on 24/7/16.
 */

public class TabsAdapter extends FragmentPagerAdapter {
    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new AllPassesListFragment();

            case 1:
                return new AcceptedPassesListFragment();

            case 2:
                return new PendingPassesListFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
