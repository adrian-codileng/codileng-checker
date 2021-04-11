package com.codileng.gui;

import com.codileng.database.DataBase;
import com.codileng.pojos.Vendors;
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

public class VendorsFrame extends JDialog {
   DataBase base = new DataBase();
   private JButton btnCancelar;
   private JButton btnGuardar;
   private JTextField campoClave;
   private JTextField campoContacto;
   private JTextArea campoDireccion;
   private JTextField campoEmail;
   private JTextField campoNombre;
   private JTextField campoTelefono;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JLabel jLabel3;
   private JLabel jLabel4;
   private JLabel jLabel5;
   private JLabel jLabel6;
   private JScrollPane jScrollPane1;

   public VendorsFrame(Frame parent, boolean modal) {
      super(parent, modal);
      this.initComponents();
   }

   private void initComponents() {
      this.jLabel1 = new JLabel();
      this.campoClave = new JTextField();
      this.jLabel2 = new JLabel();
      this.campoNombre = new JTextField();
      this.jLabel3 = new JLabel();
      this.campoTelefono = new JTextField();
      this.jLabel4 = new JLabel();
      this.campoEmail = new JTextField();
      this.jLabel5 = new JLabel();
      this.campoContacto = new JTextField();
      this.jLabel6 = new JLabel();
      this.jScrollPane1 = new JScrollPane();
      this.campoDireccion = new JTextArea();
      this.btnCancelar = new JButton();
      this.btnGuardar = new JButton();
      this.setDefaultCloseOperation(2);
      this.setTitle("Nuevo proveedor");
      this.jLabel1.setText("Clave:");
      this.jLabel2.setText("Empresa:");
      this.jLabel3.setText("Teléfono:");
      this.jLabel4.setText("Email:");
      this.jLabel5.setText("Nombre:");
      this.jLabel6.setHorizontalAlignment(0);
      this.jLabel6.setText("Dirección:");
      this.campoDireccion.setColumns(20);
      this.campoDireccion.setRows(5);
      this.jScrollPane1.setViewportView(this.campoDireccion);
      this.btnCancelar.setText("Cancelar");
      this.btnCancelar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            VendorsFrame.this.btnCancelarActionPerformed(evt);
         }
      });
      this.btnGuardar.setText("Guardar");
      this.btnGuardar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            VendorsFrame.this.btnGuardarActionPerformed(evt);
         }
      });
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel6, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel1)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.campoClave).addComponent(this.campoNombre))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel3).addComponent(this.jLabel4)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.campoTelefono).addComponent(this.campoEmail))).addGroup(layout.createSequentialGroup().addComponent(this.jLabel5).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.campoContacto)).addComponent(this.jScrollPane1).addGroup(layout.createSequentialGroup().addComponent(this.btnCancelar, -2, 165, -2).addPreferredGap(ComponentPlacement.RELATED, 46, 32767).addComponent(this.btnGuardar, -2, 165, -2))).addContainerGap()));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.campoClave, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.campoNombre, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.campoTelefono, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.campoEmail, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.campoContacto, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jLabel6).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -2, -1, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.btnCancelar).addComponent(this.btnGuardar)).addContainerGap(-1, 32767)));
      this.pack();
   }

   private void btnGuardarActionPerformed(ActionEvent evt) {
      int clave = Integer.parseInt(this.campoClave.getText());
      String nombre = this.campoNombre.getText();
      String direccion = this.campoDireccion.getText();
      String telefono = this.campoTelefono.getText();
      String email = this.campoEmail.getText();
      String contacto = this.campoContacto.getText();
      Vendors proveedor = new Vendors(clave, nombre, direccion, telefono, email, contacto);
      this.base.insertarProveedor(proveedor);
      JOptionPane.showMessageDialog(this, "El proveedor se guardó correctamente");
      this.dispose();
   }

   private void btnCancelarActionPerformed(ActionEvent evt) {
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
         Logger.getLogger(VendorsFrame.class.getName()).log(Level.SEVERE, (String)null, var5);
      } catch (InstantiationException var6) {
         Logger.getLogger(VendorsFrame.class.getName()).log(Level.SEVERE, (String)null, var6);
      } catch (IllegalAccessException var7) {
         Logger.getLogger(VendorsFrame.class.getName()).log(Level.SEVERE, (String)null, var7);
      } catch (UnsupportedLookAndFeelException var8) {
         Logger.getLogger(VendorsFrame.class.getName()).log(Level.SEVERE, (String)null, var8);
      }

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            VendorsFrame dialog = new VendorsFrame(new JFrame(), true);
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
