package com.example.gestionrh;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.InputStream;

public class NewMdp {
    PasswordField mdpuser,mdpconf;
    public Button btnconfirm;

    public GridPane nouvelleMdp() {
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

        Label nmdpLabel = new Label("Saisie de nouvelle mot de passe");
        nmdpLabel.setStyle("-fx-font-family:'Serif';-fx-font-size:24px;-fx-text-fill:#4E6E81");

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

        vb2.getChildren().add(nmdpLabel);
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
