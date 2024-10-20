package school.faang.heartMatters;

import java.util.ArrayList;
import java.util.List;

public class ChatManager {
    private final List<User> usersWaiting = new ArrayList<>();
    private final List<Chat> activeChats = new ArrayList<>();

    public synchronized void startChat(User user) {
        if (usersWaiting.isEmpty()) {
            usersWaiting.add(user);
            waitForChat(user);
        } else {
            User companion = usersWaiting.remove(0);
            Chat chat = new Chat(user, companion);
            activeChats.add(chat);
            chat.sendMessage(user, Chat.generateRandomMessage());
            notifyAll();
            System.out.println(user.getName() + " started chatting with " + companion.getName());
            endChat(chat);
        }
    }

    private synchronized void waitForChat(User user) {
        try {
            System.out.println(user.getName() + " is waiting for chat...");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void endChat(Chat chat) {
        activeChats.remove(chat);
        notifyAll();
        System.out.printf("%s and %s chat has ended.\n",
                chat.getUser1().getName(), chat.getUser2().getName());
        System.out.println("Chat history: ");
        System.out.println(chat.getChatHistory());
    }
}
