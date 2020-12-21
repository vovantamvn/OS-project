package app.service.impl;

import app.service.DeleteFile;

import java.io.File;

public class DeleteFileImpl implements DeleteFile {

    @Override
    public boolean execute(String path) {
        File file = new File(path);

        if (!file.exists()) {
            return false;
        }

        return file.delete();
    }
}
