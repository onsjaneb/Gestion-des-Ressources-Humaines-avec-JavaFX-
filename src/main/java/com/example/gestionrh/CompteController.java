package com.example.gestionrh;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.*;

public class CompteController {

    Login app;
    Stage stage;

    public CompteController(Login app, Stage stage) {
        this.app = app;
        this.stage = stage;
    }

    Connection conn = null;
    Statement st = null;

    public CompteController() throws SQLException {
        try {
            conn = Connexion.Connect();
            if (conn != null)
                st = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error conn" + e.getMessage());
        }

    }

    int insert(String mailAdd, String mdpAdd, String prenomAdd , String nomAdd) throws SQLException {
        if (conn != null) {
            String req = "select count(*) from compte where mail=?";
            PreparedStatement p1 = conn.prepareStatement(req);
            p1.setString(1,mailAdd);
            ResultSet rs = p1.executeQuery();
            rs.next();
            int countSel = rs.getInt(1);

            if(countSel == 0){
            String req1 = "insert into compte(mail,mdp,prenom,nom) values(?,?,?,?)";
            PreparedStatement p = conn.prepareStatement(req1);
            p.setString(1,mailAdd);
            p.setString(2,mdpAdd);
            p.setString(3,prenomAdd);
            p.setString(4,nomAdd);
            int r = p.executeUpdate();
            if (r > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Insertion effectuée avec succés");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Erreur lors de l'opération d'insertion");
                alert.show();
            }
        }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Mail exisite déjà!");
                alert.show();
            }
        }
        return 0;
    }



    int insertEmp(String id, String cin, String nom , String prenom,String tel1, String tel2, String etat_civil,String role, Double salaire,String niveau, String ecole, String service) throws SQLException {
        if (conn != null) {
            String req = "select count(*) from employe where id=?";
            PreparedStatement p1 = conn.prepareStatement(req);
            p1.setString(1,id);
            ResultSet rs = p1.executeQuery();
            rs.next();
            int countSel = rs.getInt(1);

            if(countSel == 0){
                String req1 = "insert into employe(id,cin,nom,prenom,tel1,tel2,etat_civil,role,salaire_base,niveau,ecole,id_service) values(?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement p = conn.prepareStatement(req1);
                p.setString(1,id);
                p.setString(2,cin);
                p.setString(3,nom);
                p.setString(4,prenom);
                p.setString(5,tel1);
                p.setString(6,tel2);
                p.setString(7,etat_civil);
                p.setString(8,role);
                p.setDouble(9,salaire);
                p.setString(10,niveau);
                p.setString(11,ecole);
                p.setString(12,service);
                int r = p.executeUpdate();
                if (r > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Insertion effectuée avec succés");
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText(null);
                    alert.setContentText("Erreur lors de l'opération d'insertion");
                    alert.show();
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Employé exisite déjà!");
                alert.show();
            }
        }
        return 0;
    }
}
