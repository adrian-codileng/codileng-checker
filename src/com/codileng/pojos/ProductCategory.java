package com.codileng.pojos;

public class ProductCategory {
   private int idCategoriaProd;
   private String nomCategoriaProd;
   private String descCategoriaProd;

   public ProductCategory(int idCategoriaProd, String nomCategoriaProd, String descCategoriaProd) {
      this.idCategoriaProd = idCategoriaProd;
      this.nomCategoriaProd = nomCategoriaProd;
      this.descCategoriaProd = descCategoriaProd;
   }

   public int getIdCategoriaProd() {
      return this.idCategoriaProd;
   }

   public void setIdCategoriaProd(int idCategoriaProd) {
      this.idCategoriaProd = idCategoriaProd;
   }

   public String getNomCategoriaProd() {
      return this.nomCategoriaProd;
   }

   public void setNomCategoriaProd(String nomCategoriaProd) {
      this.nomCategoriaProd = nomCategoriaProd;
   }

   public String getDescCategoriaProd() {
      return this.descCategoriaProd;
   }

   public void setDescCategoriaProd(String descCategoriaProd) {
      this.descCategoriaProd = descCategoriaProd;
   }

   public String toString() {
      return this.nomCategoriaProd;
   }
}
