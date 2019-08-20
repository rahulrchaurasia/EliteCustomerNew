package com.rb.elite.database;

import android.content.Context;

import com.rb.elite.core.model.InsuranceCompany;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Rajeev Ranjan on 02/02/2018.
 */

public class DataBaseController {
    Context mContext;



    public DataBaseController(Context mContext) {
        this.mContext = mContext;

    }



    public List<InsuranceCompany> getCompDetail() {

        List<InsuranceCompany> CompanyList = new ArrayList<>();
        CompanyList.add(new InsuranceCompany("1", "Bajaj Allianz General Insurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("2", "Bharti Axa General Insurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("3", "Cholamandalam MS General Insurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("4", "Future Generali India Insurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("5", "HDFC ERGO General Insurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("6", "ICICI Lombard General Insurance Co. Ltd."));

        CompanyList.add(new InsuranceCompany("7", "IFFCO Tokio General Insurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("8", "Liberty Videocon General Insurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("9", "Magma HDI General Insurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("10", "National Insurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("11", "The New India Assurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("12", "The Oriental Insurance Co. Ltd."));

        CompanyList.add(new InsuranceCompany("13", "Raheja QBE General Insurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("14", "Reliance General Insurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("15", "Royal Sundaram Alliance Insurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("16", "SBI General Insurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("17", "Shriram General Insurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("18", "Tata AIG General Insurance Co. Ltd."));

        CompanyList.add(new InsuranceCompany("19", "United India Insurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("20", "Universal Sompo General Insurance Co. Ltd."));
        CompanyList.add(new InsuranceCompany("21", "Kotak Mahindra General Insurance Co. Ltd."));

        return CompanyList;

    }



}
