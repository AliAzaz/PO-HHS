package edu.aku.hassannaqvi.uen_po_hhs.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.IdRes;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.uen_po_hhs.R;
import edu.aku.hassannaqvi.uen_po_hhs.contracts.BLRandomContract;
import edu.aku.hassannaqvi.uen_po_hhs.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_po_hhs.contracts.LHWContract;
import edu.aku.hassannaqvi.uen_po_hhs.contracts.LHWContract.lhwEntry;
import edu.aku.hassannaqvi.uen_po_hhs.contracts.TalukasContract;
import edu.aku.hassannaqvi.uen_po_hhs.contracts.UCsContract;
import edu.aku.hassannaqvi.uen_po_hhs.contracts.VillagesContract;
import edu.aku.hassannaqvi.uen_po_hhs.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs.validator.validatorClass;

public class SectionAActivity extends Activity {

    private static final String TAG = SectionAActivity.class.getName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    @BindView(R.id.pobtaluka)
    Spinner mN00;
    @BindView(R.id.pobuc)
    Spinner mN01;
    @BindView(R.id.povillage)
    Spinner mN02;
    @BindView(R.id.polhw)
    Spinner MN03;

    @BindView(R.id.pobhh)
    EditText pobhh;

    /*    @BindView(R.id.ta03)
        RadioGroup ta03;
        @BindView(R.id.ta03a)
        RadioButton ta03a;
        @BindView(R.id.ta03b)
        RadioButton ta03b;
        @BindView(R.id.ta03c)
        RadioButton ta03c;
        @BindView(R.id.ta04)
        Spinner ta04;*/


    @BindView(R.id.ta09)
    RadioGroup ta09;
    @BindView(R.id.ta09a)
    RadioButton ta09a;
    @BindView(R.id.ta09b)
    RadioButton ta09b;
    //    @BindView(R.id.ta09c)
//    RadioButton ta09c;
    @BindView(R.id.btn_Continue)
    Button btn_Continue;
    @BindView(R.id.checkHHBtn)
    Button checkHHBtn;
    @BindView(R.id.btn_End)
    Button btn_End;
    @BindView(R.id.navbuttons)
    LinearLayout navbuttons;



    @BindView(R.id.contactdetails)
    LinearLayout contactdetails;
    @BindView(R.id.hh08)
    TextView hh08;//contact name
    @BindView(R.id.labelcontact)
    TextView labelcontact;//contact name
    @BindView(R.id.hh09)
    TextView hh09; // contact number


    public List<String> psuName, districtNames, villageNames, lhwNames;
    public List<String> psuCode, districtCodes, villageCodes, lhwCodes;
    Collection<BLRandomContract> selected;

    DatabaseHelper db;
    String[] ucs = new String[]{"....",
            "Allah Yar Turk",
            "Bulri Shah Karim",
            "Dando",
            "Ghulam Shah Bagrani",
            "Jinhan Soomro",
            "Lakhat",
            "Mullakatiar",
            "Nazarpur",
            "Shaikh Bhirkio",
            "Saeed Khan Lund",
            "Saeed Matto",
            "Saeedpur",
            "Tando Saeendad",
            "Tando Ghulam Hyder",
            "TMK 01",
            "TMK 02",
            "TMK 03"};


    int ucsPos = 0;

    Collection<VillagesContract> village;
    Map<String, String> villageMap;

    ArrayList<String> lablesSubVillages;
    Collection<VillagesContract> SubVillagesList;
    Map<String, String> SubVillagesMap;


    int length = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_a);
        ButterKnife.bind(this);

        db = new DatabaseHelper(this);

        MainApp.familyMembersList = new ArrayList<>();
        populateSpinner(this);

        lablesSubVillages = new ArrayList<>();
        SubVillagesMap = new HashMap<>();
        lablesSubVillages.add("Select Sub Village..");
