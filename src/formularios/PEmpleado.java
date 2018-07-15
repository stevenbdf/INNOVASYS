/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;
import clases.*;
import java.awt.Image;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author steve
 */
public class PEmpleado extends javax.swing.JPanel {

    /**
     * Creates new form PEmpleado
     */
    Conexion con = new Conexion();
    DefaultTableModel modeloTablaEstados;
    DefaultTableModel modeloTablaDocumentos;
    DefaultTableModel modeloTablaEmpleados;
    DefaultComboBoxModel modeloComboTipoUsuario;
    DefaultComboBoxModel modeloComboEstado;
    String key = "92AE31A79FEEB2A3"; //llave
    String iv = "0123456789ABCDEF"; // vector de inicialización
    String cleartext = "";
    Conexion cn = new Conexion();
    String NombreE="",CodigoEstado="",NombreD="",CodigoDocumento="",DescripcionE="";
    String CodigoEmpleado="";
    File fichero;
    String datos=String.valueOf(fichero);
    public PEmpleado() {
        modeloTablaEstados= new DefaultTableModel(null, getColumnasEstado());setFilasEstado(0,"");
        modeloTablaDocumentos= new DefaultTableModel(null, getColumnasDocumentos());setFilasDocumentos(0,"");
        modeloTablaEmpleados=new DefaultTableModel(null,getColumnasEmpleado());setFilasEmpleado(0,"");
        modeloComboTipoUsuario = new DefaultComboBoxModel(new String[]{});
        modeloComboEstado = new DefaultComboBoxModel(new String[]{});
                try {
                     UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		}
		catch (Exception e) {
		}
        initComponents();
        
        llenaComboBoxTipoUsuario();
        llenaComboBoxEstado();
        jTFBuscarEstado.setEnabled(false);
        jTFBuscarDocumento.setEnabled(false);
        jTFBuscarEmpleado.setEnabled(false);
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
        String columnas[] = new String[]{"CODIGO", "NOMBRE", "DESCRIPCION"};
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
    
    private void setFilasEstado(int tipo,String valores) {
        try {
            String sql="";
            switch (tipo) {
                case 1:
                    sql = "SELECT idEstado, nombreEstado,descripcion FROM estadoEmpleado WHERE idEstado like '"+valores+"%'";
                    break;
                case 2:
                    sql = "SELECT idEstado, nombreEstado,descripcion FROM estadoEmpleado WHERE nombreEstado like '"+valores+"%'";
                    break;
                default:
                    sql = "SELECT idEstado, nombreEstado,descripcion FROM estadoEmpleado";
                    break;
            }
            PreparedStatement us = cn.conectar().prepareStatement(sql);
            ResultSet resultado = us.executeQuery();

            Object datos[] = new Object[3];

            while (resultado.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = resultado.getObject(i + 1);
                }
                modeloTablaEstados.addRow(datos);
            }
        } catch (Exception e) {

        }
    }
    
