package app.view;

import app.constant.AppConstant;
import app.di.DependencyInjection;
import app.event.BackFolder;
import app.event.Func;
import app.event.MoveToChildren;
import app.event.OnItemSelected;
import app.service.FileManager;
import app.service.impl.FileManagerImpl;
import app.view.popup.ConfirmPopUp;
import app.view.popup.CustomTextInput;
import app.view.popup.MessagePopUp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import java.io.File;
import java.util.Optional;

public class ScreenRoot extends HBox implements MoveToChildren, BackFolder, OnItemSelected, Func {
    private final ListView<File> listView;
    private final FileManager fileManager123;
    private File selectedFile;

    private final app.FileManager fileManager;

    public ScreenRoot() {
        super();
        this.setWidth(AppConstant.WIDTH);
        this.setHeight(AppConstant.HEIGHT);

        this.fileManager = DependencyInjection.INSTANCE.getFileManager();

        this.fileManager123 = new FileManagerImpl();

        ObservableList<File> files = FXCollections.observableArrayList(
                this.fileManager123.getAllFiles()
        );

        this.listView = new ListView<>(files);

        this.getChildren().add(new ScreenController(this, this));
        this.getChildren().add(listView);

        double prefWidth = this.getWidth() - AppConstant.LEFT;
        this.listView.setPrefWidth(prefWidth);
        initItemListview();
    }

    public void initItemListview() {
        this.listView.setCellFactory(fileListView -> new ItemListView());
        this.listView.setOnMouseClicked(new DoubleClickItem(this, this));
    }

    @Override
    public void moveToChildren() {
        ObservableList<File> items = this.listView.getItems();
        File file = this.listView.getSelectionModel().getSelectedItem();
        if (this.fileManager123.moveToChildren(file)) {
            this.refreshItem();
        }
    }

    @Override
    public void moveToHome() {
        this.fileManager123.backToHome();
        this.refreshItem();
    }

    @Override
    public void backToParent() {
        if (this.fileManager123.backToParent()) {
            this.refreshItem();
        }
    }

    private void refreshItem() {
        ObservableList<File> items = this.listView.getItems();
        items.clear();
        items.addAll(this.fileManager123.getAllFiles());
    }

    @Override
    public void onItemSelected() {
        this.selectedFile = this.listView.getSelectionModel().getSelectedItem();
    }

    @Override
    public void delete() {
        if (this.selectedFile == null) {
            return;
        }

        ConfirmPopUp confirmPopUp = new ConfirmPopUp(
                "Confirm",
                "Xoá file",
                "Bạn có muốn xóa?"
        );

        Optional<ButtonType> buttonType = confirmPopUp.showAndWait();
        buttonType.ifPresent(button -> {
            if (button == ButtonType.OK) {
                String path = selectedFile.getPath();
                fileManager.deleteFile(path);

                refreshItem();
                selectedFile = null;
            }
        });
    }

    @Override
    public void rename() {
        if (this.selectedFile == null) {
            return;
        }

        CustomTextInput customTextInput = new CustomTextInput("Dialog", "Đổi tên", "Nhập tên");
        Optional<String> optName = customTextInput.showAndWait();

        optName.ifPresent(name -> {
            String path = selectedFile.getPath();
            fileManager.renameFile(path, name);

            refreshItem();
            selectedFile = null;
        });
    }

    @Override
    public void createDirectory() {
        if (selectedFile == null) {
            return;
        }

        CustomTextInput customTextInput = new CustomTextInput("Dialog", "Tạo thư mục", "Nhập tên");
        Optional<String> optName = customTextInput.showAndWait();

        optName.ifPresent(name -> {
            String path = selectedFile.getPath();
            boolean result = fileManager.createDirectory(path, name);

            if (result) {
                refreshItem();
                selectedFile = null;
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        });
    }

    @Override
    public void createFile() {
        if (selectedFile == null) {
            return;
        }

        CustomTextInput customTextInput = new CustomTextInput("Dialog", "Tạo tệp", "Nhập tên");
        Optional<String> optName = customTextInput.showAndWait();

        optName.ifPresent(name -> {
            String path = selectedFile.getPath();
            boolean result = fileManager.createFile(path, name);

            if (result) {
                refreshItem();
                selectedFile = null;
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        });
    }

    @Override
    public void copyFile() {
        if (selectedFile == null) {
            return;
        }

        CustomTextInput customTextInput = new CustomTextInput("Dialog", "Sao chép tệp", "Đường dẫn");
        Optional<String> optName = customTextInput.showAndWait();

        optName.ifPresent(directory -> {
            String path = selectedFile.getPath();
            boolean result = fileManager.copyFile(path, directory);

            if (result) {
                MessagePopUp.showPopUp(
                        "Message",
                        "Sao chép tệp",
                        "Bạn đã sao chép thành công"
                );
            } else {
                MessagePopUp.showPopUp(
                        "Message",
                        "Sao chép tệp",
                        "Đường dẫn không hợp lệ"
                );
            }
        });
    }
}
