package app.service.impl;

import app.service.CreateFile;

import java.io.File;
import java.io.IOException;

public class CreateFileImpl implements CreateFile {

    @Override
    public boolean execute(String path, String name) {
        File file = new File(path + "/" + name);

        if (file.exists()) {
            return false;
        }

        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
