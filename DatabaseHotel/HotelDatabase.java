/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseHotel;

import ImplementHotel.PelangganDaoImpl;
import ServiceHotel.PelangganDao;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Hopeless
 */


import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Hopeless
 */
public class HotelDatabase {
    
    private static Connection connection;
    private static PelangganDao pelangganDao;
    
    public static Connection getConnection() throws SQLException{
    
        if (connection == null){
        
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/applicationhotel");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
        
        
        return connection;
    }
    public static PelangganDao getPelangganDao()throws SQLException{
    
        if (pelangganDao == null){
        
            pelangganDao = new PelangganDaoImpl(getConnection());
        }
        
        return pelangganDao;
        
    }
}


