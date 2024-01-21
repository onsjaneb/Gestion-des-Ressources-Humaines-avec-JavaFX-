package com.example.gestionrh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    public static Connection Connect(){
        String nomDriver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(nomDriver);
            System.out.println("Driver changed");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur Driver" + e.getMessage());
        }

        //Connection à la base
        String url = "jdbc:mysql://127.0.0.1/gestion_rh";
        String user = "root";
        String mp = "";
        Connection con = null;
        try{
            con = DriverManager.getConnection(url, user, mp);
            System.out.println("Connected...");
            return con;
        } catch (SQLException e) {
            System.out.println("Error conn"+e.getMessage());
            return null;
        }
    }
}
