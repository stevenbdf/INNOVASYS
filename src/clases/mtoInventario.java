/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static clases.mtoVentas.sumarFechasDias;
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
    
    public DefaultTableModel setFilasReportes(DefaultTableModel  model, int tipo, String fecha1, String fecha2, int stock, String group)
    {
        try{
        String sql="";
        switch(tipo){
//            case 1:
//                sql="SELECT idInventario, producto.nombreProducto , tipoTransaccion.nombre, fechaTransaccion, precioCompra, porcentajeGanacia, \n" +
//" stock, cantidad, impuestos, estado FROM inventario , tipoTransaccion, producto WHERE precioCompra=>"+stock+" AND producto.idProducto=inventario.idProductos ORDER BY precioCompra "+group;
//                break;
            case 1:
                System.out.println("Entra aqui case 1");
                sql="SELECT idInventario, producto.nombreProducto , tipoTransaccion.nombre, fechaTransaccion, precioCompra, porcentajeGanacia, " +
" stock, cantidad, impuestos, estado FROM inventario , tipoTransaccion, producto WHERE  tipoTransaccion.idTipoT=inventario.idTipoT AND producto.idProducto=inventario.idProductos AND precioCompra>="+stock+" AND fechaTransaccion BETWEEN '"+fecha1+"' and '"+fecha2+"' ORDER BY precioCompra "+group;
                break;
           
            default:
                sql="SELECT idInventario, producto.nombreProducto , tipoTransaccion.nombre, fechaTransaccion, precioCompra, porcentajeGanacia,  " +
                    " stock, cantidad, impuestos, estado FROM inventario , tipoTransaccion, producto WHERE tipoTransaccion.idTipoT=inventario.idTipoT AND producto.idProducto=inventario.idProductos ORDER BY precioCompra desc";
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
        String columna[] = {"CODIGO","NOMBRE PRODUCTO"," TRANSACCION", "FECHA TRANSACCION","PRECIO COMPRA", "% GANANCIA", "STOCK", "CANTIDAD", "% IMPUESTOS", "ESTADO   "};
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
                        + " stock, cantidad, impuestos, estado FROM inventario , tipoTransaccion, producto WHERE tipoTransaccion.idTipoT=inventario.idTipoT AND producto.idProducto=inventario.idProductos ORDER BY idInventario DESC";
              
        
        Object dato[] = new Object[10];
        
            PreparedStatement us = cn.prepareStatement(sql);
            ResultSet res = us.executeQuery();
            
            while(res.next()){
                for(int i =0;i<dato.length;i++)
                {
   
                    if (i == 3) {
                        dato[i] = sumarFechasDias(res.getDate(i + 1), 2);

                    } else {
                        dato[i] = res.getObject(i + 1);
                    }
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
    
    public boolean guardarInventario() {
        boolean retorno = false;
        try {
            String sql2 = "SELECT precioCompra FROM inventario"
                    + " WHERE idProductos=? ORDER BY idInventario DESC";
            PreparedStatement cmd2 = cn.prepareStatement(sql2);
            cmd2.setInt(1, codigoP);
            ResultSet ver2 = cmd2.executeQuery();
            if (ver2.next()) {
                double precioEntrada = precioCompra ;
                double precioExistente = ver2.getDouble(1) ;
                if (precioEntrada != precioExistente) {
                    double costoPromedio=(precioEntrada+precioExistente)/2;
                    System.out.println("costo p: "+costoPromedio);
                    System.out.println("precio e: "+precioEntrada);
                    System.out.println("precioExistente :"+precioExistente);
                    try {

                        String sql = "INSERT INTO inventario(idInventario, idProductos,"
                                + " idTipoT, fechaTransaccion, precioCompra, "
                                + "porcentajeGanacia , stock, cantidad, impuestos, "
                                + " estado ) VALUES((SELECT MAX(idInventario) FROM inventario)+1,?,?,?,?,?,?,?,?,?) ";
                        PreparedStatement cmd = cn.prepareStatement(sql);

                        cmd.setInt(1, codigoP);
                        cmd.setInt(2, codigoT);
                        cmd.setString(3, fecha);
                        cmd.setDouble(4, costoPromedio);
                        cmd.setDouble(5, porcentajeGanancia);
                        cmd.setInt(6, Stock);
                        cmd.setInt(7, cantidad);
                        cmd.setDouble(8, impuestos);
                        cmd.setString(9, estado);
                        if (!cmd.execute()) {
                            retorno = true;
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
                }else{
                    try {

                        String sql = "INSERT INTO inventario(idInventario, idProductos,"
                                + " idTipoT, fechaTransaccion, precioCompra, "
                                + "porcentajeGanacia , stock, cantidad, impuestos, "
                                + " estado ) VALUES((SELECT MAX(idInventario) FROM inventario)+1,?,?,?,?,?,?,?,?,?) ";
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
                }
            }
            else{
                try {

                        String sql = "INSERT INTO inventario(idInventario, idProductos,"
                                + " idTipoT, fechaTransaccion, precioCompra, "
                                + "porcentajeGanacia , stock, cantidad, impuestos, "
                                + " estado ) VALUES((SELECT MAX(idInventario) FROM inventario)+1,?,?,?,?,?,?,?,?,?) ";
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
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }
    
    public boolean modificarInventario(){
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
