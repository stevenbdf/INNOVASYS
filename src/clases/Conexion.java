/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author steve
 */
public class Conexion {
    
    public Connection conectar() {
        Connection cn = null;
        try {
            //Hola Mundo 2
            //TEST CAMBIO JD/Estos son cambios test steven
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //importar java.sql.DriverManager
            //Lap Steven
            //cn= DriverManager.getConnection("jdbc:sqlserver://DESKTOP-CAVE2O6\\SQLEXPRESS;databaseName=dbInnovasys;user=sa;password=123;");
            //Pc Steven
            cn= DriverManager.getConnection("jdbc:sqlserver://USER-PC\\SQLEXPRESS:1433;databaseName=dbInnovasys;user=sa;password=123;");
            //Lap Sebas
            //cn = DriverManager.getConnection("jdbc:sqlserver://192.168.1.2;databaseName=dbInnovasys2;user=sa;password=123;");
            //Base en internet
            //cn = DriverManager.getConnection("jdbc:sqlserver://den1.mssql6.gear.host;databaseName=dbinnovasys;user=dbinnovasys;password=FCBarcelona123@;");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return cn;
  
    }
    
}
