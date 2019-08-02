package edu.aku.hassannaqvi.uen_po_hhs_fl.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class ChildrenContract {

    private String f_name;
    private String caseid;
    private String child_name;
    private String rep_date;
    private String luid;


    public ChildrenContract() {
    }


    public String getF_name() {
        return f_name;
    }

    public String getCaseide() {
        return caseid;
    }

    public String getChild_name() {
        return child_name;
    }

    public String getRep_date() {
        return rep_date;
    }

    public String getLuid() {
        return luid;
    }

    public ChildrenContract sync(JSONObject jsonObject) throws JSONException {
        this.f_name = jsonObject.getString(ChildrenContract.singleChild.COLUMN_F_NAME);
        this.caseid = jsonObject.getString(ChildrenContract.singleChild.COLUMN_CASEID);
        this.child_name = jsonObject.getString(ChildrenContract.singleChild.COLUMN_CHILD_NAME);
        this.rep_date = jsonObject.getString(ChildrenContract.singleChild.COLUMN_REP_DATE);
        this.luid = jsonObject.getString(ChildrenContract.singleChild.COLUMN_LUID);

        return this;
    }

    public ChildrenContract hydrate(Cursor cursor) {
        this.f_name = cursor.getString(cursor.getColumnIndex(ChildrenContract.singleChild.COLUMN_F_NAME));
        this.caseid = cursor.getString(cursor.getColumnIndex(ChildrenContract.singleChild.COLUMN_CASEID));
        this.child_name = cursor.getString(cursor.getColumnIndex(ChildrenContract.singleChild.COLUMN_CHILD_NAME));
        this.rep_date = cursor.getString(cursor.getColumnIndex(ChildrenContract.singleChild.COLUMN_REP_DATE));
        this.luid = cursor.getString(cursor.getColumnIndex(ChildrenContract.singleChild.COLUMN_LUID));

        return this;
    }


    public static abstract class singleChild implements BaseColumns {

        public static final String TABLE_NAME = "children";
        public static final String COLUMN_NAME_NULLABLE = "nullColumnHack";
        public static final String _ID = "_ID";
        public static final String COLUMN_F_NAME = "taluka_code";
        public static final String COLUMN_CASEID = "taluka_name";
        public static final String COLUMN_CHILD_NAME = "uc_code";
        public static final String COLUMN_REP_DATE = "uc_name";
        public static final String COLUMN_LUID = "village_code";

        public static final String _URI = "children.php";
    }
}
