package app;

import app.service.*;

import java.io.File;
import java.util.Optional;

public class FileManagerImpl implements FileManager {

    private final CreateDirectory createDirectory;
    private final CreateFile createFile;
    private final RenameFile renameFile;
    private final DeleteFile deleteFile;
    private final CopyFile copyFile;

    public FileManagerImpl(CreateDirectory createDirectory,
                           CreateFile createFile,
                           RenameFile renameFile,
                           DeleteFile deleteFile,
                           CopyFile copyFile) {
        this.createDirectory = createDirectory;
        this.createFile = createFile;
        this.renameFile = renameFile;
        this.deleteFile = deleteFile;
        this.copyFile = copyFile;
    }

    @Override
    public boolean createDirectory(String path, String name) {
        return createDirectory.execute(path, name);
    }

    @Override
    public boolean createFile(String path, String name) {
        return createFile.execute(path, name);
    }

    @Override
    public boolean renameFile(String path, String name) {
        return renameFile.execute(path, name);
    }

    @Override
    public boolean deleteFile(String path) {
        return deleteFile.execute(path);
    }

    @Override
    public boolean copyFile(String path, String directory) {
        return copyFile.execute(path, directory);
    }
}
