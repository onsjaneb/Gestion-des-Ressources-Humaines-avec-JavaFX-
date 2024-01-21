package com.example.gestionrh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionController {
    Connection conn = null;
    Statement st = null;

    public ConnexionController() throws SQLException {
        try {
            conn = Connexion.Connect();
            if (conn != null)
                st = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error conn" + e.getMessage());
        }
    }
    public ResultSet select(String req){

        try {
            return st.executeQuery(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}