package edu.aku.hassannaqvi.uen_tmk.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import edu.aku.hassannaqvi.uen_tmk.R;
import edu.aku.hassannaqvi.uen_tmk.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk.core.MainApp;

/**
 * Created by ali.azaz on 8/29/2017.
 */

public class SectionHBActivity extends Activity {

    private static final String TAG = SectionHBActivity.class.getName();

    @BindView(R.id.thb01)
    RadioGroup thb01;
    @BindView(R.id.thb01a)
    RadioButton thb01a;
    @BindView(R.id.thb01b)
    RadioButton thb01b;
    @BindView(R.id.thb01888)
    RadioButton thb01888;
    @BindView(R.id.thb02)
    EditText thb02;
    @BindView(R.id.thb03)
    RadioGroup thb03;
    @BindView(R.id.thb03a)
    RadioButton thb03a;
    @BindView(R.id.thb03b)
    RadioButton thb03b;
    @BindView(R.id.thb03888)
    RadioButton thb03888;
    @BindView(R.id.thb04)
    EditText thb04;
    @BindView(R.id.thb05)
    Spinner thb05;
    @BindView(R.id.thb06)
    EditText thb06;
    @BindView(R.id.thb07)
    RadioGroup thb07;
    @BindView(R.id.thb07a)
    RadioButton thb07a;
    @BindView(R.id.thb07b)
    RadioButton thb07b;
    @BindView(R.id.thb07888)
    RadioButton thb07888;
    @BindView(R.id.thb08a)
    CheckBox thb08a;
    @BindView(R.id.thb08b)
    CheckBox thb08b;
    @BindView(R.id.thb08c)
    CheckBox thb08c;
    @BindView(R.id.thb08d)
    CheckBox thb08d;
    @BindView(R.id.thb08e)
    CheckBox thb08e;
    @BindView(R.id.thb08f)
    CheckBox thb08f;
    @BindView(R.id.thb08g)
    CheckBox thb08g;
    @BindView(R.id.thb08h)
    CheckBox thb08h;
    @BindView(R.id.thb0888)
    CheckBox thb0888;
    @BindView(R.id.thb0888x)
    EditText thb0888x;
    @BindView(R.id.thb09)
    EditText thb09;
    @BindView(R.id.thb10)
    RadioGroup thb10;
    @BindView(R.id.thb10a)
    RadioButton thb10a;
    @BindView(R.id.thb10b)
    RadioButton thb10b;
    @BindView(R.id.thb10c)
    RadioButton thb10c;
    @BindView(R.id.thb10d)
    RadioButton thb10d;
    @BindView(R.id.thb11)
    RadioGroup thb11;
    @BindView(R.id.thb11a)
    RadioButton thb11a;
    @BindView(R.id.thb11b)
    RadioButton thb11b;
    @BindView(R.id.thb11c)
    RadioButton thb11c;
    @BindView(R.id.thb11d)
    RadioButton thb11d;
    @BindView(R.id.thb11e)
    RadioButton thb11e;
    @BindView(R.id.thb11f)
    RadioButton thb11f;
    @BindView(R.id.thb11g)
    RadioButton thb11g;
    @BindView(R.id.thb11h)
    RadioButton thb11h;
    @BindView(R.id.thb11i)
    RadioButton thb11i;
    @BindView(R.id.thb11j)
    RadioButton thb11j;
    @BindView(R.id.thb11k)
    RadioButton thb11k;
    @BindView(R.id.thb12a)
    CheckBox thb12a;
    @BindView(R.id.thb12b)
    CheckBox thb12b;
    @BindView(R.id.thb12c)
    CheckBox thb12c;
    @BindView(R.id.thb12d)
    CheckBox thb12d;
    @BindView(R.id.thb12e)
    CheckBox thb12e;
    @BindView(R.id.thb12f)
    CheckBox thb12f;
    @BindView(R.id.thb12g)
    CheckBox thb12g;
    @BindView(R.id.thb12h)
    CheckBox thb12h;
    @BindView(R.id.thb13)
    RadioGroup thb13;
    @BindView(R.id.thb13a)
    RadioButton thb13a;
    @BindView(R.id.thb13b)
    RadioButton thb13b;
    @BindView(R.id.thb14)
    RadioGroup thb14;
    @BindView(R.id.thb14a)
    RadioButton thb14a;
    @BindView(R.id.thb14b)
    RadioButton thb14b;
    @BindView(R.id.thb15)
    RadioGroup thb15;
    @BindView(R.id.thb15a)
    RadioButton thb15a;
    @BindView(R.id.thb15b)
    RadioButton thb15b;
    @BindView(R.id.thb15c)
    RadioButton thb15c;
    @BindView(R.id.thb16)
    RadioGroup thb16;
    @BindView(R.id.thb16a)
    RadioButton thb16a;
    @BindView(R.id.thb16b)
    RadioButton thb16b;
    @BindView(R.id.thb17)
    RadioGroup thb17;
    @BindView(R.id.thb17a)
    RadioButton thb17a;
    @BindView(R.id.thb17b)
    RadioButton thb17b;
    @BindView(R.id.thb17c)
    RadioButton thb17c;
    @BindView(R.id.thb17d)
    RadioButton thb17d;
    @BindView(R.id.thb1788)
    RadioButton thb1788;
    @BindView(R.id.thb1788x)
    EditText thb1788x;
    @BindView(R.id.thb18)
    RadioGroup thb18;
    @BindView(R.id.thb18a)
    RadioButton thb18a;
    @BindView(R.id.thb18b)
    RadioButton thb18b;
    @BindView(R.id.thb18c)
    RadioButton thb18c;
    @BindView(R.id.thb19)
    RadioGroup thb19;
    @BindView(R.id.thb19a)
    RadioButton thb19a;
    @BindView(R.id.thb19b)
    RadioButton thb19b;
    @BindView(R.id.thb19c)
    RadioButton thb19c;
    @BindView(R.id.thb19d)
    RadioButton thb19d;
    @BindView(R.id.thb19e)
    RadioButton thb19e;
    @BindView(R.id.thb20a)
    CheckBox thb20a;
    @BindView(R.id.thb20b)
    CheckBox thb20b;
    @BindView(R.id.thb20c)
    CheckBox thb20c;
    @BindView(R.id.thb20d)
    CheckBox thb20d;
    @BindView(R.id.thb20e)
    CheckBox thb20e;
    @BindView(R.id.thb20f)
    CheckBox thb20f;
    @BindView(R.id.thb20g)
    CheckBox thb20g;
    @BindView(R.id.thb21)
    RadioGroup thb21;
    @BindView(R.id.thb21a)
    RadioButton thb21a;
    @BindView(R.id.thb21b)
    RadioButton thb21b;
    @BindView(R.id.thb21c)
    RadioButton thb21c;
    @BindView(R.id.thb21hr)
    EditText thb21hr;
    @BindView(R.id.thb21d)
    EditText thb21d;
    @BindView(R.id.thb22)
    RadioGroup thb22;
    @BindView(R.id.thb22a)
    RadioButton thb22a;
    @BindView(R.id.thb22b)
    RadioButton thb22b;
    @BindView(R.id.thb23)
    EditText thb23;
    @BindView(R.id.thb24)
    RadioGroup thb24;
    @BindView(R.id.thb24a)
    RadioButton thb24a;
    @BindView(R.id.thb24b)
    RadioButton thb24b;
    @BindView(R.id.thb25a)
    CheckBox thb25a;
    @BindView(R.id.thb25b)
    CheckBox thb25b;
    @BindView(R.id.thb25c)
    CheckBox thb25c;
    @BindView(R.id.thb25d)
    CheckBox thb25d;
    @BindView(R.id.thb25e)
    CheckBox thb25e;
    @BindView(R.id.thb25f)
    CheckBox thb25f;
    @BindView(R.id.thb25g)
    CheckBox thb25g;
    @BindView(R.id.thb26)
    RadioGroup thb26;
    @BindView(R.id.thb26a)
    RadioButton thb26a;
    @BindView(R.id.thb26b)
    RadioButton thb26b;
    @BindView(R.id.thb26c)
    RadioButton thb26c;
    @BindView(R.id.thb27)
    EditText thb27;

