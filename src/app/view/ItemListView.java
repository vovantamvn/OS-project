package app.view;

import app.constant.AppConstant;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ItemListView extends ListCell<File> {
    private ImageView imageView;
    private final Image imageFile;
    private final Image imageFolder;

    public ItemListView(){
        super();

        this.imageView = new ImageView();
        this.imageFile = ImageFactory.getInstance().getImageFile();
        this.imageFolder = ImageFactory.getInstance().getImageFolder();
    }

    @Override
    protected void updateItem(File file, boolean b) {
        super.updateItem(file, b);

        if (file == null || b) {
            this.setText(null);
            this.setGraphic(null);
            return;
        }

        if (file.isFile()) {
            imageView.setImage(imageFile);
        } else {
            imageView.setImage(imageFolder);
        }

        this.setText(file.getName());
        this.setGraphic(imageView);
    }
}
