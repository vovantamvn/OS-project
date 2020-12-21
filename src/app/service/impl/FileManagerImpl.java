package app.service.impl;

import app.service.FileManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManagerImpl implements FileManager {
    private static final String HOME_PROPERTY = "user.home";
    private String path;

    public FileManagerImpl() {
        this.path = System.getProperty(HOME_PROPERTY);
    }

    @Override
    public List<File> getAllFiles() {
        List<File> files = new ArrayList<>();
        File file = new File(this.path);

        if (file.isDirectory()) {
            for (File item : file.listFiles()) {
                files.add(item);
            }
        } else {
            files.add(file);
        }

        return files;
    }

    @Override
    public boolean backToParent() {
        try {
            File file = new File(this.path);
            this.path = file.getParentFile().getPath();
            return true;

        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public void backToHome() {
        this.path = System.getProperty(HOME_PROPERTY);
    }

    @Override
    public boolean moveToChildren(File file) {
        if (file == null || file.isFile()) {
            return false;
        }

        this.path = file.getPath();
        return true;
    }
}
