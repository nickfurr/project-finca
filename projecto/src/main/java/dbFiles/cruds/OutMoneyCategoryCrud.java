package dbFiles.cruds;

import co.edu.uniquindio.poo.MoveTemplate.MoveTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;


public class OutMoneyCategoryCrud {

    private OutMoneyCategoryCrud instance;

    private OutMoneyCategoryCrud(){}

    public OutMoneyCategoryCrud getInstance(){

        if (instance == null){
            instance = new OutMoneyCategoryCrud();
            return instance;
        }else {
            return instance;
        }
        
    }       
    
    public void AddOne(MoveTemplate m){
        
        
            String URL = "jdbc:sqlite:src/main/java/dbFiles/db.db"; 
            try {
                // Estableciendo conexión con la base de datos SQLite
                Connection conn = DriverManager.getConnection(URL);
    
                // Creando una declaración (Statement) para ejecutar SQL
                Statement stmt = conn.createStatement();

                String 

    
                String execute = "INSERT INTO outMoneyTable (Date, Name, Description, Total, Category, CategoryExpent) values () ";
                
                stmt.executeUpdate(execute);
    
                // Cerrando la conexión y el Statement
                stmt.close();
                conn.close();
    
            } catch (SQLException e) {
                // en caso del error
                e.printStackTrace();
                System.err.println("ha ocurrido un error");
            }

    }


}
