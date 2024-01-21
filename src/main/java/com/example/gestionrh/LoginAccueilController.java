package com.example.gestionrh;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginAccueilController implements EventHandler<MouseEvent> {
    Login app;
    Stage stage;

    public LoginAccueilController(Login app, Stage stage) {
        this.app = app;
        this.stage = stage;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        app = new Login();
        try {
            app.start(stage);
            this.stage.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}