package app;

import app.constant.AppConstant;
import app.view.ScreenRoot;
import app.view.popup.ConfirmPopUp;
import app.view.popup.MessagePopUp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Pane root = new ScreenRoot();
        primaryStage.setTitle(AppConstant.APP_NAME);
        primaryStage.setScene(new Scene(root, AppConstant.WIDTH, AppConstant.HEIGHT));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
