package k14.engima.src.db;
import java.sql.*;

import java.util.ArrayList;

public class Connection {
    private java.sql.Connection conn;
    private java.sql.Statement stmt;

    public Connection(){
        try{
            Class.forName(Config.driver);
            conn = DriverManager.getConnection(Config.dbUrl, Config.user, Config.password);
            stmt = conn.createStatement();
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

    public java.sql.Connection getConn(){
        return conn;
    }

    public ArrayList<String> generateAllNasabahRekening() {
        ArrayList <String> result = new ArrayList<String>();
        try{
            ResultSet rs = stmt.executeQuery("SELECT * FROM nasabah");
            while(rs.next())
            {
                result.add( rs.getString("no_rek"));
            }
        }
        catch(Exception e){
            System.out.println(e);
            }
        return result;
    }
}
