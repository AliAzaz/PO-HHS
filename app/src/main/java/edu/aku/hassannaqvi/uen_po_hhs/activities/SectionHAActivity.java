package edu.aku.hassannaqvi.uen_po_hhs.activities;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
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
import edu.aku.hassannaqvi.uen_po_hhs.databinding.ActivitySectionHaBinding;
import edu.aku.hassannaqvi.uen_po_hhs.validator.ClearClass;
import edu.aku.hassannaqvi.uen_po_hhs.validator.validatorClass;

public class SectionHAActivity extends Activity {

    private static final String TAG = SectionHAActivity.class.getName();

    ActivitySectionHaBinding bi;

    Map<String, String> childsMap;
    ArrayList<String> lstChild;

    int count_child_5y = 0;

//    public void clearFldGrptha14() {
//        clearFldGrptha14a();
//        tha26.setText(null);
//        tha26888.setChecked(false);
//
//        tha27.clearCheck();
//
//        tha28.setText(null);
//        tha28888.setChecked(false);
//        tha29.setText(null);
//        tha29888.setChecked(false);
//    }

    public void clearFldGrptha14a() {
//        tha14.clearCheck();
//        tha15.clearCheck();
//        tha16.clearCheck();
//        tha17.clearCheck();
//        tha18.clearCheck();
//
//        tha19a.setChecked(false);
//        tha19b.setChecked(false);
//        tha19c.setChecked(false);
//        tha19d.setChecked(false);
//        tha19e.setChecked(false);
//        tha19f.setChecked(false);
//        tha19g.setChecked(false);
//        tha19h.setChecked(false);
//        tha19i.setChecked(false);
//
//        tha20.clearCheck();
//        tha20hr.setText(null);
//        tha20d.setText(null);
//        tha21.clearCheck();
//        tha22.setText(null);
//
//        tha23.clearCheck();
//
//        tha24a.setChecked(false);
//        tha24b.setChecked(false);
//        tha24c.setChecked(false);
//        tha24d.setChecked(false);
//        tha24e.setChecked(false);
//        tha24f.setChecked(false);
//        tha24g.setChecked(false);
//
//        tha25.clearCheck();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_ha);
        bi.setCallback(this);

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

        bi.tha03.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lstChild));

        bi.tha01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.tha01a) {
                    bi.fldgrptha02.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha02, false);
                    bi.fldgrptha03.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha03, false);
                    bi.fldgrptha04.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha04, false);
                    bi.fldgrptha05.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha05, false);
                    bi.fldgrptha06.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha06, false);
                    bi.fldgrptha07.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha07, false);
                    bi.fldgrptha08.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, false);
                    bi.fldgrptha09.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, false);
                    bi.fldgrptha10.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, false);
                    bi.fldgrptha11.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, false);
                    bi.fldgrptha12.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, false);
                    bi.fldgrptha13.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, false);
                    bi.fldgrptha14.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, false);
                    bi.fldgrptha15.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, false);
                    bi.fldgrptha16.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, false);
                    bi.fldgrptha17.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, false);
                    bi.fldgrptha18.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, false);
                    bi.fldgrptha19.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, false);
                    bi.fldgrptha20.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, false);
                    bi.fldgrptha21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, false);
                    bi.fldgrptha22.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, false);
                    bi.fldgrptha23.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, false);
                    bi.fldgrptha24.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, false);
                    bi.fldgrptha25.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, false);
                    bi.fldgrptha26.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, false);
                    bi.fldgrptha27.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, false);
                    bi.fldgrptha28.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, false);

                } else {

                    bi.fldgrptha02.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha02, true);
                    bi.fldgrptha03.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha03, true);
                    bi.fldgrptha04.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha04, true);
                    bi.fldgrptha05.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha05, true);
                    bi.fldgrptha06.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha06, true);
                    bi.fldgrptha07.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha07, true);
                    bi.fldgrptha08.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, true);
                    bi.fldgrptha09.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, true);
                    bi.fldgrptha10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, true);
                    bi.fldgrptha11.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, true);
                    bi.fldgrptha12.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, true);
                    bi.fldgrptha13.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, true);
                    bi.fldgrptha14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, true);
                    bi.fldgrptha15.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, true);
                    bi.fldgrptha16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, true);
                    bi.fldgrptha17.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, true);
                    bi.fldgrptha18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, true);
                    bi.fldgrptha19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, true);
                    bi.fldgrptha20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, true);
                    bi.fldgrptha21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, true);
                    bi.fldgrptha22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, true);
                    bi.fldgrptha23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, true);
                    bi.fldgrptha24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, true);
                    bi.fldgrptha25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, true);
                    bi.fldgrptha26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, true);
                    bi.fldgrptha27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, true);
                    bi.fldgrptha28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, true);
                }
            }
        });

        bi.tha06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tha06a) {

                    bi.fldgrptha07.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha07, false);
                } else {
                    bi.fldgrptha07.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha07, true);
                }
            }
        });

        bi.tha07a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {

                    bi.fldgrptha08.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, false);
                    bi.fldgrptha09.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, false);
                    bi.fldgrptha10.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, false);
                    bi.fldgrptha11.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, false);
                    bi.fldgrptha12.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, false);
                    bi.fldgrptha13.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, false);
                    bi.fldgrptha14.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, false);
                    bi.fldgrptha15.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, false);
                    bi.fldgrptha16.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, false);
                    bi.fldgrptha17.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, false);
                    bi.fldgrptha18.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, false);
                    bi.fldgrptha19.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, false);
                    bi.fldgrptha20.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, false);
                    bi.fldgrptha21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, false);
                    bi.fldgrptha22.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, false);
                    bi.fldgrptha23.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, false);
                    bi.fldgrptha24.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, false);
                    bi.fldgrptha25.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, false);
                    bi.fldgrptha26.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, false);
                    bi.fldgrptha27.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, false);
                    bi.fldgrptha28.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, false);


                } else {
                    bi.fldgrptha08.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, true);
                    bi.fldgrptha09.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, true);
                    bi.fldgrptha10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, true);
                    bi.fldgrptha11.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, true);
                    bi.fldgrptha12.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, true);
                    bi.fldgrptha13.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, true);
                    bi.fldgrptha14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, true);
                    bi.fldgrptha15.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, true);
                    bi.fldgrptha16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, true);
                    bi.fldgrptha17.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, true);
                    bi.fldgrptha18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, true);
                    bi.fldgrptha19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, true);
                    bi.fldgrptha20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, true);
                    bi.fldgrptha21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, true);
                    bi.fldgrptha22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, true);
                    bi.fldgrptha23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, true);
                    bi.fldgrptha24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, true);
                    bi.fldgrptha25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, true);
                    bi.fldgrptha26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, true);
                    bi.fldgrptha27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, true);
                    bi.fldgrptha28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, true);
                }
            }
        });

        bi.tha07b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {

                    bi.fldgrptha08.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, false);
                    bi.fldgrptha09.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, false);
                    bi.fldgrptha10.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, false);
                    bi.fldgrptha11.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, false);
                    bi.fldgrptha12.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, false);
                    bi.fldgrptha13.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, false);
                    bi.fldgrptha14.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, false);
                    bi.fldgrptha15.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, false);
                    bi.fldgrptha16.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, false);
                    bi.fldgrptha17.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, false);
                    bi.fldgrptha18.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, false);
                    bi.fldgrptha19.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, false);
                    bi.fldgrptha20.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, false);
                    bi.fldgrptha21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, false);
                    bi.fldgrptha22.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, false);
                    bi.fldgrptha23.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, false);
                    bi.fldgrptha24.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, false);
                    bi.fldgrptha25.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, false);
                    bi.fldgrptha26.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, false);
                    bi.fldgrptha27.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, false);
                    bi.fldgrptha28.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, false);


                } else {
                    bi.fldgrptha08.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, true);
                    bi.fldgrptha09.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, true);
                    bi.fldgrptha10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, true);
                    bi.fldgrptha11.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, true);
                    bi.fldgrptha12.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, true);
                    bi.fldgrptha13.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, true);
                    bi.fldgrptha14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, true);
                    bi.fldgrptha15.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, true);
                    bi.fldgrptha16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, true);
                    bi.fldgrptha17.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, true);
                    bi.fldgrptha18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, true);
                    bi.fldgrptha19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, true);
                    bi.fldgrptha20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, true);
                    bi.fldgrptha21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, true);
                    bi.fldgrptha22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, true);
                    bi.fldgrptha23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, true);
                    bi.fldgrptha24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, true);
                    bi.fldgrptha25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, true);
                    bi.fldgrptha26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, true);
                    bi.fldgrptha27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, true);
                    bi.fldgrptha28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, true);
                }
            }
        });

        bi.tha07c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {

                    bi.fldgrptha08.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, false);
                    bi.fldgrptha09.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, false);
                    bi.fldgrptha10.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, false);
                    bi.fldgrptha11.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, false);
                    bi.fldgrptha12.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, false);
                    bi.fldgrptha13.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, false);
                    bi.fldgrptha14.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, false);
                    bi.fldgrptha15.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, false);
                    bi.fldgrptha16.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, false);
                    bi.fldgrptha17.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, false);
                    bi.fldgrptha18.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, false);
                    bi.fldgrptha19.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, false);
                    bi.fldgrptha20.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, false);
                    bi.fldgrptha21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, false);
                    bi.fldgrptha22.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, false);
                    bi.fldgrptha23.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, false);
                    bi.fldgrptha24.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, false);
                    bi.fldgrptha25.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, false);
                    bi.fldgrptha26.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, false);
                    bi.fldgrptha27.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, false);
                    bi.fldgrptha28.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, false);


                } else {
                    bi.fldgrptha08.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, true);
                    bi.fldgrptha09.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, true);
                    bi.fldgrptha10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, true);
                    bi.fldgrptha11.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, true);
                    bi.fldgrptha12.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, true);
                    bi.fldgrptha13.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, true);
                    bi.fldgrptha14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, true);
                    bi.fldgrptha15.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, true);
                    bi.fldgrptha16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, true);
                    bi.fldgrptha17.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, true);
                    bi.fldgrptha18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, true);
                    bi.fldgrptha19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, true);
                    bi.fldgrptha20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, true);
                    bi.fldgrptha21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, true);
                    bi.fldgrptha22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, true);
                    bi.fldgrptha23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, true);
                    bi.fldgrptha24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, true);
                    bi.fldgrptha25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, true);
                    bi.fldgrptha26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, true);
                    bi.fldgrptha27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, true);
                    bi.fldgrptha28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, true);
                }
            }
        });
        bi.tha07d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {

                    bi.fldgrptha08.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, false);
                    bi.fldgrptha09.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, false);
                    bi.fldgrptha10.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, false);
                    bi.fldgrptha11.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, false);
                    bi.fldgrptha12.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, false);
                    bi.fldgrptha13.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, false);
                    bi.fldgrptha14.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, false);
                    bi.fldgrptha15.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, false);
                    bi.fldgrptha16.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, false);
                    bi.fldgrptha17.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, false);
                    bi.fldgrptha18.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, false);
                    bi.fldgrptha19.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, false);
                    bi.fldgrptha20.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, false);
                    bi.fldgrptha21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, false);
                    bi.fldgrptha22.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, false);
                    bi.fldgrptha23.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, false);
                    bi.fldgrptha24.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, false);
                    bi.fldgrptha25.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, false);
                    bi.fldgrptha26.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, false);
                    bi.fldgrptha27.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, false);
                    bi.fldgrptha28.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, false);


                } else {
                    bi.fldgrptha08.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, true);
                    bi.fldgrptha09.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, true);
                    bi.fldgrptha10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, true);
                    bi.fldgrptha11.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, true);
                    bi.fldgrptha12.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, true);
                    bi.fldgrptha13.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, true);
                    bi.fldgrptha14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, true);
                    bi.fldgrptha15.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, true);
                    bi.fldgrptha16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, true);
                    bi.fldgrptha17.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, true);
                    bi.fldgrptha18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, true);
                    bi.fldgrptha19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, true);
                    bi.fldgrptha20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, true);
                    bi.fldgrptha21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, true);
                    bi.fldgrptha22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, true);
                    bi.fldgrptha23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, true);
                    bi.fldgrptha24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, true);
                    bi.fldgrptha25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, true);
                    bi.fldgrptha26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, true);
                    bi.fldgrptha27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, true);
                    bi.fldgrptha28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, true);
                }
            }
        });
        bi.tha07e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {

                    bi.fldgrptha08.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, false);
                    bi.fldgrptha09.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, false);
                    bi.fldgrptha10.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, false);
                    bi.fldgrptha11.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, false);
                    bi.fldgrptha12.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, false);
                    bi.fldgrptha13.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, false);
                    bi.fldgrptha14.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, false);
                    bi.fldgrptha15.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, false);
                    bi.fldgrptha16.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, false);
                    bi.fldgrptha17.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, false);
                    bi.fldgrptha18.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, false);
                    bi.fldgrptha19.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, false);
                    bi.fldgrptha20.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, false);
                    bi.fldgrptha21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, false);
                    bi.fldgrptha22.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, false);
                    bi.fldgrptha23.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, false);
                    bi.fldgrptha24.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, false);
                    bi.fldgrptha25.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, false);
                    bi.fldgrptha26.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, false);
                    bi.fldgrptha27.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, false);
                    bi.fldgrptha28.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, false);


                } else {
                    bi.fldgrptha08.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, true);
                    bi.fldgrptha09.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, true);
                    bi.fldgrptha10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, true);
                    bi.fldgrptha11.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, true);
                    bi.fldgrptha12.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, true);
                    bi.fldgrptha13.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, true);
                    bi.fldgrptha14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, true);
                    bi.fldgrptha15.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, true);
                    bi.fldgrptha16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, true);
                    bi.fldgrptha17.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, true);
                    bi.fldgrptha18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, true);
                    bi.fldgrptha19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, true);
                    bi.fldgrptha20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, true);
                    bi.fldgrptha21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, true);
                    bi.fldgrptha22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, true);
                    bi.fldgrptha23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, true);
                    bi.fldgrptha24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, true);
                    bi.fldgrptha25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, true);
                    bi.fldgrptha26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, true);
                    bi.fldgrptha27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, true);
                    bi.fldgrptha28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, true);
                }
            }
        });
        bi.tha07f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {

                    bi.fldgrptha08.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, false);
                    bi.fldgrptha09.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, false);
                    bi.fldgrptha10.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, false);
                    bi.fldgrptha11.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, false);
                    bi.fldgrptha12.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, false);
                    bi.fldgrptha13.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, false);
                    bi.fldgrptha14.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, false);
                    bi.fldgrptha15.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, false);
                    bi.fldgrptha16.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, false);
                    bi.fldgrptha17.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, false);
                    bi.fldgrptha18.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, false);
                    bi.fldgrptha19.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, false);
                    bi.fldgrptha20.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, false);
                    bi.fldgrptha21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, false);
                    bi.fldgrptha22.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, false);
                    bi.fldgrptha23.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, false);
                    bi.fldgrptha24.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, false);
                    bi.fldgrptha25.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, false);
                    bi.fldgrptha26.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, false);
                    bi.fldgrptha27.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, false);
                    bi.fldgrptha28.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, false);


                } else {
                    bi.fldgrptha08.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, true);
                    bi.fldgrptha09.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, true);
                    bi.fldgrptha10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, true);
                    bi.fldgrptha11.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, true);
                    bi.fldgrptha12.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, true);
                    bi.fldgrptha13.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, true);
                    bi.fldgrptha14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, true);
                    bi.fldgrptha15.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, true);
                    bi.fldgrptha16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, true);
                    bi.fldgrptha17.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, true);
                    bi.fldgrptha18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, true);
                    bi.fldgrptha19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, true);
                    bi.fldgrptha20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, true);
                    bi.fldgrptha21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, true);
                    bi.fldgrptha22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, true);
                    bi.fldgrptha23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, true);
                    bi.fldgrptha24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, true);
                    bi.fldgrptha25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, true);
                    bi.fldgrptha26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, true);
                    bi.fldgrptha27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, true);
                    bi.fldgrptha28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, true);
                }
            }
        });
        bi.tha07g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {

                    bi.fldgrptha08.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, false);
                    bi.fldgrptha09.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, false);
                    bi.fldgrptha10.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, false);
                    bi.fldgrptha11.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, false);
                    bi.fldgrptha12.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, false);
                    bi.fldgrptha13.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, false);
                    bi.fldgrptha14.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, false);
                    bi.fldgrptha15.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, false);
                    bi.fldgrptha16.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, false);
                    bi.fldgrptha17.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, false);
                    bi.fldgrptha18.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, false);
                    bi.fldgrptha19.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, false);
                    bi.fldgrptha20.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, false);
                    bi.fldgrptha21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, false);
                    bi.fldgrptha22.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, false);
                    bi.fldgrptha23.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, false);
                    bi.fldgrptha24.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, false);
                    bi.fldgrptha25.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, false);
                    bi.fldgrptha26.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, false);
                    bi.fldgrptha27.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, false);
                    bi.fldgrptha28.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, false);


                } else {
                    bi.fldgrptha08.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, true);
                    bi.fldgrptha09.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, true);
                    bi.fldgrptha10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, true);
                    bi.fldgrptha11.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, true);
                    bi.fldgrptha12.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, true);
                    bi.fldgrptha13.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, true);
                    bi.fldgrptha14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, true);
                    bi.fldgrptha15.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, true);
                    bi.fldgrptha16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, true);
                    bi.fldgrptha17.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, true);
                    bi.fldgrptha18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, true);
                    bi.fldgrptha19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, true);
                    bi.fldgrptha20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, true);
                    bi.fldgrptha21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, true);
                    bi.fldgrptha22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, true);
                    bi.fldgrptha23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, true);
                    bi.fldgrptha24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, true);
                    bi.fldgrptha25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, true);
                    bi.fldgrptha26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, true);
                    bi.fldgrptha27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, true);
                    bi.fldgrptha28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, true);
                }
            }
        });
        bi.tha07h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {

                    bi.fldgrptha08.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, false);
                    bi.fldgrptha09.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, false);
                    bi.fldgrptha10.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, false);
                    bi.fldgrptha11.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, false);
                    bi.fldgrptha12.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, false);
                    bi.fldgrptha13.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, false);
                    bi.fldgrptha14.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, false);
                    bi.fldgrptha15.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, false);
                    bi.fldgrptha16.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, false);
                    bi.fldgrptha17.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, false);
                    bi.fldgrptha18.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, false);
                    bi.fldgrptha19.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, false);
                    bi.fldgrptha20.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, false);
                    bi.fldgrptha21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, false);
                    bi.fldgrptha22.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, false);
                    bi.fldgrptha23.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, false);
                    bi.fldgrptha24.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, false);
                    bi.fldgrptha25.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, false);
                    bi.fldgrptha26.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, false);
                    bi.fldgrptha27.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, false);
                    bi.fldgrptha28.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, false);


                } else {
                    bi.fldgrptha08.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, true);
                    bi.fldgrptha09.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, true);
                    bi.fldgrptha10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, true);
                    bi.fldgrptha11.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, true);
                    bi.fldgrptha12.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, true);
                    bi.fldgrptha13.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, true);
                    bi.fldgrptha14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, true);
                    bi.fldgrptha15.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, true);
                    bi.fldgrptha16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, true);
                    bi.fldgrptha17.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, true);
                    bi.fldgrptha18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, true);
                    bi.fldgrptha19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, true);
                    bi.fldgrptha20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, true);
                    bi.fldgrptha21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, true);
                    bi.fldgrptha22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, true);
                    bi.fldgrptha23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, true);
                    bi.fldgrptha24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, true);
                    bi.fldgrptha25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, true);
                    bi.fldgrptha26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, true);
                    bi.fldgrptha27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, true);
                    bi.fldgrptha28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, true);
                }
            }
        });
        bi.tha0796.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {

                    bi.tha0796x.setVisibility(View.VISIBLE);
                    bi.fldgrptha08.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, false);
                    bi.fldgrptha09.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, false);
                    bi.fldgrptha10.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, false);
                    bi.fldgrptha11.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, false);
                    bi.fldgrptha12.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, false);
                    bi.fldgrptha13.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, false);
                    bi.fldgrptha14.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, false);
                    bi.fldgrptha15.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, false);
                    bi.fldgrptha16.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, false);
                    bi.fldgrptha17.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, false);
                    bi.fldgrptha18.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, false);
                    bi.fldgrptha19.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, false);
                    bi.fldgrptha20.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, false);
                    bi.fldgrptha21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, false);
                    bi.fldgrptha22.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, false);
                    bi.fldgrptha23.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, false);
                    bi.fldgrptha24.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, false);
                    bi.fldgrptha25.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, false);
                    bi.fldgrptha26.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, false);
                    bi.fldgrptha27.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, false);
                    bi.fldgrptha28.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, false);


                } else {
                    bi.tha0796x.setText(null);
                    bi.tha0796x.setVisibility(View.GONE);
                    bi.fldgrptha08.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, true);
                    bi.fldgrptha09.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, true);
                    bi.fldgrptha10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, true);
                    bi.fldgrptha11.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, true);
                    bi.fldgrptha12.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, true);
                    bi.fldgrptha13.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, true);
                    bi.fldgrptha14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, true);
                    bi.fldgrptha15.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, true);
                    bi.fldgrptha16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, true);
                    bi.fldgrptha17.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, true);
                    bi.fldgrptha18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, true);
                    bi.fldgrptha19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, true);
                    bi.fldgrptha20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, true);
                    bi.fldgrptha21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, true);
                    bi.fldgrptha22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, true);
                    bi.fldgrptha23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha23, true);
                    bi.fldgrptha24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha24, true);
                    bi.fldgrptha25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha25, true);
                    bi.fldgrptha26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha26, true);
                    bi.fldgrptha27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha27, true);
                    bi.fldgrptha28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha28, true);
                }
            }
        });

        bi.tha13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tha13b) {

                    bi.fldgrptha14.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, false);
                    bi.fldgrptha15.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, false);
                    bi.fldgrptha16.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, false);
                    bi.fldgrptha17.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, false);
                    bi.fldgrptha18.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, false);
                    bi.fldgrptha19.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, false);
                    bi.fldgrptha20.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, false);
                    bi.fldgrptha21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, false);
                    bi.fldgrptha22.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, false);

                } else {
                    bi.fldgrptha14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, true);
                    bi.fldgrptha15.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, true);
                    bi.fldgrptha16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha16, true);
                    bi.fldgrptha17.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha17, true);
                    bi.fldgrptha18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, true);
                    bi.fldgrptha19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, true);
                    bi.fldgrptha20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, true);
                    bi.fldgrptha21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, true);
                    bi.fldgrptha22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, true);
                }
            }
        });

        bi.tha17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tha17a) {

                    bi.tha17hr.setVisibility(View.VISIBLE);
                } else {
                    bi.tha17hr.setText(null);
                    bi.tha17hr.setVisibility(View.GONE);
                }

                if (i == R.id.tha17b) {
                    bi.tha17d.setVisibility(View.VISIBLE);
                } else {
                    bi.tha17d.setText(null);
                    bi.tha17d.setVisibility(View.GONE);
                }

                if (i == R.id.tha17c) {

                    bi.tha17hr.setVisibility(View.GONE);
                    bi.tha17d.setVisibility(View.GONE);
                    bi.tha17d.setText(null);
                    bi.tha17hr.setText(null);
                    bi.fldgrptha18.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, false);
                    bi.fldgrptha19.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, false);
                    bi.fldgrptha20.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, false);
                    bi.fldgrptha21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, false);
                    bi.fldgrptha22.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, false);
                } else {
                    bi.fldgrptha18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha18, true);
                    bi.fldgrptha19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, true);
                    bi.fldgrptha20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, true);
                    bi.fldgrptha21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, true);
                    bi.fldgrptha22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, true);
                }

            }
        });

        bi.tha18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tha18b) {
                    bi.fldgrptha19.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, false);
                    bi.fldgrptha20.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, false);
                    bi.fldgrptha21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, false);
                    bi.fldgrptha22.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, false);
                } else {
                    bi.fldgrptha19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, true);
                    bi.fldgrptha20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, true);
                    bi.fldgrptha21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, true);
                    bi.fldgrptha22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, true);
                }
            }
        });

        bi.tha20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tha20a) {
                    bi.fldgrptha21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, false);
                    bi.fldgrptha22.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, false);

                } else {
                    bi.fldgrptha21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, true);
                    bi.fldgrptha22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha22, true);
                }
            }
        });

        bi.tha29.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tha29b) {
                    bi.fldgrptha30.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha30, false);
                    bi.fldgrptha31.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha31, false);

                } else {
                    bi.fldgrptha30.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha30, true);
                    bi.fldgrptha31.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha31, true);
                }
            }
        });

        bi.tha30.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tha30b) {
                    bi.fldgrptha31.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha31, false);
                } else {
                    bi.fldgrptha31.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha31, true);
                }
            }
        });
