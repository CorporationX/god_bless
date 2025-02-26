package school.faang.mattersoftheheart;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class ChatManager {
    private static final boolean IS_BUSY_USER = false;
    private static final boolean IS_AVAILABLE_USER = true;
    private static final int END_CHAT_DELAY = 1000;
    private static final int FIND_CHAT_DELAY = 500;
    private static final int FIRST_ELEMENT = 0;

    private final List<User> waitingUsers = new ArrayList<>(1);
    private final List<Chat> chats = new CopyOnWriteArrayList<>();
    private final Object lockUser = new Object();
    private final Object lockChat = new Object();

    private void startChat(User hostUser, User connectedUser) {
        synchronized (lockChat) {
            chats.add(new Chat(hostUser, connectedUser));
            log.info("Chat between {} and {} started", hostUser.getName(), connectedUser.getName());
            lockChat.notifyAll();
        }
    }

    public void findChat(User user) {
        try {
            Objects.requireNonNull(user, "invalid user value");
            synchronized (lockUser) {
                imitateDelay(FIND_CHAT_DELAY);
                if (waitingUsers.isEmpty()) {
                    waitingUsers.add(user);
                    user.setLookingForChat(IS_BUSY_USER);
                    log.info("User {} is waiting for chat", user.getName());
                } else {
                    User hostUser = waitingUsers.get(FIRST_ELEMENT);
                    waitingUsers.remove(FIRST_ELEMENT);
                    user.setLookingForChat(IS_BUSY_USER);
                    startChat(hostUser, user);
                }
            }
        } catch (InterruptedException e) {
            catchingException(e);
        }

    }

    public void endChat() {
        try {
            synchronized (lockChat) {
                if (chats.isEmpty()) {
                    lockChat.wait();
                }
                imitateDelay(END_CHAT_DELAY);
                Chat chat = chats.get(FIRST_ELEMENT);
                User hostUser = chat.hostUser();
                User connectedUser = chat.connectedUser();
                hostUser.setLookingForChat(IS_AVAILABLE_USER);
                connectedUser.setLookingForChat(IS_AVAILABLE_USER);
                chats.remove(chat);
                log.info("Chat between {} and {} ended", hostUser.getName(), connectedUser.getName());
                lockChat.notifyAll();
            }
        } catch (InterruptedException e) {
            catchingException(e);
        }
    }

    private static void imitateDelay(int delay) throws InterruptedException {
        Thread.sleep(delay);
    }

    private void catchingException(Exception e) {
        log.error("Thread was interrupted. Thread name: {}\nException: {}\nStack trace: {}",
                Thread.currentThread().getName(), e, e.getStackTrace());
    }
}
