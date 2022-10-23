package com.waterworks.parser;

import java.util.PriorityQueue;

public interface DataParser {
   public PriorityQueue<String[]> parseCsvToQueue(String path);
}