//
//
//        tha01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//                if (tha01a.isChecked()) {
//                    fldGrptha02.setVisibility(View.VISIBLE);
//                    fldGrptha25.setVisibility(View.VISIBLE);
//                } else {
//
//                    tha02.setText(null);
////                    tha03.getChildAt(0).toString();
//                    tha04.setText(null);
//
//                    tha05.clearCheck();
//                    tha06.clearCheck();
//
//                    tha07a.setChecked(false);
//                    tha07b.setChecked(false);
//                    tha07c.setChecked(false);
//                    tha07d.setChecked(false);
//                    tha07e.setChecked(false);
//                    tha07f.setChecked(false);
//                    tha07g.setChecked(false);
//                    tha07h.setChecked(false);
//                    tha0788.setChecked(false);
//
//                    tha08.setText(null);
//
//                    tha09a.setChecked(false);
//                    tha09b.setChecked(false);
//                    tha09c.setChecked(false);
//                    tha09d.setChecked(false);
//
//                    tha10.clearCheck();
//
//                    tha11a.setChecked(false);
//                    tha11b.setChecked(false);
//                    tha11c.setChecked(false);
//                    tha11d.setChecked(false);
//                    tha11e.setChecked(false);
//                    tha11f.setChecked(false);
//                    tha11g.setChecked(false);
//                    tha11h.setChecked(false);
//                    tha11i.setChecked(false);
//                    tha11j.setChecked(false);
//
//                    tha12.clearCheck();
//                    tha13.clearCheck();
//                    tha14.clearCheck();
//                    tha15.clearCheck();
//                    tha16.clearCheck();
//
//                    tha1688x.setText(null);
//
//                    tha17.clearCheck();
//                    tha18.clearCheck();
//
//                    tha19a.setChecked(false);
//                    tha19b.setChecked(false);
//                    tha19c.setChecked(false);
//                    tha19d.setChecked(false);
//                    tha19e.setChecked(false);
//                    tha19f.setChecked(false);
//                    tha19g.setChecked(false);
//                    tha19h.setChecked(false);
//                    tha19i.setChecked(false);
//
//
//                    tha20.clearCheck();
//
//                    tha20hr.setText(null);
//                    tha20d.setText(null);
//
//                    tha21.clearCheck();
//
//                    tha22.setText(null);
//                    tha23.clearCheck();
//
//                    tha24a.setChecked(false);
//                    tha24b.setChecked(false);
//                    tha24c.setChecked(false);
//                    tha24d.setChecked(false);
//                    tha24e.setChecked(false);
//                    tha24f.setChecked(false);
//                    tha24g.setChecked(false);
//
//                    tha25.clearCheck();
//
//                    tha26.setText(null);
//
//                    tha27a.setChecked(false);
//                    tha27b.setChecked(false);
//                    tha27c.setChecked(false);
//                    tha27d.setChecked(false);
//                    tha27e.setChecked(false);
//                    tha27f.setChecked(false);
//                    tha27g.setChecked(false);
//                    tha27h.setChecked(false);
//                    tha2788.setChecked(false);
//
//                    tha2788x.setText(null);
//
//                    tha28.setText(null);
//                    tha29.setText(null);
//                    tha30.setText(null);
//
//                    tha31.clearCheck();
//                    //tha32.clearCheck();
//
//
//                    fldGrptha02.setVisibility(View.GONE);
//                    fldGrptha14a.setVisibility(View.GONE);
//                    fldGrptha25.setVisibility(View.GONE);
//                    fldGrptha32.setVisibility(View.GONE);
//                    fldGrptha34.setVisibility(View.GONE);
//                }
//            }
//        });
//
//
//        tha06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//                if (tha06a.isChecked()) {
//
//                    tha07a.setChecked(false);
//                    tha07b.setChecked(false);
//                    tha07c.setChecked(false);
//                    tha07d.setChecked(false);
//                    tha07e.setChecked(false);
//                    tha07f.setChecked(false);
//                    tha07g.setChecked(false);
//                    tha07h.setChecked(false);
//                    tha0788.setChecked(false);
//                    tha0788x.setText(null);
//
//                    fldGrptha07.setVisibility(View.GONE);
//                    tha0788x.setVisibility(View.GONE);
//
//                    fldGrptha08.setVisibility(View.VISIBLE);
//
//                } else {
//
//                    fldGrptha07.setVisibility(View.VISIBLE);
//
//                    fldGrptha08.setVisibility(View.GONE);
//
//                    tha08.setText(null);
//                    tha09.clearCheck();
//                    tha10.clearCheck();
//                    tha11a.setChecked(false);
//                    tha11b.setChecked(false);
//                    tha11c.setChecked(false);
//                    tha11d.setChecked(false);
//                    tha11e.setChecked(false);
//                    tha11f.setChecked(false);
//                    tha11g.setChecked(false);
//                    tha11h.setChecked(false);
//                    tha11i.setChecked(false);
//                    tha11j.setChecked(false);
//
//                    tha12.clearCheck();
//                    tha13.clearCheck();
//                    tha14.clearCheck();
//                    tha15.clearCheck();
//                    tha16.clearCheck();
//                    tha17.clearCheck();
//                    tha18.clearCheck();
//
//                    tha19a.setChecked(false);
//                    tha19b.setChecked(false);
//                    tha19c.setChecked(false);
//                    tha19d.setChecked(false);
//                    tha19e.setChecked(false);
//                    tha19f.setChecked(false);
//                    tha19g.setChecked(false);
//                    tha19h.setChecked(false);
//                    tha19i.setChecked(false);
//
//                    tha20.clearCheck();
//                    tha20hr.setText(null);
//                    tha20d.setText(null);
//
//                    tha21.clearCheck();
//                    tha22.setText(null);
//
//                    tha23.clearCheck();
//                    tha24a.setChecked(false);
//                    tha24b.setChecked(false);
//                    tha24c.setChecked(false);
//                    tha24d.setChecked(false);
//                    tha24e.setChecked(false);
//                    tha24f.setChecked(false);
//                    tha24g.setChecked(false);
//
////                    tha25.clearCheck();
//                    tha26.setText(null);
//                    tha26888.setChecked(false);
//
//                    tha27.clearCheck();
//
//                    tha28.setText(null);
//                    tha28888.setChecked(false);
//                    tha29.setText(null);
//                    tha29888.setChecked(false);
//                    tha30.setText(null);
//                    tha30888.setChecked(false);
//
//                    tha31.clearCheck();
//
//                    tha07a.requestFocus();
//                }
//            }
//        });
//
//
//        tha0788.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (tha0788.isChecked()) {
//                    tha0788x.setVisibility(View.VISIBLE);
//                    tha0788x.requestFocus();
//                } else {
//                    tha0788x.setText(null);
//                    tha0788x.setVisibility(View.GONE);
//                }
//            }
//        });
//
//        tha09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                if (i == R.id.tha09a && tha13b.isChecked()) {
//                    clearFldGrptha14();
//                    fldGrptha14.setVisibility(View.GONE);
//                    fldGrptha30.setVisibility(View.VISIBLE);
//                } else if (tha13b.isChecked()) {
//                    clearFldGrptha14a();
//                    fldGrptha14.setVisibility(View.VISIBLE);
//                    fldGrptha14a.setVisibility(View.GONE);
//                    fldGrptha30.setVisibility(View.VISIBLE);
//                } else {
//                    fldGrptha14.setVisibility(View.VISIBLE);
//                    fldGrptha14a.setVisibility(View.VISIBLE);
//                    fldGrptha30.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//
//        tha13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//                if (i == R.id.tha13b && tha09a.isChecked()) {
//
//                    clearFldGrptha14();
//
//                    fldGrptha14.setVisibility(View.GONE);
//                    fldGrptha30.setVisibility(View.VISIBLE);
//
//                } else if (i == R.id.tha13b) {
//                    clearFldGrptha14a();
//                    fldGrptha14.setVisibility(View.VISIBLE);
//                    fldGrptha14a.setVisibility(View.VISIBLE);
//                    fldGrptha30.setVisibility(View.VISIBLE);
//                } else {
//                    fldGrptha14.setVisibility(View.VISIBLE);
//                    fldGrptha14a.setVisibility(View.VISIBLE);
//                    fldGrptha30.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//
//        tha15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//                if (tha15b.isChecked()) {
//                    tha16.clearCheck();
//                    tha1688x.setText(null);
//                    tha17.clearCheck();
//                    fldGrptha15.setVisibility(View.GONE);
//                } else {
//                    fldGrptha15.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//
//
//        tha1688.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (tha1688.isChecked()) {
//                    tha1688x.setVisibility(View.VISIBLE);
//                    tha1688x.requestFocus();
//                } else {
//                    tha1688x.setText(null);
//                    tha1688x.setVisibility(View.GONE);
//                }
//            }
//        });
//
//
//        tha20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//                if (tha20a.isChecked()) {
//
//                    tha20d.setText(null);
//                    tha20d.setVisibility(View.GONE);
//
//                    /*tha21.clearCheck();
//                    tha22.setText(null);
//
//                    tha23.clearCheck();*/
//
//
//                    /*tha24a.setChecked(false);
//                    tha24b.setChecked(false);
//                    tha24c.setChecked(false);
//                    tha24d.setChecked(false);
//                    tha24e.setChecked(false);
//                    tha24f.setChecked(false);
//                    tha24g.setChecked(false);
//
//                    tha25.clearCheck();*/
//
//                    fldGrptha21.setVisibility(View.VISIBLE);
////                    fldGrptha25.setVisibility(View.VISIBLE);
//
//                    tha20hr.setVisibility(View.VISIBLE);
//                    tha20hr.requestFocus();
//
//                } else if (tha20b.isChecked()) {
//
//                    tha20hr.setText(null);
//                    tha20hr.setVisibility(View.GONE);
//
//
//                    //tha21.clearCheck();
//                    //tha22.setText(null);
//
//                    //tha23.clearCheck();
//
//                    /*tha24a.setChecked(false);
//                    tha24b.setChecked(false);
//                    tha24c.setChecked(false);
//                    tha24d.setChecked(false);
//                    tha24e.setChecked(false);
//                    tha24f.setChecked(false);
//                    tha24g.setChecked(false);*/
//
//                    //tha25.clearCheck();
//
//
//                    fldGrptha21.setVisibility(View.VISIBLE);
////                    fldGrptha25.setVisibility(View.VISIBLE);
//
//                    tha20d.setVisibility(View.VISIBLE);
//                    tha20d.requestFocus();
//
//                } else if (tha20c.isChecked()) {
//
//                    tha21.clearCheck();
//                    tha22.setText(null);
//
//                    tha23.clearCheck();
//
//
//                    tha24a.setChecked(false);
//                    tha24b.setChecked(false);
//                    tha24c.setChecked(false);
//                    tha24d.setChecked(false);
//                    tha24e.setChecked(false);
//                    tha24f.setChecked(false);
//                    tha24g.setChecked(false);
//
////                    tha25.clearCheck();
//
//
//                    tha20hr.setVisibility(View.GONE);
//                    tha20d.setVisibility(View.GONE);
//
//                    tha20hr.setText(null);
//                    tha20d.setText(null);
//
//                    fldGrptha21.setVisibility(View.GONE);
////                    fldGrptha25.setVisibility(View.GONE);
//                }
//            }
//        });
//
//
//        tha21.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//                if (tha21b.isChecked()) {
//
//                    tha22.setText(null);
//                    tha23.clearCheck();
//
//                    tha24a.setChecked(false);
//                    tha24b.setChecked(false);
//                    tha24c.setChecked(false);
//                    tha24d.setChecked(false);
//                    tha24e.setChecked(false);
//                    tha24f.setChecked(false);
//                    tha24g.setChecked(false);
//
//                    fldGrptha22.setVisibility(View.GONE);
//
//                } else {
//                    fldGrptha22.setVisibility(View.VISIBLE);
//                    tha22.requestFocus();
//                }
//            }
//        });
//
//
//        tha23.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//                if (tha23a.isChecked()) {
//
//                    tha24a.setChecked(false);
//                    tha24b.setChecked(false);
//                    tha24c.setChecked(false);
//                    tha24d.setChecked(false);
//                    tha24e.setChecked(false);
//                    tha24f.setChecked(false);
//                    tha24g.setChecked(false);
//
//                    fldGrptha23.setVisibility(View.GONE);
//
//                } else {
//                    fldGrptha23.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//
//
//        tha26888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (tha26888.isChecked()) {
//                    tha26.setText(null);
//                    tha26.setVisibility(View.GONE);
//                } else {
//                    tha26.setVisibility(View.VISIBLE);
//                    tha26.requestFocus();
//                }
//            }
//        });
//
//
//        tha2788.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
//
//        {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (tha2788.isChecked()) {
//                    tha2788x.setVisibility(View.VISIBLE);
//                    tha2788x.requestFocus();
//                } else {
//                    tha2788x.setText(null);
//                    tha2788x.setVisibility(View.GONE);
//                }
//            }
//        });
//
//
//        tha28888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (tha28888.isChecked()) {
//                    tha28.setText(null);
//                    tha28.setVisibility(View.GONE);
//                } else {
//                    tha28.setVisibility(View.VISIBLE);
//                    tha28.requestFocus();
//                }
//            }
//        });
//
//        tha29888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (tha29888.isChecked()) {
//                    tha29.setText(null);
//                    tha29.setVisibility(View.GONE);
//                } else {
//                    tha29.setVisibility(View.VISIBLE);
//                    tha29.requestFocus();
//                }
//            }
//        });
//
//
//        tha30888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (tha30888.isChecked()) {
//                    tha30.setText(null);
//                    tha30.setVisibility(View.GONE);
//                } else {
//                    tha30.setVisibility(View.VISIBLE);
//                    tha30.requestFocus();
//                }
//            }
//        });
//
//
//        tha32.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
//
//        {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//                if (tha32b.isChecked()) {
//
//                    tha33.clearCheck();
//                    tha34.clearCheck();
//
//                    fldGrptha32.setVisibility(View.GONE);
//
//                } else {
//                    fldGrptha32.setVisibility(View.VISIBLE);
//                    fldGrptha34.setVisibility(View.GONE);
//                }
//            }
//        });
//
//        tha33.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
//
//        {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//                if (tha33b.isChecked()) {
//                    tha34.clearCheck();
//                    fldGrptha34.setVisibility(View.GONE);
//                } else {
//                    fldGrptha34.setVisibility(View.VISIBLE);
//                }
//            }
//        });


    }


    public void BtnContinue() {
        if (formValidation()) {
            Toast.makeText(this, "validated", Toast.LENGTH_SHORT).show();
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }

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

    private void SaveDraft() throws JSONException {

        JSONObject sHA = new JSONObject();

        sHA.put("tha01", bi.tha01a.isChecked() ? "1" : bi.tha01b.isChecked() ? "2" : bi.tha01888.isChecked() ? "98" : "0");
        sHA.put("tha02", bi.tha02.getText().toString());
        sHA.put("tha03", bi.tha03.getSelectedItem().toString());
        sHA.put("tha04", bi.tha04.getText().toString());
        sHA.put("tha05", bi.tha05a.isChecked() ? "1" : bi.tha05b.isChecked() ? "2" : bi.tha05888.isChecked() ? "98" : "0");
        sHA.put("tha06", bi.tha06a.isChecked() ? "1" : bi.tha06b.isChecked() ? "2" : bi.tha06888.isChecked() ? "98" : "0");
        sHA.put("tha07a", bi.tha07a.isChecked() ? "1" : "0");
        sHA.put("tha07b", bi.tha07b.isChecked() ? "2" : "0");
        sHA.put("tha07c", bi.tha07c.isChecked() ? "3" : "0");
        sHA.put("tha07d", bi.tha07d.isChecked() ? "4" : "0");
        sHA.put("tha07e", bi.tha07e.isChecked() ? "5" : "0");
        sHA.put("tha07f", bi.tha07f.isChecked() ? "6" : "0");
        sHA.put("tha07g", bi.tha07g.isChecked() ? "7" : "0");
        sHA.put("tha07h", bi.tha07h.isChecked() ? "8" : "0");
        sHA.put("tha07a", bi.tha07a.isChecked() ? "9" : "0");
        sHA.put("tha0796", bi.tha0796.isChecked() ? "96" : "0");
        sHA.put("tha0796x", bi.tha0796x.getText().toString());
        sHA.put("tha08", bi.tha08.getText().toString());

        sHA.put("tha09",
                bi.tha09a.isChecked() ? "1"
                        : bi.tha09b.isChecked() ? "2"
                        : bi.tha09c.isChecked() ? "3"
                        : bi.tha09d.isChecked() ? "4"
                        : bi.tha0996.isChecked() ? "96" : "0");
        sHA.put("tha0996x", bi.tha0996x.getText().toString());
        sHA.put("tha10", bi.tha10a.isChecked() ? "1"
                : bi.tha10b.isChecked() ? "2"
                : bi.tha10c.isChecked() ? "3"
                : bi.tha10d.isChecked() ? "4"
                : bi.tha10e.isChecked() ? "5"
                : bi.tha10f.isChecked() ? "6"
                : bi.tha10g.isChecked() ? "7"
                : bi.tha10h.isChecked() ? "8"
                : bi.tha10i.isChecked() ? "9"
                : bi.tha1096.isChecked() ? "96"
                : "0");
        sHA.put("tha1096x", bi.tha1096x.getText().toString());

        sHA.put("tha11", bi.tha10a.isChecked() ? "1"
                : bi.tha11b.isChecked() ? "2"
                : bi.tha11c.isChecked() ? "3"
                : bi.tha11d.isChecked() ? "4"
                : bi.tha11e.isChecked() ? "5"
                : bi.tha11f.isChecked() ? "6"
                : bi.tha11g.isChecked() ? "7"
                : bi.tha11h.isChecked() ? "8"
                : bi.tha11i.isChecked() ? "9"
                : bi.tha11j.isChecked() ? "10"
                : bi.tha11k.isChecked() ? "11"
                : bi.tha11l.isChecked() ? "96"
                : "0");
        sHA.put("tha1196x", bi.tha1196x.getText().toString());
        sHA.put("tha12a", bi.tha12a.isChecked() ? "1" : "0");
        sHA.put("tha12b", bi.tha12b.isChecked() ? "2" : "0");
        sHA.put("tha12c", bi.tha12c.isChecked() ? "3" : "0");
        sHA.put("tha12d", bi.tha12d.isChecked() ? "4" : "0");
        sHA.put("tha12e", bi.tha12e.isChecked() ? "5" : "0");
        sHA.put("tha12f", bi.tha12f.isChecked() ? "6" : "0");
        sHA.put("tha12g", bi.tha12g.isChecked() ? "7" : "0");
        sHA.put("tha12h", bi.tha12h.isChecked() ? "8" : "0");
        sHA.put("tha12i", bi.tha12i.isChecked() ? "9" : "0");
        sHA.put("tha12j", bi.tha12j.isChecked() ? "10" : "0");

        sHA.put("tha13", bi.tha13a.isChecked() ? "1" : bi.tha13b.isChecked() ? "2" : "0");
        sHA.put("tha14", bi.tha14a.isChecked() ? "1"
                : bi.tha14b.isChecked() ? "2"
                : bi.tha14c.isChecked() ? "3"
                : bi.tha1496.isChecked() ? "96" : "0");
        sHA.put("tha1496x", bi.tha1496x.getText().toString());

        sHA.put("tha15", bi.tha15a.isChecked() ? "1"
                : bi.tha15b.isChecked() ? "2"
                : bi.tha15c.isChecked() ? "3"
                : bi.tha15d.isChecked() ? "4"
                : bi.tha15e.isChecked() ? "5"
                : bi.tha1596.isChecked() ? "96" : "0");
        sHA.put("tha1596x", bi.tha1596x.getText().toString());

        sHA.put("tha16a", bi.tha16a.isChecked() ? "1" : "0");
        sHA.put("tha16b", bi.tha16b.isChecked() ? "2" : "0");
        sHA.put("tha16c", bi.tha16c.isChecked() ? "3" : "0");
        sHA.put("tha16d", bi.tha16d.isChecked() ? "4" : "0");
        sHA.put("tha16e", bi.tha16e.isChecked() ? "5" : "0");
        sHA.put("tha16f", bi.tha16f.isChecked() ? "6" : "0");
        sHA.put("tha16g", bi.tha16g.isChecked() ? "7" : "0");
        sHA.put("tha16h", bi.tha16h.isChecked() ? "8" : "0");

        sHA.put("tha17", bi.tha17a.isChecked() ? "1"
                : bi.tha17b.isChecked() ? "2"
                : bi.tha17c.isChecked() ? "3" : "0");
        sHA.put("tha17hr", bi.tha17hr.getText().toString());
        sHA.put("tha17d", bi.tha17d.getText().toString());

        sHA.put("tha18", bi.tha18a.isChecked() ? "1" : bi.tha18b.isChecked() ? "2" : "0");
        sHA.put("tha19", bi.tha19.getText().toString());
        sHA.put("tha20", bi.tha20a.isChecked() ? "1" : bi.tha20b.isChecked() ? "2" : "0");

        sHA.put("tha21a", bi.tha21a.isChecked() ? "1" : "0");
        sHA.put("tha21b", bi.tha21b.isChecked() ? "2" : "0");
        sHA.put("tha21c", bi.tha21c.isChecked() ? "3" : "0");
        sHA.put("tha21d", bi.tha21d.isChecked() ? "4" : "0");
        sHA.put("tha21e", bi.tha21e.isChecked() ? "5" : "0");
        sHA.put("tha21f", bi.tha21f.isChecked() ? "6" : "0");
        sHA.put("tha21g", bi.tha21g.isChecked() ? "7" : "0");

        sHA.put("tha22", bi.tha22a.isChecked() ? "1"
                : bi.tha22b.isChecked() ? "2"
                : bi.tha22c.isChecked() ? "3"
                : "0");

        sHA.put("tha23", bi.tha2398.isChecked() ? "98" : "0");
        sHA.put("tha23km", bi.tha23.getText().toString());
        sHA.put("tha24", bi.tha24a.isChecked() ? "1"
                : bi.tha24b.isChecked() ? "2"
                : bi.tha24c.isChecked() ? "3"
                : bi.tha24d.isChecked() ? "4"
                : bi.tha24e.isChecked() ? "5"
                : bi.tha24f.isChecked() ? "6"
                : bi.tha24g.isChecked() ? "7"
                : bi.tha24h.isChecked() ? "8"
                : bi.tha2496.isChecked() ? "96"
                : "0");
        sHA.put("tha2496x", bi.tha2496x.getText().toString());
        sHA.put("tha25", bi.tha2598.isChecked() ? "98" : "0");
        sHA.put("tha25m", bi.tha25.getText().toString());

        sHA.put("tha26", bi.tha2698.isChecked() ? "98" : "0");
        sHA.put("tha26r", bi.tha26.getText().toString());

        sHA.put("tha27", bi.tha2798.isChecked() ? "98" : "0");
        sHA.put("tha27r", bi.tha27.getText().toString());

        sHA.put("tha28", bi.tha28a.isChecked() ? "1"
                : bi.tha28b.isChecked() ? "2"
                : bi.tha28c.isChecked() ? "3"
                : "0");
        sHA.put("tha29", bi.tha29a.isChecked() ? "1"
                : bi.tha29b.isChecked() ? "2" : "0");
        sHA.put("tha30", bi.tha30a.isChecked() ? "1"
                : bi.tha30b.isChecked() ? "2" : "0");

        sHA.put("tha31", bi.tha31a.isChecked() ? "1"
                : bi.tha31b.isChecked() ? "2"
                : bi.tha31c.isChecked() ? "3"
                : bi.tha31d.isChecked() ? "4"
                : bi.tha31e.isChecked() ? "5"
                : bi.tha31f.isChecked() ? "6"
                : bi.tha31g.isChecked() ? "7"
                : bi.tha31h.isChecked() ? "8"
                : bi.tha31i.isChecked() ? "9"
                : bi.tha31j.isChecked() ? "10"
                : bi.tha31k.isChecked() ? "11"
                : bi.tha3196.isChecked() ? "96"
                : "0");
        sHA.put("tha3196x", bi.tha3196x.getText().toString());


    }


    public void onBtnEndClick() {

        Toast.makeText(this, "Not Processing This Section", Toast.LENGTH_SHORT).show();

        Toast.makeText(this, "Starting Form Ending Section", Toast.LENGTH_SHORT).show();

        MainApp.endActivity(this, this);
    }


    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSHA();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private boolean formValidation() {
        if (!validatorClass.EmptyRadioButton(this, bi.tha01, bi.tha01a, getString(R.string.tha01))) {
            return false;
        }

        if (bi.tha01a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.tha02, getString(R.string.tha02))) {
                return false;
            }
            if (!validatorClass.EmptySpinner(this, bi.tha03, getString(R.string.tha03))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.tha04, getString(R.string.tha04))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.tha05, bi.tha05a, getString(R.string.tha05))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.tha06, bi.tha06a, getString(R.string.tha06))) {
                return false;
            }

            if (!bi.tha06a.isChecked()) {
                if (!validatorClass.EmptyCheckBox(this, bi.fldgrptha07, bi.tha07a, getString(R.string.tha07))) {
                    return false;
                }
                if (bi.tha0796.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.tha0796x, getString(R.string.tha07))) {
                        return false;
                    }
                }
                if (!validatorClass.EmptyRadioButton(this, bi.tha29, bi.tha29a, getString(R.string.tha29))) {
                    return false;
                }

                if (bi.tha29a.isChecked()) {
                    if (!validatorClass.EmptyRadioButton(this, bi.tha30, bi.tha30a, getString(R.string.tha30))) {
                        return false;
                    }

                    if (bi.tha30a.isChecked()) {
                        if (!validatorClass.EmptyRadioButton(this, bi.tha31, bi.tha31a, getString(R.string.tha31))) {
                            return false;
                        }

                    }
                }

            } else {
                if (!validatorClass.EmptyTextBox(this, bi.tha08, getString(R.string.tha08))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.tha09, bi.tha09a, getString(R.string.tha09))) {
                    return false;
                }

                if (bi.tha0996.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.tha0996x, getString(R.string.tha09))) {
                        return false;
                    }
                }

                if (!validatorClass.EmptyRadioButton(this, bi.tha10, bi.tha10a, getString(R.string.tha10))) {
                    return false;
                }
                if (bi.tha1096.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.tha1096x, getString(R.string.tha10))) {
                        return false;

                    }
                    if (!validatorClass.EmptyRadioButton(this, bi.tha11, bi.tha11a, getString(R.string.tha11))) {
                        return false;
                    }
                    if (bi.tha11l.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.tha1196x, getString(R.string.tha11))) {
                            return false;
                        }
                    }
                    if (!validatorClass.EmptyCheckBox(this, bi.fldgrptha12, bi.tha12a, getString(R.string.tha12))) {
                        return false;
                    }
                    if (!validatorClass.EmptyRadioButton(this, bi.tha13, bi.tha13a, getString(R.string.tha13))) {
                        return false;
                    }
                    if (!bi.tha13b.isChecked()) {
                        if (!validatorClass.EmptyRadioButton(this, bi.tha14, bi.tha14a, getString(R.string.tha14))) {
                            return false;
                        }
                        if (bi.tha1496.isChecked()) {
                            if (!validatorClass.EmptyTextBox(this, bi.tha1496x, getString(R.string.tha14))) {
                                return false;
                            }
                        }
                        if (!validatorClass.EmptyRadioButton(this, bi.tha15, bi.tha15a, getString(R.string.tha15))) {
                            return false;
                        }
                        if (bi.tha1596.isChecked()) {
                            if (!validatorClass.EmptyTextBox(this, bi.tha1596x, getString(R.string.tha15))) {
                                return false;
                            }
                        }
                        if (!validatorClass.EmptyCheckBox(this, bi.fldgrptha16, bi.tha16a, getString(R.string.tha16))) {
                            return false;
                        }
                        if (!validatorClass.EmptyRadioButton(this, bi.tha17, bi.tha17a, getString(R.string.tha17))) {
                            return false;
                        }
                        if (bi.tha17a.isChecked()) {
                            if (!validatorClass.EmptyTextBox(this, bi.tha17hr, getString(R.string.tha17))) {
                                return false;
                            }
                        }
                        if (bi.tha17b.isChecked()) {
                            if (!validatorClass.EmptyTextBox(this, bi.tha17d, getString(R.string.tha17))) {
                                return false;
                            }
                        }
                        if (!bi.tha17c.isChecked()) {
                            if (!validatorClass.EmptyRadioButton(this, bi.tha18, bi.tha18a, getString(R.string.tha18))) {
                                return false;
                            }
                            if (!bi.tha18b.isChecked()) {
                                if (!validatorClass.EmptyTextBox(this, bi.tha19, getString(R.string.tha19))) {
                                    return false;
                                }
                                if (!validatorClass.EmptyRadioButton(this, bi.tha20, bi.tha20a, getString(R.string.tha20))) {
                                    return false;
                                }
                                if (!bi.tha20a.isChecked()) {
                                    if (!validatorClass.EmptyCheckBox(this, bi.fldgrptha21, bi.tha21a, getString(R.string.tha21))) {
                                        return false;
                                    }
                                    if (!validatorClass.EmptyRadioButton(this, bi.tha22, bi.tha22a, getString(R.string.tha22))) {
                                        return false;
                                    }
                                }
                            }

                        } else {
                            if (!bi.tha2398.isChecked()) {
                                if (!validatorClass.EmptyTextBox(this, bi.tha23, getString(R.string.tha23))) {
                                    return false;
                                }
                            }
                            if (!validatorClass.EmptyRadioButton(this, bi.tha24, bi.tha24a, getString(R.string.tha24))) {
                                return false;
                            }
                            if (bi.tha2496.isChecked()) {
                                if (!validatorClass.EmptyTextBox(this, bi.tha2496x, getString(R.string.tha24))) {
                                    return false;
                                }
                            }
                            if (!bi.tha2598.isChecked()) {
                                if (!validatorClass.EmptyTextBox(this, bi.tha25, getString(R.string.tha25))) {
                                    return false;
                                }
                            }
                            if (!bi.tha2698.isChecked()) {
                                if (!validatorClass.EmptyTextBox(this, bi.tha26, getString(R.string.tha26))) {
                                    return false;
                                }
                            }
                            if (!bi.tha2798.isChecked()) {
                                if (!validatorClass.EmptyTextBox(this, bi.tha27, getString(R.string.tha27))) {
                                    return false;
                                }
                            }
                            if (!validatorClass.EmptyRadioButton(this, bi.tha28, bi.tha28a, getString(R.string.tha28))) {
                                return false;
                            }
                        }

                    } else {

                        if (!bi.tha2398.isChecked()) {
                            if (!validatorClass.EmptyTextBox(this, bi.tha23, getString(R.string.tha23))) {
                                return false;
                            }
                        }
                        if (!validatorClass.EmptyRadioButton(this, bi.tha24, bi.tha24a, getString(R.string.tha24))) {
                            return false;
                        }
                        if (bi.tha2496.isChecked()) {
                            if (!validatorClass.EmptyTextBox(this, bi.tha2496x, getString(R.string.tha24))) {
                                return false;
                            }
                        }
                        if (!bi.tha2598.isChecked()) {
                            if (!validatorClass.EmptyTextBox(this, bi.tha25, getString(R.string.tha25))) {
                                return false;
                            }
                        }
                        if (!bi.tha2698.isChecked()) {
                            if (!validatorClass.EmptyTextBox(this, bi.tha26, getString(R.string.tha26))) {
                                return false;
                            }
                        }
                        if (!bi.tha2798.isChecked()) {
                            if (!validatorClass.EmptyTextBox(this, bi.tha27, getString(R.string.tha27))) {
                                return false;
                            }
                        }
                        if (!validatorClass.EmptyRadioButton(this, bi.tha28, bi.tha28a, getString(R.string.tha28))) {
                            return false;
                        }

                    }

                }
            }
            if (!validatorClass.EmptyRadioButton(this, bi.tha29, bi.tha29a, getString(R.string.tha29))) {
                return false;
            }
            if (bi.tha29a.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.tha30, bi.tha30a, getString(R.string.tha30))) {
                    return false;
                }
                if (bi.tha30a.isChecked()) {
                    if (!validatorClass.EmptyRadioButton(this, bi.tha31, bi.tha31a, getString(R.string.tha31))) {
                        return false;
                    }
                    if (bi.tha3196.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.tha3196x, getString(R.string.tha31))) {
                            return false;
                        }
                    }
                }
            }

