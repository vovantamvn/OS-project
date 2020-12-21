package app.view;

import app.constant.AppConstant;

import javafx.scene.control.Button;

public class BaseButton extends Button {
    public BaseButton(String name) {
        super(name);
        this.setPrefWidth(AppConstant.LEFT);
    }
}
