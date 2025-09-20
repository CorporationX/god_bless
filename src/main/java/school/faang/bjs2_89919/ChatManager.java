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
    private final Lock lock = new ReentrantLock();
    private final Condition chatAvailable = lock.newCondition();

    public Chat startChat(User user) throws InterruptedException {
        lock.lock();
        try {
            user.setLookingForChat(true);
            while (true) {

                List<User> candidates = userList.getOnlineUsersLookingForChat();
                candidates.remove(user);
                if (!candidates.isEmpty()) {
                    User partner = candidates.get(0);
                    partner.setLookingForChat(false);
                    user.setLookingForChat(false);
                    Chat chat = new Chat(user, partner);
                    activeChats.add(chat);
                    log.info("Started {}", chat);
                    return chat;
                }
                log.info("{} ждёт собеседника...", user.getName());
                chatAvailable.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public Chat waitForChat(User user) throws InterruptedException {
        lock.lock();
        try {
            while (true) {
                for (Chat chat : activeChats) {
                    if (chat.getUser1().equals(user) || chat.getUser2().equals(user));
                    return chat;
                }
            }
            chatAvailable.await();
        }
    } finally {
        lock.unlock();
    }
}

