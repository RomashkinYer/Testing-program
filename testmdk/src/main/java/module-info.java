module sample.testmdk {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample.testmdk to javafx.fxml;
    exports sample.testmdk;
}