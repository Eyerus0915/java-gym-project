
package gymserver;

import gymmanagement.model.Admin;
import gymmanagement.model.Trainer;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static DatabaseConnection instance;
     Connection connection = null;
     String database = "gym";
     String url = "jdbc:mysql://localhost:3306/"+database;
    
     String username = "root";
     String password = "";
     
     //SQL
     final String SELECT_ADMIN = "SELECT * FROM `admin` WHERE admin.username=? AND admin.Password=?";
     final String SELECT_TRAINER = "SELECT * FROM `trainer` WHERE trainer.username=? AND trainer.Password=?";
    
    public static DatabaseConnection getInstance(){
        if(instance == null){
            return new DatabaseConnection();
        }
        
        return instance;
    }
    
    public DatabaseConnection(){
        instance = this;
        try {
            connection =  DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    
    public boolean AdminLogin(Admin admin){
         PreparedStatement p;
        try {
            p = connection.prepareStatement(SELECT_ADMIN);
            p.setString(1, admin.getUsername());
            p.setString(2, admin.getPassword());
            ResultSet results = p.executeQuery();
            if(results.next()){
                return true;
            }
            
        } catch (SQLException ex) {
        }
        return false;
    }
    public boolean trainerLogin(Trainer trainer){
         PreparedStatement p;
        try {
            p = connection.prepareStatement(SELECT_TRAINER);
            p.setString(1, trainer.getUsername());
            p.setString(2, trainer.getPassword());
            ResultSet results = p.executeQuery();
            if(results.next()){
                return true;
            }
            
        } catch (SQLException ex) {
            System.out.println("error in database");
        }
        return false;
    }
    
    public boolean addTrainer(Trainer trainer){
        //insert query to the database
        
        return false;
    }
    
    
}
