package edu.aku.hassannaqvi.uen_po_hhs_fl.ui.form2;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.ChildrenContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.LHWContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.TalukasContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.UCsContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF2Section01Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ClearClass;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;

public class F2Section01Activity extends AppCompatActivity {

    ActivityF2Section01Binding bi;

    private List<String> talukaNames, ucName, lhwNames;
    private List<String> talukaCodes, ucCode, lhwCodes;
    private DatabaseHelper db;
    private ChildrenContract cContract;

    String DAY;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_f2_section01);
        bi.setCallback(this);


        DAY = getIntent().getStringExtra("day");
        bi.dayHeading.setText("DAY " + (DAY.equals("7") ? "07" : "14"));
        this.setTitle(DAY.equals("7") ? "Form 02 (Follow Ups - 7 Day)" : "Form 02 (Follow Ups - 14 Day)");

        if (DAY.equals("14")) {
            bi.pofpa1597.setVisibility(View.VISIBLE);
        } else {
            bi.pofpa1597.setChecked(false);
            bi.pofpa1597.setVisibility(View.GONE);
        }

        initializingComponents();
        clickListener();


    }


    private void initializingComponents() {
        db = new DatabaseHelper(this);
        populateSpinner(this);

        bi.pofpa1597.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.llpofpa151a, null);
                    ClearClass.ClearAllFields(bi.llpofpa151b, null);
                    ClearClass.ClearAllFields(bi.llpofpa151c, null);
                    ClearClass.ClearAllFields(bi.llpofpa151d, null);
                    bi.llpofpa151a.setVisibility(View.GONE);
                    bi.llpofpa151b.setVisibility(View.GONE);
                    bi.llpofpa151c.setVisibility(View.GONE);
                    bi.llpofpa151d.setVisibility(View.GONE);
                    bi.pofpa152.setChecked(false);
                    bi.pofpa152.setTag("-1");
                } else {
                    bi.llpofpa151a.setVisibility(View.VISIBLE);
                    bi.llpofpa151b.setVisibility(View.VISIBLE);
                    bi.llpofpa151c.setVisibility(View.VISIBLE);
                    bi.llpofpa151d.setVisibility(View.VISIBLE);
                    bi.pofpa152.setChecked(false);
                    bi.pofpa152.setTag("-1");
                }
            }
        });


        bi.pofpa08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == bi.pofpa08a.getId()) {
                    bi.pofpa09cv.setVisibility(View.VISIBLE);
                    bi.pofpa10cv.setVisibility(View.VISIBLE);
                    bi.pofpa15cv.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.pofpa16cv, null);
                    bi.pofpa16cv.setVisibility(View.GONE);
                } else {
                    ClearClass.ClearAllFields(bi.pofpa09cv, null);
                    ClearClass.ClearAllFields(bi.pofpa10cv, null);
                    ClearClass.ClearAllFields(bi.pofpa15cv, null);
                    bi.pofpa09cv.setVisibility(View.GONE);
                    bi.pofpa10cv.setVisibility(View.GONE);
                    bi.pofpa15cv.setVisibility(View.GONE);
                    bi.pofpa16cv.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.pofpa19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == bi.pofpa19a.getId()) {
                    bi.pofpa20cv.setVisibility(View.VISIBLE);
                } else {
                    ClearClass.ClearAllFields(bi.pofpa20cv, null);
                    bi.pofpa20cv.setVisibility(View.GONE);
                }
            }
        });


        bi.pofpa21.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == bi.pofpa21a.getId()) {
                    bi.cvpofpa22.setVisibility(View.VISIBLE);
                    bi.cvpofpa23.setVisibility(View.VISIBLE);
                } else {
                    ClearClass.ClearAllFields(bi.cvpofpa22, null);
                    ClearClass.ClearAllFields(bi.cvpofpa23, null);
                    bi.cvpofpa22.setVisibility(View.GONE);
                    bi.cvpofpa23.setVisibility(View.GONE);
                }
            }
        });

    }


    public void populateSpinner(final Context context) {
        // Spinner Drop down elements
        talukaNames = new ArrayList<>();
        talukaCodes = new ArrayList<>();

        talukaNames.add("....");
        talukaCodes.add("....");

        Collection<TalukasContract> dc = db.getAllTalukas();

        for (TalukasContract d : dc) {
            talukaNames.add(d.getTaluka());
            talukaCodes.add(d.getTalukacode());
        }

        bi.pofpa02.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, talukaNames));

        bi.pofpa02.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) return;

                ucCode = new ArrayList<>();
                ucName = new ArrayList<>();

                ucCode.add("....");
                ucName.add("....");

                Collection<UCsContract> pc = db.getAllUCsbyTaluka(talukaCodes.get(position));
                for (UCsContract p : pc) {
                    ucCode.add(p.getUccode());
                    ucName.add(p.getUcs());
                }

                bi.pofpa03.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, ucName));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


        bi.pofpa03.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) return;

                    /*villageCodes = new ArrayList<>();
                    villageNames = new ArrayList<>();

                    villageCodes.add("....");
                    villageNames.add("....");

                    Collection<VillagesContract> pc =
                            db.getAllPSUsByTaluka(talukaCodes.get(bi.pocfa01.getSelectedItemPosition()),
                                    ucCode.get(bi.pocfa02.getSelectedItemPosition()));
                    for (VillagesContract p : pc) {
                        villageCodes.add(p.getVillagecode());
                        villageNames.add(p.getVillagename());
                    }*/

                lhwCodes = new ArrayList<>();
                lhwNames = new ArrayList<>();

                lhwCodes.add("....");
                lhwNames.add("....");

                Collection<LHWContract> lhw =
                        db.getAllLHWsByTaluka(talukaCodes.get(bi.pofpa02.getSelectedItemPosition()),
                                ucCode.get(bi.pofpa03.getSelectedItemPosition()));
                for (LHWContract p : lhw) {
                    lhwCodes.add(p.getLhwcode());
                    lhwNames.add(p.getLhwname());
                }

                bi.pofpa04.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, lhwNames));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bi.pofpa04.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) return;
                bi.lhwcode.setText("LHW Code: " + lhwCodes.get(i));
                ClearClass.ClearAllFields(bi.f2Section01, null);
                bi.f2Section01.setVisibility(View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }



    private void clickListener() {

        bi.pofpa00.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                bi.f2Section01.setVisibility(View.GONE);
                ClearClass.ClearAllFields(bi.f2Section01, false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        bi.checkHHBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!formValidation())
                    return;

                cContract = db.getChildById(lhwCodes.get(bi.pofpa04.getSelectedItemPosition()), bi.pofpa00.getText().toString());

                if (cContract == null)
                    cContract = db.getChildById("f1", lhwCodes.get(bi.pofpa04.getSelectedItemPosition()), bi.pofpa00.getText().toString());

                if (cContract == null) {
                    Toast.makeText(F2Section01Activity.this, "Referral ID not Found!", Toast.LENGTH_SHORT).show();
                    ClearClass.ClearAllFields(bi.f2Section01, false);
                    bi.f2Section01.setVisibility(View.GONE);
                    return;
                }
                ClearClass.ClearAllFields(bi.f2Section01, true);
                bi.f2Section01.setVisibility(View.VISIBLE);
                bi.pofpa05.setText(cContract.getChild_name());
                bi.pofpa06.setText(cContract.getF_name());
                bi.pofpa05.setEnabled(false);
                bi.pofpa06.setEnabled(false);
            }
        });
    }



