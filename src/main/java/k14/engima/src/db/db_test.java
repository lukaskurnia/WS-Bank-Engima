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
        	
//        	ArrayList<Nasabah> n = con.getAllNasabah();
//        	for (Nasabah i : n) 
//                i.print(); 
//        	System.out.println( "" );
//        	ArrayList<TransactionData> t = con.getAllTransaction();
//        	for (TransactionData i : t) 
//                i.print(); 
//        	boolean b = con.cekRekeningValid("1234567890");
//        	System.out.println("1234567890 status " + b);
//        	System.out.println( "" );
        	ArrayList<TransactionData> t = con.getNasabahTransaction(2);
        	for (TransactionData i : t) 
                i.print(); 
        	con.addVAtoNasabah(con.generateVAccount(), 1);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
