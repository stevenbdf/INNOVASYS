/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import formularios.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Steven
 */
public class mtoUsuarios extends PEmpleado{

    /**
     * @return the codigoE
     */
    public Integer getCodigoE() {
        return codigoE;
    }

    /**
     * @param codigoE the codigoE to set
     */
    public void setCodigoE(Integer codigoE) {
        this.codigoE = codigoE;
    }

    /**
     * @return the nombreE
     */
    public String getNombreE() {
        return nombreE;
    }

    /**
     * @param nombreE the nombreE to set
     */
    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    /**
     * @return the descripcionE
     */
    public String getDescripcionE() {
        return descripcionE;
    }

    /**
     * @param descripcionE the descripcionE to set
     */
    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    //atributos para login
    private String correo;
    private String contraseña;
    private Connection cn;
    
    //atributos para estado empleado
    private Integer codigoE;
    private String nombreE;
    private String descripcionE;
    
    
    public mtoUsuarios(){
        Conexion con = new Conexion();
        cn= con.conectar();
    }
    
    public boolean consultarContraseña(){
        boolean resp= false;
        try {
             String sql = "SELECT contraseña FROM usuarioEmpleado WHERE correoElectronico=?";
          
            //Se pasan por referencia por seguridad
            //importar clase PreparedStatement
            PreparedStatement cmd = cn.prepareStatement(sql);
            //Llenar los parametros de la clase, se coloca en el ordne de la tabla
            cmd.setString(1, correo);
            //Importar clase resultset
            ResultSet rs= cmd.executeQuery();
            //Recorrer la lista de registro
            if (rs.next()) {
                resp = true;
                contraseña = rs.getString(1);
            }
            cmd.close();
            cn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resp;
    }
    String resp2="";
    public void consultarEstado() {

        try {
            String sql = "SELECT nombreEstado FROM estadoEmpleado WHERE nombreEstado=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, nombreE);
            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                resp2 = rs.getString(1);
            }
            cmd.close();
//          cn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
    
    public boolean guardarEstadoEmpleado(){
        boolean resp = false;
        consultarEstado();
        if (resp2.equals(nombreE)) {
            JOptionPane.showMessageDialog(this,"Error ya existe un estado con ese nombre");
        } else {
            try {

                String sql2 = "INSERT INTO estadoEmpleado(idEstado,nombreEstado,descripcion) VALUES ((SELECT MAX(idEstado)+1 FROM estadoEmpleado),?,?)";
                PreparedStatement cmd2 = cn.prepareStatement(sql2);
                cmd2.setString(1, nombreE);
                cmd2.setString(2, descripcionE);
                if (!cmd2.execute()) {
                    resp = true;
                } 
                cmd2.close();
                cn.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        return resp;
    }
    
    public boolean modificarEstadoEmpleado(){
        boolean resp= false;
        
        try {
            String sql ="UPDATE estadoEmpleado SET nombreEstado=?,descripcion=? WHERE idEstado=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1,getNombreE());
            cmd.setString(2,getDescripcionE());
            cmd.setInt(3,getCodigoE());
            
                if (!cmd.execute()) {
                resp=true;
                }
            cmd.close();
            cn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resp;
    }
    
    public boolean eliminarEstadoEmpleado(){
        boolean resp=false;
        try {
            String sql ="DELETE FROM estadoEmpleado WHERE idEmpleado=?";
            
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1,codigoE);
            
            if (!cmd.execute()) {
                resp=true;
            }
            cmd.close();
            cn.close();
        } catch (Exception e) {
            System.out.println(e.toString());         
        }
        return resp;
    }
}
