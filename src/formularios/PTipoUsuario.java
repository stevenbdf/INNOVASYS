/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formularios;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import clases.*;
import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author steven
 */
public class PTipoUsuario extends javax.swing.JPanel {

    /** Creates new form PTipoUsuario */
    verificaciones verificar = new verificaciones();
    Conexion con = new Conexion();
    DefaultTableModel modeloTablaPrivilegios;
    Conexion cn = new Conexion();
    String CodigoPrivilegios="", CodigoTipos="";
    int confirmacion=0;
    DefaultComboBoxModel modeloCombo;
    DefaultTableModel modeloTablaTipos;
    String correo;
    public PTipoUsuario(String correoE) {
        modeloTablaPrivilegios= new DefaultTableModel(null, getColumnasPrivilegios());setFilasPrivilegios(0);
        modeloTablaTipos = new DefaultTableModel(null, getColumnasTipos());setFilasTipos(0,"");
//        try {
//                     UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//		}
//		catch (Exception e) {
//		}
        modeloCombo = new DefaultComboBoxModel(new String[]{});
        initComponents();
        correo=correoE;
        ImageIcon foto0 = new ImageIcon (getClass().getResource("/images/help.png"));
       ImageIcon icono0 = new ImageIcon(foto0.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
       lblhelp.setIcon(icono0);
       ImageIcon foto00 = new ImageIcon (getClass().getResource("/images/help.png"));
       ImageIcon icono00 = new ImageIcon(foto00.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
       lblhelp1.setIcon(icono00);
       
        llenaComboBox();
        jTFBuscarT.setEnabled(false);
        
        //logo de ayuda
        ImageIcon foto = new ImageIcon (getClass().getResource("/images/help.png"));
        ImageIcon icono = new ImageIcon(foto.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
        lblhelp.setIcon(icono);
        ImageIcon foto2 = new ImageIcon (getClass().getResource("/images/help.png"));
        ImageIcon icono2 = new ImageIcon(foto.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
        lblhelp1.setIcon(icono2);
    }
    private void llenaComboBox() {
        modeloCombo.removeAllElements();
        try {

            /* Realizamos la consulta a la base de datos*/
            String sql = "SELECT idPrivilegio FROM privilegio";
            PreparedStatement verDatos = con.conectar().prepareStatement(sql);
            ResultSet ver = verDatos.executeQuery();
            while (ver.next()) {

                modeloCombo.addElement(ver.getObject("idPrivilegio"));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);

        }
    }
    private String[] getColumnasPrivilegios() {
        String columnas[] = new String[]{"CODIGO"};
        return columnas;
    }
    
    private String[] getColumnasTipos() {
        String columnas[] = new String[]{"CODIGO","NOMBRE","PRIVILEGIO"};
        return columnas;
    }

    private void setFilasPrivilegios(int datos2) {
        try {
            String sql = "";
            if (datos2 == 0) {
                sql = "SELECT idPrivilegio FROM privilegio";
            } else {
                sql = "SELECT idPrivilegio FROM privilegio WHERE idPrivilegio=" + datos2;
            }
            PreparedStatement us = cn.conectar().prepareStatement(sql);
            ResultSet resultado = us.executeQuery();

            Object datos[] = new Object[1];

            while (resultado.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = resultado.getObject(i + 1);
                }
                modeloTablaPrivilegios.addRow(datos);
            }
        } catch (Exception e) {
        }
    }
    
    private void setFilasTipos(int datos1, String datos2) {
        try {
            String sql = "";
            switch (datos1) {
                case 0:
                    sql = "SELECT idTipo,nombreTipo,idPrivilegio FROM tipoUsuario";
                    break;
                case 1:
                    sql = "SELECT idTipo,nombreTipo,idPrivilegio FROM tipoUsuario WHERE nombreTipo like '"+datos2+"%'";
                    break;
                case 2:
                    sql = "SELECT idTipo,nombreTipo,idPrivilegio FROM tipoUsuario WHERE idTipo like '"+datos2+"%'";
                    break;
                default:
                    break;
            }
            PreparedStatement us = cn.conectar().prepareStatement(sql);
            ResultSet resultado = us.executeQuery();

            Object datos[] = new Object[3];

            while (resultado.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = resultado.getObject(i + 1);
                }
                modeloTablaTipos.addRow(datos);
            }
        } catch (Exception e) {
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblCodigoTipo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAgregarT = new javax.swing.JButton();
        btnEliminarT = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTFNombreTipo = new javax.swing.JTextField();
        rdNombre = new javax.swing.JRadioButton();
        rdCodigo = new javax.swing.JRadioButton();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTFBuscarT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbPrivilegios = new javax.swing.JComboBox<>();
        btnModificarT = new javax.swing.JButton();
        lblhelp1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        cbInventario = new javax.swing.JCheckBox();
        cbConstruirEquipo = new javax.swing.JCheckBox();
        cbProductos = new javax.swing.JCheckBox();
        cbSolicitarAyuda = new javax.swing.JCheckBox();
        cbOrdenesCola = new javax.swing.JCheckBox();
        cbCajaRegistradora = new javax.swing.JCheckBox();
        cbVentas = new javax.swing.JCheckBox();
        cbChatCenter = new javax.swing.JCheckBox();
        cbDatosEmpresa = new javax.swing.JCheckBox();
        cbGestionarVentas = new javax.swing.JCheckBox();
        cbBitacoras = new javax.swing.JCheckBox();
        cbClientes = new javax.swing.JCheckBox();
        cbProveedores = new javax.swing.JCheckBox();
        cbEmpleados = new javax.swing.JCheckBox();
        cbGestionarProductos = new javax.swing.JCheckBox();
        cbGestionarInventario = new javax.swing.JCheckBox();
        btnAgregarP = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTFBuscarT1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnModificarP = new javax.swing.JButton();
        lblCodigoPrivilegio = new javax.swing.JLabel();
        btnEliminarP = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        lblhelp = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(30, 57, 42));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 196, 124), 3));

