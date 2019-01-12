package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String TITLE = "\t\tMillionaires";

    @Override
    public void start(Stage primaryStage) throws Exception{

        Thread.setDefaultUncaughtExceptionHandler(Main::showError); // handling exception in application

        Parent root = FXMLLoader.load(getClass().getResource("Application.fxml"));
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(new Scene(root, 716, 402));
        primaryStage.show();

    }


    public static void main(String[] args) {launch(args);}

    private static void showError(Thread t, Throwable ex ) { // if exception was caught

        ButtonType close = new ButtonType("OK", ButtonBar.ButtonData.APPLY);
        Alert alert = new Alert(Alert.AlertType.ERROR, "Error: " + ex.getMessage() + "\n\n\n Application must be closed!", close);

        alert.setTitle("\t\tFATAL ERROR");
        alert.showAndWait();
        System.exit(6); // 6 == SIGABRT

    }
}
