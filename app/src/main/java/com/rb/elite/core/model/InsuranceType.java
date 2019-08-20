package com.rb.elite.core.model;

/**
 * Created by Rajeev Ranjan on 19/08/2019.
 */
public class InsuranceType {

    private String InsuranceId;
    private String InsuranceName;
    public InsuranceType(String insuranceId, String insuranceName) {
        InsuranceId = insuranceId;
        InsuranceName = insuranceName;
    }

    public String getInsuranceId() {
        return InsuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        InsuranceId = insuranceId;
    }

    public String getInsuranceName() {
        return InsuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        InsuranceName = insuranceName;
    }




}
