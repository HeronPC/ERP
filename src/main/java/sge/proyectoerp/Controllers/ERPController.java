package sge.proyectoerp.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sge.proyectoerp.Models.Recepciones;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.time.LocalDate.parse;

public class ERPController {

    @FXML
    private Button btnCrearRecepciones;

    @FXML
    private TableColumn<?, ?> Documentocolumn;

    @FXML
    private Pane PanelMenuPrincipal;

    @FXML
    private TextField txtrecibir;

    @FXML
    private Button btnInventario;

    @FXML
    private TableColumn<?, ?> Estadocolumn;

    @FXML
    private Button btnEmpleados;

    @FXML
    private Button btcuenta;

    @FXML
    private Button btnExpediciones;

    @FXML
    private TextField txtDocumento;

    @FXML
    private Button btnVentas;

    @FXML
    private TableColumn<?, ?> contactocolumn;

    @FXML
    private TableView<?> tableInventario;

    @FXML
    private Pane Menu;

    @FXML
    private TableColumn<?, ?> ProductoColum;

    @FXML
    private Pane BarraSuperior;

    @FXML
    private Button btncrearRecepciones;

    @FXML
    private TableColumn<?, ?> Fechacolumn;

    @FXML
    private Button btnRecepcionesAdd;

    @FXML
    private Pane PanelAddRecepciones;

    @FXML
    private DatePicker dateReferencia;

    @FXML
    private TextField txtReferencia;

    @FXML
    private TableColumn<?, ?> Referenciacolumn;

    @FXML
    private TextField txtProducto;

    @FXML
    private Button btnmenu;

    @FXML
    private Button btnDevoluciones;

    @FXML
    private TableView<Recepciones> tableRecepciones;

    @FXML
    private Label nombreusuario;

    @FXML
    private TextField txtCantidad;

    @FXML
    private ImageView imgperfil;

    @FXML
    private Button btnCompras;

    @FXML
    private TableColumn<?, ?> CantidadColum;

    @FXML
    private Button btnRecepciones;

    @FXML
    private Pane PanelInventarioInicial;

    @FXML
    private Pane PanelRecepciones;

    @FXML
    private Button btnFacturacion;

    //Variables nuevas
    private Pane panelactual;

    private ArrayList<Recepciones> listrecepciones = new ArrayList<>();

    //Creamos la cadena con la que tenemos la direccion de la base de datos
    private final String cadconexion = "jdbc:mysql://localhost:3306/erp";

    private final String cadconexionps = "jdbc:mysql://localhost:3306/erp?useServerPrepStmts=true";
    //Esta variable tiene el usuario con el que nos conectaremos a la base de datos
    private final String user = "root";
    //Esta es la contraseña del usuario anterior para conectarnos a la base de datos
    private final String pswd = "root";

