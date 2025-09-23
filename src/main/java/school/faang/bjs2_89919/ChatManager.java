package school.faang.bjs2_89919;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@AllArgsConstructor
public class ChatManager {
    private final UserList userList;
    private final List<Chat> activeChats = new ArrayList<>();
    //private final Lock lock = new ReentrantLock();
    //private final Condition chatAvailable = lock.newCondition();

    public synchronized void startChat(User user) {
        while (userList.getOnlineUsersLookingForChat(user).isEmpty() || activeChats.contains(user.getChat())) {
            waitForChat();
        }
        User otherUser = userList.getOnlineUsersLookingForChat(user).get(0);
        Chat chat = new Chat(user, otherUser);
        activeChats.add(chat);
        user.setChat(chat);
        otherUser.setChat(chat);
        log.info("{} начал чат с {}", user.getName(), otherUser.getName());
    }

    public void waitForChat() {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void endChat(User user) {
        Chat chat = user.getChat();
        activeChats.remove(chat);
        User user1 = chat.user1();
        User user2 = chat.user2();
        user1.resetChat();
        user2.resetChat();
        notifyAll();
        log.info("{} завершил чат {}", user1.getName(), user2.getName());
    }
}

