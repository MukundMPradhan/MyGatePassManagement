package in.app.myandroid.mygatepassmanagement.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import in.app.myandroid.mygatepassmanagement.R;
import in.app.myandroid.mygatepassmanagement.adapter.RVAdapter_AllPasses;
import in.app.myandroid.mygatepassmanagement.dbhelper.DataBaseHelper;
import in.app.myandroid.mygatepassmanagement.model.GatePass;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllPassesListFragment extends Fragment {
    RVAdapter_AllPasses RVAdapterAllPasses;

    RecyclerView recyclerViewAllPassList;
    DataBaseHelper dataBaseHelper;
    ArrayList<GatePass> arrayListPasses;


    public AllPassesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_passes_list, container, false);
        dataBaseHelper = new DataBaseHelper(getContext());

        arrayListPasses = dataBaseHelper.getAllGatePasses();
        RVAdapterAllPasses = new RVAdapter_AllPasses(arrayListPasses, getContext());
        recyclerViewAllPassList = (RecyclerView) view.findViewById(R.id.RecycleView_AllPass);
        recyclerViewAllPassList.setAdapter(RVAdapterAllPasses);
        Toast.makeText(getActivity(), "size : " + arrayListPasses.size(), Toast.LENGTH_SHORT).show();

        return view;
    }

}
