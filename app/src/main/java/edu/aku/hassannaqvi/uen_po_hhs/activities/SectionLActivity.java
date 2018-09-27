package edu.aku.hassannaqvi.uen_po_hhs.activities;

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
import edu.aku.hassannaqvi.uen_po_hhs.R;
import edu.aku.hassannaqvi.uen_po_hhs.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs.core.MainApp;

public class SectionLActivity extends Activity {

    private static final String TAG = SectionJActivity.class.getName();

    @BindView(R.id.tl01)
    RadioGroup tl01;
    @BindView(R.id.tl01a)
    RadioButton tl01a;
    @BindView(R.id.tl01b)
    RadioButton tl01b;
    @BindView(R.id.tl01c)
    RadioButton tl01c;
    @BindView(R.id.tl0188)
    RadioButton tl0188;
    @BindView(R.id.tl0188x)
    EditText tl0188x;
    @BindView(R.id.fldGrptl02)
    LinearLayout fldGrptl02;
    @BindView(R.id.tl02)
    RadioGroup tl02;
    @BindView(R.id.tl02a)
    RadioButton tl02a;
    @BindView(R.id.tl02b)
    RadioButton tl02b;
    @BindView(R.id.tl03)
    RadioGroup tl03;
    @BindView(R.id.tl03a)
    RadioButton tl03a;
    @BindView(R.id.tl03b)
    RadioButton tl03b;
    @BindView(R.id.fldGrptl04)
    LinearLayout fldGrptl04;
    @BindView(R.id.tl04a)
    CheckBox tl04a;
    @BindView(R.id.tl04b)
    CheckBox tl04b;
    @BindView(R.id.tl04c)
    CheckBox tl04c;
    @BindView(R.id.tl04d)
    CheckBox tl04d;
    @BindView(R.id.fldGrptl05)
    LinearLayout fldGrptl05;
    @BindView(R.id.tl05)
    RadioGroup tl05;
    @BindView(R.id.tl05a)
    RadioButton tl05a;
    @BindView(R.id.tl05b)
    RadioButton tl05b;
    @BindView(R.id.fldGrptl06)
    LinearLayout fldGrptl06;
    @BindView(R.id.tl06)
    RadioGroup tl06;
    @BindView(R.id.tl06a)
    RadioButton tl06a;
    @BindView(R.id.tl06b)
    RadioButton tl06b;
    @BindView(R.id.fldGrptl07)
    LinearLayout fldGrptl07;
    @BindView(R.id.tl07a)
    CheckBox tl07a;
    @BindView(R.id.tl07b)
    CheckBox tl07b;
    @BindView(R.id.tl07c)
    CheckBox tl07c;
    @BindView(R.id.tl07d)
    CheckBox tl07d;
    @BindView(R.id.tl08a)
    CheckBox tl08a;
    @BindView(R.id.tl08b)
    CheckBox tl08b;
    @BindView(R.id.tl08c)
    CheckBox tl08c;
    @BindView(R.id.tl08d)
    CheckBox tl08d;
    @BindView(R.id.tl08e)
    CheckBox tl08e;
    @BindView(R.id.tl08f)
    CheckBox tl08f;
    @BindView(R.id.tl08g)
    CheckBox tl08g;
    @BindView(R.id.tl08h)
    CheckBox tl08h;
    @BindView(R.id.tl08i)
    CheckBox tl08i;
    @BindView(R.id.tl09)
    RadioGroup tl09;
    @BindView(R.id.tl09a)
    RadioButton tl09a;
    @BindView(R.id.tl09b)
    RadioButton tl09b;
    @BindView(R.id.tl09c)
    RadioButton tl09c;
    @BindView(R.id.tl09d)
    RadioButton tl09d;
    @BindView(R.id.tl0988)
    RadioButton tl0988;
    @BindView(R.id.tl0988x)
    EditText tl0988x;

