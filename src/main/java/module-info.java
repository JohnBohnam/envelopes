module com.example.envelopes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.envelopes to javafx.fxml;
    exports com.example.envelopes;
}