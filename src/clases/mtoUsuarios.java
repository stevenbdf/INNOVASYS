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
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Steven
 */
public class mtoUsuarios extends PEmpleado{

    public Integer getCodigoDEE() {
        return codigoDEE;
    }

    public void setCodigoDEE(Integer codigoDEE) {
        this.codigoDEE = codigoDEE;
    }

    public Integer getCodigoDE() {
        return codigoDE;
    }

    public void setCodigoDE(Integer codigoDE) {
        this.codigoDE = codigoDE;
    }

    public Integer getCodigoDD() {
        return codigoDD;
    }

    public void setCodigoDD(Integer codigoDD) {
        this.codigoDD = codigoDD;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getPregunta1() {
        return pregunta1;
    }

    public void setPregunta1(String pregunta1) {
        this.pregunta1 = pregunta1;
        
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
        
    }

    public String getPregunta2() {
        return pregunta2;
    }

    public void setPregunta2(String pregunta2) {
        this.pregunta2 = pregunta2;
        
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
        
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
        
    }

    public Integer getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(Integer codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
        
    }

    public Integer getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(Integer codigoTipo) {
        this.codigoTipo = codigoTipo;
        
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
        
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
        
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
        
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
        
    }

    public String getContraseñaEmpleado() {
        return contraseñaEmpleado;
    }

    public void setContraseñaEmpleado(String contraseñaEmpleado) {
        this.contraseñaEmpleado = contraseñaEmpleado;
        
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
        
    }

    public Integer getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Integer codigoEstado) {
        this.codigoEstado = codigoEstado;
       
    }

    public String getDatoDocumento() {
        return datoDocumento;
    }

    public void setDatoDocumento(String datoDocumento) {
        this.datoDocumento = datoDocumento; 
    }

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
    
    //atributos para empleados
    private Integer codigoEmpleado;
    private Integer codigoTipo;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private Integer telefono;
    private String correoEmpleado;
    private String contraseñaEmpleado;
    private String direccion;
    private Integer codigoEstado;
    private String datoDocumento;
    private String imagen;
    private String pregunta1;
    private String respuesta1;
    private String pregunta2;
    private String respuesta2;  
    
    //atributos para Documentos Empleado
    private Integer codigoDEE;
    private Integer codigoDE;
    private Integer codigoDD;
    private String descrip;
    
    /**
     * Llaves necesarias para la combinacion e incriptacion de claves
     */
    String key = "92AE31A79FEEB2A3"; //llave
    String iv = "0123456789ABCDEF"; // vector de inicialización    
    
    
    public mtoUsuarios(){
        Conexion con = new Conexion();
        cn= con.conectar();
    }
    
