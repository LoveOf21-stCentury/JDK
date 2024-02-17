package seminar1.hw;

import java.util.ArrayList;
import java.util.List;

class ServerWindow {
    private List<ClientGUI> clients = new ArrayList<>();
    private List<Message> messageHistory = new ArrayList<>();
// TODO: 2/17/2024 clear comments
//    не используется. в другой версии создавался List истории сообщений. после переформировала код,
//    но этот лист точно понадобится, поэтому оставила

    public void addMessage(String sender, String message) {
        Message newMessage = new Message(sender, message);
        messageHistory.add(newMessage);
        sendMessagesToAll(newMessage);
    }

    private void sendMessagesToAll(Message message) {
        for (ClientGUI cl : clients) {
            cl.receiveMessage(message);
        }
    }

    public void addClient(ClientGUI client) {
        clients.add(client);
    }
}
