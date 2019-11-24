package services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import java.sql.*;

@WebService
public class CheckTransaction {
    @WebMethod
    public String CheckTransaction(@XmlElement(name = "destRek") String  destRek, @XmlElement(name = "amount") String amount,
                                           @XmlElement(name = "startTime") String startTime, @XmlElement(name = "endTime") String endTime) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ws_bank?serverTimezone=UTC", "root", "");
            Statement stmt = conn.createStatement();

            String query = "SELECT * FROM transaction_data WHERE jenis_transaksi = 'KREDIT' &&  no_terkait = "
                    + destRek + " && jumlah_transaksi = " + amount + " && transaction_time >= " + "'" + startTime
                    + "'" + " && transaction_time <= " + "'" + endTime + "'";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) { //Ada
                return "200";
            } else { //Tidak ada
                return "400";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "500";
        } catch (Exception e) {
            e.printStackTrace();
            return "300";
        }

    }
}