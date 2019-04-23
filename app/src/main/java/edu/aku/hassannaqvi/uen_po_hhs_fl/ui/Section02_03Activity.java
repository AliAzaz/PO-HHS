package edu.aku.hassannaqvi.uen_po_hhs_fl.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.aku.hassannaqvi.uen_po_hhs_fl.R;
import edu.aku.hassannaqvi.uen_po_hhs_fl.databinding.ActivitySection0203Binding;

public class Section02_03Activity extends AppCompatActivity {

    ActivitySection0203Binding bi;

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    bi = DataBindingUtil.setContentView(this, R.layout.activity_section02_03);
    bi.setCallback(this);
    this.setTitle("Command AND Control Centre");
}
}
