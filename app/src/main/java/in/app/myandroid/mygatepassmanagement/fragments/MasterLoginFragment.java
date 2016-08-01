package in.app.myandroid.mygatepassmanagement.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.app.myandroid.mygatepassmanagement.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MasterLoginFragment extends Fragment {


    public MasterLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_master_login, container, false);


        return view;

    }

}
