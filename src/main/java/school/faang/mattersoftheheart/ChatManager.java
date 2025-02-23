package school.faang.mattersoftheheart;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
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

    public void findChat(User user) throws InterruptedException {
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
    }

    public void endChat() throws InterruptedException {
        synchronized (lockChat) {
            if (chats.isEmpty()) {
                lockChat.wait();
            }
            imitateDelay(END_CHAT_DELAY);
            Chat chat = chats.get(FIRST_ELEMENT);
            User hostUser = chat.getHostUser();
            User connectedUser = chat.getConnectedUser();
            hostUser.setLookingForChat(IS_AVAILABLE_USER);
            connectedUser.setLookingForChat(IS_AVAILABLE_USER);
            chats.remove(chat);
            log.info("Chat between {} and {} ended", hostUser.getName(), connectedUser.getName());
            lockChat.notifyAll();
        }
    }

    private void imitateDelay(int delay) throws InterruptedException {
        Thread.sleep(delay);
    }
}
