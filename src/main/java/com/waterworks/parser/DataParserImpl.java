package com.waterworks.parser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

@Component
public class DataParserImpl implements DataParser {
   PriorityQueue<String[]> rateQueue = new PriorityQueue<>(new Comparator<String[]>() {
      @Override
      public int compare(String[] o1, String[] o2) {
         int firstValue = Integer.parseInt(o1[6]);
         int secondValue = Integer.parseInt(o2[6]);
         if (firstValue == secondValue) {
            return Integer.compare(secondValue, firstValue);
         }
         return Integer.compare(firstValue, secondValue);
      }
   });

   @Override
   public PriorityQueue<String[]> parseCsvToQueue(String path) {
      try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
         while (csvReader.readNext() != null) {
            rateQueue.add(csvReader.readNext());
         }
      } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
      } catch (IOException e) {
         throw new RuntimeException(e);
      } catch (CsvValidationException e) {
         throw new RuntimeException(e);
      }

      return rateQueue;
   }

}


