/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import Animacion.Fade;
import java.awt.Image;
import javax.swing.ImageIcon;
import AppPackage.AnimationClass;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;
import java.util.Scanner;
/**
 *
 * @author steve
 */
public class VentanaPrincipal2 extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal2
     */
    public VentanaPrincipal2() {
//        try {
//                     UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//		}
//		catch (Exception e) {
//		}
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/images/logo2.png")).getImage( ));
        PanelPrincipal.setVisible(false);
        setLocationRelativeTo(null);
        
        Fade.JFrameFadeIn(0f, 1f, 0.1f,100,this );
        ImageIcon foto = new ImageIcon (getClass().getResource("/images/logo2.png"));
       ImageIcon icono = new ImageIcon(foto.getImage().getScaledInstance(jLabel2.getWidth(),jLabel2.getHeight(),Image.SCALE_DEFAULT));
       jLabel2.setIcon(icono);
       
       ImageIcon foto6 = new ImageIcon (getClass().getResource("/images/Proveedores.png"));
       ImageIcon icono6 = new ImageIcon(foto6.getImage().getScaledInstance(Proveedores.getWidth(),Proveedores.getHeight(),Image.SCALE_DEFAULT));
       Proveedores.setIcon(icono6);
       
       ImageIcon foto3 = new ImageIcon (getClass().getResource("/images/ChatCenter.png"));
       ImageIcon icono3 = new ImageIcon(foto3.getImage().getScaledInstance(ChatCenter.getWidth(),ChatCenter.getHeight(),Image.SCALE_DEFAULT));
       ChatCenter.setIcon(icono3);
       
        ImageIcon foto4 = new ImageIcon (getClass().getResource("/images/Empleados.png"));
       ImageIcon icono4 = new ImageIcon(foto4.getImage().getScaledInstance(Empleados.getWidth(),Empleados.getHeight(),Image.SCALE_DEFAULT));
       Empleados.setIcon(icono4);
       
        ImageIcon foto5 = new ImageIcon (getClass().getResource("/images/Empresa.png"));
       ImageIcon icono5 = new ImageIcon(foto5.getImage().getScaledInstance(Empresa.getWidth(),Empresa.getHeight(),Image.SCALE_DEFAULT));
       Empresa.setIcon(icono5);
       
       ImageIcon foto7 = new ImageIcon (getClass().getResource("/images/CajaRegistradora.png"));
       ImageIcon icono7 = new ImageIcon(foto7.getImage().getScaledInstance(CajaRegistradora.getWidth(),CajaRegistradora.getHeight(),Image.SCALE_DEFAULT));
       CajaRegistradora.setIcon(icono7);
       
        ImageIcon foto8 = new ImageIcon (getClass().getResource("/images/Inventario.png"));
       ImageIcon icono8 = new ImageIcon(foto8.getImage().getScaledInstance(Inventario.getWidth(),Inventario.getHeight(),Image.SCALE_DEFAULT));
       Inventario.setIcon(icono8);
       
       ImageIcon foto9 = new ImageIcon (getClass().getResource("/images/Productos.png"));
       ImageIcon icono9 = new ImageIcon(foto9.getImage().getScaledInstance(Productos.getWidth(),Productos.getHeight(),Image.SCALE_DEFAULT));
       Productos.setIcon(icono9);
       
        ImageIcon foto10 = new ImageIcon (getClass().getResource("/images/Tipo-Usuario.png"));
       ImageIcon icono10 = new ImageIcon(foto10.getImage().getScaledInstance(TipoUsuario1.getWidth(),TipoUsuario1.getHeight(),Image.SCALE_DEFAULT));
       TipoUsuario1.setIcon(icono10);
       
       ImageIcon foto11= new ImageIcon (getClass().getResource("/images/ConstruirPC.png"));
       ImageIcon icono11 = new ImageIcon(foto11.getImage().getScaledInstance(ConstruirEquipo.getWidth(),ConstruirEquipo.getHeight(),Image.SCALE_DEFAULT));
       ConstruirEquipo.setIcon(icono11);
       
        ImageIcon foto12 = new ImageIcon (getClass().getResource("/images/Bitacoras.png"));
       ImageIcon icono12 = new ImageIcon(foto12.getImage().getScaledInstance(Bitacoras.getWidth(),Bitacoras.getHeight(),Image.SCALE_DEFAULT));
       Bitacoras.setIcon(icono12);
       
       ImageIcon foto13 = new ImageIcon (getClass().getResource("/images/Clientes.png"));
       ImageIcon icono13 = new ImageIcon(foto13.getImage().getScaledInstance(Clientes.getWidth(),Clientes.getHeight(),Image.SCALE_DEFAULT));
       Clientes.setIcon(icono13);
       
       ImageIcon foto14 = new ImageIcon (getClass().getResource("/images/Presupuesto.png"));
       ImageIcon icono14 = new ImageIcon(foto14.getImage().getScaledInstance(Presupuesto.getWidth(),Presupuesto.getHeight(),Image.SCALE_DEFAULT));
       Presupuesto.setIcon(icono14);
       
       ImageIcon foto15 = new ImageIcon (getClass().getResource("/images/Ventas.png"));
       ImageIcon icono15 = new ImageIcon(foto15.getImage().getScaledInstance(Ventas.getWidth(),Ventas.getHeight(),Image.SCALE_DEFAULT));
       Ventas.setIcon(icono15);
       
       ImageIcon foto16 = new ImageIcon (getClass().getResource("/images/OrdenesCola.png"));
       ImageIcon icono16 = new ImageIcon(foto16.getImage().getScaledInstance(Ordenes.getWidth(),Ordenes.getHeight(),Image.SCALE_DEFAULT));
       Ordenes.setIcon(icono16);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        ChatCenter = new javax.swing.JLabel();
        fecha1 = new javax.swing.JLabel();
        fecha2 = new javax.swing.JLabel();
        fecha3 = new javax.swing.JLabel();
        jblnombre = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Proveedores = new javax.swing.JLabel();
        apellido2 = new javax.swing.JLabel();
        Empleados = new javax.swing.JLabel();
        Empresa = new javax.swing.JLabel();
        CajaRegistradora = new javax.swing.JLabel();
        Inventario = new javax.swing.JLabel();
        Productos = new javax.swing.JLabel();
        TipoUsuario1 = new javax.swing.JLabel();
        ConstruirEquipo = new javax.swing.JLabel();
        Bitacoras = new javax.swing.JLabel();
        Clientes = new javax.swing.JLabel();
        Presupuesto = new javax.swing.JLabel();
        Ventas = new javax.swing.JLabel();
        Ordenes = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        PanelPrincipal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 5, true));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ChatCenter.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        ChatCenter.setForeground(new java.awt.Color(204, 204, 204));
        ChatCenter.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ChatCenterMouseMoved(evt);
            }
        });
        ChatCenter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChatCenterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ChatCenterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ChatCenterMouseExited(evt);
            }
        });
        jPanel2.add(ChatCenter, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 55, 70, 70));

        fecha1.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        fecha1.setForeground(new java.awt.Color(204, 204, 204));
        fecha1.setText("VIERNES");
        jPanel2.add(fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        fecha2.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        fecha2.setForeground(new java.awt.Color(204, 204, 204));
        fecha2.setText("23 JUNIO");
        jPanel2.add(fecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        fecha3.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        fecha3.setForeground(new java.awt.Color(204, 204, 204));
        fecha3.setText("2018");
        jPanel2.add(fecha3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, -1, -1));

        jblnombre.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jblnombre.setForeground(new java.awt.Color(204, 204, 204));
        jblnombre.setText("Steven");
        jPanel2.add(jblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        hora.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        hora.setForeground(new java.awt.Color(204, 204, 204));
        hora.setText("18:35pm");
        jPanel2.add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MenuGris.png"))); // NOI18N
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel1MouseMoved(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 32));

        Proveedores.setText("jLabel7");
        Proveedores.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ProveedoresMouseMoved(evt);
            }
        });
        Proveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProveedoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProveedoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProveedoresMouseExited(evt);
            }
        });
        jPanel2.add(Proveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 55, 70, 70));

        apellido2.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        apellido2.setForeground(new java.awt.Color(204, 204, 204));
        apellido2.setText("Diaz");
        jPanel2.add(apellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        Empleados.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        Empleados.setForeground(new java.awt.Color(204, 204, 204));
        Empleados.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                EmpleadosMouseMoved(evt);
            }
        });
        Empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmpleadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EmpleadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EmpleadosMouseExited(evt);
            }
        });
        jPanel2.add(Empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 135, 70, 70));

        Empresa.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                EmpresaMouseMoved(evt);
            }
        });
        Empresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmpresaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EmpresaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EmpresaMouseExited(evt);
            }
        });
        jPanel2.add(Empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 135, 70, 70));

        CajaRegistradora.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CajaRegistradoraMouseMoved(evt);
            }
        });
        CajaRegistradora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CajaRegistradoraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CajaRegistradoraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CajaRegistradoraMouseExited(evt);
            }
        });
        jPanel2.add(CajaRegistradora, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 215, 70, 70));

        Inventario.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        Inventario.setForeground(new java.awt.Color(204, 204, 204));
        Inventario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                InventarioMouseMoved(evt);
            }
        });
        Inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InventarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InventarioMouseExited(evt);
            }
        });
        jPanel2.add(Inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 215, 70, 70));

        Productos.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        Productos.setForeground(new java.awt.Color(204, 204, 204));
        Productos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ProductosMouseMoved(evt);
            }
        });
        Productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProductosMouseExited(evt);
            }
        });
        jPanel2.add(Productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 295, 70, 70));

        TipoUsuario1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TipoUsuario1MouseMoved(evt);
            }
        });
        TipoUsuario1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TipoUsuario1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TipoUsuario1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TipoUsuario1MouseExited(evt);
            }
        });
        jPanel2.add(TipoUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 295, 70, 70));

        ConstruirEquipo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ConstruirEquipoMouseMoved(evt);
            }
        });
        ConstruirEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConstruirEquipoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ConstruirEquipoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ConstruirEquipoMouseExited(evt);
            }
        });
        jPanel2.add(ConstruirEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 375, 70, 70));

        Bitacoras.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        Bitacoras.setForeground(new java.awt.Color(204, 204, 204));
        Bitacoras.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BitacorasMouseMoved(evt);
            }
        });
        Bitacoras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BitacorasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BitacorasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BitacorasMouseExited(evt);
            }
        });
        jPanel2.add(Bitacoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 375, 70, 70));

        Clientes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ClientesMouseMoved(evt);
            }
        });
        Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ClientesMouseExited(evt);
            }
        });
        jPanel2.add(Clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 455, 70, 70));

        Presupuesto.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        Presupuesto.setForeground(new java.awt.Color(204, 204, 204));
        Presupuesto.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PresupuestoMouseMoved(evt);
            }
        });
        Presupuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PresupuestoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PresupuestoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PresupuestoMouseExited(evt);
            }
        });
        jPanel2.add(Presupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 455, 70, 70));

        Ventas.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        Ventas.setForeground(new java.awt.Color(204, 204, 204));
        Ventas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                VentasMouseMoved(evt);
            }
        });
        Ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VentasMouseExited(evt);
            }
        });
        jPanel2.add(Ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 535, 70, 70));

        Ordenes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                OrdenesMouseMoved(evt);
            }
        });
        Ordenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrdenesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OrdenesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OrdenesMouseExited(evt);
            }
        });
        jPanel2.add(Ordenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 535, 70, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 610));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 5, true));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 60)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("INNOVASYS");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        jLabel5.setToolTipText("");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 600, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(0, 66, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 680, 110));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelPrincipal.setPreferredSize(new java.awt.Dimension(680, 500));

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jPanel3.add(PanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 5, true));
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 500));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 680, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        //1
        AnimationClass nombre = new AnimationClass();
        nombre.jLabelXLeft(40, -120,15, 5, jblnombre);
        
        AnimationClass nombre2 = new AnimationClass();
        nombre2.jLabelXRight(-120, 40,15, 5, jblnombre);
        
        AnimationClass apellido = new AnimationClass();
        apellido.jLabelXLeft(40, -120,10, 5, apellido2);
        
        AnimationClass apellidoo = new AnimationClass();
        apellidoo.jLabelXRight(-120, 40,10, 5, apellido2);
        
        AnimationClass hora1 = new AnimationClass();
        hora1.jLabelXLeft(30, -150,10, 5, hora);
        
        AnimationClass horaa = new AnimationClass();
        horaa.jLabelXRight(-150, 30,10, 5, hora);
        
        AnimationClass fecha11 = new AnimationClass();
        fecha11.jLabelXLeft(30, -140,10, 5, fecha1);
        
        AnimationClass fecha111 = new AnimationClass();
        fecha111.jLabelXRight(-140, 30,10, 5, fecha1);
        
        AnimationClass fecha22 = new AnimationClass();
        fecha22.jLabelXLeft(20, -160,10, 5, fecha2);
        
        AnimationClass fecha222 = new AnimationClass();
        fecha222.jLabelXRight(-160, 20,10, 5, fecha2);
        
        AnimationClass fecha33 = new AnimationClass();
        fecha33.jLabelXLeft(60, -120,10, 5, fecha3);
        
        AnimationClass fecha333 = new AnimationClass();
        fecha333.jLabelXRight(-120, 60,10, 5, fecha3);
        //2
         AnimationClass proveedor = new AnimationClass();
        proveedor.jLabelXRight(-70,20,10, 5,Proveedores);
        
        AnimationClass proveedorr = new AnimationClass();
        proveedorr.jLabelXLeft(20,-70,10, 5,Proveedores);
        
        AnimationClass chatcenter = new AnimationClass();
        chatcenter.jLabelXRight(-70,110,10, 5,ChatCenter);
        
        AnimationClass chatcenterr = new AnimationClass();
        chatcenterr.jLabelXLeft(110,-70,10, 5,ChatCenter);
        
        AnimationClass empleados = new AnimationClass();
        empleados.jLabelXRight(-70,20,10, 5,Empleados);
        
        AnimationClass empleadoss = new AnimationClass();
        empleadoss.jLabelXLeft(20,-70,10, 5,Empleados);
        
        AnimationClass empresa = new AnimationClass();
        empresa.jLabelXRight(-70,110,10, 5,Empresa);
        
        AnimationClass empresaa = new AnimationClass();
        empresaa.jLabelXLeft(110,-70,10, 5,Empresa);
        
        AnimationClass caja = new AnimationClass();
        caja.jLabelXRight(-70,20,10, 5,CajaRegistradora);
        
        AnimationClass cajaa = new AnimationClass();
        cajaa.jLabelXLeft(20,-70,10, 5,CajaRegistradora);
        
        AnimationClass inventario = new AnimationClass();
        inventario.jLabelXRight(-70,110,10, 5,Inventario);
        
        AnimationClass inventarioo = new AnimationClass();
        inventarioo.jLabelXLeft(110,-70,10, 5,Inventario);
        
        AnimationClass productos = new AnimationClass();
        productos.jLabelXRight(-70,20,10, 5,Productos);
        
        AnimationClass productoss = new AnimationClass();
        productoss.jLabelXLeft(20,-70,10, 5,Productos);
        
        AnimationClass TipoUsuario2 = new AnimationClass();
        TipoUsuario2.jLabelXRight(-70,110,10, 5,TipoUsuario1);
        
        AnimationClass TipoUsuarioo = new AnimationClass();
        TipoUsuarioo.jLabelXLeft(110,-70,10, 5,TipoUsuario1);
        
        AnimationClass bitacoras = new AnimationClass();
        bitacoras.jLabelXRight(-70,110,10, 5,Bitacoras);
        
        AnimationClass bitacorass = new AnimationClass();
        bitacorass.jLabelXLeft(110,-70,10, 5,Bitacoras);
        
        AnimationClass construir = new AnimationClass();
        construir.jLabelXRight(-70,20,10, 5,ConstruirEquipo);
        
        AnimationClass construirr = new AnimationClass();
        construirr.jLabelXLeft(20,-70,10, 5,ConstruirEquipo);
        
        AnimationClass clientes = new AnimationClass();
        construir.jLabelXRight(-70,20,10, 5,Clientes);
        
        AnimationClass clientess = new AnimationClass();
        clientess.jLabelXLeft(20,-70,10, 5,Clientes);
        
        AnimationClass presupuesto = new AnimationClass();
        presupuesto.jLabelXRight(-70,110,10, 5,Presupuesto);
        
        AnimationClass presupuestoo = new AnimationClass();
        presupuestoo.jLabelXLeft(110,-70,10, 5,Presupuesto);
        
        AnimationClass ventas = new AnimationClass();
        ventas.jLabelXRight(-70,20,10, 5,Ventas);
        
        AnimationClass ventass = new AnimationClass();
        ventass.jLabelXLeft(20,-70,10, 5,Ventas);
        
        AnimationClass ordenes = new AnimationClass();
        ordenes.jLabelXRight(-70,110,10, 5,Ordenes);
        
        AnimationClass ordeness = new AnimationClass();
        ordeness.jLabelXLeft(110,-70,10, 5,Ordenes);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.hide();
        Login1 login = new Login1();
        login.show();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        this.setState(VentanaPrincipal2.ICONIFIED);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void ProveedoresMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProveedoresMouseMoved
        // TODO add your handling code here:
       
        //Proveedores.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
    }//GEN-LAST:event_ProveedoresMouseMoved

    private void ProveedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProveedoresMouseExited
        // TODO add your handling code here:
        ImageIcon foto = new ImageIcon (getClass().getResource("/images/Proveedores.png"));
       ImageIcon icono = new ImageIcon(foto.getImage().getScaledInstance(Proveedores.getWidth(),Proveedores.getHeight(),Image.SCALE_DEFAULT));
       Proveedores.setIcon(icono);
      
    }//GEN-LAST:event_ProveedoresMouseExited

    private void ProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProveedoresMouseClicked
        // TODO add your handling code here:
        PanelPrincipal.setVisible(true);
        jLabel2.setVisible(false);
        PProveedores datos = new PProveedores();
        datos.setSize(680,500);
        PanelPrincipal.removeAll();
        PanelPrincipal.add(datos, BorderLayout.CENTER);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
        
    }//GEN-LAST:event_ProveedoresMouseClicked

    private void ChatCenterMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChatCenterMouseMoved
        // TODO add your handling code here:
        // ChatCenter.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
    }//GEN-LAST:event_ChatCenterMouseMoved

    private void ChatCenterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChatCenterMouseExited
        // TODO add your handling code here:
        //ChatCenter.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
         ImageIcon foto = new ImageIcon (getClass().getResource("/images/ChatCenter.png"));
       ImageIcon icono = new ImageIcon(foto.getImage().getScaledInstance(ChatCenter.getWidth(),ChatCenter.getHeight(),Image.SCALE_DEFAULT));
       ChatCenter.setIcon(icono);
    }//GEN-LAST:event_ChatCenterMouseExited

    private void ChatCenterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChatCenterMouseClicked
        // TODO add your handling code here:
        PanelPrincipal.setVisible(true);
        jLabel2.setVisible(false);
        PChatCenter chatcenter = new PChatCenter();
        chatcenter.setSize(680,500);
        PanelPrincipal.removeAll();
        PanelPrincipal.add(chatcenter, BorderLayout.CENTER);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();     
    }//GEN-LAST:event_ChatCenterMouseClicked

    private void jLabel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseMoved
        // TODO add your handling code here:
        ImageIcon foto = new ImageIcon (getClass().getResource("/images/Menu.png"));
       ImageIcon icono = new ImageIcon(foto.getImage().getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(),Image.SCALE_DEFAULT));
       jLabel1.setIcon(icono);
    }//GEN-LAST:event_jLabel1MouseMoved

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        ImageIcon foto = new ImageIcon (getClass().getResource("/images/MenuGris.png"));
       ImageIcon icono = new ImageIcon(foto.getImage().getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(),Image.SCALE_DEFAULT));
       jLabel1.setIcon(icono);
    }//GEN-LAST:event_jLabel1MouseExited

    private void ProveedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProveedoresMouseEntered
        // TODO add your handling code here:
        Proveedores.setToolTipText("Gestionar Proveedores");
        ImageIcon foto = new ImageIcon (getClass().getResource("/images/Proveedores1.png"));
       ImageIcon icono = new ImageIcon(foto.getImage().getScaledInstance(Proveedores.getWidth(),Proveedores.getHeight(),Image.SCALE_DEFAULT));
       Proveedores.setIcon(icono);
    }//GEN-LAST:event_ProveedoresMouseEntered

    private void ChatCenterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChatCenterMouseEntered
        // TODO add your handling code here:
        ChatCenter.setToolTipText("Chat Center");
        ImageIcon foto = new ImageIcon (getClass().getResource("/images/ChatCenter1.png"));
        ImageIcon icono = new ImageIcon(foto.getImage().getScaledInstance(ChatCenter.getWidth(),ChatCenter.getHeight(),Image.SCALE_DEFAULT));
        ChatCenter.setIcon(icono);
    }//GEN-LAST:event_ChatCenterMouseEntered

    private void EmpleadosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpleadosMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpleadosMouseMoved

    private void EmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpleadosMouseClicked
        // TODO add your handling code here:
        PanelPrincipal.setVisible(true);
        jLabel2.setVisible(false);
        PEmpleado empleado = new PEmpleado();
        empleado.setSize(680,500);
        PanelPrincipal.removeAll();
        PanelPrincipal.add(empleado, BorderLayout.CENTER);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
       
    }//GEN-LAST:event_EmpleadosMouseClicked

    private void EmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpleadosMouseEntered
        // TODO add your handling code here:
        Empleados.setToolTipText("Gestionar Empleados");
        ImageIcon foto5 = new ImageIcon (getClass().getResource("/images/Empleados1.png"));
       ImageIcon icono5 = new ImageIcon(foto5.getImage().getScaledInstance(Empleados.getWidth(),Empleados.getHeight(),Image.SCALE_DEFAULT));
       Empleados.setIcon(icono5);
    }//GEN-LAST:event_EmpleadosMouseEntered

    private void EmpleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpleadosMouseExited
        // TODO add your handling code here:
        ImageIcon foto5 = new ImageIcon (getClass().getResource("/images/Empleados.png"));
       ImageIcon icono5 = new ImageIcon(foto5.getImage().getScaledInstance(Empleados.getWidth(),Empleados.getHeight(),Image.SCALE_DEFAULT));
       Empleados.setIcon(icono5);
    }//GEN-LAST:event_EmpleadosMouseExited

    private void EmpresaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpresaMouseMoved
        // TODO add your handling code here:
        
    }//GEN-LAST:event_EmpresaMouseMoved

    private void EmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpresaMouseClicked
        // TODO add your handling code here:
        PanelPrincipal.setVisible(true);
        jLabel2.setVisible(false);
        PDatosEmpresa datos = new PDatosEmpresa();
        datos.setSize(680,500);
        PanelPrincipal.removeAll();
        PanelPrincipal.add(datos, BorderLayout.CENTER);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
    }//GEN-LAST:event_EmpresaMouseClicked

    private void EmpresaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpresaMouseEntered
        // TODO add your handling code here:
       Empresa.setToolTipText("Gestionar Datos de la Empresa");
       ImageIcon foto5 = new ImageIcon (getClass().getResource("/images/Empresa1.png"));
       ImageIcon icono5 = new ImageIcon(foto5.getImage().getScaledInstance(Empresa.getWidth(),Empresa.getHeight(),Image.SCALE_DEFAULT));
       Empresa.setIcon(icono5);
    }//GEN-LAST:event_EmpresaMouseEntered

    private void EmpresaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpresaMouseExited
        // TODO add your handling code here:
        ImageIcon foto5 = new ImageIcon (getClass().getResource("/images/Empresa.png"));
       ImageIcon icono5 = new ImageIcon(foto5.getImage().getScaledInstance(Empresa.getWidth(),Empresa.getHeight(),Image.SCALE_DEFAULT));
       Empresa.setIcon(icono5);
    }//GEN-LAST:event_EmpresaMouseExited

    private void CajaRegistradoraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CajaRegistradoraMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_CajaRegistradoraMouseMoved

    private void CajaRegistradoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CajaRegistradoraMouseClicked
        // TODO add your handling code here
       
            PanelPrincipal.setVisible(true);
             jLabel2.setVisible(false);
        PCajaVirtual caja = new PCajaVirtual();
        caja.setSize(680,500);
        PanelPrincipal.removeAll();
        PanelPrincipal.add(caja, BorderLayout.CENTER);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();

        
    }//GEN-LAST:event_CajaRegistradoraMouseClicked

    private void CajaRegistradoraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CajaRegistradoraMouseEntered
        // TODO add your handling code here:
        CajaRegistradora.setToolTipText("Caja Registradora Virtual");
       ImageIcon foto5 = new ImageIcon (getClass().getResource("/images/CajaRegistradora1.png"));
       ImageIcon icono5 = new ImageIcon(foto5.getImage().getScaledInstance(CajaRegistradora.getWidth(),CajaRegistradora.getHeight(),Image.SCALE_DEFAULT));
       CajaRegistradora.setIcon(icono5);
    }//GEN-LAST:event_CajaRegistradoraMouseEntered

    private void CajaRegistradoraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CajaRegistradoraMouseExited
        // TODO add your handling code here:
       ImageIcon foto5 = new ImageIcon (getClass().getResource("/images/CajaRegistradora.png"));
       ImageIcon icono5 = new ImageIcon(foto5.getImage().getScaledInstance(CajaRegistradora.getWidth(),CajaRegistradora.getHeight(),Image.SCALE_DEFAULT));
       CajaRegistradora.setIcon(icono5);
    }//GEN-LAST:event_CajaRegistradoraMouseExited

    private void InventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventarioMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_InventarioMouseMoved

    private void InventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventarioMouseClicked
        // TODO add your handling code here:
        PanelPrincipal.setVisible(true);
        jLabel2.setVisible(false);
        PInventario inventario = new PInventario();
        inventario.setSize(680,500);
        PanelPrincipal.removeAll();
        PanelPrincipal.add(inventario, BorderLayout.CENTER);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
    }//GEN-LAST:event_InventarioMouseClicked

    private void InventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventarioMouseEntered
        // TODO add your handling code here:
        Inventario.setToolTipText("Gestionar Inventario");
        ImageIcon foto5 = new ImageIcon (getClass().getResource("/images/Inventario1.png"));
       ImageIcon icono5 = new ImageIcon(foto5.getImage().getScaledInstance(Inventario.getWidth(),Inventario.getHeight(),Image.SCALE_DEFAULT));
       Inventario.setIcon(icono5);
    }//GEN-LAST:event_InventarioMouseEntered

    private void InventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventarioMouseExited
        // TODO add your handling code here:
       ImageIcon foto5 = new ImageIcon (getClass().getResource("/images/Inventario.png"));
       ImageIcon icono5 = new ImageIcon(foto5.getImage().getScaledInstance(Inventario.getWidth(),Inventario.getHeight(),Image.SCALE_DEFAULT));
       Inventario.setIcon(icono5);
    }//GEN-LAST:event_InventarioMouseExited

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

    private void ProductosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductosMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductosMouseMoved

    private void ProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductosMouseClicked
        // TODO add your handling code here:
        PanelPrincipal.setVisible(true);
        jLabel2.setVisible(false);
        PProductos productos = new PProductos();
        productos.setSize(680,500);
        PanelPrincipal.removeAll();
        PanelPrincipal.add(productos, BorderLayout.CENTER);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
    }//GEN-LAST:event_ProductosMouseClicked

    private void ProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductosMouseExited
        // TODO add your handling code here:
        ImageIcon foto5 = new ImageIcon (getClass().getResource("/images/Productos.png"));
       ImageIcon icono5 = new ImageIcon(foto5.getImage().getScaledInstance(Productos.getWidth(),Productos.getHeight(),Image.SCALE_DEFAULT));
       Productos.setIcon(icono5);
    }//GEN-LAST:event_ProductosMouseExited

    private void ProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductosMouseEntered
        // TODO add your handling code here:
        Productos.setToolTipText("Gestionar Productos");
        ImageIcon foto5 = new ImageIcon (getClass().getResource("/images/Productos1.png"));
       ImageIcon icono5 = new ImageIcon(foto5.getImage().getScaledInstance(Productos.getWidth(),Productos.getHeight(),Image.SCALE_DEFAULT));
       Productos.setIcon(icono5);
    }//GEN-LAST:event_ProductosMouseEntered

    private void TipoUsuario1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TipoUsuario1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoUsuario1MouseMoved

    private void TipoUsuario1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TipoUsuario1MouseClicked
        // TODO add your handling code here:
        PanelPrincipal.setVisible(true);
        jLabel2.setVisible(false);
        PTipoUsuario tipo= new PTipoUsuario();
        tipo.setSize(680,500);
        PanelPrincipal.removeAll();
        PanelPrincipal.add(tipo, BorderLayout.CENTER);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
    }//GEN-LAST:event_TipoUsuario1MouseClicked

    private void TipoUsuario1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TipoUsuario1MouseExited
        // TODO add your handling code here:
        ImageIcon foto5 = new ImageIcon (getClass().getResource("/images/Tipo-Usuario.png"));
       ImageIcon icono5 = new ImageIcon(foto5.getImage().getScaledInstance(TipoUsuario1.getWidth(),TipoUsuario1.getHeight(),Image.SCALE_DEFAULT));
       TipoUsuario1.setIcon(icono5);
    }//GEN-LAST:event_TipoUsuario1MouseExited

    private void TipoUsuario1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TipoUsuario1MouseEntered
        // TODO add your handling code here:
        TipoUsuario1.setToolTipText("Gestionar Tipo Usuario");
        ImageIcon foto5 = new ImageIcon (getClass().getResource("/images/Tipo-Usuario1.png"));
       ImageIcon icono5 = new ImageIcon(foto5.getImage().getScaledInstance(TipoUsuario1.getWidth(),TipoUsuario1.getHeight(),Image.SCALE_DEFAULT));
       TipoUsuario1.setIcon(icono5);
    }//GEN-LAST:event_TipoUsuario1MouseEntered

    private void ConstruirEquipoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConstruirEquipoMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_ConstruirEquipoMouseMoved

    private void ConstruirEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConstruirEquipoMouseClicked
        // TODO add your handling code here:
        PanelPrincipal.setVisible(true);
        jLabel2.setVisible(false);
        PConstruirEquipo tipo= new PConstruirEquipo();
        tipo.setSize(680,500);
        PanelPrincipal.removeAll();
        PanelPrincipal.add(tipo, BorderLayout.CENTER);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
    }//GEN-LAST:event_ConstruirEquipoMouseClicked

    private void ConstruirEquipoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConstruirEquipoMouseEntered
        // TODO add your handling code here:
        ConstruirEquipo.setToolTipText("Construir Equipo");
        ImageIcon foto = new ImageIcon (getClass().getResource("/images/ConstruirPC1.png"));
        ImageIcon icono = new ImageIcon(foto.getImage().getScaledInstance(ConstruirEquipo.getWidth(),ConstruirEquipo.getHeight(),Image.SCALE_DEFAULT));
        ConstruirEquipo.setIcon(icono);
    }//GEN-LAST:event_ConstruirEquipoMouseEntered

    private void ConstruirEquipoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConstruirEquipoMouseExited
        // TODO add your handling code here:
         ImageIcon foto = new ImageIcon (getClass().getResource("/images/ConstruirPC.png"));
        ImageIcon icono = new ImageIcon(foto.getImage().getScaledInstance(ConstruirEquipo.getWidth(),ConstruirEquipo.getHeight(),Image.SCALE_DEFAULT));
        ConstruirEquipo.setIcon(icono);
    }//GEN-LAST:event_ConstruirEquipoMouseExited

    private void BitacorasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BitacorasMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_BitacorasMouseMoved

    private void BitacorasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BitacorasMouseClicked
        // TODO add your handling code here:
        PanelPrincipal.setVisible(true);
        jLabel2.setVisible(false);
        PGestionarBitacoras tipo= new PGestionarBitacoras();
        tipo.setSize(680,500);
        PanelPrincipal.removeAll();
        PanelPrincipal.add(tipo, BorderLayout.CENTER);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
    }//GEN-LAST:event_BitacorasMouseClicked

    private void BitacorasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BitacorasMouseEntered
        // TODO add your handling code here:
        Bitacoras.setToolTipText("Gestionar Bitacoras");
        ImageIcon foto12 = new ImageIcon (getClass().getResource("/images/Bitacoras2.png"));
       ImageIcon icono12 = new ImageIcon(foto12.getImage().getScaledInstance(Bitacoras.getWidth(),Bitacoras.getHeight(),Image.SCALE_DEFAULT));
       Bitacoras.setIcon(icono12);
    }//GEN-LAST:event_BitacorasMouseEntered

    private void BitacorasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BitacorasMouseExited
        // TODO add your handling code here:
        ImageIcon foto12 = new ImageIcon (getClass().getResource("/images/Bitacoras.png"));
       ImageIcon icono12 = new ImageIcon(foto12.getImage().getScaledInstance(Bitacoras.getWidth(),Bitacoras.getHeight(),Image.SCALE_DEFAULT));
       Bitacoras.setIcon(icono12);
    }//GEN-LAST:event_BitacorasMouseExited

    private void ClientesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_ClientesMouseMoved

    private void ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesMouseClicked
        // TODO add your handling code here:
        PanelPrincipal.setVisible(true);
        jLabel2.setVisible(false);
        PGestionarClientes datos = new PGestionarClientes();
        datos.setSize(680,500);
        PanelPrincipal.removeAll();
        PanelPrincipal.add(datos, BorderLayout.CENTER);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
    }//GEN-LAST:event_ClientesMouseClicked

    private void ClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesMouseEntered
        // TODO add your handling code here:
        Clientes.setToolTipText("Gestionar Clientes");
        ImageIcon foto13 = new ImageIcon (getClass().getResource("/images/Clientes1.png"));
       ImageIcon icono13 = new ImageIcon(foto13.getImage().getScaledInstance(Clientes.getWidth(),Clientes.getHeight(),Image.SCALE_DEFAULT));
       Clientes.setIcon(icono13);
    }//GEN-LAST:event_ClientesMouseEntered

    private void ClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesMouseExited
        // TODO add your handling code here:
        ImageIcon foto13 = new ImageIcon (getClass().getResource("/images/Clientes.png"));
       ImageIcon icono13 = new ImageIcon(foto13.getImage().getScaledInstance(Clientes.getWidth(),Clientes.getHeight(),Image.SCALE_DEFAULT));
       Clientes.setIcon(icono13);
        
    }//GEN-LAST:event_ClientesMouseExited

    private void PresupuestoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PresupuestoMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_PresupuestoMouseMoved

    private void PresupuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PresupuestoMouseClicked
        // TODO add your handling code here:
        PanelPrincipal.setVisible(true);
        jLabel2.setVisible(false);
        PPresupuesto datos = new PPresupuesto();
        datos.setSize(680,500);
        PanelPrincipal.removeAll();
        PanelPrincipal.add(datos, BorderLayout.CENTER);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
    }//GEN-LAST:event_PresupuestoMouseClicked

    private void PresupuestoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PresupuestoMouseEntered
        // TODO add your handling code here:
        Presupuesto.setToolTipText("Crear Presupuesto");
        ImageIcon foto14 = new ImageIcon (getClass().getResource("/images/Presupuesto1.png"));
       ImageIcon icono14 = new ImageIcon(foto14.getImage().getScaledInstance(Presupuesto.getWidth(),Presupuesto.getHeight(),Image.SCALE_DEFAULT));
       Presupuesto.setIcon(icono14);
    }//GEN-LAST:event_PresupuestoMouseEntered

    private void PresupuestoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PresupuestoMouseExited
        // TODO add your handling code here:
        ImageIcon foto14 = new ImageIcon (getClass().getResource("/images/Presupuesto.png"));
       ImageIcon icono14 = new ImageIcon(foto14.getImage().getScaledInstance(Presupuesto.getWidth(),Presupuesto.getHeight(),Image.SCALE_DEFAULT));
       Presupuesto.setIcon(icono14);
    }//GEN-LAST:event_PresupuestoMouseExited

    private void VentasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_VentasMouseMoved

    private void VentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasMouseClicked
        // TODO add your handling code here:
        PanelPrincipal.setVisible(true);
        jLabel2.setVisible(false);
        PVentas datos = new PVentas();
        datos.setSize(680,500);
        PanelPrincipal.removeAll();
        PanelPrincipal.add(datos, BorderLayout.CENTER);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
    }//GEN-LAST:event_VentasMouseClicked

    private void VentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasMouseEntered
        // TODO add your handling code here:
        Ventas.setToolTipText("Gestionar Ventas");
        ImageIcon foto15 = new ImageIcon (getClass().getResource("/images/Ventas1.png"));
       ImageIcon icono15 = new ImageIcon(foto15.getImage().getScaledInstance(Ventas.getWidth(),Ventas.getHeight(),Image.SCALE_DEFAULT));
       Ventas.setIcon(icono15);
    }//GEN-LAST:event_VentasMouseEntered

    private void VentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasMouseExited
        // TODO add your handling code here:
        ImageIcon foto15 = new ImageIcon (getClass().getResource("/images/Ventas.png"));
       ImageIcon icono15 = new ImageIcon(foto15.getImage().getScaledInstance(Ventas.getWidth(),Ventas.getHeight(),Image.SCALE_DEFAULT));
       Ventas.setIcon(icono15);
    }//GEN-LAST:event_VentasMouseExited

    private void OrdenesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrdenesMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_OrdenesMouseMoved

    private void OrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrdenesMouseClicked
        // TODO add your handling code here:
        PanelPrincipal.setVisible(true);
        jLabel2.setVisible(false);
        VerOrdenesCola datos = new VerOrdenesCola();
        datos.setSize(680,500);
        PanelPrincipal.removeAll();
        PanelPrincipal.add(datos, BorderLayout.CENTER);
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
    }//GEN-LAST:event_OrdenesMouseClicked

    private void OrdenesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrdenesMouseEntered
        // TODO add your handling code here:
        Ordenes.setToolTipText("Gestionar Pedidos");
         ImageIcon foto16 = new ImageIcon (getClass().getResource("/images/OrdenesCola1.png"));
       ImageIcon icono16 = new ImageIcon(foto16.getImage().getScaledInstance(Ordenes.getWidth(),Ordenes.getHeight(),Image.SCALE_DEFAULT));
       Ordenes.setIcon(icono16);
    }//GEN-LAST:event_OrdenesMouseEntered

    private void OrdenesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrdenesMouseExited
        // TODO add your handling code here:
         ImageIcon foto16 = new ImageIcon (getClass().getResource("/images/OrdenesCola.png"));
       ImageIcon icono16 = new ImageIcon(foto16.getImage().getScaledInstance(Ordenes.getWidth(),Ordenes.getHeight(),Image.SCALE_DEFAULT));
       Ordenes.setIcon(icono16);
    }//GEN-LAST:event_OrdenesMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bitacoras;
    private javax.swing.JLabel CajaRegistradora;
    private javax.swing.JLabel ChatCenter;
    private javax.swing.JLabel Clientes;
    private javax.swing.JLabel ConstruirEquipo;
    private javax.swing.JLabel Empleados;
    private javax.swing.JLabel Empresa;
    private javax.swing.JLabel Inventario;
    private javax.swing.JLabel Ordenes;
    public static javax.swing.JPanel PanelPrincipal;
    private javax.swing.JLabel Presupuesto;
    private javax.swing.JLabel Productos;
    private javax.swing.JLabel Proveedores;
    private javax.swing.JLabel TipoUsuario1;
    private javax.swing.JLabel Ventas;
    private javax.swing.JLabel apellido2;
    private javax.swing.JLabel fecha1;
    private javax.swing.JLabel fecha2;
    private javax.swing.JLabel fecha3;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jblnombre;
    // End of variables declaration//GEN-END:variables
}
