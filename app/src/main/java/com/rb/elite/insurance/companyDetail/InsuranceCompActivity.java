package com.rb.elite.insurance.companyDetail;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rb.elite.BaseActivity;
import com.rb.elite.R;
import com.rb.elite.core.model.InsuranceCompany;
import com.rb.elite.core.model.UserEntity;
import com.rb.elite.database.DataBaseController;
import com.rb.elite.splash.PrefManager;
import com.rb.elite.utility.Constants;

import java.util.ArrayList;
import java.util.List;

public class InsuranceCompActivity extends BaseActivity implements View.OnClickListener {

    DataBaseController dataBaseController;
    PrefManager prefManager;
    UserEntity loginEntity;


    RecyclerView rvCompany;
    Button btnSubmit;
    InsuranceCompAdapter mAdapter;
    List<InsuranceCompany> CompanyList;
    ArrayList<InsuranceCompany> companySelectedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_comp);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        prefManager = new PrefManager(this);
        dataBaseController = new DataBaseController(this);
        CompanyList = new ArrayList<InsuranceCompany>();
        companySelectedList = new ArrayList<InsuranceCompany>();

        initialize();
        setOnclickListener();
        // CompanyList = getCompDetail();

        showDialog();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Write whatever to want to do after delay specified (1 sec)

                Log.d("Handler", "Running Handler");
                mAdapter = new InsuranceCompAdapter(InsuranceCompActivity.this, dataBaseController.getCompDetail());
                rvCompany.setAdapter(mAdapter);
                cancelDialog();
            }
        }, 500);

    }


    private void initialize() {
        prefManager = new PrefManager(this);
        loginEntity = prefManager.getUserData();

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        rvCompany = (RecyclerView) findViewById(R.id.rvCompany);
        rvCompany.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(InsuranceCompActivity.this);
        rvCompany.setLayoutManager(layoutManager);
        // rvCompany.setItemAnimator(new DefaultItemAnimator());


    }

    private void setOnclickListener() {
        btnSubmit.setOnClickListener(this);
    }


    public void getCompany(InsuranceCompany company, boolean isSelected) {


        try {
            if (isSelected) {
                companySelectedList.add(company);
            } else {
                int indexOfSelected = 0;
                for (int i = 0; i < companySelectedList.size(); i++) {
                    if (companySelectedList.get(i).getInsuranceCompId().equals(company.getInsuranceCompId())) {
                        indexOfSelected = i;
                        break;
                    }
                }
                companySelectedList.remove(indexOfSelected);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnSubmit) {

            if (companySelectedList.size() > 3) {

                getCustomToast("Maximum 3 Company can be selected");
                return;
            } else {

                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("COMPANY_DATA", companySelectedList);
                setResult(Constants.COMPANY_INSURANCE_CODE, intent);
                finish();      //finishing activity
            }

        }

    }
}
