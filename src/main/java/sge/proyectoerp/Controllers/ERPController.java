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
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sge.proyectoerp.ERPApplication;
import sge.proyectoerp.Models.Recepciones;
import sge.proyectoerp.Models.Usuario;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static java.time.LocalDate.parse;

public class ERPController {

    @FXML
    private TextField txtempleado;
    @FXML
    private Button btnCrearRecepciones;

    @FXML
    private TableColumn<?, ?> Documentocolumn;

    @FXML
    private Pane PanelMenuPrincipal;
    @FXML
    private Label txtidpagina;

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
    private TableColumn<Recepciones, String> ProductoColum;

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
    private Pane PanelAddExpediciones;

    @FXML
    private Pane PanelAddDevoluciones;

    @FXML
    private Pane PanelExpediciones;

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
    private TableColumn<Recepciones, Integer> CantidadColum;

    @FXML
    private Button btnRecepciones;

    @FXML
    private Pane PanelInventarioInicial;

    @FXML
    private GridPane Pempleados;
    @FXML
    private Pane PanelRecepciones;

    @FXML
    private Pane PanelDevoluciones;
    @FXML
    private Pane PanelEmpleados;
    @FXML
    private Pane PanelAddEmpleados;

    @FXML
    private Pane PanelEditEmpleados;

    @FXML
    private Button btnFacturacion;

    @FXML
    private ImageView imgempleado;

    //CAMBIOS
    @FXML
    private Pane PInicio;

    @FXML
    private Pane PRegistro;
    @FXML
    private static Pane Pbasesdedatos;

    @FXML
    private Pane Pnewbd;

    @FXML
    private TextField txtnombd;

    @FXML
    private TextField txtusuario;
    @FXML
    Label lblnombreusuario;

    @FXML
    private GridPane Pgridbd;
    @FXML
    public static Button btacceder;
    @FXML
    Button btaddbd;
    @FXML
    Pane Pperfil;

    //CAMBIOS
    @FXML
    private ComboBox cbtipo;
    //Variables nuevas
    private Pane panelactual;

    private ArrayList<Recepciones> listrecepciones = new ArrayList<>();


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

