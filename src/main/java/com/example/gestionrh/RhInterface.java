package com.example.gestionrh;

import com.example.gestionrh.MainEmp;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import static javafx.application.Application.setUserAgentStylesheet;

public class RhInterface {
    VBox side;
    public VBox main;
    HBox nav;
    Label appTitle;
    Label gestion_emp;
    Label gestion_serv;
    Label gestion_point;
    Label gestion_pointE;
    Label gestion_pointAE;
    Label gestion_miss;
    Label gestion_intraserv;
    Label gestion_interextserv;
    Label gestion_hrsuppAE;
    Label gestion_hrsuppE;
    Label gestion_jrferie;
    Label gestion_cong;
    Label gestion_congP;
    Label gestion_congNP;
    Image image;
    Image imagemiss, imagejr, imageserv, imagepoint, imagecong, imageuser, imagedec;
    public Label nom_prenom;
    Label declabel;
    public HBox dec;
    public MainEmp mainInter;
    public BorderPane bp;
    public BorderPane RhInteface(){
        try{
            URL cssUrl = getClass().getResource("/style.css");

            // Charge la feuille de style CSS
            String css = cssUrl.toExternalForm();
            setUserAgentStylesheet(css);

            bp = new BorderPane();
            side = new VBox();
            main = new VBox();
            nav = new HBox();

            appTitle = new Label("RH System");
            appTitle.setStyle("-fx-font-family:'Franklin Gothic Medium';-fx-font-size:28px;-fx-text-fill:white");
            appTitle.setPadding(new Insets(20,0,20,85));

            InputStream streamuser = new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\GestionRH\\src\\main\\images\\profile-user.png");
            imageuser = new Image(streamuser);
            ImageView imageViewuser = new ImageView();
            //Setting image to the image view
            imageViewuser.setImage(imageuser);
            //Setting the image view parameters
            imageViewuser.setX(10);
            imageViewuser.setY(10);

            imageViewuser.setFitWidth(22);
            imageViewuser.setFitHeight(22);
            imageViewuser.setPreserveRatio(true);
            Group imguser = new Group(imageViewuser);
            HBox user = new HBox();
            user.getChildren().addAll(imguser,nom_prenom);
            user.setPadding(new Insets(25,0,20,800));
            user.setSpacing(9);

            declabel = new Label("Se Déconnecter");
            declabel.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:15px;-fx-text-fill:white");
            InputStream streamdec= new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\GestionRH\\src\\main\\images\\logout.png");
            imagedec = new Image(streamdec);
            ImageView imageViewdec = new ImageView();
            //Setting image to the image view
            imageViewdec.setImage(imagedec);
            //Setting the image view parameters
            imageViewdec.setX(10);
            imageViewdec.setY(10);

            imageViewdec.setFitWidth(22);
            imageViewdec.setFitHeight(22);
            imageViewdec.setPreserveRatio(true);
            Group imgdec = new Group(imageViewdec);

            dec = new HBox();
            dec.getChildren().addAll(declabel,imgdec);
            dec.setPadding(new Insets(25,0,20,90));
            dec.setSpacing(4);
            nav.setPrefHeight(50);
            nav.getChildren().add(appTitle);
            nav.getChildren().add(user);
            nav.getChildren().add(dec);
            nav.setBackground(new Background(new BackgroundFill(Color.rgb(78,110, 129), null, null)));

            InputStream streamemp = new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\GestionRH\\src\\main\\images\\user-group-solid.png");
            image = new Image(streamemp);
            ImageView imageViewemp = new ImageView();
            //Setting image to the image view
            imageViewemp.setImage(image);
            //Setting the image view parameters
            imageViewemp.setX(10);
            imageViewemp.setY(10);

            imageViewemp.setFitWidth(26);
            imageViewemp.setFitHeight(26);
            imageViewemp.setPreserveRatio(true);
            Group imgemp = new Group(imageViewemp);


            gestion_emp = new Label("GESTION DES EMPLOYÉS");
            gestion_emp.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:17px;-fx-text-fill: rgb(78,110, 129)");
            gestion_emp.setPadding(new Insets(0,0,0,5));

            HBox empicon = new HBox();
            empicon.setPadding(new Insets(10,0,10,10));
            empicon.getChildren().add(imgemp);
            empicon.getChildren().add(gestion_emp);



            InputStream streamserv = new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\GestionRH\\src\\main\\images\\service.png");
            imageserv = new Image(streamserv);
            ImageView imageViewserv= new ImageView();
            //Setting image to the image view
            imageViewserv.setImage(imageserv);
            //Setting the image view parameters
            imageViewserv.setX(10);
            imageViewserv.setY(10);

            imageViewserv.setFitWidth(22);
            imageViewserv.setFitHeight(22);
            imageViewserv.setPreserveRatio(true);
            Group imgserv = new Group(imageViewserv);


            gestion_serv = new Label("GESTION DES SERVICES");
            gestion_serv.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:15px;-fx-text-fill:white");
            gestion_serv.setPadding(new Insets(0,0,0,5));
            HBox servicon = new HBox();
            servicon.setPadding(new Insets(25,0,0,10));
            servicon.getChildren().addAll(imgserv,gestion_serv);


            InputStream streampoint = new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\GestionRH\\src\\main\\images\\point.png");
            imagepoint = new Image(streampoint);
            ImageView imageViewpoint= new ImageView();
            //Setting image to the image view
            imageViewpoint.setImage(imagepoint);
            //Setting the image view parameters
            imageViewpoint.setX(10);
            imageViewpoint.setY(10);

            imageViewpoint.setFitWidth(22);
            imageViewpoint.setFitHeight(22);
            imageViewpoint.setPreserveRatio(true);
            Group imgpoint = new Group(imageViewpoint);

            gestion_point = new Label("GESTION DES POINTAGES");
            gestion_point.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:15px;-fx-text-fill:white");
            gestion_point.setPadding(new Insets(0,0,0,5));

            gestion_pointE = new Label("Gestion des pointages effectués");
            gestion_pointAE = new Label("Gestion des pointages à effectuer");
            gestion_pointE.setStyle("-fx-text-fill: white;-fx-font-size:13px");
            gestion_pointAE.setStyle("-fx-text-fill: white;-fx-font-size:13px");
            VBox gestp = new VBox();
            gestp.getChildren().addAll(gestion_pointE,gestion_pointAE);
            gestp.setPadding(new Insets(5,0,0,14));

            TitledPane tlpoint = new TitledPane();
            tlpoint.setGraphic(gestion_point);
            tlpoint.setContent(gestp);
            HBox pointicon = new HBox();
            pointicon.setPadding(new Insets(25,0,0,10));
            pointicon.getChildren().addAll(imgpoint,tlpoint);


            InputStream streammiss = new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\GestionRH\\src\\main\\images\\mission.png");
            imagemiss = new Image(streammiss);
            ImageView imageViewmiss= new ImageView();
            //Setting image to the image view
            imageViewmiss.setImage(imagemiss);
            //Setting the image view parameters
            imageViewmiss.setX(10);
            imageViewmiss.setY(10);

            imageViewmiss.setFitWidth(22);
            imageViewmiss.setFitHeight(22);
            imageViewmiss.setPreserveRatio(true);
            Group imgmiss = new Group(imageViewmiss);

            gestion_miss = new Label("GESTION DES MISSIONS");
            gestion_miss.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:15px;-fx-text-fill:white");
            gestion_miss.setPadding(new Insets(0,0,0,5));

            gestion_intraserv = new Label("Gestion des Intra-Extra-Services");
            gestion_intraserv.setStyle("-fx-text-fill: white;-fx-font-size:13px");

            gestion_interextserv = new Label("Gestion des Inter-Extra-Services");
            gestion_interextserv.setStyle("-fx-text-fill: white;-fx-font-size:13px");

            gestion_hrsuppAE = new Label("Gestion des heures supplémentaires à effectuer");
            gestion_hrsuppAE.setStyle("-fx-text-fill: white;-fx-font-size:13px");

            gestion_hrsuppE = new Label("Gestion des heures supplémentaires effectués");
            gestion_hrsuppE.setStyle("-fx-text-fill: white;-fx-font-size:13px");


            VBox gestmiss = new VBox();
            gestmiss.getChildren().addAll(gestion_intraserv, gestion_interextserv, gestion_hrsuppAE, gestion_hrsuppE);
            gestmiss.setPadding(new Insets(5,0,0,14));

            TitledPane tlmiss = new TitledPane();
            tlmiss.setGraphic(gestion_miss);
            tlmiss.setContent(gestmiss);

            HBox missicon = new HBox();
            missicon.setPadding(new Insets(25,0,0,10));
            missicon.getChildren().addAll(imgmiss,tlmiss);

            InputStream streamjrf= new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\GestionRH\\src\\main\\images\\jr ferie.png");
            imagejr= new Image(streamjrf);
            ImageView imageViewjr= new ImageView();
            //Setting image to the image view
            imageViewjr.setImage(imagejr);
            //Setting the image view parameters
            imageViewjr.setX(10);
            imageViewjr.setY(10);

            imageViewjr.setFitWidth(22);
            imageViewjr.setFitHeight(22);
            imageViewjr.setPreserveRatio(true);
            Group imgjr = new Group(imageViewjr);
            gestion_jrferie = new Label("GESTION DES JOURS  FERIÉS");
            gestion_jrferie.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:15px;-fx-text-fill:white");
            gestion_jrferie.setPadding(new Insets(0,0,0,5));
            HBox jricon = new HBox();
            jricon.setPadding(new Insets(25,0,0,10));
            jricon.getChildren().addAll(imgjr,gestion_jrferie);


            InputStream streamcong = new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\GestionRH\\src\\main\\images\\notification.png");
            imagecong = new Image(streamcong);
            ImageView imageViewcong= new ImageView();
            //Setting image to the image view
            imageViewcong.setImage(imagecong);
            //Setting the image view parameters
            imageViewcong.setX(10);
            imageViewcong.setY(10);

            imageViewcong.setFitWidth(22);
            imageViewcong.setFitHeight(22);
            imageViewcong.setPreserveRatio(true);
            Group imgcong = new Group(imageViewcong);

            gestion_cong = new Label("GESTION DES CONGÉS");
            gestion_cong.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:15px;-fx-text-fill:white");
            gestion_cong.setPadding(new Insets(0,0,0,5));

            gestion_congP= new Label("Gestion des congés planifiés");
            gestion_congP.setStyle("-fx-text-fill: white;-fx-font-size:13px");

            gestion_congNP = new Label("Gestion des congés non planifiés");
            gestion_congNP.setStyle("-fx-text-fill: white;-fx-font-size:13px");
            VBox gestcong = new VBox();
            gestcong.getChildren().addAll(gestion_congP,gestion_congNP);
            gestcong.setPadding(new Insets(5,0,0,14));

            TitledPane tlcong = new TitledPane();
            tlcong.setGraphic(gestion_cong);
            tlcong.setContent(gestcong);
            HBox congicon = new HBox();
            congicon.setPadding(new Insets(25,0,0,10));
            congicon.getChildren().addAll(imgcong,tlcong);


            side.setPrefWidth(322);
            side.getChildren().addAll(empicon,servicon,pointicon,missicon,jricon,congicon);
            side.setBackground(new Background(new BackgroundFill(Color.rgb(78,110, 129), null, null)));
            empicon.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
            empicon.setStyle("-fx-border-style: solid; -fx-border-color: rgb(78,110, 129); -fx-border-width: 2px;-fx-font-weight: bold;");

            bp.setTop(nav);
            bp.setLeft(side);
            mainInter = new MainEmp();

            return bp;
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public BorderPane getBorderPane() {
        return bp;
    }

}
