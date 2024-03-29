/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.*;
import java.awt.Image;
import java.io.File;
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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
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
public class PEmpleado extends javax.swing.JPanel {

    
    /**
     * Creates new form PEmpleado
     */
    //Instancia de clase verificaciones
    verificaciones verificar = new verificaciones();
    //Instancia clase conexion
    Conexion con = new Conexion();
    Conexion cn = new Conexion();
    /**
     * Creacion de modelo de lista
     */
    DefaultListModel modeloLista = new DefaultListModel();
    String correo = "";
    public static final Color greenD = new Color(217,179,16);
    public static final Color greenDD = new Color(217,179,16);
    public static final Color greenDDD = new Color(217,179,16);
    public static final Color greenDDDD = new Color(217,179,16);

    private void llenarList(int tipo, String valores) {
        try {
            String sql3 = "";
            switch (tipo) {
                case 1:
                    sql3 = "SELECT correoElectronico FROM usuarioEmpleado WHERE correoElectronico like '" + valores + "%'";
                    break;
                default:
                    sql3 = "SELECT correoElectronico FROM usuarioEmpleado";
                    break;
            }

            PreparedStatement cmd3 = cn.conectar().prepareStatement(sql3);
            ResultSet ver3 = cmd3.executeQuery();
            while (ver3.next()) {
                modeloLista.addElement(ver3.getObject(1));
            }
        } catch (SQLException e) {
            System.out.println("Primera");
            System.out.println(e.toString());
        }
    }

    /**
     * Creacion de modelos de tablas
     */
    DefaultTableModel modeloTablaEstados;
    DefaultTableModel modeloTablaDocumentos;
    DefaultTableModel modeloTablaEmpleados;
    DefaultTableModel modeloTablaDocumentosEmpleados;
    /**
     * Creacion de modelos de comboBoxes
     */
    DefaultComboBoxModel modeloComboTipoUsuario;
    DefaultComboBoxModel modeloComboEstado;
    DefaultComboBoxModel modeloComboDocumentos;
    /**
     * Llaves necesarias para la combinacion e incriptacion de claves
     */
    String key = "92AE31A79FEEB2A3"; //llave
    String iv = "0123456789ABCDEF"; // vector de inicialización
    /**
     * Variables Generales utilizadas en el formulario
     */
    String cleartext = "";
    String NombreE = "", CodigoEstado = "", NombreD = "", CodigoDocumento = "", DescripcionE = "";
    String CodigoEmpleado = "";
    String nombreEmpleadoDE = "", CodigoDocumentoDD;
    File fichero;
    String datos = String.valueOf(fichero);

    public PEmpleado(String correoE) {

        modeloTablaEstados = new DefaultTableModel(null, getColumnasEstado());
        setFilasEstado(0, "");
        modeloTablaDocumentos = new DefaultTableModel(null, getColumnasDocumentos());
        setFilasDocumentos(0, "");
        modeloTablaEmpleados = new DefaultTableModel(null, getColumnasEmpleado());
        setFilasEmpleado(0, "");
        modeloTablaDocumentosEmpleados = new DefaultTableModel(null, getColumnasDocumentosEmpleados());

        modeloComboTipoUsuario = new DefaultComboBoxModel(new String[]{});
        modeloComboDocumentos = new DefaultComboBoxModel(new String[]{});
        modeloComboEstado = new DefaultComboBoxModel(new String[]{});
//                try {
//                     UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//		}
//		catch (Exception e) {
//		}
        initComponents();
        correo = correoE;
        ImageIcon foto0 = new ImageIcon(getClass().getResource("/images/help.png"));
        ImageIcon icono0 = new ImageIcon(foto0.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
//       lblhelp.setIcon(icono0);
//       lblhelp1.setIcon(icono0);
//       lblhelp2.setIcon(icono0);

        llenarList(0, "");
        llenaComboBoxTipoUsuario();
        llenaComboBoxEstado();
        llenaComboBoxDocumentos();
        jTFBuscarEstado.setEnabled(false);
        jTFBuscarDocumento.setEnabled(false);
        jTFBuscarEmpleado.setEnabled(false);
        
        
        jTable1.getTableHeader().setOpaque(false);
        JTableHeader header = jTable1.getTableHeader();
        header.setBackground(greenD);
        header.setForeground(Color.WHITE);

        String[] valoresC = getColumnasEmpleado();
        TableColumnModel columnModel = jTable1.getColumnModel();
        System.out.println("tamaño: "+valoresC.length);
        for (int i = 0; i <valoresC.length; i++) {
            columnModel.getColumn(i).setPreferredWidth(valoresC[i].length()*9);
            System.out.println("entra");
        }
        
        
        jTable4.getTableHeader().setOpaque(false);
        JTableHeader header1 = jTable4.getTableHeader();
        header1.setBackground(greenDD);
        header1.setForeground(Color.WHITE);

        String[] valoresCC = getColumnasDocumentosEmpleados();
        TableColumnModel columnModel2 = jTable4.getColumnModel();
        System.out.println("tamaño: "+valoresCC.length);
        for (int i = 0; i <valoresCC.length; i++) {
            columnModel.getColumn(i).setPreferredWidth(valoresCC[i].length()*9);
            System.out.println("entra");
        }
        
        
        jTable2.getTableHeader().setOpaque(false);
        JTableHeader header2 = jTable2.getTableHeader();
        header2.setBackground(greenDDDD);
        header2.setForeground(Color.WHITE);
        
        String[] valoresCCC = getColumnasDocumentos();
        TableColumnModel columnModel3 = jTable2.getColumnModel();
        System.out.println("tamaño: "+valoresCCC.length);
        for (int i = 0; i <valoresCCC.length; i++) {
            columnModel.getColumn(i).setPreferredWidth(valoresCCC[i].length()*9);
            System.out.println("entra");
        }
        
        jTable3.getTableHeader().setOpaque(false);
        JTableHeader header3 = jTable3.getTableHeader();
        header3.setBackground(greenDDD);
        header3.setForeground(Color.WHITE);
        
        String[] valoresCCCC = getColumnasEstado();
        TableColumnModel columnModel4 = jTable3.getColumnModel();
        System.out.println("tamaño: "+valoresCCCC.length);
        for (int i = 0; i <valoresCCCC.length; i++) {
            columnModel.getColumn(i).setPreferredWidth(valoresCCCC[i].length()*9);
            System.out.println("entra");
        }
    }

    private void llenaComboBoxTipoUsuario() {
        modeloComboTipoUsuario.removeAllElements();
        try {

            /* Realizamos la consulta a la base de datos*/
            String sql = "SELECT nombreTipo FROM tipoUsuario";
            PreparedStatement verDatos = con.conectar().prepareStatement(sql);
            ResultSet ver = verDatos.executeQuery();
            while (ver.next()) {

                modeloComboTipoUsuario.addElement(ver.getObject("nombreTipo"));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);

        }
    }

    private void llenaComboBoxDocumentos() {
        modeloComboDocumentos.removeAllElements();
        try {

            /* Realizamos la consulta a la base de datos*/
            String sql = "SELECT nombre FROM Documento";
            PreparedStatement verDatos = con.conectar().prepareStatement(sql);
            ResultSet ver = verDatos.executeQuery();
            while (ver.next()) {

                modeloComboDocumentos.addElement(ver.getObject("nombre"));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);

        }
    }

    private void llenaComboBoxEstado() {
        modeloComboEstado.removeAllElements();
        try {

            /* Realizamos la consulta a la base de datos*/
            String sql = "SELECT nombreEstado FROM estadoEmpleado";
            PreparedStatement verDatos = con.conectar().prepareStatement(sql);
            ResultSet ver = verDatos.executeQuery();
            while (ver.next()) {

                modeloComboEstado.addElement(ver.getObject("nombreEstado"));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);

        }
    }

    private String[] getColumnasEstado() {
        String columnas[] = new String[]{"CODIGO", "NOMBRE", "DESCRIPCION","INGRESO"};
        return columnas;
    }

    private String[] getColumnasEmpleado() {
        String columnas[] = new String[]{"CODIGO", "TIPO", "NOMBRES", "APELLIDOS", "TELEFONO", "CORREO", "DIRECCION", "ESTADO"};
        return columnas;
    }

    private String[] getColumnasDocumentos() {
        String columnas[] = new String[]{"CODIGO", "NOMBRE", "ESTADO"};
        return columnas;
    }

    private String[] getColumnasDocumentosEmpleados() {
        String columnas[] = new String[]{"CODIGO", "NOMBRE", "EMPLEADO", "DESCRIPCION"};
        return columnas;
    }

    private void setFilasEstado(int tipo, String valores) {
        try {
            String sql = "";
            switch (tipo) {
                case 1:
                    sql = "SELECT idEstado, nombreEstado,descripcion,ingreso FROM estadoEmpleado WHERE idEstado like '" + valores + "%'";
                    break;
                case 2:
                    sql = "SELECT idEstado, nombreEstado,descripcion,ingreso FROM estadoEmpleado WHERE nombreEstado like '" + valores + "%'";
                    break;
                default:
                    sql = "SELECT idEstado, nombreEstado,descripcion,ingreso FROM estadoEmpleado";
                    break;
            }
            PreparedStatement us = cn.conectar().prepareStatement(sql);
            ResultSet resultado = us.executeQuery();

            Object datos[] = new Object[4];

            while (resultado.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = resultado.getObject(i + 1);
                }
                modeloTablaEstados.addRow(datos);
            }
        } catch (Exception e) {

        }
    }

