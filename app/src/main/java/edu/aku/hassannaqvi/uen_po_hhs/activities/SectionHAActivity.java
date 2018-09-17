package edu.aku.hassannaqvi.uen_po_hhs.activities;

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
import edu.aku.hassannaqvi.uen_po_hhs.R;
import edu.aku.hassannaqvi.uen_po_hhs.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs.core.MainApp;

public class SectionHAActivity extends Activity {

    private static final String TAG = SectionHAActivity.class.getName();

    @BindView(R.id.tha01)
    RadioGroup tha01;
    @BindView(R.id.tha01a)
    RadioButton tha01a;
    @BindView(R.id.tha01b)
    RadioButton tha01b;
    @BindView(R.id.tha01888)
    RadioButton tha01888;
    @BindView(R.id.tha02)
    EditText tha02;
    @BindView(R.id.tha03)
    Spinner tha03;
    @BindView(R.id.tha04)
    EditText tha04;
    @BindView(R.id.tha05)
    RadioGroup tha05;
    @BindView(R.id.tha05a)
    RadioButton tha05a;
    @BindView(R.id.tha05b)
    RadioButton tha05b;
    @BindView(R.id.tha05888)
    RadioButton tha05888;
    @BindView(R.id.tha06)
    RadioGroup tha06;
    @BindView(R.id.tha06a)
    RadioButton tha06a;
    @BindView(R.id.tha06b)
    RadioButton tha06b;
    @BindView(R.id.tha06888)
    RadioButton tha06888;
    @BindView(R.id.tha07a)
    CheckBox tha07a;
    @BindView(R.id.tha07b)
    CheckBox tha07b;
    @BindView(R.id.tha07c)
    CheckBox tha07c;
    @BindView(R.id.tha07d)
    CheckBox tha07d;
    @BindView(R.id.tha07e)
    CheckBox tha07e;
    @BindView(R.id.tha07f)
    CheckBox tha07f;
    @BindView(R.id.tha07g)
    CheckBox tha07g;
    @BindView(R.id.tha07h)
    CheckBox tha07h;
    @BindView(R.id.tha0788)
    CheckBox tha0788;
    @BindView(R.id.tha0788x)
    EditText tha0788x;
    @BindView(R.id.tha08)
    EditText tha08;
    @BindView(R.id.tha09)
    RadioGroup tha09;
    @BindView(R.id.tha09a)
    RadioButton tha09a;
    @BindView(R.id.tha09b)
    RadioButton tha09b;
    @BindView(R.id.tha09c)
    RadioButton tha09c;
    @BindView(R.id.tha09d)
    RadioButton tha09d;
    @BindView(R.id.tha10)
    RadioGroup tha10;
    @BindView(R.id.tha10a)
    RadioButton tha10a;
    @BindView(R.id.tha10b)
    RadioButton tha10b;
    @BindView(R.id.tha10c)
    RadioButton tha10c;
    @BindView(R.id.tha10d)
    RadioButton tha10d;
    @BindView(R.id.tha10e)
    RadioButton tha10e;
    @BindView(R.id.tha10f)
    RadioButton tha10f;
    @BindView(R.id.tha10g)
    RadioButton tha10g;
    @BindView(R.id.tha10h)
    RadioButton tha10h;
    @BindView(R.id.tha10i)
    RadioButton tha10i;
    @BindView(R.id.tha10j)
    RadioButton tha10j;
    @BindView(R.id.tha10k)
    RadioButton tha10k;
    @BindView(R.id.tha11a)
    CheckBox tha11a;
    @BindView(R.id.tha11b)
    CheckBox tha11b;
    @BindView(R.id.tha11c)
    CheckBox tha11c;
    @BindView(R.id.tha11d)
    CheckBox tha11d;
    @BindView(R.id.tha11e)
    CheckBox tha11e;
    @BindView(R.id.tha11f)
    CheckBox tha11f;
    @BindView(R.id.tha11g)
    CheckBox tha11g;
    @BindView(R.id.tha11h)
    CheckBox tha11h;
    @BindView(R.id.tha11i)
    CheckBox tha11i;
    @BindView(R.id.tha11j)
    CheckBox tha11j;
    @BindView(R.id.tha12)
    RadioGroup tha12;
    @BindView(R.id.tha12a)
    RadioButton tha12a;
    @BindView(R.id.tha12b)
    RadioButton tha12b;
    @BindView(R.id.tha13)
    RadioGroup tha13;
    @BindView(R.id.tha13a)
    RadioButton tha13a;
    @BindView(R.id.tha13b)
    RadioButton tha13b;
    @BindView(R.id.tha14)
    RadioGroup tha14;
    @BindView(R.id.tha14a)
    RadioButton tha14a;
    @BindView(R.id.tha14b)
    RadioButton tha14b;
    @BindView(R.id.tha14c)
    RadioButton tha14c;
    @BindView(R.id.tha15)
    RadioGroup tha15;
    @BindView(R.id.tha15a)
    RadioButton tha15a;
    @BindView(R.id.tha15b)
    RadioButton tha15b;
    @BindView(R.id.tha16)
    RadioGroup tha16;
    @BindView(R.id.tha16a)
    RadioButton tha16a;
    @BindView(R.id.tha16b)
    RadioButton tha16b;
    @BindView(R.id.tha16c)
    RadioButton tha16c;
    @BindView(R.id.tha16d)
    RadioButton tha16d;
    @BindView(R.id.tha1688)
    RadioButton tha1688;
    @BindView(R.id.tha1688x)
    EditText tha1688x;
    @BindView(R.id.tha17)
    RadioGroup tha17;
    @BindView(R.id.tha17a)
    RadioButton tha17a;
    @BindView(R.id.tha17b)
    RadioButton tha17b;
    @BindView(R.id.tha17c)
    RadioButton tha17c;
    @BindView(R.id.tha18)
    RadioGroup tha18;
    @BindView(R.id.tha18a)
    RadioButton tha18a;
    @BindView(R.id.tha18b)
    RadioButton tha18b;
    @BindView(R.id.tha18c)
    RadioButton tha18c;
    @BindView(R.id.tha18d)
    RadioButton tha18d;
    @BindView(R.id.tha18e)
    RadioButton tha18e;
    @BindView(R.id.tha19a)
    CheckBox tha19a;
    @BindView(R.id.tha19b)
    CheckBox tha19b;
    @BindView(R.id.tha19c)
    CheckBox tha19c;
    @BindView(R.id.tha19d)
    CheckBox tha19d;
    @BindView(R.id.tha19e)
    CheckBox tha19e;
    @BindView(R.id.tha19f)
    CheckBox tha19f;
    @BindView(R.id.tha19g)
    CheckBox tha19g;
    @BindView(R.id.tha19h)
    CheckBox tha19h;
    @BindView(R.id.tha19i)
    CheckBox tha19i;
    @BindView(R.id.tha20)
    RadioGroup tha20;
    @BindView(R.id.tha20a)
    RadioButton tha20a;
    @BindView(R.id.tha20b)
    RadioButton tha20b;
    @BindView(R.id.tha20c)
    RadioButton tha20c;
    @BindView(R.id.tha20hr)
    EditText tha20hr;
    @BindView(R.id.tha20d)
    EditText tha20d;
    @BindView(R.id.tha21)
    RadioGroup tha21;
    @BindView(R.id.tha21a)
    RadioButton tha21a;
    @BindView(R.id.tha21b)
    RadioButton tha21b;
    @BindView(R.id.tha22)
    EditText tha22;
    @BindView(R.id.tha23)
    RadioGroup tha23;
    @BindView(R.id.tha23a)
    RadioButton tha23a;
    @BindView(R.id.tha23b)
    RadioButton tha23b;
    @BindView(R.id.tha24a)
    CheckBox tha24a;
    @BindView(R.id.tha24b)
    CheckBox tha24b;
    @BindView(R.id.tha24c)
    CheckBox tha24c;
    @BindView(R.id.tha24d)
    CheckBox tha24d;
    @BindView(R.id.tha24e)
    CheckBox tha24e;
    @BindView(R.id.tha24f)
    CheckBox tha24f;
    @BindView(R.id.tha24g)
    CheckBox tha24g;
    @BindView(R.id.tha25)
    RadioGroup tha25;
    @BindView(R.id.tha25a)
    RadioButton tha25a;
    @BindView(R.id.tha25b)
    RadioButton tha25b;
    @BindView(R.id.tha25c)
    RadioButton tha25c;
    @BindView(R.id.tha26)
    EditText tha26;

