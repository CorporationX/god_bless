package school.faang.module1.bjs2_81781;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class ChatManager {

    private final UserList userList;
    private final List<Chat> activeChats = new ArrayList<>();

    public synchronized void startChat(User user) {
        user.setOnline(true);
        user.setLookingForChat(true);
        log.info("{} вышел в онлайн и ищет чат", user.getName());
        List<User> onlineUsers = userList.getOnlineUsers();
        for (User partner : onlineUsers) {
            if (!partner.equals(user)) {
                log.info("Найдена пара: {} и {}", user.getName(), partner.getName());
                user.setLookingForChat(false);
                partner.setLookingForChat(false);
                Chat chat = new Chat(user, partner);
                activeChats.add(chat);
                notifyAll();
                return;
            }
        }
        log.info("{} не нашёл пару и будет ждать", user.getName());
    }

    public synchronized Chat waitForChat(User user) {
        while (true) {
            for (Chat chat : activeChats) {
                if (chat.contains(user)) {
                    return chat;
                }
            }
            try {
                log.info("{} ожидает подключения к чату...", user.getName());
                wait();
            } catch (InterruptedException e) {
                log.error("{} прерван во время ожидания", user.getName());
                Thread.currentThread().interrupt();
                return null;
            }
        }
    }

    public synchronized void endChat(Chat chat) {
        chat.end();
        activeChats.remove(chat);
        User user1 = chat.getUser1();
        User user2 = chat.getUser2();
        user1.setLookingForChat(true);
        user2.setLookingForChat(true);
        userList.addUser(user1);
        userList.addUser(user2);
        log.info("Пользователи {} и {} снова доступны для чата", user1.getName(), user2.getName());
        notifyAll();
    }
}