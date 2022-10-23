package com.waterworks;

import com.waterworks.billing.BillingRepository;
import com.waterworks.billing.BillingRepositoryImpl;
import com.waterworks.config.waterWorkConfig;
import com.waterworks.rate.RateUsageFee;
import com.waterworks.result.ResultReport;
import com.waterworks.result.ResultReportImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(waterWorkConfig.class);
      BillingRepository billingRepository = ctx.getBean(BillingRepository.class);
      RateUsageFee rateUsageFee = ctx.getBean(RateUsageFee.class);
      ResultReport resultReport = ctx.getBean(ResultReport.class);


      String path = "src/main/resources/Tariff_20220331.csv";

      billingRepository.loadRateQueue(path);

      Scanner scanner = new Scanner(System.in);
      System.out.println("물 사용량을 입력하세요");
      int usage = scanner.nextInt();

      rateUsageFee.calculateRate(usage);

     // resultReport.mergeData();

      //여기서 물 사용량을 입력 받아서 상수도 사용 요금 서비스를 부르는 거지

      //List<String[]> fiveCheapestRate = billingRepository.getFiveCheapestRate(usage);




   }
}
