/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;
import clases.mtoDatosEmpresa;
import clases.verificaciones;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author steve
 */
public class PDatosEmpresa extends javax.swing.JPanel {

    /**
     * Creates new form PDatosEmpresa
     */
    verificaciones verificar = new verificaciones();
    public PDatosEmpresa() {
//                try {
//                     UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//		}
//		catch (Exception e) {
//		}
        initComponents();
        
        Calendar c2 = new GregorianCalendar();
        fecha.setCalendar(c2);
        Calendar hoy = Calendar.getInstance();
        int año = hoy.get(Calendar.YEAR);
        int año2 = hoy.get(Calendar.YEAR) - 25;
        hoy.add(Calendar.MONTH, 1);
        int mes = hoy.get(Calendar.MONTH);
        int dia = hoy.get(Calendar.DAY_OF_MONTH);
        String fechaP = año + "-" + mes + "-" + dia;
        String fechaP2 = año2 + "-" + mes + "-" + dia;
            
        fecha.setMaxSelectableDate(verificar.StringADate(fechaP));
        fecha.setMinSelectableDate(verificar.StringADate(fechaP2));
        
        mtoDatosEmpresa obj = new mtoDatosEmpresa();
        if (obj.consultarDatos()) {
            nombre.setText(obj.getNombre());
            domicilio.setText(obj.getDomicilio());
            fecha.setDate(verificar.StringADate(obj.getFecha()));
            descripcion.setText(obj.getDescripcion());
            String logito=obj.getLogo();
            System.out.println(logito);
            try{
                
                datos=logito;
            ImageIcon icon = new ImageIcon(logito);
                ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(130, 110, Image.SCALE_DEFAULT));
                logo.setIcon(icono);
            
            } catch (Exception e){

            }
            
            
            
            
            tel1.setText(String.valueOf(obj.getTelefono1()));
            tel2.setText(String.valueOf(obj.getTelefono2()));
            fax1.setText(String.valueOf(obj.getFax1()));
            fax2.setText(String.valueOf(obj.getFax2()));
            correo1.setText(String.valueOf(obj.getCorreo1()));
            correo2.setText(String.valueOf(obj.getCorreo2()));
            propietario.setText(obj.getPropietario());
            noFactura.setText(String.valueOf(obj.getNoFactura()));
            noCredito.setText(String.valueOf(obj.getNoFiscal()));
        }
    
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        domicilio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tel1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tel2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        fax2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fax1 = new javax.swing.JTextField();
        correo1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        correo2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        propietario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        noFactura = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        noCredito = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lblhelp = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        fecha = new com.toedter.calendar.JDateChooser();
        logo = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153), 3));
        jPanel1.setMaximumSize(new java.awt.Dimension(680, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("Gestion de los Datos de la Empresa");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, 31));

        nombre.setBackground(new java.awt.Color(204, 204, 204));
        nombre.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 60, 200, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre de la Empresa:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        domicilio.setBackground(new java.awt.Color(204, 204, 204));
        domicilio.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        domicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                domicilioActionPerformed(evt);
            }
        });
        domicilio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                domicilioKeyTyped(evt);
            }
        });
        jPanel1.add(domicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 101, 200, 30));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Domicilio:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        tel1.setBackground(new java.awt.Color(204, 204, 204));
        tel1.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        tel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tel1ActionPerformed(evt);
            }
        });
        tel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tel1KeyTyped(evt);
            }
        });
        jPanel1.add(tel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 60, 126, 30));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de Constitucion:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 146, -1, 20));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Descripcion:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 20));

        descripcion.setBackground(new java.awt.Color(204, 204, 204));
        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane1.setViewportView(descripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 200, 111));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Logo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Examinar");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jButton1.setContentAreaFilled(false);
        jButton1.setPreferredSize(new java.awt.Dimension(73, 30));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 81, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Telefono 1:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Telefono 2:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, -1));

        tel2.setBackground(new java.awt.Color(204, 204, 204));
        tel2.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        tel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tel2ActionPerformed(evt);
            }
        });
        tel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tel2KeyTyped(evt);
            }
        });
        jPanel1.add(tel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 101, 126, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Fax 2:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 191, -1, -1));

        fax2.setBackground(new java.awt.Color(204, 204, 204));
        fax2.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        fax2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fax2ActionPerformed(evt);
            }
        });
        fax2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fax2KeyTyped(evt);
            }
        });
        jPanel1.add(fax2, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 183, 126, 30));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Fax 1:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 150, -1, -1));

        fax1.setBackground(new java.awt.Color(204, 204, 204));
        fax1.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        fax1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fax1ActionPerformed(evt);
            }
        });
        fax1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fax1KeyTyped(evt);
            }
        });
        jPanel1.add(fax1, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 142, 126, 30));

        correo1.setBackground(new java.awt.Color(204, 204, 204));
        correo1.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        correo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correo1ActionPerformed(evt);
            }
        });
        correo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                correo1KeyTyped(evt);
            }
        });
        jPanel1.add(correo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 224, 126, 30));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Correo Electronico1:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, -1, -1));

        correo2.setBackground(new java.awt.Color(204, 204, 204));
        correo2.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        correo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correo2ActionPerformed(evt);
            }
        });
        correo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                correo2KeyTyped(evt);
            }
        });
        jPanel1.add(correo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 265, 126, 30));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Correo Electronico2:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, -1, -1));

        propietario.setBackground(new java.awt.Color(204, 204, 204));
        propietario.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        propietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propietarioActionPerformed(evt);
            }
        });
        propietario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                propietarioKeyTyped(evt);
            }
        });
        jPanel1.add(propietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 306, 126, 30));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Propietario:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 312, -1, -1));

        noFactura.setBackground(new java.awt.Color(204, 204, 204));
        noFactura.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        noFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noFacturaActionPerformed(evt);
            }
        });
        noFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noFacturaKeyTyped(evt);
            }
        });
        jPanel1.add(noFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 347, 126, 30));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("No.Correlativo de Factura:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 353, -1, -1));

        noCredito.setBackground(new java.awt.Color(204, 204, 204));
        noCredito.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        noCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noCreditoActionPerformed(evt);
            }
        });
        noCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noCreditoKeyTyped(evt);
            }
        });
        jPanel1.add(noCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 388, 126, 30));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("No.Correlativo de Credito Fiscal:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 394, -1, -1));

        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Modificar Datos");
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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, 140, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

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

        jTextField12.setBackground(new java.awt.Color(204, 204, 204));
        jTextField12.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 101, 187, 30));
        jPanel1.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 180, 30));
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 130, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void domicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_domicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_domicilioActionPerformed

    private void tel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tel1ActionPerformed

    private void tel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tel2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tel2ActionPerformed

    private void fax2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fax2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fax2ActionPerformed

    private void fax1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fax1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fax1ActionPerformed

    private void correo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correo1ActionPerformed

    private void correo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correo2ActionPerformed

    private void propietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_propietarioActionPerformed

    private void noFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noFacturaActionPerformed

    private void noCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noCreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noCreditoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        verificaciones obj = new verificaciones();
        if ((obj.vcorreo(correo1.getText()) == false) || (obj.vcorreo(correo2.getText()) == false)) {
            JOptionPane.showMessageDialog(this, "Ingrese un formato de correo valido");
        } else {
        if(!nombre.getText().isEmpty()&&!domicilio.getText().isEmpty()&&!descripcion.getText().isEmpty()&&!tel1.getText().isEmpty()&&!tel2.getText().isEmpty())
        {
            
            mtoDatosEmpresa objeto = new mtoDatosEmpresa();
            
            objeto.setNombre(nombre.getText());
            objeto.setDomicilio(domicilio.getText());
            objeto.setFecha(verificar.getFecha(fecha));
            objeto.setDescripcion(descripcion.getText());
            objeto.setLogo(datos);
            objeto.setTelefono1(Integer.valueOf(tel1.getText()));
            objeto.setTelefono2(Integer.valueOf(tel2.getText()));
            objeto.setFax1(Integer.valueOf(fax1.getText()));
            objeto.setFax2(Integer.valueOf(fax2.getText()));
            objeto.setCorreo1(correo1.getText());
            objeto.setCorreo2(correo2.getText());
            objeto.setPropietario(propietario.getText());
            objeto.setNoFactura(Integer.valueOf(noFactura.getText()));
            objeto.setNoFiscal(Integer.valueOf(noCredito.getText()));
            if (objeto.modificarDatos()) {
            JOptionPane.showMessageDialog(this,"Datos modificados correctamente");
            }else{
                JOptionPane.showMessageDialog(this,"Datos no modificados");
            }
        }
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        this.hide();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
         jButton1.setContentAreaFilled(true);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
         jButton1.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
         jButton2.setContentAreaFilled(true);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
         jButton2.setContentAreaFilled(false);
    }//GEN-LAST:event_jButton2MouseExited

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
        
        if (verificar.vletras(vchar) == true
                && (nombre.getText().length() < 30)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_nombreKeyTyped

    private void domicilioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_domicilioKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
        
        if (verificar.vletrasynumeros(vchar) == true
                && (domicilio.getText().length() <60)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_domicilioKeyTyped

    private void tel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tel1KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
        
        if (verificar.vnumeros(vchar) == true
                && (tel1.getText().length() < 8)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_tel1KeyTyped

    private void tel2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tel2KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
        
        if (verificar.vnumeros(vchar) == true
                && (tel2.getText().length() < 8)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_tel2KeyTyped

    private void fax1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fax1KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
        
        if (verificar.vnumeros(vchar) == true
                && (fax1.getText().length() < 14)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_fax1KeyTyped

    private void fax2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fax2KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
        
        if (verificar.vnumeros(vchar) == true
                && (fax2.getText().length() < 14)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_fax2KeyTyped

    private void correo1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correo1KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
        
        if (verificar.vcorreoevent(vchar) == true
                && (correo1.getText().length() < 30)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_correo1KeyTyped

    private void correo2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correo2KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
        
        if (verificar.vcorreoevent(vchar) == true
                && (correo2.getText().length() < 30)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_correo2KeyTyped

    private void propietarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_propietarioKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
        
        if (verificar.vletras(vchar) == true
                && (propietario.getText().length() < 30)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_propietarioKeyTyped

    private void noFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noFacturaKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
        
        if (verificar.vnumeros(vchar) == true
                && (noFactura.getText().length() < 5)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_noFacturaKeyTyped

    private void noCreditoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noCreditoKeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
        
        if (verificar.vnumeros(vchar) == true
                && (noCredito.getText().length() < 5)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_noCreditoKeyTyped

    private void lblhelpAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblhelpAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblhelpAncestorAdded

    private void lblhelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhelpMouseClicked
        // TODO add your handling code here:
        //y cuando llames el formulario ayuda en vez del 0 le vas a poner el form que le corresponda 1 2 o 3 y asi sucesivamente, si vos elegis el orden
        /**
        * ahorita, llena los textos de ayuda de todos los forms, luego vemos lo de las imagenes , me avisas cuando temrines de escribir las instrucciones
        */
        help form = new help(8);
        form.show();
    }//GEN-LAST:event_lblhelpMouseClicked

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyTyped
    File fichero;
    String datos;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int resultado;
        fileChooser ventana = new fileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
        ventana.jfchCargarFoto.setFileFilter(filtro);
        resultado = ventana.jfchCargarFoto.showOpenDialog(null);
        if (JFileChooser.APPROVE_OPTION == resultado) {
            fichero = ventana.jfchCargarFoto.getSelectedFile();
            datos=String.valueOf(fichero);
            try {
                ImageIcon icon = new ImageIcon(fichero.toString());
                ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
                logo.setIcon(icono);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen " + ex);
            }
        } 
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField correo1;
    private javax.swing.JTextField correo2;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JTextField domicilio;
    private javax.swing.JTextField fax1;
    private javax.swing.JTextField fax2;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JLabel lblhelp;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField noCredito;
    private javax.swing.JTextField noFactura;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField propietario;
    private javax.swing.JTextField tel1;
    private javax.swing.JTextField tel2;
    // End of variables declaration//GEN-END:variables
}
