package com.waterworks.billing;

import java.util.List;
import java.util.PriorityQueue;

public interface BillingRepository {
   public PriorityQueue<String[]> loadRateQueue(String path);

   public List<String[]> getFiveCheapestRate(int usage);

}
