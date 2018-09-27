package edu.aku.hassannaqvi.uen_po_hhs.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

public class SectionCActivity extends Activity {

    private static final String TAG = SectionCActivity.class.getName();
    @BindView(R.id.tc01)
    RadioGroup tc01;
    @BindView(R.id.tc01a)
    RadioButton tc01a;
    @BindView(R.id.tc01b)
    RadioButton tc01b;
    @BindView(R.id.tc01c)
    RadioButton tc01c;
    @BindView(R.id.tc01d)
    RadioButton tc01d;
    @BindView(R.id.tc01e)
    RadioButton tc01e;
    @BindView(R.id.tc01f)
    RadioButton tc01f;
    @BindView(R.id.tc01g)
    RadioButton tc01g;
    @BindView(R.id.tc01h)
    RadioButton tc01h;
    @BindView(R.id.tc01i)
    RadioButton tc01i;
    @BindView(R.id.tc01j)
    RadioButton tc01j;
    @BindView(R.id.tc01k)
    RadioButton tc01k;
    @BindView(R.id.tc01l)
    RadioButton tc01l;
    @BindView(R.id.tc02)
    RadioGroup tc02;
    @BindView(R.id.tc02a)
    RadioButton tc02a;
    @BindView(R.id.tc02b)
    RadioButton tc02b;
    @BindView(R.id.tc02c)
    RadioButton tc02c;
    @BindView(R.id.tc02d)
    RadioButton tc02d;
    @BindView(R.id.tc02e)
    RadioButton tc02e;
    @BindView(R.id.tc02f)
    RadioButton tc02f;
    @BindView(R.id.tc02g)
    RadioButton tc02g;
    @BindView(R.id.tc02h)
    RadioButton tc02h;
    @BindView(R.id.tc02i)
    RadioButton tc02i;
    @BindView(R.id.tc02j)
    RadioButton tc02j;
    @BindView(R.id.tc02k)
    RadioButton tc02k;
    @BindView(R.id.tc02l)
    RadioButton tc02l;
    @BindView(R.id.tc02m)
    RadioButton tc02m;
    @BindView(R.id.tc02n)
    RadioButton tc02n;
    @BindView(R.id.tc02o)
    RadioButton tc02o;
    @BindView(R.id.tc03)
    RadioGroup tc03;
    @BindView(R.id.tc03a)
    RadioButton tc03a;
    @BindView(R.id.tc03b)
    RadioButton tc03b;
    @BindView(R.id.tc03c)
    RadioButton tc03c;
    @BindView(R.id.tc03d)
    RadioButton tc03d;
    @BindView(R.id.tc03e)
    RadioButton tc03e;
    @BindView(R.id.tc03f)
    RadioButton tc03f;
    @BindView(R.id.tc03g)
    RadioButton tc03g;
    @BindView(R.id.tc03h)
    RadioButton tc03h;
    @BindView(R.id.tc03i)
    RadioButton tc03i;
    @BindView(R.id.tc03j)
    RadioButton tc03j;
    @BindView(R.id.tc03k)
    RadioButton tc03k;
    @BindView(R.id.tc03l)
    RadioButton tc03l;
    @BindView(R.id.tc03m)
    RadioButton tc03m;
    @BindView(R.id.tc03n)
    RadioButton tc03n;
    @BindView(R.id.tc03o)
    RadioButton tc03o;
    @BindView(R.id.tc03p)
    RadioButton tc03p;
    @BindView(R.id.tc03q)
    RadioButton tc03q;
    @BindView(R.id.tc04)
    EditText tc04;
    @BindView(R.id.tc05)
    RadioGroup tc05;
    @BindView(R.id.tc05a)
    RadioButton tc05a;
    @BindView(R.id.tc05b)
    RadioButton tc05b;
    @BindView(R.id.tc0588)
    RadioButton tc0588;
    @BindView(R.id.tc0588x)
    EditText tc0588x;
    @BindView(R.id.tc06)
    RadioGroup tc06;
    @BindView(R.id.tc06a)
    RadioButton tc06a;
    @BindView(R.id.tc06b)
    RadioButton tc06b;
    @BindView(R.id.tc06c)
    RadioButton tc06c;
    @BindView(R.id.tc06d)
    RadioButton tc06d;
    @BindView(R.id.tc0688)
    RadioButton tc0688;
    @BindView(R.id.tc0688x)
    EditText tc0688x;
    @BindView(R.id.tc07)
    RadioGroup tc07;
    @BindView(R.id.tc07a)
    RadioButton tc07a;
    @BindView(R.id.tc07b)
    RadioButton tc07b;
    @BindView(R.id.tc07c)
    RadioButton tc07c;
    @BindView(R.id.tc07d)
    RadioButton tc07d;
    @BindView(R.id.tc07e)
    RadioButton tc07e;
    @BindView(R.id.tc07f)
    RadioButton tc07f;
    @BindView(R.id.tc07g)
    RadioButton tc07g;
    @BindView(R.id.tc07h)
    RadioButton tc07h;
    @BindView(R.id.tc07i)
    RadioButton tc07i;
    @BindView(R.id.tc07j)
    RadioButton tc07j;
    @BindView(R.id.tc07k)
    RadioButton tc07k;
    @BindView(R.id.tc07l)
    RadioButton tc07l;
    @BindView(R.id.tc0788)
    RadioButton tc0788;
    @BindView(R.id.tc0788x)
    EditText tc0788x;
    @BindView(R.id.tc08a)
    RadioGroup tc08a;
    @BindView(R.id.tc08aa)
    RadioButton tc08aa;
    @BindView(R.id.tc08ab)
    RadioButton tc08ab;
    @BindView(R.id.tc08b)
    RadioGroup tc08b;
    @BindView(R.id.tc08ba)
    RadioButton tc08ba;
    @BindView(R.id.tc08bb)
    RadioButton tc08bb;
    @BindView(R.id.tc08c)
    RadioGroup tc08c;
    @BindView(R.id.tc08ca)
    RadioButton tc08ca;
    @BindView(R.id.tc08cb)
    RadioButton tc08cb;
    @BindView(R.id.tc08d)
    RadioGroup tc08d;
    @BindView(R.id.tc08da)
    RadioButton tc08da;
    @BindView(R.id.tc08db)
    RadioButton tc08db;
    @BindView(R.id.tc08e)
    RadioGroup tc08e;
    @BindView(R.id.tc08ea)
    RadioButton tc08ea;
    @BindView(R.id.tc08eb)
    RadioButton tc08eb;
    @BindView(R.id.tc08f)
    RadioGroup tc08f;
    @BindView(R.id.tc08fa)
    RadioButton tc08fa;
    @BindView(R.id.tc08fb)
    RadioButton tc08fb;
    @BindView(R.id.tc08g)
    RadioGroup tc08g;
    @BindView(R.id.tc08ga)
    RadioButton tc08ga;
    @BindView(R.id.tc08gb)
    RadioButton tc08gb;
    @BindView(R.id.tc08h)
    RadioGroup tc08h;
    @BindView(R.id.tc08ha)
    RadioButton tc08ha;
    @BindView(R.id.tc08hb)
    RadioButton tc08hb;
    @BindView(R.id.tc08i)
    RadioGroup tc08i;
    @BindView(R.id.tc08ia)
    RadioButton tc08ia;
    @BindView(R.id.tc08ib)
    RadioButton tc08ib;
    @BindView(R.id.tc08j)
    RadioGroup tc08j;
    @BindView(R.id.tc08ja)
    RadioButton tc08ja;
    @BindView(R.id.tc08jb)
    RadioButton tc08jb;
    @BindView(R.id.tc08k)
    RadioGroup tc08k;
    @BindView(R.id.tc08ka)
    RadioButton tc08ka;
    @BindView(R.id.tc08kb)
    RadioButton tc08kb;
    @BindView(R.id.tc08l)
    RadioGroup tc08l;
    @BindView(R.id.tc08la)
    RadioButton tc08la;
    @BindView(R.id.tc08lb)
    RadioButton tc08lb;
    @BindView(R.id.tc08m)
    RadioGroup tc08m;
    @BindView(R.id.tc08ma)
    RadioButton tc08ma;
    @BindView(R.id.tc08mb)
    RadioButton tc08mb;
    @BindView(R.id.tc08n)
    RadioGroup tc08n;
    @BindView(R.id.tc08na)
    RadioButton tc08na;
    @BindView(R.id.tc08nb)
    RadioButton tc08nb;
    @BindView(R.id.tc08o)
    RadioGroup tc08o;
    @BindView(R.id.tc08oa)
    RadioButton tc08oa;
    @BindView(R.id.tc08ob)
    RadioButton tc08ob;
    @BindView(R.id.tc08p)
    RadioGroup tc08p;
    @BindView(R.id.tc08pa)
    RadioButton tc08pa;
    @BindView(R.id.tc08pb)
    RadioButton tc08pb;
    @BindView(R.id.tc08q)
    RadioGroup tc08q;
    @BindView(R.id.tc08qa)
    RadioButton tc08qa;
    @BindView(R.id.tc08qb)
    RadioButton tc08qb;
    @BindView(R.id.tc08r)
    RadioGroup tc08r;
    @BindView(R.id.tc08ra)
    RadioButton tc08ra;
    @BindView(R.id.tc08rb)
    RadioButton tc08rb;
    @BindView(R.id.tc08s)
    RadioGroup tc08s;
    @BindView(R.id.tc08sa)
    RadioButton tc08sa;
    @BindView(R.id.tc08sb)
    RadioButton tc08sb;
    @BindView(R.id.tc09a)
    RadioGroup tc09a;
    @BindView(R.id.tc09aa)
    RadioButton tc09aa;
    @BindView(R.id.tc09ab)
    RadioButton tc09ab;
    @BindView(R.id.tc09b)
    RadioGroup tc09b;
    @BindView(R.id.tc09ba)
    RadioButton tc09ba;
    @BindView(R.id.tc09bb)
    RadioButton tc09bb;
    @BindView(R.id.tc09c)
    RadioGroup tc09c;
    @BindView(R.id.tc09ca)
    RadioButton tc09ca;
    @BindView(R.id.tc09cb)
    RadioButton tc09cb;
    @BindView(R.id.tc09d)
    RadioGroup tc09d;
    @BindView(R.id.tc09da)
    RadioButton tc09da;
    @BindView(R.id.tc09db)
    RadioButton tc09db;
    @BindView(R.id.tc09e)
    RadioGroup tc09e;
    @BindView(R.id.tc09ea)
    RadioButton tc09ea;
    @BindView(R.id.tc09eb)
    RadioButton tc09eb;
    @BindView(R.id.tc09f)
    RadioGroup tc09f;
    @BindView(R.id.tc09fa)
    RadioButton tc09fa;
    @BindView(R.id.tc09fb)
    RadioButton tc09fb;
    @BindView(R.id.tc09g)
    RadioGroup tc09g;
    @BindView(R.id.tc09ga)
    RadioButton tc09ga;
    @BindView(R.id.tc09gb)
    RadioButton tc09gb;
    @BindView(R.id.tc09h)
    RadioGroup tc09h;
    @BindView(R.id.tc09ha)
    RadioButton tc09ha;
    @BindView(R.id.tc09hb)
    RadioButton tc09hb;
    @BindView(R.id.tc09i)
    RadioGroup tc09i;
    @BindView(R.id.tc09ia)
    RadioButton tc09ia;
    @BindView(R.id.tc09ib)
    RadioButton tc09ib;
    @BindView(R.id.tc10)
    RadioGroup tc10;
    @BindView(R.id.tc10a)
    RadioButton tc10a;
    @BindView(R.id.tc10b)
    RadioButton tc10b;
    @BindView(R.id.tc11)
    RadioGroup tc11;
    @BindView(R.id.tc11a)
    RadioButton tc11a;
    @BindView(R.id.tc11b)
    RadioButton tc11b;
    @BindView(R.id.fldGrpte12)
    LinearLayout fldGrpte12;
    @BindView(R.id.tc12)
    RadioGroup tc12;
    @BindView(R.id.tc12a)
    RadioButton tc12a;
    @BindView(R.id.tc12b)
    RadioButton tc12b;
    @BindView(R.id.tc12888)
    RadioButton tc12888;
    @BindView(R.id.tc12ac)
    EditText tc12ac;
    @BindView(R.id.tc12kn)
    EditText tc12kn;
    @BindView(R.id.tc13)
    RadioGroup tc13;
    @BindView(R.id.tc13a)
    RadioButton tc13a;
    @BindView(R.id.tc13b)
    RadioButton tc13b;
    @BindView(R.id.fldGrptc14)
    LinearLayout fldGrptc14;
    @BindView(R.id.tc14a)
    EditText tc14a;
    @BindView(R.id.tc14b)
    EditText tc14b;
    @BindView(R.id.tc14c)
    EditText tc14c;
    @BindView(R.id.tc14d)
    EditText tc14d;
    @BindView(R.id.tc14e)
    EditText tc14e;
    @BindView(R.id.tc14f)
    EditText tc14f;
    @BindView(R.id.tc15)
    RadioGroup tc15;
    @BindView(R.id.tc15a)
    RadioButton tc15a;
    @BindView(R.id.tc15b)
    RadioButton tc15b;
    @BindView(R.id.tc15888)
    RadioButton tc15888;
    @BindView(R.id.tc16)
    RadioGroup tc16;
    @BindView(R.id.tc16a)
    RadioButton tc16a;
    @BindView(R.id.tc16b)
    RadioButton tc16b;
    @BindView(R.id.tc16c)
    RadioButton tc16c;
    @BindView(R.id.tc16d)
    RadioButton tc16d;
    @BindView(R.id.tc16e)
    RadioButton tc16e;
    @BindView(R.id.tc16f)
    RadioButton tc16f;
    @BindView(R.id.tc16g)
    RadioButton tc16g;
    @BindView(R.id.tc16h)
    RadioButton tc16h;
    @BindView(R.id.tc1688)
    RadioButton tc1688;
    @BindView(R.id.tc1688x)
    EditText tc1688x;
    @BindView(R.id.tc17)
    EditText tc17;
    @BindView(R.id.tc17888)
    CheckBox tc17888;

