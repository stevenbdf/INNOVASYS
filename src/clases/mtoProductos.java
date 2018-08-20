/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Steven
 */
public class mtoProductos {

    /**
     * @return the puntajeBenck
     */
    public Integer getPuntajeBenck() {
        return puntajeBenck;
    }

    /**
     * @param puntajeBenck the puntajeBenck to set
     */
    public void setPuntajeBenck(Integer puntajeBenck) {
        this.puntajeBenck = puntajeBenck;
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
     * @return the nombreP
     */
    public String getNombreP() {
        return nombreP;
    }

    /**
     * @param nombreP the nombreP to set
     */
    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    /**
     * @return the descripP
     */
    public String getDescripP() {
        return descripP;
    }

    /**
     * @param descripP the descripP to set
     */
    public void setDescripP(String descripP) {
        this.descripP = descripP;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the codigoProveedor
     */
    public Integer getCodigoProveedor() {
        return codigoProveedor;
    }

    /**
     * @param codigoProveedor the codigoProveedor to set
     */
    public void setCodigoProveedor(Integer codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    /**
     * @return the codigoCategoria
     */
    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    /**
     * @param codigoCategoria the codigoCategoria to set
     */
    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Integer getCodigoC() {
        return codigoC;
    }

    public void setCodigoC(Integer codigoC) {
        this.codigoC = codigoC;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public Integer getV3D() {
        return V3D;
    }

    public void setV3D(Integer V3D) {
        this.V3D = V3D;
    }

    public String getDescripC() {
        return descripC;
    }

    public void setDescripC(String descripC) {
        this.descripC = descripC;
    }
    private Connection cn;
    public mtoProductos(){
        Conexion con = new Conexion();
        cn= con.conectar();
    }
    //Atributos para Categoria
    private Integer codigoC;
    private String nombreC;
    private Integer V3D;
    private String descripC;
    
    //Atributos para Producto
    private Integer codigoP;
    private String nombreP;
    private String descripP;
    private String imagen;
    private Integer codigoProveedor;
    private Integer codigoCategoria;
    private Integer puntajeBenck;
    
    
    File dest;
    File source;
    public boolean guardarCategoria(){
        boolean retorno=false;
        
        try {
            String sql ="INSERT INTO categoriaProducto(idCategoria,nombreCategoria, descripcion, visualizacion_3D) "
                    + "VALUES ((SELECT MAX(idCategoria) FROM categoriaProducto)+1,?,?,?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1,nombreC);
            cmd.setString(2,descripC);
            cmd.setInt(3,V3D);
            if (!cmd.execute()) {
                retorno=true;
            }
           
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return retorno;
    }
    
    public boolean modificarCategoria(){
        boolean retorno=false;
        try {
            String sql="UPDATE categoriaProducto SET nombreCategoria=?, descripcion=?, visualizacion_3D=? WHERE idCategoria=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1,nombreC);
            cmd.setString(2,descripC);
            cmd.setInt(3,V3D);
            cmd.setInt(4,codigoC);
            if (!cmd.execute()) {
                retorno=true;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }
    
    public boolean eliminarCategoria(){
        boolean retorno=false;
        try {
           String sql="DELETE FROM categoriaProducto WHERE idCategoria=?";
           PreparedStatement cmd = cn.prepareStatement(sql);
           cmd.setInt(1,codigoC);
            if (!cmd.execute()) {
                retorno=true;
            }
            
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return retorno;
    }
    
    
    public DefaultTableModel setFilasCategorias(DefaultTableModel  model, int tipo, String valores)
    {
        try{
        String sql="";
        switch(tipo){
            case 1:
                sql="SELECT idCategoria, nombreCategoria, categoriaProducto.descripcion, visualizacion_3D FROM categoriaProducto WHERE idCategoria like '"+valores+"%'";
                break;
            case 2:
                sql="SELECT idCategoria, nombreCategoria, categoriaProducto.descripcion, visualizacion_3D FROM categoriaProducto WHERE nombreCategoria like '"+valores+"%'";
                break;
            default:
                sql="SELECT idCategoria, nombreCategoria, categoriaProducto.descripcion, visualizacion_3D FROM categoriaProducto";
                break;
        }
        Object dato[] = new Object[4];
        
            PreparedStatement us = cn.prepareStatement(sql);
            ResultSet res = us.executeQuery();
            
            while(res.next()){
                for(int i =0;i<3;i++)
                {
   
                        dato[i] = res.getObject(i+1);  
                }
        
                        if (res.getInt(4)==0) {
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
    
    public DefaultComboBoxModel llenarComboCategoria(DefaultComboBoxModel modelo) {
        modelo.removeAllElements();
        try {

            /* Realizamos la consulta a la base de datos*/
            String sql = "SELECT nombreCategoria FROM categoriaProducto";
            PreparedStatement verDatos = cn.prepareStatement(sql);
            ResultSet ver = verDatos.executeQuery();
            while (ver.next()) {

                modelo.addElement(ver.getObject("nombreCategoria"));
            }
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);

        }
        return modelo;
    }
    
    public DefaultComboBoxModel llenarComboProveedor(DefaultComboBoxModel modelo) {
        modelo.removeAllElements();
        try {

            /* Realizamos la consulta a la base de datos*/
            String sql = "SELECT nombreProveedor FROM proveedor";
            PreparedStatement verDatos = cn.prepareStatement(sql);
            ResultSet ver = verDatos.executeQuery();
            while (ver.next()) {

                modelo.addElement(ver.getObject("nombreProveedor"));
            }
           
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);

        }
        return modelo;
    }
 
    
    public DefaultTableModel setFilasProductos(DefaultTableModel  model, int tipo, String valores)
    {
     //Modificar esto
        try{
                  
                String sql = "";
                switch (tipo) {
                    case 1:
                        sql = "SELECT idProducto, nombreProducto, producto.descripcion, proveedor.nombreProveedor, categoriaProducto.nombreCategoria,puntajeBenchMark FROM producto , proveedor, categoriaProducto WHERE idProducto like '" + valores + "%' AND producto.idCategoria=categoriaProducto.idCategoria AND proveedor.idProveedor=producto.idProveedor";
                        break;
                    case 2:
                        sql = "SELECT idProducto, nombreProducto, producto.descripcion, proveedor.nombreProveedor, categoriaProducto.nombreCategoria,puntajeBenchMark FROM producto , proveedor, categoriaProducto WHERE nombreProducto like '" + valores + "%' AND producto.idCategoria=categoriaProducto.idCategoria AND proveedor.idProveedor=producto.idProveedor";
                        break;
                    case 3:
                        sql = "SELECT idProducto, nombreProducto, producto.descripcion, proveedor.nombreProveedor, categoriaProducto.nombreCategoria,puntajeBenchMark FROM producto , proveedor, categoriaProducto WHERE categoriaProducto.nombreCategoria like '" + valores + "%'  AND producto.idCategoria=categoriaProducto.idCategoria AND proveedor.idProveedor=producto.idProveedor";
                        break;
                    default:
                        sql = "SELECT idProducto, nombreProducto, producto.descripcion, proveedor.nombreProveedor, categoriaProducto.nombreCategoria,puntajeBenchMark FROM producto , proveedor, categoriaProducto WHERE producto.idCategoria=categoriaProducto.idCategoria AND proveedor.idProveedor=producto.idProveedor";
                        break;
                }
                Object dato[] = new Object[6];
                Conexion con = new Conexion();
                PreparedStatement us = cn.prepareStatement(sql);
                ResultSet res = us.executeQuery();

                while (res.next()) {
                    for (int i = 0; i < dato.length; i++) {

                        dato[i] = res.getObject(i + 1);
                        System.out.println("Dato; " + dato[i]);
                    }

                    model.addRow(dato);

                }
                
                
                 
        }
        catch(Exception ex){
 
                System.out.println(ex.toString());
        } 
        return model;
    }
    
    public String[] getColumnasProducto()
    {
        String columna[] = {"CODIGO","NOMBRE","DESCRIPCION", "PROVEEDOR","CATEGORIA","PUNTAJE"};
        return columna;
    }
    
    public String[] getColumnasCategoria()
    {
        String columna[] = {"CODIGO","NOMBRE","DESCRIPCION", "3D"};
        return columna;
    }
    
    
    
    public boolean guardarProducto(){
        boolean retorno=false;
        try {
            String sql="INSERT INTO producto(idProducto, nombreProducto, descripcion, imagen, idProveedor, idCategoria,puntajeBenchMark) "
                    + " VALUES ((SELECT MAX(idProducto) FROM producto)+1, ?, ?, ?, ? ,?,?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1,nombreP);
            cmd.setString(2,descripP);
            cmd.setString(3,imagen);
            cmd.setInt(4,codigoProveedor);
            cmd.setInt(5,codigoCategoria);
            cmd.setInt(6,puntajeBenck);
            if (!cmd.execute()) {
                retorno=true;
   
            }
            
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return retorno;
    }
    
    public boolean modificarProducto(){
        boolean retorno=false;
        try {
            String sql="UPDATE producto SET nombreProducto=?, descripcion=?, imagen=?, idProveedor=?, idCategoria=?,puntajeBenchMark=? WHERE idProducto=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1,nombreP);
            cmd.setString(2,descripP);
            cmd.setString(3,imagen);
            cmd.setInt(4,codigoProveedor);
            cmd.setInt(5,codigoCategoria);
            cmd.setInt(6,puntajeBenck);
            cmd.setInt(7,codigoP);
            if (!cmd.execute()) {
                retorno=true;
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return retorno;
    }
    
    public boolean eliminarProducto(){
        boolean retorno=false;
        try {
            String sql="DELETE FROM producto WHERE idProducto=?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1,codigoP);
            if (!cmd.execute()) {
                retorno=true;
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return retorno;
    }
}
