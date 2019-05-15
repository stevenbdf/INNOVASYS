/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

/**
 *
 * @author Steven
 */
public class mtoPresupuesto {

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public Integer getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Integer codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    private Connection cn;
    public mtoPresupuesto(){
        Conexion con = new Conexion();
        cn = con.conectar();
    }
    
    public String[] consultarProducto(String valores){
        String[] retorno= new String[4];
        retorno[0]="";
        retorno[1]="";
        retorno[2]="";
        retorno[3]="";
        try {
            
            System.out.println("Valores: "+valores);
                  String sql = "SELECT precioCompra, porcentajeGanacia, impuestos, stock  "
                    + " FROM inventario  "
                    + " WHERE idProductos = "+valores+" AND fechaTransaccion=(SELECT MAX(fechaTransaccion) FROM inventario WHERE idProductos="+valores+" ) ORDER BY idInventario DESC ";
               
            PreparedStatement cmd = cn.prepareStatement(sql);
            ResultSet ver = cmd.executeQuery();
            if (ver.next()) {
                    //0 precioCompra
                    retorno[0]=ver.getString(1);
                    //1 porcentaje Ganancia
                    retorno[1]=ver.getString(2);
                    //2 impuestos
                    retorno[2]=ver.getString(3);
                    //3 stock
                    retorno[3]=ver.getString(4);
            }else{
                System.out.println("No hay nada");
            }
            
        } catch (Exception e) {
            System.out.println("EN MTO");
            System.out.println(e.toString());
        }
        return retorno;
    }
    
    private Integer codigoEstado;
    private Integer codigoCliente;
    private String correoCliente;
    private double montoTotal;
    
    
    public int obtenerCliente(String cmbo){
        
     
        int rt=0;
        try {
            String sql ="SELECT cliente.idCliente FROM cliente WHERE correoElectronico='"+cmbo+"'";
            PreparedStatement cmd = cn.prepareStatement(sql);
            ResultSet ver = cmd.executeQuery();
            if (ver.next()) {
                rt=ver.getInt(1);
                System.out.println("RETURN: "+rt);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return rt;
    }
    
    public boolean guardarPedido(){
        Calendar hoy = Calendar.getInstance();
        int año = hoy.get(Calendar.YEAR);
        hoy.add(Calendar.MONTH,1);
        int mes1 = hoy.get(Calendar.MONTH);
        int mes2 =hoy.get(Calendar.MONTH)+1;
        int dia = hoy.get(Calendar.DAY_OF_MONTH);
        String fecha1=año+"-"+mes1+"-"+dia;
        String fecha2=año+"-"+mes2+"-"+dia;
        
        boolean retorno=false;
        try {
            String sql ="INSERT INTO pedido(idPedido, fecha, fecha_vencimiento, idEstadoP, idCliente, monto_total) "
                    + " VALUES((SELECT MAX(idPedido) FROM pedido)+1,?,?,?,?,?)";
            
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1,fecha1);
            cmd.setString(2,fecha2);
            cmd.setInt(3,codigoEstado);
            cmd.setInt(4,obtenerCliente(correoCliente));
            cmd.setDouble(5,montoTotal);
            if (!cmd.execute()) {
                retorno=true;
            }
        } catch (Exception e) {
            System.out.println("AQUI1: mtoGuardar"+e);
            try{
                System.out.println(e.toString());
                String sql = "INSERT INTO pedido(idPedido, fecha, fecha_vencimiento, idEstadoP, idCliente, montoTotal) "
                        + " VALUES(1,?,?,?,?,?)";

                PreparedStatement cmd = cn.prepareStatement(sql);
                cmd.setString(1, fecha1);
                cmd.setString(2, fecha2);
                cmd.setInt(3, codigoEstado);
                cmd.setInt(4, codigoCliente);
                cmd.setDouble(5, montoTotal);
                if (!cmd.execute()) {
                    retorno = true;
                }
            }catch (Exception ex){  
                System.out.println("AQUI2: mtoGuardar"+ex);
            }
            
        }
        return retorno;
    }
}
