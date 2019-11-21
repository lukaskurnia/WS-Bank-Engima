package k14.engima.src.db;
import java.sql.*;

public class db_test {
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
        	Connection con = new Connection();
//        	java.sql.Connection c = con.getConn();
        	
//        	Statement stt = c.createStatement();
////        	Create and Select DB
//        	stt.execute("CREATE DATABASE IF NOT EXIST ws_bank");
//        	stt.execute("USE ws_bank");
        	
        	
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