    @BindView(R.id.thb27888)
    CheckBox thb27888;

    @BindView(R.id.thb28)
    RadioGroup thb28;
    @BindView(R.id.thb28a)
    RadioButton thb28a;
    @BindView(R.id.thb28b)
    RadioButton thb28b;
    @BindView(R.id.thb28c)
    RadioButton thb28c;
    @BindView(R.id.thb28d)
    RadioButton thb28d;
    @BindView(R.id.thb28e)
    RadioButton thb28e;
    @BindView(R.id.thb28f)
    RadioButton thb28f;
    @BindView(R.id.thb28g)
    RadioButton thb28g;
    @BindView(R.id.thb28h)
    RadioButton thb28h;
    @BindView(R.id.thb28i)
    RadioButton thb28i;
    @BindView(R.id.thb2888)
    RadioButton thb2888;
    @BindView(R.id.thb2888x)
    EditText thb2888x;
    @BindView(R.id.thb29)
    EditText thb29;

    @BindView(R.id.thb29888)
    CheckBox thb29888;

    @BindView(R.id.thb30)
    EditText thb30;

    @BindView(R.id.thb30888)
    CheckBox thb30888;

    @BindView(R.id.thb31)
    RadioGroup thb31;
    @BindView(R.id.thb31a)
    RadioButton thb31a;
    @BindView(R.id.thb31b)
    RadioButton thb31b;
    @BindView(R.id.thb31c)
    RadioButton thb31c;
    @BindView(R.id.thb32)
    RadioGroup thb32;
    @BindView(R.id.thb32a)
    RadioButton thb32a;
    @BindView(R.id.thb32b)
    RadioButton thb32b;
    @BindView(R.id.thb3288)
    RadioButton thb3288;
    @BindView(R.id.thb33)
    RadioGroup thb33;
    @BindView(R.id.thb33a)
    RadioButton thb33a;
    @BindView(R.id.thb33b)
    RadioButton thb33b;
    @BindView(R.id.thb3388)
    RadioButton thb3388;
    @BindView(R.id.thb34)
    EditText thb34;

    @BindView(R.id.thb34888)
    CheckBox thb34888;

    @BindView(R.id.thb35)
    RadioGroup thb35;
    @BindView(R.id.thb35a)
    RadioButton thb35a;
    @BindView(R.id.thb35b)
    RadioButton thb35b;
    @BindView(R.id.thb35c)
    RadioButton thb35c;
    @BindView(R.id.thb36a)
    CheckBox thb36a;
    @BindView(R.id.thb36b)
    CheckBox thb36b;
    @BindView(R.id.thb36c)
    CheckBox thb36c;
    @BindView(R.id.thb36d)
    CheckBox thb36d;
    @BindView(R.id.thb36e)
    CheckBox thb36e;
    @BindView(R.id.thb36f)
    CheckBox thb36f;
    @BindView(R.id.thb36g)
    CheckBox thb36g;
    @BindView(R.id.thb36h)
    CheckBox thb36h;
    @BindView(R.id.thb36i)
    CheckBox thb36i;
    @BindView(R.id.thb36j)
    CheckBox thb36j;
    @BindView(R.id.thb36k)
    CheckBox thb36k;
    @BindView(R.id.thb3688)
    CheckBox thb3688;
    @BindView(R.id.thb3688x)
    EditText thb3688x;

    @BindView(R.id.fldGrpthb02)
    LinearLayout fldGrpthb02;

    @BindView(R.id.fldGrpthb04)
    LinearLayout fldGrpthb04;

    @BindView(R.id.fldGrpth08)
    LinearLayout fldGrpth08;

    @BindView(R.id.fldGrpth15)
    LinearLayout fldGrpth15;

    @BindView(R.id.fldGrpth22)
    LinearLayout fldGrpth22;

    @BindView(R.id.fldGrpth23)
    LinearLayout fldGrpth23;

    @BindView(R.id.fldGrpth25)
    LinearLayout fldGrpth25;

    @BindView(R.id.fldGrpth15a)
    LinearLayout fldGrpth15a;

    @BindView(R.id.fldGrpth17)
    LinearLayout fldGrpth17;

    @BindView(R.id.fldGrpth08a)
    LinearLayout fldGrpth08a;

    @BindView(R.id.thb00)
    RadioGroup thb00;
    @BindView(R.id.thb00a)
    RadioButton thb00a;
    @BindView(R.id.thb00b)
    RadioButton thb00b;


    Map<String, String> childsMap;
    ArrayList<String> lstChild;

    public void clearFldgrpthb15() {
        clearFldgrpthb15a();

        thb27.setText(null);
        thb27888.setChecked(false);

        thb28.clearCheck();
        thb2888x.setText(null);

        thb29.setText(null);
        thb29888.setChecked(false);

        thb30.setText(null);
        thb30888.setChecked(false);

        thb31.clearCheck();
        thb32.clearCheck();
    }

