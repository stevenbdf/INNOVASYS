/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;
import clases.Conexion;
import clases.mtoInventario;
import static clases.mtoVentas.sumarFechasDias;
import clases.verificaciones;
import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.Color;
/**
 *
 * @author steve
 */
public class PInventario extends javax.swing.JPanel {

    /**
     * Creates new form PInventario
     */
    verificaciones verificar = new verificaciones();
    DefaultTableModel modeloTablaInventario;
    DefaultComboBoxModel modeloComboCategoria;
    DefaultTableModel modeloTablaReportes;
    String correo;
    public static final Color greenD = new Color(217,179,16);
    
    public static void changeFont(Component component, Font font) {
        component.setFont(font);
        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                changeFont(child, font);
            }
        }
    }
    
    public PInventario(String correoE) {
        mtoInventario obj = new mtoInventario();
//                try {
//                     UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//		}
//		catch (Exception e) {
//		}
        initComponents();
        
        Font fuente = null;
        InputStream myStream = null;
        try {
            myStream = new BufferedInputStream(new FileInputStream("src/fuentes/Poppins-Medium.ttf"));
            fuente = Font.createFont(Font.TRUETYPE_FONT, myStream);
            fuente = fuente.deriveFont(Font.PLAIN, 11);
            
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(VentanaPrincipal2.class.getName()).log(Level.SEVERE, null, ex);
        }
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fuente);
        
        changeFont(jPanel1, fuente);
        
        
        correo=correoE;
        Calendar c2 = new GregorianCalendar();
        fecha.setCalendar(c2);
        Fmin.setCalendar(c2);
        Fmax.setCalendar(c2);
        Calendar hoy = Calendar.getInstance();
        int año = hoy.get(Calendar.YEAR);
        int año2 = hoy.get(Calendar.YEAR) - 10;
        hoy.add(Calendar.MONTH, 1);
        int mes = hoy.get(Calendar.MONTH);
        int dia = hoy.get(Calendar.DAY_OF_MONTH);
        String fechaP = año + "-" + mes + "-" + dia;
        String fechaP2 = año2 + "-" + mes + "-" + dia;
        mtoInventario objeto = new mtoInventario();
        
        
        jTable1.getTableHeader().setOpaque(false);
        JTableHeader header = jTable1.getTableHeader();
        
        header.setBackground(greenD);
        header.setForeground(Color.WHITE);
        
        
        
        fecha.setMaxSelectableDate(verificar.StringADate(fechaP));
        fecha.setMinSelectableDate(verificar.StringADate(fechaP2));
        Fmin.setMaxSelectableDate(verificar.StringADate(fechaP));
        Fmin.setMinSelectableDate(verificar.StringADate(fechaP2));
        Fmax.setMaxSelectableDate(verificar.StringADate(fechaP));
        Fmax.setMinSelectableDate(verificar.StringADate(fechaP2));
        
        jTFCodigo.setEnabled(false);
        jTFProductoEspecifico.setEnabled(false);
        
        
        modeloComboCategoria = new DefaultComboBoxModel(new String[]{});
        cmbProducto.setModel(obj.llenarComboCategoria(modeloComboCategoria));
        modeloTablaReportes = new DefaultTableModel(null, objeto.getColumnasCategoria());
        modeloTablaInventario = new DefaultTableModel(null, objeto.getColumnasCategoria());
        
        jTable1.setModel(objeto.setFilasInventario(modeloTablaInventario));
        //jTable2.setModel(setFilasReportes(modeloTablaReportes,1,verificar.getFecha(Fmin),verificar.getFecha(Fmax),Integer.valueOf(jTFStockMin.getText())));
        ImageIcon foto0 = new ImageIcon(getClass().getResource("/images/help.png"));
        ImageIcon icono0 = new ImageIcon(foto0.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        lblhelp.setIcon(icono0);
        lblhelp1.setIcon(icono0);
        
     
        
        String[] valoresC = objeto.getColumnasCategoria();
        TableColumnModel columnModel = jTable1.getColumnModel();
        System.out.println("tamaño: "+valoresC.length);
        for (int i = 0; i <valoresC.length; i++) {
            columnModel.getColumn(i).setPreferredWidth(valoresC[i].length()*9);
            System.out.println("entra");
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

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTFCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFGanancia = new javax.swing.JTextField();
        lblStock = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTFCantidad = new javax.swing.JTextField();
        jTFImpuestos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTFPrecio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        lblhelp = new javax.swing.JLabel();
        lblhelp2 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        cmbProducto = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        rdEntrada = new javax.swing.JRadioButton();
        rdSalida = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        rdAlto = new javax.swing.JRadioButton();
        rdBajo = new javax.swing.JRadioButton();
        jTFProductoEspecifico = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        lblhelp1 = new javax.swing.JLabel();
        Fmin = new com.toedter.calendar.JDateChooser();
        Fmax = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jTFStockMin1 = new javax.swing.JTextField();
        Antiguo = new javax.swing.JRadioButton();
        Reciente = new javax.swing.JRadioButton();
        jButton6 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(30, 57, 42));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane2.setBackground(new java.awt.Color(30, 57, 42));
        jTabbedPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 196, 124), 3));
        jTabbedPane2.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(680, 500));

        jPanel3.setBackground(new java.awt.Color(30, 57, 42));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 196, 124)));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(670, 500));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        jTFCodigo.setBackground(new java.awt.Color(204, 204, 204));
        jTFCodigo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCodigoActionPerformed(evt);
            }
        });
        jTFCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFCodigoKeyTyped(evt);
            }
        });
        jPanel3.add(jTFCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 70, 30));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Producto:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, 30));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio compra $:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, 30));

        jTFGanancia.setBackground(new java.awt.Color(204, 204, 204));
        jTFGanancia.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFGanancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFGananciaKeyTyped(evt);
            }
        });
        jPanel3.add(jTFGanancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 78, 30));

        lblStock.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblStock.setForeground(new java.awt.Color(255, 255, 255));
        lblStock.setText("Stock:");
        jPanel3.add(lblStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 80, 30));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("% Impuestos:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 156, 80, 20));

        jTFCantidad.setBackground(new java.awt.Color(204, 204, 204));
        jTFCantidad.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCantidadActionPerformed(evt);
            }
        });
        jTFCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFCantidadKeyTyped(evt);
            }
        });
        jPanel3.add(jTFCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 100, 90, 30));

        jTFImpuestos.setBackground(new java.awt.Color(204, 204, 204));
        jTFImpuestos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFImpuestos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFImpuestosKeyTyped(evt);
            }
        });
        jPanel3.add(jTFImpuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 90, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tipo Transaccion:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, 30));

        btnAgregar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/plus.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarMouseExited(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 120, 40));

        btnEliminar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 100, 40));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("% de ganancia:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, 30));

        jTFPrecio.setBackground(new java.awt.Color(204, 204, 204));
        jTFPrecio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
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
        jPanel3.add(jTFPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 78, 30));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Estado:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, -1, -1));

        cmbEstado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recibido", "Entregado", "Averidado", "En Camino", "Incompleto" }));
        jPanel3.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 117, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setDragEnabled(true);
        jTable1.setGridColor(new java.awt.Color(0, 153, 51));
        jTable1.setSelectionBackground(new java.awt.Color(0, 204, 51));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 616, 210));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

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
        jPanel3.add(lblhelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 25, 25));

        lblhelp2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblhelp2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lblhelp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblhelp2MouseClicked(evt);
            }
        });
        jPanel3.add(lblhelp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 25, 25));

        fecha.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 160, 30));

        cmbProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cmbProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 170, 30));

        btnModificar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images expo/edit.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnModificar.setContentAreaFilled(false);
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarMouseExited(evt);
            }
        });
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel3.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 130, 40));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Fecha transaccion:");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 30));

        rdEntrada.setText("Entrada");
        rdEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdEntradaActionPerformed(evt);
            }
        });
        jPanel3.add(rdEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        rdSalida.setText("Salida");
        rdSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSalidaActionPerformed(evt);
            }
        });
        jPanel3.add(rdSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Cantidad:");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, 30));

        jTabbedPane2.addTab("Gestionar Inventario", jPanel3);

        jPanel4.setBackground(new java.awt.Color(30, 57, 42));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 196, 124)));
        jPanel4.setPreferredSize(new java.awt.Dimension(680, 500));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha Min:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 26, -1, -1));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Fecha Max:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ordenar por:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, 30));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Producto (Especifico):");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 30));

        rdAlto.setBackground(new java.awt.Color(102, 102, 102));
        rdAlto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        rdAlto.setForeground(new java.awt.Color(255, 255, 255));
        rdAlto.setText("Precio Alto");
        rdAlto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdAltoActionPerformed(evt);
            }
        });
        jPanel4.add(rdAlto, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        rdBajo.setBackground(new java.awt.Color(102, 102, 102));
        rdBajo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        rdBajo.setForeground(new java.awt.Color(255, 255, 255));
        rdBajo.setText("Precio Bajo");
        rdBajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBajoActionPerformed(evt);
            }
        });
        jPanel4.add(rdBajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));

        jTFProductoEspecifico.setBackground(new java.awt.Color(204, 204, 204));
        jTFProductoEspecifico.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFProductoEspecifico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFProductoEspecificoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFProductoEspecificoKeyTyped(evt);
            }
        });
        jPanel4.add(jTFProductoEspecifico, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 160, 30));

        jButton4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Buscar");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 70, 30));

        jScrollPane2.setViewportView(jTable2);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 171, 651, 240));

        jButton5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Generar reporte");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 140, 40));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        lblhelp1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblhelp1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lblhelp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblhelp1MouseClicked(evt);
            }
        });
        jPanel4.add(lblhelp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 25, 25));

        Fmin.setDateFormatString("yyyy-MM-dd");
        jPanel4.add(Fmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 160, 30));

        Fmax.setDateFormatString("yyyy-MM-dd");
        jPanel4.add(Fmax, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 160, 30));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Stock Min:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        jTFStockMin1.setBackground(new java.awt.Color(204, 204, 204));
        jTFStockMin1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTFStockMin1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFStockMin1KeyTyped(evt);
            }
        });
        jPanel4.add(jTFStockMin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 82, 30));

        Antiguo.setBackground(new java.awt.Color(102, 102, 102));
        Antiguo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Antiguo.setForeground(new java.awt.Color(255, 255, 255));
        Antiguo.setText("Mas Antiguo");
        Antiguo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AntiguoActionPerformed(evt);
            }
        });
        jPanel4.add(Antiguo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, -1, -1));

        Reciente.setBackground(new java.awt.Color(102, 102, 102));
        Reciente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Reciente.setForeground(new java.awt.Color(255, 255, 255));
        Reciente.setText("Mas Reciente");
        Reciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecienteActionPerformed(evt);
            }
        });
        jPanel4.add(Reciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        jButton6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Generar reporte");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 140, 40));

        jTabbedPane2.addTab("Gestionar Reportes", jPanel4);

        jPanel1.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTFCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCantidadActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (jTFCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Error no ha seleccionado ningun registro");
        }else{
            mtoInventario objeto = new mtoInventario();
            objeto.setCodigoI(Integer.valueOf(jTFCodigo.getText()));
            if (objeto.eliminarInventario()) {
                JOptionPane.showMessageDialog(this,"Registro Eliminado correctamente");
                int filas = modeloTablaInventario.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaInventario.removeRow(0);
                }         
                objeto.setFilasInventario(modeloTablaInventario );
            }else{
                JOptionPane.showMessageDialog(this,"Error no al borrar");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jTFPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFPrecioActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        this.hide();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void rdAltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAltoActionPerformed
        // TODO add your handling code here:
        Reciente.setSelected(false);
        rdAlto.setSelected(true);
        rdBajo.setSelected(false); 
        Antiguo.setSelected(false);
       
    }//GEN-LAST:event_rdAltoActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_jLabel17MouseClicked

    private void btnAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseEntered
        // TODO add your handling code here:
         btnAgregar.setContentAreaFilled(true);
    }//GEN-LAST:event_btnAgregarMouseEntered

    private void btnAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseExited
        // TODO add your handling code here:
         btnAgregar.setContentAreaFilled(false);
    }//GEN-LAST:event_btnAgregarMouseExited

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        // TODO add your handling code here:
         btnEliminar.setContentAreaFilled(true);
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        // TODO add your handling code here:
         btnEliminar.setContentAreaFilled(false);
    }//GEN-LAST:event_btnEliminarMouseExited

    private void jTFCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCodigoKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vnumeros(vchar) == true
                && (jTFCodigo.getText().length() < 6)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFCodigoKeyTyped

    private void jTFCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCodigoActionPerformed

    private void jTFCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCantidadKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vnumeros(vchar) == true
                && (jTFCantidad.getText().length() < 4)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFCantidadKeyTyped

    private void jTFPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrecioKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vprecio(vchar) == true
                && (jTFPrecio.getText().length() < 6)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFPrecioKeyTyped

    private void jTFGananciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFGananciaKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vnumeros(vchar) == true
                && (jTFGanancia.getText().length() < 3)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFGananciaKeyTyped

    private void jTFImpuestosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFImpuestosKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vnumeros(vchar) == true
                && (jTFImpuestos.getText().length() < 3)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFImpuestosKeyTyped

    private void jTFProductoEspecificoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFProductoEspecificoKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vnumeros(vchar) == true
                && (jTFProductoEspecifico.getText().length() < 11)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFProductoEspecificoKeyTyped

    private void lblhelpAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblhelpAncestorAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_lblhelpAncestorAdded

    private void lblhelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhelpMouseClicked
        // TODO add your handling code here:
        //y cuando llames el formulario ayuda en vez del 0 le vas a poner el form que le corresponda 1 2 o 3 y asi sucesivamente, si vos elegis el orden
        /**
        * ahorita, llena los textos de ayuda de todos los forms, luego vemos lo de las imagenes , me avisas cuando temrines de escribir las instrucciones
        */
        help form = new help(12);
        form.show();
    }//GEN-LAST:event_lblhelpMouseClicked

    private void lblhelp1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblhelp1AncestorAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_lblhelp1AncestorAdded

    private void lblhelp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhelp1MouseClicked
        // TODO add your handling code here:
        //y cuando llames el formulario ayuda en vez del 0 le vas a poner el form que le corresponda 1 2 o 3 y asi sucesivamente, si vos elegis el orden
        /**
        * ahorita, llena los textos de ayuda de todos los forms, luego vemos lo de las imagenes , me avisas cuando temrines de escribir las instrucciones
        */
        help form = new help(12);
        form.show();
    }//GEN-LAST:event_lblhelp1MouseClicked

    private void lblhelp2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblhelp2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblhelp2AncestorAdded

    private void lblhelp2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhelp2MouseClicked
        // TODO add your handling code here:
        //y cuando llames el formulario ayuda en vez del 0 le vas a poner el form que le corresponda 1 2 o 3 y asi sucesivamente, si vos elegis el orden
        /**
        * ahorita, llena los textos de ayuda de todos los forms, luego vemos lo de las imagenes , me avisas cuando temrines de escribir las instrucciones
        */
        help form = new help(12);
        form.show();
    }//GEN-LAST:event_lblhelp2MouseClicked

    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarMouseEntered

    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarMouseExited

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        String fechass=verificar.getFecha(fecha);
        System.out.println("Fecha: "+fechass);
        if ( jTFPrecio.getText().isEmpty() || jTFGanancia.getText().isEmpty() || jTFCantidad.getText().isEmpty() || jTFImpuestos.getText().isEmpty() || fechass==null) {
            JOptionPane.showMessageDialog(this,"Error campos vacios");       
        }else{
            mtoInventario objeto = new mtoInventario();
            Conexion cn = new Conexion();
            objeto.setCodigoI(Integer.valueOf(jTFCodigo.getText()));
            try {
                String sql ="SELECT idProducto FROM producto WHERE nombreProducto='"+cmbProducto.getSelectedItem()+"'";
                PreparedStatement cmd = cn.conectar().prepareStatement(sql);
                ResultSet ver = cmd.executeQuery();
                if (ver.next()) {
                    objeto.setCodigoP(ver.getInt(1));
                }else{
                    System.out.println("Error");
                }
                
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            if (rdEntrada.isSelected()) {
                objeto.setCodigoT(1);
            }else if (rdSalida.isSelected()) {
                objeto.setCodigoT(2);
            }
            objeto.setFecha(fechass);
            objeto.setPrecioCompra(Double.valueOf(jTFPrecio.getText()));
            objeto.setPorcentajeGanancia(Double.valueOf(jTFGanancia.getText()));
            try {
                String sql ="SELECT stock FROM inventario WHERE idInventario ="+jTFCodigo.getText();
                PreparedStatement cmd2 = cn.conectar().prepareStatement(sql);
                ResultSet ver2 = cmd2.executeQuery();
                if (ver2.next()) {
                    System.out.println("Entra el if");
                    int cantidad= Integer.valueOf(jTFCantidad.getText());
                    if (objeto.getCodigoT()==1) {
                        objeto.setStock((ver2.getInt(1)+cantidad));
                    }else if (objeto.getCodigoT()==2 && ver2.getInt(1)>=cantidad) {
                        objeto.setStock((ver2.getInt(1)-cantidad));
                    }else{
                        JOptionPane.showMessageDialog(this,"Error no hay suficiente stock para restar");
                    }
                }
                
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            objeto.setCantidad(Integer.valueOf(jTFCantidad.getText()));
            objeto.setImpuestos(Double.valueOf(jTFImpuestos.getText()));
            objeto.setEstado(String.valueOf(cmbEstado.getSelectedItem()));
            
            
            if (objeto.modificarInventario()) {
                JOptionPane.showMessageDialog(this,"Registro modificado");
                int filas = modeloTablaInventario.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaInventario.removeRow(0);
                }         
                objeto.setFilasInventario(modeloTablaInventario );
            }else{
                JOptionPane.showMessageDialog(this,"Error al modificar");
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        String fechass = verificar.getFecha3(fecha);
        System.out.println("Fecha: " + fechass);
        verificaciones obj = new verificaciones();
        System.out.println("Fecha: " + fechass);
        if (obj.vfecham(fechass, 2000)) {
            if (jTFPrecio.getText().isEmpty() || jTFGanancia.getText().isEmpty() || jTFCantidad.getText().isEmpty() || jTFImpuestos.getText().isEmpty() || fechass == "") {
                JOptionPane.showMessageDialog(this, "Error campos vacios");
            }else if(Double.valueOf(jTFPrecio.getText())==0.0 || Integer.valueOf(jTFPrecio.getText())==0 || Integer.valueOf(jTFCantidad.getText())==0){
                JOptionPane.showMessageDialog(this, "No puedes ingresar un precio y/o cantidad igual a 0");
            }else {
                mtoInventario objeto = new mtoInventario();
                Conexion cn = new Conexion();

                try {
                    String sql = "SELECT idProducto FROM producto WHERE nombreProducto='" + cmbProducto.getSelectedItem() + "'";
                    PreparedStatement cmd = cn.conectar().prepareStatement(sql);
                    ResultSet ver = cmd.executeQuery();
                    if (ver.next()) {
                        objeto.setCodigoP(ver.getInt(1));
                    } else {
                        System.out.println("Error");
                    }

                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                if (rdEntrada.isSelected()) {
                    objeto.setCodigoT(1);
                } else if (rdSalida.isSelected()) {
                    objeto.setCodigoT(2);
                }
                objeto.setFecha(fechass);
                objeto.setPrecioCompra(Double.valueOf(jTFPrecio.getText()));
                objeto.setPorcentajeGanancia(Double.valueOf(jTFGanancia.getText()));
                try {
                    String sql2 = "SELECT stock FROM inventario WHERE idProductos=" + objeto.getCodigoP() + " ORDER BY idInventario DESC";
                    PreparedStatement cmd2 = cn.conectar().prepareStatement(sql2);
                    ResultSet ver2 = cmd2.executeQuery();
                    Integer cantidad2 = Integer.valueOf(jTFCantidad.getText());
                    if (ver2.next()) {
                        if (objeto.getCodigoT() == 1) {
                            objeto.setStock((ver2.getInt(1) + cantidad2));
                        } else if (objeto.getCodigoT() == 2 && ver2.getInt(1) >= cantidad2) {
                            objeto.setStock((ver2.getInt(1) - cantidad2));
                        } else {
                            JOptionPane.showMessageDialog(this, "Error no hay suficiente stock para restar");
                        }
                    } else {
                        objeto.setStock(cantidad2);
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                objeto.setCantidad(Integer.valueOf(jTFCantidad.getText()));
                objeto.setImpuestos(Double.valueOf(jTFImpuestos.getText()));
                objeto.setEstado(String.valueOf(cmbEstado.getSelectedItem()));

                if (objeto.guardarInventario()) {
                    JOptionPane.showMessageDialog(this, "Registro guardado");
                    int filas = modeloTablaInventario.getRowCount();
                    for (int i = 0; filas > i; i++) {
                        modeloTablaInventario.removeRow(0);
                    }
                    objeto.setFilasInventario(modeloTablaInventario);
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar");
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "Ingrese una fecha valida");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
    String codigoI="";
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        codigoI=(String.valueOf(modeloTablaInventario.getValueAt(jTable1.getSelectedRow(), (0))));
        jTFCodigo.setText(codigoI);
        cmbProducto.setSelectedItem((String.valueOf(modeloTablaInventario.getValueAt(jTable1.getSelectedRow(), (1)))));
        if ((String.valueOf(modeloTablaInventario.getValueAt(jTable1.getSelectedRow(), (2)))).equals("Entrada")) {
            rdEntrada.setSelected(true);
            rdSalida.setSelected(false);
        }else if ((String.valueOf(modeloTablaInventario.getValueAt(jTable1.getSelectedRow(), (2)))).equals("Salida")) {
            rdSalida.setSelected(true);
            rdEntrada.setSelected(false);
        }
        fecha.setDate(verificar.StringADate((String.valueOf(modeloTablaInventario.getValueAt(jTable1.getSelectedRow(), (3))))));
        jTFPrecio.setText((String.valueOf(modeloTablaInventario.getValueAt(jTable1.getSelectedRow(), (4)))));
        jTFGanancia.setText((String.valueOf(modeloTablaInventario.getValueAt(jTable1.getSelectedRow(), (5)))));
        lblStock.setText("Stock: "+(String.valueOf(modeloTablaInventario.getValueAt(jTable1.getSelectedRow(), (6)))));
        jTFCantidad.setText((String.valueOf(modeloTablaInventario.getValueAt(jTable1.getSelectedRow(), (7)))));
        jTFImpuestos.setText((String.valueOf(modeloTablaInventario.getValueAt(jTable1.getSelectedRow(), (8)))));
        cmbEstado.setSelectedItem((String.valueOf(modeloTablaInventario.getValueAt(jTable1.getSelectedRow(), (9)))));
    }//GEN-LAST:event_jTable1MouseClicked

    private void rdEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdEntradaActionPerformed
        // TODO add your handling code here:
        rdSalida.setSelected(false);
    }//GEN-LAST:event_rdEntradaActionPerformed

    private void rdSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSalidaActionPerformed
        // TODO add your handling code here:
        rdEntrada.setSelected(false);
    }//GEN-LAST:event_rdSalidaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (jTFStockMin1.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(this,"Error campos vacios");
        }else{
            jTFProductoEspecifico.setEnabled(true);
            if (rdAlto.isSelected()) {
                int filas = modeloTablaReportes.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaReportes.removeRow(0);
                }         
            jTable2.setModel(setFilasReportes(modeloTablaReportes,1,verificar.getFecha(Fmin),verificar.getFecha(Fmax),Integer.valueOf(jTFStockMin1.getText()),0));
            }else if (rdBajo.isSelected()) {
                int filas = modeloTablaReportes.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaReportes.removeRow(0);
                }         
            jTable2.setModel(setFilasReportes(modeloTablaReportes,0,verificar.getFecha(Fmin),verificar.getFecha(Fmax),Integer.valueOf(jTFStockMin1.getText()),0));
            }
                     
            
            else if (Reciente.isSelected()) {
                int filas = modeloTablaReportes.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaReportes.removeRow(0);
                }         
            jTable2.setModel(setFilasReportes(modeloTablaReportes,10,verificar.getFecha(Fmin),verificar.getFecha(Fmax),Integer.valueOf(jTFStockMin1.getText()),0));
            }
            else if (Antiguo.isSelected()) {
                int filas = modeloTablaReportes.getRowCount();
                for (int i = 0; filas > i; i++) {
                    modeloTablaReportes.removeRow(0);
                }         
            jTable2.setModel(setFilasReportes(modeloTablaReportes,11,verificar.getFecha(Fmin),verificar.getFecha(Fmax),Integer.valueOf(jTFStockMin1.getText()),0));
            }
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void rdBajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBajoActionPerformed
        // TODO add your handling code here:
        Reciente.setSelected(false);
        rdAlto.setSelected(false);
         
        Antiguo.setSelected(false);
        rdBajo.setSelected(true);
    }//GEN-LAST:event_rdBajoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
       
        try {
            Conexion con = new Conexion();

            
            
            String archivo= getClass().getResource("/reportes/InventarioExpo.jrxml").getPath();
            archivo = URLDecoder.decode(archivo,"UTF-8");
            JasperReport report = JasperCompileManager.compileReport(archivo);
            Map parametros = new HashMap();
            parametros.put("fechaM",verificar.getFecha(Fmin));
            parametros.put("fechaMayor",verificar.getFecha(Fmax));
            parametros.put("Stock",Integer.valueOf(jTFStockMin1.getText()));
            int orden =0;
            if (jTFProductoEspecifico.getText().isEmpty()) {
                if (rdAlto.isSelected()) {
                    orden = 1;
                }else if(Reciente.isSelected()){
                    orden=10;
                }else if(Antiguo.isSelected()){
                    orden=11;
                }
                
                parametros.put("orden", orden);
            }else{
                if (rdAlto.isSelected()) {
                    orden = 2;
                }else if (rdBajo.isSelected()){
                    orden = 3;
                }else if(Reciente.isSelected()){
                    orden=8;
                }else if(Antiguo.isSelected()){
                    orden=9;
                }
                parametros.put("orden", orden);
                parametros.put("codigoP",Integer.valueOf(jTFProductoEspecifico.getText()));
            }
            System.out.println("Orden :"+orden);
            
            try {
                String sql ="SELECT numRegistro, nombreEmpresa , domicilioLegal, fechaConstitucion, logo, telefono, correoElectronico, propietario "
                        + "FROM datosEmpresa";
                PreparedStatement cmd = con.conectar().prepareStatement(sql);
                ResultSet ver = cmd.executeQuery();
                if (ver.next()) {
                   parametros.put("#registro",ver.getInt(1));
                   parametros.put("nombreEmpresa", ver.getString(2));
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
            visor.setTitle("Reporte de Inventario");
            visor.setVisible(true);
 
            
        } catch (JRException e) {
            System.out.println("AQUI1");
            System.out.println(e.getMessage());
            
        } 
        catch (UnsupportedEncodingException ex) {
            System.out.println("AQUI2");
            Logger.getLogger(PInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTFStockMin1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFStockMin1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFStockMin1KeyTyped

    private void jTFProductoEspecificoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFProductoEspecificoKeyReleased
        // TODO add your handling code here:
        try {
            if (jTFProductoEspecifico.getText().isEmpty() || jTFProductoEspecifico.getText().equals(" ")) {
                if (rdAlto.isSelected()) {
                    int filas = modeloTablaReportes.getRowCount();
                    for (int i = 0; filas > i; i++) {
                        modeloTablaReportes.removeRow(0);
                    }
                    jTable2.setModel(setFilasReportes(modeloTablaReportes, 1, verificar.getFecha(Fmin), verificar.getFecha(Fmax), Integer.valueOf(jTFStockMin1.getText()), 0));
                } else if (rdBajo.isSelected()) {
                    int filas = modeloTablaReportes.getRowCount();
                    for (int i = 0; filas > i; i++) {
                        modeloTablaReportes.removeRow(0);
                    }
                    jTable2.setModel(setFilasReportes(modeloTablaReportes, 0, verificar.getFecha(Fmin), verificar.getFecha(Fmax), Integer.valueOf(jTFStockMin1.getText()), 0));
                } else if (Reciente.isSelected()) {
                    int filas = modeloTablaReportes.getRowCount();
                    for (int i = 0; filas > i; i++) {
                        modeloTablaReportes.removeRow(0);
                    }
                    jTable2.setModel(setFilasReportes(modeloTablaReportes, 10, verificar.getFecha(Fmin), verificar.getFecha(Fmax), Integer.valueOf(jTFStockMin1.getText()), 0));
                } else if (Antiguo.isSelected()) {
                    int filas = modeloTablaReportes.getRowCount();
                    for (int i = 0; filas > i; i++) {
                        modeloTablaReportes.removeRow(0);
                    }
                    jTable2.setModel(setFilasReportes(modeloTablaReportes, 11, verificar.getFecha(Fmin), verificar.getFecha(Fmax), Integer.valueOf(jTFStockMin1.getText()), 0));
                }
            } else {
                if (rdAlto.isSelected()) {
                    int filas = modeloTablaReportes.getRowCount();
                    for (int i = 0; filas > i; i++) {
                        modeloTablaReportes.removeRow(0);
                    }
                    jTable2.setModel(setFilasReportes(modeloTablaReportes, 2, verificar.getFecha(Fmin), verificar.getFecha(Fmax), Integer.valueOf(jTFStockMin1.getText()), Integer.valueOf(jTFProductoEspecifico.getText())));
                } else if (rdBajo.isSelected()) {
                    int filas = modeloTablaReportes.getRowCount();
                    for (int i = 0; filas > i; i++) {
                        modeloTablaReportes.removeRow(0);
                    }
                    jTable2.setModel(setFilasReportes(modeloTablaReportes, 3, verificar.getFecha(Fmin), verificar.getFecha(Fmax), Integer.valueOf(jTFStockMin1.getText()), Integer.valueOf(jTFProductoEspecifico.getText())));
                } else if (Reciente.isSelected()) {
                    int filas = modeloTablaReportes.getRowCount();
                    for (int i = 0; filas > i; i++) {
                        modeloTablaReportes.removeRow(0);
                    }
                    jTable2.setModel(setFilasReportes(modeloTablaReportes, 8, verificar.getFecha(Fmin), verificar.getFecha(Fmax), Integer.valueOf(jTFStockMin1.getText()), Integer.valueOf(jTFProductoEspecifico.getText())));
                } else if (Antiguo.isSelected()) {
                    int filas = modeloTablaReportes.getRowCount();
                    for (int i = 0; filas > i; i++) {
                        modeloTablaReportes.removeRow(0);
                    }
                    jTable2.setModel(setFilasReportes(modeloTablaReportes, 9, verificar.getFecha(Fmin), verificar.getFecha(Fmax), Integer.valueOf(jTFStockMin1.getText()), Integer.valueOf(jTFProductoEspecifico.getText())));
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_jTFProductoEspecificoKeyReleased

    private void AntiguoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AntiguoActionPerformed
        // TODO add your handling code here:
        Reciente.setSelected(false);
        rdAlto.setSelected(false);
        rdBajo.setSelected(false); 
        Antiguo.setSelected(true);
    }//GEN-LAST:event_AntiguoActionPerformed

    private void RecienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecienteActionPerformed
        // TODO add your handling code here:
        Reciente.setSelected(true);
        rdAlto.setSelected(false);
        rdBajo.setSelected(false); 
        Antiguo.setSelected(false);
    }//GEN-LAST:event_RecienteActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            Conexion con = new Conexion();

            
            
            String archivo= getClass().getResource("/reportes/ReporteInventarioTransacciones.jrxml").getPath();
            archivo = URLDecoder.decode(archivo,"UTF-8");
            JasperReport report = JasperCompileManager.compileReport(archivo);
            Map parametros = new HashMap();
            
            
            try {
                String sql ="SELECT numRegistro, nombreEmpresa , domicilioLegal, fechaConstitucion, logo, telefono, correoElectronico, propietario "
                        + "FROM datosEmpresa";
                PreparedStatement cmd = con.conectar().prepareStatement(sql);
                ResultSet ver = cmd.executeQuery();
                if (ver.next()) {
                   parametros.put("#registro",ver.getInt(1));
                   parametros.put("nombreEmpresa", ver.getString(2));
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
            visor.setTitle("Reporte de Inventario");
            visor.setVisible(true);
 
            
        } catch (JRException e) {
            System.out.println("AQUI1");
            System.out.println(e.getMessage());
            
        } 
        catch (UnsupportedEncodingException ex) {
            System.out.println("AQUI2");
            Logger.getLogger(PInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    public DefaultTableModel setFilasReportes(DefaultTableModel  model, int tipo, String fecha1, String fecha2, int stock, int codigoP)
    {
        Conexion cn = new Conexion();
        try{
        String sql="";
        switch(tipo){

            case 1:
                sql="SELECT idInventario, producto.nombreProducto , tipoTransaccion.nombre, fechaTransaccion, precioCompra, porcentajeGanacia, " +
                    " stock, cantidad, impuestos, estado FROM inventario , tipoTransaccion, producto WHERE fechaTransaccion BETWEEN '"+fecha1+"' and '"+fecha2+"' AND stock>="+stock+" AND producto.idProducto=inventario.idProductos AND tipoTransaccion.idTipoT=inventario.idTipoT  ORDER BY precioCompra ASC";
                break;
                //Por codigo + Alto
            case 2:
                sql="SELECT idInventario, producto.nombreProducto , tipoTransaccion.nombre, fechaTransaccion, precioCompra, porcentajeGanacia, " +
                    " stock, cantidad, impuestos, estado FROM inventario , tipoTransaccion, producto WHERE fechaTransaccion BETWEEN '"+fecha1+"' and '"+fecha2+"' AND stock>="+stock+" AND producto.idProducto=inventario.idProductos AND tipoTransaccion.idTipoT=inventario.idTipoT AND idProductos='"+codigoP+"'  ORDER BY precioCompra ASC";
                break;
            case 3:
                //Por codigo + Bajo
                sql="SELECT idInventario, producto.nombreProducto , tipoTransaccion.nombre, fechaTransaccion, precioCompra, porcentajeGanacia, " +
                    " stock, cantidad, impuestos, estado FROM inventario , tipoTransaccion, producto WHERE fechaTransaccion BETWEEN '"+fecha1+"' and '"+fecha2+"' AND stock>="+stock+" AND producto.idProducto=inventario.idProductos AND tipoTransaccion.idTipoT=inventario.idTipoT AND idProductos='"+codigoP+"'  ORDER BY precioCompra DESC";
                break;
            
            case 8:
                //Por inventario alto
                sql="SELECT idInventario, producto.nombreProducto , tipoTransaccion.nombre, fechaTransaccion, precioCompra, porcentajeGanacia, " +
                    " stock, cantidad, impuestos, estado FROM inventario , tipoTransaccion, producto WHERE fechaTransaccion BETWEEN '"+fecha1+"' and '"+fecha2+"' AND stock>="+stock+" AND producto.idProducto=inventario.idProductos AND tipoTransaccion.idTipoT=inventario.idTipoT AND idProductos='"+codigoP+"'  ORDER BY idInventario DESC";
                break;
            case 9:
                //Por Inventario bajo
                sql="SELECT idInventario, producto.nombreProducto , tipoTransaccion.nombre, fechaTransaccion, precioCompra, porcentajeGanacia, " +
                    " stock, cantidad, impuestos, estado FROM inventario , tipoTransaccion, producto WHERE fechaTransaccion BETWEEN '"+fecha1+"' and '"+fecha2+"' AND stock>="+stock+" AND producto.idProducto=inventario.idProductos AND tipoTransaccion.idTipoT=inventario.idTipoT AND idProductos='"+codigoP+"'  ORDER BY idInventario ASC";
                break;
            case 10:
                //Por inventario alto sin nombre
                sql="SELECT idInventario, producto.nombreProducto , tipoTransaccion.nombre, fechaTransaccion, precioCompra, porcentajeGanacia, " +
                    " stock, cantidad, impuestos, estado FROM inventario , tipoTransaccion, producto WHERE fechaTransaccion BETWEEN '"+fecha1+"' and '"+fecha2+"' AND stock>="+stock+" AND producto.idProducto=inventario.idProductos AND tipoTransaccion.idTipoT=inventario.idTipoT  ORDER BY idInventario DESC";
                break;
            case 11:
                //Por Inventario bajo sin nombre
                sql="SELECT idInventario, producto.nombreProducto , tipoTransaccion.nombre, fechaTransaccion, precioCompra, porcentajeGanacia, " +
                    " stock, cantidad, impuestos, estado FROM inventario , tipoTransaccion, producto WHERE fechaTransaccion BETWEEN '"+fecha1+"' and '"+fecha2+"' AND stock>="+stock+" AND producto.idProducto=inventario.idProductos AND tipoTransaccion.idTipoT=inventario.idTipoT  ORDER BY idInventario ASC";
                break; 
            default:
                sql="SELECT idInventario, producto.nombreProducto , tipoTransaccion.nombre, fechaTransaccion, precioCompra, porcentajeGanacia, " +
                    " stock, cantidad, impuestos, estado FROM inventario , tipoTransaccion, producto WHERE fechaTransaccion BETWEEN '"+fecha1+"' and '"+fecha2+"' AND stock>="+stock+" AND producto.idProducto=inventario.idProductos AND tipoTransaccion.idTipoT=inventario.idTipoT ORDER BY precioCompra DESC";
                break;
        }
        Object dato[] = new Object[10];
        
            PreparedStatement us = cn.conectar().prepareStatement(sql);
            ResultSet res = us.executeQuery();
            
            while(res.next()){
                for(int i =0;i<10;i++)
                {
   
                        if (i == 3) {
                        dato[i] = sumarFechasDias(res.getDate(i + 1), 2);

                    } else {
                        dato[i] = res.getObject(i + 1);
                    }  
                }
           

                model.addRow(dato);
            }
           
        }
        catch(Exception ex){
                System.out.println(ex.toString());
        } 
        return model;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Antiguo;
    private com.toedter.calendar.JDateChooser Fmax;
    private com.toedter.calendar.JDateChooser Fmin;
    private javax.swing.JRadioButton Reciente;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbProducto;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFCantidad;
    private javax.swing.JTextField jTFCodigo;
    private javax.swing.JTextField jTFGanancia;
    private javax.swing.JTextField jTFImpuestos;
    private javax.swing.JTextField jTFPrecio;
    private javax.swing.JTextField jTFProductoEspecifico;
    private javax.swing.JTextField jTFStockMin1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblhelp;
    private javax.swing.JLabel lblhelp1;
    private javax.swing.JLabel lblhelp2;
    private javax.swing.JRadioButton rdAlto;
    private javax.swing.JRadioButton rdBajo;
    private javax.swing.JRadioButton rdEntrada;
    private javax.swing.JRadioButton rdSalida;
    // End of variables declaration//GEN-END:variables
}
