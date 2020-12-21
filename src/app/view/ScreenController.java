package app.view;

import app.constant.AppConstant;
import app.event.Func;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ScreenController extends VBox {
    private final Button backButton;
    private final Button homeButton;
    private final Button deleteButton;
    private final Button renameButton;
    private final Button createDirectory;
    private final Button createFile;
    private final Button copyFile;
    private final Func func;

    public ScreenController(Func func) {
        super();
        this.func = func;
        this.prefWidth(AppConstant.LEFT);

        this.backButton = new BaseButton("BACK");
        this.homeButton = new BaseButton("HOME");
        this.renameButton = new BaseButton("RENAME");
        this.deleteButton = new BaseButton("DELETE");
        this.createDirectory = new BaseButton("CREATE DIRECTORY");
        this.createFile = new BaseButton("CREATE FILE");
        this.copyFile = new BaseButton("COPY FILE");

        this.getChildren().addAll(
                this.backButton,
                this.homeButton,
                this.renameButton,
                this.deleteButton,
                this.createDirectory,
                this.createFile,
                this.copyFile
        );

        this.backButton.setOnMouseClicked(mouseEvent -> this.func.backToParent());
        this.homeButton.setOnMouseClicked(mouseEvent -> this.func.moveToHome());
        this.renameButton.setOnMouseClicked(mouseEvent -> this.func.rename());
        this.deleteButton.setOnMouseClicked(mouseEvent -> this.func.delete());
        this.createDirectory.setOnMouseClicked(mouseEvent -> this.func.createDirectory());
        this.createFile.setOnMouseClicked(mouseEvent -> this.func.createFile());
        this.copyFile.setOnMouseClicked(mouseEvent -> this.func.copyFile());
    }
}
