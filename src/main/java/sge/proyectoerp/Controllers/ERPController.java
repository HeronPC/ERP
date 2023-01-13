package sge.proyectoerp.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
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
import sge.proyectoerp.Models.Devoluciones;
import sge.proyectoerp.Models.Expediciones;
import sge.proyectoerp.Models.Recepciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

import static java.time.LocalDate.parse;

public class ERPController {

    @FXML
    private Button btnCrearRecepciones;

    @FXML
    private TableColumn<Recepciones, Integer> CantidadColum;

    @FXML
    private ImageView imgempleado1;

    @FXML
    private TextField txtCantidadDevoluciones;

    @FXML
    private Pane PanelExpediciones;

    @FXML
    private Button btcuenta;

    @FXML
    private Button btnExpediciones;

    @FXML
    private TextField txtTelefonoEmpleado;

    @FXML
    private Button btnDevolucionesAdd;

    @FXML
    private TableColumn<Devoluciones, String> ColumProductDevoluciones;

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
    private TableColumn<?, ?> ColumExpFecha;

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
    private TableColumn<?, ?> ColumExpEstado;

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
    private TableView<?> TableExpediciones;

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
    private TableView<?> tablaExp;

    @FXML
    private Label nombreusuario;

    @FXML
    private TextField txtemailEmpleado;

    @FXML
    private Button btnExpAdd;

    @FXML
    private TableView<Devoluciones> tableDevoluciones;

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
    private TableView<?> TableDevoluciones;

    @FXML
    private ImageView imgperfil1121;

    @FXML
    private TableColumn<?, ?> contactocolumn;

    @FXML
    private TableColumn<Recepciones, String> ProductoColum;

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
    private TableColumn<Devoluciones, Integer> ColumCantidadDevoluciones;

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
    private TextField txtrecibir;

    @FXML
    private Button btnInventario;

    @FXML
    private Button btnVolverRecepciones;

    @FXML
    private Button btnVolverDevolNew;

    @FXML
    private TableColumn<?, ?> ColumExpReferencia;

    @FXML
    private TextField txtDocumentoEditarEmpleado;

    @FXML
    private Label txtidpagina;

    @FXML
    private TableView<Recepciones> tableInventarioRecep;

    @FXML
    private Button btncrearExpediciones;

    @FXML
    private TableColumn<?, ?> ColumContExpediciones;

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
    private TableColumn<?, ?> ColumExpDoc;

    @FXML
    private Button btnFacturacion;

    @FXML
    private Label lblAtrasRecepciones;

    @FXML
    private Label lblAtrasExpediciones;

    @FXML
    private Label lblAtrasDevoluciones;


    //Variables nuevas
    private Pane panelactual;

    private final ArrayList<Recepciones> listrecepciones = new ArrayList<>();
    private final ArrayList<Expediciones> listexpediciones = new ArrayList<>();
    private final ArrayList<Devoluciones> listdevoluciones = new ArrayList<>();

    String bdd = "erp";

    //Creamos la cadena con la que tenemos la direccion de la base de datos
    private final String cadconexion = String.format("jdbc:mysql://localhost:3306/%s", bdd);

    private final String cadconexionps = String.format("jdbc:mysql://localhost:3306/%s?useServerPrepStmts=true", bdd);
    //Esta variable tiene el usuario con el que nos conectaremos a la base de datos
    private final String user = "root";
    //Esta es la contraseña del usuario anterior para conectarnos a la base de datos
    private final String pswd = "root";

    //Debes crear otro método que añada los distintos departamentos que se vayan creando en la base de datos y se rellenen los gridlayout de los distintos departamentos
    int counter = 0;
    int filas = 0;
    int cols = 0;

    String referenciaactual;

    Stage selec = new Stage();

    // create a File chooser
    FileChooser fil_chooser = new FileChooser();
    String image;
    Image imagenem;

