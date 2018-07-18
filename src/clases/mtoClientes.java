/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import formularios.RegistroClientes;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Susy francelia
 */
public class mtoClientes extends RegistroClientes{

    /**
     * @return the respuesta2
     */
    public String getRespuesta2() {
        return respuesta2;
    }

    /**
     * @param respuesta2 the respuesta2 to set
     */
    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    /**
     * @return the CodigoCliente
     */
    public Integer getCodigoCliente() {
        return CodigoCliente;
    }

    /**
     * @param CodigoCliente the CodigoCliente to set
     */
    public void setCodigoCliente(Integer CodigoCliente) {
        this.CodigoCliente = CodigoCliente;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the apellidoCliente
     */
    public String getApellidoCliente() {
        return apellidoCliente;
    }

    /**
     * @param apellidoCliente the apellidoCliente to set
     */
    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    /**
     * @return the corporativo
     */
    public Integer getCorporativo() {
        return corporativo;
    }

    /**
     * @param corporativo the corporativo to set
     */
    public void setCorporativo(Integer corporativo) {
        this.corporativo = corporativo;
    }

    /**
     * @return the dui
     */
    public Integer getDui() {
        return dui;
    }

    /**
     * @param dui the dui to set
     */
    public void setDui(Integer dui) {
        this.dui = dui;
    }

    /**
     * @return the nit
     */
    public BigInteger getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(BigInteger nit) {
        this.nit = nit;
    }

    /**
     * @return the correoCliente
     */
    public String getCorreoCliente() {
        return correoCliente;
    }

    /**
     * @param correoCliente the correoCliente to set
     */
    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    /**
     * @return the contraseñaCliente
     */
    public String getContraseñaCliente() {
        return contraseñaCliente;
    }

    /**
     * @param contraseñaCliente the contraseñaCliente to set
     */
    public void setContraseñaCliente(String contraseñaCliente) {
        this.contraseñaCliente = contraseñaCliente;
    }

    /**
     * @return the pregunta1
     */
    public String getPregunta1() {
        return pregunta1;
    }

    /**
     * @param pregunta1 the pregunta1 to set
     */
    public void setPregunta1(String pregunta1) {
        this.pregunta1 = pregunta1;
    }

    /**
     * @return the pregunta2
     */
    public String getPregunta2() {
        return pregunta2;
    }

    /**
     * @param pregunta2 the pregunta2 to set
     */
    public void setPregunta2(String pregunta2) {
        this.pregunta2 = pregunta2;
    }

    /**
     * @return the telefono
     */
    public Integer getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the respuesta1
     */
    public String getRespuesta1() {
        return respuesta1;
    }

    /**
     * @param respuesta1 the respuesta1 to set
     */
    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }
    private Connection cn;
    public mtoClientes(){
        Conexion con = new Conexion();
        cn= con.conectar();
    }
    public DefaultTableModel setfilas(DefaultTableModel  model)
    {
        
        String sql="Select * from cliente";
        Object dato[] = new Object[8];
        try{
            PreparedStatement us = cn.prepareStatement(sql);
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
            PreparedStatement us = cn.prepareStatement(sql1);
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
    
    private Integer CodigoCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private Integer corporativo;
    private Integer dui;
    private BigInteger nit;
    private String correoCliente;
    private String contraseñaCliente;
    private String pregunta1;
    private String pregunta2;
    private Integer telefono;
    private String respuesta1;
    private String respuesta2;
    
    public boolean guardarCliente(){
        boolean valor=false;
            try {
            String sql ="INSERT INTO cliente(idCliente, nombre, apellido, corporativo, dui, nit, correoElectronico, contraseña, preguntaSeguridad1, preguntaSeguridad2, telefono, "
                    + "RespuestaSeguridad1, RespuestaSeguridad2) VALUES ((SELECT MAX(idCliente) FROM cliente)+1,?,?,?,?,"+nit+",?,?,?,?,?,?,?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1,nombreCliente);
            cmd.setString(2,apellidoCliente);
            cmd.setInt(3,corporativo);
            cmd.setInt(4,dui);
            cmd.setString(5,correoCliente);
            cmd.setString(6,contraseñaCliente);
            cmd.setString(7,pregunta1);
            cmd.setString(8,pregunta2);
            cmd.setInt(9,telefono);
            cmd.setString(10,respuesta1);
            cmd.setString(11,respuesta2);           
            if (!cmd.execute()) {
                valor=true;
            }
            cmd.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("AQUI");
            System.out.println(e.toString());
                
        }       
        return valor;
    }   
}
