package services;

import dataservice.Nasabah;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import java.sql.*;

@WebService
public class GetDataNasabah {
    @WebMethod
    public Nasabah GetDataNasabah(@XmlElement(name = "noRek") String  noRek) {
        Nasabah result = new Nasabah();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/ws_bank?autoReconnect=true&"
                + "useSSL=false&useUnicode=true&"
                + "useJDBCCompliantTimezoneShift=true&"
                + "useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "password");
            Statement stmt = conn.createStatement();

            String query = "SELECT * FROM nasabah WHERE no_rek =" + noRek;
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                result.setStatus(200);
                result.setNasabahId(rs.getInt("nasabah_id"));
                result.setName(rs.getString("name"));
                result.setSaldo(rs.getInt("saldo"));
                result.setNoRek(rs.getString("no_rek"));
            } else {
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