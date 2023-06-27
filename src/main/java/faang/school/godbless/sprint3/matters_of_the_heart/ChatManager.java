package faang.school.godbless.sprint3.matters_of_the_heart;


import java.util.ArrayList;
import java.util.List;

public class ChatManager {
    private final Object lock = new Object();
    private final List<Chat> chatList = new ArrayList<>();
    private UserList userList = new UserList();

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    List<User> onlineUsers = UserList.getOnlineUsers();

    public void startChat(User user) {
        synchronized (lock) {
            onlineUsers.remove(user);
            if (!onlineUsers.isEmpty()) {
                if (!onlineUsers.get(0).getName().equals(user.getName())) {
                    User otherUser = onlineUsers.get(0);
                    Chat chat = new Chat(user, otherUser);
                    chatList.add(chat);
                    onlineUsers.remove(otherUser);
                }
            } else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Chat waitForChat(User user) {
        synchronized (lock) {
            Chat chat;
            chat = findChat(user);
            while (chat == null) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            chat = findChat(user);
            return chat;
        }
    }

    public void endChat(Chat chat) {
        synchronized (lock) {
            chatList.remove(chat);
            lock.notifyAll();
        }
    }

    private Chat findChat(User user) {

        for (Chat chat : chatList) {
            if (chat.getUserInChat(user)) {
                return chat;
            }
        }
        return null;
    }

}
