package edu.aku.hassannaqvi.uen_po_hhs_fl.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF1Section07Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;

public class F1Section07Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    ActivityF1Section07Binding bi;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_f1_section07);

        this.setTitle(getResources().getString(R.string.nc3heading));

        db = new DatabaseHelper(this);
        bi.setCallback(this);

        bi.nc3bcgdt98.setOnCheckedChangeListener(this);
        bi.nc3opv0dt98.setOnCheckedChangeListener(this);
        bi.nc3opv1dt98.setOnCheckedChangeListener(this);
        bi.nc3p1dt98.setOnCheckedChangeListener(this);
        bi.nc3pcv1dt98.setOnCheckedChangeListener(this);
        bi.nc3opv2dt98.setOnCheckedChangeListener(this);
        bi.nc3p2dt98.setOnCheckedChangeListener(this);
        bi.nc3pcv2dt98.setOnCheckedChangeListener(this);
        bi.nc3opv3dt98.setOnCheckedChangeListener(this);
        bi.nc3p3dt98.setOnCheckedChangeListener(this);
        bi.nc3pcv3dt98.setOnCheckedChangeListener(this);
        bi.nc3ipvdt98.setOnCheckedChangeListener(this);
        bi.nc3m1dt98.setOnCheckedChangeListener(this);
        bi.nc3m2dt98.setOnCheckedChangeListener(this);

        bi.nc302.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != bi.nc302b.getId())
                    bi.nc302.clearCheck();
            }
        });
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, F1Section08Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpnc30A);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }

    private void SaveDraft() throws JSONException {

        JSONObject sG = new JSONObject();

//        nc301
        sG.put("nc301", bi.nc301a.isChecked() ? "1"
                : bi.nc301b.isChecked() ? "2"
                : "0");

//        nc302
        sG.put("nc302", bi.nc302a.isChecked() ? "1"
                : bi.nc302b.isChecked() ? "2"
                : bi.nc302c.isChecked() ? "3"
                : bi.nc302d.isChecked() ? "4"
                : "0");
//at birth
//          nc3bcg
        sG.put("nc3bcg", bi.nc3bcga.isChecked() ? "1"
                : bi.nc3bcgb.isChecked() ? "2"
                : bi.nc3bcg97.isChecked() ? "97"
                : "0");

//          nc3opv0
        sG.put("nc3opv0", bi.nc3opv0a.isChecked() ? "1"
                : bi.nc3opv0b.isChecked() ? "2"
                : bi.nc3opv097.isChecked() ? "97"
                : "0");
        sG.put("nc3opv0dt98", bi.nc3opv0dt98.isChecked() ? "1" : "0");
        sG.put("nc3opv0dt", bi.nc3opv0dt.getText().toString());

//       at age of 6

//          nc3opv1
        sG.put("nc3opv1", bi.nc3opv1a.isChecked() ? "1"
                : bi.nc3opv1b.isChecked() ? "2"
                : bi.nc3opv197.isChecked() ? "97"
                : "0");

//          nc3p1
        sG.put("nc3p1", bi.nc3p1a.isChecked() ? "1"
                : bi.nc3p1b.isChecked() ? "2"
                : bi.nc3p197.isChecked() ? "97"
                : "0");

//          nc3pcv1
        sG.put("nc3pcv1", bi.nc3pcv1a.isChecked() ? "1"
                : bi.nc3pcv1b.isChecked() ? "2"
                : bi.nc3pcv197.isChecked() ? "97"
                : "0");

//       at age of 10 weeks

//          nc3opv2
        sG.put("nc3opv2", bi.nc3opv2a.isChecked() ? "1"
                : bi.nc3opv2b.isChecked() ? "2"
                : bi.nc3opv297.isChecked() ? "97"
                : "0");

//          nc3p2
        sG.put("nc3p2", bi.nc3p2a.isChecked() ? "1"
                : bi.nc3p2b.isChecked() ? "2"
                : bi.nc3p297.isChecked() ? "97"
                : "0");

//          nc3pcv2
        sG.put("nc3pcv2", bi.nc3pcv2a.isChecked() ? "1"
                : bi.nc3pcv2b.isChecked() ? "2"
                : bi.nc3pcv297.isChecked() ? "97"
                : "0");

//       at age of 14 weeks

//          nc3opv3
        sG.put("nc3opv3", bi.nc3opv3a.isChecked() ? "1"
                : bi.nc3opv3b.isChecked() ? "2"
                : bi.nc3opv397.isChecked() ? "97"
                : "0");

//          nc3p3
        sG.put("nc3p3", bi.nc3p3a.isChecked() ? "1"
                : bi.nc3p3b.isChecked() ? "2"
                : bi.nc3p397.isChecked() ? "97"
                : "0");

//          nc3pcv3
        sG.put("nc3pcv3", bi.nc3pcv3a.isChecked() ? "1"
                : bi.nc3pcv3b.isChecked() ? "2"
                : bi.nc3pcv397.isChecked() ? "97"
                : "0");

//          nc3ipv
        sG.put("nc3ipv", bi.nc3ipva.isChecked() ? "1"
                : bi.nc3ipvb.isChecked() ? "2"
                : bi.nc3ipv97.isChecked() ? "97"
                : "0");

//at the age of 9 months
//          nc3m1
        sG.put("nc3m1", bi.nc3m1a.isChecked() ? "1"
                : bi.nc3m1b.isChecked() ? "2"
                : bi.nc3m197.isChecked() ? "97"
                : "0");

//at age of 15 months
//          nc3m2
        sG.put("nc3m2", bi.nc3m2a.isChecked() ? "1"
                : bi.nc3m2b.isChecked() ? "2"
                : bi.nc3m297.isChecked() ? "97"
                : "0");

        MainApp.fc.setsG(String.valueOf(sG));

    }

    private boolean UpdateDB() {

        return true;

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if (compoundButton.isChecked()) {
            bi.nc3bcgdt.setText(null);
            bi.nc3bcgdt.setEnabled(false);
            return;
        } else {
            bi.nc3bcgdt.setEnabled(true);
            bi.nc3bcgdt.setError(null);
            return;
        }

    }
}