    @BindView(R.id.tha26888)
    CheckBox tha26888;

    @BindView(R.id.tha27)
    RadioGroup tha27;
    @BindView(R.id.tha27a)
    RadioButton tha27a;
    @BindView(R.id.tha27b)
    RadioButton tha27b;
    @BindView(R.id.tha27c)
    RadioButton tha27c;
    @BindView(R.id.tha27d)
    RadioButton tha27d;
    @BindView(R.id.tha27e)
    RadioButton tha27e;
    @BindView(R.id.tha27f)
    RadioButton tha27f;
    @BindView(R.id.tha27g)
    RadioButton tha27g;
    @BindView(R.id.tha27h)
    RadioButton tha27h;
    @BindView(R.id.tha2788)
    RadioButton tha2788;
    @BindView(R.id.tha2788x)
    EditText tha2788x;
    @BindView(R.id.tha28)
    EditText tha28;

    @BindView(R.id.tha28888)
    CheckBox tha28888;

    @BindView(R.id.tha29)
    EditText tha29;

    @BindView(R.id.tha29888)
    CheckBox tha29888;

    @BindView(R.id.tha30)
    EditText tha30;

    @BindView(R.id.tha30888)
    CheckBox tha30888;

    @BindView(R.id.tha31)
    RadioGroup tha31;
    @BindView(R.id.tha31a)
    RadioButton tha31a;
    @BindView(R.id.tha31b)
    RadioButton tha31b;
    @BindView(R.id.tha31c)
    RadioButton tha31c;
    @BindView(R.id.tha32)
    RadioGroup tha32;
    @BindView(R.id.tha32a)
    RadioButton tha32a;
    @BindView(R.id.tha32b)
    RadioButton tha32b;
    @BindView(R.id.tha33)
    RadioGroup tha33;
    @BindView(R.id.tha33a)
    RadioButton tha33a;
    @BindView(R.id.tha33b)
    RadioButton tha33b;
    @BindView(R.id.tha34)
    RadioGroup tha34;
    @BindView(R.id.tha34a)
    RadioButton tha34a;
    @BindView(R.id.tha34b)
    RadioButton tha34b;
    @BindView(R.id.tha34c)
    RadioButton tha34c;
    @BindView(R.id.tha34d)
    RadioButton tha34d;
    @BindView(R.id.tha34e)
    RadioButton tha34e;
    @BindView(R.id.tha34f)
    RadioButton tha34f;
    @BindView(R.id.tha34g)
    RadioButton tha34g;
    @BindView(R.id.tha34h)
    RadioButton tha34h;
    @BindView(R.id.tha34i)
    RadioButton tha34i;
    @BindView(R.id.tha34j)
    RadioButton tha34j;
    @BindView(R.id.tha34k)
    RadioButton tha34k;

    @BindView(R.id.fldGrptha02)
    LinearLayout fldGrptha02;

    @BindView(R.id.fldGrptha07)
    LinearLayout fldGrptha07;

    @BindView(R.id.fldGrptha14)
    LinearLayout fldGrptha14;

    @BindView(R.id.fldGrptha21)
    LinearLayout fldGrptha21;

    @BindView(R.id.fldGrptha32)
    LinearLayout fldGrptha32;

    @BindView(R.id.fldGrptha34)
    LinearLayout fldGrptha34;

    @BindView((R.id.fldGrptha15))
    LinearLayout fldGrptha15;

    @BindView(R.id.fldGrptha22)
    LinearLayout fldGrptha22;

    @BindView(R.id.fldGrptha23)
    LinearLayout fldGrptha23;

    @BindView(R.id.fldGrptha25)
    LinearLayout fldGrptha25;

    @BindView(R.id.fldGrptha08)
    LinearLayout fldGrptha08;

    @BindView(R.id.fldGrptha30)
    LinearLayout fldGrptha30;

    @BindView(R.id.fldGrptha14a)
    LinearLayout fldGrptha14a;

    @BindView(R.id.tha00)
    RadioGroup tha00;
    @BindView(R.id.tha00a)
    RadioButton tha00a;
    @BindView(R.id.tha00b)
    RadioButton tha00b;

    Map<String, String> childsMap;
    ArrayList<String> lstChild;

    int count_child_5y = 0;

    public void clearFldGrptha14() {
        clearFldGrptha14a();
        tha26.setText(null);
        tha26888.setChecked(false);

        tha27.clearCheck();

        tha28.setText(null);
        tha28888.setChecked(false);
        tha29.setText(null);
        tha29888.setChecked(false);
    }

    public void clearFldGrptha14a() {
        tha14.clearCheck();
        tha15.clearCheck();
        tha16.clearCheck();
        tha17.clearCheck();
        tha18.clearCheck();

        tha19a.setChecked(false);
        tha19b.setChecked(false);
        tha19c.setChecked(false);
        tha19d.setChecked(false);
        tha19e.setChecked(false);
        tha19f.setChecked(false);
        tha19g.setChecked(false);
        tha19h.setChecked(false);
        tha19i.setChecked(false);

        tha20.clearCheck();
        tha20hr.setText(null);
        tha20d.setText(null);
        tha21.clearCheck();
        tha22.setText(null);

        tha23.clearCheck();

        tha24a.setChecked(false);
        tha24b.setChecked(false);
        tha24c.setChecked(false);
        tha24d.setChecked(false);
        tha24e.setChecked(false);
        tha24f.setChecked(false);
        tha24g.setChecked(false);

        tha25.clearCheck();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_ha);
        ButterKnife.bind(this);

        //        get data from sec B

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

