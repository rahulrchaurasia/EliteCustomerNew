package com.rb.elite.core.response;

import com.rb.elite.core.APIResponse;
import com.rb.elite.core.model.ServiceMainEntity;

/**
 * Created by IN-RB on 06-08-2018.
 */

public class ServiceListResponse extends APIResponse {


    /**
     * Data : {"RTO":[{"id":97,"name":"Vehicle Pick or Drop service available in Mum","catg_id":"2","product_logo":"http://elite.rupeeboss.comdefault.png","parent_id":0,"subcategory":[]},{"id":131,"name":"Pollution under Control (PUC) Renewal Reminder By SMS.","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/Pollution-under-Control (PUC)-Renewal-Reminder-By-SMS.png","parent_id":0,"subcategory":[]},{"id":132,"name":"Transfer of Insurance Policy for  No Claim Bonus  (NCB) Benefit at the time of Old vehicle Sale ","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/Transfer-of-Insurance-Policy-for-No-Claim-Bonus-(NCB)-Benefit-at-the-time-of-Old-vehicle-Sale.png","parent_id":0,"subcategory":[]},{"id":133,"name":"At the time of accident follow up with workshops/ insurance company for private vehicles.","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/At-the-time-of-accident-follow-up-with-workshops-insurance-company-for-private-vehicles.png","parent_id":0,"subcategory":[]},{"id":134,"name":"Assistance and guidance for Health related cases.","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/Assistance-and-guidance-for-Health-related-cases.png","parent_id":0,"subcategory":[]},{"id":135,"name":"Special benefits on Top Up plans","catg_id":"2","product_logo":null,"parent_id":0,"subcategory":[]},{"id":136,"name":"Assistance in getting Maturity Proceeds and Nominee Change of Life Insurance Policy. ","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/Assistance-in-getting-Maturity-Proceeds-and-Nominee-Change-of-Life-Insurance-Policy.png","parent_id":0,"subcategory":[]},{"id":137,"name":"Beyond Life Financial Services - 25% Discount on Fees 1 yr subscription, 40% on Life Time Services.","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/Beyond-Life-Financial-Services-25% Discount-on-fees-for-1-year-subscription-&-40%-on-Life-Time-subscription.png","parent_id":0,"subcategory":[]},{"id":138,"name":"Complimentary Credit Report for any 2 members  in the Family per year.","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/Complimentary-Credit-Report-for-any-2-members-in-the-Family-per-year.png","parent_id":0,"subcategory":[]},{"id":139,"name":"Complimentary Loan Audit for Interest Rate Benefit.","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/Complimentary-Loan-Audit-for-Interest-Rate-Benefit.png","parent_id":0,"subcategory":[]},{"id":140,"name":"Analysis of Current Health profile.","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/Analysis-of-Current-Health-Profile.png","parent_id":0,"subcategory":[]}],"NONRTO":[{"id":97,"name":"Vehicle Pick or Drop service available in Mum","catg_id":"2","product_logo":"http://elite.rupeeboss.comdefault.png","parent_id":0,"subcategory":[]},{"id":131,"name":"Pollution under Control (PUC) Renewal Reminder By SMS.","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/Pollution-under-Control (PUC)-Renewal-Reminder-By-SMS.png","parent_id":0,"subcategory":[]},{"id":132,"name":"Transfer of Insurance Policy for  No Claim Bonus  (NCB) Benefit at the time of Old vehicle Sale ","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/Transfer-of-Insurance-Policy-for-No-Claim-Bonus-(NCB)-Benefit-at-the-time-of-Old-vehicle-Sale.png","parent_id":0,"subcategory":[]},{"id":133,"name":"At the time of accident follow up with workshops/ insurance company for private vehicles.","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/At-the-time-of-accident-follow-up-with-workshops-insurance-company-for-private-vehicles.png","parent_id":0,"subcategory":[]},{"id":134,"name":"Assistance and guidance for Health related cases.","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/Assistance-and-guidance-for-Health-related-cases.png","parent_id":0,"subcategory":[]},{"id":135,"name":"Special benefits on Top Up plans","catg_id":"2","product_logo":null,"parent_id":0,"subcategory":[]},{"id":136,"name":"Assistance in getting Maturity Proceeds and Nominee Change of Life Insurance Policy. ","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/Assistance-in-getting-Maturity-Proceeds-and-Nominee-Change-of-Life-Insurance-Policy.png","parent_id":0,"subcategory":[]},{"id":137,"name":"Beyond Life Financial Services - 25% Discount on Fees 1 yr subscription, 40% on Life Time Services.","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/Beyond-Life-Financial-Services-25% Discount-on-fees-for-1-year-subscription-&-40%-on-Life-Time-subscription.png","parent_id":0,"subcategory":[]},{"id":138,"name":"Complimentary Credit Report for any 2 members  in the Family per year.","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/Complimentary-Credit-Report-for-any-2-members-in-the-Family-per-year.png","parent_id":0,"subcategory":[]},{"id":139,"name":"Complimentary Loan Audit for Interest Rate Benefit.","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/Complimentary-Loan-Audit-for-Interest-Rate-Benefit.png","parent_id":0,"subcategory":[]},{"id":140,"name":"Analysis of Current Health profile.","catg_id":"2","product_logo":"http://elite.rupeeboss.com/images/icons/Non-RTO/Analysis-of-Current-Health-Profile.png","parent_id":0,"subcategory":[]}]}
     */

    private ServiceMainEntity Data;

    public ServiceMainEntity getData() {
        return Data;
    }

    public void setData(ServiceMainEntity Data) {
        this.Data = Data;
    }


}
