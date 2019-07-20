package edu.aku.hassannaqvi.uen_po_hhs_fl.ui.form4;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_po_hhs_fl.core.MainApp;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF3Section01Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivityF4Section01Binding;
import edu.aku.hassannaqvi.uen_po_hhs_fl.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ClearClass;
import edu.aku.hassannaqvi.uen_po_hhs_fl.validator.ValidatorClass;


public class F4Section01Activity extends AppCompatActivity {

    ActivityF4Section01Binding bi;
    DatabaseHelper db;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_f4_section01);
       // bi.setCallback(this);
       // this.setTitle(R.string.pofisec1);

        db = new DatabaseHelper(this);
        events_call();

        clickListener();
    }


    private void clickListener() {


    }


    public void BtnContinue() {

    }

    public void BtnEnd() {


    }




    private void SaveDraft() throws JSONException {

    }


    void events_call() {



    }

}


