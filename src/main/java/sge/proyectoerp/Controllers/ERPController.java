package sge.proyectoerp.Controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sge.proyectoerp.ERPApplication;
import sge.proyectoerp.Models.Devoluciones;
import sge.proyectoerp.Models.Expediciones;
import sge.proyectoerp.Models.Recepciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import static java.time.LocalDate.parse;

public class ERPController {

    @FXML
    private Button btnCrearRecepciones;

    @FXML
    private TableColumn<?, ?> CantidadColum;

    @FXML
    private ImageView imgempleado1;

    @FXML
    private TableView<Recepciones> tableInventarioRecep;

    @FXML
    private Pane PanelExpediciones;

    @FXML
    private Button btcuenta;

    @FXML
    private Button btnExpediciones;

    @FXML
    private TextField txtTelefonoEmpleado;

    @FXML
    private Label lblAtrasRecepciones;

    @FXML
    private Button btnDevolucionesAdd;

    @FXML
    private TableColumn<?, ?> ColumProductDevoluciones;

    @FXML
    private TextField txtCantidadDevoluciones;

    @FXML
    private Pane PanelEmpleados;

    @FXML
    private TextField txtDocumento212131;

    @FXML
    private TableColumn<?, ?> Fechacolumn;

    @FXML
    private DatePicker dateReferencia;

    @FXML
    private TextField txtReferencia;

    @FXML
    private Button btnAddDevoluciones;

    @FXML
    private Button btnSeleccionarIMGEditarEmpleado;

    @FXML
    private TextField txtDepartamentoEmpleado;

    @FXML
    private TextField txtCantidadExp;

    @FXML
    private TableView<Recepciones> tableRecepciones;

    @FXML
    private GridPane Pempleados;

    @FXML
    private TextField txtDireccionLaboralEmpleado;

    @FXML
    private TableColumn<?, ?> ColumProductoExpedic;

    @FXML
    private ImageView imgperfil11211;

    @FXML
    private TextField txtCantidad;

    @FXML
    private ImageView imgempleado;

    @FXML
    private ImageView imgperfil;

    @FXML
    private Pane PanelEditEmpleados;

    @FXML
    private Pane PanelInventarioInicial;

    @FXML
    private TableColumn<Expediciones, LocalDate> ColumExpFecha;

    @FXML
    private TextField txtNombreEmpleado;

    @FXML
    private TextField txtGerenteEditarEmpleado;

    @FXML
    private Button btnEmpleados;

    @FXML
    private Pane PanelAddDevoluciones;

    @FXML
    private Button btnSeleccionarIMG;

    @FXML
    private TableColumn<Expediciones, String> ColumExpEstado;

    @FXML
    private DatePicker dateReferencia2;

    @FXML
    private DatePicker DateExpediciones;

    @FXML
    private DatePicker dateReferencia21;

    @FXML
    private TextField txtDocumento212111;

    @FXML
    private Pane Menu;

    @FXML
    private Button btncrearRecepciones;

    @FXML
    private Button btnRecepcionesAdd;

    @FXML
    private Pane PanelAddRecepciones;

    @FXML
    private TextField txtDocExp;

    @FXML
    private Button btnEditarEmpleados;

    @FXML
    private TableColumn<?, ?> Referenciacolumn;

    @FXML
    private TableView<?> tableDepartamentos;

    @FXML
    private TableView<Expediciones> TableExpediciones;

    @FXML
    private TextField txtHorasSemanalesEditarEmpleado;

    @FXML
    private TextField txtProductoDevoluciones;

    @FXML
    private Button btnCrearDevoluciones;

    @FXML
    private Button btnVolverEmpEdit;

    @FXML
    private TextField txtTelefonoEditarEmpleado;

    @FXML
    private TableView<Expediciones> tablaExp;

    @FXML
    private Label lblnombreusuario;

    @FXML
    private TextField txtemailEmpleado;

    @FXML
    private Button btnExpAdd;

    @FXML
    private TableView<?> tableDevoluciones;

    @FXML
    private Button btnCompras;

    @FXML
    private ImageView imgperfil113;

    @FXML
    private TextField txtDocumento212121;

    @FXML
    private Pane PanelRecepciones;

    @FXML
    private ImageView imgperfil111;

    @FXML
    private ImageView imgperfil112;

    @FXML
    private TableColumn<?, ?> ColumDocDevoluciones;

    @FXML
    private Pane PanelMenuPrincipal;

    @FXML
    private TextField txtemailEditarEmpleado;

    @FXML
    private TableColumn<?, ?> Estadocolumn;

    @FXML
    private Pane PanelDevoluciones;

    @FXML
    private TableColumn<?, ?> ColumRefDevoluciones;

    @FXML
    private TextField txtDocumento;

    @FXML
    private Button btnVentas;

    @FXML
    private ImageView imgperfil1122;

    @FXML
    private TableView<Devoluciones> TableDevoluciones;

    @FXML
    private ImageView imgperfil1121;

    @FXML
    private TableColumn<?, ?> contactocolumn;

    @FXML
    private TableColumn<?, ?> ProductoColum;

    @FXML
    private Pane BarraSuperior;

    @FXML
    private Button btnVolverExpediciones;

    @FXML
    private DatePicker dateDevoluciones;

    @FXML
    private TextField txtGerenteEmpleado;

    @FXML
    private TableColumn<?, ?> ColumCantidadExpedic;

    @FXML
    private Button btnDevoluciones;

    @FXML
    private Button btnCrearExpediciones;

    @FXML
    private TextField txtRecibirDevoluciones;

    @FXML
    private TextField txtHorasSemanaEmpleado;

    @FXML
    private TableColumn<?, ?> ColumCantidadDevoluciones;

    @FXML
    private TextField txtNombreEditEmpleado;

    @FXML
    private TableColumn<?, ?> ColumFechaDevoluciones;

    @FXML
    private TableColumn<?, ?> ColumContacDevoluciones;

    @FXML
    private TextField txtDocDevoluciones;

    @FXML
    private Button btnVolverEmpNuevo;

    @FXML
    private TextField txtPuestoEditarEmpleado;

    @FXML
    private TextField txtDocumento21213;

    @FXML
    private TableColumn<?, ?> Documentocolumn;

    @FXML
    private Button btnVolverRecepNew;

    @FXML
    private TextField txtDocumento21212;

    @FXML
    private TextField txtReferenciaExpediciones;

    @FXML
    private TextField txtrecibir;

    @FXML
    private Button btnInventario;

    @FXML
    private Button btnVolverRecepciones;

    @FXML
    private Button btnVolverDevolNew;

    @FXML
    private TableColumn<Expediciones, String> ColumExpReferencia;

    @FXML
    private TextField txtDocumentoEditarEmpleado;

    @FXML
    private Label txtidpagina;

    @FXML
    private Button btncrearExpediciones;

    @FXML
    private TableColumn<Expediciones, String> ColumContExpediciones;

    @FXML
    private Button btnVolverDevoluciones;

    @FXML
    private TextField txtDocumento21211;

    @FXML
    private TextField txtdireccionLaboralEditarEmpleado;

    @FXML
    private TextField txtPuestodetrabajo;

    @FXML
    private ImageView imgperfil11;

    @FXML
    private TextField txtProducto;

    @FXML
    private Button btnmenu;

    @FXML
    private Button btnCrearEmpleados;

    @FXML
    private TableColumn<?, ?> ColumEstadoDevoluciones;

    @FXML
    private TextField txt6;

    @FXML
    private ImageView imgperfil1131;

    @FXML
    private Pane PanelAddExpediciones;

