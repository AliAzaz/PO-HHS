package edu.aku.hassannaqvi.uen_po_hhs_fl.ui.form1;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF1Section11Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ClearClass;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;

public class F1Section11Activity extends AppCompatActivity {

    ActivityF1Section11Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_f1_section11);
        bi.setCallback(this);
        this.setTitle(R.string.pocfsec11);
        setupSkips();

    }


    private TextWatcher generalTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (bi.pocfk06b.getText().hashCode() == s.hashCode()) {
                if (bi.pocfk06b.getText().toString().trim().length() > 0 && Integer.parseInt(bi.pocfk06b.getText().toString().trim()) < 92) {
                    ClearClass.ClearAllFields(bi.cvpocfk07, null);
                    bi.cvpocfk07.setVisibility(View.GONE);
                } else {
                    bi.cvpocfk07.setVisibility(View.VISIBLE);
                }
            }
        }

    };

    private void setupSkips() {

        bi.pocfk06b.addTextChangedListener(generalTextWatcher);

        bi.pocfk10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.pocfk10a.getId()) {
                    bi.cvpocfk11.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.cvpocfk12, null);
                    bi.cvpocfk12.setVisibility(View.GONE);
                } else {
                    bi.cvpocfk12.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.cvpocfk11, null);
                    bi.cvpocfk11.setVisibility(View.GONE);
                }
            }
        });


        bi.pocfk0897.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    ClearClass.ClearAllFields(bi.llpocfk08, false);
                else
                    ClearClass.ClearAllFields(bi.llpocfk08, true);
            }
        });


       /* if (bi.pocfk0897.isChecked()) {

            bi.pocfk08a.setChecked(false);
            bi.pocfk08b.setChecked(false);
            bi.pocfk08c.setChecked(false);
            bi.pocfk08d.setChecked(false);
            bi.pocfk08e.setChecked(false);
//            ed_A4255_4.setText("");

        } else {
            bi.pocfk0897.setChecked(false);
        }*/

    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSH();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {
        JSONObject sK = new JSONObject();

        sK.put("pocfk01", bi.pocfk01a.isChecked() ? "1"
                : bi.pocfk01b.isChecked() ? "2"
                : bi.pocfk01c.isChecked() ? "3"
                : bi.pocfk01d.isChecked() ? "4"
                : bi.pocfk0196.isChecked() ? "96"
                : "0");

        sK.put("pocfk01cx", bi.pocfk01cx.getText().toString());
        sK.put("pocfk01dx", bi.pocfk01dx.getText().toString());
        sK.put("pocfk0196x", bi.pocfk0196x.getText().toString());

        sK.put("pocfk02", bi.pocfk02a.isChecked() ? "1"
                : bi.pocfk02b.isChecked() ? "2"
                : "0");

        sK.put("pocfk03a", bi.pocfk03a.getText().toString());
        sK.put("pocfk03b", bi.pocfk03b.getText().toString());

        sK.put("pocfk04", bi.pocfk04a.isChecked() ? "1"
                : bi.pocfk04b.isChecked() ? "2"
                : "0");

        sK.put("pocfk05", bi.pocfk05a.isChecked() ? "1"
                : bi.pocfk05b.isChecked() ? "2"
                : "0");

        sK.put("pocfk06a", bi.pocfk06a.getText().toString());
        sK.put("pocfk06b", bi.pocfk06b.getText().toString());

        sK.put("pocfk07", bi.pocfk07a.isChecked() ? "1"
                : bi.pocfk07b.isChecked() ? "2"
                : "0");

        sK.put("pocfk08a", bi.pocfk08a.isChecked() ? "1" : "0");
        sK.put("pocfk08b", bi.pocfk08b.isChecked() ? "2" : "0");
        sK.put("pocfk08c", bi.pocfk08c.isChecked() ? "3" : "0");
        sK.put("pocfk08d", bi.pocfk08d.isChecked() ? "4" : "0");
        sK.put("pocfk08e", bi.pocfk08e.isChecked() ? "5" : "0");
        sK.put("pocfk0897", bi.pocfk0897.isChecked() ? "97" : "0");


        sK.put("pocfk09", bi.pocfk09a.isChecked() ? "1"
                : bi.pocfk09b.isChecked() ? "2"
                : bi.pocfk09c.isChecked() ? "3"
                : "0");

        sK.put("pocfk10", bi.pocfk10a.isChecked() ? "1"
                : bi.pocfk10b.isChecked() ? "2"
                : "0");

        sK.put("pocfk11", bi.pocfk11a.isChecked() ? "1"
                : bi.pocfk11b.isChecked() ? "2"
                : bi.pocfk1196.isChecked() ? "96"
                : "0");
        sK.put("pocfk1196x", bi.pocfk1196x.getText().toString());

        sK.put("pocfk12", bi.pocfk12a.isChecked() ? "1"
                : bi.pocfk12b.isChecked() ? "2"
                : "0");

        sK.put("pocfk13", bi.pocfk13a.isChecked() ? "1"
                : bi.pocfk13b.isChecked() ? "2"
                : "0");

        MainApp.fc.setsH(String.valueOf(sK));

    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.ll11);
    }

    public void BtnEnd() {
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

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
