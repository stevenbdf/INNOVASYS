/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;

/**
 *
 * @author Steven
 */
public class mtoPedidos {
    Connection cn;
    public mtoPedidos(){
        Conexion con = new Conexion();
        cn=con.conectar();
    }
    
    
    
}
