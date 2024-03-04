//package hw.sem1.server;
//
//import hw.sem1.controller.ClientGUI;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ServerWindow extends JFrame {
//    public static final int WIDTH = 400;
//    public static final int HEIGHT = 300;
//    public static final String LOG_PATH = "src/seminar1/hw/log.txt";
//    List<ClientGUI> clients;
//
//    JButton btnStart, btnEnd;
//    JTextArea log;
//    boolean work;
//
//    public ServerWindow() {
//        clients = new ArrayList<>();
//
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setSize(WIDTH, HEIGHT);
//        setResizable(false);
//        setTitle("Chat");
//        setLocationRelativeTo(null);
//
//        createPanel();
//        setVisible(true);
//    }
//
//    public boolean connectUser(ClientGUI client) {
//        if (!work) {
//            return false;
//        }
//        clients.add(client);
//        return true;
//    }
//
//    public String getLogPath() {
//        return readLog();
//    }
//
//    public void disconnectUser(ClientGUI client) {
//        clients.remove(client);
//        if (client != null) {
//            client.disconnectFromServer();
//        }
//    }
//
//    public void message(String message) {
//        if (!work) return;
//        appendLog(message);
//        answerLog(message);
//        saveInLog(message);
//    }
//
//    private void answerLog(String message) {
//        for (ClientGUI cl : clients) {
//            cl.answer(message);
//        }
//    }
//
//    private void saveInLog(String message) {
//        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
//            writer.write(message);
//            writer.write("\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private String readLog() {
//        StringBuilder stringBuilder = new StringBuilder();
//        try (FileReader reader = new FileReader(LOG_PATH)) {
//            int c;
//            while ((c = reader.read()) != -1) {
//                stringBuilder.append((char) c);
//            }
//            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
//            return stringBuilder.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    private void appendLog(String message) {
//        log.append(message + "\n");
//    }
//
//    private void createPanel() {
//        log = new JTextArea();
//        add(log);
//        add(createButtons(), BorderLayout.SOUTH);
//    }
//
//    private Component createButtons() {
//        JPanel panel = new JPanel(new GridLayout(1, 2));
//        btnStart = new JButton("Start");
//        btnEnd = new JButton("End work");
//
//        btnStart.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (work) {
//                    appendLog("Server is already begin");
//                } else {
//                    work = true;
//                    appendLog("Server is just begin");
//                }
//            }
//        });
//
//        btnEnd.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (!work) {
//                    appendLog("Server is already ended");
//                } else {
//                    work = false;
//                    while (!clients.isEmpty()) {
//                        disconnectUser(clients.get(clients.size() - 1));
//                    }
//                    appendLog("Server just ended");
//                }
//            }
//        });
//
//        panel.add(btnStart);
//        panel.add(btnEnd);
//        return panel;
//    }
//}
