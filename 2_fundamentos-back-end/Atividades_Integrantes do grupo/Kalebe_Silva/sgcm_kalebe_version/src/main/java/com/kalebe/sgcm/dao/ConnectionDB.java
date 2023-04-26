package com.kalebe.sgcm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    

    private Connection connection;
    private static ConnectionDB instanceConnection;
    private final String DATABASE_URL = "jdbc:mysql://localhost/sgcm";
    private final String USERNAME =  "root";
    private final String PASSWORD = "root";


    private ConnectionDB(){
        
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(this.DATABASE_URL,this.USERNAME, this.PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                
                e.printStackTrace();
            }
            
        
    }

    public static Connection getConnection() {
        if(instanceConnection == null) {
            instanceConnection =  new ConnectionDB();
        }

        return instanceConnection.connection;
    }
    






}
