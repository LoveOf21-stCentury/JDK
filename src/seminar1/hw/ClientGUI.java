package seminar1.hw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

class ClientGUI extends JFrame {
    public static int WIDTH = 400;
    public static int HEIGHT = 300;

    private ServerWindow server;
    private boolean connected;
    private String name;

    JTextArea log;
    JTextField tfIPAddress, tfPort, tfLogin, tfMessage;
    JPasswordField password;
    JButton btnLogin, btnSend;
    JPanel headerPanel;

    public ClientGUI(ServerWindow server) {
        this.server = server;

        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Client's chat");
        setLocation(server.getX() - 500, server.getY());
        createPanel();
        setVisible(true);
    }

    public void answer(String message) {
        appendLog(message);
    }

    public void connectToServer() {
        if (server.connectUser(this)) {
            appendLog("Successfully connected\n");
            headerPanel.setVisible(false);
            connected = true;
            name = tfLogin.getText();
            String log = server.getLogPath();
            if (log != null) {
                appendLog(log);
            }
        } else {
            appendLog("Connected broke");
        }
    }


    public void disconnectedFromServer() {
        if (connected) {
            headerPanel.setVisible(true);
            connected = false;
            server.disconnectUser(this);
            appendLog("You are disconnected from server");
        }
    }

    public void message() {
        if (connected) {
            String text = tfMessage.getText();
            if (!text.equals("")) {
                server.message(name + ": " + text);
                tfMessage.setText("");
            }
        } else {
            appendLog("Disconnected");
        }
    }

    private void appendLog(String message) {
        log.append(message + "\n");
    }

    private void createPanel() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createLog());
        add(createFooter(), BorderLayout.SOUTH);
    }

    private Component createHeaderPanel() {
        headerPanel = new JPanel(new GridLayout(2, 3));
        tfIPAddress = new JTextField("127.0.0.1");
        tfPort = new JTextField("8189");
        tfLogin = new JTextField("Mary MaryAnne");
        password = new JPasswordField("7654321");
        btnLogin = new JButton("login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        headerPanel.add(tfIPAddress);
        headerPanel.add(tfPort);
        headerPanel.add(new JPanel());
        headerPanel.add(tfLogin);
        headerPanel.add(password);
        headerPanel.add(btnLogin);

        return headerPanel;
    }

    private Component createLog() {
        log = new JTextArea();
        log.setEditable(false);
        return new JScrollPane(log);
    }

    private Component createFooter() {
        JPanel panel = new JPanel(new BorderLayout());
        tfMessage = new JTextField();
        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    message();
                }
            }
        });
        btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message();
            }
        });
        panel.add(tfMessage);
        panel.add(btnSend, BorderLayout.EAST);
        return panel;
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            disconnectedFromServer();
        }
        super.processWindowEvent(e);
    }
}
