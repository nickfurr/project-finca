package dbFiles.cruds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import co.edu.uniquindio.poo.MoveTemplate.MoveTemplate;

public class InMoneyTableCrud {
    
    private InMoneyTableCrud instance;

    private InMoneyTableCrud(){}

    public InMoneyTableCrud getInstance(){

        if (instance == null){
            instance = new InMoneyTableCrud();
            return instance;
        }else {
            return instance;
        }
        
    }       
    
    public int addOne(MoveTemplate m) {
        String URL = "jdbc:sqlite:src/main/java/dbFiles/db.db";
    
        try (Connection conn = DriverManager.getConnection(URL)) {
            // Crear la consulta dentro del bloque
            String query = "INSERT INTO inMoneyTable (Date, Name, Description, Total, Category, CategoryExpent) VALUES (?, ?, ?, ?, ?, ?)";
    
            // Crear PreparedStatement dentro del try
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                // Configurar parámetros
                preparedStatement.setString(1, m.getDate());
                preparedStatement.setString(2, m.getName());
                preparedStatement.setString(3, m.getDescription());
                preparedStatement.setInt(4, m.getValor());
                preparedStatement.setString(5, m.getType());
                preparedStatement.setNull(6, java.sql.Types.VARCHAR);
    
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
    

    public Collection<MoveTemplate> searchForDate(String date){

        Collection<MoveTemplate> resultado = new ArrayList<>();


        String URL = "jdbc:sqlite:src/main/java/dbFiles/db.db";
    
        try (Connection conn = DriverManager.getConnection(URL)) {
            // Crear la consulta dentro del bloque
            String query = "SELECT * FROM inMoneyTable JOIN OUTCATEGORY ON outMoneyTable.Categoryexpend = OUTCATEGORY.outType WHERE Date = ?";
    
            // Crear PreparedStatement dentro del try
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                // Configurar parámetros
                preparedStatement.setString(1, date);
                // Ejecutar la consulta y devolver el resultado
                ResultSet rs = preparedStatement.executeQuery();

                if(rs != null){
                    while (rs.next()) {

                        String Date = rs.getString(1);
                        String Name = rs.getString(2);
                        String Description = rs.getString(3);
                        int Total = rs.getInt(4);
                        String Category = rs.getString(5);
                        String CategoryExpent = rs.getString(6);

                        MoveTemplate resoult1 = new MoveTemplate(Name, Description, Total, CategoryExpent, Date);
                        resultado.add(resoult1);
                    }
                }
    
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Ha ocurrido un error al insertar en la base de datos.");
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Ha ocurrido un error al insertar en la base de datos.");
        }

        return resultado;

    }

    public Collection<MoveTemplate> searchForType(String type){

        Collection<MoveTemplate> resultado = new ArrayList<>();


        String URL = "jdbc:sqlite:src/main/java/dbFiles/db.db";
    
        try (Connection conn = DriverManager.getConnection(URL)) {
            // Crear la consulta dentro del bloque
            String query = "SELECT * FROM inMoneyTable JOIN OUTCATEGORY ON outMoneyTable.Categoryexpend = OUTCATEGORY.outType WHERE Categoryexpend = ? ";
    
            // Crear PreparedStatement dentro del try
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                // Configurar parámetros
                preparedStatement.setString(1, type);
                // Ejecutar la consulta y devolver el resultado
                ResultSet rs = preparedStatement.executeQuery();

                if(rs != null){
                    while (rs.next()) {

                        String Date = rs.getString(1);
                        String Name = rs.getString(2);
                        String Description = rs.getString(3);
                        int Total = rs.getInt(4);
                        String Category = rs.getString(5);
                        String CategoryExpent = rs.getString(6);

                        MoveTemplate resoult1 = new MoveTemplate(Name, Description, Total, CategoryExpent, Date);
                        resultado.add(resoult1);
                    }
                }
    
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Ha ocurrido un error al insertar en la base de datos.");
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Ha ocurrido un error al insertar en la base de datos.");
        }

        return resultado;
        
    }

    public Collection<MoveTemplate> searchForDateType(String date, String type){
        Collection<MoveTemplate> resultado = new ArrayList<>();


        String URL = "jdbc:sqlite:src/main/java/dbFiles/db.db";
    
        try (Connection conn = DriverManager.getConnection(URL)) {
            // Crear la consulta dentro del bloque
            String query = "SELECT * FROM outMoneyTable JOIN OUTCATEGORY ON inMoneyTable.Categoryexpend = OUTCATEGORY.outType WHERE Categoryexpend = ? AND Date = ? ";
    
            // Crear PreparedStatement dentro del try
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                // Configurar parámetros
                preparedStatement.setString(1, type);
                preparedStatement.setString(2, date);
                // Ejecutar la consulta y devolver el resultado
                ResultSet rs = preparedStatement.executeQuery();

                if(rs != null){
                    while (rs.next()) {

                        String Date = rs.getString(1);
                        String Name = rs.getString(2);
                        String Description = rs.getString(3);
                        int Total = rs.getInt(4);
                        String Category = rs.getString(5);
                        String CategoryExpent = rs.getString(6);

                        MoveTemplate resoult1 = new MoveTemplate(Name, Description, Total, CategoryExpent, Date);
                        resultado.add(resoult1);
                    }
                }
    
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Ha ocurrido un error al insertar en la base de datos.");
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Ha ocurrido un error al insertar en la base de datos.");
        }

        return resultado;
        
    }

}
