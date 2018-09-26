package edu.aku.hassannaqvi.uen_po_hhs.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.uen_po_hhs.R;
import edu.aku.hassannaqvi.uen_po_hhs.contracts.DeceasedMotherContract;
import edu.aku.hassannaqvi.uen_po_hhs.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs.core.MainApp;
import io.blackbox_vision.datetimepickeredittext.view.DatePickerInputEditText;

public class SectionEActivity extends AppCompatActivity {

    private static final String TAG = SectionEActivity.class.getSimpleName();

    @BindView(R.id.te01)
    EditText te01;
    @BindView(R.id.te02d)
    EditText te02d;
    @BindView(R.id.te02m)
    EditText te02m;
    @BindView(R.id.te02y)
    EditText te02y;
    @BindView(R.id.te03)
    RadioGroup te03;
    @BindView(R.id.te03a)
    RadioButton te03a;
    @BindView(R.id.te03b)
    RadioButton te03b;
    @BindView(R.id.te03c)
    RadioButton te03c;
    @BindView(R.id.te03d)
    RadioButton te03d;
    @BindView(R.id.te03e)
    RadioButton te03e;
    @BindView(R.id.te04)
    DatePickerInputEditText te04;
/*    @BindView(R.id.te04d)
    EditText te04d;
    @BindView(R.id.te04m)
    EditText te04m;
    @BindView(R.id.te04y)
    EditText te04y;*/

    @BindView(R.id.te05)
    RadioGroup te05;
    @BindView(R.id.te05a)
    RadioButton te05a;
    @BindView(R.id.te05b)
    RadioButton te05b;
    @BindView(R.id.te05c)
    RadioButton te05c;
    @BindView(R.id.te05d)
    RadioButton te05d;
    @BindView(R.id.te05e)
    RadioButton te05e;
    @BindView(R.id.te05f)
    RadioButton te05f;
    @BindView(R.id.te0588)
    RadioButton te0588;
    @BindView(R.id.te0588x)
    EditText te0588x;

    @BindView(R.id.counterDec)
    TextView counterDec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_e);
        ButterKnife.bind(this);

        String dateToday = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        String maxDate5Years = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() - ((MainApp.MILLISECONDS_IN_5Years) + MainApp.MILLISECONDS_IN_DAY));


        te04.setManager(getSupportFragmentManager());

        te04.setMaxDate(dateToday);
        te04.setMinDate(maxDate5Years);

//        MainApp.CounterDeceasedMother++;
//
//        counterDec.setText("Deceased Women " + MainApp.CounterDeceasedMother + " out of " + MainApp.TotalDeceasedMotherCount);


        te0588.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    te0588x.setVisibility(View.VISIBLE);
                } else {
                    te0588x.setText(null);
                    te0588x.setVisibility(View.GONE);
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

//                if (MainApp.CounterDeceasedMother >= MainApp.TotalDeceasedMotherCount) {

                    // Reset Counter
//                    MainApp.CounterDeceasedMother = 0;

                    if (MainApp.TotalDeceasedChildCount > 0) {
                        Intent secNext = new Intent(this, SectionFActivity.class);
                        startActivity(secNext);
                    } else {
                        Intent secNext = new Intent(this, SectionHAActivity.class);
                        startActivity(secNext);
                    }
               /* } else {
                    Intent secNext = new Intent(this, SectionEActivity.class);
                    startActivity(secNext);
                }*/
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addDeceasedMother(MainApp.dcM);
        MainApp.dcM.set_ID(String.valueOf(updcount));

        if (updcount != -1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.dcM.set_UID(
                    (MainApp.fc.getDeviceID() + MainApp.dcM.get_ID()));
            db.updateDeceasedMotherID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

        MainApp.dcM = new DeceasedMotherContract();

        MainApp.dcM.set_UUID(MainApp.fc.getUID());
        MainApp.dcM.setFormDate(MainApp.fc.getFormDate());
        MainApp.dcM.setDeviceId(MainApp.fc.getDeviceID());
        MainApp.dcM.setUser(MainApp.fc.getUser());
        MainApp.dcM.setDevicetagID(sharedPref.getString("tagName", null));

        JSONObject sE = new JSONObject();

        sE.put("ta01", MainApp.cluster);
        sE.put("ta05h", MainApp.hhno);
        sE.put("ta05u", MainApp.billno);

        sE.put("te01", te01.getText().toString());

        sE.put("te02d", te02d.getText().toString());
        sE.put("te02m", te02m.getText().toString());
        sE.put("te02y", te02y.getText().toString());

        sE.put("te03", te03a.isChecked() ? "1" : te03b.isChecked() ? "2" : te03c.isChecked() ? "3"
                : te03d.isChecked() ? "4" : te03e.isChecked() ? "5" : "0");

        sE.put("te04", te04.getText().toString());
/*        sE.put("te04d", te04d.getText().toString());
        sE.put("te04m", te04m.getText().toString());
        sE.put("te04y", te04y.getText().toString());*/

        sE.put("te05", te05a.isChecked() ? "1" : te05b.isChecked() ? "2" : te05c.isChecked() ? "3"
                : te05d.isChecked() ? "4" : te05e.isChecked() ? "5" : te05f.isChecked() ? "6" : te0588.isChecked() ? "88" : "0");
        sE.put("te0588x", te0588x.getText().toString());
        sE.put("appver", MainApp.versionName + "." + MainApp.versionCode);


        MainApp.dcM.setsE(String.valueOf(sE));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    public boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (te01.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.te01), Toast.LENGTH_SHORT).show();
            te01.setError("This data is Required!");    // Set Error on last radio button
            te01.requestFocus();
            Log.i(TAG, "te01: This data is Required!");
            return false;
        } else {
            te01.setError(null);
        }
