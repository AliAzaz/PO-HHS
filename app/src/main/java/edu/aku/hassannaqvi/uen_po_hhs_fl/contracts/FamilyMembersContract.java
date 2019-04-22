package edu.aku.hassannaqvi.uen_po_hhs_fl.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FamilyMembersContract {

    private final String projectName = "Pulse Oximetry";
    private String _ID = "";
    private String _UID = "";
    private String _UUID = "";
    private String _DATE = "";
    private String formDate = "";
    private String deviceId = "";
    private String user = "";
    private String name = "";
    private String ageLess5 = "";
    private String ageLess2 = "";
    private String dob = "";
    private String sB = "";
    private String synced = "";
    private String syncedDate = "";
    private String serialNo = "";
    private String devicetagID = "";


    public FamilyMembersContract() {
    }

    public FamilyMembersContract(String name, String age, String serialNo, String dob) {
        this.name = name;
        this.ageLess5 = age;
        this.serialNo = serialNo;
        this.dob = dob;
    }

    public FamilyMembersContract(FamilyMembersContract fm) {
        this.name = fm.name;
        this.ageLess5 = fm.ageLess5;
        this.ageLess2 = fm.ageLess2;
        this.serialNo = fm.serialNo;
        this.dob = fm.dob;
    }

    public String getProjectName() {
        return projectName;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String get_UID() {
        return _UID;
    }

    public void set_UID(String _UID) {
        this._UID = _UID;
    }

    public String get_UUID() {
        return _UUID;
    }

    public void set_UUID(String _UUID) {
        this._UUID = _UUID;
    }

    public String get_DATE() {
        return _DATE;
    }

    public void set_DATE(String _DATE) {
        this._DATE = _DATE;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgeLess5() {
        return ageLess5;
    }

    public void setAgeLess5(String ageLess5) {
        this.ageLess5 = ageLess5;
    }

    public String getAgeLess2() {
        return ageLess2;
    }

    public void setAgeLess2(String ageLess2) {
        this.ageLess2 = ageLess2;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    public String getsB() {
        return sB;
    }

    public void setsB(String sB) {
        this.sB = sB;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public FamilyMembersContract Sync(JSONObject jsonObject) throws JSONException {

        this._ID = jsonObject.getString(familyMembers.COLUMN_ID);
        this._UID = jsonObject.getString(familyMembers.COLUMN_UID);
        this._UUID = jsonObject.getString(familyMembers.COLUMN_UUID);
        this.formDate = jsonObject.getString(familyMembers.COLUMN_FORMDATE);
        this.deviceId = jsonObject.getString(familyMembers.COLUMN_DEVICEID);
        this.user = jsonObject.getString(familyMembers.COLUMN_USER);
        this.sB = jsonObject.getString(familyMembers.COLUMN_SB);
        this.serialNo = jsonObject.getString(familyMembers.COLUMN_SERIAL_NO);
        this.synced = jsonObject.getString(familyMembers.COLUMN_SYNCED);
        this.syncedDate = jsonObject.getString(familyMembers.COLUMN_SYNCED_DATE);
        this.devicetagID = jsonObject.getString(familyMembers.COLUMN_DEVICETAGID);

        return this;

    }

    public FamilyMembersContract Hydrate(Cursor cursor) {

        this._ID = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_UUID));
        this.formDate = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_USER));
        this.sB = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_SB));
        this.serialNo = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_SERIAL_NO));
        this.deviceId = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_DEVICETAGID));
        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(familyMembers.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(familyMembers.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(familyMembers.COLUMN_UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(familyMembers.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(familyMembers.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
        json.put(familyMembers.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        if (!this.sB.equals("")) {
            json.put(familyMembers.COLUMN_SB, this.sB.equals("") ? JSONObject.NULL : new JSONObject(this.sB));
        }
        json.put(familyMembers.COLUMN_SERIAL_NO, this.serialNo == null ? JSONObject.NULL : this.serialNo);
        json.put(familyMembers.COLUMN_PROJECT_NAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        json.put(familyMembers.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);

        return json;
    }

    public static abstract class familyMembers implements BaseColumns {

        public static final String TABLE_NAME = "familymembers";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";

        public static final String COLUMN_PROJECT_NAME = "project_name";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_UUID = "uuid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_SB = "sB";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "sync_date";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_SERIAL_NO = "serial";

        public static String _URL = "familymembers.php";
    }
}
