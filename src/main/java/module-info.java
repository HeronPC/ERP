module sge.proyectoerp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.swing;
    requires mysql.connector.java;


    opens sge.proyectoerp to javafx.fxml;
    exports sge.proyectoerp;
    exports sge.proyectoerp.Controllers;
    opens sge.proyectoerp.Controllers to javafx.fxml;
    opens sge.proyectoerp.Models to javafx.base;
}