package in.app.myandroid.mygatepassmanagement.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import in.app.myandroid.mygatepassmanagement.R;
import in.app.myandroid.mygatepassmanagement.adapter.CustomAdapterCompanyDisplay;
import in.app.myandroid.mygatepassmanagement.dbhelper.DataBaseHelper;
import in.app.myandroid.mygatepassmanagement.model.Company;


public class CompanyListDisplayFragment extends android.support.v4.app.Fragment {


    private ListView listViewCompanyList;
    private FloatingActionButton fab;

    int selectedItem;
    // Company companyList;


    DataBaseHelper dataBaseHelper;
    CustomAdapterCompanyDisplay customAdapterCompanyDisplay;

    ArrayList<Company> companies;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_company_display, container, false);


        listViewCompanyList = (ListView) view.findViewById(R.id.recyclerViewCompanyList);
        fab = (FloatingActionButton) view.findViewById(R.id.faButton);

        registerForContextMenu(listViewCompanyList);


        dataBaseHelper = new DataBaseHelper(getActivity());

        companies = dataBaseHelper.getAllCompanyList();
        customAdapterCompanyDisplay = new CustomAdapterCompanyDisplay(getActivity(), companies);

        listViewCompanyList.setAdapter(customAdapterCompanyDisplay);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Fab Clicked", Toast.LENGTH_SHORT).show();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.main_container, new AddEditCompanyFragment());
                ft.commit();


            }
        });


        listViewCompanyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem = i;
//                selectedItem=new Company(listViewCompanyList.getItemAtPosition(i).)
                Toast.makeText(getActivity(), "Please do long press ...", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select One");

        menu.add(100, 1, 1, "Edit");
        menu.add(101, 1, 2, "Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 1) {
//            txtCompName.setText(companies.get(selectedItem).getCompName());
//            txtCompAdd.setText(companies.get(selectedItem).getCompAdd());
//            txtContactPerson.setText(companies.get(selectedItem).getContactNo());
//            txtContactNo.setText(companies.get(selectedItem).getContactNo());
//            btnSubmit.setText("Update");
//            btnSubmit.requestFocus();

            Toast.makeText(getActivity(), "Clicked Edit", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == 2) {
            Toast.makeText(getActivity(), "Delete Clicked", Toast.LENGTH_SHORT).show();
        }

        return super.onContextItemSelected(item);
    }
}
