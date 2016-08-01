package in.app.myandroid.mygatepassmanagement.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import in.app.myandroid.mygatepassmanagement.AllFunctions;
import in.app.myandroid.mygatepassmanagement.R;
import in.app.myandroid.mygatepassmanagement.dbhelper.DataBaseHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddNewVehiclePassFragment extends Fragment {
    private EditText txtRefNo, txtPreAdd, txtPerAdd, txtCity, txtPinCode, txtLLCode, txtLLNo, txtMobile,
            txtPolicestation, txtFastName, txtLastName, txtFrName, txtIDProofNo, txtLicNo, txtRegNo, txtOwnersName, txtOwnerPhoto,
            txtAuthLetter, txtRCBook, txtInsurance, txtSafety;
    private TextView txtRequestDate, txtIDProofPath, txtPhotoPath, txtDOB;
    private RadioGroup radioGroupPassType, radioGroupGender, radioGroupMStatus;
    private RadioButton radBtnIndividual, radBtnVehicle, radBtnMale, radBtnFemale, radBtnSingle, radBtnMarried, radBtnLight, radBtnHeavy;
    private ImageView imgIDProofCam, imgPhotoCam, imgAddCompany;
    private CheckBox chkBoxSameAdd;
    private Spinner spinnerPassCategory, spinnerPassPeriod, spinnerCompany, spinnerIDProof, spinnerDate,
            spinnerMonth, spinnerYear, spinnerState, spinnerVehicleMake;
    private Button btnSubmit, btnCancel;
    private ImageView btnCompanyAdd;

    // Declaring Adapters
    private ArrayAdapter arrayAdapterPassCategory, arrayAdapterPassPeriod, arrayAdapterIdProofList, arrayAdapterState;
    private ArrayAdapter<String> arrayAdapterDate, arrayAdapterMonth, arrayAdapterYear, arrayAdapterCompanyNames;
    //
    ArrayList<String> dateStr, monthStr, yearStr, companyList;

    AllFunctions allFunctions;
    DataBaseHelper dataBaseHelper;

    Calendar myCalendar = Calendar.getInstance();
    String calType = null;


    public AddNewVehiclePassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_new_vehicle_pass, container, false);

        txtRefNo = (EditText) view.findViewById(R.id.etVehPassRefNo);
        radBtnIndividual = (RadioButton) view.findViewById(R.id.radButtonVehPassIndividual);
        radBtnVehicle = (RadioButton) view.findViewById(R.id.radButtonVehPassVehicle);
        // spinnerPassCategory=(Spinner) view.findViewById(R.id.passcate)
        spinnerPassPeriod = (Spinner) view.findViewById(R.id.spinnerVehPassPassPeriod);
        txtRequestDate = (TextView) view.findViewById(R.id.tvVehPassRequestDate);
        spinnerCompany = (Spinner) view.findViewById(R.id.spinnerVehPassCompany);
        btnCompanyAdd = (ImageView) view.findViewById(R.id.buttonVehPassAddCompany);
        radBtnLight = (RadioButton) view.findViewById(R.id.radButtonVehPassLight);
        radBtnHeavy = (RadioButton) view.findViewById(R.id.radioButtonVehPassHeavy);
        spinnerVehicleMake = (Spinner) view.findViewById(R.id.spinnerVehPassVehicleMake);
        txtLicNo = (EditText) view.findViewById(R.id.etVehPassLicNo);
        txtRegNo = (EditText) view.findViewById(R.id.etVehPassRegNo);
        txtOwnersName = (EditText) view.findViewById(R.id.etVehPassOwnerName);
        txtOwnerPhoto = (EditText) view.findViewById(R.id.etVehPassOwnerPhoto);
        txtAuthLetter = (EditText) view.findViewById(R.id.etVehPassCHAAuthLetter);
        txtRCBook = (EditText) view.findViewById(R.id.etVehPassRCBook);
        txtInsurance = (EditText) view.findViewById(R.id.etVehPassInsurance);
        txtSafety = (EditText) view.findViewById(R.id.etVehPassSafetyCert);
        txtFastName = (EditText) view.findViewById(R.id.etVehPassFastName);
        txtLastName = (EditText) view.findViewById(R.id.etVehPassLastName);
        txtFrName = (EditText) view.findViewById(R.id.etVehPassFrName);
        radBtnMale = (RadioButton) view.findViewById(R.id.radioButtonVehPassMale);
        radBtnFemale = (RadioButton) view.findViewById(R.id.radioButtonVehPassFemale);
        txtDOB = (TextView) view.findViewById(R.id.etVehPassDOB);
        radBtnSingle = (RadioButton) view.findViewById(R.id.radioButtonVehPassSignle);
        radBtnMarried = (RadioButton) view.findViewById(R.id.radioButtonVehPassMarried);
        txtPreAdd = (EditText) view.findViewById(R.id.etVehPassPreAdd);
        txtPerAdd = (EditText) view.findViewById(R.id.etVehPassPerAdd);
        chkBoxSameAdd = (CheckBox) view.findViewById(R.id.checkboxVehPassSameAdd);
        txtCity = (EditText) view.findViewById(R.id.etVehPassCity);
        spinnerState = (Spinner) view.findViewById(R.id.spinnerVehPassState);
        txtPinCode = (EditText) view.findViewById(R.id.etVehPassPinCode);
        txtLLCode = (EditText) view.findViewById(R.id.etVehPassLandLineCode);
        txtLLNo = (EditText) view.findViewById(R.id.etVehPassLandLineNo);
        txtMobile = (EditText) view.findViewById(R.id.etVehPassMobile);
        txtPolicestation = (EditText) view.findViewById(R.id.etVehPassPoliceStation);
        txtPhotoPath = (TextView) view.findViewById(R.id.tvVehPassPhotoPath);
        btnSubmit = (Button) view.findViewById(R.id.buttonVehPassSubmit);
        btnCancel = (Button) view.findViewById(R.id.buttonVehPassCancel);


        //Class Initialisations
        allFunctions = new AllFunctions(getActivity());
        dataBaseHelper = new DataBaseHelper(getActivity());

        //Initilisation
