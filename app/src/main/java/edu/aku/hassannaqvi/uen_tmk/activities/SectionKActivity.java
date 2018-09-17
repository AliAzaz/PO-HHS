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
import android.widget.ScrollView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.uen_tmk.R;
import edu.aku.hassannaqvi.uen_tmk.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk.core.MainApp;

public class SectionKActivity extends Activity {

    private static final String TAG = SectionKActivity.class.getSimpleName();

    @BindView(R.id.activity_section_a)
    ScrollView activitySectionA;
    @BindView(R.id.tk01)
    RadioGroup tk01;
    @BindView(R.id.tk01a)
    RadioButton tk01a;
    @BindView(R.id.tk01b)
    RadioButton tk01b;
    @BindView(R.id.tk01c)
    RadioButton tk01c;
    @BindView(R.id.tk01d)
    RadioButton tk01d;
    @BindView(R.id.tk01e)
    RadioButton tk01e;
    @BindView(R.id.tk01f)
    RadioButton tk01f;
    @BindView(R.id.tk01g)
    RadioButton tk01g;
    @BindView(R.id.tk01h)
    RadioButton tk01h;
    @BindView(R.id.tk01i)
    RadioButton tk01i;
    @BindView(R.id.tk01j)
    RadioButton tk01j;
    @BindView(R.id.tk01k)
    RadioButton tk01k;
    @BindView(R.id.tk01l)
    RadioButton tk01l;
    @BindView(R.id.tk01m)
    RadioButton tk01m;
    @BindView(R.id.tk01n)
    RadioButton tk01n;
    @BindView(R.id.tk0188)
    RadioButton tk0188;
    @BindView(R.id.tk0188x)
    EditText tk0188x;
    @BindView(R.id.tk02)
    RadioGroup tk02;
    @BindView(R.id.tk02a)
    RadioButton tk02a;
    @BindView(R.id.tk02b)
    RadioButton tk02b;
    @BindView(R.id.tk02c)
    RadioButton tk02c;
    @BindView(R.id.tk02d)
    RadioButton tk02d;
    @BindView(R.id.tk02e)
    RadioButton tk02e;
    @BindView(R.id.tk02f)
    RadioButton tk02f;
    @BindView(R.id.tk02g)
    RadioButton tk02g;
    @BindView(R.id.tk02h)
    RadioButton tk02h;
    @BindView(R.id.tk02i)
    RadioButton tk02i;
    @BindView(R.id.tk02j)
    RadioButton tk02j;
    @BindView(R.id.tk02k)
    RadioButton tk02k;
    @BindView(R.id.tk02l)
    RadioButton tk02l;
    @BindView(R.id.tk02m)
    RadioButton tk02m;
    @BindView(R.id.tk02n)
    RadioButton tk02n;
    @BindView(R.id.tk0288)
    RadioButton tk0288;
    @BindView(R.id.tk0288x)
    EditText tk0288x;
    @BindView(R.id.tk03)
    RadioGroup tk03;
    @BindView(R.id.tk03a)
    RadioButton tk03a;
    @BindView(R.id.tk03b)
    RadioButton tk03b;
    @BindView(R.id.tk03c)
    RadioButton tk03c;
    @BindView(R.id.tk04)
    EditText tk04;
    @BindView(R.id.tk04888)
    CheckBox tk04888;
    @BindView(R.id.tk05)
    RadioGroup tk05;
    @BindView(R.id.tk05a)
    RadioButton tk05a;
    @BindView(R.id.tk05b)
    RadioButton tk05b;
    @BindView(R.id.tk05c)
    RadioButton tk05c;
    @BindView(R.id.tk05d)
    RadioButton tk05d;
    @BindView(R.id.tk05e)
    RadioButton tk05e;
    @BindView(R.id.tk06)
    RadioGroup tk06;
    @BindView(R.id.tk06a)
    RadioButton tk06a;
    @BindView(R.id.tk06b)
    RadioButton tk06b;
    @BindView(R.id.tk07)
    RadioGroup tk07;
    @BindView(R.id.tk07a)
    RadioButton tk07a;
    @BindView(R.id.tk07b)
    RadioButton tk07b;
    @BindView(R.id.tk07888)
    RadioButton tk07888;
    @BindView(R.id.tk08)
    RadioGroup tk08;
    @BindView(R.id.tk08a)
    RadioButton tk08a;
    @BindView(R.id.tk08b)
    RadioButton tk08b;
    @BindView(R.id.tk08888)
    RadioButton tk08888;
    @BindView(R.id.tk09)
    RadioGroup tk09;
    @BindView(R.id.tk09a)
    RadioButton tk09a;
    @BindView(R.id.tk09b)
    RadioButton tk09b;
    @BindView(R.id.tk09c)
    RadioButton tk09c;
    @BindView(R.id.tk09d)
    RadioButton tk09d;
    @BindView(R.id.tk09e)
    RadioButton tk09e;
    @BindView(R.id.tk09f)
    RadioButton tk09f;
    @BindView(R.id.tk09g)
    RadioButton tk09g;
    @BindView(R.id.tk0988)
    RadioButton tk0988;
    @BindView(R.id.tk0988x)
    EditText tk0988x;
    @BindView(R.id.tk10)
    RadioGroup tk10;
    @BindView(R.id.tk10a)
    RadioButton tk10a;
    @BindView(R.id.tk10b)
    RadioButton tk10b;
    @BindView(R.id.tk10c)
    RadioButton tk10c;
    @BindView(R.id.tk10d)
    RadioButton tk10d;
    @BindView(R.id.tk10e)
    RadioButton tk10e;
    @BindView(R.id.tk1088)
    RadioButton tk1088;
    @BindView(R.id.tk1088x)
    EditText tk1088x;
    @BindView(R.id.tk11)
    RadioGroup tk11;
    @BindView(R.id.tk11a)
    RadioButton tk11a;
    @BindView(R.id.tk11b)
    RadioButton tk11b;
    @BindView(R.id.tk11c)
    RadioButton tk11c;
    @BindView(R.id.tk11d)
    RadioButton tk11d;
    @BindView(R.id.tk11e)
    RadioButton tk11e;
    @BindView(R.id.tk11f)
    RadioButton tk11f;
    @BindView(R.id.tk11g)
    RadioButton tk11g;
    @BindView(R.id.tk11h)
    RadioButton tk11h;
    @BindView(R.id.tk11i)
    RadioButton tk11i;
    @BindView(R.id.tk11j)
    RadioButton tk11j;
    @BindView(R.id.tk11k)
    RadioButton tk11k;
    @BindView(R.id.tk12)
    RadioGroup tk12;
    @BindView(R.id.tk12a)
    RadioButton tk12a;
    @BindView(R.id.tk12b)
    RadioButton tk12b;
    @BindView(R.id.tk12888)
    RadioButton tk12888;
    @BindView(R.id.tk13)
    RadioGroup tk13;
    @BindView(R.id.tk13a)
    RadioButton tk13a;
    @BindView(R.id.tk13b)
    RadioButton tk13b;
    @BindView(R.id.tk14)
    RadioGroup tk14;
    @BindView(R.id.tk14a)
    RadioButton tk14a;
    @BindView(R.id.tk14b)
    RadioButton tk14b;
    @BindView(R.id.tk14888)
    RadioButton tk14888;
    @BindView(R.id.fldGrptk04)
    LinearLayout fldGrptk04;
    @BindView(R.id.fldGrptk09)
    LinearLayout fldGrptk09;
    @BindView(R.id.fldGrptk13)
    LinearLayout fldGrptk13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_k);
        ButterKnife.bind(this);

        tk0188.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tk0188x.setVisibility(View.VISIBLE);
                } else {
                    tk0188x.setVisibility(View.GONE);
                    tk0188x.setText(null);
                }
            }
        });

        tk0288.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tk0288x.setVisibility(View.VISIBLE);
                } else {
                    tk0288x.setVisibility(View.GONE);
                    tk0288x.setText(null);
                }
            }
        });

        tk03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.tk03c) {
                    fldGrptk04.setVisibility(View.VISIBLE);
                } else {
                    fldGrptk04.setVisibility(View.GONE);
                    tk04.setText(null);
                    tk04888.setChecked(false);
                    tk05.clearCheck();
                }
            }
        });

        tk04888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tk04.setVisibility(View.GONE);
                    tk04.setText(null);
                } else {
                    tk04.setVisibility(View.VISIBLE);
                }
            }
        });

        tk08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (tk08a.isChecked()) {
                    fldGrptk09.setVisibility(View.VISIBLE);
                } else {
                    fldGrptk09.setVisibility(View.GONE);
                    tk09.clearCheck();
                    tk0988x.setText(null);
                }
            }
        });

        tk0988.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tk0988x.setVisibility(View.VISIBLE);
                } else {
                    tk0988x.setVisibility(View.GONE);
                    tk0988x.setText(null);
                }
            }
        });

        tk1088.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tk1088x.setVisibility(View.VISIBLE);
                } else {
                    tk1088x.setVisibility(View.GONE);
                    tk1088x.setText(null);
                }
            }
        });

        tk12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (tk12a.isChecked()) {
                    fldGrptk13.setVisibility(View.VISIBLE);
                } else {
                    fldGrptk13.setVisibility(View.GONE);
                    tk13.clearCheck();
                    tk14.clearCheck();
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
            /*try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }*/
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                finish();

                Intent secNext = new Intent(this, SectionLActivity.class);
                startActivity(secNext);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        /*int updcount = db.updateSK();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        return true;

    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sK = new JSONObject();

        sK.put("tk01", tk01a.isChecked() ? "1" : tk01b.isChecked() ? "2" : tk01c.isChecked() ? "3" : tk01d.isChecked() ? "4"
                : tk01e.isChecked() ? "5" : tk01f.isChecked() ? "6" : tk01g.isChecked() ? "7" : tk01h.isChecked() ? "8"
                : tk01i.isChecked() ? "9" : tk01j.isChecked() ? "10" : tk01k.isChecked() ? "11" : tk01l.isChecked() ? "12"
                : tk01m.isChecked() ? "13" : tk01n.isChecked() ? "14" : tk0188.isChecked() ? "88" : "0");
        sK.put("tk0188x", tk0188x.getText().toString());

        sK.put("tk02", tk02a.isChecked() ? "1" : tk02b.isChecked() ? "2" : tk02c.isChecked() ? "3" : tk02d.isChecked() ? "4"
                : tk02e.isChecked() ? "5" : tk02f.isChecked() ? "6" : tk02g.isChecked() ? "7" : tk02h.isChecked() ? "8"
                : tk02i.isChecked() ? "9" : tk02j.isChecked() ? "10" : tk02k.isChecked() ? "11" : tk02l.isChecked() ? "12"
                : tk02m.isChecked() ? "13" : tk02n.isChecked() ? "14" : tk0288.isChecked() ? "88" : "0");
        sK.put("tk0288x", tk0288x.getText().toString());
        sK.put("tk03", tk03a.isChecked() ? "1" : tk03b.isChecked() ? "2" : tk03c.isChecked() ? "3" : "0");
        sK.put("tk04", tk04.getText().toString());
        sK.put("tk04888", tk04888.isChecked() ? "888" : "0");
        sK.put("tk05", tk05a.isChecked() ? "1" : tk05b.isChecked() ? "2" : tk05c.isChecked() ? "3" :
                tk05d.isChecked() ? "4" : tk05e.isChecked() ? "5" : "0");
        sK.put("tk06", tk06a.isChecked() ? "1" : tk06b.isChecked() ? "2" : "0");
        sK.put("tk07", tk07a.isChecked() ? "1" : tk07b.isChecked() ? "2" : tk07888.isChecked() ? "888" : "0");
        sK.put("tk08", tk08a.isChecked() ? "1" : tk08b.isChecked() ? "2" : tk08888.isChecked() ? "888" : "0");
        sK.put("tk09", tk09a.isChecked() ? "1" : tk09b.isChecked() ? "2" : tk09c.isChecked() ? "3" : tk09d.isChecked() ? "4"
                : tk09e.isChecked() ? "5" : tk09f.isChecked() ? "6" : tk09g.isChecked() ? "7" : tk0988.isChecked() ? "88" : "0");
        sK.put("tk0988x", tk0988x.getText().toString());

        sK.put("tk10", tk10a.isChecked() ? "1" : tk10b.isChecked() ? "2" : tk10c.isChecked() ? "3" : tk10d.isChecked() ? "4"
                : tk10e.isChecked() ? "5" : tk1088.isChecked() ? "88" : "0");
        sK.put("tk1088x", tk1088x.getText().toString());

        sK.put("tk11", tk11a.isChecked() ? "1" : tk11b.isChecked() ? "2" : tk11c.isChecked() ? "3" : tk11d.isChecked() ? "4"
                : tk11e.isChecked() ? "5" : tk11f.isChecked() ? "6" : tk11g.isChecked() ? "7" : tk11h.isChecked() ? "8"
                : tk11i.isChecked() ? "9" : tk11j.isChecked() ? "10" : tk11k.isChecked() ? "11" : "0");

        sK.put("tk12", tk12a.isChecked() ? "1" : tk12b.isChecked() ? "2" : tk12888.isChecked() ? "888" : "0");
        sK.put("tk13", tk13a.isChecked() ? "1" : tk13b.isChecked() ? "2" : "0");
        sK.put("tk14", tk14a.isChecked() ? "1" : tk14b.isChecked() ? "2" : tk14888.isChecked() ? "888" : "0");

        MainApp.fc.setsK(String.valueOf(sK));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    public boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (tk01.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tk01), Toast.LENGTH_SHORT).show();
            tk01a.setError("This data is Required!");    // Set Error on last radio button
            tk01a.setFocusable(true);
            tk01a.setFocusableInTouchMode(true);
            tk01a.requestFocus();
            Log.i(TAG, "tk01: This data is Required!");
            return false;
        } else {
            tk01a.setError(null);
        }

        if (tk0188.isChecked() && tk0188x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty)" + getString(R.string.tk01) + " - " + getString(R.string.other), Toast.LENGTH_SHORT).show();
            tk0188x.setError("This data is Required!");
            tk0188x.requestFocus();
            Log.i(TAG, "tk0188x: This data is Required!");
            return false;
        } else {
            tk0188x.setError(null);
        }

        if (tk02.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tk02), Toast.LENGTH_SHORT).show();
            tk02a.setError("This data is Required!");    // Set Error on last radio button
            tk02a.setFocusable(true);
            tk02a.setFocusableInTouchMode(true);
            tk02a.requestFocus();
            Log.i(TAG, "tk02: This data is Required!");
            return false;
        } else {
            tk02a.setError(null);
        }

        if (tk0288.isChecked() && tk0288x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty)" + getString(R.string.tk02) + " - " + getString(R.string.other), Toast.LENGTH_SHORT).show();
            tk0288x.setError("This data is Required!");
            tk0288x.requestFocus();
            Log.i(TAG, "tk0288x: This data is Required!");
            return false;
        } else {
            tk0288x.setError(null);
        }

        if (tk03.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tk03), Toast.LENGTH_SHORT).show();
            tk03a.setError("This data is Required!");    // Set Error on last radio button
            tk03a.setFocusable(true);
            tk03a.setFocusableInTouchMode(true);
            tk03a.requestFocus();
            Log.i(TAG, "tk03: This data is Required!");
            return false;
        } else {
            tk03a.setError(null);
        }

        if (tk03c.isChecked()) {
            if (!tk04888.isChecked()) {
                if (tk04.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tk04), Toast.LENGTH_SHORT).show();
                    tk04.setError("This data is Required!");    // Set Error on last radio button
                    tk04.requestFocus();
                    Log.i(TAG, "tk04: This data is Required!");
                    return false;
                } else {
                    tk04.setError(null);
                }

                if (Integer.parseInt(tk04.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(invalid): " + getString(R.string.tk04), Toast.LENGTH_SHORT).show();
                    tk04.setError("Zero not allowed");
                    tk04.requestFocus();
                    Log.i(TAG, "tk04: Zero not allowed");
                    return false;
                } else {
                    tk04.setError(null);
                }
            }
            if (tk05.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tk05), Toast.LENGTH_SHORT).show();
                tk05a.setError("This data is Required!");    // Set Error on last radio button
                tk05a.setFocusable(true);
                tk05a.setFocusableInTouchMode(true);
                tk05a.requestFocus();
                Log.i(TAG, "tk05: This data is Required!");
                return false;
            } else {
                tk05a.setError(null);
            }

        }

        if (tk06.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tk06), Toast.LENGTH_SHORT).show();
            tk06a.setError("This data is Required!");    // Set Error on last radio button
            tk06a.setFocusable(true);
            tk06a.setFocusableInTouchMode(true);
            tk06a.requestFocus();
            Log.i(TAG, "tk06: This data is Required!");
            return false;
        } else {
            tk06a.setError(null);
        }

        if (tk07.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tk07), Toast.LENGTH_SHORT).show();
            tk07a.setError("This data is Required!");    // Set Error on last radio button
            tk07a.setFocusable(true);
            tk07a.setFocusableInTouchMode(true);
            tk07a.requestFocus();
            Log.i(TAG, "tk07: This data is Required!");
            return false;
        } else {
            tk07a.setError(null);
        }

        if (tk08.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tk08), Toast.LENGTH_SHORT).show();
            tk08a.setError("This data is Required!");    // Set Error on last radio button
            tk08a.setFocusable(true);
            tk08a.setFocusableInTouchMode(true);
            tk08a.requestFocus();
            Log.i(TAG, "tk08: This data is Required!");
            return false;
        } else {
            tk08a.setError(null);
        }

        if (tk08a.isChecked()) {
            if (tk09.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tk09), Toast.LENGTH_SHORT).show();
                tk09a.setError("This data is Required!");    // Set Error on last radio button
                tk09a.setFocusable(true);
                tk09a.setFocusableInTouchMode(true);
                tk09a.requestFocus();
                Log.i(TAG, "tk09: This data is Required!");
                return false;
            } else {
                tk09a.setError(null);
            }

            if (tk0988.isChecked() && tk0988x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty)" + getString(R.string.tk09) + " - " + getString(R.string.other), Toast.LENGTH_SHORT).show();
                tk0988x.setError("This data is Required!");
                tk0988x.requestFocus();
                Log.i(TAG, "tk0988x: This data is Required!");
                return false;
            } else {
                tk0988x.setError(null);
            }
        }

        if (tk10.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tk10), Toast.LENGTH_SHORT).show();
            tk10a.setError("This data is Required!");    // Set Error on last radio button
            tk10a.setFocusable(true);
            tk10a.setFocusableInTouchMode(true);
            tk10a.requestFocus();
            Log.i(TAG, "tk10: This data is Required!");
            return false;
        } else {
            tk10a.setError(null);
        }

        if (tk1088.isChecked() && tk1088x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty)" + getString(R.string.tk10) + " - " + getString(R.string.other), Toast.LENGTH_SHORT).show();
            tk1088x.setError("This data is Required!");
            tk1088x.requestFocus();
            Log.i(TAG, "tk1088x: This data is Required!");
            return false;
        } else {
            tk1088x.setError(null);
        }

        if (tk11.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tk11), Toast.LENGTH_SHORT).show();
            tk11a.setError("This data is Required!");    // Set Error on last radio button
            tk11a.setFocusable(true);
            tk11a.setFocusableInTouchMode(true);
            tk11a.requestFocus();
            Log.i(TAG, "tk11: This data is Required!");
            return false;
        } else {
            tk11a.setError(null);
        }

        if (tk12.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tk12), Toast.LENGTH_SHORT).show();
            tk12a.setError("This data is Required!");    // Set Error on last radio button
            tk12a.setFocusable(true);
            tk12a.setFocusableInTouchMode(true);
            tk12a.requestFocus();
            Log.i(TAG, "tk12: This data is Required!");
            return false;
        } else {
            tk12a.setError(null);
        }

        if (tk12a.isChecked()) {
            if (tk13.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tk13), Toast.LENGTH_SHORT).show();
                tk13a.setError("This data is Required!");    // Set Error on last radio button
                tk13a.setFocusable(true);
                tk13a.setFocusableInTouchMode(true);
                tk13a.requestFocus();
                Log.i(TAG, "tk13: This data is Required!");
                return false;
            } else {
                tk13a.setError(null);
            }

            if (tk14.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tk14), Toast.LENGTH_SHORT).show();
                tk14a.setError("This data is Required!");    // Set Error on last radio button
                tk14a.setFocusable(true);
                tk14a.setFocusableInTouchMode(true);
                tk14a.requestFocus();
                Log.i(TAG, "tk14: This data is Required!");
                return false;
            } else {
                tk14a.setError(null);
            }
        }


        return true;
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }


}
