package school.faang.tinder;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class ChatManager {
    private final UserList userList = new UserList();
    private final List<Chat> activeChats = new ArrayList<>();
    private final Object lock = new Object();

    public void registerUser(User user) {
        userList.addUser(user);
        log.info("Пользователь {} зарегистрирован", user.getName());
    }

    public Chat startChat(User user) throws InterruptedException {
        user.setLookingForChat(true);
        log.info("Пользователь {} ищет чат", user.getName());

        synchronized (lock) {
            while (true) {
                List<User> onlineUsers = userList.getOnlineUsers();
                Optional<User> partner = onlineUsers.stream()
                        .filter(otherUserForChat -> otherUserForChat != user && otherUserForChat.isLookingForChat())
                        .findFirst();

                if (partner.isPresent()) {
                    User otherUserForChat = partner.get();
                    otherUserForChat.setLookingForChat(false);
                    user.setLookingForChat(false);

                    Chat newChat = new Chat(user, otherUserForChat);
                    activeChats.add(newChat);
                    log.info("Создан новый чат между {} и {}",
                            user.getName(),
                            otherUserForChat.getName());
                    lock.notifyAll();
                    return newChat;
                }
                lock.wait();
            }
        }
    }

    public Chat waitForChat(User user) throws InterruptedException {
        synchronized (lock) {
            while (true) {
                Optional<Chat> existingChat = activeChats.stream()
                        .filter(chat -> chat.isActive() && (chat.getUser1() == user || chat.getUser2() == user))
                        .findFirst();

                if (existingChat.isPresent()) {
                    return existingChat.get();
                }
                lock.wait();
            }
        }
    }

    public void endChat(Chat chat) {
        synchronized (lock) {
            chat.endChat();
            activeChats.remove(chat);
            lock.notifyAll();
            log.info("Чат между {} и {} завершен",
                    chat.getUser1().getName(),
                    chat.getUser2().getName());
        }
    }
}
