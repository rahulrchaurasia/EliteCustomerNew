package com.rb.elite.insurance.companyDetail;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.rb.elite.R;
import com.rb.elite.core.model.InsuranceCompany;

import java.util.List;

/**
 * Created by IN-RB on 09-08-2018.
 */

public class InsuranceCompAdapter extends RecyclerView.Adapter<InsuranceCompAdapter.ProductItem>  {

    Activity mContext;
    List<InsuranceCompany> CompanyList;




    public InsuranceCompAdapter(Activity mContext, List<InsuranceCompany> CompanyList) {
        this.mContext = mContext;
        this.CompanyList = CompanyList;


    }


    public class ProductItem extends RecyclerView.ViewHolder {
        public TextView txtTitle;
        CheckBox chkComp;
        LinearLayout lyParent;


        public ProductItem(View itemView) {
            super(itemView);
            chkComp = (CheckBox) itemView.findViewById(R.id.chkComp);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            lyParent = (LinearLayout) itemView.findViewById(R.id.lyParent);

        }
    }

    @Override
    public InsuranceCompAdapter.ProductItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_insurance_comp_item, parent, false);

        return new InsuranceCompAdapter.ProductItem(itemView);
    }

    @Override
    public void onBindViewHolder(final ProductItem holder, int position) {

        final InsuranceCompany entity = CompanyList.get(position);

        if (entity.isSelected()) {
            holder.chkComp.setChecked(true);

        } else {
            holder.chkComp.setChecked(false);

        }

        holder.txtTitle.setText("" + entity.getInsuranceCompName().toUpperCase());
        holder.lyParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    if (entity.isSelected()) {

                        holder.chkComp.setChecked(false);
                        entity.setSelected(false);
                        ((InsuranceCompActivity) mContext).getCompany(entity, false);


                    } else {

                        holder.chkComp.setChecked(true);
                        entity.setSelected(true);
                        ((InsuranceCompActivity) mContext).getCompany(entity, true);


                    }

                }

        });

    }


    @Override
    public int getItemCount() {
        return CompanyList.size();
    }


    public void findAll(List<InsuranceCompany> compList) {
        CompanyList = compList;
        notifyDataSetChanged();
    }

    public int getSelectedItemCount() {
        int count =0;
       for (InsuranceCompany company : CompanyList)
       {
          if (company.isSelected() )
          {
              count ++;

          }
       }

       return count;
    }

}
