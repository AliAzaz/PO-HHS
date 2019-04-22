package edu.aku.hassannaqvi.uen_po_hhs_fl.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivitySection0405Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;


public class Section0405 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ActivitySection0405Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section0405);
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
                Toast.makeText(this, "Starting 2nd Section", Toast.LENGTH_SHORT).show();
//                MainApp.endActivity(this, this, Qoc2.class, true, RSDInfoActivity.fc);

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {
//        MainApp.endActivity(this, this, EndingActivity.class, false, RSDInfoActivity.fc);
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

        return false;

    }

    public boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.ll0405);
    }

    private void SaveDraft() throws JSONException {

        JSONObject qoc1 = new JSONObject();

        /*qoc1.put("qa0101a", bi.qa0101aa.isChecked() ? "1" : bi.qa0101ab.isChecked() ? "2" : bi.qa0101a97.isChecked() ? "97" : "0");
        qoc1.put("qa0101b", bi.qa0101b.getText().toString().trim().length() > 0 ? bi.qa0101b.getText().toString() : "0");
        qoc1.put("qa0101c", bi.qa0101c.getText().toString().trim().length() > 0 ? bi.qa0101c.getText().toString() : "0");

        fc.setSqoc1(String.valueOf(qoc1));*/

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
/*
        if (!bi.qa0101ab.isChecked()) {
            bi.qa0101b.setEnabled(false);
        } else {
            bi.qa0101b.setEnabled(true);
        }
        */
    }

    void events_call() {

//        bi.qa0101a.setOnCheckedChangeListener(this);

    }
}


