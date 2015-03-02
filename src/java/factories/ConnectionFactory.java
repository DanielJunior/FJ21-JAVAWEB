/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author danieljunior
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "Luana1609");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
