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
public class mtoUsuarios {

    /**
     * @return the ingreso
     */
    public Integer getIngreso() {
        return ingreso;
    }

    /**
     * @param ingreso the ingreso to set
     */
    public void setIngreso(Integer ingreso) {
        this.ingreso = ingreso;
    }

    /**
     * @return the codigoRubro
     */
    public Integer getCodigoRubro() {
        return codigoRubro;
    }

    /**
     * @param codigoRubro the codigoRubro to set
     */
    public void setCodigoRubro(Integer codigoRubro) {
        this.codigoRubro = codigoRubro;
    }

    /**
     * @return the nombreRubro
     */
    public String getNombreRubro() {
        return nombreRubro;
    }

    /**
     * @param nombreRubro the nombreRubro to set
     */
    public void setNombreRubro(String nombreRubro) {
        this.nombreRubro = nombreRubro;
    }

    /**
     * @return the descripRubro
     */
    public String getDescripRubro() {
        return descripRubro;
    }

    /**
     * @param descripRubro the descripRubro to set
     */
    public void setDescripRubro(String descripRubro) {
        this.descripRubro = descripRubro;
    }

    /**
     * @return the cn
     */
    public Connection getCn() {
        return cn;
    }

    /**
     * @param cn the cn to set
     */
    public void setCn(Connection cn) {
        this.cn = cn;
    }

    /**
     * @return the nombreP
     */
    public String getNombreP() {
        return nombreP;
    }

    /**
     * @param nombreP the nombreP to set
     */
    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    /**
     * @return the telefonoP
     */
    public Integer getTelefonoP() {
        return telefonoP;
    }
    
