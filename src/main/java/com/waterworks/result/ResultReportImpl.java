package com.waterworks.result;

import com.waterworks.WaterBill;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResultReportImpl implements ResultReport {
   List<WaterBill> finalResultList = new ArrayList<>();

   @Override
   public void mergeData(List<String[]> fiveCheapestRate, List<String[]> calculatedUsageFeeList) {
      for (int i = 0; i < fiveCheapestRate.size(); i++) {
         String[] fiveString = fiveCheapestRate.get(i);
         String[] calculatedString = calculatedUsageFeeList.get(i);

         if (fiveString[0].equals(calculatedString[0])) {
            WaterBill waterBill = new WaterBill(fiveString[1], fiveString[2], Integer.parseInt(fiveString[6]), Integer.parseInt(calculatedString[1]));
            finalResultList.add(waterBill);
         }
      }
   }

   @Override
   public void reportResult() {
      for (WaterBill waterBill : finalResultList) {
         System.out.println(waterBill.toString());
      }

   }
}
