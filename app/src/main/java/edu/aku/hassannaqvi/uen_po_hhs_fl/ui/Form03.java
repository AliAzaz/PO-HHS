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
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityForm03Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;


public class Form03 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ActivityForm03Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form03);
        bi.setCallback(this);
        this.setTitle("Form Three 03");
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
                Toast.makeText(this, "Starting Form 03", Toast.LENGTH_SHORT).show();
                Intent ii = new Intent(this, Section06Activity.class);
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
        /*try {
            Long longID = new crudOperations(db, RSDInfoActivity.fc).execute(FormsDAO.class.getName(), "formsDao", "updateForm").get();
            return longID == 1;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        return true;

    }

    public boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.llform03);
    }

    private void SaveDraft() throws JSONException {

        JSONObject form03 = new JSONObject();

        form03.put("pocfd01", bi.pocfd01a.isChecked() ? "1" : bi.pocfd01b.isChecked() ? "2" : "0");
        form03.put("pocfd02", bi.pocfd02a.isChecked() ? "1" : bi.pocfd02b.isChecked() ? "2" : bi.pocfd02c.isChecked() ? "3" : bi.pocfd02d.isChecked() ? "4" : bi.pocfd0297.isChecked() ? "97" : "0");
        form03.put("pocfd03", bi.pocfd03a.isChecked() ? "1" : bi.pocfd03b.isChecked() ? "2" : bi.pocfd03c.isChecked() ? "3" : bi.pocfd03d.isChecked() ? "4" : bi.pocfd03e.isChecked() ? "5" : bi.pocfd0396.isChecked() ? "96" : "0");
        form03.put("pocfd0396x", bi.pocfd0396x.getText().toString());

        form03.put("pocfe01", bi.pocfe01.getText().toString().trim().length() > 0 ? bi.pocfe01.getText().toString() : "0");
        form03.put("pocfe02", bi.pocfe02.getText().toString().trim().length() > 0 ? bi.pocfe02.getText().toString() : "0");
        form03.put("pocfe03", bi.pocfe02.getText().toString().trim().length() > 0 ? bi.pocfe03.getText().toString() : "0");
        form03.put("pocfe04", bi.pocfe04a.isChecked() ? "1" : bi.pocfe04b.isChecked() ? "2" : bi.pocfe04c.isChecked() ? "3" : bi.pocfe0496.isChecked() ? "96" : "0");
        form03.put("pocfe0496x", bi.pocfe0496x.getText().toString());
        form03.put("pocfe05", bi.pocfe05a.isChecked() ? "1" : bi.pocfe05b.isChecked() ? "2" : "0");
        form03.put("pocfe06", bi.pocfe06.getText().toString());
        form03.put("pocfe07", bi.pocfe07a.isChecked() ? "1" : bi.pocfe07b.isChecked() ? "2" : bi.pocfe07c.isChecked() ? "3" : bi.pocfe07d.isChecked() ? "4" : bi.pocfe07e.isChecked() ? "5" : bi.pocfe07f.isChecked() ? "6" : bi.pocfe07g.isChecked() ? "7" : bi.pocfe07h.isChecked() ? "8" : bi.pocfe07i.isChecked() ? "9" : bi.pocfe07j.isChecked() ? "10" : bi.pocfe0796.isChecked() ? "96" : "0");
        form03.put("pocfe0796x", bi.pocfe0796x.getText().toString());
        form03.put("pocfe08", bi.pocfe08a.isChecked() ? "1" : bi.pocfe08b.isChecked() ? "2" : "0");
        form03.put("pocfe09", bi.pocfe09a.isChecked() ? "1" : bi.pocfe09b.isChecked() ? "2" : "0");
        form03.put("pocfe10", bi.pocfe10a.isChecked() ? "1" : bi.pocfe10b.isChecked() ? "2" : "0");
        form03.put("pocfe11", bi.pocfe11.getText().toString());
        form03.put("pocfe12", bi.pocfe12a.isChecked() ? "1" : bi.pocfe12b.isChecked() ? "2" : bi.pocfe12c.isChecked() ? "3" : "0");
        form03.put("pocfe13", bi.pocfe13a.isChecked() ? "1" : bi.pocfe13b.isChecked() ? "2" : "0");
        form03.put("pocfe14", bi.pocfe14.getText().toString());
        form03.put("pocfe15", bi.pocfe15a.isChecked() ? "1" : bi.pocfe15b.isChecked() ? "2" : bi.pocfe15c.isChecked() ? "3" : "0");
        form03.put("pocfe16", bi.pocfe16a.isChecked() ? "1" : bi.pocfe16b.isChecked() ? "2" : "0");
        form03.put("pocfe17", bi.pocfe17.getText().toString());
        form03.put("pocfe18", bi.pocfe18a.isChecked() ? "1" : bi.pocfe18b.isChecked() ? "2" : bi.pocfe18c.isChecked() ? "3" : "0");

        //fc.setSqoc1(String.valueOf(form03));

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