    public boolean consultarContraseña(){
        verificaciones obj= new verificaciones();
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
                 contraseña = obj.decrypt(key,iv,rs.getString(1));
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
    
    public String[] consultarEmpleado() {
        ArrayList <String> datos = new ArrayList();
        try {
            String sql = "SELECT *"
                    + "FROM usuarioEmpleado WHERE correoElectronico=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1,getCorreoEmpleado());
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                for (int i = 1; i <(rs.getMetaData().getColumnCount())+1; i++) {
                  datos.add(rs.getString(i));
                }           
            }
            cmd.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        String valores[]= new String[datos.size()];
        valores=datos.toArray(valores);
        return valores;
    }
    
    public boolean guardarEmpleado(){
        boolean resp=false;
        String[] datos = consultarEmpleado();
        if (datos[5].equals(getCorreoEmpleado())) {
            JOptionPane.showMessageDialog(this,"Error ya existe un empleado con ese correo electronico");
        }else{
            try {
                String sql = "INSERT INTO usuarioEmpleado(idEmpleado, idTipo,"
                        + " nombres, apellidos, telefono, correoElectronico, contraseña, direccion, idEstado, imagen, pregunta1,respuesta1, pregunta2, respuesta2)"
                        + "VALUES ((SELECT MAX(idEmpleado)+1 FROM usuarioEmpleado),?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement cmd = cn.prepareStatement(sql);
                cmd.setInt(1,getCodigoTipo());
                cmd.setString(2,getNombreEmpleado());
                cmd.setString(3,getApellidoEmpleado());
                cmd.setInt(4,getTelefono());
                cmd.setString(5,getCorreoEmpleado());
                cmd.setString(6,getContraseñaEmpleado());
                cmd.setString(7,getDireccion());
                cmd.setInt(8,getCodigoEstado());
                cmd.setString(9,getImagen());
                cmd.setString(10,getPregunta1());
                cmd.setString(11,getRespuesta1());
                cmd.setString(12,getPregunta2());
                cmd.setString(13, getRespuesta2());               
                if (!cmd.execute()) {
                    resp=true;
                } 
                cmd.close();
                cn.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return resp;
    }
    
    public boolean modificarEmpleado(){
        //valores.false = no son iguales, true= 1 o mas son iguales
        boolean resp=false;       
            try {
                String sql ="UPDATE usuarioEmpleado SET idTipo=?, nombres=?, apellidos=?, telefono=?, correoElectronico=?, contraseña=?, direccion=?, idEstado=?, imagen=?, pregunta1=?, respuesta1=?, pregunta2=?, respuesta2=? WHERE idEmpleado=?";
                PreparedStatement cmd = cn.prepareStatement(sql);
 
                cmd.setInt(1, codigoTipo);
                cmd.setString(2,nombreEmpleado);
                cmd.setString(3,apellidoEmpleado);
                cmd.setInt(4,telefono);
                cmd.setString(5,correoEmpleado);
                cmd.setString(6, contraseñaEmpleado);
                cmd.setString(7,direccion);
                cmd.setInt(8,codigoEstado);
                cmd.setString(9,imagen);
                cmd.setString(10, pregunta1);
                cmd.setString(11, respuesta1);
                cmd.setString(12,pregunta2);
                cmd.setString(13,respuesta2);
                cmd.setInt(14,codigoEmpleado);
      
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
    
    public boolean guardarDocumentoEmpleado(){
        boolean resp=false;
        try {
            String sql2 ="SELECT idDocumento FROM documentoEmpleado WHERE idEmpleado="+codigoDE;
            PreparedStatement cmd2 = cn.prepareStatement(sql2);
            ResultSet ver2 = cmd2.executeQuery();
            if (ver2.next()) {
                if (ver2.getInt(1)==codigoDD) {
                    JOptionPane.showMessageDialog(this,"Error ya existe este tipo de documento registrado a este empleado");
                }else{
                    String sql = "INSERT INTO documentoEmpleado(idDocumentoE , idDocumento, idEmpleado, descripcion) "
                            + "VALUES((SELECT MAX(idDocumentoE) FROM documentoEmpleado )+1,?,?,?)";
                    PreparedStatement cmd = cn.prepareStatement(sql);
                    System.out.println("1: " + codigoDD);
                    System.out.println("2: " + codigoDE);
                    System.out.println("3: " + descrip);
                    cmd.setInt(1, codigoDD);
                    cmd.setInt(2, codigoDE);
                    cmd.setString(3, descrip);

                    if (!cmd.execute()) {
                        resp = true;
                    }
                    cmd.close();
                    cn.close();
                }
            }     
        } catch (Exception e) {
            System.out.println("Metodo");
            System.out.println(e.toString());
        }
        return resp;
    }
    public boolean modificarDocumentoEmpleado(){
        boolean resp=false;
        try { 
            String sql="UPDATE documentoEmpleado SET idDocumento=?,idEmpleado=?,descripcion=? WHERE idDocumentoE=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            System.out.println("1: " + codigoDD);
            System.out.println("2: " + codigoDE);
            System.out.println("3: " + descrip);
            System.out.println("4: " + codigoDEE);
            cmd.setInt(1,codigoDD);
            cmd.setInt(2,codigoDE);
            cmd.setString(3,descrip);
            cmd.setInt(4,codigoDEE);
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
    
    public boolean eliminarDocumentoEmpleado(){
        boolean resp=false;
        try {
            String sql="DELETE FROM documentoEmpleado WHERE idDocumentoE=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1,codigoDEE);
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