        jPanel1.setBackground(new java.awt.Color(30, 57, 42));

        jPanel2.setBackground(new java.awt.Color(60, 196, 124));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(680, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCodigoTipo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCodigoTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoTipo.setText("CODIGO TIPO");
        jPanel2.add(lblCodigoTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 20));

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(modeloTablaTipos);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 260, 180));

        btnAgregarT.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAgregarT.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarT.setText("Agregar");
        btnAgregarT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnAgregarT.setContentAreaFilled(false);
        btnAgregarT.setPreferredSize(new java.awt.Dimension(71, 30));
        btnAgregarT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarTMouseExited(evt);
            }
        });
        btnAgregarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        btnEliminarT.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEliminarT.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarT.setText("Eliminar");
        btnEliminarT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnEliminarT.setContentAreaFilled(false);
        btnEliminarT.setPreferredSize(new java.awt.Dimension(75, 30));
        btnEliminarT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarTMouseExited(evt);
            }
        });
        jPanel2.add(btnEliminarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Buscar:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        jTFNombreTipo.setBackground(new java.awt.Color(204, 204, 204));
        jTFNombreTipo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFNombreTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFNombreTipoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreTipoKeyTyped(evt);
            }
        });
        jPanel2.add(jTFNombreTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 160, 30));

        rdNombre.setBackground(new java.awt.Color(102, 102, 102));
        rdNombre.setForeground(new java.awt.Color(255, 255, 255));
        rdNombre.setText("Nombre");
        rdNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNombreActionPerformed(evt);
            }
        });
        jPanel2.add(rdNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, 30));

        rdCodigo.setBackground(new java.awt.Color(102, 102, 102));
        rdCodigo.setForeground(new java.awt.Color(255, 255, 255));
        rdCodigo.setText("Codigo");
        rdCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdCodigoMouseClicked(evt);
            }
        });
        jPanel2.add(rdCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, 30));

        jButton6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Generar Reporte");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton6.setContentAreaFilled(false);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, -1, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        jTFBuscarT.setBackground(new java.awt.Color(204, 204, 204));
        jTFBuscarT.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFBuscarT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBuscarTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFBuscarTKeyTyped(evt);
            }
        });
        jPanel2.add(jTFBuscarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 80, 30));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Privilegios:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nombre Tipo:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        cmbPrivilegios.setModel(modeloCombo   );
        jPanel2.add(cmbPrivilegios, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 160, 30));

        btnModificarT.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnModificarT.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarT.setText("Modificar");
        btnModificarT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnModificarT.setContentAreaFilled(false);
        btnModificarT.setPreferredSize(new java.awt.Dimension(75, 30));
        btnModificarT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarTMouseExited(evt);
            }
        });
        btnModificarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarTActionPerformed(evt);
            }
        });
        btnModificarT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnModificarTKeyPressed(evt);
            }
        });
        jPanel2.add(btnModificarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        lblhelp1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblhelp1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lblhelp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblhelp1MouseClicked(evt);
            }
        });
        jPanel2.add(lblhelp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 25, 25));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 669, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gestionar Tipos de Usuario", jPanel1);

        jPanel4.setBackground(new java.awt.Color(30, 57, 42));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(30, 57, 42));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione los privilegios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbInventario.setBackground(new java.awt.Color(102, 102, 102));
        cbInventario.setForeground(new java.awt.Color(255, 255, 255));
        cbInventario.setText("Ver Inventario");
        cbInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInventarioActionPerformed(evt);
            }
        });
        jPanel5.add(cbInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        cbConstruirEquipo.setBackground(new java.awt.Color(102, 102, 102));
        cbConstruirEquipo.setForeground(new java.awt.Color(255, 255, 255));
        cbConstruirEquipo.setText("Construir Equipo");
        jPanel5.add(cbConstruirEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        cbProductos.setBackground(new java.awt.Color(102, 102, 102));
        cbProductos.setForeground(new java.awt.Color(255, 255, 255));
        cbProductos.setText("Ver Productos");
        jPanel5.add(cbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        cbSolicitarAyuda.setBackground(new java.awt.Color(102, 102, 102));
        cbSolicitarAyuda.setForeground(new java.awt.Color(255, 255, 255));
        cbSolicitarAyuda.setText("Crear Presupuesto");
        jPanel5.add(cbSolicitarAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        cbOrdenesCola.setBackground(new java.awt.Color(102, 102, 102));
        cbOrdenesCola.setForeground(new java.awt.Color(255, 255, 255));
        cbOrdenesCola.setText("Ordenes en Cola");
        jPanel5.add(cbOrdenesCola, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        cbCajaRegistradora.setBackground(new java.awt.Color(102, 102, 102));
        cbCajaRegistradora.setForeground(new java.awt.Color(255, 255, 255));
        cbCajaRegistradora.setText("Gestionar Caja Virtual");
        cbCajaRegistradora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCajaRegistradoraActionPerformed(evt);
            }
        });
        jPanel5.add(cbCajaRegistradora, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        cbVentas.setBackground(new java.awt.Color(102, 102, 102));
        cbVentas.setForeground(new java.awt.Color(255, 255, 255));
        cbVentas.setText("Ver ventas");
        jPanel5.add(cbVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        cbChatCenter.setBackground(new java.awt.Color(102, 102, 102));
        cbChatCenter.setForeground(new java.awt.Color(255, 255, 255));
        cbChatCenter.setText("Chat Center");
        jPanel5.add(cbChatCenter, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        cbDatosEmpresa.setBackground(new java.awt.Color(102, 102, 102));
        cbDatosEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        cbDatosEmpresa.setText("Cambiar Datos Empresa");
        jPanel5.add(cbDatosEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        cbGestionarVentas.setBackground(new java.awt.Color(102, 102, 102));
        cbGestionarVentas.setForeground(new java.awt.Color(255, 255, 255));
        cbGestionarVentas.setText("Gestionar Ventas");
        jPanel5.add(cbGestionarVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        cbBitacoras.setBackground(new java.awt.Color(102, 102, 102));
        cbBitacoras.setForeground(new java.awt.Color(255, 255, 255));
        cbBitacoras.setText("Gestionar Bitacoras");
        jPanel5.add(cbBitacoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        cbClientes.setBackground(new java.awt.Color(102, 102, 102));
        cbClientes.setForeground(new java.awt.Color(255, 255, 255));
        cbClientes.setText("Gestionar Clientes");
        jPanel5.add(cbClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        cbProveedores.setBackground(new java.awt.Color(102, 102, 102));
        cbProveedores.setForeground(new java.awt.Color(255, 255, 255));
        cbProveedores.setText("Gestionar Proveedores");
        jPanel5.add(cbProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        cbEmpleados.setBackground(new java.awt.Color(102, 102, 102));
        cbEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        cbEmpleados.setText("Gestionar Empleados");
        jPanel5.add(cbEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        cbGestionarProductos.setBackground(new java.awt.Color(102, 102, 102));
        cbGestionarProductos.setForeground(new java.awt.Color(255, 255, 255));
        cbGestionarProductos.setText("Gestionar Productos");
        jPanel5.add(cbGestionarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        cbGestionarInventario.setBackground(new java.awt.Color(102, 102, 102));
        cbGestionarInventario.setForeground(new java.awt.Color(255, 255, 255));
        cbGestionarInventario.setText("Gestionar Inventario");
        cbGestionarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGestionarInventarioActionPerformed(evt);
            }
        });
        jPanel5.add(cbGestionarInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, -1, -1));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, 370, 320));

        btnAgregarP.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAgregarP.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarP.setText("Agregar");
        btnAgregarP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnAgregarP.setContentAreaFilled(false);
        btnAgregarP.setPreferredSize(new java.awt.Dimension(71, 30));
        btnAgregarP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarPMouseExited(evt);
            }
        });
        jPanel4.add(btnAgregarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        jTable2.setBackground(new java.awt.Color(204, 204, 204));
        jTable2.setModel(modeloTablaPrivilegios);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 260, 150));

        jTFBuscarT1.setBackground(new java.awt.Color(204, 204, 204));
        jTFBuscarT1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFBuscarT1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBuscarT1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFBuscarT1KeyTyped(evt);
            }
        });
        jPanel4.add(jTFBuscarT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 80, 30));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Buscar:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        btnModificarP.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnModificarP.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarP.setText("Modificar");
        btnModificarP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnModificarP.setContentAreaFilled(false);
        btnModificarP.setPreferredSize(new java.awt.Dimension(75, 30));
        btnModificarP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarPMouseExited(evt);
            }
        });
        jPanel4.add(btnModificarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, -1, -1));

        lblCodigoPrivilegio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCodigoPrivilegio.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoPrivilegio.setText("CODIGO PRIVILEGIO");
        jPanel4.add(lblCodigoPrivilegio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

        btnEliminarP.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEliminarP.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarP.setText("Eliminar");
        btnEliminarP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnEliminarP.setContentAreaFilled(false);
        btnEliminarP.setPreferredSize(new java.awt.Dimension(75, 30));
        btnEliminarP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarPMouseExited(evt);
            }
        });
        jPanel4.add(btnEliminarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, -1));

        btnLimpiar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar Campos");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setPreferredSize(new java.awt.Dimension(75, 30));
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseExited(evt);
            }
        });
        jPanel4.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 110, -1));

        lblhelp.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblhelpAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lblhelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblhelpMouseClicked(evt);
            }
        });
        jPanel4.add(lblhelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 25, 25));

        jTabbedPane1.addTab("Gestionar Privilegios", jPanel4);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.hide();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
         jButton6.setContentAreaFilled(true);
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        // TODO add your handling code here:
         jButton6.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton6MouseExited

    private void btnAgregarTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarTMouseEntered
        // TODO add your handling code here:
         btnAgregarT.setContentAreaFilled(true);
    }//GEN-LAST:event_btnAgregarTMouseEntered

    private void btnAgregarTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarTMouseExited
        // TODO add your handling code here:
         btnAgregarT.setContentAreaFilled(false);
    }//GEN-LAST:event_btnAgregarTMouseExited

    private void btnEliminarTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarTMouseEntered
        // TODO add your handling code here:
         btnEliminarT.setContentAreaFilled(true);
    }//GEN-LAST:event_btnEliminarTMouseEntered

    private void btnEliminarTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarTMouseExited
        // TODO add your handling code here:
         btnEliminarT.setContentAreaFilled(false);
    }//GEN-LAST:event_btnEliminarTMouseExited

    private void btnAgregarPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarPMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarPMouseEntered

    private void btnAgregarPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarPMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarPMouseExited

    private void btnEliminarPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarPMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarPMouseEntered

    private void btnEliminarPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarPMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarPMouseExited

    private void btnModificarTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarTMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarTMouseEntered

    private void btnModificarTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarTMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarTMouseExited

    private void btnModificarPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarPMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarPMouseEntered

    private void btnModificarPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarPMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarPMouseExited

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        CodigoPrivilegios=String.valueOf(modeloTablaPrivilegios.getValueAt(jTable2.getSelectedRow(), 0));
        lblCodigoPrivilegio.setText("CODIGO PRIVILEGIO: "+CodigoPrivilegios);
        mtoTipoUsuarios objeto = new mtoTipoUsuarios();
        objeto.setCodigoP(Integer.valueOf(CodigoPrivilegios));
        Boolean[] valores = objeto.consultarPrivilegio();
        //Integer[] valores2 = new Integer[jPanel5.getComponentCount()];
        for (int x = 0; x < jPanel5.getComponentCount(); x++) {
            if (jPanel5.getComponent(x) instanceof JCheckBox) {
                JCheckBox check = (JCheckBox) jPanel5.getComponent(x);
                check.setSelected(valores[x]);
            }
        }

    }//GEN-LAST:event_jTable2MouseClicked
   
    private void btnAgregarPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarPMouseClicked
        // TODO add your handling code here:
        //Eliminar y volver a agregar todos los checkbox en orde de base de datos o hacer algo parecido ORDEN!
        Integer[] valores = new Integer[jPanel5.getComponentCount()];
        for (int x = 0; x < jPanel5.getComponentCount(); x++) {
            if (jPanel5.getComponent(x) instanceof JCheckBox) {
                JCheckBox check = (JCheckBox) jPanel5.getComponent(x);
                if (check.isSelected()) {
                    //System.out.println(check.getText());
                    valores[x] = 1;
                    confirmacion=1;
                } else {
                    valores[x] = 0;
                }
            }
        }
        if (confirmacion != 0) {
            mtoTipoUsuarios objeto = new mtoTipoUsuarios();
            if (objeto.guardarPrivilegio(valores)) {
                JOptionPane.showMessageDialog(this, "Privilegio guardado correctamente");
            }else {
                JOptionPane.showMessageDialog(this, "Error al guardar datos");
            }
            int filas = modeloTablaPrivilegios.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaPrivilegios.removeRow(0);
            }
            setFilasPrivilegios(0);
            confirmacion=0;
        } else {
            JOptionPane.showMessageDialog(this, "Error tiene que seleccionar al menos un privilegio");
        }
        
                    
    }//GEN-LAST:event_btnAgregarPMouseClicked

    private void cbCajaRegistradoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCajaRegistradoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCajaRegistradoraActionPerformed
    
    private void btnModificarPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarPMouseClicked
        // TODO add your handling code here:
        Integer[] valores = new Integer[jPanel5.getComponentCount()];
        for (int x = 0; x < jPanel5.getComponentCount(); x++) {

            if (jPanel5.getComponent(x) instanceof JCheckBox) {
                JCheckBox check = (JCheckBox) jPanel5.getComponent(x);
                if (check.isSelected()) {
                    //System.out.println(check.getText());
                    valores[x] = 1;
                    confirmacion = 1;
                } else {
                    valores[x] = 0;
                }
            }
        }
        if (confirmacion != 0) {
            mtoTipoUsuarios objeto = new mtoTipoUsuarios();
            if (objeto.modificarPrivilegio(valores, Integer.valueOf(CodigoPrivilegios))) {
                JOptionPane.showMessageDialog(this, "Privilegio modificado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar datos");
            }
            int filas = modeloTablaPrivilegios.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaPrivilegios.removeRow(0);
            }
            setFilasPrivilegios(0);
            confirmacion = 0;
        } else {
            JOptionPane.showMessageDialog(this, "Error tiene que seleccionar al menos un privilegio");
        }
    }//GEN-LAST:event_btnModificarPMouseClicked

    private void btnEliminarPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarPMouseClicked
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar este privilegio?", "Confirmacion",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION || response == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(this, "Privilegio no eliminado");
        } else {
            if (lblCodigoPrivilegio.getText().equals("CODIGO PRIVILEGIO")) {
                JOptionPane.showMessageDialog(this, "No ha seleccionado ningun privilegio para eliminar");
            } else {
                mtoTipoUsuarios objeto = new mtoTipoUsuarios();
                objeto.setCodigoP(Integer.valueOf(CodigoPrivilegios));
                if (objeto.eliminarPrivilegio()) {
                    JOptionPane.showMessageDialog(this, "Privilegio eliminado correctamente");
                    lblCodigoPrivilegio.setText("CODIGO PRIVILEGIO");
                    int filas = modeloTablaPrivilegios.getRowCount();
                    for (int i = 0; filas > i; i++) {
                        modeloTablaPrivilegios.removeRow(0);
                    }
                    setFilasPrivilegios(0);
                    for (int x = 0; x < jPanel5.getComponentCount(); x++) {
                        if (jPanel5.getComponent(x) instanceof JCheckBox) {
                            JCheckBox check = (JCheckBox) jPanel5.getComponent(x);
                            if (check.isSelected()) {
                                check.setSelected(false);
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Error existen tipos de usuario relacionados a este Privilegio. \n Elimina o modifica antes a los tipo usuarios relacionados para poder eliminar este privilegio.");
                }
            }
        }
    }//GEN-LAST:event_btnEliminarPMouseClicked

    private void jTFBuscarT1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarT1KeyReleased
        // TODO add your handling code here:
        try {
            int filas = modeloTablaPrivilegios.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaPrivilegios.removeRow(0);
            }
            setFilasPrivilegios(Integer.valueOf(jTFBuscarT1.getText()));
        } catch (Exception e) {
            int filas = modeloTablaPrivilegios.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaPrivilegios.removeRow(0);
            }
            setFilasPrivilegios(0);
        }    
    }//GEN-LAST:event_jTFBuscarT1KeyReleased

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        // TODO add your handling code here:
        for (int x = 0; x < jPanel5.getComponentCount(); x++) {
            if (jPanel5.getComponent(x) instanceof JCheckBox) {
                JCheckBox check = (JCheckBox) jPanel5.getComponent(x);
                if (check.isSelected()) {
                    check.setSelected(false);
                }
            }
        }
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarMouseEntered

    private void btnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarMouseExited

    private void btnAgregarTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarTMouseClicked
        // TODO add your handling code here:
        if (jTFNombreTipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Error campos vacios");
        }else{
            mtoTipoUsuarios objeto = new mtoTipoUsuarios();
            objeto.setNombreT(jTFNombreTipo.getText());
            String codigo=String.valueOf(cmbPrivilegios.getSelectedItem());
            objeto.setCodigoP(Integer.valueOf(Integer.valueOf(codigo)));
            if (objeto.guardarTipo()) {
                JOptionPane.showMessageDialog(this,"Tipo Usuario guardado correctamente");
                jTFNombreTipo.setText(null);
                int filas = modeloTablaTipos.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaTipos.removeRow(0);
                }
                setFilasTipos(0,"");
            }else{
                JOptionPane.showMessageDialog(this,"Error ya existe un tipo de usuario con ese nombre");
            }
        }
    }//GEN-LAST:event_btnAgregarTMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        CodigoTipos=String.valueOf(modeloTablaTipos.getValueAt(jTable1.getSelectedRow(), 0));
        lblCodigoTipo.setText("CODIGO PRIVILEGIO: "+CodigoTipos);
        mtoTipoUsuarios objeto = new mtoTipoUsuarios();
        objeto.setCodigoT(Integer.valueOf(CodigoTipos));
        jTFNombreTipo.setText(String.valueOf(modeloTablaTipos.getValueAt(jTable1.getSelectedRow(), 1)));
        cmbPrivilegios.setSelectedItem(modeloTablaTipos.getValueAt(jTable1.getSelectedRow(), 2));
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnModificarTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarTMouseClicked
        // TODO add your handling code here:
        if (jTFNombreTipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Error campos vacios");
        }else{
            mtoTipoUsuarios objeto = new mtoTipoUsuarios();
            objeto.setNombreT(jTFNombreTipo.getText());
            String codigo=String.valueOf(cmbPrivilegios.getSelectedItem());
            objeto.setCodigoP(Integer.valueOf(Integer.valueOf(codigo)));
            objeto.setCodigoT(Integer.valueOf(CodigoTipos));
            if (objeto.modificarTipo()) {
                
                JOptionPane.showMessageDialog(this,"Tipo Usuario modificado correctamente");
                jTFNombreTipo.setText(null);
                int filas = modeloTablaTipos.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaTipos.removeRow(0);
                }
                setFilasTipos(0,"");
            }else{
                JOptionPane.showMessageDialog(this, "Modifique algun dato para realizar esta accion");
            }
        }
    }//GEN-LAST:event_btnModificarTMouseClicked

    private void btnEliminarTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarTMouseClicked
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar este tipo de usuario?", "Confirmacion",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION || response == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(this, "Tipo de Usuario  no eliminado");
        } else {
            if (lblCodigoPrivilegio.getText().equals("CODIGO TIPO") || lblCodigoPrivilegio.getText().equals("CODIGO TIPO: ")) {
                    JOptionPane.showMessageDialog(this,"No ha seleccionado ningun tipo de usuario para eliminar");
            } else {
                mtoTipoUsuarios objeto = new mtoTipoUsuarios();
                objeto.setCodigoT(Integer.valueOf(CodigoTipos));
                if (objeto.eliminarTipo()) {
                    JOptionPane.showMessageDialog(this, "Tipo de usuario eliminado correctamente");
                    lblCodigoPrivilegio.setText("CODIGO TIPO");
                    jTFNombreTipo.setText(null);
                    int filas = modeloTablaTipos.getRowCount();
                    for (int i = 0; filas > i; i++) {
                        modeloTablaTipos.removeRow(0);
                    }
                    setFilasTipos(0,"");
                } else {
                    JOptionPane.showMessageDialog(this, "Error existen usuarios relacionados a este tipo de usuario. \n Elimina o modifica antes a los usuarios relacionados para poder eliminar este tipo de usuario.");
                }
            }
        }    
    }//GEN-LAST:event_btnEliminarTMouseClicked

    private void rdNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNombreActionPerformed
        // TODO add your handling code here:
        rdCodigo.setSelected(false);
        jTFBuscarT.setEnabled(true);   
    }//GEN-LAST:event_rdNombreActionPerformed

    private void rdCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdCodigoMouseClicked
        // TODO add your handling code here:
        rdNombre.setSelected(false);
        jTFBuscarT.setEnabled(true); 
    }//GEN-LAST:event_rdCodigoMouseClicked

    private void jTFBuscarTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarTKeyReleased
        // TODO add your handling code here:
        if (rdNombre.isSelected()) {
            int filas = modeloTablaTipos.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaTipos.removeRow(0);
            }
            setFilasTipos(1, jTFBuscarT.getText());
        }else if (rdCodigo.isSelected()) {
            int filas = modeloTablaTipos.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaTipos.removeRow(0);
            }
            setFilasTipos(2, jTFBuscarT.getText());
        }
        
    }//GEN-LAST:event_jTFBuscarTKeyReleased

    private void btnModificarTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarTKeyPressed

    private void jTFNombreTipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreTipoKeyReleased
        // TODO add your handling code here: 
        mtoTipoUsuarios objeto=new mtoTipoUsuarios();
        objeto.setNombreT(jTFNombreTipo.getText());
        String datos[]=objeto.consultarTipo();
        if (jTFNombreTipo.getText().equals(datos[0])) {
            CodigoTipos=datos[2];
            lblCodigoTipo.setText("CODIGO TIPO: "+datos[2]);
            cmbPrivilegios.setSelectedItem(Integer.valueOf(datos[1]));
        }else if(jTFNombreTipo.getText().equals("")){
            lblCodigoTipo.setText("CODIGO TIPO");
        }
    }//GEN-LAST:event_jTFNombreTipoKeyReleased

    private void jTFBuscarT1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarT1KeyTyped
        // TODO add your handling code here:char vchar = evt.getKeyChar();
       char vchar = evt.getKeyChar();
       
        if (verificar.vletrasynumeros(vchar) == true
                && (jTFBuscarT1.getText().length() < 10)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFBuscarT1KeyTyped

    private void jTFNombreTipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreTipoKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vletrasynumeros(vchar) == true
                && (jTFNombreTipo.getText().length() < 10)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFNombreTipoKeyTyped

    private void jTFBuscarTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarTKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vletrasynumeros(vchar) == true
                && (jTFBuscarT.getText().length() < 10)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFBuscarTKeyTyped

    private void lblhelpAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblhelpAncestorAdded
        // TODO add your handling code here:
        

    }//GEN-LAST:event_lblhelpAncestorAdded

    private void lblhelp1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblhelp1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblhelp1AncestorAdded

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

    private void lblhelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhelpMouseClicked
        // TODO add your handling code here:
        //y cuando llames el formulario ayuda en vez del 0 le vas a poner el form que le corresponda 1 2 o 3 y asi sucesivamente, si vos elegis el orden
        /**
         * ahorita, llena los textos de ayuda de todos los forms, luego vemos lo de las imagenes , me avisas cuando temrines de escribir las instrucciones
         */
        help form = new help(16);
        form.show();
    }//GEN-LAST:event_lblhelpMouseClicked

    private void lblhelp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhelp1MouseClicked
        // TODO add your handling code here:
        help form = new help(16);
        form.show();
    }//GEN-LAST:event_lblhelp1MouseClicked

    private void cbGestionarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGestionarInventarioActionPerformed
        // TODO add your handling code here:
        
            cbInventario.setSelected(true);
            if (cbGestionarInventario.isSelected()==false) {
            cbInventario.setSelected(false);
        }
        
    }//GEN-LAST:event_cbGestionarInventarioActionPerformed
    
    private void cbInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInventarioActionPerformed
        // TODO add your handling code here:
        
            cbGestionarInventario.setSelected(true);
           if (cbInventario.isSelected()==false) {
            cbGestionarInventario.setSelected(false);
        }
        
        
    }//GEN-LAST:event_cbInventarioActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
     
        try {
            Conexion con = new Conexion();

            
            
            String archivo= getClass().getResource("/reportes/ReporteTipoUsuarios.jrxml").getPath();
            archivo = URLDecoder.decode(archivo,"UTF-8");
            JasperReport report = JasperCompileManager.compileReport(archivo);
            Map parametros = new HashMap();
            parametros.put("valor",jTFBuscarT.getText());
            if (jTFBuscarT.getText().isEmpty()) {
                parametros.put("tipo",0);
            }else if (!jTFBuscarT.getText().isEmpty() && rdNombre.isSelected()){
               parametros.put("tipo",1); 
            }else if (!jTFBuscarT.getText().isEmpty() && rdCodigo.isSelected()){
               parametros.put("tipo",2); 
            }
           
           
            
            
            try {
                String sql ="SELECT numRegistro, nombreEmpresa, domicilioLegal, fechaConstitucion, logo, telefono, correoElectronico, propietario "
                        + "FROM datosEmpresa";
                PreparedStatement cmd = con.conectar().prepareStatement(sql);
                ResultSet ver = cmd.executeQuery();
                if (ver.next()) {
                   parametros.put("#registro",ver.getInt(1));
                   parametros.put("nombreEmpresa",ver.getString(2));
                   parametros.put("domicilio",ver.getString(3));
                   parametros.put("fechaConstitucion",ver.getString(4));
                   parametros.put("imagen",ver.getString(5));
                   parametros.put("telefono",ver.getString(6));
                   parametros.put("correo",ver.getString(7));
                   parametros.put("propietario",ver.getString(8));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            parametros.put("autor", correo);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, con.conectar());
 
            JasperViewer visor = new JasperViewer(print, false);
            visor.setTitle("Reporte de Tipos de Usuario");
            visor.setVisible(true);
 
            
        } catch (JRException e) {
            System.out.println("AQUI1");
            System.out.println(e.getMessage());
            
        } 
        catch (UnsupportedEncodingException ex) {
            System.out.println("AQUI2");
            Logger.getLogger(PInventario.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnAgregarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarTActionPerformed

    private void btnModificarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarP;
    private javax.swing.JButton btnAgregarT;
    private javax.swing.JButton btnEliminarP;
    private javax.swing.JButton btnEliminarT;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificarP;
    private javax.swing.JButton btnModificarT;
    private javax.swing.JCheckBox cbBitacoras;
    private javax.swing.JCheckBox cbCajaRegistradora;
    private javax.swing.JCheckBox cbChatCenter;
    private javax.swing.JCheckBox cbClientes;
    private javax.swing.JCheckBox cbConstruirEquipo;
    private javax.swing.JCheckBox cbDatosEmpresa;
    private javax.swing.JCheckBox cbEmpleados;
    private javax.swing.JCheckBox cbGestionarInventario;
    private javax.swing.JCheckBox cbGestionarProductos;
    private javax.swing.JCheckBox cbGestionarVentas;
    private javax.swing.JCheckBox cbInventario;
    private javax.swing.JCheckBox cbOrdenesCola;
    private javax.swing.JCheckBox cbProductos;
    private javax.swing.JCheckBox cbProveedores;
    private javax.swing.JCheckBox cbSolicitarAyuda;
    private javax.swing.JCheckBox cbVentas;
    private javax.swing.JComboBox<String> cmbPrivilegios;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFBuscarT;
    private javax.swing.JTextField jTFBuscarT1;
    private javax.swing.JTextField jTFNombreTipo;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblCodigoPrivilegio;
    private javax.swing.JLabel lblCodigoTipo;
    private javax.swing.JLabel lblhelp;
    private javax.swing.JLabel lblhelp1;
    private javax.swing.JRadioButton rdCodigo;
    private javax.swing.JRadioButton rdNombre;
    // End of variables declaration//GEN-END:variables

}
