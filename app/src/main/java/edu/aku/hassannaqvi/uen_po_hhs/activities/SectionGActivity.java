package edu.aku.hassannaqvi.uen_po_hhs.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_po_hhs.R;
import edu.aku.hassannaqvi.uen_po_hhs.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs.databinding.ActivitySectionGBinding;
import edu.aku.hassannaqvi.uen_po_hhs.validator.ClearClass;
import edu.aku.hassannaqvi.uen_po_hhs.validator.validatorClass;

public class SectionGActivity extends AppCompatActivity {

    ActivitySectionGBinding bi;

    private static final String TAG = SectionGActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g);
        bi.setCallback(this);


        bi.tg03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tg03g) {

                    bi.fldGrptg04.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrptg04, false);
                    bi.fldGrptg05.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrptg05, false);
                    bi.fldGrptg06.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrptg06, false);
                    bi.fldGrptg07.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrptg07, false);
                    bi.fldGrptg08.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrptg08, false);
                    bi.fldGrptg09.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrptg09, false);
                    bi.fldGrptg10.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrptg10, false);
                    bi.fldGrptg11.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrptg11, false);
                    bi.fldGrptg12.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrptg12, false);
                    bi.fldGrptg13.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrptg13, false);
                    bi.fldGrptg14.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrptg14, false);
                    bi.fldGrptg15.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrptg15, false);
                } else {
                    bi.fldGrptg04.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrptg04, true);
                    bi.fldGrptg05.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrptg05, true);
                    bi.fldGrptg06.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrptg06, true);
                    bi.fldGrptg07.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrptg07, true);
                    bi.fldGrptg08.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrptg08, true);
                    bi.fldGrptg09.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrptg09, true);
                    bi.fldGrptg10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrptg10, true);
                    bi.fldGrptg11.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrptg11, true);
                    bi.fldGrptg12.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrptg12, true);
                    bi.fldGrptg13.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrptg13, true);
                    bi.fldGrptg14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrptg14, true);
                    bi.fldGrptg15.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrptg15, true);
                }
            }
        });

        bi.tg05i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {

                    bi.tg05a.setChecked(false);
                    bi.tg05b.setChecked(false);
                    bi.tg05c.setChecked(false);
                    bi.tg05d.setChecked(false);
                    bi.tg05e.setChecked(false);
                    bi.tg05f.setChecked(false);
                    bi.tg05g.setChecked(false);
                    bi.tg05h.setChecked(false);
                    bi.tg05hx.setText(null);
                    bi.tg05hx.setVisibility(View.GONE);
                }
            }
        });

        bi.tg05a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg05i.setChecked(false);
                } else {
                    bi.tg05i.setChecked(true);
                }
            }
        });
        bi.tg05b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg05i.setChecked(false);
                } else {
                    bi.tg05i.setChecked(true);
                }
            }
        });

        bi.tg05c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg05i.setChecked(false);
                } else {
                    bi.tg05i.setChecked(true);
                }
            }
        });
        bi.tg05d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg05i.setChecked(false);
                } else {
                    bi.tg05i.setChecked(true);
                }
            }
        });
        bi.tg05e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg05i.setChecked(false);
                } else {
                    bi.tg05i.setChecked(true);
                }
            }
        });
        bi.tg05f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg05i.setChecked(false);
                } else {
                    bi.tg05i.setChecked(true);
                }
            }
        });

        bi.tg05g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg05i.setChecked(false);
                } else {
                    bi.tg05i.setChecked(true);
                }
            }
        });
        bi.tg05h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg05i.setChecked(false);
                    bi.tg05hx.setVisibility(View.VISIBLE);
                } else {
                    bi.tg05i.setChecked(true);
                    bi.tg05hx.setVisibility(View.GONE);
                    bi.tg05hx.setText(null);

                }
            }
        });

        bi.tg06q.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06a.setChecked(false);
                    bi.tg06b.setChecked(false);
                    bi.tg06c.setChecked(false);
                    bi.tg06d.setChecked(false);
                    bi.tg06e.setChecked(false);
                    bi.tg06f.setChecked(false);
                    bi.tg06g.setChecked(false);
                    bi.tg06h.setChecked(false);
                    bi.tg06i.setChecked(false);
                    bi.tg06j.setChecked(false);
                    bi.tg06k.setChecked(false);
                    bi.tg06l.setChecked(false);
                    bi.tg06m.setChecked(false);
                    bi.tg06n.setChecked(false);
                    bi.tg06o.setChecked(false);
                    bi.tg06p.setChecked(false);
                    bi.tg06px.setText(null);
                    bi.tg06px.setVisibility(View.GONE);
                }
            }
        });

        bi.tg06a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06q.setChecked(false);
                } else {
                    bi.tg06q.setChecked(true);
                }
            }
        });

        bi.tg06b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06q.setChecked(false);
                } else {
                    bi.tg06q.setChecked(true);
                }
            }
        });

        bi.tg06c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06q.setChecked(false);
                } else {
                    bi.tg06q.setChecked(true);
                }
            }
        });
        bi.tg06d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06q.setChecked(false);
                } else {
                    bi.tg06q.setChecked(true);
                }
            }
        });
        bi.tg06e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06q.setChecked(false);
                } else {
                    bi.tg06q.setChecked(true);
                }
            }
        });
        bi.tg06f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06q.setChecked(false);
                } else {
                    bi.tg06q.setChecked(true);
                }
            }
        });
        bi.tg06g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06q.setChecked(false);
                } else {
                    bi.tg06q.setChecked(true);
                }
            }
        });
        bi.tg06h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06q.setChecked(false);
                } else {
                    bi.tg06q.setChecked(true);
                }
            }
        });
        bi.tg06i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06q.setChecked(false);
                } else {
                    bi.tg06q.setChecked(true);
                }
            }
        });
        bi.tg06j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06q.setChecked(false);
                } else {
                    bi.tg06q.setChecked(true);
                }
            }
        });
        bi.tg06k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06q.setChecked(false);
                } else {
                    bi.tg06q.setChecked(true);
                }
            }
        });
        bi.tg06l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06q.setChecked(false);
                } else {
                    bi.tg06q.setChecked(true);
                }
            }
        });
        bi.tg06m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06q.setChecked(false);
                } else {
                    bi.tg06q.setChecked(true);
                }
            }
        });
        bi.tg06n.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06q.setChecked(false);
                } else {
                    bi.tg06q.setChecked(true);
                }
            }
        });
        bi.tg06o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06q.setChecked(false);
                } else {
                    bi.tg06q.setChecked(true);
                }
            }
        });
        bi.tg06p.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg06q.setChecked(false);
                    bi.tg06px.setVisibility(View.VISIBLE);
                } else {
                    bi.tg06q.setChecked(true);
                    bi.tg06px.setVisibility(View.GONE);
                    bi.tg06px.setText(null);
                }
            }
        });

        bi.tg07f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {

                    bi.tg07a.setChecked(false);
                    bi.tg07b.setChecked(false);
                    bi.tg07c.setChecked(false);
                    bi.tg07d.setChecked(false);
                    bi.tg07e.setChecked(false);
                    bi.tg07ex.setText(null);
                    bi.tg07ex.setVisibility(View.GONE);
                }
            }
        });

        bi.tg07a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg07f.setChecked(false);
                } else {
                    bi.tg07f.setChecked(true);
                }
            }
        });

        bi.tg07b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg07f.setChecked(false);
                } else {
                    bi.tg07f.setChecked(true);
                }
            }
        });

        bi.tg07c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg07f.setChecked(false);
                } else {
                    bi.tg07f.setChecked(true);
                }
            }
        });
        bi.tg07d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg07f.setChecked(false);
                } else {
                    bi.tg07f.setChecked(true);
                }
            }
        });
        bi.tg07e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg07f.setChecked(false);
                    bi.tg07ex.setVisibility(View.VISIBLE);
                } else {
                    bi.tg07f.setChecked(true);
                    bi.tg07ex.setVisibility(View.GONE);
                    bi.tg07ex.setText(null);
                }
            }
        });
        bi.tg0897.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg08a.setChecked(false);
                    bi.tg08b.setChecked(false);
                    bi.tg08c.setChecked(false);
                    bi.tg08d.setChecked(false);
                    bi.tg08e.setChecked(false);
                    bi.tg08f.setChecked(false);
                    bi.tg08g.setChecked(false);
                    bi.tg08h.setChecked(false);
                    bi.tg08i.setChecked(false);
                    bi.tg08j.setChecked(false);
                    bi.tg08k.setChecked(false);
                    bi.tg08l.setChecked(false);
                    bi.tg08m.setChecked(false);
                    bi.tg08n.setChecked(false);
                    bi.tg08o.setChecked(false);
                    bi.tg08p.setChecked(false);
                    bi.tg08q.setChecked(false);
                    bi.tg08r.setChecked(false);
                    bi.tg0896.setChecked(false);
                    bi.tg0896x.setText(null);
                    bi.tg0896x.setVisibility(View.GONE);
                }
            }
        });

        bi.tg08a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });
        bi.tg08b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });

        bi.tg08c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });

        bi.tg08d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });
        bi.tg08e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });
        bi.tg08f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });
        bi.tg08g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });
        bi.tg08h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });
        bi.tg08i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });
        bi.tg08j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });
        bi.tg08k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });
        bi.tg08l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });

        bi.tg08m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });
        bi.tg08n.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });
        bi.tg08o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });
        bi.tg08p.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });
        bi.tg08q.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });

        bi.tg08r.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                } else {
                    bi.tg0897.setChecked(true);
                }
            }
        });
        bi.tg0896.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg0897.setChecked(false);
                    bi.tg0896x.setVisibility(View.VISIBLE);
                } else {
                    bi.tg0897.setChecked(true);
                    bi.tg0896x.setVisibility(View.GONE);
                    bi.tg0896x.setText(null);
                }
            }
        });

        bi.tg09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tg09b) {
                    bi.fldGrptg10.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrptg10, false);
                } else {
                    bi.fldGrptg10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrptg10, true);

                }
            }
        });

        bi.tg10f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg10a.setChecked(false);
                    bi.tg10b.setChecked(false);
                    bi.tg10c.setChecked(false);
                    bi.tg10d.setChecked(false);
                    bi.tg10e.setChecked(false);
                    bi.tg10ex.setText(null);
                    bi.tg10ex.setVisibility(View.GONE);
                }
            }
        });

        bi.tg10a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg10f.setChecked(false);
                } else {
                    bi.tg10f.setChecked(true);
                }
            }
        });

        bi.tg10b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg10f.setChecked(false);
                } else {
                    bi.tg10f.setChecked(true);
                }
            }
        });

        bi.tg10c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg10f.setChecked(false);
                } else {
                    bi.tg10f.setChecked(true);
                }
            }
        });

        bi.tg10d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg10f.setChecked(false);
                } else {
                    bi.tg10f.setChecked(true);
                }
            }
        });

        bi.tg10e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.tg10f.setChecked(false);
                    bi.tg10ex.setVisibility(View.VISIBLE);
                } else {
                    bi.tg10f.setChecked(true);
                    bi.tg10ex.setVisibility(View.GONE);
                    bi.tg10ex.setText(null);
                }
            }
        });

        bi.tg13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.tg13a) {
                    bi.fldGrptg14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrptg14, true);
                    bi.fldGrptg15.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrptg15, false);
                }
                if (i == R.id.tg13b) {
                    bi.fldGrptg14.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrptg14, false);
                    bi.fldGrptg15.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrptg15, true);
                }

            }
        });

    }

    public void onBtnEndClick() {

        Toast.makeText(this, "Not Processing This Section", Toast.LENGTH_SHORT).show();

        Toast.makeText(this, "Starting Form Ending Section", Toast.LENGTH_SHORT).show();

        MainApp.endActivity(this, this);
    }


    public void onBtnContinueClick() {

        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                finish();
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSG();

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

        JSONObject sG = new JSONObject();

        sG.put("tg01", bi.tg01a.isChecked() ? "1" : bi.tg01b.isChecked() ? "2" : "0");
        sG.put("tg01x", bi.tg01bx.getText().toString());

        sG.put("tg02", bi.tg02a.isChecked() ? "1" : bi.tg02b.isChecked() ? "2" : "0");
        sG.put("tg03",
                bi.tg03a.isChecked() ? "1"
                        : bi.tg03b.isChecked() ? "2"
                        : bi.tg03c.isChecked() ? "3"
                        : bi.tg03d.isChecked() ? "4"
                        : bi.tg03d.isChecked() ? "5"
                        : bi.tg03e.isChecked() ? "5"
                        : bi.tg03f.isChecked() ? "6"
                        : bi.tg03g.isChecked() ? "7" : "0");

        sG.put("tg04a", bi.tg04a.isChecked() ? "1" : "0");
        sG.put("tg04b", bi.tg04b.isChecked() ? "2" : "0");
        sG.put("tg04c", bi.tg04c.isChecked() ? "3" : "0");
        sG.put("tg04d", bi.tg04d.isChecked() ? "4" : "0");
        sG.put("tg04e", bi.tg04e.isChecked() ? "5" : "0");
        sG.put("tg04ex", bi.tg04ex.getText().toString());
        sG.put("tg04f", bi.tg04f.isChecked() ? "7" : "0");
        sG.put("tg04fx", bi.tg04fx.getText().toString());
        sG.put("tg04g", bi.tg04f.isChecked() ? "8" : "0");
        sG.put("tg04gx", bi.tg04gx.getText().toString());
        sG.put("tg04h", bi.tg04h.isChecked() ? "9" : "0");
        sG.put("tg04hx", bi.tg04hx.getText().toString());
        sG.put("tg04i", bi.tg04i.isChecked() ? "96" : "0");
        sG.put("tg04ix", bi.tg04ix.getText().toString());

        sG.put("tg05a", bi.tg05a.isChecked() ? "1" : "0");
        sG.put("tg05b", bi.tg05b.isChecked() ? "2" : "0");
        sG.put("tg05c", bi.tg05c.isChecked() ? "3" : "0");
        sG.put("tg05d", bi.tg05d.isChecked() ? "4" : "0");
        sG.put("tg05e", bi.tg05e.isChecked() ? "5" : "0");
        sG.put("tg05f", bi.tg05f.isChecked() ? "6" : "0");
        sG.put("tg05g", bi.tg05g.isChecked() ? "7" : "0");
        sG.put("tg05h", bi.tg05h.isChecked() ? "96" : "0");
        sG.put("tg05hx", bi.tg05hx.getText().toString());
        sG.put("tg05i", bi.tg05i.isChecked() ? "97" : "0");

        sG.put("tg06a", bi.tg06a.isChecked() ? "1" : "0");
        sG.put("tg06b", bi.tg06b.isChecked() ? "2" : "0");
        sG.put("tg06c", bi.tg06c.isChecked() ? "3" : "0");
        sG.put("tg06d", bi.tg06d.isChecked() ? "4" : "0");
        sG.put("tg06e", bi.tg06e.isChecked() ? "5" : "0");
        sG.put("tg06f", bi.tg06f.isChecked() ? "6" : "0");
        sG.put("tg06g", bi.tg06g.isChecked() ? "7" : "0");
        sG.put("tg06h", bi.tg06h.isChecked() ? "8" : "0");
        sG.put("tg06i", bi.tg06i.isChecked() ? "9" : "0");
        sG.put("tg06j", bi.tg06j.isChecked() ? "10" : "0");
        sG.put("tg06k", bi.tg06k.isChecked() ? "12" : "0");
        sG.put("tg06l", bi.tg06l.isChecked() ? "13" : "0");
        sG.put("tg06m", bi.tg06m.isChecked() ? "14" : "0");
        sG.put("tg06n", bi.tg06n.isChecked() ? "15" : "0");
        sG.put("tg06o", bi.tg06o.isChecked() ? "16" : "0");
        sG.put("tg06p", bi.tg06p.isChecked() ? "96" : "0");
        sG.put("tg06px", bi.tg06px.getText().toString());
        sG.put("tg06q", bi.tg06q.isChecked() ? "97" : "0");

        sG.put("tg07a", bi.tg07a.isChecked() ? "1" : "0");
        sG.put("tg07b", bi.tg07b.isChecked() ? "2" : "0");
        sG.put("tg07c", bi.tg07c.isChecked() ? "3" : "0");
        sG.put("tg07d", bi.tg07d.isChecked() ? "4" : "0");
        sG.put("tg07e", bi.tg07e.isChecked() ? "96" : "0");
        sG.put("tg07ex", bi.tg07ex.getText().toString());
        sG.put("tg07f", bi.tg07f.isChecked() ? "97" : "0");

        sG.put("tg08a", bi.tg08a.isChecked() ? "1" : "0");
        sG.put("tg08b", bi.tg08b.isChecked() ? "2" : "0");
        sG.put("tg08c", bi.tg08c.isChecked() ? "3" : "0");
        sG.put("tg08d", bi.tg08d.isChecked() ? "4" : "0");
        sG.put("tg08e", bi.tg08e.isChecked() ? "5" : "0");
        sG.put("tg08f", bi.tg08f.isChecked() ? "6" : "0");
        sG.put("tg08g", bi.tg08g.isChecked() ? "7" : "0");
        sG.put("tg08h", bi.tg08h.isChecked() ? "8" : "0");
        sG.put("tg08i", bi.tg08i.isChecked() ? "9" : "0");
        sG.put("tg08j", bi.tg08j.isChecked() ? "10" : "0");
        sG.put("tg08k", bi.tg08k.isChecked() ? "12" : "0");
        sG.put("tg08l", bi.tg08l.isChecked() ? "13" : "0");
        sG.put("tg08m", bi.tg08m.isChecked() ? "14" : "0");
        sG.put("tg08n", bi.tg08n.isChecked() ? "15" : "0");
        sG.put("tg08o", bi.tg08o.isChecked() ? "16" : "0");
        sG.put("tg08p", bi.tg08p.isChecked() ? "17" : "0");
        sG.put("tg08q", bi.tg08q.isChecked() ? "18" : "0");
        sG.put("tg08r", bi.tg08r.isChecked() ? "19" : "0");
        sG.put("tg0896", bi.tg0896.isChecked() ? "96" : "0");
        sG.put("tg0896x", bi.tg0896x.getText().toString());
        sG.put("tg0897", bi.tg0897.isChecked() ? "97" : "0");

        sG.put("tg09", bi.tg09a.isChecked() ? "1" : bi.tg09b.isChecked() ? "2" : "0");

        sG.put("tg10a", bi.tg10a.isChecked() ? "1" : "0");
        sG.put("tg10b", bi.tg10b.isChecked() ? "2" : "0");
        sG.put("tg10c", bi.tg10c.isChecked() ? "3" : "0");
        sG.put("tg10d", bi.tg10d.isChecked() ? "4" : "0");
        sG.put("tg10e", bi.tg10e.isChecked() ? "96" : "0");
        sG.put("tg10ex", bi.tg10ex.getText().toString());
        sG.put("tg10f", bi.tg10f.isChecked() ? "97" : "0");

        sG.put("tg11", bi.tg11a.isChecked() ? "1"
                : bi.tg11b.isChecked() ? "2"
                : bi.tg11c.isChecked() ? "3"
                : bi.tg11d.isChecked() ? "4"
                : bi.tg11e.isChecked() ? "5"
                : bi.tg11f.isChecked() ? "6"
                : bi.tg11g.isChecked() ? "7"
                : bi.tg11h.isChecked() ? "8"
                : bi.tg11i.isChecked() ? "9"
                : bi.tg11j.isChecked() ? "10"
                : bi.tg11k.isChecked() ? "11"
                : bi.tg11l.isChecked() ? "12"
                : bi.tg11m.isChecked() ? "13"
                : bi.tg11n.isChecked() ? "96"
                : "0"

        );

        sG.put("tg11nx", bi.tg11nx.getText().toString());
        sG.put("tg12a", bi.tg12a.getText().toString());
        sG.put("tg12b", bi.tg12b.getText().toString());

        sG.put("tg13", bi.tg13a.isChecked() ? "1" : bi.tg13b.isChecked() ? "2" : "0");
        sG.put("tg14", bi.tg14x.getText().toString());
        sG.put("tg15", bi.tg15x.getText().toString());


        MainApp.fc.setsG(String.valueOf(sG));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    public boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();
        if (!validatorClass.EmptyRadioButton(this, bi.tg01, bi.tg01a, getString(R.string.tg01))) {
            return false;
        }
        if (bi.tg01a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.tg01bx, getString(R.string.tg01))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tg02, bi.tg02a, getString(R.string.tg02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tg03, bi.tg03a, getString(R.string.tg03))) {
            return false;
        }
        if (!bi.tg03g.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrptg04, bi.tg04a, getString(R.string.tg04))) {
                return false;
            }
            if (bi.tg04e.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.tg04ex, getString(R.string.tg04))) {
                    return false;
                }
            }
            if (bi.tg04f.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.tg04fx, getString(R.string.tg04))) {
                    return false;
                }
            }
            if (bi.tg04g.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.tg04gx, getString(R.string.tg04))) {
                    return false;
                }
            }
            if (bi.tg04h.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.tg04hx, getString(R.string.tg04))) {
                    return false;
                }
            }

            if (bi.tg04i.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.tg04ix, getString(R.string.tg04))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyCheckBox(this, bi.fldGrptg05, bi.tg05a, getString(R.string.tg05))) {
                return false;
            }
            if (!bi.tg05i.isChecked()) {
                if (bi.tg05h.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.tg05hx, getString(R.string.tg05))) {
                        return false;
                    }
                }
            }
            if (!validatorClass.EmptyCheckBox(this, bi.fldGrptg06, bi.tg06a, getString(R.string.tg06))) {
                return false;
            }
            if (!bi.tg06q.isChecked()) {
                if (bi.tg06p.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.tg06px, getString(R.string.tg06))) {
                        return false;
                    }
                }
            }
            if (!validatorClass.EmptyCheckBox(this, bi.fldGrptg07, bi.tg07a, getString(R.string.tg07))) {
                return false;
            }
            if (!bi.tg07f.isChecked()) {
                if (bi.tg07e.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.tg07ex, getString(R.string.tg07))) {
                        return false;
                    }
                }
            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrptg08, bi.tg08a, getString(R.string.tg08))) {
                return false;
            }

            if (!bi.tg0897.isChecked()) {
                if (bi.tg0896.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.tg0896x, getString(R.string.tg08))) {
                        return false;
                    }
                }
            }

            if (!validatorClass.EmptyRadioButton(this, bi.tg09, bi.tg09a, getString(R.string.tg09))) {
                return false;
            }

            if (bi.tg09a.isChecked()) {
                if (!validatorClass.EmptyCheckBox(this, bi.fldGrptg10, bi.tg10a, getString(R.string.tg10))) {
                    return false;
                }
                if(!bi.tg10f.isChecked()){
                    if (bi.tg10e.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.tg10ex, getString(R.string.tg10))) {
                            return false;
                        }
                    }
                }


            }
            if (!validatorClass.EmptyRadioButton(this, bi.tg11, bi.tg11a, getString(R.string.tg11))) {
                return false;
            }
            if (bi.tg11n.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.tg11nx, getString(R.string.tg11))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyTextBox(this, bi.tg12a, getString(R.string.tg12a))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.tg12b, getString(R.string.tg12b))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.tg13, bi.tg13a, getString(R.string.tg13))) {
                return false;
            }

            if (bi.tg13a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.tg14x, getString(R.string.tg14))) {
                    return false;
                }

            }
            if(bi.tg13b.isChecked()){
                return validatorClass.EmptyTextBox(this, bi.tg15x, getString(R.string.tg15));
            }




        }


        return true;
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }


}
