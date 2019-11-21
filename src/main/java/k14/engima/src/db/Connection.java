package k14.engima.src.db;
import java.sql.*;
import java.util.ArrayList;

public class Connection {
    private java.sql.Connection conn;

    public Connection(){
        try{
            Class.forName(Config.driver);
            conn = DriverManager.getConnection(Config.dbUrl, Config.user, Config.password);
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

    public ArrayList<String> generateAllRekening() {
        ArrayList <String> result = new ArrayList<String>();
        try{
            Statement stmt = conn.createStatement();
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

//    public String getName(String query){
//        StringBuilder hasil = new StringBuilder();
//        try{
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while(rs.next()){
//                hasil.append(rs.getString("timestamp")).append(" ");
//            }
//        }
//        catch(Exception e){
//            System.out.println(e);
//            }
//        return hasil.toString();
//    }
}