                count_child_5y++;
            }
        }*/

        tha03.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lstChild));


        tha01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (tha01a.isChecked()) {
                    fldGrptha02.setVisibility(View.VISIBLE);
                    fldGrptha25.setVisibility(View.VISIBLE);
                } else {

                    tha02.setText(null);
//                    tha03.getChildAt(0).toString();
                    tha04.setText(null);

                    tha05.clearCheck();
                    tha06.clearCheck();

                    tha07a.setChecked(false);
                    tha07b.setChecked(false);
                    tha07c.setChecked(false);
                    tha07d.setChecked(false);
                    tha07e.setChecked(false);
                    tha07f.setChecked(false);
                    tha07g.setChecked(false);
                    tha07h.setChecked(false);
                    tha0788.setChecked(false);

                    tha08.setText(null);

                    tha09a.setChecked(false);
                    tha09b.setChecked(false);
                    tha09c.setChecked(false);
                    tha09d.setChecked(false);

                    tha10.clearCheck();

                    tha11a.setChecked(false);
                    tha11b.setChecked(false);
                    tha11c.setChecked(false);
                    tha11d.setChecked(false);
                    tha11e.setChecked(false);
                    tha11f.setChecked(false);
                    tha11g.setChecked(false);
                    tha11h.setChecked(false);
                    tha11i.setChecked(false);
                    tha11j.setChecked(false);

                    tha12.clearCheck();
                    tha13.clearCheck();
                    tha14.clearCheck();
                    tha15.clearCheck();
                    tha16.clearCheck();

                    tha1688x.setText(null);

                    tha17.clearCheck();
                    tha18.clearCheck();

                    tha19a.setChecked(false);
                    tha19b.setChecked(false);
                    tha19c.setChecked(false);
                    tha19d.setChecked(false);
                    tha19e.setChecked(false);
                    tha19f.setChecked(false);
                    tha19g.setChecked(false);
                    tha19h.setChecked(false);
                    tha19i.setChecked(false);


                    tha20.clearCheck();

                    tha20hr.setText(null);
                    tha20d.setText(null);

                    tha21.clearCheck();

                    tha22.setText(null);
                    tha23.clearCheck();

                    tha24a.setChecked(false);
                    tha24b.setChecked(false);
                    tha24c.setChecked(false);
                    tha24d.setChecked(false);
                    tha24e.setChecked(false);
                    tha24f.setChecked(false);
                    tha24g.setChecked(false);

                    tha25.clearCheck();

                    tha26.setText(null);

                    tha27a.setChecked(false);
                    tha27b.setChecked(false);
                    tha27c.setChecked(false);
                    tha27d.setChecked(false);
                    tha27e.setChecked(false);
                    tha27f.setChecked(false);
                    tha27g.setChecked(false);
                    tha27h.setChecked(false);
                    tha2788.setChecked(false);

                    tha2788x.setText(null);

                    tha28.setText(null);
                    tha29.setText(null);
                    tha30.setText(null);

                    tha31.clearCheck();
                    //tha32.clearCheck();


                    fldGrptha02.setVisibility(View.GONE);
                    fldGrptha14a.setVisibility(View.GONE);
                    fldGrptha25.setVisibility(View.GONE);
                    fldGrptha32.setVisibility(View.GONE);
                    fldGrptha34.setVisibility(View.GONE);
                }
            }
        });


        tha06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (tha06a.isChecked()) {

                    tha07a.setChecked(false);
                    tha07b.setChecked(false);
                    tha07c.setChecked(false);
                    tha07d.setChecked(false);
                    tha07e.setChecked(false);
                    tha07f.setChecked(false);
                    tha07g.setChecked(false);
                    tha07h.setChecked(false);
                    tha0788.setChecked(false);
                    tha0788x.setText(null);

                    fldGrptha07.setVisibility(View.GONE);
                    tha0788x.setVisibility(View.GONE);

                    fldGrptha08.setVisibility(View.VISIBLE);

                } else {

                    fldGrptha07.setVisibility(View.VISIBLE);

                    fldGrptha08.setVisibility(View.GONE);

                    tha08.setText(null);
                    tha09.clearCheck();
                    tha10.clearCheck();
                    tha11a.setChecked(false);
                    tha11b.setChecked(false);
                    tha11c.setChecked(false);
                    tha11d.setChecked(false);
                    tha11e.setChecked(false);
                    tha11f.setChecked(false);
                    tha11g.setChecked(false);
                    tha11h.setChecked(false);
                    tha11i.setChecked(false);
                    tha11j.setChecked(false);

                    tha12.clearCheck();
                    tha13.clearCheck();
                    tha14.clearCheck();
                    tha15.clearCheck();
                    tha16.clearCheck();
                    tha17.clearCheck();
                    tha18.clearCheck();

                    tha19a.setChecked(false);
                    tha19b.setChecked(false);
                    tha19c.setChecked(false);
                    tha19d.setChecked(false);
                    tha19e.setChecked(false);
                    tha19f.setChecked(false);
                    tha19g.setChecked(false);
                    tha19h.setChecked(false);
                    tha19i.setChecked(false);

                    tha20.clearCheck();
                    tha20hr.setText(null);
                    tha20d.setText(null);

                    tha21.clearCheck();
                    tha22.setText(null);

                    tha23.clearCheck();
                    tha24a.setChecked(false);
                    tha24b.setChecked(false);
                    tha24c.setChecked(false);
                    tha24d.setChecked(false);
                    tha24e.setChecked(false);
                    tha24f.setChecked(false);
                    tha24g.setChecked(false);

//                    tha25.clearCheck();
                    tha26.setText(null);
                    tha26888.setChecked(false);

                    tha27.clearCheck();

                    tha28.setText(null);
                    tha28888.setChecked(false);
                    tha29.setText(null);
                    tha29888.setChecked(false);
                    tha30.setText(null);
                    tha30888.setChecked(false);

                    tha31.clearCheck();

                    tha07a.requestFocus();
                }
            }
        });


        tha0788.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (tha0788.isChecked()) {
                    tha0788x.setVisibility(View.VISIBLE);
                    tha0788x.requestFocus();
                } else {
                    tha0788x.setText(null);
                    tha0788x.setVisibility(View.GONE);
                }
            }
        });

        tha09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.tha09a && tha13b.isChecked()) {
                    clearFldGrptha14();
                    fldGrptha14.setVisibility(View.GONE);
                    fldGrptha30.setVisibility(View.VISIBLE);
                } else if (tha13b.isChecked()) {
                    clearFldGrptha14a();
                    fldGrptha14.setVisibility(View.VISIBLE);
                    fldGrptha14a.setVisibility(View.GONE);
                    fldGrptha30.setVisibility(View.VISIBLE);
                } else {
                    fldGrptha14.setVisibility(View.VISIBLE);
                    fldGrptha14a.setVisibility(View.VISIBLE);
                    fldGrptha30.setVisibility(View.VISIBLE);
                }
            }
        });

        tha13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.tha13b && tha09a.isChecked()) {

                    clearFldGrptha14();

                    fldGrptha14.setVisibility(View.GONE);
                    fldGrptha30.setVisibility(View.VISIBLE);

                } else if (i == R.id.tha13b) {
                    clearFldGrptha14a();
                    fldGrptha14.setVisibility(View.VISIBLE);
                    fldGrptha14a.setVisibility(View.VISIBLE);
                    fldGrptha30.setVisibility(View.VISIBLE);
                } else {
                    fldGrptha14.setVisibility(View.VISIBLE);
                    fldGrptha14a.setVisibility(View.VISIBLE);
                    fldGrptha30.setVisibility(View.VISIBLE);
                }
            }
        });

        tha15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (tha15b.isChecked()) {
                    tha16.clearCheck();
                    tha1688x.setText(null);
                    tha17.clearCheck();
                    fldGrptha15.setVisibility(View.GONE);
                } else {
                    fldGrptha15.setVisibility(View.VISIBLE);
                }
            }
        });


        tha1688.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (tha1688.isChecked()) {
                    tha1688x.setVisibility(View.VISIBLE);
                    tha1688x.requestFocus();
                } else {
                    tha1688x.setText(null);
                    tha1688x.setVisibility(View.GONE);
                }
            }
        });


        tha20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (tha20a.isChecked()) {

                    tha20d.setText(null);
                    tha20d.setVisibility(View.GONE);

                    /*tha21.clearCheck();
                    tha22.setText(null);

                    tha23.clearCheck();*/


                    /*tha24a.setChecked(false);
                    tha24b.setChecked(false);
                    tha24c.setChecked(false);
                    tha24d.setChecked(false);
                    tha24e.setChecked(false);
                    tha24f.setChecked(false);
                    tha24g.setChecked(false);

                    tha25.clearCheck();*/

                    fldGrptha21.setVisibility(View.VISIBLE);
//                    fldGrptha25.setVisibility(View.VISIBLE);

                    tha20hr.setVisibility(View.VISIBLE);
                    tha20hr.requestFocus();

                } else if (tha20b.isChecked()) {

                    tha20hr.setText(null);
                    tha20hr.setVisibility(View.GONE);


                    //tha21.clearCheck();
                    //tha22.setText(null);

                    //tha23.clearCheck();

                    /*tha24a.setChecked(false);
                    tha24b.setChecked(false);
                    tha24c.setChecked(false);
                    tha24d.setChecked(false);
                    tha24e.setChecked(false);
                    tha24f.setChecked(false);
                    tha24g.setChecked(false);*/

                    //tha25.clearCheck();


                    fldGrptha21.setVisibility(View.VISIBLE);
//                    fldGrptha25.setVisibility(View.VISIBLE);

                    tha20d.setVisibility(View.VISIBLE);
                    tha20d.requestFocus();

                } else if (tha20c.isChecked()) {

                    tha21.clearCheck();
                    tha22.setText(null);

                    tha23.clearCheck();


                    tha24a.setChecked(false);
                    tha24b.setChecked(false);
                    tha24c.setChecked(false);
                    tha24d.setChecked(false);
                    tha24e.setChecked(false);
                    tha24f.setChecked(false);
                    tha24g.setChecked(false);

//                    tha25.clearCheck();


                    tha20hr.setVisibility(View.GONE);
                    tha20d.setVisibility(View.GONE);

                    tha20hr.setText(null);
                    tha20d.setText(null);

                    fldGrptha21.setVisibility(View.GONE);
//                    fldGrptha25.setVisibility(View.GONE);
                }
            }
        });


        tha21.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (tha21b.isChecked()) {

                    tha22.setText(null);
                    tha23.clearCheck();

                    tha24a.setChecked(false);
                    tha24b.setChecked(false);
                    tha24c.setChecked(false);
                    tha24d.setChecked(false);
                    tha24e.setChecked(false);
                    tha24f.setChecked(false);
                    tha24g.setChecked(false);

                    fldGrptha22.setVisibility(View.GONE);

                } else {
                    fldGrptha22.setVisibility(View.VISIBLE);
                    tha22.requestFocus();
                }
            }
        });


        tha23.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (tha23a.isChecked()) {

                    tha24a.setChecked(false);
                    tha24b.setChecked(false);
                    tha24c.setChecked(false);
                    tha24d.setChecked(false);
                    tha24e.setChecked(false);
                    tha24f.setChecked(false);
                    tha24g.setChecked(false);

                    fldGrptha23.setVisibility(View.GONE);

                } else {
                    fldGrptha23.setVisibility(View.VISIBLE);
                }
            }
        });


        tha26888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (tha26888.isChecked()) {
                    tha26.setText(null);
                    tha26.setVisibility(View.GONE);
                } else {
                    tha26.setVisibility(View.VISIBLE);
                    tha26.requestFocus();
                }
            }
        });


        tha2788.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (tha2788.isChecked()) {
                    tha2788x.setVisibility(View.VISIBLE);
                    tha2788x.requestFocus();
                } else {
                    tha2788x.setText(null);
                    tha2788x.setVisibility(View.GONE);
                }
            }
        });


        tha28888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (tha28888.isChecked()) {
                    tha28.setText(null);
                    tha28.setVisibility(View.GONE);
                } else {
                    tha28.setVisibility(View.VISIBLE);
                    tha28.requestFocus();
                }
            }
        });

        tha29888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (tha29888.isChecked()) {
                    tha29.setText(null);
                    tha29.setVisibility(View.GONE);
                } else {
                    tha29.setVisibility(View.VISIBLE);
                    tha29.requestFocus();
                }
            }
        });


        tha30888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (tha30888.isChecked()) {
                    tha30.setText(null);
                    tha30.setVisibility(View.GONE);
                } else {
                    tha30.setVisibility(View.VISIBLE);
                    tha30.requestFocus();
                }
            }
        });


        tha32.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()

        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (tha32b.isChecked()) {

                    tha33.clearCheck();
                    tha34.clearCheck();

                    fldGrptha32.setVisibility(View.GONE);

                } else {
                    fldGrptha32.setVisibility(View.VISIBLE);
                    fldGrptha34.setVisibility(View.GONE);
                }
            }
        });

        tha33.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()

        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (tha33b.isChecked()) {
                    tha34.clearCheck();
                    fldGrptha34.setVisibility(View.GONE);
                } else {
                    fldGrptha34.setVisibility(View.VISIBLE);
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

                Intent secNext = new Intent(this, SectionHBActivity.class);
                startActivity(secNext);
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

        /*int updcount = db.updateSHA();

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
        if (tha00.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tiRespondentMother), Toast.LENGTH_SHORT).show();
            tha00a.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "tha00: This data is Required!");
            tha00a.setFocusable(true);
            tha00a.setFocusableInTouchMode(true);
            tha00a.requestFocus();
            return false;
        } else {
            tha00a.setError(null);
        }


        //        01
        if (tha01.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha01), Toast.LENGTH_SHORT).show();
            tha01a.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "tha01: This data is Required!");
            tha01a.setFocusable(true);
            tha01a.setFocusableInTouchMode(true);
            tha01a.requestFocus();
            return false;
        } else {
            tha01a.setError(null);
        }


        if (tha01a.isChecked()) {


            //        02
            if (tha02.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha02), Toast.LENGTH_SHORT).show();
                tha02.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "tha02: This data is Required!");
                tha02.requestFocus();
                return false;
            } else {
                tha02.setError(null);
            }

            /*if (MainApp.TotalChildCount < Integer.parseInt(tha02.getText().toString())) {
                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.tha02), Toast.LENGTH_SHORT).show();
                tha02.setError("This data range in " + MainApp.TotalChildCount);    // Set Error on last radio button
                Log.i(TAG, "tha02: This data range in " + MainApp.TotalChildCount);
                tha02.requestFocus();
                return false;
            } else {
                tha02.setError(null);
            }*/


            if (!tha02.getText().toString().isEmpty()) {
                if (Integer.parseInt(tha02.getText().toString()) < 0 || Integer.parseInt(tha02.getText().toString()) > 5) {
                    Toast.makeText(this, "Number of childrens had diarrea in last two weeks must be greater than 0", Toast.LENGTH_SHORT).show();
                    tha02.setError("Must be greater than 0");
                    Log.i(TAG, "tha02: This data is Required!");
                    tha02.requestFocus();
                    return false;
                } else {
                    tha02.setError(null);
                }
            }


            //        03

/*            if (tha03.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha03), Toast.LENGTH_SHORT).show();
                tha03.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "tha03: This data is Required!");
                return false;
            } else {
                tha03.setError(null);
            }*/

            if (tha03.getSelectedItem() == "....") {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.tha03), Toast.LENGTH_SHORT).show();
                ((TextView) tha03.getSelectedView()).setText("This Data is Required");
                ((TextView) tha03.getSelectedView()).setTextColor(Color.RED);
                tha03.requestFocus();
                Log.i(TAG, "tha03: This Data is Required!");
                return false;
            } else {
                ((TextView) tha03.getSelectedView()).setError(null);
            }


            //        04
            if (tha04.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha04), Toast.LENGTH_SHORT).show();
                tha04.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "tha04: This data is Required!");
                tha04.requestFocus();
                return false;
            } else {
                tha04.setError(null);
            }


            if (!tha04.getText().toString().isEmpty() && !tha08.getText().toString().isEmpty()) {
                if (Integer.parseInt(tha04.getText().toString()) <= 0
                        && Integer.parseInt(tha08.getText().toString()) > Integer.parseInt(tha04.getText().toString())) {
                    Toast.makeText(this, "Number of childrens had diarrea in last two weeks must be greater than 0 and it must be greater than " +
                            " After how many days of illness did you seek care", Toast.LENGTH_SHORT).show();
                    tha04.setError("Must be greater than 0");
                    tha04.requestFocus();
                    Log.i(TAG, "tha04: This data is Required!");
                    return false;
                } else {
                    tha04.setError(null);
                }
            }


            //        05
            if (tha05.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha05), Toast.LENGTH_SHORT).show();
                tha05a.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "tha05: This data is Required!");
                tha05a.setFocusable(true);
                tha05a.setFocusableInTouchMode(true);
                tha05a.requestFocus();
                return false;
            } else {
                tha05a.setError(null);
            }


            //        06
            if (tha06.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha06), Toast.LENGTH_SHORT).show();
                tha06a.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "tha06: This data is Required!");
                tha06a.setFocusable(true);
                tha06a.setFocusableInTouchMode(true);
                tha06a.requestFocus();
                return false;
            } else {
                tha06a.setError(null);
            }

            if (tha06b.isChecked() || tha06888.isChecked()) {

                //        07
                if (!tha07a.isChecked()
                        && !tha07b.isChecked()
                        && !tha07c.isChecked()
                        && !tha07d.isChecked()
                        && !tha07e.isChecked()
                        && !tha07f.isChecked()
                        && !tha07g.isChecked()
                        && !tha07h.isChecked()
                        && !tha0788.isChecked()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha07), Toast.LENGTH_LONG).show();
                    tha07a.setError("This data is Required!");
                    Log.i(TAG, "tha07a: This data is Required!");
                    tha07a.setFocusable(true);
                    tha07a.setFocusableInTouchMode(true);
                    tha07a.requestFocus();
                    return false;
                } else {
                    tha07a.setError(null);
                }


                //        0788
                if (tha0788.isChecked()) {
                    if (tha0788.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
                        tha0788.setError("This data is Required!");    // Set Error on last radio button
                        Log.i(TAG, "tha0788: This data is Required!");
                        tha0788x.requestFocus();
                        return false;
                    } else {
                        tha0788.setError(null);
                    }
                }

            } else {

                //        08
                if (tha08.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha08), Toast.LENGTH_SHORT).show();
                    tha08.setError("This data is Required!");    // Set Error on last radio button
                    Log.i(TAG, "tha08: This data is Required!");
                    tha08.requestFocus();
                    return false;
                } else {
                    tha08.setError(null);
                }


                //        09
                if (tha09.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha09), Toast.LENGTH_LONG).show();
                    tha09a.setError("This data is Required!");
                    Log.i(TAG, "tha09: This data is Required!");
                    tha09a.setFocusable(true);
                    tha09a.setFocusableInTouchMode(true);
                    tha09a.requestFocus();
                    return false;
                } else {
                    tha09a.setError(null);
                }


                //        10
                if (tha10.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha10), Toast.LENGTH_SHORT).show();
                    tha10a.setError("This data is Required!");    // Set Error on last radio button
                    Log.i(TAG, "tha10: This data is Required!");
                    tha10a.setFocusable(true);
                    tha10a.setFocusableInTouchMode(true);
                    tha10a.requestFocus();
                    return false;
                } else {
                    tha10a.setError(null);
                }


                //        11
                if (!tha11a.isChecked()
                        && !tha11b.isChecked()
                        && !tha11c.isChecked()
                        && !tha11d.isChecked()
                        && !tha11e.isChecked()
                        && !tha11f.isChecked()
                        && !tha11g.isChecked()
                        && !tha11h.isChecked()
                        && !tha11i.isChecked()
                        && !tha11j.isChecked()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha11), Toast.LENGTH_LONG).show();
                    tha11a.setError("This data is Required!");
                    Log.i(TAG, "tha11a: This data is Required!");
                    tha11a.setFocusable(true);
                    tha11a.setFocusableInTouchMode(true);
                    tha11a.requestFocus();
                    return false;
                } else {
                    tha11a.setError(null);
                }


                //        12
                if (tha12.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha12), Toast.LENGTH_SHORT).show();
                    tha12a.setError("This data is Required!");    // Set Error on last radio button
                    Log.i(TAG, "tha12: This data is Required!");
                    tha12a.setFocusable(true);
                    tha12a.setFocusableInTouchMode(true);
                    tha12a.requestFocus();
                    return false;
                } else {
                    tha12a.setError(null);
                }


                //        13
                if (tha13.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha13), Toast.LENGTH_SHORT).show();
                    tha13a.setError("This data is Required!");    // Set Error on last radio button
                    Log.i(TAG, "tha13: This data is Required!");
                    tha13a.setFocusable(true);
                    tha13a.setFocusableInTouchMode(true);
                    tha13a.requestFocus();
                    return false;
                } else {
                    tha13a.setError(null);
                }

                if (tha13a.isChecked()) {

                    //        14
                    if (tha14.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha14), Toast.LENGTH_SHORT).show();
                        tha14a.setError("This data is Required!");    // Set Error on last radio button
                        Log.i(TAG, "tha14: This data is Required!");
                        tha14a.setFocusable(true);
                        tha14a.setFocusableInTouchMode(true);
                        tha14a.requestFocus();
                        return false;
                    } else {
                        tha14a.setError(null);
                    }


                    //        15
                    if (tha15.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha15), Toast.LENGTH_SHORT).show();
                        tha15a.setError("This data is Required!");    // Set Error on last radio button
                        Log.i(TAG, "tha15: This data is Required!");
                        tha15a.setFocusable(true);
                        tha15a.setFocusableInTouchMode(true);
                        tha15a.requestFocus();
                        return false;
                    } else {
                        tha15a.setError(null);
                    }


                    if (tha15a.isChecked()) {

                        //        16
                        if (tha16.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha16), Toast.LENGTH_SHORT).show();
                            tha16a.setError("This data is Required!");    // Set Error on last radio button
                            Log.i(TAG, "tha16: This data is Required!");
                            tha16a.setFocusable(true);
                            tha16a.setFocusableInTouchMode(true);
                            tha16a.requestFocus();
                            return false;
                        } else {
                            tha16a.setError(null);
                        }


                        //        1688
                        if (tha1688.isChecked()) {
                            if (tha1688x.getText().toString().isEmpty()) {
                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
                                tha1688x.setError("This data is Required!");    // Set Error on last radio button
                                Log.i(TAG, "tha1688x: This data is Required!");
                                tha1688x.requestFocus();
                                return false;
                            } else {
                                tha1688x.setError(null);
                            }
                        }


                        //        17
                        if (tha17.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha17), Toast.LENGTH_SHORT).show();
                            tha17a.setError("This data is Required!");    // Set Error on last radio button
                            Log.i(TAG, "tha17: This data is Required!");
                            tha17a.setFocusable(true);
                            tha17a.setFocusableInTouchMode(true);
                            tha17a.requestFocus();
                            return false;
                        } else {
                            tha17a.setError(null);
                        }

                    }


                    //        18
                    if (tha18.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha18), Toast.LENGTH_SHORT).show();
                        tha18a.setError("This data is Required!");    // Set Error on last radio button
                        Log.i(TAG, "tha18: This data is Required!");
                        tha18a.setFocusable(true);
                        tha18a.setFocusableInTouchMode(true);
                        tha18a.requestFocus();
                        return false;
                    } else {
                        tha18a.setError(null);
                    }


                    //        19
                    if (!tha19a.isChecked()
                            && !tha19b.isChecked()
                            && !tha19c.isChecked()
                            && !tha19d.isChecked()
                            && !tha19e.isChecked()
                            && !tha19f.isChecked()
                            && !tha19g.isChecked()
                            && !tha19h.isChecked()
                            && !tha19i.isChecked()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha19), Toast.LENGTH_LONG).show();
                        tha19a.setError("This data is Required!");
                        Log.i(TAG, "tha19a: This data is Required!");
                        tha19a.setFocusable(true);
                        tha19a.setFocusableInTouchMode(true);
                        tha19a.requestFocus();
                        return false;
                    } else {
                        tha19a.setError(null);
                    }


                    //        20
                    if (tha20.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha20), Toast.LENGTH_SHORT).show();
                        tha20a.setError("This data is Required!");    // Set Error on last radio button
                        Log.i(TAG, "tha20: This data is Required!");
                        tha20a.setFocusable(true);
                        tha20a.setFocusableInTouchMode(true);
                        tha20a.requestFocus();
                        return false;
                    } else {
                        tha20a.setError(null);
                    }


                    //        20hr
                    if (tha20a.isChecked()) {
                        if (tha20hr.getText().toString().isEmpty()) {
                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha20), Toast.LENGTH_SHORT).show();
                            tha20hr.setError("This data is Required!");    // Set Error on last radio button
                            Log.i(TAG, "tha20hr: This data is Required!");
                            tha20hr.requestFocus();
                            return false;
                        } else {
                            tha20hr.setError(null);
                        }
                    }


                    //        20d
                    if (tha20b.isChecked()) {

                        if (tha20d.getText().toString().isEmpty()) {
                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha20), Toast.LENGTH_SHORT).show();
                            tha20d.setError("This data is Required!");    // Set Error on last radio button
                            Log.i(TAG, "tha20d: This data is Required!");
                            tha20d.requestFocus();
                            return false;
                        } else {
                            tha20d.setError(null);
                        }


                        if (!tha20d.getText().toString().isEmpty() && !tha04.getText().toString().isEmpty()
                                && !tha08.getText().toString().isEmpty()) {

                            int diff = Integer.parseInt(tha04.getText().toString()) - Integer.parseInt(tha08.getText().toString());

                            if (Integer.parseInt(tha20d.getText().toString()) <= 0 && Integer.parseInt(tha20d.getText().toString()) < diff) {
                                Toast.makeText(this, "After how many days of discharge were you recommended for a follow up visit and it should be " +
                                        " less than the difference of illness of did you seek care ", Toast.LENGTH_SHORT).show();
                                tha20d.setError("Must be greater than 0 and must be less than difference of illness of did you seek care");
                                Log.i(TAG, "tha20d: This data is Required!");
                                tha20d.requestFocus();
                                return false;
                            } else {
                                tha20d.setError(null);
                            }
                        }

                    }


                    //        20c
                    if (!tha20c.isChecked()) {

                        //        21
                        if (tha21.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha21), Toast.LENGTH_SHORT).show();
                            tha21a.setError("This data is Required!");    // Set Error on last radio button
                            Log.i(TAG, "tha21: This data is Required!");
                            tha21a.setFocusable(true);
                            tha21a.setFocusableInTouchMode(true);
                            tha21a.requestFocus();
                            return false;
                        } else {
                            tha21a.setError(null);
                        }

                        if (tha21a.isChecked()) {

                            //        22
                            if (tha22.getText().toString().isEmpty()) {
                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha22), Toast.LENGTH_SHORT).show();
                                tha22.setError("This data is Required!");    // Set Error on last radio button
                                Log.i(TAG, "tha22: This data is Required!");
                                tha22.requestFocus();
                                return false;
                            } else {
                                tha22.setError(null);
                            }


                            if (Integer.parseInt(tha22.getText().toString().isEmpty() ? "0" : tha22.getText().toString()) <= 0) {
                                Toast.makeText(this, "After how many days of discharge were you recommended for a follow up visit", Toast.LENGTH_SHORT).show();
                                tha22.setError("Must be greater than 0");
                                Log.i(TAG, "tha22: This data is Required!");
                                tha22.requestFocus();
                                return false;
                            } else {
                                tha22.setError(null);
                            }


                            //        23
                            if (tha23.getCheckedRadioButtonId() == -1) {
                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha23), Toast.LENGTH_SHORT).show();
                                tha23a.setError("This data is Required!");    // Set Error on last radio button
                                Log.i(TAG, "tha23: This data is Required!");
                                tha23a.setFocusable(true);
                                tha23a.setFocusableInTouchMode(true);
                                tha23a.requestFocus();
                                return false;
                            } else {
                                tha23a.setError(null);
                            }


                            if (tha23b.isChecked()) {

                                //        24
                                if (!tha24a.isChecked()
                                        && !tha24b.isChecked()
                                        && !tha24c.isChecked()
                                        && !tha24d.isChecked()
                                        && !tha24e.isChecked()
                                        && !tha24f.isChecked()
                                        && !tha24g.isChecked()) {
                                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha24), Toast.LENGTH_LONG).show();
                                    tha24a.setError("This data is Required!");
                                    Log.i(TAG, "tha24a: This data is Required!");
                                    tha24a.setFocusable(true);
                                    tha24a.setFocusableInTouchMode(true);
                                    tha24a.requestFocus();
                                    return false;
                                } else {
                                    tha24a.setError(null);
                                }

                            }

                        }


                    }

                    if (!tha09a.isChecked()) {

                        if (!tha26888.isChecked()) {

                            //        26
                            if (tha26.getText().toString().isEmpty()) {
                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha26), Toast.LENGTH_SHORT).show();
                                tha26.setError("This data is Required!");    // Set Error on last radio button
                                Log.i(TAG, "tha26: This data is Required!");
                                tha26.requestFocus();
                                return false;
                            } else {
                                tha26.setError(null);
                            }


                            if (Double.parseDouble(tha26.getText().toString().isEmpty() ? "0" : tha26.getText().toString()) <= 0) {
                                Toast.makeText(this, "How far is the health facility, where you sought treatment of {NAME} for diarrheal episode", Toast.LENGTH_SHORT).show();
                                tha26.setError("Must be greater than 0");
                                Log.i(TAG, "tha26: This data is Required!");
                                tha26.requestFocus();
                                return false;
                            } else {
                                tha26.setError(null);
                            }

                        }


                        //        27
                        if (tha27.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha27), Toast.LENGTH_SHORT).show();
                            tha27a.setError("This data is Required!");    // Set Error on last radio button
                            Log.i(TAG, "tha27: This data is Required!");
                            tha27a.setFocusable(true);
                            tha27a.setFocusableInTouchMode(true);
                            tha27a.requestFocus();
                            return false;
                        } else {
                            tha27a.setError(null);
                        }


                        //        2788x
                        if (tha2788.isChecked()) {
                            if (tha2788x.getText().toString().isEmpty()) {
                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
                                tha2788x.setError("This data is Required!");    // Set Error on last radio button
                                Log.i(TAG, "tha2788x: This data is Required!");
                                tha2788x.requestFocus();
                                return false;
                            } else {
                                tha2788x.setError(null);
                            }
                        }


                        if (!tha28888.isChecked()) {

                            //        28
                            if (tha28.getText().toString().isEmpty()) {
                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha28), Toast.LENGTH_SHORT).show();
                                tha28.setError("This data is Required!");    // Set Error on last radio button
                                Log.i(TAG, "tha28: This data is Required!");
                                tha28.requestFocus();
                                return false;
                            } else {
                                tha28.setError(null);
                            }

                        }

                        if (!tha29888.isChecked()) {

                            //        29
                            if (tha29.getText().toString().isEmpty()) {
                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha29), Toast.LENGTH_SHORT).show();
                                tha29.setError("This data is Required!");    // Set Error on last radio button
                                Log.i(TAG, "tha29: This data is Required!");
                                tha29.requestFocus();
                                return false;
                            } else {
                                tha29.setError(null);
                            }
                        }
                    }
                }

                if (!tha30888.isChecked()) {

                    //        30
                    if (tha30.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha30), Toast.LENGTH_SHORT).show();
                        tha30.setError("This data is Required!");    // Set Error on last radio button
                        Log.i(TAG, "tha30: This data is Required!");
                        tha30.requestFocus();
                        return false;
                    } else {
                        tha30.setError(null);
                    }

                }


                //        31
                if (tha31.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha31), Toast.LENGTH_SHORT).show();
                    tha31a.setError("This data is Required!");    // Set Error on last radio button
                    Log.i(TAG, "tha31: This data is Required!");
                    tha31a.setFocusable(true);
                    tha31a.setFocusableInTouchMode(true);
                    tha31a.requestFocus();
                    return false;
                } else {
                    tha31a.setError(null);
                }

