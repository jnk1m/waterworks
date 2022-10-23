package com.waterworks.rate;

import com.waterworks.billing.BillingRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RateUsageFeeImpl implements RateUsageFee {

   BillingRepositoryImpl billingRepository;

   public RateUsageFeeImpl(BillingRepositoryImpl billingRepository) {
      this.billingRepository = billingRepository;
   }


   @Override
   public List<String[]> calculateRate(int usage) {
      List<String[]> fiveCheapestRate = billingRepository.getFiveCheapestRate(usage);
      List<String[]> calculatedUsageFeeList = new ArrayList<>();

      for(int i = 0 ; i< fiveCheapestRate.size() ; i++){
         String[] eachRate = fiveCheapestRate.get(i);
         int i1 = Integer.parseInt(eachRate[6]) * usage;

         String[] test= new String[2];
         test[0] = eachRate[0];
         test[1] = String.valueOf(i1);
         calculatedUsageFeeList.add(test);
      }

      return calculatedUsageFeeList;
   }
}
