package sge.proyectoerp.Controllers;

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
import sge.proyectoerp.Models.Singleton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
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
    private Pane panelcontrol;

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
    private DatePicker dateFecNa;

    @FXML
    private TextField txtGerenteEmpleado;

    @FXML
    private TextField txtDireccionPersonal;

    @FXML
    private TextField txtNumeroCuenta;

    @FXML
    private TextField txtDNI;

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
    private TextField txtGeneroEmpleado;

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
    private Button btaccederbd1;

    @FXML
    private Button btaccederbd2;

    @FXML
    private Button btaccederbd3;

    @FXML
    private Button btaccederbd4;

    @FXML
    private Button bteliminarbd1;

    @FXML
    private Button bteliminarbd2;

    @FXML
    private Button bteliminarbd3;

    @FXML
    private Button bteliminarbd4;


    @FXML
    private Label txtidpagina1;

    @FXML
    private Label labelbd1;

    @FXML
    private Label labelbd2;

    @FXML
    private Label labelbd3;

    @FXML
    private Label labelbd4;

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
    private TextField txtemailregister;

    @FXML
    private TextField txtcontrasena11;

    @FXML
    private TextField txtcontrasena1;

    @FXML
    private TextField txttelregister;

    @FXML
    private TextField txtnombreExpediciones;

    @FXML
    private ImageView imgusuario;

    @FXML
    private Pane PRegistro;

    @FXML
    private TextField txtusuario1;

    @FXML
    private Button btcuenta1111;

    @FXML
    private Pane PanelVentas;

    //Variables nuevas
    private Pane panelactual;

    private boolean usuarioact = false;

    private String imageruta;

    private final ArrayList<Recepciones> listrecepciones = new ArrayList<>();
    private final ArrayList<Expediciones> listexpediciones = new ArrayList<>();
    private final ArrayList<Devoluciones> listdevoluciones = new ArrayList<>();

    ArrayList<Button> listabotonesacceder = new ArrayList<>();
    ArrayList<Button> listabotoneliminar = new ArrayList<>();
    ArrayList<Label> listalabels = new ArrayList<>();

    //CAMBIOS

    private String bd;
    //Creamos la cadena con la que tenemos la direccion de la base de datos
    private final String conexionerp = "jdbc:mysql://localhost:3306/erp";

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

    private boolean imgrellena;

    String tabla1 = "CREATE OR REPLACE TABLE proveedores( CIF CHAR(9) PRIMARY KEY, Nombre VARCHAR(50) UNIQUE, " + "Direccion VARCHAR(100), Email VARCHAR(50), Tel CHAR(9) UNIQUE);";
    String tabla2 = "CREATE OR REPLACE TABLE recepciones(Referencia VARCHAR(15) PRIMARY KEY, Nombre VARCHAR(50), " + "FechaPrevista DATE, Documento VARCHAR(100), Tel CHAR(9), Estado VARCHAR(100), " + "CONSTRAINT Nombre FOREIGN KEY (Nombre) REFERENCES proveedores (Nombre)," + "CONSTRAINT Tel FOREIGN KEY (Tel) REFERENCES proveedores (TEl));";
    String tabla3 = "CREATE OR REPLACE TABLE devoluciones(Referencia VARCHAR(15) PRIMARY KEY, Proveedor VARCHAR(50)," + "FechaPrevista DATE, Documento VARCHAR(100), NombreProducto VARCHAR(50), Cantidad INT);";
    String tabla5 = "CREATE OR REPLACE TABLE expediciones(Referencia CHAR(15) PRIMARY KEY, Direccion VARCHAR(50), Nombre VARCHAR(50), " + "FechaPrevista DATE, Documento VARCHAR(100), Tel CHAR(9), Estado VARCHAR(100)," + "FOREIGN KEY (Nombre) REFERENCES clientes (Nombre)," + "FOREIGN KEY (Tel) REFERENCES clientes (Tel));";
    String tabla4 = "CREATE OR REPLACE TABLE clientes( CIF CHAR(9) PRIMARY KEY, Nombre VARCHAR(50) UNIQUE," + "Direccion VARCHAR(100), Email VARCHAR(50), Tel CHAR(9) UNIQUE);";

    String tabla9 = "CREATE OR REPLACE TABLE empleados(Nombre VARCHAR(50) NOT NULL, PuestoEmpresa VARCHAR(50) NOT NULL, Telefono CHAR(9) NULL, emaillaboral VARCHAR(100) NOT NULL, Departamento VARCHAR(50) NOT NULL, " +
            "Gerente VARCHAR(50) NOT NULL, Foto VARCHAR(255), DireccionLaboral VARCHAR(100), HorarioLaboral VARCHAR(50), DireccionPersonal VARCHAR(150), NumeroCuentaBancaria CHAR(24), " +
            "DNI CHAR(9), Genero VARCHAR(50), FechaNacimiento DATE );";

    String tabla10 = "CREATE OR REPLACE TABLE imgempleados(Foto VARCHAR(255), image BLOB (524288000));";

    String tabla6 = "CREATE OR REPLACE Table productosexp(Referencia VARCHAR(15), Producto VARCHAR(50), Cantidad INT," + "CONSTRAINT Referenciaexp FOREIGN KEY (Referencia) REFERENCES expediciones (Referencia));";

    String tabla7 = "CREATE OR REPLACE Table productosrec(Referencia VARCHAR(15), Producto VARCHAR(50), Cantidad INT, " + "CONSTRAINT Referencia FOREIGN KEY (Referencia) REFERENCES Recepciones (Referencia));";

    String tabla8 = "INSERT INTO proveedores VALUES ('CAD87542G', 'Prueba', 'Calatrava', 'iago@safareyes.es', '645342345');";

    String consulta1 = "CREATE DATABASE IF NOT EXISTS erp;";
    String consulta2 = "Create table usuarios(Usuario VARCHAR(50) PRIMARY KEY, Passwd VARCHAR(50), email VARCHAR(50) UNIQUE, tel char(9), img VARCHAR(50));";
    String consulta3 = "Create table bds(Nombre VARCHAR(50), Usuario VARCHAR(50), Foreign key (Usuario) References usuarios (Usuario));";

    String consulta4 = "INSERT INTO usuarios VALUES ('root', 'root', '', '', '');";
    //CAMBIOS
    ERPApplication app = new ERPApplication();

    Stage stagere = new Stage();


    private boolean compregister;

    static Singleton singleton = new Singleton();

    private boolean complogin;

    static Stage stagebd = new Stage();
    String tituloboton;
    String usuario;

    String pruebauser;

    String nombd;
    Stage stageerp = new Stage();
    ArrayList<String> listabds = new ArrayList<>();

    public void pressbtclientes() {
    }

    public String setUser() {
        usuario = txtusuario.getText();
        return usuario;
    }

    @FXML
    public void pressregistro(ActionEvent event) throws IOException {
        URL url = Paths.get("./src/main/resources/sge/proyectoerp/register.fxml").toUri().toURL();
        Pane root = FXMLLoader.load(url);
        Scene scene = new Scene(root, 1068, 700);
        stagere.setScene(scene);
        stagere.centerOnScreen();
        stagere.show();

        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    public void pressbtnacceder(ActionEvent event) throws IOException {
        //Definimos conexion como null
        Connection conexion = null;
        //Ejecutamos el comprobarlogin para controlar posibles fallos a la hora de hacer la consulta
        comprobarlogin();
        //Comprobamos que la variable complogin sea true
        if (complogin) {
            //Ejecutamos dentro de un try para controlar posibles excepciones
            try {
                conexion = DriverManager.getConnection(conexionerp, user, pswd);
                //Creamos la consulta con PreparedStatement
                PreparedStatement ps2 = conexion.prepareStatement("select usuario from usuarios where usuario = ?");
                ps2.setString(1, txtusuario.getText());
                //Ejecutamos la consulta
                ResultSet rs2 = ps2.executeQuery();
                //Comprobamos que la consulta tenga datos
                if (rs2.next()) {
                    //Comparamos que el usuario escrito exista en la base de datos
                    if (Objects.equals(rs2.getString(1), txtusuario.getText()) && complogin) {
                        //Si existe definimos que usuarioact es true
                        usuarioact = true;
                        //Creamos la consulta con PreparedStatement
                        PreparedStatement ps = conexion.prepareStatement("select Passwd from usuarios where usuario = ? ");
                        ps.setString(1, txtusuario.getText());
                        //Ejecutamos la consulta
                        ResultSet rs = ps.executeQuery();

                        //Comprobamos que la consulta tenga datos
                        if (rs.next()) {
                            //Comparamos los datos introducidos por el usuario con la contraseña que nos ha dado la consulta anterior
                            if (Objects.equals(rs.getString(1), txtcontrasena.getText())) {
                                //Abrimos la ventana principal
                                setUser();
                                URL url = Paths.get("./src/main/resources/sge/proyectoerp/bd.fxml").toUri().toURL();
                                Pane root = FXMLLoader.load(url);
                                Scene scene = new Scene(root, 1068, 700);
                                stagebd.setScene(scene);
                                singleton.setTitstage("Bases de Datos");
                                tituloboton = singleton.getTitstage();
                                stagebd.setTitle("Bases de Datos");
                                stagebd.centerOnScreen();
                                stagebd.initStyle(StageStyle.DECORATED);
                                stagebd.initStyle(StageStyle.TRANSPARENT);
                                stagebd.show();
                                System.out.println(singleton.getTitstage());
                                ((Node) (event.getSource())).getScene().getWindow().hide();
                                Label myLabel = (Label) root.lookup("#lblnombreusuario");
                                myLabel.setText(setUser());
                                singleton.setUsuario(txtusuario.getText());
                            } else {
                                //Informamos al usuario
                                crearalertaerror("La contraseña para este usuario es incorrecta");
                            }
                        }
                    } else {
                        //Definimos que la variable usuarioact es false
                        usuarioact = false;
                    }
                }
                //Comprobamos si la variable usuarioact es false
                if (!usuarioact) {
                    //Informamos al usuario
                    crearalertaerror("Usuario no registrado");
                }

                //Controlamos la excepciones
            } catch (SQLException e) {
                try {
                    Connection conexion2;
                    conexion2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", user, pswd);
                    Statement st2 = conexion2.createStatement();
                    st2.execute(consulta1);
                    conexion2 = DriverManager.getConnection(conexionerp, user, pswd);
                    Statement st4 = conexion2.createStatement();
                    st4.execute(consulta2);
                    st4.execute(consulta3);
                    st4.execute(consulta4);
                    pressbtnacceder(event);
                } catch (Exception eo) {
                    eo.printStackTrace();
                }
            }
        }
    }

    private void rellenartablasbd() {
        pruebauser = lblnombreusuario.getText();
        System.out.println("Prueba User: " + pruebauser);
        crearpaneles(pruebauser);
    }

    private void comprobarlogin() {
        //Definimos complogin como false
        complogin = false;
        //Comprobamos que los datos no esten en blanco
        if (Objects.equals(txtusuario.getText(), "") || Objects.equals(txtcontrasena.getText(), "")) {
            crearalertaerror("Debe rellenar los dos campos");
            //Comprobamos que los datos del usuario no sobrepasen los 20 caracteres
        } else if (txtusuario.getLength() > 20) {
            crearalertaerror("El usuario no puede tener más de 20 caracteres");
            //Comprobamos que el campo de contraseña no tenga una longitud mayor de 16 caracteres
        } else if (txtcontrasena.getLength() > 16) {
            crearalertaerror("La contraseña no puede tener más de 16 caracteres");
            //Definimos true la variable complogin en caso de no haber ningun fallo en la comprobación
        } else {
            complogin = true;
        }
    }

    @FXML
    public void borrarbd() {
        int n = 0;
        String nombrebd = listabotonesacceder.get(n).getId();
        if (Objects.equals(nombrebd, "bteliminar" + nombd)) {
            try {
                Connection conexion1;
                conexion1 = DriverManager.getConnection(conexionerp, user, pswd);
                //Creamos la consulta con PreparedStatement
                Statement st1 = conexion1.createStatement();
                String consulta5 = String.format("delete from bds where usuario = '%s' and nombre = '%s'", usuario, nombrebd);
                String consulta2 = String.format("DROP DATABASE %s", nombrebd);

                //Creamos una ventana de confirmacion para la modificacion del ingreso
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmación");
                alert.setContentText("¿Está seguro de qué quiere borrar esta base de datos?");
                Optional<ButtonType> action = alert.showAndWait();
                //Comprobamos si el usuario ha presionado el boton Ok, si es asi, ejecutaremos los siguientes metodos
                if (action.orElseThrow() == ButtonType.OK) {
                    st1.executeUpdate(consulta5);
                    st1.executeUpdate(consulta2);
                    crearalertainfo("Base de datos eliminada");
                    rellenartablasbd();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cargarerp(Pane root, String nombrebd) throws IOException {
        pruebauser = txtusuario.getText();
        System.out.println("Prueba User: " + pruebauser);
        URL url;
        singleton.setUsuario(pruebauser);
        System.out.println("Declarado: " + singleton.getUsuario());
        System.out.println("Nombre del boton: " + nombrebd);
        Label myLabel = (Label) root.lookup("#lblnombreusuario");
        url = Paths.get("./src/main/resources/sge/proyectoerp/erp.fxml").toUri().toURL();
        root = FXMLLoader.load(url);
        Scene scene = new Scene(root, 1536, 790);
        stageerp.setScene(scene);
        stageerp.centerOnScreen();
        stageerp.setMaximized(true);
        stageerp.show();
        usuario = lblnombreusuario.getText();
        myLabel.setText(usuario);
    }

    @FXML
    public void accederbd1() throws IOException {
        URL url = Paths.get("./src/main/resources/sge/proyectoerp/bd.fxml").toUri().toURL();
        Pane root = FXMLLoader.load(url);
        String nombrebd = listabotonesacceder.get(0).getId();
        cargarerp(root, nombrebd);
    }


    @FXML
    public void accederbd2() throws IOException {
        URL url = Paths.get("./src/main/resources/sge/proyectoerp/bd.fxml").toUri().toURL();
        Pane root = FXMLLoader.load(url);
        String nombrebd = listabotonesacceder.get(1).getId();
        cargarerp(root, nombrebd);
    }

    @FXML
    public void accederbd3() throws IOException {
        URL url = Paths.get("./src/main/resources/sge/proyectoerp/bd.fxml").toUri().toURL();
        Pane root = FXMLLoader.load(url);
        String nombrebd = listabotonesacceder.get(2).getId();
        cargarerp(root, nombrebd);
    }

    @FXML
    public void accederbd4() throws IOException {
        URL url = Paths.get("./src/main/resources/sge/proyectoerp/bd.fxml").toUri().toURL();
        Pane root = FXMLLoader.load(url);
        String nombrebd = listabotonesacceder.get(3).getId();
        cargarerp(root, nombrebd);
    }

    private void crearpaneles(String prubuser) {
        int cont = 0;
        try {
            Connection conexion;
            conexion = DriverManager.getConnection(conexionerp, user, pswd);
            //Creamos la consulta con PreparedStatement
            Statement st = conexion.createStatement();
            String consulta = String.format("Select nombre, usuario from bds where usuario = '%s'", prubuser);
            ResultSet rs = st.executeQuery(consulta);

            adddirbotones(listabotonesacceder, btaccederbd1, btaccederbd2, btaccederbd3, btaccederbd4);

            adddirbotones(listabotoneliminar, bteliminarbd1, bteliminarbd2, bteliminarbd3, bteliminarbd4);

            addlabels();
            listabds.clear();
            while (rs.next()) {
                listabotonesacceder.get(cont).setId(rs.getString(1) + rs.getString(2).substring(0, 3));
                listabotonesacceder.get(cont).setVisible(true);
                listabotoneliminar.get(cont).setId(rs.getString(1) + rs.getString(2).substring(0, 3));
                listabotoneliminar.get(cont).setVisible(true);
                listalabels.get(cont).setId(rs.getString(1) + rs.getString(2).substring(0, 3));
                listalabels.get(cont).setVisible(true);
                cont++;
            }

            /*
            URL url = Paths.get("./src/main/resources/sge/proyectoerp/bd.fxml").toUri().toURL();
            Pane root = FXMLLoader.load(url);
            GridPane myPanel = (GridPane) root.lookup("#Pgridbd");
            myPanel.getChildren().clear();
            while (rs.next()) {
                JButton btel = new JButton();
                JButton btentrar = new JButton("Acceder");
                SwingNode node2 = new SwingNode();
                JPanel Panelbd = new JPanel(new BorderLayout());//Creamos el panel que se va a añadir multiples veces
                JPanel Panelizq = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 3));
                nombd = rs.getString(1);
                System.out.println("Base de datos " + cont + rs.getString(1));
                cont++;

                Panelizq.setBackground(new java.awt.Color(41, 45, 45));
                Panelizq.setSize(100, 30);
                Panelbd.setBorder(new EmptyBorder(40, 30, 30, 30));
                Panelbd.setBackground(new java.awt.Color(41, 45, 45));
                JLabel nombrebd = new JLabel(nombd);//Aqui aparecerá el nombre de los empleados con respecto a la base de datos
                nombrebd.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
                nombrebd.setForeground(Color.white);
                asignarJButton(btel);
                btentrar.setBackground(new java.awt.Color(41, 184, 78));
                Panelizq.add(btel);
                Panelizq.add(nombrebd);
                Panelbd.add(Panelizq, BorderLayout.WEST);
                Panelbd.add(btentrar, BorderLayout.EAST);

                btentrar.setName("bte" + rs.getString(1));
                btel.setName("btel" + rs.getString(1));
                node2.setContent(Panelbd);//Añade el contenido al nodeswing
                node2.setId("node" + nombd);

                Button mybutton = (Button) root.lookup("#btaddbd");
                myPanel.add(node2, cols, filas);//Va añadiendo los nodeswing al gridpane sumando filas y columnas
                filas++;
                if (filas == 4) {
                    mybutton.setDisable(true);
                }//debes deshabilitar el método cuandotodo el gripane esta lleno
                counter++;


                //Metodo para eliminar las base de datos añadidas en el usuario, para eliminarlas deberas hacer un delete a la base de datos y luego llamar al metodo para que recarge los paneles de las base de datos
                btel.addActionListener(el -> {
                    if (Objects.equals(btel.getName(), "bteliminar" + nombd)) {
                        try {
                            Connection conexion1;
                            conexion1 = DriverManager.getConnection(conexionerp, user, pswd);
                            //Creamos la consulta con PreparedStatement
                            Statement st1 = conexion1.createStatement();
                            String consulta5 = String.format("delete from bds where usuario = '%s' and nombre = '%s'", prubuser, nombd);
                            String consulta2 = String.format("DROP DATABASE %s", nombd);

                            //Creamos una ventana de confirmacion para la modificacion del ingreso
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setHeaderText(null);
                            alert.setTitle("Confirmación");
                            alert.setContentText("¿Está seguro de qué quiere borrar esta base de datos?");
                            Optional<ButtonType> action = alert.showAndWait();
                            //Comprobamos si el usuario ha presionado el boton Ok, si es asi, ejecutaremos los siguientes metodos
                            if (action.orElseThrow() == ButtonType.OK) {
                                st1.executeUpdate(consulta5);
                                st1.executeUpdate(consulta2);
                                crearalertainfo("Base de datos eliminada");
                                rellenartablasbd();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                btentrar.addActionListener(e -> Platform.runLater(() -> {
                    singleton.setUsuario(btentrar.getName().substring(3));
                    System.out.println("Declarado: " + singleton.getUsuario());
                    System.out.println("Nombre del boton: " + btentrar.getName());
                    Scene scene = new Scene(root, 1536, 790);
                    stageerp.setScene(scene);
                    stageerp.centerOnScreen();
                    stageerp.setMaximized(true);
                    stageerp.show();
                    Label myLabel = (Label) root.lookup("#lblnombreusuario");
                    usuario = lblnombreusuario.getText();
                    myLabel.setText(usuario);
                    try {
                        Connection conexion2;
                        conexion2 = DriverManager.getConnection(conexionerp, user, pswd);
                        //Creamos la consulta con PreparedStatement
                        Statement st2 = conexion2.createStatement();
                        String consulta2 = String.format("Select nombre from bds where usuario = '%s'", prubuser);
                        ResultSet rs2 = st2.executeQuery(consulta2);
                        while (rs2.next()) {
                            if (Objects.equals(btentrar.getName(), "bt" + rs2.getString(1))) {

                            }
                        }
                    } catch (Exception eo) {
                        eo.printStackTrace();
                    }

                }));

                btentrar.setName("bte" + bd + prubuser.substring(0, 3));
                btel.setName("bteliminar" + bd + prubuser.substring(0, 3));
                node2.setContent(Panelbd);//Añade el contenido al nodeswing
                node2.setId("node" + nombd);//Cambia el nombre del nodo con respecto al nombre del empleado, deberas hacer que cambie con los nombres que vaya cogiendo de la base de datos
                Pgridbd.add(node2, cols, filas);//Va añadiendo los nodeswing al gridpane sumando filas y columnas
                filas++;
                if (filas >= 4) {
                    btaddbd.setDisable(true);
                }//debes deshabilitar el método cuandotodo el gripane esta lleno
                counter++;
            }

             */
            //Controlamos la excepciones
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void addlabels() {
        listalabels.clear();
        listalabels.add(labelbd1);
        listalabels.add(labelbd2);
        listalabels.add(labelbd3);
        listalabels.add(labelbd4);


        for (int i = 0; i < listalabels.size() - 1; i++) {
            listalabels.get(i).setVisible(false);
        }
    }

    private void adddirbotones(ArrayList<Button> listabotonesacceder, Button btaccederbd1, Button btaccederbd2, Button btaccederbd3, Button btaccederbd4) {
        listabotonesacceder.clear();
        listabotonesacceder.add(btaccederbd1);
        listabotonesacceder.add(btaccederbd2);
        listabotonesacceder.add(btaccederbd3);
        listabotonesacceder.add(btaccederbd4);

        for (int i = 0; i < listabotonesacceder.size() - 1; i++) {
            listabotonesacceder.get(i).setVisible(false);
        }
    }

    private void asignarJButton(JButton btel) {
        btel.setBackground(new Color(41, 45, 45));
        ImageIcon iconoeliminar = new ImageIcon("src/main/resources/sge/proyectoerp/img/eliminar.png");
        java.awt.Image newimgeliminar = iconoeliminar.getImage().getScaledInstance(7, 7, java.awt.Image.SCALE_SMOOTH);
        iconoeliminar = new ImageIcon(newimgeliminar);
        btel.setIcon(iconoeliminar);
    }


    private static boolean isNumeric(String cadena) {
        //Lo ejecutamos dentro del try para controlar las excepciones
        try {
            //Intentamos parsearlo a Long
            Long.parseLong(cadena);
            //Si lo consigue, nos devuelve true
            return true;
            //Controlamos la excepcion correspondiente
        } catch (NumberFormatException nfe) {
            //En caso de que no podamos transformar el numero, devolvera false
            return false;
        }
    }

    private void comprobrarregister() {
        compregister = false;
        if (Objects.equals(txtusuario1.getText(), "") || Objects.equals(txtcontrasena1.getText(), "") || Objects.equals(txtcontrasena11.getText(), "") || Objects.equals(txtemailregister.getText(), "") || Objects.equals(txttelregister.getText(), "")) {
            crearalertaerror("Debe rellenar todos los campos");
        } else if (txtusuario1.getLength() > 20) {
            crearalertaerror("El usuario no puede tener más de 20 carácteres");
        } else if (txtusuario1.getLength() < 4) {
            crearalertaerror("El usuario no puede tener menos de 4 carácteres");
        } else if (!Objects.equals(txtcontrasena1.getText(), txtcontrasena11.getText())) {
            crearalertaerror("Las contraseñas no coinciden");
        } else if (txtcontrasena1.getLength() > 16) {
            crearalertaerror("La contraseña no puede tener más de 16 carácteres");
        } else if (txttelregister.getLength() != 9) {
            crearalertaerror("El teléfono debe tener una longitud de 9 dígitos");
        } else if (!isNumeric(txttelregister.getText())) {
            crearalertaerror("El número de telefono no pueden ser letras");
        } else if (!imgrellena) {
            crearalertaerror("Rellenar una foto de perfil");
        } else {
            compregister = true;
        }
    }

    private void clearRegistro() {
        txtusuario1.clear();
        txtcontrasena1.clear();
        txtcontrasena11.clear();
        txtemailregister.clear();
        txttelregister.clear();
        Image imguser = new Image("src/main/resources/sge/proyectoerp/img/usuarioblanco.png");
        imgusuario.setImage(imguser);
    }

    @FXML
    public void pressbtnregistrarse() {
        //Definimos conexion como null
        Connection conexion = null;
        //Ejecutamos el comprobarlogin para controlar posibles fallos a la hora de hacer la consulta
        comprobrarregister();
        //Comprobamos que la variable complogin sea true
        if (compregister) {

            //Ejecutamos dentro de un try para controlar posibles excepciones
            try {
                conexion = DriverManager.getConnection(conexionerp, user, pswd);
                //Creamos la consulta con PreparedStatement
                PreparedStatement ps2 = conexion.prepareStatement("insert into usuarios VALUES (?, ?, ?, ?, ?)");
                ps2.setString(1, txtusuario1.getText());
                ps2.setString(2, txtcontrasena1.getText());
                ps2.setString(3, txtemailregister.getText());
                ps2.setString(4, txttelregister.getText());
                ps2.setString(5, "macaco.png");
                ps2.executeUpdate();
                crearalertainfo("Usuario Registrado");
                clearRegistro();

                //Controlamos la excepciones
            } catch (SQLException e) {
                try {
                    Connection conexion2;
                    conexion2 = DriverManager.getConnection(conexionerp, user, pswd);
                    Statement st2 = conexion2.createStatement();
                    conexion2 = DriverManager.getConnection(conexionerp, user, pswd);
                    Statement st4 = conexion2.createStatement();
                    st2.execute(consulta1);
                    st4.execute(consulta2);
                    st4.execute(consulta3);
                    st4.execute(consulta4);
                    pressbtnregistrarse();
                } catch (Exception eo) {
                    eo.printStackTrace();
                }
            } finally {
                try {
                    //Cerramos la conexion para ahorrar recursos
                    assert conexion != null;
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    public void pressaddbd() {
        txtnombd.setText(null);
        Pnewbd.setVisible(true);
        rellenartablasbd();
    }

    @FXML
    public void pressbtnewbd() {
        try {
            Connection conexion;
            Connection conexion2;
            bd = txtnombd.getText();
            pruebauser = lblnombreusuario.getText();
            boolean comnombrebd = true;
            conexion = DriverManager.getConnection(conexionerp, user, pswd);

            String consulta = String.format("Select Nombre from bds where Usuario = '%s'", pruebauser);
            Statement st = conexion.createStatement();

            ResultSet rs = st.executeQuery(consulta);

            if (rs.next()) {
                if (Objects.equals(bd, rs.getString(1))) {
                    crearalertaerror("Este nombre ya se esta usando en una base de datos");
                    comnombrebd = false;
                }
            }

            if (comnombrebd) {
                try {
                    String consulta34 = String.format("CREATE DATABASE IF NOT EXISTS %s;", bd + pruebauser.substring(0, 3));
                    st.execute(consulta34);
                    String consulta2 = String.format("INSERT INTO bds values ('%s', '%s')", bd, pruebauser);
                    st.execute(consulta2);
                    String conexionbdusuario = String.format("jdbc:mysql://localhost:3306/%s", bd + pruebauser.substring(0, 3));
                    conexion2 = DriverManager.getConnection(conexionbdusuario, user, pswd);
                    Statement st2 = conexion2.createStatement();
                    st2.executeUpdate(tabla1);
                    st2.executeUpdate(tabla2);
                    st2.executeUpdate(tabla3);
                    st2.executeUpdate(tabla4);
                    st2.executeUpdate(tabla5);
                    st2.executeUpdate(tabla6);
                    st2.executeUpdate(tabla7);
                    st2.executeUpdate(tabla8);
                    st2.executeUpdate(tabla9);
                    st2.executeUpdate(tabla10);

                    Pnewbd.setVisible(false);
                    nombd = txtnombd.getText();
                    rellenartablasbd();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void presscerrar() {
        txtnombd.setText(null);
        Pnewbd.setVisible(false);
    }

    //Obtiene la imagen a la hora de crear un empleado
    @FXML
    void seleccionarimg() {
        // Agregar filtros para facilitar la busqueda
        fil_chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"), new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
        // Obtener la imagen seleccionada
        File file = fil_chooser.showOpenDialog(selec);
        // Mostar la imagen
        if (file != null) {
            image = file.getPath();
            imagenem = new Image(image);
            imgrellena = true;
            imgempleado.setImage(imagenem);
        }
        assert file != null;
        String image = file.getPath();
        new Image(image);
        imageruta = file.getName();
    }

    //Metodo para extraer las fotos de la base de datos
    private Image extraerfotobdd(Connection con, ResultSet rs2) throws SQLException {
        PreparedStatement ps = con.prepareStatement("Select image from imgempleados where Foto = ?");
        ps.setString(1, rs2.getString(2));
        return rsconimg(ps);
    }

    //Metodo para reconocer las imagenes
    private Image rsconimg(PreparedStatement ps) throws SQLException {
        ResultSet rs4 = ps.executeQuery();
        Image imge = null;
        if (rs4.next()) {
            Blob blob = rs4.getBlob(1);
            byte[] bytes = blob.getBytes(1, (int) blob.length());
            imge = new Image(new ByteArrayInputStream(bytes));
        }
        return imge;
    }

    private void rellenarempleados() {
        cols = 0;
        filas = 0;
        Image imagenempleados = null;
        try {
            Connection conexion;
            String conexionbdusuario = String.format("jdbc:mysql://localhost:3306/%s", singleton.getUsuario());
            //Creamos la conexion
            conexion = DriverManager.getConnection(conexionbdusuario, user, pswd);
            Statement st = conexion.createStatement();
            String consultaempleados = "Select Nombre, Foto from empleados";
            ResultSet rs = st.executeQuery(consultaempleados);
            while (rs.next()) {
                imagenempleados = extraerfotobdd(conexion, rs);
                String nomempleado = String.valueOf(rs.getString(1));//Esto es una mera prueba para que obtenga el nombre del ultimo empleado añadido, deberas cambiarlo para que obtenga el de la base de datos
                SwingNode node = new SwingNode();
                JPanel newpane = new JPanel(new BorderLayout());//Creamos el panel que se va a añadir multiples veces
                newpane.setBorder(new EmptyBorder(10, 10, 10, 10));
                newpane.setBackground(new java.awt.Color(41, 45, 45));
                JLabel nombreempleado = new JLabel(nomempleado);//Aqui aparecerá el nombre de los empleados con respecto a la base de datos
                nombreempleado.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
                nombreempleado.setForeground(Color.white);
                JLabel imagen = new JLabel();
                imagen.setBorder(new EmptyBorder(10, 10, 10, 10));
                imagen.setIcon((Icon) imagenempleados);
                JPanel btpane = new JPanel(new GridLayout(2, 1));
                JButton bteliminar = new JButton();
                asignarJButton(bteliminar);
                JButton bteditar = new JButton();
                bteditar.setBackground(new java.awt.Color(41, 45, 45));
                ImageIcon iconoeditar = new ImageIcon("src/main/resources/sge/proyectoerp/img/lapiz.png");
                java.awt.Image newimgeditar = iconoeditar.getImage().getScaledInstance(7, 7, java.awt.Image.SCALE_SMOOTH);
                iconoeditar = new ImageIcon(newimgeditar);
                bteditar.setIcon(iconoeditar);
                btpane.add(bteliminar);
                btpane.add(bteditar);
                bteditar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent ed) {
                        cambiarpanel(PanelEmpleados, PanelEditEmpleados);
                    }
                });
                bteliminar.addActionListener(e -> {
                    //pressbtnCrearEmpleados();
                    //Eliminar de la base de datos el nombre de la persona que es el id el boton pulsado y usar la funcion para que se vuelva a rellenar el gridpane
                });
                //Establecemos la posicion en el panel de cada objeto
                newpane.add(btpane, BorderLayout.EAST);
                newpane.add(imagen, BorderLayout.WEST);
                newpane.add(nombreempleado, BorderLayout.CENTER);
                newpane.setVisible(true);
                bteditar.setName("bted" + rs.getString(1));
                bteliminar.setName("btel" + rs.getString(1));//Debe obtener el nombre de cada empleado de la bse de datos para su posterior eliminacion
                newpane.setName("panel" + counter);//El nombre de cada panel sera panel+numero de panel
                node.setContent(newpane);//Añade el contenido al nodeswing
                node.setId("node" + nomempleado);//Cambia el nombre del nodo con respecto al nombre del empleado, deberas hacer que cambie con los nombres que vaya cogiendo de la base de datos
                Pempleados.add(node, cols, filas);//Va añadiendo los nodeswing al gridpane sumando filas y columnas
                if (cols == 4) {
                    cols = -1;
                    filas++;
                }
                if (filas == 5 && cols == 5) {

                }//debes deshabilitar el método cuandotodo el gripane esta lleno
                cols++;
                counter++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Metodo que crea los paneles de cada empleado

    @FXML
    void pressbtnCrearEmpleados() {
        cambiarpanel(panelactual, PanelEmpleados);
        try {
            Connection conexion;
            String conexionbdusuario = String.format("jdbc:mysql://localhost:3306/%s", singleton.getUsuario());
            //Creamos la conexion
            conexion = DriverManager.getConnection(conexionbdusuario, user, pswd);
            PreparedStatement ps = conexion.prepareStatement("Insert into empleados values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, txtNombreEmpleado.getText());
            ps.setString(2, txtPuestodetrabajo.getText());
            ps.setString(3, txtTelefonoEmpleado.getText());
            ps.setString(4, txtemailEmpleado.getText());
            ps.setString(5, txtDepartamentoEmpleado.getText());
            ps.setString(6, txtGerenteEmpleado.getText());
            ps.setString(7, imageruta);
            ps.setString(8, txtDireccionLaboralEmpleado.getText());
            ps.setString(9, txtHorasSemanaEmpleado.getText());
            ps.setString(10, txtDireccionPersonal.getText());
            ps.setString(11, txtNumeroCuenta.getText());
            ps.setString(12, txtDNI.getText());
            ps.setString(13, txtGeneroEmpleado.getText());
            ps.setDate(14, Date.valueOf(dateFecNa.getValue()));
            ps.execute();
            crearalertainfo("Empleado Creado");
        } catch (Exception e) {
            e.printStackTrace();
        }
        rellenarempleados();
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
    void presslogout(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        app.start(new Stage());
    }

    @FXML
    void presscerrarbd(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
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
    void pressatrasinicio(ActionEvent event) {
        if (PRegistro.isVisible()) {
            ((Node) (event.getSource())).getScene().getWindow().hide();
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
        cambiarpanel(PanelMenuPrincipal, PanelVentas);
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
        rellenarempleados();
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
            lblAtrasRecepciones.setText("/ CREAR");
            txtReferencia.setDisable(false);
            btnCrearRecepciones.setText("CREAR");
            clearRecepciones();
        } else if (PanelExpediciones.isVisible()) {
            DateExpediciones.setValue(LocalDate.now());
            lblAtrasExp.setText("/ CREAR");
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
            String conexionbdusuario = String.format("jdbc:mysql://localhost:3306/%s", singleton.getUsuario());
            //Creamos la conexion
            conexion = DriverManager.getConnection(conexionbdusuario, user, pswd);
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
            lblAtrasRecepciones.setText("/ EDITAR");
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
            String conexionbdusuario = String.format("jdbc:mysql://localhost:3306/%s", singleton.getUsuario());
            //Creamos la conexion
            conexion = DriverManager.getConnection(conexionbdusuario, user, pswd);
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
        if (Objects.equals(btnCrearRecepciones.getText(), "EDITAR")) {
            //Creamos conexión null por si tuviéramos otra conexión cerrarla
            Connection conexion = null;
            //Ejecutamos dentro de un try para controlar todas las excepciones posibles
            try {
                //Creamos la conexión con la base de datos
                String conexionerpsusuario = String.format("jdbc:mysql://localhost:3306/%s?useServerPrepStmts=true", singleton.getUsuario());
                conexion = DriverManager.getConnection(conexionerpsusuario, user, pswd);
                //Utilizamos un PreparedStatement para la consulta para mayor seguridad

                Statement st = conexion.createStatement();
                //Parseamos la fecha
                String fecha = dateReferencia.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate localdate = parse(fecha);

                String consulta = String.format("UPDATE recepciones SET Nombre = '%s', " + "FechaPrevista = '%s', " + "Documento = '%s' " + "WHERE Referencia = '%s'", txtrecibir.getText(), Date.valueOf(localdate), txtDocumento.getText(), txtReferencia.getText());

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
                        String consulta2 = String.format("Update productosrec set Referencia = '%s', Producto = '%s', Cantidad = %s", txtReferencia.getText(), listrecepcione.getNombreproducto(), listrecepcione.getCantidad());
                        st.execute(consulta2);
                        crearalertainfo("Recepcion editada");
                        rellenartablaRecepciones();
                        cambiarpanel(PanelAddRecepciones, PanelRecepciones);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (Objects.equals(btnCrearRecepciones.getText(), "CREAR")) {
            //Creamos conexión null por si tuviéramos otra conexión cerrarla
            Connection conexion = null;
            //Ejecutamos dentro de un try para controlar todas las excepciones posibles
            try {
                //Creamos la conexión con la base de datos
                String conexionerpsusuario = String.format("jdbc:mysql://localhost:3306/%s?useServerPrepStmts=true", singleton.getUsuario());
                conexion = DriverManager.getConnection(conexionerpsusuario, user, pswd);
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
                        String consulta = String.format("insert into productosrec values ('%s', '%s', %s)", txtReferencia.getText(), listrecepcione.getNombreproducto(), listrecepcione.getCantidad());
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
            System.out.println("Base De Datos Rellenar Tabla: " + singleton.getUsuario());
            String conexionbdusuario = String.format("jdbc:mysql://localhost:3306/%s", singleton.getUsuario());
            conexion = DriverManager.getConnection(conexionbdusuario, user, pswd);
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
                obsrec.add(new Recepciones(rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4), rs.getString(5)));
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
            String conexionbdusuario = String.format("jdbc:mysql://localhost:3306/%s", singleton.getUsuario());
            conexion = DriverManager.getConnection(conexionbdusuario, user, pswd);
            Statement st = conexion.createStatement();
            TableExpediciones.getItems().clear();
            //Creamos la consulta
            String consulta = "SELECT Tel, Referencia, FechaPrevista, Documento, Estado FROM expediciones";
            System.out.println("Conexion: " + conexionbdusuario);
            //Guardamos la ejecución de la consulta en la variable rs
            ResultSet rs = st.executeQuery(consulta);
            //Bucle para seguir importando datos mientras los haya
            ObservableList<Expediciones> obsexp = FXCollections.observableArrayList();
            while (rs.next()) {
                //ObservableList para guardar dentro el paciente correspondiente para añadirlo a las columnas
                //Creamos un paciente, con los campos obtenidos de la consulta
                obsexp.add(new Expediciones(rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4), rs.getString(5)));
                //Relacionamos la columna con el campo del constructor correcto
                rellenarcolumnas();
                //Metemos dentro la tabla paciente la lista creada anteriormente
                TableExpediciones.setItems(obsexp);
            }
            //Refrescamos la tabla paciente
            TableExpediciones.refresh();
            //Controlamos las excepciones mostrándolas por la terminal
        } catch (Exception e) {
            e.printStackTrace();
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
        if (Objects.equals(btnCrearExpediciones.getText(), "EDITAR")) {
            //Creamos conexión null por si tuviéramos otra conexión cerrarla
            Connection conexion = null;
            //Ejecutamos dentro de un try para controlar todas las excepciones posibles
            try {
                //Creamos la conexión con la base de datos
                String conexionerpsusuario = String.format("jdbc:mysql://localhost:3306/%s?useServerPrepStmts=true", singleton.getUsuario());
                conexion = DriverManager.getConnection(conexionerpsusuario, user, pswd);
                //Utilizamos un PreparedStatement para la consulta para mayor seguridad

                Statement st = conexion.createStatement();
                //Parseamos la fecha
                String fecha = DateExpediciones.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate localdate = parse(fecha);

                String consulta = String.format("UPDATE expediciones SET Nombre = '%s', " + "FechaPrevista = '%s', " + "Direccion = '%s', " + "Documento = '%s' " + "WHERE Referencia = '%s'", txtnombreExpediciones.getText(), Date.valueOf(localdate), txtdireccionExpediciones.getText(), txtDocExp.getText(), txtReferenciaExpediciones.getText());

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
                        String consulta2 = String.format("Update productosexp set Referencia = '%s', Producto = '%s', Cantidad = %s", txtReferenciaExpediciones.getText(), listexp.getNombreproducto(), listexp.getCantidad());
                        st.execute(consulta2);
                    }
                    crearalertainfo("Expedicion editada");
                    rellenartablaExpediciones();
                    cambiarpanel(panelactual, PanelExpediciones);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (Objects.equals(btnCrearExpediciones.getText(), "CREAR")) {
            //Creamos conexión null por si tuviéramos otra conexión cerrarla
            Connection conexion = null;
            //Ejecutamos dentro de un try para controlar todas las excepciones posibles
            try {
                String conexionerpsusuario = String.format("jdbc:mysql://localhost:3306/%s?useServerPrepStmts=true", singleton.getUsuario());
                conexion = DriverManager.getConnection(conexionerpsusuario, user, pswd);
                PreparedStatement ps2 = conexion.prepareStatement("Select Nombre, Tel from Telefono where ");
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                //Creamos la conexión con la base de datos
                String conexionerpsusuario = String.format("jdbc:mysql://localhost:3306/%s?useServerPrepStmts=true", singleton.getUsuario());
                conexion = DriverManager.getConnection(conexionerpsusuario, user, pswd);
                //Utilizamos un PreparedStatement para la consulta para mayor seguridad
                PreparedStatement ps = conexion.prepareStatement("INSERT INTO expediciones (Referencia, Nombre, Direccion, FechaPrevista, Documento) VALUES  (?, ?, ?, ?, ?)");

                ps.setString(1, txtReferenciaExpediciones.getText());
                ps.setString(2, txtnombreExpediciones.getText());
                ps.setString(3, txtdireccionExpediciones.getText());
                //Parseamos la fecha
                String fecha = DateExpediciones.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate localdate = parse(fecha);
                ps.setDate(4, Date.valueOf(localdate));
                ps.setString(5, txtDocExp.getText());
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
                        String consulta = String.format("insert into productosexp values ('%s', '%s', %s)", txtReferenciaExpediciones.getText(), listexp.getNombreproducto(), listexp.getCantidad());
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
            String conexionbdusuario = String.format("jdbc:mysql://localhost:3306/%s", singleton.getUsuario());
            //Creamos la conexion
            conexion = DriverManager.getConnection(conexionbdusuario, user, pswd);
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
            String conexionbdusuario = String.format("jdbc:mysql://localhost:3306/%s", singleton.getUsuario());
            //Creamos la conexion
            conexion = DriverManager.getConnection(conexionbdusuario, user, pswd);
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
            String conexionbdusuario = String.format("jdbc:mysql://localhost:3306/%s", singleton.getUsuario());
            conexion = DriverManager.getConnection(conexionbdusuario, user, pswd);
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
                obsdev.add(new Devoluciones(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                //Relacionamos la columna con el campo del constructor correcto
                rellenarcolumnas();
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

    private void rellenarcolumnas() {
        ColumContExpediciones.setCellValueFactory(new PropertyValueFactory<>("contacto"));
        ColumExpReferencia.setCellValueFactory(new PropertyValueFactory<>("referencia"));
        ColumExpFecha.setCellValueFactory(new PropertyValueFactory<>("dateReferencia"));
        ColumExpDoc.setCellValueFactory(new PropertyValueFactory<>("docorigen"));
        ColumExpEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
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

    private void balon() throws InterruptedException {
        Thread.sleep(1000);
        rellenartablasbd();
    }

    @FXML
    void initialize() throws InterruptedException {
        System.out.println("Initialize");
        System.out.println("ID Del panel: " + panelcontrol.getId());
        // Obtener el título del stage actual
        if(Objects.equals(panelcontrol.getId(), "BasesDeDatos")){
            System.out.println("Entra");
            balon();
        }
    }
}