/*
        SubVillagesList = db.getVillage(String.valueOf(MainApp.areaCode));

        if (SubVillagesList.size() != 0) {
            for (VillagesContract vil : SubVillagesList) {
                lablesSubVillages.add(vil.getVillagename());
                SubVillagesMap.put(vil.getVillagename(), vil.getVillagecode());
            }
        }

        spSubVillages.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lablesSubVillages));

        spSubVillages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (spSubVillages.getSelectedItemPosition() != 0) {
                    MainApp.cluster = SubVillagesMap.get(spSubVillages.getSelectedItem().toString());

                    ta01.setText(MainApp.cluster);

                    ta06.setText(spSubVillages.getSelectedItem().toString());
                } else {

                    ta01.setText(null);

                    ta06.setText("N/A");

                    fldGrpt03.setVisibility(View.GONE);

                    hhName.setText(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

*/

/*
        pobhh.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                pobhh.setInputType(InputType.TYPE_CLASS_NUMBER);
                length = charSequence.toString().length();

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!pobhh.getText().toString().isEmpty() && pobhh.getText().toString().length() == 4) {
                    if (pobhh.getText().toString().substring(0, 3).matches("[0-9]+")) {
                        if (length < 5) {
                            pobhh.setText(pobhh.getText().toString() + "-");
                            pobhh.setSelection(pobhh.getText().length());
                        }

                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });
        */
        ta09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.ta09a) {
                    btn_Continue.setVisibility(View.VISIBLE);
                    btn_End.setVisibility(View.GONE);
                } else {
                    btn_Continue.setVisibility(View.GONE);
                    btn_End.setVisibility(View.VISIBLE);
                }
            }
        });
        checkHHBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(SectionAActivity.this,"This feature is under construction! ",Toast.LENGTH_SHORT).show();

                if (MainApp.lhwCode != "" && validatorClass.EmptyTextBox(SectionAActivity.this, pobhh, getString(R.string.household))) {
                    setupViews();
                }else{
                    Toast.makeText(SectionAActivity.this, "Please Enter Correct Household", Toast.LENGTH_SHORT).show();

                }
            }

        });



    }

    public void setupViews() {
        selected = db.getAllBLRandom(MainApp.lhwCode, pobhh.getText().toString().toUpperCase());

        if (selected.size() != 0) {

            Toast.makeText(this, "Household found!", Toast.LENGTH_SHORT).show();

            for (BLRandomContract rnd : selected) {
                MainApp.selectedHead = new BLRandomContract(rnd);
            }
            contactdetails.setVisibility(View.VISIBLE);
            navbuttons.setVisibility(View.VISIBLE);
            hh08.setText(MainApp.selectedHead.getHhhead().toUpperCase());
            if (!MainApp.selectedHead.gethhcontact().equals("99")){
                hh09.setVisibility(View.VISIBLE);
                labelcontact.setVisibility(View.VISIBLE);
                hh09.setText(MainApp.selectedHead.gethhcontact().toUpperCase());
            }else {
                hh09.setText(null);
                hh09.setVisibility(View.GONE);
                labelcontact.setVisibility(View.GONE);
            }

        } else {
            clearFields();
            Toast.makeText(this, "No Household found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void clearFields() {
        contactdetails.setVisibility(View.GONE);
        hh08.setText(null);
        hh09.setText(null);
        ta09.clearCheck();
        navbuttons.setVisibility(View.GONE);
    }

    public void populateSpinner(final Context context) {
        // Spinner Drop down elements
        districtNames = new ArrayList<>();
        districtCodes = new ArrayList<>();

        districtNames.add("....");
        districtCodes.add("....");

        Collection<TalukasContract> dc = db.getAllTalukas();
        Log.d(TAG, "onCreate: " + dc.size());
        for (TalukasContract d : dc) {
            districtNames.add(d.getTaluka());
            districtCodes.add(d.getTalukacode());
        }

       /* // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context,
                android.R.layout.simple_spinner_dropdown_item, districtNames);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/

        mN00.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, districtNames));

        // attaching data adapter to spinner
        //mN00.setAdapter(dataAdapter);

        mN00.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainApp.hh01txt = districtCodes.get(position);

                psuCode = new ArrayList<>();
                psuName = new ArrayList<>();


                psuCode.add("....");
                psuName.add("....");

                Collection<UCsContract> pc = db.getAllUCsbyTaluka(districtCodes.get(position));
                for (UCsContract p : pc) {
                    psuCode.add(p.getUccode());
                    psuName.add(p.getUcs());
                }

                mN01.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, psuName));

                /*ArrayAdapter<String> psuAdapter = new ArrayAdapter<>(context,
                        android.R.layout.simple_spinner_dropdown_item, psuName);

                psuAdapter
                        .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mN01.setAdapter(psuAdapter);*/

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mN01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainApp.hh02txt = psuCode.get(position);

                villageCodes = new ArrayList<>();
                villageNames = new ArrayList<>();

                lhwCodes = new ArrayList<>();
                lhwNames = new ArrayList<>();

                final List<String> villageNames1 = new ArrayList<>();

                villageCodes.add("....");
                villageNames.add("....");
                villageNames1.add("....");

                Collection<VillagesContract> pc = db.getAllPSUsByDistrict(MainApp.hh01txt, MainApp.hh02txt);
                for (VillagesContract p : pc) {
                    villageCodes.add(p.getVillagecode());
                    villageNames.add(p.getVillagename());
                    //villageNames1.add(p.getVillagename().split("\\|")[2]);
                }

//                mN02.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, villageNames));


                lhwCodes.add("....");
                lhwNames.add("....");

                Collection<LHWContract> lhw = db.getAllLHWsByDistrict(MainApp.hh01txt, MainApp.hh02txt);
                for (LHWContract p : lhw) {
                    lhwCodes.add(p.getLhwcode());
                    lhwNames.add(p.getLhwname());
                    //villageNames1.add(p.getVillagename().split("\\|")[2]);
                }

                MN03.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, lhwNames));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        MN03.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (MN03.getSelectedItemPosition() != 0) {
                    MainApp.lhwCode = lhwCodes.get(i);
                    MainApp.lhwName = lhwNames.get(i);

                    //String[] st = villageNames.get(i).split("\\|");

                    /*districtN.setText(AppMain.hh01txt);
                    ucN.setText(AppMain.hh02txt);
                    psuN.setText(AppMain.lhwName);*/

                    //districtN.setText(st[0]);
                    //ucN.setText(st[1]);
                    //psuN.setText(st[2]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

/*        mN02.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (mN02.getSelectedItemPosition() != 0) {
                    MainApp.hh04txt = villageCodes.get(i);
                    MainApp.villageCode = villageCodes.get(i);
                    MainApp.villageName = villageNames.get(i);

                    //String[] st = villageNames.get(i).split("\\|");

                    //districtN.setText(st[0]);
                    //ucN.setText(st[1]);
                    //psuN.setText(st[2]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
    }

    public void openForm(View view) {

// removed village selection
//        if (mN01.getSelectedItemPosition() != 0 && mN02.getSelectedItemPosition() != 0 && mN02.getSelectedItemPosition() != 0) {
        if (MN03.getSelectedItemPosition() != 0 && !validatorClass.EmptyTextBox(this, pobhh,getString(R.string.household))) {

            Intent oF = new Intent(this, SectionBActivity.class);

            if (MainApp.LHWExist(MainApp.lhwCode, MainApp.villageCode)) {
                Toast.makeText(SectionAActivity.this, "LHW data exist!", Toast.LENGTH_LONG).show();
                alertPSU();
            } else {
                startActivity(oF);
            }
        } else {
            Toast.makeText(this, "Select values from dropdown", Toast.LENGTH_SHORT).show();
        }
    }

    public void alertPSU() {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent oF = new Intent(SectionAActivity.this, SectionBActivity.class);
                        startActivity(oF);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:

                        break;
                }
            }

        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Do you want to continue?");
        builder.setMessage("LHW data already exist.").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("Cancel", dialogClickListener).show();
    }

/*

    @OnClick(R.id.checkHH)
    void onCheckHHClick() {
        //TODO implement

        if (!ta01.getText().toString().trim().isEmpty() && !ta05h.getText().toString().trim().isEmpty()) {

            selected = db.getAllBLRandom(ta01.getText().toString(), ta05h.getText().toString().toUpperCase());

            if (selected.size() != 0) {

                for (BLRandomContract rnd : selected) {
                    MainApp.selectedHead = new BLRandomContract(rnd);
                }

                hhName.setText(MainApp.selectedHead.getHhhead().toUpperCase());

                fldGrpt03.setVisibility(View.VISIBLE);
            } else {
                hhName.setText(null);

                fldGrpt03.setVisibility(View.GONE);

                Toast.makeText(this, "No Head found in this HH.", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Not found.", Toast.LENGTH_SHORT).show();
        }

    }
*/

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        //TODO implement
        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
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

                startActivity(new Intent(this, SectionBActivity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

        MainApp.fc = new FormsContract();

        MainApp.fc.setDevicetagID(sharedPref.getString("tagName", null));
        MainApp.fc.setFormDate(dtToday);
        MainApp.fc.setUser(MainApp.userName);
        MainApp.fc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));

        JSONObject sa = new JSONObject();

        MainApp.cluster = "";
        MainApp.hhno = pobhh.getText().toString();
//        MainApp.billno = ta05u.getText().toString();

    /*
        sa.put("rndid", MainApp.selectedHead.get_ID());
        sa.put("luid", MainApp.selectedHead.getLUID());
        sa.put("randDT", MainApp.selectedHead.getRandomDT());
        sa.put("hh03", MainApp.selectedHead.getStructure());
        sa.put("hh07", MainApp.selectedHead.getExtension());
        sa.put("hhhead", MainApp.selectedHead.getHhhead());

        sa.put("hhheadpresent", checkHHHeadpresent.isChecked() ? "1" : "2");
        sa.put("hhheadpresentnew", newHHheadname.getText().toString());

        sa.put("ta01", ta01.getText().toString());
        sa.put("ta02", ta02a.isChecked() ? "1" : ta02b.isChecked() ? "2" : ta02c.isChecked() ? "3" : "0");*/
        sa.put("ta03", MainApp.talukaCode);
        sa.put("ta04", MainApp.ucCode);
        sa.put("ta04A", MainApp.areaCode);
       /* sa.put("ta05h", ta05h.getText().toString());
        sa.put("ta05u", ta05u.getText().toString());
        sa.put("ta06", ta06.getText().toString());
        sa.put("ta07", ta07.getText().toString());
        sa.put("ta08", ta08.getText().toString());*/
        sa.put("ta09", ta09a.isChecked() ? "1" : ta09b.isChecked() ? "2" : "0");
        sa.put("lhw_name",MainApp.lhwName);
        sa.put("lhw_code",MainApp.lhwCode);
        sa.put("hh_no",pobhh.getText().toString());
        sa.put("app_version", MainApp.versionName + "." + MainApp.versionCode);


        MainApp.fc.setsA(String.valueOf(sa));

        setGPS();

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        Long updcount = db.addForm(MainApp.fc);
        MainApp.fc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.fc.setUID(
                    (MainApp.fc.getDeviceID() + MainApp.fc.get_ID()));
            db.updateFormID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void setGPS() {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);

        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String dt = GPSPref.getString("Time", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            MainApp.fc.setGpsLat(GPSPref.getString("Latitude", "0"));
            MainApp.fc.setGpsLng(GPSPref.getString("Longitude", "0"));
            MainApp.fc.setGpsAcc(GPSPref.getString("Accuracy", "0"));
//            AppMain.fc.setGpsTime(GPSPref.getString(date, "0")); // Timestamp is converted to date above
            MainApp.fc.setGpsDT(date); // Timestamp is converted to date above

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }
    }

    public boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();


        if (!validatorClass.EmptySpinner(this, mN00, getString(R.string.talukaname))) {
            return false;
        }
        if (!validatorClass.EmptySpinner(this, mN01, getString(R.string.ucname))) {
            return false;
        }
      /*  if (!validatorClass.EmptySpinner(this,mN02,getString(R.string.villagename))) {
        return false;
        }*/
        if (!validatorClass.EmptySpinner(this, MN03, getString(R.string.lhwname))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, pobhh, getString(R.string.household))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, ta09, ta09a, getString(R.string.ta09))) {
            return false;
        }

