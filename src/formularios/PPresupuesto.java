/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.Conexion;
import clases.mtoInventario;
import clases.mtoPresupuesto;
import clases.verificaciones;
import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;
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
import java.text.DecimalFormat;

/**
 *
 * @author steven
 */
public class PPresupuesto extends javax.swing.JPanel {

    /**
     * Creates new form PPresupuesto
     */
    verificaciones verificar = new verificaciones();
    DefaultComboBoxModel modeloComboPro;
    DefaultComboBoxModel modeloComboCat;
    DefaultTableModel modeloTablaProductos;
    DefaultComboBoxModel modeloComboCliente;
    DefaultComboBoxModel modeloComboEstado;
    
    Integer[][] stockes = new Integer[2][50];
    String fechaP="";
    public static final Color greenD = new Color(217,179,16);
    public PPresupuesto() {
        mtoInventario obj = new mtoInventario();
//        try {
//                     UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//		}
//		catch (Exception e) {
//		}
        modeloTablaProductos = new DefaultTableModel(null, getColumnasProductos());
        
        modeloComboPro = new DefaultComboBoxModel(new String[]{});
        modeloComboCat = new DefaultComboBoxModel(new String[]{});
        modeloComboCliente = new DefaultComboBoxModel(new String[]{});
        modeloComboEstado = new DefaultComboBoxModel(new String[]{});
        initComponents();
        
        
        jTFCodigoP.setEditable(false);
        jTFPrecio.setEditable(false);
        jTFStock.setEditable(false);
        Calendar hoy = Calendar.getInstance();
        int año = hoy.get(Calendar.YEAR);
        hoy.add(Calendar.MONTH,1);
        int mes = hoy.get(Calendar.MONTH)+1;
        int dia = hoy.get(Calendar.DAY_OF_MONTH);
        fechaP=año+"-"+mes+"-"+dia;
        lblVence.setText("Vence el: "+fechaP);
        
        
        llenaComboBoxClientes();
        llenaComboBoxEstado();
        llenaComboBoxCategoria();
        
        ImageIcon foto0 = new ImageIcon (getClass().getResource("/images/help.png"));
       ImageIcon icono0 = new ImageIcon(foto0.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
       lblhelp.setIcon(icono0);
       
       jLabel20.setVisible(false);
       jTFSubTotal.setVisible(false);
       
       jTable1.getTableHeader().setOpaque(false);
        JTableHeader header = jTable1.getTableHeader();
        header.setBackground(greenD);
        header.setForeground(Color.WHITE);
        
        String[] valoresC = getColumnasProductos();
        TableColumnModel columnModel = jTable1.getColumnModel();
        System.out.println("tamaño: "+valoresC.length);
        for (int i = 0; i <valoresC.length; i++) {
            columnModel.getColumn(i).setPreferredWidth(valoresC[i].length()*9);
            System.out.println("entra");
        }
    }
    private String[] getColumnasProductos() {
        String columnas[] = new String[]{"#","CODIGO", "NOMBRE", "CATEGORIA","$ UNIT.","CANTIDAD","SUBTOTAL" };
        return columnas;
    }
    private void llenaComboBoxCategoria() {
        modeloComboCat.removeAllElements();
        try {
                Conexion con = new Conexion();
            /* Realizamos la consulta a la base de datos*/
            String sql2="SELECT idCategoria, nombreCategoria FROM categoriaProducto ";
            PreparedStatement verDatos2 = con.conectar().prepareStatement(sql2);
            ResultSet ver2 = verDatos2.executeQuery();
            
            while(ver2.next()){
                modeloComboCat.addElement(ver2.getObject("nombreCategoria"));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);

        }
    }
    private void llenaComboBoxProductos() {
        modeloComboPro.removeAllElements();
        
        try {
            Conexion con = new Conexion();
            /* Realizamos la consulta a la base de datos*/
            String sql = "select idProductos from inventario  group by idProductos ";
            PreparedStatement verDatos = con.conectar().prepareStatement(sql);
            ResultSet ver = verDatos.executeQuery();
            while (ver.next()) {
                String sql2 = "select nombreProducto ,(SELECT top 1 stock from inventario where idProductos="+ver.getObject("idProductos")+" order by idInventario DESC) as stock FROM producto " 
                               +" WHERE idProducto= "+ver.getObject("idProductos")+"  AND idCategoria="+idCat;
                PreparedStatement verDatos2 = con.conectar().prepareStatement(sql2);
                ResultSet ver2 = verDatos2.executeQuery();
                if (ver2.next()) {
                    if(!(ver2.getInt("stock")<=0)){
                        modeloComboPro.addElement(ver2.getString(1));
                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void llenaComboBoxClientes() {
        modeloComboCliente.removeAllElements();
        try {
                Conexion con = new Conexion();
            /* Realizamos la consulta a la base de datos*/
            String sql = "SELECT correoElectronico FROM cliente";
            PreparedStatement verDatos = con.conectar().prepareStatement(sql);
            ResultSet ver = verDatos.executeQuery();
            while (ver.next()) {

                modeloComboCliente.addElement(ver.getObject("correoElectronico"));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);

        }
    }
    
    private void llenaComboBoxEstado() {
        modeloComboEstado.removeAllElements();
        try {
                Conexion con = new Conexion();
            /* Realizamos la consulta a la base de datos*/
            String sql = "SELECT nombre FROM estadoPedido";
            PreparedStatement verDatos = con.conectar().prepareStatement(sql);
            ResultSet ver = verDatos.executeQuery();
            while (ver.next()) {

                modeloComboEstado.addElement(ver.getObject("nombre"));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);

        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jTFCodigoP = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jTFCantidad = new javax.swing.JTextField();
        jTFPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTFTotal = new javax.swing.JTextField();
        jTFSubTotal = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblhelp = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        lblVence = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jTFStock = new javax.swing.JTextField();

        setBackground(new java.awt.Color(30, 57, 42));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 196, 124), 3));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(60, 196, 124));
        jLabel10.setText("Crear Presupuesto");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        jTFCodigoP.setBackground(new java.awt.Color(204, 204, 204));
        jTFCodigoP.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jTFCodigoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFCodigoPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFCodigoPKeyTyped(evt);
            }
        });
        add(jTFCodigoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 110, 30));

