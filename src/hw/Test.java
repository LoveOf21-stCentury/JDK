package seminar1.hw;

public class Test {
    public static void main(String[] args) {
        ServerWindow server = new ServerWindow();
        new ClientGUI(server);
        new ClientGUI(server);

    }
}
