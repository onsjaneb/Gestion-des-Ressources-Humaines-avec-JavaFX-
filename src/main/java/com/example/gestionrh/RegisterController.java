package com.example.gestionrh;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RegisterController implements EventHandler {
    Login app;
    Stage stage;

    public RegisterController(Login app, Stage stage) {
        this.app = app;
        this.stage = stage;
    }

    @Override
    public void handle(Event event){
        try{
            Register r = new Register();
            GridPane gp = r.registerinterface();
            Scene scene = new Scene(gp,850, 500);
            stage = new Stage();
            stage.setTitle("Créer un compte");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
            app.stage1.close();
            Button b = r.btncnx;
            b.setOnAction(new LoginController(this.app,this.stage));
        }catch (Exception e){
            System.out.println(e.getMessage());       }
    }



}