//            if (!tha20c.isChecked()) {

                //        25
                if (tha25.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha25), Toast.LENGTH_SHORT).show();
                    tha25a.setError("This data is Required!");    // Set Error on last radio button
                    Log.i(TAG, "tha25: This data is Required!");
                    tha25a.setFocusable(true);
                    tha25a.setFocusableInTouchMode(true);
                    tha25a.requestFocus();
                    return false;
                } else {
                    tha25a.setError(null);
                }

            }
        }
        //        32
        if (tha32.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha32), Toast.LENGTH_SHORT).show();
            tha32a.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "tha32: This data is Required!");
            tha32a.setFocusable(true);
            tha32a.setFocusableInTouchMode(true);
            tha32a.requestFocus();
            return false;
        } else {
            tha32a.setError(null);
        }

//        }


        if (tha32a.isChecked()) {

            //        33
            if (tha33.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha33), Toast.LENGTH_SHORT).show();
                tha33a.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "tha33: This data is Required!");
                tha33a.setFocusable(true);
                tha33a.setFocusableInTouchMode(true);
                tha33a.requestFocus();
                return false;
            } else {
                tha33a.setError(null);
            }

        }

        if (tha33a.isChecked()) {

            //        34
            if (tha34.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha34), Toast.LENGTH_SHORT).show();
                tha34a.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "tha34: This data is Required!");
                tha34a.setFocusable(true);
                tha34a.setFocusableInTouchMode(true);
                tha34a.requestFocus();
                return false;
            } else {
                tha34a.setError(null);
            }

        }

        return true;
    }

    private void SaveDraft() throws JSONException {

        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sHA = new JSONObject();

        sHA.put("tha00", tha00a.isChecked() ? "1" : tha00b.isChecked() ? "2" : "0");
        sHA.put("tha01", tha01a.isChecked() ? "1" : tha01b.isChecked() ? "2" : tha01888.isChecked() ? "888" : "0");
        sHA.put("tha02", tha02.getText().toString());
        if (tha01a.isChecked()) {
            sHA.put("tha03", tha03.getSelectedItem().toString());
            sHA.put("tha03Serial", childsMap.get(tha03.getSelectedItem().toString()));
        }
        sHA.put("tha04", tha04.getText().toString());

        sHA.put("tha05", tha05a.isChecked() ? "1" : tha05b.isChecked() ? "2" : tha05888.isChecked() ? "888" : "0");
        sHA.put("tha06", tha06a.isChecked() ? "1" : tha06b.isChecked() ? "2" : tha06888.isChecked() ? "888" : "0");

        sHA.put("tha07a", tha07a.isChecked() ? "1" : "0");
        sHA.put("tha07b", tha07b.isChecked() ? "2" : "0");
        sHA.put("tha07c", tha07c.isChecked() ? "3" : "0");
        sHA.put("tha07d", tha07d.isChecked() ? "4" : "0");
        sHA.put("tha07e", tha07e.isChecked() ? "5" : "0");
        sHA.put("tha07f", tha07f.isChecked() ? "6" : "0");
        sHA.put("tha07g", tha07g.isChecked() ? "7" : "0");
        sHA.put("tha07h", tha07h.isChecked() ? "8" : "0");
        sHA.put("tha0788", tha0788.isChecked() ? "88" : "0");
        sHA.put("tha0788x", tha0788x.getText().toString());

        sHA.put("tha08", tha08.getText().toString());

        sHA.put("tha09", tha09a.isChecked() ? "1"
                : tha09b.isChecked() ? "2"
                : tha09c.isChecked() ? "3"
                : tha09d.isChecked() ? "4"
                : "0");


        sHA.put("tha10", tha10a.isChecked() ? "1"
                : tha10b.isChecked() ? "2"
                : tha10c.isChecked() ? "3"
                : tha10d.isChecked() ? "4"
                : tha10e.isChecked() ? "5"
                : tha10f.isChecked() ? "6"
                : tha10g.isChecked() ? "7"
                : tha10h.isChecked() ? "8"
                : tha10i.isChecked() ? "9"
                : tha10j.isChecked() ? "10"
                : tha10k.isChecked() ? "11"
                : "0");


        sHA.put("tha11a", tha11a.isChecked() ? "1" : "0");
        sHA.put("tha11b", tha11b.isChecked() ? "2" : "0");
        sHA.put("tha11c", tha11c.isChecked() ? "3" : "0");
        sHA.put("tha11d", tha11d.isChecked() ? "4" : "0");
        sHA.put("tha11e", tha11e.isChecked() ? "5" : "0");
        sHA.put("tha11f", tha11f.isChecked() ? "6" : "0");
        sHA.put("tha11g", tha11g.isChecked() ? "7" : "0");
        sHA.put("tha11h", tha11h.isChecked() ? "8" : "0");
        sHA.put("tha11i", tha11i.isChecked() ? "9" : "0");
        sHA.put("tha11j", tha11j.isChecked() ? "10" : "0");

        sHA.put("tha12", tha12a.isChecked() ? "1" : tha12b.isChecked() ? "2" : "0");
        sHA.put("tha13", tha13a.isChecked() ? "1" : tha13b.isChecked() ? "2" : "0");

        sHA.put("tha14", tha14a.isChecked() ? "1" : tha14b.isChecked() ? "2" : tha14c.isChecked() ? "3" : "0");
        sHA.put("tha15", tha15a.isChecked() ? "1" : tha15b.isChecked() ? "2" : "0");
        sHA.put("tha16", tha16a.isChecked() ? "1" : tha16b.isChecked() ? "2" : tha16c.isChecked() ? "3" : tha1688.isChecked() ? "88" : "0");

        sHA.put("tha1688x", tha1688x.getText().toString());


        sHA.put("tha17", tha17a.isChecked() ? "1" : tha17b.isChecked() ? "2" : tha17c.isChecked() ? "3" : "0");

        sHA.put("tha18", tha18a.isChecked() ? "1"
                : tha18b.isChecked() ? "2"
                : tha18c.isChecked() ? "3"
                : tha18d.isChecked() ? "4"
                : tha18e.isChecked() ? "5"
                : "0");


        sHA.put("tha19a", tha19a.isChecked() ? "1" : "0");
        sHA.put("tha19b", tha19b.isChecked() ? "2" : "0");
        sHA.put("tha19c", tha19c.isChecked() ? "3" : "0");
        sHA.put("tha19d", tha19d.isChecked() ? "4" : "0");
        sHA.put("tha19e", tha19e.isChecked() ? "5" : "0");
        sHA.put("tha19f", tha19f.isChecked() ? "6" : "0");
        sHA.put("tha19g", tha19g.isChecked() ? "7" : "0");
        sHA.put("tha19h", tha19h.isChecked() ? "8" : "0");
        sHA.put("tha19i", tha19i.isChecked() ? "9" : "0");


        sHA.put("tha20", tha20a.isChecked() ? "1" : tha20b.isChecked() ? "2" : tha20c.isChecked() ? "3" : "0");

        sHA.put("tha20hr", tha20hr.getText().toString());
        sHA.put("tha20d", tha20d.getText().toString());

        sHA.put("tha21", tha21a.isChecked() ? "1" : tha21b.isChecked() ? "2" : "0");
        sHA.put("tha22", tha22.getText().toString());
        sHA.put("tha23", tha23a.isChecked() ? "1" : tha23b.isChecked() ? "2" : "0");

        sHA.put("tha24a", tha24a.isChecked() ? "1" : "0");
        sHA.put("tha24b", tha24b.isChecked() ? "2" : "0");
        sHA.put("tha24c", tha24c.isChecked() ? "3" : "0");
        sHA.put("tha24d", tha24d.isChecked() ? "4" : "0");
        sHA.put("tha24e", tha24e.isChecked() ? "5" : "0");
        sHA.put("tha24f", tha24f.isChecked() ? "6" : "0");
        sHA.put("tha24g", tha24g.isChecked() ? "7" : "0");


        sHA.put("tha25", tha25a.isChecked() ? "1" : tha25b.isChecked() ? "2" : tha25c.isChecked() ? "3" : "0");

        if (tha26888.isChecked()) {
            sHA.put("tha26", "888");
        } else {
            sHA.put("tha26", tha26.getText().toString());
        }


        sHA.put("tha27", tha27a.isChecked() ? "1" : tha27b.isChecked() ? "2"
                : tha27c.isChecked() ? "3"
                : tha27d.isChecked() ? "4"
                : tha27e.isChecked() ? "5"
                : tha27f.isChecked() ? "6"
                : tha27g.isChecked() ? "7"
                : tha27h.isChecked() ? "8"
                : tha2788.isChecked() ? "88"
                : "0");


        sHA.put("tha2788x", tha2788x.getText().toString());


        if (tha28888.isChecked()) {
            sHA.put("tha28", "888");
        } else {
            sHA.put("tha28", tha28.getText().toString());
        }


        if (tha29888.isChecked()) {
            sHA.put("tha29", "888");
        } else {
            sHA.put("tha29", tha29.getText().toString());
        }


        if (tha30888.isChecked()) {
            sHA.put("tha30", "888");
        } else {
            sHA.put("tha30", tha30.getText().toString());
        }


        sHA.put("tha31", tha31a.isChecked() ? "1" : tha31b.isChecked() ? "2" : tha31c.isChecked() ? "3" : "0");
        sHA.put("tha32", tha32a.isChecked() ? "1" : tha32b.isChecked() ? "2" : "0");
        sHA.put("tha33", tha33a.isChecked() ? "1" : tha33b.isChecked() ? "2" : "0");


        sHA.put("tha34", tha34a.isChecked() ? "1" : tha34b.isChecked() ? "2"
                : tha34c.isChecked() ? "3"
                : tha34d.isChecked() ? "4"
                : tha34e.isChecked() ? "5"
                : tha34f.isChecked() ? "6"
                : tha34g.isChecked() ? "7"
                : tha34h.isChecked() ? "8"
                : tha34i.isChecked() ? "9"
                : tha34j.isChecked() ? "10"
                : tha34k.isChecked() ? "11"
                : "0");

        sHA.put("appver", MainApp.versionName + "." + MainApp.versionCode);

        MainApp.fc.setsHA(String.valueOf(sHA));

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}
