package edu.aku.hassannaqvi.uen_po_hhs_fl.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

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

    private void SaveDraft() {
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
