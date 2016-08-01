package in.app.myandroid.mygatepassmanagement.model;

/**
 * Created by mukund on 7/7/16.
 */
public class GatePass {

    private String id, app_id, ref_id, fast_name, last_name, fr_name, gender, date_of_birth, mr_status, pre_add, per_add, state, pincode, std_code,
            land_line, mobile, police_station, photo_path, pass_type, pass_category, pass_period, req_date, comp_name, veh_type, veh_name, lic_no,
            reg_no, owner_name, guard_status, mod_status, reject_rejon, accept_date, mod_sign, noc, owner_photo, city, id_proof_no, manager_sign,
            id_proof_type, admin_status, id_proof_path, auth_letter_path, rc_book_path, ins_book_path, safety_cert;


    public GatePass(String id, String app_id, String ref_id, String fast_name, String last_name,
                    String fr_name, String gender, String date_of_birth, String mr_status,
                    String pre_add, String per_add, String state, String pincode, String std_code,
                    String land_line, String mobile, String police_station, String photo_path,
                    String pass_type, String pass_category, String pass_period, String req_date,
                    String comp_name, String veh_type, String veh_name, String lic_no, String reg_no,
                    String owner_name, String id_proof_type, String id_proof_no,
                    String guard_status, String admin_status, String mod_status, String reject_rejon,
                    String accept_date, String mod_sign, String noc, String owner_photo, String city,
                    String id_proof_path, String manager_sign, String auth_letter_path, String rc_book_path,
                    String ins_book_path, String safety_cert) {
        this.id = id;
        this.app_id = app_id;
        this.ref_id = ref_id;
        this.fast_name = fast_name;
        this.last_name = last_name;
        this.fr_name = fr_name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.mr_status = mr_status;
        this.pre_add = pre_add;
        this.per_add = per_add;
        this.state = state;
        this.pincode = pincode;
        this.std_code = std_code;
        this.land_line = land_line;
        this.mobile = mobile;
        this.police_station = police_station;
        this.photo_path = photo_path;
        this.pass_type = pass_type;
        this.pass_category = pass_category;
        this.pass_period = pass_period;
        this.req_date = req_date;
        this.veh_type = veh_type;
        this.veh_name = veh_name;
        this.comp_name = comp_name;
        this.id_proof_type = id_proof_type;
        this.lic_no = lic_no;
        this.admin_status = admin_status;
        this.id_proof_path = id_proof_path;
        this.owner_name = owner_name;
        this.guard_status = guard_status;
        this.mod_status = mod_status;
        this.reject_rejon = reject_rejon;
        this.accept_date = accept_date;
        this.mod_sign = mod_sign;
        this.noc = noc;
        this.reg_no = reg_no;
        this.owner_photo = owner_photo;
        this.city = city;
        this.id_proof_no = id_proof_no;
        this.manager_sign = manager_sign;
        this.auth_letter_path = auth_letter_path;
        this.rc_book_path = rc_book_path;
        this.ins_book_path = ins_book_path;
        this.safety_cert = safety_cert;

    }

    public String getAccept_date() {
        return accept_date;
    }

    public String getAdmin_status() {
        return admin_status;
    }

    public String getApp_id() {
        return app_id;
    }

    public String getCity() {
        return city;
    }

    public String getComp_name() {
        return comp_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getFast_name() {
        return fast_name;
    }

    public String getFr_name() {
        return fr_name;
    }

    public String getGender() {
        return gender;
    }

    public String getGuard_status() {
        return guard_status;
    }

    public String getId() {
        return id;
    }

    public String getId_proof_no() {
        return id_proof_no;
    }

    public String getId_proof_path() {
        return id_proof_path;
    }

    public String getId_proof_type() {
        return id_proof_type;
    }

    public String getLand_line() {
        return land_line;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getLic_no() {
        return lic_no;
    }

    public String getManager_sign() {
        return manager_sign;
    }

    public String getMobile() {
        return mobile;
    }

    public String getMod_sign() {
        return mod_sign;
    }

    public String getMod_status() {
        return mod_status;
    }

    public String getMr_status() {
        return mr_status;
    }

    public String getNoc() {
        return noc;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public String getOwner_photo() {
        return owner_photo;
    }

    public String getPass_category() {
        return pass_category;
    }

    public String getPass_period() {
        return pass_period;
    }

    public String getPass_type() {
        return pass_type;
    }

    public String getPer_add() {
        return per_add;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public String getPincode() {
        return pincode;
    }

    public String getPolice_station() {
        return police_station;
    }

    public String getPre_add() {
        return pre_add;
    }

    public String getRef_id() {
        return ref_id;
    }

    public String getReg_no() {
        return reg_no;
    }

    public String getReject_rejon() {
        return reject_rejon;
    }

    public String getReq_date() {
        return req_date;
    }

    public String getState() {
        return state;
    }

    public String getStd_code() {
        return std_code;
    }

    public String getVeh_name() {
        return veh_name;
    }

    public String getVeh_type() {
        return veh_type;
    }
}
