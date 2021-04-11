package com.codileng.database;

import com.codileng.pojos.Product;
import com.codileng.pojos.ProductCategory;
import com.codileng.pojos.Sale;
import com.codileng.pojos.SaleDetail;
import com.codileng.pojos.Vendors;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
   Connection conn = null;
   PreparedStatement prepSt = null;
   Statement st = null;
   ResultSet rs = null;

   public DataBase() {
      try {
         Class.forName("org.postgresql.Driver");
      } catch (ClassNotFoundException var2) {
         var2.printStackTrace();
      }

   }

   public void insertarProducto(Product producto) {
      try {
         this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/codileng", "postgres", "123");
         File fileFoto = producto.getFotoProducto();
         FileInputStream fis = new FileInputStream(fileFoto);
         String sql = "INSERT INTO cat_productos (id_prod, nombre_prod, desc_prod, stock_prod, foto_prod, unidad_prod,precio_compra_prod, precio_venta_prod, existencias_prod, id_categoria_prod, id_proveedor) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         this.prepSt = this.conn.prepareStatement(sql);
         this.prepSt.setString(1, producto.getIdProducto());
         this.prepSt.setString(2, producto.getNomProducto());
         this.prepSt.setString(3, producto.getDescProducto());
         this.prepSt.setDouble(4, producto.getStockProducto());
         long tamanoFoto = fileFoto.length();
         this.prepSt.setBinaryStream(5, fis, tamanoFoto);
         this.prepSt.setString(6, producto.getUnidadProducto());
         this.prepSt.setDouble(7, producto.getPrecioCompraProducto());
         this.prepSt.setDouble(8, producto.getPrecioVentaProducto());
         this.prepSt.setDouble(9, producto.getExistenciasProducto());
         this.prepSt.setInt(10, producto.getIdCategoria());
         this.prepSt.setInt(11, producto.getIdProveedor());
         this.prepSt.executeUpdate();
      } catch (SQLException var17) {
         var17.printStackTrace();
      } catch (FileNotFoundException var18) {
         Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, (String)null, var18);
      } finally {
         try {
            this.prepSt.close();
            this.conn.close();
         } catch (SQLException var16) {
            var16.printStackTrace();
         }

      }

   }

   public void borrarProducto(Product producto) {
      try {
         this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/codileng", "postgres", "123");
         String sql = "DELETE FROM cat_productos WHERE id_prod=?";
         this.prepSt = this.conn.prepareStatement(sql);
         this.prepSt.setString(1, producto.getIdProducto());
         this.prepSt.executeUpdate();
      } catch (SQLException var11) {
         var11.printStackTrace();
      } finally {
         try {
            this.prepSt.close();
            this.conn.close();
         } catch (SQLException var10) {
            var10.printStackTrace();
         }

      }

   }

   public void actualizarProducto(Product producto, boolean cambiarFoto) {
      try {
         this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/codileng", "postgres", "123");
         if (cambiarFoto) {
            File fileFoto = producto.getFotoProducto();
            FileInputStream fis = new FileInputStream(fileFoto);
            String sql = "UPDATE cat_producto SET desc_prod=?, stock_prod=?, foto_prod=?, unidad_prod=?, precio_compra_prod=?, precio_venta_prod=?, id_categoria_prod=?, id_proveedor=? WHERE id_prod=?";
            this.prepSt = this.conn.prepareStatement(sql);
            this.prepSt.setString(1, producto.getDescProducto());
            this.prepSt.setDouble(2, producto.getStockProducto());
            long tamanoFoto = fileFoto.length();
            this.prepSt.setBinaryStream(3, fis, tamanoFoto);
            this.prepSt.setString(4, producto.getUnidadProducto());
            this.prepSt.setDouble(5, producto.getPrecioCompraProducto());
            this.prepSt.setDouble(6, producto.getPrecioVentaProducto());
            this.prepSt.setInt(7, producto.getIdCategoria());
            this.prepSt.setInt(8, producto.getIdProveedor());
            this.prepSt.setString(9, producto.getIdProducto());
         } else {
            String sql = "UPDATE cat_productos SET desc_prod=?, stock_prod=?, unidad_prod=?, precio_compra_prod=?, precio_venta_prod=?, id_categoria_prod=?, id_proveedor=? WHERE id_prod=?";
            this.prepSt = this.conn.prepareStatement(sql);
            this.prepSt.setString(1, producto.getDescProducto());
            this.prepSt.setDouble(2, producto.getStockProducto());
            this.prepSt.setString(3, producto.getUnidadProducto());
            this.prepSt.setDouble(4, producto.getPrecioCompraProducto());
            this.prepSt.setDouble(5, producto.getPrecioVentaProducto());
            this.prepSt.setInt(6, producto.getIdCategoria());
            this.prepSt.setInt(7, producto.getIdProveedor());
            this.prepSt.setString(8, producto.getIdProducto());
         }

         this.prepSt.executeUpdate();
      } catch (SQLException var18) {
         var18.printStackTrace();
      } catch (FileNotFoundException var19) {
         Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, (String)null, var19);
      } finally {
         try {
            this.prepSt.close();
            this.conn.close();
         } catch (SQLException var17) {
            var17.printStackTrace();
         }

      }

   }

   public InputStream buscarFoto(Product producto) {
      InputStream streamFoto = null;

      try {
         this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/codileng", "postgres", "123");
         String sql = "SELECT foto_prod from cat_productos where id_prod = ?";
         this.prepSt = this.conn.prepareStatement(sql);
         this.prepSt.setString(1, producto.getIdProducto());

         for(this.rs = this.prepSt.executeQuery(); this.rs.next(); streamFoto = this.rs.getBinaryStream("foto_prod")) {
         }
      } catch (SQLException var12) {
         var12.printStackTrace();
      } finally {
         try {
            this.prepSt.close();
            this.conn.close();
         } catch (SQLException var11) {
            var11.printStackTrace();
         }

      }

      return streamFoto;
   }

   public void actualizarInventario(Product producto, double cantidad) {
      try {
         this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/codileng", "postgres", "123");
         String sql = "UPDATE cat_productos SET existencias_prod = ? WHERE id_prod=?";
         this.prepSt = this.conn.prepareStatement(sql);
         this.prepSt.setDouble(1, cantidad);
         this.prepSt.setString(2, producto.getIdProducto());
         this.prepSt.executeUpdate();
      } catch (SQLException var13) {
         var13.printStackTrace();
      } finally {
         try {
            this.prepSt.close();
            this.conn.close();
         } catch (SQLException var12) {
            var12.printStackTrace();
         }

      }

   }

   public void insertarCategoriaProducto(ProductCategory categoria) {
      try {
         this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/codileng", "postgres", "123");
         String sql = "INSERT INTO cat_categorias (nom_categoria_prod, desc_categoria_prod) values(?, ?)";
         this.prepSt = this.conn.prepareStatement(sql);
         this.prepSt.setString(1, categoria.getNomCategoriaProd());
         this.prepSt.setString(2, categoria.getDescCategoriaProd());
         this.prepSt.executeUpdate();
      } catch (SQLException var11) {
         var11.printStackTrace();
      } finally {
         try {
            this.prepSt.close();
            this.conn.close();
         } catch (SQLException var10) {
            var10.printStackTrace();
         }

      }

   }

   public void insertarProveedor(Vendors prov) {
      try {
         this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/codileng", "postgres", "123");
         String sql = "INSERT INTO cat_proveedores (nom_proveedor, dir_proveedor, telefono_proveedor, email_proveedor, contacto_proveedor) values(?, ?, ?, ?, ? )";
         this.prepSt = this.conn.prepareStatement(sql);
         this.prepSt.setString(1, prov.getNomProveedor());
         this.prepSt.setString(2, prov.getDirProveedor());
         this.prepSt.setString(3, prov.getTelProveedor());
         this.prepSt.setString(4, prov.getEmailProveedor());
         this.prepSt.setString(5, prov.getContactoProveedor());
         this.prepSt.executeUpdate();
      } catch (SQLException var11) {
         var11.printStackTrace();
      } finally {
         try {
            this.prepSt.close();
            this.conn.close();
         } catch (SQLException var10) {
            var10.printStackTrace();
         }

      }

   }

   public Long insertarVenta(Sale venta) {
      Long lastVal = 0L;

      try {
         this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/codileng", "postgres", "123");
         String sql = "INSERT INTO ventas (monto_venta, fecha_venta) values(?, ?)";
         this.prepSt = this.conn.prepareStatement(sql);
         this.prepSt.setDouble(1, venta.getMontoVenta());
         this.prepSt.setDate(2, venta.getFechaVenta());
         this.prepSt.executeUpdate();
         this.prepSt.close();
         this.prepSt = this.conn.prepareStatement("select lastval()");

         for(this.rs = this.prepSt.executeQuery(); this.rs.next(); lastVal = this.rs.getLong("lastval")) {
         }
      } catch (SQLException var12) {
         var12.printStackTrace();
      } finally {
         try {
            this.rs.close();
            this.prepSt.close();
            this.conn.close();
         } catch (SQLException var11) {
            var11.printStackTrace();
         }

      }

      return lastVal;
   }

   public void insertarDetalleVenta(SaleDetail detalle) {
      try {
         this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/codileng", "postgres", "123");
         String sql = "INSERT INTO detalle_venta (id_venta, id_prod, cantidad_vendida) values(?, ?, ?)";
         this.prepSt = this.conn.prepareStatement(sql);
         this.prepSt.setLong(1, detalle.getIdVenta());
         this.prepSt.setString(2, detalle.getIdProd());
         this.prepSt.setDouble(3, detalle.getCantidadVendida());
         this.prepSt.executeUpdate();
      } catch (SQLException var11) {
         var11.printStackTrace();
      } finally {
         try {
            this.prepSt.close();
            this.conn.close();
         } catch (SQLException var10) {
            var10.printStackTrace();
         }

      }

   }

   public void obtenerProducto(Product prod) {
      try {
         this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/codileng", "postgres", "123");
         String sql = "SELECT * from cat_productos where id_prod = ?";
         this.prepSt = this.conn.prepareStatement(sql);
         this.prepSt.setString(1, prod.getIdProducto());
         this.rs = this.prepSt.executeQuery();

         while(true) {
            if (this.rs.next()) {
               continue;
            }
         }
      } catch (SQLException var11) {
         var11.printStackTrace();
      } finally {
         try {
            this.prepSt.close();
            this.conn.close();
         } catch (SQLException var10) {
            var10.printStackTrace();
         }

      }

   }

   public ArrayList<Product> obtenerProductosPorCriterio(String criterio) {
      ArrayList listaProductos = new ArrayList();

      try {
         this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/codileng", "postgres", "123");
         String sql = "SELECT * FROM cat_productos WHERE id_prod LIKE '" + criterio + "%'OR nombre_prod LIKE '%" + criterio + "%'order by nombre_prod";
         this.st = this.conn.createStatement();
         this.rs = this.st.executeQuery(sql);

         while(this.rs.next()) {
            String id = this.rs.getString("id_prod");
            String nombre = this.rs.getString("nombre_prod");
            String descripcion = this.rs.getString("desc_prod");
            double stock = this.rs.getDouble("stock_prod");
            String unidad = this.rs.getString("unidad_prod");
            double precioCompra = this.rs.getDouble("precio_compra_prod");
            double precioVenta = this.rs.getDouble("precio_venta_prod");
            double existencias = this.rs.getDouble("existencias_prod");
            int idCategoria = this.rs.getInt("id_categoria_prod");
            int idProveedor = this.rs.getInt("id_proveedor");
            Product producto = new Product(id, nombre, descripcion, stock, (File)null, unidad, precioCompra, precioVenta, existencias, idCategoria, idProveedor);
            listaProductos.add(producto);
         }
      } catch (SQLException var27) {
         var27.printStackTrace();
      } finally {
         try {
            this.st.close();
            this.conn.close();
         } catch (SQLException var26) {
            var26.printStackTrace();
         }

      }

      return listaProductos;
   }

   public ArrayList<Product> obtenerProductos() {
      ArrayList listaProductos = new ArrayList();

      try {
         this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/codileng", "postgres", "123");
         String sql = "SELECT * FROM cat_productos order by nombre_prod";
         this.prepSt = this.conn.prepareStatement(sql);
         this.rs = this.prepSt.executeQuery();

         while(this.rs.next()) {
            String id = this.rs.getString("id_prod");
            String nombre = this.rs.getString("nombre_prod");
            String descripcion = this.rs.getString("desc_prod");
            double stock = this.rs.getDouble("stock_prod");
            String unidad = this.rs.getString("unidad_prod");
            double precioCompra = this.rs.getDouble("precio_compra_prod");
            double precioVenta = this.rs.getDouble("precio_venta_prod");
            double existencias = this.rs.getDouble("existencias_prod");
            int idCategoria = this.rs.getInt("id_categoria_prod");
            int idProveedor = this.rs.getInt("id_proveedor");
            Product producto = new Product(id, nombre, descripcion, stock, (File)null, unidad, precioCompra, precioVenta, existencias, idCategoria, idProveedor);
            listaProductos.add(producto);
         }
      } catch (SQLException var26) {
         var26.printStackTrace();
      } finally {
         try {
            this.prepSt.close();
            this.conn.close();
         } catch (SQLException var25) {
            var25.printStackTrace();
         }

      }

      return listaProductos;
   }

   public ArrayList<ProductCategory> obtenerCategorias() {
      ArrayList listaCategorias = new ArrayList();

      try {
         this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/codileng", "postgres", "123");
         String sql = "SELECT * FROM cat_categorias";
         this.prepSt = this.conn.prepareStatement(sql);
         this.rs = this.prepSt.executeQuery();

         while(this.rs.next()) {
            int id = this.rs.getInt("id_categoria_prod");
            String nombre = this.rs.getString("nom_categoria_prod");
            String descripcion = this.rs.getString("desc_categoria_prod");
            ProductCategory categoria = new ProductCategory(id, nombre, descripcion);
            listaCategorias.add(categoria);
         }
      } catch (SQLException var15) {
         var15.printStackTrace();
      } finally {
         try {
            this.prepSt.close();
            this.conn.close();
         } catch (SQLException var14) {
            var14.printStackTrace();
         }

      }

      return listaCategorias;
   }

   public ArrayList<Vendors> obtenerProveedores() {
      ArrayList listaProveedores = new ArrayList();

      try {
         this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/codileng", "postgres", "123");
         String sql = "SELECT * FROM cat_proveedores";
         this.prepSt = this.conn.prepareStatement(sql);
         this.rs = this.prepSt.executeQuery();

         while(this.rs.next()) {
            int id = this.rs.getInt("id_proveedor");
            String nombre = this.rs.getString("nom_proveedor");
            String direccion = this.rs.getString("dir_proveedor");
            String telefono = this.rs.getString("telefono_proveedor");
            String email = this.rs.getString("email_proveedor");
            String contacto = this.rs.getString("contacto_proveedor");
            Vendors proveedor = new Vendors(id, nombre, direccion, telefono, email, contacto);
            listaProveedores.add(proveedor);
         }
      } catch (SQLException var18) {
         var18.printStackTrace();
      } finally {
         try {
            this.prepSt.close();
            this.conn.close();
         } catch (SQLException var17) {
            var17.printStackTrace();
         }

      }

      return listaProveedores;
   }
}
