package edu.aku.hassannaqvi.uen_po_hhs_fl.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class ChildrenContract {

    private String luid;
    private String formType;
    private String Sa;
    private String iStatus;
    private String lhw_code;
    private String caseid;
    private String child_name;
    private String f_name;
    private String rep_date;


    public ChildrenContract() {
    }


    public String getLuid() {
        return luid;
    }

    public String getFormType() {
        return formType;
    }

    public String getSa() {
        return Sa;
    }

    public String getiStatus() {
        return iStatus;
    }

    public String getRep_date() {
        return rep_date;
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


    public ChildrenContract hydrateForm(Cursor cursor) {

        //this.luid = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_UID));
        this.formType = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_FORMTYPE));
        this.iStatus = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_ISTATUS));
        this.iStatus = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_CODE_LHW));
        this.iStatus = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_REF_ID));

        CrfChild formSa = new Gson().fromJson(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SA)), CrfChild.class);
        CrfChild formSb = new Gson().fromJson(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SB)), CrfChild.class);

        this.lhw_code = formSa.getPocfa03();
        this.caseid = formSa.getPocfa08();
        this.child_name = formSa.getPocfa09();
        this.f_name = formSb.getPocfb02();
        //this.rep_date = formSa.getKapr09();

        return this;
    }


    private class CrfChild {
        String pocfa03, pocfa08, pocfa09, pocfb02;

        public String getPocfa03() {
            return pocfa03;
        }

        public void setPocfa03(String pocfa03) {
            this.pocfa03 = pocfa03;
        }

        public String getPocfa08() {
            return pocfa08;
        }

        public void setPocfa08(String pocfa08) {
            this.pocfa08 = pocfa08;
        }

        public String getPocfa09() {
            return pocfa09;
        }

        public void setPocfa09(String pocfa09) {
            this.pocfa09 = pocfa09;
        }

        public String getPocfb02() {
            return pocfb02;
        }

        public void setPocfb02(String pocfb02) {
            this.pocfb02 = pocfb02;
        }

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
