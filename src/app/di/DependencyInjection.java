package app.di;

import app.FileManager;
import app.FileManagerImpl;
import app.service.*;
import app.service.impl.*;

public enum DependencyInjection {
    INSTANCE;

    private CreateDirectory createDirectory = new CreateDirectoryImpl();
    private CreateFile createFile = new CreateFileImpl();
    private RenameFile renameFile = new RenameFileImpl();
    private DeleteFile deleteFile = new DeleteFileImpl();
    private CopyFile copyFile = new CopyFileImpl();
    private MoveDirectory moveDirectory = new MoveDirectoryImpl();
    private FileManager fileManager = new FileManagerImpl(
            createDirectory,
            createFile,
            renameFile,
            deleteFile,
            copyFile
    );

    public CreateDirectory getCreateDirectory() {
        return createDirectory;
    }

    public CreateFile getCreateFile() {
        return createFile;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public MoveDirectory getMoveDirectory() {
        return moveDirectory;
    }
}
