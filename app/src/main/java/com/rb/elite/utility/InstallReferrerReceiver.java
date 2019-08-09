package com.rb.elite.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.rb.elite.splash.PrefManager;

/**
 * Created by Rajeev Ranjan on 07/08/2019.
 */
public class InstallReferrerReceiver extends BroadcastReceiver {

    String TAG = "REFERRER";
    PrefManager prefManager;

    @Override
    public void onReceive(Context context, Intent intent) {

        String referrer = intent.getStringExtra("referrer");

        Log.d(TAG, "Referrer Code" + referrer);

        try {
            JsonObject jsonObject = new JsonObject().getAsJsonObject(referrer);
            if (jsonObject.has("company_id")) {
                String companyID = String.valueOf(jsonObject.get("company_id"));
                String companyName = String.valueOf(jsonObject.get("company_name"));
                prefManager = new PrefManager(context);

                prefManager.setCompanyID(companyID,companyName);
            }
        }catch (Exception ex)
        {

        }


    }
}
