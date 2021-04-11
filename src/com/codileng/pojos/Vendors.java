package com.codileng.pojos;

public class Vendors {
   private int idProveedor;
   private String nomProveedor;
   private String dirProveedor;
   private String telProveedor;
   private String emailProveedor;
   private String contactoProveedor;

   public Vendors(int idProveedor, String nomProveedor, String dirProveedor, String telProveedor, String emailProveedor, String contactoProveedor) {
      this.idProveedor = idProveedor;
      this.nomProveedor = nomProveedor;
      this.dirProveedor = dirProveedor;
      this.telProveedor = telProveedor;
      this.emailProveedor = emailProveedor;
      this.contactoProveedor = contactoProveedor;
   }

   public int getIdProveedor() {
      return this.idProveedor;
   }

   public void setIdProveedor(int idProveedor) {
      this.idProveedor = idProveedor;
   }

   public String getNomProveedor() {
      return this.nomProveedor;
   }

   public void setNomProveedor(String nomProveedor) {
      this.nomProveedor = nomProveedor;
   }

   public String getDirProveedor() {
      return this.dirProveedor;
   }

   public void setDirProveedor(String dirProveedor) {
      this.dirProveedor = dirProveedor;
   }

   public String getTelProveedor() {
      return this.telProveedor;
   }

   public void setTelProveedor(String telProveedor) {
      this.telProveedor = telProveedor;
   }

   public String getEmailProveedor() {
      return this.emailProveedor;
   }

   public void setEmailProveedor(String emailProveedor) {
      this.emailProveedor = emailProveedor;
   }

   public String getContactoProveedor() {
      return this.contactoProveedor;
   }

   public void setContactoProveedor(String contactoProveedor) {
      this.contactoProveedor = contactoProveedor;
   }

   public String toString() {
      return this.nomProveedor;
   }
}
