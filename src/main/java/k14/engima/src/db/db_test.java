package k14.engima.src.db;
import java.sql.*;
import java.util.ArrayList;

import k14.engima.src.components.Nasabah;
import k14.engima.src.components.TransactionData;

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
        	
//        	ArrayList <String> result = con.generateAllNasabahRekening();
//        	System.out.println(result);
        	ArrayList<Nasabah> n = con.getAllNasabah();
        	for (Nasabah i : n) 
                i.print(); 
        	System.out.println( "" );
        	ArrayList<TransactionData> t = con.getAllTransaction();
        	for (TransactionData i : t) 
                i.print(); 
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
