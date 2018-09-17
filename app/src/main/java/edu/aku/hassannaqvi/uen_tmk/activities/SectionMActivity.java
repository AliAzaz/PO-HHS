package edu.aku.hassannaqvi.uen_tmk.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class SectionMActivity extends Activity {

    private static final String TAG = SectionMActivity.class.getName();
    @BindView(R.id.tm01)
    RadioGroup tm01;
    @BindView(R.id.tm01a)
    RadioButton tm01a;
    @BindView(R.id.tm01b)
    RadioButton tm01b;
    @BindView(R.id.tm02)
    RadioGroup tm02;
    @BindView(R.id.tm02a)
    RadioButton tm02a;
    @BindView(R.id.tm02b)
    RadioButton tm02b;
    @BindView(R.id.tm03)
    RadioGroup tm03;
    @BindView(R.id.tm03a)
    RadioButton tm03a;
    @BindView(R.id.tm03b)
    RadioButton tm03b;
    @BindView(R.id.tm04)
    RadioGroup tm04;
    @BindView(R.id.tm04a)
    RadioButton tm04a;
    @BindView(R.id.tm04b)
    RadioButton tm04b;
    @BindView(R.id.tm05)
    RadioGroup tm05;
    @BindView(R.id.tm05a)
    RadioButton tm05a;
    @BindView(R.id.tm05b)
    RadioButton tm05b;
    @BindView(R.id.tm06)
    RadioGroup tm06;
    @BindView(R.id.tm06a)
    RadioButton tm06a;
    @BindView(R.id.tm06b)
    RadioButton tm06b;
    @BindView(R.id.tm07)
    RadioGroup tm07;
    @BindView(R.id.tm07a)
    RadioButton tm07a;
    @BindView(R.id.tm07b)
    RadioButton tm07b;
    @BindView(R.id.tm08)
    RadioGroup tm08;
    @BindView(R.id.tm08a)
    RadioButton tm08a;
    @BindView(R.id.tm08b)
    RadioButton tm08b;
    @BindView(R.id.tm09)
    RadioGroup tm09;
    @BindView(R.id.tm09a)
    RadioButton tm09a;
    @BindView(R.id.tm09b)
    RadioButton tm09b;
    @BindView(R.id.tm10)
    RadioGroup tm10;
    @BindView(R.id.tm10a)
    RadioButton tm10a;
    @BindView(R.id.tm10b)
    RadioButton tm10b;
    @BindView(R.id.tm11)
    RadioGroup tm11;
    @BindView(R.id.tm11a)
    RadioButton tm11a;
    @BindView(R.id.tm11b)
    RadioButton tm11b;
    @BindView(R.id.tm12)
    RadioGroup tm12;
    @BindView(R.id.tm12a)
    RadioButton tm12a;
    @BindView(R.id.tm12b)
    RadioButton tm12b;
    /*@BindView(R.id.tm13)
    RadioGroup tm13;
    @BindView(R.id.tm13a)
    RadioButton tm13a;
    @BindView(R.id.tm13b)
    RadioButton tm13b;
    @BindView(R.id.tm14)
    RadioGroup tm14;
    @BindView(R.id.tm14a)
    RadioButton tm14a;
    @BindView(R.id.tm14b)
    RadioButton tm14b;
    @BindView(R.id.tm15)
    RadioGroup tm15;
    @BindView(R.id.tm15a)
    RadioButton tm15a;
    @BindView(R.id.tm15b)
    RadioButton tm15b;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_m);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        //TODO implement

        MainApp.endActivity(this, this);

    }

    @OnClick(R.id.btn_Continue)
    void onBtnContinueClick() {
        //TODO implement
        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            /*try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }*/
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sM = new JSONObject();

        sM.put("tm01", tm01a.isChecked() ? "1" : tm01b.isChecked() ? "2" : "0");
        sM.put("tm02", tm02a.isChecked() ? "1" : tm02b.isChecked() ? "2" : "0");
        sM.put("tm03", tm03a.isChecked() ? "1" : tm03b.isChecked() ? "2" : "0");
        sM.put("tm04", tm04a.isChecked() ? "1" : tm04b.isChecked() ? "2" : "0");
        sM.put("tm05", tm05a.isChecked() ? "1" : tm05b.isChecked() ? "2" : "0");
        sM.put("tm06", tm06a.isChecked() ? "1" : tm06b.isChecked() ? "2" : "0");
        sM.put("tm07", tm07a.isChecked() ? "1" : tm07b.isChecked() ? "2" : "0");
        sM.put("tm08", tm08a.isChecked() ? "1" : tm08b.isChecked() ? "2" : "0");
        sM.put("tm09", tm09a.isChecked() ? "1" : tm09b.isChecked() ? "2" : "0");
        sM.put("tm10", tm10a.isChecked() ? "1" : tm10b.isChecked() ? "2" : "0");
        sM.put("tm11", tm11a.isChecked() ? "1" : tm11b.isChecked() ? "2" : "0");
        sM.put("tm12", tm12a.isChecked() ? "1" : tm12b.isChecked() ? "2" : "0");


        /*sM.put("tm13", tm13a.isChecked() ? "1" : tm13b.isChecked() ? "2" : "0");
        sM.put("tm14", tm14a.isChecked() ? "1" : tm14b.isChecked() ? "2" : "0");
        sM.put("tm15", tm15a.isChecked() ? "1" : tm15b.isChecked() ? "2" : "0");*/

        MainApp.fc.setsM(String.valueOf(sM));
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        /*int updcount = db.updateSM();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        return true;
    }

    public boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//         01
        if (tm01.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tm01), Toast.LENGTH_SHORT).show();
            tm01b.setError("This data is Required!");    // Set Error on last radio button
            tm01b.setFocusable(true);
            tm01b.setFocusableInTouchMode(true);
            tm01b.requestFocus();
            Log.i(TAG, "tm01: This data is Required!");
            return false;
        } else {
            tm01b.setError(null);
        }

//         02
        if (tm02.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tm02), Toast.LENGTH_SHORT).show();
            tm02b.setError("This data is Required!");    // Set Error on last radio button
            tm02b.setFocusable(true);
            tm02b.setFocusableInTouchMode(true);
            tm02b.requestFocus();
            Log.i(TAG, "tm02: This data is Required!");
            return false;
        } else {
            tm02b.setError(null);
        }

//         03
        if (tm03.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tm03), Toast.LENGTH_SHORT).show();
            tm03b.setError("This data is Required!");    // Set Error on last radio button
            tm03b.setFocusable(true);
            tm03b.setFocusableInTouchMode(true);
            tm03b.requestFocus();
            Log.i(TAG, "tm03: This data is Required!");
            return false;
        } else {
            tm03b.setError(null);
        }

//         04
        if (tm04.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tm04), Toast.LENGTH_SHORT).show();
            tm04b.setError("This data is Required!");    // Set Error on last radio button
            tm04b.setFocusable(true);
            tm04b.setFocusableInTouchMode(true);
            tm04b.requestFocus();
            Log.i(TAG, "tm04: This data is Required!");
            return false;
        } else {
            tm04b.setError(null);
        }

//         05
        if (tm05.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tm05), Toast.LENGTH_SHORT).show();
            tm05b.setError("This data is Required!");    // Set Error on last radio button
            tm05b.setFocusable(true);
            tm05b.setFocusableInTouchMode(true);
            tm05b.requestFocus();
            Log.i(TAG, "tm05: This data is Required!");
            return false;
        } else {
            tm05b.setError(null);
        }

//         06
        if (tm06.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tm06), Toast.LENGTH_SHORT).show();
            tm06b.setError("This data is Required!");    // Set Error on last radio button
            tm06b.setFocusable(true);
            tm06b.setFocusableInTouchMode(true);
            tm06b.requestFocus();
            Log.i(TAG, "tm06: This data is Required!");
            return false;
        } else {
            tm06b.setError(null);
        }

//         07
        if (tm07.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tm07), Toast.LENGTH_SHORT).show();
            tm07b.setError("This data is Required!");    // Set Error on last radio button
            tm07b.setFocusable(true);
            tm07b.setFocusableInTouchMode(true);
            tm07b.requestFocus();
            Log.i(TAG, "tm07: This data is Required!");
            return false;
        } else {
            tm07b.setError(null);
        }

//         08
        if (tm08.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tm08), Toast.LENGTH_SHORT).show();
            tm08b.setError("This data is Required!");    // Set Error on last radio button
            tm08b.setFocusable(true);
            tm08b.setFocusableInTouchMode(true);
            tm08b.requestFocus();
            Log.i(TAG, "tm08: This data is Required!");
            return false;
        } else {
            tm08b.setError(null);
        }

//         09
        if (tm09.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tm09), Toast.LENGTH_SHORT).show();
            tm09b.setError("This data is Required!");    // Set Error on last radio button
            tm09b.setFocusable(true);
            tm09b.setFocusableInTouchMode(true);
            tm09b.requestFocus();
            Log.i(TAG, "tm09: This data is Required!");
            return false;
        } else {
            tm09b.setError(null);
        }

//         10
        if (tm10.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tm10), Toast.LENGTH_SHORT).show();
            tm10b.setError("This data is Required!");    // Set Error on last radio button
            tm10b.setFocusable(true);
            tm10b.setFocusableInTouchMode(true);
            tm10b.requestFocus();
            Log.i(TAG, "tm10: This data is Required!");
            return false;
        } else {
            tm10b.setError(null);
        }

//         11
        if (tm11.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tm11), Toast.LENGTH_SHORT).show();
            tm11b.setError("This data is Required!");    // Set Error on last radio button
            tm11b.setFocusable(true);
            tm11b.setFocusableInTouchMode(true);
            tm11b.requestFocus();
            Log.i(TAG, "tm11: This data is Required!");
            return false;
        } else {
            tm11b.setError(null);
        }

//         12
        if (tm12.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tm12), Toast.LENGTH_SHORT).show();
            tm12b.setError("This data is Required!");    // Set Error on last radio button
            tm12b.setFocusable(true);
            tm12b.setFocusableInTouchMode(true);
            tm12b.requestFocus();
            Log.i(TAG, "tm12: This data is Required!");
            return false;
        } else {
            tm12b.setError(null);
        }

        /*if (tm13.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tm13), Toast.LENGTH_SHORT).show();
            tm13b.setError("This data is Required!");    // Set Error on last radio button
            tm13b.setFocusable(true);
            tm13b.setFocusableInTouchMode(true);
            tm13b.requestFocus();
            Log.i(TAG, "tm13: This data is Required!");
            return false;
        } else {
            tm13b.setError(null);
        }

        if (tm14.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tm14), Toast.LENGTH_SHORT).show();
            tm14b.setError("This data is Required!");    // Set Error on last radio button
            tm14b.setFocusable(true);
            tm14b.setFocusableInTouchMode(true);
            tm14b.requestFocus();
            Log.i(TAG, "tm14: This data is Required!");
            return false;
        } else {
            tm14b.setError(null);
        }

        if (tm15.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tm15), Toast.LENGTH_SHORT).show();
            tm15b.setError("This data is Required!");    // Set Error on last radio button
            tm15b.setFocusable(true);
            tm15b.setFocusableInTouchMode(true);
            tm15b.requestFocus();
            Log.i(TAG, "tm15: This data is Required!");
            return false;
        } else {
            tm15b.setError(null);
        }*/

        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }
}