/**
 * 
 */
package k14.engima.src.components;

/**
 * @author Seldi K Trihardja
 *
 */
public class Nasabah {
//	Attributes
	int nasabah_id;
	String name;
	String no_rek;
	String virtual_acc;
	int saldo;
	String password;
	
//	Constructors
	public Nasabah(){
		nasabah_id= 0;
		name= "";
		no_rek= "";
		virtual_acc= "";
		saldo= 0;
		password= "";
	}
	public Nasabah(int id_nasabah,String nama,String rekening,String v_acc,int saldo_n,String pass){
		nasabah_id= id_nasabah;
		name= nama;
		no_rek= rekening;
		virtual_acc= v_acc;
		saldo= saldo_n;
		password= pass;
	}
	
//	Methods
	public void print() {
		System.out.println("nasabah_id: " + nasabah_id);
		System.out.println("name: " + name);
		System.out.println("no_rek: " + no_rek);
		System.out.println("virtual_acc: " + virtual_acc);
		System.out.println("saldo: " + saldo);
		System.out.println("password: " + password);
		System.out.println( "" );
	}
}
