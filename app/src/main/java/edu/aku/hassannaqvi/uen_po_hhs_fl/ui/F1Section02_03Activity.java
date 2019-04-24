package edu.aku.hassannaqvi.uen_po_hhs_fl.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF1Section0203Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;

public class F1Section02_03Activity extends AppCompatActivity {

    ActivityF1Section0203Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f1_section02_03);
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
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

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {
        JSONObject sBC = new JSONObject();

        sBC.put("pocfb01", bi.pocfb01.getText().toString());
        sBC.put("pocfb02", bi.pocfb02.getText().toString());
        sBC.put("pocfb03a", bi.pocfb03a.getText().toString());
        sBC.put("pocfb03b", bi.pocfb03b.getText().toString());
        sBC.put("pocfb04a", bi.pocfb04a.getText().toString());
        sBC.put("pocfb04b", bi.pocfb04b.getText().toString());
        sBC.put("pocfb05", bi.pocfb05.getText().toString());

        sBC.put("pocfc01", bi.pocfc01a.isChecked() ? "1"
                : bi.pocfc01b.isChecked() ? "2"
                : bi.pocfc01c.isChecked() ? "3"
                : bi.pocfc01d.isChecked() ? "4"
                : bi.pocfc01e.isChecked() ? "5"
                : bi.pocfc01f.isChecked() ? "6"
                : bi.pocfc0196.isChecked() ? "96" : "0");
        sBC.put("pocfc0196x", bi.pocfc0196x.getText().toString());

        sBC.put("pocfc02", bi.pocfc02a.isChecked() ? "1"
                : bi.pocfc02b.isChecked() ? "2"
                : bi.pocfc02c.isChecked() ? "3"
                : bi.pocfc02d.isChecked() ? "4"
                : bi.pocfc02e.isChecked() ? "5"
                : bi.pocfc02f.isChecked() ? "6"
                : bi.pocfc02g.isChecked() ? "7"
                : bi.pocfc0296.isChecked() ? "96" : "0");
        sBC.put("pocfc0296x", bi.pocfc0296x.getText().toString());

        sBC.put("pocfc03", bi.pocfc03a.isChecked() ? "1"
                : bi.pocfc03b.isChecked() ? "2"
                : "0");
        sBC.put("pocfc04", bi.pocfc04a.isChecked() ? "1"
                : bi.pocfc04b.isChecked() ? "2"
                : "0");
        sBC.put("pocfc05", bi.pocfc05a.isChecked() ? "1"
                : bi.pocfc05b.isChecked() ? "2"
                : "0");
        sBC.put("pocfc06", bi.pocfc06a.isChecked() ? "1"
                : bi.pocfc06b.isChecked() ? "2"
                : "0");
        sBC.put("pocfc07", bi.pocfc07a.isChecked() ? "1"
                : bi.pocfc07b.isChecked() ? "2"
                : "0");
        sBC.put("pocfc08", bi.pocfc08a.isChecked() ? "1"
                : bi.pocfc08b.isChecked() ? "2"
                : "0");
        sBC.put("pocfc09", bi.pocfc09a.isChecked() ? "1"
                : bi.pocfc09b.isChecked() ? "2"
                : "0");
        sBC.put("pocfc10", bi.pocfc10a.isChecked() ? "1"
                : bi.pocfc10b.isChecked() ? "2"
                : "0");
        sBC.put("pocfc10ax", bi.pocfc10ax.getText().toString());

        sBC.put("pocfc11", !bi.pocfc1198.isChecked() ? bi.pocfc11.getText().toString() : "98");

        sBC.put("pocfc12", bi.pocfc12.getText().toString());


    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.ll0203);
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
