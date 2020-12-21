package app.view;

import app.constant.AppConstant;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageFactory {
    private Image imageFile;
    private Image imageFolder;

    private final static String FILE_URL = AppConstant.ROOT_PATH + "/images/file.png";
    private final static String FOLDER_URL = AppConstant.ROOT_PATH + "/images/folder.png";

    private ImageFactory() {
        try {
            this.imageFile = new Image(new FileInputStream(FILE_URL));
            this.imageFolder = new Image(new FileInputStream(FOLDER_URL));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Image getImageFile() {
        return imageFile;
    }

    public Image getImageFolder() {
        return imageFolder;
    }

    public static ImageFactory getInstance() {
        return SingleTonHepper.INSTANCE;
    }

    private static class SingleTonHepper{
        private static final ImageFactory INSTANCE = new ImageFactory();
    }
}
