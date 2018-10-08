package edu.aku.hassannaqvi.uen_po_hhs.activities;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.uen_po_hhs.R;
import edu.aku.hassannaqvi.uen_po_hhs.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_po_hhs.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs.core.MainApp;

public class SectionJActivity extends Activity {

    private static final String TAG = SectionJActivity.class.getName();
    @BindView(R.id.scroll)
    ScrollView scroll;
    @BindView(R.id.tj01)
    Spinner tj01;
    @BindView(R.id.tj02)
    RadioGroup tj02;
    @BindView(R.id.tj02a)
    RadioButton tj02a;
    @BindView(R.id.tj02b)
    RadioButton tj02b;
    @BindView(R.id.tj02c)
    RadioButton tj02c;
    @BindView(R.id.tj02d)
    RadioButton tj02d;
    @BindView(R.id.tj02e)
    RadioButton tj02e;
    @BindView(R.id.tj02f)
    RadioButton tj02f;
    @BindView(R.id.tj02g)
    RadioButton tj02g;
    @BindView(R.id.tj02h)
    RadioButton tj02h;
    @BindView(R.id.tj02i)
    RadioButton tj02i;
    @BindView(R.id.tj0288)
    RadioButton tj0288;
    @BindView(R.id.tj0288x)
    EditText tj0288x;
    @BindView(R.id.tj03)
    RadioGroup tj03;
    @BindView(R.id.tj03a)
    RadioButton tj03a;
    @BindView(R.id.tj03b)
    RadioButton tj03b;
    @BindView(R.id.tj03c)
    RadioButton tj03c;
    @BindView(R.id.tj03666)
    RadioButton tj03666;
    @BindView(R.id.tj03888)
    RadioButton tj03888;
    @BindView(R.id.tj03m)
    EditText tj03m;
    @BindView(R.id.tj03h)
    EditText tj03h;
    @BindView(R.id.tj03d)
    EditText tj03d;
    @BindView(R.id.tj04)
    RadioGroup tj04;
    @BindView(R.id.tj04a)
    RadioButton tj04a;
    @BindView(R.id.tj04b)
    RadioButton tj04b;
    @BindView(R.id.fldGrpti05)
    LinearLayout fldGrpti05;
    @BindView(R.id.tj05a)
    CheckBox tj05a;
    @BindView(R.id.tj05b)
    CheckBox tj05b;
    @BindView(R.id.tj05c)
    CheckBox tj05c;
    @BindView(R.id.tj05d)
    CheckBox tj05d;
    @BindView(R.id.tj05e)
    CheckBox tj05e;
    @BindView(R.id.tj05f)
    CheckBox tj05f;
    @BindView(R.id.tj05g)
    CheckBox tj05g;
    @BindView(R.id.tj05h)
    CheckBox tj05h;
    @BindView(R.id.tj06)
    RadioGroup tj06;
    @BindView(R.id.tj06a)
    RadioButton tj06a;
    @BindView(R.id.tj06b)
    RadioButton tj06b;
    @BindView(R.id.fldGrpti07)
    LinearLayout fldGrpti07;
    @BindView(R.id.tj07a)
    CheckBox tj07a;
    @BindView(R.id.tj07b)
    CheckBox tj07b;
    @BindView(R.id.tj07c)
    CheckBox tj07c;
    @BindView(R.id.tj07d)
    CheckBox tj07d;
    @BindView(R.id.tj07e)
    CheckBox tj07e;
    @BindView(R.id.tj07f)
    CheckBox tj07f;
    @BindView(R.id.tj07g)
    CheckBox tj07g;
    @BindView(R.id.tj07h)
    CheckBox tj07h;
    @BindView(R.id.tj0788)
    CheckBox tj0788;
    @BindView(R.id.tj0788x)
    EditText tj0788x;
    @BindView(R.id.fldGrpti08)
    LinearLayout fldGrpti08;
    @BindView(R.id.tj08a)
    CheckBox tj08a;
    @BindView(R.id.tj08b)
    CheckBox tj08b;
    @BindView(R.id.tj08c)
    CheckBox tj08c;
    @BindView(R.id.tj08d)
    CheckBox tj08d;
    @BindView(R.id.tj08e)
    CheckBox tj08e;
    @BindView(R.id.tj08f)
    CheckBox tj08f;
    @BindView(R.id.tj08g)
    CheckBox tj08g;
    @BindView(R.id.tj08h)
    CheckBox tj08h;
    @BindView(R.id.tj08i)
    CheckBox tj08i;
    @BindView(R.id.tj0888)
    CheckBox tj0888;
    @BindView(R.id.tj0888x)
    EditText tj0888x;
    @BindView(R.id.tj09)
    RadioGroup tj09;
    @BindView(R.id.tj09a)
    RadioButton tj09a;
    @BindView(R.id.tj09b)
    RadioButton tj09b;
    @BindView(R.id.tj10)
    RadioGroup tj10;
    @BindView(R.id.tj10a)
    RadioButton tj10a;
    @BindView(R.id.tj10b)
    RadioButton tj10b;
    @BindView(R.id.fldGrpti11)
    LinearLayout fldGrpti11;
    @BindView(R.id.tj11)
    RadioGroup tj11;
    @BindView(R.id.tj11a)
    RadioButton tj11a;
    @BindView(R.id.tj11b)
    RadioButton tj11b;
    @BindView(R.id.tj11888)
    RadioButton tj11888;
    @BindView(R.id.tj11d)
    EditText tj11d;
    @BindView(R.id.tj11m)
    EditText tj11m;
    @BindView(R.id.tj12)
    RadioGroup tj12;
    @BindView(R.id.tj12a)
    RadioButton tj12a;
    @BindView(R.id.tj12b)
    RadioButton tj12b;
    @BindView(R.id.tj12c)
    RadioButton tj12c;
    @BindView(R.id.tj12888)
    RadioButton tj12888;
    @BindView(R.id.tj12d)
    EditText tj12d;
    @BindView(R.id.tj12m)
    EditText tj12m;
    @BindView(R.id.tj13)
    RadioGroup tj13;
    @BindView(R.id.tj13a)
    RadioButton tj13a;
    @BindView(R.id.tj13b)
    RadioButton tj13b;
    @BindView(R.id.tj13c)
    RadioButton tj13c;
    @BindView(R.id.tj13d)
    EditText tj13d;
    @BindView(R.id.tj13m)
    EditText tj13m;
    @BindView(R.id.tj14)
    RadioGroup tj14;
    @BindView(R.id.tj14a)
    RadioButton tj14a;
    @BindView(R.id.tj14b)
    RadioButton tj14b;
    @BindView(R.id.tj14c)
    RadioButton tj14c;
    @BindView(R.id.tj14d)
    RadioButton tj14d;
    @BindView(R.id.tj14e)
    RadioButton tj14e;
    @BindView(R.id.tj14f)
    RadioButton tj14f;
    @BindView(R.id.tj14g)
    RadioButton tj14g;
    @BindView(R.id.tj14h)
    RadioButton tj14h;
    @BindView(R.id.tj14i)
    RadioButton tj14i;
    @BindView(R.id.tj14j)
    RadioButton tj14j;
    @BindView(R.id.tj14k)
    RadioButton tj14k;
    @BindView(R.id.tj14l)
    RadioButton tj14l;
    @BindView(R.id.tj1488)
    RadioButton tj1488;
    @BindView(R.id.tj1488x)
    EditText tj1488x;
    @BindView(R.id.fldtj14)
    LinearLayout fldtj14;

