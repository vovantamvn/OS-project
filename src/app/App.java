package app;

import app.constant.AppConstant;
import app.event.ChangePath;
import app.view.ScreenRoot;
import app.view.popup.ConfirmPopUp;
import app.view.popup.MessagePopUp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class App extends Application implements ChangePath {
    private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        Pane root = new ScreenRoot(this);
        primaryStage.setScene(new Scene(root, AppConstant.WIDTH, AppConstant.HEIGHT));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void change(String path) {
        stage.setTitle(path);
    }
}