    public boolean bitacora(){
        boolean resp= false;
        try {
             String sql = "SELECT idEmpleado FROM usuarioEmpleado WHERE correoElectronico=?";
          
            //Se pasan por referencia por seguridad
            //importar clase PreparedStatement
            PreparedStatement cmd = getCn().prepareStatement(sql);
            //Llenar los parametros de la clase, se coloca en el ordne de la tabla
            cmd.setString(1, getCorreo());
            //Importar clase resultset
            ResultSet rs= cmd.executeQuery();
            //Recorrer la lista de registro
            if (rs.next()) {
                int ids = Integer.valueOf(rs.getString(1));
                try {

                String sql2 = "INSERT bitacoraEmpleado VALUES ((SELECT MAX(idBitacora)+1 FROM bitacoraEmpleado),getDate(),?)";
                PreparedStatement cmd2 = getCn().prepareStatement(sql2);
                cmd2.setInt(1, ids);
                if (!cmd2.execute()) {
                    resp = true;
                    System.out.println("Ingresado en bitacora");
                } 
                cmd2.close();
                getCn().close();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
            cmd.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resp;
    }
    
    /**
     * @param telefonoP the telefonoP to set
     */
    public void setTelefonoP(Integer telefonoP) {
        this.telefonoP = telefonoP;
    }

    /**
     * @return the correoP
     */
    public String getCorreoP() {
        return correoP;
    }

    /**
     * @param correoP the correoP to set
     */
    public void setCorreoP(String correoP) {
        this.correoP = correoP;
    }

    /**
     * @return the faxP
     */
    public Integer getFaxP() {
        return faxP;
    }

    /**
     * @param faxP the faxP to set
     */
    public void setFaxP(Integer faxP) {
        this.faxP = faxP;
    }

    /**
     * @return the direccionP
     */
    public String getDireccionP() {
        return direccionP;
    }

    /**
     * @param direccionP the direccionP to set
     */
    public void setDireccionP(String direccionP) {
        this.direccionP = direccionP;
    }

    /**
     * @return the estadoP
     */
    public String getEstadoP() {
        return estadoP;
    }

    /**
     * @param estadoP the estadoP to set
     */
    public void setEstadoP(String estadoP) {
        this.estadoP = estadoP;
    }

    /**
     * @return the idP
     */
    public Integer getIdP() {
        return idP;
    }

    /**
     * @param idP the idP to set
     */
    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the iv
     */
    public String getIv() {
        return iv;
    }

    /**
     * @param iv the iv to set
     */
    public void setIv(String iv) {
        this.iv = iv;
    }

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
    private Integer ingreso;
    
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
    
    //atributos para proveedor
    private String nombreP;
    private Integer telefonoP;
    private String correoP;
    private Integer faxP;
    private String direccionP;
    private String estadoP;
    private Integer idP;
    
    //atributos para rubros de proveedores
    private Integer codigoRubro;
    private String nombreRubro;
    private String descripRubro;
    
    /**
     * Llaves necesarias para la combinacion e incriptacion de claves
     */
    private String key = "92AE31A79FEEB2A3"; //llave
    private String iv = "0123456789ABCDEF"; // vector de inicialización    
    
    
    public mtoUsuarios(){
        Conexion con = new Conexion();
        cn= con.conectar();
    }
    
    public boolean validarIngreso(){
        boolean resp= false;
        try {
            //ha modifique la tabla, esta funcion valida si tenes permiso de entrar al sistema
            //apues donde validas la contra y el usuario?
            String sql = "select es.nombreEstado "
                    + " from usuarioEmpleado us, estadoEmpleado es "
                    + " where us.idEstado=es.idEstado AND us.correoElectronico=?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getCorreo());
            ResultSet rs= cmd.executeQuery();
            if (rs.next()) {
                if(rs.getInt(1)==1){
                    resp=true;
                }
            }
            cmd.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resp;
    }
    
    public boolean consultarContraseña(){
        verificaciones obj= new verificaciones();
        boolean resp= false;
        try {
             String sql = "select CONVERT(varchar(max),Decryptbypassphrase('FCBarcelona321',(select contraseña from usuarioEmpleado where correoElectronico=?))) as contra  from usuarioEmpleado where correoElectronico =?";
          
            //Se pasan por referencia por seguridad
            //que es eso que devuelve ?, ese 8
            //eso devuelve el id del usuario al que pertenese esa contraseña y correo si algo no coincide devuleve 0
            //importar clase PreparedStatement
            PreparedStatement cmd = getCn().prepareStatement(sql);
            //Llenar los parametros de la clase, se coloca en el ordne de la tabla
            cmd.setString(1, getCorreo());
            cmd.setString(2, getCorreo());
            //Importar clase resultset
            ResultSet rs= cmd.executeQuery();
            //Recorrer la lista de registro
            if (rs.next()) {
                resp = true;
                System.out.println("Entra en el consult");
                 setContraseña(rs.getString(1));
            }
            cmd.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resp;
    }
    
    public String[] consultarEstado() {
        String[] resp2=new  String[4];
        resp2[0]="";
        resp2[1]="";
        resp2[2]="";
        resp2[3]="";
        try {
            String sql = "SELECT idEstado, nombreEstado, descripcion, ingreso FROM estadoEmpleado WHERE nombreEstado=?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1, getNombreE());
            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                //nombreEstado
                resp2[0] = rs.getString(2);
                //descripcion
                resp2[1] = rs.getString(3);
                //idEstado
                resp2[2] = rs.getString(1);
                
                resp2[3] = rs.getString(4);
            }
            cmd.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resp2;
    }
    PEmpleado nuevo= new PEmpleado("");
    public boolean guardarEstadoEmpleado(){
        boolean resp = false;
        String[] resp2=consultarEstado();
        if (resp2[0] .equals(getNombreE())) {
            JOptionPane.showMessageDialog(nuevo,"Error ya existe un estado con ese nombre");
        } else {
            try {

                String sql2 = "INSERT INTO estadoEmpleado(idEstado,nombreEstado,descripcion,ingreso) VALUES ((SELECT MAX(idEstado)+1 FROM estadoEmpleado),?,?,?)";
                PreparedStatement cmd2 = getCn().prepareStatement(sql2);
                cmd2.setString(1, getNombreE());
                cmd2.setString(2, getDescripcionE());
                cmd2.setInt(3,getIngreso());
                if (!cmd2.execute()) {
                    resp = true;
                } 
                cmd2.close();
                getCn().close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        return resp;
    }
    
    public boolean modificarEstadoEmpleado(){
        boolean resp= false;
            try {
                String sql = "UPDATE estadoEmpleado SET nombreEstado=?,descripcion=?,ingreso=? WHERE idEstado=?";
                PreparedStatement cmd = getCn().prepareStatement(sql);
                cmd.setString(1,getNombreE());
                cmd.setString(2, getDescripcionE());
                cmd.setInt(3,getIngreso());
                cmd.setInt(4, getCodigoE());

                if (!cmd.execute()) {
                    resp = true;
                }
                cmd.close();
                getCn().close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }    
        return resp;
    }
    
    public boolean eliminarEstadoEmpleado(){
        boolean resp=false;
        try {
            String sql ="DELETE FROM estadoEmpleado WHERE idEstado=?";
            
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setInt(1, getCodigoE());
            
            if (!cmd.execute()) {
                resp=true;
            }
            cmd.close();
            getCn().close();
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
            PreparedStatement cmd = getCn().prepareStatement(sql);
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
            JOptionPane.showMessageDialog(nuevo,"Error ya existe un documento con ese nombre");
        }
        else {
            try {

                String sql2 = "INSERT INTO documento(idDocumento,nombre,estado) VALUES ((SELECT MAX(idDocumento)+1 FROM documento),?,?)";
                PreparedStatement cmd2 = getCn().prepareStatement(sql2);
                cmd2.setString(1, getNombreD());
                cmd2.setString(2, getEstadoD());
                if (!cmd2.execute()) {
                    resp = true;
                } 
                cmd2.close();
                getCn().close();
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
            
                JOptionPane.showMessageDialog(nuevo, "Modifique algun dato para realizar esta accion");                   
        } else if(resp2[0].equals(getNombreD()) && !resp2[1].equals(getEstadoD())) {
            try {
                String sql = "UPDATE documento SET estado=? WHERE idDocumento=?";
                PreparedStatement cmd = getCn().prepareStatement(sql);
                cmd.setString(1, getEstadoD());
                cmd.setInt(2, getCodigoD());

                if (!cmd.execute()) {
                    resp = true;
                }
                cmd.close();
                getCn().close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }else{
            try {
                String sql = "UPDATE documento SET nombre=?,estado=? WHERE idDocumento=?";
                PreparedStatement cmd = getCn().prepareStatement(sql);
                cmd.setString(1,getNombreD());
                cmd.setString(2, getEstadoD());
                cmd.setInt(3, getCodigoD());

                if (!cmd.execute()) {
                    resp = true;
                }
                cmd.close();
                getCn().close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return resp;
    }
    
     public boolean consultasRandom(){
     boolean resp=false;
     try {
            String sql ="alter table proveedor add estado bit";
            
            PreparedStatement cmd = getCn().prepareStatement(sql);
            
            
            if (!cmd.execute()) {
                resp=true;
            }
            cmd.close();
            getCn().close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
     return resp;
     }
    
    public boolean eliminarDocumento(){
        boolean resp=false;
        try {
            String sql ="DELETE FROM documento WHERE idDocumento=?";
            
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setInt(1, getCodigoD());
            
            if (!cmd.execute()) {
                resp=true;
            }
            cmd.close();
            getCn().close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resp;
    }
    
    public boolean consultarEmpleado() {

       boolean razon=false;
        try {
            String sql = "SELECT * "
                    + " FROM usuarioEmpleado WHERE correoElectronico=?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setString(1,getCorreoEmpleado());
            ResultSet rs = cmd.executeQuery();
            
            if(rs.next()) {
                
                  razon=true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
       
        
        return razon;
    }
    
    public boolean guardarEmpleado(){
        boolean resp=false;
        
        try {
            if (consultarEmpleado()) {
            JOptionPane.showMessageDialog(nuevo,"Error ya existe un empleado con ese correo electronico");
            }
        } catch (Exception e) {
            System.out.println("e: "+e);
            try {
                String sql = "INSERT INTO usuarioEmpleado(idEmpleado, idTipo,"
                        + " nombres, apellidos, telefono, correoElectronico, contraseña, direccion, idEstado, imagen, pregunta1,respuesta1, pregunta2, respuesta2)"
                        + "VALUES ((SELECT MAX(idEmpleado)+1 FROM usuarioEmpleado),?,?,?,?,?, Encryptbypassphrase('FCBarcelona321','"+getContraseñaEmpleado()+"') ,?,?,?,?,?,?,?)";
                PreparedStatement cmd = getCn().prepareStatement(sql);
                cmd.setInt(1,getCodigoTipo());
                cmd.setString(2,getNombreEmpleado());
                cmd.setString(3,getApellidoEmpleado());
                cmd.setInt(4,getTelefono());
                cmd.setString(5,getCorreoEmpleado());
                //cmd.setString(6,getContraseñaEmpleado());
                cmd.setString(6,getDireccion());
                cmd.setInt(7,getCodigoEstado());
                cmd.setString(8,getImagen());
                cmd.setString(9,getPregunta1());
                cmd.setString(10,getRespuesta1());
                cmd.setString(11,getPregunta2());
                cmd.setString(12, getRespuesta2());               
                if (!cmd.execute()) {
                    resp=true;
                } 
                
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
        
        return resp;
    }
    
    public boolean modificarEmpleado(){
        //valores.false = no son iguales, true= 1 o mas son iguales
        boolean resp=false;       
            try {
                String sql ="UPDATE usuarioEmpleado SET idTipo=?, nombres=?, apellidos=?, telefono=?, correoElectronico=?, contraseña=Encryptbypassphrase('FCBarcelona321','"+getContraseñaEmpleado()+"'), direccion=?, idEstado=?, imagen=?, pregunta1=?, respuesta1=?, pregunta2=?, respuesta2=? WHERE idEmpleado=?";
                PreparedStatement cmd = getCn().prepareStatement(sql);
 
                cmd.setInt(1, getCodigoTipo());
                cmd.setString(2, getNombreEmpleado());
                cmd.setString(3, getApellidoEmpleado());
                cmd.setInt(4, getTelefono());
                cmd.setString(5, getCorreoEmpleado());
                System.out.println("contra: "+getContraseñaEmpleado());
                //cmd.setString(6, getContraseñaEmpleado());
                cmd.setString(6, getDireccion());
                cmd.setInt(7, getCodigoEstado());
                cmd.setString(8, getImagen());
                cmd.setString(9, getPregunta1());
                cmd.setString(10, getRespuesta1());
                cmd.setString(11, getPregunta2());
                cmd.setString(12, getRespuesta2());
                cmd.setInt(13, getCodigoEmpleado());
      
                if (!cmd.execute()) {
                resp=true;    
                }
                cmd.close();
                getCn().close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }       
        return resp;              
    }
    
    public boolean guardarDocumentoEmpleado(){
        boolean resp=false;
        try {
            String sql2 ="SELECT idDocumento FROM documentoEmpleado WHERE idEmpleado="+getCodigoDE();
            PreparedStatement cmd2 = getCn().prepareStatement(sql2);
            ResultSet ver2 = cmd2.executeQuery();
            if (ver2.next()) {
                if (ver2.getInt(1)==getCodigoDD()) {
                    JOptionPane.showMessageDialog(nuevo,"Error ya existe este tipo de documento registrado a este empleado");
                }else{
                    String sql = "INSERT INTO documentoEmpleado(idDocumentoE , idDocumento, idEmpleado, descripcion) "
                            + "VALUES((SELECT MAX(idDocumentoE) FROM documentoEmpleado )+1,?,?,?)";
                    PreparedStatement cmd = getCn().prepareStatement(sql);
                    System.out.println("1: " + getCodigoDD());
                    System.out.println("2: " + getCodigoDE());
                    System.out.println("3: " + getDescrip());
                    cmd.setInt(1, getCodigoDD());
                    cmd.setInt(2, getCodigoDE());
                    cmd.setString(3, getDescrip());

                    if (!cmd.execute()) {
                        resp = true;
                    }
                    cmd.close();

                }
            }else{   
                    String sql = "INSERT INTO documentoEmpleado(idDocumentoE , idDocumento, idEmpleado, descripcion) "
                            + "VALUES((SELECT MAX(idDocumentoE) FROM documentoEmpleado )+1,?,?,?)";
                    PreparedStatement cmd = getCn().prepareStatement(sql);
                    System.out.println("1: " + getCodigoDD());
                    System.out.println("2: " + getCodigoDE());
                    System.out.println("3: " + getDescrip());
                    cmd.setInt(1, getCodigoDD());
                    cmd.setInt(2, getCodigoDE());
                    cmd.setString(3, getDescrip());

                    if (!cmd.execute()) {
                        resp = true;
                    }
                    cmd.close();

                
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
            String sql="UPDATE documentoEmpleado SET descripcion=? WHERE idDocumentoE=?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            
            cmd.setString(1, getDescrip());
            cmd.setInt(2, getCodigoDEE());
           
            
            if (!cmd.execute()) {
                resp=true;
            }
            cmd.close();
            getCn().close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resp;
    }
    
    public boolean eliminarDocumentoEmpleado(){
        boolean resp=false;
        try {
            String sql="DELETE FROM documentoEmpleado WHERE idDocumentoE=?";
            PreparedStatement cmd = getCn().prepareStatement(sql);
            cmd.setInt(1, getCodigoDEE());
            if (!cmd.execute()) {
                resp=true;
            }
            cmd.close();
            getCn().close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resp;
    }
    
    public boolean guardarProveedor(){
        boolean resp=false;
        try {
                String sql = "INSERT INTO proveedor(idProveedor, nombreProveedor,"
                        + " direccion, telefono, fax, correoElectronico, idRubro, estado)"
                        + "VALUES ((SELECT MAX(idProveedor)+1 FROM proveedor),?,?,?,?,?,?, ?)";
                PreparedStatement cmd = getCn().prepareStatement(sql);
                cmd.setString(1,getNombreP());
                cmd.setString(2,getDireccionP());
                cmd.setInt(3,getTelefonoP());
                cmd.setInt(4,getFaxP());
                cmd.setString(5,getCorreoP());
                cmd.setInt(6,getCodigoRubro());
                cmd.setString(7,getEstadoP());
                
                if (!cmd.execute()) {
                    resp=true;
                } 
                cmd.close();
                getCn().close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        return resp;
    }
    public boolean modificarProveedor(){
        boolean resp=false;
        try {
                String sql = "UPDATE proveedor SET nombreProveedor=?,direccion=?,telefono=?, fax=?,correoElectronico=?, idRubro=?,  estado=? WHERE idProveedor=?";
                PreparedStatement cmd = getCn().prepareStatement(sql);
                cmd.setString(1,getNombreP());
                cmd.setString(2,getDireccionP());
                cmd.setInt(3,getTelefonoP());
                cmd.setInt(4,getFaxP());
                cmd.setString(5,getCorreoP());
                cmd.setInt(6,getCodigoRubro());
                cmd.setString(7,getEstadoP());
                cmd.setInt(8,getIdP());
                
                if (!cmd.execute()) {
                    resp=true;
                } 
                cmd.close();
                getCn().close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        return resp;
    }
    
    public boolean checkProveedor(){
        boolean resp=true;
        try {
                String sql = "select nombreProveedor FROM proveedor WHERE idProveedor=?";
                PreparedStatement cmd = getCn().prepareStatement(sql);
                
                cmd.setInt(1,getIdP());
                
                if (!cmd.execute()) {
                    resp=false;
                } 
                cmd.close();
             
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        return resp;
    }
    
    public boolean eliminarProveedor(){
        boolean ret=false;
        try {
            String sql = "DELETE FROM proveedor WHERE idProveedor=?";
                PreparedStatement cmd = getCn().prepareStatement(sql);
                
                cmd.setInt(1,getIdP());
                
                if (!cmd.execute()) {
                    ret=true;
                } 
                cmd.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ret;
    }
    
    public boolean guardarRubro(){
        boolean retorno=false;
        try {
            String sql ="INSERT INTO rubroProveedor(idRubro,nombreRubro,descripcion) VALUES "
                    + " ((SELECT MAX(idRubro) FROM rubroProveedor)+1, ?, ?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1,nombreRubro);
            cmd.setString(2,descripRubro);
            if (!cmd.execute()) {
                retorno=true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }
    
    public boolean modificarRubro(){
        boolean retorno=false;
        try {
            String sql ="UPDATE rubroProveedor SET nombreRubro=?, descripcion=? WHERE idRubro=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1,nombreRubro);
            cmd.setString(2,descripRubro);
            cmd.setInt(3,codigoRubro);
            if (!cmd.execute()) {
                retorno=true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }
    public boolean eliminarRubro(){
        boolean retorno=false;
        try {
            String sql ="DELETE FROM rubroProveedor WHERE idRubro=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setInt(1,codigoRubro);
            if (!cmd.execute()) {
                retorno=true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }
}
