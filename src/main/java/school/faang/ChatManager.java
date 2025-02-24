package school.faang;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
public class ChatManager {
    private final UserList users;
    private final Object lock = new Object();
    private final Set<Chat> chats = new HashSet<>();

    public void startChat(User user) {
        synchronized (lock) {
            while (users.getOnlineUsers(user).isEmpty() && chats.contains(user.getChat())) {
                if (Thread.currentThread().isInterrupted()) {
                    log.error("{}'s chat initiation was interrupted.", user.getName());
                    return;
                }
                waitForChat();
            }
            User secondUser = users.getOnlineUsers(user).get(0);
            secondUser.setLookingForChat(false);
            secondUser.setOnline(true);
            user.setLookingForChat(false);
            user.setOnline(true);

            Chat chat = new Chat(user, secondUser);
            chats.add(chat);
            user.setChat(chat);
            secondUser.setChat(chat);
            log.info("{} started chat with {}.", user.getName(), secondUser.getName());
        }
    }

    public void waitForChat() {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                log.error("Wait was interrupted.");
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    public void endChat(User user) {
        synchronized (lock) {
            Chat chat = user.getChat();
            chats.remove(chat);
            User user1 = chat.getUser1();
            User user2 = chat.getUser2();

            user1.setLookingForChat(true);
            user2.setLookingForChat(true);
            user1.setOnline(false);
            user2.setOnline(false);
            user1.setChat(null);
            user2.setChat(null);
            lock.notify();
            log.info("{} ended chat with {}.", user1.getName(), user2.getName());
        }
    }
}
