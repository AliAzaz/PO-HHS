package edu.aku.hassannaqvi.uen_po_hhs_fl.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class ChildrenContract {

    private String lhw_code;
    private String caseid;
    private String child_name;
    private String f_name;
    private String rep_date;
    private String luid;


    public ChildrenContract() {
    }

    public String getLhw_code() {
        return lhw_code;
    }

    public String getCaseid() {
        return caseid;
    }

    public String getChild_name() {
        return child_name;
    }

    public String getF_name() {
        return f_name;
    }

    public String getRep_date() {
        return rep_date;
    }

    public String getLuid() {
        return luid;
    }

    public ChildrenContract sync(JSONObject jsonObject) throws JSONException {
        this.lhw_code = jsonObject.getString(singleChild.COLUMN_LHW_CODE);
        this.caseid = jsonObject.getString(singleChild.COLUMN_CASEID);
        this.child_name = jsonObject.getString(singleChild.COLUMN_CHILD_NAME);
        this.f_name = jsonObject.getString(singleChild.COLUMN_F_NAME);
        this.rep_date = jsonObject.getString(singleChild.COLUMN_REP_DATE);
        this.luid = jsonObject.getString(singleChild.COLUMN_LUID);

        return this;
    }

    public ChildrenContract hydrate(Cursor cursor) {
        this.lhw_code = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_LHW_CODE));
        this.caseid = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_CASEID));
        this.child_name = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_CHILD_NAME));
        this.f_name = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_F_NAME));
        this.rep_date = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_REP_DATE));
        this.luid = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_LUID));

        return this;
    }


    public static abstract class singleChild implements BaseColumns {

        public static final String TABLE_NAME = "children";
        public static final String _ID = "_ID";
        public static final String COLUMN_LHW_CODE = "lhw_code";
        public static final String COLUMN_CASEID = "caseid";
        public static final String COLUMN_CHILD_NAME = "child_name";
        public static final String COLUMN_F_NAME = "f_name";
        public static final String COLUMN_REP_DATE = "rep_date";
        public static final String COLUMN_LUID = "luid";

        public static final String _URI = "children.php";
    }
}
