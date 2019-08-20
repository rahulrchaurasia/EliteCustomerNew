package com.rb.elite.insurance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.rb.elite.R;
import com.rb.elite.core.model.InsuranceType;

import java.util.List;

/**
 * Created by IN-RB on 05-02-2018.
 */

public class InsuranceAdapter extends RecyclerView.Adapter<InsuranceAdapter.OrderDetailItem> {


    Fragment mContext;
    List<InsuranceType> lstInsuranceList;

    public InsuranceAdapter(Fragment mContext, List<InsuranceType> lstInsuranceList) {
        this.mContext = mContext;
        this.lstInsuranceList = lstInsuranceList;

    }

    public class OrderDetailItem extends RecyclerView.ViewHolder {
        TextView txtBody;
        LinearLayout lyParent;


        public OrderDetailItem(View itemView) {
            super(itemView);

            txtBody = (TextView) itemView.findViewById(R.id.txtBody);

            lyParent = (LinearLayout) itemView.findViewById(R.id.lyParent);

        }
    }

    @Override
    public OrderDetailItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_insurance_item, parent, false);

        return new InsuranceAdapter.OrderDetailItem(itemView);
    }

    @Override
    public void onBindViewHolder(OrderDetailItem holder, int position) {


        final InsuranceType company = lstInsuranceList.get(position);

        holder.txtBody.setText("" + company.getInsuranceName());

        holder.lyParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((InsuranceFragment) mContext).getCompanyData(company);

            }
        });


    }


    @Override
    public int getItemCount() {
        return lstInsuranceList.size();
    }
}
