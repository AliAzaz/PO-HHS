package edu.aku.hassannaqvi.uen_po_hhs.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import edu.aku.hassannaqvi.uen_po_hhs.contracts.DeceasedChildContract;
import edu.aku.hassannaqvi.uen_po_hhs.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs.core.MainApp;

public class SectionFActivity extends AppCompatActivity {

    private static final String TAG = SectionFActivity.class.getSimpleName();

    @BindView(R.id.tf01)
    EditText tf01;
    @BindView(R.id.tf02)
    EditText tf02;
    @BindView(R.id.tf03)
    RadioGroup tf03;
    @BindView(R.id.tf03a)
    RadioButton tf03a;
    @BindView(R.id.tf03b)
    RadioButton tf03b;
    @BindView(R.id.tf04d)
    EditText tf04d;
    @BindView(R.id.tf04m)
    EditText tf04m;
    @BindView(R.id.tf04y)
    EditText tf04y;
    @BindView(R.id.tf05)
    RadioGroup tf05;
    @BindView(R.id.tf05a)
    RadioButton tf05a;
    @BindView(R.id.tf05b)
    RadioButton tf05b;
    @BindView(R.id.tf05c)
    RadioButton tf05c;
    @BindView(R.id.tf05d)
    RadioButton tf05d;
    @BindView(R.id.tf05e)
    RadioButton tf05e;
    @BindView(R.id.tf06d)
    EditText tf06d;
    @BindView(R.id.tf06m)
    EditText tf06m;
    @BindView(R.id.tf06y)
    EditText tf06y;
    @BindView(R.id.tf07)
    RadioGroup tf07;
    @BindView(R.id.tf07a)
    RadioButton tf07a;
    @BindView(R.id.tf07b)
    RadioButton tf07b;
    @BindView(R.id.tf07c)
    RadioButton tf07c;
    @BindView(R.id.tf07d)
    RadioButton tf07d;
    @BindView(R.id.tf07e)
    RadioButton tf07e;
    @BindView(R.id.tf07f)
    RadioButton tf07f;
    @BindView(R.id.tf07g)
    RadioButton tf07g;
    @BindView(R.id.tf07h)
    RadioButton tf07h;
    @BindView(R.id.tf0788)
    RadioButton tf0788;
    @BindView(R.id.tf0788x)
    EditText tf0788x;

    @BindView(R.id.tf08)
    RadioGroup tf08;
    @BindView(R.id.tf08a)
    RadioButton tf08a;
    @BindView(R.id.tf08b)
    RadioButton tf08b;

    @BindView(R.id.tf09)
    RadioGroup tf09;
    @BindView(R.id.tf09a)
    RadioButton tf09a;
    @BindView(R.id.tf09b)
    RadioButton tf09b;

    @BindView(R.id.tf09ax)
    EditText tf09ax;
    @BindView(R.id.tf09bx)
    EditText tf09bx;

    @BindView(R.id.tf10)
    RadioGroup tf10;
    @BindView(R.id.tf10a)
    RadioButton tf10a;
    @BindView(R.id.tf10b)
    RadioButton tf10b;

    @BindView(R.id.tf10ax)
    EditText tf10ax;


    @BindView(R.id.tf11)
    RadioGroup tf11;
    @BindView(R.id.tf11a)
    RadioButton tf11a;
    @BindView(R.id.tf11b)
    RadioButton tf11b;

    @BindView(R.id.tf11ax)
    EditText tf11ax;

    @BindView(R.id.tf12)
    EditText tf12;

    @BindView(R.id.fldgrptf10)
    LinearLayout fldgrptf10;

    @BindView(R.id.fldgrptf11)
    LinearLayout fldgrptf11;

    @BindView(R.id.fldgrptf12)
    LinearLayout fldgrptf12;


