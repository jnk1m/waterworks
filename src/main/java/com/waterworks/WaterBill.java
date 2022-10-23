package com.waterworks;

public class WaterBill {
   private String city;
   private String sector;
   private int unitPrice;
   private int billTotal;

   public WaterBill(String city, String sector, int unitPrice, int billTotal) {
      this.city = city;
      this.sector = sector;
      this.unitPrice = unitPrice;
      this.billTotal = billTotal;
   }

   public String getCity() {
      return city;
   }

   public String getSector() {
      return sector;
   }

   public int getUnitPrice() {
      return unitPrice;
   }

   public int getBillTotal() {
      return billTotal;
   }

   @Override
   public String toString() {
      return getClass().getSimpleName()
              + " {city=" + getCity() + ","
              + "sector=" + getSector() + ", "
              + "unitPrice= " + getUnitPrice() + " , "
              + "billTotal= " + getBillTotal() + "}";

   }
}
