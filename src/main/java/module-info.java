module com.example.gestionrh {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.gestionrh to javafx.fxml;
    exports com.example.gestionrh;




}