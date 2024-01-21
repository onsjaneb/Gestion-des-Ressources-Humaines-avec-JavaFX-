package com.example.gestionrh;

import javafx.beans.Observable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.sql.*;

public class AccueilController implements EventHandler {
    public Login app;
    public Stage stage;

    Connection conn = null;
    Statement st = null;

    public AccueilController(Login app, Stage stage) throws SQLException{
        this.app = app;
        this.stage = stage;
        try {
            conn = Connexion.Connect();
            if (conn != null)
                st = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error conn" + e.getMessage());
        }
    }

    @Override
    public void handle(Event event) {
        try{
            if (app.emailuser.getText().isEmpty() || app.mdpuser.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("La saisie de tous les champs est obligatoire!");
                alert.show();
                app.emailuser.setText("");
                app.mdpuser.setText("");

            }
        else{
            int count = 0;
            String req = "select count(*) from compte where mail=? and mdp=?";
            if (conn != null) {

                PreparedStatement p = conn.prepareStatement(req);
                p.setString(1, app.emailuser.getText());
                p.setString(2, app.mdpuser.getText());
                ResultSet r = p.executeQuery();
                r.next();
                count = r.getInt(1);
                if (count > 0) {
                    System.out.println("Connecté");
                    try {
                        String req2 = "select nom,prenom from compte where mail=? and mdp=?";
                        PreparedStatement p2 = conn.prepareStatement(req2);
                        p2.setString(1, app.emailuser.getText());
                        p2.setString(2, app.mdpuser.getText());
                        ResultSet r2 = p2.executeQuery();
                        String nom_pre = "";
                        while (r2.next()) {
                            System.out.println(r2.getString("nom"));
                            System.out.println(r2.getString("prenom"));
                            nom_pre = r2.getString("prenom") + " " + r2.getString("nom");
                            System.out.println(nom_pre);
                        }

                        RhInterface rh = new RhInterface();
                        if (nom_pre != null) {
                            rh.nom_prenom = new Label();
                            rh.nom_prenom.setText(nom_pre);
                            rh.nom_prenom.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:15px;-fx-text-fill:white");
                        }



                        BorderPane bp = rh.RhInteface();
                        MainEmp mainInter = new MainEmp();


                        String req3 = "select count(id) from employe";
                        ResultSet rs3 = st.executeQuery(req3);
                        while (rs3.next()) {
                            int count3 = rs3.getInt(1);
                            mainInter.nbemp = new Label();
                            mainInter.nbemp.setText(Integer.toString(count3));
                            mainInter.nbemp.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:18px;-fx-text-fill:white;-fx-font-weight: bold");
                            mainInter.nbemp.setPadding(new Insets(0,215,0,0));
                        }

                        String req4 = "select count(id) from employe where role = 'directeur'";
                        ResultSet rs4 = st.executeQuery(req4);
                        while (rs4.next()) {
                            int count4 = rs4.getInt(1);
                            mainInter.nbdirLabel = new Label();
                            mainInter.nbdirLabel.setText(Integer.toString(count4));
                            mainInter.nbdirLabel.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:18px;-fx-text-fill:white;-fx-font-weight: bold");
                            mainInter.nbdirLabel.setPadding(new Insets(0,215,0,0));
                        }


                        String req5 = "select count(id) from employe where role = 'employe'";
                        ResultSet rs5 = st.executeQuery(req5);
                        while (rs5.next()) {
                            int count5 = rs5.getInt(1);
                            mainInter.nbempLabel = new Label();
                            mainInter.nbempLabel.setText(Integer.toString(count5));
                            mainInter.nbempLabel.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:18px;-fx-text-fill:white;-fx-font-weight: bold");
                            mainInter.nbempLabel.setPadding(new Insets(0,215,0,0));
                        }


                        ScrollPane me = mainInter.EmployeMain();
                        rh.main.getChildren().add(me);
                        rh.main.setPadding(new Insets(20,0,0,20));
                        bp.setCenter(rh.main);

                        mainInter.ajoutEmp.setOnAction(e -> {
                            AddEmp add = new AddEmp();
                            ScrollPane a = add.EmployeAdd();
                            bp.setCenter(a);

                            add.ajtEmp.setOnAction(e2 -> {
                                CompteController cnx = null;
                                try {
                                    cnx = new CompteController();
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                                String id = add.id.getText();
                                    String cin = add.cin.getText();
                                    String nom = add.nom.getText();
                                    String prenom = add.prenom.getText();
                                    String tel1 = add.tel1.getText();
                                    String tel2 = add.tel2.getText();
                                    String etat_civil = add.etat_civil.getValue();
                                    RadioButton selectedRadioButton = (RadioButton) add.role.getSelectedToggle();
                                    String role = selectedRadioButton.getText();
                                    Double  salaire = Double.parseDouble(add.salairebase.getText());
                                    String niveau = add.niveau.getValue();
                                    String ecole = add.ecole.getText();
                                    String service_nom = add.servicesList.getValue();
                                    String req6 = "select id_service from service where nom_service = ?";
                                PreparedStatement p1 = null;
                                try {
                                    p1 = conn.prepareStatement(req6);
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                                try {
                                    p1.setString(1,service_nom);
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                                ResultSet rs6 = null;
                                try {
                                    rs6 = p1.executeQuery();
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                                String id_serv = "";
                                    while (true) {
                                        try {
                                            if (!rs6.next()) break;
                                        } catch (SQLException ex) {
                                            throw new RuntimeException(ex);
                                        }
                                        try {
                                            id_serv = rs6.getString(1);
                                        } catch (SQLException ex) {
                                            throw new RuntimeException(ex);
                                        }
                                    }

                                try {
                                    cnx.insertEmp(id,cin,nom,prenom,tel1,tel2,etat_civil,role,salaire,niveau,ecole,id_serv);

                                    String req7 = "select count(id) from employe";
                                    ResultSet rs7 = st.executeQuery(req7);
                                    while (rs7.next()) {
                                        int count7 = rs7.getInt(1);
                                        mainInter.nbemp = new Label();
                                        mainInter.nbemp.setText(Integer.toString(count7));
                                        mainInter.nbemp.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:18px;-fx-text-fill:white;-fx-font-weight: bold");
                                        mainInter.nbemp.setPadding(new Insets(0,215,0,0));
                                    }

                                    String req8 = "select count(id) from employe where role = 'directeur'";
                                    ResultSet rs8 = st.executeQuery(req8);
                                    while (rs8.next()) {
                                        int count8 = rs8.getInt(1);
                                        mainInter.nbdirLabel = new Label();
                                        mainInter.nbdirLabel.setText(Integer.toString(count8));
                                        mainInter.nbdirLabel.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:18px;-fx-text-fill:white;-fx-font-weight: bold");
                                        mainInter.nbdirLabel.setPadding(new Insets(0,215,0,0));
                                    }

                                    String req9 = "select count(id) from employe where role = 'employe'";
                                    ResultSet rs9 = st.executeQuery(req9);
                                    while (rs9.next()) {
                                        int count9 = rs9.getInt(1);
                                        mainInter.nbempLabel = new Label();
                                        mainInter.nbempLabel.setText(Integer.toString(count9));
                                        mainInter.nbempLabel.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:18px;-fx-text-fill:white;-fx-font-weight: bold");
                                        mainInter.nbempLabel.setPadding(new Insets(0,215,0,0));
                                    }
                                    mainInter.tableEmploye.refresh();
                                    mainInter.searchField.textProperty().addListener((Observable obs) -> mainInter.rechercher());
                                    ScrollPane m2 = mainInter.EmployeMain();
                                    rh.main = new VBox();
                                    rh.main.getChildren().add(m2);
                                    rh.main.setPadding(new Insets(20,0,0,20));
                                    bp.setCenter(rh.main);
                                    bp.setCenter(rh.main);

                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }

                            });
                        });



                        Scene scene = new Scene(bp, 1300, 700);
                        stage = new Stage();
                        stage.setTitle("Gestion des employés");
                        stage.setResizable(true);
                        stage.setScene(scene);
                        stage.show();
                        app.stage1.close();
                        HBox hdec = rh.dec;
                        hdec.setOnMouseClicked(new LoginAccueilController(this.app,this.stage));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText(null);
                    alert.setContentText("Mail ou Mot de passe incorrect");
                    alert.show();
                    app.emailuser.setText("");
                    app.mdpuser.setText("");
                }


            }
                }

        }catch (Exception e){
            System.out.println(e.getMessage());       }
    }
}