    @BindView(R.id.counterDecChild)
    TextView counterDecChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_f);
        ButterKnife.bind(this);

        MainApp.CounterDeceasedChild++;
        counterDecChild.setText("Deceased Child " + MainApp.CounterDeceasedChild + " out of " + MainApp.TotalDeceasedChildCount);

        //tf06.setManager(getSupportFragmentManager());

        String dateToday = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        String maxDate5Years = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() - ((MainApp.MILLISECONDS_IN_5Years) + MainApp.MILLISECONDS_IN_DAY));

        // tf06.setMinDate(maxDate5Years);
        // tf06.setMaxDate(dateToday);


        tf0788.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (tf0788.isChecked()) {
                    tf0788x.setVisibility(View.VISIBLE);
                    tf0788x.requestFocus();
                } else {
                    tf0788x.setText(null);
                    tf0788x.setVisibility(View.GONE);
                }
            }
        });

        tf09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tf09a) {
                    tf09ax.setVisibility(View.VISIBLE);
                    tf09bx.setVisibility(View.GONE);
                    tf09bx.setText(null);
                    fldgrptf10.setVisibility(View.VISIBLE);
                    fldgrptf11.setVisibility(View.VISIBLE);
                    fldgrptf12.setVisibility(View.VISIBLE);
                } else {
                    tf09ax.setVisibility(View.GONE);
                    tf09ax.setText(null);
                    tf09bx.setVisibility(View.VISIBLE);
                    fldgrptf10.setVisibility(View.GONE);
                    tf10.clearCheck();
                    tf10ax.setText(null);
                    fldgrptf11.setVisibility(View.GONE);
                    tf11.clearCheck();
                    tf11ax.setText(null);
                    fldgrptf12.setVisibility(View.GONE);
                    tf12.setText(null);
                }
            }
        });
        tf10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tf10a) {
                    tf10ax.setVisibility(View.VISIBLE);

                    fldgrptf11.setVisibility(View.VISIBLE);
                    fldgrptf12.setVisibility(View.VISIBLE);
                } else {
                    tf10ax.setVisibility(View.GONE);
                    tf10ax.setText(null);
                    fldgrptf11.setVisibility(View.GONE);
                    tf11.clearCheck();
                    tf11ax.setText(null);
                    fldgrptf12.setVisibility(View.GONE);
                    tf12.setText(null);
                }
            }
        });

        tf11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tf11a) {

                    tf11ax.setVisibility(View.VISIBLE);
                    fldgrptf12.setVisibility(View.GONE);
                    tf12.setText(null);

                } else {
                    fldgrptf12.setVisibility(View.VISIBLE);
                    tf11ax.setVisibility(View.GONE);
                    tf11ax.setText(null);
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

                if (MainApp.CounterDeceasedChild == MainApp.TotalDeceasedChildCount) {

                    // Reset Counter
                    MainApp.CounterDeceasedChild = 0;

                    if (MainApp.TotalChildCount > 0 || MainApp.totalImsCount > 0) {
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
                    Intent secNext = new Intent(this, SectionFActivity.class);
                    startActivity(secNext);
                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addDeceasedChild(MainApp.dcC);
        MainApp.dcC.set_ID(String.valueOf(updcount));

        if (updcount != -1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.dcC.set_UID(
                    (MainApp.fc.getDeviceID() + MainApp.dcC.get_ID()));
            db.updateDeceasedChildID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

        MainApp.dcC = new DeceasedChildContract();

        MainApp.dcC.set_UUID(MainApp.fc.getUID());
        MainApp.dcC.setFormDate(MainApp.fc.getFormDate());
        MainApp.dcC.setDeviceId(MainApp.fc.getDeviceID());
        MainApp.dcC.setUser(MainApp.fc.getUser());
        MainApp.dcC.setDevicetagID(sharedPref.getString("tagName", null));

        JSONObject sF = new JSONObject();

        sF.put("ta01", MainApp.cluster);
        sF.put("ta05h", MainApp.hhno);
        sF.put("ta05u", MainApp.billno);

        sF.put("tf01", tf01.getText().toString());
        sF.put("tf02", tf02.getText().toString());
        sF.put("tf03", tf03a.isChecked() ? "1" : tf03b.isChecked() ? "2" : "0");
        sF.put("tf04d", tf04d.getText().toString());
        sF.put("tf04m", tf04m.getText().toString());
        sF.put("tf04y", tf04y.getText().toString());
        sF.put("tf05", tf05a.isChecked() ? "1" : tf05b.isChecked() ? "2" : tf05c.isChecked() ? "3"
                : tf05d.isChecked() ? "4" : tf05e.isChecked() ? "5" : "0");
        sF.put("tf06d", tf06d.getText().toString());
        sF.put("tf06m", tf06m.getText().toString());
        sF.put("tf06y", tf06y.getText().toString());
        sF.put("te07", tf07a.isChecked() ? "1" : tf07b.isChecked() ? "2" : tf07c.isChecked() ? "3"
                : tf07d.isChecked() ? "4" : tf07e.isChecked() ? "5" : tf07f.isChecked() ? "6" : tf07g.isChecked() ? "7"
                : tf07h.isChecked() ? "8" : tf0788.isChecked() ? "88" : "0");
        sF.put("tf0788x", tf0788x.getText().toString());
        sF.put("tf08", tf08a.isChecked() ? "1" : tf08b.isChecked() ? "2" : "0");
        sF.put("tf09", tf09a.isChecked() ? "1" : tf09b.isChecked() ? "2" : "0");
        sF.put("tf09a", tf09ax.getText().toString());
        sF.put("tf09b", tf09bx.getText().toString());

        sF.put("tf10", tf10a.isChecked() ? "1" : tf10b.isChecked() ? "2" : "0");
        sF.put("tf10a", tf10ax.getText().toString());
        sF.put("tf11", tf11a.isChecked() ? "1" : tf11b.isChecked() ? "2" : "0");
        sF.put("tf11a", tf11ax.getText().toString());

        sF.put("tf12", tf12.getText().toString());

        sF.put("appver", MainApp.versionName + "." + MainApp.versionCode);

        MainApp.dcC.setsF(String.valueOf(sF));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    public boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (tf01.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf01), Toast.LENGTH_SHORT).show();
            tf01.setError("This data is Required!");    // Set Error on last radio button
            tf01.requestFocus();
            Log.i(TAG, "tf01: This data is Required!");
            return false;
        } else {
            tf01.setError(null);
        }

        if (tf02.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf02), Toast.LENGTH_SHORT).show();
            tf02.setError("This data is Required!");    // Set Error on last radio button
            tf02.requestFocus();
            Log.i(TAG, "tf02: This data is Required!");
            return false;
        } else {
            tf02.setError(null);
        }

        if (tf03.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf03), Toast.LENGTH_SHORT).show();
            tf03a.setError("This data is Required!");    // Set Error on last radio button
            tf03a.setFocusable(true);
            tf03a.setFocusableInTouchMode(true);
            tf03a.requestFocus();
            Log.i(TAG, "tf03: This data is Required!");
            return false;
        } else {
            tf03a.setError(null);
        }

        if (tf04d.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf04), Toast.LENGTH_SHORT).show();
            tf04d.setError("This data is Required!");    // Set Error on last radio button
            tf04d.requestFocus();
            Log.i(TAG, "tf04: This data is Required!");
            return false;
        } else {
            tf04d.setError(null);
        }

        if (tf04m.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf04), Toast.LENGTH_SHORT).show();
            tf04m.setError("This data is Required!");    // Set Error on last radio button
            tf04m.requestFocus();
            Log.i(TAG, "tf04: This data is Required!");
            return false;
        } else {
            tf04m.setError(null);
        }

        if (tf04y.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf04), Toast.LENGTH_SHORT).show();
            tf04y.setError("This data is Required!");    // Set Error on last radio button
            tf04y.requestFocus();
            Log.i(TAG, "tf04: This data is Required!");
            return false;
        } else {
            tf04y.setError(null);
        }


        if (Integer.parseInt(tf04d.getText().toString()) < 0 || Integer.parseInt(tf04d.getText().toString()) > 29) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.day), Toast.LENGTH_SHORT).show();
            tf04d.setError("Range is 0 to 29 Days");    // Set Error on last radio button
            tf04d.requestFocus();
            Log.i(TAG, "tf04d: Range is 0 to 29 Days");
            return false;
        } else {
            tf04d.setError(null);
        }

        if (Integer.parseInt(tf04m.getText().toString()) < 0 || Integer.parseInt(tf04m.getText().toString()) > 11) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.month), Toast.LENGTH_SHORT).show();
            tf04m.setError("Range is 0 to 11 Months");    // Set Error on last radio button
            tf04m.requestFocus();
            Log.i(TAG, "tf04d: Range is 0 to 11 Months");
            return false;
        } else {
            tf04m.setError(null);
        }

        if (Integer.parseInt(tf04y.getText().toString()) < 0 || Integer.parseInt(tf04y.getText().toString()) > 5) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.year), Toast.LENGTH_SHORT).show();
            tf04y.setError("Range is 0 to 5 Years");    // Set Error on last radio button
            tf04y.requestFocus();
            Log.i(TAG, "tf04d: Range is 0 to 5 Years");
            return false;
        } else {
            tf04y.setError(null);
        }

        if (tf05.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf05), Toast.LENGTH_SHORT).show();
            tf05a.setError("This data is Required!");    // Set Error on last radio button
            tf05a.setFocusable(true);
            tf05a.setFocusableInTouchMode(true);
            tf05a.requestFocus();
            Log.i(TAG, "tf05: This data is Required!");
            return false;
        } else {
            tf05a.setError(null);
        }

        if (tf06d.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf06), Toast.LENGTH_SHORT).show();
            tf06d.setError("This data is Required!");    // Set Error on last radio button
            tf06d.requestFocus();
            Log.i(TAG, "tf06: This data is Required!");
            return false;
        } else {
            tf06d.setError(null);
        }

        if (Integer.parseInt(tf06d.getText().toString()) > 31) {
            Toast.makeText(this, "ERROR: " + getString(R.string.tf06), Toast.LENGTH_SHORT).show();
            tf06d.setError("Days must not be greater than 30!");    // Set Error on last radio button
            tf06d.requestFocus();
            Log.i(TAG, "tf06: This data is Required!");
            return false;
        } else {
            tf06d.setError(null);
        }

        if (tf06m.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf06), Toast.LENGTH_SHORT).show();
            tf06m.setError("This data is Required!");    // Set Error on last radio button
            tf06m.requestFocus();
            Log.i(TAG, "tf06: This data is Required!");
            return false;
        } else {
            tf06m.setError(null);
        }

        if (Integer.parseInt(tf06m.getText().toString()) > 12) {
            Toast.makeText(this, "ERROR: " + getString(R.string.tf06), Toast.LENGTH_SHORT).show();
            tf06m.setError("Month must not be greater than 12!");    // Set Error on last radio button
            tf06m.requestFocus();
            Log.i(TAG, "tf06: This data is Required!");
            return false;
        } else {
            tf06m.setError(null);
        }

        if (tf06y.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf06), Toast.LENGTH_SHORT).show();
            tf06y.setError("This data is Required!");    // Set Error on last radio button
            tf06y.requestFocus();
            Log.i(TAG, "tf06: This data is Required!");
            return false;
        } else {
            tf06y.setError(null);
        }

        if (Integer.parseInt(tf06y.getText().toString()) < 2013 && Integer.parseInt(tf06y.getText().toString()) > 2018) {
            Toast.makeText(this, "ERROR: " + getString(R.string.tf06), Toast.LENGTH_SHORT).show();
            tf06y.setError("Year must be in between 2013 to 2018");    // Set Error on last radio button
            tf06y.requestFocus();
            Log.i(TAG, "tf06: This data is Required!");
            return false;
        } else {
            tf06y.setError(null);
        }

        if (tf07.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf07), Toast.LENGTH_SHORT).show();
            tf07a.setError("This data is Required!");    // Set Error on last radio button
            tf07a.setFocusable(true);
            tf07a.setFocusableInTouchMode(true);
            tf07a.requestFocus();
            Log.i(TAG, "tf07: This data is Required!");
            return false;
        } else {
            tf07a.setError(null);
        }

        if (tf0788.isChecked() && tf0788x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf07) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
            tf0788x.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "tf0788x: This data is Required!");
            tf0788x.requestFocus();
            return false;
        } else {
            tf0788x.setError(null);
        }

        if (tf08.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf08), Toast.LENGTH_SHORT).show();
            tf08a.setError("This data is Required!");    // Set Error on last radio button
            tf08a.setFocusable(true);
            tf08a.setFocusableInTouchMode(true);
            tf08a.requestFocus();
            Log.i(TAG, "tf07: This data is Required!");
            return false;
        } else {
            tf08a.setError(null);
        }

        if (tf09.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf09), Toast.LENGTH_SHORT).show();
            tf09a.setError("This data is Required!");    // Set Error on last radio button
            tf09a.setFocusable(true);
            tf09a.setFocusableInTouchMode(true);
            tf09a.requestFocus();
            Log.i(TAG, "tf07: This data is Required!");
            return false;
        } else {
            tf09a.setError(null);
        }

        if (tf09a.isChecked()) {
            if (tf09ax.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf09) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                tf09ax.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "tf0788x: This data is Required!");
                tf09ax.requestFocus();
                return false;
            } else {
                tf09ax.setError(null);
            }

            if (tf10.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf10), Toast.LENGTH_SHORT).show();
                tf10a.setError("This data is Required!");    // Set Error on last radio button
                tf10a.setFocusable(true);
                tf10a.setFocusableInTouchMode(true);
                tf10a.requestFocus();
                Log.i(TAG, "tf07: This data is Required!");
                return false;
            } else {
                tf10a.setError(null);
            }

            if (tf10a.isChecked()) {
                if (tf10ax.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf10) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                    tf10ax.setError("This data is Required!");    // Set Error on last radio button
                    Log.i(TAG, "tf0788x: This data is Required!");
                    tf10ax.requestFocus();
                    return false;
                } else {
                    tf10ax.setError(null);
                }

                if (tf11.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf11), Toast.LENGTH_SHORT).show();
                    tf11a.setError("This data is Required!");    // Set Error on last radio button
                    tf11a.setFocusable(true);
                    tf11a.setFocusableInTouchMode(true);
                    tf11a.requestFocus();
                    Log.i(TAG, "tf07: This data is Required!");
                    return false;
                } else {
                    tf11a.setError(null);
                }
                if (tf11a.isChecked()) {
                    if (tf11ax.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf11) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                        tf11ax.setError("This data is Required!");    // Set Error on last radio button
                        Log.i(TAG, "tf0788x: This data is Required!");
                        tf11ax.requestFocus();
                        return false;
                    } else {
                        tf11ax.setError(null);
                    }

                }
                if (tf11b.isChecked()) {
                    if (tf12.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf12) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                        tf12.setError("This data is Required!");    // Set Error on last radio button
                        Log.i(TAG, "tf0788x: This data is Required!");
                        tf12.requestFocus();
                        return false;
                    } else {
                        tf12.setError(null);
                    }
                }

            }

        } else {
            if (tf09bx.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tf09) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                tf09bx.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "tf0788x: This data is Required!");
                tf09bx.requestFocus();
                return false;
            } else {
                tf09bx.setError(null);
            }
        }


        return true;
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }


}
