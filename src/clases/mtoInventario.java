/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class mtoInventario {
    private Connection cn;
    public mtoInventario(){
        Conexion con = new Conexion();
        cn= con.conectar();
    }
    public DefaultTableModel setFilasCategorias(DefaultTableModel  model)
    {
        try{
       
        
                String sql="SELECT idInventario, idProductos, tipoTransaccion.nombre, fechaTransaccion, precioCompra, procentajeGanacia, "
                        + " stock, cantidad, impuestos, estado FROM inventario , tipoTransaccion WHERE tipoTransaccion.idTipoT=inventario.idTipoT";
              
        
        Object dato[] = new Object[10];
        
            PreparedStatement us = cn.prepareStatement(sql);
            ResultSet res = us.executeQuery();
            
            while(res.next()){
                for(int i =0;i<dato.length;i++)
                {
   
                        dato[i] = res.getObject(i+1);  
                }
        
                model.addRow(dato);
            }
           
        }
        catch(Exception ex){
                System.out.println(ex.toString());
        } 
        return model;
    }
    
    
    private Integer codigoI;
    private Integer codigoP;
    
}
