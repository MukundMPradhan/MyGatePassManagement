package in.app.myandroid.mygatepassmanagement.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
public class AddNewIndividualPassFragment extends Fragment {
    // Declarations
    private EditText txtRefNo, txtPreAdd, txtPerAdd, txtCity, txtPinCode, txtLLCode, txtLLNo, txtMobile,
            txtPolicestation, txtFastName, txtLastName, txtFrName, txtIDProofNo;
    private TextView txtRequestDate, txtIDProofPath, txtDOB;
    private RadioGroup radioGroupPassType, radioGroupGender, radioGroupMStatus;
    private RadioButton radBtnIndividual, radBtnVehicle, radBtnMale, radBtnFemale, radBtnSingle, radBtnMarried;
    private ImageView imgIDProofCam, imgPhotoCam, imgAddCompany;

    private CheckBox chkBoxSameAdd;
    private Spinner spinnerPassCategory, spinnerPassPeriod, spinnerCompany, spinnerIDProof, spinnerState;
    private Button btnSubmit, btnCancel;

    private String calType;

    // Declaring Adapters
    ArrayAdapter arrayAdapterPassCategory, arrayAdapterPassPeriod, arrayAdapterIdProofList, arrayAdapterStateList;
    ArrayAdapter<String> arrayAdapterDate, arrayAdapterMonth, arrayAdapterYear, arrayAdapterCompanyNames;
    //
    ArrayList<String> dateStr, monthStr, yearStr, companyList;
    //ArrayList<Company> companyList;


    AllFunctions allFunctions;
    DataBaseHelper dataBaseHelper;

    Calendar myCalendar = Calendar.getInstance();


