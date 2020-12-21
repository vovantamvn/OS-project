package app.service.impl;

import app.service.MoveDirectory;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class MoveDirectoryImpl implements MoveDirectory {
    private static final String HOME_PROPERTY = "user.home";
    private File currentFile;

    public MoveDirectoryImpl() {
        String homePath = System.getProperty(HOME_PROPERTY);
        currentFile = new File(homePath);
    }

    @Override
    public List<File> getAllFiles() {
        return Arrays.asList(currentFile.listFiles());
    }

    @Override
    public boolean backToParent() {
        File parent = currentFile.getParentFile();

        if (parent != null) {
            currentFile = parent;
            return true;
        }

        return false;
    }

    @Override
    public void backToHome() {
        currentFile = new File(System.getProperty(HOME_PROPERTY));
    }

    @Override
    public boolean moveToChildren(File file) {
        if (file == null || file.isFile()) {
            return false;
        }

        currentFile = file;
        return true;
    }

    @Override
    public String getCurrentPath() {
        return currentFile.getPath();
    }
}
