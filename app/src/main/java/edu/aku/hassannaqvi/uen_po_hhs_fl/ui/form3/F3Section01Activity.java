package edu.aku.hassannaqvi.uen_po_hhs_fl.ui.form3;

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
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.LHWContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.TalukasContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.UCsContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF3Section01Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_po_hhs_fl.utils.DateUtils;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ClearClass;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;


public class F3Section01Activity extends AppCompatActivity {

    ActivityF3Section01Binding bi;
    private List<String> talukaNames, ucName, lhwNames;
    private List<String> talukaCodes, ucCode, lhwCodes;
    DatabaseHelper db;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_f3_section01);
        bi.setCallback(this);
        this.setTitle("Form 03 (Referral Form)");

        db = new DatabaseHelper(this);
        populateSpinner(this);
        events_call();

        clickListener();

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

        bi.pofi001.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, talukaNames));

        bi.pofi001.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

                bi.pofi002.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, ucName));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


        bi.pofi002.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        db.getAllLHWsByTaluka(talukaCodes.get(bi.pofi001.getSelectedItemPosition()),
                                ucCode.get(bi.pofi002.getSelectedItemPosition()));
                for (LHWContract p : lhw) {
                    lhwCodes.add(p.getLhwcode());
                    lhwNames.add(p.getLhwname());
                }

                bi.pofi003.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, lhwNames));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bi.pofi003.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) return;
                bi.lhwcode.setText("LHW Code: " + lhwCodes.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    private void clickListener() {

        bi.checkHHBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bi.llform03.setVisibility(View.VISIBLE);
                ClearClass.ClearAllFields(bi.llform03, true);
            }
        });

        bi.pofi00.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                bi.llform03.setVisibility(View.GONE);
                ClearClass.ClearAllFields(bi.llform03, false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {

        if (!ValidatorClass.EmptyCheckingContainer(this, bi.llF3S1B))
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

    public boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.llF3S1A);
    }

    private void SaveDraft() throws JSONException {

        MainApp.fc = new FormsContract();
        MainApp.fc.setDeviceID(MainApp.deviceId);
        MainApp.fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.fc.setFormType(MainApp.formtype);
        MainApp.fc.setUser(MainApp.userName);
        MainApp.fc.setFormDate(dtToday);
        MainApp.fc.setDevicetagID(getSharedPreferences("tagName", MODE_PRIVATE).getString("tagName", ""));

        JSONObject form03_01 = new JSONObject();

        form03_01.put("pofi001", talukaCodes.get(bi.pofi001.getSelectedItemPosition()));
        form03_01.put("pofi002", ucCode.get(bi.pofi002.getSelectedItemPosition()));
        form03_01.put("pofi003", lhwCodes.get(bi.pofi003.getSelectedItemPosition()));

        form03_01.put("pofi00", bi.pofi00.getText().toString());
        form03_01.put("pofi01", bi.pofi01.getText().toString());

        form03_01.put("pofi004", bi.pofi004.getText().toString());
        form03_01.put("pofi005", bi.pofi005.getText().toString());

        form03_01.put("pofi02", bi.pofi02a.isChecked() ? "1" : bi.pofi02b.isChecked() ? "2" : "0");
        form03_01.put("pofi02bx", bi.pofi02bx.getText().toString());

        form03_01.put("pofi03", bi.pofi03a.isChecked() ? "1" : bi.pofi03b.isChecked() ? "2" : "0");
        form03_01.put("pofi03bx", bi.pofi03bx.getText().toString());

        form03_01.put("pofi04", bi.pofi04a.isChecked() ? "1" : bi.pofi04b.isChecked() ? "2" : "0");
        form03_01.put("pofi04ax", bi.pofi04ax.getText().toString());

        form03_01.put("pofi05", bi.pofi05a.isChecked() ? "1" : bi.pofi05b.isChecked() ? "2" : "0");

        form03_01.put("pofi06", bi.pofi06a.isChecked() ? "1" : bi.pofi06b.isChecked() ? "2" : bi.pofi0696.isChecked() ? "96" : "0");
        form03_01.put("pofi0696x", bi.pofi0696x.getText().toString());

        form03_01.put("pofi07", bi.pofi07a.isChecked() ? "1" : bi.pofi07b.isChecked() ? "2" : "0");

        form03_01.put("pofi08", bi.pofi08a.isChecked() ? "1" : bi.pofi08b.isChecked() ? "2" : "0");

        form03_01.put("pofi09", bi.pofi09a.isChecked() ? "1" : bi.pofi09b.isChecked() ? "2" : "0");

        form03_01.put("pofi10", bi.pofi10.getText().toString());

        form03_01.put("pofi11a", bi.pofi11a.isChecked() ? "1" : "0");
        form03_01.put("pofi11b", bi.pofi11b.isChecked() ? "2" : "0");
        form03_01.put("pofi11c", bi.pofi11c.isChecked() ? "3" : "0");
        form03_01.put("pofi11d", bi.pofi11d.isChecked() ? "4" : "0");
        form03_01.put("pofi11e", bi.pofi11e.isChecked() ? "5" : "0");
        form03_01.put("pofi11f", bi.pofi11f.isChecked() ? "6" : "0");
        form03_01.put("pofi1196", bi.pofi1196.isChecked() ? "96" : "0");
        form03_01.put("pofi1196x", bi.pofi1196x.getText().toString());

        form03_01.put("pofi12a", bi.pofi12a.isChecked() ? "1" : "0");
        form03_01.put("pofi12b", bi.pofi12b.isChecked() ? "2" : "0");
        form03_01.put("pofi12c", bi.pofi12c.isChecked() ? "3" : "0");
        form03_01.put("pofi12d", bi.pofi12d.isChecked() ? "4" : "0");
        form03_01.put("pofi12e", bi.pofi12e.isChecked() ? "5" : "0");
        form03_01.put("pofi12f", bi.pofi12f.isChecked() ? "6" : "0");
        form03_01.put("pofi12g", bi.pofi12g.isChecked() ? "7" : "0");
        form03_01.put("pofi12h", bi.pofi12h.isChecked() ? "8" : "0");
        form03_01.put("pofi12i", bi.pofi12i.isChecked() ? "9" : "0");
        form03_01.put("pofi1296", bi.pofi1296.isChecked() ? "96" : "0");
        form03_01.put("pofi1296x", bi.pofi1296x.getText().toString());

        form03_01.put("pofi13", bi.pofi13a.isChecked() ? "1"
                : bi.pofi13b.isChecked() ? "2"
                : "0");

        MainApp.fc.setsA(String.valueOf(form03_01));
        MainApp.setGPS(this);
    }


    void events_call() {

        bi.pofi01.setMinDate(DateUtils.getMonthsBack("dd/MM/yyyy", -6));
        bi.pofi10.setMinDate(DateUtils.getYearsBack("dd/MM/yyyy", -5));

        bi.pofi05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                ClearClass.ClearAllFields(bi.cvpofi06, null);
                ClearClass.ClearAllFields(bi.cvpofi07, null);
                bi.cvpofi06.setVisibility(View.GONE);
                bi.cvpofi07.setVisibility(View.GONE);

                if (checkedId == bi.pofi05a.getId()) {
                    bi.cvpofi07.setVisibility(View.VISIBLE);
                } else if (checkedId == bi.pofi05b.getId()) {
                    bi.cvpofi06.setVisibility(View.VISIBLE);
                }
            }
        });


       /* bi.pofi05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (!bi.pofi05a.isChecked()) {
                    bi.pofi06.clearCheck();
                }
            }
        });*/


        /*bi.pofi09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.pofi09b.isChecked()) {
                    ClearClass.ClearAllFields(bi.fldGrppofi11, null);
                }
            }
        });*/


        bi.pofi09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                ClearClass.ClearAllFields(bi.pofi10cv, null);
                ClearClass.ClearAllFields(bi.pofi11cv, null);
                ClearClass.ClearAllFields(bi.pofi12cv, null);
                bi.pofi10cv.setVisibility(View.GONE);
                bi.pofi11cv.setVisibility(View.GONE);
                bi.pofi12cv.setVisibility(View.GONE);

                if (checkedId == bi.pofi09a.getId()) {
                    bi.pofi10cv.setVisibility(View.VISIBLE);
                    bi.pofi11cv.setVisibility(View.VISIBLE);
                } else if (checkedId == bi.pofi09b.getId()) {
                    bi.pofi12cv.setVisibility(View.VISIBLE);
                }
            }
        });

    }

}


