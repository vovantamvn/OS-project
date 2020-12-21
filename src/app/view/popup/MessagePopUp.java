package app.view.popup;

import javafx.scene.control.Alert;

public class MessagePopUp extends Alert {

    public MessagePopUp(String title, String header, String content) {
        super(AlertType.INFORMATION);
        this.setTitle(title);
        this.setHeaderText(header);
        this.setContentText(content);
    }

    public static void showPopUp(String title, String header, String content) {
        MessagePopUp popUp = new MessagePopUp(title, header, content);
        popUp.show();
    }
}
