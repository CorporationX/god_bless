package faang.school.godbless.multithreading.matters_of_the_heart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ChatManager {

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    private UserList userList;

    private List<Chat> chats = new ArrayList<>();

    private Object lock = new Object();

    public void startChat(User user) throws InterruptedException {
        Optional<User> activeUsers;

        synchronized (this) {
            activeUsers = userList.getOnlineUsers().stream()
                    .filter(u -> u.hashCode() != user.hashCode() && u.isCommunication())
                    .findFirst();
            userList.changeStatus(activeUsers);

        }

        if (activeUsers.isPresent()) {
            user.setCommunication(false);
            activeUsers.get().setCommunication(false);

            Chat chat = new Chat(user, activeUsers.get(), true);
            chats.add(chat);
            chat.communication(this);
        } else {
            wait(user);
        }

    }

    public void wait(User user) throws InterruptedException {
        synchronized (lock) {
            startChat(user);
            lock.wait();
        }

    }

    public void endChat(Chat chat) {
        synchronized (lock) {
            chat.fUser.setCommunication(true);
            chat.sUser.setCommunication(true);
            chats.remove(chat);
            lock.notify();
        }
    }
}

