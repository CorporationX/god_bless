package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class ChatManager {
    private UserList userList;
    private List<Chat> chats;

    public ChatManager(UserList userList) {
        this.userList = userList;
        this.chats = new ArrayList<>();
    }

    public synchronized void startChat(User user) {
        List<User> onlineUsers = userList.getOnlineUsers();
        onlineUsers.remove(user);
        while (!onlineUsers.isEmpty()) {
            if (!onlineUsers.isEmpty()) {
                User otherUser = onlineUsers.get(0);
                Chat chat = new Chat(user, otherUser);
                chats.add(chat);
                System.out.println("Chat started between " + user.getUsername() + " and " + otherUser.getUsername());
                return;
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void waitForChat(User user){
        while (!hasChatWithUser(user)) {
            try {
                System.out.println(user.getUsername() + " is waiting for a chat...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean hasChatWithUser(User user) {
        for (Chat chat : chats) {
            if (chat.getChatId().contains(user.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public synchronized void endChat(Chat chat) {
        chats.remove(chat);
        System.out.println("Chat " + chat.getChatId() + " ended.");
        notifyAll();
    }
}