    private void setFilasDocumentos(int tipo, String valores) {
        try {
            String sql = "";
            switch (tipo) {
                case 1:
                    sql = "SELECT idDocumento, nombre, estado FROM documento WHERE idDocumento like '" + valores + "%'";
                    break;
                case 2:
                    sql = "SELECT idDocumento, nombre, estado FROM documento WHERE nombre like '" + valores + "%'";
                    break;
                case 3:
                    sql = "SELECT idDocumento, nombre, estado FROM documento WHERE estado like '" + valores + "%'";
                    break;
                default:
                    sql = "SELECT idDocumento, nombre, estado FROM documento";
                    break;
            }
            PreparedStatement us = cn.conectar().prepareStatement(sql);
            ResultSet resultado = us.executeQuery();

            Object datos[] = new Object[3];

            while (resultado.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = resultado.getObject(i + 1);
                }
                modeloTablaDocumentos.addRow(datos);
            }
        } catch (Exception e) {

        }
    }

    private void setFilasEmpleado(int tipo, String valores) {
        try {
            String sql = "";
            switch (tipo) {
                //Codigo Empleado
                case 1:
                    sql = "SELECT idEmpleado, tipoUsuario.nombreTipo"
                            + ", nombres, apellidos, telefono, correoElectronico,direccion, estadoEmpleado.nombreEstado "
                            + "FROM usuarioEmpleado , tipoUsuario, estadoEmpleado  WHERE idEmpleado like '" + valores + "%' AND estadoEmpleado.idEstado=usuarioEmpleado.idEstado AND tipoUsuario.idTipo= usuarioEmpleado.idTipo";
                    break;
                //Nombre
                case 2:
                    sql = "SELECT idEmpleado, tipoUsuario.nombreTipo, nombres, apellidos, telefono, correoElectronico,direccion, estadoEmpleado.nombreEstado  "
                            + "FROM usuarioEmpleado , tipoUsuario, estadoEmpleado  WHERE nombres like '" + valores + "%' AND estadoEmpleado.idEstado=usuarioEmpleado.idEstado AND tipoUsuario.idTipo= usuarioEmpleado.idTipo";
                    break;
                default:
                    sql = "SELECT idEmpleado, tipoUsuario.nombreTipo, nombres, apellidos, telefono, correoElectronico,direccion, estadoEmpleado.nombreEstado "
                            + "FROM usuarioEmpleado, tipoUsuario, estadoEmpleado "
                            + "WHERE estadoEmpleado.idEstado=usuarioEmpleado.idEstado AND tipoUsuario.idTipo= usuarioEmpleado.idTipo";
                    break;
            }
            PreparedStatement us = cn.conectar().prepareStatement(sql);
            ResultSet resultado = us.executeQuery();

            Object datos[] = new Object[8];

            while (resultado.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = resultado.getObject(i + 1);
                }
                modeloTablaEmpleados.addRow(datos);
            }
        } catch (Exception e) {

        }
    }

    private void setFilasDocumentosEmpleados(int tipo, String valores) {
        try {
            String sql = "";
            switch (tipo) {
                case 1:
                    sql = "SELECT idDocumentoE,documento.nombre,usuarioEmpleado.nombres,descripcion"
                            + " FROM documentoEmpleado, usuarioEmpleado, documento "
                            + " WHERE documentoEmpleado.idEmpleado=usuarioEmpleado.idEmpleado AND documento.idDocumento=documentoEmpleado.idDocumento "
                            + " AND correoElectronico='" + valores + "'";
                    break;
                default:
                    sql = "SELECT idDocumentoE,documento.nombre, usuarioEmpleado.nombres , descripcion "
                            + " FROM documentoEmpleado, usuarioEmpleado, documento "
                            + " WHERE documentoEmpleado.idEmpleado=usuarioEmpleado.idEmpleado AND documento.idDocumento=documentoEmpleado.idDocumento";
                    break;
            }
            PreparedStatement us = cn.conectar().prepareStatement(sql);
            ResultSet resultado = us.executeQuery();
            Object datos[] = new Object[4];
            while (resultado.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = resultado.getObject(i + 1);
                }
                modeloTablaDocumentosEmpleados.addRow(datos);
            }
        } catch (Exception e) {

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbTipoUsuario = new javax.swing.JComboBox<>();
        lblCodigoEmpleado = new javax.swing.JLabel();
        jTFTelefono = new javax.swing.JTextField();
        jTFNombreEmpleado = new javax.swing.JTextField();
        jTFApellido = new javax.swing.JTextField();
        jTFDireccion = new javax.swing.JTextField();
        jTFCorreo = new javax.swing.JTextField();
        jTFContraseña = new javax.swing.JTextField();
        btnModificarEmpleado = new javax.swing.JButton();
        btnLimpiarCampos = new javax.swing.JButton();
        btnExaminar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTFBuscarEmpleado = new javax.swing.JTextField();
        rdNombreEmpleado = new javax.swing.JRadioButton();
        rdCodigoEmpleado = new javax.swing.JRadioButton();
        btnGenerarReporteEmpleado = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnAgregarEmpleado = new javax.swing.JButton();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cmdPregunta1 = new javax.swing.JComboBox<>();
        jTFRespuesta1 = new javax.swing.JTextField();
        jTFRespuesta2 = new javax.swing.JTextField();
        cmdPregunta2 = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        btnEliminarEmpleado = new javax.swing.JButton();
        btnGenerarReporteEmpleado1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cmbDocumento = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        jTFBuscarCorreo = new javax.swing.JTextField();
        btnAgregarEmpleado1 = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        btnEliminarEmpleado1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        lblEmpleadoDE = new javax.swing.JLabel();
        jTFDescripcionDE = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        btnModificarEmpleado2 = new javax.swing.JButton();
        btnReport1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTFBuscarDocumento = new javax.swing.JTextField();
        rdNombreDocumento = new javax.swing.JRadioButton();
        rdCodigoDocumento = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        cmbEstadoD = new javax.swing.JComboBox<>();
        jTFNombreD = new javax.swing.JTextField();
        lblCodigoDocumento = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAgregarD = new javax.swing.JButton();
        btnModificarD = new javax.swing.JButton();
        btnEliminarD = new javax.swing.JButton();
        rdEstadoDocumento = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTFBuscarEstado = new javax.swing.JTextField();
        rdNombreEstado = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        jTFNombreE = new javax.swing.JTextField();
        lblCodigoEstado = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnAgregarE = new javax.swing.JButton();
        btnModificarE = new javax.swing.JButton();
        jTFDescripcionE = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        rdCodigoEstado = new javax.swing.JRadioButton();
        btnEliminarE = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        ingreso = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(30, 57, 42));

        jTabbedPane1.setBackground(new java.awt.Color(30, 57, 42));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 196, 124), 3));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(680, 500));

        jPanel1.setBackground(new java.awt.Color(30, 57, 42));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 196, 124)));
        jPanel1.setPreferredSize(new java.awt.Dimension(680, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 36, -1, 30));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 76, -1, 30));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Direccion:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 24));

        cmbTipoUsuario.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmbTipoUsuario.setModel(modeloComboTipoUsuario);
        jPanel1.add(cmbTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 120, 30));

        lblCodigoEmpleado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCodigoEmpleado.setForeground(new java.awt.Color(204, 204, 204));
        lblCodigoEmpleado.setText("CODIGO EMPLEADO");
        jPanel1.add(lblCodigoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jTFTelefono.setBackground(new java.awt.Color(204, 204, 204));
        jTFTelefono.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFTelefono.setToolTipText("");
        jTFTelefono.setPreferredSize(new java.awt.Dimension(78, 30));
        jTFTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(jTFTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 200, -1));

        jTFNombreEmpleado.setBackground(new java.awt.Color(204, 204, 204));
        jTFNombreEmpleado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFNombreEmpleado.setToolTipText("");
        jTFNombreEmpleado.setPreferredSize(new java.awt.Dimension(78, 30));
        jTFNombreEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreEmpleadoKeyTyped(evt);
            }
        });
        jPanel1.add(jTFNombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 200, -1));

        jTFApellido.setBackground(new java.awt.Color(204, 204, 204));
        jTFApellido.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFApellido.setToolTipText("");
        jTFApellido.setPreferredSize(new java.awt.Dimension(78, 30));
        jTFApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFApellidoKeyTyped(evt);
            }
        });
        jPanel1.add(jTFApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 200, -1));

        jTFDireccion.setBackground(new java.awt.Color(204, 204, 204));
        jTFDireccion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFDireccion.setToolTipText("");
        jTFDireccion.setPreferredSize(new java.awt.Dimension(78, 30));
        jTFDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(jTFDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 200, -1));

        jTFCorreo.setBackground(new java.awt.Color(204, 204, 204));
        jTFCorreo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFCorreo.setToolTipText("");
        jTFCorreo.setPreferredSize(new java.awt.Dimension(78, 30));
        jTFCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFCorreoKeyTyped(evt);
            }
        });
        jPanel1.add(jTFCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 200, -1));

        jTFContraseña.setBackground(new java.awt.Color(204, 204, 204));
        jTFContraseña.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFContraseña.setToolTipText("");
        jTFContraseña.setPreferredSize(new java.awt.Dimension(78, 30));
        jTFContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFContraseñaKeyTyped(evt);
            }
        });
        jPanel1.add(jTFContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 200, -1));

        btnModificarEmpleado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnModificarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/edit.png"))); // NOI18N
        btnModificarEmpleado.setText("Modificar");
        btnModificarEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnModificarEmpleado.setContentAreaFilled(false);
        btnModificarEmpleado.setPreferredSize(new java.awt.Dimension(75, 30));
        btnModificarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarEmpleadoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarEmpleadoMouseEntered(evt);
            }
        });
        btnModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 100, 40));

        btnLimpiarCampos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnLimpiarCampos.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/eraser.png"))); // NOI18N
        btnLimpiarCampos.setText("Limpiar Campos");
        btnLimpiarCampos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnLimpiarCampos.setContentAreaFilled(false);
        btnLimpiarCampos.setPreferredSize(new java.awt.Dimension(107, 30));
        btnLimpiarCampos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarCamposMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarCamposMouseEntered(evt);
            }
        });
        btnLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCamposActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 140, 40));

        btnExaminar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnExaminar.setForeground(new java.awt.Color(255, 255, 255));
        btnExaminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/imagen.png"))); // NOI18N
        btnExaminar.setText("Examinar");
        btnExaminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnExaminar.setContentAreaFilled(false);
        btnExaminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExaminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExaminarMouseExited(evt);
            }
        });
        btnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 246, 100, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Buscar:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, 30));

        jTFBuscarEmpleado.setBackground(new java.awt.Color(204, 204, 204));
        jTFBuscarEmpleado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFBuscarEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBuscarEmpleadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFBuscarEmpleadoKeyTyped(evt);
            }
        });
        jPanel1.add(jTFBuscarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 110, 30));

        rdNombreEmpleado.setBackground(new java.awt.Color(102, 102, 102));
        rdNombreEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        rdNombreEmpleado.setText("Nombre");
        rdNombreEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNombreEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(rdNombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, -1));

        rdCodigoEmpleado.setBackground(new java.awt.Color(102, 102, 102));
        rdCodigoEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        rdCodigoEmpleado.setText("Codigo");
        rdCodigoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCodigoEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(rdCodigoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, -1));

        btnGenerarReporteEmpleado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnGenerarReporteEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarReporteEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/report.png"))); // NOI18N
        btnGenerarReporteEmpleado.setText("Generar Reporte");
        btnGenerarReporteEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnGenerarReporteEmpleado.setContentAreaFilled(false);
        btnGenerarReporteEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGenerarReporteEmpleadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGenerarReporteEmpleadoMouseExited(evt);
            }
        });
        btnGenerarReporteEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarReporteEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 140, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Usuario:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Telefono:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 116, -1, 30));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Correo:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 30));

        btnAgregarEmpleado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAgregarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/plus.png"))); // NOI18N
        btnAgregarEmpleado.setText("Agregar");
        btnAgregarEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnAgregarEmpleado.setContentAreaFilled(false);
        btnAgregarEmpleado.setPreferredSize(new java.awt.Dimension(71, 30));
        btnAgregarEmpleado.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                btnAgregarEmpleadoAncestorRemoved(evt);
            }
        });
        btnAgregarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarEmpleadoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarEmpleadoMouseEntered(evt);
            }
        });
        btnAgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 90, 40));

        cmbEstado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmbEstado.setModel(modeloComboEstado);
        jPanel1.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 120, 30));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Imagen:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 50, 30));
        jPanel1.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 120, 120));

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(modeloTablaEmpleados);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setGridColor(new java.awt.Color(0, 153, 51));
        jTable1.setSelectionBackground(new java.awt.Color(0, 204, 51));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 470, 110));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Tipo de");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, 20));

        jLabel27.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Estado:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, 30));

        jLabel29.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Pregunta de Seguridad #1");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, 20));

        cmdPregunta1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmdPregunta1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "¿Tu profesor favorito?", "¿Cumpleaños de tu madre?", "¿Mayor temor?", "¿Clima favorito?" }));
        jPanel1.add(cmdPregunta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 170, 30));

        jTFRespuesta1.setBackground(new java.awt.Color(204, 204, 204));
        jTFRespuesta1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFRespuesta1.setToolTipText("");
        jTFRespuesta1.setPreferredSize(new java.awt.Dimension(78, 30));
        jTFRespuesta1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFRespuesta1KeyTyped(evt);
            }
        });
        jPanel1.add(jTFRespuesta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 170, -1));

        jTFRespuesta2.setBackground(new java.awt.Color(204, 204, 204));
        jTFRespuesta2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFRespuesta2.setToolTipText("");
        jTFRespuesta2.setPreferredSize(new java.awt.Dimension(78, 30));
        jTFRespuesta2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFRespuesta2KeyTyped(evt);
            }
        });
        jPanel1.add(jTFRespuesta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 170, -1));

        cmdPregunta2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmdPregunta2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "¿Tu primer mascota?", "¿Color Favorito?", "¿Festividad favorita?" }));
        jPanel1.add(cmdPregunta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 170, 30));

        jLabel30.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Pregunta de Seguridad #2");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, 20));

        btnEliminarEmpleado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEliminarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/delete.png"))); // NOI18N
        btnEliminarEmpleado.setText("Eliminar");
        btnEliminarEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnEliminarEmpleado.setContentAreaFilled(false);
        btnEliminarEmpleado.setPreferredSize(new java.awt.Dimension(75, 30));
        btnEliminarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarEmpleadoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarEmpleadoMouseEntered(evt);
            }
        });
        btnEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 90, 40));

        btnGenerarReporteEmpleado1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnGenerarReporteEmpleado1.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarReporteEmpleado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/employee.png"))); // NOI18N
        btnGenerarReporteEmpleado1.setText("Empleados por Tipo");
        btnGenerarReporteEmpleado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnGenerarReporteEmpleado1.setContentAreaFilled(false);
        btnGenerarReporteEmpleado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGenerarReporteEmpleado1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGenerarReporteEmpleado1MouseEntered(evt);
            }
        });
        btnGenerarReporteEmpleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteEmpleado1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarReporteEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 170, 30));

        jTabbedPane1.addTab("Gestion de Empleados", jPanel1);

        jPanel2.setBackground(new java.awt.Color(30, 57, 42));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 196, 124)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbDocumento.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmbDocumento.setModel(modeloComboDocumentos);
        jPanel2.add(cmbDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 120, 30));

        jLabel31.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Selecciona un empleado:");
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 220, 30));

        jTable4.setModel(modeloTablaDocumentosEmpleados);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 325, 230));

        jLabel32.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Filtro:");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 40, 30));

        jTFBuscarCorreo.setBackground(new java.awt.Color(204, 204, 204));
        jTFBuscarCorreo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFBuscarCorreo.setToolTipText("");
        jTFBuscarCorreo.setPreferredSize(new java.awt.Dimension(78, 30));
        jTFBuscarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFBuscarCorreoActionPerformed(evt);
            }
        });
        jTFBuscarCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBuscarCorreoKeyReleased(evt);
            }
        });
        jPanel2.add(jTFBuscarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 140, -1));

        btnAgregarEmpleado1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAgregarEmpleado1.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarEmpleado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/plus.png"))); // NOI18N
        btnAgregarEmpleado1.setText("Agregar");
        btnAgregarEmpleado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnAgregarEmpleado1.setContentAreaFilled(false);
        btnAgregarEmpleado1.setPreferredSize(new java.awt.Dimension(71, 30));
        btnAgregarEmpleado1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                btnAgregarEmpleado1AncestorRemoved(evt);
            }
        });
        btnAgregarEmpleado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarEmpleado1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarEmpleado1MouseEntered(evt);
            }
        });
        btnAgregarEmpleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEmpleado1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 90, 40));

        btnReport.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnReport.setForeground(new java.awt.Color(255, 255, 255));
        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/report.png"))); // NOI18N
        btnReport.setText("Generar Reporte");
        btnReport.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnReport.setContentAreaFilled(false);
        btnReport.setPreferredSize(new java.awt.Dimension(75, 30));
        btnReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportMouseExited(evt);
            }
        });
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });
        jPanel2.add(btnReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 140, 40));

        btnEliminarEmpleado1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEliminarEmpleado1.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarEmpleado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/delete.png"))); // NOI18N
        btnEliminarEmpleado1.setText("Eliminar");
        btnEliminarEmpleado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnEliminarEmpleado1.setContentAreaFilled(false);
        btnEliminarEmpleado1.setPreferredSize(new java.awt.Dimension(75, 30));
        btnEliminarEmpleado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarEmpleado1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarEmpleado1MouseEntered(evt);
            }
        });
        btnEliminarEmpleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEmpleado1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 100, 40));

        jList1.setModel(modeloLista);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jList1);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 210, 190));

        lblEmpleadoDE.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblEmpleadoDE.setForeground(new java.awt.Color(255, 255, 255));
        lblEmpleadoDE.setText("Empleado:");
        jPanel2.add(lblEmpleadoDE, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, 30));

        jTFDescripcionDE.setBackground(new java.awt.Color(204, 204, 204));
        jTFDescripcionDE.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFDescripcionDE.setToolTipText("");
        jTFDescripcionDE.setPreferredSize(new java.awt.Dimension(78, 30));
        jTFDescripcionDE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFDescripcionDEKeyTyped(evt);
            }
        });
        jPanel2.add(jTFDescripcionDE, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 120, -1));

        jLabel34.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Valor:");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, 30));

        jLabel35.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Documento:");
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, 30));

        btnModificarEmpleado2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnModificarEmpleado2.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarEmpleado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/edit.png"))); // NOI18N
        btnModificarEmpleado2.setText("Modificar");
        btnModificarEmpleado2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnModificarEmpleado2.setContentAreaFilled(false);
        btnModificarEmpleado2.setPreferredSize(new java.awt.Dimension(75, 30));
        btnModificarEmpleado2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarEmpleado2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarEmpleado2MouseEntered(evt);
            }
        });
        btnModificarEmpleado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEmpleado2ActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificarEmpleado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 100, 40));

        btnReport1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnReport1.setForeground(new java.awt.Color(255, 255, 255));
        btnReport1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/documentos.png"))); // NOI18N
        btnReport1.setText("Documentos por Empleado");
        btnReport1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnReport1.setContentAreaFilled(false);
        btnReport1.setPreferredSize(new java.awt.Dimension(75, 30));
        btnReport1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReport1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReport1MouseExited(evt);
            }
        });
        btnReport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReport1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnReport1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 200, 40));

        jTabbedPane1.addTab("Documentos de  Empleados", jPanel2);

        jPanel3.setBackground(new java.awt.Color(30, 57, 42));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 196, 124)));
        jPanel3.setPreferredSize(new java.awt.Dimension(680, 500));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar.png"))); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        jPanel7.setBackground(new java.awt.Color(30, 57, 42));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestionar Documentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        jButton10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/report.png"))); // NOI18N
        jButton10.setText("Generar Reporte");
        jButton10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton10.setContentAreaFilled(false);
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

        jTable2.setBackground(new java.awt.Color(204, 204, 204));
        jTable2.setModel(modeloTablaDocumentos);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTFBuscarDocumento.setBackground(new java.awt.Color(204, 204, 204));
        jTFBuscarDocumento.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFBuscarDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBuscarDocumentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFBuscarDocumentoKeyTyped(evt);
            }
        });

        rdNombreDocumento.setBackground(new java.awt.Color(102, 102, 102));
        rdNombreDocumento.setForeground(new java.awt.Color(255, 255, 255));
        rdNombreDocumento.setText("Nombre");
        rdNombreDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNombreDocumentoActionPerformed(evt);
            }
        });

        rdCodigoDocumento.setBackground(new java.awt.Color(102, 102, 102));
        rdCodigoDocumento.setForeground(new java.awt.Color(255, 255, 255));
        rdCodigoDocumento.setText("Codigo");
        rdCodigoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCodigoDocumentoActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Buscar:");

        cmbEstadoD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        jTFNombreD.setBackground(new java.awt.Color(204, 204, 204));
        jTFNombreD.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFNombreD.setToolTipText("");
        jTFNombreD.setPreferredSize(new java.awt.Dimension(78, 30));
        jTFNombreD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFNombreDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFNombreDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreDKeyTyped(evt);
            }
        });

        lblCodigoDocumento.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCodigoDocumento.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoDocumento.setText("CODIGO DOCUMENTO");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estado:");

        btnAgregarD.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAgregarD.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/plus.png"))); // NOI18N
        btnAgregarD.setText("Agregar");
        btnAgregarD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnAgregarD.setContentAreaFilled(false);
        btnAgregarD.setPreferredSize(new java.awt.Dimension(71, 30));
        btnAgregarD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarDMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarDMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarDMouseEntered(evt);
            }
        });

        btnModificarD.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnModificarD.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/edit.png"))); // NOI18N
        btnModificarD.setText("Modificar");
        btnModificarD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnModificarD.setContentAreaFilled(false);
        btnModificarD.setPreferredSize(new java.awt.Dimension(75, 30));
        btnModificarD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarDMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarDMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarDMouseEntered(evt);
            }
        });

        btnEliminarD.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEliminarD.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/delete.png"))); // NOI18N
        btnEliminarD.setText("Eliminar");
        btnEliminarD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnEliminarD.setContentAreaFilled(false);
        btnEliminarD.setPreferredSize(new java.awt.Dimension(75, 30));
        btnEliminarD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarDMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarDMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarDMouseEntered(evt);
            }
        });

        rdEstadoDocumento.setBackground(new java.awt.Color(102, 102, 102));
        rdEstadoDocumento.setForeground(new java.awt.Color(255, 255, 255));
        rdEstadoDocumento.setText("Estado");
        rdEstadoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdEstadoDocumentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodigoDocumento)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(9, 9, 9)
                        .addComponent(jTFNombreD, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(17, 17, 17)
                        .addComponent(cmbEstadoD, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnAgregarD, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarD, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFBuscarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdNombreDocumento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdCodigoDocumento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdEstadoDocumento))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jButton10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel22)
                                .addComponent(jTFBuscarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdCodigoDocumento)
                                .addComponent(rdEstadoDocumento)
                                .addComponent(rdNombreDocumento)))
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(lblCodigoDocumento)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel6))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jTFNombreD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cmbEstadoD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnModificarD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEliminarD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 670, 210));

        jPanel8.setBackground(new java.awt.Color(30, 57, 42));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestionar Estado de los Empleados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));

        jButton11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/report.png"))); // NOI18N
        jButton11.setText("Generar Reporte");
        jButton11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton11.setContentAreaFilled(false);
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

        jTable3.setBackground(new java.awt.Color(204, 204, 204));
        jTable3.setModel(modeloTablaEstados);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jTFBuscarEstado.setBackground(new java.awt.Color(204, 204, 204));
        jTFBuscarEstado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFBuscarEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBuscarEstadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFBuscarEstadoKeyTyped(evt);
            }
        });

        rdNombreEstado.setBackground(new java.awt.Color(102, 102, 102));
        rdNombreEstado.setForeground(new java.awt.Color(255, 255, 255));
        rdNombreEstado.setText("Nombre");
        rdNombreEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNombreEstadoActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Buscar:");

        jTFNombreE.setBackground(new java.awt.Color(204, 204, 204));
        jTFNombreE.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFNombreE.setToolTipText("");
        jTFNombreE.setPreferredSize(new java.awt.Dimension(78, 30));
        jTFNombreE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreEKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFNombreEKeyReleased(evt);
            }
        });

        lblCodigoEstado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCodigoEstado.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoEstado.setText("CODIGO ESTADO");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nombre:");

        btnAgregarE.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAgregarE.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/plus.png"))); // NOI18N
        btnAgregarE.setText("Agregar");
        btnAgregarE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnAgregarE.setContentAreaFilled(false);
        btnAgregarE.setPreferredSize(new java.awt.Dimension(71, 30));
        btnAgregarE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarEMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarEMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarEMouseEntered(evt);
            }
        });
        btnAgregarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEActionPerformed(evt);
            }
        });

        btnModificarE.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnModificarE.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/edit.png"))); // NOI18N
        btnModificarE.setText("Modificar");
        btnModificarE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnModificarE.setContentAreaFilled(false);
        btnModificarE.setPreferredSize(new java.awt.Dimension(75, 30));
        btnModificarE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarEMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarEMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarEMouseEntered(evt);
            }
        });
        btnModificarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEActionPerformed(evt);
            }
        });

        jTFDescripcionE.setBackground(new java.awt.Color(204, 204, 204));
        jTFDescripcionE.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFDescripcionE.setToolTipText("");
        jTFDescripcionE.setPreferredSize(new java.awt.Dimension(78, 30));
        jTFDescripcionE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFDescripcionEKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Descripcion:");

        rdCodigoEstado.setBackground(new java.awt.Color(102, 102, 102));
        rdCodigoEstado.setForeground(new java.awt.Color(255, 255, 255));
        rdCodigoEstado.setText("Codigo");
        rdCodigoEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCodigoEstadoActionPerformed(evt);
            }
        });

        btnEliminarE.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEliminarE.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/delete.png"))); // NOI18N
        btnEliminarE.setText("Eliminar");
        btnEliminarE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnEliminarE.setContentAreaFilled(false);
        btnEliminarE.setPreferredSize(new java.awt.Dimension(75, 30));
        btnEliminarE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarEMouseExited(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Ingreso:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFDescripcionE, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(lblCodigoEstado))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(btnAgregarE, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificarE, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarE, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ingreso)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFBuscarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdNombreEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdCodigoEstado)
                                .addGap(0, 63, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton11)
                        .addGap(83, 83, 83))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24)
                                .addComponent(jTFBuscarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdNombreEstado)
                                .addComponent(rdCodigoEstado)))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lblCodigoEstado)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jTFDescripcionE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ingreso)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarE, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(btnModificarE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 670, 210));

        jTabbedPane1.addTab("Otros", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarActionPerformed
        // TODO add your handling code here:
        int resultado;
        fileChooser ventana = new fileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
        ventana.jfchCargarFoto.setFileFilter(filtro);
        resultado = ventana.jfchCargarFoto.showOpenDialog(null);
        if (JFileChooser.APPROVE_OPTION == resultado) {
            fichero = ventana.jfchCargarFoto.getSelectedFile();
            try {
                ImageIcon icon = new ImageIcon(fichero.toString());
                ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                lblFoto.setIcon(icono);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen " + ex);
            }
        }
    }//GEN-LAST:event_btnExaminarActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.hide();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void btnAgregarEmpleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarEmpleadoMouseEntered
        // TODO add your handling code here:
        btnAgregarEmpleado.setContentAreaFilled(true);
    }//GEN-LAST:event_btnAgregarEmpleadoMouseEntered

    private void btnAgregarEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarEmpleadoMouseExited

        btnAgregarEmpleado.setContentAreaFilled(false);
    }//GEN-LAST:event_btnAgregarEmpleadoMouseExited

    private void btnModificarEmpleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarEmpleadoMouseEntered
        // TODO add your handling code here:
        btnModificarEmpleado.setContentAreaFilled(true);
    }//GEN-LAST:event_btnModificarEmpleadoMouseEntered

    private void btnModificarEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarEmpleadoMouseExited
        // TODO add your handling code here:
        btnModificarEmpleado.setContentAreaFilled(false);
    }//GEN-LAST:event_btnModificarEmpleadoMouseExited

    private void btnLimpiarCamposMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarCamposMouseEntered
        // TODO add your handling code here:
        btnLimpiarCampos.setContentAreaFilled(true);
    }//GEN-LAST:event_btnLimpiarCamposMouseEntered

    private void btnLimpiarCamposMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarCamposMouseExited
        // TODO add your handling code here:
        btnLimpiarCampos.setContentAreaFilled(false);
    }//GEN-LAST:event_btnLimpiarCamposMouseExited

    private void btnExaminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExaminarMouseEntered
        // TODO add your handling code here:
        btnExaminar.setContentAreaFilled(true);
    }//GEN-LAST:event_btnExaminarMouseEntered

    private void btnExaminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExaminarMouseExited
        // TODO add your handling code here:
        btnExaminar.setContentAreaFilled(false);
    }//GEN-LAST:event_btnExaminarMouseExited

    private void btnGenerarReporteEmpleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarReporteEmpleadoMouseEntered
        // TODO add your handling code here:
        btnGenerarReporteEmpleado.setContentAreaFilled(true);
    }//GEN-LAST:event_btnGenerarReporteEmpleadoMouseEntered

    private void btnGenerarReporteEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarReporteEmpleadoMouseExited
        // TODO add your handling code here:
        btnGenerarReporteEmpleado.setContentAreaFilled(false);
    }//GEN-LAST:event_btnGenerarReporteEmpleadoMouseExited

    private void btnAgregarDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarDMouseEntered
        // TODO add your handling code here:
        btnAgregarD.setContentAreaFilled(true);
    }//GEN-LAST:event_btnAgregarDMouseEntered

    private void btnAgregarDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarDMouseExited
        // TODO add your handling code here:
        btnAgregarD.setContentAreaFilled(false);
    }//GEN-LAST:event_btnAgregarDMouseExited

    private void btnModificarDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarDMouseEntered
        // TODO add your handling code here:
        btnModificarD.setContentAreaFilled(true);
    }//GEN-LAST:event_btnModificarDMouseEntered

    private void btnModificarDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarDMouseExited
        // TODO add your handling code here:
        btnModificarD.setContentAreaFilled(false);
    }//GEN-LAST:event_btnModificarDMouseExited

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
        // TODO add your handling code here:
        jButton10.setContentAreaFilled(true);
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
        // TODO add your handling code here:
        jButton10.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton10MouseExited

    private void btnAgregarEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarEMouseEntered
        // TODO add your handling code here:
        btnAgregarE.setContentAreaFilled(true);
    }//GEN-LAST:event_btnAgregarEMouseEntered

    private void btnAgregarEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarEMouseExited
        // TODO add your handling code here:
        btnAgregarE.setContentAreaFilled(false);
    }//GEN-LAST:event_btnAgregarEMouseExited

    private void btnModificarEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarEMouseEntered
        // TODO add your handling code here:
        btnModificarE.setContentAreaFilled(true);
    }//GEN-LAST:event_btnModificarEMouseEntered

    private void btnModificarEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarEMouseExited
        // TODO add your handling code here:
        btnModificarE.setContentAreaFilled(false);
    }//GEN-LAST:event_btnModificarEMouseExited

    private void jButton11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseEntered
        // TODO add your handling code here:
        jButton11.setContentAreaFilled(true);
    }//GEN-LAST:event_jButton11MouseEntered

    private void jButton11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseExited
        // TODO add your handling code here:
        jButton11.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton11MouseExited

    private void btnAgregarEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarEMouseClicked
        // TODO add your handling code here:
        if (jTFNombreE.getText().isEmpty() || jTFDescripcionE.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error campos vacios");
        } else {
            mtoUsuarios objeto = new mtoUsuarios();
            objeto.setNombreE(jTFNombreE.getText());
            objeto.setDescripcionE(jTFDescripcionE.getText());
            if(ingreso.isSelected()){
                objeto.setIngreso(1);
            }else{
                objeto.setIngreso(0);
            }
            if (objeto.guardarEstadoEmpleado()) {
                JOptionPane.showMessageDialog(this, "Datos guardados correctamente");
                jTFNombreE.setText(null);
                jTFDescripcionE.setText(null);
                int filas = modeloTablaEstados.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaEstados.removeRow(0);
                }
                setFilasEstado(0, "");
            }
        }
    }//GEN-LAST:event_btnAgregarEMouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        CodigoEstado = String.valueOf(modeloTablaEstados.getValueAt(jTable3.getSelectedRow(), 0));
        lblCodigoEstado.setText("CODIGO ESTADO: " + CodigoEstado);
        NombreE = String.valueOf(modeloTablaEstados.getValueAt(jTable3.getSelectedRow(), 1));
        jTFNombreE.setText(NombreE);
        jTFDescripcionE.setText(String.valueOf(modeloTablaEstados.getValueAt(jTable3.getSelectedRow(), 2)));
        if(String.valueOf(modeloTablaEstados.getValueAt(jTable3.getSelectedRow(), 3)).equals("1")){
            ingreso.setSelected(true);
        }else{
            ingreso.setSelected(false);
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void btnModificarEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarEMouseClicked
        // TODO add your handling code here:
        if (jTFNombreE.getText().isEmpty() || jTFDescripcionE.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error campos vacios");
        } else {
            mtoUsuarios objeto = new mtoUsuarios();
            objeto.setCodigoE(Integer.valueOf(CodigoEstado));
            objeto.setNombreE(jTFNombreE.getText());
            objeto.setDescripcionE(jTFDescripcionE.getText());
            if(ingreso.isSelected()){
                objeto.setIngreso(1);
            }else{
                objeto.setIngreso(0);
            }
            System.out.println("ingreso: "+objeto.getIngreso());
            if (objeto.modificarEstadoEmpleado()) {
                JOptionPane.showMessageDialog(this, "Datos modificados correctamente");
                lblCodigoEstado.setText("CODIGO ESTADO");
                jTFNombreE.setText(null);
                jTFDescripcionE.setText(null);
                int filas = modeloTablaEstados.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaEstados.removeRow(0);
                }
                setFilasEstado(0, "");
            }
        }
    }//GEN-LAST:event_btnModificarEMouseClicked

    private void jTFBuscarEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarEstadoKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();

        if (verificar.vletrasynumeros(vchar) == true
                && (jTFBuscarEstado.getText().length() < 11)) {

        } else {
            evt.consume();
        }

    }//GEN-LAST:event_jTFBuscarEstadoKeyTyped
    int tipo_estado = 0;
    private void rdNombreEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNombreEstadoActionPerformed
        // TODO add your handling code here:
        rdCodigoEstado.setSelected(false);
        jTFBuscarEstado.setEnabled(true);
        tipo_estado = 2;
    }//GEN-LAST:event_rdNombreEstadoActionPerformed

    private void rdCodigoEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCodigoEstadoActionPerformed
        // TODO add your handling code here:
        rdNombreEstado.setSelected(false);
        jTFBuscarEstado.setEnabled(true);
        tipo_estado = 1;
    }//GEN-LAST:event_rdCodigoEstadoActionPerformed

    private void jTFBuscarEstadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarEstadoKeyReleased
        // TODO add your handling code here:
        if (rdCodigoEstado.isSelected()) {
            int filas = modeloTablaEstados.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaEstados.removeRow(0);
            }
            setFilasEstado(1, jTFBuscarEstado.getText());
        } else if (rdNombreEstado.isSelected()) {
            int filas = modeloTablaEstados.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaEstados.removeRow(0);
            }
            setFilasEstado(2, jTFBuscarEstado.getText());
        }
    }//GEN-LAST:event_jTFBuscarEstadoKeyReleased

    private void jTFNombreEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreEKeyReleased
        // TODO add your handling code here:
        mtoUsuarios objeto = new mtoUsuarios();
        objeto.setNombreE(jTFNombreE.getText());
        String datos[] = objeto.consultarEstado();
        if (jTFNombreE.getText().equals(datos[0])) {
            CodigoEstado = datos[2];
            lblCodigoEstado.setText("CODIGO ESTADO: " + datos[2]);
            DescripcionE = datos[1];
            jTFDescripcionE.setText(datos[1]);
        } else {
            lblCodigoEstado.setText("CODIGO ESTADO");
        }
    }//GEN-LAST:event_jTFNombreEKeyReleased

    private void btnEliminarEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEMouseClicked
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar este estado?", "Confirmacion",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION || response == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(this, "Estado no eliminado");
        } else {
            if (lblCodigoEstado.getText().equals("CODIGO ESTADO") || lblCodigoEstado.getText().equals("CODIGO ESTADO: ")) {
                JOptionPane.showMessageDialog(this, "No ha seleccionado ningun estado para eliminar");
            } else {
                mtoUsuarios objeto = new mtoUsuarios();
                objeto.setCodigoE(Integer.valueOf(CodigoEstado));
                if (objeto.eliminarEstadoEmpleado()) {
                    JOptionPane.showMessageDialog(this, "Estado eliminado correctamente");
                    lblCodigoEstado.setText("CODIGO ESTADO");
                    jTFNombreE.setText(null);
                    jTFDescripcionE.setText(null);
                    int filas = modeloTablaEstados.getRowCount();
                    for (int i = 0; filas > i; i++) {
                        modeloTablaEstados.removeRow(0);
                    }
                    setFilasEstado(0, "");
                } else {
                    JOptionPane.showMessageDialog(this, "Error existen empleados relacionados a este estado. \n Elimina o modifica antes a los empleados relacionados para poder eliminar este estado.");
                }
            }
        }
    }//GEN-LAST:event_btnEliminarEMouseClicked

    private void btnEliminarEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarEMouseEntered

    private void btnEliminarEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarEMouseExited

    private void btnEliminarDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarDMouseClicked
        // TODO add your handling code here:
        //Instanciar siempre las variable tipo String
        int response = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar este documento?", "Confirmacion",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION || response == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(this, "Documento no eliminado");
        } else {
            if (lblCodigoDocumento.getText().equals("CODIGO DOCUMENTO") || lblCodigoDocumento.getText().equals("CODIGO DOCUMENTO: ")) {
                JOptionPane.showMessageDialog(this, "No ha seleccionado ningun estado para eliminar");
            } else {
                mtoUsuarios objeto = new mtoUsuarios();
                objeto.setCodigoD(Integer.valueOf(CodigoDocumento));
                if (objeto.eliminarDocumento()) {
                    JOptionPane.showMessageDialog(this, "Documento eliminado correctamente");
                    lblCodigoDocumento.setText("CODIGO DOCUMENTO");
                    jTFNombreD.setText(null);
                    int filas = modeloTablaDocumentos.getRowCount();
                    for (int i = 0; filas > i; i++) {
                        modeloTablaDocumentos.removeRow(0);
                    }
                    setFilasDocumentos(0, "");
                } else {
                    JOptionPane.showMessageDialog(this, "Error existen empleados relacionados a este documento. \n Elimina o modifica antes a los empleados relacionados para poder eliminar este documento.");
                }
            }
        }
    }//GEN-LAST:event_btnEliminarDMouseClicked

    private void btnEliminarDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarDMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarDMouseEntered

    private void btnEliminarDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarDMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarDMouseExited
    int tipo = 0;
    private void rdNombreDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNombreDocumentoActionPerformed
        // TODO add your handling code here:
        rdCodigoDocumento.setSelected(false);
        rdEstadoDocumento.setSelected(false);
        jTFBuscarDocumento.setEnabled(true);
        tipo = 1;
    }//GEN-LAST:event_rdNombreDocumentoActionPerformed

    private void rdCodigoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCodigoDocumentoActionPerformed
        // TODO add your handling code here:
        rdNombreDocumento.setSelected(false);
        rdEstadoDocumento.setSelected(false);
        jTFBuscarDocumento.setEnabled(true);
        tipo = 3;
    }//GEN-LAST:event_rdCodigoDocumentoActionPerformed

    private void rdEstadoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdEstadoDocumentoActionPerformed
        // TODO add your handling code here:
        rdCodigoDocumento.setSelected(false);
        rdNombreDocumento.setSelected(false);
        jTFBuscarDocumento.setEnabled(true);
        tipo = 2;
    }//GEN-LAST:event_rdEstadoDocumentoActionPerformed

    private void jTFBuscarDocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarDocumentoKeyReleased
        // TODO add your handling code here:
        if (rdCodigoDocumento.isSelected()) {
            int filas = modeloTablaDocumentos.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaDocumentos.removeRow(0);
            }
            setFilasDocumentos(1, jTFBuscarDocumento.getText());
        } else if (rdNombreDocumento.isSelected()) {
            int filas = modeloTablaDocumentos.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaDocumentos.removeRow(0);
            }
            setFilasDocumentos(2, jTFBuscarDocumento.getText());
        } else if (rdEstadoDocumento.isSelected()) {
            int filas = modeloTablaDocumentos.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaDocumentos.removeRow(0);
            }
            setFilasDocumentos(3, jTFBuscarDocumento.getText());
        }
    }//GEN-LAST:event_jTFBuscarDocumentoKeyReleased

    private void btnAgregarDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarDMouseClicked
        // TODO add your handling code here:
        if (jTFNombreD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error campos vacios");
        } else {
            mtoUsuarios objeto = new mtoUsuarios();
            objeto.setNombreD(jTFNombreD.getText());
            objeto.setEstadoD(String.valueOf(cmbEstadoD.getSelectedItem()));
            if (objeto.guardarDocumento()) {
                JOptionPane.showMessageDialog(this, "Datos guardados correctamente");
                jTFNombreD.setText(null);
                cmbEstadoD.setSelectedIndex(0);
                int filas = modeloTablaDocumentos.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaDocumentos.removeRow(0);
                }
                setFilasDocumentos(0, "");
            }
        }
    }//GEN-LAST:event_btnAgregarDMouseClicked

    private void btnModificarDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarDMouseClicked
        // TODO add your handling code here:
        if (jTFNombreD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error campos vacios");
        } else {
            mtoUsuarios objeto = new mtoUsuarios();
            objeto.setCodigoD(Integer.valueOf(CodigoDocumento));
            objeto.setNombreD(jTFNombreD.getText());
            objeto.setEstadoD(String.valueOf(cmbEstadoD.getSelectedItem()));
            if (objeto.modificarDocumento()) {
                JOptionPane.showMessageDialog(this, "Datos modificados correctamente");
                jTFNombreD.setText(null);
                int filas = modeloTablaDocumentos.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaDocumentos.removeRow(0);
                }
                setFilasDocumentos(0, "");
            }
        }
    }//GEN-LAST:event_btnModificarDMouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        CodigoDocumento = String.valueOf(modeloTablaDocumentos.getValueAt(jTable2.getSelectedRow(), 0));
        lblCodigoDocumento.setText("CODIGO DOCUMENTO: " + CodigoDocumento);
        NombreD = String.valueOf(modeloTablaDocumentos.getValueAt(jTable2.getSelectedRow(), 1));
        jTFNombreD.setText(NombreD);
        cmbEstadoD.setSelectedItem(String.valueOf(modeloTablaDocumentos.getValueAt(jTable2.getSelectedRow(), 2)));
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTFNombreDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreDKeyReleased
        // TODO add your handling code here:
        mtoUsuarios objeto = new mtoUsuarios();
        objeto.setNombreD(jTFNombreD.getText());
        String datos[] = objeto.consultarDocumento();
        if (jTFNombreD.getText().equals(datos[0])) {
            CodigoDocumento = datos[2];
            lblCodigoDocumento.setText("CODIGO DOCUMENTO: " + datos[2]);
            cmbEstadoD.setSelectedItem(datos[1]);
        } else if (jTFNombreD.getText().equals("")) {
            lblCodigoDocumento.setText("CODIGO DOCUMENTO");
        }
    }//GEN-LAST:event_jTFNombreDKeyReleased

    private void jTFNombreDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreDKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTFNombreDKeyPressed

    private void btnAgregarEmpleadoAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btnAgregarEmpleadoAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarEmpleadoAncestorRemoved

    private void btnAgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpleadoActionPerformed
        // TODO add your handling code here:
        verificaciones obj = new verificaciones();

        mtoUsuarios objeto = new mtoUsuarios();
        if (obj.vcorreo(jTFCorreo.getText())) {
            objeto.setNombreEmpleado(jTFNombreEmpleado.getText());
            objeto.setApellidoEmpleado(jTFApellido.getText());
            objeto.setTelefono(Integer.valueOf(jTFTelefono.getText()));
            objeto.setCorreoEmpleado(jTFCorreo.getText());
            cleartext = jTFContraseña.getText();
//        objeto.setContraseñaEmpleado(cleartext);
            try {
                objeto.setContraseñaEmpleado(cleartext);
            } catch (Exception ex) {
                Logger.getLogger(PEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }

            objeto.setDireccion(jTFDireccion.getText());
            objeto.setImagen(String.valueOf(fichero));
            objeto.setPregunta1(String.valueOf(cmdPregunta1.getSelectedItem()));
            objeto.setRespuesta1(String.valueOf(jTFRespuesta1.getText()));
            objeto.setPregunta2(String.valueOf(cmdPregunta2.getSelectedItem()));
            objeto.setRespuesta2(String.valueOf(jTFRespuesta2.getText()));
            try {
                //0 TipoUsuario, 1 Estado
                String[] valores = {String.valueOf(cmbTipoUsuario.getSelectedItem()), String.valueOf(cmbEstado.getSelectedItem())};

                String[] consultas = {"SELECT idTipo FROM tipoUsuario WHERE nombreTipo='" + valores[0] + "'", "SELECT idEstado FROM estadoEmpleado WHERE nombreEstado='" + valores[1] + "'"};
                PreparedStatement cmd1 = con.conectar().prepareStatement(consultas[0]);
                PreparedStatement cmd2 = con.conectar().prepareStatement(consultas[1]);
                ResultSet ver1 = cmd1.executeQuery();
                ResultSet ver2 = cmd2.executeQuery();
                if (ver1.next()) {
                    objeto.setCodigoTipo(ver1.getInt(1));
                }
                if (ver2.next()) {
                    objeto.setCodigoEstado(ver2.getInt(1));
                }
                cmd1.close();
                cmd2.close();
                con.conectar().close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

            if (objeto.guardarEmpleado()) {
                JOptionPane.showMessageDialog(this, "Usuario Empleado guardado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error Usuario Empleado no guardado");
            }
            int filas = modeloTablaEmpleados.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaEmpleados.removeRow(0);
            }
            setFilasEmpleado(0, "");

        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un correo con formato valido");
        }
    }//GEN-LAST:event_btnAgregarEmpleadoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        CodigoEmpleado = (String.valueOf(modeloTablaEmpleados.getValueAt(jTable1.getSelectedRow(), (0))));
        lblCodigoEmpleado.setText("CODIGO EMPLEADO: " + CodigoEmpleado);
        cmbTipoUsuario.setSelectedItem(String.valueOf(modeloTablaEmpleados.getValueAt(jTable1.getSelectedRow(), (1))));
        jTFNombreEmpleado.setText(String.valueOf(modeloTablaEmpleados.getValueAt(jTable1.getSelectedRow(), (2))));
        jTFApellido.setText(String.valueOf(modeloTablaEmpleados.getValueAt(jTable1.getSelectedRow(), (3))));
        jTFTelefono.setText(String.valueOf(modeloTablaEmpleados.getValueAt(jTable1.getSelectedRow(), (4))));
        jTFCorreo.setText(String.valueOf(modeloTablaEmpleados.getValueAt(jTable1.getSelectedRow(), (5))));
        jTFDireccion.setText(String.valueOf(modeloTablaEmpleados.getValueAt(jTable1.getSelectedRow(), (6))));
        cmbEstado.setSelectedItem(String.valueOf(modeloTablaEmpleados.getValueAt(jTable1.getSelectedRow(), (7))));
        try {
            verificaciones obj = new verificaciones();
            //esto es
            String sql = "SELECT imagen, CONVERT(varchar(max),Decryptbypassphrase('FCBarcelona321',(select contraseña from usuarioEmpleado where idEmpleado=" + modeloTablaEmpleados.getValueAt(jTable1.getSelectedRow(), (0)) + "))) as contraseña, pregunta1, respuesta1, pregunta2, respuesta2 "
                    + "FROM usuarioEmpleado WHERE idEmpleado='" + modeloTablaEmpleados.getValueAt(jTable1.getSelectedRow(), (0)) + "'";
            PreparedStatement cmd = cn.conectar().prepareStatement(sql);
            ResultSet ver = cmd.executeQuery();
            if (ver.next()) {
                datos = ver.getString(1);
                ImageIcon icon = new ImageIcon(ver.getString(1));
                ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                lblFoto.setIcon(icono);
                jTFContraseña.setText(ver.getString(2));
                cmdPregunta1.setSelectedItem(ver.getString(3));
                jTFRespuesta1.setText(ver.getString(4));
                cmdPregunta2.setSelectedItem(ver.getString(5));
                jTFRespuesta2.setText(ver.getString(6));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEmpleadoActionPerformed
        // TODO add your handling code here:
        mtoUsuarios objeto = new mtoUsuarios();
        verificaciones obj = new verificaciones();
        if (obj.vcorreo(jTFCorreo.getText())) {
            objeto.setCodigoEmpleado(Integer.valueOf(CodigoEmpleado));
            objeto.setNombreEmpleado(jTFNombreEmpleado.getText());
            objeto.setApellidoEmpleado(jTFApellido.getText());
            objeto.setTelefono(Integer.valueOf(jTFTelefono.getText()));
            objeto.setCorreoEmpleado(jTFCorreo.getText());
            objeto.setContraseñaEmpleado(jTFContraseña.getText());
           

            objeto.setDireccion(jTFDireccion.getText());
            objeto.setImagen(String.valueOf(fichero));
            objeto.setPregunta1(String.valueOf(cmdPregunta1.getSelectedItem()));
            objeto.setRespuesta1(String.valueOf(jTFRespuesta1.getText()));
            objeto.setPregunta2(String.valueOf(cmdPregunta2.getSelectedItem()));
            objeto.setRespuesta2(String.valueOf(jTFRespuesta2.getText()));
            try {
                //0 TipoUsuario, 1 Estado
                String[] valores = {String.valueOf(cmbTipoUsuario.getSelectedItem()), String.valueOf(cmbEstado.getSelectedItem())};
                for (String e : valores) {
                    System.out.println("Valores " + e);
                }
                String[] consultas = {"SELECT idTipo FROM tipoUsuario WHERE nombreTipo='" + valores[0] + "'", "SELECT idEstado FROM estadoEmpleado WHERE nombreEstado='" + valores[1] + "'"};
                PreparedStatement cmd1 = con.conectar().prepareStatement(consultas[0]);
                PreparedStatement cmd2 = con.conectar().prepareStatement(consultas[1]);
                ResultSet ver1 = cmd1.executeQuery();
                ResultSet ver2 = cmd2.executeQuery();
                if (ver1.next()) {
                    objeto.setCodigoTipo(ver1.getInt(1));
                }
                if (ver2.next()) {
                    objeto.setCodigoEstado(ver2.getInt(1));
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

            if (objeto.modificarEmpleado()) {
                JOptionPane.showMessageDialog(this, "Usuario Empleado modificado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error Usuario Empleado no modificado");
            }
            int filas = modeloTablaEmpleados.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaEmpleados.removeRow(0);
            }
            setFilasEmpleado(0, "");
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un correo con formato valido");
        }
    }//GEN-LAST:event_btnModificarEmpleadoActionPerformed

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed
        // TODO add your handling code here:
        jTFNombreEmpleado.setText(null);
        jTFApellido.setText(null);
        jTFTelefono.setText(null);
        jTFCorreo.setText(null);
        jTFContraseña.setText(null);
        jTFDireccion.setText(null);
        jTFRespuesta1.setText(null);
        jTFRespuesta2.setText(null);
        cmdPregunta1.setSelectedIndex(0);
        cmdPregunta2.setSelectedIndex(0);
        cmbEstado.setSelectedIndex(0);
        cmbTipoUsuario.setSelectedIndex(0);
    }//GEN-LAST:event_btnLimpiarCamposActionPerformed

    private void btnEliminarEmpleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarEmpleadoMouseEntered

    private void btnEliminarEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarEmpleadoMouseExited

    private void btnEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoActionPerformed
        // TODO add your handling code here:
        Integer codE = Integer.valueOf(CodigoEmpleado);
        if (codE != null || codE != 0) {
            try {
                Conexion cn = new Conexion();
                String sql = "DELETE FROM usuarioEmpleado WHERE idEmpleado=" + codE;
                PreparedStatement cmd = cn.conectar().prepareStatement(sql);
                if (!cmd.execute()) {
                    JOptionPane.showMessageDialog(this, "Empleado eliminado");
                    int filas = modeloTablaEmpleados.getRowCount();
                    for (int i = 0; filas > i; i++) {
                        modeloTablaEmpleados.removeRow(0);
                    }
                    setFilasEmpleado(0, "");
                }

            } catch (Exception e) {
                System.out.println("eliminar e: " + e);
            }

        }
    }//GEN-LAST:event_btnEliminarEmpleadoActionPerformed

    private void rdNombreEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNombreEmpleadoActionPerformed
        // TODO add your handling code here:
        rdCodigoEmpleado.setSelected(false);
        jTFBuscarEmpleado.setEnabled(true);
        tipo2 = 2;
    }//GEN-LAST:event_rdNombreEmpleadoActionPerformed

    private void rdCodigoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCodigoEmpleadoActionPerformed
        // TODO add your handling code here:
        rdNombreEmpleado.setSelected(false);
        jTFBuscarEmpleado.setEnabled(true);
        tipo2 = 1;
    }//GEN-LAST:event_rdCodigoEmpleadoActionPerformed

    private void jTFBuscarEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarEmpleadoKeyReleased
        // TODO add your handling code here:
        if (rdNombreEmpleado.isSelected()) {
            int filas = modeloTablaEmpleados.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaEmpleados.removeRow(0);
            }
            setFilasEmpleado(2, jTFBuscarEmpleado.getText());
        } else if (rdCodigoEmpleado.isSelected()) {
            int filas = modeloTablaEmpleados.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaEmpleados.removeRow(0);
            }
            setFilasEmpleado(1, jTFBuscarEmpleado.getText());
        }
    }//GEN-LAST:event_jTFBuscarEmpleadoKeyReleased

    private void btnAgregarEmpleado1AncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btnAgregarEmpleado1AncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarEmpleado1AncestorRemoved

    private void btnAgregarEmpleado1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarEmpleado1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarEmpleado1MouseEntered

    private void btnAgregarEmpleado1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarEmpleado1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarEmpleado1MouseExited

    private void btnAgregarEmpleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpleado1ActionPerformed
        // TODO add your handling code here:
        if (jTFDescripcionDE.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, " Error campos vacios");
        } else {
            mtoUsuarios obj = new mtoUsuarios();
            Conexion cn = new Conexion();
            try {
                String sql = "SELECT idDocumento FROM documento WHERE nombre='" + String.valueOf(cmbDocumento.getSelectedItem()) + "'";
                PreparedStatement cmd = cn.conectar().prepareStatement(sql);
                ResultSet ver = cmd.executeQuery();
                if (ver.next()) {
                    obj.setCodigoDD(ver.getInt(1));
                }

                System.out.println("Correo: " + nombreEmpleadoDE);
                String sql2 = "SELECT idEmpleado FROM usuarioEmpleado WHERE correoElectronico='" + nombreEmpleadoDE + "'";
                PreparedStatement cmd2 = cn.conectar().prepareStatement(sql2);
                ResultSet ver2 = cmd2.executeQuery();
                if (ver2.next()) {
                    obj.setCodigoDE(ver2.getInt(1));
                }

            } catch (Exception e) {
                System.out.println("Boton");
                System.out.println(e.toString());
            }
            obj.setDescrip(jTFDescripcionDE.getText());
            if (obj.guardarDocumentoEmpleado()) {
                JOptionPane.showMessageDialog(this, "Documento agregado correctamente al empleado: " + nombreEmpleadoDE);
                int filas = modeloTablaDocumentosEmpleados.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaDocumentosEmpleados.removeRow(0);
                }
                setFilasDocumentosEmpleados(1, nombreEmpleadoDE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar documentos");
            }
        }
    }//GEN-LAST:event_btnAgregarEmpleado1ActionPerformed

    private void btnReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportMouseEntered

    private void btnReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportMouseExited

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        String path = "";
        try {
            Conexion con = new Conexion();
//            //establecemos la ruta donde esta el reportes
//            path = getClass().getResource("/reportes/Secciones.jasper").getPath();
//            //se decodifica por algun caracter especial
//            path = URLDecoder.decode(path,"UTF-8");
//            System.out.println("path: "+path);
//            //Se crea la conexion
//            
//            //Se crean los parametros
//            Map parametros = new HashMap();
//            parametros.put("Nombre","Steven Diaz");
//            //Se crea el objeto reporte
//            JasperReport reporte = (JasperReport)JRLoader.loadObject(path);
//            //se crea el objeto de impresion del reporte 
//            JasperPrint imprimir = JasperFillManager.fillReport(reporte,parametros,con.conectar());
//            //ahora se crea el visor, donde se muestra el reporte
//            JasperViewer visor = new JasperViewer(imprimir, false);
//            visor.setTitle("Reporte de proyectos e integrantes");
//            visor.setVisible(true);

            String archivo = getClass().getResource("/reportes/ReporteDocumentos.jrxml").getPath();
            archivo = URLDecoder.decode(archivo, "UTF-8");
            JasperReport report = JasperCompileManager.compileReport(archivo);
            Map parametros = new HashMap();
            parametros.put("imagen", "F:\\2018\\Ejercicio2.png");
            parametros.put("nombre", String.valueOf(jList1.getSelectedValue()));
            try {
                String sql = "SELECT numRegistro, nombreEmpresa, domicilioLegal, fechaConstitucion, logo, telefono, correoElectronico, propietario "
                        + "FROM datosEmpresa";
                PreparedStatement cmd = con.conectar().prepareStatement(sql);
                ResultSet ver = cmd.executeQuery();
                if (ver.next()) {
                    parametros.put("#registro", ver.getInt(1));
                    parametros.put("nombreEmpresa", ver.getString(2));
                    parametros.put("domicilio", ver.getString(3));
                    parametros.put("fechaConstitucion", ver.getString(4));
                    parametros.put("imagen", ver.getString(5));
                    parametros.put("telefono", ver.getString(6));
                    parametros.put("correo", ver.getString(7));
                    parametros.put("propietario", ver.getString(8));
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
            System.out.println("AQUI2");
            Logger.getLogger(PInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReportActionPerformed

    private void btnEliminarEmpleado1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEmpleado1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarEmpleado1MouseEntered

    private void btnEliminarEmpleado1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEmpleado1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarEmpleado1MouseExited

    private void btnEliminarEmpleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEmpleado1ActionPerformed
        // TODO add your handling code here:
        if (CodigoDocumentoDD.equals("")) {
            JOptionPane.showMessageDialog(this, "Error selecciona un documento para eliminar");
        } else {
            mtoUsuarios obj = new mtoUsuarios();
            obj.setCodigoDEE(Integer.valueOf(CodigoDocumentoDD));
            if (obj.eliminarDocumentoEmpleado()) {
                JOptionPane.showMessageDialog(this, "Documento elminado");
                int filas = modeloTablaDocumentosEmpleados.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaDocumentosEmpleados.removeRow(0);
                }
                setFilasDocumentosEmpleados(1, nombreEmpleadoDE);
                cmbDocumento.setSelectedIndex(0);
                jTFDescripcionDE.setText(null);
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar documento");
            }
        }
    }//GEN-LAST:event_btnEliminarEmpleado1ActionPerformed

    private void jTFBuscarCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarCorreoKeyReleased
        // TODO add your handling code here:
        modeloLista.removeAllElements();
        llenarList(1, jTFBuscarCorreo.getText());
    }//GEN-LAST:event_jTFBuscarCorreoKeyReleased

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        cmbDocumento.setEnabled(true);
        int filas = modeloTablaDocumentosEmpleados.getRowCount();
        for (int i = 0; filas > i; i++) {
            modeloTablaDocumentosEmpleados.removeRow(0);
        }
        setFilasDocumentosEmpleados(1, String.valueOf(jList1.getSelectedValue()));
        nombreEmpleadoDE = String.valueOf(jList1.getSelectedValue());
        lblEmpleadoDE.setText("Empleado: " + nombreEmpleadoDE);
    }//GEN-LAST:event_jList1MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        cmbDocumento.setEnabled(false);
        CodigoDocumentoDD = String.valueOf(modeloTablaDocumentosEmpleados.getValueAt(jTable4.getSelectedRow(), (0)));
        cmbDocumento.setSelectedItem(String.valueOf(modeloTablaDocumentosEmpleados.getValueAt(jTable4.getSelectedRow(), (1))));
        jTFDescripcionDE.setText(String.valueOf(modeloTablaDocumentosEmpleados.getValueAt(jTable4.getSelectedRow(), (3))));
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTFNombreEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreEmpleadoKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();

        if (verificar.vletras(vchar) == true
                && (jTFNombreEmpleado.getText().length() < 30)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFNombreEmpleadoKeyTyped

    private void jTFApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidoKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();

        if (verificar.vletras(vchar) == true
                && (jTFApellido.getText().length() < 30)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFApellidoKeyTyped

    private void jTFTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelefonoKeyTyped
        // TODO add your handling code here:char vchar = evt.getKeyChar();
        char vchar = evt.getKeyChar();

        if (verificar.vnumeros(vchar) == true
                && (jTFTelefono.getText().length() < 8)) {

        } else {
            evt.consume();
        }

    }//GEN-LAST:event_jTFTelefonoKeyTyped

    private void jTFCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCorreoKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();

        if (verificar.vcorreoevent(vchar) == true
                && (jTFCorreo.getText().length() < 30)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFCorreoKeyTyped

    private void jTFContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFContraseñaKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();

        if (verificar.vletrasynumeros(vchar) == true
                && (jTFContraseña.getText().length() < 20)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFContraseñaKeyTyped

    private void jTFDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDireccionKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();

        if (verificar.vletrasynumeros(vchar) == true
                && (jTFDireccion.getText().length() < 40)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFDireccionKeyTyped

    private void jTFBuscarEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarEmpleadoKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();

        if (verificar.vletrasynumeros(vchar) == true
                && (jTFBuscarEmpleado.getText().length() < 20)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFBuscarEmpleadoKeyTyped

    private void jTFRespuesta1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFRespuesta1KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();

        if (verificar.vletras(vchar) == true
                && (jTFRespuesta1.getText().length() < 30)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFRespuesta1KeyTyped

    private void jTFRespuesta2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFRespuesta2KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();

        if (verificar.vletras(vchar) == true
                && (jTFRespuesta2.getText().length() < 20)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFRespuesta2KeyTyped

    private void jTFDescripcionDEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDescripcionDEKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();

        if (verificar.vnumeros(vchar) == true
                && (jTFDescripcionDE.getText().length() < 14)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFDescripcionDEKeyTyped

    private void jTFBuscarDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarDocumentoKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();

        if (verificar.vletrasynumeros(vchar) == true
                && (jTFBuscarDocumento.getText().length() < 14)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFBuscarDocumentoKeyTyped

    private void jTFNombreDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreDKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();

        if (verificar.vletras(vchar) == true
                && (jTFNombreD.getText().length() < 20)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFNombreDKeyTyped

    private void jTFNombreEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreEKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();

        if (verificar.vletras(vchar) == true
                && (jTFNombreE.getText().length() < 20)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFNombreEKeyTyped

    private void jTFDescripcionEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDescripcionEKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();

        if (verificar.vletrasynumeros(vchar) == true
                && (jTFDescripcionE.getText().length() < 40)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFDescripcionEKeyTyped

    private void lblhelp2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblhelp2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblhelp2AncestorAdded

    private void lblhelp2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhelp2MouseClicked
        // TODO add your handling code here:
        //y cuando llames el formulario ayuda en vez del 0 le vas a poner el form que le corresponda 1 2 o 3 y asi sucesivamente, si vos elegis el orden
        /**
         * ahorita, llena los textos de ayuda de todos los forms, luego vemos lo
         * de las imagenes , me avisas cuando temrines de escribir las
         * instrucciones
         */
        help form = new help(9);
        form.show();
    }//GEN-LAST:event_lblhelp2MouseClicked

    private void lblhelp1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblhelp1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblhelp1AncestorAdded

    private void lblhelp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhelp1MouseClicked
        // TODO add your handling code here:
        //y cuando llames el formulario ayuda en vez del 0 le vas a poner el form que le corresponda 1 2 o 3 y asi sucesivamente, si vos elegis el orden
        /**
         * ahorita, llena los textos de ayuda de todos los forms, luego vemos lo
         * de las imagenes , me avisas cuando temrines de escribir las
         * instrucciones
         */
        help form = new help(9);
        form.show();
    }//GEN-LAST:event_lblhelp1MouseClicked

    private void lblhelpAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblhelpAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblhelpAncestorAdded

    private void lblhelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhelpMouseClicked
        // TODO add your handling code here:
        //y cuando llames el formulario ayuda en vez del 0 le vas a poner el form que le corresponda 1 2 o 3 y asi sucesivamente, si vos elegis el orden
        /**
         * ahorita, llena los textos de ayuda de todos los forms, luego vemos lo
         * de las imagenes , me avisas cuando temrines de escribir las
         * instrucciones
         */
        help form = new help(9);
        form.show();
    }//GEN-LAST:event_lblhelpMouseClicked

    private void btnModificarEmpleado2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarEmpleado2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarEmpleado2MouseEntered

    private void btnModificarEmpleado2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarEmpleado2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarEmpleado2MouseExited

    private void btnModificarEmpleado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEmpleado2ActionPerformed
        // TODO add your handling code here:
        if (!jTFDescripcionDE.getText().isEmpty()) {
            mtoUsuarios obj = new mtoUsuarios();
            obj.setDescrip(jTFDescripcionDE.getText());
            obj.setCodigoDEE(Integer.valueOf(CodigoDocumentoDD) );
            if (obj.modificarDocumentoEmpleado()) {
                JOptionPane.showMessageDialog(this,"Documento empleado modificado");
                int filas = modeloTablaDocumentosEmpleados.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaDocumentosEmpleados.removeRow(0);
                }
                setFilasDocumentosEmpleados(1, nombreEmpleadoDE);
            }
        }else{
            JOptionPane.showMessageDialog(this,"error campos vacios");
        }
    }//GEN-LAST:event_btnModificarEmpleado2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String path = "";
        try {
            Conexion con = new Conexion();
//            //establecemos la ruta donde esta el reportes
//            path = getClass().getResource("/reportes/Secciones.jasper").getPath();
//            //se decodifica por algun caracter especial
//            path = URLDecoder.decode(path,"UTF-8");
//            System.out.println("path: "+path);
//            //Se crea la conexion
//            
//            //Se crean los parametros
//            Map parametros = new HashMap();
//            parametros.put("Nombre","Steven Diaz");
//            //Se crea el objeto reporte
//            JasperReport reporte = (JasperReport)JRLoader.loadObject(path);
//            //se crea el objeto de impresion del reporte 
//            JasperPrint imprimir = JasperFillManager.fillReport(reporte,parametros,con.conectar());
//            //ahora se crea el visor, donde se muestra el reporte
//            JasperViewer visor = new JasperViewer(imprimir, false);
//            visor.setTitle("Reporte de proyectos e integrantes");
//            visor.setVisible(true);

            String archivo = getClass().getResource("/reportes/ReporteDocumento.jrxml").getPath();
            archivo = URLDecoder.decode(archivo, "UTF-8");
            JasperReport report = JasperCompileManager.compileReport(archivo);
            Map parametros = new HashMap();
            try {
                String sql = "SELECT numRegistro, nombreEmpresa, domicilioLegal, fechaConstitucion, logo, telefono, correoElectronico, propietario "
                        + "FROM datosEmpresa";
                PreparedStatement cmd = con.conectar().prepareStatement(sql);
                ResultSet ver = cmd.executeQuery();
                if (ver.next()) {
                    parametros.put("#registro", ver.getInt(1));
                    parametros.put("nombreEmpresa", ver.getString(2));
                    parametros.put("domicilio", ver.getString(3));
                    parametros.put("fechaConstitucion", ver.getString(4));
                    parametros.put("imagen", ver.getString(5));
                    parametros.put("telefono", ver.getString(6));
                    parametros.put("correo", ver.getString(7));
                    parametros.put("propietario", ver.getString(8));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            parametros.put("autor", correo);
            parametros.put("nombreD", jTFBuscarDocumento.getText());
            parametros.put("tipo", tipo);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, con.conectar());

            JasperViewer visor = new JasperViewer(print, false);
            visor.setTitle("Reporte de Documentos");
            visor.setVisible(true);

        } catch (JRException e) {
            System.out.println("AQUI1");
            System.out.println(e.getMessage());

        } catch (UnsupportedEncodingException ex) {
            System.out.println("AQUI2");
            Logger.getLogger(PInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String path = "";
        try {
            Conexion con = new Conexion();
//            //establecemos la ruta donde esta el reportes
//            path = getClass().getResource("/reportes/Secciones.jasper").getPath();
//            //se decodifica por algun caracter especial
//            path = URLDecoder.decode(path,"UTF-8");
//            System.out.println("path: "+path);
//            //Se crea la conexion
//            
//            //Se crean los parametros
//            Map parametros = new HashMap();
//            parametros.put("Nombre","Steven Diaz");
//            //Se crea el objeto reporte
//            JasperReport reporte = (JasperReport)JRLoader.loadObject(path);
//            //se crea el objeto de impresion del reporte 
//            JasperPrint imprimir = JasperFillManager.fillReport(reporte,parametros,con.conectar());
//            //ahora se crea el visor, donde se muestra el reporte
//            JasperViewer visor = new JasperViewer(imprimir, false);
//            visor.setTitle("Reporte de proyectos e integrantes");
//            visor.setVisible(true);

            String archivo = getClass().getResource("/reportes/ReporteEstadosE.jrxml").getPath();
            archivo = URLDecoder.decode(archivo, "UTF-8");
            JasperReport report = JasperCompileManager.compileReport(archivo);
            Map parametros = new HashMap();
            try {
                String sql = "SELECT numRegistro, nombreEmpresa, domicilioLegal, fechaConstitucion, logo, telefono, correoElectronico, propietario "
                        + "FROM datosEmpresa";
                PreparedStatement cmd = con.conectar().prepareStatement(sql);
                ResultSet ver = cmd.executeQuery();
                if (ver.next()) {
                    parametros.put("#registro", ver.getInt(1));
                    parametros.put("nombreEmpresa", ver.getString(2));
                    parametros.put("domicilio", ver.getString(3));
                    parametros.put("fechaConstitucion", ver.getString(4));
                    parametros.put("imagen", ver.getString(5));
                    parametros.put("telefono", ver.getString(6));
                    parametros.put("correo", ver.getString(7));
                    parametros.put("propietario", ver.getString(8));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            parametros.put("autor", correo);
            parametros.put("nombreEs", jTFBuscarEstado.getText());
            parametros.put("tipo", tipo_estado);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, con.conectar());

            JasperViewer visor = new JasperViewer(print, false);
            visor.setTitle("Reporte de Estado Empleados");
            visor.setVisible(true);

        } catch (JRException e) {
            System.out.println("AQUI1");
            System.out.println(e.getMessage());

        } catch (UnsupportedEncodingException ex) {
            System.out.println("AQUI2");
            Logger.getLogger(PInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed
    int tipo2 = 0;
    private void btnGenerarReporteEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteEmpleadoActionPerformed
        // TODO add your handling code here:
        try {
            Conexion con = new Conexion();

            String archivo = getClass().getResource("/reportes/ReporteEmpleados.jrxml").getPath();
            archivo = URLDecoder.decode(archivo, "UTF-8");
            JasperReport report = JasperCompileManager.compileReport(archivo);
            Map parametros = new HashMap();

            parametros.put("tipo", tipo2);
            parametros.put("valores", jTFBuscarEmpleado.getText());
            try {
                String sql = "SELECT numRegistro, nombreEmpresa, domicilioLegal, fechaConstitucion, logo, telefono, correoElectronico, propietario "
                        + "FROM datosEmpresa";
                PreparedStatement cmd = con.conectar().prepareStatement(sql);
                ResultSet ver = cmd.executeQuery();
                if (ver.next()) {
                    parametros.put("#registro", ver.getInt(1));
                    parametros.put("nombreEmpresa", ver.getString(2));
                    parametros.put("domicilio", ver.getString(3));
                    parametros.put("fechaConstitucion", ver.getString(4));
                    parametros.put("imagen", ver.getString(5));
                    parametros.put("telefono", ver.getString(6));
                    parametros.put("correo", ver.getString(7));
                    parametros.put("propietario", ver.getString(8));
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
            System.out.println("AQUI2");
            Logger.getLogger(PInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarReporteEmpleadoActionPerformed

    private void jTFBuscarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFBuscarCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFBuscarCorreoActionPerformed

    private void btnReport1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReport1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReport1MouseEntered

    private void btnReport1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReport1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReport1MouseExited

    private void btnReport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReport1ActionPerformed
        // TODO add your handling code here:
        String path = "";
        try {
            Conexion con = new Conexion();
//            //establecemos la ruta donde esta el reportes
//            path = getClass().getResource("/reportes/Secciones.jasper").getPath();
//            //se decodifica por algun caracter especial
//            path = URLDecoder.decode(path,"UTF-8");
//            System.out.println("path: "+path);
//            //Se crea la conexion
//            
//            //Se crean los parametros
//            Map parametros = new HashMap();
//            parametros.put("Nombre","Steven Diaz");
//            //Se crea el objeto reporte
//            JasperReport reporte = (JasperReport)JRLoader.loadObject(path);
//            //se crea el objeto de impresion del reporte 
//            JasperPrint imprimir = JasperFillManager.fillReport(reporte,parametros,con.conectar());
//            //ahora se crea el visor, donde se muestra el reporte
//            JasperViewer visor = new JasperViewer(imprimir, false);
//            visor.setTitle("Reporte de proyectos e integrantes");
//            visor.setVisible(true);

            String archivo = getClass().getResource("/reportes/ReporteDocumentosEmpleados.jrxml").getPath();
            archivo = URLDecoder.decode(archivo, "UTF-8");
            JasperReport report = JasperCompileManager.compileReport(archivo);
            Map parametros = new HashMap(); 
            try {
                String sql = "SELECT numRegistro, nombreEmpresa, domicilioLegal, fechaConstitucion, logo, telefono, correoElectronico, propietario "
                        + "FROM datosEmpresa";
                PreparedStatement cmd = con.conectar().prepareStatement(sql);
                ResultSet ver = cmd.executeQuery();
                if (ver.next()) {
                    parametros.put("#registro", ver.getInt(1));
                    parametros.put("nombreEmpresa", ver.getString(2));
                    parametros.put("domicilio", ver.getString(3));
                    parametros.put("fechaConstitucion", ver.getString(4));
                    parametros.put("imagen", ver.getString(5));
                    parametros.put("telefono", ver.getString(6));
                    parametros.put("correo", ver.getString(7));
                    parametros.put("propietario", ver.getString(8));
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
            System.out.println("AQUI2");
            Logger.getLogger(PInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReport1ActionPerformed

    private void btnGenerarReporteEmpleado1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarReporteEmpleado1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarReporteEmpleado1MouseEntered

    private void btnGenerarReporteEmpleado1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarReporteEmpleado1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarReporteEmpleado1MouseExited

    private void btnGenerarReporteEmpleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteEmpleado1ActionPerformed
        // TODO add your handling code here:
        try {
            Conexion con = new Conexion();

            String archivo = getClass().getResource("/reportes/ReporteEmpleadosTipos.jrxml").getPath();
            archivo = URLDecoder.decode(archivo, "UTF-8");
            JasperReport report = JasperCompileManager.compileReport(archivo);
            Map parametros = new HashMap();

            try {
                String sql = "SELECT numRegistro, nombreEmpresa, domicilioLegal, fechaConstitucion, logo, telefono, correoElectronico, propietario "
                        + "FROM datosEmpresa";
                PreparedStatement cmd = con.conectar().prepareStatement(sql);
                ResultSet ver = cmd.executeQuery();
                if (ver.next()) {
                    parametros.put("#registro", ver.getInt(1));
                    parametros.put("nombreEmpresa", ver.getString(2));
                    parametros.put("domicilio", ver.getString(3));
                    parametros.put("fechaConstitucion", ver.getString(4));
                    parametros.put("imagen", ver.getString(5));
                    parametros.put("telefono", ver.getString(6));
                    parametros.put("correo", ver.getString(7));
                    parametros.put("propietario", ver.getString(8));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            parametros.put("autor", correo);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, con.conectar());

            JasperViewer visor = new JasperViewer(print, false);
            visor.setTitle("Reporte de Documento de Empleados y Tipos");
            visor.setVisible(true);

        } catch (JRException e) {
            System.out.println("AQUI1");
            System.out.println(e.getMessage());

        } catch (UnsupportedEncodingException ex) {
            System.out.println("AQUI2");
            Logger.getLogger(PInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarReporteEmpleado1ActionPerformed

    private void btnModificarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarEActionPerformed

    private void btnAgregarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarEActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarD;
    private javax.swing.JButton btnAgregarE;
    private javax.swing.JButton btnAgregarEmpleado;
    private javax.swing.JButton btnAgregarEmpleado1;
    private javax.swing.JButton btnEliminarD;
    private javax.swing.JButton btnEliminarE;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnEliminarEmpleado1;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnGenerarReporteEmpleado;
    private javax.swing.JButton btnGenerarReporteEmpleado1;
    private javax.swing.JButton btnLimpiarCampos;
    private javax.swing.JButton btnModificarD;
    private javax.swing.JButton btnModificarE;
    private javax.swing.JButton btnModificarEmpleado;
    private javax.swing.JButton btnModificarEmpleado2;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnReport1;
    private javax.swing.JComboBox<String> cmbDocumento;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbEstadoD;
    private javax.swing.JComboBox<String> cmbTipoUsuario;
    private javax.swing.JComboBox<String> cmdPregunta1;
    private javax.swing.JComboBox<String> cmdPregunta2;
    private javax.swing.JCheckBox ingreso;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTFApellido;
    private javax.swing.JTextField jTFBuscarCorreo;
    private javax.swing.JTextField jTFBuscarDocumento;
    private javax.swing.JTextField jTFBuscarEmpleado;
    private javax.swing.JTextField jTFBuscarEstado;
    private javax.swing.JTextField jTFContraseña;
    private javax.swing.JTextField jTFCorreo;
    private javax.swing.JTextField jTFDescripcionDE;
    private javax.swing.JTextField jTFDescripcionE;
    private javax.swing.JTextField jTFDireccion;
    private javax.swing.JTextField jTFNombreD;
    private javax.swing.JTextField jTFNombreE;
    private javax.swing.JTextField jTFNombreEmpleado;
    private javax.swing.JTextField jTFRespuesta1;
    private javax.swing.JTextField jTFRespuesta2;
    private javax.swing.JTextField jTFTelefono;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JLabel lblCodigoDocumento;
    private javax.swing.JLabel lblCodigoEmpleado;
    private javax.swing.JLabel lblCodigoEstado;
    private javax.swing.JLabel lblEmpleadoDE;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JRadioButton rdCodigoDocumento;
    private javax.swing.JRadioButton rdCodigoEmpleado;
    private javax.swing.JRadioButton rdCodigoEstado;
    private javax.swing.JRadioButton rdEstadoDocumento;
    private javax.swing.JRadioButton rdNombreDocumento;
    private javax.swing.JRadioButton rdNombreEmpleado;
    private javax.swing.JRadioButton rdNombreEstado;
    // End of variables declaration//GEN-END:variables
}