    @BindView(R.id.tl10)
    RadioGroup tl10;
    @BindView(R.id.tl10a)
    RadioButton tl10a;
    @BindView(R.id.tl10b)
    RadioButton tl10b;
    @BindView(R.id.tl11)
    RadioGroup tl11;
    @BindView(R.id.tl11a)
    RadioButton tl11a;
    @BindView(R.id.tl11b)
    RadioButton tl11b;
    @BindView(R.id.tl11c)
    RadioButton tl11c;
    @BindView(R.id.tl11d)
    RadioButton tl11d;
    @BindView(R.id.tl1188)
    RadioButton tl1188;
    @BindView(R.id.tl1188x)
    EditText tl1188x;
    @BindView(R.id.tl12)
    RadioGroup tl12;
    @BindView(R.id.tl12a)
    RadioButton tl12a;
    @BindView(R.id.tl12b)
    RadioButton tl12b;
    @BindView(R.id.tl12c)
    RadioButton tl12c;
    @BindView(R.id.tl1288)
    RadioButton tl1288;
    @BindView(R.id.tl1288x)
    EditText tl1288x;
    @BindView(R.id.fldGrptl11)
    LinearLayout fldGrptl11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_l);
        ButterKnife.bind(this);

        tl01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (tl01a.isChecked()) {
                    fldGrptl02.setVisibility(View.VISIBLE);
                } else {
                    fldGrptl02.setVisibility(View.GONE);
                    tl02.clearCheck();
                    tl03.clearCheck();
                    tl04a.setChecked(false);
                    tl04b.setChecked(false);
                    tl04c.setChecked(false);
                    tl04d.setChecked(false);

                }
            }
        });

        tl0188.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tl0188x.setVisibility(View.VISIBLE);
                } else {
                    tl0188x.setVisibility(View.GONE);
                    tl0188x.setText(null);
                }
            }
        });

        tl03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (tl03a.isChecked()) {
                    fldGrptl04.setVisibility(View.VISIBLE);
                    fldGrptl05.setVisibility(View.GONE);
                    tl05.clearCheck();
                    tl06.clearCheck();
                    tl07a.setChecked(false);
                    tl07b.setChecked(false);
                    tl07c.setChecked(false);
                    tl07d.setChecked(false);
                } else {
                    fldGrptl04.setVisibility(View.GONE);
                    tl04a.setChecked(false);
                    tl04b.setChecked(false);
                    tl04c.setChecked(false);
                    tl04d.setChecked(false);
                    fldGrptl05.setVisibility(View.VISIBLE);
                }
            }
        });

        tl05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (tl05a.isChecked()) {
                    fldGrptl06.setVisibility(View.VISIBLE);
                } else {
                    fldGrptl06.setVisibility(View.GONE);
                    tl06.clearCheck();
                    tl07a.setChecked(false);
                    tl07b.setChecked(false);
                    tl07c.setChecked(false);
                    tl07d.setChecked(false);
                }
            }
        });

        tl06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (tl06a.isChecked()) {
                    fldGrptl07.setVisibility(View.VISIBLE);
                } else {
                    fldGrptl07.setVisibility(View.GONE);
                    tl07a.setChecked(false);
                    tl07b.setChecked(false);
                    tl07c.setChecked(false);
                    tl07d.setChecked(false);
                }
            }
        });

        tl0988.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tl0988x.setVisibility(View.VISIBLE);
                } else {
                    tl0988x.setVisibility(View.GONE);
                    tl0988x.setText(null);
                }
            }
        });

        tl1188.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tl1188x.setVisibility(View.VISIBLE);
                } else {
                    tl1188x.setVisibility(View.GONE);
                    tl1188x.setText(null);
                }
            }
        });

        tl1288.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tl1288x.setVisibility(View.VISIBLE);
                } else {
                    tl1288x.setVisibility(View.GONE);
                    tl1288x.setText(null);
                }
            }
        });

        tl10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (tl10a.isChecked()) {
                    fldGrptl11.setVisibility(View.VISIBLE);
                } else {
                    fldGrptl11.setVisibility(View.GONE);
                    tl11.clearCheck();
                    tl1188x.setText(null);
                    tl12.clearCheck();
                    tl1288x.setText(null);
                }
            }
        });

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
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                finish();

