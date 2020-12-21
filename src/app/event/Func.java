package app.event;

public interface Func {
    void moveToHome();
    void backToParent();
    void moveToChildren();
    void delete();
    void rename();
    void createDirectory();
    void createFile();
    void copyFile();
}
