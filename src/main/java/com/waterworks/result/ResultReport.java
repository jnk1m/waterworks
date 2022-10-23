package com.waterworks.result;

import java.util.List;

public interface ResultReport {

   public void mergeData(List<String[]> fiveCheapestRate, List<String[]> calculatedUsageFeeList);

   public void reportResult();
}
