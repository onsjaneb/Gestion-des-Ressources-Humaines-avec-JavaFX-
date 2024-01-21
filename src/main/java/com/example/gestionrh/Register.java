package com.example.gestionrh;

import com.example.gestionrh.CreateUserController;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.InputStream;

public class Register {
    public Button btncnx;
    public TextField emailuser;
    public PasswordField mdpuser;
    public PasswordField mdpconf;
    public  TextField nomuser;
    public TextField prenomuser;
    public Button btnconfirm;
    public GridPane registerinterface() {
        try{
        GridPane gp = new GridPane();

        VBox vb1 = new VBox();

        InputStream stream = new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\GestionRH\\src\\main\\images\\Login.png");
        Image image = new Image(stream);
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);
        Group img = new Group(imageView);

        btncnx = new Button("SE CONNECTER");
        btncnx.setStyle("-fx-font: 16px 'Serif';-fx-padding: 10;-fx-background-color:WHITE ;-fx-text-fill:#4E6E81");

        vb1.getChildren().add(img);
        vb1.getChildren().add(btncnx);

        vb1.setAlignment(Pos.CENTER);

        vb1.setPrefWidth(425);
        vb1.setPrefHeight(500);
        vb1.setBackground(new Background(new BackgroundFill(Color.rgb(78,110, 129), null, null)));

        VBox vb2 = new VBox();

        Label authlabel = new Label("Créer Un Compte");
        authlabel.setStyle("-fx-font-family:'Serif';-fx-font-size:34px;-fx-text-fill:#4E6E81");


        prenomuser = new TextField();
        prenomuser.setMaxWidth(150);
        prenomuser.setPrefHeight(30);
        prenomuser.setPromptText("Prénom du l'utilisateur");

        nomuser = new TextField();
        nomuser.setMaxWidth(150);
        nomuser.setPrefHeight(30);
        nomuser.setPromptText("Nom du l'utilisateur");

        HBox np = new HBox();
        np.getChildren().addAll(prenomuser,nomuser);
        np.setAlignment(Pos.CENTER);
        np.setSpacing(22);

        emailuser = new TextField();
        emailuser.setMaxWidth(320);
        emailuser.setPrefHeight(30);
        emailuser.setPromptText("E-mail du l'utilisateur");

        mdpuser = new PasswordField();
        mdpuser.setMaxWidth(320);
        mdpuser.setPrefHeight(30);
        mdpuser.setPromptText("Saisir le mot de passe");

        mdpconf = new PasswordField();
        mdpconf.setMaxWidth(320);
        mdpconf.setPrefHeight(30);
        mdpconf.setPromptText("Confirmer le mot de passe");

        btnconfirm = new Button("CONFIRMER");
        btnconfirm.setStyle("-fx-font: 16px 'Serif';-fx-padding: 10;-fx-background-color: #4E6E81;-fx-text-fill:WHITE");
        btnconfirm.setOnAction(new CreateUserController(this));

        vb2.getChildren().add(authlabel);
        vb2.getChildren().add(np);
        vb2.getChildren().add(emailuser);
        vb2.getChildren().add(mdpuser);
        vb2.getChildren().add(mdpconf);
        vb2.getChildren().add(btnconfirm);

        vb2.setAlignment(Pos.CENTER);
        vb2.setSpacing(25);
        vb2.setPrefWidth(425);
        vb2.setPrefHeight(500);
        vb2.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        gp.add(vb1,0,0);
        gp.add(vb2,1,0);
        return gp;
      }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
