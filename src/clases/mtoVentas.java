/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Susy francelia
 */
public class mtoVentas {
    Conexion cn = new Conexion();
    String sql;
    
    public static java.sql.Date sumarFechasDias(java.sql.Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new java.sql.Date(cal.getTimeInMillis());
    }
    
    public DefaultTableModel Tabla(DefaultTableModel  model,int num)
    {
        switch(num)
        {
            case 0:
                sql="select noFactura, factura.fecha, usuarioEmpleado.nombres,cliente.nombre,montoTotal from factura, cliente,usuarioEmpleado where factura.idCliente = cliente.idCliente AND factura.idEmpleado = usuarioEmpleado.idEmpleado";
            break;
            case 1:
                sql="select noCreditoFiscal, creditoFiscal.fecha, usuarioEmpleado.nombres,cliente.nombre,monto_total from creditoFiscal, cliente,usuarioEmpleado where creditoFiscal.idCliente = cliente.idCliente AND creditoFiscal.idEmpleado = usuarioEmpleado.idEmpleado";
            break;
        }
        Object dato[] = new Object[5];
        try{
            PreparedStatement us = cn.conectar().prepareStatement(sql);
            ResultSet res = us.executeQuery();
            
            while(res.next()){
                for(int i =0;i<5;i++)
                {
                    
                    if (i==1) {
                        dato[i]= sumarFechasDias(res.getDate(i+1),2);
                        
                    }else{
                        dato[i] =res.getObject(i+1);
                    
                    }
                    
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
    public DefaultTableModel buscar(DefaultTableModel  model, String palabra,int num,int n)
    {   
        if(n==0)
        {
            switch(num)
            {
                case 0:
                    sql="select noFactura, factura.fecha, usuarioEmpleado.nombres,cliente.nombre,montoTotal from factura, cliente,usuarioEmpleado where factura.idCliente = cliente.idCliente AND factura.idEmpleado = usuarioEmpleado.idEmpleado and noFactura Like '"+palabra+"%'";
                break;
                case 1:
                    sql="select noFactura, factura.fecha, usuarioEmpleado.nombres,cliente.nombre,montoTotal from factura, cliente,usuarioEmpleado where factura.idCliente = cliente.idCliente AND factura.idEmpleado = usuarioEmpleado.idEmpleado and usuarioEmpleado.nombres Like '"+palabra+"%'";
                break;
                case 2:
                    sql="select noFactura, factura.fecha, usuarioEmpleado.nombres,cliente.nombre,montoTotal from factura, cliente,usuarioEmpleado where factura.idCliente = cliente.idCliente AND factura.idEmpleado = usuarioEmpleado.idEmpleado and montoTotal >= "+palabra;
                break;
            }
        }
        else if(n==1)
        {
            switch(num)
            {
                case 0:
                    sql="select noCreditoFiscal, creditoFiscal.fecha, usuarioEmpleado.nombres,cliente.nombre,monto_total from creditoFiscal, cliente,usuarioEmpleado where creditoFiscal.idCliente = cliente.idCliente AND creditoFiscal.idEmpleado = usuarioEmpleado.idEmpleado and noCreditoFiscal Like '"+palabra+"%'";
                break;
                case 1:
                    sql="select noCreditoFiscal, creditoFiscal.fecha, usuarioEmpleado.nombres,cliente.nombre,monto_total from creditoFiscal, cliente,usuarioEmpleado where creditoFiscal.idCliente = cliente.idCliente AND creditoFiscal.idEmpleado = usuarioEmpleado.idEmpleado and usuarioEmpleado.nombres Like '"+palabra+"%'";
                break;
                
            }
        }
        Object dato[] = new Object[5];
        try{
            PreparedStatement us = cn.conectar().prepareStatement(sql);
            ResultSet res = us.executeQuery();
            
            while(res.next()){
                for(int i =0;i<5;i++)
                {
                    if (i==1) {
                        dato[i]= sumarFechasDias(res.getDate(i+1),2);
                        
                    }else{
                       dato[i] =res.getObject(i+1); 
                    }
                    
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
    public DefaultTableModel buscarFecha(DefaultTableModel  model, String fecha1,String fecha2,int num)
    {
        switch(num)
        {
            case 0:
                System.out.println("fecha1: "+fecha1);
                System.out.println("fecha2: "+fecha2);
                sql="select noFactura, factura.fecha, usuarioEmpleado.nombres,cliente.nombre,montoTotal from factura, cliente,usuarioEmpleado where factura.idCliente = cliente.idCliente AND factura.idEmpleado = usuarioEmpleado.idEmpleado AND factura.fecha BETWEEN '"+fecha1+"' AND '"+fecha2+"'";
            break;
            case 1:
                sql="select noCreditoFiscal, creditoFiscal.fecha, usuarioEmpleado.nombres,cliente.nombre,monto_total from creditoFiscal, cliente,usuarioEmpleado where creditoFiscal.idCliente = cliente.idCliente AND creditoFiscal.idEmpleado = usuarioEmpleado.idEmpleado AND creditoFiscal.fecha <= '"+fecha2+"'";
            break;
        }
        Object dato[] = new Object[5];
        try{
            PreparedStatement us = cn.conectar().prepareStatement(sql);
            ResultSet res = us.executeQuery();
            
            while(res.next()){
                for(int i =0;i<5;i++)
                {
                    
                    if (i==1) {
                        dato[i]= sumarFechasDias(res.getDate(i+1),2);
                        
                    }else{
                       dato[i] =res.getObject(i+1); 
                    }
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
    public DefaultTableModel buscarMonto(DefaultTableModel  model, String palabra,int num)
    {   
        switch(num)
            {
                case 0:
                    sql="select noFactura, factura.fecha, usuarioEmpleado.nombres,cliente.nombre,montoTotal from factura, cliente,usuarioEmpleado where factura.idCliente = cliente.idCliente AND factura.idEmpleado = usuarioEmpleado.idEmpleado and montoTotal >= "+palabra;
                break;
                case 1:
                    sql="select noCreditoFiscal, creditoFiscal.fecha, usuarioEmpleado.nombres,cliente.nombre,monto_total from creditoFiscal, cliente,usuarioEmpleado where creditoFiscal.idCliente = cliente.idCliente AND creditoFiscal.idEmpleado = usuarioEmpleado.idEmpleado and monto_total >= "+palabra;
                break;
            }
        Object dato[] = new Object[5];
        try{
            PreparedStatement us = cn.conectar().prepareStatement(sql);
            
            ResultSet res = us.executeQuery();
            
            while(res.next()){
                for(int i =0;i<5;i++)
                {
                    if (i==1) {
                        dato[i]= sumarFechasDias(res.getDate(i+1),2);
                        
                    }else{
                       dato[i] =res.getObject(i+1); 
                    }
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
