package com.codileng.gui;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

public class Main extends JFrame {
   SalesFrame ventas;
   InventoryFrame inventario;
   private JButton btnExit;
   private JToggleButton btnInventarios;
   private JToggleButton btnVentas;
   private JDesktopPane contenedorModulos;
   private JPanel jPanel1;
   private JLabel lblLogo;
   private ButtonGroup modulesGroup;

   public Main() {
      this.initComponents();
      this.setLocationRelativeTo((Component)null);
      this.setIconImage((new ImageIcon(this.getClass().getResource("/com/codileng/images/icono.png"))).getImage());
      ImageIcon imagenLogo = new ImageIcon("images/logo.png");
      Icon iconoLogo = new ImageIcon(imagenLogo.getImage().getScaledInstance(this.lblLogo.getWidth(), this.lblLogo.getHeight(), 1));
      this.lblLogo.setIcon(iconoLogo);
      this.repaint();
   }

   private void initComponents() {
      this.modulesGroup = new ButtonGroup();
      this.contenedorModulos = new JDesktopPane();
      this.lblLogo = new JLabel();
      this.jPanel1 = new JPanel();
      this.btnInventarios = new JToggleButton();
      this.btnVentas = new JToggleButton();
      this.btnExit = new JButton();
      this.setDefaultCloseOperation(3);
      this.setTitle("Códileng Checker");
      GroupLayout contenedorModulosLayout = new GroupLayout(this.contenedorModulos);
      this.contenedorModulos.setLayout(contenedorModulosLayout);
      contenedorModulosLayout.setHorizontalGroup(contenedorModulosLayout.createParallelGroup(Alignment.LEADING).addGap(0, 0, 32767));
      contenedorModulosLayout.setVerticalGroup(contenedorModulosLayout.createParallelGroup(Alignment.LEADING).addGap(0, 561, 32767));
      this.modulesGroup.add(this.btnInventarios);
      this.btnInventarios.setToolTipText("Inventario");
      this.btnInventarios.setCursor(new Cursor(0));
      this.btnInventarios.setPreferredSize(new Dimension(81, 81));
      ImageIcon iconBtnInventory = new ImageIcon("images/inventory.png");
      Image imgBtnInventory = iconBtnInventory.getImage();
      Dimension prefSizeBtnInventory = this.btnInventarios.getPreferredSize();
      int anchoBtnInventory = (int)(prefSizeBtnInventory.getWidth() * 0.6D);
      int altoBtnInventory = (int)(prefSizeBtnInventory.getHeight() * 0.6D);
      Image imgRedimBtnInventory = imgBtnInventory.getScaledInstance(anchoBtnInventory, altoBtnInventory, 1);
      ImageIcon iconRedimBtnInventory = new ImageIcon(imgRedimBtnInventory);
      this.btnInventarios.setIcon(iconRedimBtnInventory);
      this.btnInventarios.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Main.this.btnInventariosActionPerformed(evt);
         }
      });
      this.modulesGroup.add(this.btnVentas);
      this.btnVentas.setToolTipText("Ventas");
      this.btnVentas.setPreferredSize(new Dimension(81, 81));
      ImageIcon iconBtnVentas = new ImageIcon("images/sales.png");
      Image imgBtnVentas = iconBtnVentas.getImage();
      Dimension prefSizeBtnVentas = this.btnVentas.getPreferredSize();
      int anchoBtnVentas = (int)(prefSizeBtnVentas.getWidth() * 0.6D);
      int altoBtnVentas = (int)(prefSizeBtnVentas.getHeight() * 0.6D);
      Image imgRedimBtnVentas = imgBtnVentas.getScaledInstance(anchoBtnVentas, altoBtnVentas, 1);
      ImageIcon iconRedimBtnVentas = new ImageIcon(imgRedimBtnVentas);
      this.btnVentas.setIcon(iconRedimBtnVentas);
      this.btnVentas.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Main.this.btnVentasActionPerformed(evt);
         }
      });
      this.btnExit.setIcon(new ImageIcon(this.getClass().getResource("/com/codileng/images/salir.png")));
      this.btnExit.setToolTipText("Salir");
      this.btnExit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Main.this.btnExitActionPerformed(evt);
         }
      });
      GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
      this.jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.btnInventarios, -2, 80, -2).addGap(18, 18, 18).addComponent(this.btnVentas, -2, 82, -2).addGap(18, 18, 18).addComponent(this.btnExit, -2, 80, -2).addContainerGap(-1, 32767)));
      jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING).addComponent(this.btnExit, -2, 80, -2).addComponent(this.btnInventarios, -1, -1, 32767).addComponent(this.btnVentas, -2, -1, -2)).addContainerGap(-1, 32767)));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.contenedorModulos).addGroup(layout.createSequentialGroup().addComponent(this.lblLogo, -2, 390, -2).addPreferredGap(ComponentPlacement.RELATED, 280, 32767).addComponent(this.jPanel1, -2, -1, -2))).addContainerGap()));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addComponent(this.lblLogo, -2, 99, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.contenedorModulos).addContainerGap()));
      this.pack();
   }

   private void btnVentasActionPerformed(ActionEvent evt) {
      if (this.ventas == null) {
         this.ventas = new SalesFrame();
         this.contenedorModulos.add(this.ventas);
         this.contenedorModulos.getDesktopManager().maximizeFrame(this.ventas);
         this.ventas.setVisible(true);
      } else {
         this.contenedorModulos.getDesktopManager().maximizeFrame(this.ventas);
      }

   }

   private void btnInventariosActionPerformed(ActionEvent evt) {
      if (this.inventario == null) {
         this.inventario = new InventoryFrame();
         this.contenedorModulos.add(this.inventario);
         this.contenedorModulos.getDesktopManager().maximizeFrame(this.inventario);
         this.inventario.setVisible(true);
      } else {
         this.contenedorModulos.getDesktopManager().maximizeFrame(this.inventario);
      }

   }

   private void btnExitActionPerformed(ActionEvent evt) {
      System.exit(0);
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
         Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, var5);
      } catch (InstantiationException var6) {
         Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, var6);
      } catch (IllegalAccessException var7) {
         Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, var7);
      } catch (UnsupportedLookAndFeelException var8) {
         Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, var8);
      }

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            (new Main()).setVisible(true);
         }
      });
   }
}
