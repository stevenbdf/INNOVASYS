/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.Conexion;
import clases.mtoPresupuesto;
import clases.verificaciones;
import static formularios.VentanaPrincipal2.PanelPrincipal;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
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
public class PConstruirEquipo extends javax.swing.JPanel {

    /**
     * Creates new form PConstruirEquipo
     */
    verificaciones verificar = new verificaciones();
    DefaultComboBoxModel modeloComboCategorias;
    DefaultComboBoxModel modeloComboCliente;
    DefaultListModel modeloLista = new DefaultListModel();
    DefaultListModel modeloLista2 = new DefaultListModel();
    public PConstruirEquipo() {
//        try {
//                     UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//		}
//		catch (Exception e) {
//		}
        modeloComboCategorias = new DefaultComboBoxModel(new String[]{});
        modeloComboCliente = new DefaultComboBoxModel(new String[]{});
        
        initComponents();
        llenaComboBoxClientes();
        llenaComboBoxCategorias();
        ImageIcon foto0 = new ImageIcon (getClass().getResource("/images/help.png"));
       ImageIcon icono0 = new ImageIcon(foto0.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
       lblhelp.setIcon(icono0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        lblhelp = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTFCodigo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTA1 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jTFPuntaje = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel14 = new javax.swing.JLabel();
        jTFPrecio1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        spin = new javax.swing.JSpinner();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel13 = new javax.swing.JLabel();
        jTFTotal = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(51, 51, 51));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153), 3));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 153));
        jLabel10.setText("Construir Computadora");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

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
        add(lblhelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 25, 25));

        lblFoto.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblFoto.setForeground(new java.awt.Color(255, 255, 255));
        add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 260, 240));

        jComboBox1.setModel(modeloComboCategorias);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 180, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cliente:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 60, 30));

        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Remover");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton2.setContentAreaFilled(false);
        jButton2.setPreferredSize(new java.awt.Dimension(73, 30));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 80, 30));

        jButton3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Ver 3D");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton3.setContentAreaFilled(false);
        jButton3.setPreferredSize(new java.awt.Dimension(73, 30));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 60, 30));

        jButton4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Agregar");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton4.setContentAreaFilled(false);
        jButton4.setPreferredSize(new java.awt.Dimension(73, 30));
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
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 90, 30));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cantidad:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 80, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Descripcion:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 90, 30));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 40, 30));

        jTFCodigo.setBackground(new java.awt.Color(204, 204, 204));
        jTFCodigo.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
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
        add(jTFCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 70, 30));

        jTA1.setColumns(20);
        jTA1.setRows(5);
        jScrollPane2.setViewportView(jTA1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 180, 110));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nombre:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 60, 30));

        jTFNombre.setBackground(new java.awt.Color(204, 204, 204));
        jTFNombre.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jTFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreActionPerformed(evt);
            }
        });
        jTFNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNombreKeyTyped(evt);
            }
        });
        add(jTFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 320, 180, 30));

        jTFPuntaje.setBackground(new java.awt.Color(204, 204, 204));
        jTFPuntaje.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jTFPuntaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFPuntajeActionPerformed(evt);
            }
        });
        jTFPuntaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFPuntajeKeyTyped(evt);
            }
        });
        add(jTFPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 70, 30));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("BenchMark:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 90, 30));

        jList2.setModel(modeloLista);
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jList2);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 180, 120));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Precio:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 50, 30));

        jTFPrecio1.setBackground(new java.awt.Color(204, 204, 204));
        jTFPrecio1.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jTFPrecio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFPrecio1ActionPerformed(evt);
            }
        });
        jTFPrecio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFPrecio1KeyTyped(evt);
            }
        });
        add(jTFPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 70, 30));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Opciones:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 70, 30));
        add(spin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 50, 30));

        jList3.setModel(modeloLista);
        jList3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jList3);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 180, 120));

        jList1.setModel(modeloLista2);
        jScrollPane1.setViewportView(jList1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 160, 130));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Codigo:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 60, 30));

        jTFTotal.setBackground(new java.awt.Color(204, 204, 204));
        jTFTotal.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jTFTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTotalActionPerformed(evt);
            }
        });
        jTFTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTotalKeyTyped(evt);
            }
        });
        add(jTFTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 70, 30));

        jButton5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("TERMINAR");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton5.setContentAreaFilled(false);
        jButton5.setPreferredSize(new java.awt.Dimension(73, 30));
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
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 140, 30));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Componente:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, 30));

        jComboBox2.setModel(modeloComboCliente);
        add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 180, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void lblhelpAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblhelpAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblhelpAncestorAdded
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
    private void lblhelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhelpMouseClicked
        // TODO add your handling code here:
        //y cuando llames el formulario ayuda en vez del 0 le vas a poner el form que le corresponda 1 2 o 3 y asi sucesivamente, si vos elegis el orden
        /**
        * ahorita, llena los textos de ayuda de todos los forms, luego vemos lo de las imagenes , me avisas cuando temrines de escribir las instrucciones
        */
        help form = new help(4);
        form.show();
    }//GEN-LAST:event_lblhelpMouseClicked
    int cant=0;
    private void llenaComboBoxCategorias() {
        modeloComboCategorias.removeAllElements();
        try {
                Conexion con = new Conexion();
            /* Realizamos la consulta a la base de datos*/
            String sql2="SELECT idCategoria, nombreCategoria FROM categoriaProducto WHERE visualizacion_3D=1";
            PreparedStatement verDatos2 = con.conectar().prepareStatement(sql2);
            ResultSet ver2 = verDatos2.executeQuery();
            
            while(ver2.next()){
                
                modeloComboCategorias.addElement(ver2.getObject("nombreCategoria"));
                cant++;
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);

        }
    }
    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setContentAreaFilled(true);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
        jButton2.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        System.out.println(""+jComboBox1.getSelectedIndex());
        stockes[0][jComboBox1.getSelectedIndex()]=0;
        stockes[1][jComboBox1.getSelectedIndex()]=0;
        stockes[2][jComboBox1.getSelectedIndex()]=0;
        stockes[3][jComboBox1.getSelectedIndex()]=0;
        modeloLista2.removeAllElements();
        double suma=0;
        for (int i = 0; i < 9; i++) {
            try {
                if(Integer.valueOf(stockes[0][i].toString())!=0){
                modeloLista2.addElement(i+1+". "+stockes[3][i]+" Cant. "+stockes[1][i]+" $"+stockes[2][i]);
                suma=suma+Double.valueOf(stockes[2][i].toString());
                }
            } catch (Exception e) {
            }
            
        }
        total=suma;
        DecimalFormat df = new DecimalFormat("#.00"); 
        jTFTotal.setText(""+df.format(total));
        contador--;
        //System.out.println("Stockes: "+stockes[0][jComboBox1.getSelectedIndex()]+" valor: "+stockes[1][jComboBox1.getSelectedIndex()]);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < 9; i++) {
            System.out.println("0  "+stockes[0][i]);
            System.out.println("1  "+stockes[1][i]);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseExited
    Object[] datos= new Object[7];
    Integer contador=0;
    Object[][] stockes = new Object[4][50];
    double total=0;
    double[] bench = new double[5];
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        System.out.println("Index: "+jComboBox1.getSelectedIndex());
        if (jComboBox1.getSelectedIndex()>=1 &&  jComboBox1.getSelectedIndex()<=4 ) {
            bench[jComboBox1.getSelectedIndex()]= Double.valueOf(jTFPuntaje.getText());
        }
        System.out.println("Stockes: "+stockes[0][jComboBox1.getSelectedIndex()]+" valor: "+stockes[1][jComboBox1.getSelectedIndex()]);
        datos[0] = contador;
        datos[1] = jTFCodigo.getText();
        datos[2] = jList2.getSelectedValue();
        datos[3] = jComboBox1.getSelectedItem();
        datos[4] = jTFPrecio1.getText();
        datos[5] = spin.getValue().toString();
        double subtotal = (Double.parseDouble(jTFPrecio1.getText())) * Integer.valueOf(spin.getValue().toString());
        datos[6] = subtotal;
        modeloLista2.addElement(contador+1+". "+datos[2]+" Cant. "+datos[5]+" $"+datos[6]);
        stockes[0][jComboBox1.getSelectedIndex()]= Integer.parseInt(datos[1].toString());
        stockes[1][jComboBox1.getSelectedIndex()]= Integer.parseInt(datos[5].toString());
        stockes[2][jComboBox1.getSelectedIndex()]= datos[6].toString();
        stockes[3][jComboBox1.getSelectedIndex()]= datos[2].toString();
        
        total = total + subtotal;
        DecimalFormat df = new DecimalFormat("#.00"); 
        System.out.println("Stockes: "+stockes[0][jComboBox1.getSelectedIndex()]+" valor: "+stockes[1][jComboBox1.getSelectedIndex()]);
        jTFTotal.setText(df.format(total));
        contador++;
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTFCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCodigoActionPerformed

    private void jTFCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCodigoKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();

        if (verificar.vnumeros(vchar) == true
            && (jTFCodigo.getText().length() < 8)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTFCodigoKeyTyped

    private void jTFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNombreActionPerformed

    private void jTFNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNombreKeyTyped

    private void jTFPuntajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFPuntajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFPuntajeActionPerformed

    private void jTFPuntajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPuntajeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFPuntajeKeyTyped
    private void llenarList(int tipo, String valores) {
        modeloLista.removeAllElements();
        Conexion cn = new Conexion();
        try {
            String sql3 = "";
            switch (tipo) {
                case 1:
                    sql3 = "select nombreProducto from producto, categoriaProducto "+
                    " where categoriaProducto.nombreCategoria='"+valores+"' AND categoriaProducto.idCategoria=producto.idCategoria";
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
    
    SpinnerNumberModel model = new SpinnerNumberModel(
            new Integer(1), // Dato visualizado al inicio en el spinner 
            new Integer(1), // Límite inferior 
            new Integer(1), // Límite superior 
            new Integer(1) // incremento-decremento 
    );
    SpinnerNumberModel model2 = new SpinnerNumberModel(
            new Integer(1), // Dato visualizado al inicio en el spinner 
            new Integer(1), // Límite inferior 
            new Integer(4), // Límite superior 
            new Integer(1) // incremento-decremento 
    );
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
        llenarList(1,""+jComboBox1.getSelectedItem());
        if (jComboBox1.getSelectedItem().equals("Almacenamiento") || jComboBox1.getSelectedItem().equals("Pasta Termica")|| jComboBox1.getSelectedItem().equals("RAM") ) {
            spin.setModel(model2);
        }else{
            spin.setModel(model);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    Integer stockGeneral;
    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        // TODO add your handling code here:
        try {
            Conexion cn = new Conexion();
            String sql ="SELECT * FROM producto WHERE nombreProducto='"+jList2.getSelectedValue()+"'";
            PreparedStatement cmd = cn.conectar().prepareStatement(sql);
            ResultSet ver =cmd.executeQuery();
            if (ver.next()) {
                jTFCodigo.setText(String.valueOf(ver.getInt(1)));
                jTFNombre.setText(ver.getString(2));
                jTA1.setText(ver.getString(3));
                jTFPuntaje.setText(String.valueOf(ver.getInt(7)));
                try {
                    String sql2 = "SELECT TOP 1 (precioCompra * ((porcentajeGanacia + impuestos)/100))+precioCompra FROM inventario where idProductos="+jTFCodigo.getText()+" ORDER By idInventario DESC  ";
                    PreparedStatement cmd2 = cn.conectar().prepareStatement(sql2);
                    ResultSet ver2 = cmd2.executeQuery();
                    if (ver2.next()) {
                        mtoPresupuesto obj = new mtoPresupuesto();
                        String[] datos = obj.consultarProducto(jTFCodigo.getText());
                        stockGeneral = Integer.valueOf(datos[3]);
                        System.out.println("stock g: " + stockGeneral);
                        double precio = (Double.parseDouble(datos[1])) + (Double.parseDouble(datos[2]));
                        double precio2 = (Double.parseDouble(datos[0])) * (precio / 100);
                        double precio3 = precio2 + (Double.parseDouble(datos[0]));
                        DecimalFormat df = new DecimalFormat("#.00");
                        
                        jTFPrecio1.setText(String.valueOf(df.format(precio3)));
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                
                ImageIcon icon = new ImageIcon(ver.getString(4));
                ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                lblFoto.setIcon(icono);
            }
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_jList2MouseClicked

    private void jTFPrecio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFPrecio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFPrecio1ActionPerformed

    private void jTFPrecio1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrecio1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFPrecio1KeyTyped

    private void jList3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jList3MouseClicked

    private void jTFTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFTotalActionPerformed

    private void jTFTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFTotalKeyTyped

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseExited

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (contador>=7) {
            try {
            Conexion cn = new Conexion();
            mtoPresupuesto obj = new mtoPresupuesto();
            
            obj.setCorreoCliente(String.valueOf(jComboBox2.getSelectedItem()));
 
            obj.setCodigoEstado(1);
            
            obj.setMontoTotal(total);
            if (obj.guardarPedido()) {
                System.out.println("Entra");
                for (int i = 0; i < 9; i++) {
                   
                       try {
                        String sql3 = "INSERT INTO detallePedido(idDetalleP, idPedido, idProducto, cantidadProducto) "
                                + " VALUES ((SELECT MAX (idDetalleP) FROM detallePedido)+1,(SELECT MAX(idPedido) FROM pedido ),?, ?)";
                        PreparedStatement cmd3 = cn.conectar().prepareStatement(sql3);
                           try {
                               if (Integer.valueOf(stockes[0][i].toString()) != 0 || stockes[0][i] != null) {
                                   cmd3.setInt(1, Integer.valueOf(stockes[0][i].toString()));
                                   cmd3.setInt(2, Integer.valueOf(stockes[1][i].toString()));
                                   if (!cmd3.execute()) {
                                       if (i == (8)) {
                                           JOptionPane.showMessageDialog(this, "Presupuesto guardado correctamente");
                                           double benchT = (bench[0] * 0.65) + (bench[1] * 0.90) + (bench[2] * 0.75) + (bench[3] * 0.70);
                                           JOptionPane.showMessageDialog(this, "Calificacion benchmark de la PC es: " + benchT);
                                           crearReporte();
                                       }

                                   }
                               } else {
                                   System.out.println("hay un nulo");
                               }
                           } catch (Exception e) {
                           }
                        
                    } catch (Exception e) {
                           System.out.println("ESTE "+e);
                        String sql3 = "INSERT INTO detallePedido(idDetalleP, idPedido, idProducto, cantidadProducto) "
                                + " VALUES (1,(SELECT MAX(idPedido) FROM pedido ),?, ?)";
                        PreparedStatement cmd3 = cn.conectar().prepareStatement(sql3);
                        if (Integer.valueOf(stockes[0][i].toString())!=0) {
                            cmd3.setInt(1, Integer.valueOf(stockes[0][i].toString()));
                            cmd3.setInt(2, Integer.valueOf(stockes[1][i].toString()));
                                if (!cmd3.execute()) {
                                    if (i == (8)) {
                                        JOptionPane.showMessageDialog(this, "Presupuesto guardado correctamente");
                                        crearReporte();
                                    }
                                }
                            }
                        }              
                    }
                }
            } catch (Exception e) {
                System.out.println("esteS; "+e.toString());
            }
        }else{
            JOptionPane.showMessageDialog(this,"Faltan componentes");
        }
    }//GEN-LAST:event_jButton5ActionPerformed
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
            
            parametros.put("autor", jComboBox2.getSelectedItem()); 
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTA1;
    private javax.swing.JTextField jTFCodigo;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFPrecio1;
    private javax.swing.JTextField jTFPuntaje;
    private javax.swing.JTextField jTFTotal;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblhelp;
    private javax.swing.JSpinner spin;
    // End of variables declaration//GEN-END:variables
}
