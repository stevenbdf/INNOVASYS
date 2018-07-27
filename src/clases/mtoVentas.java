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
public class mtoVentas {
    Conexion cn = new Conexion();
    String sql;
    
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
    public DefaultTableModel buscarFecha(DefaultTableModel  model, String fecha1,String fecha2,int num)
    {
        switch(num)
        {
            case 0:
                sql="select noFactura, factura.fecha, usuarioEmpleado.nombres,cliente.nombre,montoTotal from factura, cliente,usuarioEmpleado where factura.idCliente = cliente.idCliente AND factura.idEmpleado = usuarioEmpleado.idEmpleado AND factura.fecha <= '"+fecha2+"'";
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
