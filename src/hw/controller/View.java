package hw.controller;

public interface View {
    void showMessage(String message);
    void disconnectFromServer();
    void connectedToServer();
}