/*
        if (te02.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.te02), Toast.LENGTH_SHORT).show();
            te02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "te02: This data is Required!");
            return false;
        } else {
            te02.setError(null);
        }

        if (Integer.parseInt(te02.getText().toString()) < 15 || Integer.parseInt(te02.getText().toString()) > 49) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.te02), Toast.LENGTH_SHORT).show();
            te02.setError("Range is 15 to 49 Years");    // Set Error on last radio button

            Log.i(TAG, "te02: Range is 15 to 49 Years");
            return false;
        } else {
            te02.setError(null);
        }*/

        if (te02d.getText().toString().isEmpty() || te02m.getText().toString().isEmpty() || te02y.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.te02), Toast.LENGTH_SHORT).show();
            te02d.setError("This data is Required!");    // Set Error on last radio button
            te02d.requestFocus();
            Log.i(TAG, "te02: This data is Required!");
            return false;
        } else {
            te02d.setError(null);
        }


        if (Integer.parseInt(te02d.getText().toString()) < 0 || Integer.parseInt(te02d.getText().toString()) > 29) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.day), Toast.LENGTH_SHORT).show();
            te02d.setError("Range is 0 to 29 Days");    // Set Error on last radio button
            te02d.requestFocus();
            Log.i(TAG, "te02d: Range is 0 to 29 Days");
            return false;
        } else {
            te02d.setError(null);
        }

        if (Integer.parseInt(te02m.getText().toString()) < 0 || Integer.parseInt(te02m.getText().toString()) > 11) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.month), Toast.LENGTH_SHORT).show();
            te02m.setError("Range is 0 to 11 Months");    // Set Error on last radio button
            te02m.requestFocus();
            Log.i(TAG, "te02d: Range is 0 to 11 Months");
            return false;
        } else {
            te02m.setError(null);
        }

        if (Integer.parseInt(te02y.getText().toString()) < 15 || Integer.parseInt(te02y.getText().toString()) > 49) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.year), Toast.LENGTH_SHORT).show();
            te02y.setError("Range is 15 to 49  Years");    // Set Error on last radio button
            te02y.requestFocus();
            Log.i(TAG, "te02d: Range is 15 to 49 Years");
            return false;
        } else {
            te02y.setError(null);
        }

        if (te03.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.te03), Toast.LENGTH_SHORT).show();
            te03a.setError("This data is Required!");    // Set Error on last radio button
            te03a.setFocusable(true);
            te03a.setFocusableInTouchMode(true);
            te03a.requestFocus();
            Log.i(TAG, "te03: This data is Required!");
            return false;
        } else {
            te03a.setError(null);
        }

        if (te04.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.te04), Toast.LENGTH_SHORT).show();
            te04.setError("This data is Required!");    // Set Error on last radio button
            te04.requestFocus();
            Log.i(TAG, "te04: This data is Required!");
            return false;
        } else {
            te04.setError(null);
        }
        /*if (te04d.getText().toString().isEmpty() || te04m.getText().toString().isEmpty() || te04y.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.te04), Toast.LENGTH_SHORT).show();
            te04d.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "te04: This data is Required!");
            return false;
        } else {
            te04d.setError(null);
        }


        if (Integer.parseInt(te04d.getText().toString()) < 0 || Integer.parseInt(te04d.getText().toString()) > 29) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.day), Toast.LENGTH_SHORT).show();
            te04d.setError("Range is 0 to 29 Days");    // Set Error on last radio button

            Log.i(TAG, "te04d: Range is 0 to 29 Days");
            return false;
        } else {
            te04d.setError(null);
        }

        if (Integer.parseInt(te04m.getText().toString()) < 0 || Integer.parseInt(te04m.getText().toString()) > 11) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.month), Toast.LENGTH_SHORT).show();
            te04m.setError("Range is 0 to 11 Months");    // Set Error on last radio button

            Log.i(TAG, "te04d: Range is 0 to 11 Months");
            return false;
        } else {
            te04m.setError(null);
        }

        if (Integer.parseInt(te04y.getText().toString()) < 0) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.year), Toast.LENGTH_SHORT).show();
            te04y.setError("Years not be 0");    // Set Error on last radio button

            Log.i(TAG, "te04d: Years not be 0");
            return false;
        } else {
            te04y.setError(null);
        }*/

        if (te05.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.te05), Toast.LENGTH_SHORT).show();
            te05a.setError("This data is Required!");    // Set Error on last radio button
            te05a.setFocusable(true);
            te05a.setFocusableInTouchMode(true);
            te05a.requestFocus();
            Log.i(TAG, "te05: This data is Required!");
            return false;
        } else {
            te05a.setError(null);
        }

        if (te0588.isChecked() && te0588x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.te05) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
            te0588x.setError("This data is Required!");    // Set Error on last radio button
            te0588x.requestFocus();
            Log.i(TAG, "te0588x: This data is Required!");
            return false;
        } else {
            te0588x.setError(null);
        }


        return true;
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }


}
