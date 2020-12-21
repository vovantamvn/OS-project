package app.view.popup;

import javafx.scene.control.*;

public class CustomTextInput extends TextInputDialog {

    public CustomTextInput(String title, String header, String content) {
        super();

        setTitle(title);
        setHeaderText(header);
        setContentText(content);
    }
}
