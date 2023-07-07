package faang.school.godbless.mattersHeart;

import java.util.ArrayList;
import java.util.List;
public class ChatManager {
    private final List<User> onlineUsers;
    private final List<Chat> chats;

    public ChatManager() {
        this.onlineUsers = new ArrayList<>();
        this.chats = new ArrayList<>();
    }

    public synchronized void startChat(User user) {
        List<User> availableUsers = new ArrayList<>(onlineUsers);
        availableUsers.remove(user);

        if (!availableUsers.isEmpty()) {
            User otherUser = availableUsers.get(0);
            Chat chat = new Chat(user, otherUser);
            chats.add(chat);
            availableUsers.remove(otherUser);
            onlineUsers.remove(user);
            onlineUsers.remove(otherUser);

            chat.startChat();
        } else {
            try {
                System.out.println("[ChatManager] No other users want to chat. " + user.name() + " is waiting for someone to join...");
                wait(6000);
                if (!onlineUsers.contains(user)) {
                    onlineUsers.add(user);
                    System.out.println("[ChatManager] " + user.name() + " has left the chat.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void waitForChat(User user) {
        boolean hasChat = false;
        for (Chat chat : chats) {
            if (chat.containsUser(user)) {
                hasChat = true;
                break;
            }
        }

        if (!hasChat) {
            try {
                System.out.println("[ChatManager] " + user.name() + " is waiting for a chat...");
                wait(6000);
                if (!onlineUsers.contains(user)) {
                    onlineUsers.add(user);
                    System.out.println("[ChatManager] " + user.name() + " has left the chat.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void addUser(User user) {
        onlineUsers.add(user);
    }

    public synchronized List<User> getOnlineUsers() {
        return new ArrayList<>(onlineUsers);
    }
}