    @BindView(R.id.tc18)
    RadioGroup tc18;
    @BindView(R.id.tc18a)
    RadioButton tc18a;
    @BindView(R.id.tc18b)
    RadioButton tc18b;
    @BindView(R.id.fldGrptc18)
    LinearLayout fldGrptc18;
    @BindView(R.id.tc19)
    EditText tc19;


    @BindView(R.id.tc20)
    RadioGroup tc20;
    @BindView(R.id.tc20a)
    RadioButton tc20a;
    @BindView(R.id.tc20b)
    RadioButton tc20b;
    @BindView(R.id.fldGrptc20)
    LinearLayout fldGrptc20;
    @BindView(R.id.tc21)
    EditText tc21;

    private Boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_c);
        ButterKnife.bind(this);


        MainApp.TotalDeceasedChildCount = 0;
//        MainApp.TotalDeceasedMotherCount = 0;

//        05
        tc0588.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    tc0588x.setVisibility(View.VISIBLE);
                } else {
                    tc0588x.setVisibility(View.GONE);
                    tc0588x.setText(null);
                }
            }
        });

//        06
        tc0688.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    tc0688x.setVisibility(View.VISIBLE);
                } else {
                    tc0688x.setVisibility(View.GONE);
                    tc0688x.setText(null);
                }
            }
        });

