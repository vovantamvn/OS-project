package app.service;

import java.io.File;
import java.util.List;

public interface MoveDirectory {
    List<File> getAllFiles();
    boolean backToParent();
    void backToHome();
    boolean moveToChildren(File file);
    String getCurrentPath();
}
