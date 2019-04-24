package edu.aku.hassannaqvi.uen_po_hhs_fl.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF1Section0910Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;

public class F1Section09_10Activity extends AppCompatActivity {

    ActivityF1Section0910Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f1_section09_10);
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
        JSONObject sIJ = new JSONObject();

        sIJ.put("pocfi01", bi.pocfi01a.isChecked() ? "1"
                : bi.pocfi01b.isChecked() ? "2" : "0");

        sIJ.put("pocfi02", bi.pocfi02a.isChecked() ? "1"
                : bi.pocfi02b.isChecked() ? "2" : "0");

        sIJ.put("pocfj01", bi.pocfj01a.isChecked() ? "1"
                : bi.pocfj01b.isChecked() ? "2"
                : bi.pocfj01c.isChecked() ? "3"
                : bi.pocfj01d.isChecked() ? "4"
                : bi.pocfj01e.isChecked() ? "5"
                : bi.pocfj01f.isChecked() ? "6"
                : bi.pocfj01g.isChecked() ? "7"
                : bi.pocfj01h.isChecked() ? "8"
                : bi.pocfj01i.isChecked() ? "9"
                : bi.pocfj01j.isChecked() ? "10"
                : bi.pocfj01k.isChecked() ? "11"
                : bi.pocfj01l.isChecked() ? "12"
                : bi.pocfj01m.isChecked() ? "13"
                : bi.pocfj01n.isChecked() ? "14"
                : bi.pocfj0196.isChecked() ? "96"
                : "0");

        sIJ.put("pocfj0196x", bi.pocfj0196x.getText().toString());
        sIJ.put("pocfj0198", bi.pocfj0198.isChecked() ? "98" : "0");

        sIJ.put("pocfj02", bi.pocfj02a.isChecked() ? "1"
                : bi.pocfj02b.isChecked() ? "2" : "0");
    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.ll0910);
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