//        07
        tc0788.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    tc0788x.setVisibility(View.VISIBLE);
                } else {
                    tc0788x.setVisibility(View.GONE);
                    tc0788x.setText(null);
                }
            }
        });

//        11
        tc11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.tc11a) {
                    fldGrpte12.setVisibility(View.VISIBLE);
                } else {
                    fldGrpte12.setVisibility(View.GONE);
                    tc12.clearCheck();
                    tc12ac.setText(null);
                    tc12kn.setText(null);
                }
            }
        });

//        12
        tc12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.tc12a) {
                    tc12ac.setVisibility(View.VISIBLE);
                    tc12kn.setVisibility(View.GONE);
                    tc12kn.setText(null);
                } else if (i == R.id.tc12b) {
                    tc12kn.setVisibility(View.VISIBLE);
                    tc12ac.setVisibility(View.GONE);
                    tc12ac.setText(null);
                } else {
                    tc12ac.setVisibility(View.GONE);
                    tc12ac.setText(null);
                    tc12kn.setVisibility(View.GONE);
                    tc12kn.setText(null);
                }
            }
        });

//        13
        tc13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.tc13a) {
                    fldGrptc14.setVisibility(View.VISIBLE);
                } else {
                    fldGrptc14.setVisibility(View.GONE);
                    tc14a.setText(null);
                    tc14b.setText(null);
                    tc14c.setText(null);
                    tc14d.setText(null);
                    tc14e.setText(null);
                    tc14f.setText(null);
                }
            }
        });

//        16
        tc1688.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    tc1688x.setVisibility(View.VISIBLE);
                } else {
                    tc1688x.setVisibility(View.GONE);
                    tc1688x.setText(null);
                }
            }
        });


