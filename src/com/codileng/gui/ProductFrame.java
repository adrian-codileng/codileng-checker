package com.codileng.gui;

import com.codileng.database.DataBase;
import com.codileng.pojos.Product;
import com.codileng.pojos.ProductCategory;
import com.codileng.pojos.Vendors;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProductFrame extends JDialog {
   DefaultComboBoxModel<ProductCategory> modeloCategorias = new DefaultComboBoxModel();
   DefaultComboBoxModel<Vendors> modeloProveedor = new DefaultComboBoxModel();
   DataBase base = new DataBase();
   boolean estaActualizando;
   String informacion = "";
   File imgArticleFile;
   private JButton btnCancelar;
   private JButton btnGuardarProducto;
   private JTextField campoClave;
   private JTextArea campoDesc;
   private JTextField campoNombre;
   private JTextField campoPrecioCompra;
   private JTextField campoPrecioVenta;
   private JTextField campoStock;
   private JComboBox<ProductCategory> comboCategorias;
   private JComboBox<Vendors> comboProveedores;
   private JComboBox<String> comboUnidades;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JLabel jLabel3;
   private JLabel jLabel4;
   private JLabel jLabel5;
   private JLabel jLabel6;
   private JLabel jLabel7;
   private JLabel jLabel8;
   private JLabel jLabel9;
   private JScrollPane jScrollPane1;
   private JSeparator jSeparator1;
   private JSeparator jSeparator2;
   private JSeparator jSeparator3;
   private JLabel lblImagenArticulo;

   public ProductFrame(Frame parent, boolean modal, Product producto, ImageIcon icon, String titulo, boolean actualizando) {
      super(parent, modal);
      this.cargarModeloCat();
      this.cargarModeloProv();
      this.initComponents();
      this.estaActualizando = actualizando;
      this.setTitle(titulo);
      if (producto != null) {
         this.cargarProducto(producto, icon);
      }

   }

   private void cargarProducto(Product producto, ImageIcon icono) {
      Image imgProd = icono.getImage();
      int anchoEtiqueta = this.lblImagenArticulo.getWidth();
      int altoEtiqueta = this.lblImagenArticulo.getHeight();
      Image imgRedimensionada = imgProd.getScaledInstance(anchoEtiqueta, altoEtiqueta, 1);
      ImageIcon iconRedimensionado = new ImageIcon(imgRedimensionada);
      this.lblImagenArticulo.setIcon(iconRedimensionado);
      String clave = producto.getIdProducto();
      String nombre = producto.getNomProducto();
      String descripcion = producto.getDescProducto();
      double stockRequerido = producto.getStockProducto();
      String unidad = producto.getUnidadProducto();
      double precioCompra = producto.getPrecioCompraProducto();
      double precioVenta = producto.getPrecioVentaProducto();
      this.campoClave.setText(clave);
      this.campoNombre.setText(nombre);
      this.campoDesc.setText(descripcion);
      this.campoStock.setText(String.valueOf(stockRequerido));
      this.comboUnidades.setSelectedItem(unidad);
      this.campoPrecioCompra.setText(String.valueOf(precioCompra));
      this.campoPrecioVenta.setText(String.valueOf(precioVenta));
      this.campoClave.setEnabled(false);
      this.campoNombre.setEnabled(false);
   }

   private void cargarModeloCat() {
      ArrayList<ProductCategory> listaCategorias = this.base.obtenerCategorias();
      Iterator var2 = listaCategorias.iterator();

      while(var2.hasNext()) {
         ProductCategory categoria = (ProductCategory)var2.next();
         this.modeloCategorias.addElement(categoria);
      }

   }

   private void cargarModeloProv() {
      ArrayList<Vendors> listaProveedores = this.base.obtenerProveedores();
      Iterator var2 = listaProveedores.iterator();

      while(var2.hasNext()) {
         Vendors proveedor = (Vendors)var2.next();
         this.modeloProveedor.addElement(proveedor);
      }

   }

   private void initComponents() {
      this.lblImagenArticulo = new JLabel();
      this.jLabel1 = new JLabel();
      this.campoClave = new JTextField();
      this.jLabel2 = new JLabel();
      this.campoStock = new JTextField();
      this.jLabel3 = new JLabel();
      this.comboCategorias = new JComboBox();
      this.jLabel4 = new JLabel();
      this.jSeparator1 = new JSeparator();
      this.jLabel5 = new JLabel();
      this.comboUnidades = new JComboBox();
      this.jLabel6 = new JLabel();
      this.campoPrecioCompra = new JTextField();
      this.jLabel7 = new JLabel();
      this.campoPrecioVenta = new JTextField();
      this.jSeparator2 = new JSeparator();
      this.jScrollPane1 = new JScrollPane();
      this.campoDesc = new JTextArea();
      this.btnGuardarProducto = new JButton();
      this.btnCancelar = new JButton();
      this.jLabel8 = new JLabel();
      this.comboProveedores = new JComboBox();
      this.jLabel9 = new JLabel();
      this.campoNombre = new JTextField();
      this.jSeparator3 = new JSeparator();
      this.setDefaultCloseOperation(2);
      this.setTitle("Nuevo producto");
      this.lblImagenArticulo.setHorizontalAlignment(0);
      this.lblImagenArticulo.setToolTipText("Presiona para elegir una imagen");
      this.lblImagenArticulo.setBorder(BorderFactory.createEtchedBorder());
      this.lblImagenArticulo.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent evt) {
            ProductFrame.this.lblImagenArticuloMousePressed(evt);
         }
      });
      this.jLabel1.setText("Código:");
      this.jLabel2.setText("Stock requerido:");
      this.jLabel3.setText("Categoría:");
      this.comboCategorias.setModel(this.modeloCategorias);
      this.jLabel4.setHorizontalAlignment(0);
      this.jLabel4.setText("Descripción");
      this.jLabel5.setText("Unidad:");
      this.comboUnidades.setModel(new DefaultComboBoxModel(new String[]{"No definido", "Kilogramo", "Metro", "Pieza"}));
      this.jLabel6.setText("Precio proveedor: ");
      this.jLabel7.setText("Mi precio:");
      this.campoDesc.setColumns(20);
      this.campoDesc.setRows(5);
      this.jScrollPane1.setViewportView(this.campoDesc);
      this.btnGuardarProducto.setText("Guardar");
      this.btnGuardarProducto.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            ProductFrame.this.btnGuardarProductoActionPerformed(evt);
         }
      });
      this.btnCancelar.setText("Cancelar");
      this.btnCancelar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            ProductFrame.this.btnCancelarActionPerformed(evt);
         }
      });
      this.jLabel8.setText("Proveedor:");
      this.comboProveedores.setModel(this.modeloProveedor);
      this.jLabel9.setText("Nombre:");
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jSeparator2).addComponent(this.jSeparator1, Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.lblImagenArticulo, -2, 144, -2).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel3).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.jLabel9)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.campoStock, Alignment.TRAILING).addComponent(this.campoClave, Alignment.TRAILING).addComponent(this.comboCategorias, 0, 320, 32767).addComponent(this.campoNombre))).addComponent(this.jScrollPane1).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.btnCancelar).addGap(18, 18, 18).addComponent(this.btnGuardarProducto)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel5).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.comboUnidades, -2, 234, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jLabel8).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.comboProveedores, 0, -1, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel6).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.campoPrecioCompra, -2, 198, -2).addGap(36, 36, 36).addComponent(this.jLabel7).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.campoPrecioVenta, -2, 198, -2).addGap(0, 0, 32767)).addComponent(this.jSeparator3).addComponent(this.jLabel4, Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.campoClave, -2, -1, -2).addComponent(this.jLabel1)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.campoStock, -2, -1, -2).addComponent(this.jLabel2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.comboCategorias, -2, -1, -2).addComponent(this.jLabel3)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.campoNombre, -2, -1, -2)).addGap(2, 2, 2)).addComponent(this.lblImagenArticulo, -2, 144, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jSeparator1, -2, 10, -2).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.campoPrecioCompra, -2, -1, -2).addComponent(this.jLabel7).addComponent(this.campoPrecioVenta, -2, -1, -2)).addGap(15, 15, 15).addComponent(this.jSeparator2, -2, 10, -2).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.comboProveedores, -2, -1, -2).addComponent(this.jLabel5).addComponent(this.comboUnidades, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jSeparator3, -2, 10, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel4).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.btnGuardarProducto).addComponent(this.btnCancelar)).addContainerGap(-1, 32767)));
      this.pack();
   }

   private void lblImagenArticuloMousePressed(MouseEvent evt) {
      JFileChooser chooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen jpg, gif o png", new String[]{"jpg", "gif", "png"});
      chooser.setFileFilter(filter);
      int returnVal = chooser.showOpenDialog(this);
      if (returnVal == 0) {
         int anchoImagen = this.lblImagenArticulo.getWidth();
         int altoImagen = this.lblImagenArticulo.getHeight();
         this.imgArticleFile = chooser.getSelectedFile();
         ImageIcon icono = new ImageIcon(this.imgArticleFile.getAbsolutePath());
         Image imagen = icono.getImage();
         Image imagenRedimensionada = imagen.getScaledInstance(anchoImagen, altoImagen, 1);
         ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
         this.lblImagenArticulo.setIcon(iconoRedimensionado);
      }

   }

   private void btnGuardarProductoActionPerformed(ActionEvent evt) {
      String codigo = this.campoClave.getText().toLowerCase();
      String nombre = this.campoNombre.getText().toLowerCase();
      String descripcion = this.campoDesc.getText().toLowerCase();
      double stock = Double.parseDouble(this.campoStock.getText());
      double precioCompra = Double.parseDouble(this.campoPrecioCompra.getText());
      double precioVenta = Double.parseDouble(this.campoPrecioVenta.getText());
      String unidad = this.comboUnidades.getSelectedItem().toString();
      ProductCategory categoria = (ProductCategory)this.comboCategorias.getSelectedItem();
      Vendors proveedor = (Vendors)this.comboProveedores.getSelectedItem();
      Product producto;
      if (this.estaActualizando) {
         if (this.imgArticleFile == null) {
            producto = new Product(codigo, nombre, descripcion, stock, (File)null, unidad, precioCompra, precioVenta, 0.0D, categoria.getIdCategoriaProd(), proveedor.getIdProveedor());
            this.base.actualizarProducto(producto, false);
         } else {
            producto = new Product(codigo, nombre, descripcion, stock, this.imgArticleFile, unidad, precioCompra, precioVenta, 0.0D, categoria.getIdCategoriaProd(), proveedor.getIdProveedor());
            this.base.actualizarProducto(producto, true);
         }

         JOptionPane.showMessageDialog(this, "Se ha guardado el producto");
         this.dispose();
         this.informacion = "1";
         if (this.imgArticleFile == null) {
            JOptionPane.showMessageDialog(this, "No ha elegido una fotografía de producto");
         } else {
            producto = new Product(codigo, nombre, descripcion, stock, this.imgArticleFile, unidad, precioCompra, precioVenta, 0.0D, categoria.getIdCategoriaProd(), proveedor.getIdProveedor());
            this.base.insertarProducto(producto);
            JOptionPane.showMessageDialog(this, "Se ha guardado el producto");
            this.dispose();
         }
      } else if (this.imgArticleFile == null) {
         JOptionPane.showMessageDialog(this, "No ha elegido una fotografía de producto");
      } else {
         producto = new Product(codigo, nombre, descripcion, stock, this.imgArticleFile, unidad, precioCompra, precioVenta, 0.0D, categoria.getIdCategoriaProd(), proveedor.getIdProveedor());
         this.base.insertarProducto(producto);
         JOptionPane.showMessageDialog(this, "Se ha guardado el producto");
         this.dispose();
      }

   }

   private void btnCancelarActionPerformed(ActionEvent evt) {
      this.dispose();
   }

   public String getInformacion() {
      return this.informacion;
   }

   public static void main(String[] args) {
      try {
         LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            LookAndFeelInfo info = var1[var3];
            if ("Nimbus".equals(info.getName())) {
               UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException var5) {
         Logger.getLogger(ProductFrame.class.getName()).log(Level.SEVERE, (String)null, var5);
      } catch (InstantiationException var6) {
         Logger.getLogger(ProductFrame.class.getName()).log(Level.SEVERE, (String)null, var6);
      } catch (IllegalAccessException var7) {
         Logger.getLogger(ProductFrame.class.getName()).log(Level.SEVERE, (String)null, var7);
      } catch (UnsupportedLookAndFeelException var8) {
         Logger.getLogger(ProductFrame.class.getName()).log(Level.SEVERE, (String)null, var8);
      }

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            ProductFrame dialog = new ProductFrame(new JFrame(), true, (Product)null, (ImageIcon)null, (String)null, false);
            dialog.addWindowListener(new WindowAdapter() {
               public void windowClosing(WindowEvent e) {
                  System.exit(0);
               }
            });
            dialog.setVisible(true);
         }
      });
   }
}
