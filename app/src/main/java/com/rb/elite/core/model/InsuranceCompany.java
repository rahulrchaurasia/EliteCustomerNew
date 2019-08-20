package com.rb.elite.core.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajeev Ranjan on 19/08/2019.
 */
public class InsuranceCompany implements Parcelable  {

    private String InsuranceCompId;
    private String InsuranceCompName;
    private boolean isSelected;
    private int selectedCount;

    public InsuranceCompany(String insuranceCompId, String insuranceCompName) {
        InsuranceCompId = insuranceCompId;
        InsuranceCompName = insuranceCompName;
        this.isSelected = false;
        this.selectedCount = 0;
    }

    protected InsuranceCompany(Parcel in) {
        InsuranceCompId = in.readString();
        InsuranceCompName = in.readString();
        isSelected = in.readByte() != 0;
        selectedCount = in.readInt();
    }

    public static final Creator<InsuranceCompany> CREATOR = new Creator<InsuranceCompany>() {
        @Override
        public InsuranceCompany createFromParcel(Parcel in) {
            return new InsuranceCompany(in);
        }

        @Override
        public InsuranceCompany[] newArray(int size) {
            return new InsuranceCompany[size];
        }
    };

    public String getInsuranceCompId() {
        return InsuranceCompId;
    }

    public void setInsuranceCompId(String insuranceCompId) {
        InsuranceCompId = insuranceCompId;
    }

    public String getInsuranceCompName() {
        return InsuranceCompName;
    }

    public void setInsuranceCompName(String insuranceCompName) {
        InsuranceCompName = insuranceCompName;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getSelectedCount() {
        return selectedCount;
    }

    public void setSelectedCount(int selectedCount) {
        this.selectedCount = selectedCount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(InsuranceCompId);
        dest.writeString(InsuranceCompName);
        dest.writeByte((byte) (isSelected ? 1 : 0));
        dest.writeInt(selectedCount);
    }
}
