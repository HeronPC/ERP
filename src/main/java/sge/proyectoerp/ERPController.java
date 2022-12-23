package sge.proyectoerp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
public class ERPController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfprodi;

    @FXML
    private TableColumn<?, ?> CLProductoi;

    @FXML
    private Button btcuenta;

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private TextField tfcanti;

    @FXML
    private Button b4;

    @FXML
    private Button b5;

    @FXML
    private Button b6;

    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private TextField tfrdi;

    @FXML
    private Pane Precepciones;

    @FXML
    private Pane Menu;

    @FXML
    private TextField tfdoci;

    @FXML
    private Pane Pinventario;

    @FXML
    private DatePicker dpfpi;

    @FXML
    private Pane Psuperior;

    @FXML
    private TableColumn<?, ?> CLCantidadi;

    @FXML
    private TextField tfrefi;

    @FXML
    private Pane Pcrearrecepciones;

    @FXML
    private Label nombreusuario;

    @FXML
    private Pane Pmenu;

    @FXML
    private ImageView imgperfil;

    public ObservableList<Pane> paneles = FXCollections.observableArrayList();
    @FXML
    void btmenu(ActionEvent event) {
        for (int x=0;x< paneles.size();x++){
            paneles.get(x).setVisible(false);
        }
        Pmenu.setVisible(true);
    }
    @FXML
    void btventas(ActionEvent event) {

    }

    @FXML
    void btcompras(ActionEvent event) {

    }

    @FXML
    void btInventario(ActionEvent event) {
        Pmenu.setVisible(false);
        Pinventario.setVisible(true);
    }

    @FXML
    void btfacturacion(ActionEvent event) {

    }

    @FXML
    void btempleados(ActionEvent event) {

    }

    @FXML
    void btrecepciones(ActionEvent event) {
        Precepciones.setVisible(true);
        Pinventario.setVisible(false);
    }

    @FXML
    void btexpediciones(ActionEvent event) {

    }

    @FXML
    void btdevoluciones(ActionEvent event) {

    }
    @FXML
    void btadd(ActionEvent event) {

    }


    @FXML
    void btnuevo(ActionEvent event) {
        Pcrearrecepciones.setVisible(true);
        Precepciones.setVisible(false);
    }

    @FXML
    void btcrear(ActionEvent event) {

    }

    @FXML
    void initialize() {
        paneles.addAll(Pinventario,Precepciones,Pcrearrecepciones);
    }
}