    Map<String, FamilyMembersContract> childsMap;
    ArrayList<String> lstChild;

    int position;
    Long months;
    int childSerial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_j);
        ButterKnife.bind(this);

//        get data from sec B

        childsMap = new HashMap<>();
        lstChild = new ArrayList<>();

        childsMap.put("....", new FamilyMembersContract());
       // lstChild.add("....");

//        for (byte i = 0; i < MainApp.familyMembersList.size(); i++) {
//            if (MainApp.familyMembersList.get(i).getAgeLess5().equals("3")) {
//                childsMap.put(MainApp.familyMembersList.get(i).getName(), new FamilyMembersContract(MainApp.familyMembersList.get(i)));
//                lstChild.add(MainApp.familyMembersList.get(i).getName());
//            }
//        }

        //Checking dix months Child condition
        if(MainApp.sixMonthsCount > 0){
            fldGrpti08.setVisibility(View.VISIBLE);
        }else{
            fldGrpti08.setVisibility(View.GONE);
            tj08a.setChecked(false);
            tj08b.setChecked(false);
            tj08c.setChecked(false);
            tj08d.setChecked(false);
            tj08e.setChecked(false);
            tj08f.setChecked(false);
            tj08g.setChecked(false);
            tj08h.setChecked(false);
            tj08i.setChecked(false);
            tj0888.setChecked(false);
            tj0888x.setText(null);
        }

        tj01.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, MainApp.lstChild));

        tj01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                childSerial = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        tj0288.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (tj0288.isChecked()) {
                    tj0288x.setVisibility(View.VISIBLE);
                    tj0288x.requestFocus();
                } else {
                    tj0288x.setText(null);
                    tj0288x.setVisibility(View.GONE);
                }
            }
        });


        tj04a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (tj04b.isChecked()) {

                    tj05a.setChecked(false);
                    tj05b.setChecked(false);
                    tj05c.setChecked(false);
                    tj05d.setChecked(false);
                    tj05e.setChecked(false);
                    tj05f.setChecked(false);
                    tj05g.setChecked(false);
                    tj05h.setChecked(false);

                    fldGrpti05.setVisibility(View.GONE);
                } else {
                    fldGrpti05.setVisibility(View.VISIBLE);
                }
            }
        });


        tj0788.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (tj0788.isChecked()) {
                    tj0788x.setVisibility(View.VISIBLE);
                    tj0788x.requestFocus();
                } else {
                    tj0788x.setText(null);
                    tj0788x.setVisibility(View.GONE);
                }
            }
        });

        tj0888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (tj0888.isChecked()) {
                    tj0888x.setVisibility(View.VISIBLE);
                    tj0888x.requestFocus();
                } else {
                    tj0888x.setText(null);
                    tj0888x.setVisibility(View.GONE);
                }
            }
        });


        tj1488.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (tj1488.isChecked()) {
                    tj1488x.setVisibility(View.VISIBLE);
                    tj1488x.requestFocus();
                } else {
                    tj1488x.setText(null);
                    tj1488x.setVisibility(View.GONE);
                }
            }
        });

