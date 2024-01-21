package com.example.gestionrh;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;

public class RecMdp {
    public TextField emailuser;
    public  TextField nomuser;
    public TextField prenomuser;
    public Button btnconfirm;

    public GridPane recapMdpInterface() {
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

        vb1.getChildren().add(img);


        vb1.setAlignment(Pos.CENTER);

        vb1.setPrefWidth(425);
        vb1.setPrefHeight(500);
        vb1.setBackground(new Background(new BackgroundFill(Color.rgb(78,110, 129), null, null)));

        VBox vb2 = new VBox();

        Label recupLabel = new Label("Récupérer mot de passe");
        recupLabel.setStyle("-fx-font-family:'Serif';-fx-font-size:34px;-fx-text-fill:#4E6E81");


        prenomuser = new TextField();
        prenomuser.setMaxWidth(150);
        prenomuser.setPrefHeight(30);
        prenomuser.setPromptText("Saisie votre Prénom");

        nomuser = new TextField();
        nomuser.setMaxWidth(150);
        nomuser.setPrefHeight(30);
        nomuser.setPromptText("Saisie votre Nom");

        HBox np = new HBox();
        np.getChildren().addAll(prenomuser,nomuser);
        np.setAlignment(Pos.CENTER);
        np.setSpacing(22);

        emailuser = new TextField();
        emailuser.setMaxWidth(320);
        emailuser.setPrefHeight(30);
        emailuser.setPromptText("Saisie votre E-mail");


        btnconfirm = new Button("CONFIRMER");
        btnconfirm.setStyle("-fx-font: 16px 'Serif';-fx-padding: 10;-fx-background-color: #4E6E81;-fx-text-fill:WHITE");


        vb2.getChildren().add(recupLabel);
        vb2.getChildren().add(np);
        vb2.getChildren().add(emailuser);
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
