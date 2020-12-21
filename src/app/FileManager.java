package app;

import java.io.File;
import java.util.Optional;

public interface FileManager {
    boolean createDirectory(String path, String name);
    boolean createFile(String path, String name);
    boolean renameFile(String path, String name);
    boolean deleteFile(String path);
    boolean copyFile(String path, String directory);
}
