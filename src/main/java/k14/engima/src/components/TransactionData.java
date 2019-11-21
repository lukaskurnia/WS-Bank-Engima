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
	TransactionData(){
		txn_id = 0;
		nasabah_id = 0;
		jenis_transaksi = 0;
		jumlah_transaksi= 0;
		no_terkait = "";
		timestamp = new Date();
	}
	TransactionData(int a,int b,int c,int d,String e,Date f){
		txn_id = a;
		nasabah_id = b;
		jenis_transaksi = c;
		jumlah_transaksi= d;
		no_terkait = e;
		timestamp = f;
	}
	
//	Methods
	
}