    private void setFilasDocumentos(int tipo,String valores) {
        try {
            String sql="";
            switch (tipo) {
                case 1:
                    sql = "SELECT idDocumento, nombre, estado FROM documento WHERE idDocumento like '"+valores+"%'";
                    break;
                case 2:
                    sql = "SELECT idDocumento, nombre, estado FROM documento WHERE nombre like '"+valores+"%'";
                    break;
                case 3:
                    sql = "SELECT idDocumento, nombre, estado FROM documento WHERE estado like '"+valores+"%'";
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
    
    private void setFilasEmpleado(int tipo,String valores) {
        try {
            String sql="";
            switch (tipo) {
                //Codigo Empleado
                case 1:
                    sql = "SELECT idEmpleado, idTipo, nombres, apellidos, telefono, correoElectronico,direccion, idEstado "
                            + "FROM usuarioEmpleado WHERE idEmpleado like '"+valores+"%'";
                    break;
                //Nombre
                case 2:
                    sql = "SELECT idEmpleado, idTipo, nombres, apellidos, telefono, correoElectronico,direccion, idEstado "
                            + "FROM usuarioEmpleado WHERE nombres like '"+valores+"%'";
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
        jPanel2 = new javax.swing.JPanel();
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

        setBackground(new java.awt.Color(51, 51, 51));

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153), 3));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(680, 500));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));
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
        jTFTelefono.setForeground(new java.awt.Color(204, 204, 204));
        jTFTelefono.setToolTipText("");
        jTFTelefono.setPreferredSize(new java.awt.Dimension(78, 30));
        jPanel1.add(jTFTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 200, -1));

        jTFNombreEmpleado.setBackground(new java.awt.Color(204, 204, 204));
        jTFNombreEmpleado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFNombreEmpleado.setForeground(new java.awt.Color(204, 204, 204));
        jTFNombreEmpleado.setToolTipText("");
        jTFNombreEmpleado.setPreferredSize(new java.awt.Dimension(78, 30));
        jPanel1.add(jTFNombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 200, -1));

        jTFApellido.setBackground(new java.awt.Color(204, 204, 204));
        jTFApellido.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFApellido.setForeground(new java.awt.Color(204, 204, 204));
        jTFApellido.setToolTipText("");
        jTFApellido.setPreferredSize(new java.awt.Dimension(78, 30));
        jPanel1.add(jTFApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 200, -1));

        jTFDireccion.setBackground(new java.awt.Color(204, 204, 204));
        jTFDireccion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFDireccion.setForeground(new java.awt.Color(204, 204, 204));
        jTFDireccion.setToolTipText("");
        jTFDireccion.setPreferredSize(new java.awt.Dimension(78, 30));
        jPanel1.add(jTFDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 200, -1));

        jTFCorreo.setBackground(new java.awt.Color(204, 204, 204));
        jTFCorreo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFCorreo.setForeground(new java.awt.Color(204, 204, 204));
        jTFCorreo.setToolTipText("");
        jTFCorreo.setPreferredSize(new java.awt.Dimension(78, 30));
        jPanel1.add(jTFCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 200, -1));

        jTFContraseña.setBackground(new java.awt.Color(204, 204, 204));
        jTFContraseña.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFContraseña.setForeground(new java.awt.Color(204, 204, 204));
        jTFContraseña.setToolTipText("");
        jTFContraseña.setPreferredSize(new java.awt.Dimension(78, 30));
        jPanel1.add(jTFContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 200, -1));

        btnModificarEmpleado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnModificarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarEmpleado.setText("Modificar");
        btnModificarEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnModificarEmpleado.setContentAreaFilled(false);
        btnModificarEmpleado.setPreferredSize(new java.awt.Dimension(75, 30));
        btnModificarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarEmpleadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarEmpleadoMouseExited(evt);
            }
        });
        btnModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        btnLimpiarCampos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnLimpiarCampos.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarCampos.setText("Limpiar Campos");
        btnLimpiarCampos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnLimpiarCampos.setContentAreaFilled(false);
        btnLimpiarCampos.setPreferredSize(new java.awt.Dimension(107, 30));
        btnLimpiarCampos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarCamposMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarCamposMouseExited(evt);
            }
        });
        btnLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCamposActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        btnExaminar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnExaminar.setForeground(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(btnExaminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 100, 30));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Buscar:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, 30));

        jTFBuscarEmpleado.setBackground(new java.awt.Color(204, 204, 204));
        jTFBuscarEmpleado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFBuscarEmpleado.setForeground(new java.awt.Color(204, 204, 204));
        jTFBuscarEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBuscarEmpleadoKeyReleased(evt);
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
        jPanel1.add(rdNombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        rdCodigoEmpleado.setBackground(new java.awt.Color(102, 102, 102));
        rdCodigoEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        rdCodigoEmpleado.setText("Codigo");
        rdCodigoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCodigoEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(rdCodigoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, -1));

        btnGenerarReporteEmpleado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnGenerarReporteEmpleado.setForeground(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(btnGenerarReporteEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, 30));

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarEmpleadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarEmpleadoMouseExited(evt);
            }
        });
        btnAgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        cmbEstado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmbEstado.setModel(modeloComboEstado);
        jPanel1.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 120, 30));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Imagen:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 50, 30));
        jPanel1.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 120, 120));

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(modeloTablaEmpleados);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
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
        jTFRespuesta1.setForeground(new java.awt.Color(204, 204, 204));
        jTFRespuesta1.setToolTipText("");
        jTFRespuesta1.setPreferredSize(new java.awt.Dimension(78, 30));
        jPanel1.add(jTFRespuesta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 170, -1));

        jTFRespuesta2.setBackground(new java.awt.Color(204, 204, 204));
        jTFRespuesta2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFRespuesta2.setForeground(new java.awt.Color(204, 204, 204));
        jTFRespuesta2.setToolTipText("");
        jTFRespuesta2.setPreferredSize(new java.awt.Dimension(78, 30));
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
        btnEliminarEmpleado.setText("Eliminar");
        btnEliminarEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnEliminarEmpleado.setContentAreaFilled(false);
        btnEliminarEmpleado.setPreferredSize(new java.awt.Dimension(75, 30));
        btnEliminarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarEmpleadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarEmpleadoMouseExited(evt);
            }
        });
        btnEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        jTabbedPane1.addTab("Gestion de Empleados", jPanel1);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 667, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Documentos de  Empleados", jPanel2);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));
        jPanel3.setPreferredSize(new java.awt.Dimension(680, 500));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar.png"))); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestionar Documentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        jButton10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
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
        jTFBuscarDocumento.setForeground(new java.awt.Color(204, 204, 204));
        jTFBuscarDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBuscarDocumentoKeyReleased(evt);
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
        jTFNombreD.setForeground(new java.awt.Color(204, 204, 204));
        jTFNombreD.setToolTipText("");
        jTFNombreD.setPreferredSize(new java.awt.Dimension(78, 30));
        jTFNombreD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFNombreDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFNombreDKeyReleased(evt);
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
        btnAgregarD.setText("Agregar");
        btnAgregarD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnAgregarD.setContentAreaFilled(false);
        btnAgregarD.setPreferredSize(new java.awt.Dimension(71, 30));
        btnAgregarD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarDMouseExited(evt);
            }
        });

        btnModificarD.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnModificarD.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarD.setText("Modificar");
        btnModificarD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnModificarD.setContentAreaFilled(false);
        btnModificarD.setPreferredSize(new java.awt.Dimension(75, 30));
        btnModificarD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarDMouseExited(evt);
            }
        });

        btnEliminarD.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEliminarD.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarD.setText("Eliminar");
        btnEliminarD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnEliminarD.setContentAreaFilled(false);
        btnEliminarD.setPreferredSize(new java.awt.Dimension(75, 30));
        btnEliminarD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarDMouseExited(evt);
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
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(cmbEstadoD, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnAgregarD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(btnModificarD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jButton10))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(btnAgregarD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnModificarD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEliminarD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 670, 210));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestionar Estado de los Empleados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));

        jButton11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
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
        jTFBuscarEstado.setForeground(new java.awt.Color(204, 204, 204));
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
        jTFNombreE.setForeground(new java.awt.Color(204, 204, 204));
        jTFNombreE.setToolTipText("");
        jTFNombreE.setPreferredSize(new java.awt.Dimension(78, 30));
        jTFNombreE.addKeyListener(new java.awt.event.KeyAdapter() {
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
        btnAgregarE.setText("Agregar");
        btnAgregarE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnAgregarE.setContentAreaFilled(false);
        btnAgregarE.setPreferredSize(new java.awt.Dimension(71, 30));
        btnAgregarE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarEMouseExited(evt);
            }
        });

        btnModificarE.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnModificarE.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarE.setText("Modificar");
        btnModificarE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnModificarE.setContentAreaFilled(false);
        btnModificarE.setPreferredSize(new java.awt.Dimension(75, 30));
        btnModificarE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarEMouseExited(evt);
            }
        });

        jTFDescripcionE.setBackground(new java.awt.Color(204, 204, 204));
        jTFDescripcionE.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFDescripcionE.setForeground(new java.awt.Color(204, 204, 204));
        jTFDescripcionE.setToolTipText("");
        jTFDescripcionE.setPreferredSize(new java.awt.Dimension(78, 30));

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
                                .addComponent(lblCodigoEstado))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnAgregarE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFBuscarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdNombreEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdCodigoEstado)
                                .addGap(0, 83, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jButton11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(lblCodigoEstado)
                        .addComponent(jTFBuscarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdNombreEstado)
                        .addComponent(rdCodigoEstado)))
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAgregarE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnModificarE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEliminarE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jTFDescripcionE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
            JOptionPane.showMessageDialog(this,"Error campos vacios");
        } else {
            mtoUsuarios objeto= new mtoUsuarios();
            objeto.setNombreE(jTFNombreE.getText());
            objeto.setDescripcionE(jTFDescripcionE.getText());
            if (objeto.guardarEstadoEmpleado()) {
                JOptionPane.showMessageDialog(this,"Datos guardados correctamente");
                jTFNombreE.setText(null);
                jTFDescripcionE.setText(null);
                int filas = modeloTablaEstados.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaEstados.removeRow(0);
                }
                setFilasEstado(0,"");
            }          
        }
    }//GEN-LAST:event_btnAgregarEMouseClicked
    
    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        CodigoEstado=String.valueOf(modeloTablaEstados.getValueAt(jTable3.getSelectedRow(), 0));
        lblCodigoEstado.setText("CODIGO ESTADO: "+CodigoEstado);
        NombreE=String.valueOf(modeloTablaEstados.getValueAt(jTable3.getSelectedRow(), 1));
        jTFNombreE.setText(NombreE);
        jTFDescripcionE.setText(String.valueOf(modeloTablaEstados.getValueAt(jTable3.getSelectedRow(), 2)));
    }//GEN-LAST:event_jTable3MouseClicked

    private void btnModificarEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarEMouseClicked
        // TODO add your handling code here:
        if (jTFNombreE.getText().isEmpty() || jTFDescripcionE.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Error campos vacios");
        } else {
            mtoUsuarios objeto= new mtoUsuarios();
            objeto.setCodigoE(Integer.valueOf(CodigoEstado));
            objeto.setNombreE(jTFNombreE.getText());
            objeto.setDescripcionE(jTFDescripcionE.getText());
            if (objeto.modificarEstadoEmpleado()) {
                JOptionPane.showMessageDialog(this,"Datos modificados correctamente");
                lblCodigoEstado.setText("CODIGO ESTADO");
                jTFNombreE.setText(null);
                jTFDescripcionE.setText(null);
                int filas = modeloTablaEstados.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaEstados.removeRow(0);
                }
                setFilasEstado(0,"");
            }          
        }
    }//GEN-LAST:event_btnModificarEMouseClicked

    private void jTFBuscarEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarEstadoKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTFBuscarEstadoKeyTyped

    private void rdNombreEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNombreEstadoActionPerformed
        // TODO add your handling code here:
        rdCodigoEstado.setSelected(false);
        jTFBuscarEstado.setEnabled(true);
    }//GEN-LAST:event_rdNombreEstadoActionPerformed

    private void rdCodigoEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCodigoEstadoActionPerformed
        // TODO add your handling code here:
        rdNombreEstado.setSelected(false);
        jTFBuscarEstado.setEnabled(true);
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
        mtoUsuarios objeto=new mtoUsuarios();
        objeto.setNombreE(jTFNombreE.getText());
        String datos[]=objeto.consultarEstado();
        if (jTFNombreE.getText().equals(datos[0])) {
            CodigoEstado=datos[2];
            lblCodigoEstado.setText("CODIGO ESTADO: "+datos[2]);
            DescripcionE=datos[1];
            jTFDescripcionE.setText(datos[1]);
        }else{
            lblCodigoEstado.setText("CODIGO ESTADO");
        }
    }//GEN-LAST:event_jTFNombreEKeyReleased

    private void btnEliminarEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEMouseClicked
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar este estado?", "Confirmacion",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION || response==JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(this,"Estado no eliminado");
        }else{
            if (lblCodigoEstado.getText().equals("CODIGO ESTADO") ||lblCodigoEstado.getText().equals("CODIGO ESTADO: ")) {
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
        if (response == JOptionPane.NO_OPTION || response==JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(this,"Documento no eliminado");
        }else{
            if (lblCodigoDocumento.getText().equals("CODIGO DOCUMENTO") || lblCodigoDocumento.getText().equals("CODIGO DOCUMENTO: ") ) {
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

    private void rdNombreDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNombreDocumentoActionPerformed
        // TODO add your handling code here:
        rdCodigoDocumento.setSelected(false);
        rdEstadoDocumento.setSelected(false);
        jTFBuscarDocumento.setEnabled(true);
    }//GEN-LAST:event_rdNombreDocumentoActionPerformed

    private void rdCodigoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCodigoDocumentoActionPerformed
        // TODO add your handling code here:
        rdNombreDocumento.setSelected(false);
        rdEstadoDocumento.setSelected(false);
        jTFBuscarDocumento.setEnabled(true);
    }//GEN-LAST:event_rdCodigoDocumentoActionPerformed

    private void rdEstadoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdEstadoDocumentoActionPerformed
        // TODO add your handling code here:
        rdCodigoDocumento.setSelected(false);
        rdNombreDocumento.setSelected(false);
        jTFBuscarDocumento.setEnabled(true);
    }//GEN-LAST:event_rdEstadoDocumentoActionPerformed

    private void jTFBuscarDocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBuscarDocumentoKeyReleased
        // TODO add your handling code here:
        if (rdCodigoDocumento.isSelected()) {
            int filas = modeloTablaDocumentos.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaDocumentos.removeRow(0);
            }
            setFilasDocumentos(1, jTFBuscarDocumento.getText());
        }else if (rdNombreDocumento.isSelected()) {
            int filas = modeloTablaDocumentos.getRowCount();
            for (int i = 0; filas > i; i++) {
                modeloTablaDocumentos.removeRow(0);
            }
            setFilasDocumentos(2, jTFBuscarDocumento.getText());
        }else if (rdEstadoDocumento.isSelected()) {
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
            JOptionPane.showMessageDialog(this,"Error campos vacios");
        }else{
            mtoUsuarios objeto = new mtoUsuarios();
            objeto.setNombreD(jTFNombreD.getText());
            objeto.setEstadoD(String.valueOf(cmbEstadoD.getSelectedItem()));
            if (objeto.guardarDocumento()) {
                JOptionPane.showMessageDialog(this,"Datos guardados correctamente");
                jTFNombreD.setText(null);
                cmbEstadoD.setSelectedIndex(0);
                int filas = modeloTablaDocumentos.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaDocumentos.removeRow(0);
                }
                setFilasDocumentos(0,"");
            }
        }
    }//GEN-LAST:event_btnAgregarDMouseClicked

    private void btnModificarDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarDMouseClicked
        // TODO add your handling code here:
        if (jTFNombreD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Error campos vacios");
        } else {
            mtoUsuarios objeto = new mtoUsuarios();
            objeto.setCodigoD(Integer.valueOf(CodigoDocumento));
            objeto.setNombreD(jTFNombreD.getText());
            objeto.setEstadoD(String.valueOf(cmbEstadoD.getSelectedItem()));
            if (objeto.modificarDocumento()) {
                JOptionPane.showMessageDialog(this,"Datos modificados correctamente");
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
        CodigoDocumento=String.valueOf(modeloTablaDocumentos.getValueAt(jTable2.getSelectedRow(), 0));
        lblCodigoDocumento.setText("CODIGO DOCUMENTO: "+CodigoDocumento);
        NombreD=String.valueOf(modeloTablaDocumentos.getValueAt(jTable2.getSelectedRow(), 1));
        jTFNombreD.setText(NombreD);
        cmbEstadoD.setSelectedItem(String.valueOf(modeloTablaDocumentos.getValueAt(jTable2.getSelectedRow(), 2)));
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTFNombreDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreDKeyReleased
        // TODO add your handling code here:
        mtoUsuarios objeto=new mtoUsuarios();
        objeto.setNombreD(jTFNombreD.getText());
        String datos[]=objeto.consultarDocumento();
        if (jTFNombreD.getText().equals(datos[0])) {
            CodigoDocumento=datos[2];
            lblCodigoDocumento.setText("CODIGO DOCUMENTO: "+datos[2]);
            cmbEstadoD.setSelectedItem(datos[1]);
        }else if(jTFNombreD.getText().equals("")){
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
        // TODO add your handling code here:
        verificaciones obj = new verificaciones();      
        mtoUsuarios objeto = new mtoUsuarios();
        objeto.setNombreEmpleado(jTFNombreEmpleado.getText());
        objeto.setApellidoEmpleado(jTFApellido.getText());
        objeto.setTelefono(Integer.valueOf(jTFTelefono.getText()));
        objeto.setCorreoEmpleado(jTFCorreo.getText());
        cleartext=jTFContraseña.getText();
//        objeto.setContraseñaEmpleado(cleartext);
        try {
            objeto.setContraseñaEmpleado(obj.encrypt(key, iv, cleartext));
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
            
            String[]consultas ={"SELECT idTipo FROM tipoUsuario WHERE nombreTipo='"+valores[0]+"'","SELECT idEstado FROM estadoEmpleado WHERE nombreEstado='"+valores[1]+"'"};
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
            JOptionPane.showMessageDialog(this,"Usuario Empleado guardado correctamente");
        }else{
            JOptionPane.showMessageDialog(this,"Error Usuario Empleado no guardado");
        }
        int filas = modeloTablaEmpleados.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaEmpleados.removeRow(0);
                }
                setFilasEmpleado(0,"");    
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
            String sql = "SELECT imagen, contraseña, pregunta1, respuesta1, pregunta2, respuesta2 "
                    + "FROM usuarioEmpleado WHERE idEmpleado='" + modeloTablaEmpleados.getValueAt(jTable1.getSelectedRow(), (0)) + "'";
            PreparedStatement cmd = cn.conectar().prepareStatement(sql);
            ResultSet ver = cmd.executeQuery();
            if (ver.next()) {
                datos = ver.getString(1);
                ImageIcon icon = new ImageIcon(ver.getString(1));
                ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                lblFoto.setIcon(icono);
                jTFContraseña.setText(obj.decrypt(key, iv, ver.getString(2)));
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
        objeto.setCodigoEmpleado(Integer.valueOf(CodigoEmpleado));
        objeto.setNombreEmpleado(jTFNombreEmpleado.getText());
        objeto.setApellidoEmpleado(jTFApellido.getText());
        objeto.setTelefono(Integer.valueOf(jTFTelefono.getText()));
        objeto.setCorreoEmpleado(jTFCorreo.getText());
        cleartext=jTFContraseña.getText();
        try {
            objeto.setContraseñaEmpleado(obj.encrypt(key, iv, cleartext));
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
            for(String e: valores){
                System.out.println("Valores "+e);
            }
            String[]consultas ={"SELECT idTipo FROM tipoUsuario WHERE nombreTipo='"+valores[0]+"'","SELECT idEstado FROM estadoEmpleado WHERE nombreEstado='"+valores[1]+"'"};
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
            JOptionPane.showMessageDialog(this,"Usuario Empleado modificado correctamente");
        }else{
            JOptionPane.showMessageDialog(this,"Error Usuario Empleado no modificado");
        }
        int filas = modeloTablaEmpleados.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaEmpleados.removeRow(0);
                }
                setFilasEmpleado(0,"");    
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
    }//GEN-LAST:event_btnEliminarEmpleadoActionPerformed

    private void rdNombreEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNombreEmpleadoActionPerformed
        // TODO add your handling code here:
        rdCodigoEmpleado.setSelected(false);
        jTFBuscarEmpleado.setEnabled(true);
    }//GEN-LAST:event_rdNombreEmpleadoActionPerformed

    private void rdCodigoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCodigoEmpleadoActionPerformed
        // TODO add your handling code here:
        rdNombreEmpleado.setSelected(false);
        jTFBuscarEmpleado.setEnabled(true);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarD;
    private javax.swing.JButton btnAgregarE;
    private javax.swing.JButton btnAgregarEmpleado;
    private javax.swing.JButton btnEliminarD;
    private javax.swing.JButton btnEliminarE;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnGenerarReporteEmpleado;
    private javax.swing.JButton btnLimpiarCampos;
    private javax.swing.JButton btnModificarD;
    private javax.swing.JButton btnModificarE;
    private javax.swing.JButton btnModificarEmpleado;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbEstadoD;
    private javax.swing.JComboBox<String> cmbTipoUsuario;
    private javax.swing.JComboBox<String> cmdPregunta1;
    private javax.swing.JComboBox<String> cmdPregunta2;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTFApellido;
    private javax.swing.JTextField jTFBuscarDocumento;
    private javax.swing.JTextField jTFBuscarEmpleado;
    private javax.swing.JTextField jTFBuscarEstado;
    private javax.swing.JTextField jTFContraseña;
    private javax.swing.JTextField jTFCorreo;
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
    private javax.swing.JLabel lblCodigoDocumento;
    private javax.swing.JLabel lblCodigoEmpleado;
    private javax.swing.JLabel lblCodigoEstado;
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