//        03

        tj03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.tj03a) {
                    tj03m.setVisibility(View.VISIBLE);

                    tj03h.setText(null);
                    tj03h.setVisibility(View.GONE);
                    tj03d.setText(null);
                    tj03d.setVisibility(View.GONE);
                } else if (i == R.id.tj03b) {
                    tj03m.setText(null);
                    tj03m.setVisibility(View.GONE);

                    tj03h.setVisibility(View.VISIBLE);
                    tj03d.setText(null);
                    tj03d.setVisibility(View.GONE);
                } else if (i == R.id.tj03c) {
                    tj03m.setText(null);
                    tj03m.setVisibility(View.GONE);
                    tj03h.setText(null);
                    tj03h.setVisibility(View.GONE);

                    tj03d.setVisibility(View.VISIBLE);
                } else {
                    tj03m.setText(null);
                    tj03m.setVisibility(View.GONE);
                    tj03h.setText(null);
                    tj03h.setVisibility(View.GONE);
                    tj03d.setText(null);
                    tj03d.setVisibility(View.GONE);
                }
            }
        });

//        04
        tj04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.tj04a) {
                    fldGrpti05.setVisibility(View.VISIBLE);
                } else {
                    fldGrpti05.setVisibility(View.GONE);
                    tj05a.setChecked(false);
                    tj05b.setChecked(false);
                    tj05c.setChecked(false);
                    tj05d.setChecked(false);
                    tj05e.setChecked(false);
                    tj05f.setChecked(false);
                    tj05g.setChecked(false);
                    tj05h.setChecked(false);
                }
            }
        });

//        06
        tj06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.tj06a) {
                    fldGrpti07.setVisibility(View.VISIBLE);
                } else {
                    fldGrpti07.setVisibility(View.GONE);
                    tj07a.setChecked(false);
                    tj07b.setChecked(false);
                    tj07c.setChecked(false);
                    tj07d.setChecked(false);
                    tj07e.setChecked(false);
                    tj07f.setChecked(false);
                    tj07g.setChecked(false);
                    tj07h.setChecked(false);
                    tj0788.setChecked(false);
                    tj0788.setText(null);
                }
            }
        });

//        10
        tj10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.tj10a) {
                    fldGrpti11.setVisibility(View.VISIBLE);
                } else {
                    tj11.clearCheck();
                    fldGrpti11.setVisibility(View.GONE);
                }
            }
        });

//        11
        tj11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.tj11a) {
                    tj11d.setVisibility(View.VISIBLE);

                    tj11m.setText(null);
                    tj11m.setVisibility(View.GONE);
                } else if (i == R.id.tj11b) {
                    tj11d.setText(null);
                    tj11d.setVisibility(View.GONE);

                    tj11m.setVisibility(View.VISIBLE);
                } else {
                    tj11d.setText(null);
                    tj11d.setVisibility(View.GONE);

                    tj11m.setText(null);
                    tj11m.setVisibility(View.GONE);
                }
            }
        });

