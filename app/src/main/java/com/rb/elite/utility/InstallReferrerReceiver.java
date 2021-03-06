package com.rb.elite.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.rb.elite.splash.PrefManager;

/**
 * Created by Rajeev Ranjan on 07/08/2019.
 */
public class InstallReferrerReceiver extends BroadcastReceiver {

    String TAG = "REFERRER";
    PrefManager prefManager;

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getStringExtra("referrer") != null) {


            String referrer = intent.getStringExtra("referrer");

            Log.d(TAG, "Referrer Code" + referrer);

//            try {
//                JsonObject jsonObject = new JsonParser().parse(referrer).getAsJsonObject();
//                if (jsonObject.has("company_id")) {
//                    String companyID = String.valueOf(jsonObject.get("company_id"));
//                    String companyName = String.valueOf(jsonObject.get("company_name"));
//                    prefManager = new PrefManager(context);
//
//                    prefManager.setCompanyID(companyID, companyName);
//                }
//            } catch (Exception ex) {
//                Log.d(TAG, "Referrer Error" + ex.getMessage());
//
//            }
            try {

                if(referrer.contains("@")) {
                    String[] splitArray = referrer.split("@");
                    if (splitArray[0] != null && splitArray[1] != null) {

                        prefManager = new PrefManager(context);
                        String companyID = splitArray[0];
                        String companyName = splitArray[1];
                        prefManager.setCompanyID(companyID, companyName);

                    }
                }
            } catch (Exception ex) {
                Log.d(TAG, "Referrer Error" + ex.getMessage());

            }


        }


    }
}