    @FXML
    private TextField txtdireccionExpediciones;

    @FXML
    private TextField txt5;

    @FXML
    private Pane PanelAddEmpleados;

    @FXML
    private Button btnRecepciones;

    @FXML
    private TextField txtProductoExp;

    @FXML
    private TableColumn<Expediciones, String> ColumExpDoc;

    @FXML
    private Button btnFacturacion;

    @FXML
    private Pane BarraSuperior1;

    @FXML
    private ImageView imgperfil1;

    @FXML
    private Pane Pperfil;

    @FXML
    private Button btaddbd;

    @FXML
    private Pane Pnewbd;

    @FXML
    private GridPane Pgridbd;

    @FXML
    private TextField txtnombd;

    @FXML
    private Button btcuenta1;

    @FXML
    private Button btaddbd11;

    @FXML
    private ImageView imgperfil12;

    @FXML
    private Button btaddbd1;

    @FXML
    private Label txtidpagina1;

    @FXML
    private Label lblAtrasExp;

    @FXML
    private Pane Pbasesdedatos;

    @FXML
    private Button btacceder;

    @FXML
    private Pane PInicio;

    @FXML
    private TextField txtusuario;

    @FXML
    private TextField txtcontrasena;

    @FXML
    private ImageView imgperfil1111;

    @FXML
    private TextField txtcontrasena12;

    @FXML
    private TextField txtcontrasena11;

    @FXML
    private TextField txtcontrasena1;

    @FXML
    private TextField txtcontrasena13;

    @FXML
    private Pane PRegistro;

    @FXML
    private TextField txtusuario1;

    @FXML
    private Button btcuenta1111;

    //Variables nuevas
    private Pane panelactual;

    private ArrayList<Recepciones> listrecepciones = new ArrayList<>();
    private final ArrayList<Expediciones> listexpediciones = new ArrayList<>();
    private final ArrayList<Devoluciones> listdevoluciones = new ArrayList<>();


    //CAMBIOS
    ERPApplication app = new ERPApplication();

