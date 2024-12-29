package dbFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class BuildDB {
    public static void buildDb() {
        
        String URL = "jdbc:sqlite:src/main/java/dbFiles/db.db"; 
        try {
            // Estableciendo conexión con la base de datos SQLite
            Connection conn = DriverManager.getConnection(URL);

            // Creando una declaración (Statement) para ejecutar SQL
            Statement stmt = conn.createStatement();

            // creando tablas:
            String inTypeTable = "CREATE TABLE IF NOT EXISTS \"INCATEGORY\" (\n" + //
                                "\t\"ID\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" + //
                                "\t\"inType\"\tTEXT NOT NULL UNIQUE\n" + //
                                ");";

            String outTypeTable = "CREATE TABLE IF NOT EXISTS \"OUTCATEGORY\" (\n" + //
                                "    \"ID\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" + //
                                "    \"outType\" TEXT NOT NULL UNIQUE\n" + //
                                ");\n" + //
                                "";

            String inMoneyListTable = "CREATE TABLE IF NOT EXISTS \"inMoneyTable\" (\n" + //
                                "\t\"ID\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" + //
                                "\t\"Date\"\tTEXT NOT NULL,\n" + //
                                "\t\"Name\"\tTEXT NOT NULL,\n" + //
                                "\t\"Description\"\tINTEGER NOT NULL,\n" + //
                                "\t\"Total\"\tINTEGER NOT NULL,\n" + //
                                "\t\"Category\"\tTEXT NOT NULL,\n" + //
                                "\t\"Categoryexpend\"\tINTEGER NOT NULL,\n" + //
                                "\tFOREIGN KEY(\"Categoryexpend\") REFERENCES \"INCATEGORY\"\n" + //
                                ");";

            String outMoneyListTable = "CREATE TABLE IF NOT EXISTS\"outMoneyTable\" (\n" + //
                                "\t\"ID\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" + //
                                "\t\"Date\"\tTEXT NOT NULL,\n" + //
                                "\t\"Name\"\tTEXT NOT NULL,\n" + //
                                "\t\"Description\"\tINTEGER NOT NULL,\n" + //
                                "\t\"Total\"\tINTEGER NOT NULL,\n" + //
                                "\t\"Category\"\tTEXT NOT NULL,\n" + //
                                "\t\"Categoryexpend\"\tINTEGER NOT NULL,\n" + //
                                "\tFOREIGN KEY(\"Categoryexpend\") REFERENCES \" OUTCATEGORY\"\n" + //
                                ");";

            
            // ejecutando sentencias
            stmt.executeUpdate(inTypeTable);
            stmt.executeUpdate(outTypeTable);
            stmt.executeUpdate(inMoneyListTable);
            stmt.executeUpdate(outMoneyListTable);

            // Cerrando la conexión y el Statement
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            // en caso del error
            e.printStackTrace();
            System.err.println("ha ocurrido un error con el creado de la base de datos y las tablas");
        }
    }
}