//        12
        tj12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.tj12a) {
                    tj12d.setVisibility(View.VISIBLE);

                    tj12m.setText(null);
                    tj12m.setVisibility(View.GONE);
                } else if (i == R.id.tj12b) {
                    tj12d.setText(null);
                    tj12d.setVisibility(View.GONE);

                    tj12m.setVisibility(View.VISIBLE);
                } else if(i == R.id.tj12c){
                    tj12d.setText(null);
                    tj12d.setVisibility(View.GONE);
                    tj12m.setText(null);
                    tj12m.setVisibility(View.GONE);

                }else{
                    tj12d.setText(null);
                    tj12d.setVisibility(View.GONE);
                    tj12m.setText(null);
                    tj12m.setVisibility(View.GONE);
                }
            }
        });

//        13
        tj13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.tj13a) {
                    tj13d.setVisibility(View.VISIBLE);
                    fldtj14.setVisibility(View.VISIBLE);

                    tj13m.setText(null);
                    tj13m.setVisibility(View.GONE);
                } else if (i == R.id.tj13b) {
                    tj13d.setText(null);
                    tj13d.setVisibility(View.GONE);
                    fldtj14.setVisibility(View.VISIBLE);

                    tj13m.setVisibility(View.VISIBLE);
                } else {
                    tj13d.setText(null);
                    tj13d.setVisibility(View.GONE);
                    tj13m.setText(null);
                    tj13m.setVisibility(View.GONE);
                    fldtj14.setVisibility(View.GONE);
                    tj14.clearCheck();
                    tj1488x.setText(null);
                }
            }
        });

        tj01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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
                startActivity(new Intent(this, SectionKActivity.class));
                finish();

//                if (MainApp.mm < MainApp.TotalChildCount) {
//
//                    clearFields();
//
//                    MainApp.mm++;
//
//                    lstChild.remove(position);
//                    childsMap.remove(position);
//
//                    tj01.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lstChild));
//
//                    scroll.setScrollY(0);
//
//                } else {
//                    finish();
//
//                    MainApp.mm = 1;
//
//
//                }

                finish();
//                startActivity(new Intent(this, SectionKActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void clearFields() {
        tj02.clearCheck();
        tj03.clearCheck();
        tj03m.setText(null);
        tj03h.setText(null);
        tj03d.setText(null);
        tj04.clearCheck();

        tj05a.setChecked(false);
        tj05b.setChecked(false);
        tj05c.setChecked(false);
        tj05d.setChecked(false);
        tj05e.setChecked(false);
        tj05f.setChecked(false);
        tj05g.setChecked(false);
        tj05h.setChecked(false);

        tj06.clearCheck();

        tj07a.setChecked(false);
        tj07b.setChecked(false);
        tj07c.setChecked(false);
        tj07d.setChecked(false);
        tj07e.setChecked(false);
        tj07f.setChecked(false);
        tj07g.setChecked(false);
        tj07h.setChecked(false);
        tj0788.setChecked(false);
        tj0788x.setText(null);

        tj08a.setChecked(false);
        tj08b.setChecked(false);
        tj08c.setChecked(false);
        tj08d.setChecked(false);
        tj08e.setChecked(false);
        tj08f.setChecked(false);
        tj08g.setChecked(false);
        tj08h.setChecked(false);
        tj08i.setChecked(false);
        tj0888.setChecked(false);
        tj0888x.setText(null);

        tj09.clearCheck();
        tj10.clearCheck();

        tj11.clearCheck();
        tj11m.setText(null);
        tj11d.setText(null);

        tj12.clearCheck();
        tj12m.setText(null);
        tj12d.setText(null);

        tj13.clearCheck();
        tj13m.setText(null);
        tj13d.setText(null);

        tj14.clearCheck();
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSJ();

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

/*        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

        MainApp.ims = new SectionJIMContract();

        MainApp.ims.setDevicetagID(sharedPref.getString("tagName", null));
        MainApp.ims.setFormDate(MainApp.dtToday);
        MainApp.ims.setUser(MainApp.userName);
        MainApp.ims.setDeviceId(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));*/

        JSONObject sJ = new JSONObject();

        sJ.put("tjchildSerial", childSerial);
