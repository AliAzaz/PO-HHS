package edu.aku.hassannaqvi.uen_tmk.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.uen_tmk.R;
import edu.aku.hassannaqvi.uen_tmk.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk.core.MainApp;

public class SectionGActivity extends Activity {

    private static final String TAG = SectionGActivity.class.getSimpleName();

    @BindView(R.id.tg01)
    RadioGroup tg01;
    @BindView(R.id.tg01a)
    RadioButton tg01a;
    @BindView(R.id.tg01b)
    RadioButton tg01b;
    @BindView(R.id.tg01888)
    RadioButton tg01888;
    @BindView(R.id.fldGrptg02)
    LinearLayout fldGrptg02;
    @BindView(R.id.tg02)
    RadioGroup tg02;
    @BindView(R.id.tg02a)
    RadioButton tg02a;
    @BindView(R.id.tg02b)
    RadioButton tg02b;
    @BindView(R.id.tg02c)
    RadioButton tg02c;
    @BindView(R.id.tg02d)
    RadioButton tg02d;
    @BindView(R.id.tg0288)
    RadioButton tg0288;
    @BindView(R.id.tg03a)
    CheckBox tg03a;
    @BindView(R.id.tg03b)
    CheckBox tg03b;
    @BindView(R.id.tg03c)
    CheckBox tg03c;
    @BindView(R.id.tg03d)
    CheckBox tg03d;
    @BindView(R.id.tg03e)
    CheckBox tg03e;
    @BindView(R.id.tg03f)
    CheckBox tg03f;
    @BindView(R.id.tg0288x)
    EditText tg0288x;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_g);
        ButterKnife.bind(this);

        tg01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (tg01a.isChecked()) {
                    fldGrptg02.setVisibility(View.VISIBLE);
                } else {
                    fldGrptg02.setVisibility(View.GONE);
                    tg02.clearCheck();
                    tg0288x.setText(null);
                    tg03a.setChecked(false);
                    tg03b.setChecked(false);
                    tg03c.setChecked(false);
                    tg03d.setChecked(false);
                    tg03e.setChecked(false);
                    tg03f.setChecked(false);
                }
            }
        });

        tg0288.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tg0288x.setVisibility(View.VISIBLE);
                    tg0288x.requestFocus();
                } else {
                    tg0288x.setVisibility(View.GONE);
                    tg0288x.setText(null);
                }
            }
        });

    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {

        Toast.makeText(this, "Not Processing This Section", Toast.LENGTH_SHORT).show();

        Toast.makeText(this, "Starting Form Ending Section", Toast.LENGTH_SHORT).show();

        MainApp.endActivity(this, this);
    }


    @OnClick(R.id.btn_Continue)
    void onBtnContinueClick() {

        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                finish();

                if (MainApp.TotalChildCount > 0) {
                    Intent secNext = new Intent(this, SectionHAActivity.class);
                    startActivity(secNext);
                } else if (MainApp.totalImsCount > 0) {
                    Intent secNext = new Intent(this, SectionIActivity.class);
                    startActivity(secNext);
                } else {
                    Intent secNext = new Intent(this, SectionKActivity.class);
                    startActivity(secNext);
                }
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSG();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sG = new JSONObject();

        sG.put("tg01", tg01a.isChecked() ? "1" : tg01b.isChecked() ? "2" : tg01888.isChecked() ? "888" : "0");
        sG.put("tg02", tg02a.isChecked() ? "1" : tg02b.isChecked() ? "2" : tg02c.isChecked() ? "3"
                : tg02d.isChecked() ? "4" : tg0288.isChecked() ? "88" : "0");
        sG.put("tg0288x", tg0288x.getText().toString());
        sG.put("tg03a", tg03a.isChecked() ? "1" : "0");
        sG.put("tg03b", tg03b.isChecked() ? "2" : "0");
        sG.put("tg03c", tg03c.isChecked() ? "3" : "0");
        sG.put("tg03d", tg03d.isChecked() ? "4" : "0");
        sG.put("tg03e", tg03e.isChecked() ? "5" : "0");
        sG.put("tg03f", tg03f.isChecked() ? "6" : "0");

        MainApp.fc.setsG(String.valueOf(sG));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    public boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (tg01.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tg01), Toast.LENGTH_SHORT).show();
            tg01888.setError("This data is Required!");    // Set Error on last radio button
            tg01a.setFocusable(true);
            tg01a.setFocusableInTouchMode(true);
            tg01a.requestFocus();
            Log.i(TAG, "tg01: This data is Required!");
            return false;
        } else {
            tg01888.setError(null);
        }

        if (tg01a.isChecked()) {
            if (tg02.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tg02), Toast.LENGTH_SHORT).show();
                tg0288.setError("This data is Required!");    // Set Error on last radio button
                tg02a.setFocusable(true);
                tg02a.setFocusableInTouchMode(true);
                tg02a.requestFocus();
                Log.i(TAG, "tg02: This data is Required!");
                return false;
            } else {
                tg0288.setError(null);
            }

            if (tg0288.isChecked() && tg0288x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tg02) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                tg0288x.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "tg0288x: This data is Required!");
                tg0288x.requestFocus();
                return false;
            } else {
                tg0288x.setError(null);
            }

            if (!(tg03a.isChecked() || tg03b.isChecked() || tg03c.isChecked() || tg03d.isChecked()
                    || tg03e.isChecked() || tg03f.isChecked())) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tg03), Toast.LENGTH_LONG).show();
                tg03f.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "tg03: This data is Required!");
                tg03f.setFocusable(true);
                tg03f.setFocusableInTouchMode(true);
                tg03f.requestFocus();
                return false;
            } else {
                tg03f.setError(null);
            }
        }


        return true;
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }


}
