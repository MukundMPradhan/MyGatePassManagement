package in.app.myandroid.mygatepassmanagement.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import in.app.myandroid.mygatepassmanagement.R;
import in.app.myandroid.mygatepassmanagement.dbhelper.DataBaseHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment {

    private TextView txtUsuUserID, txtUsuPassword, txtUsuCnfPassword, txtUsuFastName, txtUsuLastName;
    private TextView txtUsuFrName, txtUsuMobNo, txtUsuPhotoPath, txtUsuEmail, txtUsuDob;
    private Spinner spinnerRole, spinnerGender;
    private Button btnSubmit, btnCancel;

    ArrayAdapter adapterRole;
    ArrayAdapter adapterGender;


    DataBaseHelper dataBaseHelper;


    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_signup, container, false);

        txtUsuUserID = (TextView) v.findViewById(R.id.etUsuUserId);
        txtUsuPassword = (TextView) v.findViewById(R.id.etUsuPassword);
        txtUsuFastName = (TextView) v.findViewById(R.id.etUsuFastName);
        txtUsuLastName = (TextView) v.findViewById(R.id.etUsuLastName);
        txtUsuFrName = (TextView) v.findViewById(R.id.etUsuFrName);
        txtUsuMobNo = (TextView) v.findViewById(R.id.etUsuMobile);
        txtUsuCnfPassword = (TextView) v.findViewById(R.id.etUsuCnfPassword);
        txtUsuPhotoPath = (TextView) v.findViewById(R.id.etUsuPhotos);
        txtUsuEmail = (TextView) v.findViewById(R.id.etUsuEmail);
        btnSubmit = (Button) v.findViewById(R.id.buttonUsuSubmit);
        btnCancel = (Button) v.findViewById(R.id.buttonUsuCancel);

        spinnerRole = (Spinner) v.findViewById(R.id.spinner);
        spinnerGender = (Spinner) v.findViewById(R.id.spinnerGender);
        txtUsuDob = (TextView) v.findViewById(R.id.etUsuDob);

        adapterRole = ArrayAdapter.createFromResource(getActivity(), R.array.role, R.layout.layout_text_view);
        adapterGender = ArrayAdapter.createFromResource(getActivity(), R.array.gender, R.layout.layout_text_view);

        spinnerRole.setAdapter(adapterRole);
        spinnerGender.setAdapter(adapterGender);

        dataBaseHelper = new DataBaseHelper(getActivity());


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = txtUsuUserID.getText().toString();
                String pw = txtUsuPassword.getText().toString();
                String role = spinnerRole.getSelectedItem().toString();
                String fastName = txtUsuFastName.getText().toString();
                String lastName = txtUsuLastName.getText().toString();
                String frName = txtUsuFrName.getText().toString();
                String gender = spinnerGender.getSelectedItem().toString();
                String dob = txtUsuDob.getText().toString();
                String mobNo = txtUsuMobNo.getText().toString();
                String photoPath = txtUsuPhotoPath.getText().toString();
                String email = txtUsuEmail.getText().toString();


                dataBaseHelper.insertUser(id, pw, role, fastName, lastName, frName, gender,
                        dob, mobNo, photoPath, email);

                txtUsuUserID.setText("");
                txtUsuPassword.setText("");
                txtUsuCnfPassword.setText("");
                spinnerRole.setSelection(0);
                txtUsuFastName.setText("");
                txtUsuLastName.setText("");
                txtUsuFrName.setText("");
                spinnerGender.setSelection(0);
                txtUsuDob.setText("");
                txtUsuMobNo.setText("");
                txtUsuPhotoPath.setText("");
                txtUsuEmail.setText("");
                txtUsuPhotoPath.setText("");
                Toast.makeText(getActivity(), "Account Creation Done Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });


        txtUsuEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (txtUsuEmail.getText().toString().length() < 1)
                        txtUsuEmail.setError("Email field can not be empty");
                }
            }
        });
        txtUsuUserID.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (txtUsuUserID.getText().toString().length() < 1) {
                        txtUsuUserID.setError("User ID may not be blank");
                    }
                }
            }
        });
        txtUsuPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (txtUsuPassword.getText().toString().length() < 1)
                        txtUsuPassword.setError("Password may not be blank");
                }
            }
        });
        txtUsuCnfPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (txtUsuCnfPassword.getText().toString().length() < 1) {
                        txtUsuCnfPassword.setError("Plz re-enter correct password");
                    } else if (!txtUsuPassword.getText().toString().trim().equals(txtUsuCnfPassword.getText().toString().trim())) {
                        txtUsuCnfPassword.setError("Both password not same");

                    }
                }
            }
        });


        return v;
    }

}