//        sJ.put("tjchildName", tj01.getSelectedItem().toString());

        sJ.put("tj01", tj01.getSelectedItem().toString());

        sJ.put("tj02", tj02a.isChecked() ? "1" : tj02b.isChecked() ? "2" : tj02c.isChecked() ? "3"
                : tj02d.isChecked() ? "4" : tj02e.isChecked() ? "5" : tj02f.isChecked() ? "6"
                : tj02g.isChecked() ? "7" : tj02h.isChecked() ? "8" : tj02i.isChecked() ? "9"
                : tj0288.isChecked() ? "88" : "0");
        sJ.put("tj0288x", tj0288x.getText().toString());

        sJ.put("tj03", tj03a.isChecked() ? "1" : tj03b.isChecked() ? "2" : tj03c.isChecked() ? "3"
                : tj03666.isChecked() ? "666" : tj03888.isChecked() ? "888" : "0");
        sJ.put("tj03m", tj03m.getText().toString());
        sJ.put("tj03h", tj03h.getText().toString());
        sJ.put("tj03d", tj03d.getText().toString());

        sJ.put("tj04", tj04a.isChecked() ? "1" : tj04b.isChecked() ? "2" : "0");

        sJ.put("tj05a", tj05a.isChecked() ? "1" : "0");
        sJ.put("tj05b", tj05b.isChecked() ? "2" : "0");
        sJ.put("tj05c", tj05c.isChecked() ? "3" : "0");
        sJ.put("tj05d", tj05d.isChecked() ? "4" : "0");
        sJ.put("tj05e", tj05e.isChecked() ? "5" : "0");
        sJ.put("tj05f", tj05f.isChecked() ? "6" : "0");
        sJ.put("tj05g", tj05g.isChecked() ? "7" : "0");
        sJ.put("tj05h", tj05h.isChecked() ? "8" : "0");

        sJ.put("tj06", tj06a.isChecked() ? "1" : tj06b.isChecked() ? "2" : "0");

        sJ.put("tj07a", tj07a.isChecked() ? "1" : "0");
        sJ.put("tj07b", tj07b.isChecked() ? "2" : "0");
        sJ.put("tj07c", tj07c.isChecked() ? "3" : "0");
        sJ.put("tj07d", tj07d.isChecked() ? "4" : "0");
        sJ.put("tj07e", tj07e.isChecked() ? "5" : "0");
        sJ.put("tj07f", tj07f.isChecked() ? "6" : "0");
        sJ.put("tj07g", tj07g.isChecked() ? "7" : "0");
        sJ.put("tj07h", tj07h.isChecked() ? "8" : "0");
        sJ.put("tj0788", tj0788.isChecked() ? "88" : "0");
        sJ.put("tj0788x", tj0788x.getText().toString());

        sJ.put("tj08a", tj08a.isChecked() ? "1" : "0");
        sJ.put("tj08b", tj08b.isChecked() ? "2" : "0");
        sJ.put("tj08c", tj08c.isChecked() ? "3" : "0");
        sJ.put("tj08d", tj08d.isChecked() ? "4" : "0");
        sJ.put("tj08e", tj08e.isChecked() ? "5" : "0");
        sJ.put("tj08f", tj08f.isChecked() ? "6" : "0");
        sJ.put("tj08g", tj08g.isChecked() ? "7" : "0");
        sJ.put("tj08h", tj08h.isChecked() ? "8" : "0");
        sJ.put("tj08i", tj08i.isChecked() ? "9" : "0");
        sJ.put("tj0888", tj0888.isChecked() ? "88" : "0");
        sJ.put("tj0888x", tj0888x.getText().toString());

        sJ.put("tj09", tj09a.isChecked() ? "1" : tj09b.isChecked() ? "2" : "0");
        sJ.put("tj10", tj10a.isChecked() ? "1" : tj10b.isChecked() ? "2" : "0");

        sJ.put("tj11", tj11a.isChecked() ? "1" : tj11b.isChecked() ? "2"
                : tj11888.isChecked() ? "888" : "0");
        sJ.put("tj11d", tj11d.getText().toString());
        sJ.put("tj11m", tj11m.getText().toString());

        sJ.put("tj12", tj12a.isChecked() ? "1" : tj12b.isChecked() ? "2"
                : tj12888.isChecked() ? "888" : tj12c.isChecked() ? "3" : "0");
        sJ.put("tj12d", tj12d.getText().toString());
        sJ.put("tj12m", tj12m.getText().toString());

        sJ.put("tj13", tj13a.isChecked() ? "1" : tj13b.isChecked() ? "2"
                : tj13c.isChecked() ? "3" : "0");
        sJ.put("tj13d", tj13d.getText().toString());
        sJ.put("tj13m", tj13m.getText().toString());

        sJ.put("tj14", tj14a.isChecked() ? "1"
                : tj14b.isChecked() ? "2" : tj14c.isChecked() ? "3"
                : tj14d.isChecked() ? "4" : tj14e.isChecked() ? "5"
                : tj14f.isChecked() ? "6"
                : tj14g.isChecked() ? "7" : tj14h.isChecked() ? "8" : tj14i.isChecked() ? "9"
                : tj14j.isChecked() ? "10"
                : tj14k.isChecked() ? "11" : tj14l.isChecked() ? "12" : tj1488.isChecked() ? "88" : "0");
        sJ.put("tj1488x", tj1488x.getText().toString());

        MainApp.fc.setsJ(String.valueOf(sJ));
    }

    public boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        01
        if (tj01.getSelectedItem() == "....") {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.tj01), Toast.LENGTH_SHORT).show();
            ((TextView) tj01.getSelectedView()).setText("This Data is Required");
            ((TextView) tj01.getSelectedView()).setTextColor(Color.RED);
            tj01.requestFocus();
            Log.i(TAG, "tj01: This Data is Required!");
            return false;
        } else {
            ((TextView) tj01.getSelectedView()).setError(null);
        }