    //Lo usaremos para informar al usuario mediante ventanas emergentes, podemos establecer el mensaje pasándoselo por
    //parámetros
    void crearalertainfo(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    //Lo usaremos para informar al usuario de errores mediante ventanas emergentes, podemos establecer el mensaje
    //pasándoselo por parámetros
    void crearalertaerror(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


    @FXML
    void presscuenta() {

    }

    @FXML
    void pressMenu() {
        if(panelactual != PanelMenuPrincipal){
            if (PanelMenuPrincipal.isVisible()) {
                PanelMenuPrincipal.setVisible(false);
                panelactual.setVisible(true);
            } else if (!PanelMenuPrincipal.isVisible()) {
                PanelMenuPrincipal.setVisible(true);
                panelactual.setVisible(false);
            }
        } else {
            PanelMenuPrincipal.setVisible(true);
        }
    }

    @FXML
    void pressbtventas() {
    }

    @FXML
    void pressbtcompras() {

    }

    @FXML
    void pressbtInventario() {
        cambiarpanel(PanelMenuPrincipal, PanelInventarioInicial);
    }

    @FXML
    void pressbtfacturacion() {

    }

    @FXML
    void pressbtempleados() {

    }

    private void cambiarpanel(Pane panel1, Pane panel2){
        panel1.setVisible(false);
        panel2.setVisible(true);
        panelactual = panel2;
    }

    @FXML
    void pressRecepciones() {
        cambiarpanel(PanelInventarioInicial, PanelRecepciones);
    }

    @FXML
    void pressbtnExpediciones() {

    }

    @FXML
    void pressbtnDevoluciones() {

    }

    @FXML
    void pressbtncrearRecepciones() {
        cambiarpanel(PanelRecepciones, PanelAddRecepciones);
        dateReferencia.setValue(LocalDate.now());
        listrecepciones.clear();
    }

    @FXML
    void selectInventario() {

    }

    @FXML
    void selectRecepciones() {

    }

    @FXML
    void pressbtnCrearRecepciones() {
        //Creamos conexión null por si tuviéramos otra conexión cerrarla
        Connection conexion = null;
        //Ejecutamos dentro de un try para controlar todas las excepciones posibles
        try {
            //Creamos la conexión con la base de datos
            conexion = DriverManager.getConnection(cadconexionps, user, pswd);
            //Utilizamos un PreparedStatement para la consulta para mayor seguridad
            PreparedStatement ps = conexion.prepareStatement("insert into Recepciones values (?, ?, ?, ?, ?, ?)");
            ps.setString(1, txtReferencia.getText());
            ps.setString(2, txtrecibir.getText());

            //Parseamos la fecha
            String fecha = dateReferencia.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate localdate = parse(fecha);

            ps.setDate(3, Date.valueOf(localdate));
            ps.setString(4, txtDocumento.getText());
            ps.setString(5, txtProducto.getText());
            ps.setInt(6, Integer.parseInt(txtCantidad.getText()));

            //Creamos una ventana de confirmacion para la modificacion del ingreso
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmación");
            alert.setContentText("¿Está seguro de crear la recepcion de los productos? ");
            Optional<ButtonType> action = alert.showAndWait();
            //Comprobamos si el usuario ha presionado el boton Ok, si es asi, ejecutaremos los siguientes metodos
            if (action.orElseThrow() == ButtonType.OK) {
                ps.executeUpdate();
                crearalertainfo("Recepcion creada");
                cambiarpanel(PanelAddRecepciones, PanelRecepciones);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void pressbtnRecepcionesAdd() {
        //Parseamos la fecha
        String fecha = dateReferencia.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate localdate = parse(fecha);


        listrecepciones.add(new Recepciones(txtReferencia.getText(), txtrecibir.getText(), localdate,
                txtDocumento.getText(), txtProducto.getText(), Integer.parseInt(txtCantidad.getText())));

        tableRecepciones.getItems().removeAll();
        ObservableList<Recepciones> obsrec = FXCollections.observableArrayList();



        obsrec.setAll(listrecepciones);
        tableRecepciones.setItems(obsrec);
    }

    @FXML
    void initialize() {
        assert btnCrearRecepciones != null : "fx:id=\"btnCrearRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert Documentocolumn != null : "fx:id=\"Documentocolumn\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelMenuPrincipal != null : "fx:id=\"PanelMenuPrincipal\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtrecibir != null : "fx:id=\"txtrecibir\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnInventario != null : "fx:id=\"btnInventario\" was not injected: check your FXML file 'erp.fxml'.";
        assert Estadocolumn != null : "fx:id=\"Estadocolumn\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnEmpleados != null : "fx:id=\"btnEmpleados\" was not injected: check your FXML file 'erp.fxml'.";
        assert btcuenta != null : "fx:id=\"btcuenta\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnExpediciones != null : "fx:id=\"btnExpediciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtDocumento != null : "fx:id=\"txtDocumento\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnVentas != null : "fx:id=\"btnVentas\" was not injected: check your FXML file 'erp.fxml'.";
        assert contactocolumn != null : "fx:id=\"contactocolumn\" was not injected: check your FXML file 'erp.fxml'.";
        assert tableInventario != null : "fx:id=\"tableInventario\" was not injected: check your FXML file 'erp.fxml'.";
        assert Menu != null : "fx:id=\"Menu\" was not injected: check your FXML file 'erp.fxml'.";
        assert ProductoColum != null : "fx:id=\"ProductoColum\" was not injected: check your FXML file 'erp.fxml'.";
        assert BarraSuperior != null : "fx:id=\"BarraSuperior\" was not injected: check your FXML file 'erp.fxml'.";
        assert btncrearRecepciones != null : "fx:id=\"btncrearRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert Fechacolumn != null : "fx:id=\"Fechacolumn\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnRecepcionesAdd != null : "fx:id=\"btnRecepcionesAdd\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelAddRecepciones != null : "fx:id=\"PanelAddRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert dateReferencia != null : "fx:id=\"dateReferencia\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtReferencia != null : "fx:id=\"txtReferencia\" was not injected: check your FXML file 'erp.fxml'.";
        assert Referenciacolumn != null : "fx:id=\"Referenciacolumn\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtProducto != null : "fx:id=\"txtProducto\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnmenu != null : "fx:id=\"btnmenu\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnDevoluciones != null : "fx:id=\"btnDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert tableRecepciones != null : "fx:id=\"tableRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert nombreusuario != null : "fx:id=\"nombreusuario\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtCantidad != null : "fx:id=\"txtCantidad\" was not injected: check your FXML file 'erp.fxml'.";
        assert imgperfil != null : "fx:id=\"imgperfil\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnCompras != null : "fx:id=\"btnCompras\" was not injected: check your FXML file 'erp.fxml'.";
        assert CantidadColum != null : "fx:id=\"um\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnRecepciones != null : "fx:id=\"btnRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelInventarioInicial != null : "fx:id=\"PanelInventarioInicial\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelRecepciones != null : "fx:id=\"PanelRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnFacturacion != null : "fx:id=\"btnFacturacion\" was not injected: check your FXML file 'erp.fxml'.";

    }
}