    ObservableList<String> items1 = FXCollections.observableArrayList();
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
                            stageerp.show();
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
        String nomempleado = String.valueOf(txtempleado.getText());//Esto es una mera prueba para que obtenga el nombre del ultimo empleado añadido, deberas cambiarlo para que obtenga el de la base de datos
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
        bteliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                //pressbtnCrearEmpleados();
                //Eliminar de la base de datos el nombre de la persona que es el id el boton pulsado y usar la funcion para que se vuelva a rellenar el gridpane
            }
        });
        //Establecemos la posicion en el panel de cada objeto
        newpane.add(btpane, BorderLayout.EAST);
        newpane.add(imagen,BorderLayout.WEST);
        newpane.add(nombreempleado,BorderLayout.CENTER);
        newpane.setVisible(true);
        bteditar.setName("bted"+txtempleado.getText());
        bteliminar.setName("btel"+txtempleado.getText());//Debe obtener el nombre de cada empleado de la bse de datos para su posterior eliminacion
        newpane.setName("panel"+counter);//El nombre de cada panel sera panel+numero de panel
        node.setContent(newpane);//Añade el contenido al nodeswing
        node.setId("node"+nomempleado);//Cambia el nombre del nodo con respecto al nombre del empleado, deberas hacer que cambie con los nombres que vaya cogiendo de la base de datos
        Pempleados.add(node,cols,filas);//Va añadiendo los nodeswing al gridpane sumando filas y columnas
        if(cols==4){
            cols=-1;
            filas++;
        }
        if(filas==5 && cols==5){}//debes deshabilitar el método cuandotodo el gripane esta lleno
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
        if(PanelRecepciones.isVisible()||PanelExpediciones.isVisible()||PanelDevoluciones.isVisible()){
            cambiarpanel(panelactual, PanelInventarioInicial);
            dateReferencia.setValue(LocalDate.now());
            listrecepciones.clear();
        } else if (PanelAddRecepciones.isVisible()) {cambiarpanel(panelactual, PanelRecepciones);
        }else if (PanelAddExpediciones.isVisible()) {cambiarpanel(panelactual, PanelExpediciones);
        }else if (PanelAddDevoluciones.isVisible()) {cambiarpanel(panelactual,PanelDevoluciones);
        }else if (PanelAddEmpleados.isVisible() || PanelEditEmpleados.isVisible()) {cambiarpanel(panelactual,PanelEmpleados);
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
        items1.addAll("Recepciones", "Expediciones", "Devoluciones");
        cbtipo.setItems(items1);
    }

    @FXML
    void pressDevoluciones() {cambiarpanel(PanelInventarioInicial, PanelDevoluciones);
        items1.addAll("Recepciones", "Expediciones", "Devoluciones");
        cbtipo.setItems(items1);}

    @FXML
    void pressbtncrear() {
        if(PanelRecepciones.isVisible()){
            cambiarpanel(PanelRecepciones, PanelAddRecepciones);
            dateReferencia.setValue(LocalDate.now());
            listrecepciones.clear();
        }else if(PanelExpediciones.isVisible()){
            cambiarpanel(PanelExpediciones, PanelAddExpediciones);
        } else if (PanelDevoluciones.isVisible()) {
            cambiarpanel(PanelDevoluciones, PanelAddDevoluciones);
        } else if(PanelEmpleados.isVisible()){
            cambiarpanel(PanelEmpleados,PanelAddEmpleados);
        }

    }

    @FXML
    void selectInventario() {

    }

    @FXML
    void selectRecepciones() {
        //Ejecutaremos el codigo dentro de un try para controlar las excepciones
        try {
            //Creamos un médico con los datos selecionados de la tabla
            Recepciones rec = tableRecepciones.getSelectionModel().getSelectedItem();
            //Con un if comprobamos que los datos sean validos
            for (int i = 0; i < listrecepciones.size(); i++) {
                if(Objects.equals(listrecepciones.get(i).getNombreproducto(), rec.getNombreproducto())){
                    txtReferencia.setText(rec.getReferencia());
                    txtrecibir.setText(rec.getRecibir());
                    dateReferencia.setValue(rec.getDateReferencia());
                    txtDocumento.setText(rec.getDocorigen());
                    txtProducto.setText(rec.getNombreproducto());
                    txtCantidad.setText(String.valueOf(rec.getCantidad()));
                }
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
            PreparedStatement ps = conexion.prepareStatement("insert into Recepciones values (?, ?, ?, ?, ?, ?)");

            for (int i = 0; i < listrecepciones.size()-1; i++) {
                ps.setString(1, listrecepciones.get(i).getReferencia());
                ps.setString(2, listrecepciones.get(i).getRecibir());

                //Parseamos la fecha
                String fecha = listrecepciones.get(i).getDateReferencia().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate localdate = parse(fecha);

                ps.setDate(3, Date.valueOf(localdate));
                ps.setString(4, listrecepciones.get(i).getDocorigen());
                ps.setString(5, listrecepciones.get(i).getNombreproducto());
                ps.setInt(6, listrecepciones.get(i).getCantidad());
            }

            //Creamos una ventana de confirmacion para la modificacion del ingreso
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmación");
            alert.setContentText("Recuerde presionar en añadir producto para completar la insercion del producto");
            Optional<ButtonType> action = alert.showAndWait();
            //Comprobamos si el usuario ha presionado el boton Ok, si es asi, ejecutaremos los siguientes metodos
            if (action.orElseThrow() == ButtonType.OK) {
                ps.executeUpdate();
                crearalertainfo("Recepcion creada");
                cambiarpanel(PanelAddRecepciones, PanelRecepciones);
            }
        } catch (Exception e) {
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

        ProductoColum.setCellValueFactory(new PropertyValueFactory<>("nombreproducto"));
        CantidadColum.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        obsrec.setAll(listrecepciones);
        tableRecepciones.setItems(obsrec);
        tableRecepciones.refresh();
    }
    @FXML
    void pressbtnCrearExpediciones() {

    }

    @FXML
    void pressbtnCrearDevoluciones() {

    }
    @FXML
    void initialize() throws IOException {


    }
}
