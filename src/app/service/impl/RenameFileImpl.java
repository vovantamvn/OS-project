package app.service.impl;

import app.service.RenameFile;

import java.io.File;

public class RenameFileImpl implements RenameFile {

    @Override
    public boolean execute(String filePath, String newName) {
        File file = new File(filePath);

        if (!file.exists()) {
            return false;
        }

        String parentPath = file.getParentFile().getPath();
        String newFilePath = parentPath + "/" + newName;

        File newFile = new File(newFilePath);

        if (newFile.exists()){
            return false;
        }

        return file.renameTo(newFile);
    }
}
