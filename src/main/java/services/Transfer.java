package services;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import java.sql.*;


@WebService
public class Transfer {
    @WebMethod
    public String Transfer(@XmlElement(name = "noRek") String noRek, @XmlElement(name = "amount") String amount, @XmlElement(name = "destRek") String destRek) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ws_bank?serverTimezone=UTC", "root", "");
            Statement stmt = conn.createStatement();

            String tambahTransaksiDebit = "INSERT INTO transaction_data (txn_id, no_rek, jenis_transaksi, jumlah_transaksi, no_terkait, transaction_time)"
                    + " VALUES (NULL," + noRek + ", 'DEBIT', " + amount + "," + destRek + ", CURRENT_TIMESTAMP)";

            String updatePengirim = "UPDATE nasabah SET saldo = saldo - " + amount + " WHERE no_rek = " + noRek;

            String tambahTransaksiKredit = "INSERT INTO transaction_data (txn_id, no_rek, jenis_transaksi, jumlah_transaksi, no_terkait, transaction_time)"
                    + " VALUES (NULL," + destRek + ", 'KREDIT', " + amount + "," + noRek + ", CURRENT_TIMESTAMP)";

            String updatePenerima = "UPDATE nasabah SET saldo = saldo + " + amount + " WHERE no_rek = " + destRek;

            stmt.addBatch(tambahTransaksiDebit);
            stmt.addBatch(tambahTransaksiKredit);
            stmt.addBatch(updatePengirim);
            stmt.addBatch(updatePenerima);
            stmt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            return "500";
        } catch (Exception e) {
            e.printStackTrace();
            return "300";
        } finally {
            return "200";
        }

    }
}