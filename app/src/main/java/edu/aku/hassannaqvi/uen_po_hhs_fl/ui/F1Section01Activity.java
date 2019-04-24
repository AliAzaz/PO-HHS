package edu.aku.hassannaqvi.uen_po_hhs_fl.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.BLRandomContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.LHWContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.TalukasContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.UCsContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.VillagesContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF1Section01Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.otherClasses.SnackUtils;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;

public class F1Section01Activity extends Activity {

    ActivityF1Section01Binding bi;

    public List<String> ucName, talukaNames, villageNames, lhwNames;
    public List<String> ucCode, talukaCodes, villageCodes, lhwCodes;
    Collection<BLRandomContract> selected;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_f1_section_01);

        settingListeners();
        initializingComponents();
    }

    private void initializingComponents() {
        db = new DatabaseHelper(this);
        populateSpinner(this);
    }

    private void settingListeners() {
        bi.checkHHBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Snackbar snackbar = SnackUtils.showLoadingSnackbar(F1Section01Activity.this, "This feature is under construction!!");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        snackbar.dismiss();
                    }
                }, 3000);

                /*if (validation()) {
                    if (MainApp.lhwCode != "" && ValidatorClass.EmptyTextBox(Section01Activity.this, pobhh, getString(R.string.household))) {
                        setupViews();
                    } else {
                        Toast.makeText(F1Section01Activity.this, "Please Enter Correct Household", Toast.LENGTH_SHORT).show();

                    }
                }*/
            }

        });
    }

    public void setupViews() {
        selected = db.getAllBLRandom(MainApp.lhwCode, bi.pocfa06.getText().toString().toUpperCase());

        if (selected.size() != 0) {

            Toast.makeText(this, "Household found!", Toast.LENGTH_SHORT).show();

            for (BLRandomContract rnd : selected) {
                MainApp.selectedHead = new BLRandomContract(rnd);
            }
            bi.contactdetails.setVisibility(View.VISIBLE);
            bi.navbuttons.setVisibility(View.VISIBLE);
            bi.hh08.setText(MainApp.selectedHead.getHhhead().toUpperCase());
            if (!MainApp.selectedHead.gethhcontact().equals("99")) {
                bi.hh09.setVisibility(View.VISIBLE);
                bi.labelcontact.setVisibility(View.VISIBLE);
                bi.hh09.setText(MainApp.selectedHead.gethhcontact().toUpperCase());
            } else {
                bi.hh09.setText(null);
                bi.hh09.setVisibility(View.GONE);
                bi.labelcontact.setVisibility(View.GONE);
            }

        } else {
            clearFields();
            Toast.makeText(this, "No Household found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void clearFields() {
        bi.contactdetails.setVisibility(View.GONE);
        bi.hh08.setText(null);
        bi.hh09.setText(null);
        bi.navbuttons.setVisibility(View.GONE);
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

        bi.pocfa01.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, talukaNames));

        bi.pocfa01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

                bi.pocfa02.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, ucName));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        bi.pocfa02.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) return;

                villageCodes = new ArrayList<>();
                villageNames = new ArrayList<>();

                villageCodes.add("....");
                villageNames.add("....");

                Collection<VillagesContract> pc =
                        db.getAllPSUsByTaluka(talukaCodes.get(bi.pocfa01.getSelectedItemPosition()),
                                ucCode.get(bi.pocfa02.getSelectedItemPosition()));
                for (VillagesContract p : pc) {
                    villageCodes.add(p.getVillagecode());
                    villageNames.add(p.getVillagename());
                }

                lhwCodes = new ArrayList<>();
                lhwNames = new ArrayList<>();

                lhwCodes.add("....");
                lhwNames.add("....");

                Collection<LHWContract> lhw =
                        db.getAllLHWsByTaluka(talukaCodes.get(bi.pocfa01.getSelectedItemPosition()),
                                ucCode.get(bi.pocfa02.getSelectedItemPosition()));
                for (LHWContract p : lhw) {
                    lhwCodes.add(p.getLhwcode());
                    lhwNames.add(p.getLhwname());
                }

                bi.pocfa03.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, lhwNames));
                bi.pocfa04.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, villageNames));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void BtnContinue() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(this, F1Section02_03Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {
        return true;
    }

    private void SaveDraft() {
        JSONObject sBC = new JSONObject();
    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.ll01);
    }

    public void BtnEnd() {

        if (!ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecA02))
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
                        SaveDraft();
                        if (!UpdateDB()) {
                            Toast.makeText(F1Section01Activity.this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        MainApp.endActivity(F1Section01Activity.this, F1Section01Activity.this);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}

