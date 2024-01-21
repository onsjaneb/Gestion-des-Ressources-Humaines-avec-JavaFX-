package com.example.gestionrh;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.sql.SQLException;

public class CreateUserController implements EventHandler {
    Register add;
    public CreateUserController(Register add) {
        this.add = add;
        String nomDriver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(nomDriver);
            System.out.println("Driver changed");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur Driver" + e.getMessage());
        }
    }
    @Override
    public void handle(Event event) {
        try {
            if (add.prenomuser.getText().isEmpty() || add.nomuser.getText().isEmpty() || add.emailuser.getText().isEmpty() || add.mdpuser.getText().isEmpty() || add.mdpconf.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("La saisie de tous les champs est obligatoire!");
                alert.show();

            }else{
            if (add.mdpuser.getText().equals(add.mdpconf.getText())) {
                CompteController cnx = new CompteController();
                cnx.insert(add.emailuser.getText(),add.mdpuser.getText(),add.prenomuser.getText(),add.nomuser.getText());
                add.prenomuser.setText("");
                add.nomuser.setText("");
                add.emailuser.setText("");
                add.mdpuser.setText("");
                add.mdpconf.setText("");
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Vérifier la confirmation du mot de passe!");
                alert.show();
            }
        } }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
