package app.service.impl;

import app.service.CreateDirectory;

import java.io.File;

public class CreateDirectoryImpl implements CreateDirectory {

    @Override
    public boolean execute(String path, String name) {
        File file = new File(path + "/" + name);

        if (file.exists()) {
            return false;
        }

        return file.mkdir();
    }
}
