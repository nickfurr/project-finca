package dbFiles.cruds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class OutCategoryCrud {

    private OutCategoryCrud instance;

    private OutCategoryCrud(){}

    public OutCategoryCrud getInstance(){

        if (instance == null){
            instance = new OutCategoryCrud();
            return instance;
        }else {
            return instance;
        }
        
    }       

    public int Add (String type){
        String URL = "jdbc:sqlite:src/main/java/dbFiles/db.db";
    
        try (Connection conn = DriverManager.getConnection(URL)) {
            // Crear la consulta dentro del bloque
            String query = "INSERT INTO OUTCATEGORY (outType) VALUES (?)";
    
            // Crear PreparedStatement dentro del try
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                // Configurar parámetros
                preparedStatement.setString(1, type);
    
                // Ejecutar la consulta y devolver el resultado
                int cambios = preparedStatement.executeUpdate();
                return cambios;
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Ha ocurrido un error al insertar en la base de datos.");
            return 0;
        }

    }

    public Collection<String> getAll(){
        String URL = "jdbc:sqlite:src/main/java/dbFiles/db.db";

        Collection<String> all = new ArrayList<>();
    
        try (Connection conn = DriverManager.getConnection(URL)) {
            // Crear la consulta dentro del bloque
            String query = "SELECT * FROM OUTCATEGORY";
    
            // Crear PreparedStatement dentro del try
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                // Configurar parámetros
                ResultSet rs = preparedStatement.executeQuery();
    
                while (rs.next()) {
                    all.add(rs.getString(1));
                }
                
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Ha ocurrido un error al insertar en la base de datos.");
            
        }
        return all;

    }
     

}