    public void clearFldgrpthb15a() {
        thb15.clearCheck();
        thb16.clearCheck();
        thb17.clearCheck();
        thb18.clearCheck();
        thb19.clearCheck();

        thb20a.setChecked(false);
        thb20b.setChecked(false);
        thb20c.setChecked(false);
        thb20d.setChecked(false);
        thb20e.setChecked(false);
        thb20f.setChecked(false);
        thb20g.setChecked(false);

        thb21.clearCheck();

        thb21hr.setText(null);
        thb21d.setText(null);


        thb22.clearCheck();

        thb23.setText(null);

        thb24.clearCheck();

        thb25a.setChecked(false);
        thb25b.setChecked(false);
        thb25c.setChecked(false);
        thb25d.setChecked(false);
        thb25e.setChecked(false);
        thb25f.setChecked(false);
        thb25g.setChecked(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_hb);
        ButterKnife.bind(this);

        childsMap = new HashMap<>();
        lstChild = new ArrayList<>();

        childsMap.put("....", "");
        lstChild.add("....");

        lstChild.add("Child 1 ");
        lstChild.add("Child 2 ");
        lstChild.add("Child 3 ");
        lstChild.add("Child 4 ");

        /*for (byte i = 0; i < MainApp.familyMembersList.size(); i++) {
            if (MainApp.familyMembersList.get(i).getAgeLess5().equals("1") || MainApp.familyMembersList.get(i).getAgeLess5().equals("3")) {
                childsMap.put(MainApp.familyMembersList.get(i).getName(), MainApp.familyMembersList.get(i).getSerialNo());
                lstChild.add(MainApp.familyMembersList.get(i).getName());
            }
        }*/

        thb05.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lstChild));


        thb01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (thb01a.isChecked()) {
                    fldGrpthb02.setVisibility(View.VISIBLE);
                    thb02.requestFocus();
                } else {

                    thb02.setText(null);
                    fldGrpthb02.setVisibility(View.GONE);
                }
            }
        });


        thb03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (thb03a.isChecked()) {
                    fldGrpthb04.setVisibility(View.VISIBLE);
                } else {

                    thb04.setText(null);
                    /*thb05.getChildAt(0).toString();*/
                    thb06.setText(null);

                    thb07.clearCheck();

                    thb08a.setChecked(false);
                    thb08b.setChecked(false);
                    thb08c.setChecked(false);
                    thb08d.setChecked(false);
                    thb08e.setChecked(false);
                    thb08f.setChecked(false);
                    thb08g.setChecked(false);
                    thb08h.setChecked(false);
                    thb0888.setChecked(false);


                    thb0888x.setText(null);

                    thb09.setText(null);
                    thb10.clearCheck();
                    thb11.clearCheck();

                    thb12a.setChecked(false);
                    thb12b.setChecked(false);
                    thb12c.setChecked(false);
                    thb12d.setChecked(false);
                    thb12e.setChecked(false);
                    thb12f.setChecked(false);
                    thb12g.setChecked(false);
                    thb12h.setChecked(false);

                    thb13.clearCheck();
                    thb14.clearCheck();
                    thb15.clearCheck();
                    thb16.clearCheck();
                    thb17.clearCheck();
                    thb18.clearCheck();
                    thb19.clearCheck();

                    thb20a.setChecked(false);
                    thb20b.setChecked(false);
                    thb20c.setChecked(false);
                    thb20d.setChecked(false);
                    thb20e.setChecked(false);
                    thb20f.setChecked(false);
                    thb20g.setChecked(false);

                    thb21.clearCheck();

                    thb21hr.setText(null);
                    thb21d.setText(null);

                    thb22.clearCheck();

                    thb23.setText(null);
                    thb24.clearCheck();

                    thb25a.setChecked(false);
                    thb25b.setChecked(false);
                    thb25c.setChecked(false);
                    thb25d.setChecked(false);
                    thb25e.setChecked(false);
                    thb25f.setChecked(false);
                    thb25g.setChecked(false);


                    thb26.clearCheck();

                    thb27.setText(null);

                    thb28.clearCheck();
                    thb2888x.setText(null);

                    thb29.setText(null);
                    thb30.setText(null);

                    thb31.clearCheck();
                    thb32.clearCheck();
                    thb33.clearCheck();

                    thb34.setText(null);

                    thb35.clearCheck();

                    thb36a.setChecked(false);
                    thb36b.setChecked(false);
                    thb36c.setChecked(false);
                    thb36d.setChecked(false);
                    thb36e.setChecked(false);
                    thb36f.setChecked(false);
                    thb36g.setChecked(false);
                    thb36h.setChecked(false);
                    thb36i.setChecked(false);
                    thb36j.setChecked(false);
                    thb36k.setChecked(false);
                    thb3688.setChecked(false);

                    thb3688x.setText(null);


                    fldGrpthb04.setVisibility(View.GONE);
                }
            }
        });


        thb07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (thb07a.isChecked()) {

                    thb08a.setChecked(false);
                    thb08b.setChecked(false);
                    thb08c.setChecked(false);
                    thb08d.setChecked(false);
                    thb08e.setChecked(false);
                    thb08f.setChecked(false);
                    thb08g.setChecked(false);
                    thb08h.setChecked(false);
                    thb0888.setChecked(false);

                    thb0888x.setText(null);

                    fldGrpth08.setVisibility(View.GONE);
                    fldGrpth08a.setVisibility(View.VISIBLE);

                } else {

                    thb09.setText(null);
                    thb10.clearCheck();
                    thb11.clearCheck();

                    thb12a.setChecked(false);
                    thb12b.setChecked(false);
                    thb12c.setChecked(false);
                    thb12d.setChecked(false);
                    thb12e.setChecked(false);
                    thb12f.setChecked(false);
                    thb12g.setChecked(false);
                    thb12h.setChecked(false);

                    thb13.clearCheck();
                    thb14.clearCheck();
                    thb15.clearCheck();

                    thb16.clearCheck();

                    thb17.clearCheck();
                    thb1788x.setText(null);

                    thb18.clearCheck();
                    thb19.clearCheck();

                    thb20a.setChecked(false);
                    thb20b.setChecked(false);
                    thb20c.setChecked(false);
                    thb20d.setChecked(false);
                    thb20e.setChecked(false);
                    thb20f.setChecked(false);
                    thb20g.setChecked(false);

                    thb21.clearCheck();
                    thb21hr.setText(null);
                    thb21d.setText(null);

                    thb22.clearCheck();
                    thb23.setText(null);
                    thb24.clearCheck();

                    thb25a.setChecked(false);
                    thb25b.setChecked(false);
                    thb25c.setChecked(false);
                    thb25d.setChecked(false);
                    thb25e.setChecked(false);
                    thb25f.setChecked(false);
                    thb25g.setChecked(false);

                    thb26.clearCheck();

                    thb27.setText(null);
                    thb27888.setChecked(false);

                    thb28.clearCheck();
                    thb2888x.setText(null);

                    thb29.setText(null);
                    thb29888.setChecked(false);

                    thb30.setText(null);
                    thb30888.setChecked(false);

                    thb31.clearCheck();
                    thb32.clearCheck();
                    thb33.clearCheck();

                    thb34.setText(null);
                    thb34888.setChecked(false);

                    thb35.clearCheck();

                    thb36a.setChecked(false);
                    thb36b.setChecked(false);
                    thb36c.setChecked(false);
                    thb36d.setChecked(false);
                    thb36e.setChecked(false);
                    thb36f.setChecked(false);
                    thb36g.setChecked(false);
                    thb36h.setChecked(false);
                    thb36i.setChecked(false);
                    thb36j.setChecked(false);
                    thb36k.setChecked(false);
                    thb3688.setChecked(false);

                    thb3688x.setText(null);

                    fldGrpth08.setVisibility(View.VISIBLE);
                    fldGrpth08a.setVisibility(View.GONE);
                }
            }
        });


        thb0888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (thb0888.isChecked()) {
                    thb0888x.setVisibility(View.VISIBLE);
                    thb0888x.requestFocus();
                } else {
                    thb0888x.setText(null);
                    thb0888x.setVisibility(View.GONE);
                }
            }
        });


        thb10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.thb10a && thb14b.isChecked()) {

                    clearFldgrpthb15();

                    fldGrpth15.setVisibility(View.GONE);

                } else if (thb14b.isChecked()) {
                    clearFldgrpthb15a();

                    fldGrpth15.setVisibility(View.VISIBLE);
                    fldGrpth15a.setVisibility(View.GONE);
                } else {
                    fldGrpth15.setVisibility(View.VISIBLE);
                }
            }
        });

        thb14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.thb14b && thb10a.isChecked()) {

                    clearFldgrpthb15();

                    fldGrpth15.setVisibility(View.GONE);
//                    fldGrpth26.setVisibility(View.VISIBLE);

                } else if (i == R.id.thb14b) {
                    clearFldgrpthb15a();
                    fldGrpth15.setVisibility(View.VISIBLE);
                    fldGrpth15a.setVisibility(View.GONE);
                } else {
                    fldGrpth15.setVisibility(View.VISIBLE);
                    fldGrpth15a.setVisibility(View.VISIBLE);
                }
            }
        });

        thb16.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (thb16b.isChecked()) {

                    thb17.clearCheck();
                    thb1788x.setText(null);

                    thb18.clearCheck();

                    fldGrpth17.setVisibility(View.GONE);
                } else {
                    fldGrpth17.setVisibility(View.VISIBLE);
                }
            }
        });


        thb1788.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (thb1788.isChecked()) {
                    thb1788x.setVisibility(View.VISIBLE);
                    thb1788x.requestFocus();
                } else {
                    thb1788x.setText(null);
                    thb1788x.setVisibility(View.GONE);
                }
            }
        });


        thb21.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (thb21a.isChecked()) {

                    thb21d.setText(null);
                    thb21d.setVisibility(View.GONE);

                    /*thb22.clearCheck();
                    thb23.setText(null);
                    thb24.clearCheck();

                    thb25a.setChecked(false);
                    thb25b.setChecked(false);
                    thb25c.setChecked(false);
                    thb25d.setChecked(false);
                    thb25e.setChecked(false);
                    thb25f.setChecked(false);
                    thb25g.setChecked(false);

                    thb26.clearCheck();*/


                    fldGrpth22.setVisibility(View.VISIBLE);
                    fldGrpth25.setVisibility(View.VISIBLE);
//                    fldGrpth26.setVisibility(View.VISIBLE);

                    thb21hr.setVisibility(View.VISIBLE);
                    thb21hr.requestFocus();

                } else if (thb21b.isChecked()) {
                    thb21hr.setText(null);
                    thb21hr.setVisibility(View.GONE);

                    /*thb22.clearCheck();
                    thb23.setText(null);
                    thb24.clearCheck();

                    thb25a.setChecked(false);
                    thb25b.setChecked(false);
                    thb25c.setChecked(false);
                    thb25d.setChecked(false);
                    thb25e.setChecked(false);
                    thb25f.setChecked(false);
                    thb25g.setChecked(false);

                    thb26.clearCheck();*/

                    fldGrpth22.setVisibility(View.VISIBLE);
                    fldGrpth25.setVisibility(View.VISIBLE);
//                    fldGrpth26.setVisibility(View.VISIBLE);

                    thb21d.setVisibility(View.VISIBLE);
                    thb21d.requestFocus();

                } else if (thb21c.isChecked()) {


                    thb22.clearCheck();
                    thb23.setText(null);
                    thb24.clearCheck();

                    thb25a.setChecked(false);
                    thb25b.setChecked(false);
                    thb25c.setChecked(false);
                    thb25d.setChecked(false);
                    thb25e.setChecked(false);
                    thb25f.setChecked(false);
                    thb25g.setChecked(false);

//                    thb26.clearCheck();


                    thb21hr.setText(null);
                    thb21hr.setVisibility(View.GONE);

                    thb21d.setText(null);
                    thb21d.setVisibility(View.GONE);

                    fldGrpth22.setVisibility(View.GONE);
                    fldGrpth25.setVisibility(View.GONE);
//                    fldGrpth26.setVisibility(View.GONE);
                }
            }
        });


        thb22.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (thb22b.isChecked()) {

                    thb23.setText(null);
                    thb24.clearCheck();

                    thb25a.setChecked(false);
                    thb25b.setChecked(false);
                    thb25c.setChecked(false);
                    thb25d.setChecked(false);
                    thb25e.setChecked(false);
                    thb25f.setChecked(false);
                    thb25g.setChecked(false);

                    fldGrpth23.setVisibility(View.GONE);
                    fldGrpth25.setVisibility(View.GONE);

                } else {
                    fldGrpth23.setVisibility(View.VISIBLE);
                    fldGrpth25.setVisibility(View.VISIBLE);
                }
            }
        });

        thb24.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (thb24a.isChecked()) {

                    thb25a.setChecked(false);
                    thb25b.setChecked(false);
                    thb25c.setChecked(false);
                    thb25d.setChecked(false);
                    thb25e.setChecked(false);
                    thb25f.setChecked(false);
                    thb25g.setChecked(false);

                    fldGrpth25.setVisibility(View.GONE);

                } else {
                    fldGrpth25.setVisibility(View.VISIBLE);
                }
            }
        });


        thb27888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (thb27888.isChecked()) {
                    thb27.setText(null);
                    thb27.setVisibility(View.GONE);
                } else {
                    thb27.setVisibility(View.VISIBLE);
                    thb27.requestFocus();
                }
            }
        });


        thb28.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (thb2888.isChecked()) {
                    thb2888x.setVisibility(View.VISIBLE);
                    thb2888x.requestFocus();
                } else {
                    thb2888x.setText(null);
                    thb2888x.setVisibility(View.GONE);
                }
            }
        });


        thb29888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (thb29888.isChecked()) {
                    thb29.setText(null);
                    thb29.setVisibility(View.GONE);
                } else {
                    thb29.setVisibility(View.VISIBLE);
                    thb29.requestFocus();
                }
            }
        });


        thb30888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (thb30888.isChecked()) {
                    thb30.setText(null);
                    thb30.setVisibility(View.GONE);
                } else {
                    thb30.setVisibility(View.VISIBLE);
                    thb30.requestFocus();
                }
            }
        });


        thb34888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (thb34888.isChecked()) {
                    thb34.setText(null);
                    thb34.setVisibility(View.GONE);
                } else {
                    thb34.setVisibility(View.VISIBLE);
                    thb34.requestFocus();
                }
            }
        });


        thb3688.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (thb3688.isChecked()) {
                    thb3688x.setVisibility(View.VISIBLE);
                    thb3688x.requestFocus();
                } else {
                    thb3688x.setText(null);
                    thb3688x.setVisibility(View.GONE);
                }
            }
        });

    }


    @OnClick(R.id.btn_Continue)
    void SaveData() {

        if (formValidation()) {
            /*try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }*/

            if (UpdateDB()) {
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                finish();

                /*if (MainApp.totalImsCount > 0) {
                    Intent secNext = new Intent(this, SectionIActivity.class);
                    startActivity(secNext);
                } else {*/
                startActivity(new Intent(this, SectionKActivity.class));
//                }
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @OnClick(R.id.btn_End)
    void onBtnEndClick() {

        Toast.makeText(this, "Not Processing This Section", Toast.LENGTH_SHORT).show();

        Toast.makeText(this, "Starting Form Ending Section", Toast.LENGTH_SHORT).show();

        MainApp.endActivity(this, this);
    }


    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        /*int updcount = db.updateSHB();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        return true;

    }


    private boolean formValidation() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        //        00
        if (thb00.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tiRespondentMother), Toast.LENGTH_SHORT).show();
            thb00a.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "thb00: This data is Required!");
            thb00a.setFocusable(true);
            thb00a.setFocusableInTouchMode(true);
            thb00a.requestFocus();
            return false;
        } else {
            thb00a.setError(null);
        }


        //        01
        if (thb01.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb01), Toast.LENGTH_SHORT).show();
            thb01a.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "thb01: This data is Required!");
            thb01a.setFocusable(true);
            thb01a.setFocusableInTouchMode(true);
            thb01a.requestFocus();
            return false;
        } else {
            thb01a.setError(null);
        }


        if (thb01a.isChecked()) {

            //        02
            if (thb02.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb02), Toast.LENGTH_SHORT).show();
                thb02.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "thb02: This data is Required!");
                thb02.requestFocus();
                return false;
            } else {
                thb02.setError(null);
            }

            if (!thb02.getText().toString().isEmpty()) {

                if (Integer.parseInt(thb02.getText().toString()) < 0 || Integer.valueOf(thb02.getText().toString()) > 5) {
                    Toast.makeText(this, "How many children had fever during last two weeks in the household", Toast.LENGTH_SHORT).show();
                    thb02.setError("Data Range is 1-4 ");
                    Log.i(TAG, "thb02: This data is Required!");
                    thb02.requestFocus();
                    return false;
                } else {
                    thb02.setError(null);
                }
            }

        }


        //        03
        if (thb03.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb03), Toast.LENGTH_SHORT).show();
            thb03a.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "thb03: This data is Required!");
            thb03a.setFocusable(true);
            thb03a.setFocusableInTouchMode(true);
            thb03a.requestFocus();
            return false;
        } else {
            thb03a.setError(null);
        }


        if (thb03a.isChecked()) {

            //        04
            if (thb04.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb04), Toast.LENGTH_SHORT).show();
                thb04.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "thb04: This data is Required!");
                thb04.requestFocus();
                return false;
            } else {
                thb04.setError(null);
            }


            if (!thb04.getText().toString().isEmpty()) {

                /*if (Integer.parseInt(thb04.getText().toString()) < 0 || Integer.valueOf(thb04.getText().toString()) > MainApp.TotalChildCount) {
                    Toast.makeText(this, "Number of childrens must be greater than 0", Toast.LENGTH_SHORT).show();
                    thb04.setError("Data Range is " + MainApp.TotalChildCount);
                    Log.i(TAG, "thb04: This data is Required!");
                    thb04.requestFocus();
                    return false;
                } else {
                    thb04.setError(null);
                }*/

            }


            //        05
            /*if (thb05.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb05), Toast.LENGTH_SHORT).show();
                thb05.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "thb05: This data is Required!");
                return false;
            } else {
                thb05.setError(null);
            }*/
            if (thb05.getSelectedItem() == "....") {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.thb05), Toast.LENGTH_SHORT).show();
                ((TextView) thb05.getSelectedView()).setText("This Data is Required");
                ((TextView) thb05.getSelectedView()).setTextColor(Color.RED);
                thb05.requestFocus();
                Log.i(TAG, "thb05: This Data is Required!");
                return false;
            } else {
                ((TextView) thb05.getSelectedView()).setError(null);
            }


            //        06
            if (thb06.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb06), Toast.LENGTH_SHORT).show();
                thb06.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "thb06: This data is Required!");
                thb06.requestFocus();
                return false;
            } else {
                thb06.setError(null);
            }


            if (thb06.getText().toString().isEmpty()) {

                if (Integer.parseInt(thb06.getText().toString()) < 0) {
                    Toast.makeText(this, "Number of days must be greater than 0", Toast.LENGTH_SHORT).show();
                    thb06.setError("Must be greater than 0");
                    Log.i(TAG, "thb06: This data is Required!");
                    thb06.requestFocus();
                    return false;
                } else {
                    thb06.setError(null);
                }

            }


            //        07
            if (thb07.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb07), Toast.LENGTH_SHORT).show();
                thb07a.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "thb07: This data is Required!");
                thb07a.setFocusable(true);
                thb07a.setFocusableInTouchMode(true);
                thb07a.requestFocus();
                return false;
            } else {
                thb07a.setError(null);
            }

            if (thb07b.isChecked() || thb07888.isChecked()) {

                //        08
                if (!thb08a.isChecked()
                        && !thb08b.isChecked()
                        && !thb08c.isChecked()
                        && !thb08d.isChecked()
                        && !thb08e.isChecked()
                        && !thb08f.isChecked()
                        && !thb08g.isChecked()
                        && !thb08h.isChecked()
                        && !thb0888.isChecked()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb08), Toast.LENGTH_LONG).show();
                    thb08a.setError("This data is Required!");
                    Log.i(TAG, "thb08a: This data is Required!");
                    thb08a.setFocusable(true);
                    thb08a.setFocusableInTouchMode(true);
                    thb08a.requestFocus();
                    return false;
                } else {
                    thb08a.setError(null);
                }


                if (thb0888.isChecked()) {
                    //        0888
                    if (thb0888x.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
                        thb0888x.setError("This data is Required!");    // Set Error on last radio button
                        Log.i(TAG, "thb0888x: This data is Required!");
                        thb0888x.requestFocus();
                        return false;
                    } else {
                        thb0888x.setError(null);
                    }
                }


            } else {


                //        09
                if (thb09.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb09), Toast.LENGTH_SHORT).show();
                    thb09.setError("This data is Required!");    // Set Error on last radio button
                    Log.i(TAG, "thb09: This data is Required!");
                    thb09.requestFocus();
                    return false;
                } else {
                    thb09.setError(null);
                }


                //        10
                if (thb10.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb10), Toast.LENGTH_SHORT).show();
                    thb10a.setError("This data is Required!");    // Set Error on last radio button
                    Log.i(TAG, "thb10: This data is Required!");
                    thb10a.setFocusable(true);
                    thb10a.setFocusableInTouchMode(true);
                    thb10a.requestFocus();
                    return false;
                } else {
                    thb10a.setError(null);
                }


                //        11
                if (thb11.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb11), Toast.LENGTH_SHORT).show();
                    thb11a.setError("This data is Required!");    // Set Error on last radio button
                    Log.i(TAG, "thb11: This data is Required!");
                    thb11a.setFocusable(true);
                    thb11a.setFocusableInTouchMode(true);
                    thb11a.requestFocus();
                    return false;
                } else {
                    thb11a.setError(null);
                }


                //        12
                if (!thb12a.isChecked()
                        && !thb12b.isChecked()
                        && !thb12c.isChecked()
                        && !thb12d.isChecked()
                        && !thb12e.isChecked()
                        && !thb12f.isChecked()
                        && !thb12g.isChecked()
                        && !thb12h.isChecked()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb12), Toast.LENGTH_LONG).show();
                    thb12a.setError("This data is Required!");
                    Log.i(TAG, "thb12a: This data is Required!");
                    thb12a.setFocusable(true);
                    thb12a.setFocusableInTouchMode(true);
                    thb12a.requestFocus();
                    return false;
                } else {
                    thb12a.setError(null);
                }


                //        13
                if (thb13.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb13), Toast.LENGTH_SHORT).show();
                    thb13a.setError("This data is Required!");    // Set Error on last radio button
                    Log.i(TAG, "thb13: This data is Required!");
                    thb13a.setFocusable(true);
                    thb13a.setFocusableInTouchMode(true);
                    thb13a.requestFocus();
                    return false;
                } else {
                    thb13a.setError(null);
                }


                //        14
                if (thb14.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb14), Toast.LENGTH_SHORT).show();
                    thb14a.setError("This data is Required!");    // Set Error on last radio button
                    thb14a.setFocusable(true);
                    thb14a.setFocusableInTouchMode(true);
                    thb14a.requestFocus();
                    Log.i(TAG, "thb14: This data is Required!");
                    return false;
                } else {
                    thb14a.setError(null);
                }


                if (thb14a.isChecked()) {

                    //        15
                    if (thb15.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb15), Toast.LENGTH_SHORT).show();
                        thb15a.setError("This data is Required!");    // Set Error on last radio button
                        Log.i(TAG, "thb15: This data is Required!");
                        thb15a.setFocusable(true);
                        thb15a.setFocusableInTouchMode(true);
                        thb15a.requestFocus();
                        return false;
                    } else {
                        thb15a.setError(null);
                    }


                    //        16
                    if (thb16.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb16), Toast.LENGTH_SHORT).show();
                        thb16a.setError("This data is Required!");    // Set Error on last radio button
                        Log.i(TAG, "thb16: This data is Required!");
                        thb16a.setFocusable(true);
                        thb16a.setFocusableInTouchMode(true);
                        thb16a.requestFocus();
                        return false;
                    } else {
                        thb16a.setError(null);
                    }


                    if (thb16a.isChecked()) {

                        //        17
                        if (thb17.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb17), Toast.LENGTH_SHORT).show();
                            thb17a.setError("This data is Required!");    // Set Error on last radio button
                            Log.i(TAG, "thb17: This data is Required!");
                            thb17a.setFocusable(true);
                            thb17a.setFocusableInTouchMode(true);
                            thb17a.requestFocus();
                            return false;
                        } else {
                            thb17a.setError(null);
                        }


                        if (thb1788.isChecked()) {
                            //        1788x
                            if (thb1788x.getText().toString().isEmpty()) {
                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
                                thb1788x.setError("This data is Required!");    // Set Error on last radio button
                                Log.i(TAG, "thb1788x: This data is Required!");
                                thb1788x.requestFocus();
                                return false;
                            } else {
                                thb1788x.setError(null);
                            }
                        }


                        //        18
                        if (thb18.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb18), Toast.LENGTH_SHORT).show();
                            thb18a.setError("This data is Required!");    // Set Error on last radio button
                            Log.i(TAG, "thb18: This data is Required!");
                            thb18a.setFocusable(true);
                            thb18a.setFocusableInTouchMode(true);
                            thb18a.requestFocus();
                            return false;
                        } else {
                            thb18a.setError(null);
                        }

                    }


                    //        19
                    if (thb19.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb19), Toast.LENGTH_SHORT).show();
                        thb19a.setError("This data is Required!");    // Set Error on last radio button
                        Log.i(TAG, "thb19: This data is Required!");
                        thb19a.setFocusable(true);
                        thb19a.setFocusableInTouchMode(true);
                        thb19a.requestFocus();
                        return false;
                    } else {
                        thb19a.setError(null);
                    }


                    //        20
                    if (!thb20a.isChecked()
                            && !thb20b.isChecked()
                            && !thb20c.isChecked()
                            && !thb20d.isChecked()
                            && !thb20e.isChecked()
                            && !thb20f.isChecked()
                            && !thb20g.isChecked()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb20), Toast.LENGTH_LONG).show();
                        thb20a.setError("This data is Required!");
                        Log.i(TAG, "thb20a: This data is Required!");
                        thb20a.setFocusable(true);
                        thb20a.setFocusableInTouchMode(true);
                        thb20a.requestFocus();
                        return false;
                    } else {
                        thb20a.setError(null);
                    }


                    //        21
                    if (thb21.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb21), Toast.LENGTH_SHORT).show();
                        thb21a.setError("This data is Required!");    // Set Error on last radio button
                        Log.i(TAG, "thb21: This data is Required!");
                        thb21a.setFocusable(true);
                        thb21a.setFocusableInTouchMode(true);
                        thb21a.requestFocus();
                        return false;
                    } else {
                        thb21a.setError(null);
                    }


                    if (thb21a.isChecked()) {
                        //        21hr
                        if (thb21hr.getText().toString().isEmpty()) {
                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb21), Toast.LENGTH_SHORT).show();
                            thb21hr.setError("This data is Required!");    // Set Error on last radio button
                            Log.i(TAG, "thb21hr: This data is Required!");
                            thb21hr.requestFocus();
                            return false;
                        } else {
                            thb21hr.setError(null);
                        }


                        if (!thb21hr.getText().toString().isEmpty()) {
                            if (Integer.parseInt(thb21hr.getText().toString()) < 0 && Integer.parseInt(thb21hr.getText().toString()) > 23) {
                                Toast.makeText(this, "Hours must be 0 - 23", Toast.LENGTH_SHORT).show();
                                thb21hr.setError("Hours must be 0 - 23");
                                Log.i(TAG, "thb21hr: This data is Required!");
                                thb21hr.requestFocus();
                                return false;
                            } else {
                                thb21hr.setError(null);
                            }
                        }

                    }


                    if (thb21b.isChecked()) {
                        //        21d
                        if (thb21d.getText().toString().isEmpty()) {
                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb21), Toast.LENGTH_SHORT).show();
                            thb21d.setError("This data is Required!");    // Set Error on last radio button
                            Log.i(TAG, "thb21d: This data is Required!");
                            thb21d.requestFocus();
                            return false;
                        } else {
                            thb21d.setError(null);
                        }
                    }


                    if (!thb21c.isChecked()) {

                        //        22
                        if (thb22.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb22), Toast.LENGTH_SHORT).show();
                            thb22a.setError("This data is Required!");    // Set Error on last radio button
                            Log.i(TAG, "thb22: This data is Required!");
                            thb22a.setFocusable(true);
                            thb22a.setFocusableInTouchMode(true);
                            thb22a.requestFocus();
                            return false;
                        } else {
                            thb22a.setError(null);
                        }


                        if (thb22a.isChecked()) {

                            //        23
                            if (thb23.getText().toString().isEmpty()) {
                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb23), Toast.LENGTH_SHORT).show();
                                thb23.setError("This data is Required!");    // Set Error on last radio button
                                Log.i(TAG, "thb23: This data is Required!");
                                thb23.requestFocus();
                                return false;
                            } else {
                                thb23.setError(null);
                            }


                            //        24
                            if (thb24.getCheckedRadioButtonId() == -1) {
                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb24), Toast.LENGTH_SHORT).show();
                                thb24a.setError("This data is Required!");    // Set Error on last radio button
                                Log.i(TAG, "thb24: This data is Required!");
                                thb24a.setFocusable(true);
                                thb24a.setFocusableInTouchMode(true);
                                thb24a.requestFocus();
                                return false;
                            } else {
                                thb24a.setError(null);
                            }


                            if (thb24b.isChecked()) {

                                //        25
                                if (!thb25a.isChecked()
                                        && !thb25b.isChecked()
                                        && !thb25c.isChecked()
                                        && !thb25d.isChecked()
                                        && !thb25e.isChecked()
                                        && !thb25f.isChecked()
                                        && !thb25g.isChecked()) {
                                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb25), Toast.LENGTH_LONG).show();
                                    thb25a.setError("This data is Required!");
                                    thb25a.setFocusable(true);
                                    thb25a.setFocusableInTouchMode(true);
                                    thb25a.requestFocus();
                                    Log.i(TAG, "thb25a: This data is Required!");
                                    return false;
                                } else {
                                    thb25a.setError(null);
                                }

                            }


                        }


                    }

                    if (!thb10a.isChecked()) {

                        if (!thb27888.isChecked()) {

                            //        27
                            if (thb27.getText().toString().isEmpty()) {
                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb27), Toast.LENGTH_SHORT).show();
                                thb27.setError("This data is Required!");    // Set Error on last radio button
                                thb27.requestFocus();
                                Log.i(TAG, "thb27: This data is Required!");
                                return false;
                            } else {
                                thb27.setError(null);
                            }

                        }


                        //        28
                        if (thb28.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb28), Toast.LENGTH_SHORT).show();
                            thb28a.setError("This data is Required!");    // Set Error on last radio button
                            Log.i(TAG, "thb28: This data is Required!");
                            thb28a.setFocusable(true);
                            thb28a.setFocusableInTouchMode(true);
                            thb28a.requestFocus();
                            return false;
                        } else {
                            thb28a.setError(null);
                        }


                        if (thb2888.isChecked()) {
                            //        2888x
                            if (thb2888x.getText().toString().isEmpty()) {
                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
                                thb2888x.setError("This data is Required!");    // Set Error on last radio button
                                Log.i(TAG, "thb2888x: This data is Required!");
                                thb2888x.requestFocus();
                                return false;
                            } else {
                                thb2888x.setError(null);
                            }
                        }


                        if (!thb29888.isChecked()) {

                            //        29
                            if (thb29.getText().toString().isEmpty()) {
                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb29), Toast.LENGTH_SHORT).show();
                                thb29.setError("This data is Required!");    // Set Error on last radio button
                                Log.i(TAG, "thb29: This data is Required!");
                                thb29.requestFocus();
                                return false;
                            } else {
                                thb29.setError(null);
                            }

                        }


                        if (!thb30888.isChecked()) {

                            //        30
                            if (thb30.getText().toString().isEmpty()) {
                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb30), Toast.LENGTH_SHORT).show();
                                thb30.setError("This data is Required!");    // Set Error on last radio button
                                Log.i(TAG, "thb30: This data is Required!");
                                thb30.requestFocus();
                                return false;
                            } else {
                                thb30.setError(null);
                            }

                        }


                        //        31
                        if (thb31.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb31), Toast.LENGTH_SHORT).show();
                            thb31a.setError("This data is Required!");    // Set Error on last radio button
                            Log.i(TAG, "thb31: This data is Required!");
                            thb31a.setFocusable(true);
                            thb31a.setFocusableInTouchMode(true);
                            thb31a.requestFocus();
                            return false;
                        } else {
                            thb31a.setError(null);
                        }


                        //        32
                        if (thb32.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb32), Toast.LENGTH_SHORT).show();
                            thb32a.setError("This data is Required!");    // Set Error on last radio button
                            Log.i(TAG, "thb32: This data is Required!");
                            thb32a.setFocusable(true);
                            thb32a.setFocusableInTouchMode(true);
                            thb32a.requestFocus();
                            return false;
                        } else {
                            thb32a.setError(null);
                        }
                    }
                }


                //        33
                if (thb33.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb33), Toast.LENGTH_SHORT).show();
                    thb33a.setError("This data is Required!");    // Set Error on last radio button
                    Log.i(TAG, "thb33: This data is Required!");
                    thb33a.setFocusable(true);
                    thb33a.setFocusableInTouchMode(true);
                    thb33a.requestFocus();
                    return false;
                } else {
                    thb33a.setError(null);
                }


                if (!thb34888.isChecked()) {

                    //        34
                    if (thb34.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb34), Toast.LENGTH_SHORT).show();
                        thb34.setError("This data is Required!");    // Set Error on last radio button
                        Log.i(TAG, "thb34: This data is Required!");
                        thb34.requestFocus();
                        return false;
                    } else {
                        thb34.setError(null);
                    }

                }


                //        35
                if (thb35.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb35), Toast.LENGTH_SHORT).show();
                    thb35a.setError("This data is Required!");    // Set Error on last radio button
                    Log.i(TAG, "thb35: This data is Required!");
                    thb35a.setFocusable(true);
                    thb35a.setFocusableInTouchMode(true);
                    thb35a.requestFocus();
                    return false;
                } else {
                    thb35a.setError(null);
                }


                //        36
                if (!thb36a.isChecked()
                        && !thb36b.isChecked()
                        && !thb36c.isChecked()
                        && !thb36d.isChecked()
                        && !thb36e.isChecked()
                        && !thb36f.isChecked()
                        && !thb36g.isChecked()
                        && !thb36h.isChecked()
                        && !thb36i.isChecked()
                        && !thb36j.isChecked()
                        && !thb36k.isChecked()
                        && !thb3688.isChecked()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb36), Toast.LENGTH_LONG).show();
                    thb36a.setError("This data is Required!");
                    thb36a.setFocusable(true);
                    thb36a.setFocusableInTouchMode(true);
                    thb36a.requestFocus();
                    Log.i(TAG, "thb36a: This data is Required!");
                    return false;
                } else {
                    thb36a.setError(null);
                }


                if (thb3688.isChecked()) {
                    //        3688x
                    if (thb3688x.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
                        thb3688x.setError("This data is Required!");    // Set Error on last radio button
                        Log.i(TAG, "thb3688x: This data is Required!");
                        thb3688x.requestFocus();
                        return false;
                    } else {
                        thb3688x.setError(null);
                    }
                }
            }

            //                if (!thb21c.isChecked()) {
            //        26
            if (thb26.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.thb26), Toast.LENGTH_SHORT).show();
                thb26a.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "thb26: This data is Required!");
                thb26a.setFocusable(true);
                thb26a.setFocusableInTouchMode(true);
                thb26a.requestFocus();
                return false;
            } else {
                thb26a.setError(null);
            }