//      17
        tc17888.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    tc17.setText(null);
                    tc17.setVisibility(View.GONE);
                } else {
                    tc17.setVisibility(View.VISIBLE);
                }
            }
        });


       /* td06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (td06a.isChecked()) {
                    fldGrptd19.setVisibility(View.VISIBLE);

                } else {
                    fldGrptd19.setVisibility(View.GONE);
                    td07.setText(null);
                }
            }
        });*/

        tc18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (tc18a.isChecked()) {
                    fldGrptc18.setVisibility(View.VISIBLE);

                } else {
                    fldGrptc18.setVisibility(View.GONE);
                    tc19.setText(null);
                }
            }
        });

        tc20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (tc20a.isChecked()) {
                    fldGrptc20.setVisibility(View.VISIBLE);

                } else {
                    fldGrptc20.setVisibility(View.GONE);
                    tc21.setText(null);
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

                /*if (MainApp.TotalMWRACount > 0) {
                    startActivity(new Intent(this, SectionDActivity.class));
                } else if (MainApp.TotalDeceasedMotherCount > 0) {
                    startActivity(new Intent(this, SectionEActivity.class));
                } else if (MainApp.TotalDeceasedChildCount > 0) {
                    startActivity(new Intent(this, SectionFActivity.class));
                } else {
                    startActivity(new Intent(this, SectionGActivity.class));
                }*/
                if (MainApp.TotalDeceasedChildCount > 0) {
                    Intent secNext = new Intent(this, SectionFActivity.class);
                    startActivity(secNext);
                } else if (MainApp.TotalChildCount > 0) {
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
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
//        return true;

    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sC = new JSONObject();

        sC.put("po01", tc01a.isChecked() ? "1" : tc01b.isChecked() ? "2" : tc01c.isChecked() ? "3"
                : tc01d.isChecked() ? "4" : tc01e.isChecked() ? "5" : tc01f.isChecked() ? "6"
                : tc01g.isChecked() ? "7" : tc01h.isChecked() ? "8" : tc01i.isChecked() ? "9" : tc01j.isChecked() ? "10"
                : tc01k.isChecked() ? "11" : tc01l.isChecked() ? "12" : "0");

        sC.put("po02", tc02a.isChecked() ? "1" : tc02b.isChecked() ? "2" : tc02c.isChecked() ? "3"
                : tc02d.isChecked() ? "4" : tc02e.isChecked() ? "5" : tc02f.isChecked() ? "6"
                : tc02g.isChecked() ? "7" : tc02h.isChecked() ? "8" : tc02i.isChecked() ? "9" : tc02j.isChecked() ? "10"
                : tc02k.isChecked() ? "11" : tc02l.isChecked() ? "12" : tc02m.isChecked() ? "13"
                : tc02n.isChecked() ? "14" : tc02o.isChecked() ? "15" : "0");

        sC.put("po03", tc03a.isChecked() ? "1" : tc03b.isChecked() ? "2" : tc03c.isChecked() ? "3"
                : tc03d.isChecked() ? "4" : tc03e.isChecked() ? "5" : tc03f.isChecked() ? "6"
                : tc03g.isChecked() ? "7" : tc03h.isChecked() ? "8" : tc03i.isChecked() ? "9" : tc03j.isChecked() ? "10"
                : tc03k.isChecked() ? "11" : tc03l.isChecked() ? "12" : tc03m.isChecked() ? "13"
                : tc03n.isChecked() ? "14" : tc03o.isChecked() ? "15" : tc03p.isChecked() ? "16"
                : tc03q.isChecked() ? "17" : "0");

        sC.put("po04", tc04.getText().toString());
        sC.put("po05", tc05a.isChecked() ? "1" : tc05b.isChecked() ? "2"
                : tc0588.isChecked() ? "88" : "0");
        sC.put("po0588x", tc0588x.getText().toString());
        sC.put("po06", tc06a.isChecked() ? "1" : tc06b.isChecked() ? "2"
                : tc06c.isChecked() ? "3" : tc06d.isChecked() ? "4"
                : tc0688.isChecked() ? "88" : "0");
        sC.put("po0688x", tc0688x.getText().toString());
        sC.put("po07", tc07a.isChecked() ? "1" : tc07b.isChecked() ? "2" : tc07c.isChecked() ? "3"
                : tc07d.isChecked() ? "4" : tc07e.isChecked() ? "5" : tc07f.isChecked() ? "6"
                : tc07g.isChecked() ? "7" : tc07h.isChecked() ? "8" : tc07i.isChecked() ? "9"
                : tc07j.isChecked() ? "10" : tc07k.isChecked() ? "11" : tc07l.isChecked() ? "12"
                : tc0788.isChecked() ? "88" : "0");
        sC.put("po0788x", tc0788x.getText().toString());

        sC.put("po08a", tc08aa.isChecked() ? "1" : tc08ab.isChecked() ? "2" : "0");
        sC.put("po08b", tc08ba.isChecked() ? "1" : tc08bb.isChecked() ? "2" : "0");
        sC.put("po08c", tc08ca.isChecked() ? "1" : tc08cb.isChecked() ? "2" : "0");
        sC.put("po08d", tc08da.isChecked() ? "1" : tc08db.isChecked() ? "2" : "0");
        sC.put("po08e", tc08ea.isChecked() ? "1" : tc08eb.isChecked() ? "2" : "0");
        sC.put("po08f", tc08fa.isChecked() ? "1" : tc08fb.isChecked() ? "2" : "0");
        sC.put("po08g", tc08ga.isChecked() ? "1" : tc08gb.isChecked() ? "2" : "0");
        sC.put("po08h", tc08ha.isChecked() ? "1" : tc08hb.isChecked() ? "2" : "0");
        sC.put("po08i", tc08ia.isChecked() ? "1" : tc08ib.isChecked() ? "2" : "0");
        sC.put("po08j", tc08ja.isChecked() ? "1" : tc08jb.isChecked() ? "2" : "0");
        sC.put("po08k", tc08ka.isChecked() ? "1" : tc08kb.isChecked() ? "2" : "0");
        sC.put("po08l", tc08la.isChecked() ? "1" : tc08lb.isChecked() ? "2" : "0");
        sC.put("po08m", tc08ma.isChecked() ? "1" : tc08mb.isChecked() ? "2" : "0");
        sC.put("po08n", tc08na.isChecked() ? "1" : tc08nb.isChecked() ? "2" : "0");
        sC.put("po08o", tc08oa.isChecked() ? "1" : tc08ob.isChecked() ? "2" : "0");
        sC.put("po08p", tc08pa.isChecked() ? "1" : tc08pb.isChecked() ? "2" : "0");
        sC.put("po08q", tc08qa.isChecked() ? "1" : tc08qb.isChecked() ? "2" : "0");
        sC.put("po08r", tc08ra.isChecked() ? "1" : tc08rb.isChecked() ? "2" : "0");
        sC.put("po08s", tc08sa.isChecked() ? "1" : tc08sb.isChecked() ? "2" : "0");

        sC.put("po09a", tc09aa.isChecked() ? "1" : tc09ab.isChecked() ? "2" : "0");
        sC.put("po09b", tc09ba.isChecked() ? "1" : tc09bb.isChecked() ? "2" : "0");
        sC.put("po09c", tc09ca.isChecked() ? "1" : tc09cb.isChecked() ? "2" : "0");
        sC.put("po09d", tc09da.isChecked() ? "1" : tc09db.isChecked() ? "2" : "0");
        sC.put("po09e", tc09ea.isChecked() ? "1" : tc09eb.isChecked() ? "2" : "0");
        sC.put("po09f", tc09fa.isChecked() ? "1" : tc09fb.isChecked() ? "2" : "0");
        sC.put("po09g", tc09ga.isChecked() ? "1" : tc09gb.isChecked() ? "2" : "0");
        sC.put("po09h", tc09ha.isChecked() ? "1" : tc09hb.isChecked() ? "2" : "0");
        sC.put("po09i", tc09ia.isChecked() ? "1" : tc09ib.isChecked() ? "2" : "0");

        sC.put("po10", tc10a.isChecked() ? "1" : tc10b.isChecked() ? "2" : "0");
        sC.put("po11", tc11a.isChecked() ? "1" : tc11b.isChecked() ? "2" : "0");

        sC.put("po12", tc12a.isChecked() ? "1" : tc12b.isChecked() ? "2"
                : tc12888.isChecked() ? "888" : "0");
        sC.put("po12ac", tc12ac.getText().toString());
        sC.put("po12kn", tc12kn.getText().toString());

        sC.put("po13", tc13a.isChecked() ? "1" : tc13b.isChecked() ? "2" : "0");

        sC.put("po14a", tc14a.getText().toString());
        sC.put("po14b", tc14b.getText().toString());
        sC.put("po14c", tc14c.getText().toString());
        sC.put("po14d", tc14d.getText().toString());
        sC.put("po14e", tc14e.getText().toString());
        sC.put("po14f", tc14f.getText().toString());

        sC.put("po15", tc15a.isChecked() ? "1" : tc15b.isChecked() ? "2"
                : tc15888.isChecked() ? "888" : "0");

        sC.put("po16", tc16a.isChecked() ? "1" : tc16b.isChecked() ? "2" : tc16c.isChecked() ? "3"
                : tc16d.isChecked() ? "4" : tc16e.isChecked() ? "5" : tc16f.isChecked() ? "6"
                : tc16g.isChecked() ? "7" : tc16h.isChecked() ? "8" : tc1688.isChecked() ? "88"
                : "0");
        sC.put("po1688x", tc1688x.getText().toString());

        sC.put("po17", tc17888.isChecked() ? "888" : tc17.getText().toString());

        sC.put("po18", tc18a.isChecked() ? "1" : tc18b.isChecked() ? "2"
                : "0");
        sC.put("po19", tc19.getText().toString());

      /*  if (td06a.isChecked()) {
            MainApp.TotalDeceasedMotherCount = Integer.valueOf(td07.getText().toString().isEmpty() ? "0" : td07.getText().toString());
        }
*/
        sC.put("po20", tc20a.isChecked() ? "1" : tc20b.isChecked() ? "2"
                : "0");
        sC.put("po21", tc21.getText().toString());

        if (tc20a.isChecked()) {
            MainApp.TotalDeceasedChildCount = Integer.valueOf(tc21.getText().toString().isEmpty() ? "0" : tc21.getText().toString());
        }

        MainApp.fc.setsC(String.valueOf(sC));
    }

    public boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        01
        if (tc01.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc01), Toast.LENGTH_SHORT).show();
            tc01b.setError("This data is Required!");    // Set Error on last radio button
            tc01b.setFocusable(true);
            tc01b.setFocusableInTouchMode(true);
            tc01b.requestFocus();
            Log.i(TAG, "po01: This data is Required!");
            return false;
        } else {
            tc01b.setError(null);
        }

