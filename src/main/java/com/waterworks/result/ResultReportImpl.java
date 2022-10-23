package com.waterworks.result;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResultReportImpl implements ResultReport {
   @Override
   public void mergeData(List<String[]> fiveCheapestRate, List<String[]> calculatedUsageFeeList) {
      //최종 결과물 리스트를 만들어
      //fiveCheapestRate 랑 CalculatedUsage랑 아이디를 비교를 해
      //아이디가 같으면 취합을 해
      //취합한 리스트를 리턴해

      List<String[]> finalResultList = new ArrayList<>();


      while(true){
         String[] strings = fiveCheapestRate.get(1);
         String[] strings1 = calculatedUsageFeeList.get(1);
         String[] test = new String[4];
         if(strings[0].equals(strings1[0])){

            test[0] = strings[1];
            test[1] = strings[2];
            test[2] = strings[6];
            test[3] = strings1[1];
         }
         finalResultList.add(test);



      }
   }

   @Override
   public void reportResult() {

   }
}
