package services;

import dataservice.AccountNumber;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import java.sql.*;

@WebService
public class ValidateRekening {
    @WebMethod
    public AccountNumber ValidateRekening(@XmlElement(name = "noAcc") String  noAcc) {
        AccountNumber result = new AccountNumber();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ws_bank?serverTimezone=UTC", "root", "");
            Statement stmt = conn.createStatement();
            String query = "SELECT no_rek FROM nasabah WHERE no_rek = " + noAcc;
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) { //Found
                result.setStatus(200);
            } else { //Not Found
                result.setStatus(400);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result.setStatus(500);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(300);
        } finally {
            return result;
        }

    }
}