//        dateStr = new ArrayList<>();
//        monthStr = new ArrayList<>();
//        yearStr = new ArrayList<>();
        companyList = new ArrayList<>();

        txtRequestDate.setText(allFunctions.getCurrentDate());

        // Loading array datas to values
        dateStr = allFunctions.LoadingDates();
        monthStr = allFunctions.LoadingMonths();
        yearStr = allFunctions.LoadingYears();
        companyList = dataBaseHelper.getCompanyList();


        // Adapters
        // arrayAdapterPassCategory = ArrayAdapter.createFromResource(getApplicationContext(), R.array.PassCategory, R.layout.layout_text_view);
        arrayAdapterPassPeriod = ArrayAdapter.createFromResource(getActivity(), R.array.PassPeriod, R.layout.layout_text_view);
        arrayAdapterState = ArrayAdapter.createFromResource(getContext(), R.array.StateNameList, R.layout.layout_text_view);

        arrayAdapterDate = new ArrayAdapter<String>(getActivity(), R.layout.layout_text_view, R.id.text1, dateStr);
        arrayAdapterMonth = new ArrayAdapter<String>(getActivity(), R.layout.layout_text_view, R.id.text1, monthStr);
        arrayAdapterYear = new ArrayAdapter<String>(getActivity(), R.layout.layout_text_view, R.id.text1, yearStr);
        arrayAdapterCompanyNames = new ArrayAdapter<String>(getActivity(), R.layout.layout_text_view, R.id.text1, companyList);

        // Set Adapters
        //  spinnerPassCategory.setAdapter(arrayAdapterPassCategory);
        spinnerPassPeriod.setAdapter(arrayAdapterPassPeriod);
        spinnerState.setAdapter(arrayAdapterState);
        spinnerCompany.setAdapter(arrayAdapterCompanyNames);


        radBtnIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                AddNewIndividualPassFragment individualPass = new AddNewIndividualPassFragment();
                fragmentTransaction.replace(R.id.main_container, individualPass);

                fragmentTransaction.commit();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String selectedPassType = null, selectedGender = null, selectedMaritalStatus = null, selectedVehicleType = null;

                if (radBtnIndividual.isChecked()) {
                    selectedPassType = "Individual";
                } else if (radBtnVehicle.isChecked()) {
                    selectedPassType = "Vehicle";
                }

                if (radBtnSingle.isChecked()) {
                    selectedMaritalStatus = "Single";
                } else if (radBtnMarried.isChecked()) {
                    selectedMaritalStatus = "Married";
                }

                if (radBtnMale.isChecked()) {
                    selectedGender = "Male";
                } else if (radBtnFemale.isChecked()) {
                    selectedGender = "Female";
                }

                if (radBtnLight.isChecked()) {
                    selectedVehicleType = "light";
                } else if (radBtnHeavy.isChecked()) {
                    selectedVehicleType = "Heavy";
                }
                dataBaseHelper.insertNewVehPass("1", txtRefNo.getText().toString(), selectedPassType,
                        spinnerPassPeriod.getSelectedItem().toString(), txtRequestDate.getText().toString(),
                        spinnerCompany.getSelectedItem().toString(), selectedVehicleType, "Vehicle Make"//spinnerVehicleMake.getSelectedItem().toString(),
                        , txtLicNo.getText().toString(), txtRegNo.getText().toString(), txtOwnersName.getText().toString(),
                        txtOwnerPhoto.getText().toString(), txtAuthLetter.getText().toString(), txtRCBook.getText().toString(),
                        txtInsurance.getText().toString(), txtSafety.getText().toString(), txtFastName.getText().toString(),
                        txtLastName.getText().toString(), txtFrName.getText().toString(), txtDOB.getText().toString(),
                        selectedGender, selectedMaritalStatus, txtPreAdd.getText().toString(), txtPerAdd.getText().toString(),
                        txtCity.getText().toString(), spinnerState.getSelectedItem().toString(), txtPinCode.getText().toString(),
                        txtLLCode.getText().toString(), txtLLNo.getText().toString(), txtMobile.getText().toString(),
                        txtPolicestation.getText().toString(), txtPhotoPath.getText().toString());


                Toast.makeText(getActivity(), "Data has been saved sucessfully", Toast.LENGTH_SHORT).show();

                ;
            }
        });

        txtDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calType = "DOB";
                new DatePickerDialog(getActivity(), date, myCalendar.get(Calendar.YEAR) - 18, myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        txtRequestDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calType = "ReqDt";
                new DatePickerDialog(getActivity(), date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        return view;
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            dateFormat();
        }
    };

    private void dateFormat() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(myFormat, Locale.US);
        if (calType.equals("ReqDt")) {
            txtRequestDate.setText(simpleDateFormat.format(myCalendar.getTime()));
        } else if (calType.equals("DOB"))
            txtDOB.setText(simpleDateFormat.format(myCalendar.getTime()));

    }

}
