package edu.aku.hassannaqvi.uen_po_hhs_fl.contracts;


import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class BLRandomContract {

    private static final String TAG = "BLRandom_CONTRACT";

    private String _ID;
    private String LUID;
    private String LHWCode; // hh02
    private String villageCode;
    private String structure;  // Structure
    private String extension; // Extension
    private String hh;
    private String hhhead;
    private String hhcontact;
    private String randomDT;

    public BLRandomContract() {
    }

    public BLRandomContract(BLRandomContract rnd) {
        this._ID = rnd.get_ID();
        this.LUID = rnd.getLUID();
        this.LHWCode = rnd.getLHWCode();
        this.villageCode = rnd.getVillageCode();
        this.structure = rnd.getStructure();
        this.extension = rnd.getExtension();
        this.hh = rnd.getHh();
        this.hhhead = rnd.getHhhead();
        this.hhcontact = rnd.gethhcontact();
        this.randomDT = rnd.getRandomDT();
    }

    public BLRandomContract Sync(JSONObject jsonObject) throws JSONException {
        this.LUID = jsonObject.getString(singleChild.COLUMN_LUID);
        this.LHWCode = jsonObject.getString(singleChild.COLUMN_LHW_CODE);
        this.villageCode = jsonObject.getString(singleChild.COLUMN_VILLAGE_CODE);
        this.structure = jsonObject.getString(singleChild.COLUMN_STRUCTURE_NO);

        this.structure = String.format("%04d", Integer.valueOf(this.structure));

        this.extension = jsonObject.getString(singleChild.COLUMN_FAMILY_EXT_CODE);
        this.hh = jsonObject.getString(singleChild.COLUMN_STRUCTURE_NO)
                + "-" + jsonObject.getString(singleChild.COLUMN_FAMILY_EXT_CODE);
        this.randomDT = jsonObject.getString(singleChild.COLUMN_RANDOMDT);
        this.hhhead = jsonObject.getString(singleChild.COLUMN_HH_HEAD);
        this.hhcontact = jsonObject.getString(singleChild.COLUMN_HH_CONTACT);

        return this;
    }

    public BLRandomContract Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_ID));
        this.LUID = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_LUID));
        this.LHWCode = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_LHW_CODE));
        this.villageCode = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_VILLAGE_CODE));
        this.structure = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_STRUCTURE_NO));
        this.extension = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_FAMILY_EXT_CODE));
        this.hh = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_HH));
        this.randomDT = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_RANDOMDT));
        this.hhhead = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_HH_HEAD));
        this.hhcontact = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_HH_CONTACT));

        return this;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String getLUID() {
        return LUID;
    }

    public void setLUID(String LUID) {
        this.LUID = LUID;
    }

    public String getLHWCode() {
        return LHWCode;
    }

    public void setLHWCode(String LHWCode) {
        this.LHWCode = LHWCode;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getHh() {
        return structure + "-" + "" + extension;
    }

    public void setHh(String hh) {
        this.hh = hh;
    }

    public String getRandomDT() {
        return randomDT;
    }

    public void setRandomDT(String randomDT) {
        this.randomDT = randomDT;
    }

    public String getHhhead() {
        return hhhead;
    }

    public void setHhhead(String hhhead) {
        this.hhhead = hhhead;
    }

    public String gethhcontact() {
        return hhcontact;
    }

    public void sethhcontact(String hhcontact) {
        this.hhcontact = hhcontact;
    }

    public String getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode;
    }

    public static abstract class singleChild implements BaseColumns {

        public static final String TABLE_NAME = "BLRandom";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_RANDOMDT = "randDT";
        public static final String COLUMN_LUID = "uid";
        public static final String COLUMN_LHW_CODE = "lhwcode";
        public static final String COLUMN_VILLAGE_CODE = "hh04village";
        public static final String COLUMN_STRUCTURE_NO = "hh03";
        public static final String COLUMN_FAMILY_EXT_CODE = "hh07";
        public static final String COLUMN_HH = "hh";
        public static final String COLUMN_HH_HEAD = "hh08";
        public static final String COLUMN_HH_CONTACT = "hh09";
        //        public static String _URIGET = "bl_random.php";
        public static String _URIGET = "gethh.php";
    }

}