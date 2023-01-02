package sge.proyectoerp.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

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
    private TableView<?> tableRecepciones;

    @FXML
    private Label nombreusuario;

    @FXML
    private TextField txtCantidad;

    @FXML
    private ImageView imgperfil;

    @FXML
    private Button btnCompras;

    @FXML
    private TableColumn<?, ?> HechoColum;

    @FXML
    private Button btnRecepciones;

    @FXML
    private Pane PanelInventarioInicial;

    @FXML
    private Pane PanelRecepciones;

    @FXML
    private Button btnFacturacion;

    //Variables nuevas


    @FXML
    void presscuenta() {

    }

    @FXML
    void pressMenu() {
        if (PanelMenuPrincipal.isVisible()) {
            PanelMenuPrincipal.setVisible(false);
        } else if (!PanelMenuPrincipal.isVisible()) {
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
        PanelMenuPrincipal.setVisible(false);
        PanelInventarioInicial.setVisible(true);
    }

    @FXML
    void pressbtfacturacion() {

    }

    @FXML
    void pressbtempleados() {

    }

    @FXML
    void pressRecepciones() {
        PanelInventarioInicial.setVisible(false);
        PanelRecepciones.setVisible(true);
    }

    @FXML
    void pressbtnExpediciones() {

    }

    @FXML
    void pressbtnDevoluciones() {

    }

    @FXML
    void pressbtncrearRecepciones() {

    }

    @FXML
    void selectInventario() {

    }

    @FXML
    void selectRecepciones() {

    }

    @FXML
    void pressbtnCrearRecepciones() {

    }

    @FXML
    void pressbtnRecepcionesAdd() {

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
        assert HechoColum != null : "fx:id=\"HechoColum\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnRecepciones != null : "fx:id=\"btnRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelInventarioInicial != null : "fx:id=\"PanelInventarioInicial\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelRecepciones != null : "fx:id=\"PanelRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnFacturacion != null : "fx:id=\"btnFacturacion\" was not injected: check your FXML file 'erp.fxml'.";

    }
}
