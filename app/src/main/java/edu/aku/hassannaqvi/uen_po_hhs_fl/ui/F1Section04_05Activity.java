package edu.aku.hassannaqvi.uen_po_hhs_fl.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF1Section0405Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;


public class F1Section04_05Activity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ActivityF1Section0405Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_f1_section04_05);
        bi.setCallback(this);
        this.setTitle("Command AND Control Centre");
        events_call();
    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Section 0405", Toast.LENGTH_SHORT).show();
                Intent ii = new Intent(this, F1Section06Activity.class);
                startActivity(ii);

                //MainApp.endActivity(this, this, Qoc2.class, true, RSDInfoActivity.fc);

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }


    }

    public boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.ll0405);
    }

    private void SaveDraft() throws JSONException {

        JSONObject s0405 = new JSONObject();

        s0405.put("pocfd01", bi.pocfd01a.isChecked() ? "1" : bi.pocfd01b.isChecked() ? "2" : "0");
        s0405.put("pocfd02", bi.pocfd02a.isChecked() ? "1" : bi.pocfd02b.isChecked() ? "2" : bi.pocfd02c.isChecked() ? "3" : bi.pocfd02d.isChecked() ? "4" : bi.pocfd0297.isChecked() ? "97" : "0");
        s0405.put("pocfd03", bi.pocfd03a.isChecked() ? "1" : bi.pocfd03b.isChecked() ? "2" : bi.pocfd03c.isChecked() ? "3" : bi.pocfd03d.isChecked() ? "4" : bi.pocfd03e.isChecked() ? "5" : bi.pocfd0396.isChecked() ? "96" : "0");
        s0405.put("pocfd0396x", bi.pocfd0396x.getText().toString());

        s0405.put("pocfe01", bi.pocfe01.getText().toString().trim().length() > 0 ? bi.pocfe01.getText().toString() : "0");
        s0405.put("pocfe02", bi.pocfe02.getText().toString().trim().length() > 0 ? bi.pocfe02.getText().toString() : "0");
        s0405.put("pocfe03", bi.pocfe02.getText().toString().trim().length() > 0 ? bi.pocfe03.getText().toString() : "0");
        s0405.put("pocfe04", bi.pocfe04a.isChecked() ? "1" : bi.pocfe04b.isChecked() ? "2" : bi.pocfe04c.isChecked() ? "3" : bi.pocfe0496.isChecked() ? "96" : "0");
        s0405.put("pocfe0496x", bi.pocfe0496x.getText().toString());
        s0405.put("pocfe05", bi.pocfe05a.isChecked() ? "1" : bi.pocfe05b.isChecked() ? "2" : "0");
        s0405.put("pocfe06", bi.pocfe06.getText().toString());
        s0405.put("pocfe07", bi.pocfe07a.isChecked() ? "1" : bi.pocfe07b.isChecked() ? "2" : bi.pocfe07c.isChecked() ? "3" : bi.pocfe07d.isChecked() ? "4" : bi.pocfe07e.isChecked() ? "5" : bi.pocfe07f.isChecked() ? "6" : bi.pocfe07g.isChecked() ? "7" : bi.pocfe07h.isChecked() ? "8" : bi.pocfe07i.isChecked() ? "9" : bi.pocfe07j.isChecked() ? "10" : bi.pocfe0796.isChecked() ? "96" : "0");
        s0405.put("pocfe0796x", bi.pocfe0796x.getText().toString());
        s0405.put("pocfe08", bi.pocfe08a.isChecked() ? "1" : bi.pocfe08b.isChecked() ? "2" : "0");
        s0405.put("pocfe09", bi.pocfe09a.isChecked() ? "1" : bi.pocfe09b.isChecked() ? "2" : "0");
        s0405.put("pocfe10", bi.pocfe10a.isChecked() ? "1" : bi.pocfe10b.isChecked() ? "2" : "0");
        s0405.put("pocfe11", bi.pocfe11.getText().toString());
        s0405.put("pocfe12", bi.pocfe12a.isChecked() ? "1" : bi.pocfe12b.isChecked() ? "2" : bi.pocfe12c.isChecked() ? "3" : "0");
        s0405.put("pocfe13", bi.pocfe13a.isChecked() ? "1" : bi.pocfe13b.isChecked() ? "2" : "0");
        s0405.put("pocfe14", bi.pocfe14.getText().toString());
        s0405.put("pocfe15", bi.pocfe15a.isChecked() ? "1" : bi.pocfe15b.isChecked() ? "2" : bi.pocfe15c.isChecked() ? "3" : "0");
        s0405.put("pocfe16", bi.pocfe16a.isChecked() ? "1" : bi.pocfe16b.isChecked() ? "2" : "0");
        s0405.put("pocfe17", bi.pocfe17.getText().toString());
        s0405.put("pocfe18", bi.pocfe18a.isChecked() ? "1" : bi.pocfe18b.isChecked() ? "2" : bi.pocfe18c.isChecked() ? "3" : "0");

        MainApp.fc.setsC(String.valueOf(s0405));
        //fc.setSqoc1(String.valueOf(s0405));

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        if (!bi.pocfd01a.isChecked()) {
            bi.pocfd02.clearCheck();
        }

        if (bi.pocfe04c.isChecked()) {
            bi.pocfe05.clearCheck();
            bi.pocfe06.setEnabled(false);
        } else {
            bi.pocfe06.setEnabled(true);
        }

        if (!bi.pocfe05a.isChecked()) {
            bi.pocfe06.setEnabled(false);
        } else {
            bi.pocfe06.setEnabled(true);
        }


        if (!bi.pocfe10a.isChecked()) {
            bi.pocfe11.setEnabled(false);
            bi.pocfe12.clearCheck();
        } else {
            bi.pocfe11.setEnabled(true);
        }

        if (!bi.pocfe13a.isChecked()) {
            bi.pocfe14.setEnabled(false);
            bi.pocfe15.clearCheck();
        } else {
            bi.pocfe14.setEnabled(true);
        }

        if (!bi.pocfe16a.isChecked()) {
            bi.pocfe17.setEnabled(false);
            bi.pocfe18.clearCheck();
        } else {
            bi.pocfe17.setEnabled(true);
        }
    }

    void events_call() {

        bi.pocfd01.setOnCheckedChangeListener(this);
        bi.pocfe04.setOnCheckedChangeListener(this);
        bi.pocfe05.setOnCheckedChangeListener(this);
        bi.pocfe10.setOnCheckedChangeListener(this);
        bi.pocfe13.setOnCheckedChangeListener(this);
        bi.pocfe16.setOnCheckedChangeListener(this);

    }

}


