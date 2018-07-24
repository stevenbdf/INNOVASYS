/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class mtoInventario {

    /**
     * @return the codigoI
     */
    public Integer getCodigoI() {
        return codigoI;
    }

    /**
     * @param codigoI the codigoI to set
     */
    public void setCodigoI(Integer codigoI) {
        this.codigoI = codigoI;
    }

    /**
     * @return the codigoP
     */
    public Integer getCodigoP() {
        return codigoP;
    }

    /**
     * @param codigoP the codigoP to set
     */
    public void setCodigoP(Integer codigoP) {
        this.codigoP = codigoP;
    }

    /**
     * @return the codigoT
     */
    public Integer getCodigoT() {
        return codigoT;
    }

    /**
     * @param codigoT the codigoT to set
     */
    public void setCodigoT(Integer codigoT) {
        this.codigoT = codigoT;
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
     * @return the precioCompra
     */
    public double getPrecioCompra() {
        return precioCompra;
    }

    /**
     * @param precioCompra the precioCompra to set
     */
    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    /**
     * @return the porcentajeGanancia
     */
    public double getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    /**
     * @param porcentajeGanancia the porcentajeGanancia to set
     */
    public void setPorcentajeGanancia(double porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }

    /**
     * @return the Stock
     */
    public Integer getStock() {
        return Stock;
    }

    /**
     * @param Stock the Stock to set
     */
    public void setStock(Integer Stock) {
        this.Stock = Stock;
    }

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the impuestos
     */
    public double getImpuestos() {
        return impuestos;
    }

    /**
     * @param impuestos the impuestos to set
     */
    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    private Connection cn;
    public mtoInventario(){
        Conexion con = new Conexion();
        cn= con.conectar();
    }
    
    public DefaultTableModel setFilasReportes(DefaultTableModel  model, int tipo, String valores)
    {
        try{
        String sql="";
        switch(tipo){
            case 1:
                sql="";
                break;
            case 2:
                sql="";
                break;
            default:
                sql="";
                break;
        }
        Object dato[] = new Object[10];
        
            PreparedStatement us = cn.prepareStatement(sql);
            ResultSet res = us.executeQuery();
            
            while(res.next()){
                for(int i =0;i<9;i++)
                {
   
                        dato[i] = res.getObject(i+1);  
                }
        
                        if (res.getInt(10)==0) {
                            Object valor = (String) "NO";
                            dato[3] = valor;
                        }else{
                            Object valor = (String) "SI";
                            dato[3] = valor;
                        }

                model.addRow(dato);
            }
           
        }
        catch(Exception ex){
                System.out.println(ex.toString());
        } 
        return model;
    }
    
    public String[] getColumnasCategoria()
    {
        String columna[] = {"CODIGO","CODIGO PRODUCTO","TIPO TRANSACCION", "FECHA TRANSACCION","PRECIO COMPRA", "% GANANCIA", "STOCK", "CANTIDAD", "IMPUESTOS", "ESTADO"};
        return columna;
    }
    
    public DefaultComboBoxModel llenarComboCategoria(DefaultComboBoxModel modelo) {
        modelo.removeAllElements();
        try {

            /* Realizamos la consulta a la base de datos*/
            String sql = "SELECT nombreProducto FROM producto";
            PreparedStatement verDatos = cn.prepareStatement(sql);
            ResultSet ver = verDatos.executeQuery();
            while (ver.next()) {

                modelo.addElement(ver.getObject("nombreProducto"));
            }
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);

        }
        return modelo;
    }
    
    public DefaultTableModel setFilasInventario(DefaultTableModel  model)
    {
        try{
       
        
                String sql="SELECT idInventario, producto.nombreProducto , tipoTransaccion.nombre, fechaTransaccion, precioCompra, porcentajeGanacia, "
                        + " stock, cantidad, impuestos, estado FROM inventario , tipoTransaccion, producto WHERE tipoTransaccion.idTipoT=inventario.idTipoT AND producto.idProducto=inventario.idProductos ORDER BY fechaTransaccion desc";
              
        
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
    private Integer codigoT;
    private String fecha;
    private double precioCompra;
    private double porcentajeGanancia;
    private Integer Stock;
    private Integer cantidad;
    private double impuestos;
    private String estado;
    
    public boolean guardarInventario(){
        boolean retorno=false;
        try {
            
            
            
            
            String sql ="INSERT INTO inventario(idInventario, idProductos,"
                    + " idTipoT, fechaTransaccion, precioCompra, "
                    + "porcentajeGanacia , stock, cantidad, impuestos, "
                    + " estado ) VALUES((SELECT MAX(idInventario) FROM inventario),?,?,?,?,?,?,?,?,?) ";
           PreparedStatement cmd = cn.prepareStatement(sql);
           
           
           
           cmd.setInt(1,codigoP);
           cmd.setInt(2,codigoT);
           cmd.setString(3,fecha);
           cmd.setDouble(4,precioCompra);
           cmd.setDouble(5,porcentajeGanancia);
           cmd.setInt(6,Stock);
           cmd.setInt(7,cantidad);
           cmd.setDouble(8,impuestos);
           cmd.setString(9,estado);
            if (!cmd.execute()) {
                 retorno=true;
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
            try {
                String sql = "INSERT INTO inventario(idInventario, idProductos,"
                        + " idTipoT, fechaTransaccion, precioCompra, "
                        + "porcentajeGanacia , stock, cantidad, impuestos, "
                        + " estado ) VALUES(1,?,?,?,?,?,?,?,?,?) ";
                PreparedStatement cmd = cn.prepareStatement(sql);

                
                cmd.setInt(1, codigoP);
                cmd.setInt(2, codigoT);
                cmd.setString(3, fecha);
                cmd.setDouble(4, precioCompra);
                cmd.setDouble(5, porcentajeGanancia);
                cmd.setInt(6, Stock);
                cmd.setInt(7, cantidad);
                cmd.setDouble(8, impuestos);
                cmd.setString(9, estado);
                if (!cmd.execute()) {
                    retorno = true;
                }
            } catch (Exception ex) {
                System.out.println(ex.toString()); 
            }
        }
        return retorno;
    }
    
    public boolean modificarInventario(){
        System.out.println("Entra");
        boolean retorno=false;
        try {
             
            String sql="UPDATE inventario SET idProductos=?, idTipoT=?, fechaTransaccion=?,"
                    + " precioCompra=?, porcentajeGanacia=?, stock=?, cantidad=?, impuestos=?, estado=? "
                    + " WHERE idInventario=?";
           PreparedStatement cmd = cn.prepareStatement(sql);     
           
           cmd.setInt(1,codigoP);
           cmd.setInt(2,codigoT);
           cmd.setString(3,fecha);
           cmd.setDouble(4,precioCompra);
           cmd.setDouble(5,porcentajeGanancia);
           cmd.setInt(6,Stock);
           cmd.setInt(7,cantidad);
           cmd.setDouble(8,impuestos);
           cmd.setString(9,estado);
           cmd.setInt(10,codigoI);
            if (!cmd.execute()) {
                 retorno=true;
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return retorno;
    }
    
    public boolean eliminarInventario(){
        boolean retorno=false;
        try {
            String sql ="DELETE FROM inventario WHERE idInventario=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1,codigoI);
            if (!cmd.execute()) {
                retorno=true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return retorno;
    }
    
}
