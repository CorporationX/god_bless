package school.faang.bjs2_81786;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class ChatManager {
    private static final int MAX_WAIT_IN_MS = 6_000;

    private final UserList userList;
    private final Set<Chat> chats;

    public ChatManager(UserList userList) {
        this.userList = userList;
        this.chats = new HashSet<>();
    }

    public synchronized void startChat(User user) {
        while (userList.getOnlineUsers(user).isEmpty() || chats.contains(user.getChat())) {
            waitForChat(user);
        }

        User interlocutor = userList.getOnlineUsers(user).get(0);
        Chat chat = new Chat(user, interlocutor);
        chats.add(chat);
        user.setChat(chat);
        interlocutor.setChat(chat);
        log.info("Пользователи {} и {} зашли в чат", user.getName(), interlocutor.getName());
    }

    public synchronized void waitForChat(User user) {
        try {
            log.info("{} ожидает доступных пользователей", user.getName());
            wait(MAX_WAIT_IN_MS);
        } catch (InterruptedException e) {
            log.error("Поток прерван при ожидании {} другого пользователя", user.getName(), e);
            throw new RuntimeException(e);
        }
    }

    public synchronized void endChat(User user) {
        Chat userChat = user.getChat();
        chats.remove(userChat);
        User user1 = userChat.getUser1();
        User user2 = userChat.getUser2();
        user1.resetChat();
        user2.resetChat();
        notifyAll();
        log.info("Пользователи {} и {} завершили чат", user1.getName(), user2.getName());
    }
}
