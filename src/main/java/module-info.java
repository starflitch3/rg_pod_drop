module isep.jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens isep.jfx to javafx.fxml;
    exports isep.jfx;
}
