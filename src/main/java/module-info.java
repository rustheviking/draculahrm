module com.virusoft.draculahrm {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.kordamp.bootstrapfx.core;
    requires java.persistence;
    requires org.hibernate.orm.core;

    opens com.virusoft.draculahrm.app to javafx.fxml;
    exports com.virusoft.draculahrm.app;
    opens com.virusoft.draculahrm.view.auth to javafx.fxml;
    opens com.virusoft.draculahrm.controller.auth to javafx.fxml;
    exports com.virusoft.draculahrm.controller.auth to javafx.fxml;
    opens com.virusoft.draculahrm.controller.dashboard to javafx.fxml;
    exports com.virusoft.draculahrm.controller.dashboard to javafx.fxml;
}