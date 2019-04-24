package edu.aku.hassannaqvi.uen_po_hhs_fl.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF1Section11Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;

public class F1Section11Activity extends AppCompatActivity {

    ActivityF1Section11Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_f1_section11);
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
        JSONObject sK = new JSONObject();

        sK.put("pocfk01", bi.pocfk01a.isChecked() ? "1"
                : bi.pocfk01b.isChecked() ? "2"
                : bi.pocfk01c.isChecked() ? "3"
                : bi.pocfk0196.isChecked() ? "96" : "0");

        sK.put("pocfk0196x", bi.pocfk0196x.getText().toString());

        sK.put("pocfk02", bi.pocfk02a.isChecked() ? "1"
                : bi.pocfk02b.isChecked() ? "2"
                : "0");
        sK.put("pocfk03", bi.pocfk03a.isChecked() ? "1"
                : bi.pocfk03b.isChecked() ? "2"
                : "0");
        sK.put("pocfk03a01", bi.pocfk03a01.getText().toString());
        sK.put("pocfk03a02", bi.pocfk03a02.getText().toString());

        sK.put("pocfk04", bi.pocfk04a.isChecked() ? "1"
                : bi.pocfk04b.isChecked() ? "2"
                : "0");

        sK.put("pocfk05a", bi.pocfk05a.getText().toString());
        sK.put("pocfk05b", bi.pocfk05b.getText().toString());

        sK.put("pocfk06", bi.pocfk06a.isChecked() ? "1"
                : bi.pocfk06b.isChecked() ? "2"
                : "0");
        sK.put("pocfk07", bi.pocfk07a.isChecked() ? "1"
                : bi.pocfk07b.isChecked() ? "2"
                : "0");
        sK.put("pocfk08", bi.pocfk08a.isChecked() ? "1"
                : bi.pocfk08b.isChecked() ? "2"
                : bi.pocfk08c.isChecked() ? "3"
                : bi.pocfk08d.isChecked() ? "4"
                : bi.pocfk0898.isChecked() ? "98"
                : "0");
        sK.put("pocfk09", bi.pocfk09a.isChecked() ? "1"
                : bi.pocfk09b.isChecked() ? "2"
                : bi.pocfk09c.isChecked() ? "3"
                : bi.pocfk09d.isChecked() ? "4"
                : bi.pocfk09e.isChecked() ? "5"
                : "0");

        sK.put("pocfk10", bi.pocfk10a.isChecked() ? "1"
                : bi.pocfk10b.isChecked() ? "2"
                : "0");
        sK.put("pocfk11", bi.pocfk11a.isChecked() ? "1"
                : bi.pocfk11b.isChecked() ? "2"
                : bi.pocfk1196.isChecked() ? "96"
                : "0");
        sK.put("pocfk1196x", bi.pocfk1196x.getText().toString());

        sK.put("pocfk12", bi.pocfk12a.isChecked() ? "1"
                : bi.pocfk12b.isChecked() ? "2"
                : "0");
        sK.put("pocfk13", bi.pocfk13a.isChecked() ? "1"
                : bi.pocfk13b.isChecked() ? "2"
                : "0");

    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.ll11);
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
        super.onBackPressed();

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