        btnEliminar.setBackground(new java.awt.Color(51, 51, 51));
        btnEliminar.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 90, 40));

        btnAgregar.setBackground(new java.awt.Color(51, 51, 51));
        btnAgregar.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/plus.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarMouseEntered(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 90, 40));

        jTFCantidad.setBackground(new java.awt.Color(204, 204, 204));
        jTFCantidad.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jTFCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFCantidadKeyTyped(evt);
            }
        });
        add(jTFCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 97, 30));

        jTFPrecio.setBackground(new java.awt.Color(204, 204, 204));
        jTFPrecio.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jTFPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFPrecioActionPerformed(evt);
            }
        });
        jTFPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFPrecioKeyTyped(evt);
            }
        });
        add(jTFPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 80, 30));

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable1.setModel(modeloTablaProductos);
        jTable1.setGridColor(new java.awt.Color(153, 153, 153));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 470, 240));

        jTFTotal.setBackground(new java.awt.Color(204, 204, 204));
        jTFTotal.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jTFTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTotalKeyTyped(evt);
            }
        });
        add(jTFTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 87, 30));

        jTFSubTotal.setBackground(new java.awt.Color(204, 204, 204));
        jTFSubTotal.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jTFSubTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFSubTotalKeyTyped(evt);
            }
        });
        add(jTFSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 88, 30));

        btnGuardar.setBackground(new java.awt.Color(51, 51, 51));
        btnGuardar.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/save.png"))); // NOI18N
        btnGuardar.setText("Guardar Presupuesto");
        btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 170, 40));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Codigo Producto:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nombre:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Precio ($):");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Stock:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 40, -1));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Total ($):");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 50, 30));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Sub-Total:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar.png"))); // NOI18N
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        lblhelp.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblhelpAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lblhelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblhelpMouseClicked(evt);
            }
        });
        add(lblhelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 25, 25));

        cmbProducto.setModel(modeloComboPro);
        cmbProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProductoItemStateChanged(evt);
            }
        });
        cmbProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbProductoMouseClicked(evt);
            }
        });
        cmbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProductoActionPerformed(evt);
            }
        });
        add(cmbProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 140, 30));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Cliente:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, -1));

        jComboBox1.setModel(modeloComboCliente);
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 140, 30));

        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Categoria:");
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        jComboBox2.setModel(modeloComboEstado);
        add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 140, 30));

        lblVence.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblVence.setForeground(new java.awt.Color(255, 255, 255));
        lblVence.setText("Vence: ");
        add(lblVence, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 140, 30));

        jLabel28.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Estado Presupuesto:");
        add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, -1, -1));

        cmbCategoria.setModel(modeloComboCat);
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });
        add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 150, 30));

        jLabel27.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Cantidad (Unds):");
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 100, -1));

        jTFStock.setBackground(new java.awt.Color(204, 204, 204));
        jTFStock.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        add(jTFStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 70, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        // TODO add your handling code here:
        btnEliminar.setContentAreaFilled(false);
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        // TODO add your handling code here:
        btnEliminar.setContentAreaFilled(true);
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseExited
        // TODO add your handling code here:
        btnAgregar.setContentAreaFilled(false);
    }//GEN-LAST:event_btnAgregarMouseExited

    private void btnAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseEntered
        // TODO add your handling code here:
        btnAgregar.setContentAreaFilled(true);
    }//GEN-LAST:event_btnAgregarMouseEntered

    private void jTFPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFPrecioActionPerformed

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        // TODO add your handling code here:
        btnGuardar.setContentAreaFilled(false);
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        // TODO add your handling code here:
        btnGuardar.setContentAreaFilled(true);
    }//GEN-LAST:event_btnGuardarMouseEntered
    void crearReporte(){
        try {
            Conexion con = new Conexion();

            String archivo= getClass().getResource("/reportes/Presupuesto.jrxml").getPath();
            archivo = URLDecoder.decode(archivo,"UTF-8");
            JasperReport report = JasperCompileManager.compileReport(archivo);
            Map parametros = new HashMap();
                      
            try {
                String sql ="SELECT TOP 1 idPedido FROM pedido ORDER BY idPedido DESC";
                PreparedStatement cmd = con.conectar().prepareStatement(sql);
                ResultSet ver = cmd.executeQuery();
                if (ver.next()) {
                   parametros.put("valores",ver.getInt(1)); 
                }
            } catch (Exception e) {
                System.out.println("No hay pedidos");
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
            
            parametros.put("autor", jComboBox1.getSelectedItem()); 
            JasperPrint print = JasperFillManager.fillReport(report, parametros, con.conectar());
 
            JasperViewer visor = new JasperViewer(print, false);
            visor.setTitle("Presupuesto");
            visor.setVisible(true);
 
            
        } catch (JRException e) {
            System.out.println("AQUI1");
            System.out.println(e.getMessage());
            
        } 
        catch (UnsupportedEncodingException ex) {
            System.out.println("AQUI2");
            Logger.getLogger(PInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        try {
            Conexion cn = new Conexion();
            mtoPresupuesto obj = new mtoPresupuesto();
            
            obj.setCorreoCliente(String.valueOf(jComboBox1.getSelectedItem()));
            
            
            String sql2 ="SELECT idEstadoP FROM estadoPedido WHERE nombre='"+String.valueOf(jComboBox2.getSelectedItem())+"'";
            PreparedStatement cmd2 = cn.conectar().prepareStatement(sql2);
            ResultSet ver2 = cmd2.executeQuery();
            if (ver2.next()) {
                obj.setCodigoEstado(ver2.getInt(1));
            }
            obj.setMontoTotal(total);
            if (obj.guardarPedido()) {
                for (int i = 0; i < contador; i++) {
                    try {
                        String sql3 = "INSERT INTO detallePedido(idDetalleP, idPedido, idProducto, cantidadProducto) "
                                + " VALUES ((SELECT MAX (idDetalleP) FROM detallePedido)+1,(SELECT MAX(idPedido) FROM pedido ),?, ?)";
                        PreparedStatement cmd3 = cn.conectar().prepareStatement(sql3);
                        if (stockes[0][i]!=0) {
                            cmd3.setInt(1, stockes[0][i]);
                            cmd3.setInt(2, stockes[1][i]);
                            if (!cmd3.execute()) {
                                if (i==(contador-1)) {
                                    JOptionPane.showMessageDialog(this,"Presupuesto guardado correctamente");
                                    crearReporte();
                                }
                                
                            }
                        }
                    } catch (Exception e) {
                        String sql3 = "INSERT INTO detallePedido(idDetalleP, idPedido, idProducto, cantidadProducto) "
                                + " VALUES (1,(SELECT MAX(idPedido) FROM pedido ),?, ?)";
                        PreparedStatement cmd3 = cn.conectar().prepareStatement(sql3);
                        if (stockes[0][i]!=0) {
                            cmd3.setInt(1, stockes[0][i]);
                            cmd3.setInt(2, stockes[1][i]);
                            if (!cmd3.execute()) {
                                if (i==(contador-1)) {
                                    JOptionPane.showMessageDialog(this,"Presupuesto guardado correctamente");
                                    crearReporte();
                                }
                            }
                        }
                    }
                    
                    
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        this.hide();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jTFCodigoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCodigoPKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vnumeros(vchar) == true
                && (jTFCodigoP.getText().length() < 6)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFCodigoPKeyTyped

    private void jTFPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrecioKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vnumeros(vchar) == true
                && (jTFPrecio.getText().length() < 4)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFPrecioKeyTyped

    private void jTFCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCantidadKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vnumeros(vchar) == true
                && (jTFCantidad.getText().length() < 2) && vchar!='0') {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFCantidadKeyTyped

    private void jTFSubTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFSubTotalKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vnumeros(vchar) == true
                && (jTFSubTotal.getText().length() < 5)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFSubTotalKeyTyped

    private void jTFTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTotalKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vnumeros(vchar) == true
                && (jTFTotal.getText().length() < 5)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFTotalKeyTyped

    private void lblhelpAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblhelpAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblhelpAncestorAdded

    private void lblhelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhelpMouseClicked
        // TODO add your handling code here:
        //y cuando llames el formulario ayuda en vez del 0 le vas a poner el form que le corresponda 1 2 o 3 y asi sucesivamente, si vos elegis el orden
        /**
        * ahorita, llena los textos de ayuda de todos los forms, luego vemos lo de las imagenes , me avisas cuando temrines de escribir las instrucciones
        */
        help form = new help(13);
        form.show();
    }//GEN-LAST:event_lblhelpMouseClicked

    private void jTFCodigoPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCodigoPKeyReleased
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jTFCodigoPKeyReleased

    private void cmbProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProductoItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbProductoItemStateChanged
    Integer stockGeneral=0;
    String categoria;
    private void cmbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductoActionPerformed
        // TODO add your handling code here:
        try {
            Conexion con = new Conexion();
            System.out.println("combo: "+cmbProducto.getSelectedItem());
            String sql ="SELECT idProducto, categoriaProducto.nombreCategoria, imagen  FROM producto, categoriaProducto "
                    + " WHERE nombreProducto='"+cmbProducto.getSelectedItem()+"' AND categoriaProducto.idCategoria = producto.idCategoria";
            PreparedStatement cmd = con.conectar().prepareStatement(sql);
            ResultSet ver = cmd.executeQuery();
            if (ver.next()) {
                jTFCodigoP.setText(String.valueOf(ver.getInt(1)));
                categoria = ver.getString(2);
                
            }
        } catch (Exception e) {
            System.out.println("Aqui");
            System.out.println(e.toString());
        }
        
        mtoPresupuesto obj = new mtoPresupuesto();
        String[] datos = obj.consultarProducto(jTFCodigoP.getText());
        stockGeneral= Integer.valueOf(datos[3]);
        System.out.println("stock g: "+stockGeneral);
        jTFStock.setText(""+stockGeneral);
        double precio = (Double.parseDouble(datos[1])) + (Double.parseDouble(datos[2]));
        double precio2= (Double.parseDouble(datos[0])) * (precio/100) ;
        double precio3= precio2 +(Double.parseDouble(datos[0]));
        jTFPrecio.setText(String.valueOf(precio3));
        
    }//GEN-LAST:event_cmbProductoActionPerformed

    private void cmbProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbProductoMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbProductoMouseClicked
    Integer contador=0;
    double total=0;
    Object[] datos = new Object[7];
    DecimalFormat df = new DecimalFormat("#.##");
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (Integer.valueOf(jTFCantidad.getText())>stockGeneral) {
            JOptionPane.showMessageDialog(this,"No se cuenta con suficiente stock de este producto");
        }else{
            if (true) {
                
            }
         int validacion=0;
            for (int i = 0; i <contador; i++) {
                if (stockes[0][i]==Integer.valueOf(jTFCodigoP.getText())) {
                    
                    validacion=1;
                }
            }
            if (validacion==1) {
                JOptionPane.showMessageDialog(this,"Ya se encuentra este producto en el detalle");
            }else{
                Object[] datos = new Object[7];
//        Object valor0 = new Object(jTFCodigoP.getText());
                datos[0] = contador;
                datos[1] = jTFCodigoP.getText();
                datos[2] = cmbProducto.getSelectedItem();
                datos[3] = categoria;
                datos[4] = jTFPrecio.getText();
                datos[5] = jTFCantidad.getText();
                double subtotal = (Double.parseDouble(jTFPrecio.getText())) * Integer.valueOf(jTFCantidad.getText());
                datos[6] = subtotal;
                modeloTablaProductos.addRow(datos);
                //0 Codigo Pro
                stockes[0][contador] = Integer.valueOf(jTFCodigoP.getText());
                System.out.println("Codigo Producto: " + stockes[0][contador]);
                //1 Stock final
                stockes[1][contador] = Integer.valueOf(jTFCantidad.getText());
                System.out.println("Codigo Stock Final: " + stockes[1][contador]);

                contador++;
                total = total + subtotal;
                jTFTotal.setText("" + df.format(total));
                System.out.println("Contador: " + contador);
            }
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed
    int x=-1;
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (x!=-1) {
            Integer posicion =Integer.valueOf(String.valueOf(modeloTablaProductos.getValueAt(jTable1.getSelectedRow(), (0))));
            Integer stockT =Integer.valueOf(String.valueOf(modeloTablaProductos.getValueAt(jTable1.getSelectedRow(), (5))));
            
        //0 Codigo Pro
         stockes[0][posicion]=0;
            System.out.println("Codigo Producto 2: "+stockes[0][posicion]);
        //1 Stock final
            stockes[1][posicion]= stockes[1][posicion]+(stockT) ;
            System.out.println("Codigo Stock Final 2: "+stockes[1][posicion]);
            total=total-(Double.valueOf(String.valueOf(modeloTablaProductos.getValueAt(jTable1.getSelectedRow(), (6)))));
           modeloTablaProductos.removeRow(x);
           jTFTotal.setText(""+total);
            if (jTable1.getRowCount()==0) {
                contador=0;
                total=0;
                jTFTotal.setText(""+total);
                System.out.println("Contador: "+contador);
            }
        x=-1; 
        }else{
            JOptionPane.showMessageDialog(this,"Selecciona una fila para eliminar");
        }   
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        x=jTable1.getSelectedRow();
    }//GEN-LAST:event_jTable1MouseClicked
    Integer idCat;
    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        // TODO add your handling code here:
         try {
            Conexion con = new Conexion();
            String sql="SELECT idCategoria FROM categoriaProducto WHERE nombreCategoria='"+cmbCategoria.getSelectedItem()+"'";
            PreparedStatement cmd = con.conectar().prepareStatement(sql);
            ResultSet ver = cmd.executeQuery();
            if (ver.next()) {
                idCat=ver.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        llenaComboBoxProductos();
    }//GEN-LAST:event_cmbCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbProducto;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFCantidad;
    private javax.swing.JTextField jTFCodigoP;
    private javax.swing.JTextField jTFPrecio;
    private javax.swing.JTextField jTFStock;
    private javax.swing.JTextField jTFSubTotal;
    private javax.swing.JTextField jTFTotal;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblVence;
    private javax.swing.JLabel lblhelp;
    // End of variables declaration//GEN-END:variables
}