//        02
        if (tc02.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc02), Toast.LENGTH_SHORT).show();
            tc02b.setError("This data is Required!");    // Set Error on last radio button
            tc02b.setFocusable(true);
            tc02b.setFocusableInTouchMode(true);
            tc02b.requestFocus();
            Log.i(TAG, "po02: This data is Required!");
            return false;
        } else {
            tc02b.setError(null);
        }

//        03
        if (tc03.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc03), Toast.LENGTH_SHORT).show();
            tc03b.setError("This data is Required!");    // Set Error on last radio button
            tc03b.setFocusable(true);
            tc03b.setFocusableInTouchMode(true);
            tc03b.requestFocus();
            Log.i(TAG, "po03: This data is Required!");
            return false;
        } else {
            tc03b.setError(null);
        }

//        04
        if (tc04.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc04), Toast.LENGTH_SHORT).show();
            tc04.setError("This data is Required! ");    // Set Error on last radio button
            tc04.requestFocus();
            Log.i(TAG, "po04: This data is Required!");
            return false;
        } else {
            tc04.setError(null);
        }

        if (Integer.valueOf(tc04.getText().toString()) < 1 || Integer.valueOf(tc04.getText().toString()) > 30) {
            Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.tc04), Toast.LENGTH_SHORT).show();
            tc04.setError("Range is 1 to 30");    // Set Error on last radio button
            tc04.requestFocus();
            Log.i(TAG, "po04: Range is 1 to 30");
            return false;
        } else {
            tc04.setError(null);
        }

//        05
        if (tc05.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc05), Toast.LENGTH_SHORT).show();
            tc0588.setError("This data is Required!");    // Set Error on last radio button
            tc05a.setFocusable(true);
            tc05a.setFocusableInTouchMode(true);
            tc05a.requestFocus();
            Log.i(TAG, "po05: This data is Required!");
            return false;
        } else {
            tc0588.setError(null);
        }
        if (tc0588.isChecked() && tc0588x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
            tc0588x.setError("This data is Required! ");    // Set Error on last radio button
            tc0588x.requestFocus();
            Log.i(TAG, "po05: This data is Required!");
            return false;
        } else {
            tc0588x.setError(null);
        }


//        06
        if (tc06.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.td06), Toast.LENGTH_SHORT).show();
            tc0688.setError("This data is Required!");    // Set Error on last radio button
            tc06a.setFocusable(true);
            tc06a.setFocusableInTouchMode(true);
            tc06a.requestFocus();
            Log.i(TAG, "td06: This data is Required!");
            return false;
        } else {
            tc0688.setError(null);
        }
        if (tc0688.isChecked() && tc0688x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
            tc0688x.setError("This data is Required! ");    // Set Error on last radio button
            tc0688x.requestFocus();
            Log.i(TAG, "td06: This data is Required!");
            return false;
        } else {
            tc0688x.setError(null);
        }


//        07
        if (tc07.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc07), Toast.LENGTH_SHORT).show();
            tc0788.setError("This data is Required!");    // Set Error on last radio button
            tc07a.setFocusable(true);
            tc07a.setFocusableInTouchMode(true);
            tc07a.requestFocus();
            Log.i(TAG, "po07: This data is Required!");
            return false;
        } else {
            tc0788.setError(null);
        }
        if (tc0788.isChecked() && tc0788x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
            tc0788x.setError("This data is Required! ");    // Set Error on last radio button
            tc0788x.requestFocus();
            Log.i(TAG, "po07: This data is Required!");
            return false;
        } else {
            tc0788x.setError(null);
        }


//        08a
        if (tc08a.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08a), Toast.LENGTH_SHORT).show();
            tc08ab.setError("This data is Required!");    // Set Error on last radio button
            tc08ab.setFocusable(true);
            tc08ab.setFocusableInTouchMode(true);
            tc08ab.requestFocus();
            Log.i(TAG, "po08a: This data is Required!");
            return false;
        } else {
            tc08ab.setError(null);
        }
//        08b
        if (tc08b.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08b), Toast.LENGTH_SHORT).show();
            tc08bb.setError("This data is Required!");    // Set Error on last radio button
            tc08bb.setFocusable(true);
            tc08bb.setFocusableInTouchMode(true);
            tc08bb.requestFocus();
            Log.i(TAG, "po08b: This data is Required!");
            return false;
        } else {
            tc08bb.setError(null);
        }
//        08c
        if (tc08c.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08c), Toast.LENGTH_SHORT).show();
            tc08cb.setError("This data is Required!");    // Set Error on last radio button
            tc08cb.setFocusable(true);
            tc08cb.setFocusableInTouchMode(true);
            tc08cb.requestFocus();
            Log.i(TAG, "po08c: This data is Required!");
            return false;
        } else {
            tc08cb.setError(null);
        }
//        08d
        if (tc08d.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08d), Toast.LENGTH_SHORT).show();
            tc08db.setError("This data is Required!");    // Set Error on last radio button
            tc08db.setFocusable(true);
            tc08db.setFocusableInTouchMode(true);
            tc08db.requestFocus();
            Log.i(TAG, "po08d: This data is Required!");
            return false;
        } else {
            tc08db.setError(null);
        }
//        08e
        if (tc08e.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08e), Toast.LENGTH_SHORT).show();
            tc08eb.setError("This data is Required!");    // Set Error on last radio button
            tc08eb.setFocusable(true);
            tc08eb.setFocusableInTouchMode(true);
            tc08eb.requestFocus();
            Log.i(TAG, "po08e: This data is Required!");
            return false;
        } else {
            tc08eb.setError(null);
        }
