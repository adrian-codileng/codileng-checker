package com.codileng.gui;

import com.codileng.database.DataBase;
import com.codileng.pojos.ProductCategory;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

public class CategoryFrame extends JDialog {
   DataBase base = new DataBase();
   private JButton btnCancelar;
   private JButton btnGuardar;
   private JTextArea campoDesc;
   private JTextField campoNombre;
   private JLabel jLabel2;
   private JLabel jLabel3;
   private JScrollPane jScrollPane1;

   public CategoryFrame(Frame parent, boolean modal) {
      super(parent, modal);
      this.initComponents();
   }

   private void initComponents() {
      this.jLabel2 = new JLabel();
      this.campoNombre = new JTextField();
      this.jLabel3 = new JLabel();
      this.jScrollPane1 = new JScrollPane();
      this.campoDesc = new JTextArea();
      this.btnGuardar = new JButton();
      this.btnCancelar = new JButton();
      this.setDefaultCloseOperation(2);
      this.setTitle("Nueva categoría");
      this.jLabel2.setText("Nombre:");
      this.campoNombre.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            CategoryFrame.this.campoNombreActionPerformed(evt);
         }
      });
      this.jLabel3.setHorizontalAlignment(0);
      this.jLabel3.setText("Descripción:");
      this.campoDesc.setColumns(20);
      this.campoDesc.setRows(5);
      this.jScrollPane1.setViewportView(this.campoDesc);
      this.btnGuardar.setText("Cancelar");
      this.btnGuardar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            CategoryFrame.this.btnGuardarActionPerformed(evt);
         }
      });
      this.btnCancelar.setText("Guardar");
      this.btnCancelar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            CategoryFrame.this.btnCancelarActionPerformed(evt);
         }
      });
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel3, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jLabel2).addGap(32, 32, 32).addComponent(this.campoNombre)).addComponent(this.jScrollPane1).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.btnGuardar, -2, 200, -2).addGap(202, 202, 202).addComponent(this.btnCancelar, -2, 200, -2))).addContainerGap()));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.campoNombre, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jLabel3).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -2, -1, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.btnCancelar).addComponent(this.btnGuardar)).addContainerGap(-1, 32767)));
      this.pack();
   }

   private void campoNombreActionPerformed(ActionEvent evt) {
   }

   private void btnCancelarActionPerformed(ActionEvent evt) {
      String nombre = this.campoNombre.getText();
      String descripcion = this.campoDesc.getText();
      ProductCategory categoria = new ProductCategory(0, nombre, descripcion);
      this.base.insertarCategoriaProducto(categoria);
      JOptionPane.showMessageDialog(this, "Se realizó correctamente la inserción de categoria");
      this.dispose();
   }

   private void btnGuardarActionPerformed(ActionEvent evt) {
      this.dispose();
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
         Logger.getLogger(CategoryFrame.class.getName()).log(Level.SEVERE, (String)null, var5);
      } catch (InstantiationException var6) {
         Logger.getLogger(CategoryFrame.class.getName()).log(Level.SEVERE, (String)null, var6);
      } catch (IllegalAccessException var7) {
         Logger.getLogger(CategoryFrame.class.getName()).log(Level.SEVERE, (String)null, var7);
      } catch (UnsupportedLookAndFeelException var8) {
         Logger.getLogger(CategoryFrame.class.getName()).log(Level.SEVERE, (String)null, var8);
      }

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            CategoryFrame dialog = new CategoryFrame(new JFrame(), true);
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
