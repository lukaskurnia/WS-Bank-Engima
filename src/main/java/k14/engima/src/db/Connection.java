package k14.engima.src.db;
import java.sql.*;
import k14.engima.src.components.*;
import java.util.ArrayList;
import java.util.Date;

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
    
    public ArrayList<Nasabah> getAllNasabah(){
    	ArrayList <Nasabah> result = new ArrayList<Nasabah>();
        try{
            ResultSet rs = stmt.executeQuery("SELECT * FROM nasabah");
            
            while(rs.next())
            {
            	int nasabah_id=rs.getInt("nasabah_id");
                String name=rs.getString("name");
                String no_rek=rs.getString("no_rek");
                String virtual_acc=rs.getString("virtual_acc");
                int saldo=rs.getInt("saldo");
                String password=rs.getString("password");
            	Nasabah n = new Nasabah(nasabah_id,name,no_rek,virtual_acc,saldo,password);
                result.add(n);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    	return result;
    }
    
    public ArrayList<TransactionData> getAllTransaction(){
    	ArrayList <TransactionData> result = new ArrayList<TransactionData>();
        try{
            ResultSet rs = stmt.executeQuery("SELECT * FROM transaction_data");
            
            while(rs.next())
            {
            	int txn_id = rs.getInt("txn_id");
            	int nasabah_id = rs.getInt("nasabah_id");
            	int jenis_transaksi = rs.getInt("jenis_transaksi");
            	int jumlah_transaksi = rs.getInt("jumlah_transaksi");
            	String no_terkait = rs.getString("no_terkait");
            	Date timestamp = rs.getDate("timestamp");
            	
                TransactionData n = new TransactionData(txn_id,nasabah_id,jenis_transaksi,jumlah_transaksi,no_terkait,timestamp);
                result.add(n);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    	return result;
    }
    
    public boolean cekRekeningValid(String no_rekening) {
    	boolean valid = false;
    	
    	try{
            ResultSet rs = stmt.executeQuery("SELECT * FROM nasabah");
            
            while(rs.next())
            {
            	String no_rek = rs.getString("no_rek");
            	if(no_rek.equals(no_rekening)) {
            		valid = true;
            	}
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    	
    	return valid;
    }
    
    public ArrayList<TransactionData> getNasabahTransaction(int i){
    	ArrayList<TransactionData> result = new ArrayList<TransactionData>();
    	try{
            ResultSet rs = stmt.executeQuery("SELECT * FROM nasabah JOIN transaction_data "+
            								"WHERE nasabah.nasabah_id = transaction_data.nasabah_id AND transaction_data.nasabah_id ="+ 
            								i);
            while(rs.next())
            {
            	int txn_id = rs.getInt("txn_id");
            	int nsbh_id = rs.getInt("nasabah_id");
            	int jenis_transaksi = rs.getInt("jenis_transaksi");
            	int jumlah_transaksi = rs.getInt("jumlah_transaksi");
            	String no_terkait = rs.getString("no_terkait");
            	Date timestamp = rs.getDate("timestamp");
            	
                TransactionData n = new TransactionData(txn_id,nsbh_id,jenis_transaksi,jumlah_transaksi,no_terkait,timestamp);
                result.add(n);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    	return result;
    }
}
