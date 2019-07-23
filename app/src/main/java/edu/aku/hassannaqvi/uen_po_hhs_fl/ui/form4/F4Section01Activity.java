package edu.aku.hassannaqvi.uen_po_hhs_fl.ui.form4;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
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
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.VillagesContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF4Section01Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ClearClass;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;


public class F4Section01Activity extends AppCompatActivity {

    ActivityF4Section01Binding bi;
    private List<String> ucName, talukaNames, villageNames, lhwNames;
    private List<String> ucCode, talukaCodes, villageCodes, lhwCodes;

    DatabaseHelper db;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    public static String DOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_f4_section01);
        bi.setCallback(this);
        this.setTitle("Form 4 Hospital Physician");
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

        bi.pohra01.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, talukaNames));

        bi.pohra01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

                bi.pohra02.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, ucName));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        bi.pohra02.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) return;

                villageCodes = new ArrayList<>();
                villageNames = new ArrayList<>();

                villageCodes.add("....");
                villageNames.add("....");

                Collection<VillagesContract> pc =
                        db.getAllPSUsByTaluka(talukaCodes.get(bi.pohra01.getSelectedItemPosition()),
                                ucCode.get(bi.pohra02.getSelectedItemPosition()));
                for (VillagesContract p : pc) {
                    villageCodes.add(p.getVillagecode());
                    villageNames.add(p.getVillagename());
                }

                lhwCodes = new ArrayList<>();
                lhwNames = new ArrayList<>();

                lhwCodes.add("....");
                lhwNames.add("....");

                Collection<LHWContract> lhw =
                        db.getAllLHWsByTaluka(talukaCodes.get(bi.pohra01.getSelectedItemPosition()),
                                ucCode.get(bi.pohra02.getSelectedItemPosition()));
                for (LHWContract p : lhw) {
                    lhwCodes.add(p.getLhwcode());
                    lhwNames.add(p.getLhwname());
                }

                bi.pohra03.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, lhwNames));
                bi.pohra05.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, villageNames));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bi.pohra03.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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


        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
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
        return ValidatorClass.EmptyCheckingContainer(this, bi.f2Section011);
    }

    private void SaveDraft() throws JSONException {

        MainApp.fc = new FormsContract();
        MainApp.fc.setDeviceID(MainApp.deviceId);
        MainApp.fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.fc.setFormType(MainApp.formtype);
        MainApp.fc.setFormDate(dtToday);
        MainApp.fc.setDevicetagID(getSharedPreferences("tagName", MODE_PRIVATE).getString("tagName", ""));
        JSONObject form04_01 = new JSONObject();

        form04_01.put("pohra01", talukaCodes.get(bi.pohra01.getSelectedItemPosition()));
        form04_01.put("pohra02", ucCode.get(bi.pohra02.getSelectedItemPosition()));
        form04_01.put("pohra03", lhwCodes.get(bi.pohra03.getSelectedItemPosition()));
        form04_01.put("pohra05", villageCodes.get(bi.pohra05.getSelectedItemPosition()));
//        form04_01.put("pohra04", bi.pohra04.getSelectedItemPosition());
        form04_01.put("pohra06", bi.pohra06.getText().toString());


        form04_01.put("pohra09", bi.pohra09.getText().toString());

        form04_01.put("pohrb01", bi.pohrb01a.isChecked() ? "1"
                : bi.pohrb01b.isChecked() ? "2"
                : bi.pohrb01c.isChecked() ? "3"
                : bi.pohrb01d.isChecked() ? "4"
                : bi.pohrb01e.isChecked() ? "5"
                : bi.pohrb01f.isChecked() ? "6"
                : "0");

        form04_01.put("pohrb02", bi.pohrb02.getText().toString());


        form04_01.put("pohrb03", bi.pohrb03a.isChecked() ? "1"
                        : bi.pohrb03b.isChecked() ? "2"
                        : "0");

        form04_01.put("pohrb04", bi.pohrb04.getText().toString());

        form04_01.put("pohrb05", bi.pohrb05.getText().toString());

        form04_01.put("pohrc01a", bi.pohrc01a.isChecked() ? "1" : "0");
        form04_01.put("pohrc01b", bi.pohrc01b.isChecked() ? "2" : "0");
        form04_01.put("pohrc01c", bi.pohrc01c.isChecked() ? "3" : "0");

        form04_01.put("pohrd01a", bi.pohrd01a.isChecked() ? "1" : "0");
        form04_01.put("pohrd01b", bi.pohrd01b.isChecked() ? "2" : "0");
        form04_01.put("pohrd01c", bi.pohrd01c.isChecked() ? "3" : "0");
        form04_01.put("pohrd01d", bi.pohrd01d.isChecked() ? "4" : "0");
        form04_01.put("pohrd01e", bi.pohrd01e.isChecked() ? "5" : "0");


        form04_01.put("pohre01", bi.pohre01a.isChecked() ? "1"
                        : bi.pohre01b.isChecked() ? "2"
                        : bi.pohre01c.isChecked() ? "3"
                        : "0");

        form04_01.put("pohrf01a", bi.pohrf01a.isChecked() ? "1" : "0");
        form04_01.put("pohrf01b", bi.pohrf01b.isChecked() ? "2" : "0");
        form04_01.put("pohrf01c", bi.pohrf01c.isChecked() ? "3" : "0");
        form04_01.put("pohrf01d", bi.pohrf01d.isChecked() ? "4" : "0");
        form04_01.put("pohrf01e", bi.pohrf01e.isChecked() ? "5" : "0");
        form04_01.put("pohrf01f", bi.pohrf01f.isChecked() ? "6" : "0");
        form04_01.put("pohrf01g", bi.pohrf01g.isChecked() ? "7" : "0");
        form04_01.put("pohrf0197", bi.pohrf0197.isChecked() ? "97" : "0");

        form04_01.put("pohrg01a", bi.pohrg01a.getText().toString());

        form04_01.put("pohrg01b", bi.pohrg01b.getText().toString());

        form04_01.put("pohrg02", bi.pohrg02.getText().toString());

        form04_01.put("pohrg03", bi.pohrg03.getText().toString());


        form04_01.put("pohrg04a", bi.pohrg04a.getText().toString());

        form04_01.put("pohrg04b", bi.pohrg04b.getText().toString());

        form04_01.put("pohrh01", bi.pohrh01.isChecked() ? "1" : "0");
        form04_01.put("pohrh01x", bi.pohrh01x.getText().toString());

        form04_01.put("pohrh02", bi.pohrh02.isChecked() ? "2" : "0");
        form04_01.put("pohrh02x", bi.pohrh02x.getText().toString());

        form04_01.put("pohrh03", bi.pohrh03.isChecked() ? "3" : "0");
        form04_01.put("pohrh03x", bi.pohrh03x.getText().toString());

        form04_01.put("pohrh04", bi.pohrh04.isChecked() ? "4" : "0");
        form04_01.put("pohrh04x", bi.pohrh04x.getText().toString());

        form04_01.put("pohrh05", bi.pohrh05.isChecked() ? "5" : "0");
        form04_01.put("pohrh05x", bi.pohrh05x.getText().toString());

        form04_01.put("pohrh06", bi.pohrh06.isChecked() ? "6" : "0");
        form04_01.put("pohrh06x", bi.pohrh06x.getText().toString());

        form04_01.put("pohrh07", bi.pohrh07.isChecked() ? "7" : "0");
        form04_01.put("pohrh07x", bi.pohrh07x.getText().toString());

        form04_01.put("pohrh08", bi.pohrh08.isChecked() ? "8" : "0");
        form04_01.put("pohrh08x", bi.pohrh08x.getText().toString());

        form04_01.put("pohrh09", bi.pohrh09.isChecked() ? "9" : "0");
        form04_01.put("pohrh09x", bi.pohrh09x.getText().toString());

        form04_01.put("pohrh10", bi.pohrh10.isChecked() ? "10" : "0");
        form04_01.put("pohrh10x", bi.pohrh10x.getText().toString());


        form04_01.put("pohri01", bi.pohri01.isChecked() ? "1" : "0");
        form04_01.put("pohri02", bi.pohri02.isChecked() ? "2" : "0");
        form04_01.put("pohri03", bi.pohri03.isChecked() ? "3" : "0");
        form04_01.put("pohri04", bi.pohri04.isChecked() ? "4" : "0");
        form04_01.put("pohri96", bi.pohri96.isChecked() ? "96" : "0");

        form04_01.put("pohri96x", bi.pohri96x.getText().toString());
        form04_01.put("pohri97", bi.pohri97.isChecked() ? "97" : "0");


        form04_01.put("pohrj01", bi.pohrj01a.isChecked() ? "1"
                        : bi.pohrj01b.isChecked() ? "2"
                        : "0");
        form04_01.put("pohrj02a", bi.pohrj02a.getText().toString());
        form04_01.put("pohrj02b", bi.pohrj02b.getText().toString());
        form04_01.put("pohrj02c", bi.pohrj02c.getText().toString());
        form04_01.put("pohrj02d", bi.pohrj02da.isChecked() ? "1"
                        : bi.pohrj02db.isChecked() ? "2"
                        : "0");

        form04_01.put("pohrj03", bi.pohrj03a.isChecked() ? "1"
                        : bi.pohrj03b.isChecked() ? "2"
                        : "0");


        form04_01.put("pohrj04a", bi.pohrj04a.isChecked() ? "1" : "0");
        form04_01.put("pohrj04b", bi.pohrj04b.isChecked() ? "2" : "0");
        form04_01.put("pohrj04c", bi.pohrj04c.isChecked() ? "3" : "0");
        form04_01.put("pohrj04d", bi.pohrj04d.isChecked() ? "4" : "0");
        form04_01.put("pohrj04dx", bi.pohrj04dx.getText().toString());
        form04_01.put("pohrj04e", bi.pohrj04e.isChecked() ? "5" : "0");
        form04_01.put("pohrj04ex", bi.pohrj04ex.getText().toString());

        form04_01.put("pohrj05", bi.pohrj05.getText().toString());


        form04_01.put("pohrk01", bi.pohrk01a.isChecked() ? "1"
                        : bi.pohrk01b.isChecked() ? "2"
                        : bi.pohrk01c.isChecked() ? "3"
                        : "0");

        form04_01.put("pohrl01", bi.pohrl01a.isChecked() ? "1"
                        : bi.pohrl01b.isChecked() ? "2"
                        : bi.pohrl01c.isChecked() ? "3"
                        : "0");

        form04_01.put("pohrl01ax", bi.pohrl01ax.getText().toString());
        form04_01.put("pohrl01bx", bi.pohrl01bx.getText().toString());

        form04_01.put("pohrl0196", bi.pohrl0196.isChecked() ? "96" : "0");

        form04_01.put("pohrl02", bi.pohrl02.getText().toString());


        form04_01.put("pohrl03", bi.pohrl03a.isChecked() ? "1"
                        : bi.pohrl03b.isChecked() ? "2"
                        : bi.pohrl03c.isChecked() ? "3"
                        : "0");

        MainApp.fc.setsA(String.valueOf(form04_01));
        MainApp.setGPS(this);


    }


    void events_call() {

        bi.pohrf0197.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    ClearClass.ClearAllFields(bi.lvpohrf01, false);
                } else {
                    ClearClass.ClearAllFields(bi.lvpohrf01, true);
                }
            }
        });


        bi.pohrh97.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    ClearClass.ClearAllFields(bi.lvpohrhh2, false);
                else
                    ClearClass.ClearAllFields(bi.lvpohrhh2, true);
            }
        });


        bi.pohri96.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    ClearClass.ClearAllFields(bi.lvpohri01, false);
                } else {
                    ClearClass.ClearAllFields(bi.lvpohri01, true);
                }
            }
        });

        bi.pohrl0196.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    ClearClass.ClearAllFields(bi.pohrl01lv, false);
                else
                    ClearClass.ClearAllFields(bi.pohrl01lv, true);
            }
        });
    }


}


