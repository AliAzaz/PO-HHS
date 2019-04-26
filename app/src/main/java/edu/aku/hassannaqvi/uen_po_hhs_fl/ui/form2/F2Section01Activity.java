package edu.aku.hassannaqvi.uen_po_hhs_fl.ui.form2;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF2Section01Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ClearClass;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;

public class F2Section01Activity extends AppCompatActivity {

    ActivityF2Section01Binding bi;
    String DAY;
    DatabaseHelper db;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_f2_section01);
        bi.setCallback(this);

        DAY = getIntent().getStringExtra("day");
        bi.dayHeading.setText("DAY " + (DAY.equals("7") ? "07" : "14"));

        db = new DatabaseHelper(this);

        clickListener();
    }

    private void clickListener() {
        bi.checkHHBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bi.f2Section01.setVisibility(View.VISIBLE);
                ClearClass.ClearAllFields(bi.f2Section01, true);
            }
        });

        bi.pofpa00.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                bi.f2Section01.setVisibility(View.GONE);
                ClearClass.ClearAllFields(bi.f2Section01, false);
            }

            @Override
            public void afterTextChanged(Editable s) {

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
                startActivity(new Intent(this, F2Section02Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {
        long updcount = db.addForm(MainApp.fc);

        MainApp.fc.set_ID(String.valueOf(updcount));
        if (updcount != 0) {
            MainApp.fc.set_UID(
                    (MainApp.fc.getDeviceID() + MainApp.fc.get_ID()));
            db.updateFormID();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        MainApp.fc = new FormsContract();
        MainApp.fc.setDeviceID(MainApp.deviceId);
        MainApp.fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.fc.setFormType(MainApp.formtype);
        MainApp.fc.setFormDate(dtToday);
        MainApp.fc.setDevicetagID(getSharedPreferences("tagName", MODE_PRIVATE).getString("tagName", ""));

        JSONObject f02 = new JSONObject();
        f02.put("pofp_survey", DAY);
        f02.put("pofpa00", bi.pofpa00.getText().toString());
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

        MainApp.fc.setsA(String.valueOf(f02));
        MainApp.setGPS(this);

    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.f2Section01);
    }

    public void BtnEnd() {

        if (!ValidatorClass.EmptyTextBox(this, bi.pofpa00, getString(R.string.pocfa06))) return;

        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }

}
