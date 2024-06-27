package faang.school.godbless.multithreading.matters_of_the_heart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ChatManager {

    private final Object lock = new Object();
    private final UserList userList;
    private final List<Chat> onlineChats = new ArrayList<>();

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    public void addUser(User user) {
        synchronized (lock) {
            userList.add(user);
            lock.notifyAll();
            System.out.println("Добавлен пользователь: " + user.getName());
        }
    }

    public void startChat(User user) {
        synchronized (lock) {
            List<User> usersToChat = getOnlineUsers(user);
            boolean isWaitForChat = waitForChat(user);
            while (usersToChat.isEmpty() && isWaitForChat) {
                try {
                    System.out.println(user.getName() + "ждёт нового пользователя для начала беседы");
                    lock.wait();
                    usersToChat = getOnlineUsers(user);
                    isWaitForChat = waitForChat(user);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (isWaitForChat) {
                User randomUser = UserList.getRandomUserFromList(usersToChat);
                createChat(user, randomUser);
                user.setWaitToChat(false);
                randomUser.setWaitToChat(false);
                lock.notifyAll();
                System.out.println("Создан чат для пользователей " + user.getName() + " и " + randomUser.getName());
            }
        }
    }

    private boolean waitForChat(User user) {
        synchronized (lock) {
            for (Chat chat : onlineChats) {
                if (chat.users().contains(user)) {
                    return false;
                }
            }
            return true;
        }
    }
    public void endChat(User user) {
        synchronized (lock) {
            for (Chat chat : onlineChats) {
                if (chat.users().contains(user)) {
                    onlineChats.remove(chat);
                    System.out.println("Удалён чат: " + chat);
                    return;
                }
            }
        }
    }

    public List<User> getOnlineUsers(User user) {
        synchronized (lock) {
            return userList.users().stream()
                    .filter(userElem -> userElem.isWaitToChat() && !Objects.equals(user, userElem))
                    .toList();
        }
    }

    public void createChat(User user1, User user2) {
        onlineChats.add(new Chat(user1.getName() + "_" + user2.getName(), new HashSet<>(Set.of(user1, user2))));
    }
}