//        08f
        if (tc08f.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08f), Toast.LENGTH_SHORT).show();
            tc08fb.setError("This data is Required!");    // Set Error on last radio button
            tc08fb.setFocusable(true);
            tc08fb.setFocusableInTouchMode(true);
            tc08fb.requestFocus();
            Log.i(TAG, "po08f: This data is Required!");
            return false;
        } else {
            tc08fb.setError(null);
        }
//        08g
        if (tc08g.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08g), Toast.LENGTH_SHORT).show();
            tc08gb.setError("This data is Required!");    // Set Error on last radio button
            tc08gb.setFocusable(true);
            tc08gb.setFocusableInTouchMode(true);
            tc08gb.requestFocus();
            Log.i(TAG, "po08g: This data is Required!");
            return false;
        } else {
            tc08gb.setError(null);
        }
//        08h
        if (tc08h.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08h), Toast.LENGTH_SHORT).show();
            tc08hb.setError("This data is Required!");    // Set Error on last radio button
            tc08hb.setFocusable(true);
            tc08hb.setFocusableInTouchMode(true);
            tc08hb.requestFocus();
            Log.i(TAG, "po08h: This data is Required!");
            return false;
        } else {
            tc08hb.setError(null);
        }
//        08i
        if (tc08i.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08i), Toast.LENGTH_SHORT).show();
            tc08ib.setError("This data is Required!");    // Set Error on last radio button
            tc08ib.setFocusable(true);
            tc08ib.setFocusableInTouchMode(true);
            tc08ib.requestFocus();
            Log.i(TAG, "po08i: This data is Required!");
            return false;
        } else {
            tc08ib.setError(null);
        }
//        08j
        if (tc08j.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08j), Toast.LENGTH_SHORT).show();
            tc08jb.setError("This data is Required!");    // Set Error on last radio button
            tc08jb.setFocusable(true);
            tc08jb.setFocusableInTouchMode(true);
            tc08jb.requestFocus();
            Log.i(TAG, "po08j: This data is Required!");
            return false;
        } else {
            tc08jb.setError(null);
        }
//        08k
        if (tc08k.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08k), Toast.LENGTH_SHORT).show();
            tc08kb.setError("This data is Required!");    // Set Error on last radio button
            tc08kb.setFocusable(true);
            tc08kb.setFocusableInTouchMode(true);
            tc08kb.requestFocus();
            Log.i(TAG, "po08k: This data is Required!");
            return false;
        } else {
            tc08kb.setError(null);
        }
//        08l
        if (tc08l.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08l), Toast.LENGTH_SHORT).show();
            tc08lb.setError("This data is Required!");    // Set Error on last radio button
            tc08lb.setFocusable(true);
            tc08lb.setFocusableInTouchMode(true);
            tc08lb.requestFocus();
            Log.i(TAG, "po08l: This data is Required!");
            return false;
        } else {
            tc08lb.setError(null);
        }
//        08m
        if (tc08m.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08m), Toast.LENGTH_SHORT).show();
            tc08mb.setError("This data is Required!");    // Set Error on last radio button
            tc08mb.setFocusable(true);
            tc08mb.setFocusableInTouchMode(true);
            tc08mb.requestFocus();
            Log.i(TAG, "po08m: This data is Required!");
            return false;
        } else {
            tc08mb.setError(null);
        }
//        08n
        if (tc08n.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08n), Toast.LENGTH_SHORT).show();
            tc08nb.setError("This data is Required!");    // Set Error on last radio button
            tc08nb.setFocusable(true);
            tc08nb.setFocusableInTouchMode(true);
            tc08nb.requestFocus();
            Log.i(TAG, "po08n: This data is Required!");
            return false;
        } else {
            tc08nb.setError(null);
        }
//        08o
        if (tc08o.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08o), Toast.LENGTH_SHORT).show();
            tc08ob.setError("This data is Required!");    // Set Error on last radio button
            tc08ob.setFocusable(true);
            tc08ob.setFocusableInTouchMode(true);
            tc08ob.requestFocus();
            Log.i(TAG, "po08o: This data is Required!");
            return false;
        } else {
            tc08ob.setError(null);
        }
//        08p
        if (tc08p.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08p), Toast.LENGTH_SHORT).show();
            tc08pb.setError("This data is Required!");    // Set Error on last radio button
            tc08pb.setFocusable(true);
            tc08pb.setFocusableInTouchMode(true);
            tc08pb.requestFocus();
            Log.i(TAG, "po08p: This data is Required!");
            return false;
        } else {
            tc08pb.setError(null);
        }
//        08q
        if (tc08q.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08q), Toast.LENGTH_SHORT).show();
            tc08qb.setError("This data is Required!");    // Set Error on last radio button
            tc08qb.setFocusable(true);
            tc08qb.setFocusableInTouchMode(true);
            tc08qb.requestFocus();
            Log.i(TAG, "po08q: This data is Required!");
            return false;
        } else {
            tc08qb.setError(null);
        }
//        08r
        if (tc08r.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08r), Toast.LENGTH_SHORT).show();
            tc08rb.setError("This data is Required!");    // Set Error on last radio button
            tc08rb.setFocusable(true);
            tc08rb.setFocusableInTouchMode(true);
            tc08rb.requestFocus();
            Log.i(TAG, "po08r: This data is Required!");
            return false;
        } else {
            tc08rb.setError(null);
        }

        if (tc08s.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc08s), Toast.LENGTH_SHORT).show();
            tc08sb.setError("This data is Required!");    // Set Error on last radio button
            tc08sb.setFocusable(true);
            tc08sb.setFocusableInTouchMode(true);
            tc08sb.requestFocus();
            Log.i(TAG, "po08s: This data is Required!");
            return false;
        } else {
            tc08sb.setError(null);
        }


//        09a
        if (tc09a.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc09a), Toast.LENGTH_SHORT).show();
            tc09ab.setError("This data is Required!");    // Set Error on last radio button
            tc09ab.setFocusable(true);
            tc09ab.setFocusableInTouchMode(true);
            tc09ab.requestFocus();
            Log.i(TAG, "po09a: This data is Required!");
            return false;
        } else {
            tc09ab.setError(null);
        }
//        09b
        if (tc09b.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc09b), Toast.LENGTH_SHORT).show();
            tc09bb.setError("This data is Required!");    // Set Error on last radio button
            tc09bb.setFocusable(true);
            tc09bb.setFocusableInTouchMode(true);
            tc09bb.requestFocus();
            Log.i(TAG, "po09b: This data is Required!");
            return false;
        } else {
            tc09bb.setError(null);
        }
