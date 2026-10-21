module com.example.priimerproyecto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.priimerproyecto to javafx.fxml;
    exports com.example.priimerproyecto;
}