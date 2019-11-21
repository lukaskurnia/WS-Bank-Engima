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
	Nasabah(){
		nasabah_id= 0;
		name= "";
		no_rek= "";
		virtual_acc= "";
		saldo= 0;
		password= "";
	}
	Nasabah(int a,String b,String c,String d,int e,String f){
		nasabah_id= a;
		name= b;
		no_rek= c;
		virtual_acc= d;
		saldo= e;
		password= f;
	}
	
//	Methods
	
}
