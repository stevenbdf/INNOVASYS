/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.Conexion;
import clases.mtoUsuarios;
import clases.verificaciones;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.Color;

/**
 *
 * @author steve
 */
public class PProveedores extends javax.swing.JPanel {

    Conexion con = new Conexion();
    DefaultTableModel modeloTablaProveedores;
    DefaultTableModel modeloTablaRubros;
    DefaultComboBoxModel modeloComboRubros;
    
    /**
     * Creates new form PProveedores
     */
    verificaciones verificar = new verificaciones();
    String correo;
    public static final Color greenD = new Color(217,179,16);
    public static final Color greenDD = new Color(217,179,16);
    
    public PProveedores(String correoE) {
         modeloTablaProveedores= new DefaultTableModel(null, getColumnasProveedores());
         modeloTablaRubros= new DefaultTableModel(null, getColumnasRubros());
         modeloComboRubros = new DefaultComboBoxModel(new String[]{});
         
         setFilasP(0,"");
         setFilasRubros(0,"");
//         try {
//                     UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//		}
//		catch (Exception e) {
                
//		}
        initComponents();
        setFilasP(0,"");
         setFilasRubros(0,"");
        llenarRubros();
        correo=correoE;
        jTextField1.setEnabled(false);
        ImageIcon foto0 = new ImageIcon (getClass().getResource("/images/help.png"));
       ImageIcon icono0 = new ImageIcon(foto0.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
       lblhelp.setIcon(icono0);
       
       jTable1.getTableHeader().setOpaque(false);
        JTableHeader header = jTable1.getTableHeader();
        header.setBackground(greenD);
        header.setForeground(Color.WHITE);
        
        String[] valoresC = getColumnasProveedores();
        TableColumnModel columnModel = jTable1.getColumnModel();
        System.out.println("tamaño: "+valoresC.length);
        for (int i = 0; i <valoresC.length; i++) {
            columnModel.getColumn(i).setPreferredWidth(valoresC[i].length()*9);
            System.out.println("entra");
        }
        
        
        jTable2.getTableHeader().setOpaque(false);
        JTableHeader header2 = jTable2.getTableHeader();
        header2.setBackground(greenDD);
        header2.setForeground(Color.WHITE);
        
        String[] valoresCC = getColumnasProveedores();
        TableColumnModel columnModel2 = jTable2.getColumnModel();
        System.out.println("tamaño: "+valoresCC.length);
        for (int i = 0; i <valoresCC.length; i++) {
            columnModel2.getColumn(i).setPreferredWidth(valoresCC[i].length()*9);
            System.out.println("entra");
        }
        
    }
    private String[] getColumnasProveedores() {
        String columnas[] = new String[]{"ID PROVEEDOR", "NOMBRE", "DIRECCION", "TELEFONO", "FAX", "CORREO","RUBRO" ,"ESTADO"};
        return columnas;
    }
    private String[] getColumnasRubros() {
        String columnas[] = new String[]{"CODIGO", "NOMBRE", "DESCRIPCION"};
        return columnas;
    }
    void llenarRubros(){
        modeloComboRubros.removeAllElements();
        try {
                Conexion con = new Conexion();
            /* Realizamos la consulta a la base de datos*/
            String sql2="SELECT nombreRubro FROM rubroProveedor ";
            PreparedStatement verDatos2 = con.conectar().prepareStatement(sql2);
            ResultSet ver2 = verDatos2.executeQuery();
            
            while(ver2.next()){
                modeloComboRubros.addElement(ver2.getObject("nombreRubro"));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);

        }
    }
    private void setFilasP(int tipo,String valores) {
        try {
            String sql="";
            switch (tipo) {
                //Codigo Empleado
                case 1:
                    sql = "SELECT idProveedor, nombreProveedor, direccion,telefono, fax,correoElectronico,rubroProveedor.nombreRubro, estado "
                            + "FROM proveedor, rubroProveedor WHERE idProveedor like '"+valores+"%' AND rubroProveedor.idRubro=proveedor.idRubro";
                    break;
                //Nombre
                case 2:
                    sql = "SELECT idProveedor, nombreProveedor, direccion,telefono, fax,correoElectronico,rubroProveedor.nombreRubro , estado "
                            + "FROM proveedor,rubroProveedor WHERE nombreProveedor like '"+valores+"%' AND rubroProveedor.idRubro=proveedor.idRubro";
                    break;
                default:
                    sql = "SELECT idProveedor, nombreProveedor, direccion,telefono, fax,correoElectronico,rubroProveedor.nombreRubro, estado "
                            + "FROM proveedor,rubroProveedor "
                            + "WHERE idProveedor>0 AND rubroProveedor.idRubro=proveedor.idRubro";
                    break;
            }
            PreparedStatement us = con.conectar().prepareStatement(sql);
            ResultSet resultado = us.executeQuery();

            Object datos[] = new Object[8];

            while (resultado.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = resultado.getObject(i + 1);
                }
                modeloTablaProveedores.addRow(datos);
            }
        } catch (Exception e) {

        }
    }
    private void setFilasRubros(int tipo,String valores) {
        try {
            String sql="";
            switch (tipo) {
                //Codigo Empleado
                case 1:
                    sql = "SELECT * "
                            + "FROM rubroProveedor WHERE idRubro like '"+valores+"%'";
                    break;
                //Nombre
                case 2:
                    sql = "SELECT * "
                            + "FROM rubroProveedor WHERE nombreRubro like '"+valores+"%'";
                    break;
                default:
                    sql = "SELECT * "
                            + "FROM rubroProveedor "
                            + "WHERE idRubro>0";
                    break;
            }
            PreparedStatement us = con.conectar().prepareStatement(sql);
            ResultSet resultado = us.executeQuery();

            Object datos[] = new Object[3];

            while (resultado.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = resultado.getObject(i + 1);
                }
                modeloTablaRubros.addRow(datos);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTFBuscarP = new javax.swing.JTextField();
        rdCodigoP = new javax.swing.JRadioButton();
        rdNombreP = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblhelp = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cmbRubro = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTFCodigoR = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTFNombreR = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();

        setBackground(new java.awt.Color(30, 57, 42));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 196, 124), 3));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(30, 57, 42));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Agregar");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton6.setContentAreaFilled(false);
        jButton6.setPreferredSize(new java.awt.Dimension(71, 30));
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
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 90, -1));

        jButton5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Modificar");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton5.setContentAreaFilled(false);
        jButton5.setPreferredSize(new java.awt.Dimension(75, 30));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 90, -1));

        jButton8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Eliminar");
        jButton8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton8.setContentAreaFilled(false);
        jButton8.setPreferredSize(new java.awt.Dimension(75, 30));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 90, -1));

        jButton7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Limpiar");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton7.setContentAreaFilled(false);
        jButton7.setPreferredSize(new java.awt.Dimension(75, 30));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 90, -1));

        jButton4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Generar Reporte");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton4.setContentAreaFilled(false);
        jButton4.setPreferredSize(new java.awt.Dimension(71, 30));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 120, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 160, 30));

        jTextField7.setBackground(new java.awt.Color(204, 204, 204));
        jTextField7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 155, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Rubro:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, -1, 30));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Correo Electronico:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 30));

        jTextField6.setBackground(new java.awt.Color(204, 204, 204));
        jTextField6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 155, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fax:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 30, 30));

        jTextField5.setBackground(new java.awt.Color(204, 204, 204));
        jTextField5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 155, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Direccion:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, 30));

        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 155, 30));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, 30));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 60, 30));

        jTextField3.setBackground(new java.awt.Color(204, 204, 204));
        jTextField3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 155, 30));

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 100, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, 30));

        jTable1.setModel(modeloTablaProveedores);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setGridColor(new java.awt.Color(0, 153, 51));
        jTable1.setSelectionBackground(new java.awt.Color(0, 204, 51));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 315, 200));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Buscar:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, 20));

        jTFBuscarP.setBackground(new java.awt.Color(204, 204, 204));
        jTFBuscarP.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFBuscarP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBuscarPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFBuscarPKeyTyped(evt);
            }
        });
        jPanel1.add(jTFBuscarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 110, 30));

        rdCodigoP.setBackground(new java.awt.Color(102, 102, 102));
        rdCodigoP.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        rdCodigoP.setForeground(new java.awt.Color(255, 255, 255));
        rdCodigoP.setText("Codigo");
        rdCodigoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCodigoPActionPerformed(evt);
            }
        });
        jPanel1.add(rdCodigoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, 30));

        rdNombreP.setBackground(new java.awt.Color(102, 102, 102));
        rdNombreP.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        rdNombreP.setForeground(new java.awt.Color(255, 255, 255));
        rdNombreP.setText("Nombre");
        rdNombreP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNombrePActionPerformed(evt);
            }
        });
        jPanel1.add(rdNombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, 30));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(217, 179, 16));
        jLabel1.setText("Gestion de los Proveedores");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

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
        jPanel1.add(lblhelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 25, 25));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Estado:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, 30));

        cmbRubro.setModel(modeloComboRubros);
        cmbRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRubroActionPerformed(evt);
            }
        });
        jPanel1.add(cmbRubro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 160, 30));

        jTabbedPane1.addTab("Proveedores", jPanel1);

        jPanel2.setBackground(new java.awt.Color(30, 57, 42));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Codigo:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 60, 50, 30));

        jTFCodigoR.setBackground(new java.awt.Color(204, 204, 204));
        jTFCodigoR.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFCodigoR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCodigoRActionPerformed(evt);
            }
        });
        jTFCodigoR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFCodigoRKeyTyped(evt);
            }
        });
        jPanel2.add(jTFCodigoR, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 100, 30));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(60, 196, 124));
        jLabel12.setText("Gestion de Rubros");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Descripcion:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 80, 30));

        jTFNombreR.setBackground(new java.awt.Color(204, 204, 204));
        jTFNombreR.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFNombreR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreRActionPerformed(evt);
            }
        });
        jTFNombreR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreRKeyTyped(evt);
            }
        });
        jPanel2.add(jTFNombreR, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 150, 30));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nombre:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 110, 60, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 190, 160));

        jTable2.setModel(modeloTablaRubros);
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable2.setGridColor(new java.awt.Color(0, 153, 51));
        jTable2.setSelectionBackground(new java.awt.Color(0, 204, 51));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 310, 240));

        jButton9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Agregar");
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton9.setContentAreaFilled(false);
        jButton9.setPreferredSize(new java.awt.Dimension(71, 30));
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 90, -1));

        jButton10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Modificar");
        jButton10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton10.setContentAreaFilled(false);
        jButton10.setPreferredSize(new java.awt.Dimension(75, 30));
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10MouseExited(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 90, -1));

        jButton11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Eliminar");
        jButton11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton11.setContentAreaFilled(false);
        jButton11.setPreferredSize(new java.awt.Dimension(75, 30));
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton11MouseExited(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 90, -1));

        jButton12.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Generar Reporte");
        jButton12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton12.setContentAreaFilled(false);
        jButton12.setPreferredSize(new java.awt.Dimension(71, 30));
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton12MouseExited(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 120, -1));

        jTabbedPane1.addTab("Rubro de Proveedores", jPanel2);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        this.hide();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
         jButton4.setContentAreaFilled(true);
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        // TODO add your handling code here:
         jButton4.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
         jButton6.setContentAreaFilled(true);
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        // TODO add your handling code here:
         jButton6.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
         jButton5.setContentAreaFilled(true);
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        // TODO add your handling code here:
         jButton5.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton5MouseExited

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vletras(vchar) == true
                && (jTextField3.getText().length() < 40)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        
            evt.consume();
        
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vnumeros(vchar) == true
                && (jTextField2.getText().length() < 8)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vletrasynumeros(vchar) == true
                && (jTextField5.getText().length() < 40)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vnumeros(vchar) == true
                && (jTextField6.getText().length() < 14)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vcorreoevent(vchar) == true
                && (jTextField7.getText().length() < 40)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTFBuscarPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarPKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vletrasynumeros(vchar) == true
                && (jTextField7.getText().length() < 30)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFBuscarPKeyTyped

    private void lblhelpAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblhelpAncestorAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_lblhelpAncestorAdded

    private void lblhelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhelpMouseClicked
        // TODO add your handling code here:
        //y cuando llames el formulario ayuda en vez del 0 le vas a poner el form que le corresponda 1 2 o 3 y asi sucesivamente, si vos elegis el orden
        /**
        * ahorita, llena los textos de ayuda de todos los forms, luego vemos lo de las imagenes , me avisas cuando temrines de escribir las instrucciones
        */
        help form = new help(15);
        form.show();
    }//GEN-LAST:event_lblhelpMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        verificaciones obj = new verificaciones();      
        mtoUsuarios objeto = new mtoUsuarios();
        if(obj.vcorreo(jTextField7.getText())){
//        objeto.consultasRandom();
        if(!(jTextField3.getText().isEmpty()&&jTextField2.getText().isEmpty()
            && jTextField7.getText().isEmpty()&&jTextField6.getText().isEmpty()
            &&jTextField5.getText().isEmpty()&&jTextField1.getText().isEmpty())){
                objeto.setNombreP(String.valueOf(jTextField3.getText()));
                objeto.setTelefonoP(Integer.valueOf(jTextField2.getText()));
                objeto.setCorreoP(String.valueOf(jTextField7.getText()));
                objeto.setFaxP(Integer.valueOf(jTextField6.getText()));
                objeto.setDireccionP(String.valueOf(jTextField5.getText()));
                objeto.setCodigoRubro(codigoRubro);
                String texto= String.valueOf(jComboBox1.getSelectedItem());
                
            if(jTextField1.getText().isEmpty()){
                
                if (texto.equals("Activo")) {
                   objeto.setEstadoP("Activo");
                   if(objeto.guardarProveedor()){
                        JOptionPane.showMessageDialog(this, "Proveedor agregado");
                        
                        int filas = modeloTablaProveedores.getRowCount();
                       for (int i = 0; filas > i; i++) {
                           modeloTablaProveedores.removeRow(0);
                       }
                        setFilasP(0,"");
                    }else{
                        JOptionPane.showMessageDialog(this, "Error al agregar");
                    }
                }else if (texto.equals("Inactivo")) {
                    objeto.setEstadoP("Inactivo");
                    if(objeto.guardarProveedor()){
                        JOptionPane.showMessageDialog(this, "Proveedor agregado");
                        int filas = modeloTablaProveedores.getRowCount();
                       for (int i = 0; filas > i; i++) {
                           modeloTablaProveedores.removeRow(0);
                       }
                        setFilasP(0,"");
                    }else{
                        JOptionPane.showMessageDialog(this, "Error al agrgar");
                    }
                
                }else{
                        JOptionPane.showMessageDialog(this,"Seleccione un estado de el proveedor");
                    }
                
            }else{
                objeto.setIdP(Integer.valueOf(jTextField1.getText()));
                    if(objeto.checkProveedor()){
                    JOptionPane.showMessageDialog(this, "Ya existe ese usuario registrado");
                }else{
                    if (texto.equals("Activo")) {
                       objeto.setEstadoP("Activo");
                       if(objeto.guardarProveedor()){
                            JOptionPane.showMessageDialog(this, "Proveedor agregado");
                            int filas = modeloTablaProveedores.getRowCount();
                       for (int i = 0; filas > i; i++) {
                           modeloTablaProveedores.removeRow(0);
                       }
                            setFilasP(0,"");
                        }else{
                            JOptionPane.showMessageDialog(this, "Error al agregar");
                        }
                    }else if (texto.equals("Inactivo")) {
                        objeto.setEstadoP("Inactivo");
                        if(objeto.guardarProveedor()){
                            JOptionPane.showMessageDialog(this, "Proveedor agregado");
                            int filas = modeloTablaProveedores.getRowCount();
                       for (int i = 0; filas > i; i++) {
                           modeloTablaProveedores.removeRow(0);
                       }
                            setFilasP(0,"");
                        }else{
                            JOptionPane.showMessageDialog(this, "Error al agrgar");
                        }
                    }else{
                        JOptionPane.showMessageDialog(this,"Seleccione un estado de el proveedor");
                    }
            }
            }   
          
        }else{
                JOptionPane.showMessageDialog(this,"Ingrese todos los datos");
            }
            
        }else{
            JOptionPane.showMessageDialog(this,"Ingrese un formato de correo valido");
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        verificaciones obj = new verificaciones();      
        mtoUsuarios objeto = new mtoUsuarios();
        if(obj.vcorreo(jTextField7.getText())){
        objeto.setNombreP(String.valueOf(jTextField3.getText()));
        objeto.setTelefonoP(Integer.valueOf(jTextField2.getText()));
        objeto.setCorreoP(String.valueOf(jTextField7.getText()));
        objeto.setFaxP(Integer.valueOf(jTextField6.getText()));
        objeto.setDireccionP(String.valueOf(jTextField5.getText()));
        String texto= String.valueOf(jComboBox1.getSelectedItem());
        objeto.setCodigoRubro(codigoRubro);
        objeto.setIdP(Integer.valueOf(jTextField1.getText()));
        
            if (texto.equals("Activo")) {
               objeto.setEstadoP("Activo");
               if(objeto.modificarProveedor()){
                    JOptionPane.showMessageDialog(this, "Proveedor modificado");
                    int filas = modeloTablaProveedores.getRowCount();
                       for (int i = 0; filas > i; i++) {
                           modeloTablaProveedores.removeRow(0);
                       }
                       setFilasP(0,"");
                }else{
                    JOptionPane.showMessageDialog(this, "Error al modificar");
                }
            }else if (texto.equals("Inactivo")) {
                objeto.setEstadoP("Inactivo");
                if(objeto.modificarProveedor()){
                    JOptionPane.showMessageDialog(this, "Proveedor modificado");
                    int filas = modeloTablaProveedores.getRowCount();
                       for (int i = 0; filas > i; i++) {
                           modeloTablaProveedores.removeRow(0);
                       }
                       setFilasP(0,"");
                }else{
                    JOptionPane.showMessageDialog(this, "Error al modificar");
                }
            
        }
        }else{
            JOptionPane.showMessageDialog(this,"Ingrese un formato de correo valido");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        jTextField3.setText(String.valueOf(modeloTablaProveedores.getValueAt(jTable1.getSelectedRow(), (1))));
        jTextField1.setText(String.valueOf(modeloTablaProveedores.getValueAt(jTable1.getSelectedRow(), (0))));
        jTextField2.setText(String.valueOf(modeloTablaProveedores.getValueAt(jTable1.getSelectedRow(), (3))));
        jTextField5.setText(String.valueOf(modeloTablaProveedores.getValueAt(jTable1.getSelectedRow(), (2))));
        jTextField6.setText(String.valueOf(modeloTablaProveedores.getValueAt(jTable1.getSelectedRow(), (4))));
        jTextField7.setText(String.valueOf(modeloTablaProveedores.getValueAt(jTable1.getSelectedRow(), (5))));
        cmbRubro.setSelectedItem(String.valueOf(modeloTablaProveedores.getValueAt(jTable1.getSelectedRow(), (6))));
        String texto = String.valueOf(modeloTablaProveedores.getValueAt(jTable1.getSelectedRow(), (7)));
        if (texto.equals("Activo")) {
            jComboBox1.setSelectedItem("Activo");
        }else{
            jComboBox1.setSelectedItem("Inactivo");
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTFBuscarPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarPKeyReleased
        // TODO add your handling code here:
        if (rdNombreP.isSelected()) {
            int filas = modeloTablaProveedores.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaProveedores.removeRow(0);
            }
            setFilasP(2, jTFBuscarP.getText());
        } else if (rdCodigoP.isSelected()) {
            int filas = modeloTablaProveedores.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaProveedores.removeRow(0);
            }
            setFilasP(1, jTFBuscarP.getText());
        }
    }//GEN-LAST:event_jTFBuscarPKeyReleased

    private void rdNombrePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNombrePActionPerformed
        // TODO add your handling code here:
        rdCodigoP.setSelected(false);
        jTFBuscarP.setEnabled(true);
        tipo2=2;
    }//GEN-LAST:event_rdNombrePActionPerformed

    private void rdCodigoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCodigoPActionPerformed
        // TODO add your handling code here:
        rdNombreP.setSelected(false);
        jTFBuscarP.setEnabled(true);
        tipo2=1;
    }//GEN-LAST:event_rdCodigoPActionPerformed

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText(null);
        
        jTextField3.setText(null);
        
        jTextField2.setText(null);
        
        jTextField5.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
        jComboBox1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8MouseExited

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecciona un proveedor para eliminar");
        }else{
            mtoUsuarios obj = new mtoUsuarios();
            obj.setIdP(Integer.valueOf(jTextField1.getText()));
            if (obj.eliminarProveedor()) {
                JOptionPane.showMessageDialog(this, "Proveedor eliminado");
                jTextField1.setText(null);

                jTextField3.setText(null);

                jTextField2.setText(null);

                jTextField5.setText(null);
                jTextField6.setText(null);
                jTextField7.setText(null);
                jComboBox1.setSelectedIndex(0);
            }else{
                JOptionPane.showMessageDialog(this, "Productos relacionados a este proveedor");
            }         
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
int tipo2=0;
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String path ="";
        try {
            Conexion con = new Conexion();
                     
            String archivo= getClass().getResource("/reportes/ReporteProveedores.jrxml").getPath();
            archivo = URLDecoder.decode(archivo,"UTF-8");
            JasperReport report = JasperCompileManager.compileReport(archivo);
            Map parametros = new HashMap();
                      
           parametros.put("tipo",tipo2);
           parametros.put("valores",jTFBuscarP.getText());
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
            visor.setTitle("Reporte de Documento de Empleados");
            visor.setVisible(true);
 
            
        } catch (JRException e) {
            System.out.println("AQUI1");
            System.out.println(e.getMessage());
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PProveedores.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTFCodigoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCodigoRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCodigoRActionPerformed

    private void jTFCodigoRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCodigoRKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCodigoRKeyTyped

    private void jTFNombreRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombreRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNombreRActionPerformed

    private void jTFNombreRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreRKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNombreRKeyTyped

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if(jTFNombreR.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Error campos vacios");
        }else{
            mtoUsuarios obj = new mtoUsuarios();
            obj.setNombreRubro(jTFNombreR.getText());
            obj.setDescripRubro(jTextArea1.getText());
            if (obj.guardarRubro()) {
                JOptionPane.showMessageDialog(this,"Rubro guardado correctamente");
                int filas = modeloTablaRubros.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaRubros.removeRow(0);
                }
                setFilasRubros(0, "");
            }else{
                JOptionPane.showMessageDialog(this,"Error al guardar");
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10MouseExited

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if(jTFNombreR.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Error campos vacios");
        }else{
            mtoUsuarios obj = new mtoUsuarios();
            obj.setNombreRubro(jTFNombreR.getText());
            obj.setDescripRubro(jTextArea1.getText());
            obj.setCodigoRubro(Integer.valueOf(jTFCodigoR.getText()));
            if (obj.modificarRubro()) {
                JOptionPane.showMessageDialog(this,"Rubro modificado correctamente");
                int filas = modeloTablaRubros.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaRubros.removeRow(0);
                }
                setFilasRubros(0, "");
            }else{
                JOptionPane.showMessageDialog(this,"Error al modificar");
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MouseEntered

    private void jButton11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MouseExited

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        if (jTFCodigoR.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecciona un rubro para eliminar");
        }else{
            mtoUsuarios obj = new mtoUsuarios();
            obj.setCodigoRubro(Integer.valueOf(jTFCodigoR.getText()));
            if (obj.eliminarRubro()) {
                JOptionPane.showMessageDialog(this, "Rubro eliminado");
                jTFCodigoR.setText(null);
                jTextArea1.setText(null);
                jTFNombreR.setText(null);
                int filas = modeloTablaRubros.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaRubros.removeRow(0);
                }
                setFilasRubros(0, "");
            }else{
                JOptionPane.showMessageDialog(this, "Proveedores relacionados a este rubro");
            }         
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        jTFCodigoR.setText(String.valueOf(modeloTablaRubros.getValueAt(jTable2.getSelectedRow(), (0))));
        jTFNombreR.setText(String.valueOf(modeloTablaRubros.getValueAt(jTable2.getSelectedRow(), (1))));
        jTextArea1.setText(String.valueOf(modeloTablaRubros.getValueAt(jTable2.getSelectedRow(), (2))));
        
    }//GEN-LAST:event_jTable2MouseClicked
    Integer codigoRubro;
    private void cmbRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRubroActionPerformed
        // TODO add your handling code here:
        try {
            PreparedStatement cmd = con.conectar().prepareStatement("SELECT idRubro FROM rubroProveedor WHERE nombreRubro='"+cmbRubro.getSelectedItem()+"'");
            ResultSet ver = cmd.executeQuery();
            if (ver.next()) {
                codigoRubro=ver.getInt(1);
                System.out.println("r: "+codigoRubro);
            }
        } catch (Exception e) {
            System.out.println("Error al leer combo: "+e);
        }
    }//GEN-LAST:event_cmbRubroActionPerformed

    private void jButton12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12MouseEntered

    private void jButton12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12MouseExited

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        
        try {
            Conexion con = new Conexion();

            
            String archivo= getClass().getResource("/reportes/ReporteRubros.jrxml").getPath();
            archivo = URLDecoder.decode(archivo,"UTF-8");
            JasperReport report = JasperCompileManager.compileReport(archivo);
            Map parametros = new HashMap();
            
            
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
            visor.setTitle("Reporte Rubro de Proveedores");
            visor.setVisible(true);
 
            
        } catch (JRException e) {
            System.out.println("AQUI1");
            System.out.println(e.getMessage());
            
        } 
        catch (UnsupportedEncodingException ex) {
            System.out.println("AQUI2");
            Logger.getLogger(PInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton12ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbRubro;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTFBuscarP;
    private javax.swing.JTextField jTFCodigoR;
    private javax.swing.JTextField jTFNombreR;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lblhelp;
    private javax.swing.JRadioButton rdCodigoP;
    private javax.swing.JRadioButton rdNombreP;
    // End of variables declaration//GEN-END:variables
}
