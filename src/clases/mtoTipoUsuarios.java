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
                }
            }
            cmd.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return valores;
    }
}
