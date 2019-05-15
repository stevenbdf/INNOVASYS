/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author JUANCARLOS
 */
public class recuperarContraseña {

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
     * @return the pregunta1
     */
    public String getPregunta1() {
        return pregunta1;
    }

    /**
     * @param pregunta1 the pregunta1 to set
     */
    public void setPregunta1(String pregunta1) {
        this.pregunta1 = pregunta1;
    }

    /**
     * @return the pregunta2
     */
    public String getPregunta2() {
        return pregunta2;
    }

    /**
     * @param pregunta2 the pregunta2 to set
     */
    public void setPregunta2(String pregunta2) {
        this.pregunta2 = pregunta2;
    }

    /**
     * @return the respuesta1
     */
    public String getRespuesta1() {
        return respuesta1;
    }

    /**
     * @param respuesta1 the respuesta1 to set
     */
    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    /**
     * @return the respuesta2
     */
    public String getRespuesta2() {
        return respuesta2;
    }

    /**
     * @param respuesta2 the respuesta2 to set
     */
    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }
    private Connection cn;
    public recuperarContraseña(){
        Conexion con = new Conexion();
        cn= con.conectar();
    }
    private String correo;
    private String pregunta1;
    private String pregunta2;
    private String respuesta1;
    private String respuesta2;
    private String contraseña;
    
    public boolean obtenerPreguntas(){
        boolean retorno=false;
        try {
            String sql ="SELECT pregunta1, pregunta2 FROM usuarioEmpleado WHERE correoElectronico=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            System.out.println("correo mto: "+getCorreo());
            cmd.setString(1, getCorreo());
            ResultSet ver = cmd.executeQuery();
            if (ver.next()) {
                setPregunta1(ver.getString(1));
                setPregunta2(ver.getString(2));
                retorno=true;
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return retorno;
    }
    
    public boolean obtenerContraseña(){
        boolean retorno=false;
        try {
            String sql ="select CONVERT(varchar(max),Decryptbypassphrase('FCBarcelona321',(select contraseña from usuarioEmpleado where correoElectronico=?))) as contra  from usuarioEmpleado where correoElectronico =?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, getCorreo());
            cmd.setString(2, getCorreo());
            ResultSet ver = cmd.executeQuery();
            
            if (ver.next()) {
                setContraseña(ver.getString(1));
                System.out.println("Contraseña: "+getContraseña());
                retorno=true;
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return retorno;
    }
    
    public boolean obtenerRespuestas(){
        boolean retorno=false;
        try {
            String sql ="SELECT respuesta1 , respuesta2 FROM usuarioEmpleado WHERE correoElectronico=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, getCorreo());
            ResultSet ver = cmd.executeQuery();
            if (ver.next()) {
                setRespuesta1(ver.getString(1));
                setRespuesta2(ver.getString(2));
                retorno=true;
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return retorno;
    }
}
