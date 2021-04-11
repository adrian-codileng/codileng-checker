package com.codileng.pojos;

import java.io.File;

public class Product {
   private String idProducto;
   private String nomProducto;
   private String descProducto;
   private double stockProducto;
   private File fotoProducto;
   private String unidadProducto;
   private double precioCompraProducto;
   private double precioVentaProducto;
   private double existenciasProducto;
   private int idCategoria;
   private int idProveedor;

   public Product(String idProducto, String nomProducto, String descProducto, double stockProducto, File fotoProducto, String unidadProducto, double precioCompraProducto, double precioVentaProducto, double existenciasProducto, int idCategoria, int idProveedor) {
      this.idProducto = idProducto;
      this.nomProducto = nomProducto;
      this.descProducto = descProducto;
      this.stockProducto = stockProducto;
      this.fotoProducto = fotoProducto;
      this.unidadProducto = unidadProducto;
      this.precioCompraProducto = precioCompraProducto;
      this.precioVentaProducto = precioVentaProducto;
      this.existenciasProducto = existenciasProducto;
      this.idCategoria = idCategoria;
      this.idProveedor = idProveedor;
   }

   public String getIdProducto() {
      return this.idProducto;
   }

   public void setIdProducto(String idProducto) {
      this.idProducto = idProducto;
   }

   public String getNomProducto() {
      return this.nomProducto;
   }

   public void setNomProducto(String nomProducto) {
      this.nomProducto = nomProducto;
   }

   public String getDescProducto() {
      return this.descProducto;
   }

   public void setDescProducto(String descProducto) {
      this.descProducto = descProducto;
   }

   public double getStockProducto() {
      return this.stockProducto;
   }

   public void setStockProducto(double stockProducto) {
      this.stockProducto = stockProducto;
   }

   public File getFotoProducto() {
      return this.fotoProducto;
   }

   public void setFotoProducto(File fotoProducto) {
      this.fotoProducto = fotoProducto;
   }

   public String getUnidadProducto() {
      return this.unidadProducto;
   }

   public void setUnidadProducto(String unidadProducto) {
      this.unidadProducto = unidadProducto;
   }

   public double getPrecioCompraProducto() {
      return this.precioCompraProducto;
   }

   public void setPrecioCompraProducto(double precioCompraProducto) {
      this.precioCompraProducto = precioCompraProducto;
   }

   public double getPrecioVentaProducto() {
      return this.precioVentaProducto;
   }

   public void setPrecioVentaProducto(double precioVentaProducto) {
      this.precioVentaProducto = precioVentaProducto;
   }

   public double getExistenciasProducto() {
      return this.existenciasProducto;
   }

   public void setExistenciasProducto(double existenciasProducto) {
      this.existenciasProducto = existenciasProducto;
   }

   public int getIdCategoria() {
      return this.idCategoria;
   }

   public void setIdCategoria(int idCategoria) {
      this.idCategoria = idCategoria;
   }

   public int getIdProveedor() {
      return this.idProveedor;
   }

   public void setIdProveedor(int idProveedor) {
      this.idProveedor = idProveedor;
   }

   public String toString() {
      return this.nomProducto;
   }
}
