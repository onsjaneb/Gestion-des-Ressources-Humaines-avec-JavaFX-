package com.example.gestionrh;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainEmp {
    public Label nbemp, nbLabel, nbdirLabel,  nbempLabel;
    Image imagetot,imagedir;
    public ObservableList<Employe> data;
    public TableView<Employe> tableEmploye;
    public  TextField searchField = new TextField();

    public Group imgtot;
    public HBox nbtot;
    public VBox tot;
    public Login app;
    public Stage stage;
    public Button ajoutEmp;
    public ScrollPane EmployeMain()  {
        try {
            VBox contot = new VBox();
            ScrollPane mainscroll = new ScrollPane();
            mainscroll.setContent(contot);
            HBox card = new HBox();

            nbtot = new HBox();
            tot = new VBox();

            InputStream streamtot = new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\GestionRH\\src\\main\\images\\sum.png");
            imagetot = new Image(streamtot);
            ImageView imageViewtot = new ImageView();
            //Setting image to the image view
            imageViewtot.setImage(imagetot);
            //Setting the image view parameters
            imageViewtot.setX(10);
            imageViewtot.setY(10);

            imageViewtot.setFitWidth(25);
            imageViewtot.setFitHeight(25);
            imageViewtot.setPreserveRatio(true);
            imgtot= new Group(imageViewtot);
            nbtot.getChildren().addAll(nbemp,imgtot);

            nbLabel = new Label("Nombre Totale");
            nbLabel.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:16px;-fx-text-fill:white");
            nbLabel.setPadding(new Insets(5,0,5,0));

            tot.getChildren().addAll(nbLabel,nbtot);
            tot.setPrefHeight(75);
            tot.setPrefWidth(290);
            tot.setBackground(new Background(new BackgroundFill(Color.rgb(78,110, 129), null, null)));
            tot.setPadding(new Insets(0,0,0,10));


            HBox nbdir = new HBox();
            InputStream streamdir = new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\GestionRH\\src\\main\\images\\owner.png");
            imagedir = new Image(streamdir);
            ImageView imageViewdir = new ImageView();
            //Setting image to the image view
            imageViewdir.setImage(imagedir);
            //Setting the image view parameters
            imageViewdir.setX(10);
            imageViewdir.setY(10);

            imageViewdir.setFitWidth(25);
            imageViewdir.setFitHeight(25);
            imageViewdir.setPreserveRatio(true);
            Group imgdir= new Group(imageViewdir);


            nbdir.getChildren().addAll(nbdirLabel,imgdir);
            Label nbdirs = new Label("Nombre des Directeurs");
            nbdirs.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:16px;-fx-text-fill:white");
            nbdirs.setPadding(new Insets(5,0,5,0));
            VBox directeurs = new VBox();

            directeurs.setPrefHeight(75);
            directeurs.setPrefWidth(290);
            directeurs.setBackground(new Background(new BackgroundFill(Color.rgb(78,110, 129), null, null)));
            directeurs.setPadding(new Insets(0,0,0,10));
            directeurs.getChildren().addAll(nbdirs,nbdir);

            HBox nbemp = new HBox();
            InputStream streamemp = new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\GestionRH\\src\\main\\images\\employees.png");
            Image imageemp= new Image(streamemp);
            ImageView imageViewemp = new ImageView();
            //Setting image to the image view
            imageViewemp.setImage(imageemp);
            //Setting the image view parameters
            imageViewemp.setX(10);
            imageViewemp.setY(10);

            imageViewemp.setFitWidth(25);
            imageViewemp.setFitHeight(25);
            imageViewemp.setPreserveRatio(true);
            Group imgemp= new Group(imageViewemp);


            nbemp.getChildren().addAll(nbempLabel,imgemp);
            Label nbemps = new Label("Nombre des Employés");
            nbemps.setStyle("-fx-font-family:'Gill Sans';-fx-font-size:16px;-fx-text-fill:white");
            nbemps.setPadding(new Insets(5,0,5,0));
            VBox employes = new VBox();

            employes.setPrefHeight(75);
            employes.setPrefWidth(290);
            employes.setBackground(new Background(new BackgroundFill(Color.rgb(78,110, 129), null, null)));
            employes.setPadding(new Insets(0,0,0,10));
            employes.getChildren().addAll(nbemps,nbemp);


            card.getChildren().addAll(tot,directeurs,employes);
            card.setSpacing(55);
            card.setAlignment(Pos.CENTER);
            contot.getChildren().add(card);

            Label liste = new Label("Liste");
            liste.setStyle("-fx-font-size: 33");
            liste.setPadding(new Insets(6,0,0,0));
            Label lstEmp = new Label("Des Employés");
            lstEmp.setStyle("-fx-font-size: 40");
            HBox lstTitle = new HBox();
            lstTitle.getChildren().addAll(liste,lstEmp);
            lstTitle.setSpacing(13);
            lstTitle.setPadding(new Insets(30,0,0,30));


            InputStream streamplus= new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\GestionRH\\src\\main\\images\\add.png");
            Image imageplus = new Image(streamplus);
            ImageView imageViewplus= new ImageView();
            //Setting image to the image view
            imageViewplus.setImage(imageplus);
            //Setting the image view parameters
            imageViewplus.setX(10);
            imageViewplus.setY(10);

            imageViewplus.setFitWidth(20);
            imageViewplus.setFitHeight(20);
            imageViewplus.setPreserveRatio(true);
            Group imgplus = new Group(imageViewplus);


            ajoutEmp = new Button("AJOUTER UN EMPLOYÉ");
            ajoutEmp.setStyle("-fx-font: 16px 'Serif';-fx-text-fill:white;");


            HBox btnbox = new HBox();
            btnbox.getChildren().addAll(imgplus,ajoutEmp);
            btnbox.setStyle("-fx-background-color:#7AA874 ;-fx-background-radius: 5px; -fx-border-radius: 5px;");
            btnbox.setMaxHeight(40);
            btnbox.setPrefWidth(225);
            btnbox.setAlignment(Pos.CENTER);
            btnbox.setSpacing(5);
            HBox.setMargin(btnbox, new Insets(40, 0, 0, 427));

            HBox lignelst = new HBox();
            lignelst.getChildren().addAll(lstTitle,btnbox);
            contot.getChildren().add(lignelst);

            searchField.setPromptText("Rechercher un employe");
            searchField.textProperty().addListener((Observable obs) -> rechercher());


            InputStream streamsearch= new FileInputStream("C:\\Users\\Asus\\IdeaProjects\\GestionRH\\src\\main\\images\\search.png");
            Image imagesearch = new Image(streamsearch);
            ImageView imageViewsearch= new ImageView();
            //Setting image to the image view
            imageViewsearch.setImage(imagesearch);
            //Setting the image view parameters
            imageViewsearch.setX(10);
            imageViewsearch.setY(10);

            imageViewsearch.setFitWidth(20);
            imageViewsearch.setFitHeight(20);
            imageViewsearch.setPreserveRatio(true);
            Group imgsaerch = new Group(imageViewsearch);

            HBox search = new HBox();
            search.setMaxWidth(220);
            search.setSpacing(40);
            search.setPadding(new Insets(2,0,0,5));
            search.setStyle("-fx-border-radius: 10px; -fx-border-width: 2px; -fx-border-color: #4E6E81;");
            VBox.setMargin(search, new Insets(10, 0, 0, 785));
            search.getChildren().addAll(searchField,imgsaerch);

            contot.getChildren().add(search);

            tableEmploye  = new TableView<Employe>();
            initTableView();

            contot.getChildren().add(tableEmploye);



            return mainscroll;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }



    public void initTableView() throws SQLException {
        try {
            ConnexionController cnx = new ConnexionController();
            String req = "SELECT employe.id, employe.cin, employe.nom, employe.prenom, employe.tel1, employe.tel2, employe.salaire_base, employe.role, service.nom_service FROM employe INNER JOIN service ON employe.id_service = service.id_service";

            ResultSet rs = cnx.select(req);

            List<String> listeColumns = new ArrayList<>();
            listeColumns.add("Id");
            listeColumns.add("CIN");
            listeColumns.add("Prénom");
            listeColumns.add("Nom");
            listeColumns.add("Téléphone 1");
            listeColumns.add("Téléphone 2");
            listeColumns.add("Salaire");
            listeColumns.add("Rôle");
            listeColumns.add("Service");
            listeColumns.add("Action");

            listeColumns.forEach(colonne -> {
                TableColumn<Employe, String> tc = new TableColumn<>(colonne);
                if (colonne.equals("Id")){
                    tc.setCellValueFactory(new PropertyValueFactory<>("id"));
                }
                else if (colonne.equals("CIN")){
                    tc.setCellValueFactory(new PropertyValueFactory<>("cin"));
                }
                else if (colonne.equals("Prénom")){
                    tc.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                }
                else if (colonne.equals("Nom")){
                    tc.setCellValueFactory(new PropertyValueFactory<>("nom"));
                }
                else if (colonne.equals("Téléphone 1")){
                    tc.setCellValueFactory(new PropertyValueFactory<>("tel1"));
                }
                else if (colonne.equals("Téléphone 2")){
                    tc.setCellValueFactory(new PropertyValueFactory<>("tel2"));
                }
                else if (colonne.equals("Salaire")) {
                    tc.setCellValueFactory(new PropertyValueFactory<>("salaire_base"));
                }
                else if (colonne.equals("Rôle")) {
                    tc.setCellValueFactory(new PropertyValueFactory<>("role"));
                }
                else if (colonne.equals("Service")) {
                    tc.setCellValueFactory(new PropertyValueFactory<>("nom_service"));
                }
                tc.setStyle("-fx-font-size: 15px;");
                tableEmploye.getColumns().add(tc);
            });

            data = FXCollections.observableArrayList();

            while (rs.next()) {
                String id = rs.getString("id");
                String cin = rs.getString("cin");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String tel1 = rs.getString("tel1");
                String tel2 = rs.getString("tel2");
                Double salaire = rs.getDouble("salaire_base");
                String role = rs.getString("role");
                String service = rs.getString("nom_service");

                data.add(new Employe(id, cin, nom, prenom, tel1, tel2, salaire, role, service));
            }


            tableEmploye.setTableMenuButtonVisible(false);
            ObservableList<Employe> employes = FXCollections.observableArrayList(data);
            tableEmploye.setItems(employes);
            tableEmploye.setFixedCellSize(50); // hauteur fixe d'une cellule
            tableEmploye.prefHeightProperty().bind(Bindings.size(employes).multiply(tableEmploye.getFixedCellSize()).add(50)); // hauteur totale de la table = hauteur d'une cellule * nombre de cellules + 30 pixels de marge


            tableEmploye.setStyle("-fx-padding: 30 0 0 30;");


// Style des en-têtes de colonnes
            tableEmploye.getColumns().forEach(col -> {
                col.setMinWidth(100);
                col.setMaxWidth(200);
            });


            tableEmploye.setPrefWidth(400);


        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void rechercher() {
        String searchTerm = searchField.getText().toLowerCase().trim();
        if (searchTerm.isEmpty()) {
            tableEmploye.setItems(data);
        } else {
            ObservableList<Employe> filteredList = FXCollections.observableArrayList();
            for (Employe employe : data) {
                String[] fullName = (employe.getNom() + " " + employe.getPrenom()).toLowerCase().split(" ");
                boolean found = true;
                boolean match = false;
                if(searchTerm.contains(" ")) {
                    for (String term : searchTerm.split(" ")) {

                        boolean columnMatch = false;
                        for (String namePart : fullName) {
                            if (namePart.startsWith(term)) {
                                columnMatch = true;
                                break;
                            }
                        }
                        if (!columnMatch) {
                            if (employe.getId().contains(term)
                                    || employe.getCin().toLowerCase().contains(term)
                                    || employe.getTel1().toLowerCase().contains(term)
                                    || employe.getTel2().toLowerCase().contains(term)
                                    || Double.toString(employe.getSalaire_base()).equals(searchTerm)
                                    || employe.getRole().toLowerCase().contains(term)
                                    || employe.getNom_service().toLowerCase().contains(term)) {
                                columnMatch = true;
                            }
                        }
                        if (!columnMatch) {
                            found = false;
                            break;
                        }
                    }
                }
                else {
                    if (employe.getNom().toLowerCase().contains(searchTerm)
                            || employe.getPrenom().toLowerCase().contains(searchTerm)
                            || employe.getId().toLowerCase().contains(searchTerm)
                            || employe.getCin().toLowerCase().contains(searchTerm)
                            || employe.getTel1().toLowerCase().contains(searchTerm)
                            || employe.getTel2().toLowerCase().contains(searchTerm)
                            || Double.toString(employe.getSalaire_base()).equals(searchTerm)
                            || employe.getRole().toLowerCase().contains(searchTerm)
                            || employe.getNom_service().toLowerCase().contains(searchTerm)) {
                        match = true;
                    }
                    if (!match) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    filteredList.add(employe);
                }
            }
            tableEmploye.setItems(filteredList);
        }
    }



}
