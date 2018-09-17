package edu.aku.hassannaqvi.uen_tmk.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
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
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.uen_tmk.R;
import edu.aku.hassannaqvi.uen_tmk.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_tmk.contracts.SectionIIMContract;
import edu.aku.hassannaqvi.uen_tmk.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_tmk.core.MainApp;
import io.blackbox_vision.datetimepickeredittext.view.DatePickerInputEditText;

public class SectionIActivity extends AppCompatActivity
{

    private static final String TAG = SectionIActivity.class.getSimpleName();

    @BindView(R.id.activity_section_a)
    NestedScrollView scroll;
    @BindView(R.id.tiname)
    Spinner tiname;
    @BindView(R.id.ti00)
    RadioGroup ti00;
    @BindView(R.id.ti00a)
    RadioButton ti00a;
    @BindView(R.id.ti00b)
    RadioButton ti00b;
    @BindView(R.id.ti01)
    RadioGroup ti01;
    @BindView(R.id.ti01a)
    RadioButton ti01a;
    @BindView(R.id.ti01b)
    RadioButton ti01b;
    @BindView(R.id.ti01888)
    RadioButton ti01888;
    @BindView(R.id.fldGrpti02)
    LinearLayout fldGrpti02;
    @BindView(R.id.ti02a)
    CheckBox ti02a;
    @BindView(R.id.ti02b)
    CheckBox ti02b;
    @BindView(R.id.ti02c)
    CheckBox ti02c;
    @BindView(R.id.ti02d)
    CheckBox ti02d;
    @BindView(R.id.ti0288)
    CheckBox ti0288;
    @BindView(R.id.ti0288x)
    EditText ti0288x;
    @BindView(R.id.fldGrpti03)
    LinearLayout fldGrpti03;
    @BindView(R.id.ti03)
    RadioGroup ti03;
    @BindView(R.id.ti03a)
    RadioButton ti03a;
    @BindView(R.id.ti03b)
    RadioButton ti03b;
    @BindView(R.id.ti03c)
    RadioButton ti03c;
    @BindView(R.id.scbirth)
    NestedScrollView scbirth;
    @BindView(R.id.sc1)
    NestedScrollView sc1;
    @BindView(R.id.fldGrpBcgM)
    LinearLayout fldGrpBcgM;
    @BindView(R.id.bcgM)
    RadioGroup bcgM;
    @BindView(R.id.bcgM01)
    RadioButton bcgM01;
    @BindView(R.id.bcgM02)
    RadioButton bcgM02;
    @BindView(R.id.fldGrpBcgMCheck)
    LinearLayout fldGrpBcgMCheck;
    @BindView(R.id.bcgdatenr)
    CheckBox bcgdatenr;
    @BindView(R.id.fldGrpbcgMDate)
    LinearLayout fldGrpbcgMDate;
    @BindView(R.id.bcgDateM_year)
    EditText bcgDateMYear;
    @BindView(R.id.bcgDateM_mon)
    EditText bcgDateMMon;
    @BindView(R.id.fldGrpBcgC)
    LinearLayout fldGrpBcgC;
    @BindView(R.id.bcgC)
    RadioGroup bcgC;
    @BindView(R.id.bcgC01)
    RadioButton bcgC01;
    @BindView(R.id.bcgC02)
    RadioButton bcgC02;
    @BindView(R.id.fldGrpBcgCCheck)
    LinearLayout fldGrpBcgCCheck;
    @BindView(R.id.bcgdatenp)
    CheckBox bcgdatenp;
    @BindView(R.id.fldGrpBcgCDate)
    LinearLayout fldGrpBcgCDate;
    @BindView(R.id.text1)
    TextView text1;
    @BindView(R.id.bcgDate)
    DatePickerInputEditText bcgDate;
    @BindView(R.id.fldGrpov1)
    LinearLayout fldGrpov1;
    @BindView(R.id.bcgPov)
    RadioGroup bcgPov;
    public RadioGroup.OnCheckedChangeListener bcg = new OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {


            if (radioGroup == bcgC) {
                if (bcgC01.isChecked()) {
                    fldGrpBcgCCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpBcgCCheck.setVisibility(View.GONE);
                    bcgDate.setText(null);
                    bcgdatenp.setChecked(false);
                }
            }

            if (radioGroup == bcgM) {

                if (bcgM01.isChecked()) {
                    fldGrpBcgMCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpBcgMCheck.setVisibility(View.GONE);
                    bcgDateMYear.setText(null);
                    bcgDateMMon.setText(null);
                    bcgdatenr.setChecked(false);
                }
            }


            if (bcgM01.isChecked() || bcgC01.isChecked()) {
                fldGrpov1.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
                sc1.setLayoutParams(params);
                LinearLayout.LayoutParams param2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1000);
                scbirth.setLayoutParams(param2);
            } else if (bcgC02.isChecked() || bcgM02.isChecked()) {
                fldGrpov1.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                sc1.setLayoutParams(params);
                scbirth.setLayoutParams(params);
                bcgPov.clearCheck();

            }
        }
    };
    @BindView(R.id.bcgPova)
    RadioButton bcgPova;
    @BindView(R.id.bcgPovb)
    RadioButton bcgPovb;
    @BindView(R.id.bcgPovc)
    RadioButton bcgPovc;
    @BindView(R.id.bcgPovd)
    RadioButton bcgPovd;
    @BindView(R.id.bcgPove)
    RadioButton bcgPove;
    @BindView(R.id.bcgPovf)
    RadioButton bcgPovf;
    @BindView(R.id.bcgPovg)
    RadioButton bcgPovg;
    @BindView(R.id.bcgPovh)
    RadioButton bcgPovh;
    @BindView(R.id.sc2)
    NestedScrollView sc2;
    @BindView(R.id.fldGrpOpv0M)
    LinearLayout fldGrpOpv0M;
    @BindView(R.id.opv0M)
    RadioGroup opv0M;
    @BindView(R.id.opv0M01)
    RadioButton opv0M01;
    @BindView(R.id.opv0M02)
    RadioButton opv0M02;
    @BindView(R.id.fldGrpOpv0MCheck)
    LinearLayout fldGrpOpv0MCheck;
    @BindView(R.id.opv0datenr)
    CheckBox opv0datenr;
    @BindView(R.id.fldGrpopv0MDate)
    LinearLayout fldGrpopv0MDate;
    @BindView(R.id.opv0DateM_year)
    EditText opv0DateMYear;
    @BindView(R.id.opv0DateM_mon)
    EditText opv0DateMMon;
    @BindView(R.id.fldGrpopv0C)
    LinearLayout fldGrpopv0C;
    @BindView(R.id.opv0C)
    RadioGroup opv0C;
    @BindView(R.id.opv0C01)
    RadioButton opv0C01;
    @BindView(R.id.opv0C02)
    RadioButton opv0C02;
    @BindView(R.id.fldGrpOpv0CCheck)
    LinearLayout fldGrpOpv0CCheck;
    @BindView(R.id.opv0datenp)
    CheckBox opv0datenp;
    @BindView(R.id.fldGrpOpv0CDate)
    LinearLayout fldGrpOpv0CDate;
    @BindView(R.id.text2)
    TextView text2;
    @BindView(R.id.opv0Date)
    DatePickerInputEditText opv0Date;
    @BindView(R.id.fldGrpov2)
    LinearLayout fldGrpov2;
    @BindView(R.id.opv0Pov)
    RadioGroup opv0Pov;
    public RadioGroup.OnCheckedChangeListener opv0 = new OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {


            if (radioGroup == opv0C) {
                if (opv0C01.isChecked()) {
                    fldGrpOpv0CCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpOpv0CCheck.setVisibility(View.GONE);
                    opv0Date.setText(null);
                    opv0datenp.setChecked(false);
                }
            }

            if (radioGroup == opv0M) {
                if (opv0M01.isChecked()) {
                    fldGrpOpv0MCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpOpv0MCheck.setVisibility(View.GONE);
                    opv0DateMYear.setText(null);
                    opv0DateMMon.setText(null);
                    opv0datenr.setChecked(false);
                }
            }
            if (opv0M01.isChecked() || opv0C01.isChecked()) {
                fldGrpov2.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
                sc2.setLayoutParams(params);
            } else if (opv0C02.isChecked() || opv0M02.isChecked()) {
                fldGrpov2.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                sc2.setLayoutParams(params);
                opv0Pov.clearCheck();

            }
        }
    };
    @BindView(R.id.opv0Pova)
    RadioButton opv0Pova;
    @BindView(R.id.opv0Povb)
    RadioButton opv0Povb;
    @BindView(R.id.opv0Povc)
    RadioButton opv0Povc;
    @BindView(R.id.opv0Povd)
    RadioButton opv0Povd;
    @BindView(R.id.opv0Pove)
    RadioButton opv0Pove;
    @BindView(R.id.opv0Povf)
    RadioButton opv0Povf;
    @BindView(R.id.opv0Povg)
    RadioButton opv0Povg;
    @BindView(R.id.opv0Povh)
    RadioButton opv0Povh;
    @BindView(R.id.sc6wks)
    NestedScrollView sc6wks;
    @BindView(R.id.sc3)
    NestedScrollView sc3;
    @BindView(R.id.fldGrpopv1M)
    LinearLayout fldGrpopv1M;
    @BindView(R.id.opv1M)
    RadioGroup opv1M;
    @BindView(R.id.opv1M01)
    RadioButton opv1M01;
    @BindView(R.id.opv1M02)
    RadioButton opv1M02;
    @BindView(R.id.fldGrpOpv1MCheck)
    LinearLayout fldGrpOpv1MCheck;
    @BindView(R.id.opv1datenr)
    CheckBox opv1datenr;
    @BindView(R.id.fldGrpopv1MDate)
    LinearLayout fldGrpopv1MDate;
    @BindView(R.id.opv1DateM_year)
    EditText opv1DateMYear;
    @BindView(R.id.opv1DateM_mon)
    EditText opv1DateMMon;
    @BindView(R.id.fldGrpopv1C)
    LinearLayout fldGrpopv1C;
    @BindView(R.id.opv1C)
    RadioGroup opv1C;
    @BindView(R.id.opv1C01)
    RadioButton opv1C01;
    @BindView(R.id.opv1C02)
    RadioButton opv1C02;
    @BindView(R.id.fldGrpOpv1CCheck)
    LinearLayout fldGrpOpv1CCheck;
    @BindView(R.id.opv1datenp)
    CheckBox opv1datenp;
    @BindView(R.id.fldGrpOpv1CDate)
    LinearLayout fldGrpOpv1CDate;
    @BindView(R.id.text3)
    TextView text3;
    @BindView(R.id.opv1Date)
    DatePickerInputEditText opv1Date;
    @BindView(R.id.fldGrpov3)
    LinearLayout fldGrpov3;
    @BindView(R.id.opv1Pov)
    RadioGroup opv1Pov;
    public RadioGroup.OnCheckedChangeListener opv1 = new OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {


            if (radioGroup == opv1C) {
                if (opv1C01.isChecked()) {
                    fldGrpOpv1CCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpOpv1CCheck.setVisibility(View.GONE);
                    opv1Date.setText(null);
                    opv1datenp.setChecked(false);
                }
            }

            if (radioGroup == opv1M) {

                if (opv1M01.isChecked()) {
                    fldGrpOpv1MCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpOpv1MCheck.setVisibility(View.GONE);
                    opv1DateMYear.setText(null);
                    opv1DateMMon.setText(null);
                    opv1datenr.setChecked(false);
                }
            }

            if (opv1M01.isChecked() || opv1C01.isChecked()) {
                fldGrpov3.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
                sc3.setLayoutParams(params);
            } else if (opv1C02.isChecked() || opv1M02.isChecked()) {
                fldGrpov3.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                sc3.setLayoutParams(params);
                opv1Pov.clearCheck();

            }
        }
    };
    @BindView(R.id.opv1Pova)
    RadioButton opv1Pova;
    @BindView(R.id.opv1Povb)
    RadioButton opv1Povb;
    @BindView(R.id.opv1Povc)
    RadioButton opv1Povc;
    @BindView(R.id.opv1Povd)
    RadioButton opv1Povd;
    @BindView(R.id.opv1Pove)
    RadioButton opv1Pove;
    @BindView(R.id.opv1Povf)
    RadioButton opv1Povf;
    @BindView(R.id.opv1Povg)
    RadioButton opv1Povg;
    @BindView(R.id.opv1Povh)
    RadioButton opv1Povh;
    @BindView(R.id.sc4)
    NestedScrollView sc4;
    @BindView(R.id.fldGrpPenta1M)
    LinearLayout fldGrpPenta1M;
    @BindView(R.id.penta1M)
    RadioGroup penta1M;
    @BindView(R.id.penta1M01)
    RadioButton penta1M01;
    @BindView(R.id.Penta1M02)
    RadioButton penta1M02;
    @BindView(R.id.fldGrpPenta1MCheck)
    LinearLayout fldGrpPenta1MCheck;
    @BindView(R.id.penta1datenr)
    CheckBox penta1datenr;
    @BindView(R.id.fldGrppenta1MDate)
    LinearLayout fldGrppenta1MDate;
    @BindView(R.id.penta1DateM_year)
    EditText penta1DateMYear;
    @BindView(R.id.penta1DateM_mon)
    EditText penta1DateMMon;
    @BindView(R.id.fldGrpPenta1C)
    LinearLayout fldGrpPenta1C;
    @BindView(R.id.penta1C)
    RadioGroup penta1C;
    @BindView(R.id.penta1C01)
    RadioButton penta1C01;
    @BindView(R.id.penta1C02)
    RadioButton penta1C02;
    @BindView(R.id.fldGrppenta1CCheck)
    LinearLayout fldGrppenta1CCheck;
    @BindView(R.id.penta1datenp)
    CheckBox penta1datenp;
    @BindView(R.id.fldGrpPenta1CDate)
    LinearLayout fldGrpPenta1CDate;
    @BindView(R.id.text4)
    TextView text4;
    @BindView(R.id.penta1Date)
    DatePickerInputEditText penta1Date;
    @BindView(R.id.fldGrpov4)
    LinearLayout fldGrpov4;
    @BindView(R.id.penta1Pov)
    RadioGroup penta1Pov;
    public RadioGroup.OnCheckedChangeListener penta1 = new OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

            if (radioGroup == penta1C) {
                if (penta1C01.isChecked()) {
                    fldGrppenta1CCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrppenta1CCheck.setVisibility(View.GONE);
                    penta1Date.setText(null);
                    penta1datenp.setChecked(false);
                }
            }


            if (radioGroup == penta1M) {
                if (penta1M01.isChecked()) {
                    fldGrpPenta1MCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpPenta1MCheck.setVisibility(View.GONE);
                    penta1DateMYear.setText(null);
                    penta1DateMMon.setText(null);
                    penta1datenr.setChecked(false);
                }
            }

            if (penta1M01.isChecked() || penta1C01.isChecked()) {
                fldGrpov4.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
                sc4.setLayoutParams(params);
            } else if (penta1C02.isChecked() || penta1M02.isChecked()) {
                fldGrpov4.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                sc4.setLayoutParams(params);
                penta1Pov.clearCheck();

            }
        }
    };
    @BindView(R.id.penta1Pova)
    RadioButton penta1Pova;
    @BindView(R.id.penta1Povb)
    RadioButton penta1Povb;
    @BindView(R.id.penta1Povc)
    RadioButton penta1Povc;
    @BindView(R.id.penta1Povd)
    RadioButton penta1Povd;
    @BindView(R.id.penta1Pove)
    RadioButton penta1Pove;
    @BindView(R.id.penta1Povf)
    RadioButton penta1Povf;
    @BindView(R.id.penta1Povg)
    RadioButton penta1Povg;
    @BindView(R.id.penta1Povh)
    RadioButton penta1Povh;
    @BindView(R.id.sc5)
    NestedScrollView sc5;
    @BindView(R.id.fldGrppcv1M)
    LinearLayout fldGrppcv1M;
    @BindView(R.id.pcv1M)
    RadioGroup pcv1M;
    @BindView(R.id.pcv1M01)
    RadioButton pcv1M01;
    @BindView(R.id.pcv1M02)
    RadioButton pcv1M02;
    @BindView(R.id.fldGrpPcv1MCheck)
    LinearLayout fldGrpPcv1MCheck;
    @BindView(R.id.pcv1datenr)
    CheckBox pcv1datenr;
    @BindView(R.id.fldGrppcv1MDate)
    LinearLayout fldGrppcv1MDate;
    @BindView(R.id.pcv1DateM_year)
    EditText pcv1DateMYear;
    @BindView(R.id.pcv1DateM_mon)
    EditText pcv1DateMMon;
    @BindView(R.id.fldGrppcv1C)
    LinearLayout fldGrppcv1C;
    @BindView(R.id.pcv1C)
    RadioGroup pcv1C;
    @BindView(R.id.pcv1C01)
    RadioButton pcv1C01;
    @BindView(R.id.pcv1C02)
    RadioButton pcv1C02;
    @BindView(R.id.fldGrpPcv1CCheck)
    LinearLayout fldGrpPcv1CCheck;
    @BindView(R.id.pcv1datenp)
    CheckBox pcv1datenp;
    @BindView(R.id.fldGrpPcv1CDate)
    LinearLayout fldGrpPcv1CDate;
    @BindView(R.id.text5)
    TextView text5;
    @BindView(R.id.pcv1Date)
    DatePickerInputEditText pcv1Date;
    @BindView(R.id.fldGrpov5)
    LinearLayout fldGrpov5;
    @BindView(R.id.pcv1Pov)
    RadioGroup pcv1Pov;
    public RadioGroup.OnCheckedChangeListener pcv1 = new OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {


            if (radioGroup == pcv1C) {
                if (pcv1C01.isChecked()) {
                    fldGrpPcv1CCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpPcv1CCheck.setVisibility(View.GONE);
                    pcv1Date.setText(null);
                    pcv1datenp.setChecked(false);
                }
            }

            if (radioGroup == pcv1M) {
                if (pcv1M01.isChecked()) {
                    fldGrpPcv1MCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpPcv1MCheck.setVisibility(View.GONE);
                    pcv1DateMYear.setText(null);
                    pcv1DateMMon.setText(null);
                    pcv1datenr.setChecked(false);
                }
            }


            if (pcv1M01.isChecked() || pcv1C01.isChecked()) {
                fldGrpov5.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
                sc5.setLayoutParams(params);

            } else if (pcv1C02.isChecked() || pcv1M02.isChecked()) {
                fldGrpov5.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                sc5.setLayoutParams(params);
                pcv1Pov.clearCheck();

            }
        }
    };
    @BindView(R.id.pcv1Pova)
    RadioButton pcv1Pova;
    @BindView(R.id.pcv1Povb)
    RadioButton pcv1Povb;
    @BindView(R.id.pcv1Povc)
    RadioButton pcv1Povc;
    @BindView(R.id.pcv1Povd)
    RadioButton pcv1Povd;
    @BindView(R.id.pcv1Pove)
    RadioButton pcv1Pove;
    @BindView(R.id.pcv1Povf)
    RadioButton pcv1Povf;
    @BindView(R.id.pcv1Povg)
    RadioButton pcv1Povg;
    @BindView(R.id.pcv1Povh)
    RadioButton pcv1Povh;
    @BindView(R.id.sc10wks)
    NestedScrollView sc10wks;
    @BindView(R.id.sc6)
    NestedScrollView sc6;
    @BindView(R.id.fldGrpopv2M)
    LinearLayout fldGrpopv2M;
    @BindView(R.id.opv2M)
    RadioGroup opv2M;
    @BindView(R.id.opv2M01)
    RadioButton opv2M01;
    @BindView(R.id.opv2M02)
    RadioButton opv2M02;
    @BindView(R.id.fldGrpOpv2MCheck)
    LinearLayout fldGrpOpv2MCheck;
    @BindView(R.id.opv2datenr)
    CheckBox opv2datenr;
    @BindView(R.id.fldGrpopv2MDate)
    LinearLayout fldGrpopv2MDate;
    @BindView(R.id.opv2DateM_year)
    EditText opv2DateMYear;
    @BindView(R.id.opv2DateM_mon)
    EditText opv2DateMMon;
    @BindView(R.id.fldGrpopv2C)
    LinearLayout fldGrpopv2C;
    @BindView(R.id.opv2C)
    RadioGroup opv2C;
    @BindView(R.id.opv2C01)
    RadioButton opv2C01;
    @BindView(R.id.opv2C02)
    RadioButton opv2C02;
    @BindView(R.id.fldGrpOpv2CCheck)
    LinearLayout fldGrpOpv2CCheck;
    @BindView(R.id.opv2datenp)
    CheckBox opv2datenp;
    @BindView(R.id.fldGrpOpv2CDate)
    LinearLayout fldGrpOpv2CDate;
    @BindView(R.id.text6)
    TextView text6;
    @BindView(R.id.opv2Date)
    DatePickerInputEditText opv2Date;
    @BindView(R.id.fldGrpov6)
    LinearLayout fldGrpov6;
    @BindView(R.id.opv2Pov)
    RadioGroup opv2Pov;
    public RadioGroup.OnCheckedChangeListener opv2 = new OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

            if (radioGroup == opv2C) {
                if (opv2C01.isChecked()) {
                    fldGrpOpv2CCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpOpv2CCheck.setVisibility(View.GONE);
                    opv2Date.setText(null);
                    opv2datenp.setChecked(false);
                }
            }

            if (radioGroup == opv2M) {
                if (opv2M01.isChecked()) {
                    fldGrpOpv2MCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpOpv2MCheck.setVisibility(View.GONE);
                    opv2DateMYear.setText(null);
                    opv2DateMMon.setText(null);
                    opv2datenr.setChecked(false);
                }
            }

            if (opv2M01.isChecked() || opv2C01.isChecked()) {
                fldGrpov6.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
                sc6.setLayoutParams(params);
            } else if (opv2C02.isChecked() || opv2M02.isChecked()) {
                fldGrpov6.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                sc6.setLayoutParams(params);
                opv2Pov.clearCheck();

            }
        }
    };
    @BindView(R.id.opv2Pova)
    RadioButton opv2Pova;
    @BindView(R.id.opv2Povb)
    RadioButton opv2Povb;
    @BindView(R.id.opv2Povc)
    RadioButton opv2Povc;
    @BindView(R.id.opv2Povd)
    RadioButton opv2Povd;
    @BindView(R.id.opv2Pove)
    RadioButton opv2Pove;
    @BindView(R.id.opv2Povf)
    RadioButton opv2Povf;
    @BindView(R.id.opv2Povg)
    RadioButton opv2Povg;
    @BindView(R.id.opv2Povh)
    RadioButton opv2Povh;
    @BindView(R.id.sc7)
    NestedScrollView sc7;
    @BindView(R.id.fldGrppenta2M)
    LinearLayout fldGrppenta2M;
    @BindView(R.id.penta2M)
    RadioGroup penta2M;
    @BindView(R.id.penta2M01)
    RadioButton penta2M01;
    @BindView(R.id.penta2M02)
    RadioButton penta2M02;
    @BindView(R.id.fldGrppenta2MCheck)
    LinearLayout fldGrppenta2MCheck;
    @BindView(R.id.penta2datenr)
    CheckBox penta2datenr;
    @BindView(R.id.fldGrppenta2MDate)
    LinearLayout fldGrppenta2MDate;
    @BindView(R.id.penta2DateM_year)
    EditText penta2DateMYear;
    @BindView(R.id.penta2DateM_mon)
    EditText penta2DateMMon;
    @BindView(R.id.fldGrppenta2C)
    LinearLayout fldGrppenta2C;
    @BindView(R.id.penta2C)
    RadioGroup penta2C;
    @BindView(R.id.penta2C01)
    RadioButton penta2C01;
    @BindView(R.id.penta2C02)
    RadioButton penta2C02;
    @BindView(R.id.fldGrpPenta2CCheck)
    LinearLayout fldGrpPenta2CCheck;
    @BindView(R.id.penta2datenp)
    CheckBox penta2datenp;
    @BindView(R.id.fldGrpPenta2CDate)
    LinearLayout fldGrpPenta2CDate;
    @BindView(R.id.text7)
    TextView text7;
    @BindView(R.id.penta2Date)
    DatePickerInputEditText penta2Date;
    @BindView(R.id.fldGrpov7)
    LinearLayout fldGrpov7;
    @BindView(R.id.penta2Pov)
    RadioGroup penta2Pov;
    public RadioGroup.OnCheckedChangeListener penta2 = new OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {


            if (radioGroup == penta2C) {
                if (penta2C01.isChecked()) {
                    fldGrpPenta2CCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpPenta2CCheck.setVisibility(View.GONE);
                    penta2Date.setText(null);
                    penta2datenp.setChecked(false);
                }
            }


            if (radioGroup == penta2M) {
                if (penta2M01.isChecked()) {
                    fldGrppenta2MCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrppenta2MCheck.setVisibility(View.GONE);
                    penta2DateMYear.setText(null);
                    penta2DateMMon.setText(null);
                    penta2datenr.setChecked(false);
                }
            }
            if (penta2M01.isChecked() || penta2C01.isChecked()) {
                fldGrpov7.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
                sc7.setLayoutParams(params);
            } else if (penta2C02.isChecked() || penta2M02.isChecked()) {
                fldGrpov7.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                sc7.setLayoutParams(params);
                penta2Pov.clearCheck();

            }
        }
    };
    @BindView(R.id.penta2Pova)
    RadioButton penta2Pova;
    @BindView(R.id.penta2Povb)
    RadioButton penta2Povb;
    @BindView(R.id.penta2Povc)
    RadioButton penta2Povc;
    @BindView(R.id.penta2Povd)
    RadioButton penta2Povd;
    @BindView(R.id.penta2Pove)
    RadioButton penta2Pove;
    @BindView(R.id.penta2Povf)
    RadioButton penta2Povf;
    @BindView(R.id.penta2Povg)
    RadioButton penta2Povg;
    @BindView(R.id.penta2Povh)
    RadioButton penta2Povh;
    @BindView(R.id.sc8)
    NestedScrollView sc8;
    @BindView(R.id.fldGrppcv2M)
    LinearLayout fldGrppcv2M;
    @BindView(R.id.pcv2M)
    RadioGroup pcv2M;
    @BindView(R.id.pcv2M01)
    RadioButton pcv2M01;
    @BindView(R.id.pcv2M02)
    RadioButton pcv2M02;
    @BindView(R.id.fldGrpPcv2MCheck)
    LinearLayout fldGrpPcv2MCheck;
    @BindView(R.id.pcv2datenr)
    CheckBox pcv2datenr;
    @BindView(R.id.fldGrppcv2MDate)
    LinearLayout fldGrppcv2MDate;
    @BindView(R.id.pcv2DateM_year)
    EditText pcv2DateMYear;
    @BindView(R.id.pcv2DateM_mon)
    EditText pcv2DateMMon;
    @BindView(R.id.fldGrppcv2C)
    LinearLayout fldGrppcv2C;
    @BindView(R.id.pcv2C)
    RadioGroup pcv2C;
    @BindView(R.id.pcv2C01)
    RadioButton pcv2C01;
    @BindView(R.id.pcv2C02)
    RadioButton pcv2C02;
    @BindView(R.id.fldGrpPcv2CCheck)
    LinearLayout fldGrpPcv2CCheck;
    @BindView(R.id.pcv2datenp)
    CheckBox pcv2datenp;
    @BindView(R.id.fldGrpPcv2CDate)
    LinearLayout fldGrpPcv2CDate;
    @BindView(R.id.text8)
    TextView text8;
    @BindView(R.id.pcv2Date)
    DatePickerInputEditText pcv2Date;
    @BindView(R.id.fldGrpov8)
    LinearLayout fldGrpov8;
    @BindView(R.id.pcv2Pov)
    RadioGroup pcv2Pov;
    public RadioGroup.OnCheckedChangeListener pcv2 = new OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {


            if (radioGroup == pcv2C) {
                if (pcv2C01.isChecked()) {
                    fldGrpPcv2CCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpPcv2CCheck.setVisibility(View.GONE);
                    pcv2Date.setText(null);
                    pcv2datenp.setChecked(false);
                }
            }

            if (radioGroup == pcv2M) {

                if (pcv2M01.isChecked()) {
                    fldGrpPcv2MCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpPcv2MCheck.setVisibility(View.GONE);
                    pcv2DateMYear.setText(null);
                    pcv2DateMMon.setText(null);
                    pcv2datenr.setChecked(false);
                }
            }

            if (pcv2M01.isChecked() || pcv2C01.isChecked()) {
                fldGrpov8.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
                sc8.setLayoutParams(params);
            } else if (pcv2C02.isChecked() || pcv2M02.isChecked()) {
                fldGrpov8.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                sc8.setLayoutParams(params);
                pcv2Pov.clearCheck();

            }
        }
    };
    @BindView(R.id.pcv2Pova)
    RadioButton pcv2Pova;
    @BindView(R.id.pcv2Povb)
    RadioButton pcv2Povb;
    @BindView(R.id.pcv2Povc)
    RadioButton pcv2Povc;
    @BindView(R.id.pcv2Povd)
    RadioButton pcv2Povd;
    @BindView(R.id.pcv2Pove)
    RadioButton pcv2Pove;
    @BindView(R.id.pcv2Povf)
    RadioButton pcv2Povf;
    @BindView(R.id.pcv2Povg)
    RadioButton pcv2Povg;
    @BindView(R.id.pcv2Povh)
    RadioButton pcv2Povh;
    @BindView(R.id.sc14wks)
    NestedScrollView sc14wks;
    @BindView(R.id.sc9)
    NestedScrollView sc9;
    @BindView(R.id.fldGrpopv3M)
    LinearLayout fldGrpopv3M;
    @BindView(R.id.opv3M)
    RadioGroup opv3M;
    @BindView(R.id.opv3M01)
    RadioButton opv3M01;
    @BindView(R.id.opv3M02)
    RadioButton opv3M02;
    @BindView(R.id.fldGrpOpv3MCheck)
    LinearLayout fldGrpOpv3MCheck;
    @BindView(R.id.opv3datenr)
    CheckBox opv3datenr;
    @BindView(R.id.fldGrpopv3MDate)
    LinearLayout fldGrpopv3MDate;
    @BindView(R.id.opv3DateM_year)
    EditText opv3DateMYear;
    @BindView(R.id.opv3DateM_mon)
    EditText opv3DateMMon;
    @BindView(R.id.fldGrpopv3C)
    LinearLayout fldGrpopv3C;
    @BindView(R.id.opv3C)
    RadioGroup opv3C;
    @BindView(R.id.opv3C01)
    RadioButton opv3C01;
    @BindView(R.id.opv3C02)
    RadioButton opv3C02;
    @BindView(R.id.fldGrpOpv3CCheck)
    LinearLayout fldGrpOpv3CCheck;
    @BindView(R.id.opv3datenp)
    CheckBox opv3datenp;
    @BindView(R.id.fldGrpOpv3CDate)
    LinearLayout fldGrpOpv3CDate;
    @BindView(R.id.text9)
    TextView text9;
    @BindView(R.id.opv3Date)
    DatePickerInputEditText opv3Date;
    @BindView(R.id.fldGrpov9)
    LinearLayout fldGrpov9;
    @BindView(R.id.opv3Pov)
    RadioGroup opv3Pov;
    public RadioGroup.OnCheckedChangeListener opv3 = new OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

            if (radioGroup == opv3C) {
                if (opv3C01.isChecked()) {
                    fldGrpOpv3CCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpOpv3CCheck.setVisibility(View.GONE);
                    opv3Date.setText(null);
                    opv3datenp.setChecked(false);
                }
            }

            if (radioGroup == opv3M) {

                if (opv3M01.isChecked()) {
                    fldGrpOpv3MCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpOpv3MCheck.setVisibility(View.GONE);
                    opv3DateMYear.setText(null);
                    opv3DateMMon.setText(null);
                    opv3datenr.setChecked(false);
                }
            }
            if (opv3M01.isChecked() || opv3C01.isChecked()) {
                fldGrpov9.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
                sc9.setLayoutParams(params);
            } else if (opv3C02.isChecked() || opv3M02.isChecked()) {
                fldGrpov9.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                sc9.setLayoutParams(params);
                opv3Pov.clearCheck();

            }
        }
    };
    @BindView(R.id.opv3Pova)
    RadioButton opv3Pova;
    @BindView(R.id.opv3Povb)
    RadioButton opv3Povb;
    @BindView(R.id.opv3Povc)
    RadioButton opv3Povc;
    @BindView(R.id.opv3Povd)
    RadioButton opv3Povd;
    @BindView(R.id.opv3Pove)
    RadioButton opv3Pove;
    @BindView(R.id.opv3Povf)
    RadioButton opv3Povf;
    @BindView(R.id.opv3Povg)
    RadioButton opv3Povg;
    @BindView(R.id.opv3Povh)
    RadioButton opv3Povh;
    @BindView(R.id.sc10)
    NestedScrollView sc10;
    @BindView(R.id.fldGrpPenta3M)
    LinearLayout fldGrpPenta3M;
    @BindView(R.id.penta3M)
    RadioGroup penta3M;
    @BindView(R.id.penta3M01)
    RadioButton penta3M01;
    @BindView(R.id.penta3M02)
    RadioButton penta3M02;
    @BindView(R.id.fldGrpPenta3MCheck)
    LinearLayout fldGrpPenta3MCheck;
    @BindView(R.id.penta3datenr)
    CheckBox penta3datenr;
    @BindView(R.id.fldGrppenta3MDate)
    LinearLayout fldGrppenta3MDate;
    @BindView(R.id.penta3DateM_year)
    EditText penta3DateMYear;
    @BindView(R.id.penta3DateM_mon)
    EditText penta3DateMMon;
    @BindView(R.id.fldGrpenta3C)
    LinearLayout fldGrpenta3C;
    @BindView(R.id.penta3C)
    RadioGroup penta3C;
    @BindView(R.id.penta3C01)
    RadioButton penta3C01;
    @BindView(R.id.penta3C02)
    RadioButton penta3C02;
    @BindView(R.id.fldGrppenta3CCheck)
    LinearLayout fldGrppenta3CCheck;
    @BindView(R.id.penta3datenp)
    CheckBox penta3datenp;
    @BindView(R.id.fldGrpPenta3CDate)
    LinearLayout fldGrpPenta3CDate;
    @BindView(R.id.text10)
    TextView text10;
    @BindView(R.id.penta3Date)
    DatePickerInputEditText penta3Date;
    @BindView(R.id.fldGrpov10)
    LinearLayout fldGrpov10;
    @BindView(R.id.penta3Pov)
    RadioGroup penta3Pov;
    public RadioGroup.OnCheckedChangeListener penta3 = new OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {


            if (radioGroup == penta3C) {
                if (penta3C01.isChecked()) {
                    fldGrppenta3CCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrppenta3CCheck.setVisibility(View.GONE);
                    penta3Date.setText(null);
                    penta3datenp.setChecked(false);
                }
            }

            if (radioGroup == penta3M) {

                if (penta3M01.isChecked()) {
                    fldGrpPenta3MCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpPenta3MCheck.setVisibility(View.GONE);
                    penta3DateMYear.setText(null);
                    penta3DateMMon.setText(null);
                    penta3datenr.setChecked(false);
                }
            }

            if (penta3M01.isChecked() || penta3C01.isChecked()) {
                fldGrpov10.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
                sc10.setLayoutParams(params);
            } else if (penta3C02.isChecked() || penta3M02.isChecked()) {
                fldGrpov10.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                sc10.setLayoutParams(params);
                penta3Pov.clearCheck();

            }
        }
    };
    @BindView(R.id.penta3Pova)
    RadioButton penta3Pova;
    @BindView(R.id.penta3Povb)
    RadioButton penta3Povb;
    @BindView(R.id.penta3Povc)
    RadioButton penta3Povc;
    @BindView(R.id.penta3Povd)
    RadioButton penta3Povd;
    @BindView(R.id.penta3Pove)
    RadioButton penta3Pove;
    @BindView(R.id.penta3Povf)
    RadioButton penta3Povf;
    @BindView(R.id.penta3Povg)
    RadioButton penta3Povg;
    @BindView(R.id.penta3Povh)
    RadioButton penta3Povh;
    @BindView(R.id.sc11)
    NestedScrollView sc11;
    @BindView(R.id.fldGrppcv3M)
    LinearLayout fldGrppcv3M;
    @BindView(R.id.pcv3M)
    RadioGroup pcv3M;
    @BindView(R.id.pcv3M01)
    RadioButton pcv3M01;
    @BindView(R.id.pcv3M02)
    RadioButton pcv3M02;
    @BindView(R.id.fldGrpPcv3MCheck)
    LinearLayout fldGrpPcv3MCheck;
    @BindView(R.id.pcv3datenr)
    CheckBox pcv3datenr;
    @BindView(R.id.fldGrppcv3MDate)
    LinearLayout fldGrppcv3MDate;
    @BindView(R.id.pcv3DateM_year)
    EditText pcv3DateMYear;
    @BindView(R.id.pcv3DateM_mon)
    EditText pcv3DateMMon;
    @BindView(R.id.fldGrppcv3C)
    LinearLayout fldGrppcv3C;
    @BindView(R.id.pcv3C)
    RadioGroup pcv3C;
    @BindView(R.id.pcv3C01)
    RadioButton pcv3C01;
    @BindView(R.id.pcv3C02)
    RadioButton pcv3C02;
    @BindView(R.id.fldGrpPcv3CCheck)
    LinearLayout fldGrpPcv3CCheck;
    @BindView(R.id.pcv3datenp)
    CheckBox pcv3datenp;
    @BindView(R.id.fldGrpPcv3CDate)
    LinearLayout fldGrpPcv3CDate;
    @BindView(R.id.text11)
    TextView text11;
    @BindView(R.id.pcv3Date)
    DatePickerInputEditText pcv3Date;
    @BindView(R.id.fldGrpov11)
    LinearLayout fldGrpov11;
    @BindView(R.id.pcv3Pov)
    RadioGroup pcv3Pov;
    public RadioGroup.OnCheckedChangeListener pcv3 = new OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {


            if (radioGroup == pcv3C) {
                if (pcv3C01.isChecked()) {
                    fldGrpPcv3CCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpPcv3CCheck.setVisibility(View.GONE);
                    pcv3Date.setText(null);
                    pcv3datenp.setChecked(false);
                }
            }

            if (radioGroup == pcv3M) {

                if (pcv3M01.isChecked()) {
                    fldGrpPcv3MCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpPcv3MCheck.setVisibility(View.GONE);
                    pcv3DateMYear.setText(null);
                    pcv3DateMMon.setText(null);
                    pcv3datenr.setChecked(false);
                }
            }


            if (pcv3M01.isChecked() || pcv3C01.isChecked()) {
                fldGrpov11.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
                sc11.setLayoutParams(params);
            } else if (pcv3C02.isChecked() || pcv3M02.isChecked()) {
                fldGrpov11.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                sc11.setLayoutParams(params);
                pcv3Pov.clearCheck();

            }
        }
    };
    @BindView(R.id.pcv3Pova)
    RadioButton pcv3Pova;
    @BindView(R.id.pcv3Povb)
    RadioButton pcv3Povb;
    @BindView(R.id.pcv3Povc)
    RadioButton pcv3Povc;
    @BindView(R.id.pcv3Povd)
    RadioButton pcv3Povd;
    @BindView(R.id.pcv3Pove)
    RadioButton pcv3Pove;
    @BindView(R.id.pcv3Povf)
    RadioButton pcv3Povf;
    @BindView(R.id.pcv3Povg)
    RadioButton pcv3Povg;
    @BindView(R.id.pcv3Povh)
    RadioButton pcv3Povh;
    @BindView(R.id.sc12)
    NestedScrollView sc12;
    @BindView(R.id.fldGrpipvM)
    LinearLayout fldGrpipvM;
    @BindView(R.id.ipvM)
    RadioGroup ipvM;
    @BindView(R.id.ipvM01)
    RadioButton ipvM01;
    @BindView(R.id.ipvM02)
    RadioButton ipvM02;
    @BindView(R.id.fldGrpIpvMCheck)
    LinearLayout fldGrpIpvMCheck;
    @BindView(R.id.ipvdatenr)
    CheckBox ipvdatenr;
    @BindView(R.id.fldGrpipvMDate)
    LinearLayout fldGrpipvMDate;
    @BindView(R.id.ipvDateM_year)
    EditText ipvDateMYear;
    @BindView(R.id.ipvDateM_mon)
    EditText ipvDateMMon;
    @BindView(R.id.fldGrpipvC)
    LinearLayout fldGrpipvC;
    @BindView(R.id.ipvC)
    RadioGroup ipvC;
    @BindView(R.id.ipvC01)
    RadioButton ipvC01;
    @BindView(R.id.ipvC02)
    RadioButton ipvC02;
    @BindView(R.id.fldGrpIpvCCheck)
    LinearLayout fldGrpIpvCCheck;
    @BindView(R.id.ipvdatenp)
    CheckBox ipvdatenp;
    @BindView(R.id.fldGrpIpvCDate)
    LinearLayout fldGrpIpvCDate;
    @BindView(R.id.text12)
    TextView text12;
    @BindView(R.id.ipvDate)
    DatePickerInputEditText ipvDate;
    @BindView(R.id.fldGrpov12)
    LinearLayout fldGrpov12;
    @BindView(R.id.ipvPov)
    RadioGroup ipvPov;
    public RadioGroup.OnCheckedChangeListener ipv = new OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {


            if (radioGroup == ipvC) {
                if (ipvC01.isChecked()) {
                    fldGrpIpvCCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpIpvCCheck.setVisibility(View.GONE);
                    ipvDate.setText(null);
                    ipvdatenp.setChecked(false);
                }
            }

            if (radioGroup == ipvM) {

                if (ipvM01.isChecked()) {
                    fldGrpIpvMCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpIpvMCheck.setVisibility(View.GONE);
                    ipvDateMYear.setText(null);
                    ipvDateMMon.setText(null);
                    ipvdatenr.setChecked(false);
                }
            }


            if (ipvM01.isChecked() || ipvC01.isChecked()) {
                fldGrpov12.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
                sc10.setLayoutParams(params);
            } else if (ipvC02.isChecked() || ipvM02.isChecked()) {
                fldGrpov12.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                sc12.setLayoutParams(params);
                ipvPov.clearCheck();

            }
        }
    };
    @BindView(R.id.ipvPova)
    RadioButton ipvPova;
    @BindView(R.id.ipvPovb)
    RadioButton ipvPovb;
    @BindView(R.id.ipvPovc)
    RadioButton ipvPovc;
    @BindView(R.id.ipvPovd)
    RadioButton ipvPovd;
    @BindView(R.id.ipvPove)
    RadioButton ipvPove;
    @BindView(R.id.ipvPovf)
    RadioButton ipvPovf;
    @BindView(R.id.ipvPovg)
    RadioButton ipvPovg;
    @BindView(R.id.ipvPovh)
    RadioButton ipvPovh;
    @BindView(R.id.sc9M)
    NestedScrollView sc9M;
    @BindView(R.id.sc13)
    NestedScrollView sc13;
    @BindView(R.id.fldGrpMeasles1M)
    LinearLayout fldGrpMeasles1M;
    @BindView(R.id.measles1M)
    RadioGroup measles1M;
    @BindView(R.id.measles1M01)
    RadioButton measles1M01;
    @BindView(R.id.measles1M02)
    RadioButton measles1M02;
    @BindView(R.id.fldGrpmeasles1MCheck)
    LinearLayout fldGrpmeasles1MCheck;
    @BindView(R.id.measles1datenr)
    CheckBox measles1datenr;
    @BindView(R.id.fldGrpmeasles1MDate)
    LinearLayout fldGrpmeasles1MDate;
    @BindView(R.id.measles1DateM_year)
    EditText measles1DateMYear;
    @BindView(R.id.measles1DateM_mon)
    EditText measles1DateMMon;
    @BindView(R.id.fldGrpmeasles1C)
    LinearLayout fldGrpmeasles1C;
    @BindView(R.id.measles1C)
    RadioGroup measles1C;
    @BindView(R.id.measles1C01)
    RadioButton measles1C01;
    @BindView(R.id.measles1C02)
    RadioButton measles1C02;
    @BindView(R.id.fldGrpMeasles1CCheck)
    LinearLayout fldGrpMeasles1CCheck;
    @BindView(R.id.measles1datenp)
    CheckBox measles1datenp;
    @BindView(R.id.fldGrpMeasles1CDate)
    LinearLayout fldGrpMeasles1CDate;
    @BindView(R.id.text13)
    TextView text13;
    @BindView(R.id.measles1Date)
    DatePickerInputEditText measles1Date;
    @BindView(R.id.fldGrpov13)
    LinearLayout fldGrpov13;
    @BindView(R.id.measles1Pov)
    RadioGroup measles1Pov;
    public RadioGroup.OnCheckedChangeListener measles1 = new OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {


            if (radioGroup == measles1C) {
                if (measles1C01.isChecked()) {
                    fldGrpMeasles1CCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpMeasles1CCheck.setVisibility(View.GONE);
                    measles1Date.setText(null);
                    measles1datenp.setChecked(false);
                }
            }

            if (radioGroup == measles1M) {

                if (measles1M01.isChecked()) {
                    fldGrpmeasles1MCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpmeasles1MCheck.setVisibility(View.GONE);
                    measles1DateMYear.setText(null);
                    measles1DateMMon.setText(null);
                    measles1datenr.setChecked(false);
                }
            }

            if (measles1M01.isChecked() || measles1C01.isChecked()) {
                fldGrpov13.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
                sc13.setLayoutParams(params);
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1000);
                sc9M.setLayoutParams(params2);
            } else if (measles1C02.isChecked() || measles1M02.isChecked()) {
                fldGrpov13.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                sc13.setLayoutParams(params);
                sc9M.setLayoutParams(params);
                measles1Pov.clearCheck();

            }
        }
    };
    @BindView(R.id.measles1Pova)
    RadioButton measles1Pova;
    @BindView(R.id.measles1Povb)
    RadioButton measles1Povb;
    @BindView(R.id.measles1Povc)
    RadioButton measles1Povc;
    @BindView(R.id.measles1Povd)
    RadioButton measles1Povd;
    @BindView(R.id.measles1Pove)
    RadioButton measles1Pove;
    @BindView(R.id.measles1Povf)
    RadioButton measles1Povf;
    @BindView(R.id.measles1Povg)
    RadioButton measles1Povg;
    @BindView(R.id.measles1Povh)
    RadioButton measles1Povh;
    @BindView(R.id.sc15M)
    NestedScrollView sc15M;
    @BindView(R.id.sc14)
    NestedScrollView sc14;
    @BindView(R.id.fldGrpMeasles2M)
    LinearLayout fldGrpMeasles2M;
    @BindView(R.id.measles2M)
    RadioGroup measles2M;
    @BindView(R.id.measles2M01)
    RadioButton measles2M01;
    @BindView(R.id.measles2M02)
    RadioButton measles2M02;
    @BindView(R.id.fldGrpmeasles2MCheck)
    LinearLayout fldGrpmeasles2MCheck;
    @BindView(R.id.measles2datenr)
    CheckBox measles2datenr;
    @BindView(R.id.fldGrpmeasles2MDate)
    LinearLayout fldGrpmeasles2MDate;
    @BindView(R.id.measles2DateM_year)
    EditText measles2DateMYear;
    @BindView(R.id.measles2DateM_mon)
    EditText measles2DateMMon;
    @BindView(R.id.fldGrpmeasles2C)
    LinearLayout fldGrpmeasles2C;
    @BindView(R.id.measles2C)
    RadioGroup measles2C;
    @BindView(R.id.measles2C01)
    RadioButton measles2C01;
    @BindView(R.id.measles2C02)
    RadioButton measles2C02;
    @BindView(R.id.fldGrpMeasles2CCheck)
    LinearLayout fldGrpMeasles2CCheck;
    @BindView(R.id.measles2datenp)
    CheckBox measles2datenp;
    @BindView(R.id.fldGrpMeasles2CDate)
    LinearLayout fldGrpMeasles2CDate;
    @BindView(R.id.text14)
    TextView text14;
    @BindView(R.id.measles2Date)
    DatePickerInputEditText measles2Date;
    @BindView(R.id.fldGrpov14)
    LinearLayout fldGrpov14;
    @BindView(R.id.measles2Pov)
    RadioGroup measles2Pov;
    public RadioGroup.OnCheckedChangeListener measles2 = new OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {


            if (radioGroup == measles2C) {
                if (measles2C01.isChecked()) {
                    fldGrpMeasles2CCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpMeasles2CCheck.setVisibility(View.GONE);
                    measles2Date.setText(null);
                    measles2datenp.setChecked(false);
                }
            }

            if (radioGroup == measles2M) {

                if (measles2M01.isChecked()) {
                    fldGrpmeasles2MCheck.setVisibility(View.VISIBLE);
                } else {
                    fldGrpmeasles2MCheck.setVisibility(View.GONE);
                    measles2DateMYear.setText(null);
                    measles2DateMMon.setText(null);
                    measles2datenr.setChecked(false);
                }
            }

            if (measles2M01.isChecked() || measles2C01.isChecked()) {
                fldGrpov14.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900);
                sc14.setLayoutParams(params);
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1000);
                sc15M.setLayoutParams(params2);
            } else if (measles2C02.isChecked() || measles2M02.isChecked()) {
                fldGrpov14.setVisibility(View.GONE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                sc14.setLayoutParams(params);
                sc15M.setLayoutParams(params);
                measles2Pov.clearCheck();

            }
        }
    };
    @BindView(R.id.measles2Pova)
    RadioButton measles2Pova;
    @BindView(R.id.measles2Povb)
    RadioButton measles2Povb;
    @BindView(R.id.measles2Povc)
    RadioButton measles2Povc;
    @BindView(R.id.measles2Povd)
    RadioButton measles2Povd;
    @BindView(R.id.measles2Pove)
    RadioButton measles2Pove;
    @BindView(R.id.measles2Povf)
    RadioButton measles2Povf;
    @BindView(R.id.measles2Povg)
    RadioButton measles2Povg;
    @BindView(R.id.measles2Povh)
    RadioButton measles2Povh;
    @BindView(R.id.ti04)
    RadioGroup ti04;
    @BindView(R.id.ti04a)
    RadioButton ti04a;
    @BindView(R.id.ti04b)
    RadioButton ti04b;
    @BindView(R.id.ti04888)
    RadioButton ti04888;
    @BindView(R.id.fldGrpti05)
    LinearLayout fldGrpti05;
    @BindView(R.id.ti05)
    EditText ti05;
    @BindView(R.id.ti05888)
    CheckBox ti05888;
    @BindViews({R.id.bcgDate, R.id.opv0Date, R.id.opv1Date, R.id.penta1Date, R.id.pcv1Date, R.id.opv2Date, R.id.penta2Date
            , R.id.pcv2Date, R.id.opv3Date, R.id.penta3Date, R.id.pcv3Date, R.id.ipvDate, R.id.measles1Date, R.id.measles2Date})
    List<DatePickerInputEditText> dates;
    @BindViews({R.id.text1, R.id.text2, R.id.text3, R.id.text4, R.id.text5, R.id.text6, R.id.text7
            , R.id.text8, R.id.text9, R.id.text10, R.id.text11, R.id.text12, R.id.text13, R.id.text14})
    List<TextView> datesText;
    @BindViews({R.id.fldGrpBcgC, R.id.fldGrpopv0C, R.id.fldGrpPenta1C, R.id.fldGrppcv1C, R.id.fldGrpopv1C, R.id.fldGrppenta2C,
            R.id.fldGrppcv2C, R.id.fldGrpopv2C, R.id.fldGrpenta3C, R.id.fldGrppcv3C, R.id.fldGrpopv3C, R.id.fldGrpipvC,
            R.id.fldGrpmeasles1C, R.id.fldGrpmeasles2C})
    List<LinearLayout> fldGrpCard;
    @BindViews({R.id.fldGrpBcgM, R.id.fldGrpOpv0M, R.id.fldGrpPenta1M, R.id.fldGrppcv1M, R.id.fldGrpopv1M, R.id.fldGrppenta2M,
            R.id.fldGrppcv2M, R.id.fldGrpopv2M, R.id.fldGrpPenta3M, R.id.fldGrppcv3M, R.id.fldGrpopv3M, R.id.fldGrpipvM,
            R.id.fldGrpMeasles1M, R.id.fldGrpMeasles2M})
    List<LinearLayout> fldGrpMother;
    @BindViews({R.id.bcgC, R.id.opv0C, R.id.penta1C, R.id.pcv1C, R.id.opv1C, R.id.penta2C, R.id.pcv2C, R.id.opv2C, R.id.penta3C,
            R.id.pcv3C, R.id.opv3C, R.id.ipvC, R.id.measles1C, R.id.measles2C})
    List<RadioGroup> rdoCard;
    @BindViews({R.id.bcgC, R.id.bcgM, R.id.opv0C, R.id.opv0M, R.id.penta1C, R.id.penta1M, R.id.pcv1C, R.id.pcv1M,
            R.id.opv1C, R.id.opv1M, R.id.penta2C, R.id.pcv2C, R.id.pcv2M, R.id.opv2C, R.id.opv2M, R.id.penta3C, R.id.penta3M,
            R.id.pcv3C, R.id.pcv3M, R.id.opv3C, R.id.opv3M, R.id.ipvC, R.id.ipvM, R.id.measles1C, R.id.measles1M,
            R.id.measles2C, R.id.measles2M})
    List<RadioGroup> rdoAll;
    @BindViews({R.id.bcgPov, R.id.opv0Pov, R.id.penta1Pov, R.id.pcv1Pov, R.id.opv1Pov, R.id.penta2Pov, R.id.pcv2Pov, R.id.opv2Pov,
            R.id.penta3Pov, R.id.pcv3Pov, R.id.opv3Pov, R.id.ipvPov, R.id.measles1Pov, R.id.measles2Pov})
    List<RadioGroup> placeofVacc;
    @BindViews({R.id.bcgC, R.id.bcgM})
    List<RadioGroup> grpBcg;
    @BindViews({R.id.opv0C, R.id.opv0M})
    List<RadioGroup> grpOpv0;
    @BindViews({R.id.penta1C, R.id.penta1M})
    List<RadioGroup> grpPenta1;
    @BindViews({R.id.pcv1C, R.id.pcv1M})
    List<RadioGroup> grpPcv1;
    @BindViews({R.id.opv1C, R.id.opv1M})
    List<RadioGroup> grpOpv1;
    @BindViews({R.id.penta2C, R.id.penta2M})
    List<RadioGroup> grpPenta2;
    @BindViews({R.id.pcv2C, R.id.pcv2M})
    List<RadioGroup> grpPcv2;
    @BindViews({R.id.opv2C, R.id.opv2M})
    List<RadioGroup> grpOpv2;
    @BindViews({R.id.penta3C, R.id.penta3M})
    List<RadioGroup> grpPenta3;
    @BindViews({R.id.pcv3C, R.id.pcv3M})
    List<RadioGroup> grpPcv3;
    @BindViews({R.id.opv3C, R.id.opv3M})
    List<RadioGroup> grpOpv3;
    @BindViews({R.id.ipvC, R.id.ipvM})
    List<RadioGroup> grpIpv;
    @BindViews({R.id.measles1C, R.id.measles1M})
    List<RadioGroup> grpMeasles1;
    @BindViews({R.id.measles2C, R.id.measles2M})
    List<RadioGroup> grpMeasles2;
    String maxDate2Years;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_i);
        ButterKnife.bind(this);
        maxDate2Years = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() - ((MainApp.MILLISECONDS_IN_2Years) + MainApp.MILLISECONDS_IN_DAY));


        //        get data from sec B

        if (MainApp.flag) {


            MainApp.childsMap.put("....", null);
            MainApp.lstChild.add("....");

            for (byte i = 0; i < MainApp.familyMembersList.size(); i++) {
                if (MainApp.familyMembersList.get(i).getAgeLess5().equals("3")) {
                    MainApp.childsMap.put(MainApp.familyMembersList.get(i).getName(), new FamilyMembersContract(MainApp.familyMembersList.get(i)));
                    MainApp.lstChild.add(MainApp.familyMembersList.get(i).getName());

                }
            }


        }
        tiname.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, MainApp.lstChild));

        tiname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                MainApp.positionIm = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        String dateToday = new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis());

        for (DatePickerInputEditText de : dates) {
            de.setManager(getSupportFragmentManager());
            de.setMaxDate(dateToday);


        }


        ti03.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (ti03a.isChecked()) {
                    for (DatePickerInputEditText de : dates) {
                        de.setVisibility(View.VISIBLE);
                        if (MainApp.ageRdo == 1 && (!tiname.getSelectedItem().equals("...."))) {
                            de.setMinDate(MainApp.convertDateFormat(MainApp.childsMap.get(tiname.getSelectedItem()).getDob()));
                        } else if (MainApp.ageRdo == 2 && (!tiname.getSelectedItem().equals("...."))) {
                            de.setMinDate(maxDate2Years);
                        }
                    }
                    for (LinearLayout le : fldGrpCard) {
                        le.setVisibility(View.VISIBLE);
                    }
                    for (TextView te : datesText) {
                        te.setVisibility(View.VISIBLE);
                    }
                    for (LinearLayout le : fldGrpMother) {
                        le.setVisibility(View.VISIBLE);
                    }
                } else {

                    for (LinearLayout le : fldGrpCard) {
                        le.setVisibility(View.GONE);
                        for (RadioGroup re : rdoCard) {
                            re.clearCheck();
                        }

                        for (DatePickerInputEditText de : dates) {
                            de.setVisibility(View.GONE);
                            de.setText(null);
                        }
                        for (TextView te : datesText) {
                            te.setVisibility(View.GONE);
                        }
                    }
                    for (LinearLayout le : fldGrpMother) {
                        le.setVisibility(View.VISIBLE);
                    }

                }
            }
        });


        ti01.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (ti01a.isChecked()) {
                    fldGrpti02.setVisibility(View.GONE);
                    ti02a.setChecked(false);
                    ti02b.setChecked(false);
                    ti02c.setChecked(false);
                    ti02d.setChecked(false);
                    ti0288.setChecked(false);
                    ti0288x.setText(null);
                    fldGrpti03.setVisibility(View.VISIBLE);
                } else {
                    fldGrpti03.setVisibility(View.GONE);
                    for (RadioGroup re : rdoAll) {
                        re.clearCheck();
                    }
                    for (DatePickerInputEditText de : dates) {
                        de.setText(null);
                    }

                    for (RadioGroup re : placeofVacc) {
                        re.clearCheck();
                    }
                    fldGrpti02.setVisibility(View.VISIBLE);

                }
            }
        });

        ti0288.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ti0288x.setVisibility(View.VISIBLE);
                    ti0288x.requestFocus();
                } else {
                    ti0288x.setVisibility(View.GONE);
                    ti0288x.setText(null);
                }
            }
        });


        ti04.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (ti04a.isChecked()) {
                    fldGrpti05.setVisibility(View.VISIBLE);
                    ti05.requestFocus();
                } else {
                    ti05.setText(null);
                    ti05888.setChecked(false);
                    fldGrpti05.setVisibility(View.GONE);
                }
            }
        });


        ti05888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ti05.setVisibility(View.GONE);
                    ti05.setText(null);
                } else {
                    ti05.setVisibility(View.VISIBLE);
                    ti05.requestFocus();
                }
            }
        });

        //================= Individual Skip Patterns of Vaccines=============

        // BCG
        for (RadioGroup rd : grpBcg) {
            rd.setOnCheckedChangeListener(bcg);
        }

        // Opv - 0

        for (RadioGroup rd : grpOpv0) {
            rd.setOnCheckedChangeListener(opv0);
        }

        // OPV1
        for (RadioGroup rd : grpOpv1) {
            rd.setOnCheckedChangeListener(opv1);
        }

        // Penta1
        for (RadioGroup rd : grpPenta1) {
            rd.setOnCheckedChangeListener(penta1);

        }

        // PCV1
        for (RadioGroup rd : grpPcv1) {
            rd.setOnCheckedChangeListener(pcv1);
        }

        // OPV2
        for (RadioGroup rd : grpOpv2) {
            rd.setOnCheckedChangeListener(opv2);
        }

        // Penta2
        for (RadioGroup rd : grpPenta2) {
            rd.setOnCheckedChangeListener(penta2);

        }

        // PCV2
        for (RadioGroup rd : grpPcv2) {
            rd.setOnCheckedChangeListener(pcv2);
        }


        // OPV3
        for (RadioGroup rd : grpOpv3) {
            rd.setOnCheckedChangeListener(opv3);
        }

        // Penta3
        for (RadioGroup rd : grpPenta3) {
            rd.setOnCheckedChangeListener(penta3);

        }

        // PCV3
        for (RadioGroup rd : grpPcv3) {
            rd.setOnCheckedChangeListener(pcv3);
        }

        // IPV
        for (RadioGroup rd : grpIpv) {
            rd.setOnCheckedChangeListener(ipv);
        }


        // Measles 1

        for (RadioGroup rd : grpMeasles1) {
            rd.setOnCheckedChangeListener(measles1);
        }

        // Measles 2
        for (RadioGroup rd : grpMeasles2) {
            rd.setOnCheckedChangeListener(measles2);
        }

        bcgdatenr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpbcgMDate.setVisibility(View.GONE);
                    bcgDateMMon.setText(null);
                    bcgDateMYear.setText(null);
                } else {
                    fldGrpbcgMDate.setVisibility(View.VISIBLE);
                }
            }
        });

        bcgdatenp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpBcgCDate.setVisibility(View.GONE);
                    bcgDate.setText(null);
                } else {
                    fldGrpBcgCDate.setVisibility(View.VISIBLE);
                }
            }
        });

        opv0datenr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpopv0MDate.setVisibility(View.GONE);
                    opv0DateMMon.setText(null);
                    opv0DateMYear.setText(null);
                } else {
                    fldGrpopv0MDate.setVisibility(View.VISIBLE);
                }
            }
        });

        opv0datenp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpOpv0CDate.setVisibility(View.GONE);
                    opv0Date.setText(null);
                } else {
                    fldGrpOpv0CDate.setVisibility(View.VISIBLE);
                }
            }
        });

        opv1datenr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpopv1MDate.setVisibility(View.GONE);
                    opv1DateMMon.setText(null);
                    opv1DateMYear.setText(null);
                } else {
                    fldGrpopv1MDate.setVisibility(View.VISIBLE);
                }
            }
        });

        opv1datenp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpOpv1CDate.setVisibility(View.GONE);
                    opv1Date.setText(null);
                } else {
                    fldGrpOpv1CDate.setVisibility(View.VISIBLE);
                }
            }
        });

        penta1datenr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrppenta1MDate.setVisibility(View.GONE);
                    penta1DateMMon.setText(null);
                    penta1DateMYear.setText(null);
                } else {
                    fldGrppenta1MDate.setVisibility(View.VISIBLE);
                }
            }
        });

        penta1datenp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpPenta1CDate.setVisibility(View.GONE);
                    penta1Date.setText(null);
                } else {
                    fldGrpPenta1CDate.setVisibility(View.VISIBLE);
                }
            }
        });


        pcv1datenr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrppcv1MDate.setVisibility(View.GONE);
                    pcv1DateMMon.setText(null);
                    pcv1DateMYear.setText(null);
                } else {
                    fldGrppcv1MDate.setVisibility(View.VISIBLE);
                }
            }
        });

        pcv1datenp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpPcv1CDate.setVisibility(View.GONE);
                    pcv1Date.setText(null);
                } else {
                    fldGrpPcv1CDate.setVisibility(View.VISIBLE);
                }
            }
        });

        opv2datenr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpopv2MDate.setVisibility(View.GONE);
                    opv2DateMMon.setText(null);
                    opv2DateMYear.setText(null);
                } else {
                    fldGrpopv2MDate.setVisibility(View.VISIBLE);
                }
            }
        });


        opv2datenp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpOpv2CDate.setVisibility(View.GONE);
                    opv2Date.setText(null);
                } else {
                    fldGrpOpv2CDate.setVisibility(View.VISIBLE);
                }
            }
        });

        penta2datenr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrppenta2MDate.setVisibility(View.GONE);
                    penta2DateMMon.setText(null);
                    penta2DateMYear.setText(null);
                } else {
                    fldGrppenta2MDate.setVisibility(View.VISIBLE);
                }
            }
        });

        penta2datenp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpPenta2CDate.setVisibility(View.GONE);
                    penta2Date.setText(null);
                } else {
                    fldGrpPenta2CDate.setVisibility(View.VISIBLE);
                }
            }
        });


        pcv2datenr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrppcv2MDate.setVisibility(View.GONE);
                    pcv2DateMMon.setText(null);
                    pcv2DateMYear.setText(null);
                } else {
                    fldGrppcv2MDate.setVisibility(View.VISIBLE);
                }
            }
        });

        pcv2datenp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpPcv2CDate.setVisibility(View.GONE);
                    pcv2Date.setText(null);
                } else {
                    fldGrpPcv2CDate.setVisibility(View.VISIBLE);
                }
            }
        });

        opv3datenr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpopv3MDate.setVisibility(View.GONE);
                    opv3DateMMon.setText(null);
                    opv3DateMYear.setText(null);
                } else {
                    fldGrpopv3MDate.setVisibility(View.VISIBLE);
                }
            }
        });


        opv3datenp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpOpv3CDate.setVisibility(View.GONE);
                    opv3Date.setText(null);
                } else {
                    fldGrpOpv3CDate.setVisibility(View.VISIBLE);
                }
            }
        });

        penta3datenr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrppenta3MDate.setVisibility(View.GONE);
                    penta3DateMMon.setText(null);
                    penta3DateMYear.setText(null);
                } else {
                    fldGrppenta3MDate.setVisibility(View.VISIBLE);
                }
            }
        });

        penta3datenp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpPenta3CDate.setVisibility(View.GONE);
                    penta3Date.setText(null);
                } else {
                    fldGrpPenta3CDate.setVisibility(View.VISIBLE);
                }
            }
        });


        pcv3datenr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrppcv3MDate.setVisibility(View.GONE);
                    pcv3DateMMon.setText(null);
                    pcv3DateMYear.setText(null);
                } else {
                    fldGrppcv3MDate.setVisibility(View.VISIBLE);
                }
            }
        });

        pcv3datenp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpPcv3CDate.setVisibility(View.GONE);
                    pcv3Date.setText(null);
                } else {
                    fldGrpPcv3CDate.setVisibility(View.VISIBLE);
                }
            }
        });

        ipvdatenr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpipvMDate.setVisibility(View.GONE);
                    ipvDateMMon.setText(null);
                    ipvDateMYear.setText(null);
                } else {
                    fldGrpipvMDate.setVisibility(View.VISIBLE);
                }
            }
        });

        ipvdatenp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpIpvCDate.setVisibility(View.GONE);
                    ipvDate.setText(null);
                } else {
                    fldGrpIpvCDate.setVisibility(View.VISIBLE);
                }
            }
        });

        measles1datenr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpmeasles1MDate.setVisibility(View.GONE);
                    measles1DateMMon.setText(null);
                    measles1DateMYear.setText(null);
                } else {
                    fldGrpmeasles1MDate.setVisibility(View.VISIBLE);
                }
            }
        });

        measles1datenp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpMeasles1CDate.setVisibility(View.GONE);
                    measles1Date.setText(null);
                } else {
                    fldGrpMeasles1CDate.setVisibility(View.VISIBLE);
                }
            }
        });

        measles2datenr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpmeasles2MDate.setVisibility(View.GONE);
                    measles2DateMMon.setText(null);
                    measles2DateMYear.setText(null);
                } else {
                    fldGrpmeasles2MDate.setVisibility(View.VISIBLE);
                }
            }
        });

        measles2datenp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    fldGrpMeasles2CDate.setVisibility(View.GONE);
                    measles2Date.setText(null);
                } else {
                    fldGrpMeasles2CDate.setVisibility(View.VISIBLE);
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

                //finish();

                if (MainApp.imsCount < MainApp.totalImsCount) {
                    finish();

                    MainApp.imsCount++;

                    MainApp.lstChild.remove(MainApp.positionIm);
                    MainApp.childsMap.remove(MainApp.positionIm);
                    MainApp.flag = false;
                    Intent secNext = new Intent(this, SectionIActivity.class);
                    //tiname.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, MainApp.lstChild));
                    startActivity(secNext);


                } else {
                    MainApp.imsCount = 0;

                    Intent secNext = new Intent(this, SectionJActivity.class);
                    startActivity(secNext);
                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addChild(MainApp.ims);
        MainApp.ims.set_ID(String.valueOf(updcount));

        if (updcount != -1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.ims.setUID(
                    (MainApp.fc.getDeviceID() + MainApp.ims.get_ID()));
            db.updateChildID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

        MainApp.ims = new SectionIIMContract();

        MainApp.ims.set_UUID(MainApp.fc.getUID());
        MainApp.ims.setFormDate(MainApp.fc.getFormDate());
        MainApp.ims.setDeviceId(MainApp.fc.getDeviceID());
        MainApp.ims.setUser(MainApp.fc.getUser());
        MainApp.ims.setDevicetagID(sharedPref.getString("tagName", null));

        JSONObject sI = new JSONObject();

        sI.put("ta01", MainApp.cluster);
        sI.put("ta05h", MainApp.hhno);
        sI.put("ta05u", MainApp.billno);

        sI.put("tiImsSerial", MainApp.childsMap.get(tiname.getSelectedItem().toString()).getSerialNo());

        sI.put("tiname", tiname.getSelectedItem().toString());
        sI.put("ti00", ti00a.isChecked() ? "1" : ti00b.isChecked() ? "2" : "0");
        sI.put("ti01", ti01a.isChecked() ? "1" : ti01b.isChecked() ? "2" : ti01888.isChecked() ? "888" : "0");
        sI.put("ti02a", ti02a.isChecked() ? "1" : "0");
        sI.put("ti02b", ti02b.isChecked() ? "2" : "0");
        sI.put("ti02c", ti02c.isChecked() ? "3" : "0");
        sI.put("ti02d", ti02d.isChecked() ? "4" : "0");
        sI.put("ti0288", ti0288.isChecked() ? "88" : "0");
        sI.put("ti0288x", ti0288x.getText().toString());
        sI.put("ti03", ti03a.isChecked() ? "1" : ti03b.isChecked() ? "2" : ti03c.isChecked() ? "3" : "0");

        sI.put("bcgM", bcgM01.isChecked() ? "1" : bcgM02.isChecked() ? "2" : "0");
        sI.put("bcgdatenr", bcgdatenr.isChecked() ? "1" : "0");
        sI.put("bcgdateM_mon", bcgDateMMon.getText().toString());
        sI.put("bcgdateM_year", bcgDateMYear.getText().toString());
        sI.put("bcgC", bcgC01.isChecked() ? "1" : bcgC02.isChecked() ? "2" : "0");
        sI.put("bcgdatenp", bcgdatenp.isChecked() ? "1" : "0");
        sI.put("bcgDate", bcgDate.getText().toString());
        sI.put("bcgPov", bcgPova.isChecked() ? "1" : bcgPovb.isChecked() ? "2" : bcgPovc.isChecked() ? "3"
                : bcgPovd.isChecked() ? "4" : bcgPove.isChecked() ? "5" : bcgPovf.isChecked() ? "6" : bcgPovg.isChecked() ? "7"
                : bcgPovh.isChecked() ? "8" : "0");
        // BCG At Birth
        sI.put("opv0M", opv0M01.isChecked() ? "1" : opv0M02.isChecked() ? "2" : "0");
        sI.put("opv0datenr", opv0datenr.isChecked() ? "1" : "0");
        sI.put("opv0dateM_mon", opv0DateMMon.getText().toString());
        sI.put("opv0dateM_year", opv0DateMYear.getText().toString());
        sI.put("opv0C", opv0C01.isChecked() ? "1" : opv0C02.isChecked() ? "2" : "0");
        sI.put("opv0datenp", opv0datenp.isChecked() ? "1" : "0");
        sI.put("opv0Date", opv0Date.getText().toString());
        sI.put("opv0Pov", opv0Pova.isChecked() ? "1" : opv0Povb.isChecked() ? "2" : opv0Povc.isChecked() ? "3"
                : opv0Povd.isChecked() ? "4" : opv0Pove.isChecked() ? "5" : opv0Povf.isChecked() ? "6" : opv0Povg.isChecked() ? "7"
                : opv0Povh.isChecked() ? "8" : "0");
        //Polio At Birth
        sI.put("penta1M", penta1M01.isChecked() ? "1" : penta1M02.isChecked() ? "2" : "0");
        sI.put("penta1datenr", penta1datenr.isChecked() ? "1" : "0");
        sI.put("penta1dateM_mon", penta1DateMMon.getText().toString());
        sI.put("penta1dateM_year", penta1DateMYear.getText().toString());
        sI.put("penta1C", penta1C01.isChecked() ? "1" : penta1C02.isChecked() ? "2" : "0");
        sI.put("penta1datenp", penta1datenp.isChecked() ? "1" : "0");
        sI.put("penta1Date", penta1Date.getText().toString());
        sI.put("penta1Pov", penta1Pova.isChecked() ? "1" : penta1Povb.isChecked() ? "2" : penta1Povc.isChecked() ? "3"
                : penta1Povd.isChecked() ? "4" : penta1Pove.isChecked() ? "5" : penta1Povf.isChecked() ? "6" : penta1Povg.isChecked() ? "7"
                : penta1Povh.isChecked() ? "8" : "0");
        // Penta 1 at 6 weeks
        sI.put("pcv1M", pcv1M01.isChecked() ? "1" : pcv1M02.isChecked() ? "2" : "0");
        sI.put("pcv1datenr", pcv1datenr.isChecked() ? "1" : "0");
        sI.put("pcv1dateM_mon", pcv1DateMMon.getText().toString());
        sI.put("pcv1dateM_year", pcv1DateMYear.getText().toString());

        sI.put("pcv1C", pcv1C01.isChecked() ? "1" : pcv1C02.isChecked() ? "2" : "0");
        sI.put("pcv1datenp", pcv1datenp.isChecked() ? "1" : "0");
        sI.put("pcv1Date", pcv1Date.getText().toString());
        sI.put("pcv1Pov", pcv1Pova.isChecked() ? "1" : pcv1Povb.isChecked() ? "2" : pcv1Povc.isChecked() ? "3"
                : pcv1Povd.isChecked() ? "4" : pcv1Pove.isChecked() ? "5" : pcv1Povf.isChecked() ? "6" : pcv1Povg.isChecked() ? "7"
                : pcv1Povh.isChecked() ? "8" : "0");
        //PCV 1 at 6 weeks
        sI.put("opv1M", opv1M01.isChecked() ? "1" : opv1M02.isChecked() ? "2" : "0");
        sI.put("opv1datenr", opv1datenr.isChecked() ? "1" : "0");
        sI.put("opv1dateM_mon", opv1DateMMon.getText().toString());
        sI.put("opv1dateM_year", opv1DateMYear.getText().toString());
        sI.put("opv1C", opv1C01.isChecked() ? "1" : opv1C02.isChecked() ? "2" : "0");
        sI.put("opv1datenp", opv1datenp.isChecked() ? "1" : "0");
        sI.put("opv1Date", opv1Date.getText().toString());
        sI.put("opv1Pov", opv1Pova.isChecked() ? "1" : opv1Povb.isChecked() ? "2" : opv1Povc.isChecked() ? "3"
                : opv1Povd.isChecked() ? "4" : opv1Pove.isChecked() ? "5" : opv1Povf.isChecked() ? "6" : opv1Povg.isChecked() ? "7"
                : opv1Povh.isChecked() ? "8" : "0");
        // OPV 1 at 6 weeks
        sI.put("penta2M", penta2M01.isChecked() ? "1" : penta2M02.isChecked() ? "2" : "0");
        sI.put("penta2datenr", penta2datenr.isChecked() ? "1" : "0");
        sI.put("penta2dateM_mon", penta2DateMMon.getText().toString());
        sI.put("penta2dateM_year", penta2DateMYear.getText().toString());
        sI.put("penta2C", penta2C01.isChecked() ? "1" : penta2C02.isChecked() ? "2" : "0");
        sI.put("penta2datenp", penta2datenp.isChecked() ? "1" : "0");

        sI.put("penta2Date", penta2Date.getText().toString());
        sI.put("penta2Pov", penta2Pova.isChecked() ? "1" : penta2Povb.isChecked() ? "2" : penta2Povc.isChecked() ? "3"
                : penta2Povd.isChecked() ? "4" : penta2Pove.isChecked() ? "5" : penta2Povf.isChecked() ? "6" : penta2Povg.isChecked() ? "7"
                : penta2Povh.isChecked() ? "8" : "0");
        // Penta 2 at 10 weeks
        sI.put("pcv2M", pcv2M01.isChecked() ? "1" : pcv2M02.isChecked() ? "2" : "0");
        sI.put("pcv2datenr", pcv2datenr.isChecked() ? "1" : "0");
        sI.put("pcv2dateM_mon", pcv2DateMMon.getText().toString());
        sI.put("pcv2dateM_year", pcv2DateMYear.getText().toString());
        sI.put("pcv2C", pcv2C01.isChecked() ? "1" : pcv2C02.isChecked() ? "2" : "0");
        sI.put("pcv2datenp", pcv2datenp.isChecked() ? "1" : "0");
        sI.put("pcv2Date", pcv2Date.getText().toString());
        sI.put("pcv2Pov", pcv2Pova.isChecked() ? "1" : pcv2Povb.isChecked() ? "2" : pcv2Povc.isChecked() ? "3"
                : pcv2Povd.isChecked() ? "4" : pcv2Pove.isChecked() ? "5" : pcv2Povf.isChecked() ? "6" : pcv2Povg.isChecked() ? "7"
                : pcv2Povh.isChecked() ? "8" : "0");

        sI.put("opv2M", opv2M01.isChecked() ? "1" : opv2M02.isChecked() ? "2" : "0");
        sI.put("opv2datenr", opv2datenr.isChecked() ? "1" : "0");
        sI.put("opv2dateM_mon", opv2DateMMon.getText().toString());
        sI.put("opv2dateM_year", opv2DateMYear.getText().toString());
        sI.put("opv2C", opv2C01.isChecked() ? "1" : opv2C02.isChecked() ? "2" : "0");
        sI.put("opv2datenp", opv2datenp.isChecked() ? "1" : "0");

        sI.put("opv2Date", opv2Date.getText().toString());
        sI.put("opv2Pov", opv2Pova.isChecked() ? "1" : opv2Povb.isChecked() ? "2" : opv2Povc.isChecked() ? "3"
                : opv2Povd.isChecked() ? "4" : opv2Pove.isChecked() ? "5" : opv2Povf.isChecked() ? "6" : opv2Povg.isChecked() ? "7"
                : opv2Povh.isChecked() ? "8" : "0");

        // PCV 2 at 6 weeks
        sI.put("penta3M", penta3M01.isChecked() ? "1" : penta3M02.isChecked() ? "2" : "0");
        sI.put("penta3datenr", penta3datenr.isChecked() ? "1" : "0");
        sI.put("penta3dateM_mon", penta3DateMMon.getText().toString());
        sI.put("penta3dateM_year", penta3DateMYear.getText().toString());
        sI.put("penta3C", penta3C01.isChecked() ? "1" : penta3C02.isChecked() ? "2" : "0");
        sI.put("penta3datenp", penta3datenp.isChecked() ? "1" : "0");

        sI.put("penta3Date", penta3Date.getText().toString());
        sI.put("penta3Pov", penta3Pova.isChecked() ? "1" : penta3Povb.isChecked() ? "2" : penta3Povc.isChecked() ? "3"
                : penta3Povd.isChecked() ? "4" : penta3Pove.isChecked() ? "5" : penta3Povf.isChecked() ? "6" : penta3Povg.isChecked() ? "7"
                : penta3Povh.isChecked() ? "8" : "0");
        // OPV 2 at 6 weeks
        sI.put("pcv3M", pcv3M01.isChecked() ? "1" : pcv3M02.isChecked() ? "2" : "0");
        sI.put("pcv3datenr", pcv3datenr.isChecked() ? "1" : "0");
        sI.put("pcv3dateM_mon", pcv3DateMMon.getText().toString());
        sI.put("pcv3dateM_year", pcv3DateMYear.getText().toString());

        sI.put("pcv3C", pcv3C01.isChecked() ? "1" : pcv3C02.isChecked() ? "2" : "0");
        sI.put("pcv3datenp", pcv3datenp.isChecked() ? "1" : "0");

        sI.put("pcv3Date", pcv3Date.getText().toString());
        sI.put("pcv3Pov", pcv3Pova.isChecked() ? "1" : pcv3Povb.isChecked() ? "2" : pcv3Povc.isChecked() ? "3"
                : pcv3Povd.isChecked() ? "4" : pcv3Pove.isChecked() ? "5" : pcv3Povf.isChecked() ? "6" : pcv3Povg.isChecked() ? "7"
                : pcv3Povh.isChecked() ? "8" : "0");

        // Penta 3 at 14 weeks
        sI.put("opv3M", opv3M01.isChecked() ? "1" : opv3M02.isChecked() ? "2" : "0");
        sI.put("opv3datenr", opv3datenr.isChecked() ? "1" : "0");
        sI.put("opv3dateM_mon", opv3DateMMon.getText().toString());
        sI.put("opv3dateM_year", opv3DateMYear.getText().toString());
        sI.put("opv3C", opv3C01.isChecked() ? "1" : opv3C02.isChecked() ? "2" : "0");
        sI.put("opv3datenp", opv3datenp.isChecked() ? "1" : "0");

        sI.put("opv3Date", opv3Date.getText().toString());
        sI.put("opv3Pov", opv3Pova.isChecked() ? "1" : opv3Povb.isChecked() ? "2" : opv3Povc.isChecked() ? "3"
                : opv3Povd.isChecked() ? "4" : opv3Pove.isChecked() ? "5" : opv3Povf.isChecked() ? "6" : opv3Povg.isChecked() ? "7"
                : opv3Povh.isChecked() ? "8" : "0");

        // PCV 3 at 14 weeks
        sI.put("ipvM", ipvM01.isChecked() ? "1" : ipvM02.isChecked() ? "2" : "0");
        sI.put("ipvdatenr", ipvdatenr.isChecked() ? "1" : "0");
        sI.put("ipvdateM_mon", ipvDateMMon.getText().toString());
        sI.put("ipvdateM_year", ipvDateMYear.getText().toString());
        sI.put("ipvC", ipvC01.isChecked() ? "1" : ipvC02.isChecked() ? "2" : "0");
        sI.put("ipvdatenp", ipvdatenp.isChecked() ? "1" : "0");

        sI.put("ipvDate", ipvDate.getText().toString());
        sI.put("ipvPov", ipvPova.isChecked() ? "1" : ipvPovb.isChecked() ? "2" : ipvPovc.isChecked() ? "3"
                : ipvPovd.isChecked() ? "4" : ipvPove.isChecked() ? "5" : ipvPovf.isChecked() ? "6" : ipvPovg.isChecked() ? "7"
                : ipvPovh.isChecked() ? "8" : "0");
        // OPV 3 at 14 weeks
        sI.put("measles1M", measles1M01.isChecked() ? "1" : measles1M02.isChecked() ? "2" : "0");
        sI.put("measles1datenr", measles1datenr.isChecked() ? "1" : "0");
        sI.put("measles1dateM_mon", measles1DateMMon.getText().toString());
        sI.put("measles1dateM_year", measles1DateMYear.getText().toString());
        sI.put("measles1C", measles1C01.isChecked() ? "1" : measles1C02.isChecked() ? "2" : "0");
        sI.put("measles1datenp", measles1datenp.isChecked() ? "1" : "0");

        sI.put("measles1Date", measles1Date.getText().toString());
        sI.put("measles1Pov", measles1Pova.isChecked() ? "1" : measles1Povb.isChecked() ? "2" : measles1Povc.isChecked() ? "3"
                : measles1Povd.isChecked() ? "4" : measles1Pove.isChecked() ? "5" : measles1Povf.isChecked() ? "6" : measles1Povg.isChecked() ? "7"
                : measles1Povh.isChecked() ? "8" : "0");
        // IPV at 14 weeks
        sI.put("measles2M", measles2M01.isChecked() ? "1" : measles2M02.isChecked() ? "2" : "0");
        sI.put("measles2datenr", measles2datenr.isChecked() ? "1" : "0");
        sI.put("measles2dateM_mon", measles2DateMMon.getText().toString());
        sI.put("measles2dateM_year", measles2DateMYear.getText().toString());
        sI.put("measles2C", measles2C01.isChecked() ? "1" : measles2C02.isChecked() ? "2" : "0");
        sI.put("measles2datenp", measles2datenp.isChecked() ? "1" : "0");

        sI.put("measles2Date", measles2Date.getText().toString());
        sI.put("measles2Pov", measles2Pova.isChecked() ? "1" : measles2Povb.isChecked() ? "2" : measles2Povc.isChecked() ? "3"
                : measles2Povd.isChecked() ? "4" : measles2Pove.isChecked() ? "5" : measles2Povf.isChecked() ? "6"
                : measles2Povg.isChecked() ? "7" : measles2Povh.isChecked() ? "8" : "0");

        sI.put("ti04", ti04a.isChecked() ? "1" : ti04b.isChecked() ? "2" : ti04888.isChecked() ? "888" : "0");
        sI.put("ti05", ti05.getText().toString());
        sI.put("ti05888", ti05888.isChecked() ? "888" : "0");
        sI.put("appver", MainApp.versionName + "." + MainApp.versionCode);


        MainApp.ims.setsI(String.valueOf(sI));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    public boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (tiname.getSelectedItem() == "....") {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.name), Toast.LENGTH_SHORT).show();
            ((TextView) tiname.getSelectedView()).setText("This Data is Required");
            ((TextView) tiname.getSelectedView()).setTextColor(Color.RED);
            tiname.requestFocus();
            Log.i(TAG, "tiname: This Data is Required!");
            return false;
        } else {
            ((TextView) tiname.getSelectedView()).setError(null);
        }


        if (ti00.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tiRespondentMother), Toast.LENGTH_SHORT).show();
            ti00a.setError("This data is Required!");    // Set Error on last radio button
            ti00a.setFocusable(true);
            ti00a.setFocusableInTouchMode(true);
            ti00a.requestFocus();
            Log.i(TAG, "ti00: This data is Required!");
            return false;
        } else {
            ti00a.setError(null);
        }

        if (ti01.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ti01), Toast.LENGTH_SHORT).show();
            ti01888.setError("This data is Required!");    // Set Error on last radio button
            ti01888.setFocusable(true);
            ti01888.setFocusableInTouchMode(true);
            ti01888.requestFocus();
            Log.i(TAG, "ti01: This data is Required!");
            return false;
        } else {
            ti01888.setError(null);
        }

        if (ti01a.isChecked()) {
            if (ti03.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ti03), Toast.LENGTH_SHORT).show();
                ti03c.setError("This data is Required!");    // Set Error on last radio button
                ti03c.setFocusable(true);
                ti03c.setFocusableInTouchMode(true);
                ti03c.requestFocus();
                Log.i(TAG, "ti03: This data is Required!");
                return false;
            } else {
                ti03c.setError(null);
            }

            //============ BCG / Mother ==========
            if (bcgM.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bcg), Toast.LENGTH_SHORT).show();
                bcgM02.setError("This data is Required!");
                Log.i(TAG, "bcgM: This data is Required!");
                bcgM02.setFocusable(true);
                bcgM02.setFocusableInTouchMode(true);
                bcgM02.requestFocus();
                return false;
            } else {
                bcgM02.setError(null);
            }

            if (bcgM01.isChecked() && !bcgdatenr.isChecked()) {
                if (bcgDateMYear.getText().toString().isEmpty() && bcgDateMMon.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.bcg) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                    bcgDateMYear.setError("This data is Required!");
                    bcgDateMMon.setError("This data is Required!");
                    Log.i(TAG, "bcgMDate: This data is Required!");
                    bcgDateMYear.requestFocus();
                    return false;
                } else {
                    bcgDateMYear.setError(null);
                    bcgDateMMon.setError(null);
                }
            }

            if (ti03a.isChecked()) {
                //============ BCG / Card Present ==========
                if (bcgC.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.bcg), Toast.LENGTH_SHORT).show();
                    bcgC02.setError("This data is Required!");
                    Log.i(TAG, "bcgC: This data is Required!");
                    bcgC02.setFocusable(true);
                    bcgC02.setFocusableInTouchMode(true);
                    bcgC02.requestFocus();

                    return false;
                } else {
                    bcgC02.setError(null);
                }


                if (bcgC01.isChecked() && !bcgdatenp.isChecked()) {
                    if (bcgDate.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.bcg) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                        bcgDate.setError("This data is Required!");
                        Log.i(TAG, "bcgDate: This data is Required!");
                        bcgDate.requestFocus();
                        return false;
                    } else {
                        bcgDate.setError(null);
                    }
                }
            }
            if (bcgC01.isChecked() || bcgM01.isChecked()) {

                if (bcgPov.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.bcg) + " - " + getString(R.string.place), Toast.LENGTH_SHORT).show();
                    bcgPova.setError("This data is Required!");
                    Log.i(TAG, "bcgPov: This data is Required!");
                    bcgPova.setFocusable(true);
                    bcgPova.setFocusableInTouchMode(true);
                    bcgPova.requestFocus();
                    return false;
                } else {
                    bcgPova.setError(null);
                }
            }


            //============ Polio 0 / Mother ==========
            if (opv0M.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv0), Toast.LENGTH_SHORT).show();
                opv0M02.setError("This data is Required!");
                Log.i(TAG, "opv0M: This data is Required!");
                opv0M02.setFocusable(true);
                opv0M02.setFocusableInTouchMode(true);
                opv0M02.requestFocus();
                return false;
            } else {
                opv0M02.setError(null);
            }

            if (opv0M01.isChecked() && !opv0datenr.isChecked()) {
                if (opv0DateMYear.getText().toString().isEmpty() && opv0DateMMon.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv0) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                    opv0DateMYear.setError("This data is Required!");
                    opv0DateMMon.setError("This data is Required!");
                    Log.i(TAG, "opv0MDate: This data is Required!");
                    opv0DateMYear.requestFocus();
                    return false;
                } else {
                    opv0DateMYear.setError(null);
                    opv0DateMMon.setError(null);
                }
            }


            if (ti03a.isChecked()) {
                //============ Polio 0 / Card Present ==========
                if (opv0C.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv0), Toast.LENGTH_SHORT).show();
                    opv0C02.setError("This data is Required!");
                    Log.i(TAG, "opv0C: This data is Required!");
                    opv0C02.setFocusable(true);
                    opv0C02.setFocusableInTouchMode(true);
                    opv0C02.requestFocus();
                    return false;
                } else {
                    opv0C02.setError(null);
                }

                if (opv0C01.isChecked() && !opv0datenp.isChecked()) {
                    if (opv0Date.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv0) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                        opv0Date.setError("This data is Required!");
                        Log.i(TAG, "opv0Date: This data is Required!");
                        opv0Date.requestFocus();
                        return false;
                    } else {
                        opv0Date.setError(null);
                    }
                }
            }

            if (opv0C01.isChecked() || opv0M01.isChecked()) {
                if (opv0Pov.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv0) + " - " + getString(R.string.place), Toast.LENGTH_SHORT).show();
                    opv0Pova.setError("This data is Required!");
                    Log.i(TAG, "opv0Pov: This data is Required!");
                    opv0Pova.setFocusable(true);
                    opv0Pova.setFocusableInTouchMode(true);
                    opv0Pova.requestFocus();
                    return false;
                } else {
                    opv0Pova.setError(null);
                }
            }


            //============ OPV 1 / Mother ==========
            if (opv1M.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv1), Toast.LENGTH_SHORT).show();
                opv1M02.setError("This data is Required!");
                Log.i(TAG, "opv1M: This data is Required!");
                opv1M02.setFocusable(true);
                opv1M02.setFocusableInTouchMode(true);
                opv1M02.requestFocus();
                return false;
            } else {
                opv1M02.setError(null);
            }

            if (opv1M01.isChecked() && !opv1datenr.isChecked()) {
                if (opv1DateMYear.getText().toString().isEmpty() && opv1DateMMon.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv1) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                    opv1DateMYear.setError("This data is Required!");
                    opv1DateMMon.setError("This data is Required!");
                    Log.i(TAG, "opv1MDate: This data is Required!");
                    opv1DateMYear.requestFocus();
                    return false;
                } else {
                    opv1DateMYear.setError(null);
                    opv1DateMMon.setError(null);
                }
            }

            if (ti03a.isChecked()) {
                //============ OPV 1 / Card Present ==========
                if (opv1C.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv1), Toast.LENGTH_SHORT).show();
                    opv1C02.setError("This data is Required!");
                    Log.i(TAG, "opv1C: This data is Required!");
                    opv1C02.setFocusable(true);
                    opv1C02.setFocusableInTouchMode(true);
                    opv1C02.requestFocus();
                    return false;
                } else {
                    opv1C02.setError(null);
                }

                if (opv1C01.isChecked() && !opv1datenp.isChecked()) {
                    if (opv1Date.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv1) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                        opv1Date.setError("This data is Required!");
                        Log.i(TAG, "opv1Date: This data is Required!");
                        opv1Date.requestFocus();
                        return false;
                    } else {
                        opv1Date.setError(null);
                    }
                }
            }



            if (opv1C01.isChecked() || opv1M01.isChecked()) {
                if (opv1Pov.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv1) + " - " + getString(R.string.place), Toast.LENGTH_SHORT).show();
                    opv1Pova.setError("This data is Required!");
                    Log.i(TAG, "opv1Pov: This data is Required!");
                    opv1Pova.setFocusable(true);
                    opv1Pova.setFocusableInTouchMode(true);
                    opv1Pova.requestFocus();
                    return false;
                } else {
                    opv1Pova.setError(null);
                }
            }

            //============ Penta 1 / Mother ==========
            if (penta1M.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta1), Toast.LENGTH_SHORT).show();
                penta1M02.setError("This data is Required!");
                Log.i(TAG, "penta1M: This data is Required!");
                penta1M02.setFocusable(true);
                penta1M02.setFocusableInTouchMode(true);
                penta1M02.requestFocus();
                return false;
            } else {
                penta1M02.setError(null);
            }

            if (penta1M01.isChecked() && !penta1datenr.isChecked()) {
                if (penta1DateMYear.getText().toString().isEmpty() && penta1DateMMon.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta1) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                    penta1DateMYear.setError("This data is Required!");
                    penta1DateMMon.setError("This data is Required!");
                    Log.i(TAG, "penta1MDate: This data is Required!");
                    penta1DateMYear.requestFocus();
                    return false;
                } else {
                    penta1DateMYear.setError(null);
                    penta1DateMMon.setError(null);
                }
            }


            if (ti03a.isChecked()) {
                //============ Penta 1 / Card Present ==========
                if (penta1C.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta1), Toast.LENGTH_SHORT).show();
                    penta1C02.setError("This data is Required!");
                    Log.i(TAG, "penta1C: This data is Required!");
                    penta1C02.setFocusable(true);
                    penta1C02.setFocusableInTouchMode(true);
                    penta1C02.requestFocus();
                    return false;
                } else {
                    penta1C02.setError(null);
                }

                if (penta1C01.isChecked() && !penta1datenp.isChecked()) {
                    if (penta1Date.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta1) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                        penta1Date.setError("This data is Required!");
                        Log.i(TAG, "penta1Date: This data is Required!");
                        penta1Date.requestFocus();
                        return false;
                    } else {
                        penta1Date.setError(null);
                    }
                }
            }

            if (penta1C01.isChecked() || penta1M01.isChecked()) {
                if (penta1Pov.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta1) + " - " + getString(R.string.place), Toast.LENGTH_SHORT).show();
                    penta1Pova.setError("This data is Required!");
                    Log.i(TAG, "penta1Pov: This data is Required!");
                    penta1Pova.setFocusable(true);
                    penta1Pova.setFocusableInTouchMode(true);
                    penta1Pova.requestFocus();
                    return false;
                } else {
                    penta1Pova.setError(null);
                }
            }


            //============ PCV 1 / Mother ==========
            if (pcv1M.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv1), Toast.LENGTH_SHORT).show();
                pcv1M02.setError("This data is Required!");
                Log.i(TAG, "pcv1M: This data is Required!");
                pcv1M02.setFocusable(true);
                pcv1M02.setFocusableInTouchMode(true);
                pcv1M02.requestFocus();
                return false;
            } else {
                pcv1M02.setError(null);
            }

            if (pcv1M01.isChecked() && !pcv1datenr.isChecked()) {
                if (pcv1DateMYear.getText().toString().isEmpty() && pcv1DateMMon.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv1) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                    pcv1DateMYear.setError("This data is Required!");
                    pcv1DateMMon.setError("This data is Required!");
                    Log.i(TAG, "pcv1MDate: This data is Required!");
                    pcv1DateMYear.requestFocus();
                    return false;
                } else {
                    pcv1DateMYear.setError(null);
                    pcv1DateMMon.setError(null);
                }
            }

            if (ti03a.isChecked()) {

                //============ PCV 1 / Card Present ==========
                if (pcv1C.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv1), Toast.LENGTH_SHORT).show();
                    pcv1C02.setError("This data is Required!");
                    Log.i(TAG, "pcv1C: This data is Required!");
                    pcv1C02.setFocusable(true);
                    pcv1C02.setFocusableInTouchMode(true);
                    pcv1C02.requestFocus();
                    return false;
                } else {
                    pcv1C02.setError(null);
                }

                if (pcv1C01.isChecked() && !pcv1datenp.isChecked()) {
                    if (pcv1Date.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv1) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                        pcv1Date.setError("This data is Required!");
                        Log.i(TAG, "pcv1Date: This data is Required!");
                        pcv1Date.requestFocus();
                        return false;
                    } else {
                        pcv1Date.setError(null);
                    }
                }
            }

            if (pcv1C01.isChecked() || pcv1M01.isChecked()) {
                if (pcv1Pov.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv1) + " - " + getString(R.string.place), Toast.LENGTH_SHORT).show();
                    pcv1Pova.setError("This data is Required!");
                    Log.i(TAG, "pcv1Pov: This data is Required!");
                    pcv1Pova.setFocusable(true);
                    pcv1Pova.setFocusableInTouchMode(true);
                    pcv1Pova.requestFocus();
                    return false;
                } else {
                    pcv1Pova.setError(null);
                }
            }

            //============ OPV 2 / Mother ==========
            if (opv2M.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv2), Toast.LENGTH_SHORT).show();
                opv2M02.setError("This data is Required!");
                Log.i(TAG, "opv2M: This data is Required!");
                opv2M02.setFocusable(true);
                opv2M02.setFocusableInTouchMode(true);
                opv2M02.requestFocus();
                return false;
            } else {
                opv2M02.setError(null);
            }

            if (opv2M01.isChecked() && !opv2datenr.isChecked()) {
                if (opv2DateMYear.getText().toString().isEmpty() && opv2DateMMon.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv2) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                    opv2DateMYear.setError("This data is Required!");
                    opv2DateMMon.setError("This data is Required!");
                    Log.i(TAG, "opv2MDate: This data is Required!");
                    opv2DateMYear.requestFocus();
                    return false;
                } else {
                    opv2DateMYear.setError(null);
                    opv2DateMMon.setError(null);
                }
            }

            if (ti03a.isChecked()) {
                //============ OPV 2 / Card Present ==========
                if (opv2C.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv2), Toast.LENGTH_SHORT).show();
                    opv2C02.setError("This data is Required!");
                    Log.i(TAG, "opv2C: This data is Required!");
                    opv2C02.setFocusable(true);
                    opv2C02.setFocusableInTouchMode(true);
                    opv2C02.requestFocus();
                    return false;
                } else {
                    opv2C02.setError(null);
                }

                if (opv2C01.isChecked() && !opv2datenp.isChecked()) {
                    if (opv2Date.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv2) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                        opv2Date.setError("This data is Required!");
                        Log.i(TAG, "opv2Date: This data is Required!");
                        opv2Date.requestFocus();
                        return false;
                    } else {
                        opv2Date.setError(null);
                    }
                }
            }


            if (opv2C01.isChecked() || opv2M01.isChecked()) {
                if (opv2Pov.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv2) + " - " + getString(R.string.place), Toast.LENGTH_SHORT).show();
                    opv2Pova.setError("This data is Required!");
                    Log.i(TAG, "opv2Pov: This data is Required!");
                    opv2Pova.setFocusable(true);
                    opv2Pova.setFocusableInTouchMode(true);
                    opv2Pova.requestFocus();
                    return false;
                } else {
                    opv2Pova.setError(null);
                }
            }

            //============ Penta 2 / Mother ==========
            if (penta2M.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta2), Toast.LENGTH_SHORT).show();
                penta2M02.setError("This data is Required!");
                Log.i(TAG, "penta2M: This data is Required!");
                penta2M02.setFocusable(true);
                penta2M02.setFocusableInTouchMode(true);
                penta2M02.requestFocus();
                return false;
            } else {
                penta2M02.setError(null);
            }

            if (penta2M01.isChecked() && !penta2datenr.isChecked()) {
                if (penta2DateMYear.getText().toString().isEmpty() && penta2DateMMon.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta2) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                    penta2DateMYear.setError("This data is Required!");
                    penta2DateMMon.setError("This data is Required!");
                    Log.i(TAG, "penta2MDate: This data is Required!");
                    penta2DateMYear.requestFocus();
                    return false;
                } else {
                    penta2DateMYear.setError(null);
                    penta2DateMMon.setError(null);
                }
            }

            if (ti03a.isChecked()) {
                //============ Penta 2 / Card Present ==========
                if (penta2C.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta2), Toast.LENGTH_SHORT).show();
                    penta2C02.setError("This data is Required!");
                    Log.i(TAG, "penta2C: This data is Required!");
                    penta2C02.setFocusable(true);
                    penta2C02.setFocusableInTouchMode(true);
                    penta2C02.requestFocus();
                    return false;
                } else {
                    penta2C02.setError(null);
                }


                if (penta2C01.isChecked() && !penta2datenp.isChecked()) {
                    if (penta2Date.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta2) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                        penta2Date.setError("This data is Required!");
                        Log.i(TAG, "penta2Date: This data is Required!");
                        penta2Date.requestFocus();
                        return false;
                    } else {
                        penta2Date.setError(null);
                    }
                }
            }


            if (penta2C01.isChecked() || penta2M01.isChecked()) {
                if (penta2Pov.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta2) + " - " + getString(R.string.place), Toast.LENGTH_SHORT).show();
                    penta2Pova.setError("This data is Required!");
                    Log.i(TAG, "penta2Pov: This data is Required!");
                    penta2Pova.setFocusable(true);
                    penta2Pova.setFocusableInTouchMode(true);
                    penta2Pova.requestFocus();
                    return false;
                } else {
                    penta2Pova.setError(null);
                }
            }

            //============ PCV 2 / Mother ==========
            if (pcv2M.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv2), Toast.LENGTH_SHORT).show();
                pcv2M02.setError("This data is Required!");
                Log.i(TAG, "pcv2M: This data is Required!");
                pcv2M02.setFocusable(true);
                pcv2M02.setFocusableInTouchMode(true);
                pcv2M02.requestFocus();
                return false;
            } else {
                pcv2M02.setError(null);
            }

            if (pcv2M01.isChecked() && !pcv2datenr.isChecked()) {
                if (pcv2DateMYear.getText().toString().isEmpty() && pcv2DateMMon.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv2) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                    pcv2DateMYear.setError("This data is Required!");
                    pcv2DateMMon.setError("This data is Required!");
                    Log.i(TAG, "pcv2MDate: This data is Required!");
                    pcv2DateMYear.requestFocus();
                    return false;
                } else {
                    pcv2DateMYear.setError(null);
                    pcv2DateMMon.setError(null);
                }
            }

            if (ti03a.isChecked()) {
                //============ PCV 2 / Card Present ==========
                if (pcv2C.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv2), Toast.LENGTH_SHORT).show();
                    pcv2C02.setError("This data is Required!");
                    Log.i(TAG, "pcv2C: This data is Required!");
                    pcv2C02.setFocusable(true);
                    pcv2C02.setFocusableInTouchMode(true);
                    pcv2C02.requestFocus();
                    return false;
                } else {
                    pcv2C02.setError(null);
                }

                if (pcv2C01.isChecked() && !pcv2datenp.isChecked()) {
                    if (pcv2Date.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv2) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                        pcv2Date.setError("This data is Required!");
                        Log.i(TAG, "pcv2Date: This data is Required!");
                        pcv2Date.requestFocus();
                        return false;
                    } else {
                        pcv2Date.setError(null);
                    }
                }
            }

            if (pcv2C01.isChecked() || pcv2M01.isChecked()) {
                if (pcv2Pov.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv2) + " - " + getString(R.string.place), Toast.LENGTH_SHORT).show();
                    pcv2Pova.setError("This data is Required!");
                    Log.i(TAG, "pcv2Pov: This data is Required!");
                    pcv2Pova.setFocusable(true);
                    pcv2Pova.setFocusableInTouchMode(true);
                    pcv2Pova.requestFocus();
                    return false;
                } else {
                    pcv2Pova.setError(null);
                }
            }

            //============ OPV 3 / Mother ==========
            if (opv3M.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv3), Toast.LENGTH_SHORT).show();
                opv3M02.setError("This data is Required!");
                Log.i(TAG, "opv3M: This data is Required!");
                opv3M02.setFocusable(true);
                opv3M02.setFocusableInTouchMode(true);
                opv3M02.requestFocus();
                return false;
            } else {
                opv3M02.setError(null);
            }

            if (opv3M01.isChecked() && !opv3datenr.isChecked()) {
                if (opv3DateMYear.getText().toString().isEmpty() && opv3DateMMon.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv3) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                    opv3DateMYear.setError("This data is Required!");
                    opv3DateMMon.setError("This data is Required!");
                    Log.i(TAG, "opv3MDate: This data is Required!");
                    opv3DateMYear.requestFocus();
                    return false;
                } else {
                    opv3DateMYear.setError(null);
                    opv3DateMMon.setError(null);
                }
            }

            if (ti03a.isChecked()) {
                //============ OPV 3 / Card Present ==========
                if (opv3C.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv3), Toast.LENGTH_SHORT).show();
                    opv3C02.setError("This data is Required!");
                    Log.i(TAG, "opv3C: This data is Required!");
                    opv3C02.setFocusable(true);
                    opv3C02.setFocusableInTouchMode(true);
                    opv3C02.requestFocus();
                    return false;
                } else {
                    opv3C02.setError(null);
                }

                if (opv3C01.isChecked() && !opv3datenp.isChecked()) {
                    if (opv3Date.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv3) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                        opv3Date.setError("This data is Required!");
                        Log.i(TAG, "opv3Date: This data is Required!");
                        opv3Date.requestFocus();
                        return false;
                    } else {
                        opv3Date.setError(null);
                    }
                }
            }


            if (opv3C01.isChecked() || opv3M01.isChecked()) {
                if (opv3Pov.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.opv3) + " - " + getString(R.string.place), Toast.LENGTH_SHORT).show();
                    opv3Pova.setError("This data is Required!");
                    Log.i(TAG, "opv3Pov: This data is Required!");
                    opv3Pova.setFocusable(true);
                    opv3Pova.setFocusableInTouchMode(true);
                    opv3Pova.requestFocus();
                    return false;
                } else {
                    opv3Pova.setError(null);
                }
            }

            //============ Penta 3 / Mother ==========
            if (penta3M.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta3), Toast.LENGTH_SHORT).show();
                penta3M02.setError("This data is Required!");
                Log.i(TAG, "penta3M: This data is Required!");
                penta3M02.setFocusable(true);
                penta3M02.setFocusableInTouchMode(true);
                penta3M02.requestFocus();
                return false;
            } else {
                penta3M02.setError(null);
            }

            if (penta3M01.isChecked() && !penta3datenr.isChecked()) {
                if (penta3DateMYear.getText().toString().isEmpty() && penta3DateMMon.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta3) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                    penta3DateMYear.setError("This data is Required!");
                    penta3DateMMon.setError("This data is Required!");
                    Log.i(TAG, "penta3MDate: This data is Required!");
                    penta2DateMYear.requestFocus();
                    return false;
                } else {
                    penta3DateMYear.setError(null);
                    penta3DateMMon.setError(null);
                }
            }

            if (ti03a.isChecked()) {
                //============ Penta 3 / Card Present ==========
                if (penta3C.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta3), Toast.LENGTH_SHORT).show();
                    penta3C02.setError("This data is Required!");
                    Log.i(TAG, "penta3C: This data is Required!");
                    penta3C02.setFocusable(true);
                    penta3C02.setFocusableInTouchMode(true);
                    penta3C02.requestFocus();
                    return false;
                } else {
                    penta3C02.setError(null);
                }

                if (penta3C01.isChecked() && !penta3datenp.isChecked()) {
                    if (penta3Date.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta3) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                        penta3Date.setError("This data is Required!");
                        Log.i(TAG, "penta3Date: This data is Required!");
                        penta3Date.requestFocus();
                        return false;
                    } else {
                        penta3Date.setError(null);
                    }
                }
            }

            if (penta3C01.isChecked() || penta3M01.isChecked()) {
                if (penta3Pov.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.penta3) + " - " + getString(R.string.place), Toast.LENGTH_SHORT).show();
                    penta3Pova.setError("This data is Required!");
                    Log.i(TAG, "penta3Pov: This data is Required!");
                    penta3Pova.setFocusable(true);
                    penta3Pova.setFocusableInTouchMode(true);
                    penta3Pova.requestFocus();
                    return false;
                } else {
                    penta3Pova.setError(null);
                }
            }

            //============ PCV / Mother ==========
            if (pcv3M.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv3), Toast.LENGTH_SHORT).show();
                pcv3M02.setError("This data is Required!");
                Log.i(TAG, "pcv3M: This data is Required!");
                pcv3M02.setFocusable(true);
                pcv3M02.setFocusableInTouchMode(true);
                pcv3M02.requestFocus();
                return false;
            } else {
                pcv3M02.setError(null);
            }

            if (pcv3M01.isChecked() && !pcv3datenr.isChecked()) {
                if (pcv3DateMYear.getText().toString().isEmpty() && pcv3DateMMon.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv3) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                    pcv3DateMYear.setError("This data is Required!");
                    pcv3DateMMon.setError("This data is Required!");
                    Log.i(TAG, "pcv3MDate: This data is Required!");
                    pcv3DateMYear.requestFocus();
                    return false;
                } else {
                    pcv3DateMYear.setError(null);
                    pcv3DateMMon.setError(null);
                }
            }

            if (ti03a.isChecked()) {
                //============ PCV 3 / Card Present ==========
                if (pcv3C.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv3), Toast.LENGTH_SHORT).show();
                    pcv3C02.setError("This data is Required!");
                    Log.i(TAG, "pcv3C: This data is Required!");
                    pcv3C02.setFocusable(true);
                    pcv3C02.setFocusableInTouchMode(true);
                    pcv3C02.requestFocus();
                    return false;
                } else {
                    pcv3C02.setError(null);
                }

                if (pcv3C01.isChecked() && !pcv3datenp.isChecked()) {
                    if (pcv3Date.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv3) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                        pcv3Date.setError("This data is Required!");
                        Log.i(TAG, "pcv3Date: This data is Required!");
                        pcv3Date.requestFocus();
                        return false;
                    } else {
                        pcv3Date.setError(null);
                    }
                }
            }

            if (pcv3C01.isChecked() || pcv3M01.isChecked()) {
                if (pcv3Pov.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.pcv3) + " - " + getString(R.string.place), Toast.LENGTH_SHORT).show();
                    pcv3Pova.setError("This data is Required!");
                    Log.i(TAG, "pcv3Pov: This data is Required!");
                    pcv3Pova.setFocusable(true);
                    pcv3Pova.setFocusableInTouchMode(true);
                    pcv3Pova.requestFocus();
                    return false;
                } else {
                    pcv3Pova.setError(null);
                }
            }


            //============ IPV / Mother ==========
            if (ipvM.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ipv), Toast.LENGTH_SHORT).show();
                ipvM02.setError("This data is Required!");
                Log.i(TAG, "ipvM: This data is Required!");
                ipvM02.setFocusable(true);
                ipvM02.setFocusableInTouchMode(true);
                ipvM02.requestFocus();
                return false;
            } else {
                ipvM02.setError(null);
            }

            if (ipvM01.isChecked() && !ipvdatenr.isChecked()) {
                if (ipvDateMYear.getText().toString().isEmpty() && ipvDateMMon.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.ipv) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                    ipvDateMYear.setError("This data is Required!");
                    ipvDateMMon.setError("This data is Required!");
                    Log.i(TAG, "ipvMDate: This data is Required!");
                    ipvDateMYear.requestFocus();
                    return false;
                } else {
                    ipvDateMYear.setError(null);
                    ipvDateMMon.setError(null);
                }
            }


            if (ti03a.isChecked()) {
                //============ IPV / Card Present ==========
                if (ipvC.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.ipv), Toast.LENGTH_SHORT).show();
                    ipvC02.setError("This data is Required!");
                    Log.i(TAG, "ipvC: This data is Required!");
                    ipvC02.setFocusable(true);
                    ipvC02.setFocusableInTouchMode(true);
                    ipvC02.requestFocus();
                    return false;
                } else {
                    ipvC02.setError(null);
                }


                if (ipvC01.isChecked() && !ipvdatenp.isChecked()) {
                    if (ipvDate.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.ipv) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                        ipvDate.setError("This data is Required!");
                        Log.i(TAG, "ipvDate: This data is Required!");
                        ipvDate.requestFocus();
                        return false;
                    } else {
                        ipvDate.setError(null);
                    }
                }
            }


            if (ipvC01.isChecked() || ipvM01.isChecked()) {
                if (ipvPov.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.ipv) + " - " + getString(R.string.place), Toast.LENGTH_SHORT).show();
                    ipvPova.setError("This data is Required!");
                    Log.i(TAG, "ipvPov: This data is Required!");
                    ipvPova.setFocusable(true);
                    ipvPova.setFocusableInTouchMode(true);
                    ipvPova.requestFocus();
                    return false;
                } else {
                    ipvPova.setError(null);
                }
            }

            //============ measles1 / Mother ==========
            if (measles1M.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.measles1), Toast.LENGTH_SHORT).show();
                measles1M02.setError("This data is Required!");
                Log.i(TAG, "measles1M: This data is Required!");
                measles1M02.setFocusable(true);
                measles1M02.setFocusableInTouchMode(true);
                measles1M02.requestFocus();
                return false;
            } else {
                measles1M02.setError(null);
            }

            if (measles1M01.isChecked() && !measles1datenr.isChecked()) {
                if (measles1DateMYear.getText().toString().isEmpty() && measles1DateMMon.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.measles1) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                    measles1DateMYear.setError("This data is Required!");
                    measles1DateMMon.setError("This data is Required!");
                    Log.i(TAG, "measles1MDate: This data is Required!");
                    measles1DateMYear.requestFocus();
                    return false;
                } else {
                    measles1DateMYear.setError(null);
                    measles1DateMMon.setError(null);
                }
            }

            if (ti03a.isChecked()) {
                //============ measles1 / Card Present ==========
                if (measles1C.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.measles1), Toast.LENGTH_SHORT).show();
                    measles1C02.setError("This data is Required!");
                    Log.i(TAG, "measles1C: This data is Required!");
                    measles1C02.setFocusable(true);
                    measles1C02.setFocusableInTouchMode(true);
                    measles1C02.requestFocus();
                    return false;
                } else {
                    measles1C02.setError(null);
                }

                if (measles1C01.isChecked() && !measles1datenp.isChecked()) {
                    if (measles1Date.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.measles1) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                        measles1Date.setError("This data is Required!");
                        Log.i(TAG, "measles1Date: This data is Required!");
                        measles1Date.requestFocus();
                        return false;
                    } else {
                        measles1Date.setError(null);
                    }
                }
            }

            if (measles1C01.isChecked() || measles1M01.isChecked()) {
                if (measles1Pov.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.measles1) + " - " + getString(R.string.place), Toast.LENGTH_SHORT).show();
                    measles1Pova.setError("This data is Required!");
                    Log.i(TAG, "measles1Pov: This data is Required!");
                    measles1Pov.setFocusable(true);
                    measles1Pov.setFocusableInTouchMode(true);
                    measles1Pov.requestFocus();
                    return false;
                } else {
                    measles1Pova.setError(null);
                }
            }

            //============ measles2 / Mother ==========
            if (measles2M.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.measles2), Toast.LENGTH_SHORT).show();
                measles2M02.setError("This data is Required!");
                Log.i(TAG, "measles2M: This data is Required!");
                measles2M02.setFocusable(true);
                measles2M02.setFocusableInTouchMode(true);
                measles2M02.requestFocus();
                return false;
            } else {
                measles2M02.setError(null);
            }

            if (measles2M01.isChecked() && !measles2datenr.isChecked()) {
                if (measles2DateMYear.getText().toString().isEmpty() && measles1DateMMon.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.measles2) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                    measles2DateMYear.setError("This data is Required!");
                    measles2DateMMon.setError("This data is Required!");
                    Log.i(TAG, "measles2MDate: This data is Required!");
                    measles2DateMYear.requestFocus();
                    return false;
                } else {
                    measles2DateMYear.setError(null);
                    measles2DateMMon.setError(null);
                }
            }

            if (ti03a.isChecked()) {

                //============ measles2 / Card Present ==========
                if (measles2C.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.measles2), Toast.LENGTH_SHORT).show();
                    measles2C02.setError("This data is Required!");
                    Log.i(TAG, "measles2C: This data is Required!");
                    measles2C02.setFocusable(true);
                    measles2C02.setFocusableInTouchMode(true);
                    measles2C02.requestFocus();
                    return false;
                } else {
                    measles2C02.setError(null);
                }

                if (measles2C01.isChecked() && !measles2datenp.isChecked()) {

                    if (measles2Date.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.measles2) + " - " + getString(R.string.date), Toast.LENGTH_SHORT).show();
                        measles2Date.setError("This data is Required!");
                        Log.i(TAG, "measles2Date: This data is Required!");
                        measles2Date.requestFocus();
                        return false;
                    } else {
                        measles2Date.setError(null);
                    }
                }
            }

            if (measles2C01.isChecked() || measles2M01.isChecked()) {
                if (measles2Pov.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.measles2) + " - " + getString(R.string.place), Toast.LENGTH_SHORT).show();
                    measles2Pova.setError("This data is Required!");
                    Log.i(TAG, "measles2Pov: This data is Required!");
                    measles2Pova.setFocusable(true);
                    measles2Pova.setFocusableInTouchMode(true);
                    measles2Pova.requestFocus();
                    return false;
                } else {
                    measles2Pova.setError(null);
                }
            }

            if (ti04.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ti04), Toast.LENGTH_SHORT).show();
                ti04888.setError("This data is Required!");
                Log.i(TAG, "ti04: This data is Required!");
                ti04a.setFocusable(true);
                ti04a.setFocusableInTouchMode(true);
                ti04a.requestFocus();
                return false;
            } else {
                ti04888.setError(null);
            }

            if (ti04a.isChecked()) {

                if (!ti05888.isChecked()) {
                    if (ti05.getText().toString().isEmpty()) {
                        Toast.makeText(this, "ERROR(empty): " + getString(R.string.ti05), Toast.LENGTH_SHORT).show();
                        ti05.setError("This data is Required!");
                        ti05.requestFocus();
                        Log.i(TAG, "ti05: This data is Required!");

                        return false;
                    } else {
                        ti05.setError(null);
                    }

                    if (Integer.parseInt(ti05.getText().toString()) < 1) {
                        Toast.makeText(this, "ERROR(invalid): " + getString(R.string.ti05), Toast.LENGTH_SHORT).show();
                        ti05.setError("Zero not allowed");
                        ti05.requestFocus();
                        Log.i(TAG, "ti05: Zero not allowed");
                        return false;
                    } else {
                        ti05.setError(null);
                    }

                }
            }


        } else {
            if (!(ti02a.isChecked() || ti02b.isChecked() || ti02c.isChecked() || ti02d.isChecked()
                    || ti0288.isChecked())) {
                Toast.makeText(this, "ERROR(empty)" + getString(R.string.ti02), Toast.LENGTH_SHORT).show();
                ti02a.setError("This data is Required!");
                ti02a.requestFocus();
                Log.i(TAG, "ti02: This data is Required!");
                return false;
            } else {
                ti02a.setError(null);
            }

            if (ti0288.isChecked() && ti0288x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty)" + getString(R.string.ti02) + " - " + getString(R.string.other), Toast.LENGTH_SHORT).show();
                ti0288x.setError("This data is Required!");
                ti0288x.requestFocus();
                Log.i(TAG, "ti0288x: This data is Required!");
                return false;
            } else {
                ti0288x.setError(null);
            }
        }


        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }


}


