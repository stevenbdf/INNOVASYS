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
public class mtoClientes {
    Conexion cn = new Conexion();
    public DefaultTableModel setfilas(DefaultTableModel  model)
    {
        
        String sql="Select * from cliente";
        Object dato[] = new Object[8];
        try{
            PreparedStatement us = cn.conectar().prepareStatement(sql);
            ResultSet res = us.executeQuery();
            
            while(res.next()){
                for(int i =0;i<11;i++)
                {
                    if(i>6)
                    {
                        
                    }
                    else
                    {
                        dato[i] =res.getObject(i+1);
                    }
                    
                }
                dato[7] =res.getObject(11);
                model.addRow(dato);
            }
            res.close();
        }
        catch(Exception ex){
                System.out.println("Error tabla:"+ex.getMessage());
        } 
        return model;
    }
    public DefaultTableModel buscar(DefaultTableModel  model, String palabra,int codigo)
    {
        String sql1="";
        switch(codigo)
        {
            case 1:
                sql1="Select * from cliente where nombre Like '"+palabra+"%'";
            break;
            case 2:
                sql1="Select * from cliente where idCliente Like '"+palabra+"%'";
            break;
        }
        Object dato[] = new Object[8];
        try{
            PreparedStatement us = cn.conectar().prepareStatement(sql1);
            ResultSet res = us.executeQuery();
            
            while(res.next()){
                for(int i =0;i<8;i++)
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
