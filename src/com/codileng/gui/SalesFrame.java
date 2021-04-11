package com.codileng.gui;

import com.codileng.database.DataBase;
import com.codileng.pojos.Product;
import com.codileng.pojos.Sale;
import com.codileng.pojos.SaleDetail;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class SalesFrame extends JInternalFrame {
   DefaultTableModel modeloTablaProductos = new DefaultTableModel() {
      public boolean isCellEditable(int row, int column) {
         return false;
      }
   };
   DefaultListModel<Product> modeloListaProductos = new DefaultListModel();
   DataBase base = new DataBase();
   private JButton btnCancelarVenta;
   private JButton btnQuitarProd;
   private JButton btnRealizarVenta;
   private JTextField campoBuscarProd;
   private JTextField campoPagaCon;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JLabel jLabel4;
   private JPanel jPanel1;
   private JPanel jPanel2;
   private JScrollPane jScrollPane1;
   private JScrollPane jScrollPane2;
   private JLabel lblImagenProd;
   private JLabel lblSumatoria;
   private JList<Product> listaBusquedas;
   private JTable tablaVentas;

   public SalesFrame() {
      this.initComponents();
      this.cargarColumnasTabla();
      this.cargarListenerModeloTabla();
   }

   private void cargarListenerModeloTabla() {
      this.modeloTablaProductos.addTableModelListener(new TableModelListener() {
         public void tableChanged(TableModelEvent e) {
            int numFilas = SalesFrame.this.modeloTablaProductos.getRowCount();
            double sumatoria = 0.0D;

            for(int i = 0; i < numFilas; ++i) {
               String importe = (String)SalesFrame.this.modeloTablaProductos.getValueAt(i, 4);
               sumatoria += Double.parseDouble(importe);
            }

            SalesFrame.this.lblSumatoria.setText(String.valueOf(sumatoria));
         }
      });
   }

   private void cargarColumnasTabla() {
      this.modeloTablaProductos.addColumn("Clave");
      this.modeloTablaProductos.addColumn("Nombre");
      this.modeloTablaProductos.addColumn("Precio Venta");
      this.modeloTablaProductos.addColumn("Cantidad");
      this.modeloTablaProductos.addColumn("Importe");
   }

   private void initComponents() {
      this.jLabel1 = new JLabel();
      this.campoBuscarProd = new JTextField();
      this.jScrollPane1 = new JScrollPane();
      this.tablaVentas = new JTable();
      this.jPanel1 = new JPanel();
      this.jLabel2 = new JLabel();
      this.lblSumatoria = new JLabel();
      this.btnRealizarVenta = new JButton();
      this.jLabel4 = new JLabel();
      this.campoPagaCon = new JTextField();
      this.jPanel2 = new JPanel();
      this.lblImagenProd = new JLabel();
      this.jScrollPane2 = new JScrollPane();
      this.listaBusquedas = new JList();
      this.btnQuitarProd = new JButton();
      this.btnCancelarVenta = new JButton();
      this.setTitle("Ventas");
      this.jLabel1.setHorizontalAlignment(0);
      this.jLabel1.setText("Buscar:");
      this.campoBuscarProd.setHorizontalAlignment(0);
      this.campoBuscarProd.addKeyListener(new KeyAdapter() {
         public void keyReleased(KeyEvent evt) {
            SalesFrame.this.campoBuscarProdKeyReleased(evt);
         }
      });
      this.tablaVentas.setModel(this.modeloTablaProductos);
      this.tablaVentas.addKeyListener(new KeyAdapter() {
         public void keyReleased(KeyEvent evt) {
            SalesFrame.this.tablaVentasKeyReleased(evt);
         }
      });
      this.jScrollPane1.setViewportView(this.tablaVentas);
      this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
      this.jLabel2.setHorizontalAlignment(0);
      this.jLabel2.setText("TOTAL:");
      this.lblSumatoria.setFont(new Font("Dialog", 1, 36));
      this.lblSumatoria.setHorizontalAlignment(0);
      this.lblSumatoria.setText("0.00");
      GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
      this.jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel2, -1, -1, 32767).addComponent(this.lblSumatoria, -1, 368, 32767)).addContainerGap()));
      jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.lblSumatoria, -1, -1, 32767).addContainerGap()));
      this.btnRealizarVenta.setBackground(new Color(0, 204, 0));
      this.btnRealizarVenta.setFont(new Font("Dialog", 1, 24));
      this.btnRealizarVenta.setForeground(new Color(255, 255, 255));
      this.btnRealizarVenta.setText("COBRAR");
      this.btnRealizarVenta.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            SalesFrame.this.btnRealizarVentaActionPerformed(evt);
         }
      });
      this.jLabel4.setHorizontalAlignment(0);
      this.jLabel4.setText("Recibido:");
      this.jPanel2.setBackground(new Color(102, 102, 102));
      this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
      this.lblImagenProd.setHorizontalAlignment(0);
      GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
      this.jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.lblImagenProd, -2, 122, -2).addContainerGap()));
      jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.lblImagenProd, -2, 122, -2).addContainerGap()));
      this.listaBusquedas.setModel(this.modeloListaProductos);
      this.listaBusquedas.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent evt) {
            SalesFrame.this.listaBusquedasMousePressed(evt);
         }
      });
      this.jScrollPane2.setViewportView(this.listaBusquedas);
      this.btnQuitarProd.setIcon(new ImageIcon(this.getClass().getResource("/com/codileng/images/quitar.png")));
      this.btnQuitarProd.setToolTipText("Remover producto");
      this.btnQuitarProd.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            SalesFrame.this.btnQuitarProdActionPerformed(evt);
         }
      });
      this.btnCancelarVenta.setIcon(new ImageIcon(this.getClass().getResource("/com/codileng/images/eliminar.png")));
      this.btnCancelarVenta.setToolTipText("Cancelar venta");
      this.btnCancelarVenta.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            SalesFrame.this.btnCancelarVentaActionPerformed(evt);
         }
      });
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.campoPagaCon).addComponent(this.jLabel4, Alignment.LEADING, -1, -1, 32767).addGroup(Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.campoBuscarProd, Alignment.LEADING).addComponent(this.jLabel1, -1, -1, 32767).addComponent(this.jScrollPane2, Alignment.LEADING, -1, 334, 32767)).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2)).addGroup(Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.btnQuitarProd, -2, 55, -2).addComponent(this.btnCancelarVenta, -2, 55, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1)).addComponent(this.btnRealizarVenta, Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING, false).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.campoBuscarProd, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 98, -2)).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.jScrollPane1, -2, 0, 32767).addGroup(layout.createSequentialGroup().addComponent(this.btnQuitarProd, -2, 55, -2).addPreferredGap(ComponentPlacement.RELATED, 11, 32767).addComponent(this.btnCancelarVenta, -2, 55, -2))).addGap(18, 18, 18).addComponent(this.jLabel4).addGap(18, 18, 18).addComponent(this.campoPagaCon, -2, -1, -2).addGap(18, 18, 18).addComponent(this.btnRealizarVenta, -2, 55, -2).addContainerGap(-1, 32767)));
      this.pack();
   }

   private void btnQuitarProdActionPerformed(ActionEvent evt) {
      int filaSeleccionada = this.tablaVentas.getSelectedRow();
      int cantidadFilas = this.modeloTablaProductos.getRowCount();
      if (cantidadFilas > 0) {
         int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de borrar el producto?");
         if (opcion == 0) {
            this.modeloTablaProductos.removeRow(filaSeleccionada);
         }
      }

   }

   private void campoBuscarProdKeyReleased(KeyEvent evt) {
      this.limpiarListaProductos();
      String cadenaBusqueda = this.campoBuscarProd.getText();
      if (cadenaBusqueda.isEmpty()) {
         this.limpiarListaProductos();
      } else {
         ArrayList<Product> listaProductos = this.base.obtenerProductosPorCriterio(cadenaBusqueda);
         Iterator var4 = listaProductos.iterator();

         while(var4.hasNext()) {
            Product prod = (Product)var4.next();
            this.modeloListaProductos.addElement(prod);
         }
      }

   }

   private void listaBusquedasMousePressed(MouseEvent evt) {
      JList list = (JList)evt.getSource();
      if (evt.getClickCount() == 2) {
         list.locationToIndex(evt.getPoint());
         Product prod = (Product)list.getSelectedValue();
         this.anadirProductoAVenta(prod);
         this.desplegarFoto(prod);
      }

   }

   private void tablaVentasKeyReleased(KeyEvent evt) {
      if (evt.getKeyCode() == 113) {
         int filaSeleccionada = this.tablaVentas.getSelectedRow();
         String cantidad = JOptionPane.showInputDialog("Modificar cantidad:");
         String precioVenta = (String)this.modeloTablaProductos.getValueAt(filaSeleccionada, 2);
         double importe = Double.parseDouble(cantidad) * Double.parseDouble(precioVenta);
         String importeString = String.valueOf(importe);
         this.modeloTablaProductos.setValueAt(cantidad, filaSeleccionada, 3);
         this.modeloTablaProductos.setValueAt(importeString, filaSeleccionada, 4);
      }

   }

   private void btnCancelarVentaActionPerformed(ActionEvent evt) {
      int cantidadFilas = this.modeloTablaProductos.getRowCount();
      if (cantidadFilas > 0) {
         int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de cancelar la venta?");
         if (opcion == 0) {
            for(int i = cantidadFilas - 1; i >= 0; --i) {
               this.modeloTablaProductos.removeRow(i);
            }
         }
      }

   }

   private void btnRealizarVentaActionPerformed(ActionEvent evt) {
      ArrayList<SaleDetail> detalles = new ArrayList();
      String sumatoriaStr = this.lblSumatoria.getText();
      double montoVenta = Double.parseDouble(sumatoriaStr);
      String pagoConStr = this.campoPagaCon.getText();
      double cambio = 0.0D;
      if (!pagoConStr.isEmpty()) {
         double montoPago = Double.parseDouble(pagoConStr);
         cambio = montoPago - montoVenta;
      }

      Calendar calendarioLocal = Calendar.getInstance();
      Date fechaActual = calendarioLocal.getTime();
      long fechaMilisegundos = fechaActual.getTime();
      java.sql.Date fecha = new java.sql.Date(fechaMilisegundos);
      Sale venta = new Sale(montoVenta, fecha);
      Long idVenta = this.base.insertarVenta(venta);
      int numRows = this.modeloTablaProductos.getRowCount();

      int i;
      for(i = 0; i < numRows; ++i) {
         String idProducto = (String)this.modeloTablaProductos.getValueAt(i, 0);
         String cantidadStr = (String)this.modeloTablaProductos.getValueAt(i, 3);
         double cantidad = Double.parseDouble(cantidadStr);
         SaleDetail detalle = new SaleDetail(idVenta, idProducto, cantidad);
         this.base.insertarDetalleVenta(detalle);
         detalles.add(detalle);
      }

      for(i = numRows - 1; i >= 0; --i) {
         this.modeloTablaProductos.removeRow(i);
      }

      this.lblSumatoria.setText("0.0");
      if (!pagoConStr.isEmpty()) {
         JOptionPane.showMessageDialog(this, "<html><h4 style='font-size:30px; color:orange'>" + cambio + "</h4></html>", "Debes dar este cambio:", 1);
         this.campoPagaCon.setText("");
      }

   }

   private void desplegarFoto(Product prod) {
      ImageIcon imagenProducto = null;

      try {
         InputStream is = this.base.buscarFoto(prod);
         BufferedImage bi = ImageIO.read(is);
         imagenProducto = new ImageIcon(bi);
         Image imgProd = imagenProducto.getImage();
         int anchoEtiqueta = this.lblImagenProd.getWidth();
         int altoEtiqueta = this.lblImagenProd.getHeight();
         Image imgRedimensionada = imgProd.getScaledInstance(anchoEtiqueta, altoEtiqueta, 1);
         ImageIcon iconRedimensionado = new ImageIcon(imgRedimensionada);
         this.lblImagenProd.setIcon(iconRedimensionado);
      } catch (IOException var10) {
         var10.printStackTrace();
      }

   }

   private void anadirProductoAVenta(Product prod) {
      String claveProd = prod.getIdProducto();
      String nombreProd = prod.getNomProducto();
      String precioVenta = String.valueOf(prod.getPrecioVentaProducto());
      String importe = String.valueOf(prod.getPrecioVentaProducto());
      String[] datosProducto = new String[]{claveProd, nombreProd, precioVenta, "1", importe};
      this.modeloTablaProductos.addRow(datosProducto);
   }

   private void limpiarListaProductos() {
      this.modeloListaProductos.clear();
   }
}
