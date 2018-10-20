package edu.aku.hassannaqvi.uen_po_hhs.activities;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
        childsMap.put("....", "");
//        lstChild.add("....");
//
//        lstChild.add("Child 1 ");
//        lstChild.add("Child 2 ");
//        lstChild.add("Child 3 ");
//        lstChild.add("Child 4 ");

        /*for (byte i = 0; i < MainApp.familyMembersList.size(); i++) {
            if (MainApp.familyMembersList.get(i).getAgeLess5().equals("1") || MainApp.familyMembersList.get(i).getAgeLess5().equals("3")) {
                childsMap.put(MainApp.familyMembersList.get(i).getName(), MainApp.familyMembersList.get(i).getSerialNo());
                lstChild.add(MainApp.familyMembersList.get(i).getName());

                count_child_5y++;
            }
        }*/

        bi.tha03.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, MainApp.childList));

        bi.tha01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.tha01a) {
                    bi.fldgrptha02.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha02, false);
                    bi.fldgrptha03.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha03, false);
                    bi.tha03.setSelection(0);
                    bi.fldgrptha04.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha04, false);
                    bi.fldgrptha05.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha05, false);
                    bi.fldgrptha06.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha06, false);
                    bi.fldgrptha07.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha07, false);
                    bi.tha0796x.setText(null);
                    bi.fldgrptha08.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha08, false);
                    bi.fldgrptha09.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha09, false);
                    bi.tha0996x.setText(null);
                    bi.fldgrptha10.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha10, false);
                    bi.tha1096x.setText(null);
                    bi.fldgrptha11.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha11, false);
                    bi.tha1196x.setText(null);
                    bi.fldgrptha12.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha12, false);
                    bi.fldgrptha13.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha13, false);
                    bi.fldgrptha14.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, false);
                    bi.fldgrptha15.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha15, false);
                    bi.tha1596x.setText(null);
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
                    bi.tha2496x.setText(null);
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

        bi.tha09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i == R.id.tha09a){
                    bi.tha09ex.setVisibility(View.GONE);
                    bi.tha0996x.setVisibility(View.GONE);
                    bi.tha09ex.setText(null);
                    bi.tha0996x.setText(null);
                }
                if (i == R.id.tha09b || i == R.id.tha09c || i == R.id.tha09d) {
                    bi.tha0996x.setVisibility(View.VISIBLE);
                    bi.tha09ex.setVisibility(View.GONE);
                    bi.tha09ex.setText(null);
                }
                if(i == R.id.tha09e){
                    bi.tha0996x.setVisibility(View.GONE);
                    bi.tha0996x.setText(null);
                    bi.tha09ex.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.tha10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tha10a || i == R.id.tha10f) {
                    bi.tha1096x.setVisibility(View.VISIBLE);
                } else {
                    bi.tha1096x.setVisibility(View.GONE);
                    bi.tha1096x.setText(null);
                }
            }
        });

        bi.tha11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tha11b || i == R.id.tha11c) {
                    bi.tha1196x.setVisibility(View.VISIBLE);
                } else {
                    bi.tha1196x.setVisibility(View.GONE);
                    bi.tha1196x.setText(null);
                }
            }
        });

        bi.tha13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tha13b) {

                    bi.fldgrptha14.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha14, false);
                    bi.tha1496x.setText(null);
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

                }
            }
        });

        bi.tha14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.tha14d) {
                    bi.tha14dx.setVisibility(View.GONE);
                    bi.tha14dx.setText(null);
                    bi.tha1496x.setVisibility(View.VISIBLE);
                } else {
                    bi.tha14dx.setVisibility(View.VISIBLE);
                    bi.tha1496x.setVisibility(View.GONE);
                    bi.tha1496x.setText(null);
                }
            }
        });

        bi.tha15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i == R.id.tha15a){
                    bi.tha1596x.setVisibility(View.VISIBLE);
                    bi.tha15fx.setVisibility(View.GONE);
                    bi.tha15fx.setText(null);
                }
                if(i == R.id.tha15f){
                    bi.tha15fx.setVisibility(View.VISIBLE);
                    bi.tha1596x.setVisibility(View.GONE);
                    bi.tha1596x.setText(null);
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

                } else {
                    bi.fldgrptha19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha19, true);
                    bi.fldgrptha20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha20, true);
                    bi.fldgrptha21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, true);

                }
            }
        });

        bi.tha20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tha20a) {
                    bi.fldgrptha21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, false);

                } else {
                    bi.fldgrptha21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrptha21, true);

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

        bi.tha31.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tha31b || i == R.id.tha31c) {
                    bi.tha3196x.setVisibility(View.VISIBLE);
                } else {
                    bi.tha3196x.setVisibility(View.GONE);
                    bi.tha3196x.setText(null);
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

        sHA.put("tha01", bi.tha01a.isChecked() ? "1" : bi.tha01b.isChecked() ? "2" : bi.tha01888.isChecked() ? "888" : "0");
        sHA.put("tha02", bi.tha02.getText().toString());
        sHA.put("tha03", bi.tha03.getSelectedItem().toString().equalsIgnoreCase("....") ? "" : bi.tha03.getSelectedItem().toString());
        sHA.put("tha04", bi.tha04.getText().toString());
        sHA.put("tha05", bi.tha05a.isChecked() ? "1" : bi.tha05b.isChecked() ? "2" : bi.tha05888.isChecked() ? "888" : "0");
        sHA.put("tha06", bi.tha06a.isChecked() ? "1" : bi.tha06b.isChecked() ? "2" : bi.tha06888.isChecked() ? "888" : "0");
        sHA.put("tha07a", bi.tha07a.isChecked() ? "1" : "0");
        sHA.put("tha07b", bi.tha07b.isChecked() ? "2" : "0");
        sHA.put("tha07c", bi.tha07c.isChecked() ? "3" : "0");
        sHA.put("tha07d", bi.tha07d.isChecked() ? "4" : "0");
        sHA.put("tha07e", bi.tha07e.isChecked() ? "5" : "0");
        sHA.put("tha07f", bi.tha07f.isChecked() ? "6" : "0");
        sHA.put("tha07g", bi.tha07g.isChecked() ? "7" : "0");
        sHA.put("tha07h", bi.tha07h.isChecked() ? "8" : "0");
        sHA.put("tha07a", bi.tha07a.isChecked() ? "9" : "0");
        sHA.put("tha0788", bi.tha0796.isChecked() ? "88" : "0");
        sHA.put("tha0788x", bi.tha0796x.getText().toString());
        sHA.put("tha08", bi.tha08.getText().toString());

        sHA.put("tha09",
                bi.tha09a.isChecked() ? "1"
                        : bi.tha09b.isChecked() ? "2"
                        : bi.tha09c.isChecked() ? "3"
                        : bi.tha09d.isChecked() ? "4"
                        : bi.tha09e.isChecked() ? "88"
                        : "0");
        sHA.put("tha0996x", bi.tha0996x.getText().toString());
        sHA.put("tha09ex", bi.tha09ex.getText().toString());
        sHA.put("tha10", bi.tha10a.isChecked() ? "1"
                : bi.tha10b.isChecked() ? "2"
                : bi.tha10c.isChecked() ? "3"
                : bi.tha10d.isChecked() ? "4"
                : bi.tha10e.isChecked() ? "5"
                : bi.tha10f.isChecked() ? "6"
                : bi.tha10g.isChecked() ? "7"
                : bi.tha10h.isChecked() ? "8"
                : bi.tha10i.isChecked() ? "9"
                : "0");
        sHA.put("tha10x", bi.tha1096x.getText().toString());

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
                : bi.tha14d.isChecked() ? "88"
                : "0");
        sHA.put("tha1488x", bi.tha1496x.getText().toString());
        sHA.put("tha14dx", bi.tha14dx.getText().toString());

        sHA.put("tha15", bi.tha15a.isChecked() ? "1"
                : bi.tha15b.isChecked() ? "2"
                : bi.tha15c.isChecked() ? "3"
                : bi.tha15d.isChecked() ? "4"
                : bi.tha15e.isChecked() ? "5"
                : bi.tha15f.isChecked() ? "88"
                : "0");
        sHA.put("tha1588x", bi.tha15fx.getText().toString());
        sHA.put("tha1588x", bi.tha1596x.getText().toString());

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

        sHA.put("tha23", bi.tha2398.isChecked() ? "888" : "0");
        sHA.put("tha23km", bi.tha23.getText().toString());
        sHA.put("tha24", bi.tha24a.isChecked() ? "1"
                : bi.tha24b.isChecked() ? "2"
                : bi.tha24c.isChecked() ? "3"
                : bi.tha24d.isChecked() ? "4"
                : bi.tha24e.isChecked() ? "5"
                : bi.tha24f.isChecked() ? "6"
                : bi.tha24i.isChecked() ? "7"
                : bi.tha24g.isChecked() ? "8"
                : bi.tha24h.isChecked() ? "9"
                : bi.tha2496.isChecked() ? "88"
                : "0");
        sHA.put("tha2488x", bi.tha2496x.getText().toString());
        sHA.put("tha25", bi.tha2598.isChecked() ? "888" : "0");
        sHA.put("tha25m", bi.tha25.getText().toString());

        sHA.put("tha26", bi.tha2698.isChecked() ? "888" : "0");
        sHA.put("tha26r", bi.tha26.getText().toString());

        sHA.put("tha27", bi.tha2798.isChecked() ? "888" : "0");
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
                : bi.tha31l.isChecked() ? "12"
                : "0");
        sHA.put("tha3188x", bi.tha3196x.getText().toString());


        MainApp.fc.setsHA(String.valueOf(sHA));

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
            if (Integer.parseInt(bi.tha02.getText().toString()) > MainApp.TotalChildCount) {
                bi.tha02.setError("Child could not be greater than " + MainApp.TotalChildCount + "!");
                bi.tha02.requestFocus();
                return false;
            } else {
                bi.tha02.setError(null);
                bi.tha02.clearFocus();
            }
            if (!validatorClass.EmptySpinner(this, bi.tha03, getString(R.string.tha03))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.tha04, getString(R.string.tha04))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, bi.tha04, 1, 14, getString(R.string.tha04), "Number")) {
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
                if (!validatorClass.RangeTextBox(this, bi.tha08, 1, 20, getString(R.string.tha08), "Number")) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.tha09, bi.tha09a, getString(R.string.tha09))) {
                    return false;
                }

                if (bi.tha09b.isChecked() ||  bi.tha09c.isChecked() || bi.tha09d.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.tha0996x, getString(R.string.tha09))) {
                        return false;
                    }
                }
                if(bi.tha09e.isChecked()){
                    if (!validatorClass.EmptyTextBox(this, bi.tha09ex, getString(R.string.tha09))) {
                        return false;
                    }
                }
                if (!validatorClass.EmptyRadioButton(this, bi.tha10, bi.tha10a, getString(R.string.tha10))) {
                    return false;
                }
                if (bi.tha10a.isChecked() || bi.tha10f.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.tha1096x, getString(R.string.tha10))) {
                        return false;

                    }
                }
                if (!validatorClass.EmptyRadioButton(this, bi.tha11, bi.tha11a, getString(R.string.tha11))) {
                    return false;
                }
                if (bi.tha11b.isChecked() || bi.tha11c.isChecked()) {
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
                    if (!bi.tha14d.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.tha1496x, getString(R.string.tha14))) {
                            return false;
                        }
                    } else {
                        if (!validatorClass.EmptyTextBox(this, bi.tha14dx, getString(R.string.tha14))) {
                            return false;
                        }
                    }

                    if (!validatorClass.EmptyRadioButton(this, bi.tha15, bi.tha15a, getString(R.string.tha15))) {
                        return false;
                    }
                    if (bi.tha15a.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.tha1596x, getString(R.string.tha15))) {
                            return false;
                        }
                    }
                    if (bi.tha15f.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.tha15fx, getString(R.string.tha15))) {
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
                        if (!validatorClass.RangeTextBox(this, bi.tha17hr, 1, 23, getString(R.string.tha17), "Number")) {
                            return false;
                        }
                    }
                    if (bi.tha17b.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.tha17d, getString(R.string.tha17))) {
                            return false;
                        }
                        if (!validatorClass.RangeTextBox(this, bi.tha17d, 1, 20, getString(R.string.tha17), "Number")) {
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
                            if (!validatorClass.RangeTextBox(this, bi.tha19, 1, 20, getString(R.string.tha17), "Number")) {
                                return false;
                            }
                            if (!validatorClass.EmptyRadioButton(this, bi.tha20, bi.tha20a, getString(R.string.tha20))) {
                                return false;
                            }
                            if (!bi.tha20a.isChecked()) {
                                if (!validatorClass.EmptyCheckBox(this, bi.fldgrptha21, bi.tha21a, getString(R.string.tha21))) {
                                    return false;
                                }

                            }
                            if (!validatorClass.EmptyRadioButton(this, bi.tha22, bi.tha22a, getString(R.string.tha22))) {
                                return false;
                            }
                        }

                    }
                    if (!bi.tha2398.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.tha23, getString(R.string.tha23))) {
                            return false;
                        }
                        if (!validatorClass.RangeTextBox(this, bi.tha23, 0.5, 40.0, getString(R.string.tha23), "Decimal")) {
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
                        if (!validatorClass.RangeTextBox(this, bi.tha25, 5, 90, getString(R.string.tha25), "Number")) {
                            return false;
                        }
                    }
                    if (!bi.tha2698.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.tha26, getString(R.string.tha26))) {
                            return false;
                        }
                        if (!validatorClass.RangeTextBox(this, bi.tha26, 50, 200000, getString(R.string.tha26), "Number")) {
                            return false;
                        }

                    }
                    if (!bi.tha2798.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.tha27, getString(R.string.tha27))) {
                            return false;
                        }
                        if (!validatorClass.RangeTextBox(this, bi.tha27, 50, 200000, getString(R.string.tha27), "Number")) {
                            return false;
                        }
                    }
                    if (!validatorClass.EmptyRadioButton(this, bi.tha28, bi.tha28a, getString(R.string.tha28))) {
                        return false;
                    }

                } else {
                    if (!validatorClass.EmptyRadioButton(this, bi.tha22, bi.tha22a, getString(R.string.tha22))) {
                        return false;
                    }

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
                    if (bi.tha31b.isChecked() || bi.tha31c.isChecked()) {
                        return validatorClass.EmptyTextBox(this, bi.tha3196x, getString(R.string.tha31));
                    }
                }
            }
        } else {
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
                    if (bi.tha31b.isChecked() || bi.tha31c.isChecked()) {
                        return validatorClass.EmptyTextBox(this, bi.tha3196x, getString(R.string.tha31));
                    }
                }
            }
        }
        return true;

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}


