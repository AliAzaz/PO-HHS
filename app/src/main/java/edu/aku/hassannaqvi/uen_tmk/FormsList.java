package edu.aku.hassannaqvi.uen_tmk;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.aku.hassannaqvi.uen_tmk.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_tmk.core.DatabaseHelper;

public class FormsList extends Activity {

    @BindView(R.id.totalForms)
    TextView totalForms;
    @BindView(R.id.completeForms)
    TextView completeForms;
    @BindView(R.id.psuNoTxt)
    TextView psuNoTxt;
    @BindView(R.id.FormsList)
    RecyclerView formsList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms_list);
        ButterKnife.bind(this);
        String dssid = getIntent().getStringExtra("dssid");
        int fTotal = 0;
        int fComplete = 0;
        psuNoTxt.setText("Forms for Block: " + dssid);
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        List<FormsContract> forms = db.getFormsByDSS(dssid);
        for (FormsContract fc : forms) {
            fTotal++;
            if (fc.getIstatus().contains("1")) {
                fComplete++;
            }
        }
        totalForms.setText("Total Forms: " + fTotal);
        completeForms.setText("Complete Forms: " + fComplete);

        mRecyclerView = (RecyclerView) findViewById(R.id.FormsList);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);


        mAdapter = new FormsAdapter(forms, getApplication());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(5000);
        itemAnimator.setRemoveDuration(5000);
        mRecyclerView.setItemAnimator(itemAnimator);


    }
}