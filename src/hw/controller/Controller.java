package hw.controller;

public class Controller {
    private boolean connection;
    private View view;
    private User user;
    private Server server;

    public Controller(View view, Server server) {
        this.view = view;
        this.server = server;
    }

    public boolean connectToServer(User userName) {
        if (user != null) {
            this.name = user.getName();
            if (server.connectUser(this)) {
                showOnWindow("Connected!\n");
                connection = true;
                String log = server.getHistory();
                if (log != null) {
                    showOnWindow(log);
                }
                return true;
            } else {
                showOnWindow("Didn't connected");
                return false;
            }
        } else {
            return false;
        }
    }

    public void disconnectFromServer() {
        if (connection) {
            connection = false;
            server.disconnectUser(this);
            view.disconnectFromServer();
            showOnWindow("You've been disconnected from server!");
        }
    }

    public void answerFromServer(String messageFromServer) {
        showOnWindow(messageFromServer);
    }

    public void sendMessage(String message) {
        if (connection) {
            if (!message.isEmpty()) {
                server.sendMessage(name + ": " + message);
            }
        } else {
            showOnWindow("No connection to server");
        }
    }

    private void showOnWindow(String text) {
        view.showMessage(text + "\n");
    }
}
