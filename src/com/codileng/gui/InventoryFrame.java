package com.codileng.gui;

import com.codileng.database.DataBase;
import com.codileng.pojos.Product;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class InventoryFrame extends JInternalFrame {
   DefaultTableModel modeloTabla = new DefaultTableModel();
   DataBase base = new DataBase();
   Product productoSeleccionado = null;
   String informacion = "";
   private JButton btnAgregarExistencia;
   private JButton btnBorrarProd;
   private JButton btnCategoria;
   private JButton btnModificarProd;
   private JButton btnNuevoArticulo;
   private JButton btnProveedor;
   private JTextField campoAgregarExistencia;
   private JTextField campoBuscar;
   private JTextField campoClaveProducto;
   private JTextField campoExistenciaProducto;
   private JTextField campoNombreProducto;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JLabel jLabel3;
   private JLabel jLabel4;
   private JLabel jLabel5;
   private JLabel jLabel7;
   private JScrollPane jScrollPane1;
   private JSeparator jSeparator1;
   private JSeparator jSeparator2;
   private JSeparator jSeparator4;
   private JLabel lblImagen;
   private JTable tablaProductos;

   public InventoryFrame() {
      this.initComponents();
      this.cargarColumnasTabla();
      this.cargarModeloTabla();
   }

   private void cargarColumnasTabla() {
      this.modeloTabla.addColumn("Clave");
      this.modeloTabla.addColumn("Nombre");
      this.modeloTabla.addColumn("Unidad");
      this.modeloTabla.addColumn("Precio Compra");
      this.modeloTabla.addColumn("Precio Venta");
      this.modeloTabla.addColumn("Existencias");
   }

   private void cargarModeloTabla() {
      this.limpiarTabla();
      ArrayList<Product> listaProductos = this.base.obtenerProductos();
      int numeroProductos = listaProductos.size();
      this.modeloTabla.setNumRows(numeroProductos);

      for(int i = 0; i < numeroProductos; ++i) {
         Product producto = (Product)listaProductos.get(i);
         String clave = producto.getIdProducto();
         String nombre = producto.getNomProducto();
         String unidad = producto.getUnidadProducto();
         Double precioCompra = producto.getPrecioCompraProducto();
         Double precioVenta = producto.getPrecioVentaProducto();
         Double existencias = producto.getExistenciasProducto();
         this.modeloTabla.setValueAt(clave, i, 0);
         this.modeloTabla.setValueAt(producto, i, 1);
         this.modeloTabla.setValueAt(unidad, i, 2);
         this.modeloTabla.setValueAt(precioCompra, i, 3);
         this.modeloTabla.setValueAt(precioVenta, i, 4);
         this.modeloTabla.setValueAt(existencias, i, 5);
      }

   }

   private void initComponents() {
      this.btnNuevoArticulo = new JButton();
      this.btnCategoria = new JButton();
      this.btnProveedor = new JButton();
      this.jSeparator1 = new JSeparator();
      this.jSeparator2 = new JSeparator();
      this.jLabel1 = new JLabel();
      this.jLabel2 = new JLabel();
      this.campoClaveProducto = new JTextField();
      this.jLabel3 = new JLabel();
      this.campoNombreProducto = new JTextField();
      this.jLabel4 = new JLabel();
      this.campoExistenciaProducto = new JTextField();
      this.jScrollPane1 = new JScrollPane();
      this.tablaProductos = new JTable();
      this.tablaProductos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
         public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting() && InventoryFrame.this.tablaProductos.getSelectedRow() >= 0) {
               int filaSeleccionada = InventoryFrame.this.tablaProductos.getSelectedRow();
               Product producto = (Product)InventoryFrame.this.modeloTabla.getValueAt(filaSeleccionada, 1);
               InventoryFrame.this.campoNombreProducto.setText(producto.getNomProducto());
               InventoryFrame.this.campoClaveProducto.setText(producto.getIdProducto());
               String existencias = String.valueOf(producto.getExistenciasProducto());
               InventoryFrame.this.campoExistenciaProducto.setText(existencias);
               InventoryFrame.this.productoSeleccionado = producto;
               InventoryFrame.this.desplegarFoto(producto);
            }

         }
      });
      this.jLabel5 = new JLabel();
      this.lblImagen = new JLabel();
      this.campoAgregarExistencia = new JTextField();
      this.btnAgregarExistencia = new JButton();
      this.jSeparator4 = new JSeparator();
      this.btnBorrarProd = new JButton();
      this.btnModificarProd = new JButton();
      this.jLabel7 = new JLabel();
      this.campoBuscar = new JTextField();
      this.setTitle("Inventario");
      this.btnNuevoArticulo.setIcon(new ImageIcon(this.getClass().getResource("/com/codileng/images/producto.png")));
      this.btnNuevoArticulo.setToolTipText("Nuevo producto");
      this.btnNuevoArticulo.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            InventoryFrame.this.btnNuevoArticuloActionPerformed(evt);
         }
      });
      this.btnCategoria.setIcon(new ImageIcon(this.getClass().getResource("/com/codileng/images/categoria.png")));
      this.btnCategoria.setToolTipText("Nueva categoría");
      this.btnCategoria.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            InventoryFrame.this.btnCategoriaActionPerformed(evt);
         }
      });
      this.btnProveedor.setIcon(new ImageIcon(this.getClass().getResource("/com/codileng/images/proveedor.png")));
      this.btnProveedor.setToolTipText("Nuevo proveedor");
      this.btnProveedor.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            InventoryFrame.this.btnProveedorActionPerformed(evt);
         }
      });
      this.jLabel1.setHorizontalAlignment(0);
      this.jLabel1.setText("INVENTARIO");
      this.jLabel2.setText("Código:");
      this.jLabel3.setText("Nombre:");
      this.jLabel4.setText("Existencia:");
      this.tablaProductos.setModel(this.modeloTabla);
      this.jScrollPane1.setViewportView(this.tablaProductos);
      this.jLabel5.setText("Ingresar:");
      this.lblImagen.setHorizontalAlignment(0);
      this.lblImagen.setBorder(BorderFactory.createEtchedBorder());
      this.btnAgregarExistencia.setBackground(new Color(0, 255, 0));
      this.btnAgregarExistencia.setFont(new Font("Dialog", 1, 14));
      this.btnAgregarExistencia.setForeground(new Color(255, 255, 255));
      this.btnAgregarExistencia.setText("Guardar");
      this.btnAgregarExistencia.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            InventoryFrame.this.btnAgregarExistenciaActionPerformed(evt);
         }
      });
      this.jSeparator4.setOrientation(1);
      this.btnBorrarProd.setIcon(new ImageIcon(this.getClass().getResource("/com/codileng/images/cancelar.png")));
      this.btnBorrarProd.setToolTipText("Eliminar producto");
      this.btnBorrarProd.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            InventoryFrame.this.btnBorrarProdActionPerformed(evt);
         }
      });
      this.btnModificarProd.setIcon(new ImageIcon(this.getClass().getResource("/com/codileng/images/editar.png")));
      this.btnModificarProd.setToolTipText("Editar producto");
      this.btnModificarProd.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            InventoryFrame.this.btnModificarProdActionPerformed(evt);
         }
      });
      this.jLabel7.setText("Buscar:");
      this.campoBuscar.addKeyListener(new KeyAdapter() {
         public void keyReleased(KeyEvent evt) {
            InventoryFrame.this.campoBuscarKeyReleased(evt);
         }
      });
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jSeparator1, -2, 34, -2).addComponent(this.btnNuevoArticulo, -2, 73, -2)).addGap(12, 12, 12).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.btnCategoria, -2, 73, -2)).addGap(12, 12, 12).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jSeparator2, -2, 73, -2).addComponent(this.btnProveedor, -2, 73, -2)).addGap(17, 17, 17).addComponent(this.jSeparator4, -2, 9, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.lblImagen, -2, 186, -2).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.btnModificarProd, -2, 73, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.btnBorrarProd, -2, 73, -2)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel5).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.campoAgregarExistencia)).addComponent(this.btnAgregarExistencia, -1, -1, 32767))).addComponent(this.jScrollPane1, -1, 636, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.jLabel7)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.campoBuscar).addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.campoNombreProducto, -2, 179, -2).addComponent(this.campoClaveProducto, -2, 179, -2).addComponent(this.campoExistenciaProducto, -2, 179, -2))))).addContainerGap()));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.TRAILING, false).addComponent(this.jSeparator4, Alignment.LEADING).addGroup(Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.btnModificarProd, -2, 73, -2).addComponent(this.btnBorrarProd, -2, 73, -2)).addGap(27, 27, 27).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.campoAgregarExistencia, -2, -1, -2).addComponent(this.jLabel5)).addGap(18, 18, 18).addComponent(this.btnAgregarExistencia, -2, 40, -2)).addGroup(Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.btnProveedor, -2, 73, -2).addComponent(this.btnCategoria, -2, 73, -2).addComponent(this.btnNuevoArticulo, -2, 73, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jSeparator1, -2, 10, -2).addComponent(this.jSeparator2, -2, 10, -2)).addComponent(this.jLabel1, -2, 23, -2)).addGap(4, 4, 4).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.campoClaveProducto, -2, -1, -2).addComponent(this.jLabel2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.campoNombreProducto, -2, -1, -2).addComponent(this.jLabel3)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.campoExistenciaProducto, -2, -1, -2).addComponent(this.jLabel4))).addComponent(this.lblImagen, Alignment.LEADING, -2, 186, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.campoBuscar, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -2, 147, -2).addContainerGap()));
      this.pack();
   }

   private void btnNuevoArticuloActionPerformed(ActionEvent evt) {
      ProductFrame articulo = new ProductFrame((Frame)null, true, (Product)null, (ImageIcon)null, "Nuevo Producto", false);
      articulo.setVisible(true);
      articulo.setDefaultCloseOperation(2);
      articulo.setLocation(600, 150);
      articulo.setAlwaysOnTop(true);
   }

   private void btnCategoriaActionPerformed(ActionEvent evt) {
      CategoryFrame category = new CategoryFrame((Frame)null, true);
      category.setVisible(true);
      category.setDefaultCloseOperation(2);
      category.setLocation(600, 150);
      category.setAlwaysOnTop(true);
   }

   private void btnProveedorActionPerformed(ActionEvent evt) {
      VendorsFrame vendor = new VendorsFrame((Frame)null, true);
      vendor.setVisible(true);
      vendor.setDefaultCloseOperation(2);
      vendor.setLocation(600, 150);
      vendor.setAlwaysOnTop(true);
   }

   private void btnAgregarExistenciaActionPerformed(ActionEvent evt) {
      double existencia = Double.parseDouble(this.campoAgregarExistencia.getText());
      double cantidadActual = this.productoSeleccionado.getExistenciasProducto();
      double nuevaCantidad = cantidadActual + existencia;
      this.base.actualizarInventario(this.productoSeleccionado, nuevaCantidad);
      this.limpiarTabla();
      this.cargarModeloTabla();
   }

   private void campoBuscarKeyReleased(KeyEvent evt) {
      this.limpiarTabla();
      String cadenaBusqueda = this.campoBuscar.getText();
      ArrayList<Product> listaProductos = this.base.obtenerProductosPorCriterio(cadenaBusqueda);
      int numeroProductos = listaProductos.size();
      this.modeloTabla.setNumRows(numeroProductos);

      for(int i = 0; i < numeroProductos; ++i) {
         Product producto = (Product)listaProductos.get(i);
         String clave = producto.getIdProducto();
         String nombre = producto.getNomProducto();
         String unidad = producto.getUnidadProducto();
         Double precioCompra = producto.getPrecioCompraProducto();
         Double precioVenta = producto.getPrecioVentaProducto();
         Double existencias = producto.getExistenciasProducto();
         this.modeloTabla.setValueAt(clave, i, 0);
         this.modeloTabla.setValueAt(producto, i, 1);
         this.modeloTabla.setValueAt(unidad, i, 2);
         this.modeloTabla.setValueAt(precioCompra, i, 3);
         this.modeloTabla.setValueAt(precioVenta, i, 4);
         this.modeloTabla.setValueAt(existencias, i, 5);
      }

   }

   private void btnModificarProdActionPerformed(ActionEvent evt) {
      String nombreProducto = this.productoSeleccionado.getNomProducto();
      ImageIcon imagenProducto = null;
      ProductFrame frameProd = null;
      int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de modificar el artículo " + nombreProducto + "?");
      if (opcion == 0) {
         try {
            InputStream is = this.base.buscarFoto(this.productoSeleccionado);
            BufferedImage bi = ImageIO.read(is);
            imagenProducto = new ImageIcon(bi);
            frameProd = new ProductFrame((Frame)null, true, this.productoSeleccionado, imagenProducto, "Actualizar producto", true);
            frameProd.setVisible(true);
            if (frameProd != null && frameProd.getInformacion() != "") {
               this.cargarModeloTabla();
            }
         } catch (IOException var8) {
            var8.printStackTrace();
         }
      }

   }

   private void btnBorrarProdActionPerformed(ActionEvent evt) {
      int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de borrar el producto?");
      if (opcion == 0) {
         this.modeloTabla.removeRow(this.tablaProductos.getSelectedRow());
         this.base.borrarProducto(this.productoSeleccionado);
      }

   }

   private void desplegarFoto(Product prod) {
      ImageIcon imagenProducto = null;

      try {
         InputStream is = this.base.buscarFoto(prod);
         BufferedImage bi = ImageIO.read(is);
         imagenProducto = new ImageIcon(bi);
         Image imgProd = imagenProducto.getImage();
         int anchoEtiqueta = this.lblImagen.getWidth();
         int altoEtiqueta = this.lblImagen.getHeight();
         Image imgRedimensionada = imgProd.getScaledInstance(anchoEtiqueta, altoEtiqueta, 1);
         ImageIcon iconRedimensionado = new ImageIcon(imgRedimensionada);
         this.lblImagen.setIcon(iconRedimensionado);
      } catch (IOException var10) {
         var10.printStackTrace();
      }

   }

   private void limpiarTabla() {
      int numFilas = this.modeloTabla.getRowCount();
      if (numFilas > 0) {
         for(int i = numFilas - 1; i >= 0; --i) {
            this.modeloTabla.removeRow(i);
         }
      }

   }
}