//
//        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();
//
//        //        00
//        if (tha00.getCheckedRadioButtonId() == -1) {
//            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tiRespondentMother), Toast.LENGTH_SHORT).show();
//            tha00a.setError("This data is Required!");    // Set Error on last radio button
//            Log.i(TAG, "tha00: This data is Required!");
//            tha00a.setFocusable(true);
//            tha00a.setFocusableInTouchMode(true);
//            tha00a.requestFocus();
//            return false;
//        } else {
//            tha00a.setError(null);
//        }
//
//
//        //        01
//        if (tha01.getCheckedRadioButtonId() == -1) {
//            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha01), Toast.LENGTH_SHORT).show();
//            tha01a.setError("This data is Required!");    // Set Error on last radio button
//            Log.i(TAG, "tha01: This data is Required!");
//            tha01a.setFocusable(true);
//            tha01a.setFocusableInTouchMode(true);
//            tha01a.requestFocus();
//            return false;
//        } else {
//            tha01a.setError(null);
//        }
//
//
//        if (tha01a.isChecked()) {
//
//
//            //        02
//            if (tha02.getText().toString().isEmpty()) {
//                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha02), Toast.LENGTH_SHORT).show();
//                tha02.setError("This data is Required!");    // Set Error on last radio button
//                Log.i(TAG, "tha02: This data is Required!");
//                tha02.requestFocus();
//                return false;
//            } else {
//                tha02.setError(null);
//            }
//
//            /*if (MainApp.TotalChildCount < Integer.parseInt(tha02.getText().toString())) {
//                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.tha02), Toast.LENGTH_SHORT).show();
//                tha02.setError("This data range in " + MainApp.TotalChildCount);    // Set Error on last radio button
//                Log.i(TAG, "tha02: This data range in " + MainApp.TotalChildCount);
//                tha02.requestFocus();
//                return false;
//            } else {
//                tha02.setError(null);
//            }*/
//
//
//            if (!tha02.getText().toString().isEmpty()) {
//                if (Integer.parseInt(tha02.getText().toString()) < 0 || Integer.parseInt(tha02.getText().toString()) > 5) {
//                    Toast.makeText(this, "Number of childrens had diarrea in last two weeks must be greater than 0", Toast.LENGTH_SHORT).show();
//                    tha02.setError("Must be greater than 0");
//                    Log.i(TAG, "tha02: This data is Required!");
//                    tha02.requestFocus();
//                    return false;
//                } else {
//                    tha02.setError(null);
//                }
//            }
//
//
//            //        03
//
///*            if (tha03.getText().toString().isEmpty()) {
//                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha03), Toast.LENGTH_SHORT).show();
//                tha03.setError("This data is Required!");    // Set Error on last radio button
//                Log.i(TAG, "tha03: This data is Required!");
//                return false;
//            } else {
//                tha03.setError(null);
//            }*/
//
//            if (tha03.getSelectedItem() == "....") {
//                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.tha03), Toast.LENGTH_SHORT).show();
//                ((TextView) tha03.getSelectedView()).setText("This Data is Required");
//                ((TextView) tha03.getSelectedView()).setTextColor(Color.RED);
//                tha03.requestFocus();
//                Log.i(TAG, "tha03: This Data is Required!");
//                return false;
//            } else {
//                ((TextView) tha03.getSelectedView()).setError(null);
//            }
//
//
//            //        04
//            if (tha04.getText().toString().isEmpty()) {
//                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha04), Toast.LENGTH_SHORT).show();
//                tha04.setError("This data is Required!");    // Set Error on last radio button
//                Log.i(TAG, "tha04: This data is Required!");
//                tha04.requestFocus();
//                return false;
//            } else {
//                tha04.setError(null);
//            }
//
//
//            if (!tha04.getText().toString().isEmpty() && !tha08.getText().toString().isEmpty()) {
//                if (Integer.parseInt(tha04.getText().toString()) <= 0
//                        && Integer.parseInt(tha08.getText().toString()) > Integer.parseInt(tha04.getText().toString())) {
//                    Toast.makeText(this, "Number of childrens had diarrea in last two weeks must be greater than 0 and it must be greater than " +
//                            " After how many days of illness did you seek care", Toast.LENGTH_SHORT).show();
//                    tha04.setError("Must be greater than 0");
//                    tha04.requestFocus();
//                    Log.i(TAG, "tha04: This data is Required!");
//                    return false;
//                } else {
//                    tha04.setError(null);
//                }
//            }
//
//
//            //        05
//            if (tha05.getCheckedRadioButtonId() == -1) {
//                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha05), Toast.LENGTH_SHORT).show();
//                tha05a.setError("This data is Required!");    // Set Error on last radio button
//                Log.i(TAG, "tha05: This data is Required!");
//                tha05a.setFocusable(true);
//                tha05a.setFocusableInTouchMode(true);
//                tha05a.requestFocus();
//                return false;
//            } else {
//                tha05a.setError(null);
//            }
//
//
//            //        06
//            if (tha06.getCheckedRadioButtonId() == -1) {
//                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha06), Toast.LENGTH_SHORT).show();
//                tha06a.setError("This data is Required!");    // Set Error on last radio button
//                Log.i(TAG, "tha06: This data is Required!");
//                tha06a.setFocusable(true);
//                tha06a.setFocusableInTouchMode(true);
//                tha06a.requestFocus();
//                return false;
//            } else {
//                tha06a.setError(null);
//            }
//
//            if (tha06b.isChecked() || tha06888.isChecked()) {
//
//                //        07
//                if (!tha07a.isChecked()
//                        && !tha07b.isChecked()
//                        && !tha07c.isChecked()
//                        && !tha07d.isChecked()
//                        && !tha07e.isChecked()
//                        && !tha07f.isChecked()
//                        && !tha07g.isChecked()
//                        && !tha07h.isChecked()
//                        && !tha0788.isChecked()) {
//                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha07), Toast.LENGTH_LONG).show();
//                    tha07a.setError("This data is Required!");
//                    Log.i(TAG, "tha07a: This data is Required!");
//                    tha07a.setFocusable(true);
//                    tha07a.setFocusableInTouchMode(true);
//                    tha07a.requestFocus();
//                    return false;
//                } else {
//                    tha07a.setError(null);
//                }
//
//
//                //        0788
//                if (tha0788.isChecked()) {
//                    if (tha0788.getText().toString().isEmpty()) {
//                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
//                        tha0788.setError("This data is Required!");    // Set Error on last radio button
//                        Log.i(TAG, "tha0788: This data is Required!");
//                        tha0788x.requestFocus();
//                        return false;
//                    } else {
//                        tha0788.setError(null);
//                    }
//                }
//
//            } else {
//
//                //        08
//                if (tha08.getText().toString().isEmpty()) {
//                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha08), Toast.LENGTH_SHORT).show();
//                    tha08.setError("This data is Required!");    // Set Error on last radio button
//                    Log.i(TAG, "tha08: This data is Required!");
//                    tha08.requestFocus();
//                    return false;
//                } else {
//                    tha08.setError(null);
//                }
//
//
//                //        09
//                if (tha09.getCheckedRadioButtonId() == -1) {
//                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha09), Toast.LENGTH_LONG).show();
//                    tha09a.setError("This data is Required!");
//                    Log.i(TAG, "tha09: This data is Required!");
//                    tha09a.setFocusable(true);
//                    tha09a.setFocusableInTouchMode(true);
//                    tha09a.requestFocus();
//                    return false;
//                } else {
//                    tha09a.setError(null);
//                }
//
//
//                //        10
//                if (tha10.getCheckedRadioButtonId() == -1) {
//                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha10), Toast.LENGTH_SHORT).show();
//                    tha10a.setError("This data is Required!");    // Set Error on last radio button
//                    Log.i(TAG, "tha10: This data is Required!");
//                    tha10a.setFocusable(true);
//                    tha10a.setFocusableInTouchMode(true);
//                    tha10a.requestFocus();
//                    return false;
//                } else {
//                    tha10a.setError(null);
//                }
//
//
//                //        11
//                if (!tha11a.isChecked()
//                        && !tha11b.isChecked()
//                        && !tha11c.isChecked()
//                        && !tha11d.isChecked()
//                        && !tha11e.isChecked()
//                        && !tha11f.isChecked()
//                        && !tha11g.isChecked()
//                        && !tha11h.isChecked()
//                        && !tha11i.isChecked()
//                        && !tha11j.isChecked()) {
//                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha11), Toast.LENGTH_LONG).show();
//                    tha11a.setError("This data is Required!");
//                    Log.i(TAG, "tha11a: This data is Required!");
//                    tha11a.setFocusable(true);
//                    tha11a.setFocusableInTouchMode(true);
//                    tha11a.requestFocus();
//                    return false;
//                } else {
//                    tha11a.setError(null);
//                }
//
//
//                //        12
//                if (tha12.getCheckedRadioButtonId() == -1) {
//                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha12), Toast.LENGTH_SHORT).show();
//                    tha12a.setError("This data is Required!");    // Set Error on last radio button
//                    Log.i(TAG, "tha12: This data is Required!");
//                    tha12a.setFocusable(true);
//                    tha12a.setFocusableInTouchMode(true);
//                    tha12a.requestFocus();
//                    return false;
//                } else {
//                    tha12a.setError(null);
//                }
//
//
//                //        13
//                if (tha13.getCheckedRadioButtonId() == -1) {
//                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha13), Toast.LENGTH_SHORT).show();
//                    tha13a.setError("This data is Required!");    // Set Error on last radio button
//                    Log.i(TAG, "tha13: This data is Required!");
//                    tha13a.setFocusable(true);
//                    tha13a.setFocusableInTouchMode(true);
//                    tha13a.requestFocus();
//                    return false;
//                } else {
//                    tha13a.setError(null);
//                }
//
//                if (tha13a.isChecked()) {
//
//                    //        14
//                    if (tha14.getCheckedRadioButtonId() == -1) {
//                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha14), Toast.LENGTH_SHORT).show();
//                        tha14a.setError("This data is Required!");    // Set Error on last radio button
//                        Log.i(TAG, "tha14: This data is Required!");
//                        tha14a.setFocusable(true);
//                        tha14a.setFocusableInTouchMode(true);
//                        tha14a.requestFocus();
//                        return false;
//                    } else {
//                        tha14a.setError(null);
//                    }
//
//
//                    //        15
//                    if (tha15.getCheckedRadioButtonId() == -1) {
//                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha15), Toast.LENGTH_SHORT).show();
//                        tha15a.setError("This data is Required!");    // Set Error on last radio button
//                        Log.i(TAG, "tha15: This data is Required!");
//                        tha15a.setFocusable(true);
//                        tha15a.setFocusableInTouchMode(true);
//                        tha15a.requestFocus();
//                        return false;
//                    } else {
//                        tha15a.setError(null);
//                    }
//
//
//                    if (tha15a.isChecked()) {
//
//                        //        16
//                        if (tha16.getCheckedRadioButtonId() == -1) {
//                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha16), Toast.LENGTH_SHORT).show();
//                            tha16a.setError("This data is Required!");    // Set Error on last radio button
//                            Log.i(TAG, "tha16: This data is Required!");
//                            tha16a.setFocusable(true);
//                            tha16a.setFocusableInTouchMode(true);
//                            tha16a.requestFocus();
//                            return false;
//                        } else {
//                            tha16a.setError(null);
//                        }
//
//
//                        //        1688
//                        if (tha1688.isChecked()) {
//                            if (tha1688x.getText().toString().isEmpty()) {
//                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
//                                tha1688x.setError("This data is Required!");    // Set Error on last radio button
//                                Log.i(TAG, "tha1688x: This data is Required!");
//                                tha1688x.requestFocus();
//                                return false;
//                            } else {
//                                tha1688x.setError(null);
//                            }
//                        }
//
//
//                        //        17
//                        if (tha17.getCheckedRadioButtonId() == -1) {
//                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha17), Toast.LENGTH_SHORT).show();
//                            tha17a.setError("This data is Required!");    // Set Error on last radio button
//                            Log.i(TAG, "tha17: This data is Required!");
//                            tha17a.setFocusable(true);
//                            tha17a.setFocusableInTouchMode(true);
//                            tha17a.requestFocus();
//                            return false;
//                        } else {
//                            tha17a.setError(null);
//                        }
//
//                    }
//
//
//                    //        18
//                    if (tha18.getCheckedRadioButtonId() == -1) {
//                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha18), Toast.LENGTH_SHORT).show();
//                        tha18a.setError("This data is Required!");    // Set Error on last radio button
//                        Log.i(TAG, "tha18: This data is Required!");
//                        tha18a.setFocusable(true);
//                        tha18a.setFocusableInTouchMode(true);
//                        tha18a.requestFocus();
//                        return false;
//                    } else {
//                        tha18a.setError(null);
//                    }
//
//
//                    //        19
//                    if (!tha19a.isChecked()
//                            && !tha19b.isChecked()
//                            && !tha19c.isChecked()
//                            && !tha19d.isChecked()
//                            && !tha19e.isChecked()
//                            && !tha19f.isChecked()
//                            && !tha19g.isChecked()
//                            && !tha19h.isChecked()
//                            && !tha19i.isChecked()) {
//                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha19), Toast.LENGTH_LONG).show();
//                        tha19a.setError("This data is Required!");
//                        Log.i(TAG, "tha19a: This data is Required!");
//                        tha19a.setFocusable(true);
//                        tha19a.setFocusableInTouchMode(true);
//                        tha19a.requestFocus();
//                        return false;
//                    } else {
//                        tha19a.setError(null);
//                    }
//
//
//                    //        20
//                    if (tha20.getCheckedRadioButtonId() == -1) {
//                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha20), Toast.LENGTH_SHORT).show();
//                        tha20a.setError("This data is Required!");    // Set Error on last radio button
//                        Log.i(TAG, "tha20: This data is Required!");
//                        tha20a.setFocusable(true);
//                        tha20a.setFocusableInTouchMode(true);
//                        tha20a.requestFocus();
//                        return false;
//                    } else {
//                        tha20a.setError(null);
//                    }
//
//
//                    //        20hr
//                    if (tha20a.isChecked()) {
//                        if (tha20hr.getText().toString().isEmpty()) {
//                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha20), Toast.LENGTH_SHORT).show();
//                            tha20hr.setError("This data is Required!");    // Set Error on last radio button
//                            Log.i(TAG, "tha20hr: This data is Required!");
//                            tha20hr.requestFocus();
//                            return false;
//                        } else {
//                            tha20hr.setError(null);
//                        }
//                    }
//
//
//                    //        20d
//                    if (tha20b.isChecked()) {
//
//                        if (tha20d.getText().toString().isEmpty()) {
//                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha20), Toast.LENGTH_SHORT).show();
//                            tha20d.setError("This data is Required!");    // Set Error on last radio button
//                            Log.i(TAG, "tha20d: This data is Required!");
//                            tha20d.requestFocus();
//                            return false;
//                        } else {
//                            tha20d.setError(null);
//                        }
//
//
//                        if (!tha20d.getText().toString().isEmpty() && !tha04.getText().toString().isEmpty()
//                                && !tha08.getText().toString().isEmpty()) {
//
//                            int diff = Integer.parseInt(tha04.getText().toString()) - Integer.parseInt(tha08.getText().toString());
//
//                            if (Integer.parseInt(tha20d.getText().toString()) <= 0 && Integer.parseInt(tha20d.getText().toString()) < diff) {
//                                Toast.makeText(this, "After how many days of discharge were you recommended for a follow up visit and it should be " +
//                                        " less than the difference of illness of did you seek care ", Toast.LENGTH_SHORT).show();
//                                tha20d.setError("Must be greater than 0 and must be less than difference of illness of did you seek care");
//                                Log.i(TAG, "tha20d: This data is Required!");
//                                tha20d.requestFocus();
//                                return false;
//                            } else {
//                                tha20d.setError(null);
//                            }
//                        }
//
//                    }
//
//
//                    //        20c
//                    if (!tha20c.isChecked()) {
//
//                        //        21
//                        if (tha21.getCheckedRadioButtonId() == -1) {
//                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha21), Toast.LENGTH_SHORT).show();
//                            tha21a.setError("This data is Required!");    // Set Error on last radio button
//                            Log.i(TAG, "tha21: This data is Required!");
//                            tha21a.setFocusable(true);
//                            tha21a.setFocusableInTouchMode(true);
//                            tha21a.requestFocus();
//                            return false;
//                        } else {
//                            tha21a.setError(null);
//                        }
//
//                        if (tha21a.isChecked()) {
//
//                            //        22
//                            if (tha22.getText().toString().isEmpty()) {
//                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha22), Toast.LENGTH_SHORT).show();
//                                tha22.setError("This data is Required!");    // Set Error on last radio button
//                                Log.i(TAG, "tha22: This data is Required!");
//                                tha22.requestFocus();
//                                return false;
//                            } else {
//                                tha22.setError(null);
//                            }
//
//
//                            if (Integer.parseInt(tha22.getText().toString().isEmpty() ? "0" : tha22.getText().toString()) <= 0) {
//                                Toast.makeText(this, "After how many days of discharge were you recommended for a follow up visit", Toast.LENGTH_SHORT).show();
//                                tha22.setError("Must be greater than 0");
//                                Log.i(TAG, "tha22: This data is Required!");
//                                tha22.requestFocus();
//                                return false;
//                            } else {
//                                tha22.setError(null);
//                            }
//
//
//                            //        23
//                            if (tha23.getCheckedRadioButtonId() == -1) {
//                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha23), Toast.LENGTH_SHORT).show();
//                                tha23a.setError("This data is Required!");    // Set Error on last radio button
//                                Log.i(TAG, "tha23: This data is Required!");
//                                tha23a.setFocusable(true);
//                                tha23a.setFocusableInTouchMode(true);
//                                tha23a.requestFocus();
//                                return false;
//                            } else {
//                                tha23a.setError(null);
//                            }
//
//
//                            if (tha23b.isChecked()) {
//
//                                //        24
//                                if (!tha24a.isChecked()
//                                        && !tha24b.isChecked()
//                                        && !tha24c.isChecked()
//                                        && !tha24d.isChecked()
//                                        && !tha24e.isChecked()
//                                        && !tha24f.isChecked()
//                                        && !tha24g.isChecked()) {
//                                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha24), Toast.LENGTH_LONG).show();
//                                    tha24a.setError("This data is Required!");
//                                    Log.i(TAG, "tha24a: This data is Required!");
//                                    tha24a.setFocusable(true);
//                                    tha24a.setFocusableInTouchMode(true);
//                                    tha24a.requestFocus();
//                                    return false;
//                                } else {
//                                    tha24a.setError(null);
//                                }
//
//                            }
//
//                        }
//
//
//                    }
//
//                    if (!tha09a.isChecked()) {
//
//                        if (!tha26888.isChecked()) {
//
//                            //        26
//                            if (tha26.getText().toString().isEmpty()) {
//                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha26), Toast.LENGTH_SHORT).show();
//                                tha26.setError("This data is Required!");    // Set Error on last radio button
//                                Log.i(TAG, "tha26: This data is Required!");
//                                tha26.requestFocus();
//                                return false;
//                            } else {
//                                tha26.setError(null);
//                            }
//
//
//                            if (Double.parseDouble(tha26.getText().toString().isEmpty() ? "0" : tha26.getText().toString()) <= 0) {
//                                Toast.makeText(this, "How far is the health facility, where you sought treatment of {NAME} for diarrheal episode", Toast.LENGTH_SHORT).show();
//                                tha26.setError("Must be greater than 0");
//                                Log.i(TAG, "tha26: This data is Required!");
//                                tha26.requestFocus();
//                                return false;
//                            } else {
//                                tha26.setError(null);
//                            }
//
//                        }
//
//
//                        //        27
//                        if (tha27.getCheckedRadioButtonId() == -1) {
//                            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha27), Toast.LENGTH_SHORT).show();
//                            tha27a.setError("This data is Required!");    // Set Error on last radio button
//                            Log.i(TAG, "tha27: This data is Required!");
//                            tha27a.setFocusable(true);
//                            tha27a.setFocusableInTouchMode(true);
//                            tha27a.requestFocus();
//                            return false;
//                        } else {
//                            tha27a.setError(null);
//                        }
//
//
//                        //        2788x
//                        if (tha2788.isChecked()) {
//                            if (tha2788x.getText().toString().isEmpty()) {
//                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
//                                tha2788x.setError("This data is Required!");    // Set Error on last radio button
//                                Log.i(TAG, "tha2788x: This data is Required!");
//                                tha2788x.requestFocus();
//                                return false;
//                            } else {
//                                tha2788x.setError(null);
//                            }
//                        }
//
//
//                        if (!tha28888.isChecked()) {
//
//                            //        28
//                            if (tha28.getText().toString().isEmpty()) {
//                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha28), Toast.LENGTH_SHORT).show();
//                                tha28.setError("This data is Required!");    // Set Error on last radio button
//                                Log.i(TAG, "tha28: This data is Required!");
//                                tha28.requestFocus();
//                                return false;
//                            } else {
//                                tha28.setError(null);
//                            }
//
//                        }
//
//                        if (!tha29888.isChecked()) {
//
//                            //        29
//                            if (tha29.getText().toString().isEmpty()) {
//                                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha29), Toast.LENGTH_SHORT).show();
//                                tha29.setError("This data is Required!");    // Set Error on last radio button
//                                Log.i(TAG, "tha29: This data is Required!");
//                                tha29.requestFocus();
//                                return false;
//                            } else {
//                                tha29.setError(null);
//                            }
//                        }
//                    }
//                }
//
//                if (!tha30888.isChecked()) {
//
//                    //        30
//                    if (tha30.getText().toString().isEmpty()) {
//                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha30), Toast.LENGTH_SHORT).show();
//                        tha30.setError("This data is Required!");    // Set Error on last radio button
//                        Log.i(TAG, "tha30: This data is Required!");
//                        tha30.requestFocus();
//                        return false;
//                    } else {
//                        tha30.setError(null);
//                    }
//
//                }
//
//
//                //        31
//                if (tha31.getCheckedRadioButtonId() == -1) {
//                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha31), Toast.LENGTH_SHORT).show();
//                    tha31a.setError("This data is Required!");    // Set Error on last radio button
//                    Log.i(TAG, "tha31: This data is Required!");
//                    tha31a.setFocusable(true);
//                    tha31a.setFocusableInTouchMode(true);
//                    tha31a.requestFocus();
//                    return false;
//                } else {
//                    tha31a.setError(null);
//                }
//
////            if (!tha20c.isChecked()) {
//
//                //        25
//                if (tha25.getCheckedRadioButtonId() == -1) {
//                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha25), Toast.LENGTH_SHORT).show();
//                    tha25a.setError("This data is Required!");    // Set Error on last radio button
//                    Log.i(TAG, "tha25: This data is Required!");
//                    tha25a.setFocusable(true);
//                    tha25a.setFocusableInTouchMode(true);
//                    tha25a.requestFocus();
//                    return false;
//                } else {
//                    tha25a.setError(null);
//                }
//
//            }
//        }
//        //        32
//        if (tha32.getCheckedRadioButtonId() == -1) {
//            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha32), Toast.LENGTH_SHORT).show();
//            tha32a.setError("This data is Required!");    // Set Error on last radio button
//            Log.i(TAG, "tha32: This data is Required!");
//            tha32a.setFocusable(true);
//            tha32a.setFocusableInTouchMode(true);
//            tha32a.requestFocus();
//            return false;
//        } else {
//            tha32a.setError(null);
//        }
//
////        }
//
//
//        if (tha32a.isChecked()) {
//
//            //        33
//            if (tha33.getCheckedRadioButtonId() == -1) {
//                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha33), Toast.LENGTH_SHORT).show();
//                tha33a.setError("This data is Required!");    // Set Error on last radio button
//                Log.i(TAG, "tha33: This data is Required!");
//                tha33a.setFocusable(true);
//                tha33a.setFocusableInTouchMode(true);
//                tha33a.requestFocus();
//                return false;
//            } else {
//                tha33a.setError(null);
//            }
//
//        }
//
//        if (tha33a.isChecked()) {
//
//            //        34
//            if (tha34.getCheckedRadioButtonId() == -1) {
//                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tha34), Toast.LENGTH_SHORT).show();
//                tha34a.setError("This data is Required!");    // Set Error on last radio button
//                Log.i(TAG, "tha34: This data is Required!");
//                tha34a.setFocusable(true);
//                tha34a.setFocusableInTouchMode(true);
//                tha34a.requestFocus();
//                return false;
//            } else {
//                tha34a.setError(null);
//            }
//
//        }
//

        }
        return true;

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}