//                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
                startActivity(new Intent(this, SectionGActivity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sL = new JSONObject();

        sL.put("tl01", tl01a.isChecked() ? "1" : tl01b.isChecked() ? "2" : tl01c.isChecked() ? "3"
                : tl0188.isChecked() ? "88" : "0");
        sL.put("tl0188x", tl0188x.getText().toString());

        sL.put("tl02", tl02a.isChecked() ? "1" : tl02b.isChecked() ? "2" : "0");
        sL.put("tl03", tl03a.isChecked() ? "1" : tl03b.isChecked() ? "2" : "0");

        sL.put("tl04a", tl04a.isChecked() ? "1" : "0");
        sL.put("tl04b", tl04b.isChecked() ? "2" : "0");
        sL.put("tl04c", tl04c.isChecked() ? "3" : "0");
        sL.put("tl04d", tl04d.isChecked() ? "4" : "0");

        sL.put("tl05", tl05a.isChecked() ? "1" : tl05b.isChecked() ? "2" : "0");
        sL.put("tl06", tl06a.isChecked() ? "1" : tl06b.isChecked() ? "2" : "0");

        sL.put("tl07a", tl07a.isChecked() ? "1" : "0");
        sL.put("tl07b", tl07b.isChecked() ? "2" : "0");
        sL.put("tl07c", tl07c.isChecked() ? "3" : "0");
        sL.put("tl07d", tl07d.isChecked() ? "4" : "0");

        sL.put("tl08a", tl08a.isChecked() ? "1" : "0");
        sL.put("tl08b", tl08b.isChecked() ? "2" : "0");
        sL.put("tl08c", tl08c.isChecked() ? "3" : "0");
        sL.put("tl08d", tl08d.isChecked() ? "4" : "0");
        sL.put("tl08e", tl08e.isChecked() ? "5" : "0");
        sL.put("tl08f", tl08f.isChecked() ? "6" : "0");
        sL.put("tl08g", tl08g.isChecked() ? "7" : "0");
        sL.put("tl08h", tl08h.isChecked() ? "8" : "0");
        sL.put("tl08i", tl08i.isChecked() ? "9" : "0");

        sL.put("tl09", tl09a.isChecked() ? "1" : tl09b.isChecked() ? "2" : tl09c.isChecked() ? "3"
                : tl09d.isChecked() ? "4" : tl0988.isChecked() ? "88" : "0");
        sL.put("tl0988x", tl0988x.getText().toString());

        sL.put("tl10", tl10a.isChecked() ? "1" : tl10b.isChecked() ? "2" : "0");
        sL.put("tl11", tl11a.isChecked() ? "1" : tl11b.isChecked() ? "2" : tl11c.isChecked() ? "3"
                : tl11d.isChecked() ? "4" : tl1188.isChecked() ? "88" : "0");
        sL.put("tl1188x", tl1188x.getText().toString());
        sL.put("tl12", tl12a.isChecked() ? "1" : tl12b.isChecked() ? "2" : tl12c.isChecked() ? "3"
                : tl1288.isChecked() ? "88" : "0");
        sL.put("tl1288x", tl1288x.getText().toString());

        MainApp.fc.setsL(String.valueOf(sL));
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSL();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//         01
        if (tl01.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tl01), Toast.LENGTH_SHORT).show();
            tl0188.setError("This data is Required!");    // Set Error on last radio button
            tl01a.setFocusable(true);
            tl01a.setFocusableInTouchMode(true);
            tl01a.requestFocus();
            Log.i(TAG, "tl01: This data is Required!");
            return false;
        } else {
            tl0188.setError(null);
        }
        if (tl0188.isChecked() && tl0188x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
            tl0188x.setError("This data is Required! ");    // Set Error on last radio button
            tl0188x.requestFocus();
            Log.i(TAG, "tl0188x: This data is Required!");
            return false;
        } else {
            tl0188x.setError(null);
        }

        if (tl01a.isChecked()) {
//        02
            if (tl02.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tl02), Toast.LENGTH_SHORT).show();
                tl02b.setError("This data is Required! ");    // Set Error on last radio button
                tl02b.setFocusable(true);
                tl02b.setFocusableInTouchMode(true);
                tl02b.requestFocus();
                Log.i(TAG, "tl02: This data is Required!");
                return false;
            } else {
                tl02b.setError(null);
            }

