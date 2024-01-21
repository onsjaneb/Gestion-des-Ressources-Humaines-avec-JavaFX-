package com.example.gestionrh;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.ResultSet;


public class AddEmp {
    public VBox empajt;
    public Button ajtEmp;
   public TextField id,cin,nom,prenom,tel1,tel2,salairebase,ecole;
    public ComboBox<String> etat_civil;
    public ComboBox<String> servicesList;
    public ToggleGroup role;
    public RadioButton dir,emp;
    public ComboBox<String> niveau;
    public ScrollPane EmployeAdd()  {
        try {
            empajt = new VBox();
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(empajt);
            Label ajtLabel = new Label("Ajouter");
            ajtLabel.setStyle("-fx-font-size: 30");
            ajtLabel.setPadding(new Insets(6,0,0,0));
            Label ajoutEmp = new Label("Un Employé");
            ajoutEmp.setStyle("-fx-font-size: 37");
            HBox ajtTitle = new HBox();
            ajtTitle.getChildren().addAll(ajtLabel,ajoutEmp);
            ajtTitle.setSpacing(13);
            ajtTitle.setPadding(new Insets(30,0,0,30));

            Label infopers = new Label("Informations Personnelles");
            infopers.setStyle("-fx-font-size: 20; -fx-text-fill: rgb(78,110, 129);");
            infopers.setPadding(new Insets(10,0,0,30));

            HBox boxid = new HBox();
            Label id_label = new Label("Id");
            id_label.setStyle("-fx-text-fill: #000000; -fx-font-size: 18px;");
            id = new TextField();
            id.setPrefHeight(30);
            id.setPrefWidth(180);
            id.setStyle("-fx-border-size: 2px;-fx-border-color: black;-fx-border-radius: 2;-fx-font-size: 15px;");
            boxid.getChildren().addAll(id_label,id);
            boxid.setSpacing(102);

            HBox boxcin = new HBox();
            Label cin_label = new Label("CIN");
            cin_label.setStyle("-fx-text-fill: #000000; -fx-font-size: 18px;");
            cin = new TextField();
            cin.setPrefHeight(30);
            cin.setPrefWidth(180);
            cin.setStyle("-fx-border-size: 2px;-fx-border-color: black;-fx-border-radius: 2;-fx-font-size: 15px;");
            boxcin.getChildren().addAll(cin_label,cin);
            boxcin.setSpacing(88);

            HBox ligne1 = new HBox();
            ligne1.getChildren().addAll(boxid,boxcin);
            ligne1.setPadding(new Insets(50,0,0,30));
            ligne1.setSpacing(150);

            HBox boxnom = new HBox();
            Label nom_label = new Label("Nom");
            nom_label.setStyle("-fx-text-fill: #000000; -fx-font-size: 18px;");
            nom = new TextField();
            nom.setPrefHeight(30);
            nom.setPrefWidth(180);
            nom.setStyle("-fx-border-size: 2px;-fx-border-color: black;-fx-border-radius: 2;-fx-font-size: 15px;");
            boxnom.getChildren().addAll(nom_label,nom);
            boxnom.setSpacing(79);

            HBox boxpre= new HBox();
            Label prenom_label = new Label("Prénom");
            prenom_label.setStyle("-fx-text-fill: #000000; -fx-font-size: 18px;");
            prenom = new TextField();
            prenom.setPrefHeight(30);
            prenom.setPrefWidth(180);
            prenom.setStyle("-fx-border-size: 2px;-fx-border-color: black;-fx-border-radius: 2;-fx-font-size: 15px;");
            boxpre.getChildren().addAll(prenom_label,prenom);
            boxpre.setSpacing(55.5);

            HBox ligne2 = new HBox();
            ligne2.getChildren().addAll(boxnom,boxpre);
            ligne2.setPadding(new Insets(50,0,0,30));
            ligne2.setSpacing(150);


            HBox boxtel1 = new HBox();
            Label tel1_tabel = new Label("Téléphone 1");
            tel1_tabel.setStyle("-fx-text-fill: #000000; -fx-font-size: 18px;");
            tel1 = new TextField();
            tel1.setPrefHeight(30);
            tel1.setPrefWidth(180);
            tel1.setStyle("-fx-border-size: 2px;-fx-border-color: black;-fx-border-radius: 2;-fx-font-size: 15px;");
            boxtel1.getChildren().addAll(tel1_tabel,tel1);
            boxtel1.setSpacing(20);

            HBox boxtel2 = new HBox();
            Label tel2_tabel = new Label("Téléphone 2");
            tel2_tabel.setStyle("-fx-text-fill: #000000; -fx-font-size: 18px;");
            tel2 = new TextField();
            tel2.setPrefHeight(30);
            tel2.setPrefWidth(180);
            tel2.setStyle("-fx-border-size: 2px;-fx-border-color: black;-fx-border-radius: 2;-fx-font-size: 15px;");
            boxtel2.getChildren().addAll(tel2_tabel,tel2);
            boxtel2.setSpacing(20);

            HBox ligne3 = new HBox();
            ligne3.getChildren().addAll(boxtel1,boxtel2);
            ligne3.setPadding(new Insets(50,0,0,30));
            ligne3.setSpacing(150);


            HBox boxetatciv = new HBox();
            Label etatcivil_label = new Label("État civil");
            etatcivil_label.setStyle("-fx-text-fill: #000000; -fx-font-size: 18px;");
            ObservableList<String> options =
                    FXCollections.observableArrayList(
                            "Célibataire",
                            "Marié",
                            "Veuf"
                    );
            etat_civil = new ComboBox<>(options);
            etat_civil.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #CCCCCC; -fx-border-width: 1px;-fx-font-size: 15px;");

            etat_civil.setPrefHeight(30);
            etat_civil.setPrefWidth(180);
            etat_civil.getSelectionModel().selectFirst();
            boxetatciv.getChildren().addAll(etatcivil_label,etat_civil);
            boxetatciv.setSpacing(52);
            boxetatciv.setPadding(new Insets(50,0,30,30));


            Label infopro = new Label("Informations Professionnelles");
            infopro.setStyle("-fx-font-size: 20; -fx-text-fill: rgb(78,110, 129);");
            infopro.setPadding(new Insets(10,0,0,30));

            HBox boxservices = new HBox();
            Label service_label = new Label("Service");
            service_label.setStyle("-fx-text-fill: #000000; -fx-font-size: 18px;");
            ObservableList<String> services = FXCollections.observableArrayList();

            ConnexionController cnx = new ConnexionController();
            String req = "SELECT  distinct(nom_service) FROM service";
            ResultSet rs = cnx.select(req);
            while (rs.next()) {
                services.add(rs.getString("nom_service"));
            }

            servicesList = new ComboBox<>(services);
            servicesList.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #CCCCCC; -fx-border-width: 1px;-fx-font-size: 15px;");
            servicesList.setPrefHeight(30);
            servicesList.setPrefWidth(180);
            servicesList.getSelectionModel().selectFirst();
            boxservices.getChildren().addAll(service_label,servicesList);
            boxservices.setSpacing(88);

            HBox boxsalaire= new HBox();
            Label salaire_label = new Label("Salaire Base");
            salaire_label.setStyle("-fx-text-fill: #000000; -fx-font-size: 18px;");
            salairebase = new TextField();
            salairebase.setPrefHeight(30);
            salairebase.setPrefWidth(180);
            salairebase.setStyle("-fx-border-size: 2px;-fx-border-color: black;-fx-border-radius: 2;-fx-font-size: 15px;");
            boxsalaire.getChildren().addAll(salaire_label,salairebase);
            boxsalaire.setSpacing(20);

            HBox ligne4 = new HBox();
            ligne4.getChildren().addAll(boxservices,boxsalaire);
            ligne4.setPadding(new Insets(50,0,0,30));
            ligne4.setSpacing(150);

            HBox boxrole= new HBox();
            boxrole.setMinWidth(300);
            boxrole.setPrefHeight(160);
            Label role_label = new Label("Rôle");
            role_label.setStyle("-fx-text-fill: #000000; -fx-font-size: 18px;");
            role = new ToggleGroup();

            dir = new RadioButton("Directeur");
            dir.setStyle("-fx-border-size: 2px;");
            dir.setToggleGroup(role);
            dir.setSelected(true);

            emp = new RadioButton("Employé");
            emp.setToggleGroup(role);

            boxrole.getChildren().addAll(role_label,dir, emp);
            boxrole.setSpacing(20);
            boxrole.setPadding(new Insets(50,0,30,30));

            Label infoacad = new Label("Informations Académiques");
            infoacad.setStyle("-fx-font-size: 20; -fx-text-fill: rgb(78,110, 129);");
            infoacad.setPadding(new Insets(10,0,0,30));


            HBox boxniv= new HBox();
            Label niv_label = new Label("Niveau");
            niv_label.setStyle("-fx-text-fill: #000000; -fx-font-size: 18px;");
            ObservableList<String> optionsniv =
                    FXCollections.observableArrayList(
                            "Sans Bac",
                            "Avec Bac",
                            "Technicien",
                            "Technicien Supérieur",
                            "Ingénieur"
                    );
            niveau = new ComboBox<>(optionsniv);
            niveau.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #CCCCCC; -fx-border-width: 1px;-fx-font-size: 15px;");

            niveau.setPrefHeight(30);
            niveau.setPrefWidth(180);
            niveau.getSelectionModel().selectFirst();
            boxniv.getChildren().addAll(niv_label,niveau);
            boxniv.setSpacing(52);

            HBox boxecole = new HBox();
            Label ecole_tabel = new Label("Ecole");
            ecole_tabel.setStyle("-fx-text-fill: #000000; -fx-font-size: 18px;");
            ecole = new TextField();
            ecole.setPrefHeight(30);
            ecole.setPrefWidth(180);
            ecole.setStyle("-fx-border-size: 2px;-fx-border-color: black;-fx-border-radius: 2;-fx-font-size: 15px;");
            boxecole.getChildren().addAll(ecole_tabel,ecole);
            boxecole.setSpacing(20);

            HBox ligne5 = new HBox();
            ligne5.getChildren().addAll(boxniv,boxecole);
            ligne5.setPadding(new Insets(50,0,80,30));
            ligne5.setSpacing(150);



            InputStream streamaddemp= new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\GestionRH\\src\\main\\images\\add.png");
            Image imageaddemp = new Image(streamaddemp);
            ImageView imageViewaddemp= new ImageView();
            //Setting image to the image view
            imageViewaddemp.setImage(imageaddemp);
            //Setting the image view parameters
            imageViewaddemp.setX(10);
            imageViewaddemp.setY(10);

            imageViewaddemp.setFitWidth(20);
            imageViewaddemp.setFitHeight(20);
            imageViewaddemp.setPreserveRatio(true);
            Group imgaddemp = new Group(imageViewaddemp);


            ajtEmp = new Button("AJOUTER");
            ajtEmp.setStyle("-fx-font: 16px 'Serif';-fx-text-fill:white;");


            HBox btnbox = new HBox();
            btnbox.getChildren().addAll(imgaddemp,ajtEmp);
            btnbox.setStyle("-fx-background-color:#7AA874 ;-fx-background-radius: 5px; -fx-border-radius: 5px;");
            btnbox.setPrefHeight(50);
            btnbox.setMaxWidth(130);
            btnbox.setAlignment(Pos.CENTER);
            btnbox.setSpacing(5);
            VBox.setMargin(btnbox, new Insets(40, 0, 20, 427));



            empajt.getChildren().add(ajtTitle);
            empajt.getChildren().add(infopers);
            empajt.getChildren().add(ligne1);
            empajt.getChildren().add(ligne2);
            empajt.getChildren().add(ligne3);
            empajt.getChildren().add(boxetatciv);
            empajt.getChildren().add(infopro);
            empajt.getChildren().add(ligne4);
            empajt.getChildren().add(boxrole);
            empajt.getChildren().add(infoacad);
            empajt.getChildren().add(ligne5);
            empajt.getChildren().add(btnbox);
            return scrollPane;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

}