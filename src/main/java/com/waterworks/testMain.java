package com.waterworks;

import java.util.ArrayList;
import java.util.List;

public class testMain {
   public static void main(String[] args) {
      List<String> test = new ArrayList<>();

      test.add("1");
      test.add("동두천시");
      test.add("가정용");
      test.add("1");
      test.add("1");
      test.add("20");
      test.add("690");



      List<List<String>> test2 = new ArrayList<>();
      test2.add(test);

      System.out.println(test2.get(0));

   }
}
