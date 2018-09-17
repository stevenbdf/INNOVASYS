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
 * @author User
 */
public class mtoDatosEmpresa {

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * @return the telefono1
     */
    public Integer getTelefono1() {
        return telefono1;
    }

    /**
     * @param telefono1 the telefono1 to set
     */
    public void setTelefono1(Integer telefono1) {
        this.telefono1 = telefono1;
    }

    /**
     * @return the telefono2
     */
    public Integer getTelefono2() {
        return telefono2;
    }

    /**
     * @param telefono2 the telefono2 to set
     */
    public void setTelefono2(Integer telefono2) {
        this.telefono2 = telefono2;
    }

    /**
     * @return the fax1
     */
    public Integer getFax1() {
        return fax1;
    }

    /**
     * @param fax1 the fax1 to set
     */
    public void setFax1(Integer fax1) {
        this.fax1 = fax1;
    }

    /**
     * @return the fax2
     */
    public Integer getFax2() {
        return fax2;
    }

    /**
     * @param fax2 the fax2 to set
     */
    public void setFax2(Integer fax2) {
        this.fax2 = fax2;
    }

    /**
     * @return the correo1
     */
    public String getCorreo1() {
        return correo1;
    }

    /**
     * @param correo1 the correo1 to set
     */
    public void setCorreo1(String correo1) {
        this.correo1 = correo1;
    }

    /**
     * @return the correo2
     */
    public String getCorreo2() {
        return correo2;
    }

    /**
     * @param correo2 the correo2 to set
     */
    public void setCorreo2(String correo2) {
        this.correo2 = correo2;
    }

    /**
     * @return the propietario
     */
    public String getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    /**
     * @return the noFactura
     */
    public Integer getNoFactura() {
        return noFactura;
    }

    /**
     * @param noFactura the noFactura to set
     */
    public void setNoFactura(Integer noFactura) {
        this.noFactura = noFactura;
    }

    
    
    private Connection cn;
    
    public mtoDatosEmpresa(){
        Conexion con = new Conexion();
        cn= con.conectar();
    }
    private String nombre;
    private String domicilio;
    private String fecha;
    private String descripcion;
    private String logo;
    private Integer telefono1;
    private Integer telefono2;  
    private Integer fax1;  
    private Integer fax2;
    private String correo1;
    private String correo2;
    private String propietario;
    private Integer noFactura;
    
    public boolean consultarDatos(){
        boolean retorno=false;
        try {
            String sql="SELECT * FROM datosEmpresa";
            PreparedStatement cmd = cn.prepareStatement(sql);
            ResultSet ver = cmd.executeQuery();
            if (ver.next()) {
                nombre=ver.getString(2);
                domicilio=ver.getString(3);
                fecha=ver.getString(4);
                descripcion=ver.getString(5);
                logo= ver.getString(6);
                System.out.println("Logo: "+logo);
                telefono1=ver.getInt(7);
                telefono2=ver.getInt(8);
                fax1=ver.getInt(9);
                fax2=ver.getInt(10);
                correo1=ver.getString(11);
                correo2=ver.getString(12);
                propietario=ver.getString(13);
                noFactura=ver.getInt(14);
                retorno=true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return retorno;
    }
    
    public boolean modificarDatos(){
        boolean resp=false;
        try {
                String sql = "update datosEmpresa set nombreEmpresa= ?,domicilioLegal =?, fechaConstitucion=?,descripcion=?,logo=?,telefono=?,telefono2=?,fax=?,fax2=?,correoElectronico=?,correoElectronico2=?,propietario=?,noSerieFactura=?";
                PreparedStatement cmd = cn.prepareStatement(sql);
                cmd.setString(1,getNombre());
                cmd.setString(2,getDomicilio());
                cmd.setString(3,getFecha());
                cmd.setString(4,getDescripcion());
                cmd.setString(5,getLogo());
                cmd.setInt(6,getTelefono1());
                cmd.setInt(7,getTelefono2());
                cmd.setInt(8,getFax1());
                cmd.setInt(9,getFax2());
                cmd.setString(10,getCorreo1());
                cmd.setString(11,getCorreo2());
                cmd.setString(12,getPropietario());
                cmd.setInt(13,getNoFactura());
                
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
