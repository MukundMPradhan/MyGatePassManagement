package in.app.myandroid.mygatepassmanagement;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

import in.app.myandroid.mygatepassmanagement.model.LoginUser;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    ArrayList<LoginUser> loginUsers;

    //
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;

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

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

//          = new DataBaseHelper(this);
//        loginUsers = dataBaseHelper.getAllUserStaffs();

        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mnu_home:
                Toast.makeText(this, "Home Button Clicked", Toast.LENGTH_SHORT).show();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container, new HomeFragment());
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Log-In ....");
                item.setChecked(true);

                break;

//                        drawerLayout.closeDrawers();
//                        Toast.makeText(getApplicationContext(), "Home Button Clicked", Toast.LENGTH_SHORT).show();
            case R.id.mnu_new_ind_pass:
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container, new AddNewIndividualPass());
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("New Pass ....");
                item.setChecked(true);
                // drawerLayout.closeDrawer(Gravity.LEFT);
                Toast.makeText(getApplicationContext(), "Individual Pass", Toast.LENGTH_SHORT).show();

                break;
        }
        return true;
    }
}

