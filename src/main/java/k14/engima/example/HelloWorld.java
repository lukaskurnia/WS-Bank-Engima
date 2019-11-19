package k14.engima.example;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import k14.engima.util.MySQLConnection;;

@WebService()
public class HelloWorld {
  @WebMethod
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }
  public static void main(String[] argv) {
    MySQLConnection conn = new MySQLConnection();
    conn.getName("select * from nasabah;");
    Object implementor = new HelloWorld ();
    String address = "http://localhost:9876/HelloWorld";
    System.out.println("Halo");
    Endpoint.publish(address, implementor);
  }
}