//        02
        if (tj02.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tj02), Toast.LENGTH_SHORT).show();
            tj0288.setError("This data is Required!");    // Set Error on last radio button
            tj02a.setFocusable(true);
            tj02a.setFocusableInTouchMode(true);
            tj02a.requestFocus();

            Log.i(TAG, "tj02: This data is Required!");
            return false;
        } else {
            tj0288.setError(null);
        }
        if (tj0288.isChecked() && tj0288x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
            tj0288x.setError("This data is Required! ");    // Set Error on last radio button
            tj0288x.requestFocus();
            Log.i(TAG, "tj0288x: This data is Required!");
            return false;
        } else {
            tj0288x.setError(null);
        }


//        03
        if (tj03.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tj03), Toast.LENGTH_SHORT).show();
            tj03888.setError("This data is Required!");    // Set Error on last radio button
            tj03a.setFocusable(true);
            tj03a.setFocusableInTouchMode(true);
            tj03a.requestFocus();

            Log.i(TAG, "tj03: This data is Required!");
            return false;
        } else {
            tj03888.setError(null);
        }
        if (tj03a.isChecked()) {
            if (tj03m.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.month), Toast.LENGTH_SHORT).show();
                tj03m.setError("This data is Required! ");    // Set Error on last radio button
                tj03m.requestFocus();
                Log.i(TAG, "tj03m: This data is Required!");
                return false;
            } else {
                tj03m.setError(null);
            }
            if (Integer.parseInt(tj03m.getText().toString()) < 1 || Integer.parseInt(tj03m.getText().toString()) > 59) {
                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.min), Toast.LENGTH_SHORT).show();
                tj03m.setError("Range from 1 - 59!");    // Set Error on last radio button
                tj03m.requestFocus();
                Log.i(TAG, "tj03m: Range from 1 - 59!");
                return false;
            } else {
                tj03m.setError(null);
            }
        } else if (tj03b.isChecked()) {
            if (tj03h.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.hour), Toast.LENGTH_SHORT).show();
                tj03h.setError("This data is Required! ");    // Set Error on last radio button
                tj03h.requestFocus();
                Log.i(TAG, "tj03h: This data is Required!");
                return false;
            } else {
                tj03h.setError(null);
            }

            if (Integer.valueOf(tj03h.getText().toString()) < 1 || Integer.valueOf(tj03h.getText().toString()) > 23) {
                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.hour), Toast.LENGTH_SHORT).show();
                tj03h.setError("Range from 1 - 23!");    // Set Error on last radio button
                tj03h.requestFocus();
                Log.i(TAG, "tj03h: Range from 1 - 23!");
                return false;
            } else {
                tj03h.setError(null);
            }
        } else if (tj03c.isChecked()) {
            if (tj03d.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.day), Toast.LENGTH_SHORT).show();
                tj03d.setError("This data is Required! ");    // Set Error on last radio button
                tj03d.requestFocus();
                Log.i(TAG, "tj03d: This data is Required!");
                return false;
            } else {
                tj03d.setError(null);
            }
            if (Integer.valueOf(tj03d.getText().toString()) < 1 || Integer.valueOf(tj03d.getText().toString()) > 29) {
                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.day), Toast.LENGTH_SHORT).show();
                tj03d.setError("Range from 1 - 29!");    // Set Error on last radio button
                tj03d.requestFocus();
                Log.i(TAG, "tj03d: Range from 1 - 29");
                return false;
            } else {
                tj03d.setError(null);
            }
        }

//        04
        if (tj04.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tj04), Toast.LENGTH_SHORT).show();
            tj04b.setError("This data is Required! ");    // Set Error on last radio button
            tj04b.setFocusable(true);
            tj04b.setFocusableInTouchMode(true);
            tj04b.requestFocus();

            Log.i(TAG, "tj04: This data is Required!");
            return false;
        } else {
            tj04b.setError(null);
        }

        if (tj04a.isChecked()) {
//        05
            if (!tj05a.isChecked() &&
                    !tj05b.isChecked() &&
                    !tj05c.isChecked() &&
                    !tj05d.isChecked() &&
                    !tj05e.isChecked() &&
                    !tj05f.isChecked() &&
                    !tj05g.isChecked() &&
                    !tj05h.isChecked()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tj05), Toast.LENGTH_SHORT).show();
                tj05h.setError("This data is Required!");    // Set Error on last check box
                tj05h.requestFocus();
                Log.i(TAG, "tj05: This data is Required!");
                return false;
            } else {
                tj05h.setError(null);
            }
        }