//        01
       /* if (ta01.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ta01), Toast.LENGTH_SHORT).show();
            ta01.setError("This data is Required! ");    // Set Error on last radio button
            ta01.requestFocus();
            Log.i(TAG, "ta01: This data is Required!");
            return false;
        } else {
            ta01.setError(null);
        }*/

//        03
/*        if (ta03.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ta03), Toast.LENGTH_SHORT).show();
            ta03c.setError("This data is Required!");    // Set Error on last radio button
            ta03c.setFocusableInTouchMode(true);
            ta03c.setFocusable(true);
            ta03c.requestFocus();
            Log.i(TAG, "ta03: This data is Required!");
            return false;
        } else {
            ta03c.setError(null);
        }*/

//        04
/*        if (ta04.getSelectedItem() == "....") {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.ta04), Toast.LENGTH_SHORT).show();
            ((TextView) ta04.getSelectedView()).setText("This Data is Required");
            ((TextView) ta04.getSelectedView()).setTextColor(Color.RED);
            ta04.requestFocus();
            Log.i(TAG, "ta04: This Data is Required!");
            return false;
        } else {
            ((TextView) ta04.getSelectedView()).setError(null);
        }

//        05
        if (ta05h.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ta05h), Toast.LENGTH_SHORT).show();
            ta05h.setError("This data is Required! ");    // Set Error on last radio button
            ta05h.requestFocus();
            Log.i(TAG, "ta05h: This data is Required!");
            return false;
        } else {
            ta05h.setError(null);
        }

//        New HHHead

        if (!checkHHHeadpresent.isChecked()) {
            if (newHHheadname.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): New head name", Toast.LENGTH_SHORT).show();
                newHHheadname.setError("This data is Required! ");    // Set Error on last radio button
                newHHheadname.requestFocus();
                Log.i(TAG, "newHHheadname: This data is Required!");
                return false;
            } else {
                newHHheadname.setError(null);
            }
        }

//        02
        if (ta02.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ta02), Toast.LENGTH_SHORT).show();
            ta02c.setError("This data is Required!");    // Set Error on last radio button

            ta02c.setFocusable(true);
            ta02c.setFocusableInTouchMode(true);
            ta02c.requestFocus();
            Log.i(TAG, "ta02: This data is Required!");
            return false;
        } else {
            ta02c.setError(null);
        }


        if (ta05u.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ta05u), Toast.LENGTH_SHORT).show();
            ta05u.setError("This data is Required! ");    // Set Error on last radio button
            ta05u.requestFocus();
            Log.i(TAG, "ta05u: This data is Required!");
            return false;
        } else {
            ta05u.setError(null);
        }

//        06
      /*  if (ta06.getText().toString().equals("N/A")) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.ta06), Toast.LENGTH_SHORT).show();
            ta06.setError("Change cluster no! ");    // Set Error on last radio button
            ta06.requestFocus();
            Log.i(TAG, "ta06: Change cluster no!");
            return false;
        } else {
            ta06.setError(null);
        }
*/
//        07

/*        if (ta07.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ta07), Toast.LENGTH_SHORT).show();
            ta07.setError("This data is Required! ");    // Set Error on last radio button

            Log.i(TAG, "ta07: This data is Required!");
            return false;
        } else {
            ta07.setError(null);
        } */

//        08

/*        if (ta08.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ta08), Toast.LENGTH_SHORT).show();
            ta08.setError("This data is Required! ");    // Set Error on last radio button

            Log.i(TAG, "ta08: This data is Required!");
            return false;
        } else {
            ta08.setError(null);
        }
*/
//     09
        /*if (ta09.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ta09), Toast.LENGTH_SHORT).show();
            ta09a.setError("This data is Required!");    // Set Error on last radio button
            ta09a.setFocusable(true);
            ta09a.setFocusableInTouchMode(true);
            ta09a.requestFocus();
            Log.i(TAG, "ta09: This data is Required!");
            return false;
        } else {
            ta09a.setError(null);
        }
*/
        return true;
    }

}

