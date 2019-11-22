/**
 * 
 */
package k14.engima.src.components;

import java.util.Date;

/**
 * @author Seldi K Trihardja
 *
 */
public class TransactionData {
//	Attributes	
	int txn_id;
	int nasabah_id;
	int jenis_transaksi;
	int jumlah_transaksi;
	String no_terkait;
	Date timestamp;
//	Constructors
	public TransactionData(){
		txn_id = 0;
		nasabah_id = 0;
		jenis_transaksi = 0;
		jumlah_transaksi= 0;
		no_terkait = "";
		timestamp = new Date();
	}
	public TransactionData(int id,int nsbh_id,int jenis,int jumlah,String terkait,Date waktu){
		txn_id = id;
		nasabah_id = nsbh_id;
		jenis_transaksi = jenis;
		jumlah_transaksi= jumlah;
		no_terkait = terkait;
		timestamp = waktu;
	}
	
//	Methods
//	Methods
	public void print() {
		System.out.println("txn_id: " + txn_id);
		System.out.println("nasabah_id: " + nasabah_id);
		System.out.println("jenis_transaksi: " + jenis_transaksi);
		System.out.println("jumlah_transaksi: " + jumlah_transaksi);
		System.out.println("no_terkait: " + no_terkait);
		System.out.println("timestamp: " + timestamp);
		System.out.println( "" );
	}
}