/*

                if (!formValidation())
                    return;

                cContract = db.getChildById(lhwCodes.get(bi.pohra03.getSelectedItemPosition()), bi.pohra04.getText().toString());

                if (cContract == null) {

                    Toast.makeText(F4Section01Activity.this, "Referral ID not Found!", Toast.LENGTH_SHORT).show();
                    ClearClass.ClearAllFields(bi.llform04, null);
                    bi.llform04.setVisibility(View.GONE);
                    return;
                }

                bi.llform04.setVisibility(View.VISIBLE);

            */




    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                if (DAY.equals("7")) {
                    finish();
                    startActivity(new Intent(this, F2Section02Activity.class).putExtra("day", DAY));
                } else {
                    finish();
                    startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {
        long updcount = db.addForm(MainApp.fc);

        MainApp.fc.set_ID(String.valueOf(updcount));
        if (updcount != 0) {
            MainApp.fc.set_UID(
                    (MainApp.fc.getDeviceID() + MainApp.fc.get_ID()));
            db.updateFormID();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        MainApp.fc = new FormsContract();
        MainApp.fc.setDeviceID(MainApp.deviceId);
        MainApp.fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.fc.setFormType(MainApp.formtype);
        MainApp.fc.setUser(MainApp.userName);
        MainApp.fc.setFormDate(dtToday);
        MainApp.fc.setDevicetagID(getSharedPreferences("tagName", MODE_PRIVATE).getString("tagName", ""));

        MainApp.fc.setCode_lhw(lhwCodes.get(bi.pofpa04.getSelectedItemPosition()));
        MainApp.fc.setRef_ID(bi.pofpa00.getText().toString());

        JSONObject f02 = new JSONObject();
        f02.put("pofp_survey", DAY);

        f02.put("pofpa02", talukaCodes.get(bi.pofpa02.getSelectedItemPosition()));
        f02.put("pofpa03", ucCode.get(bi.pofpa03.getSelectedItemPosition()));

        f02.put("pofpa05", bi.pofpa05.getText().toString());
        f02.put("pofpa06", bi.pofpa06.getText().toString());

//        f02.put("pofpa01", bi.pofpa01.getText().toString());

        f02.put("pofpa07", bi.pofpa07a.isChecked() ? "1"
                : bi.pofpa07b.isChecked() ? "2"
                : bi.pofpa07c.isChecked() ? "3"
                : bi.pofpa07d.isChecked() ? "4"
                : bi.pofpa0796.isChecked() ? "96"
                : "0");
        f02.put("pofpa07cx", bi.pofpa07cx.getText().toString());
        f02.put("pofpa07dx", bi.pofpa07dx.getText().toString());
        f02.put("pofpa0796x", bi.pofpa0796x.getText().toString());

        f02.put("pofpa08", bi.pofpa08a.isChecked() ? "1"
                : bi.pofpa08b.isChecked() ? "2"
                : "0");

        f02.put("pofpa09", bi.pofpa09.getText().toString());

        f02.put("pofpa10", bi.pofpa10a.isChecked() ? "1"
                : bi.pofpa10b.isChecked() ? "2"
                : "0");

        f02.put("pofpa151a", bi.pofpa151a.getText().toString());
        f02.put("pofpa151b", bi.pofpa151b.getText().toString());
        f02.put("pofpa151c", bi.pofpa151c.getText().toString());
        f02.put("pofpa151d", bi.pofpa151da.isChecked() ? "1"
                : bi.pofpa151db.isChecked() ? "2"
                : "0");
        f02.put("pofpa152", bi.pofpa152.isChecked() ? "1" : "0");
        f02.put("pofpa1597", bi.pofpa1597.isChecked() ? "97" : "0");

        f02.put("pofpa161a", bi.pofpa161a.getText().toString());
        f02.put("pofpa161b", bi.pofpa161b.getText().toString());
        f02.put("pofpa161c", bi.pofpa161c.getText().toString());
        f02.put("pofpa161d", bi.pofpa161da.isChecked() ? "1"
                : bi.pofpa161db.isChecked() ? "2"
                : "0");
        f02.put("pofpa162", bi.pofpa162.isChecked() ? "1" : "0");

        f02.put("pofpa17", bi.pofpa17.getText().toString());

        f02.put("pofpa18", bi.pofpa18a.isChecked() ? "1"
                : bi.pofpa18b.isChecked() ? "2"
                : bi.pofpa18c.isChecked() ? "3"
                : bi.pofpa18d.isChecked() ? "4"
                : bi.pofpa18e.isChecked() ? "5"
                : "0");

        f02.put("pofpa19", bi.pofpa19a.isChecked() ? "1"
                : bi.pofpa19b.isChecked() ? "2"
                : "0");

        f02.put("pofpa20a", bi.pofpa20a.isChecked() ? "1" : "0");
        f02.put("pofpa20b", bi.pofpa20b.isChecked() ? "2" : "0");
        f02.put("pofpa20c", bi.pofpa20c.isChecked() ? "3" : "0");
        f02.put("pofpa2096", bi.pofpa2096.isChecked() ? "96" : "0");
        f02.put("pofpa2096x", bi.pofpa2096x.getText().toString());

        f02.put("pofpa21", bi.pofpa21a.isChecked() ? "1"
                : bi.pofpa21b.isChecked() ? "2"
                : "0");

        f02.put("pofpa22", bi.pofpa22a.isChecked() ? "1"
                : bi.pofpa22b.isChecked() ? "2"
                : bi.pofpa22c.isChecked() ? "3"
                : bi.pofpa2296.isChecked() ? "96"
                : "0");
        f02.put("pofpa2296x", bi.pofpa2296x.getText().toString());

        f02.put("pofpa23a", bi.pofpa23a.getText().toString());
        f02.put("pofpa23b", bi.pofpa23b.getText().toString());
        f02.put("pofpa23c", bi.pofpa23c.getText().toString());
        f02.put("pofpa231", bi.pofpa231a.isChecked() ? "1"
                : bi.pofpa231b.isChecked() ? "2"
                : "0");

        MainApp.fc.setsA(String.valueOf(f02));
        MainApp.setGPS(this);

    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.f2Section011);

    }

    public void BtnEnd() {

//        if (!ValidatorClass.EmptyTextBox(this, bi.pofpa00, getString(R.string.pocfa06))) return;

        if (!ValidatorClass.EmptyCheckingContainer(this, bi.llF2S1))
            return;

        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            MainApp.endActivity(this, this);
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }

        /*if (!ValidatorClass.EmptyCheckingContainer(this, bi.llF2S1))
            return;

        new AlertDialog.Builder(this)
                .setTitle("END INTERVIEW")
                .setIcon(R.drawable.ic_power_settings_new_black_24dp)
                .setCancelable(false)
                .setCancelable(false)
                .setMessage("Do you want to End Interview??")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            SaveDraft();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!UpdateDB()) {
                            Toast.makeText(F2Section01Activity.this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        MainApp.endActivity(F2Section01Activity.this, F2Section01Activity.this);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();*/
    }

}
