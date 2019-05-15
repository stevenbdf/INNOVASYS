/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import formularios.PTipoUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Steven
 */
public class mtoTipoUsuarios {

    /**
     * @return the NombreT
     */
    public String getNombreT() {
        return NombreT;
    }

    /**
     * @param NombreT the NombreT to set
     */
    public void setNombreT(String NombreT) {
        this.NombreT = NombreT;
    }

    /**
     * @return the CodigoT
     */
    public Integer getCodigoT() {
        return CodigoT;
    }

    /**
     * @param CodigoT the CodigoT to set
     */
    public void setCodigoT(Integer CodigoT) {
        this.CodigoT = CodigoT;
    }

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
    //Atributos para privilegios
    private Integer CodigoP;
    //Atributos para TipoUsuario
    private Integer CodigoT;
    private String NombreT;
    
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
            //JOptionPane.showMessageDialog(this,"Error tiene que seleccionar al menos un privilegio");
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
    
    public String[] consultarTipo(){
        String[] resp2=new  String[3];
        resp2[0]="";
        resp2[1]="";
        resp2[2]="";
        try {
            String sql="SELECT idTipo, nombreTipo, idPrivilegio FROM tipoUsuario WHERE nombreTipo=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1,getNombreT());
            ResultSet rs = cmd.executeQuery();    
            if (rs.next()) {
                //nombreTipo
                resp2[0] = rs.getString(2);
                //idPrivilegio
                resp2[1] = rs.getString(3);
                //idTipo
                resp2[2] = rs.getString(1);
            }
            cmd.close(); 
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resp2;
    }
    
    public boolean guardarTipo() {
        boolean resp = false;
        String[] resp2=consultarTipo();
        if (resp2[0].equals(getNombreT())) {
            
        } else {
            try {
                String sql = "INSERT INTO tipoUsuario(idTipo, nombreTipo, idPrivilegio) VALUES ((SELECT MAX(idTipo)+1 FROM tipoUsuario), ?,?)";
                PreparedStatement cmd = cn.prepareStatement(sql);
                cmd.setString(1, getNombreT());
                cmd.setInt(2, getCodigoP());
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
    
    public boolean modificarTipo() {
        boolean resp = false;
        String[] resp2=consultarTipo();
        if (resp2[0].equals(getNombreT()) && Integer.valueOf(resp2[1])==getCodigoP() ) {
            
        } else {
            try {

                String sql = "UPDATE tipoUsuario SET nombreTipo=?,idPrivilegio=? WHERE idTipo=?";
                PreparedStatement cmd = cn.prepareStatement(sql);
                cmd.setString(1, getNombreT());
                cmd.setInt(2, getCodigoP());
                cmd.setInt(3, getCodigoT());

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
    
    public boolean eliminarTipo(){
        boolean respuesta=false;
        try {
            String sql="DELETE FROM tipoUsuario WHERE idTipo=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1,getCodigoT());     
            if (!cmd.execute()) {
                respuesta=true;
            }
        } catch (Exception e) {    
            System.out.println(e.toString());
        }
        return respuesta;
    }
    
    
}
