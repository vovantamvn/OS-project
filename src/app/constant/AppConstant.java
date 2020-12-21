package app.constant;

import javafx.stage.Screen;

public class AppConstant {
    private AppConstant(){}

    public static final double WIDTH = Screen.getPrimary().getBounds().getWidth();
    public static final double HEIGHT = Screen.getPrimary().getBounds().getHeight();
    public static final String APP_NAME = "App";
    public static final double LEFT = 250;
    public static final String ROOT_PATH = System.getProperty("user.dir");
}