//        06
        if (tj06.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tj06), Toast.LENGTH_SHORT).show();
            tj06b.setError("This data is Required! ");    // Set Error on last radio button
            tj06b.setFocusable(true);
            tj06b.setFocusableInTouchMode(true);
            tj06b.requestFocus();
            Log.i(TAG, "tj06: This data is Required!");
            return false;
        } else {
            tj06b.setError(null);
        }

        if (tj06a.isChecked()) {
//        07
            if (!(tj07a.isChecked() || tj07b.isChecked() || tj07c.isChecked() || tj07d.isChecked() ||
                    tj07e.isChecked() || tj07f.isChecked() || tj07g.isChecked() ||
                    tj07h.isChecked() || tj0788.isChecked())) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tj07), Toast.LENGTH_SHORT).show();
                tj07h.setError("This data is Required!");    // Set Error on last check box
                tj07h.requestFocus();
                Log.i(TAG, "tj07: This data is Required!");
                return false;
            } else {
                tj07h.setError(null);
            }
            if (tj0788.isChecked() && tj0788x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
                tj0788x.setError("This data is Required! ");    // Set Error on last radio button
                tj0788x.requestFocus();
                Log.i(TAG, "tj07: This data is Required!");
                return false;
            } else {
                tj0788x.setError(null);
            }

        }


//        08
        if(MainApp.sixMonthsCount > 0){

            if (!(tj08a.isChecked() || tj08b.isChecked() || tj08c.isChecked() || tj08d.isChecked() ||
                    tj08e.isChecked() || tj08f.isChecked() || tj08g.isChecked() ||
                    tj08h.isChecked() || tj08i.isChecked() || tj0888.isChecked())) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tj08), Toast.LENGTH_SHORT).show();
                tj08i.setError("This data is Required!");    // Set Error on last check box

                Log.i(TAG, "tj08: This data is Required!");
                return false;
            } else {
                tj08i.setError(null);
            }
            if (tj0888.isChecked() && tj0888x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
                tj0888x.setError("This data is Required! ");    // Set Error on last radio button

                Log.i(TAG, "tj08: This data is Required!");
                return false;
            } else {
                tj0888x.setError(null);
            }

        }


//        09
        if (tj09.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tj09), Toast.LENGTH_SHORT).show();
            tj09b.setError("This data is Required! ");    // Set Error on last radio button

            Log.i(TAG, "tj09: This data is Required!");
            return false;
        } else {
            tj09b.setError(null);
        }

//        10
        if (tj10.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tj10), Toast.LENGTH_SHORT).show();
            tj10b.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "tj10: This data is Required!");
            return false;
        } else {
            tj10b.setError(null);
        }

        if (tj10a.isChecked()) {
//        11
            if (tj11.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tj11), Toast.LENGTH_SHORT).show();
                tj11888.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "tj11: This data is Required!");
                return false;
            } else {
                tj11888.setError(null);
            }
            if (tj11a.isChecked()) {
                if (tj11d.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.day), Toast.LENGTH_SHORT).show();
                    tj11d.setError("This data is Required! ");    // Set Error on last radio button

                    Log.i(TAG, "tj11d: This data is Required!");
                    return false;
                } else {
                    tj11d.setError(null);
                }
                if (Integer.valueOf(tj11d.getText().toString()) < 1 || Integer.valueOf(tj11d.getText().toString()) > 29) {
                    Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.day), Toast.LENGTH_SHORT).show();
                    tj11d.setError("Range from 1 - 29!");    // Set Error on last radio button

                    Log.i(TAG, "tj11d: Range from 1 - 29");
                    return false;
                } else {
                    tj11d.setError(null);
                }
            } else if (tj11b.isChecked()) {
                if (tj11m.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.month), Toast.LENGTH_SHORT).show();
                    tj11m.setError("This data is Required! ");    // Set Error on last radio button

                    Log.i(TAG, "tj11m: This data is Required!");
                    return false;
                } else {
                    tj11m.setError(null);
                }

                if (Integer.valueOf(tj11m.getText().toString()) < 1 || Integer.valueOf(tj11m.getText().toString()) > 6) {
                    Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.month), Toast.LENGTH_SHORT).show();
                    tj11m.setError("Range from 1 - 6!");    // Set Error on last radio button

                    Log.i(TAG, "tj11m: Range from 1 - 6");
                    return false;
                } else {
                    tj11m.setError(null);
                }
            }
        }

