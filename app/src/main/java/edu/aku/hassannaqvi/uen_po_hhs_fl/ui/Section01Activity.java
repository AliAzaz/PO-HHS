package edu.aku.hassannaqvi.uen_po_hhs_fl.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivitySection01Binding;

public class Section01Activity extends Activity {

    ActivitySection01Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this,R.layout.activity_section_01);




    }


}

