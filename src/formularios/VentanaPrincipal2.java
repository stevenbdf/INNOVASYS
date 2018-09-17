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
import clases.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author steve
 */
public class VentanaPrincipal2 extends javax.swing.JFrame {

    
    ImageIcon foto0 = new ImageIcon(getClass().getResource("/images/Inventario.png")); 
    ImageIcon icono0 = new ImageIcon(foto0.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto1 = new ImageIcon(getClass().getResource("/images/ConstruirPC.png")); 
    ImageIcon icono1 = new ImageIcon(foto1.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto2 = new ImageIcon(getClass().getResource("/images/Productos.png")); 
    ImageIcon icono2 = new ImageIcon(foto2.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto3 = new ImageIcon(getClass().getResource("/images/Presupuesto.png")); 
    ImageIcon icono3 = new ImageIcon(foto3.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto4 = new ImageIcon(getClass().getResource("/images/OrdenesCola.png")); 
    ImageIcon icono4 = new ImageIcon(foto4.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto5 = new ImageIcon(getClass().getResource("/images/CajaRegistradora.png")); 
    ImageIcon icono5 = new ImageIcon(foto5.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto6 = new ImageIcon(getClass().getResource("/images/Ventas.png")); 
    ImageIcon icono6 = new ImageIcon(foto6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto7 = new ImageIcon(getClass().getResource("/images/ChatCenter.png")); 
    ImageIcon icono7 = new ImageIcon(foto7.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto8 = new ImageIcon(getClass().getResource("/images/Empresa.png")); 
    ImageIcon icono8 = new ImageIcon(foto8.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto9 = new ImageIcon(getClass().getResource("/images/Tipo-Usuario.png")); 
    ImageIcon icono9 = new ImageIcon(foto9.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto10 = new ImageIcon(getClass().getResource("/images/Bitacoras.png")); 
    ImageIcon icono10 = new ImageIcon(foto10.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto11 = new ImageIcon(getClass().getResource("/images/Clientes.png")); 
    ImageIcon icono11 = new ImageIcon(foto11.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto12 = new ImageIcon(getClass().getResource("/images/Proveedores.png")); 
    ImageIcon icono12 = new ImageIcon(foto12.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto13 = new ImageIcon(getClass().getResource("/images/Empleados.png")); 
    ImageIcon icono13 = new ImageIcon(foto13.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto0s = new ImageIcon(getClass().getResource("/images/Inventario1.png")); 
    ImageIcon icono0s = new ImageIcon(foto0s.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto1s = new ImageIcon(getClass().getResource("/images/ConstruirPC1.png")); 
    ImageIcon icono1s = new ImageIcon(foto1s.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto2s = new ImageIcon(getClass().getResource("/images/Productos1.png")); 
    ImageIcon icono2s = new ImageIcon(foto2s.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto3s = new ImageIcon(getClass().getResource("/images/Presupuesto1.png")); 
    ImageIcon icono3s = new ImageIcon(foto3s.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto4s = new ImageIcon(getClass().getResource("/images/OrdenesCola1.png")); 
    ImageIcon icono4s = new ImageIcon(foto4s.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto5s = new ImageIcon(getClass().getResource("/images/CajaRegistradora1.png")); 
    ImageIcon icono5s = new ImageIcon(foto5s.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto6s = new ImageIcon(getClass().getResource("/images/Ventas1.png")); 
    ImageIcon icono6s = new ImageIcon(foto6s.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto7s = new ImageIcon(getClass().getResource("/images/ChatCenter1.png")); 
    ImageIcon icono7s = new ImageIcon(foto7s.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto8s = new ImageIcon(getClass().getResource("/images/Empresa1.png")); 
    ImageIcon icono8s = new ImageIcon(foto8s.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto9s = new ImageIcon(getClass().getResource("/images/Tipo-Usuario1.png")); 
    ImageIcon icono9s = new ImageIcon(foto9s.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto10s = new ImageIcon(getClass().getResource("/images/Bitacoras2.png")); 
    ImageIcon icono10s = new ImageIcon(foto10s.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto11s = new ImageIcon(getClass().getResource("/images/Clientes1.png")); 
    ImageIcon icono11s = new ImageIcon(foto11s.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto12s = new ImageIcon(getClass().getResource("/images/Proveedores1.png")); 
    ImageIcon icono12s = new ImageIcon(foto12s.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    ImageIcon foto13s = new ImageIcon(getClass().getResource("/images/Empleados1.png")); 
    ImageIcon icono13s = new ImageIcon(foto13s.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
    
    Integer dia,diames, mes, año, tipoU, codigoEmpleado;
    public String correoE;
    int posiciones[] = new int[14];
    
    public static void changeFont(Component component, Font font) {
        component.setFont(font);
        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                changeFont(child, font);
            }
        }
    }
    
    public VentanaPrincipal2(String correo) {
//        try {
//                     UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//		}
//		catch (Exception e) {
//		}
        initComponents();
        timer.start();
        obtenerFecha();
        correoE=correo;
        Font fuente = null;
        Font fuente2 = null;
        Font fuente3 = null;
        InputStream myStream = null;
        try {
            myStream = new BufferedInputStream(new FileInputStream("src/fuentes/Raleway.ttf"));
            fuente = Font.createFont(Font.TRUETYPE_FONT, myStream);
            fuente = fuente.deriveFont(Font.BOLD, 60);
            fuente2 = fuente.deriveFont(Font.BOLD, 30);
            fuente3 = fuente.deriveFont(Font.BOLD, 26);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(VentanaPrincipal2.class.getName()).log(Level.SEVERE, null, ex);
        }
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fuente);
        
        
        
        jLabel3.setFont(fuente);
        changeFont(jPanel2, fuente2);
        tipoUsuario.setFont(fuente3);
        

            
        
        try {
            Conexion cn = new Conexion();
            String sql ="SELECT nombres, apellidos, usuarioEmpleado.idTipo, idEmpleado, tip.nombreTipo FROM usuarioEmpleado, tipoUsuario tip WHERE correoElectronico='"+correo+"' AND tip.idTipo=usuarioEmpleado.idTipo";
            PreparedStatement cmd = cn.conectar().prepareStatement(sql);
            ResultSet look = cmd.executeQuery();
            if (look.next()) {
                jblnombre.setText(look.getString(1));
                apellido2.setText(look.getString(2));
                tipoU=look.getInt(3);
                codigoEmpleado=look.getInt(4);
                tipoUsuario.setText(look.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        setIconImage(new ImageIcon(getClass().getResource("/images/logo2.png")).getImage( ));
        PanelPrincipal.setVisible(false);
        Inventario.setVisible(false);
        ConstruirEquipo.setVisible(false);
        Presupuesto.setVisible(false);
        Productos.setVisible(false);
        Ordenes.setVisible(false);
        CajaRegistradora.setVisible(false);
        Ventas.setVisible(false);
        ChatCenter.setVisible(false);
        Empresa.setVisible(false);
        Ventas.setVisible(false);
        Bitacoras.setVisible(false);
        Clientes.setVisible(false);
        Proveedores.setVisible(false);
        Empleados.setVisible(false);
        TipoUsuario1.setVisible(false);
        Productos.setVisible(false);
                     
        
        
        setLocationRelativeTo(null);
        
       Fade.JFrameFadeIn(0f, 1f, 0.1f,100,this );
       ImageIcon foto = new ImageIcon (getClass().getResource("/images/logo2.png"));
       ImageIcon icono = new ImageIcon(foto.getImage().getScaledInstance(jLabel2.getWidth(),jLabel2.getHeight(),Image.SCALE_DEFAULT));
       jLabel2.setIcon(icono);
       
       definirPrivilegios();
       
       
    }
    
    int[] casos = new int[14];
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
        tipoUsuario = new javax.swing.JLabel();
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

        jPanel2.setBackground(new java.awt.Color(30, 57, 42));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(60, 196, 124), 3, true));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel2MouseReleased(evt);
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
        fecha1.setForeground(new java.awt.Color(255, 255, 255));
        fecha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fecha1.setText("VIERNES");
        jPanel2.add(fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        fecha2.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        fecha2.setForeground(new java.awt.Color(255, 255, 255));
        fecha2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fecha2.setText("23 JUNIO");
        jPanel2.add(fecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        fecha3.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        fecha3.setForeground(new java.awt.Color(255, 255, 255));
        fecha3.setText("2018");
        jPanel2.add(fecha3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, -1, -1));

        jblnombre.setFont(new java.awt.Font("Century Gothic", 0, 32)); // NOI18N
        jblnombre.setForeground(new java.awt.Color(255, 255, 255));
        jblnombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblnombre.setText("Steven");
        jPanel2.add(jblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        hora.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        hora.setForeground(new java.awt.Color(255, 255, 255));
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

        apellido2.setFont(new java.awt.Font("Century Gothic", 0, 32)); // NOI18N
        apellido2.setForeground(new java.awt.Color(255, 255, 255));
        apellido2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        apellido2.setText("Diaz");
        jPanel2.add(apellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

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

        tipoUsuario.setFont(new java.awt.Font("Century Gothic", 0, 32)); // NOI18N
        tipoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        tipoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipoUsuario.setText("adm");
        jPanel2.add(tipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 610));

        jPanel1.setBackground(new java.awt.Color(30, 57, 42));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(60, 196, 124), 3, true));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 60)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(217, 179, 16));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("INNOVASYS");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

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
                .addGap(0, 604, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(40, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(124, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(0, 70, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 680, 110));

        jPanel3.setBackground(new java.awt.Color(30, 57, 42));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelPrincipal.setBackground(new java.awt.Color(30, 57, 42));
        PanelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 196, 124)));
        PanelPrincipal.setPreferredSize(new java.awt.Dimension(680, 500));

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        jPanel3.add(PanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(60, 196, 124), 5, true));
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 500));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 680, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int prove, chat, empleado, empresa, caja, invent, producto, tipo, construir, bitacor, client, presup, vent, orde; 
    private void obtenerFecha(){
        Calendar calendario = Calendar.getInstance();
        dia=(calendario.get(Calendar.DAY_OF_WEEK ));
        diames=(calendario.get(Calendar.DAY_OF_MONTH));
        mes=(calendario.get(Calendar.MONTH)+1);
        año=(calendario.get(Calendar.YEAR));
        
        switch (dia-1){
            case 0:
                fecha1.setText("Domingo");
                break;
            case 1:
                fecha1.setText("Lunes");
                break;
            case 2:
                fecha1.setText("Martes");
                break;
            case 3:
                fecha1.setText("Miercoles");
                break;
            case 4:
                fecha1.setText("Jueves");
                break;
            case 5:
                fecha1.setText("Viernes");
                break;
            case 6:
                fecha1.setText("Sabado");
                break;
            
        }
        
        switch (mes){
            case 1:
                fecha1.setText(diames+" Ene");
                break;
            case 2:
                fecha2.setText(diames+" Feb");
                break;
            case 3:
                fecha2.setText(diames+" Marz");
                break;
            case 4:
                fecha2.setText(diames+" Abril");
                break;
            case 5:
                fecha2.setText(diames+" Mayo");
                break;
            case 6:
                fecha2.setText(diames+" Junio");
                break;
            case 7:
                fecha2.setText(diames+" Julio");
                break;
            case 8:
                fecha2.setText(diames+" Agost");
                break;
            case 9:
                fecha2.setText(diames+" Septiem");
                break;
            case 10:
                fecha2.setText(diames+" Oct");
                break;
            case 11:
                fecha2.setText(diames+" Nov");
                break;
            case 12:
                fecha2.setText(diames+" Dic");
                break;  
        }      
        fecha3.setText(""+año);
    }
    
    Boolean[] valores = new Boolean[16];
    
    Integer[] botones = new Integer[14];
    
    
    //agregar cases que hacen fala privilegios NO repetivos
    private void definirPrivilegios(){
        Conexion cn = new Conexion();
        for (int i = 0; i < valores.length; i++) {
            valores[i] = false;
        }
        try {
            String sql = "SELECT verInventario, construirEquipo, verProductos, solicitarAyuda, verOrdenesCola, verCajaVirtual, verVentasUuario, chatCenter, cambiarDatosEmpresa, gestionarVentas, gestionarBitacoras, gestionarClientes,gestionarProveedores, gestionarEmpleados, gestionarProductos, gestionarInventario FROM privilegio, tipoUsuario WHERE idTipo=? AND tipoUsuario.idPrivilegio=privilegio.idPrivilegio ";   
            PreparedStatement cmd = cn.conectar().prepareStatement(sql);
            System.out.println("tipoU: "+tipoU);
            cmd.setInt(1,tipoU);
            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                for (int i = 0; i < valores.length; i++) {
                    if (rs.getByte(i+1)==1) {
                       valores[i] =  true;
                    }
                    else{
                        valores[i]= false;
                    }
                }
            }
            
            
            for (int i = 0; i <14; i++) {
                if (valores[i]==true) {
                    System.out.println("i: "+i);
                    switch (i) {
                        case 0:         
                            for (int j = 0; j < 14; j++) {
                                System.out.println("j: "+j);
                                if (posiciones[j]==0) {
                                    ImageIcon foto6 = new ImageIcon(getClass().getResource("/images/Inventario.png"));
                                    ImageIcon icono6 = new ImageIcon(foto6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
                                    switch(j){
                                        case 0:
                                            Proveedores.setIcon(icono6);
                                            Proveedores.setVisible(true);
                                            prove=i;
                                            posiciones[j]=1;
                                            casos[i]=j;
                                            botones[i]=0;
                                            System.out.println("botones case :"+i+" valor: "+botones[i]);
                                            break;
                                        case 1:
                                            ChatCenter.setIcon(icono6);
                                            ChatCenter.setVisible(true);
                                            chat=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=1;
                                            break;
                                        case 2:
                                            Empleados.setIcon(icono6);
                                            Empleados.setVisible(true);
                                            empleado=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=2;
                                            break;
                                        case 3:
                                            Empresa.setIcon(icono6);
                                            Empresa.setVisible(true);
                                            empresa=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=3;
                                            break;
                                        case 4:
                                            CajaRegistradora.setIcon(icono6);
                                            CajaRegistradora.setVisible(true);
                                            caja=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=4;
                                            break;
                                        case 5:
                                            Inventario.setIcon(icono6);
                                            Inventario.setVisible(true);
                                            invent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=5;
                                            break;
                                        case 6:
                                            Productos.setIcon(icono6);
                                            Productos.setVisible(true);
                                             producto=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=6;
                                            break;
                                        case 7:
                                            TipoUsuario1.setIcon(icono6);
                                            TipoUsuario1.setVisible(true);
                                            tipo=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=7;
                                            break;
                                        case 8:
                                            ConstruirEquipo.setIcon(icono6);
                                            ConstruirEquipo.setVisible(true);
                                            construir=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=8;
                                            break;
                                        case 9:
                                            Bitacoras.setIcon(icono6);
                                            Bitacoras.setVisible(true);
                                            bitacor=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=9;
                                            break;
                                        case 10:
                                            Clientes.setIcon(icono6);
                                            Clientes.setVisible(true);
                                            client=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=10;
                                            break;
                                        case 11:
                                            Presupuesto.setIcon(icono6);
                                            Presupuesto.setVisible(true);
                                            presup=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=11;
                                            break;
                                        case 12:
                                            Ventas.setIcon(icono6);
                                            Ventas.setVisible(true);
                                            vent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=12;
                                            break;
                                        case 13:
                                            Ordenes.setIcon(icono6);
                                            Ordenes.setVisible(true);
                                            orde=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=13;
                                            break;
                                        
                                    }
                                    break;
                                }
                                
                            }
                            break;
                        case 1:
                           
                            for (int j = 0; j < 14; j++) {
                                System.out.println("j: "+j);
                                    if (posiciones[j]==0) {
                                        
                                    ImageIcon foto6 = new ImageIcon(getClass().getResource("/images/ConstruirPC.png"));
                                    ImageIcon icono6 = new ImageIcon(foto6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
                                    switch(j){
                                        case 0:
                                            Proveedores.setIcon(icono6);
                                            Proveedores.setVisible(true);
                                            prove=i;
                                            posiciones[j]=1;
                                            casos[i]=j;
                                            botones[i]=0;
                                            System.out.println("botones case :"+i+" valor: "+botones[i]);
                                            break;
                                        case 1:
                                            ChatCenter.setIcon(icono6);
                                            ChatCenter.setVisible(true);
                                            chat=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=1;
                                            break;
                                        case 2:
                                            Empleados.setIcon(icono6);
                                            Empleados.setVisible(true);
                                            empleado=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=2;
                                            break;
                                        case 3:
                                            Empresa.setIcon(icono6);
                                            Empresa.setVisible(true);
                                            empresa=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=3;
                                            break;
                                        case 4:
                                            CajaRegistradora.setIcon(icono6);
                                            CajaRegistradora.setVisible(true);
                                            caja=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=4;
                                            break;
                                        case 5:
                                            Inventario.setIcon(icono6);
                                            Inventario.setVisible(true);
                                            invent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=5;
                                            break;
                                        case 6:
                                            Productos.setIcon(icono6);
                                            Productos.setVisible(true);
                                             producto=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=6;
                                            break;
                                        case 7:
                                            TipoUsuario1.setIcon(icono6);
                                            TipoUsuario1.setVisible(true);
                                            tipo=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=7;
                                            break;
                                        case 8:
                                            ConstruirEquipo.setIcon(icono6);
                                            ConstruirEquipo.setVisible(true);
                                            construir=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=8;
                                            break;
                                        case 9:
                                            Bitacoras.setIcon(icono6);
                                            Bitacoras.setVisible(true);
                                            bitacor=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=9;
                                            break;
                                        case 10:
                                            Clientes.setIcon(icono6);
                                            Clientes.setVisible(true);
                                            client=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=10;
                                            break;
                                        case 11:
                                            Presupuesto.setIcon(icono6);
                                            Presupuesto.setVisible(true);
                                            presup=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=11;
                                            break;
                                        case 12:
                                            Ventas.setIcon(icono6);
                                            Ventas.setVisible(true);
                                            vent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=12;
                                            break;
                                        case 13:
                                            Ordenes.setIcon(icono6);
                                            Ordenes.setVisible(true);
                                            orde=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=13;
                                            break;
                                        
                                    }
                                    break;
                                }         
                            }
                            break;
                        case 2:
                            for (int j = 0; j < 14; j++) {
                                System.out.println("j: "+j);
                                if (posiciones[j]==0) {
                                    ImageIcon foto6 = new ImageIcon(getClass().getResource("/images/Productos.png"));
                                    ImageIcon icono6 = new ImageIcon(foto6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
                                    switch(j){
                                        case 0:
                                            Proveedores.setIcon(icono6);
                                            Proveedores.setVisible(true);
                                            prove=i;
                                            posiciones[j]=1;
                                            casos[i]=j;
                                            botones[i]=0;
                                            System.out.println("botones case :"+i+" valor: "+botones[i]);
                                            break;
                                        case 1:
                                            ChatCenter.setIcon(icono6);
                                            ChatCenter.setVisible(true);
                                            chat=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=1;
                                            break;
                                        case 2:
                                            Empleados.setIcon(icono6);
                                            Empleados.setVisible(true);
                                            empleado=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=2;
                                            break;
                                        case 3:
                                            Empresa.setIcon(icono6);
                                            Empresa.setVisible(true);
                                            empresa=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=3;
                                            break;
                                        case 4:
                                            CajaRegistradora.setIcon(icono6);
                                            CajaRegistradora.setVisible(true);
                                            caja=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=4;
                                            break;
                                        case 5:
                                            Inventario.setIcon(icono6);
                                            Inventario.setVisible(true);
                                            invent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=5;
                                            break;
                                        case 6:
                                            Productos.setIcon(icono6);
                                            Productos.setVisible(true);
                                            posiciones[j]=1;casos[i]=j; producto=i;
                                            botones[i]=6;
                                            break;
                                        case 7:
                                            TipoUsuario1.setIcon(icono6);
                                            TipoUsuario1.setVisible(true);
                                            tipo=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=7;
                                            break;
                                        case 8:
                                            ConstruirEquipo.setIcon(icono6);
                                            ConstruirEquipo.setVisible(true);
                                            construir=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=8;
                                            break;
                                        case 9:
                                            Bitacoras.setIcon(icono6);
                                            Bitacoras.setVisible(true);
                                            bitacor=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=9;
                                            break;
                                        case 10:
                                            Clientes.setIcon(icono6);
                                            Clientes.setVisible(true);
                                            client=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=10;
                                            break;
                                        case 11:
                                            Presupuesto.setIcon(icono6);
                                            Presupuesto.setVisible(true);
                                            presup=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=11;
                                            break;
                                        case 12:
                                            Ventas.setIcon(icono6);
                                            Ventas.setVisible(true);
                                            vent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=12;
                                            break;
                                        case 13:
                                            Ordenes.setIcon(icono6);
                                            Ordenes.setVisible(true);
                                            orde=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=13;
                                            break;
                                    }
                                    break;
                                }
                                
                            }
                           break;
                        case 3:
                            for (int j = 0; j < 14; j++) {
                                System.out.println("j: "+j);
                                if (posiciones[j]==0) {
                                    ImageIcon foto6 = new ImageIcon(getClass().getResource("/images/Presupuesto.png"));
                                    ImageIcon icono6 = new ImageIcon(foto6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
                                    switch(j){
                                        case 0:
                                            Proveedores.setIcon(icono6);
                                            Proveedores.setVisible(true);
                                            prove=i;
                                            posiciones[j]=1;
                                            casos[i]=j;
                                            botones[i]=0;
                                            System.out.println("botones case :"+i+" valor: "+botones[i]);
                                            break;
                                        case 1:
                                            ChatCenter.setIcon(icono6);
                                            ChatCenter.setVisible(true);
                                            chat=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=1;
                                            break;
                                        case 2:
                                            Empleados.setIcon(icono6);
                                            Empleados.setVisible(true);
                                            empleado=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=2;
                                            break;
                                        case 3:
                                            Empresa.setIcon(icono6);
                                            Empresa.setVisible(true);
                                            empresa=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=3;
                                            break;
                                        case 4:
                                            CajaRegistradora.setIcon(icono6);
                                            CajaRegistradora.setVisible(true);
                                            caja=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=4;
                                            break;
                                        case 5:
                                            Inventario.setIcon(icono6);
                                            Inventario.setVisible(true);
                                            invent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=5;
                                            break;
                                        case 6:
                                            Productos.setIcon(icono6);
                                            Productos.setVisible(true); producto=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=6;
                                            break;
                                        case 7:
                                            TipoUsuario1.setIcon(icono6);
                                            TipoUsuario1.setVisible(true);
                                            tipo=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=7;
                                            break;
                                        case 8:
                                            ConstruirEquipo.setIcon(icono6);
                                            ConstruirEquipo.setVisible(true);
                                            construir=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=8;
                                            break;
                                        case 9:
                                            Bitacoras.setIcon(icono6);
                                            Bitacoras.setVisible(true);
                                            bitacor=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=9;
                                            break;
                                        case 10:
                                            Clientes.setIcon(icono6);
                                            Clientes.setVisible(true);
                                            client=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=10;
                                            break;
                                        case 11:
                                            Presupuesto.setIcon(icono6);
                                            Presupuesto.setVisible(true);
                                            presup=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=11;
                                            break;
                                        case 12:
                                            Ventas.setIcon(icono6);
                                            Ventas.setVisible(true);
                                            vent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=12;
                                            break;
                                        case 13:
                                            Ordenes.setIcon(icono6);
                                            Ordenes.setVisible(true);
                                            orde=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=13;
                                            break;
                                        
                                    }
                                    break;
                                }
                                
                            }
                           break;
                        case 4:
                            for (int j = 0; j < 14; j++) {
                                System.out.println("j: "+j);
                                if (posiciones[j]==0) {
                                    ImageIcon foto6 = new ImageIcon(getClass().getResource("/images/OrdenesCola.png"));
                                    ImageIcon icono6 = new ImageIcon(foto6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
                                    switch(j){
                                        case 0:
                                            Proveedores.setIcon(icono6);
                                            Proveedores.setVisible(true);
                                            prove=i;
                                            posiciones[j]=1;
                                            casos[i]=j;
                                            botones[i]=0;
                                            System.out.println("botones case :"+i+" valor: "+botones[i]);
                                            break;
                                        case 1:
                                            ChatCenter.setIcon(icono6);
                                            ChatCenter.setVisible(true);
                                            chat=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=1;
                                            break;
                                        case 2:
                                            Empleados.setIcon(icono6);
                                            Empleados.setVisible(true);
                                            empleado=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=2;
                                            break;
                                        case 3:
                                            Empresa.setIcon(icono6);
                                            Empresa.setVisible(true);
                                            empresa=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=3;
                                            break;
                                        case 4:
                                            CajaRegistradora.setIcon(icono6);
                                            CajaRegistradora.setVisible(true);
                                            caja=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=4;
                                            break;
                                        case 5:
                                            Inventario.setIcon(icono6);
                                            Inventario.setVisible(true);
                                            invent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=5;
                                            break;
                                        case 6:
                                            Productos.setIcon(icono6);
                                            Productos.setVisible(true); producto=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=6;
                                            break;
                                        case 7:
                                            TipoUsuario1.setIcon(icono6);
                                            TipoUsuario1.setVisible(true);
                                            tipo=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=7;
                                            break;
                                        case 8:
                                            ConstruirEquipo.setIcon(icono6);
                                            ConstruirEquipo.setVisible(true);
                                            construir=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=8;
                                            break;
                                        case 9:
                                            Bitacoras.setIcon(icono6);
                                            Bitacoras.setVisible(true);
                                            bitacor=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=9;
                                            break;
                                        case 10:
                                            Clientes.setIcon(icono6);
                                            Clientes.setVisible(true);
                                            client=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=10;
                                            break;
                                        case 11:
                                            Presupuesto.setIcon(icono6);
                                            Presupuesto.setVisible(true);
                                            presup=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=11;
                                            break;
                                        case 12:
                                            Ventas.setIcon(icono6);
                                            Ventas.setVisible(true);
                                            vent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=12;
                                            break;
                                        case 13:
                                            Ordenes.setIcon(icono6);
                                            Ordenes.setVisible(true);
                                            orde=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=13;
                                            break;
                                        
                                    }
                                    break;
                                }
                                
                            }
                            break;
                        case 5:
                            for (int j = 0; j < 14; j++) {
                                System.out.println("j: "+j);
                                if (posiciones[j]==0) {
                                    ImageIcon foto6 = new ImageIcon(getClass().getResource("/images/CajaRegistradora.png"));
                                    ImageIcon icono6 = new ImageIcon(foto6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
                                    switch(j){
                                        case 0:
                                            Proveedores.setIcon(icono6);
                                            Proveedores.setVisible(true);
                                            prove=i;
                                            posiciones[j]=1;
                                            casos[i]=j;
                                            botones[i]=0;
                                            System.out.println("botones case :"+i+" valor: "+botones[i]);
                                            break;
                                        case 1:
                                            ChatCenter.setIcon(icono6);
                                            ChatCenter.setVisible(true);
                                            chat=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=1;
                                            break;
                                        case 2:
                                            Empleados.setIcon(icono6);
                                            Empleados.setVisible(true);
                                            empleado=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=2;
                                            break;
                                        case 3:
                                            Empresa.setIcon(icono6);
                                            Empresa.setVisible(true);
                                            empresa=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=3;
                                            break;
                                        case 4:
                                            CajaRegistradora.setIcon(icono6);
                                            CajaRegistradora.setVisible(true);
                                            caja=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=4;
                                            break;
                                        case 5:
                                            Inventario.setIcon(icono6);
                                            Inventario.setVisible(true);
                                            invent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=5;
                                            break;
                                        case 6:
                                            Productos.setIcon(icono6);
                                            Productos.setVisible(true); producto=i;
                                            posiciones[j]=1;casos[i]=j;
                                            producto=i;
                                            botones[i]=6;
                                            break;
                                        case 7:
                                            TipoUsuario1.setIcon(icono6);
                                            TipoUsuario1.setVisible(true);
                                            tipo=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=7;
                                            break;
                                        case 8:
                                            ConstruirEquipo.setIcon(icono6);
                                            ConstruirEquipo.setVisible(true);
                                            construir=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=8;
                                            break;
                                        case 9:
                                            Bitacoras.setIcon(icono6);
                                            Bitacoras.setVisible(true);
                                            bitacor=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=9;
                                            break;
                                        case 10:
                                            Clientes.setIcon(icono6);
                                            Clientes.setVisible(true);
                                            client=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=10;
                                            break;
                                        case 11:
                                            Presupuesto.setIcon(icono6);
                                            Presupuesto.setVisible(true);
                                            presup=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=11;
                                            break;
                                        case 12:
                                            Ventas.setIcon(icono6);
                                            Ventas.setVisible(true);
                                            vent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=12;
                                            break;
                                        case 13:
                                            Ordenes.setIcon(icono6);
                                            Ordenes.setVisible(true);
                                            orde=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=13;
                                            break;
                                    }
                                    break;
                                }
                                
                            }
                            break;
                        case 6:
                            for (int j = 0; j < 14; j++) {
                                System.out.println("j: "+j);
                                if (posiciones[j]==0) {
                                    ImageIcon foto6 = new ImageIcon(getClass().getResource("/images/Ventas.png"));
                                    ImageIcon icono6 = new ImageIcon(foto6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
                                   switch(j){
                                        case 0:
                                            Proveedores.setIcon(icono6);
                                            Proveedores.setVisible(true);
                                            prove=i;
                                            posiciones[j]=1;
                                            casos[i]=j;
                                            botones[i]=0;
                                            System.out.println("botones case :"+i+" valor: "+botones[i]);
                                            break;
                                        case 1:
                                            ChatCenter.setIcon(icono6);
                                            ChatCenter.setVisible(true);
                                            chat=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=1;
                                            break;
                                        case 2:
                                            Empleados.setIcon(icono6);
                                            Empleados.setVisible(true);
                                            empleado=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=2;
                                            break;
                                        case 3:
                                            Empresa.setIcon(icono6);
                                            Empresa.setVisible(true);
                                            empresa=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=3;
                                            break;
                                        case 4:
                                            CajaRegistradora.setIcon(icono6);
                                            CajaRegistradora.setVisible(true);
                                            caja=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=4;
                                            break;
                                        case 5:
                                            Inventario.setIcon(icono6);
                                            Inventario.setVisible(true);
                                            invent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=5;
                                            break;
                                        case 6:
                                            Productos.setIcon(icono6);
                                            Productos.setVisible(true); 
                                            posiciones[j]=1;casos[i]=j;
                                            producto=i;
                                            botones[i]=6;
                                            break;
                                        case 7:
                                            TipoUsuario1.setIcon(icono6);
                                            TipoUsuario1.setVisible(true);
                                            tipo=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=7;
                                            break;
                                        case 8:
                                            ConstruirEquipo.setIcon(icono6);
                                            ConstruirEquipo.setVisible(true);
                                            construir=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=8;
                                            break;
                                        case 9:
                                            Bitacoras.setIcon(icono6);
                                            Bitacoras.setVisible(true);
                                            bitacor=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=9;
                                            break;
                                        case 10:
                                            Clientes.setIcon(icono6);
                                            Clientes.setVisible(true);
                                            client=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=10;
                                            break;
                                        case 11:
                                            Presupuesto.setIcon(icono6);
                                            Presupuesto.setVisible(true);
                                            presup=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=11;
                                            break;
                                        case 12:
                                            Ventas.setIcon(icono6);
                                            Ventas.setVisible(true);
                                            vent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=12;
                                            break;
                                        case 13:
                                            Ordenes.setIcon(icono6);
                                            Ordenes.setVisible(true);
                                            orde=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=13;
                                            break;
                                    }
                                    break;
                                }
                                
                            }
                            break;
                        case 7:
                           for (int j = 0; j < 14; j++) {
                               System.out.println("j: "+j);
                                if (posiciones[j]==0) {
                                    ImageIcon foto6 = new ImageIcon(getClass().getResource("/images/ChatCenter.png"));
                                    ImageIcon icono6 = new ImageIcon(foto6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
                                    switch(j){
                                        case 0:
                                            Proveedores.setIcon(icono6);
                                            Proveedores.setVisible(true);
                                            prove=i;
                                            posiciones[j]=1;
                                            casos[i]=j;
                                            botones[i]=0;
                                            System.out.println("botones case :"+i+" valor: "+botones[i]);
                                            break;
                                        case 1:
                                            ChatCenter.setIcon(icono6);
                                            ChatCenter.setVisible(true);
                                            chat=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=1;
                                            break;
                                        case 2:
                                            Empleados.setIcon(icono6);
                                            Empleados.setVisible(true);
                                            empleado=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=2;
                                            break;
                                        case 3:
                                            Empresa.setIcon(icono6);
                                            Empresa.setVisible(true);
                                            empresa=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=3;
                                            break;
                                        case 4:
                                            CajaRegistradora.setIcon(icono6);
                                            CajaRegistradora.setVisible(true);
                                            caja=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=4;
                                            break;
                                        case 5:
                                            Inventario.setIcon(icono6);
                                            Inventario.setVisible(true);
                                            invent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=5;
                                            break;
                                        case 6:
                                            Productos.setIcon(icono6);
                                            Productos.setVisible(true); producto=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=6;
                                            break;
                                        case 7:
                                            TipoUsuario1.setIcon(icono6);
                                            TipoUsuario1.setVisible(true);
                                            tipo=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=7;
                                            break;
                                        case 8:
                                            ConstruirEquipo.setIcon(icono6);
                                            ConstruirEquipo.setVisible(true);
                                            construir=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=8;
                                            break;
                                        case 9:
                                            Bitacoras.setIcon(icono6);
                                            Bitacoras.setVisible(true);
                                            bitacor=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=9;
                                            break;
                                        case 10:
                                            Clientes.setIcon(icono6);
                                            Clientes.setVisible(true);
                                            client=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=10;
                                            break;
                                        case 11:
                                            Presupuesto.setIcon(icono6);
                                            Presupuesto.setVisible(true);
                                            presup=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=11;
                                            break;
                                        case 12:
                                            Ventas.setIcon(icono6);
                                            Ventas.setVisible(true);
                                            vent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=12;
                                            break;
                                        case 13:
                                            Ordenes.setIcon(icono6);
                                            Ordenes.setVisible(true);
                                            orde=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=13;
                                            break;
                                    }
                                    break;
                                }
                                
                            }
                            break;
                        case 8:
                            for (int j = 0; j < 14; j++) {
                                System.out.println("j: "+j);
                                if (posiciones[j]==0) {
                                    ImageIcon foto6 = new ImageIcon(getClass().getResource("/images/Empresa.png"));
                                    ImageIcon icono6 = new ImageIcon(foto6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
                                    switch(j){
                                        case 0:
                                            Proveedores.setIcon(icono6);
                                            Proveedores.setVisible(true);
                                            prove=i;
                                            posiciones[j]=1;
                                            casos[i]=j;
                                            botones[i]=0;
                                            System.out.println("botones case :"+i+" valor: "+botones[i]);
                                            break;
                                        case 1:
                                            ChatCenter.setIcon(icono6);
                                            ChatCenter.setVisible(true);
                                            chat=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=1;
                                            break;
                                        case 2:
                                            Empleados.setIcon(icono6);
                                            Empleados.setVisible(true);
                                            empleado=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=2;
                                            break;
                                        case 3:
                                            Empresa.setIcon(icono6);
                                            Empresa.setVisible(true);
                                            empresa=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=3;
                                            break;
                                        case 4:
                                            CajaRegistradora.setIcon(icono6);
                                            CajaRegistradora.setVisible(true);
                                            caja=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=4;
                                            break;
                                        case 5:
                                            Inventario.setIcon(icono6);
                                            Inventario.setVisible(true);
                                            invent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=5;
                                            break;
                                        case 6:
                                            Productos.setIcon(icono6);
                                            Productos.setVisible(true); producto=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=6;
                                            break;
                                        case 7:
                                            TipoUsuario1.setIcon(icono6);
                                            TipoUsuario1.setVisible(true);
                                            tipo=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=7;
                                            break;
                                        case 8:
                                            ConstruirEquipo.setIcon(icono6);
                                            ConstruirEquipo.setVisible(true);
                                            construir=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=8;
                                            break;
                                        case 9:
                                            Bitacoras.setIcon(icono6);
                                            Bitacoras.setVisible(true);
                                            bitacor=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=9;
                                            break;
                                        case 10:
                                            Clientes.setIcon(icono6);
                                            Clientes.setVisible(true);
                                            client=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=10;
                                            break;
                                        case 11:
                                            Presupuesto.setIcon(icono6);
                                            Presupuesto.setVisible(true);
                                            presup=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=11;
                                            break;
                                        case 12:
                                            Ventas.setIcon(icono6);
                                            Ventas.setVisible(true);
                                            vent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=12;
                                            break;
                                        case 13:
                                            Ordenes.setIcon(icono6);
                                            Ordenes.setVisible(true);
                                            orde=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=13;
                                            break;
                                    }
                                    break;
                                }
                                
                            }
                            break;
                        case 9:
                            for (int j = 0; j < 14; j++) {
                                System.out.println("j: "+j);
                                if (posiciones[j]==0) {
                                    ImageIcon foto6 = new ImageIcon(getClass().getResource("/images/Tipo-Usuario.png"));
                                    ImageIcon icono6 = new ImageIcon(foto6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
                                    switch(j){
                                       case 0:
                                            Proveedores.setIcon(icono6);
                                            Proveedores.setVisible(true);
                                            prove=i;
                                            posiciones[j]=1;
                                            casos[i]=j;
                                            botones[i]=0;
                                            System.out.println("botones case :"+i+" valor: "+botones[i]);
                                            break;
                                        case 1:
                                            ChatCenter.setIcon(icono6);
                                            ChatCenter.setVisible(true);
                                            chat=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=1;
                                            break;
                                        case 2:
                                            Empleados.setIcon(icono6);
                                            Empleados.setVisible(true);
                                            empleado=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=2;
                                            break;
                                        case 3:
                                            Empresa.setIcon(icono6);
                                            Empresa.setVisible(true);
                                            empresa=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=3;
                                            break;
                                        case 4:
                                            CajaRegistradora.setIcon(icono6);
                                            CajaRegistradora.setVisible(true);
                                            caja=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=4;
                                            break;
                                        case 5:
                                            Inventario.setIcon(icono6);
                                            Inventario.setVisible(true);
                                            invent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=5;
                                            break;
                                        case 6:
                                            Productos.setIcon(icono6);
                                            Productos.setVisible(true); producto=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=6;
                                            break;
                                        case 7:
                                            TipoUsuario1.setIcon(icono6);
                                            TipoUsuario1.setVisible(true);
                                            tipo=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=7;
                                            break;
                                        case 8:
                                            ConstruirEquipo.setIcon(icono6);
                                            ConstruirEquipo.setVisible(true);
                                            construir=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=8;
                                            break;
                                        case 9:
                                            Bitacoras.setIcon(icono6);
                                            Bitacoras.setVisible(true);
                                            bitacor=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=9;
                                            break;
                                        case 10:
                                            Clientes.setIcon(icono6);
                                            Clientes.setVisible(true);
                                            client=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=10;
                                            break;
                                        case 11:
                                            Presupuesto.setIcon(icono6);
                                            Presupuesto.setVisible(true);
                                            presup=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=11;
                                            break;
                                        case 12:
                                            Ventas.setIcon(icono6);
                                            Ventas.setVisible(true);
                                            vent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=12;
                                            break;
                                        case 13:
                                            Ordenes.setIcon(icono6);
                                            Ordenes.setVisible(true);
                                            orde=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=13;
                                            break;
                                    }
                                    break;
                                }
                                
                            }
                            break;    
                        case 10:
                            for (int j = 0; j < 14; j++) {
                                System.out.println("j: "+j);
                                if (posiciones[j]==0) {
                                    ImageIcon foto6 = new ImageIcon(getClass().getResource("/images/Bitacoras.png"));
                                    ImageIcon icono6 = new ImageIcon(foto6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
                                    switch(j){
                                        case 0:
                                            Proveedores.setIcon(icono6);
                                            Proveedores.setVisible(true);
                                            prove=i;
                                            posiciones[j]=1;
                                            casos[i]=j;
                                            botones[i]=0;
                                            System.out.println("botones case :"+i+" valor: "+botones[i]);
                                            break;
                                        case 1:
                                            ChatCenter.setIcon(icono6);
                                            ChatCenter.setVisible(true);
                                            chat=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=1;
                                            break;
                                        case 2:
                                            Empleados.setIcon(icono6);
                                            Empleados.setVisible(true);
                                            empleado=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=2;
                                            break;
                                        case 3:
                                            Empresa.setIcon(icono6);
                                            Empresa.setVisible(true);
                                            empresa=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=3;
                                            break;
                                        case 4:
                                            CajaRegistradora.setIcon(icono6);
                                            CajaRegistradora.setVisible(true);
                                            caja=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=4;
                                            break;
                                        case 5:
                                            Inventario.setIcon(icono6);
                                            Inventario.setVisible(true);
                                            invent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=5;
                                            break;
                                        case 6:
                                            Productos.setIcon(icono6);
                                            Productos.setVisible(true); producto=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=6;
                                            break;
                                        case 7:
                                            TipoUsuario1.setIcon(icono6);
                                            TipoUsuario1.setVisible(true);
                                            tipo=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=7;
                                            break;
                                        case 8:
                                            ConstruirEquipo.setIcon(icono6);
                                            ConstruirEquipo.setVisible(true);
                                            construir=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=8;
                                            break;
                                        case 9:
                                            Bitacoras.setIcon(icono6);
                                            Bitacoras.setVisible(true);
                                            bitacor=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=9;
                                            break;
                                        case 10:
                                            Clientes.setIcon(icono6);
                                            Clientes.setVisible(true);
                                            client=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=10;
                                            break;
                                        case 11:
                                            Presupuesto.setIcon(icono6);
                                            Presupuesto.setVisible(true);
                                            presup=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=11;
                                            break;
                                        case 12:
                                            Ventas.setIcon(icono6);
                                            Ventas.setVisible(true);
                                            vent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=12;
                                            break;
                                        case 13:
                                            Ordenes.setIcon(icono6);
                                            Ordenes.setVisible(true);
                                            orde=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=13;
                                            break;
                                    }
                                    break;
                                }
                                
                            }
                            break;
                        case 11:
                            for (int j = 0; j < 14; j++) {
                                System.out.println("j: "+j);
                                if (posiciones[j]==0) {
                                    
                                    ImageIcon foto6 = new ImageIcon(getClass().getResource("/images/Clientes.png"));
                                    ImageIcon icono6 = new ImageIcon(foto6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
                                    switch(j){
                                        case 0:
                                            Proveedores.setIcon(icono6);
                                            Proveedores.setVisible(true);
                                            prove=i;
                                            posiciones[j]=1;
                                            casos[i]=j;
                                            botones[i]=0;
                                            System.out.println("botones case :"+i+" valor: "+botones[i]);
                                            break;
                                        case 1:
                                            ChatCenter.setIcon(icono6);
                                            ChatCenter.setVisible(true);
                                            chat=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=1;
                                            break;
                                        case 2:
                                            Empleados.setIcon(icono6);
                                            Empleados.setVisible(true);
                                            empleado=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=2;
                                            break;
                                        case 3:
                                            Empresa.setIcon(icono6);
                                            Empresa.setVisible(true);
                                            empresa=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=3;
                                            break;
                                        case 4:
                                            CajaRegistradora.setIcon(icono6);
                                            CajaRegistradora.setVisible(true);
                                            caja=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=4;
                                            break;
                                        case 5:
                                            Inventario.setIcon(icono6);
                                            Inventario.setVisible(true);
                                            invent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=5;
                                            break;
                                        case 6:
                                            Productos.setIcon(icono6);
                                            Productos.setVisible(true);
                                            posiciones[j]=1;casos[i]=j; producto=i;
                                            botones[i]=6;
                                            break;
                                        case 7:
                                            TipoUsuario1.setIcon(icono6);
                                            TipoUsuario1.setVisible(true);
                                            tipo=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=7;
                                            break;
                                        case 8:
                                            ConstruirEquipo.setIcon(icono6);
                                            ConstruirEquipo.setVisible(true);
                                            construir=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=8;
                                            break;
                                        case 9:
                                            Bitacoras.setIcon(icono6);
                                            Bitacoras.setVisible(true);
                                            bitacor=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=9;
                                            break;
                                        case 10:
                                            Clientes.setIcon(icono6);
                                            Clientes.setVisible(true);
                                            client=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=10;
                                            break;
                                        case 11:
                                            Presupuesto.setIcon(icono6);
                                            Presupuesto.setVisible(true);
                                            presup=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=11;
                                            break;
                                        case 12:
                                            Ventas.setIcon(icono6);
                                            Ventas.setVisible(true);
                                            vent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=12;
                                            break;
                                        case 13:
                                            Ordenes.setIcon(icono6);
                                            Ordenes.setVisible(true);
                                            orde=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=13;
                                            break;
                                        
                                    }
                                    break;
                                }
                                
                            }
                            break;
                        case 12:
                            for (int j = 0; j < 14; j++) {
                                System.out.println("j: "+j);
                                if (posiciones[j]==0) {
                                    
                                    ImageIcon foto6 = new ImageIcon(getClass().getResource("/images/Proveedores.png"));
                                    ImageIcon icono6 = new ImageIcon(foto6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
                                    switch(j){
                                        case 0:
                                            Proveedores.setIcon(icono6);
                                            Proveedores.setVisible(true);
                                            prove=i;
                                            posiciones[j]=1;
                                            casos[i]=j;
                                            botones[i]=0;
                                            System.out.println("botones case :"+i+" valor: "+botones[i]);
                                            break;
                                        case 1:
                                            ChatCenter.setIcon(icono6);
                                            ChatCenter.setVisible(true);
                                            chat=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=1;
                                            break;
                                        case 2:
                                            Empleados.setIcon(icono6);
                                            Empleados.setVisible(true);
                                            empleado=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=2;
                                            break;
                                        case 3:
                                            Empresa.setIcon(icono6);
                                            Empresa.setVisible(true);
                                            empresa=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=3;
                                            break;
                                        case 4:
                                            CajaRegistradora.setIcon(icono6);
                                            CajaRegistradora.setVisible(true);
                                            caja=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=4;
                                            break;
                                        case 5:
                                            Inventario.setIcon(icono6);
                                            Inventario.setVisible(true);
                                            invent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=5;
                                            break;
                                        case 6:
                                            Productos.setIcon(icono6);
                                            Productos.setVisible(true); producto=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=6;
                                            break;
                                        case 7:
                                            TipoUsuario1.setIcon(icono6);
                                            TipoUsuario1.setVisible(true);
                                            tipo=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=7;
                                            break;
                                        case 8:
                                            ConstruirEquipo.setIcon(icono6);
                                            ConstruirEquipo.setVisible(true);
                                            construir=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=8;
                                            break;
                                        case 9:
                                            Bitacoras.setIcon(icono6);
                                            Bitacoras.setVisible(true);
                                            bitacor=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=9;
                                            break;
                                        case 10:
                                            Clientes.setIcon(icono6);
                                            Clientes.setVisible(true);
                                            client=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=10;
                                            break;
                                        case 11:
                                            Presupuesto.setIcon(icono6);
                                            Presupuesto.setVisible(true);
                                            presup=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=11;
                                            break;
                                        case 12:
                                            Ventas.setIcon(icono6);
                                            Ventas.setVisible(true);
                                            vent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=12;
                                            break;
                                        case 13:
                                            Ordenes.setIcon(icono6);
                                            Ordenes.setVisible(true);
                                            orde=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=13;
                                            break;
                                    }
                                    break;
                                }
                                
                            }
                            break;
                        case 13:
                            for (int j = 0; j < 14; j++) {
                                System.out.println("j: "+j);
                                if (posiciones[j]==0) {
                                    ImageIcon foto6 = new ImageIcon(getClass().getResource("/images/Empleados.png"));
                                    ImageIcon icono6 = new ImageIcon(foto6.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT));
                                    switch(j){
                                       case 0:
                                            Proveedores.setIcon(icono6);
                                            Proveedores.setVisible(true);
                                            prove=i;
                                            posiciones[j]=1;
                                            casos[i]=j;
                                            botones[i]=0;
                                            System.out.println("botones case :"+i+" valor: "+botones[i]);
                                            break;
                                        case 1:
                                            ChatCenter.setIcon(icono6);
                                            ChatCenter.setVisible(true);
                                            chat=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=1;
                                            break;
                                        case 2:
                                            Empleados.setIcon(icono6);
                                            Empleados.setVisible(true);
                                            empleado=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=2;
                                            break;
                                        case 3:
                                            Empresa.setIcon(icono6);
                                            Empresa.setVisible(true);
                                            empresa=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=3;
                                            break;
                                        case 4:
                                            CajaRegistradora.setIcon(icono6);
                                            CajaRegistradora.setVisible(true);
                                            caja=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=4;
                                            break;
                                        case 5:
                                            Inventario.setIcon(icono6);
                                            Inventario.setVisible(true);
                                            invent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=5;
                                            break;
                                        case 6:
                                            Productos.setIcon(icono6);
                                            Productos.setVisible(true); producto=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=6;
                                            break;
                                        case 7:
                                            TipoUsuario1.setIcon(icono6);
                                            TipoUsuario1.setVisible(true);
                                            tipo=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=7;
                                            break;
                                        case 8:
                                            ConstruirEquipo.setIcon(icono6);
                                            ConstruirEquipo.setVisible(true);
                                            construir=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=8;
                                            break;
                                        case 9:
                                            Bitacoras.setIcon(icono6);
                                            Bitacoras.setVisible(true);
                                            bitacor=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=9;
                                            break;
                                        case 10:
                                            Clientes.setIcon(icono6);
                                            Clientes.setVisible(true);
                                            client=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=10;
                                            break;
                                        case 11:
                                            Presupuesto.setIcon(icono6);
                                            Presupuesto.setVisible(true);
                                            presup=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=11;
                                            break;
                                        case 12:
                                            Ventas.setIcon(icono6);
                                            Ventas.setVisible(true);
                                            vent=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=12;
                                            break;
                                        case 13:
                                            Ordenes.setIcon(icono6);
                                            Ordenes.setVisible(true);
                                            orde=i;
                                            posiciones[j]=1;casos[i]=j;
                                            botones[i]=13;
                                            break;
                                    }
                                    break;
                                }
                                
                            }
                            break;
                        default:
                           
                            break;
                    }
 
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        //1
        AnimationClass nombre = new AnimationClass();
        nombre.jLabelXLeft(20, -150,15, 5, jblnombre);
        
        
        
        AnimationClass nombre2 = new AnimationClass();
        nombre2.jLabelXRight(-150, 20,15, 5, jblnombre);
        
        nombre.jLabelXLeft(20, -200,15, 5, tipoUsuario);
        
        nombre2.jLabelXRight(-200, 20,15, 5, tipoUsuario);
        
        AnimationClass apellido = new AnimationClass();
        apellido.jLabelXLeft(20, -150,10, 5, apellido2);
        
        AnimationClass apellidoo = new AnimationClass();
        apellidoo.jLabelXRight(-150, 20,10, 5, apellido2);
        
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
        
        if (condicion==0) {
            condicion=1;
            timer.stop();
        }else if (condicion==1) {
            condicion=0;
            timer.start();
        }
    }//GEN-LAST:event_jLabel1MouseClicked
    int condicion=0;
    int horas, minutos, segundos;
    String minsR,secR;
    Timer timer = new Timer (1000, new ActionListener () 
    { 
        @Override
        public void actionPerformed(ActionEvent e) 
        { 
            Calendar calendario = Calendar.getInstance();
            horas = calendario.get(Calendar.HOUR_OF_DAY);
            minutos = calendario.get(Calendar.MINUTE);
            segundos = calendario.get(Calendar.SECOND);
//            if (minutos<10) {
//                minsR="0"+minutos;
//            }
//            if (segundos<10){
//                secR="0"+segundos;
//            }
            hora.setText(horas + ":" + minutos + ":" + segundos);         
         } 

    }); 
    
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        timer.stop();
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
        if (Proveedores.isVisible()==true) {
            Proveedores.setIcon(definirIconoExit(prove));
        }
    }//GEN-LAST:event_ProveedoresMouseExited

    private void ProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProveedoresMouseClicked
        // TODO add your handling code here:
        definirClick(prove);
        
    }//GEN-LAST:event_ProveedoresMouseClicked

    private void ChatCenterMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChatCenterMouseMoved
        // TODO add your handling code here:
        // ChatCenter.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
    }//GEN-LAST:event_ChatCenterMouseMoved

    private void ChatCenterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChatCenterMouseExited
        // TODO add your handling code here:
//        
        if (ChatCenter.isVisible()==true) {
                    ChatCenter.setIcon(definirIconoExit(chat));
                }
    }//GEN-LAST:event_ChatCenterMouseExited
    
    private void ChatCenterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChatCenterMouseClicked
        // TODO add your handling code here:
        definirClick(chat);
        
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
        if (Proveedores.isVisible()==true) {
            Proveedores.setIcon(definirIconoEnter(prove));
        }
    }//GEN-LAST:event_ProveedoresMouseEntered

    
    private void ChatCenterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChatCenterMouseEntered
        // TODO add your handling code here:
        if (ChatCenter.isVisible()==true) {
            ChatCenter.setIcon(definirIconoEnter(chat));
        }            
    }//GEN-LAST:event_ChatCenterMouseEntered

    private void EmpleadosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpleadosMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpleadosMouseMoved

    private void EmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpleadosMouseClicked
        // TODO add your handling code here:
        definirClick(empleado);
      
    }//GEN-LAST:event_EmpleadosMouseClicked

    private void EmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpleadosMouseEntered
        // TODO add your handling code here:
       if (Empleados.isVisible()==true) {
            Empleados.setIcon(definirIconoEnter(empleado));
        }
    }//GEN-LAST:event_EmpleadosMouseEntered

    private void EmpleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpleadosMouseExited
        // TODO add your handling code here:
       if (Empleados.isVisible()==true) {
            Empleados.setIcon(definirIconoExit(empleado));
        }
    }//GEN-LAST:event_EmpleadosMouseExited

    private void EmpresaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpresaMouseMoved
        // TODO add your handling code here:
        
    }//GEN-LAST:event_EmpresaMouseMoved

    private void EmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpresaMouseClicked
        // TODO add your handling code here:
        definirClick(empresa);
        
        
    }//GEN-LAST:event_EmpresaMouseClicked

    public void definirClick(int label) {
       condicion=0;
        
        switch (label) {
            case 0:
                PanelPrincipal.setVisible(true);
                jLabel2.setVisible(false);
                PInventario inventario = new PInventario(correoE);
                inventario.setSize(680, 500);
                PanelPrincipal.removeAll();
                PanelPrincipal.add(inventario, BorderLayout.CENTER);
                PanelPrincipal.revalidate();
                PanelPrincipal.repaint();
                break;
            case 1:
                PanelPrincipal.setVisible(true);
                jLabel2.setVisible(false);
                PConstruirEquipo tipossss = new PConstruirEquipo();
                tipossss.setSize(680, 500);
                PanelPrincipal.removeAll();
                PanelPrincipal.add(tipossss, BorderLayout.CENTER);
                PanelPrincipal.revalidate();
                PanelPrincipal.repaint();
                break;
            case 2:
                PanelPrincipal.setVisible(true);
                jLabel2.setVisible(false);
                PProductos productos = new PProductos(correoE);
                productos.setSize(680, 500);
                PanelPrincipal.removeAll();
                PanelPrincipal.add(productos, BorderLayout.CENTER);
                PanelPrincipal.revalidate();
                PanelPrincipal.repaint();
                break;
            case 3:
                PanelPrincipal.setVisible(true);
                jLabel2.setVisible(false);
                PPresupuesto press = new PPresupuesto();
                press.setSize(680, 500);
                PanelPrincipal.removeAll();
                PanelPrincipal.add(press, BorderLayout.CENTER);
                PanelPrincipal.revalidate();
                PanelPrincipal.repaint();
                break;
            case 4:
                PanelPrincipal.setVisible(true);
                jLabel2.setVisible(false);
                VerOrdenesCola datos = new VerOrdenesCola(correoE);
                datos.setSize(680, 500);
                PanelPrincipal.removeAll();
                PanelPrincipal.add(datos, BorderLayout.CENTER);
                PanelPrincipal.revalidate();
                PanelPrincipal.repaint();
                break;
            case 5:
                PanelPrincipal.setVisible(true);
                jLabel2.setVisible(false);
                PCajaVirtual cajas = new PCajaVirtual(codigoEmpleado,jblnombre.getText());
                cajas.setSize(680, 500);
                PanelPrincipal.removeAll();
                PanelPrincipal.add(cajas, BorderLayout.CENTER);
                PanelPrincipal.revalidate();
                PanelPrincipal.repaint();
                break;
            case 6:
                PanelPrincipal.setVisible(true);
                jLabel2.setVisible(false);
                PVentas ventass = new PVentas(correoE);
                ventass.setSize(680, 500);
                PanelPrincipal.removeAll();
                PanelPrincipal.add(ventass, BorderLayout.CENTER);
                PanelPrincipal.revalidate();
                PanelPrincipal.repaint();
                break;
            case 7:
//        PanelPrincipal.setVisible(true);
//        jLabel2.setVisible(false);
//        PChatCenter chatcenter = new PChatCenter();
//        chatcenter.setSize(680,500);
//        PanelPrincipal.removeAll();
//        PanelPrincipal.add(chatcenter, BorderLayout.CENTER);
//        PanelPrincipal.revalidate();
//        PanelPrincipal.repaint();
                Runtime obj = Runtime.getRuntime();
                try {
                    obj.exec("F:\\INNOVASYS\\INNOVASYS\\gg.exe");
                } catch (IOException ex) {
                    Logger.getLogger(VentanaPrincipal2.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 8:
                PanelPrincipal.setVisible(true);
                jLabel2.setVisible(false);
                PDatosEmpresa empresas = new PDatosEmpresa();
                empresas.setSize(680, 500);
                PanelPrincipal.removeAll();
                PanelPrincipal.add(empresas, BorderLayout.CENTER);
                PanelPrincipal.revalidate();
                PanelPrincipal.repaint();
                break;

            case 9:
                PanelPrincipal.setVisible(true);
                jLabel2.setVisible(false);
                PTipoUsuario tiposs = new PTipoUsuario(correoE);
                tiposs.setSize(680, 500);
                PanelPrincipal.removeAll();
                PanelPrincipal.add(tiposs, BorderLayout.CENTER);
                PanelPrincipal.revalidate();
                PanelPrincipal.repaint();
                break;
            case 10:
                PanelPrincipal.setVisible(true);
                jLabel2.setVisible(false);
                PGestionarBitacoras tiposss = new PGestionarBitacoras(correoE);
                tiposss.setSize(680, 500);
                PanelPrincipal.removeAll();
                PanelPrincipal.add(tiposss, BorderLayout.CENTER);
                PanelPrincipal.revalidate();
                PanelPrincipal.repaint();
                break;
            case 11:
                PanelPrincipal.setVisible(true);
                jLabel2.setVisible(false);
                PGestionarClientes clientes = new PGestionarClientes(correoE);
                clientes.setSize(680, 500);
                PanelPrincipal.removeAll();
                PanelPrincipal.add(clientes, BorderLayout.CENTER);
                PanelPrincipal.revalidate();
                PanelPrincipal.repaint();
                break;
            case 12:
                PanelPrincipal.setVisible(true);
                jLabel2.setVisible(false);
                PProveedores proveedores = new PProveedores(correoE);
                proveedores.setSize(680, 500);
                PanelPrincipal.removeAll();
                PanelPrincipal.add(proveedores, BorderLayout.CENTER);
                PanelPrincipal.revalidate();
                PanelPrincipal.repaint();
                break;
            case 13:
                PanelPrincipal.setVisible(true);
                jLabel2.setVisible(false);
                PEmpleado empleadoss = new PEmpleado(correoE);
                empleadoss.setSize(680, 500);
                PanelPrincipal.removeAll();
                PanelPrincipal.add(empleadoss, BorderLayout.CENTER);
                PanelPrincipal.revalidate();
                PanelPrincipal.repaint();
                break;
            default:
                System.out.println("i: nada");
                break;
        }
    }
    
    public ImageIcon definirIconoExit(int botonT){

   
            switch (botonT) {
            case 0:
                return icono0;         
            case 1:        
                return icono1;
            case 2:
                return icono2;   
            case 3:
                return icono3;
            case 4:
                return icono4;
            case 5:
               return icono5;
            case 6:
                return icono6;
            case 7:
                return icono7;
            case 8:
                return icono8;
            case 9:
                return icono9;
            case 10:
                return icono10;
            case 11:
                return icono11;
            case 12:
                return icono12;
            case 13:
                return icono13;
            default:
                System.out.println("i: nada");
                break;
            }

        return null;
    }
    
    public ImageIcon definirIconoEnter(int botonT){

           
                
            switch (botonT) {
            case 0:
                return icono0s;         
            case 1:        
                return icono1s;
            case 2:
                return icono2s;   
            case 3:
                return icono3s;
            case 4:
                return icono4s;
            case 5:
               return icono5s;
            case 6:
                return icono6s;
            case 7:
                return icono7s;
            case 8:
                return icono8s;
            case 9:
                return icono9s;
            case 10:
                return icono10s;
            case 11:
                return icono11s;
            case 12:
                return icono12s;
            case 13:
                return icono13s;
            default:
                System.out.println("i: nada");
                break;
            }
            
        return null;
    }
    
    
    private void EmpresaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpresaMouseEntered
        // TODO add your handling code here:
      if (Empresa.isVisible()==true) {  
              Empresa.setIcon(definirIconoEnter(empresa));
          }
    }//GEN-LAST:event_EmpresaMouseEntered

    private void EmpresaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpresaMouseExited
        // TODO add your handling code here:
       if (Empresa.isVisible()==true) {

              Empresa.setIcon(definirIconoExit(empresa));
          }

    }//GEN-LAST:event_EmpresaMouseExited

    private void CajaRegistradoraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CajaRegistradoraMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_CajaRegistradoraMouseMoved

    private void CajaRegistradoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CajaRegistradoraMouseClicked
        // TODO add your handling code here
       definirClick(caja);
        

        
    }//GEN-LAST:event_CajaRegistradoraMouseClicked

    private void CajaRegistradoraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CajaRegistradoraMouseEntered
        // TODO add your handling code here:
       if (CajaRegistradora.isVisible()==true) {
 
              CajaRegistradora.setIcon(definirIconoEnter(caja));
          }
      
    }//GEN-LAST:event_CajaRegistradoraMouseEntered

    private void CajaRegistradoraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CajaRegistradoraMouseExited
        // TODO add your handling code here:
     if (CajaRegistradora.isVisible()==true) {

              CajaRegistradora.setIcon(definirIconoExit(caja));
          }
   
    }//GEN-LAST:event_CajaRegistradoraMouseExited

    private void InventarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventarioMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_InventarioMouseMoved

    private void InventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventarioMouseClicked
        // TODO add your handling code here:
        definirClick(invent);
    }//GEN-LAST:event_InventarioMouseClicked

    private void InventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventarioMouseEntered
        // TODO add your handling code here:
        if (Inventario.isVisible()==true) {

              Inventario.setIcon(definirIconoEnter(invent));
          }

    }//GEN-LAST:event_InventarioMouseEntered

    private void InventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventarioMouseExited
        // TODO add your handling code here:
       if (Inventario.isVisible()==true) {

              Inventario.setIcon(definirIconoExit(invent));
          }

    }//GEN-LAST:event_InventarioMouseExited

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

    private void ProductosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductosMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductosMouseMoved

    private void ProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductosMouseClicked
        // TODO add your handling code here:
        definirClick(producto);
    }//GEN-LAST:event_ProductosMouseClicked

    private void ProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductosMouseExited
        // TODO add your handling code here:
       if (Productos.isVisible()==true) {
  
              Productos.setIcon(definirIconoExit(producto));
         
      }
    }//GEN-LAST:event_ProductosMouseExited

    private void ProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductosMouseEntered
        // TODO add your handling code here:
       if (Productos.isVisible()==true) {

              Productos.setIcon(definirIconoEnter(producto));
          
      }
    }//GEN-LAST:event_ProductosMouseEntered

    private void TipoUsuario1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TipoUsuario1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoUsuario1MouseMoved

    private void TipoUsuario1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TipoUsuario1MouseClicked
        // TODO add your handling code here:
        definirClick(tipo);
    }//GEN-LAST:event_TipoUsuario1MouseClicked

    private void TipoUsuario1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TipoUsuario1MouseExited
        // TODO add your handling code here:
       if (TipoUsuario1.isVisible()==true) {
 
              TipoUsuario1.setIcon(definirIconoExit(tipo));
          }

    }//GEN-LAST:event_TipoUsuario1MouseExited

    private void TipoUsuario1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TipoUsuario1MouseEntered
        // TODO add your handling code here:
       if (TipoUsuario1.isVisible()==true) {
     
              TipoUsuario1.setIcon(definirIconoEnter(tipo));
          
      }
    }//GEN-LAST:event_TipoUsuario1MouseEntered

    private void ConstruirEquipoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConstruirEquipoMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_ConstruirEquipoMouseMoved

    private void ConstruirEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConstruirEquipoMouseClicked
        // TODO add your handling code here:
        definirClick(construir);
    }//GEN-LAST:event_ConstruirEquipoMouseClicked

    private void ConstruirEquipoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConstruirEquipoMouseEntered
        // TODO add your handling code here:
        if (ConstruirEquipo.isVisible()==true) {
     
              ConstruirEquipo.setIcon(definirIconoEnter(construir));
          }
      
    }//GEN-LAST:event_ConstruirEquipoMouseEntered

    private void ConstruirEquipoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConstruirEquipoMouseExited
        // TODO add your handling code here:
        if (ConstruirEquipo.isVisible()==true) {
         
              ConstruirEquipo.setIcon(definirIconoExit(construir));
          }
      
    }//GEN-LAST:event_ConstruirEquipoMouseExited

    private void BitacorasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BitacorasMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_BitacorasMouseMoved

    private void BitacorasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BitacorasMouseClicked
        // TODO add your handling code here:
        definirClick(bitacor);
    }//GEN-LAST:event_BitacorasMouseClicked

    private void BitacorasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BitacorasMouseEntered
        // TODO add your handling code here:
       if (Bitacoras.isVisible()==true) {
          
              Bitacoras.setIcon(definirIconoEnter(bitacor));
          }
      
    }//GEN-LAST:event_BitacorasMouseEntered

    private void BitacorasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BitacorasMouseExited
        // TODO add your handling code here:
      if (Bitacoras.isVisible()==true) {
     
              Bitacoras.setIcon(definirIconoExit(bitacor));
          }
   
    }//GEN-LAST:event_BitacorasMouseExited

    private void ClientesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_ClientesMouseMoved
    int xx, xy;
    private void ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesMouseClicked
        // TODO add your handling code here:
        definirClick(client);
    }//GEN-LAST:event_ClientesMouseClicked

    private void ClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesMouseEntered
        // TODO add your handling code here:
       if (Clientes.isVisible()==true) {
        
              Clientes.setIcon(definirIconoEnter(client));
          }
     
    }//GEN-LAST:event_ClientesMouseEntered

    private void ClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesMouseExited
        // TODO add your handling code here:
     if (Clientes.isVisible()==true) {
          
              Clientes.setIcon(definirIconoExit(client));
          }
      
        
    }//GEN-LAST:event_ClientesMouseExited

    private void PresupuestoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PresupuestoMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_PresupuestoMouseMoved

    private void PresupuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PresupuestoMouseClicked
        // TODO add your handling code here:
        definirClick(presup);
    }//GEN-LAST:event_PresupuestoMouseClicked

    private void PresupuestoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PresupuestoMouseEntered
        // TODO add your handling code here:
       if (Presupuesto.isVisible()==true) {
         
              Presupuesto.setIcon(definirIconoEnter(presup));
          }
    
    }//GEN-LAST:event_PresupuestoMouseEntered

