package app.service.impl;

import app.service.CopyFile;

import java.io.*;

public class CopyFileImpl implements CopyFile {

    @Override
    public boolean execute(String filePath, String newFilePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            return false;
        }

        File newFile = new File(newFilePath);

        if (newFile.exists()){
            return false;
        }

        try {
            newFile.createNewFile();
            newFile.setWritable(true);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte bytes[] = bufferedInputStream.readAllBytes();

            OutputStream outputStream = new FileOutputStream(newFile);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
