package services;

import dataservice.VirtualAcc;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.*;
import java.util.Random;

@WebService
public class GetVirtualAcc {
    @WebMethod
    public VirtualAcc GetVirtualAcc() {
        VirtualAcc result = new VirtualAcc();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ws_bank?serverTimezone=UTC", "root", "");
            Statement stmt = conn.createStatement();

            int leftLimit = 48; // letter '0'
            int rightLimit = 57; // letter '9'
            int targetStringLength = 10;
            Random random = new Random();
            StringBuilder buffer = new StringBuilder(targetStringLength);
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }

            String virtual = "123123" + buffer.toString();

            String query = "INSERT INTO nasabah_vaccount (id, nasabah_id, virtual_acc)"
                    + "VALUES (NULL, 1, " + virtual + ")";
            stmt.addBatch(query);
            System.out.println(query);
            stmt.executeBatch();

            result.setStatus(200);
            result.setAmount(virtual);
            result.setNasabahId(1);

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