    private void PresupuestoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PresupuestoMouseExited
        // TODO add your handling code here:
       if (Presupuesto.isVisible()==true) {
        
              Presupuesto.setIcon(definirIconoExit(presup));
          }
    
    }//GEN-LAST:event_PresupuestoMouseExited

    private void VentasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_VentasMouseMoved

    private void VentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasMouseClicked
        // TODO add your handling code here:
        definirClick(vent);
    }//GEN-LAST:event_VentasMouseClicked

    private void VentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasMouseEntered
        // TODO add your handling code here:
       if (Ventas.isVisible()==true) {
         
              Ventas.setIcon(definirIconoEnter(vent));
          }
   
    }//GEN-LAST:event_VentasMouseEntered

    private void VentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasMouseExited
        // TODO add your handling code here:
       if (Ventas.isVisible()==true) {
      
              Ventas.setIcon(definirIconoExit(vent));
 
        }
    }//GEN-LAST:event_VentasMouseExited

    private void OrdenesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrdenesMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_OrdenesMouseMoved

    private void OrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrdenesMouseClicked
        // TODO add your handling code here:
        definirClick(orde);
    }//GEN-LAST:event_OrdenesMouseClicked

    private void OrdenesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrdenesMouseEntered
        // TODO add your handling code here:
        if (Ordenes.isVisible()==true) {
         
              Ordenes.setIcon(definirIconoEnter(orde));
         
      }
    }//GEN-LAST:event_OrdenesMouseEntered

    
    private void OrdenesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrdenesMouseExited
        // TODO add your handling code here:
     if (Ordenes.isVisible()==true) {
          
              Ordenes.setIcon(definirIconoExit(orde));
      
      }
       
    }//GEN-LAST:event_OrdenesMouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        for (int i = 0; i <botones.length; i++) {
            
                System.out.println("boton: "+i+" valor: "+botones[i]);
            
            
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        setOpacity((float)0.8);
        xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseReleased
        // TODO add your handling code here:
        setOpacity((float)1.0);
    }//GEN-LAST:event_jPanel2MouseReleased

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel1MouseReleased
    
    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel1MouseDragged

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
                if ("Windows".equals(info.getName())) {
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
                new VentanaPrincipal2("stevenbdf@gmail.com").setVisible(true);
                
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
    private javax.swing.JLabel tipoUsuario;
    // End of variables declaration//GEN-END:variables
}
