package com.example.gestionrh;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;

public class Login extends Application {
    public GridPane gp;
    public VBox vb1;
    public VBox vb2;
    public Label authlabel;
    public TextField emailuser;
    public PasswordField mdpuser;
    public Button btncnx;
    public Image image;
    public Button btnadd;

    public Stage stage1;
    public Label mdpoublieLabel;

    public void start(Stage stage)  throws IOException {
        try{
        gp = new GridPane();
        vb1 = new VBox();

        authlabel = new Label("Authentification");
        authlabel.setStyle("-fx-font-family:'Serif';-fx-font-size:34px;-fx-text-fill:#4E6E81");

        emailuser = new TextField();
        emailuser.setMaxWidth(320);
        emailuser.setPrefHeight(30);
        emailuser.setPromptText("E-mail du l'utilisateur");

        mdpuser = new PasswordField();
        mdpuser.setMaxWidth(320);
        mdpuser.setPrefHeight(30);
        mdpuser.setPromptText("Mot de passe");
        mdpoublieLabel = new Label("Mot de passe oublié?");
        mdpoublieLabel.setStyle("-fx-font-family:'Serif';-fx-font-size:15px;-fx-text-fill:#4E6E81");
        VBox.setMargin(mdpoublieLabel, new Insets(-17, 0, 0, 190));
        mdpoublieLabel.setOnMouseClicked(e -> {
            try {
                RecMdp recMdp = new RecMdp();
                Stage stage2 = new Stage();
                stage2.setTitle("Récupération du mot de passe");
                stage2.setResizable(false);
                stage2.setScene(new Scene(recMdp.recapMdpInterface(), 850, 500));
                stage2.show();
                this.stage1.close();
                recMdp.btnconfirm.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            Socket socket = new Socket("127.0.0.1", 8000);
                        String nomuser = recMdp.nomuser.getText();
                        String  prenomuser = recMdp.prenomuser.getText();
                        String mailuser = recMdp.emailuser.getText();

                        Object[] objets = {nomuser, prenomuser, mailuser};


                         ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        objectOutputStream.writeObject(objets);
                        objectOutputStream.flush();


                        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                        String serverResponse = (String) objectInputStream.readObject();


                        if (serverResponse.equals("OK")) {
                            NewMdp nmd = new NewMdp();
                            Stage stage3 = new Stage();
                            stage3.setResizable(false);
                            stage3.setTitle("Saisie de nouvelle mot de passe");
                            stage3.setScene(new Scene(nmd.nouvelleMdp(), 850, 500));
                            stage3.show();
                            stage2.close();

                            nmd.btnconfirm.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    try {
                                        String mdp = nmd.mdpuser.getText();
                                        String mdpcnf = nmd.mdpconf.getText();

                                        Object[] objets2 = {mdp,mdpcnf};
                                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                                        objectOutputStream.writeObject(objets2);
                                        objectOutputStream.flush();


                                        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                                        String serverResponse2 = (String) objectInputStream.readObject();

                                        if (serverResponse2.equals("done")) {
                                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                            alert.setTitle("Information");
                                            alert.setHeaderText(null);
                                            alert.setContentText("Modification effectuée avec succés, Vous-pouvez connecter maintenant");
                                            alert.show();
                                        }
                                        else{
                                            Alert alert = new Alert(Alert.AlertType.ERROR);
                                            alert.setTitle("Erreur");
                                            alert.setHeaderText(null);
                                            alert.setContentText("Vérifier les champs saisies!");
                                            alert.show();
                                        }
                                    }catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            });

                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Erreur");
                            alert.setHeaderText(null);
                            alert.setContentText("Données saisies inexistantes!");
                            alert.show();
                        }
                    }catch (Exception ex) {
                            ex.printStackTrace();
                        }}
                });

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btncnx = new Button("CONNEXION");
        btncnx.setStyle("-fx-font: 16px 'Serif';-fx-padding: 10;-fx-background-color: #4E6E81;-fx-text-fill:WHITE");
        btncnx.setOnAction(new AccueilController(this,this.stage1));

        vb1.getChildren().add(authlabel);
        vb1.getChildren().add(emailuser);
        vb1.getChildren().add(mdpuser);
        vb1.getChildren().add(mdpoublieLabel);
        vb1.getChildren().add(btncnx);


        vb1.setAlignment(Pos.CENTER);
        vb1.setSpacing(25);
        vb1.setPrefWidth(425);
        vb1.setPrefHeight(500);
        vb1.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        vb2 = new VBox();
        InputStream stream = new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\GestionRH\\src\\main\\images\\add-user.png");
        image = new Image(stream);
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);
        Group img = new Group(imageView);

        btnadd = new Button("CRRÉR UN COMPTE");
        btnadd.setStyle("-fx-font: 16px 'Serif';-fx-padding: 10;-fx-background-color:WHITE ;-fx-text-fill:#4E6E81");
        btnadd.setOnAction(new RegisterController(this,this.stage1));
        vb2.getChildren().add(img);
        vb2.getChildren().add(btnadd);

        vb2.setAlignment(Pos.CENTER);

        vb2.setPrefWidth(425);
        vb2.setPrefHeight(500);
        vb2.setBackground(new Background(new BackgroundFill(Color.rgb(78,110, 129), null, null)));

        gp.add(vb1,0,0);
        gp.add(vb2,1,0);
        Scene scene = new Scene(gp,850, 500);
        stage1 = new Stage();
        stage1.setTitle("Gestion des ressources humaines");
        stage1.setResizable(false);
        stage1.setScene(scene);
        stage1.show();}
        catch (IOException e){
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}