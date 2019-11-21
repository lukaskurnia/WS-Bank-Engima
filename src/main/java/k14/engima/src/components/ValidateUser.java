package k14.engima.src.components;
import k14.engima.src.db.Connection;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public class ValidateUser {
    @WebMethod
    public Boolean isValidRekening(String rekening){
        Connection db = new Connection();
        ArrayList <String> result = db.generateAllNasabahRekening();
        return  result.contains(rekening);
    }
}