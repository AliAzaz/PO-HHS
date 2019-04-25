package edu.aku.hassannaqvi.uen_po_hhs_fl.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF2Section01Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;

public class F2Section01Activity extends AppCompatActivity {


    ActivityF2Section01Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f2_section01);

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

        JSONObject f02 = new JSONObject();
        f02.put("pofpa01", bi.pofpa01.getText().toString());
        f02.put("pofpa02", bi.pofpa02a.isChecked() ? "1"
                : bi.pofpa02b.isChecked() ? "2"
                : bi.pofpa02c.isChecked() ? "3"
                : bi.pofpa02d.isChecked() ? "4"
                : bi.pofpa0296.isChecked() ? "96" : "0"
        );

        f02.put("pofpa0296x", bi.pofpa0296x.getText().toString());
        f02.put("pofpa03", bi.pofpa03.getText().toString());
        f02.put("pofpa04", bi.pofpa04a.isChecked() ? "1"
                : bi.pofpa04b.isChecked() ? "2"
                : "0"
        );
        f02.put("pofpa05a", bi.pofpa05a.isChecked() ? bi.pofpa05ax.getText().toString() : "0");
        f02.put("pofpa05b", bi.pofpa05b.isChecked() ? bi.pofpa05bx.getText().toString() : "0");
        f02.put("pofpa05c", bi.pofpa05b.isChecked() ? "1" : "0");

        f02.put("pofpa06a", bi.pofpa06a.isChecked() ? bi.pofpa06ax.getText().toString() : "0");
        f02.put("pofpa06b", bi.pofpa06b.isChecked() ? bi.pofpa06bx.getText().toString() : "0");

        f02.put("pofpa07", bi.pofpa07a.isChecked() ? "1"
                : bi.pofpa07b.isChecked() ? "2"
                : bi.pofpa07c.isChecked() ? "3"
                : bi.pofpa07d.isChecked() ? "4"
                : bi.pofpa07e.isChecked() ? "5" : "0"
        );

        f02.put("pofpa08a", bi.pofpa08a.isChecked() ? "1" : "0");
        f02.put("pofpa08b", bi.pofpa08b.isChecked() ? "2" : "0");
        f02.put("pofpa08c", bi.pofpa08c.isChecked() ? "3" : "0");
        f02.put("pofpa0896", bi.pofpa0896.isChecked() ? "96" : "0");

        f02.put("pofpa0896x", bi.pofpa0896x.getText().toString());
        f02.put("pofpa09", bi.pofpa09a.isChecked() ? "1"
                : bi.pofpa09b.isChecked() ? "2"
                : "0");
        f02.put("pofpa09ax", bi.pofpa09ax.getText().toString());

        f02.put("pofpa10", bi.pofpa10a.isChecked() ? "1"
                : bi.pofpa10b.isChecked() ? "2"
                : bi.pofpa10c.isChecked() ? "3"
                : bi.pofpa1096.isChecked() ? "96"
                : "0"
        );
        f02.put("pofpa1096x", bi.pofpa1096x.getText().toString());
        f02.put("pofpa11a", bi.pofpa11a.getText().toString());
        f02.put("pofpa11b", bi.pofpa11b.getText().toString());
        f02.put("pofpa11c", bi.pofpa11c.getText().toString());
        f02.put("pofpa11d", bi.pofpa11d.getText().toString());


    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.f2Section01);
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