//                }

        }


        return true;

    }


    private void SaveDraft() throws JSONException {

        Toast.makeText(this, "Saving Draft for This Section", Toast.LENGTH_SHORT).show();

        JSONObject sHB = new JSONObject();

        sHB.put("thb00", thb00a.isChecked() ? "1" : thb00b.isChecked() ? "2" : "0");
        sHB.put("thb01", thb01a.isChecked() ? "1" : thb01b.isChecked() ? "2" : thb01888.isChecked() ? "888" : "0");
        sHB.put("thb02", thb02.getText().toString());

        sHB.put("thb03", thb03a.isChecked() ? "1" : thb03b.isChecked() ? "2" : thb03888.isChecked() ? "888" : "0");
        sHB.put("thb04", thb04.getText().toString());
        if (thb03a.isChecked()) {
            sHB.put("thb05", thb05.getSelectedItem().toString());
            sHB.put("thb05Serial", childsMap.get(thb05.getSelectedItem().toString()));
        }
        sHB.put("thb06", thb06.getText().toString());
        sHB.put("thb07", thb07a.isChecked() ? "1" : thb07b.isChecked() ? "2" : thb07888.isChecked() ? "888" : "0");


        sHB.put("thb08a", thb08a.isChecked() ? "1" : "0");
        sHB.put("thb08b", thb08b.isChecked() ? "2" : "0");
        sHB.put("thb08c", thb08c.isChecked() ? "3" : "0");
        sHB.put("thb08d", thb08d.isChecked() ? "4" : "0");
        sHB.put("thb08e", thb08e.isChecked() ? "5" : "0");
        sHB.put("thb08f", thb08f.isChecked() ? "6" : "0");
        sHB.put("thb08g", thb08g.isChecked() ? "7" : "0");
        sHB.put("thb08h", thb08h.isChecked() ? "8" : "0");
        sHB.put("thb088", thb0888.isChecked() ? "9" : "0");

        sHB.put("thb0888x", thb0888x.getText().toString());

        sHB.put("thb09", thb09.getText().toString());

        sHB.put("thb10", thb10a.isChecked() ? "1" : thb10b.isChecked() ? "2"
                : thb10c.isChecked() ? "3"
                : thb10d.isChecked() ? "4"
                : "0");


        sHB.put("thb11", thb11a.isChecked() ? "1" : thb11b.isChecked() ? "2"
                : thb11c.isChecked() ? "3"
                : thb11d.isChecked() ? "4"
                : thb11e.isChecked() ? "4"
                : thb11f.isChecked() ? "5"
                : thb11g.isChecked() ? "6"
                : thb11h.isChecked() ? "7"
                : thb11i.isChecked() ? "8"
                : thb11j.isChecked() ? "9"
                : thb11k.isChecked() ? "10"
                : "0");


        sHB.put("thb12a", thb12a.isChecked() ? "1" : "0");
        sHB.put("thb12b", thb12b.isChecked() ? "2" : "0");
        sHB.put("thb12c", thb12c.isChecked() ? "3" : "0");
        sHB.put("thb12d", thb12d.isChecked() ? "4" : "0");
        sHB.put("thb12e", thb12e.isChecked() ? "5" : "0");
        sHB.put("thb12f", thb12f.isChecked() ? "6" : "0");
        sHB.put("thb12g", thb12g.isChecked() ? "7" : "0");
        sHB.put("thb12h", thb12h.isChecked() ? "8" : "0");

        sHB.put("thb13", thb13a.isChecked() ? "1" : thb13b.isChecked() ? "2" : "0");
        sHB.put("thb14", thb14a.isChecked() ? "1" : thb14b.isChecked() ? "2" : "0");
        sHB.put("thb15", thb15a.isChecked() ? "1" : thb15b.isChecked() ? "2" : thb15c.isChecked() ? "3" : "0");
        sHB.put("thb16", thb16a.isChecked() ? "1" : thb16b.isChecked() ? "2" : "0");


        sHB.put("thb17", thb17a.isChecked() ? "1" : thb17b.isChecked() ? "2"
                : thb17c.isChecked() ? "3"
                : thb17d.isChecked() ? "4"
                : thb1788.isChecked() ? "88"
                : "0");


        sHB.put("thb18", thb18a.isChecked() ? "1" : thb18b.isChecked() ? "2" : thb18c.isChecked() ? "3" : "0");


        sHB.put("thb19", thb19a.isChecked() ? "1" : thb19b.isChecked() ? "2"
                : thb19c.isChecked() ? "3"
                : thb19d.isChecked() ? "4"
                : thb19e.isChecked() ? "5"
                : "0");


        sHB.put("thb20a", thb20a.isChecked() ? "1" : "0");
        sHB.put("thb20b", thb20b.isChecked() ? "2" : "0");
        sHB.put("thb20c", thb20c.isChecked() ? "3" : "0");
        sHB.put("thb20d", thb20d.isChecked() ? "4" : "0");
        sHB.put("thb20e", thb20e.isChecked() ? "5" : "0");
        sHB.put("thb20f", thb20f.isChecked() ? "6" : "0");
        sHB.put("thb20g", thb20g.isChecked() ? "7" : "0");

        sHB.put("thb21", thb21a.isChecked() ? "1" : thb21b.isChecked() ? "2" : thb21c.isChecked() ? "3" : "0");

        sHB.put("thb21hr", thb21hr.getText().toString());
        sHB.put("thb21d", thb21d.getText().toString());

        sHB.put("thb22", thb22a.isChecked() ? "1" : thb22b.isChecked() ? "2" : "0");
        sHB.put("thb23", thb23.getText().toString());
        sHB.put("thb24", thb24a.isChecked() ? "1" : thb24b.isChecked() ? "2" : "0");


        sHB.put("thb25a", thb25a.isChecked() ? "1" : "0");
        sHB.put("thb25b", thb25b.isChecked() ? "2" : "0");
        sHB.put("thb25c", thb25c.isChecked() ? "3" : "0");
        sHB.put("thb25d", thb25d.isChecked() ? "4" : "0");
        sHB.put("thb25e", thb25e.isChecked() ? "5" : "0");
        sHB.put("thb25f", thb25f.isChecked() ? "6" : "0");
        sHB.put("thb25g", thb25g.isChecked() ? "7" : "0");


        sHB.put("thb26", thb26a.isChecked() ? "1" : thb26b.isChecked() ? "2" : thb26c.isChecked() ? "3" : "0");

        if (thb27888.isChecked()) {
            sHB.put("thb27", "888");
        } else {
            sHB.put("thb27", thb27.getText().toString());
        }


        sHB.put("thb28", thb28a.isChecked() ? "1"
                : thb28b.isChecked() ? "2"
                : thb28c.isChecked() ? "3"
                : thb28d.isChecked() ? "4"
                : thb28e.isChecked() ? "5"
                : thb28f.isChecked() ? "6"
                : thb28g.isChecked() ? "7"
                : thb28h.isChecked() ? "8"
                : thb28i.isChecked() ? "9"
                : thb2888.isChecked() ? "88"
                : "0");


        sHB.put("thb2888x", thb2888x.getText().toString());


        if (thb29888.isChecked()) {
            sHB.put("thb29", "888");
        } else {
            sHB.put("thb29", thb29.getText().toString());
        }


        if (thb30888.isChecked()) {
            sHB.put("thb30", "888");
        } else {
            sHB.put("thb30", thb30.getText().toString());
        }


        sHB.put("thb31", thb31a.isChecked() ? "1" : thb31b.isChecked() ? "2" : "0");
        sHB.put("thb32", thb32a.isChecked() ? "1" : thb32b.isChecked() ? "2" : thb3288.isChecked() ? "888"
                : "0");

        sHB.put("thb33", thb33a.isChecked() ? "1" : thb33b.isChecked() ? "2" : thb3388.isChecked() ? "888"
                : "0");


        if (thb34888.isChecked()) {
            sHB.put("thb34", "888");
        } else {
            sHB.put("thb34", thb34.getText().toString());
        }


        sHB.put("thb35", thb35a.isChecked() ? "1" : thb35b.isChecked() ? "2" : thb35c.isChecked() ? "3" : "0");


        sHB.put("thb36a", thb36a.isChecked() ? "1" : "0");
        sHB.put("thb36b", thb36b.isChecked() ? "2" : "0");
        sHB.put("thb36c", thb36c.isChecked() ? "3" : "0");
        sHB.put("thb36d", thb36d.isChecked() ? "4" : "0");
        sHB.put("thb36e", thb36e.isChecked() ? "5" : "0");
        sHB.put("thb36f", thb36f.isChecked() ? "6" : "0");
        sHB.put("thb36g", thb36g.isChecked() ? "7" : "0");
        sHB.put("thb36h", thb36h.isChecked() ? "8" : "0");
        sHB.put("thb36i", thb36i.isChecked() ? "9" : "0");
        sHB.put("thb36j", thb36j.isChecked() ? "10" : "0");
        sHB.put("thb36k", thb36k.isChecked() ? "11" : "0");
        sHB.put("thb3688", thb3688.isChecked() ? "88" : "0");
        sHB.put("thb3688x", thb3688x.getText().toString());
        sHB.put("appver", MainApp.versionName + "." + MainApp.versionCode);

        MainApp.fc.setsHB(String.valueOf(sHB));
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}