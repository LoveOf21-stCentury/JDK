package seminar1.hw;

public class Test {
    public static void main(String[] args) {
        ServerWindow server = new ServerWindow();
        ClientGUI c1 = new ClientGUI(server);
        ClientGUI c2 = new ClientGUI(server);

        c1.sendMessage("first text");
        c2.sendMessage("text from second user");
    }
}
