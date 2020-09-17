/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecom.helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pc
 */
public class ConnectionProvider {
    private static Connection con;
    
    public static Connection createConnection()
    {
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learn_ecom", "root","root");
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        return con;
    }
}
