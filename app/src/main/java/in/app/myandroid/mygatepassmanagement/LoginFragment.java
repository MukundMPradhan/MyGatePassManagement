package in.app.myandroid.mygatepassmanagement;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import in.app.myandroid.mygatepassmanagement.dbhelper.DataBaseHelper;
import in.app.myandroid.mygatepassmanagement.model.LoginUser;


public class LoginFragment extends Fragment {

    private Button btnSignIn, btnSignUp;
    private EditText txtUserName, txtUserPassword;

    DataBaseHelper dataBaseHelper;
    ArrayList<LoginUser> loginUsers;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        btnSignIn = (Button) view.findViewById(R.id.buttonSignIn);
        btnSignUp = (Button) view.findViewById(R.id.buttonSignUp);
        txtUserName = (EditText) view.findViewById(R.id.etSignInUserName);
        txtUserPassword = (EditText) view.findViewById(R.id.etSignInPassword);

        dataBaseHelper = new DataBaseHelper(getActivity());

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = txtUserName.getText().toString();
                String userPassword = txtUserPassword.getText().toString();
                String savedPassword = dataBaseHelper.getUserSearchEntry(userName);

                if (userPassword.equals(savedPassword)) {

                    Toast.makeText(getActivity(), "Congratulation... Login Successfully", Toast.LENGTH_SHORT).show();

                    //   FragmentManager fragmentManager = getFragmentManager();
                    //      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    HomeFragment homeFragment = new HomeFragment();
                    fragmentTransaction.replace(R.id.main_container, homeFragment);

                    fragmentTransaction.commit();
                }else{
                    Toast.makeText(getActivity(), "User Name & Password not correct..", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean MasterLogin = false;
                if (MasterLogin) {

                } else {
                    //    final DialogFragment dialogFragment=new DialogFragment();
                    final Dialog dialog = new Dialog(getActivity());
                    dialog.setContentView(R.layout.fragment_master_login);
                    dialog.setTitle("Master Login ...");
                    final EditText txtMasterName = (EditText) dialog.findViewById(R.id.etMasterUserName);
                    final EditText txtMasterPassword = (EditText) dialog.findViewById(R.id.etMasterPassword);
                    final Button btnMasterLogin = (Button) dialog.findViewById(R.id.buttonMasterLogin);

                    btnMasterLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String userMasterName = txtMasterName.getText().toString();
                            String userMasterPassword = txtMasterPassword.getText().toString();
                            // String savedMasterUserName=dataBaseHelper.getMasterEntry("UserName");
                            String savedMasterUserName = dataBaseHelper.getMasterUserName(userMasterName);
                            //  Toast.makeText(MainActivity.this, ""+ savedMasterUserName, Toast.LENGTH_SHORT).show();
                            String savedMasterPassword = dataBaseHelper.getMasterUserPassword(userMasterPassword);
                            if (userMasterName.equals(savedMasterUserName) && userMasterPassword.equals(savedMasterPassword)) {
                                Toast.makeText(getActivity(), "Login Successfully as Master", Toast.LENGTH_SHORT).show();

                                FragmentManager fragmentManager = getFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                SignupFragment signupFragment = new SignupFragment();
                                fragmentTransaction.replace(R.id.main_container, signupFragment);
                                fragmentTransaction.commit();



                                dialog.dismiss();

                            } else {
                                Toast.makeText(getActivity(), "User Name / Password not correct", Toast.LENGTH_SHORT).show();
                                txtMasterName.setText("");
                                txtMasterPassword.setText("");
                                txtMasterName.requestFocus();
                            }
                        }
                    });
                    dialog.show();

                }
            }
        });


        return view;

        //   btnSignIn = (Button) getActivity().findViewById(R.id.buttonSignIn);

    }

}


//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String userName = txtUserName.getText().toString();
//                String userPassword = txtUserPassword.getText().toString();
//                String savedPassword = dataBaseHelper.getUserSearchEntry(userName);
//
//                if (userPassword.equals(savedPassword)) {
//
//                    Toast.makeText(getActivity(), "Congrats : Login Successfully", Toast.LENGTH_SHORT).show();

//                    FragmentManager fragmentManager = getFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                    LoginFragment loginFragment = new LoginFragment();
//                    fragmentTransaction.add(R.id.main_container, loginFragment);
//
//                    fragmentTransaction.commit();


//Intent mainIntent = new Intent(MainActivity.this, WelcomeActivity.class);
//startActivity(mainIntent);

