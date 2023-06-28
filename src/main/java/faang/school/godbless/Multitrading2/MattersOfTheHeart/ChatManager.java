package faang.school.godbless.Multitrading2.MattersOfTheHeart;

import java.util.ArrayList;
import java.util.List;


public class ChatManager {

    private List<Chat> chats = new ArrayList<>();

    List<User> onlineUsers = UserList.getOnlineUsers();
    private UserList userList;

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    public synchronized void startChat(User user) {
        onlineUsers.remove(user);
        if (!onlineUsers.isEmpty()) {
            if (!onlineUsers.get(0).getName().equals(user.getName())) {
                User otherUser = onlineUsers.get(0);
                Chat chat = new Chat(user, otherUser);
                chats.add(chat);
                onlineUsers.remove(otherUser);
            }
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized Chat waitForChat(User user) {
        Chat chat;
        chat = findChat(user);
        while (chat == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chat = findChat(user);
        return chat;
    }

    public synchronized void endChat(Chat chat) {
        chats.remove(chat);
        notifyAll();
    }

    private Chat findChat(User user) {

        for (Chat chat : chats) {
            if (chat.getUserInChat(user)) {
                return chat;
            }
        }
        return null;
    }
}
