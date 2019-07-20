package edu.aku.hassannaqvi.uen_po_hhs_fl.ui.form2;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF2Section02Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ClearClass;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;

public class F2Section02Activity extends AppCompatActivity {

    ActivityF2Section02Binding bi;
    String DAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_f2_section02);
        bi.setCallback(this);

        DAY = getIntent().getStringExtra("day");
        this.setTitle(DAY.equals("7") ? "Form 02 (Follow Ups - 7 Day)" : "Form 02 (Follow Ups - 14 Day)");
        settingListeners();

    }

    private void settingListeners() {

        bi.pofpb0797.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.fldgrppofpb07, false);
                    bi.fldgrppofpb07.setTag("-1");
                } else {
                    ClearClass.ClearAllFields(bi.fldgrppofpb07, true);
                    bi.fldgrppofpb07.setTag("0");
                }
            }
        });


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
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject f02 = new JSONObject();

        f02.put("pofpb01", bi.pofpb01a.isChecked() ? "1"
                : bi.pofpb01b.isChecked() ? "2"
                : "0");

        f02.put("pofpb02a", bi.pofpb02a.getText().toString());
        f02.put("pofpb02b", bi.pofpb02a.getText().toString());

        f02.put("pofpb021", bi.pofpb021a.isChecked() ? "1"
                : bi.pofpb021b.isChecked() ? "2"
                : "0");

        f02.put("pofpb03", bi.pofpb03a.isChecked() ? "1"
                : bi.pofpb03b.isChecked() ? "2"
                : "0");

        f02.put("pofpb04a", bi.pofpb04a.getText().toString());
        f02.put("pofpb04b", bi.pofpb04b.getText().toString());

        f02.put("pofpb05", bi.pofpb05a.isChecked() ? "1"
                : bi.pofpb05b.isChecked() ? "2"
                : "0");

        f02.put("pofpb06", bi.pofpb06a.isChecked() ? "1"
                : bi.pofpb06b.isChecked() ? "2"
                : "0");

        f02.put("pofpb07a", bi.pofpb07a.isChecked() ? "1" : "0");
        f02.put("pofpb07b", bi.pofpb07b.isChecked() ? "2" : "0");
        f02.put("pofpb07c", bi.pofpb07c.isChecked() ? "3" : "0");
        f02.put("pofpb07d", bi.pofpb07d.isChecked() ? "4" : "0");
        f02.put("pofpb0797", bi.pofpb0797.isChecked() ? "97" : "0");

        f02.put("pofpb08", bi.pofpb08a.isChecked() ? "1"
                : bi.pofpb08b.isChecked() ? "2"
                : bi.pofpb08c.isChecked() ? "3"
                : "0");

        MainApp.fc.setsB(String.valueOf(f02));
    }

    private boolean formValidation() {

        if (!ValidatorClass.EmptyCheckingContainer(this, bi.f2Section02))
            return false;

        if (Integer.parseInt(bi.pofpb04b.getText().toString().trim()) >= 92 && bi.pofpb05a.isChecked()) {
            return ValidatorClass.EmptyCustomeTextBox(this, bi.pofpb04b, "please check below question!!");
        }

        if (Integer.parseInt(bi.pofpb04b.getText().toString().trim()) < 92 && bi.pofpb05b.isChecked()) {
            return ValidatorClass.EmptyCustomeTextBox(this, bi.pofpb04b, "please check below question!!");
        }

        return true;

    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
