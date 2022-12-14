module com.example.ninodimitriadi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ninodimitriadi to javafx.fxml;
    exports com.example.ninodimitriadi;
}