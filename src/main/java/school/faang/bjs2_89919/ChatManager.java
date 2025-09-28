package school.faang.bjs2_89919;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class ChatManager {
    private final UserList userList;
    private final List<Chat> activeChats = new ArrayList<>();
    private static final Random random = new Random();
    private final Object monitor;

    public ChatManager(UserList userList) {
        this.userList = userList;
        this.monitor = userList.getMonitor();
    }

    public void addUser(User user) {
        synchronized (monitor) {
            userList.addUser(user);
            userList.addToSearching(user);
            monitor.notifyAll();
        }
    }

    public void removeUser(User user) {
        synchronized (monitor) {
            userList.removeUser(user);
            monitor.notifyAll();
        }
    }

    public void startChat(User user) {
        User otherUser;
        synchronized (monitor) {
            while (userList.getOnlineUsersLookingForChat(user).isEmpty()
                    || user.getChat().map(activeChats::contains).orElse(false)) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.warn("Поток {} был прерван во время ожидания.", Thread.currentThread().getName());
                    return;
                }
            }
            List<User> candidates = userList.getOnlineUsersLookingForChat(user);
            otherUser = candidates.get(random.nextInt(candidates.size()));

            userList.removeUser(user);
            userList.removeUser(otherUser);
        }

        createChat(user, otherUser);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Поток {} был прерван во время сна.", Thread.currentThread().getName());
        } finally {
            user.getChat().ifPresent(this::endChat);
        }
    }

    public void endChat(Chat chat) {
        synchronized (monitor) {
            if (chat == null) {
                return;
            }
            activeChats.remove(chat);

            User user1 = chat.getUser1();
            User user2 = chat.getUser2();

            user1.resetChat();
            user2.resetChat();

            userList.addToSearching(user1);
            userList.addToSearching(user2);

            log.info("{} завершил чат {}", user1.getName(), user2.getName());

            monitor.notifyAll();
        }
    }

    private void createChat(User user, User otherUser) {
        synchronized (monitor) {
            Chat chat = new Chat(user, otherUser);
            activeChats.add(chat);
            user.setChat(chat);
            otherUser.setChat(chat);
            log.info("{} начал чат с {}", user.getName(), otherUser.getName());
        }
    }
}