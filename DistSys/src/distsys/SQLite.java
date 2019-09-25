package distsys;

import java.sql.*;
import java.util.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class SQLite {
    private static final String CON_STR = "jdbc:sqlite:E:/install/SQLite3/tdisciple.db";
    
    private Connection connection = null;
    private Statement statement = null;
    private static SQLite instance = null;
    
    public static synchronized SQLite getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null)
            instance = new SQLite();
        return instance;
    }
    SQLite(){
         try
         {
        Class.forName("org.sqlite.JDBC");
        this.connection = DriverManager.getConnection(CON_STR);
         }
         catch (SQLException | ClassNotFoundException ex)
         {
                System.out.println("Project is not connected to DB! " + ex.getMessage());
         }
    }
    
    public Connection getConnection()
    {
        return connection;
    }
    
    public Statement getStatement()
    {
        if(statement != null) return statement;
        try
        {
            statement = connection.createStatement();
        }
        catch(SQLException ex)
        {
            System.out.println("Error creating query! " + ex.getMessage());
        }
        return statement;
    }
    
    public HashSet<Teacher> getAllTeachers() {
        try (Statement statement = this.connection.createStatement()) {
         
            HashSet<Teacher> teachers = new HashSet<Teacher>();
            ResultSet resultSet = statement.executeQuery("SELECT t_id, t_name, d_name FROM teachers");
            while (resultSet.next()) {
                teachers.add(new Teacher(resultSet.getInt("t_id"),
                                            resultSet.getString("t_name"),
                                            resultSet.getString("d_name")));
            }
            return teachers;
 
        } catch (SQLException e) {
            
            e.printStackTrace();
            return null;
        }
    }
    
    public HashSet<Dicipline> getAllDisciplines() {
        try (Statement statement = this.connection.createStatement()) {
         
            HashSet<Dicipline> diciplines = new HashSet<Dicipline>();
            ResultSet resultSet = statement.executeQuery("SELECT d_id, d_name, d_subarea FROM diciplines");
            while (resultSet.next()) {
                diciplines.add(new Dicipline(resultSet.getInt("d_id"),
                                            resultSet.getString("d_name"),
                                            resultSet.getString("d_subarea")));
            }
            return diciplines;
 
        } catch (SQLException e) {
            
            e.printStackTrace();
            return null;
        }
    }
    
    public String CreateT(int id, String name, String lesson)
    {
        String query = "INSERT INTO teachers VALUES ('" + id + "', '" + name + "', '" + lesson + "')";
        return query;
    }
    
    public String UpdateT(int id, String name, String lesson, String updateinfo)
    {
        String query = "UPDATE teachers SET d_name = '" + updateinfo + "' WHERE t_id = '" + 
                 id + "' AND t_name = '" + name + "' AND d_name = '" + lesson + "'";
        return query;
    }
    
    public String DeleteT(int id, String name, String lesson)
    {
        String query = "DELETE FROM teachers WHERE t_id = '" + id + "' AND t_name = '" + name + "' AND d_name = '" + lesson + "'";
        return query;
    }
    
    public String CreateD(String name, String area)
    {
        String query = "INSERT INTO diciplines (d_name, d_subarea) VALUES ('" + name + "', '" + area + "')";
        return query;
    }
    
    public String UpdateD1(int id,  String updateinfo1)
    {
        String query = "UPDATE diciplines SET d_name = '" + updateinfo1 + "' WHERE d_id = '" + id + "'";
        return query;
    }
    
    public String UpdateD2(int id,  String updateinfo2)
    {
        String query = "UPDATE diciplines SET d_subarea = '" + updateinfo2 + "' WHERE d_id = '" + id + "'";
        return query;
    }
    
    public String UpdateD3(int id,  String updateinfo1, String updateinfo2)
    {
        String query = "UPDATE diciplines SET d_name = '" + updateinfo1 + "', d_subarea = '" + updateinfo2 + "' WHERE d_id = '" + 
                 id + "'";
        return query;
    }
    
    public String DeleteD(int id)
    {
        String query = "DELETE FROM diciplines WHERE d_id = '" + id + "'";
        return query;
    }
    
}
