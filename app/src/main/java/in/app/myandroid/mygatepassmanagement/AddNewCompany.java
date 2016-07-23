package in.app.myandroid.mygatepassmanagement;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import in.app.myandroid.mygatepassmanagement.adapter.CustomAdapterCompanyDisplay;
import in.app.myandroid.mygatepassmanagement.dbhelper.DataBaseHelper;
import in.app.myandroid.mygatepassmanagement.model.Company;



public class AddNewCompany extends Fragment {

    private EditText txtCompName, txtCompAdd, txtContactPerson, txtContactNo;
    private Button btnSubmit, btnCancel;
    private ListView listViewCompanyList;


    DataBaseHelper dataBaseHelper;
    CustomAdapterCompanyDisplay customAdapterCompanyDisplay;

    ArrayList<Company> companies;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_new_company, container, false);

        txtCompName = (EditText) view.findViewById(R.id.etACCompName);
        txtCompAdd = (EditText) view.findViewById(R.id.etACCompAdd);
        txtContactPerson = (EditText) view.findViewById(R.id.etACContactPerson);
        txtContactNo = (EditText) view.findViewById(R.id.etACConatactNo);
        btnSubmit = (Button) view.findViewById(R.id.buttonACSubmit);
        btnCancel = (Button) view.findViewById(R.id.buttonACCancel);
        listViewCompanyList = (ListView) view.findViewById(R.id.listviewDisplayCompany);

        dataBaseHelper = new DataBaseHelper(getActivity());

        companies = dataBaseHelper.getAllCompanyList();
        customAdapterCompanyDisplay = new CustomAdapterCompanyDisplay(getActivity(), companies);

        listViewCompanyList.setAdapter(customAdapterCompanyDisplay);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper.insertCompany(txtCompName.getText().toString().trim(), txtCompAdd.getText().toString().trim()
                        , txtContactPerson.getText().toString().trim(), txtContactNo.getText().toString().trim());

                Toast.makeText(getActivity(), "Data Saved Successfully...", Toast.LENGTH_SHORT).show();


                txtCompName.setText("");
                txtCompAdd.setText("");
                txtContactPerson.setText("");
                txtContactNo.setText("");
                txtCompName.requestFocus();

                customAdapterCompanyDisplay.notifyDataSetChanged();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "You Clicked Cancel Button", Toast.LENGTH_SHORT).show();
            }
        });




        return  view;
    }


}
