package org.example.proyecto;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.example.proyecto.models.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class DashboardController implements Initializable {
    @FXML
    private TableView<Curso> tableViewCurso;
    @FXML
    private TableColumn<Curso, String> cursoCol;
    @FXML
    private TableColumn<Curso, String> horarioCol;
    @FXML
    private TableColumn<Curso, String> locacionCol;
    @FXML
    private TableColumn<Curso, String> categoriaCol;
    @FXML
    private TableColumn<Curso, Integer> cupoCol;
    @FXML
    private TableColumn<Curso, String> seleccionarCol;

    private Horario horario;

    @FXML
    private Text alumnoSelec; // Debe ser Text, ya que en el FXML es un Text

    public void setHorario(Horario horario) {
        this.horario = horario;
        System.out.println("Set: " + horario.getAlumno().getNombre());

        // Actualizar el Text con el nombre del alumno seleccionado
        alumnoSelec.setText(horario.getAlumno().getNombre());
    }

    private static final List<Curso> CURSO_LIST = Collections.unmodifiableList(
            FXCollections.observableArrayList(
                    new Avanzado("Calculo Integral", "11:00 a.m - 01:00 p.m", "CC03 304", "Avanzado", 41, 40, false),
                    new Avanzado("Programación II", "7:00 a.m - 9:00 a.m", "CC03 203", "Avanzado", 37, 40, true),
                    new Basico("Álgebra Lineal", "9:00 a.m - 11:00 a.m", "CCO1 101", "Básico", 35 , 60, true),
                    new Basico("Programación I", "7:00 a.m - 9:00 a.m", "CC03 202", "Básico", 33, 40,true),
                    new Avanzado("Ingeniería de Software", " 7:00 a.m - 8:59 a.m", "CCO3 104", "Avanzado", 34, 30, true),
                    new Basico("Fisica I", " 11:00 a.m - 1:00 p.m", "CCO3 103", "Básico", 35, 40, true),
                    new Avanzado("Formacion Humana y Social", " 11:00 a.m - 8:59 a.m", "CCO3104", "Avanzado", 35, 40, false),
                    new Basico("DHPC", "11:00 a.m - 1:00 p.m", "CCO4 101", "Básico", 30, 10, false),
                    new Avanzado("Estructura de Datos", "9:00 a.m - 11:00 a.m", "CCO2 101", "Avanzado", 30, 35, true),
                    new Basico("lengua Extranjera III", "5:00 p.m - 7:00 p.m", "CCO1 101V", "Básico", 40, 20,  false)
                    )
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadCursos();
    }

    private void loadCursos() {
        // Bind the CURSO_LIST to the TableView
        tableViewCurso.setItems(FXCollections.observableArrayList(CURSO_LIST));

        cursoCol.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        horarioCol.setCellValueFactory(new PropertyValueFactory<>("Horario"));
        locacionCol.setCellValueFactory(new PropertyValueFactory<>("Locacion"));
        categoriaCol.setCellValueFactory(new PropertyValueFactory<>("Categoria"));
        cupoCol.setCellValueFactory(new PropertyValueFactory<>("Cupo"));


        Callback<TableColumn<Curso, String>, TableCell<Curso, String>> cellFactory = (TableColumn<Curso, String> param) -> new TableCell<Curso, String>() {
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                    setText(null);
                } else {
                    Curso curso = getTableView().getItems().get(getIndex());

                    // Crear el ImageView con la imagen del icono
                    Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/icon_add.png")));
                    ImageView iconImageView = new ImageView(image);
                    iconImageView.setFitWidth(28); // Ajustar el ancho según sea necesario
                    iconImageView.setFitHeight(28); // Ajustar el alto según sea necesario

                    iconImageView.setOnMouseClicked((MouseEvent event) -> {
                        Curso selectedCurso = tableViewCurso.getSelectionModel().getSelectedItem();
                        if (selectedCurso != null) {
                            // Verificar si ya se han seleccionado 6 cursos
                            if (horario.getListaCursos().size() < 6) {
                                // Verificar si el curso seleccionado no está ya en la lista
                                if (!horario.getListaCursos().contains(selectedCurso)) {
                                    // Agregar el curso seleccionado a la lista
                                    horario.agregarCurso(selectedCurso);
                                    System.out.println("Curso seleccionado: " + selectedCurso.getNombre());
                                    // showAlert()
                                } else {
                                    System.out.println("¡El curso ya ha sido seleccionado!");
                                    showAlert(Alert.AlertType.ERROR, "Error", "¡El curso ya ha sido seleccionado!");

                                }
                            } else {
                                showAlert(Alert.AlertType.ERROR, "Error", "¡Ya has seleccionado el máximo de cursos permitidos!");
                                System.out.println("¡Ya has seleccionado el máximo de cursos permitidos!");
                            }
                        }
                    });

                    // Crear un Rectangle para el fondo de color
                    Rectangle background = new Rectangle(28, 28); // Ancho y alto del icono
                    background.setFill(Color.rgb(0, 230, 118)); // Color de fondo (verde)

                    // Crear un StackPane para colocar el ImageView y el Rectangle
                    StackPane iconStackPane = new StackPane();
                    iconStackPane.getChildren().addAll(background, iconImageView);

                    // Configurar el estilo del StackPane (opcional)
                    iconStackPane.setStyle("-fx-cursor: hand; -fx-padding: 2px;");

                    // Asignar el StackPane como el gráfico de la celda en la tabla
                    setGraphic(iconStackPane);
                    setText(null); // Limpiar el texto de la celda

                }
            }
        };
        seleccionarCol.setCellFactory(cellFactory);
    }

    @FXML
    private void guardarCursos() {
        if (horario.getListaCursos().isEmpty()) {
            // Mostrar mensaje de error
            showAlert(Alert.AlertType.ERROR, "Error", "No hay cursos seleccionados para guardar.");
            return; // Salir del método si no hay cursos seleccionados
        }

        try {
            horario.setCantMaterias(horario.getListaCursos().size());
            // Obtener la ruta del archivo
            String rutaArchivo = "horario_" + horario.getAlumno().getMatricula() + ".txt";
            FileWriter fileWriter = new FileWriter(rutaArchivo);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write("********** HORARIO DE CURSOS **********");
            writer.newLine();
            writer.newLine();

            // Escribir el encabezado
            writer.write("Nombre del alumno: " + horario.getAlumno().getNombre());
            writer.newLine();
            writer.write("_______________________________________");
            writer.newLine();
            writer.newLine(); // Agregar una línea en blanco

            // Escribir el encabezado
            writer.write("Número de cursos seleccionados: " + horario.getCantMaterias());
            writer.newLine();
            writer.newLine(); // Agregar una línea en blanco

            // Escribir los detalles de los cursos seleccionados
            for (Curso curso : horario.getListaCursos()) {
                writer.write("Nombre del curso: " + curso.getNombre());
                writer.newLine();
                writer.write("Horario: " + curso.getHorario());
                writer.newLine();
                writer.write("Locación: " + curso.getLocacion());
                writer.newLine();
                writer.write("Categoría: " + curso.getCategoria());
                writer.newLine();
                writer.write("Cupo: " + curso.getCupo());
                writer.newLine();
                writer.newLine();
                writer.write("_______________________________________");
                writer.newLine();
                writer.newLine();
            }

            writer.close();
            System.out.println("Cursos seleccionados guardados en " + rutaArchivo);
            showAlert(Alert.AlertType.CONFIRMATION, "Guardado", "¡Tu horario ha sido guardado exitosamente!");

        } catch (IOException e) {
            System.out.println("Error al guardar los cursos seleccionados: " + e.getMessage());
            showAlert(Alert.AlertType.ERROR, "Error", "¡Error al guardar el horario!");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void cerrarSesionDesdeMenu() {
        if (horario.getAlumno() != null) {
            Stage stage = (Stage) tableViewCurso.getScene().getWindow();
            horario.getAlumno().cerrarSesion(stage);
        }
    }
}