//        09c
        if (tc09c.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc09c), Toast.LENGTH_SHORT).show();
            tc09cb.setError("This data is Required!");    // Set Error on last radio button
            tc09cb.setFocusable(true);
            tc09cb.setFocusableInTouchMode(true);
            tc09cb.requestFocus();
            Log.i(TAG, "po09c: This data is Required!");
            return false;
        } else {
            tc09cb.setError(null);
        }
//        09d
        if (tc09d.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc09d), Toast.LENGTH_SHORT).show();
            tc09db.setError("This data is Required!");    // Set Error on last radio button
            tc09db.setFocusable(true);
            tc09db.setFocusableInTouchMode(true);
            tc09db.requestFocus();
            Log.i(TAG, "po09d: This data is Required!");
            return false;
        } else {
            tc09db.setError(null);
        }
//        09e
        if (tc09e.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc09e), Toast.LENGTH_SHORT).show();
            tc09eb.setError("This data is Required!");    // Set Error on last radio button
            tc09eb.setFocusable(true);
            tc09eb.setFocusableInTouchMode(true);
            tc09eb.requestFocus();
            Log.i(TAG, "po09e: This data is Required!");
            return false;
        } else {
            tc09eb.setError(null);
        }
//        09f
        if (tc09f.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc09f), Toast.LENGTH_SHORT).show();
            tc09fb.setError("This data is Required!");    // Set Error on last radio button
            tc09fb.setFocusable(true);
            tc09fb.setFocusableInTouchMode(true);
            tc09fb.requestFocus();
            Log.i(TAG, "po09f: This data is Required!");
            return false;
        } else {
            tc09fb.setError(null);
        }
//        09g
        if (tc09g.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc09g), Toast.LENGTH_SHORT).show();
            tc09gb.setError("This data is Required!");    // Set Error on last radio button
            tc09gb.setFocusable(true);
            tc09gb.setFocusableInTouchMode(true);
            tc09gb.requestFocus();
            Log.i(TAG, "po09g: This data is Required!");
            return false;
        } else {
            tc09gb.setError(null);
        }
//        09h
        if (tc09h.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc09h), Toast.LENGTH_SHORT).show();
            tc09hb.setError("This data is Required!");    // Set Error on last radio button
            tc09hb.setFocusable(true);
            tc09hb.setFocusableInTouchMode(true);
            tc09hb.requestFocus();
            Log.i(TAG, "po09h: This data is Required!");
            return false;
        } else {
            tc09hb.setError(null);
        }
//        09i
        if (tc09i.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc09i), Toast.LENGTH_SHORT).show();
            tc09ib.setError("This data is Required!");    // Set Error on last radio button
            tc09ib.setFocusable(true);
            tc09ib.setFocusableInTouchMode(true);
            tc09ib.requestFocus();
            Log.i(TAG, "po09i: This data is Required!");
            return false;
        } else {
            tc09ib.setError(null);
        }

//        10
        if (tc10.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc10), Toast.LENGTH_SHORT).show();
            tc10b.setError("This data is Required!");    // Set Error on last radio button
            tc10b.setFocusable(true);
            tc10b.setFocusableInTouchMode(true);
            tc10b.requestFocus();
            Log.i(TAG, "po10: This data is Required!");
            return false;
        } else {
            tc10b.setError(null);
        }

//        11
        if (tc11.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc11), Toast.LENGTH_SHORT).show();
            tc11b.setError("This data is Required!");    // Set Error on last radio button
            tc11b.setFocusable(true);
            tc11b.setFocusableInTouchMode(true);
            tc11b.requestFocus();
            Log.i(TAG, "po11: This data is Required!");
            return false;
        } else {
            tc11b.setError(null);
        }

        if (tc11a.isChecked()) {

//        12
            if (tc12.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc12), Toast.LENGTH_SHORT).show();
                tc12888.setError("This data is Required!");    // Set Error on last radio button
                tc12a.setFocusable(true);
                tc12a.setFocusableInTouchMode(true);
                tc12a.requestFocus();
                Log.i(TAG, "po12: This data is Required!");
                return false;
            } else {
                tc12888.setError(null);
            }
            if (tc12a.isChecked()) {
                if (tc12ac.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc12a), Toast.LENGTH_SHORT).show();
                    tc12ac.setError("This data is Required! ");    // Set Error on last radio button
                    tc12ac.requestFocus();
                    Log.i(TAG, "po12ac: This data is Required!");
                    return false;
                } else {
                    tc12ac.setError(null);
                }
                if (Integer.valueOf(tc12ac.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc12a), Toast.LENGTH_SHORT).show();
                    tc12ac.setError("Greater then 0! ");    // Set Error on last radio button
                    tc12ac.requestFocus();
                    Log.i(TAG, "po12ac: Greater then 0!");
                    return false;
                } else {
                    tc12ac.setError(null);
                }
            }
            if (tc12b.isChecked()) {
                if (tc12kn.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc12b), Toast.LENGTH_SHORT).show();
                    tc12kn.setError("This data is Required! ");    // Set Error on last radio button
                    tc12kn.requestFocus();
                    Log.i(TAG, "po12kn: This data is Required!");
                    return false;
                } else {
                    tc12kn.setError(null);
                }
                if (Integer.valueOf(tc12kn.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc12b), Toast.LENGTH_SHORT).show();
                    tc12kn.setError("Greater then 0! ");    // S et Error on last radio button
                    tc12kn.requestFocus();
                    Log.i(TAG, "po12kn: Greater then 0!");
                    return false;
                } else {
                    tc12kn.setError(null);
                }
            }

        }


//        13
        if (tc13.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc13), Toast.LENGTH_SHORT).show();
            tc13b.setError("This data is Required!");    // Set Error on last radio button
            tc13b.setFocusable(true);
            tc13b.setFocusableInTouchMode(true);
            tc13b.requestFocus();
            Log.i(TAG, "po13: This data is Required!");
            return false;
        } else {
            tc13b.setError(null);
        }

