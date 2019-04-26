package edu.aku.hassannaqvi.uen_po_hhs_fl.ui.form1;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF1Section06Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;

public class F1Section06Activity extends AppCompatActivity {

    ActivityF1Section06Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_f1_section06);
        bi.setCallback(this);
        this.setTitle(R.string.pocfh6);

    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, F1Section07Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSD();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {
        JSONObject sF = new JSONObject();

        sF.put("pocff01", bi.pocff01a.isChecked() ? "1"
                : bi.pocff01b.isChecked() ? "2"
                : bi.pocff01d.isChecked() ? "3"
                : bi.pocff01e.isChecked() ? "4"
                : bi.pocff0196.isChecked() ? "96" : "0");


        sF.put("pocff02", bi.pocff02a.isChecked() ? "1"
                : bi.pocff02b.isChecked() ? "2"
                : bi.pocff02d.isChecked() ? "3"
                : bi.pocff02e.isChecked() ? "4"
                : bi.pocff02f.isChecked() ? "5"
                : bi.pocff02g.isChecked() ? "6"
                : bi.pocff02h.isChecked() ? "7"
                : bi.pocff02i.isChecked() ? "8"
                : bi.pocff02j.isChecked() ? "9"
                : bi.pocff02k.isChecked() ? "10"
                : bi.pocff02l.isChecked() ? "11"
                : bi.pocff02m.isChecked() ? "12"
                : "0");
        sF.put("pocff02gx", bi.pocff02gx.getText().toString());
        sF.put("pocff02kx", bi.pocff02kx.getText().toString());
        sF.put("pocff02mx", bi.pocff02mx.getText().toString());

        sF.put("pocff03", bi.pocff03a.isChecked() ? "1"
                : bi.pocff03b.isChecked() ? "2"
                : "0");
        sF.put("pocff04", bi.pocff04a.isChecked() ? "1"
                : bi.pocff04b.isChecked() ? "2"
                : bi.pocff04c.isChecked() ? "3"
                : bi.pocff04d.isChecked() ? "4"
                : "0");

        sF.put("pocff05", bi.pocff05a.isChecked() ? "1"
                : bi.pocff05b.isChecked() ? "2"
                : bi.pocff05d.isChecked() ? "3"
                : bi.pocff05e.isChecked() ? "4"
                : bi.pocff0598.isChecked() ? "98"
                : "0");

        sF.put("pocff06", bi.pocff06a.isChecked() ? "1"
                : bi.pocff06b.isChecked() ? "2"
                : "0");

        sF.put("pocff07", bi.pocff07a.isChecked() ? "1"
                : bi.pocff07b.isChecked() ? "2"
                : bi.pocff0798.isChecked() ? "98"
                : "0");
        sF.put("pocff07ax", bi.pocff07ax.getText().toString());
        sF.put("pocff07bx", bi.pocff07bx.getText().toString());

        sF.put("pocff08", bi.pocff08a.isChecked() ? "1"
                : bi.pocff08b.isChecked() ? "2"
                : bi.pocff08c.isChecked() ? "3"
                : bi.pocff08d.isChecked() ? "4"
                : "0");
        sF.put("pocff09", bi.pocff09.getText().toString());

        sF.put("pocff10", bi.pocff10a.isChecked() ? "1"
                : bi.pocff10b.isChecked() ? "2"
                : bi.pocff10c.isChecked() ? "3"
                : bi.pocff10d.isChecked() ? "4"
                : "0");
        sF.put("pocff11", bi.pocff11.getText().toString());

        MainApp.fc.setsD(String.valueOf(sF));


    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.ll06);
    }

    public void BtnEnd() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting 2nd Section", Toast.LENGTH_SHORT).show();
//                MainApp.endActivity(this, this, Qoc2.class, true, RSDInfoActivity.fc);

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