    //Métodos generales
    //Obtiene la imagen a la hora de crear un empleado
    @FXML
    void seleccionarimg() {
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
        String nomempleado = String.valueOf(txtNombreEmpleado.getText());//Esto es una mera prueba para que obtenga el nombre del ultimo empleado añadido, deberas cambiarlo para que obtenga el de la base de datos
        SwingNode node = new SwingNode();
        JPanel newpane = new JPanel(new BorderLayout());//Creamos el panel que se va a añadir multiples veces
        newpane.setBorder(new EmptyBorder(10, 10, 10, 10));
        newpane.setBackground(new java.awt.Color(41, 45, 45));
        JLabel nombreempleado = new JLabel(nomempleado);//Aqui aparecerá el nombre de los empleados con respecto a la base de datos
        nombreempleado.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        nombreempleado.setForeground(Color.white);
        JLabel imagen = new JLabel();
        imagen.setBorder(new EmptyBorder(10, 10, 10, 10));
        ImageIcon icono = new ImageIcon(image);//establece la dirección url de la imagen de perfil del empleado, debera cambiar respecto a la base de datos
        java.awt.Image newimg = icono.getImage().getScaledInstance(54, 61, java.awt.Image.SCALE_SMOOTH);//Redimensiona la imagen
        icono = new ImageIcon(newimg);
        imagen.setIcon(icono);
        JPanel btpane = new JPanel(new GridLayout(2, 1));
        JButton bteliminar = new JButton();
        bteliminar.setBackground(new java.awt.Color(41, 45, 45));
        ImageIcon iconoeliminar = new ImageIcon("src/main/resources/sge/proyectoerp/img/eliminar.png");
        java.awt.Image newimgeliminar = iconoeliminar.getImage().getScaledInstance(7, 7, java.awt.Image.SCALE_SMOOTH);
        iconoeliminar = new ImageIcon(newimgeliminar);
        bteliminar.setIcon(iconoeliminar);
        JButton bteditar = new JButton();
        bteditar.setBackground(new java.awt.Color(41, 45, 45));
        ImageIcon iconoeditar = new ImageIcon("src/main/resources/sge/proyectoerp/img/lapiz.png");
        java.awt.Image newimgeditar = iconoeditar.getImage().getScaledInstance(7, 7, java.awt.Image.SCALE_SMOOTH);
        iconoeditar = new ImageIcon(newimgeditar);
        bteditar.setIcon(iconoeditar);
        btpane.add(bteliminar);
        btpane.add(bteditar);
        bteditar.addActionListener(ed -> cambiarpanel(PanelEmpleados, PanelEditEmpleados));
        bteliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                //pressbtnCrearEmpleados();
                //Eliminar de la base de datos el nombre de la persona que es el id el boton pulsado y usar la funcion para que se vuelva a rellenar el gridpane
            }
        });
        //Establecemos la posicion en el panel de cada objeto
        newpane.add(btpane, BorderLayout.EAST);
        newpane.add(imagen, BorderLayout.WEST);
        newpane.add(nombreempleado, BorderLayout.CENTER);
        newpane.setVisible(true);
        bteditar.setName("bted" + txtNombreEmpleado.getText());
        bteliminar.setName("btel" + txtNombreEmpleado.getText());//Debe obtener el nombre de cada empleado de la bse de datos para su posterior eliminacion
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
    void pressatras() {
        if (PanelRecepciones.isVisible() || PanelExpediciones.isVisible() || PanelDevoluciones.isVisible()) {
            cambiarpanel(panelactual, PanelInventarioInicial);
            dateReferencia.setValue(LocalDate.now());
            listrecepciones.clear();
        } else if (PanelAddRecepciones.isVisible()) {
            cambiarpanel(panelactual, PanelRecepciones);
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
        //Definimos el campo de conexion como null
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
            ResultSet rs2 = st.executeQuery(consulta);
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
                for (int i = 0; i < listrecepciones.size(); i++) {
                    String consulta = String.format("insert into productosrec values ('%s', '%s', %s)",
                            txtReferencia.getText(),
                            listrecepciones.get(i).getNombreproducto(),
                            listrecepciones.get(i).getCantidad());
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
        //Parseamos la fecha
        //Establecemos la conexion en null, por si estaba abierta anteriormente
        Connection conexion = null;
        //Ejecutamos el código en un try para controlar las excepciones
        try {
            //Creamos la conexion
            conexion = DriverManager.getConnection(cadconexionps, user, pswd);

            listrecepciones.add(new Recepciones(txtProducto.getText(), Integer.parseInt(txtCantidad.getText())));
            txtProducto.clear();
            txtCantidad.clear();
            rellenartablaAddRecepciones();

            /*
            PreparedStatement ps2 = conexion.prepareStatement("insert into productosrec values (?, ?, ?)");
            ps2.setString(1, txtReferencia.getText());
            ps2.setString(2, txtProducto.getText());
            ps2.setInt(3, Integer.parseInt(txtCantidad.getText()));
            ps2.executeUpdate();
            rellenartablaAddRecepciones();
             */
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
    void pressbtnCrearExpediciones() {

    }

    @FXML
    void pressbtnCrearDevoluciones() {

    }

    @FXML
    void pressbtncrearExpediciones() {

    }

    @FXML
    void SelectExpediciones() {

    }

    @FXML
    void selectExpediciones() {

    }

    @FXML
    void pressbtnExpAdd() {

    }

    @FXML
    void pressbtncrearDevoluciones() {

    }

    @FXML
    void SelectDevoluciones() {

    }


    @FXML
    void selectDevoluciones() {

    }

    @FXML
    void pressbtncrearEmpleados() {

    }

    @FXML
    void selectDepartamentos() {

    }

    @FXML
    void pressbtnEditarEmpleados() {

    }

    @FXML
    void initialize() {
        assert btnCrearRecepciones != null : "fx:id=\"btnCrearRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert CantidadColum != null : "fx:id=\"CantidadColum\" was not injected: check your FXML file 'erp.fxml'.";
        assert imgempleado1 != null : "fx:id=\"imgempleado1\" was not injected: check your FXML file 'erp.fxml'.";
        assert tableInventarioRecep != null : "fx:id=\"tableInventarioRecep\" was not injected: check your FXML file 'erp.fxml'.";
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
        assert lblAtrasExpediciones != null : "fx:id=\"lblAtrasExpediciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert dateReferencia != null : "fx:id=\"dateReferencia\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtReferencia != null : "fx:id=\"txtReferencia\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnAddDevoluciones != null : "fx:id=\"btnAddDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnSeleccionarIMGEditarEmpleado != null : "fx:id=\"btnSeleccionarIMGEditarEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtDepartamentoEmpleado != null : "fx:id=\"txtDepartamentoEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtCantidadExp != null : "fx:id=\"txtCantidadExp\" was not injected: check your FXML file 'erp.fxml'.";
        assert tableRecepciones != null : "fx:id=\"tableRecepciones\" was not injected: check your FXML file 'erp.fxml'.";
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
        assert lblAtrasDevoluciones != null : "fx:id=\"lblAtrasDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert tableDepartamentos != null : "fx:id=\"tableDepartamentos\" was not injected: check your FXML file 'erp.fxml'.";
        assert TableExpediciones != null : "fx:id=\"TableExpediciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtHorasSemanalesEditarEmpleado != null : "fx:id=\"txtHorasSemanalesEditarEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtProductoDevoluciones != null : "fx:id=\"txtProductoDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnCrearDevoluciones != null : "fx:id=\"btnCrearDevoluciones\" was not injected: check your FXML file 'erp.fxml'.";
        assert btnVolverEmpEdit != null : "fx:id=\"btnVolverEmpEdit\" was not injected: check your FXML file 'erp.fxml'.";
        assert txtTelefonoEditarEmpleado != null : "fx:id=\"txtTelefonoEditarEmpleado\" was not injected: check your FXML file 'erp.fxml'.";
        assert tablaExp != null : "fx:id=\"tablaExp\" was not injected: check your FXML file 'erp.fxml'.";
        assert nombreusuario != null : "fx:id=\"nombreusuario\" was not injected: check your FXML file 'erp.fxml'.";
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
        rellenartablaRecepciones();
    }
}