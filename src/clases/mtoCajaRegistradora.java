/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;

/**
 *
 * @author Steven
 */
public class mtoCajaRegistradora {

    

    

    public Integer getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(Integer codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
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
    
    private Connection cn ;
    String fechaP="";
    public mtoCajaRegistradora(){
        Conexion con = new Conexion();
        cn= con.conectar();
        
        
        Calendar hoy = Calendar.getInstance();
            int año = hoy.get(Calendar.YEAR);
            hoy.add(Calendar.MONTH,1);
            int mes = hoy.get(Calendar.MONTH);
            int dia = hoy.get(Calendar.DAY_OF_MONTH);
            fechaP=año+"-"+mes+"-"+dia;
    }
    
    private Integer codigoEmpleado;
    private Integer codigoCliente;
    private double montoTotal;
    
    
    public boolean guardarFactura(Object[][] detalle,int tamaño){
        boolean retorno=false;
        try {
            
            
            System.out.println("Fecha: "+fechaP);
            String sql ="INSERT INTO factura(noFactura,numRegistro, fecha, idEmpleado, idCliente, montoTotal)"
                    + " VALUES ( (SELECT MAX(noFactura) FROM factura)+1, 1,'"+fechaP+"', ?,?,?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1, codigoEmpleado);
            cmd.setInt(2,codigoCliente);
            System.out.println("Monto Total: "+montoTotal);
            cmd.setDouble(3,montoTotal);
            if (!cmd.execute()) {
                if (guardarDetalleFactura(detalle,tamaño)) {
                    retorno=true;
                }
            }
        } catch (Exception e) {
            System.out.println("mtoCajaRegistradora: "+e);
        }
        return retorno;
    }
    
    private boolean guardarDetalleFactura(Object[][] detalle2, int tamaño2){
        boolean retorno=false;
        try {
            System.out.println("length detalle: "+detalle2.length);
            for (int i = 0; i < tamaño2; i++) {
                String sql = "INSERT INTO detalleFactura(idDetalle,noFactura,idProducto,cantidadProducto) "
                        + " VALUES ((SELECT MAX (idDetalle) FROM detalleFactura)+1, (SELECT MAX(noFactura) FROM factura ), ?,?)";
                PreparedStatement cmd = cn.prepareStatement(sql);
                cmd.setObject(1, detalle2[0][i]);
                cmd.setObject(2,detalle2[1][i]);
                if (!cmd.execute()) {
                    try {
                        String sql2="INSERT INTO inventario(idInventario, idProductos, idTipoT, fechaTransaccion, "
                                + " precioCompra, porcentajeGanacia, stock, cantidad, impuestos, estado) "
                                + " VALUES ( (SELECT MAX (idInventario) FROM inventario )+1, "+detalle2[0][i]+", 2, '"+fechaP+"' , "
                                + " (SELECT TOP 1 precioCompra FROM inventario WHERE idProductos="+detalle2[0][i]+" ORDER BY idInventario DESC ), "
                                + " (SELECT TOP 1 porcentajeGanacia FROM inventario WHERE idProductos="+detalle2[0][i]+" ORDER BY idInventario DESC) , "
                                + " (SELECT TOP 1 stock FROM inventario WHERE idProductos="+detalle2[0][i]+" ORDER BY idInventario DESC )-"+detalle2[1][i] +","+detalle2[1][i]+", "
                                + " (SELECT TOP 1 impuestos FROM inventario WHERE idProductos="+detalle2[0][i]+" ORDER BY idInventario DESC ), 'Entregado')";
                        PreparedStatement cmd2 = cn.prepareStatement(sql2);
                        if (!cmd2.execute()) {
                            retorno=true;
                        }
                    } catch (Exception e) {
                        System.out.println("inventario: "+e);
                    }    
                }
            }
        } catch (Exception e) {
            System.out.println("guardarDetalle: "+e);
        }
        return retorno;
    }
}
