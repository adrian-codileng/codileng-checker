package com.codileng.pojos;

import java.sql.Date;

public class Sale {
   private int idVenta;
   private double montoVenta;
   private Date fechaVenta;

   public Sale(double montoVenta, Date fechaVenta) {
      this.montoVenta = montoVenta;
      this.fechaVenta = fechaVenta;
   }

   public int getIdVenta() {
      return this.idVenta;
   }

   public void setIdVenta(int idVenta) {
      this.idVenta = idVenta;
   }

   public double getMontoVenta() {
      return this.montoVenta;
   }

   public void setMontoVenta(double montoVenta) {
      this.montoVenta = montoVenta;
   }

   public Date getFechaVenta() {
      return this.fechaVenta;
   }

   public void setFechaVenta(Date fechaVenta) {
      this.fechaVenta = fechaVenta;
   }
}
