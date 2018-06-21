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
     * @return the codigoD
     */
    public Integer getCodigoD() {
        return codigoD;
    }

    /**
     * @param codigoD the codigoD to set
     */
    public void setCodigoD(Integer codigoD) {
        this.codigoD = codigoD;
    }

    /**
     * @return the nombreD
     */
    public String getNombreD() {
        return nombreD;
    }

    /**
     * @param nombreD the nombreD to set
     */
    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    /**
     * @return the estadoD
     */
    public String getEstadoD() {
        return estadoD;
    }

    /**
     * @param estadoD the estadoD to set
     */
    public void setEstadoD(String estadoD) {
        this.estadoD = estadoD;
    }

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
    
    //atributos para documento empleado
    private Integer codigoD;
    private String nombreD;
    private String estadoD;
    
    
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
    
    public String[] consultarEstado() {
        String[] resp2=new  String[3];
        resp2[0]="";
        resp2[1]="";
        resp2[2]="";
        try {
            String sql = "SELECT idEstado, nombreEstado, descripcion FROM estadoEmpleado WHERE nombreEstado=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, getNombreE());
            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                //nombreEstado
                resp2[0] = rs.getString(2);
                //descripcion
                resp2[1] = rs.getString(3);
                //idEstado
                resp2[2] = rs.getString(1);
            }
            cmd.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resp2;
    }
    
    public boolean guardarEstadoEmpleado(){
        boolean resp = false;
        String[] resp2=consultarEstado();
        if (resp2[0] .equals(getNombreE())) {
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
        String[] resp2=consultarEstado();
//        System.out.println("Codigo:"+resp2[2]);
//        System.out.println("Nombre:"+resp2[0]);
//        System.out.println("Descripcion:"+resp2[1]);
        if (resp2[0].equals(getNombreE()) && resp2[1].equals(getDescripcionE())) {
                JOptionPane.showMessageDialog(this, "Modifique algun dato para realizar esta accion");                   
        }else if (resp2[0].equals(getNombreE()) && !resp2[1].equals(getDescripcionE())) {
            try {
                String sql = "UPDATE estadoEmpleado SET descripcion=? WHERE idEstado=?";
                PreparedStatement cmd = cn.prepareStatement(sql);        
                cmd.setString(1, getDescripcionE());
                cmd.setInt(2, getCodigoE());

                if (!cmd.execute()) {
                    resp = true;
                }
                cmd.close();
                cn.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }else{
            try {
                String sql = "UPDATE estadoEmpleado SET nombreEstado=?,descripcion=? WHERE idEstado=?";
                PreparedStatement cmd = cn.prepareStatement(sql);
                cmd.setString(1,getNombreE());
                cmd.setString(2, getDescripcionE());
                cmd.setInt(3, getCodigoE());

                if (!cmd.execute()) {
                    resp = true;
                }
                cmd.close();
                cn.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return resp;
    }
    
    public boolean eliminarEstadoEmpleado(){
        boolean resp=false;
        try {
            String sql ="DELETE FROM estadoEmpleado WHERE idEstado=?";
            
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
    
    public String[] consultarDocumento(){
        String[] resp2=new  String[3];
        resp2[0]="";
        resp2[1]="";
        resp2[2]="";
        try {
            String sql = "SELECT idDocumento,nombre,estado FROM documento WHERE nombre=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, getNombreD());
            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                resp2[0] = rs.getString(2);
                resp2[1] = rs.getString(3);
                resp2[2] = rs.getString(1);
            }
            cmd.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resp2;
    }
    
    public boolean guardarDocumento(){
        boolean resp=false;
        String[] resp2=consultarDocumento();
        if (resp2[0].equals(getNombreD())) {
            JOptionPane.showMessageDialog(this,"Error ya existe un documento con ese nombre");
        }
        else {
            try {

                String sql2 = "INSERT INTO documento(idDocumento,nombre,estado) VALUES ((SELECT MAX(idDocumento)+1 FROM documento),?,?)";
                PreparedStatement cmd2 = cn.prepareStatement(sql2);
                cmd2.setString(1, getNombreD());
                cmd2.setString(2, getEstadoD());
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
    
    public boolean modificarDocumento(){
        boolean resp = false;
        String[] resp2=consultarDocumento();
        if (resp2[0].equals(getNombreD()) && resp2[1].equals(getEstadoD())) {
            
                JOptionPane.showMessageDialog(this, "Modifique algun dato para realizar esta accion");                   
        } else if(resp2[0].equals(getNombreD()) && !resp2[1].equals(getEstadoD())) {
            try {
                String sql = "UPDATE documento SET estado=? WHERE idDocumento=?";
                PreparedStatement cmd = cn.prepareStatement(sql);
                cmd.setString(1, getEstadoD());
                cmd.setInt(2, getCodigoD());

                if (!cmd.execute()) {
                    resp = true;
                }
                cmd.close();
                cn.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }else{
            try {
                String sql = "UPDATE documento SET nombre=?,estado=? WHERE idDocumento=?";
                PreparedStatement cmd = cn.prepareStatement(sql);
                cmd.setString(1,getNombreD());
                cmd.setString(2, getEstadoD());
                cmd.setInt(3, getCodigoD());

                if (!cmd.execute()) {
                    resp = true;
                }
                cmd.close();
                cn.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return resp;
    }
    
    public boolean eliminarDocumento(){
        boolean resp=false;
        try {
            String sql ="DELETE FROM documento WHERE idDocumento=?";
            
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1,codigoD);
            
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
