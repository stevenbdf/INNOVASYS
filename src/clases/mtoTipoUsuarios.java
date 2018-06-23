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
 * @author Steven
 */
public class mtoTipoUsuarios {

    /**
     * @return the CodigoP
     */
    public Integer getCodigoP() {
        return CodigoP;
    }

    /**
     * @param CodigoP the CodigoP to set
     */
    public void setCodigoP(Integer CodigoP) {
        this.CodigoP = CodigoP;
    }
    private Connection cn;
    private Integer CodigoP;
    public mtoTipoUsuarios(){
        Conexion con = new Conexion();
        cn= con.conectar();
    }
    
    public Boolean[] consultarPrivilegio() {
        Boolean[] valores = new Boolean[16];
        for (int i = 0; i <valores.length; i++) {
            valores[i] =false;
        }
        try {
            String sql = "SELECT verInventario, construirEquipo, verProductos, solicitarAyuda, verOrdenesCola, verCajaVirtual, verVentasUuario, chatCenter, cambiarDatosEmpresa, gestionarVentas, gestionarBitacoras, gestionarClientes,gestionarProveedores, gestionarEmpleados, gestionarProductos, gestionarInventario FROM privilegio WHERE idPrivilegio=?";   
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1,getCodigoP());
            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                for (int i = 0; i < valores.length; i++) {
                    if (rs.getByte(i+1)==1) {
                       valores[i] =  true;
                    }
                    else{
                        valores[i]= false;
                    }
                }
            }
            cmd.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return valores;
    }
    
    public boolean guardarPrivilegio(Integer[] datos){
        boolean resp=false;
        try {
            String sql="INSERT INTO privilegio(idPrivilegio, verInventario, construirEquipo, verProductos, solicitarAyuda, verOrdenesCola, verCajaVirtual, verVentasUuario, chatCenter, cambiarDatosEmpresa, gestionarVentas, gestionarBitacoras, gestionarClientes,gestionarProveedores, gestionarEmpleados, gestionarProductos, gestionarInventario) "
                    + "VALUES ((SELECT MAX(idPrivilegio)+1 FROM privilegio),?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            for (int i = 0; i < datos.length; i++) {
                cmd.setInt(i+1,datos[i]);
            }
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
    
    public boolean modificarPrivilegio(Integer[] datos, Integer codigo){
        boolean resp=false;
        try {
            String sql="UPDATE privilegio SET verInventario=?, construirEquipo=?, verProductos=?, solicitarAyuda=?, verOrdenesCola=?, verCajaVirtual=?, verVentasUuario=?, chatCenter=?, cambiarDatosEmpresa=?, gestionarVentas=?, gestionarBitacoras=?, gestionarClientes=?,gestionarProveedores=?, gestionarEmpleados=?, gestionarProductos=?, gestionarInventario=? WHERE idPrivilegio=?";
                  
                    
            PreparedStatement cmd = cn.prepareStatement(sql);
            for (int i = 0; i < 16; i++) {          
                    cmd.setInt(i+1,datos[i]);
            }
            cmd.setInt(17,codigo);
            
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
    
    public boolean eliminarPrivilegio(){
        boolean resp=false;
        try {
            String sql="DELETE FROM privilegio WHERE idPrivilegio=?";           
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1,getCodigoP());
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
