package application;
	
import java.time.LocalDate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
	        // Controles
	        DatePicker fechaPicker = new DatePicker();
	        ColorPicker colorPicker = new ColorPicker();
	        Button confirmarButton = new Button("Confirmar");

	        // Etiquetas
	        Label fechaLabel = new Label("Selecciona una fecha:");
	        Label colorLabel = new Label("Selecciona un color:");
	        Label titulo =      new Label("Controles DatePicker y ColorPicker");

	        // VBox para organizar los elementos
	        VBox contenedor = new VBox();
	        contenedor.setSpacing(10);
	        contenedor.getChildren().addAll(titulo,fechaLabel, fechaPicker, colorLabel, colorPicker, confirmarButton);

	        // Manejo del evento "clic" del botón
	        confirmarButton.setOnAction(event -> {
	            LocalDate fechaSeleccionada = fechaPicker.getValue();
	            Color colorSeleccionado = colorPicker.getValue();

	            // Mostrar selecciones en la consola
	            System.out.println("Fecha seleccionada: " + fechaSeleccionada);
	            System.out.println("Color seleccionado: " + colorSeleccionado);

	            // Opcional: Mostrar selecciones en otro componente de la interfaz (por ejemplo, un Label)
	            Label resultadoLabel = new Label("Fecha: " + fechaSeleccionada + ", Color: " + colorSeleccionado);
	            contenedor.getChildren().add(resultadoLabel);
	        });

			BorderPane root = new BorderPane(contenedor);
			Scene scene = new Scene(root,300,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
