/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rafael Wendel Pinheiro
 */
public class ConnectionFactory 
{
    
    public Connection getConnection() 
    {
        try 
        {
            return DriverManager.getConnection("jdbc:mysql://localhost/cantina", "root", "admin123");
        } 
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
    }
    
}
