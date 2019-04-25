package edu.aku.hassannaqvi.uen_po_hhs_fl.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF2Section02Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;

public class F2Section02Activity extends AppCompatActivity {

    ActivityF2Section02Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        bi = DataBindingUtil.setContentView(this, R.layout.activity_f2_section02);
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete",true));
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

        JSONObject f02 = new JSONObject();
        f02.put("pofpb01", bi.pofpb01a.isChecked() ? "1"
                : bi.pofpb01b.isChecked() ? "2" : "0");
        f02.put("pofpb02", bi.pofpb02a.isChecked() ? "1"
                : bi.pofpb02b.isChecked() ? "2" : "0");

        f02.put("pofpb02a", bi.pofpb02a01.getText().toString());
        f02.put("pofpb02b", bi.pofpb02a02.getText().toString());

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
        f02.put("pofpb0798", bi.pofpb0798.isChecked() ? "98" : "0");

        f02.put("pofpb08", bi.pofpb08a.isChecked() ? "1"
                : bi.pofpb08b.isChecked() ? "2"
                : bi.pofpb08c.isChecked() ? "3"
                : bi.pofpb08d.isChecked() ? "4"
                : bi.pofpb08e.isChecked() ? "5"
                : bi.pofpb08f.isChecked() ? "6"
                : bi.pofpb08g.isChecked() ? "7"
                : bi.pofpb08h.isChecked() ? "8"
                : "0");

    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.f2Section02);
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
