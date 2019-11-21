package k14.engima.example;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import k14.engima.src.db.Connection;;

@WebService()
public class HelloWorld {
  @WebMethod
  public String sayHelloWorldFrom(String from) {
//    Connection conn = new Connection();
//    String hasil = conn.getName("select * from transaction_data;");
    String result = "Hello, world, from " + from +"  " /* + hasil*/;
//    conn.close();
//    System.out.println(result);
    return result;
  }
  public static void main(String[] argv) {
    Object implementor = new HelloWorld ();
    String address = "http://localhost:9876/HelloWorld";
    System.out.println("Halo");
    Endpoint.publish(address, implementor);
  }
}
