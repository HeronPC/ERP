package sge.proyectoerp.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import sge.proyectoerp.Models.Recepciones;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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

    @FXML
    private ComboBox cbtipo;
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
    }

    @FXML
    void pressDevoluciones() {cambiarpanel(PanelInventarioInicial, PanelDevoluciones);}

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
    void initialize() {
        ObservableList<String> items1 = FXCollections.observableArrayList();
        items1.addAll("Recepciones", "Expediciones", "Devoluciones");
        cbtipo.setItems(items1);

    }
}
