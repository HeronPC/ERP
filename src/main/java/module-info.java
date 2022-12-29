module sge.proyectoerp {
    requires javafx.controls;
    requires javafx.fxml;


    opens sge.proyectoerp to javafx.fxml;
    exports sge.proyectoerp;
    exports sge.proyectoerp.Controllers;
    opens sge.proyectoerp.Controllers to javafx.fxml;
}