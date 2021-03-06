package edu.aku.hassannaqvi.uen_po_hhs_fl.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.AreasContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.AreasContract.singleAreas;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.ChildrenContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.ChildrenContract.singleChild;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.FormsContract.FormsTable;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.LHWContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.LHWContract.lhwEntry;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.MWRAContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.MWRAContract.MWRATable;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.TalukasContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.TalukasContract.singleTalukas;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.UCsContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.UCsContract.singleUCs;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.UsersContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.UsersContract.singleUser;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.VersionAppContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.VersionAppContract.VersionAppTable;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.VillagesContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.VillagesContract.singleVillage;
import edu.aku.hassannaqvi.uen_po_hhs_fl.otherClasses.MotherLst;


/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_USERS = "CREATE TABLE " + singleUser.TABLE_NAME + "("
            + singleUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleUser.ROW_USERNAME + " TEXT,"
            + singleUser.ROW_PASSWORD + " TEXT,"
            + singleUser.FULL_NAME + " TEXT"
            + " );";
    public static final String DATABASE_NAME = "po_hhs.db";
    public static final String DB_NAME = "po_hhs_copy.db";
    public static final String PROJECT_NAME = "DMU-PO-HHS";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsTable.COLUMN_UID + " TEXT," +
            FormsTable.COLUMN_FORMDATE + " TEXT," +
            FormsTable.COLUMN_APPVERSION + " TEXT," +
            FormsTable.COLUMN_FORMTYPE + " TEXT," +
            FormsTable.COLUMN_CODE_LHW + " TEXT," +
            FormsTable.COLUMN_REF_ID + " TEXT," +
            FormsTable.COLUMN_USER + " TEXT," +
            FormsTable.COLUMN_SA + " TEXT," +
            FormsTable.COLUMN_SB + " TEXT," +
            FormsTable.COLUMN_SC + " TEXT," +
            FormsTable.COLUMN_SD + " TEXT," +
            FormsTable.COLUMN_SE + " TEXT," +
            FormsTable.COLUMN_SF + " TEXT," +
            FormsTable.COLUMN_SG + " TEXT," +
            FormsTable.COLUMN_SH + " TEXT," +
            FormsTable.COLUMN_SI + " TEXT," +
            FormsTable.COLUMN_SJ + " TEXT," +
            FormsTable.COLUMN_SK + " TEXT," +
            FormsTable.COLUMN_ISTATUS + " TEXT," +
            FormsTable.COLUMN_ISTATUS88x + " TEXT," +
            FormsTable.COLUMN_ENDINGDATETIME + " TEXT," +
            FormsTable.COLUMN_GPSLAT + " TEXT," +
            FormsTable.COLUMN_GPSLNG + " TEXT," +
            FormsTable.COLUMN_GPSDATE + " TEXT," +
            FormsTable.COLUMN_GPSACC + " TEXT," +
            FormsTable.COLUMN_DEVICEID + " TEXT," +
            FormsTable.COLUMN_DEVICETAGID + " TEXT," +
            FormsTable.COLUMN_SYNCED + " TEXT," +
            FormsTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );";
    private static final String SQL_SELECT_MOTHER_BY_CHILD =
            "SELECT c.agem cm, c.agey cy, c.aged cd, c.gender, c.serial serial, m.serial serialm, c.name child_name, c.dss_id_member child_id, m.name mother_name, c.dss_id_member mother_id, c.dob date_of_birth FROM census C join census m on c.dss_id_m = m.dss_id_member where c.member_type =? and c.uuid = m.uuid and c.current_status IN ('1', '2') and c.uuid = ? group by mother_id order by substr(c.dob, 7) desc, substr(c.dob, 4,2) desc, substr(c.dob, 1,2) desc;";
    private static final String SQL_DELETE_USERS =
            "DROP TABLE IF EXISTS " + singleUser.TABLE_NAME;
    private static final String SQL_DELETE_FORMS =
            "DROP TABLE IF EXISTS " + FormsTable.TABLE_NAME;
    final String SQL_CREATE_VERSIONAPP = "CREATE TABLE " + VersionAppTable.TABLE_NAME + " (" +
            VersionAppTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            VersionAppTable.COLUMN_VERSION_CODE + " TEXT, " +
            VersionAppTable.COLUMN_VERSION_NAME + " TEXT, " +
            VersionAppTable.COLUMN_PATH_NAME + " TEXT " +
            ");";
    private static final String SQL_SELECT_CHILD =
            "SELECT * from census where member_type =? and dss_id_hh =? and uuid =? and current_status IN ('1', '2')";
    private static final String SQL_SELECT_MWRA =
            "SELECT * from census where member_type =? and dss_id_hh =? and uuid =? and current_status IN ('1', '2')";
    private static final String SQL_DELETE_CHILDREN = "DROP TABLE IF EXISTS " + singleChild.TABLE_NAME;
    private static final String SQL_DELETE_VILLAGES = "DROP TABLE IF EXISTS " + singleVillage.TABLE_NAME;
    private static final String SQL_DELETE_TALUKAS = "DROP TABLE IF EXISTS " + singleTalukas.TABLE_NAME;
    private static final String SQL_DELETE_UCS = "DROP TABLE IF EXISTS " + singleUCs.TABLE_NAME;
    private static final String SQL_DELETE_AREAS = "DROP TABLE IF EXISTS " + singleAreas.TABLE_NAME;
    final String SQL_CREATE_PSU_TABLE = "CREATE TABLE " + singleVillage.TABLE_NAME + " (" +
            singleVillage._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            singleVillage.COLUMN_TALUKA_CODE + " TEXT, " +
            singleVillage.COLUMN_TALUKA_NAME + " TEXT, " +
            singleVillage.COLUMN_UC_CODE + " TEXT, " +
            singleVillage.COLUMN_UC_NAME + " TEXT, " +
            singleVillage.COLUMN_VILLAGE_CODE + " TEXT, " +
            singleVillage.COLUMN_VILLAGE_NAME + " TEXT " +
            ");";
    final String SQL_CREATE_LHW_TABLE = "CREATE TABLE " + lhwEntry.TABLE_NAME + " (" +
            lhwEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            lhwEntry.COLUMN_TALUKA_CODE + " TEXT, " +
            lhwEntry.COLUMN_TALUKA_NAME + " TEXT, " +
            lhwEntry.COLUMN_UC_CODE + " TEXT, " +
            lhwEntry.COLUMN_UC_NAME + " TEXT, " +
            lhwEntry.COLUMN_LHW_CODE + " TEXT, " +
            lhwEntry.COLUMN_LHW_NAME + " TEXT " +
            ");";


    final String SQL_CREATE_TALUKAS = "CREATE TABLE " + singleTalukas.TABLE_NAME + "("
            + singleTalukas._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleTalukas.COLUMN_TALUKA_CODE + " TEXT,"
            + singleTalukas.COLUMN_TALUKA + " TEXT );";
    final String SQL_CREATE_UCS = "CREATE TABLE " + singleUCs.TABLE_NAME + "("
            + singleUCs._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleUCs.COLUMN_UCCODE + " TEXT,"
            + singleUCs.COLUMN_TALUKA_CODE + " TEXT,"
            + singleUCs.COLUMN_UCS + " TEXT );";
    final String SQL_CREATE_AREAS = "CREATE TABLE " + singleAreas.TABLE_NAME + "("
            + singleAreas._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleAreas.COLUMN_AREACODE + " TEXT,"
            + singleAreas.COLUMN_UC_CODE + " TEXT,"
            + singleAreas.COLUMN_AREA + " TEXT );";
    final String SQL_CREATE_CHILDREN = "CREATE TABLE " + singleChild.TABLE_NAME + "("
            + singleChild._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleChild.COLUMN_LHW_CODE + " TEXT,"
            + singleChild.COLUMN_CASEID + " TEXT,"
            + singleChild.COLUMN_CHILD_NAME + " TEXT, "
            + singleChild.COLUMN_F_NAME + " TEXT,"
            + singleChild.COLUMN_REF_DATE + " TEXT, "
            + singleChild.COLUMN_LUID + " TEXT );";
    private final String TAG = "DatabaseHelper";


    public String spDateT = new SimpleDateFormat("dd-MM-yy").format(new Date().getTime());


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_FORMS);
        db.execSQL(SQL_CREATE_TALUKAS);
        db.execSQL(SQL_CREATE_UCS);
        db.execSQL(SQL_CREATE_CHILDREN);
        db.execSQL(SQL_CREATE_PSU_TABLE);
        db.execSQL(SQL_CREATE_AREAS);
        db.execSQL(SQL_CREATE_LHW_TABLE);
        db.execSQL(SQL_CREATE_VERSIONAPP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_USERS);
        db.execSQL(SQL_DELETE_FORMS);
        db.execSQL("DROP TABLE IF EXISTS " + lhwEntry.TABLE_NAME);
        db.execSQL(SQL_DELETE_CHILDREN);
        db.execSQL(SQL_DELETE_VILLAGES);
        db.execSQL(SQL_DELETE_TALUKAS);
        db.execSQL(SQL_DELETE_UCS);
        db.execSQL(SQL_DELETE_AREAS);

    }

    public void syncChildren(JSONArray pcList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(singleChild.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = pcList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                ChildrenContract cc = new ChildrenContract();
                cc.sync(jsonObjectCC);
                Log.i(TAG, "syncChildren: " + jsonObjectCC.toString());

                ContentValues values = new ContentValues();

                values.put(singleChild.COLUMN_LHW_CODE, cc.getLhw_code());
                values.put(singleChild.COLUMN_CASEID, cc.getCaseid());
                values.put(singleChild.COLUMN_CHILD_NAME, cc.getChild_name());
                values.put(singleChild.COLUMN_F_NAME, cc.getF_name());
                values.put(singleChild.COLUMN_REF_DATE, cc.getRef_date());
                values.put(singleChild.COLUMN_LUID, cc.getLuid());

                db.insert(singleChild.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {

        }
    }

    public void syncVillages(JSONArray pcList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(singleVillage.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = pcList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectPSU = jsonArray.getJSONObject(i);

                VillagesContract vc = new VillagesContract();
                vc.sync(jsonObjectPSU);
                Log.i(TAG, "syncVillages: " + jsonObjectPSU.toString());

                ContentValues values = new ContentValues();

                values.put(singleVillage.COLUMN_TALUKA_CODE, vc.getTalukacode());
                values.put(singleVillage.COLUMN_TALUKA_NAME, vc.getTalukaname());
                values.put(singleVillage.COLUMN_UC_CODE, vc.getUccode());
                values.put(singleVillage.COLUMN_UC_NAME, vc.getUcname());
                values.put(singleVillage.COLUMN_VILLAGE_CODE, vc.getVillagecode());
                values.put(singleVillage.COLUMN_VILLAGE_NAME, vc.getVillagename());

                db.insert(singleVillage.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {

        }
    }


    public Collection<VillagesContract> getAllPSUsByTaluka(String taluka_code, String uc_code) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleVillage._ID,
                singleVillage.COLUMN_TALUKA_CODE,
                singleVillage.COLUMN_TALUKA_NAME,
                singleVillage.COLUMN_UC_CODE,
                singleVillage.COLUMN_UC_NAME,
                singleVillage.COLUMN_VILLAGE_CODE,
                singleVillage.COLUMN_VILLAGE_NAME

        };

        String whereClause = singleVillage.COLUMN_TALUKA_CODE + " =? AND " + singleVillage.COLUMN_UC_CODE + " =?";

        String[] whereArgs = {taluka_code, uc_code};
        String groupBy = null;
        String having = null;

        String orderBy =
                singleVillage.COLUMN_VILLAGE_NAME + " ASC";

        Collection<VillagesContract> allPC = new ArrayList<VillagesContract>();
        try {
            c = db.query(
                    singleVillage.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                VillagesContract pc = new VillagesContract();
                allPC.add(pc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allPC;
    }


    public Collection<LHWContract> getAllLHWsByTaluka(String district_code, String uc_code) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                lhwEntry._ID,
                lhwEntry.COLUMN_TALUKA_CODE,
                lhwEntry.COLUMN_TALUKA_NAME,
                lhwEntry.COLUMN_UC_CODE,
                lhwEntry.COLUMN_UC_NAME,
                lhwEntry.COLUMN_LHW_CODE,
                lhwEntry.COLUMN_LHW_NAME
        };

        String whereClause = lhwEntry.COLUMN_TALUKA_CODE + " =? AND " + lhwEntry.COLUMN_UC_CODE + " =?";

        String[] whereArgs = {district_code, uc_code};
        String groupBy = null;
        String having = null;

        String orderBy =
                lhwEntry.COLUMN_LHW_NAME + " ASC";

        Collection<LHWContract> allPC = new ArrayList<LHWContract>();
        try {
            c = db.query(
                    lhwEntry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                LHWContract pc = new LHWContract();
                allPC.add(pc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allPC;
    }


    public void syncTalukas(JSONArray Talukaslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(singleTalukas.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = Talukaslist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                TalukasContract Vc = new TalukasContract();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(singleTalukas.COLUMN_TALUKA_CODE, Vc.getTalukacode());
                values.put(singleTalukas.COLUMN_TALUKA, Vc.getTaluka());

                db.insert(singleTalukas.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }

    public void syncUCs(JSONArray UCslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(singleUCs.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = UCslist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                UCsContract Vc = new UCsContract();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(singleUCs.COLUMN_UCCODE, Vc.getUccode());
                values.put(singleUCs.COLUMN_UCS, Vc.getUcs());
                values.put(singleUCs.COLUMN_TALUKA_CODE, Vc.getTaluka_code());

                db.insert(singleUCs.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }

    public void syncAreas(JSONArray Areaslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(singleAreas.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = Areaslist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                AreasContract Vc = new AreasContract();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(singleAreas.COLUMN_AREACODE, Vc.getAreacode());
                values.put(singleAreas.COLUMN_AREA, Vc.getArea());
                values.put(singleAreas.COLUMN_UC_CODE, Vc.getUc_code());

                db.insert(singleAreas.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }

    /*public Collection<VillagesContract> getVillage(String areacode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
//                singleVillages.COLUMN_ID,
                singleVillage.COLUMN_VILLAGE_NAME,
                singleVillage.COLUMN_AREA_CODE,
//                singleVillages.COLUMN_TALUKA,
                singleVillage.COLUMN_VILLAGE_CODE,
        };

        String whereClause = singleVillages.COLUMN_AREA_CODE + " =?";
        String[] whereArgs = {areacode};
        String groupBy = null;
        String having = null;

        String orderBy =
                singleVillages.COLUMN_VILLAGE_NAME + " ASC";

        Collection<VillagesContract> allDC = new ArrayList<>();
        try {
            c = db.query(
                    singleVillages.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                VillagesContract dc = new VillagesContract();
                allDC.add(dc.HydrateVillages(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }*/

    public Collection<UCsContract> getAllUCsbyTaluka(String taluka_code) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleUCs._ID,
                singleUCs.COLUMN_UCCODE,
                singleUCs.COLUMN_UCS,
                singleUCs.COLUMN_TALUKA_CODE
        };

        String whereClause = singleUCs.COLUMN_TALUKA_CODE + " = ?";
        String[] whereArgs = {taluka_code};
        String groupBy = null;
        String having = null;

        String orderBy =
                singleUCs.COLUMN_UCS + " ASC";

        Collection<UCsContract> allPC = new ArrayList<UCsContract>();
        try {
            c = db.query(
                    singleUCs.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                UCsContract pc = new UCsContract();
                allPC.add(pc.HydrateUCs(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allPC;
    }

    public Collection<TalukasContract> getAllTalukas() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleTalukas.COLUMN_TALUKA_CODE,
                singleTalukas.COLUMN_TALUKA
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                singleTalukas.COLUMN_TALUKA + " ASC";

        Collection<TalukasContract> allDC = new ArrayList<>();
        try {
            c = db.query(
                    singleTalukas.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                TalukasContract dc = new TalukasContract();
                allDC.add(dc.HydrateTalukas(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }

    public Collection<ChildrenContract> getChildBy(String lhw_code, String caseid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleChild._ID,
                singleChild.COLUMN_LHW_CODE,
                singleChild.COLUMN_CASEID,
                singleChild.COLUMN_CHILD_NAME,
                singleChild.COLUMN_F_NAME,
                singleChild.COLUMN_REF_DATE,
                singleChild.COLUMN_LUID
        };

        String whereClause = singleChild.COLUMN_LHW_CODE + " = ? AND " + singleChild.COLUMN_CASEID + " = ?";
        String[] whereArgs = {lhw_code, caseid};
        String groupBy = null;
        String having = null;

        String orderBy =
                singleChild.COLUMN_LHW_CODE + " ASC";

        Collection<ChildrenContract> allCC = new ArrayList<>();
        try {
            c = db.query(
                    singleChild.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ChildrenContract cc = new ChildrenContract();
                allCC.add(cc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allCC;
    }


    public ChildrenContract getChildById(String lhw_code, String caseid) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleChild._ID,
                singleChild.COLUMN_LHW_CODE,
                singleChild.COLUMN_CASEID,
                singleChild.COLUMN_CHILD_NAME,
                singleChild.COLUMN_F_NAME,
                singleChild.COLUMN_REF_DATE,
                singleChild.COLUMN_LUID,
        };

        String whereClause = singleChild.COLUMN_LHW_CODE + " =? AND " + singleChild.COLUMN_CASEID + " =?";
        String[] whereArgs = {lhw_code, caseid};
        String groupBy = null;
        String having = null;

        String orderBy = singleChild.COLUMN_LHW_CODE + " ASC";

        ChildrenContract allEB = null;

        try {
            c = db.query(
                    singleChild.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allEB = new ChildrenContract().hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allEB;
    }


    public ChildrenContract getChildById(String sType, String codeLhw, String refId) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable.COLUMN_FORMTYPE,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_CODE_LHW,
                FormsTable.COLUMN_REF_ID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_SA,
                FormsTable.COLUMN_SB,
        };

        String whereClause = FormsTable.COLUMN_FORMTYPE + " =? AND " + FormsTable.COLUMN_CODE_LHW + " =? AND " + FormsTable.COLUMN_REF_ID + "=? AND " + FormsTable.COLUMN_ISTATUS + "=?";
        String[] whereArgs = {sType, codeLhw, refId, "1"};
        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_FORMTYPE + " ASC";

        ChildrenContract allEB = null;

        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allEB = new ChildrenContract().hydrateForm(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allEB;
    }


    public Collection<UCsContract> getAllUCs(String talukaCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleUCs.COLUMN_UCCODE,
                singleUCs.COLUMN_UCS,
                singleUCs.COLUMN_TALUKA_CODE
        };

        String whereClause = singleUCs.COLUMN_TALUKA_CODE + "=?";
        String[] whereArgs = new String[]{talukaCode};
        String groupBy = null;
        String having = null;

        String orderBy =
                singleUCs.COLUMN_UCS + " ASC";

        Collection<UCsContract> allDC = new ArrayList<>();
        try {
            c = db.query(
                    singleUCs.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                UCsContract dc = new UCsContract();
                allDC.add(dc.HydrateUCs(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }

    public Collection<AreasContract> getAllAreas(String UCCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleAreas.COLUMN_AREACODE,
                singleAreas.COLUMN_AREA,
                singleAreas.COLUMN_UC_CODE
        };

        String whereClause = singleAreas.COLUMN_UC_CODE + "=?";
        String[] whereArgs = new String[]{UCCode};
        String groupBy = null;
        String having = null;

        String orderBy =
                singleAreas.COLUMN_AREA + " ASC";

        Collection<AreasContract> allAC = new ArrayList<>();
        try {
            c = db.query(
                    singleAreas.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                AreasContract dc = new AreasContract();
                allAC.add(dc.HydrateUCs(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allAC;
    }

    public void syncVersionApp(JSONArray Versionlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VersionAppTable.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = Versionlist;
            JSONObject jsonObjectCC = jsonArray.getJSONObject(0);

            VersionAppContract Vc = new VersionAppContract();
            Vc.Sync(jsonObjectCC);

            ContentValues values = new ContentValues();

            values.put(VersionAppTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(VersionAppTable.COLUMN_VERSION_CODE, Vc.getVersioncode());
            values.put(VersionAppTable.COLUMN_VERSION_NAME, Vc.getVersionname());

            db.insert(VersionAppTable.TABLE_NAME, null, values);
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }

    public VersionAppContract getVersionApp() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                VersionAppContract.VersionAppTable._ID,
                VersionAppTable.COLUMN_VERSION_CODE,
                VersionAppTable.COLUMN_VERSION_NAME,
                VersionAppTable.COLUMN_PATH_NAME
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = null;

        VersionAppContract allVC = new VersionAppContract();
        try {
            c = db.query(
                    VersionAppTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allVC.hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allVC;
    }

    public void syncUser(JSONArray userlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersContract.singleUser.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                UsersContract user = new UsersContract();
                user.Sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(singleUser.ROW_USERNAME, user.getUserName());
                values.put(singleUser.ROW_PASSWORD, user.getPassword());
                values.put(singleUser.FULL_NAME, user.getFULL_NAME());
//                values.put(singleUser.REGION_DSS, user.getREGION_DSS());
                db.insert(singleUser.TABLE_NAME, null, values);
            }


        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
        } finally {
            db.close();
        }
    }


    public boolean Login(String username, String password) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.rawQuery("SELECT * FROM " + singleUser.TABLE_NAME + " WHERE " + singleUser.ROW_USERNAME + "=? AND " + singleUser.ROW_PASSWORD + "=?", new String[]{username, password});
        if (mCursor != null) {
            return mCursor.getCount() > 0;
        }
        return false;
    }


    public List<FormsContract> getFormsByDSS(String dssID) {
        List<FormsContract> formList = new ArrayList<FormsContract>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + FormsTable.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                FormsContract fc = new FormsContract();
                formList.add(fc.Hydrate(c));
            } while (c.moveToNext());
        }

        // return contact list
        return formList;
    }

    public Collection<MotherLst> getMotherByUUID(String uuid) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        // COLUMNS RETURNED: child_name, child_id, mother_name, mother_id, date_of_birth, serial
        Collection<MotherLst> memList = new ArrayList<>();
        try {

//            c = db.rawQuery(SQL_SELECT_MOTHER_BY_CHILD, new String[]{"c", "('1', '2')", uuid});
            c = db.rawQuery(SQL_SELECT_MOTHER_BY_CHILD, new String[]{"c", uuid});

            while (c.moveToNext()) {

                MotherLst mc = new MotherLst();
                memList.add(mc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return memList;
    }

    public Long addForm(FormsContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_PROJECT_NAME, fc.getProjectName());
        values.put(FormsTable.COLUMN_UID, fc.get_UID());
        values.put(FormsTable.COLUMN_FORMDATE, fc.getFormDate());
        values.put(FormsTable.COLUMN_CODE_LHW, fc.getCode_lhw());
        values.put(FormsTable.COLUMN_REF_ID, fc.getRef_ID());
        values.put(FormsTable.COLUMN_USER, fc.getUser());
        values.put(FormsTable.COLUMN_ISTATUS, fc.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS88x, fc.getIstatus88x());
        values.put(FormsTable.COLUMN_ENDINGDATETIME, fc.getEndingdatetime());
        values.put(FormsTable.COLUMN_SA, fc.getsA());
        values.put(FormsTable.COLUMN_SB, fc.getsB());
        values.put(FormsTable.COLUMN_SC, fc.getsC());
        values.put(FormsTable.COLUMN_SD, fc.getsD());
        values.put(FormsTable.COLUMN_SE, fc.getsE());
        values.put(FormsTable.COLUMN_SF, fc.getsF());
        values.put(FormsTable.COLUMN_SG, fc.getsG());
        values.put(FormsTable.COLUMN_SH, fc.getsH());
        values.put(FormsTable.COLUMN_SI, fc.getsI());
        values.put(FormsTable.COLUMN_SJ, fc.getsJ());
        values.put(FormsTable.COLUMN_SK, fc.getsK());
        values.put(FormsTable.COLUMN_GPSLAT, fc.getGpsLat());
        values.put(FormsTable.COLUMN_GPSLNG, fc.getGpsLng());
        values.put(FormsTable.COLUMN_GPSDATE, fc.getGpsDT());
        values.put(FormsTable.COLUMN_GPSACC, fc.getGpsAcc());
        values.put(FormsTable.COLUMN_DEVICETAGID, fc.getDevicetagID());
        values.put(FormsTable.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(FormsTable.COLUMN_APPVERSION, fc.getAppversion());
        values.put(FormsTable.COLUMN_FORMTYPE, fc.getFormType());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

//    public Long addFamilyMembers(FamilyMembersContract fmc) {
//
//        // Gets the data repository in write mode
//        SQLiteDatabase db = this.getWritableDatabase();
//
//// Create a new map of values, where column names are the keys
//        ContentValues values = new ContentValues();
//        values.put(familyMembers.COLUMN_PROJECT_NAME, fmc.getProjectName());
//        values.put(familyMembers.COLUMN_UID, fmc.get_UID());
//        values.put(familyMembers.COLUMN_UUID, fmc.get_UUID());
//        values.put(familyMembers.COLUMN_FORMDATE, fmc.getFormDate());
//        values.put(familyMembers.COLUMN_USER, fmc.getUser());
//        values.put(familyMembers.COLUMN_SB, fmc.getsB());
//        values.put(familyMembers.COLUMN_SERIAL_NO, fmc.getSerialNo());
//        values.put(familyMembers.COLUMN_DEVICETAGID, fmc.getDevicetagID());
//        values.put(familyMembers.COLUMN_DEVICEID, fmc.getDeviceId());
//
//        // Insert the new row, returning the primary key value of the new row
//        long newRowId;
//        newRowId = db.insert(
//                familyMembers.TABLE_NAME,
//                familyMembers.COLUMN_NAME_NULLABLE,
//                values);
//        return newRowId;
//    }

    public Long addMWRA(MWRAContract mc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(MWRATable.COLUMN_PROJECT_NAME, mc.getProjectName());
        values.put(MWRATable.COLUMN_UID, mc.getUID());
        values.put(MWRATable.COLUMN_UUID, mc.get_UUID());
        values.put(MWRATable.COLUMN_FORMDATE, mc.getFormDate());
        values.put(MWRATable.COLUMN_USER, mc.getUser());
        values.put(MWRATable.COLUMN_SD, mc.getsD());
        values.put(MWRATable.COLUMN_DEVICEID, mc.getDeviceId());
        values.put(MWRATable.COLUMN_DEVICETAGID, mc.getDevicetagID());

        // SYNCED INFORMATION IS NEVER INSERTED WITH NEW RECORD.
     /*   values.put(MWRATable.COLUMN_SYNCED, mc.getSynced());
        values.put(MWRATable.COLUMN_SYNCED_DATE, mc.getSynced_date());*/


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                MWRATable.TABLE_NAME,
                MWRATable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

//    public Long addChild(SectionIIMContract ims) {
//
//        // Gets the data repository in write mode
//        SQLiteDatabase db = this.getWritableDatabase();
//
//// Create a new map of values, where column names are the keys
//        ContentValues values = new ContentValues();
//
//        values.put(singleIm.COLUMN_PROJECT_NAME, ims.getProjectName());
//        values.put(singleIm.COLUMN_UUID, ims.get_UUID());
//        values.put(singleIm.COLUMN_UID, ims.getUID());
//        values.put(singleIm.COLUMN_SI, ims.getsI());
//        values.put(singleIm.COLUMN_FORMDATE, ims.getFormDate());
//        values.put(singleIm.COLUMN_USER, ims.getUser());
////        values.put(singleIm.COLUMN_MM, ims.getMm());
//        //values.put(singleIm.COLUMN_CHILDID, ims.getChildID());
////        values.put(singleIm.COLUMN_DSSID, ims.getDssID());
//        values.put(singleIm.COLUMN_DEVICEID, ims.getDeviceId());
//        values.put(singleIm.COLUMN_DEVICETAGID, ims.getDevicetagID());
//
//
//        // Insert the new row, returning the primary key value of the new row
//        long newRowId;
//        newRowId = db.insert(
//                singleIm.TABLE_NAME,
//                singleIm.COLUMN_NAME_NULLABLE,
//                values);
//        return newRowId;
//    }


//    public Long addDeceasedMother(DeceasedMotherContract dc) {
//
//        // Gets the data repository in write mode
//        SQLiteDatabase db = this.getWritableDatabase();
//
//// Create a new map of values, where column names are the keys
//        ContentValues values = new ContentValues();
//        values.put(DeceasedMother.COLUMN_PROJECT_NAME, dc.getProjectName());
//        values.put(DeceasedMother.COLUMN_UID, dc.get_UID());
//        values.put(DeceasedMother.COLUMN_UUID, dc.get_UUID());
//        values.put(DeceasedMother.COLUMN_FORMDATE, dc.getFormDate());
//        values.put(DeceasedMother.COLUMN_DEVICEID, dc.getDeviceId());
//        values.put(DeceasedMother.COLUMN_DEVICETAGID, dc.getDevicetagID());
//        values.put(DeceasedMother.COLUMN_USER, dc.getUser());
//        values.put(DeceasedMother.COLUMN_SE, dc.getsE());
//
//        long newRowId;
//        newRowId = db.insert(
//                DeceasedMother.TABLE_NAME,
//                DeceasedMother.COLUMN_NAME_NULLABLE,
//                values);
//        return newRowId;
//    }
//

//    public Long addDeceasedChild(DeceasedChildContract dc) {
//
//        // Gets the data repository in write mode
//        SQLiteDatabase db = this.getWritableDatabase();
//
//// Create a new map of values, where column names are the keys
//        ContentValues values = new ContentValues();
//        values.put(DeceasedChild.COLUMN_PROJECT_NAME, dc.getProjectName());
//        values.put(DeceasedChild.COLUMN_UID, dc.get_UID());
//        values.put(DeceasedChild.COLUMN_UUID, dc.get_UUID());
//        values.put(DeceasedChild.COLUMN_FORMDATE, dc.getFormDate());
//        values.put(DeceasedChild.COLUMN_DEVICEID, dc.getDeviceId());
//        values.put(DeceasedChild.COLUMN_DEVICETAGID, dc.getDevicetagID());
//        values.put(DeceasedChild.COLUMN_USER, dc.getUser());
//        values.put(DeceasedChild.COLUMN_SF, dc.getsF());
//
//        long newRowId;
//        newRowId = db.insert(
//                DeceasedChild.TABLE_NAME,
//                DeceasedChild.COLUMN_NAME_NULLABLE,
//                values);
//        return newRowId;
//    }


    public void updateSyncedForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SYNCED, true);
        values.put(FormsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateMWRAs(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MWRATable.COLUMN_SYNCED, true);
        values.put(MWRATable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = MWRATable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                MWRATable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

//    public void updateFamilyMember(String id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//// New value for one column
//        ContentValues values = new ContentValues();
//        values.put(familyMembers.COLUMN_SYNCED, true);
//        values.put(familyMembers.COLUMN_SYNCED_DATE, new Date().toString());
//
//// Which row to update, based on the title
//        String where = familyMembers.COLUMN_ID + " = ?";
//        String[] whereArgs = {id};
//
//        int count = db.update(
//                familyMembers.TABLE_NAME,
//                values,
//                where,
//                whereArgs);
//    }

//    public void updateDeceasedMother(String id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//// New value for one column
//        ContentValues values = new ContentValues();
//        values.put(DeceasedMother.COLUMN_SYNCED, true);
//        values.put(DeceasedMother.COLUMN_SYNCED_DATE, new Date().toString());
//
//// Which row to update, based on the title
//        String where = DeceasedMother.COLUMN_ID + " = ?";
//        String[] whereArgs = {id};
//
//        int count = db.update(
//                DeceasedMother.TABLE_NAME,
//                values,
//                where,
//                whereArgs);
//    }

//    public void updateDeceasedChild(String id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//// New value for one column
//        ContentValues values = new ContentValues();
//        values.put(DeceasedChild.COLUMN_SYNCED, true);
//        values.put(DeceasedChild.COLUMN_SYNCED_DATE, new Date().toString());
//
//// Which row to update, based on the title
//        String where = DeceasedChild.COLUMN_ID + " = ?";
//        String[] whereArgs = {id};
//
//        int count = db.update(
//                DeceasedChild.TABLE_NAME,
//                values,
//                where,
//                whereArgs);
//    }


//    public void updateIM(String id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//// New value for one column
//        ContentValues values = new ContentValues();
//        values.put(singleIm.COLUMN_SYNCED, true);
//        values.put(singleIm.COLUMN_SYNCED_DATE, new Date().toString());
//
//// Which row to update, based on the title
//        String where = singleIm.COLUMN_ID + " = ?";
//        String[] whereArgs = {id};
//
//        int count = db.update(
//                singleIm.TABLE_NAME,
//                values,
//                where,
//                whereArgs);
//    }

//    public int updateDeceasedMotherID() {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//// New value for one column
//        ContentValues values = new ContentValues();
//        values.put(DeceasedMother.COLUMN_UID, MainApp.dcM.get_UID());
//
//// Which row to update, based on the ID
//        String selection = DeceasedMother._ID + " = ?";
//        String[] selectionArgs = {String.valueOf(MainApp.dcM.get_ID())};
//
//        int count = db.update(DeceasedMother.TABLE_NAME,
//                values,
//                selection,
//                selectionArgs);
//        return count;
//    }


//    public int updateDeceasedChildID() {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//// New value for one column
//        ContentValues values = new ContentValues();
//        values.put(DeceasedChild.COLUMN_UID, MainApp.dcC.get_UID());
//
//// Which row to update, based on the ID
//        String selection = DeceasedChild._ID + " = ?";
//        String[] selectionArgs = {String.valueOf(MainApp.dcC.get_ID())};
//
//        int count = db.update(DeceasedChild.TABLE_NAME,
//                values,
//                selection,
//                selectionArgs);
//        return count;
//    }


    public int updateFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_UID, MainApp.fc.get_UID());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


//    public int updateFamilyMemberID() {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//// New value for one column
//        ContentValues values = new ContentValues();
//        values.put(familyMembers.COLUMN_UID, MainApp.fmc.get_UID());
//
//// Which row to update, based on the ID
//        String selection = familyMembers.COLUMN_ID + " = ?";
//        String[] selectionArgs = {String.valueOf(MainApp.fmc.get_ID())};
//
//        int count = db.update(familyMembers.TABLE_NAME,
//                values,
//                selection,
//                selectionArgs);
//        return count;
//    }

    public int updateMWRAID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MWRATable.COLUMN_UID, MainApp.mw.getUID());

// Which row to update, based on the ID
        String selection = MWRATable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.mw.get_ID())};

        int count = db.update(MWRATable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

//    public int updateChildID() {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//// New value for one column
//        ContentValues values = new ContentValues();
//        values.put(singleIm.COLUMN_UID, MainApp.ims.getUID());
//
//// Which row to update, based on the ID
//        String selection = singleIm.COLUMN_ID + " = ?";
//        String[] selectionArgs = {String.valueOf(MainApp.ims.get_ID())};
//
//        int count = db.update(singleIm.TABLE_NAME,
//                values,
//                selection,
//                selectionArgs);
//        return count;
//    }

    public Collection<FormsContract> getAllForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SA,
                FormsTable.COLUMN_SB,
                FormsTable.COLUMN_SC,
                FormsTable.COLUMN_SD,
                FormsTable.COLUMN_SE,
                FormsTable.COLUMN_SF,
                FormsTable.COLUMN_SG,
                FormsTable.COLUMN_SH,
                FormsTable.COLUMN_SI,
                FormsTable.COLUMN_SJ,
                FormsTable.COLUMN_SK,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_APPVERSION,
                FormsTable.COLUMN_FORMTYPE,

        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<FormsContract> checkFormExist() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SA,
                FormsTable.COLUMN_SB,
                FormsTable.COLUMN_SC,
                FormsTable.COLUMN_SD,
                FormsTable.COLUMN_SE,
                FormsTable.COLUMN_SF,
                FormsTable.COLUMN_SG,
                FormsTable.COLUMN_SH,
                FormsTable.COLUMN_SI,
                FormsTable.COLUMN_SJ,
                FormsTable.COLUMN_SK,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_APPVERSION,
                FormsTable.COLUMN_FORMTYPE,

        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public Collection<MWRAContract> getUnsyncedMWRA() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                MWRATable.COLUMN_ID,
                MWRATable.COLUMN_UID,
                MWRATable.COLUMN_UUID,
                MWRATable.COLUMN_FORMDATE,
                MWRATable.COLUMN_USER,
                MWRATable.COLUMN_SD,
                MWRATable.COLUMN_DEVICEID,
                MWRATable.COLUMN_DEVICETAGID
        };
        String whereClause = MWRATable.COLUMN_SYNCED + " is null";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                MWRATable.COLUMN_ID + " ASC";

        Collection<MWRAContract> allMC = new ArrayList<MWRAContract>();
        try {
            c = db.query(
                    MWRATable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                MWRAContract mc = new MWRAContract();
                allMC.add(mc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allMC;
    }


//    public Collection<SectionIIMContract> getUnsyncedIM() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor c = null;
//        String[] columns = {
//                singleIm.COLUMN_ID,
//                singleIm.COLUMN_UUID,
//                singleIm.COLUMN_UID,
//                singleIm.COLUMN_SI,
//                singleIm.COLUMN_FORMDATE,
//                singleIm.COLUMN_USER,
////                singleIm.COLUMN_CHILDID,
//                /*singleIm.COLUMN_MM,
//                singleIm.COLUMN_DSSID,*/
//                singleIm.COLUMN_DEVICETAGID,
//                singleIm.COLUMN_DEVICEID,
//                singleIm.COLUMN_ISTATUS
//
//        };
//        String whereClause = singleIm.COLUMN_SYNCED + " is null";
//        String[] whereArgs = null;
//        String groupBy = null;
//        String having = null;
//
//        String orderBy =
//                singleIm.COLUMN_ID + " ASC";
//
//        Collection<SectionIIMContract> allIM = new ArrayList<SectionIIMContract>();
//        try {
//            c = db.query(
//                    singleIm.TABLE_NAME,  // The table to query
//                    columns,                   // The columns to return
//                    whereClause,               // The columns for the WHERE clause
//                    whereArgs,                 // The values for the WHERE clause
//                    groupBy,                   // don't group the rows
//                    having,                    // don't filter by row groups
//                    orderBy                    // The sort order
//            );
//            while (c.moveToNext()) {
//                SectionIIMContract kIm = new SectionIIMContract();
//                allIM.add(kIm.Hydrate(c));
//            }
//        } finally {
//            if (c != null) {
//                c.close();
//            }
//            if (db != null) {
//                db.close();
//            }
//        }
//        return allIM;
//    }

//    public Collection<FamilyMembersContract> getUnsyncedFamilyMembers() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor c = null;
//        String[] columns = {
//                familyMembers.COLUMN_ID,
//                familyMembers.COLUMN_UID,
//                familyMembers.COLUMN_UUID,
//                familyMembers.COLUMN_FORMDATE,
//                familyMembers.COLUMN_DEVICEID,
//                familyMembers.COLUMN_USER,
//                familyMembers.COLUMN_SB,
//                familyMembers.COLUMN_SERIAL_NO,
//                familyMembers.COLUMN_DEVICETAGID
//        };
//        String whereClause = familyMembers.COLUMN_SYNCED + " is null";
//        String[] whereArgs = null;
//        String groupBy = null;
//        String having = null;
//
//        String orderBy =
//                familyMembers.COLUMN_ID + " ASC";
//
//        Collection<FamilyMembersContract> allCC = new ArrayList<FamilyMembersContract>();
//        try {
//            c = db.query(
//                    familyMembers.TABLE_NAME,  // The table to query
//                    columns,                   // The columns to return
//                    whereClause,               // The columns for the WHERE clause
//                    whereArgs,                 // The values for the WHERE clause
//                    groupBy,                   // don't group the rows
//                    having,                    // don't filter by row groups
//                    orderBy                    // The sort order
//            );
//            while (c.moveToNext()) {
//                FamilyMembersContract cc = new FamilyMembersContract();
//                allCC.add(cc.Hydrate(c));
//            }
//        } finally {
//            if (c != null) {
//                c.close();
//            }
//            if (db != null) {
//                db.close();
//            }
//        }
//        return allCC;
//    }

//    public Collection<DeceasedMotherContract> getUnsyncedDeceasedMother() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor c = null;
//        String[] columns = {
//                DeceasedMother.COLUMN_ID,
//                DeceasedMother.COLUMN_UID,
//                DeceasedMother.COLUMN_UUID,
//                DeceasedMother.COLUMN_FORMDATE,
//                DeceasedMother.COLUMN_DEVICEID,
//                DeceasedMother.COLUMN_USER,
//                DeceasedMother.COLUMN_SE,
//                DeceasedMother.COLUMN_DEVICETAGID
//
//        };
//        String whereClause = DeceasedMother.COLUMN_SYNCED + " is null";
//        //String whereClause = null;
//        String[] whereArgs = null;
//        String groupBy = null;
//        String having = null;
//
//        String orderBy =
//                DeceasedMother.COLUMN_ID + " ASC";
//
//        Collection<DeceasedMotherContract> allDC = new ArrayList<DeceasedMotherContract>();
//        try {
//            c = db.query(
//                    DeceasedMother.TABLE_NAME,  // The table to query
//                    columns,                   // The columns to return
//                    whereClause,               // The columns for the WHERE clause
//                    whereArgs,                 // The values for the WHERE clause
//                    groupBy,                   // don't group the rows
//                    having,                    // don't filter by row groups
//                    orderBy                    // The sort order
//            );
//            while (c.moveToNext()) {
//                DeceasedMotherContract dc = new DeceasedMotherContract();
//                allDC.add(dc.Hydrate(c));
//            }
//        } finally {
//            if (c != null) {
//                c.close();
//            }
//            if (db != null) {
//                db.close();
//            }
//        }
//        return allDC;
//    }


//    public Collection<DeceasedChildContract> getUnsyncedDeceasedChild() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor c = null;
//        String[] columns = {
//                DeceasedChild.COLUMN_ID,
//                DeceasedChild.COLUMN_UID,
//                DeceasedChild.COLUMN_UUID,
//                DeceasedChild.COLUMN_FORMDATE,
//                DeceasedChild.COLUMN_DEVICEID,
//                DeceasedChild.COLUMN_USER,
//                DeceasedChild.COLUMN_SF,
//                DeceasedChild.COLUMN_DEVICETAGID
//        };
//        String whereClause = DeceasedChild.COLUMN_SYNCED + " is null";
//        //String whereClause = null;
//        String[] whereArgs = null;
//        String groupBy = null;
//        String having = null;
//
//        String orderBy =
//                DeceasedChild.COLUMN_ID + " ASC";
//
//        Collection<DeceasedChildContract> allDC = new ArrayList<DeceasedChildContract>();
//        try {
//            c = db.query(
//                    DeceasedChild.TABLE_NAME,  // The table to query
//                    columns,                   // The columns to return
//                    whereClause,               // The columns for the WHERE clause
//                    whereArgs,                 // The values for the WHERE clause
//                    groupBy,                   // don't group the rows
//                    having,                    // don't filter by row groups
//                    orderBy                    // The sort order
//            );
//            while (c.moveToNext()) {
//                DeceasedChildContract dc = new DeceasedChildContract();
//                allDC.add(dc.Hydrate(c));
//            }
//        } finally {
//            if (c != null) {
//                c.close();
//            }
//            if (db != null) {
//                db.close();
//            }
//        }
//        return allDC;
//    }


    public Collection<FormsContract> getUnsyncedForms(String formType) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS88x,
                FormsTable.COLUMN_CODE_LHW,
                FormsTable.COLUMN_REF_ID,
                FormsTable.COLUMN_ENDINGDATETIME,
                FormsTable.COLUMN_SA,
                FormsTable.COLUMN_SB,
                FormsTable.COLUMN_SC,
                FormsTable.COLUMN_SD,
                FormsTable.COLUMN_SE,
                FormsTable.COLUMN_SF,
                FormsTable.COLUMN_SG,
                FormsTable.COLUMN_SH,
                FormsTable.COLUMN_SI,
                FormsTable.COLUMN_SJ,
                FormsTable.COLUMN_SK,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_APPVERSION,
                FormsTable.COLUMN_FORMTYPE
        };


        String whereClause = formType != null ? FormsTable.COLUMN_FORMTYPE + "=? AND " : "";
        whereClause += FormsTable.COLUMN_SYNCED + " is null";

        String[] whereArgs = formType != null ? new String[]{formType} : null;

        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<FormsContract> getTodayForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_FORMDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                fc.set_ID(c.getString(c.getColumnIndex(FormsTable.COLUMN_ID)));
                fc.setFormDate(c.getString(c.getColumnIndex(FormsTable.COLUMN_FORMDATE)));
                fc.setIstatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    // ANDROID DATABASE MANAGER
    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }


    public int updateSA() {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SA, MainApp.fc.getsA());

        String selection = FormsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSB() {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SB, MainApp.fc.getsB());

        String selection = FormsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSC() {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SC, MainApp.fc.getsC());

        String selection = FormsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSD() {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SD, MainApp.fc.getsD());

        String selection = FormsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSE() {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SE, MainApp.fc.getsE());

        String selection = FormsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSF() {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SF, MainApp.fc.getsF());

        String selection = FormsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSG() {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SG, MainApp.fc.getsG());

        String selection = FormsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSH() {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SH, MainApp.fc.getsH());

        String selection = FormsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_ISTATUS, MainApp.fc.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS88x, MainApp.fc.getIstatus88x());
        values.put(FormsTable.COLUMN_ENDINGDATETIME, MainApp.fc.getEndingdatetime());


// Which row to update, based on the ID
        String selection = FormsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


    public void syncLHWs(JSONArray dcList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(lhwEntry.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = dcList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectDistrict = jsonArray.getJSONObject(i);

                LHWContract dc = new LHWContract();
                dc.sync(jsonObjectDistrict);

                ContentValues values = new ContentValues();

                values.put(lhwEntry.COLUMN_TALUKA_CODE, dc.getTalukacode());
                values.put(lhwEntry.COLUMN_TALUKA_NAME, dc.getTalukaname());
                values.put(lhwEntry.COLUMN_UC_CODE, dc.getUccode());
                values.put(lhwEntry.COLUMN_UC_NAME, dc.getUcname());
                values.put(lhwEntry.COLUMN_LHW_CODE, dc.getLhwcode());
                values.put(lhwEntry.COLUMN_LHW_NAME, dc.getLhwname());

                db.insert(lhwEntry.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {

        }
    }


}