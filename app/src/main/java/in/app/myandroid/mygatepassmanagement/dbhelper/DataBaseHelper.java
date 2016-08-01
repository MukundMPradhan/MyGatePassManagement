package in.app.myandroid.mygatepassmanagement.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import in.app.myandroid.mygatepassmanagement.model.Company;
import in.app.myandroid.mygatepassmanagement.model.GatePass;
import in.app.myandroid.mygatepassmanagement.model.LoginUser;

import static android.R.attr.data;

/**
 * Created by mukund on 27/6/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    // user data base

    private static final String DB_NAME = "GpMngtDb";
    private static final int DB_VERSION = 1;
    //TABLES
    private static final String TABLE_USERDETAILS = "user_details";
    private static final String TABLE_GATEPASS = "gatepass";
    private static final String TABLE_COMPANY_DETAILS = "company_details";
    //private static final String TABLE_PASSTYPE = "passtype";

    //Table Columns
    private static final String COL_ID = "id";
    private static final String COL_USERID = "user_id";
    private static final String COL_USERNAME = "user_name";
    private static final String COL_PASSWORD = "password";
    private static final String COL_ROLE = "role";
    private static final String COL_FASTNAME = "f_name";
    private static final String COL_LASTNAME = "l_name";
    private static final String COL_FRNAME = "fr_name";
    private static final String COL_GENDER = "gender";
    private static final String COL_DOB = "date_of_birth";
    private static final String COL_MOB_NO = "mob_no";
    private static final String COL_MRSTATUS = "mr_status";
    private static final String COL_PRESENT_ADD = "present_add";
    private static final String COL_PERMANENT_ADD = "permanent_add";
    private static final String COL_STATE = "state";
    private static final String COL_PINCODE = "pincode";
    private static final String COL_STD = "std_isd";
    private static final String COL_LAND_LINE = "land_line";
    private static final String COL_MOB = "mobile";
    private static final String COL_POLICE_STATION = "police";
    private static final String COL_PHOTO_PATH = "photo_path";
    private static final String COL_EMAIL = "email";
    private static final String COL_LOGIN_STATUS = "login_status";
    private static final String COL_USER_SIGN = "user_sign";
    private static final String COL_APP_ID = "applicant_id";
    private static final String COL_REF_ID = "ref_id";
    private static final String COL_PASS_TYPE = "pass_type";
    private static final String COL_PASS_CATEGORY = "pass_category";
    private static final String COL_PASS_PERIOD = "pass_period";
    private static final String COL_REQ_DATE = "requestdate";
    private static final String COL_COMP_NAME = "company_name";
    private static final String COL_VEHICLE_TYPE = "vehicle_type";
    private static final String COL_VEHICLE_NAME = "vehicle_name";
    private static final String COL_LIC_NO = "lc_no";
    private static final String COL_REG_NO = "reg_no";
    private static final String COL_OWNER_NAME = "owner_name";
    private static final String COL_ID_PROOF_TYPE = "id_proof_type";
    private static final String COL_ID_NO = "id_no";
    private static final String COL_GUARD_STATUS = "guard_status";
    private static final String COL_MASTER_STATUS = "admin_status";
    private static final String COL_MOD_STATUS = "moderator_status";
    private static final String COL_REJECT_REASON = "reject_reason";
    private static final String COL_ACCEPT_DATE = "accept_date";
    private static final String COL_MOD_SIGN = "mod_sign";
    private static final String COL_NOC = "noc";
    private static final String COL_OWNER_PHOTO = "owner_photo";
    private static final String COL_CITY = "city";
    private static final String COL_ID_PROOF_PATH = "id_proof_path";
    private static final String COL_MANAGER_SIGN = "manager_sig";

    private static final String COL_ADDRESS = "address";
    private static final String COL_CONTACT_PERSON = "contact_person";
    private static final String COL_CONTACT_NO = "contact_person_no";

    private static final String COL_AUTH_LETTER_PATH = "auth_letter_path";
    private static final String COL_RC_BOOK_PATH = "rc_book_path";
    private static final String COL_INS_BOOK_PATH = "insurance_path";
    private static final String COL_SAFETY_CERT = "safety_certificate";

    //

    private static final String create_UserDetails_Table = "CREATE TABLE " + TABLE_USERDETAILS +
            " (" + COL_ID + " INTEGER PRIMARY KEY," + " "
            + COL_USERID + " TEXT," + " "
            + COL_FASTNAME + " TEXT," + " "
            + COL_LASTNAME + " TEXT," + " "
            + COL_FRNAME + " TEXT," + " "
            + COL_GENDER + " TEXT," + " "
            + COL_DOB + " TEXT," + " "
            + COL_MOB_NO + " TEXT," + " "
            + COL_PHOTO_PATH + " TEXT," + " "
            + COL_EMAIL + " TEXT," + " "
            + COL_ROLE + " TEXT," + " "
            + COL_LOGIN_STATUS + " TEXT," + " "
            + COL_PASSWORD + " TEXT);";

    private static final String insertMaster = "INSERT INTO " + TABLE_USERDETAILS +
            "(" + COL_ID + ", " +
            COL_USERID + ", " +
            COL_FASTNAME + ", " +
            COL_LASTNAME + ", " +
            COL_FRNAME + ", " +
            COL_GENDER + ", " +
            COL_DOB + ", " +
            COL_MOB_NO + ", " +
            COL_PHOTO_PATH + ", " +
            COL_EMAIL + ", " +
            COL_ROLE + ", " +
            COL_LOGIN_STATUS + ", " +
            COL_PASSWORD + ") " +
            "VALUES(" + 1 + ", 'Master', NULL, NULL, NULL,'Male',NULL,'9099975177',NULL,'replyme.mmp@gmail.com', 'Master', NULL, 'master');";


    private static final String create_GatePassTable = "CREATE TABLE " + TABLE_GATEPASS +
            " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + " "
            + COL_APP_ID + " TEXT," + " "
            + COL_REF_ID + " TEXT," + " "
            + COL_FASTNAME + " TEXT," + " "
            + COL_LASTNAME + " TEXT," + " "
            + COL_FRNAME + " TEXT," + " "
            + COL_GENDER + " TEXT," + " "
            + COL_DOB + " TEXT," + " "
            + COL_MRSTATUS + " TEXT," + " "
            + COL_PRESENT_ADD + " TEXT," + " "
            + COL_PERMANENT_ADD + " TEXT," + " "
            + COL_STATE + " TEXT," + " "
            + COL_PINCODE + " TEXT," + " "
            + COL_STD + " TEXT," + " "
            + COL_LAND_LINE + " TEXT," + " "
            + COL_MOB_NO + " TEXT," + " "
            + COL_POLICE_STATION + " TEXT," + " "
            + COL_PHOTO_PATH + " TEXT," + " "
            + COL_PASS_TYPE + " TEXT," + " "
            + COL_PASS_CATEGORY + " TEXT," + " "
            + COL_PASS_PERIOD + " TEXT," + " "
            + COL_REQ_DATE + " TEXT," + " "
            + COL_COMP_NAME + " TEXT," + " "
            + COL_VEHICLE_TYPE + " TEXT," + " "
            + COL_VEHICLE_NAME + " TEXT," + " "
            + COL_LIC_NO + " TEXT," + " "
            + COL_REG_NO + " TEXT," + " "
            + COL_OWNER_NAME + " TEXT," + " "
            + COL_ID_PROOF_TYPE + " TEXT," + " "
            + COL_ID_NO + " TEXT," + " "
            + COL_AUTH_LETTER_PATH + " TEXT," + " "
            + COL_RC_BOOK_PATH + " TEXT," + " "
            + COL_INS_BOOK_PATH + " TEXT," + " "
            + COL_SAFETY_CERT + " TEXT," + " "
            + COL_GUARD_STATUS + " TEXT," + " "
            + COL_MASTER_STATUS + " TEXT," + " "
            + COL_MOD_STATUS + " TEXT," + " "
            + COL_REJECT_REASON + " TEXT," + " "
            + COL_ACCEPT_DATE + " TEXT," + " "
            + COL_MOD_SIGN + " TEXT," + " "
            + COL_NOC + " TEXT," + " "
            + COL_OWNER_PHOTO + " TEXT," + " "
            + COL_CITY + " TEXT," + " "
            + COL_ID_PROOF_PATH + " TEXT," + " "
            + COL_MANAGER_SIGN + " TEXT);";


    private static final String create_Company_Details_Table = "CREATE TABLE " + TABLE_COMPANY_DETAILS +
            " (" + COL_ID + " INTEGER PRIMARY KEY," + " "
            + COL_COMP_NAME + " TEXT ," + " "
            + COL_ADDRESS + " TEXT," + " "
            //     + COL_USERNAME + " TEXT," + " "
            + COL_CONTACT_PERSON + " TEXT," + " "
            + COL_CONTACT_NO + " TEXT );";


    SQLiteDatabase database;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(create_UserDetails_Table);
        db.execSQL(create_GatePassTable);
        db.execSQL(create_Company_Details_Table);
        // Insert data

        db.execSQL(insertMaster);

        Log.e("MMP", "Database created successfully");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS" + TABLE_USERDETAILS);
        database.execSQL("DROP TABLE IF EXISTS" + TABLE_GATEPASS);

    }

    public void insertUser(String id, String password, String role, String fastName, String lastName, String frName, String gender,
                           String dob, String mobNo, String photoPath, String email) {

        database = getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(COL_USERID, id);
        values.put(COL_PASSWORD, password);
        values.put(COL_ROLE, role);
        values.put(COL_FASTNAME, fastName);
        values.put(COL_LASTNAME, lastName);
        values.put(COL_FRNAME, frName);
        values.put(COL_GENDER, gender);
        values.put(COL_DOB, dob);
        values.put(COL_MOB_NO, mobNo);
        values.put(COL_PHOTO_PATH, photoPath);
        values.put(COL_EMAIL, email);


        try {
            database.insert(TABLE_USERDETAILS, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.close();
        }


    }


    public ArrayList<LoginUser> getAllUserStaffs() {
        database = getReadableDatabase();

        ArrayList<LoginUser> loginUsers = new ArrayList<>();

        String select_all = "Select * from " + TABLE_USERDETAILS;

        Cursor cursor = database.rawQuery(select_all, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String uName = cursor.getString(1);
                String uPassword = cursor.getString(9);

                LoginUser loginUser = new LoginUser(uName, uPassword);

                loginUsers.add(loginUser);

            } while (cursor.moveToNext());
        }
        database.close();

        return loginUsers;


    }

    public ArrayList<Company> getAllCompanyList() {

        ArrayList<Company> companyList = new ArrayList<>();

        database = getReadableDatabase();

        String sql = "SELECT * FROM " + TABLE_COMPANY_DETAILS + ";";

        Cursor cursor = database.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                String comp_name = cursor.getString(1);
                String comp_add = cursor.getString(2);
                String comp_cont_person = cursor.getString(3);
                String cont_mob = cursor.getString(4);

                Company company = new Company(comp_name, comp_add, comp_cont_person, cont_mob);

                companyList.add(company);

            } while (cursor.moveToNext());
        }

        database.close();
        return companyList;
    }

    public ArrayList<String> getCompanyList() {

        database = getReadableDatabase();

        ArrayList<String> arrayList = new ArrayList<>();


        String sql = "select " + COL_COMP_NAME + " from " + TABLE_COMPANY_DETAILS + ";";

        Cursor cursor = database.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                String compName = cursor.getString(0);
                arrayList.add(compName);
            } while (cursor.moveToNext());

        }

        return arrayList;
    }


    public String getUserSearchEntry(String userName) {

        database = getReadableDatabase();

        Cursor cursor = database.query(TABLE_USERDETAILS, null, COL_USERID + "=?",
                new String[]{userName}, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex(COL_PASSWORD));
        cursor.close();
        return password;
    }

    //   public String getMaxRefId() {
//        database = getReadableDatabase();
//
//        String sql = "SELECT MAX(ref_id) from gatepass where pass_type='Individual'";//"Select ISNULL(Max(" + COL_REF_ID + "),100000) " + TABLE_GATEPASS + " Where " + COL_PASS_TYPE + " = Individual";
//        Cursor cursor = database.rawQuery(sql, null);
//        // Cursor cursor = database.query(TABLE_GATEPASS, new String[]{"MAX(" + COL_REF_ID + ")"}, null, null, null, null, null);
//
//        // Cursor cursor = database.query(TABLE_GATEPASS, null, COL_USERID + "=?",
//        //       new String[]{userName}, null, null, null);
////        if (cursor == null) {
////            cursor.close();
////            return String.valueOf(100001);
////        }
//        int nextNo = 0;
//        if (cursor != null) {
//            cursor.moveToFirst();
//            String maxRefID = cursor.getString(0);
//            nextNo = Integer.parseInt(maxRefID) + 1;
//            cursor.close();
//
//        }
//        return String.valueOf(nextNo);
//    }

    public String getMasterUserName(String userID) {
        database = getReadableDatabase();

        Cursor cursor = database.query(TABLE_USERDETAILS, null, COL_USERID + "=? AND " + COL_ROLE + "='Master'",
                new String[]{userID}, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String un = cursor.getString(cursor.getColumnIndex(COL_USERID));
        cursor.close();
        return un;
    }

    public String getMasterUserPassword(String userName) {
        database = getReadableDatabase();

        Cursor cursor = database.query(TABLE_USERDETAILS, null, COL_PASSWORD + "=? AND " + COL_ROLE + "='Master'",
                new String[]{userName}, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String pw = cursor.getString(cursor.getColumnIndex(COL_PASSWORD));
        cursor.close();
        return pw;
    }

    public ArrayList<GatePass> getAllGatePasses() {
        database = getReadableDatabase();

        ArrayList<GatePass> allPasses = new ArrayList<>();

        String select_all = "Select * from " + TABLE_GATEPASS;

        Cursor cursor = database.rawQuery(select_all, null);

        if (cursor.moveToFirst()) {
            do {

                String id = cursor.getString(0);
                String app_id = cursor.getString(1);
                String ref_id = cursor.getString(2);
                //String userName = cursor.getString(3);
                String fastName = cursor.getString(3);
                String lastName = cursor.getString(4);
                String frName = cursor.getString(5);
                String gender = cursor.getString(6);
                String dob = cursor.getString(7);
                String mrStatus = cursor.getString(8);
                String preAdd = cursor.getString(9);
                String perAdd = cursor.getString(10);
                String state = cursor.getString(11);
                String pin = cursor.getString(12);
                String std = cursor.getString(13);
                String landLine = cursor.getString(14);
                String mobNo = cursor.getString(15);
                //String email = cursor.getString(17);
                String policeStation = cursor.getString(16);
                String photoPath = cursor.getString(17);
                String pass_type = cursor.getString(18);
                String pass_catg = cursor.getString(19);
                String pass_period = cursor.getString(20);
                String reqDate = cursor.getString(21);
                String comp_name = cursor.getString(22);
                String veh_Type = cursor.getString(23);
                String vehName = cursor.getString(24);
                String lic_No = cursor.getString(25);
                String reg_No = cursor.getString(26);
                String owner_name = cursor.getString(27);
                String id_proof_type = cursor.getString(28);
                String id_no = cursor.getString(29);
                String auth_letter_path = cursor.getString(30);
                String rc_book_path = cursor.getString(31);
                String ins_book_path = cursor.getString(32);
                String safety_cert = cursor.getString(33);
                String guard_status = cursor.getString(34);
                String admin_stat = cursor.getString(35);
                String mod_status = cursor.getString(36);
                String rej_rejon = cursor.getString(37);
                String accept_date = cursor.getString(38);
                String mod_sign = cursor.getString(39);
                String noc = cursor.getString(40);
                String owner_photo = cursor.getString(41);
                String city = cursor.getString(42);
                String id_proof_path = cursor.getString(43);
                String manager_sign = cursor.getString(44);

                GatePass gatePass = new GatePass(id, app_id, ref_id, fastName, lastName,
                        frName, gender, dob, mrStatus, preAdd, perAdd, state, pin, std,
                        landLine, mobNo, policeStation, photoPath, pass_type, pass_catg,
                        pass_period, reqDate, comp_name, veh_Type, vehName, lic_No, reg_No,
                        owner_name, id_proof_type, id_no, guard_status, admin_stat, mod_status,
                        rej_rejon, accept_date, mod_sign, noc, owner_photo, city, id_proof_path,
                        manager_sign, auth_letter_path, rc_book_path, ins_book_path, safety_cert);

                allPasses.add(gatePass);

            } while (cursor.moveToNext());
        }

        cursor.close();
        return allPasses;
    }


    public void insertNewIndPass
            (String app_id, String ref_id, String pass_type, String pass_catg, String pass_period, String reqDate, String comp_name, String id_proof_type, String id_proof_path, String id_no, String fastName, String lastName,
             String frName, String gender, String dob, String mrStatus, String preAdd,
             String perAdd, String city, String state, String pin, String std, String landLine, String mobNo,
             String policeStation, String photoPath) {

//                    , String veh_Type,String vehName, String lic_No, String reg_No, String owner_name,
//              String guard_status, String admin_stat, String mod_status, String rej_rejon,
//             String accept_date, String mod_sign, String owner_photo, String noc) {
//
        database = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        // contentValues.put(COL_ID, id);
        contentValues.put(COL_APP_ID, app_id);
        contentValues.put(COL_REF_ID, ref_id);
        contentValues.put(COL_PASS_TYPE, pass_type);
        contentValues.put(COL_PASS_CATEGORY, pass_catg);
        contentValues.put(COL_PASS_PERIOD, pass_period);
        contentValues.put(COL_REQ_DATE, reqDate);
        contentValues.put(COL_COMP_NAME, comp_name);
        contentValues.put(COL_ID_PROOF_TYPE, id_proof_type);
        contentValues.put(COL_ID_PROOF_PATH, id_proof_path);
        contentValues.put(COL_ID_NO, id_no);

        // Individual Information
        contentValues.put(COL_FASTNAME, fastName);
        contentValues.put(COL_LASTNAME, lastName);
        contentValues.put(COL_FRNAME, frName);
        contentValues.put(COL_GENDER, gender);
        contentValues.put(COL_DOB, dob);
        contentValues.put(COL_MRSTATUS, mrStatus);
        contentValues.put(COL_PRESENT_ADD, preAdd);
        contentValues.put(COL_PERMANENT_ADD, perAdd);
        contentValues.put(COL_STATE, state);
        contentValues.put(COL_PINCODE, pin);
        contentValues.put(COL_STD, std);
        contentValues.put(COL_LAND_LINE, landLine);
        contentValues.put(COL_MOB_NO, mobNo);
        contentValues.put(COL_POLICE_STATION, policeStation);
        contentValues.put(COL_PHOTO_PATH, photoPath);

        try {
            database.insert(TABLE_GATEPASS, null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.close();
        }

    }


    //  public Integer NextIndGPNo() {
//        database = getReadableDatabase();
//        //Cursor cursor = database.query("Select Max(ref_id) from" + TABLE_GATEPASS + " where " + COL_PASS_TYPE + "= Individual", null, null, null, null, null, null);
//        String sql = "Select Max(" + COL_REF_ID + ") from " + TABLE_GATEPASS + " where " + COL_PASS_TYPE + "=Individual";
//        Cursor cursor = database.rawQuery(sql, null);//, null, null, null, null, null, null);
//        // Select max(ref_id) from Gatepass where pass_type="Individual";
//        int maxId;
//        Log.e("MMP", sql);
//
//        if (cursor.getCount() < 1) {
//            cursor.close();
//            return 100000;
//
//        }
//        cursor.moveToFirst();
//        String ref_id = cursor.getString(cursor.getColumnIndex(COL_REF_ID));
//        if (ref_id.equals("")) {
//            return 0;
//
//        } else {
//            maxId = Integer.parseInt(ref_id) + 1;
//        }
//        cursor.close();
//        return maxId;

    // }
    public String getMaxAppID_IndPass() {
        database = getReadableDatabase();
        Cursor cursor = database.query(TABLE_GATEPASS, new String[]{"MAX(" + COL_APP_ID + ") AS MAX"}, null, null, null, null, null);
        cursor.moveToFirst();
        int index = cursor.getColumnIndex("MAX");
        int appID = Integer.parseInt(cursor.getString(index)) + 1;
        database.close();

        return String.valueOf(appID);
    }

    public String getMaxRefID_IndPass() {
        database = getReadableDatabase();
        Cursor cursor = database.query(TABLE_GATEPASS, new String[]{"MAX(" + COL_REF_ID + ") AS MAX"}, null, null, null, null, null);
        if (cursor.getCount() < 1) {
            return String.valueOf(100000);
        } else {
            cursor.moveToFirst();
            int index = cursor.getColumnIndex("MAX");
            int refID = Integer.parseInt(cursor.getString(index)) + 1;
            database.close();

            return String.valueOf(refID);
        }
    }

    public void insertNewVehPass
            (String app_id, String ref_id, String pass_type,
             String pass_period, String req_date, String comp_name, String vehicle_type,
             String vehicle_make, String lic_no, String reg_no, String owner_name,
             String owner_photo, String auth_letter_path, String rc_book_path,
             String insBookPath, String safety_cert, String fast_name, String last_name,
             String fr_name, String date_of_birth, String gender, String mrStatus,
             String pre_add, String per_add, String city, String state, String pincode,
             String std_code, String land_line, String mob, String police, String photo_path) {

        database = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        // Pass Information

        contentValues.put(COL_APP_ID, app_id);
        contentValues.put(COL_REF_ID, ref_id);
        contentValues.put(COL_PASS_TYPE, pass_type);
        contentValues.put(COL_PASS_PERIOD, pass_period);
        contentValues.put(COL_REQ_DATE, req_date);
        contentValues.put(COL_COMP_NAME, comp_name);


        // Proof Information
        contentValues.put(COL_VEHICLE_TYPE, vehicle_type);
        contentValues.put(COL_VEHICLE_NAME, vehicle_make);
        contentValues.put(COL_LIC_NO, lic_no);
        contentValues.put(COL_REG_NO, reg_no);
        contentValues.put(COL_OWNER_NAME, owner_name);
        contentValues.put(COL_OWNER_PHOTO, owner_photo);
        contentValues.put(COL_AUTH_LETTER_PATH, auth_letter_path);
        contentValues.put(COL_RC_BOOK_PATH, rc_book_path);
        contentValues.put(COL_INS_BOOK_PATH, insBookPath);
        contentValues.put(COL_SAFETY_CERT, safety_cert);


        //Individual Information
        contentValues.put(COL_FASTNAME, fast_name);
        contentValues.put(COL_LASTNAME, last_name);
        contentValues.put(COL_FRNAME, fr_name);
        contentValues.put(COL_GENDER, gender);
        contentValues.put(COL_MRSTATUS, mrStatus);
        contentValues.put(COL_PRESENT_ADD, pre_add);
        contentValues.put(COL_PERMANENT_ADD, per_add);
        contentValues.put(COL_CITY, city);
        contentValues.put(COL_STATE, state);
        contentValues.put(COL_PINCODE, pincode);
        contentValues.put(COL_STD, std_code);
        contentValues.put(COL_LAND_LINE, land_line);
        contentValues.put(COL_MOB_NO, mob);
        contentValues.put(COL_POLICE_STATION, police);
        contentValues.put(COL_PHOTO_PATH, photo_path);

        try {
            database.insert(TABLE_GATEPASS, null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.close();
        }

    }

    public void insertCompany(String compName, String compAdd, String contactPerson, String contactNo) {

        database = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_COMP_NAME, compName);
        values.put(COL_ADDRESS, compAdd);
        values.put(COL_CONTACT_PERSON, contactPerson);
        values.put(COL_CONTACT_NO, contactNo);

        try {
            database.insert(TABLE_COMPANY_DETAILS, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.close();
        }


    }


//    public String getMaxAppID_IndPass() {
//
//        database = getReadableDatabase();
//        String sql = "SELECT IFNULL(MAX(" + COL_APP_ID + "),0) AS maxAppId FROM " + TABLE_GATEPASS + ";";
//        Cursor cursor = database.rawQuery(sql, null);
//
//
//       // int maxAppID = cursor.getInt(1);
//
//        String max=cursor.getColumnName(Integer.parseInt(getMaxAppID_IndPass()));
//
//        return String.valueOf(max + 1);
//
//    }
}



