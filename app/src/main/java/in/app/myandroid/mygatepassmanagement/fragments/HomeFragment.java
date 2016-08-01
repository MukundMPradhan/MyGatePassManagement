package in.app.myandroid.mygatepassmanagement.fragments;


import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.app.myandroid.mygatepassmanagement.R;
import in.app.myandroid.mygatepassmanagement.adapter.TabsAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener, ActionBar.TabListener, android.support.v7.app.ActionBar.TabListener {

    ViewPager viewPager;
    TabsAdapter tabsAdapter;

    ActionBar actionBar;
    android.support.v7.app.ActionBar mActionBar;


    String[] tabs = {"All Passes", "Accepted Passes", "Pending Passes"};


    public HomeFragment() {
        // Required empty public constructor
       // actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabsAdapter = new TabsAdapter(getFragmentManager());



///         mActionBar.setHomeButtonEnabled(false);
        viewPager.setAdapter(tabsAdapter);


      //  mActionBar.setNavigationMode(android.support.v7.app.ActionBar.NAVIGATION_MODE_TABS);


        for (String tab : tabs) {
//            mActionBar.addTab(mActionBar.newTab().setText(tab).setTabListener(this));
        }

        viewPager.setOnPageChangeListener(this);


        return view;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }
}
