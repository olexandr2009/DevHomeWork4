package org.example.database;

import org.example.prefs.Configurations;

import java.sql.*;



public class Database {
    private static final Database INSTANCE = new Database();
    private Connection CONNECTION ;
    private Database(){
        try {
            Configurations configs = new Configurations();
             CONNECTION = DriverManager.getConnection(
                     configs.getConfigAsString(Configurations.DB_URL),
                     configs.getConfigAsString(Configurations.USER_NAME_CONFIG_NAME),
                     configs.getConfigAsString(Configurations.PASSWORD_CONFIG_NAME)
                     );
        } catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
    }
    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return CONNECTION;
    }

    public int executeUpdate(String sql){
        try(Statement st = CONNECTION.createStatement()){
            return st.executeUpdate(sql);
        } catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return -1;
    }
    public Statement getStatement(){
        try {
            return CONNECTION.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void close(){
        try {
            CONNECTION.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

