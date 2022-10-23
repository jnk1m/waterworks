package com.waterworks.rate;

import java.util.List;

public interface RateUsageFee {
   public List<String[]> calculateRate(int usage);
}
