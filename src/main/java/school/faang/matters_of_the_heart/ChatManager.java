package school.faang.matters_of_the_heart;

import java.util.ArrayList;
import java.util.List;

public class ChatManager {
    private final List<Chat> chatList = new ArrayList<>();
    private static final Object lock = new Object();
    private final UserList userList = new UserList();

    public void startChat(User user) throws InterruptedException {
        Chat chat = new Chat(user);
        synchronized (lock) {
            chatList.add(chat);
        }
        List<User> users = userList.getOnlineUsers();
        while (users.isEmpty()) {
            wait();
        }
    }

    public void waitForChat() {

    }

    public void endChat(Chat chat) {
        synchronized (lock) {
            chatList.remove(chat);
            notify();
        }
    }

}
