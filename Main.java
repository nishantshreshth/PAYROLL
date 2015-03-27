import java.sql.Array;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ptimus-nishant
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    //Database Connection.
    static final String DATABASE_URL = "jdlc:mysql://localhost/name_of_Database";
    public static void main(String[] args) {
       LoginForm login = new LoginForm();
       login.setVisible(true);
       login.setSize(400,300);
       
    Connection connection = null; // Managemenmts Main connection.
    Statement statement = null;  //query statement
    ResultSet result = null;    //Manages result;
    
    try{
        //Establish Database Connection.
        connection = DriverManager.getConnection(DATABASE_URL, " nisant", "AHKIL & Demba");
        
        //create statement for query database.
        statement = connection.createStatement();
        
        //query database.
        result = statement.executeQuery("SELECT NAME, LASRNAME,  FROM TABLE ");
        
        //process query result.
        ResultSetMetaData metadata = result.getMetaData();
        int numberofcolumns = metadata.getColumnCount();
        System.out.printf("useful infor\n");
        
        for(int i = 1; i<=numberofcolumns; i++)
                System.out.printf("%-8s\t", metadata.getColumnClassName(i));
                System.out.println();
                
        while (result.next()) {
            for(int i = 1; i<=numberofcolumns; i++)
                System.out.printf("%-8s\t", result.getObject(i));
                System.out.println();
        }// end of while
        
        
    }
    catch(SQLException sqlexception){
        sqlexception.printStackTrace();
        
    }
    finally{
        try{result.close();
        statement.close();
        connection.close();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
            
        }
    }
    
    
       
       
    }
    
}
