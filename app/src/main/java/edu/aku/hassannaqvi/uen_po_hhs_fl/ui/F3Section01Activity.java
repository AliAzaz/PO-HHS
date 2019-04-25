package edu.aku.hassannaqvi.uen_po_hhs_fl.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF3Section01Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;


public class F3Section01Activity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ActivityF3Section01Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_f3_section01);
        bi.setCallback(this);
        this.setTitle("F3 Section 01");
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
                Intent ii = new Intent(this, F1Section02_03Activity.class);
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
       /* try {
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

        JSONObject form03_01 = new JSONObject();

        form03_01.put("pofi01", bi.pofi01.getText().toString());

        form03_01.put("pofi02", bi.pofi02a.isChecked() ? "1" : bi.pofi02b.isChecked() ? "2" : "0");
        form03_01.put("pofi02bx", bi.pofi02bx.getText().toString());

        form03_01.put("pofi03", bi.pofi03a.isChecked() ? "1" : bi.pofi03b.isChecked() ? "2" : "0");
        form03_01.put("pofi03bx", bi.pofi03bx.getText().toString());

        form03_01.put("pofi04", bi.pofi04a.isChecked() ? "1" : bi.pofi04b.isChecked() ? "2" : "0");
        form03_01.put("pofi04ax", bi.pofi04ax.getText().toString());

        form03_01.put("pofi05", bi.pofi05a.isChecked() ? "1" : bi.pofi05b.isChecked() ? "2" : "0");

        form03_01.put("pofi06", bi.pofi06a.isChecked() ? "1" : bi.pofi06b.isChecked() ? "2" : bi.pofi0696.isChecked() ? "96" : "0");
        form03_01.put("pofi0696x", bi.pofi0696x.getText().toString());

        form03_01.put("pofi07", bi.pofi07a.isChecked() ? "1" : bi.pofi07b.isChecked() ? "2" : "0");

        form03_01.put("pofi08", bi.pofi08a.isChecked() ? "1" : bi.pofi08b.isChecked() ? "2" : "0");

        form03_01.put("pofi09", bi.pofi09a.isChecked() ? "1" : bi.pofi09b.isChecked() ? "2" : "0");

        form03_01.put("pofi10", bi.pofi10.getText().toString());

        form03_01.put("pofi11a", bi.pofi11a.isChecked() ? "1" : "0");
        form03_01.put("pofi11b", bi.pofi11b.isChecked() ? "2" : "0");
        form03_01.put("pofi11c", bi.pofi11c.isChecked() ? "3" : "0");
        form03_01.put("pofi11d", bi.pofi11d.isChecked() ? "4" : "0");
        form03_01.put("pofi11e", bi.pofi11e.isChecked() ? "5" : "0");
        form03_01.put("pofi11f", bi.pofi11f.isChecked() ? "6" : "0");
        form03_01.put("pofi1196", bi.pofi1196.isChecked() ? "96" : "0");
        form03_01.put("pofi1196x", bi.pofi1196x.getText().toString());

        form03_01.put("pofi12a", bi.pofi12a.isChecked() ? "1" : "0");
        form03_01.put("pofi12b", bi.pofi12b.isChecked() ? "2" : "0");
        form03_01.put("pofi12c", bi.pofi12c.isChecked() ? "3" : "0");
        form03_01.put("pofi12d", bi.pofi12d.isChecked() ? "4" : "0");
        form03_01.put("pofi12e", bi.pofi12e.isChecked() ? "5" : "0");
        form03_01.put("pofi12f", bi.pofi12f.isChecked() ? "6" : "0");
        form03_01.put("pofi12g", bi.pofi12g.isChecked() ? "7" : "0");
        form03_01.put("pofi12h", bi.pofi12h.isChecked() ? "8" : "0");
        form03_01.put("pofi12i", bi.pofi12i.isChecked() ? "9" : "0");
        form03_01.put("pofi1296", bi.pofi1296.isChecked() ? "96" : "0");
        form03_01.put("pofi1296x", bi.pofi1296x.getText().toString());

        form03_01.put("pofi13", bi.pofi13a.isChecked() ? "1" : bi.pofi13b.isChecked() ? "2" : "0");

        //fc.setSqoc1(String.valueOf(form03_01));

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        if (!bi.pofi05a.isChecked()) {
            bi.pofi06.clearCheck();
        }

        if (bi.pofi09b.isChecked()) {
            bi.pofi10.setEnabled(false);
            for(int a = 0; a < bi.pofi11cv.getChildCount(); i++) {
                View v = bi.pofi11cv.getChildAt(a);
                if(v instanceof CheckBox) {
                    ((CheckBox)v).setChecked(false);
                }
            }
        } else {
            bi.pofi10.setEnabled(true);
        }

        /*if (!bi.pocfe05a.isChecked()) {
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
        }*/
    }

    void events_call() {

        bi.pofi05.setOnCheckedChangeListener(this);
       /* bi.pocfe04.setOnCheckedChangeListener(this);
        bi.pocfe05.setOnCheckedChangeListener(this);
        bi.pocfe10.setOnCheckedChangeListener(this);
        bi.pocfe13.setOnCheckedChangeListener(this);
        bi.pocfe16.setOnCheckedChangeListener(this);*/

    }

}


