package services;

import dataservice.Transaksi;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebService
public class GetTransactionHistory {
    @WebMethod
    public Transaksi GetTransactionHistory(@XmlElement(name = "noRek") String  noRek) {
        Transaksi result = new Transaksi();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ws_bank?autoReconnect=true&"
                    + "useSSL=false&useUnicode=true&"
                    + "useJDBCCompliantTimezoneShift=true&"
                    + "useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "password");
            Statement stmt = conn.createStatement();

            String query = "SELECT * FROM transaction_data WHERE no_rek =" + noRek
                    + " ORDER BY transaction_time DESC";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) { //Ada
                rs.beforeFirst(); //Mundur satu record

                List<String> dataJenis = new ArrayList<String>();
                List<String> dataAmount = new ArrayList<String>();
                List<String> dataTransactionTime = new ArrayList<String>();
                List<String> dataNoAcc = new ArrayList<String>();

                result.setStatus(200);

                while (rs.next()) {
                    dataJenis.add(rs.getString("jenis_transaksi"));
                    dataAmount.add(rs.getString("jumlah_transaksi"));
                    dataTransactionTime.add(rs.getString("transaction_time"));
                    dataNoAcc.add(rs.getString("no_terkait"));
                }
                result.setJenisTxn(dataJenis);
                result.setAmount(dataAmount);
                result.setTransactionTime(dataTransactionTime);
                result.setNoAcc(dataNoAcc);
            } else { //Tidak ada
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
