package seminar1.hw;

import java.util.List;

class ClientGUI {
    private ServerWindow server;
    private String name;

    public ClientGUI(ServerWindow server) {
        this.server = server;
        this.name = "User";
        server.addClient(this);
    }

    // TODO: 2/17/2024 clear comments
    // этот геттер нужен был для того, чтобы избежать дублирования вывода в консоль - в условии if
    // по имени сравнивать с отправителем и не использовать метод receiveMessage в классе ServerWindow
    // или что-то в этом роде.
    public String getName() {
        return name;
    }

    public void setServer(ServerWindow server) {
        this.server = server;
    }

    public void receiveMessage(Message message) {
        System.out.println(message.getSender() + ": " + message.getContent());
    }

    public void sendMessage(String message) {
        server.addMessage(name, message); // Отправляем сообщение серверу
    }

}
