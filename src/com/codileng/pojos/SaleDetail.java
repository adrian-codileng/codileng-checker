package com.codileng.pojos;

public class SaleDetail {
   private int idDetalleVenta;
   private Long idVenta;
   private String idProd;
   private double cantidadVendida;

   public SaleDetail(Long idVenta, String idProd, double cantidadVendida) {
      this.idVenta = idVenta;
      this.idProd = idProd;
      this.cantidadVendida = cantidadVendida;
   }

   public int getIdDetalleVenta() {
      return this.idDetalleVenta;
   }

   public void setIdDetalleVenta(int idDetalleVenta) {
      this.idDetalleVenta = idDetalleVenta;
   }

   public Long getIdVenta() {
      return this.idVenta;
   }

   public void setIdVenta(Long idVenta) {
      this.idVenta = idVenta;
   }

   public String getIdProd() {
      return this.idProd;
   }

   public void setIdProd(String idProd) {
      this.idProd = idProd;
   }

   public double getCantidadVendida() {
      return this.cantidadVendida;
   }

   public void setCantidadVendida(double cantidadVendida) {
      this.cantidadVendida = cantidadVendida;
   }
}
