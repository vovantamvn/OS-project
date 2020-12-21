package app.view.popup;

import javafx.scene.control.Alert;

public class ConfirmPopUp extends Alert {

    public ConfirmPopUp(String title, String header, String content) {
        super(AlertType.CONFIRMATION);
        this.setTitle(title);
        this.setHeaderText(header);
        this.setContentText(content);
    }
}
