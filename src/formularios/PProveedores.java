/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.verificaciones;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/**
 *
 * @author steve
 */
public class PProveedores extends javax.swing.JPanel {

    /**
     * Creates new form PProveedores
     */
    verificaciones verificar = new verificaciones();
    public PProveedores() {
//         try {
//                     UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//		}
//		catch (Exception e) {
//		}
        initComponents();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblhelp = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153), 3));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 315, 200));

        jTextField4.setBackground(new java.awt.Color(204, 204, 204));
        jTextField4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 110, 30));

        jRadioButton1.setBackground(new java.awt.Color(102, 102, 102));
        jRadioButton1.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Nombre");
        add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 65, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Buscar:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, 20));

        jRadioButton2.setBackground(new java.awt.Color(102, 102, 102));
        jRadioButton2.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Codigo");
        add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 65, -1, -1));

        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 155, 30));

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 78, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre  Proveedor:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

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
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 120, -1));

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
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 90, -1));

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
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 90, -1));

        jTextField3.setBackground(new java.awt.Color(204, 204, 204));
        jTextField3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 155, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Direccion:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, 20));

        jTextField5.setBackground(new java.awt.Color(204, 204, 204));
        jTextField5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 155, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fax:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, -1, -1));

        jTextField6.setBackground(new java.awt.Color(204, 204, 204));
        jTextField6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 155, 30));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Correo Electronico:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jTextField7.setBackground(new java.awt.Color(204, 204, 204));
        jTextField7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 155, 30));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("Gestion de los Proveedores");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, 31));

        jTextField8.setBackground(new java.awt.Color(204, 204, 204));
        jTextField8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });
        add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 155, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Estado:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

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
        add(lblhelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 25, 25));
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
        char vchar = evt.getKeyChar();
       
        if (verificar.vnumeros(vchar) == true
                && (jTextField1.getText().length() <6)) {

        } else {
            evt.consume();
        }
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
                && (jTextField6.getText().length() < 40)) {

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

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vletras(vchar) == true
                && (jTextField8.getText().length() < 20)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
        char vchar = evt.getKeyChar();
       
        if (verificar.vletrasynumeros(vchar) == true
                && (jTextField7.getText().length() < 10)) {

        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField4KeyTyped

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lblhelp;
    // End of variables declaration//GEN-END:variables
}
