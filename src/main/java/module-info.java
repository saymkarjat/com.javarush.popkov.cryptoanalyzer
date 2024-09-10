module org.example.com_javarush_popkov_cryptoanalyzer {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.com_javarush_popkov_cryptoanalyzer to javafx.fxml;
    exports org.example.com_javarush_popkov_cryptoanalyzer;
}