//        03
            if (tl03.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tl03), Toast.LENGTH_SHORT).show();
                tl03b.setError("This data is Required! ");    // Set Error on last radio button
                tl03b.setFocusable(true);
                tl03b.setFocusableInTouchMode(true);
                tl03b.requestFocus();
                Log.i(TAG, "tl03: This data is Required!");
                return false;
            } else {
                tl03b.setError(null);
            }

            if (tl03a.isChecked()) {

//        04
                if (!(tl04a.isChecked() || tl04b.isChecked() || tl04c.isChecked()
                        || tl04d.isChecked())) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tl04), Toast.LENGTH_SHORT).show();
                    tl04d.setError("This data is Required!");    // Set Error on last check box
                    tl04d.setFocusable(true);
                    tl04d.setFocusableInTouchMode(true);
                    tl04d.requestFocus();
                    Log.i(TAG, "tl04: This data is Required!");
                    return false;
                } else {
                    tl04d.setError(null);
                }
            }
        } else {

            //if (!(tl04a.isChecked() || tl04b.isChecked() || tl04c.isChecked() || tl04d.isChecked())) {
//        05
            if (tl05.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tl05), Toast.LENGTH_SHORT).show();
                tl05b.setError("This data is Required! ");    // Set Error on last radio button
                tl05b.setFocusable(true);
                tl05b.setFocusableInTouchMode(true);
                tl05b.requestFocus();
                Log.i(TAG, "tl05: This data is Required!");
                return false;
            } else {
                tl05b.setError(null);
            }

            if (tl05a.isChecked()) {
//        06
                if (tl06.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tl06), Toast.LENGTH_SHORT).show();
                    tl06b.setError("This data is Required! ");    // Set Error on last radio button
                    tl06b.setFocusable(true);
                    tl06b.setFocusableInTouchMode(true);
                    tl06b.requestFocus();
                    Log.i(TAG, "tl06: This data is Required!");
                    return false;
                } else {
                    tl06b.setError(null);
                }

                if (tl06a.isChecked()) {
//        07
                    if (!(tl07a.isChecked() || tl07b.isChecked() || tl07c.isChecked()
                            || tl07d.isChecked())) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.tl07), Toast.LENGTH_SHORT).show();
                        tl07d.setError("This data is Required!");    // Set Error on last check box
                        tl07d.requestFocus();
                        Log.i(TAG, "tl07: This data is Required!");
                        return false;
                    } else {
                        tl07d.setError(null);
                    }
                }
            }
        }


//        08
        if (!(tl08a.isChecked() || tl08b.isChecked() || tl08c.isChecked() || tl08d.isChecked() ||
                tl08e.isChecked() || tl08f.isChecked() || tl08g.isChecked() ||
                tl08h.isChecked() || tl08i.isChecked())) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tl08), Toast.LENGTH_SHORT).show();
            tl08i.setError("This data is Required!");    // Set Error on last check box
            tl08i.requestFocus();
            Log.i(TAG, "tl08: This data is Required!");
            return false;
        } else {
            tl08i.setError(null);
        }

//        09
        if (tl09.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tl09), Toast.LENGTH_SHORT).show();
            tl0988.setError("This data is Required!");    // Set Error on last radio button
            tl09a.setFocusable(true);
            tl09a.setFocusableInTouchMode(true);
            tl09a.requestFocus();
            Log.i(TAG, "tl09: This data is Required!");
            return false;
        } else {
            tl0988.setError(null);
        }
        if (tl0988.isChecked() && tl0988x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
            tl0988x.setError("This data is Required! ");    // Set Error on last radio button
            tl0988x.requestFocus();
            Log.i(TAG, "tl0988x: This data is Required!");
            return false;
        } else {
            tl0988x.setError(null);
        }

//        10
        if (tl10.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tl10), Toast.LENGTH_SHORT).show();
            tl10b.setError("This data is Required!");    // Set Error on last radio button
            tl10b.setFocusable(true);
            tl10b.setFocusableInTouchMode(true);
            tl10b.requestFocus();
            Log.i(TAG, "tl10: This data is Required!");
            return false;
        } else {
            tl10b.setError(null);
        }

//        11

        if (tl10a.isChecked()) {
            if (tl11.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tl11), Toast.LENGTH_SHORT).show();
                tl1188.setError("This data is Required!");    // Set Error on last radio button
                tl11a.setFocusable(true);
                tl11a.setFocusableInTouchMode(true);
                tl11a.requestFocus();
                Log.i(TAG, "tl11: This data is Required!");
                return false;
            } else {
                tl1188.setError(null);
            }
            if (tl1188.isChecked() && tl1188x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
                tl1188x.setError("This data is Required! ");    // Set Error on last radio button
                tl1188x.requestFocus();
                Log.i(TAG, "tl1188x: This data is Required!");
                return false;
            } else {
                tl1188x.setError(null);
            }

//        12
            if (tl12.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tl12), Toast.LENGTH_SHORT).show();
                tl1288.setError("This data is Required!");    // Set Error on last radio button
                tl12a.setFocusable(true);
                tl12a.setFocusableInTouchMode(true);
                tl12a.requestFocus();
                Log.i(TAG, "tl12: This data is Required!");
                return false;
            } else {
                tl1288.setError(null);
            }
            if (tl1288.isChecked() && tl1288x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
                tl1288x.setError("This data is Required! ");    // Set Error on last radio button
                tl1288x.requestFocus();
                Log.i(TAG, "tl1288x: This data is Required!");
                return false;
            } else {
                tl1288x.setError(null);
            }
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}

