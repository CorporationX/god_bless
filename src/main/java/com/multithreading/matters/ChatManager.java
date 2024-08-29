package com.multithreading.matters;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ChatManager {
    private UserList userList;
    private boolean isStartChat = false;
    private final Object lock = new Object();
    private final Object lock2 = new Object();
    private List<Chat> chats = new ArrayList<>();

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    public static void main(String[] args) {
        User user1 = new User("David");
        User user2 = new User("Seak");
        User user3 = new User("Jord");
        User user4 = new User("Bob");

        UserList userList = new UserList();
        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
        userList.addUser(user4);

        ChatManager chatManager = new ChatManager(userList);

        ExecutorService service = Executors.newFixedThreadPool(2);

        for (User user : userList.getUsers()) {
            service.execute(() -> {
                try {
                    chatManager.startChat(user);
                    TimeUnit.SECONDS.sleep(1);
                    chatManager.endChat(user);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        service.shutdown();
    }

    public void startChat(User user) {
        if (user != null) {
            synchronized (lock) {
                //Маркер показывает, что пользователь готов к общению
                user.setOnline(true);
                try {
                    List<User> usersOnline = userList
                            .getOnlineUsers()
                            .stream()
                            .filter(u -> !u.equals(user))
                            .toList();
                    //Проверка есть ли пользователь в списке, который готов к общению, если нет, то ожидаем
                    if (!usersOnline.isEmpty()) {
                        log.info("Активирует поток, который в ожидание");
                        lock.notify();
                        return;
                    } else {
                        log.info("Ожидание {}", user);
                        lock.wait();
                    }
                    log.info("Создает чат {}", user);
                    //Процесс создания чата
                    User first = userList.getOnlineUsers().get(0);
                    User second = userList.getOnlineUsers().get(1);
                    waitForChat(new Chat(first, second));
                    first.setOnline(false);
                    second.setOnline(false);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

    }

    public void waitForChat(Chat chat) {
        try {
            synchronized (lock2) {
                if (chats.size() > 10) {
                    log.info("Ожидание свободного чата ");
                    lock2.wait();
                }
                chats.add(chat);
                log.info("Добавлен новый чат с хостом ");
                System.out.println("Chat with users: " + chat);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void endChat(User user) {
        synchronized (lock2) {
            if (chats.stream().anyMatch(chat -> chat.getFirstUser().equals(user))) {
                log.info("{} удалил чат", user);
                chats.removeIf(c -> c.getFirstUser().equals(user));
                lock2.notifyAll();
                System.out.println("chat is empty " + chats);
            }
        }
    }
}
