/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Susy francelia
 */
public class mtoBitacora {
    Conexion cn = new Conexion();
    String sql;
    
    public DefaultTableModel Tabla(DefaultTableModel  model)
    {
        
        sql="select idBitacora,fechaEntrada,nombres,apellidos from bitacoraEmpleado, usuarioEmpleado where bitacoraEmpleado.idEmpleado = usuarioEmpleado.idEmpleado";
        Object dato[] = new Object[4];
        try{
            PreparedStatement us = cn.conectar().prepareStatement(sql);
            ResultSet res = us.executeQuery();
            
            while(res.next()){
                for(int i =0;i<4;i++)
                {
                    dato[i] =res.getObject(i+1);
                }
                model.addRow(dato);
            }
            res.close();
        }
        catch(Exception ex){
                System.out.println("Error tabla:"+ex.getMessage());
        } 
        return model;
    }
    public DefaultTableModel buscar(DefaultTableModel  model, String palabra)
    {
        sql="select idBitacora,fechaEntrada,nombres,apellidos from bitacoraEmpleado, usuarioEmpleado where bitacoraEmpleado.idEmpleado = usuarioEmpleado.idEmpleado and usuarioEmpleado.nombres Like '"+palabra+"%'";
        Object dato[] = new Object[4];
        try{
            PreparedStatement us = cn.conectar().prepareStatement(sql);
            ResultSet res = us.executeQuery();
            
            while(res.next()){
                for(int i =0;i<4;i++)
                {
                    dato[i] =res.getObject(i+1);
                }
                model.addRow(dato);
            }
            res.close();
        }
        catch(Exception ex){
                System.out.println("Error tabla:"+ex.getMessage());
        } 
        return model;
    }
    public DefaultTableModel buscarFecha(DefaultTableModel  model, String fecha1,String fecha2)
    {
        sql="select idBitacora,fechaEntrada,nombres,apellidos from bitacoraEmpleado, usuarioEmpleado where bitacoraEmpleado.idEmpleado = usuarioEmpleado.idEmpleado AND fechaEntrada >= '"+fecha1+"' AND fechaEntrada <= '"+fecha2+"'";
        Object dato[] = new Object[4];
        try{
            PreparedStatement us = cn.conectar().prepareStatement(sql);
            ResultSet res = us.executeQuery();
            
            while(res.next()){
                for(int i =0;i<4;i++)
                {
                    dato[i] =res.getObject(i+1);
                }
                model.addRow(dato);
            }
            res.close();
        }
        catch(Exception ex){
                System.out.println("Error tabla:"+ex.getMessage());
        } 
        return model;
    }
}