    public AddNewIndividualPassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_new_individual_pass, container, false);


        //Initialisation of views
        txtRefNo = (EditText) view.findViewById(R.id.etVehPassRefNo);
        txtIDProofPath = (TextView) view.findViewById(R.id.etIndPassIDProofPath);
        txtPreAdd = (EditText) view.findViewById(R.id.etIndPassPreAdd);
        txtPerAdd = (EditText) view.findViewById(R.id.etIndPassPerAdd);
        txtCity = (EditText) view.findViewById(R.id.etIndPassCity);
        txtPinCode = (EditText) view.findViewById(R.id.etIndPassPinCode);
        txtLLCode = (EditText) view.findViewById(R.id.etIndPassLandLineCode);
        txtLLNo = (EditText) view.findViewById(R.id.etIndPassLandLineNo);
        txtMobile = (EditText) view.findViewById(R.id.etIndPassMobile);
        txtPolicestation = (EditText) view.findViewById(R.id.etIndPassPoliceStation);
        txtFastName = (EditText) view.findViewById(R.id.etIndPassFastName);
        txtLastName = (EditText) view.findViewById(R.id.etIndPassLastName);
        txtFrName = (EditText) view.findViewById(R.id.etIndPassFrName);
        txtIDProofNo = (EditText) view.findViewById(R.id.etIndPassIDProofNo);
        txtRequestDate = (TextView) view.findViewById(R.id.tvIndPassRequestDate);
        radBtnFemale = (RadioButton) view.findViewById(R.id.radioButtonIndPassFemale);
        radBtnIndividual = (RadioButton) view.findViewById(R.id.radButtonIndPassIndividual);
        radBtnMale = (RadioButton) view.findViewById(R.id.radioButtonIndPassMale);
        radBtnMarried = (RadioButton) view.findViewById(R.id.radioButtonIndPassMarried);
        radBtnSingle = (RadioButton) view.findViewById(R.id.radioButtonIndPassSignle);
        radBtnVehicle = (RadioButton) view.findViewById(R.id.radButtonIndPassVehicle);
        chkBoxSameAdd = (CheckBox) view.findViewById(R.id.checkboxIndPassSameAdd);
        spinnerCompany = (Spinner) view.findViewById(R.id.spinnerIndPassCompany);
        txtDOB = (TextView) view.findViewById(R.id.etVehPassDOB);
        // spinnerDate = (Spinner) view.findViewById(R.id.spinnerIndPassDate);
        spinnerIDProof = (Spinner) view.findViewById(R.id.spinnerIndPassIDProof);
        //spinnerMonth = (Spinner) view.findViewById(R.id.spinnerIndPassMonth);
        spinnerPassCategory = (Spinner) view.findViewById(R.id.spinnerIndPassPassCategory);
        spinnerState = (Spinner) view.findViewById(R.id.spinnerIndPassState);
        spinnerPassPeriod = (Spinner) view.findViewById(R.id.spinnerVehPassPassPeriod);
        // spinnerYear = (Spinner) view.findViewById(R.id.spinnerIndPassYear);
        //txtIdProofPath = (TextView) findViewById(R.id.tvNPPhotoPath)
        btnSubmit = (Button) view.findViewById(R.id.buttonIndPassSubmit);
        btnCancel = (Button) view.findViewById(R.id.buttonIndPassCancel);
        imgAddCompany = (ImageView) view.findViewById(R.id.imgbuttonIndPassAddComp);


        //Class Initialisations
        allFunctions = new AllFunctions(getActivity());
        dataBaseHelper = new DataBaseHelper(getActivity());

        //Initilisation
        dateStr = new ArrayList<>();
        monthStr = new ArrayList<>();
        yearStr = new ArrayList<>();
        companyList = new ArrayList<>();

        txtRequestDate.setText(allFunctions.getCurrentDate());
        // txtRefNo.setText(dataBaseHelper.NextIndGPNo());

        // Loading array datas to values
        dateStr = allFunctions.LoadingDates();
        monthStr = allFunctions.LoadingMonths();
        yearStr = allFunctions.LoadingYears();
        companyList = dataBaseHelper.getCompanyList();

        // Adapters
        arrayAdapterPassCategory = ArrayAdapter.createFromResource(getActivity(), R.array.PassCategory, R.layout.layout_text_view);
        arrayAdapterPassPeriod = ArrayAdapter.createFromResource(getActivity(), R.array.PassPeriod, R.layout.layout_text_view);
        arrayAdapterIdProofList = ArrayAdapter.createFromResource(getActivity(), R.array.IdProofType, R.layout.layout_text_view);
        arrayAdapterStateList = ArrayAdapter.createFromResource(getActivity(), R.array.StateNameList, R.layout.layout_text_view);

        arrayAdapterDate = new ArrayAdapter<String>(getActivity(), R.layout.layout_text_view, R.id.text1, dateStr);
        arrayAdapterMonth = new ArrayAdapter<String>(getActivity(), R.layout.layout_text_view, R.id.text1, monthStr);
        arrayAdapterYear = new ArrayAdapter<String>(getActivity(), R.layout.layout_text_view, R.id.text1, yearStr);
        arrayAdapterCompanyNames = new ArrayAdapter<String>(getActivity(), R.layout.layout_text_view, R.id.text1, companyList);


        final String nxtAppID = dataBaseHelper.getMaxAppID_IndPass();
        final  String nxtRefID=dataBaseHelper.getMaxRefID_IndPass();
        txtRefNo.setText(nxtRefID);


        // Clickable Codes


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedPass_Type = null, selectedGender = null, selectedMaritalStatus = null;

                if (radBtnIndividual.isChecked()) {
                    selectedPass_Type = "Individual";
                } else if (radBtnVehicle.isChecked()) {
                    selectedPass_Type = "Vehicle";
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


                dataBaseHelper.insertNewIndPass(nxtAppID, txtRefNo.getText().toString(), selectedPass_Type,
                        spinnerPassCategory.getSelectedItem().toString(), spinnerPassPeriod.getSelectedItem().toString(),
                        txtRequestDate.getText().toString(), spinnerCompany.getSelectedItem().toString(),
                        spinnerIDProof.getSelectedItem().toString(), txtIDProofPath.toString(), txtIDProofNo.getText().toString(),
                        txtFastName.getText().toString(), txtLastName.getText().toString(), txtFrName.getText().toString(),
                        selectedGender, txtDOB.getText().toString(), selectedMaritalStatus, txtPreAdd.getText().toString(),
                        txtPerAdd.getText().toString(), txtCity.getText().toString(), spinnerState.getSelectedItem().toString(),
                        txtPinCode.getText().toString(), txtLLCode.getText().toString(), txtLLNo.getText().toString(),
                        txtMobile.getText().toString(), txtPolicestation.getText().toString(), txtIDProofPath.getText().toString());


//                dataBaseHelper.insertNewIndPass("1", txtRefNo.getText().toString().trim(), selectedPass_Type, spinnerPassCategory.getSelectedItem().toString(),
//                        spinnerPassPeriod.getSelectedItem().toString(), txtRequestDate.getText().toString(), "Testing", spinnerIDProof.getSelectedItem().toString()
//                        , txtIDProofPath.getText().toString().trim(), txtIDProofNo.getText().toString(), txtFastName.getText().toString().trim(), txtLastName.getText().toString().trim()
//                        , txtFrName.getText().toString().trim(), selectedGender, selectedMaritalStatus, txtPreAdd.getText().toString().trim(), txtPerAdd.getText().toString().trim()
//                        , txtCity.getText().toString().trim(), "Not listed", txtPinCode.getText().toString(), txtLLCode.getText().toString(), txtLLNo.getText().toString()
//                        , txtMobile.getText().toString(), txtPolicestation.getText().toString(), txtIDProofPath.getText().toString());
                Toast.makeText(getActivity(), "DataBase Saved Successfully", Toast.LENGTH_SHORT).show();

                ClearForm();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Cleared", Toast.LENGTH_SHORT).show();
            }
        });
        radBtnIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

        radBtnVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                AddNewVehiclePassFragment vehiclePass = new AddNewVehiclePassFragment();
                fragmentTransaction.replace(R.id.main_container, vehiclePass);
                fragmentTransaction.commit();
            }
        });

        imgAddCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, new CompanyListDisplayFragment());
                fragmentTransaction.commit();
            }
        });

        txtPreAdd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (chkBoxSameAdd.isChecked()) {
                    txtPerAdd.setText(txtPreAdd.getText());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        chkBoxSameAdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    txtPerAdd.setText("");
                    //txtPerAdd.requestFocus();
                } else if (isChecked) {
                    txtPerAdd.setText(txtPreAdd.getText());
                }
            }
        });


        // Set Adapters
        spinnerPassCategory.setAdapter(arrayAdapterPassCategory);
        spinnerPassPeriod.setAdapter(arrayAdapterPassPeriod);
        spinnerIDProof.setAdapter(arrayAdapterIdProofList);
        spinnerState.setAdapter(arrayAdapterStateList);

//        spinnerDate.setAdapter(arrayAdapterDate);
//        spinnerMonth.setAdapter(arrayAdapterMonth);
//        spinnerYear.setAdapter(arrayAdapterYear);

        spinnerCompany.setAdapter(arrayAdapterCompanyNames);

        return view;
    }

    private void ClearForm() {
        txtRefNo.setText("");
        spinnerPassCategory.setSelection(0);
        spinnerPassPeriod.setSelection(0);
        spinnerCompany.setSelection(0);
        spinnerIDProof.setSelection(0);
        txtIDProofNo.setText("");
        txtFastName.setText("");
        txtLastName.setText("");
        chkBoxSameAdd.setChecked(false);
        txtFrName.setText("");
        txtDOB.setText("");
        txtPerAdd.setText("");
        txtPreAdd.setText("");
        txtCity.setText("");
        spinnerState.setSelection(0);
        txtPinCode.setText("");
        txtLLCode.setText("");
        txtLLNo.setText("");
        txtMobile.setText("");
        txtPolicestation.setText("");
        txtIDProofPath.setText("");

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
