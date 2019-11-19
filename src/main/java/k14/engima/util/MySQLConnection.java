package k14.engima.util;
import java.sql.*;

public class MySQLConnection{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    
    

    public MySQLConnection(){
        try{
            Class.forName(Variable.driver);
            conn = DriverManager.getConnection(Variable.dbUrl,Variable.user,Variable.password);
            // System.out.println("test");

            // while(rs.next())
            //     System.out.println(rs.getString("name"));

        }
        catch(Exception e){ 
            System.out.println(e);
            }
    }

    public void close() {
        try{
            conn.close();
        }
        catch(Exception e){ 
            System.out.println(e);
            }
    }

    public void getName(String query){
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        }
        catch(Exception e){ 
            System.out.println(e);
            }
    }
}