    Stage stagere = new Stage();
    @FXML
    public void pressregistro(ActionEvent event) throws IOException {
        URL url = Paths.get("./src/main/resources/sge/proyectoerp/register.fxml").toUri().toURL();
        Pane root = FXMLLoader.load(url);
        Scene scene= new Scene(root, 1068, 700);
        stagere.setScene(scene);
        stagere.centerOnScreen();
        stagere.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    Stage stagebd = new Stage();
    String usuario;
    @FXML
    public void pressbtnacceder(ActionEvent event) throws IOException {
        setUser();
        URL url = Paths.get("./src/main/resources/sge/proyectoerp/bd.fxml").toUri().toURL();
        Pane root = FXMLLoader.load(url);
        Scene scene= new Scene(root, 1068, 700);
        stagebd.setScene(scene);
        stagebd.centerOnScreen();
        stagebd.initStyle(StageStyle.DECORATED);
        stagebd.initStyle(StageStyle.TRANSPARENT);
        stagebd.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        Label myLabel = (Label) root.lookup("#lblnombreusuario");
        myLabel.setText(setUser());
    }
    public String setUser(){
        usuario = txtusuario.getText();
        return usuario;
    };
    @FXML
    public void pressbtnregistrarse(){

    }
    @FXML
    public void pressaddbd(){
        txtnombd.setText(null);
        Pnewbd.setVisible(true);

    }
    String nombd;
    Stage stageerp = new Stage();

    @FXML
    public void pressbtnewbd(){
        Pnewbd.setVisible(false);
        nombd = txtnombd.getText();
        SwingNode node2 = new SwingNode();
        JPanel Panelbd = new JPanel(new BorderLayout());//Creamos el panel que se va a añadir multiples veces
        JPanel Panelizq = new JPanel(new FlowLayout(FlowLayout.CENTER,10,3));
        Panelizq.setBackground(new java.awt.Color(41, 45, 45));
        Panelizq.setSize(100,30);
        Panelbd.setBorder(new EmptyBorder(40, 30, 30, 30));
        Panelbd.setBackground(new java.awt.Color(41, 45, 45));
        JLabel nombrebd = new JLabel(nombd);//Aqui aparecerá el nombre de los empleados con respecto a la base de datos
        nombrebd.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        nombrebd.setForeground (Color.white);
        JButton btel = new JButton();
        btel.setBackground(new java.awt.Color(41, 45, 45));
        ImageIcon iconoeliminar= new ImageIcon("src/main/resources/sge/proyectoerp/img/eliminar.png");
        java.awt.Image newimgeliminar = iconoeliminar.getImage().getScaledInstance(7, 7,  java.awt.Image.SCALE_SMOOTH);
        iconoeliminar = new ImageIcon(newimgeliminar);
        btel.setIcon(iconoeliminar);
        JButton btentrar = new JButton("Acceder");
        btentrar.setBackground(new java.awt.Color(41, 184, 78));
        Panelizq.add(btel);
        Panelizq.add(nombrebd);
        Panelbd.add(Panelizq,BorderLayout.WEST);
        Panelbd.add(btentrar,BorderLayout.EAST);
        btel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent el) {
                //Metodo para eliminar las base de datos añadidas en el usuario, para eliminarlas deberas hacer un delete a la base de datos y luego llamar al metodo para que recarge los paneles de las base de datos
            }
        });

        btentrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e){
                Platform.runLater(new Runnable() {
                    public void run() {
                        try {
                            URL url = Paths.get("./src/main/resources/sge/proyectoerp/erp.fxml").toUri().toURL();
                            Pane root = FXMLLoader.load(url);
                            Scene scene= new Scene(root, 1536, 790);
                            stageerp.setScene(scene);
                            stageerp.centerOnScreen();
                            stageerp.setMaximized(true);
                            stageerp.show();
                            Pane myPanel = (Pane) root.lookup("#PanelMenuPrincipal");
                            myPanel.setMaxSize(1500,790);
                            Label myLabel = (Label) root.lookup("#lblnombreusuario");
                            usuario = lblnombreusuario.getText();
                            myLabel.setText(usuario);
                        } catch (MalformedURLException ex) {
                            throw new RuntimeException(ex);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
            }
        });
        node2.setContent(Panelbd);//Añade el contenido al nodeswing
        node2.setId("node"+nombd);//Cambia el nombre del nodo con respecto al nombre del empleado, deberas hacer que cambie con los nombres que vaya cogiendo de la base de datos
        Pgridbd.add(node2,cols,filas);//Va añadiendo los nodeswing al gridpane sumando filas y columnas
        filas++;
        if(filas==4){btaddbd.setDisable(true);}//debes deshabilitar el método cuandotodo el gripane esta lleno
        counter++;
    }


    @FXML
    public void presscerrar(){
        txtnombd.setText(null);
        Pnewbd.setVisible(false);
    }
    public String bd = "erp";
    //CAMBIOS

    //Creamos la cadena con la que tenemos la direccion de la base de datos
    private final String cadconexion = String.format("jdbc:mysql://localhost:3306/%s",bd);

    private final String cadconexionps = "jdbc:mysql://localhost:3306/erp?useServerPrepStmts=true";
    //Esta variable tiene el usuario con el que nos conectaremos a la base de datos
    private final String user = "root";
    //Esta es la contraseña del usuario anterior para conectarnos a la base de datos
    private final String pswd = "root";

    //Debes crear otro método que añada los distintos departamentos que se vayan creando en la base de datos y se rellenen los gridlayout de los distintos departamentos
    int counter = 0;
    int filas = 0;
    int cols = 0;

    Stage selec = new Stage();
    String referenciaactual;

    // create a File chooser
    FileChooser fil_chooser = new FileChooser();
    String image;
    Image imagenem;

    //Obtiene la imagen a la hora de crear un empleado
    @FXML
    void seleccionarimg(){
        // Agregar filtros para facilitar la busqueda
        fil_chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        // Obtener la imagen seleccionada
        File file = fil_chooser.showOpenDialog(selec);
        // Mostar la imagen
        if (file != null) {
            image = file.getPath();
            imagenem = new Image(image);
            imgempleado.setImage(imagenem);
        }
    }
    //Metodo que crea los paneles de cada empleado

    @FXML
    void pressbtnCrearEmpleados() {
        cambiarpanel(panelactual,PanelEmpleados);
        String nomempleado = String.valueOf(txtNombreEmpleado.getText());//Esto es una mera prueba para que obtenga el nombre del ultimo empleado añadido, deberas cambiarlo para que obtenga el de la base de datos
        SwingNode node = new SwingNode();
        JPanel newpane = new JPanel(new BorderLayout());//Creamos el panel que se va a añadir multiples veces
        newpane.setBorder(new EmptyBorder(10, 10, 10, 10));
        newpane.setBackground(new java.awt.Color(41, 45, 45));
        JLabel nombreempleado = new JLabel(nomempleado);//Aqui aparecerá el nombre de los empleados con respecto a la base de datos
        nombreempleado.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        nombreempleado.setForeground (Color.white);
        JLabel imagen = new JLabel();
        imagen.setBorder(new EmptyBorder(10, 10, 10, 10));
        ImageIcon icono= new ImageIcon(image);//establece la dirección url de la imagen de perfil del empleado, debera cambiar respecto a la base de datos
        java.awt.Image newimg = icono.getImage().getScaledInstance(54, 61,  java.awt.Image.SCALE_SMOOTH);//Redimensiona la imagen
        icono = new ImageIcon(newimg);
        imagen.setIcon(icono);
        JPanel btpane = new JPanel(new GridLayout(2,1));
        JButton bteliminar = new JButton();
        bteliminar.setBackground(new java.awt.Color(41, 45, 45));
        ImageIcon iconoeliminar= new ImageIcon("src/main/resources/sge/proyectoerp/img/eliminar.png");
        java.awt.Image newimgeliminar = iconoeliminar.getImage().getScaledInstance(7, 7,  java.awt.Image.SCALE_SMOOTH);
        iconoeliminar = new ImageIcon(newimgeliminar);
        bteliminar.setIcon(iconoeliminar);
        JButton bteditar = new JButton();
        bteditar.setBackground(new java.awt.Color(41, 45, 45));
        ImageIcon iconoeditar = new ImageIcon("src/main/resources/sge/proyectoerp/img/lapiz.png");
        java.awt.Image newimgeditar = iconoeditar.getImage().getScaledInstance(7, 7,  java.awt.Image.SCALE_SMOOTH);
        iconoeditar = new ImageIcon(newimgeditar);
        bteditar.setIcon(iconoeditar);
        btpane.add(bteliminar);
        btpane.add(bteditar);
        bteditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ed) {
                cambiarpanel(PanelEmpleados,PanelEditEmpleados);
            }
        });
        bteliminar.addActionListener(e -> {
            //pressbtnCrearEmpleados();
            //Eliminar de la base de datos el nombre de la persona que es el id el boton pulsado y usar la funcion para que se vuelva a rellenar el gridpane
        });
        //Establecemos la posicion en el panel de cada objeto
        newpane.add(btpane, BorderLayout.EAST);
        newpane.add(imagen,BorderLayout.WEST);
        newpane.add(nombreempleado,BorderLayout.CENTER);
        newpane.setVisible(true);
        bteditar.setName("bted"+txtNombreEmpleado.getText());
        bteliminar.setName("btel"+txtNombreEmpleado.getText());//Debe obtener el nombre de cada empleado de la bse de datos para su posterior eliminacion
        newpane.setName("panel"+counter);//El nombre de cada panel sera panel+numero de panel
        node.setContent(newpane);//Añade el contenido al nodeswing
        node.setId("node"+nomempleado);//Cambia el nombre del nodo con respecto al nombre del empleado, deberas hacer que cambie con los nombres que vaya cogiendo de la base de datos
        Pempleados.add(node,cols,filas);//Va añadiendo los nodeswing al gridpane sumando filas y columnas
        if(cols==4){
            cols=-1;
            filas++;
        }
        if(filas==5 && cols==5){

        }//debes deshabilitar el método cuandotodo el gripane esta lleno
        cols++;
        counter++;
    }
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
        Pperfil.setVisible(true);
    }
    @FXML
    void cerrarperfil() {
        Pperfil.setVisible(false);
    }
    @FXML
    void presslogout(ActionEvent event){
        ((Node)(event.getSource())).getScene().getWindow().hide();
        app.start(new Stage());
    }
    @FXML
    void presscerrarbd(ActionEvent event){
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void pressMenu() {
        if (panelactual != PanelMenuPrincipal) {
            if (PanelMenuPrincipal.isVisible()) {
                PanelMenuPrincipal.setVisible(false);
                panelactual.setVisible(true);
            } else if (!PanelMenuPrincipal.isVisible()) {
                PanelMenuPrincipal.setVisible(true);
                panelactual.setVisible(false);
                txtidpagina.setText("");
            }
        } else {
            PanelMenuPrincipal.setVisible(true);
        }
    }
    @FXML
    void pressatrasinicio(ActionEvent event){
        if(PRegistro.isVisible()){
            ((Node)(event.getSource())).getScene().getWindow().hide();
            app.start(new Stage());
        }
    }
    @FXML
    void pressatras() {
        if (PanelRecepciones.isVisible() || PanelExpediciones.isVisible() || PanelDevoluciones.isVisible()) {
            cambiarpanel(panelactual, PanelInventarioInicial);
            dateReferencia.setValue(LocalDate.now());
            listrecepciones.clear();
            rellenartablaRecepciones();
        } else if (PanelAddRecepciones.isVisible()) {
            cambiarpanel(panelactual, PanelRecepciones);
            rellenartablaRecepciones();
        } else if (PanelAddExpediciones.isVisible()) {
            cambiarpanel(panelactual, PanelExpediciones);
        } else if (PanelAddDevoluciones.isVisible()) {
            cambiarpanel(panelactual, PanelDevoluciones);
        } else if (PanelAddEmpleados.isVisible() || PanelEditEmpleados.isVisible()) {
            cambiarpanel(panelactual, PanelEmpleados);
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
        txtidpagina.setText("INVENTARIO");
        rellenartablaRecepciones();
        rellenartablaExpediciones();
    }

    @FXML
    void pressbtfacturacion() {

    }

    @FXML
    void pressbtempleados() {
        cambiarpanel(PanelMenuPrincipal, PanelEmpleados);
        txtidpagina.setText("EMPLEADOS");
    }

    private void cambiarpanel(Pane panel1, Pane panel2) {
        panel1.setVisible(false);
        panel2.setVisible(true);
        panelactual = panel2;
    }

    @FXML
    void pressRecepciones() {
        cambiarpanel(PanelInventarioInicial, PanelRecepciones);
    }

    @FXML
    void pressExpediciones() {
        cambiarpanel(PanelInventarioInicial, PanelExpediciones);
    }

    @FXML
    void pressDevoluciones() {
        cambiarpanel(PanelInventarioInicial, PanelDevoluciones);
    }

    @FXML
    void pressbtncrear() {
        if (PanelRecepciones.isVisible()) {
            cambiarpanel(PanelRecepciones, PanelAddRecepciones);
            dateReferencia.setValue(LocalDate.now());
            lblAtrasRecepciones.setText("RECEPCIONES / CREAR");
            txtReferencia.setDisable(false);
            btnCrearRecepciones.setText("CREAR");
            clearRecepciones();
        } else if (PanelExpediciones.isVisible()) {
            DateExpediciones.setValue(LocalDate.now());
            lblAtrasExp.setText("EXPEDICIONES / CREAR");
            txtReferenciaExpediciones.setDisable(false);
            btnCrearExpediciones.setText("CREAR");
            cambiarpanel(PanelExpediciones, PanelAddExpediciones);
        } else if (PanelDevoluciones.isVisible()) {
            cambiarpanel(PanelDevoluciones, PanelAddDevoluciones);
        } else if (PanelEmpleados.isVisible()) {
            cambiarpanel(PanelEmpleados, PanelAddEmpleados);
        }
    }

    private void clearRecepciones() {
        listrecepciones.clear();
        txtReferencia.clear();
        txtCantidad.clear();
        txtProducto.clear();
        txtDocumento.clear();
        txtrecibir.clear();
        tableRecepciones.getItems().clear();
    }

    @FXML
    void selectInventario() {
        //Definimos el campo de conexion como null
        Connection conexion = null;
        //Ejecutamos dentro de un try para controlar las excepciones
        try {
            tableRecepciones.getItems().clear();
            //Creamos un paciente con los datos extraidos del campo seleccionado de la tabla
            Recepciones rec = tableInventarioRecep.getSelectionModel().getSelectedItem();
            //Creamos la conexion
            conexion = DriverManager.getConnection(cadconexion, user, pswd);
            //Creamos el correspondiente Statement con nuestra conexion anterior
            Statement st = conexion.createStatement();
            //Creamos la consulta
            referenciaactual = rec.getReferencia();
            String consulta2 = String.format("Select * from recepciones where referencia = '%s'", rec.getReferencia());
            ResultSet rs = st.executeQuery(consulta2);
            if (rs.next()) {
                txtReferencia.setText(rec.getReferencia());
                txtrecibir.setText(rs.getString(2));
                dateReferencia.setValue(rs.getDate(3).toLocalDate());
                txtDocumento.setText(rs.getString(4));
            }
            rellenartablaAddRecepciones();
            lblAtrasRecepciones.setText("RECEPCIONES / EDITAR");
            txtReferencia.setDisable(true);
            btnCrearRecepciones.setText("EDITAR");
            cambiarpanel(panelactual, PanelAddRecepciones);
            //Controlamos las excepciones con los catch
        } catch (NullPointerException pi) {
            System.out.print("");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Comprobamos que la conexion sea null, en caso de que no lo sea la cerramos
            try {
                assert conexion != null;
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void selectRecepciones() {
        Connection conexion = null;
        //Ejecutaremos el codigo dentro de un try para controlar las excepciones
        try {
            //Creamos un médico con los datos selecionados de la tabla
            Recepciones rec = tableRecepciones.getSelectionModel().getSelectedItem();
            //Creamos la conexion
            conexion = DriverManager.getConnection(cadconexion, user, pswd);
            //Creamos el Statement con la conexion
            Statement st = conexion.createStatement();
            //Creamos la consulta
            String consulta = "Select Producto, Cantidad from productosrec";
            //Guardamos dentro del ResulSet la ejecucion de la consulta con la conexion anterior
            ResultSet rs = st.executeQuery(consulta);
            //Con un if comprobamos que los datos sean validos
            while (rs.next()) {
                if (Objects.equals(rs.getString(1), rec.getNombreproducto())) {
                    txtProducto.setText(rs.getString(1));
                    txtCantidad.setText(String.valueOf(rs.getInt(2)));
                    break;
                }
            }

            String consulta2 = String.format("Select Producto, Cantidad from productosrec where referencia = '%s'", referenciaactual);
            //Guardamos dentro del ResulSet la ejecucion de la consulta con la conexion anterior
            ResultSet rs2 = st.executeQuery(consulta2);
            listrecepciones.clear();
            while (rs2.next()) {
                listrecepciones.add(new Recepciones(rs2.getString(1), rs2.getInt(2)));
            }
            //Controlamos las excepciones mostrandolas por la terminal
        } catch (NullPointerException pi) {
            System.out.print("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void pressbtnCrearRecepciones() {
        if (Objects.equals(btnCrearRecepciones.getText(), "EDITAR")){
            //Creamos conexión null por si tuviéramos otra conexión cerrarla
            Connection conexion = null;
            //Ejecutamos dentro de un try para controlar todas las excepciones posibles
            try {
                //Creamos la conexión con la base de datos
                conexion = DriverManager.getConnection(cadconexionps, user, pswd);
                //Utilizamos un PreparedStatement para la consulta para mayor seguridad

                Statement st = conexion.createStatement();
                //Parseamos la fecha
                String fecha = dateReferencia.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate localdate = parse(fecha);

                String consulta = String.format("UPDATE recepciones SET Nombre = '%s', " +
                                "FechaPrevista = '%s', " +
                                "Documento = '%s' " +
                                "WHERE Referencia = '%s'", txtrecibir.getText(),
                        Date.valueOf(localdate), txtDocumento.getText(),
                        txtReferencia.getText());

                //Creamos una ventana de confirmacion para la modificacion del ingreso
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmación");
                alert.setContentText("Recuerde presionar en añadir producto para completar la edicion del producto");
                Optional<ButtonType> action = alert.showAndWait();
                //Comprobamos si el usuario ha presionado el boton Ok, si es asi, ejecutaremos los siguientes metodos
                if (action.orElseThrow() == ButtonType.OK) {
                    st.executeUpdate(consulta);
                    //Creamos el Statement con la conexion
                    for (Recepciones listrecepcione : listrecepciones) {
                        String consulta2 = String.format("Update productosrec set Referencia = '%s', Producto = '%s', Cantidad = %s",
                                txtReferencia.getText(),
                                listrecepcione.getNombreproducto(),
                                listrecepcione.getCantidad());
                        st.execute(consulta2);
                    }
                    crearalertainfo("Recepcion editada");
                    rellenartablaRecepciones();
                    cambiarpanel(PanelAddRecepciones, PanelRecepciones);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(Objects.equals(btnCrearRecepciones.getText(), "CREAR")){
            //Creamos conexión null por si tuviéramos otra conexión cerrarla
            Connection conexion = null;
            //Ejecutamos dentro de un try para controlar todas las excepciones posibles
            try {
                //Creamos la conexión con la base de datos
                conexion = DriverManager.getConnection(cadconexionps, user, pswd);
                //Utilizamos un PreparedStatement para la consulta para mayor seguridad
                PreparedStatement ps = conexion.prepareStatement("INSERT INTO recepciones (Referencia, Nombre, FechaPrevista, Documento) VALUES  (?, ?, ?, ?)");

                ps.setString(1, txtReferencia.getText());
                ps.setString(2, txtrecibir.getText());
                //Parseamos la fecha
                String fecha = dateReferencia.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate localdate = parse(fecha);
                ps.setDate(3, Date.valueOf(localdate));
                ps.setString(4, txtDocumento.getText());
                //Creamos una ventana de confirmacion para la modificacion del ingreso
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmación");
                alert.setContentText("Recuerde presionar en añadir producto para completar la insercion del producto");
                Optional<ButtonType> action = alert.showAndWait();
                //Comprobamos si el usuario ha presionado el boton Ok, si es asi, ejecutaremos los siguientes metodos
                if (action.orElseThrow() == ButtonType.OK) {
                    ps.executeUpdate();
                    //Creamos el Statement con la conexion
                    Statement st = conexion.createStatement();
                    for (Recepciones listrecepcione : listrecepciones) {
                        String consulta = String.format("insert into productosrec values ('%s', '%s', %s)",
                                txtReferencia.getText(),
                                listrecepcione.getNombreproducto(),
                                listrecepcione.getCantidad());
                        st.execute(consulta);
                    }
                    crearalertainfo("Recepcion creada");
                    rellenartablaRecepciones();
                    cambiarpanel(PanelAddRecepciones, PanelRecepciones);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void rellenartablaRecepciones() {
        Connection conexion = null;
        //Ejecutamos el código en un try para controlar las excepciones
        try {
            //Creamos la conexion
            conexion = DriverManager.getConnection(cadconexion, user, pswd);
            Statement st = conexion.createStatement();
            tableRecepciones.getItems().clear();
            //Creamos la consulta
            String consulta = "SELECT Tel, Referencia, FechaPrevista, Documento, Estado FROM recepciones;";
            //Guardamos la ejecución de la consulta en la variable rs
            ResultSet rs = st.executeQuery(consulta);
            //Bucle para seguir importando datos mientras los haya
            ObservableList<Recepciones> obsrec = FXCollections.observableArrayList();
            while (rs.next()) {
                //ObservableList para guardar dentro el paciente correspondiente para añadirlo a las columnas
                //Creamos un paciente, con los campos obtenidos de la consulta
                obsrec.add(new Recepciones(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3).toLocalDate(),
                        rs.getString(4),
                        rs.getString(5))
                );
                //Relacionamos la columna con el campo del constructor correcto
                contactocolumn.setCellValueFactory(new PropertyValueFactory<>("contacto"));
                Referenciacolumn.setCellValueFactory(new PropertyValueFactory<>("referencia"));
                Fechacolumn.setCellValueFactory(new PropertyValueFactory<>("dateReferencia"));
                Documentocolumn.setCellValueFactory(new PropertyValueFactory<>("docorigen"));
                Estadocolumn.setCellValueFactory(new PropertyValueFactory<>("estado"));
                //Metemos dentro la tabla paciente la lista creada anteriormente
                tableInventarioRecep.setItems(obsrec);
            }
            //Refrescamos la tabla paciente
            tableInventarioRecep.refresh();
            //Controlamos las excepciones mostrándolas por la terminal
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Controlamos que la connexion sea null, en el caso contrario lo definiremos como tal
            try {
                assert conexion != null;
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    void rellenartablaAddRecepciones() {
        //Ejecutamos el código en un try para controlar las excepciones
        tableRecepciones.getItems().clear();
        try {
            ObservableList<Recepciones> obsrec = FXCollections.observableArrayList();
            //Rellenamos los datos de los pacientes con sus respectivos campos
            ProductoColum.setCellValueFactory(new PropertyValueFactory<>("nombreproducto"));
            CantidadColum.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
            txtProducto.setText("");
            txtCantidad.setText("");
            obsrec.addAll(listrecepciones);
            tableRecepciones.setItems(obsrec);
            tableRecepciones.refresh();
            //Controlamos las excepciones mostrándolas por la terminal
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void pressbtnRecepcionesAdd() {
        //Ejecutamos el código en un try para controlar las excepciones
        try {
            listrecepciones.add(new Recepciones(txtProducto.getText(), Integer.parseInt(txtCantidad.getText())));
            txtProducto.clear();
            txtCantidad.clear();
            rellenartablaAddRecepciones();

            //Controlamos las excepciones mostrándolas por la terminal
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Expediciones
    void rellenartablaExpediciones() {
        Connection conexion = null;
        //Ejecutamos el código en un try para controlar las excepciones
        try {
            //Creamos la conexion
            conexion = DriverManager.getConnection(cadconexion, user, pswd);
            Statement st = conexion.createStatement();
            TableExpediciones.getItems().clear();
            //Creamos la consulta
            String consulta = "SELECT Tel, Referencia, FechaPrevista, Documento, Estado FROM expediciones";
            //Guardamos la ejecución de la consulta en la variable rs
            ResultSet rs = st.executeQuery(consulta);
            //Bucle para seguir importando datos mientras los haya
            ObservableList<Expediciones> obsexp = FXCollections.observableArrayList();
            while (rs.next()) {
                //ObservableList para guardar dentro el paciente correspondiente para añadirlo a las columnas
                //Creamos un paciente, con los campos obtenidos de la consulta
                obsexp.add(new Expediciones(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3).toLocalDate(),
                        rs.getString(4),
                        rs.getString(5))
                );
                //Relacionamos la columna con el campo del constructor correcto
                ColumContExpediciones.setCellValueFactory(new PropertyValueFactory<>("contacto"));
                ColumExpReferencia.setCellValueFactory(new PropertyValueFactory<>("referencia"));
                ColumExpFecha.setCellValueFactory(new PropertyValueFactory<>("dateReferencia"));
                ColumExpDoc.setCellValueFactory(new PropertyValueFactory<>("docorigen"));
                ColumExpEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
                //Metemos dentro la tabla paciente la lista creada anteriormente
                TableExpediciones.setItems(obsexp);
            }
            //Refrescamos la tabla paciente
            TableExpediciones.refresh();
            //Controlamos las excepciones mostrándolas por la terminal
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Controlamos que la connexion sea null, en el caso contrario lo definiremos como tal
            try {
                assert conexion != null;
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    void rellenartablaAddExcepciones() {
        //Ejecutamos el código en un try para controlar las excepciones
        tablaExp.getItems().clear();
        try {
            ObservableList<Expediciones> obsexp = FXCollections.observableArrayList();
            //Rellenamos los datos de los pacientes con sus respectivos campos
            ColumProductoExpedic.setCellValueFactory(new PropertyValueFactory<>("nombreproducto"));
            ColumCantidadExpedic.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
            txtProductoExp.setText("");
            txtCantidadExp.setText("");
            obsexp.addAll(listexpediciones);
            tablaExp.setItems(obsexp);
            tablaExp.refresh();
            //Controlamos las excepciones mostrándolas por la terminal
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void pressbtnExpAdd() {
        //Ejecutamos el código en un try para controlar las excepciones
        try {
            listexpediciones.add(new Expediciones(txtProductoExp.getText(), Integer.parseInt(txtCantidadExp.getText())));
            txtProductoExp.clear();
            txtCantidadExp.clear();
            rellenartablaAddExcepciones();

            //Controlamos las excepciones mostrándolas por la terminal
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void pressbtnCrearExpediciones() {
        if (Objects.equals(btnCrearExpediciones.getText(), "EDITAR")){
            //Creamos conexión null por si tuviéramos otra conexión cerrarla
            Connection conexion = null;
            //Ejecutamos dentro de un try para controlar todas las excepciones posibles
            try {
                //Creamos la conexión con la base de datos
                conexion = DriverManager.getConnection(cadconexionps, user, pswd);
                //Utilizamos un PreparedStatement para la consulta para mayor seguridad

                Statement st = conexion.createStatement();
                //Parseamos la fecha
                String fecha = DateExpediciones.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate localdate = parse(fecha);

                String consulta = String.format("UPDATE expediciones SET Nombre = '%s', " +
                                "FechaPrevista = '%s', " +
                                "Direccion = '%s', " +
                                "Documento = '%s' " +
                                "WHERE Referencia = '%s'", txtrecibir.getText(), //Cambiar por campo Nombre
                        Date.valueOf(localdate), txtdireccionExpediciones.getText(),
                        txtDocExp.getText(),
                        txtReferenciaExpediciones.getText());

                //Creamos una ventana de confirmacion para la modificacion del ingreso
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmación");
                alert.setContentText("Recuerde presionar en añadir producto para completar la edicion del producto");
                Optional<ButtonType> action = alert.showAndWait();
                //Comprobamos si el usuario ha presionado el boton Ok, si es asi, ejecutaremos los siguientes metodos
                if (action.orElseThrow() == ButtonType.OK) {
                    st.executeUpdate(consulta);
                    //Creamos el Statement con la conexion
                    for (Expediciones listexp : listexpediciones) {
                        String consulta2 = String.format("Update productosexp set Referencia = '%s', Producto = '%s', Cantidad = %s",
                                txtReferenciaExpediciones.getText(),
                                listexp.getNombreproducto(),
                                listexp.getCantidad());
                        st.execute(consulta2);
                    }
                    crearalertainfo("Expedicion editada");
                    rellenartablaExpediciones();
                    cambiarpanel(panelactual, PanelExpediciones);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(Objects.equals(btnCrearExpediciones.getText(), "CREAR")){
            //Creamos conexión null por si tuviéramos otra conexión cerrarla
            Connection conexion = null;
            //Ejecutamos dentro de un try para controlar todas las excepciones posibles
            try {
                //Creamos la conexión con la base de datos
                conexion = DriverManager.getConnection(cadconexionps, user, pswd);
                //Utilizamos un PreparedStatement para la consulta para mayor seguridad
                PreparedStatement ps = conexion.prepareStatement("INSERT INTO expediciones (Referencia, Direccion, FechaPrevista, Documento) VALUES  (?, ?, ?, ?)");

                ps.setString(1, txtReferenciaExpediciones.getText());
                ps.setString(2, txtdireccionExpediciones.getText());
                //Parseamos la fecha
                String fecha = DateExpediciones.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate localdate = parse(fecha);
                ps.setDate(3, Date.valueOf(localdate));
                ps.setString(4, txtDocExp.getText());
                //Creamos una ventana de confirmacion para la modificacion del ingreso
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmación");
                alert.setContentText("Recuerde presionar en añadir producto para completar la insercion del producto");
                Optional<ButtonType> action = alert.showAndWait();
                //Comprobamos si el usuario ha presionado el boton Ok, si es asi, ejecutaremos los siguientes metodos
                if (action.orElseThrow() == ButtonType.OK) {
                    ps.executeUpdate();
                    //Creamos el Statement con la conexion
                    Statement st = conexion.createStatement();
                    for (Expediciones listexp : listexpediciones) {
                        String consulta = String.format("insert into productosexp values ('%s', '%s', %s)",
                                txtReferenciaExpediciones.getText(),
                                listexp.getNombreproducto(),
                                listexp.getCantidad());
                        st.execute(consulta);
                    }
                    crearalertainfo("Expedicion creada");
                    rellenartablaExpediciones();
                    cambiarpanel(panelactual, PanelExpediciones);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    void SelectExpediciones() {
        //Definimos el campo de conexion como null
        Connection conexion = null;
        //Ejecutamos dentro de un try para controlar las excepciones
        try {
            tablaExp.getItems().clear();
            //Creamos un paciente con los datos extraidos del campo seleccionado de la tabla
            Expediciones exp = TableExpediciones.getSelectionModel().getSelectedItem();
            //Creamos la conexion
            conexion = DriverManager.getConnection(cadconexion, user, pswd);
            //Creamos el correspondiente Statement con nuestra conexion anterior
            Statement st = conexion.createStatement();
            //Creamos la consulta
            referenciaactual = exp.getReferencia();
            String consulta2 = String.format("Select * from expediciones where referencia = '%s'", exp.getReferencia());
            ResultSet rs = st.executeQuery(consulta2);
            if (rs.next()) {
                txtReferenciaExpediciones.setText(exp.getReferencia());
                txtdireccionExpediciones.setText(rs.getString(2));
                DateExpediciones.setValue(rs.getDate(4).toLocalDate());
                txtDocExp.setText(rs.getString(5));
            }
            rellenartablaAddExcepciones();
            lblAtrasExp.setText("EXCEPCIONES / EDITAR");
            txtReferenciaExpediciones.setDisable(true);
            btnCrearExpediciones.setText("EDITAR");
            cambiarpanel(panelactual, PanelAddExpediciones);
            //Controlamos las excepciones con los catch
        } catch (NullPointerException pi) {
            System.out.print("");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Comprobamos que la conexion sea null, en caso de que no lo sea la cerramos
            try {
                assert conexion != null;
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void selectAddExpediciones() {
        Connection conexion = null;
        //Ejecutaremos el codigo dentro de un try para controlar las excepciones
        try {
            //Creamos un médico con los datos selecionados de la tabla
            Expediciones exp = tablaExp.getSelectionModel().getSelectedItem();
            //Creamos la conexion
            conexion = DriverManager.getConnection(cadconexion, user, pswd);
            //Creamos el Statement con la conexion
            Statement st = conexion.createStatement();
            //Creamos la consulta
            String consulta = "Select Producto, Cantidad from productosexp";
            //Guardamos dentro del ResulSet la ejecucion de la consulta con la conexion anterior
            ResultSet rs = st.executeQuery(consulta);
            //Con un if comprobamos que los datos sean validos
            while (rs.next()) {
                if (Objects.equals(rs.getString(1), exp.getNombreproducto())) {
                    txtProductoExp.setText(rs.getString(1));
                    txtCantidadExp.setText(String.valueOf(rs.getInt(2)));
                    break;
                }
            }

            String consulta2 = String.format("Select Producto, Cantidad from productosrexp where referencia = '%s'", referenciaactual);
            //Guardamos dentro del ResulSet la ejecucion de la consulta con la conexion anterior
            ResultSet rs2 = st.executeQuery(consulta2);
            listexpediciones.clear();
            while (rs2.next()) {
                listexpediciones.add(new Expediciones(rs2.getString(1), rs2.getInt(2)));
            }
            //Controlamos las excepciones mostrandolas por la terminal
        } catch (NullPointerException pi) {
            System.out.print("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Devoluciones
    @FXML
    void pressbtnCrearDevoluciones() {

    }

    @FXML
    void pressbtnAddDevoluciones() {

    }

    void rellenaTableDevoluciones() {
        Connection conexion = null;
        //Ejecutamos el código en un try para controlar las excepciones
        try {
            //Creamos la conexion
            conexion = DriverManager.getConnection(cadconexion, user, pswd);
            Statement st = conexion.createStatement();
            TableDevoluciones.getItems().clear();
            //Creamos la consulta
            String consulta = "SELECT Tel, Referencia, FechaPrevista, Documento, Estado FROM expediciones";
            //Guardamos la ejecución de la consulta en la variable rs
            ResultSet rs = st.executeQuery(consulta);
            //Bucle para seguir importando datos mientras los haya
            ObservableList<Devoluciones> obsdev = FXCollections.observableArrayList();
            while (rs.next()) {
                //ObservableList para guardar dentro el paciente correspondiente para añadirlo a las columnas
                //Creamos un paciente, con los campos obtenidos de la consulta
                obsdev.add(new Devoluciones(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
                //Relacionamos la columna con el campo del constructor correcto
                ColumContExpediciones.setCellValueFactory(new PropertyValueFactory<>("contacto"));
                ColumExpReferencia.setCellValueFactory(new PropertyValueFactory<>("referencia"));
                ColumExpFecha.setCellValueFactory(new PropertyValueFactory<>("dateReferencia"));
                ColumExpDoc.setCellValueFactory(new PropertyValueFactory<>("docorigen"));
                ColumExpEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
                //Metemos dentro la tabla paciente la lista creada anteriormente
                TableDevoluciones.setItems(obsdev);
            }
            //Refrescamos la tabla paciente
            TableDevoluciones.refresh();
            //Controlamos las excepciones mostrándolas por la terminal
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Controlamos que la connexion sea null, en el caso contrario lo definiremos como tal
            try {
                assert conexion != null;
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void SelectDevoluciones() {

    }


    @FXML
    void selectDevoluciones() {

    }

    @FXML
    void pressbtnAddEmpleados() {

    }

    @FXML
    void selectDepartamentos() {

    }


    @FXML
    void initialize() {
        assert lblnombreusuario != null : "fx:id=\"lblnombreusuario\" was not injected: check your FXML file 'bd.fxml'.";
        assert BarraSuperior1 != null : "fx:id=\"BarraSuperior1\" was not injected: check your FXML file 'bd.fxml'.";
        assert imgperfil1 != null : "fx:id=\"imgperfil1\" was not injected: check your FXML file 'bd.fxml'.";
        assert Pperfil != null : "fx:id=\"Pperfil\" was not injected: check your FXML file 'bd.fxml'.";
        assert btaddbd != null : "fx:id=\"btaddbd\" was not injected: check your FXML file 'bd.fxml'.";
        assert Pnewbd != null : "fx:id=\"Pnewbd\" was not injected: check your FXML file 'bd.fxml'.";
        assert Pgridbd != null : "fx:id=\"Pgridbd\" was not injected: check your FXML file 'bd.fxml'.";
        assert txtnombd != null : "fx:id=\"txtnombd\" was not injected: check your FXML file 'bd.fxml'.";
        assert btcuenta1 != null : "fx:id=\"btcuenta1\" was not injected: check your FXML file 'bd.fxml'.";
        assert btaddbd11 != null : "fx:id=\"btaddbd11\" was not injected: check your FXML file 'bd.fxml'.";
        assert imgperfil12 != null : "fx:id=\"imgperfil12\" was not injected: check your FXML file 'bd.fxml'.";
        assert btaddbd1 != null : "fx:id=\"btaddbd1\" was not injected: check your FXML file 'bd.fxml'.";
        assert txtidpagina1 != null : "fx:id=\"txtidpagina1\" was not injected: check your FXML file 'bd.fxml'.";
        assert Pbasesdedatos != null : "fx:id=\"Pbasesdedatos\" was not injected: check your FXML file 'bd.fxml'.";
        assert btacceder != null : "fx:id=\"btacceder\" was not injected: check your FXML file 'inicio.fxml'.";
        assert PInicio != null : "fx:id=\"PInicio\" was not injected: check your FXML file 'inicio.fxml'.";
        assert txtusuario != null : "fx:id=\"txtusuario\" was not injected: check your FXML file 'inicio.fxml'.";
        assert txtcontrasena != null : "fx:id=\"txtcontrasena\" was not injected: check your FXML file 'inicio.fxml'.";
        assert imgperfil1111 != null : "fx:id=\"imgperfil1111\" was not injected: check your FXML file 'register.fxml'.";
        assert txtcontrasena12 != null : "fx:id=\"txtcontrasena12\" was not injected: check your FXML file 'register.fxml'.";
        assert txtcontrasena11 != null : "fx:id=\"txtcontrasena11\" was not injected: check your FXML file 'register.fxml'.";
        assert txtcontrasena1 != null : "fx:id=\"txtcontrasena1\" was not injected: check your FXML file 'register.fxml'.";
        assert txtcontrasena13 != null : "fx:id=\"txtcontrasena13\" was not injected: check your FXML file 'register.fxml'.";
        assert PRegistro != null : "fx:id=\"PRegistro\" was not injected: check your FXML file 'register.fxml'.";
        assert txtusuario1 != null : "fx:id=\"txtusuario1\" was not injected: check your FXML file 'register.fxml'.";
        assert btcuenta1111 != null : "fx:id=\"btcuenta1111\" was not injected: check your FXML file 'register.fxml'.";
        assert btnCrearRecepciones != null : "fx:id=\"btnCrearRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert CantidadColum != null : "fx:id=\"CantidadColum\" was not injected: check your FXML file 'erp.fxml'.";
        assert imgempleado1 != null : "fx:id=\"imgempleado1\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelExpediciones != null : "fx:id=\"PanelExpediciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btcuenta != null : "fx:id=\"btcuenta\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnExpediciones != null : "fx:id=\"btnExpediciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtTelefonoEmpleado != null : "fx:id=\"txtTelefonoEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert lblAtrasRecepciones != null : "fx:id=\"lblAtrasRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnDevolucionesAdd != null : "fx:id=\"btnDevolucionesAdd\" was not injected: check your FXML file 'erp.fxml'.";
        assert ColumProductDevoluciones != null : "fx:id=\"ColumProductDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtCantidadDevoluciones != null : "fx:id=\"txtCantidadDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelEmpleados != null : "fx:id=\"PanelEmpleados\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtDocumento212131 != null : "fx:id=\"txtDocumento212131\" was not injected: check your FXML file 'erp.fxml'.";
        assert Fechacolumn != null : "fx:id=\"Fechacolumn\" was not injected: check your FXML file 'erp.fxml'.";
        assert dateReferencia != null : "fx:id=\"dateReferencia\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtReferencia != null : "fx:id=\"txtReferencia\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnAddDevoluciones != null : "fx:id=\"btnAddDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnSeleccionarIMGEditarEmpleado != null : "fx:id=\"btnSeleccionarIMGEditarEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtDepartamentoEmpleado != null : "fx:id=\"txtDepartamentoEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtCantidadExp != null : "fx:id=\"txtCantidadExp\" was not injected: check your FXML file 'erp.fxml'.";
        assert Pempleados != null : "fx:id=\"Pempleados\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtDireccionLaboralEmpleado != null : "fx:id=\"txtDireccionLaboralEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert ColumProductoExpedic != null : "fx:id=\"ColumProductoExpedic\" was not injected: check your FXML file 'erp.fxml'.";
        assert imgperfil11211 != null : "fx:id=\"imgperfil11211\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtCantidad != null : "fx:id=\"txtCantidad\" was not injected: check your FXML file 'erp.fxml'.";
        assert imgempleado != null : "fx:id=\"imgempleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert imgperfil != null : "fx:id=\"imgperfil\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelEditEmpleados != null : "fx:id=\"PanelEditEmpleados\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelInventarioInicial != null : "fx:id=\"PanelInventarioInicial\" was not injected: check your FXML file 'erp.fxml'.";
        assert ColumExpFecha != null : "fx:id=\"ColumExpFecha\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtNombreEmpleado != null : "fx:id=\"txtNombreEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtGerenteEditarEmpleado != null : "fx:id=\"txtGerenteEditarEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnEmpleados != null : "fx:id=\"btnEmpleados\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelAddDevoluciones != null : "fx:id=\"PanelAddDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnSeleccionarIMG != null : "fx:id=\"btnSeleccionarIMG\" was not injected: check your FXML file 'erp.fxml'.";
        assert ColumExpEstado != null : "fx:id=\"ColumExpEstado\" was not injected: check your FXML file 'erp.fxml'.";
        assert dateReferencia2 != null : "fx:id=\"dateReferencia2\" was not injected: check your FXML file 'erp.fxml'.";
        assert DateExpediciones != null : "fx:id=\"DateExpediciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert dateReferencia21 != null : "fx:id=\"dateReferencia21\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtDocumento212111 != null : "fx:id=\"txtDocumento212111\" was not injected: check your FXML file 'erp.fxml'.";
        assert Menu != null : "fx:id=\"Menu\" was not injected: check your FXML file 'erp.fxml'.";
        assert btncrearRecepciones != null : "fx:id=\"btncrearRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnRecepcionesAdd != null : "fx:id=\"btnRecepcionesAdd\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelAddRecepciones != null : "fx:id=\"PanelAddRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtDocExp != null : "fx:id=\"txtDocExp\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnEditarEmpleados != null : "fx:id=\"btnEditarEmpleados\" was not injected: check your FXML file 'erp.fxml'.";
        assert Referenciacolumn != null : "fx:id=\"Referenciacolumn\" was not injected: check your FXML file 'erp.fxml'.";
        assert tableDepartamentos != null : "fx:id=\"tableDepartamentos\" was not injected: check your FXML file 'erp.fxml'.";
        assert TableExpediciones != null : "fx:id=\"TableExpediciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtHorasSemanalesEditarEmpleado != null : "fx:id=\"txtHorasSemanalesEditarEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtProductoDevoluciones != null : "fx:id=\"txtProductoDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnCrearDevoluciones != null : "fx:id=\"btnCrearDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnVolverEmpEdit != null : "fx:id=\"btnVolverEmpEdit\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtTelefonoEditarEmpleado != null : "fx:id=\"txtTelefonoEditarEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert tablaExp != null : "fx:id=\"tablaExp\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtemailEmpleado != null : "fx:id=\"txtemailEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnExpAdd != null : "fx:id=\"btnExpAdd\" was not injected: check your FXML file 'erp.fxml'.";
        assert tableDevoluciones != null : "fx:id=\"tableDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnCompras != null : "fx:id=\"btnCompras\" was not injected: check your FXML file 'erp.fxml'.";
        assert imgperfil113 != null : "fx:id=\"imgperfil113\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtDocumento212121 != null : "fx:id=\"txtDocumento212121\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelRecepciones != null : "fx:id=\"PanelRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert imgperfil111 != null : "fx:id=\"imgperfil111\" was not injected: check your FXML file 'erp.fxml'.";
        assert imgperfil112 != null : "fx:id=\"imgperfil112\" was not injected: check your FXML file 'erp.fxml'.";
        assert ColumDocDevoluciones != null : "fx:id=\"ColumDocDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelMenuPrincipal != null : "fx:id=\"PanelMenuPrincipal\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtemailEditarEmpleado != null : "fx:id=\"txtemailEditarEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert Estadocolumn != null : "fx:id=\"Estadocolumn\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelDevoluciones != null : "fx:id=\"PanelDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert ColumRefDevoluciones != null : "fx:id=\"ColumRefDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtDocumento != null : "fx:id=\"txtDocumento\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnVentas != null : "fx:id=\"btnVentas\" was not injected: check your FXML file 'erp.fxml'.";
        assert imgperfil1122 != null : "fx:id=\"imgperfil1122\" was not injected: check your FXML file 'erp.fxml'.";
        assert TableDevoluciones != null : "fx:id=\"TableDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert imgperfil1121 != null : "fx:id=\"imgperfil1121\" was not injected: check your FXML file 'erp.fxml'.";
        assert contactocolumn != null : "fx:id=\"contactocolumn\" was not injected: check your FXML file 'erp.fxml'.";
        assert ProductoColum != null : "fx:id=\"ProductoColum\" was not injected: check your FXML file 'erp.fxml'.";
        assert BarraSuperior != null : "fx:id=\"BarraSuperior\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnVolverExpediciones != null : "fx:id=\"btnVolverExpediciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert dateDevoluciones != null : "fx:id=\"dateDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtGerenteEmpleado != null : "fx:id=\"txtGerenteEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert ColumCantidadExpedic != null : "fx:id=\"ColumCantidadExpedic\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnDevoluciones != null : "fx:id=\"btnDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnCrearExpediciones != null : "fx:id=\"btnCrearExpediciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtRecibirDevoluciones != null : "fx:id=\"txtRecibirDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtHorasSemanaEmpleado != null : "fx:id=\"txtHorasSemanaEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert ColumCantidadDevoluciones != null : "fx:id=\"ColumCantidadDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtNombreEditEmpleado != null : "fx:id=\"txtNombreEditEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert ColumFechaDevoluciones != null : "fx:id=\"ColumFechaDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert ColumContacDevoluciones != null : "fx:id=\"ColumContacDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtDocDevoluciones != null : "fx:id=\"txtDocDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnVolverEmpNuevo != null : "fx:id=\"btnVolverEmpNuevo\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtPuestoEditarEmpleado != null : "fx:id=\"txtPuestoEditarEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtDocumento21213 != null : "fx:id=\"txtDocumento21213\" was not injected: check your FXML file 'erp.fxml'.";
        assert Documentocolumn != null : "fx:id=\"Documentocolumn\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnVolverRecepNew != null : "fx:id=\"btnVolverRecepNew\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtDocumento21212 != null : "fx:id=\"txtDocumento21212\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtrecibir != null : "fx:id=\"txtrecibir\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnInventario != null : "fx:id=\"btnInventario\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnVolverRecepciones != null : "fx:id=\"btnVolverRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnVolverDevolNew != null : "fx:id=\"btnVolverDevolNew\" was not injected: check your FXML file 'erp.fxml'.";
        assert ColumExpReferencia != null : "fx:id=\"ColumExpReferencia\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtDocumentoEditarEmpleado != null : "fx:id=\"txtDocumentoEditarEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtidpagina != null : "fx:id=\"txtidpagina\" was not injected: check your FXML file 'erp.fxml'.";
        assert btncrearExpediciones != null : "fx:id=\"btncrearExpediciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert ColumContExpediciones != null : "fx:id=\"ColumContExpediciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnVolverDevoluciones != null : "fx:id=\"btnVolverDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtDocumento21211 != null : "fx:id=\"txtDocumento21211\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtdireccionLaboralEditarEmpleado != null : "fx:id=\"txtdireccionLaboralEditarEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtPuestodetrabajo != null : "fx:id=\"txtPuestodetrabajo\" was not injected: check your FXML file 'erp.fxml'.";
        assert imgperfil11 != null : "fx:id=\"imgperfil11\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtProducto != null : "fx:id=\"txtProducto\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnmenu != null : "fx:id=\"btnmenu\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnCrearEmpleados != null : "fx:id=\"btnCrearEmpleados\" was not injected: check your FXML file 'erp.fxml'.";
        assert ColumEstadoDevoluciones != null : "fx:id=\"ColumEstadoDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txt6 != null : "fx:id=\"txt6\" was not injected: check your FXML file 'erp.fxml'.";
        assert imgperfil1131 != null : "fx:id=\"imgperfil1131\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelAddExpediciones != null : "fx:id=\"PanelAddExpediciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtdireccionExpediciones != null : "fx:id=\"txtdireccionExpediciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txt5 != null : "fx:id=\"txt5\" was not injected: check your FXML file 'erp.fxml'.";
        assert PanelAddEmpleados != null : "fx:id=\"PanelAddEmpleados\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnRecepciones != null : "fx:id=\"btnRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtProductoExp != null : "fx:id=\"txtProductoExp\" was not injected: check your FXML file 'erp.fxml'.";
        assert ColumExpDoc != null : "fx:id=\"ColumExpDoc\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnFacturacion != null : "fx:id=\"btnFacturacion\" was not injected: check your FXML file 'erp.fxml'.";

    }
}
