package com.example.gestionrh;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController implements EventHandler {
    Login app;
    Stage stage;

    public LoginController(Login app, Stage stage) {
        this.app = app;
        this.stage = stage;
    }

    @Override
    public void handle(Event event) {
        app = new Login();
        try {
            app.start(stage);
            this.stage.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}