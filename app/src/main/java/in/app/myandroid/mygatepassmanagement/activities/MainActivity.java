package in.app.myandroid.mygatepassmanagement.activities;


import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import in.app.myandroid.mygatepassmanagement.R;
import in.app.myandroid.mygatepassmanagement.fragments.AcceptedPassesListFragment;
import in.app.myandroid.mygatepassmanagement.fragments.AllPassesListFragment;
import in.app.myandroid.mygatepassmanagement.fragments.CompanyListDisplayFragment;
import in.app.myandroid.mygatepassmanagement.fragments.AddNewIndividualPassFragment;
import in.app.myandroid.mygatepassmanagement.fragments.AddNewVehiclePassFragment;
import in.app.myandroid.mygatepassmanagement.fragments.HomeFragment;
import in.app.myandroid.mygatepassmanagement.fragments.LoginFragment;
import in.app.myandroid.mygatepassmanagement.model.LoginUser;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    ArrayList<LoginUser> loginUsers;

    //
    FragmentTransaction fragmentTransaction;



    //DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, new LoginFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Log-In ....");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

//          = new DataBaseHelper(this);
//        loginUsers = dataBaseHelper.getAllUserStaffs();

        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return true;
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if (item.isChecked()) item.setChecked(false);
        else item.setChecked(true);

        drawerLayout.closeDrawers();

        switch (item.getItemId()) {
            case R.id.mnu_home:
                Toast.makeText(getApplicationContext(), "Home Button Clicked", Toast.LENGTH_SHORT).show();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container, new AllPassesListFragment());
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("All Passes ...");
                // item.setChecked(true);

                break;
            case R.id.mnu_new_ind_pass:
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container, new AddNewIndividualPassFragment());
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("New Individual Pass ....");
                //  Toast.makeText(getApplicationContext(), "Individual Pass", Toast.LENGTH_SHORT).show();

                break;
            case R.id.mnu_new_veh_pass:
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container, new AddNewVehiclePassFragment());
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("New Vehicle Pass ....");
                break;
            case R.id.mnu_new_company:
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container, new CompanyListDisplayFragment());
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Add New Company ....");
                break;

        }
        return true;
    }
}