//        14


        if (tc13a.isChecked()) {
            if (tc14a.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc14a), Toast.LENGTH_SHORT).show();
                tc14a.setError("This data is Required! ");    // Set Error on last radio button
                tc14a.requestFocus();
                Log.i(TAG, "po14a: This data is Required!");
                return false;
            } else {
                tc14a.setError(null);
            }
            if (tc14b.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc14b), Toast.LENGTH_SHORT).show();
                tc14b.setError("This data is Required! ");    // Set Error on last radio button
                tc14b.requestFocus();
                Log.i(TAG, "po14b: This data is Required!");
                return false;
            } else {
                tc14b.setError(null);
            }
            if (tc14c.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc14c), Toast.LENGTH_SHORT).show();
                tc14c.setError("This data is Required! ");    // Set Error on last radio button
                tc14c.requestFocus();
                Log.i(TAG, "po14c: This data is Required!");
                return false;
            } else {
                tc14c.setError(null);
            }
            if (tc14d.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc14d), Toast.LENGTH_SHORT).show();
                tc14d.setError("This data is Required! ");    // Set Error on last radio button
                tc14d.requestFocus();
                Log.i(TAG, "po14d: This data is Required!");
                return false;
            } else {
                tc14d.setError(null);
            }
            if (tc14e.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc14e), Toast.LENGTH_SHORT).show();
                tc14e.setError("This data is Required! ");    // Set Error on last radio button
                tc14e.requestFocus();
                Log.i(TAG, "po14e: This data is Required!");
                return false;
            } else {
                tc14e.setError(null);
            }
            if (tc14f.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc14f), Toast.LENGTH_SHORT).show();
                tc14f.setError("This data is Required! ");    // Set Error on last radio button
                tc14f.requestFocus();
                Log.i(TAG, "po14f: This data is Required!");
                return false;
            } else {
                tc14f.setError(null);
            }

            int totalAnimals = Integer.valueOf(tc14a.getText().toString()) + Integer.valueOf(tc14b.getText().toString()) +
                    Integer.valueOf(tc14c.getText().toString()) + Integer.valueOf(tc14d.getText().toString()) +
                    Integer.valueOf(tc14e.getText().toString()) + Integer.valueOf(tc14f.getText().toString());

            if (totalAnimals == 0) {
                tc14a.setError("Not be zero as mentioned in Q13.");    // Set Error on last radio button
            } else {
                tc14a.setError(null);
            }

        }

//        15
        if (tc15.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc15), Toast.LENGTH_SHORT).show();
            tc15888.setError("This data is Required!");    // Set Error on last radio button
            tc15a.setFocusable(true);
            tc15a.setFocusableInTouchMode(true);
            tc15a.requestFocus();
            Log.i(TAG, "po15: This data is Required!");
            return false;
        } else {
            tc15888.setError(null);
        }

//        16
        if (tc16.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc16), Toast.LENGTH_SHORT).show();
            tc1688.setError("This data is Required!");    // Set Error on last radio button
            tc16a.setFocusable(true);
            tc16a.setFocusableInTouchMode(true);
            tc16a.requestFocus();
            Log.i(TAG, "po16: This data is Required!");
            return false;
        } else {
            tc1688.setError(null);
        }
        if (tc1688.isChecked() && tc1688x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.other), Toast.LENGTH_SHORT).show();
            tc1688x.setError("This data is Required! ");    // Set Error on last radio button
            tc1688x.requestFocus();
            Log.i(TAG, "po1688: This data is Required!");
            return false;
        } else {
            tc1688x.setError(null);
        }

//        17
        if (!tc17888.isChecked() && tc17.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc17), Toast.LENGTH_SHORT).show();
            tc17888.setError("This data is Required!");    // Set Error on last radio button
            tc17888.requestFocus();
            Log.i(TAG, "po17: This data is Required!");
            return false;
        } else {
            tc17888.setError(null);
        }
        /*if (!tc17888.isChecked() && (Integer.valueOf(tc17.getText().toString()) < 1 ||
                Integer.valueOf(tc17.getText().toString()) >= 1000)) {
            Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.tc17), Toast.LENGTH_SHORT).show();
            tc17.setError("Range from 0 to 1000!");    // Set Error on last radio button

            Log.i(TAG, "po17: Range from 0 to 1000!");
            return false;
        } else {
            tc17.setError(null);
        }*/

       /* if (td06.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.td06), Toast.LENGTH_SHORT).show();
            td06b.setError("This data is Required!");    // Set Error on last radio button
            tc06b.setFocusable(true);
            tc06b.setFocusableInTouchMode(true);
            tc06b.requestFocus();
            Log.i(TAG, "td06: This data is Required!");
            return false;
        } else {
            td06b.setError(null);
        }

        if (td06a.isChecked()) {
            if (td07.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.td07), Toast.LENGTH_SHORT).show();
                td07.setError("This data is Required!");    // Set Error on last radio button
                td07.requestFocus();
                Log.i(TAG, "td07: This data is Required!");
                return false;
            } else {
                td07.setError(null);
            }
            if (Integer.valueOf(td07.getText().toString()) < 1) {
                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.td07), Toast.LENGTH_SHORT).show();
                td07.setError("Greater then 0!");    // Set Error on last radio button

                Log.i(TAG, "td07: Greater then 0!");
                return false;
            } else {
                td07.setError(null);
            }
        }*/
        /*18*/
        if (tc18.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc18), Toast.LENGTH_SHORT).show();
            tc18b.setError("This data is Required!");    // Set Error on last radio button
            tc18b.setFocusable(true);
            tc18b.setFocusableInTouchMode(true);
            tc18b.requestFocus();
            Log.i(TAG, "po18: This data is Required!");
            return false;
        } else {
            tc18b.setError(null);
        }
        /*19*/
        if (tc18a.isChecked()) {
            if (tc19.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc19), Toast.LENGTH_SHORT).show();
                tc19.setError("This data is Required!");    // Set Error on last radio button
                tc19.requestFocus();
                Log.i(TAG, "po19: This data is Required!");
                return false;
            } else {
                tc19.setError(null);
            }
            if (Integer.valueOf(tc19.getText().toString()) < 1) {
                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.tc19), Toast.LENGTH_SHORT).show();
                tc19.setError("Greater then 0!");    // Set Error on last radio button
                tc19.requestFocus();
                Log.i(TAG, "po19: Greater then 0!");
                return false;
            } else {
                tc19.setError(null);
            }
        }

        /*20*/

        if (tc20.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc20), Toast.LENGTH_SHORT).show();
            tc20b.setError("This data is Required!");    // Set Error on last radio button
            tc20b.setFocusable(true);
            tc20b.setFocusableInTouchMode(true);
            tc20b.requestFocus();
            Log.i(TAG, "po20: This data is Required!");
            return false;
        } else {
            tc20b.setError(null);
        }

        if (tc20a.isChecked()) {
            if (tc21.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.tc21), Toast.LENGTH_SHORT).show();
                tc21.setError("This data is Required!");    // Set Error on last radio button
                tc21.requestFocus();
                Log.i(TAG, "po21: This data is Required!");
                return false;
            } else {
                tc21.setError(null);
            }
            if (Integer.valueOf(tc21.getText().toString()) < 1) {
                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.tc21), Toast.LENGTH_SHORT).show();
                tc21.setError("Greater then 0!");    // Set Error on last radio button
                tc21.requestFocus();
                Log.i(TAG, "po21: Greater then 0!");
                return false;
            } else {
                tc21.setError(null);
            }
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity

            startActivity(new Intent(this, MainActivity.class));

        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }
    }
}
