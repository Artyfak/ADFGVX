module com.example.adfgx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.adfgx to javafx.fxml;
    exports com.example.adfgx;
}