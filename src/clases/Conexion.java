/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author steve
 */
public class Conexion {

    public Connection conectar() {
        Connection cn = null;
        try {
            //sebas 33
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //importar java.sql.DriverManager
            //cn= DriverManager.getConnection("jdbc:sqlserver://DESKTOP-CAVE2O6\\SQLEXPRESS;databaseName=dbInnovasys;user=sa;password=123;");
            cn = DriverManager.getConnection("jdbc:sqlserver://Internet\\SQLEXPRESS;databaseName=dbInnovasys;user=sa;password=123;");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cn;
    }
}
