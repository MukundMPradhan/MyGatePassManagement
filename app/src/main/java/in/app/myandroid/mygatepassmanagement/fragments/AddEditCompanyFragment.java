package in.app.myandroid.mygatepassmanagement.fragments;

import android.app.DialogFragment;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import in.app.myandroid.mygatepassmanagement.R;
import in.app.myandroid.mygatepassmanagement.dbhelper.DataBaseHelper;


public class AddEditCompanyFragment extends Fragment {

    private EditText txtCompName, txtCompAdd, txtContactPerson, txtContactNo;
    private Button btnSubmit, btnCancel;

    DataBaseHelper dataBaseHelper;


    public AddEditCompanyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_edit_company, container, false);

        txtCompName = (EditText) view.findViewById(R.id.etACCompName);
        txtCompAdd = (EditText) view.findViewById(R.id.etACCompAdd);
        txtContactPerson = (EditText) view.findViewById(R.id.etACContactPerson);
        txtContactNo = (EditText) view.findViewById(R.id.etACConatactNo);
        btnSubmit = (Button) view.findViewById(R.id.buttonACSubmit);
        btnCancel = (Button) view.findViewById(R.id.buttonACCancel);


        dataBaseHelper = new DataBaseHelper(getActivity());


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btnSubmit.getText().equals("Submit")) {

                    dataBaseHelper.insertCompany(txtCompName.getText().toString().trim(), txtCompAdd.getText().toString().trim()
                            , txtContactPerson.getText().toString().trim(), txtContactNo.getText().toString().trim());

                    Toast.makeText(getActivity(), "Data Saved Successfully...", Toast.LENGTH_SHORT).show();
                    getFragmentManager().beginTransaction().replace(R.id.main_container, new CompanyListDisplayFragment()).commit();


//                    txtCompName.setText("");
//                    txtCompAdd.setText("");
//                    txtContactPerson.setText("");
//                    txtContactNo.setText("");
//                    txtCompName.requestFocus();
//                    customAdapterCompanyDisplay.notifyDataSetChanged();
                } else if (btnSubmit.getText().equals("Update")) {
                    btnSubmit.setText("Submit");
                }

            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Toast.makeText(getActivity(), "You Clicked Cancel Button", Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                CompanyListDisplayFragment compDisplay = new CompanyListDisplayFragment();
                ft.replace(R.id.main_container, new CompanyListDisplayFragment());
                ft.commit();
            }
        });

        return view;

    }

}
