package com.waterworks;

import com.waterworks.billing.BillingRepository;
import com.waterworks.config.WaterWorkConfig;
import com.waterworks.rate.RateUsageFee;
import com.waterworks.result.ResultReport;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(WaterWorkConfig.class);
      BillingRepository billingRepository = ctx.getBean(BillingRepository.class);
      RateUsageFee rateUsageFee = ctx.getBean(RateUsageFee.class);
      ResultReport resultReport = ctx.getBean(ResultReport.class);

      String path = "src/main/resources/Tariff_20220331.csv";

      try (Scanner scanner = new Scanner(System.in);) {
         billingRepository.loadRateQueue(path);
         System.out.println("물 사용량을 입력하세요");
         int usage = scanner.nextInt();

         List<String[]> fiveCheapestRate = billingRepository.getFiveCheapestRate(usage);
         List<String[]> calculatedUsageFeeList = rateUsageFee.calculateRate(usage);

         resultReport.mergeData(fiveCheapestRate, calculatedUsageFeeList);
         resultReport.reportResult();
      } catch (RuntimeException e) {
         e.printStackTrace();
      }


   }
}
