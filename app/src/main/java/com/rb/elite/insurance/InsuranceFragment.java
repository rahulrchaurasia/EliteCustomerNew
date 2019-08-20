package com.rb.elite.insurance;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rb.elite.BaseFragment;
import com.rb.elite.R;
import com.rb.elite.core.model.InsuranceCompany;
import com.rb.elite.core.model.InsuranceType;
import com.rb.elite.insurance.companyDetail.InsuranceCompActivity;
import com.rb.elite.utility.Constants;
import com.rb.elite.utility.DateTimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InsuranceFragment extends BaseFragment implements View.OnClickListener {


    private Context mContext;
    LinearLayout lyOther;
    EditText etName, etCompany, etDate, etStartTime, etEndTime, etInstruction ,etOther;
    Button btnSubmit;
    List<InsuranceType> lstInsuranceList;
    AlertDialog alertDialog;
    InsuranceAdapter compAdapter;
    InsuranceType insuranceType;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insurance, container, false);

        return view;
    }



    //endregion

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContext = view.getContext();

        initialize(view);
        lyOther.setVisibility(View.GONE);

        setOnClickListener();

        lstInsuranceList = new ArrayList<InsuranceType>();
        getCompDetail();
    }

    private void initialize(View view) {

        lyOther = view.findViewById(R.id.lyOther);
        btnSubmit = view.findViewById(R.id.btnSubmit);

        etOther = view.findViewById(R.id.etOther);
        etName = view.findViewById(R.id.etName);
        etCompany = view.findViewById(R.id.etCompany);
        etInstruction = view.findViewById(R.id.etInstruction);

        etDate = view.findViewById(R.id.etDate);
        etStartTime = view.findViewById(R.id.etStartTime);
        etEndTime = view.findViewById(R.id.etEndTime);

    }

    private void setOnClickListener() {
        etName.setFocusable(false);
        etName.setClickable(true);

        etCompany.setFocusable(false);
        etCompany.setClickable(true);

        etName.setOnClickListener(this);
        etCompany.setOnClickListener(this);

        etDate.setOnClickListener(this);
        etStartTime.setOnClickListener(this);
        etEndTime.setOnClickListener(this);

        btnSubmit.setOnClickListener(this);

    }


    private List<InsuranceType> getCompDetail() {
        lstInsuranceList.clear();

        lstInsuranceList.add(new InsuranceType("1", "Car Insurance"));
        lstInsuranceList.add(new InsuranceType("2", "Car Renewal"));
        lstInsuranceList.add(new InsuranceType("3", "Two Wheeler Insurance"));
        lstInsuranceList.add(new InsuranceType("4", "Two Wheeler Renewal"));
        lstInsuranceList.add(new InsuranceType("5", "Health TopUp"));
        lstInsuranceList.add(new InsuranceType("6", "Term Insurance"));
        lstInsuranceList.add(new InsuranceType("7", "Travel Insurance"));
        lstInsuranceList.add(new InsuranceType("8", "Home Insurance"));
        lstInsuranceList.add(new InsuranceType("9", "Personal Accident"));
        lstInsuranceList.add(new InsuranceType("10", "Critical Insurance"));
        lstInsuranceList.add(new InsuranceType("11", "Marine Insurance"));
        lstInsuranceList.add(new InsuranceType("99", "Any Other"));
        return lstInsuranceList;
    }

    public void requestPopUp(String Title) {
        if (alertDialog != null && alertDialog.isShowing()) {

            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.CustomDialog);

        TextView txtHdr;
        ImageView ivCross;

        LayoutInflater inflater = this.getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.feedback_dialog, null);

        builder.setView(dialogView);
        alertDialog = builder.create();
        // set the custom dialog components - text, image and button
        txtHdr = dialogView.findViewById(R.id.txtHdr);
        RecyclerView rvRTO = dialogView.findViewById(R.id.rvRTO);
        ivCross = (ImageView) dialogView.findViewById(R.id.ivCross);

        txtHdr.setText("Select Insurance Company");
        rvRTO.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvRTO.setHasFixedSize(true);
        rvRTO.setNestedScrollingEnabled(false);
        compAdapter = new InsuranceAdapter(InsuranceFragment.this, lstInsuranceList);
        rvRTO.setAdapter(compAdapter);
        rvRTO.setVisibility(View.VISIBLE);
        txtHdr.setText(Title);


        ivCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

            }
        });
        alertDialog.setCancelable(false);
        alertDialog.show();

    }

    private boolean validateTime(String strTime)
    {



        String[] arrOfStr =  strTime.split(":");

        int time = Integer.valueOf(String.valueOf(arrOfStr[0]).trim());
        if(time>9 && time < 19)
        {

            return true;
        }else {


            return false;
        }

    }

    private boolean validateAnyOther()
    {

        if(lyOther.getVisibility() == View.VISIBLE){

            if (!isEmpty( etOther)) {
                etOther.requestFocus();
                etOther.setError("Select Type OF Insurance");
               // getCustomToast("Select Type OF Insurance");
                return false;
            }
        }
        return true;
    }
    private boolean validate() {

        if (!isEmpty(etName)) {
            etName.requestFocus();
            etName.setError("Select Type OF Insurance");
            getCustomToast("Select Type OF Insurance");
            return false;
        } else if(!validateAnyOther())
        {
            return false;
        }
        else if (!isEmpty(etCompany)) {

            etCompany.requestFocus();
            etCompany.setError("Select Insurance Company");
            getCustomToast("Select Insurance Company");
            return false;
        } else if (!isEmpty(etDate)) {
            etDate.requestFocus();
            etDate.setError("Enter Date");
            getCustomToast("Enter Date");
            return false;
        } else if (!isEmpty(etStartTime)) {
            etStartTime.requestFocus();
            etStartTime.setError("Enter From Time");
            getCustomToast("Enter From Time");
            return false;
        } else if(!validateTime(etStartTime.getText().toString()))
        {
            etStartTime.requestFocus();
            etStartTime.setError("Time range between 9 am to 7 pm");
            getCustomToast("Time range between 9 am to 7 pm");
            return false;
        }else if (!isEmpty(etEndTime)) {
            etEndTime.requestFocus();
            etEndTime.setError("Enter To Time");
            getCustomToast("Enter To Time");
            return false;
        }else if(!validateTime(etEndTime.getText().toString()))
        {
            etEndTime.requestFocus();
            etEndTime.setError("Time range between 9 am to 7 pm");
            getCustomToast("Time range between 9 am to 7 pm");
            return false;
        }

        return true;
    }

    private void saveDarta()
    {
        String strMsg = "Data Save Successfully" +"\n\n";
        strMsg = strMsg+ "Type Of Insurance:"+ etName.getText().toString() +"\n";

        strMsg = strMsg+ "Insurance Company:"+ etCompany.getText().toString() +"\n";

        strMsg = strMsg+ "Preferred Date:"+ etDate.getText().toString() +"\n";
        strMsg = strMsg+ "Start Time:"+ etStartTime.getText().toString() +"\n";
        strMsg = strMsg+ "End Time:"+ etEndTime.getText().toString() +"\n";
        strMsg = strMsg+ "Any Specific Instruction:"+ etInstruction.getText().toString() +"\n";

        getCustomToast(strMsg);
    }

    @Override
    public void onClick(View view) {

        Constants.hideKeyBoard(view, mContext);

        switch (view.getId()) {
            case R.id.btnSubmit:


                if (validate() == false) {
                    return;
                } else {

                    saveDarta();
                }

                break;

            case R.id.etName:
                if (lstInsuranceList.size() > 0) {
                    etName.setError(null);
                    requestPopUp("Select Insurance Company");
                }

                break;

            case R.id.etCompany:


                startActivityForResult(new Intent(getActivity(), InsuranceCompActivity.class), Constants.COMPANY_INSURANCE_CODE);

                break;


            case R.id.etDate:

                DateTimePicker.showDatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                        if (view1.isShown()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(year, monthOfYear, dayOfMonth);
                            String currentDay = simpleDateFormat.format(calendar.getTime());
                            etDate.setText(currentDay);
                            etDate.setError(null);
                        }
                    }
                });
                break;

            case R.id.etStartTime:

                DateTimePicker.showTimePickerDialog(view.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (view.isShown()) {
                            String item = "";
                            if (hourOfDay >= 12 && minute > 0)
                                item = " PM";
                            else
                                item = " AM";


                            etStartTime.setText("" + hourOfDay + " : " + minute + item);
                            etStartTime.setError(null);

                        }
                    }
                });


                break;


            case R.id.etEndTime:

                DateTimePicker.showTimePickerDialog(view.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (view.isShown()) {
                            String item = "";
                            if (hourOfDay >= 12 && minute > 0)
                                item = " PM";
                            else
                                item = " AM";


                            etEndTime.setText("" + hourOfDay + " : " + minute + item);
                            etEndTime.setError(null);

                        }
                    }
                });


                break;
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.COMPANY_INSURANCE_CODE) {
            if (data != null) {


                ArrayList<InsuranceCompany> companySelectedList = data.getParcelableArrayListExtra("COMPANY_DATA");

                if (companySelectedList.size() > 0) {
                    etCompany.setError(null);
                    String strComp = "";

                    for (InsuranceCompany company : companySelectedList) {

                        strComp = strComp + "\n" + company.getInsuranceCompName();
                    }
                    etCompany.setText(strComp);

                }

                //endregion

            }
        }

    }

    public void getCompanyData(InsuranceType objInsurance) {
        if (alertDialog != null)
            if (alertDialog.isShowing()) {
                alertDialog.dismiss();
                insuranceType = objInsurance;
                etName.setText(insuranceType.getInsuranceName());

                if(insuranceType.getInsuranceId().equals("99")){
                    lyOther.setVisibility(View.VISIBLE);
                }else {
                    lyOther.setVisibility(View.GONE);
                }


            }

    }
}
