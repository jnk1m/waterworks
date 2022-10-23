package com.waterworks.billing;

import com.waterworks.parser.DataParserImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

@Component
public class BillingRepositoryImpl implements BillingRepository {

   DataParserImpl dataParser;

   public BillingRepositoryImpl(DataParserImpl dataParser) {
      this.dataParser = dataParser;
   }

   PriorityQueue<String[]> rateQueue = new PriorityQueue<>();
   List<String[]> cheapestFiveList = new ArrayList<>();

   @Override
   public PriorityQueue<String[]> loadRateQueue(String path) {
      rateQueue = dataParser.parseCsvToQueue(path);
      return rateQueue;
   }

   int getFiveFlag = 0;

   @Override
   public List<String[]> getFiveCheapestRate(int usage) {
      while (getFiveFlag < 5) {
         cheapestFiveList.add(rateQueue.poll());
         getFiveFlag++;
      }
      return cheapestFiveList;
   }
}