//        12
        if (tj12.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tj12), Toast.LENGTH_SHORT).show();
            tj12888.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "tj12: This data is Required!");
            return false;
        } else {
            tj12888.setError(null);
        }
        if (tj12a.isChecked()) {
            if (tj12d.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.day), Toast.LENGTH_SHORT).show();
                tj12d.setError("This data is Required! ");    // Set Error on last radio button

                Log.i(TAG, "tj12d: This data is Required!");
                return false;
            } else {
                tj12d.setError(null);
            }
            if (Integer.valueOf(tj12d.getText().toString()) < 1 || Integer.valueOf(tj12d.getText().toString()) > 29) {
                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.day), Toast.LENGTH_SHORT).show();
                tj12d.setError("Range from 1 - 29!");    // Set Error on last radio button

                Log.i(TAG, "tj12d: Range from 1 - 29");
                return false;
            } else {
                tj12d.setError(null);
            }
        } else if (tj12b.isChecked()) {
            if (tj12m.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.month), Toast.LENGTH_SHORT).show();
                tj12m.setError("This data is Required! ");    // Set Error on last radio button

                Log.i(TAG, "tj12m: This data is Required!");
                return false;
            } else {
                tj12m.setError(null);
            }

//            if (childsMap.get(tj01.getSelectedItem().toString()).getDob().length() == 10) {
//                months = MainApp.ageInMonthsByDOB(childsMap.get(tj01.getSelectedItem().toString()).getDob());
//            } else {
//                String[] dob = childsMap.get(tj01.getSelectedItem().toString()).getDob().split("-");
//
//                months = MainApp.ageInMonths(dob[1], dob[0]);
//            }


//            if (Integer.valueOf(tj12m.getText().toString()) > months) {
//                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.month), Toast.LENGTH_SHORT).show();
//                tj12m.setError("Invalid Months!");    // Set Error on last radio button
//
//                Log.i(TAG, "tj12m: Invalid Months");
//                return false;
//            } else {
//                tj12m.setError(null);
//            }

        }

//        13
        if (tj13.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tj13), Toast.LENGTH_SHORT).show();
            tj13c.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "tj13: This data is Required!");
            return false;
        } else {
            tj13c.setError(null);
        }
        if (tj13a.isChecked()) {
            if (tj13d.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.day), Toast.LENGTH_SHORT).show();
                tj13d.setError("This data is Required! ");    // Set Error on last radio button

                Log.i(TAG, "tj13d: This data is Required!");
                return false;
            } else {
                tj13d.setError(null);
            }
            if (Integer.valueOf(tj13d.getText().toString()) < 1 || Integer.valueOf(tj13d.getText().toString()) > 29) {
                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.day), Toast.LENGTH_SHORT).show();
                tj13d.setError("Range from 1 - 29!");    // Set Error on last radio button

                Log.i(TAG, "tj13d: Range from 1 - 29");
                return false;
            } else {
                tj13d.setError(null);
            }
        } else if (tj13b.isChecked()) {
            if (tj13m.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.month), Toast.LENGTH_SHORT).show();
                tj13m.setError("This data is Required! ");    // Set Error on last radio button

                Log.i(TAG, "tj13m: This data is Required!");
                return false;
            } else {
                tj13m.setError(null);
            }

//            if (childsMap.get(tj01.getSelectedItem().toString()).getDob().length() == 10) {
//                months = MainApp.ageInMonthsByDOB(childsMap.get(tj01.getSelectedItem().toString()).getDob());
//            } else {
//                String[] dob = childsMap.get(tj01.getSelectedItem().toString()).getDob().split("-");
//
//                months = MainApp.ageInMonths(dob[1], dob[0]);
//            }

//            if (Long.valueOf(tj13m.getText().toString()) > months) {
//                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.month), Toast.LENGTH_SHORT).show();
//                tj13m.setError("Invalid Months!");    // Set Error on last radio button
//
//                Log.i(TAG, "tj13m: Invalid Months");
//                return false;
//            } else {
//                tj13m.setError(null);
//            }
        }

//        14
        if(!tj13c.isChecked()){
            if (tj14.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tj14), Toast.LENGTH_SHORT).show();
                tj14a.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "tj14: This data is Required!");
                return false;
            } else {
                tj14a.setError(null);
            }
            if (tj1488.isChecked() && tj1488x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
                tj1488x.setError("This data is Required! ");    // Set Error on last radio button

                Log.i(TAG, "tj1488: This data is Required!");
                return false;
            } else {
                tj1488x.setError(null);
            }

        }




        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }
}