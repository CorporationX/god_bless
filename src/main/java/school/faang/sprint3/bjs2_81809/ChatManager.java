package school.faang.sprint3.bjs2_81809;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Data
public class ChatManager {
    public static final int THREAD_BATCH = 5;
    public static final int CHAT_DURATION = 1000;
    public static final int USERS_COUNT = 5;

    public final UserList userList;

    ChatManager(UserList userList) {
        this.userList = userList;
    }

    public Chat startChat(User user) {
        System.out.println("Поиск...");
        synchronized (userList) {
            if (userList.getLookingForChatUsersCount(user) < 1) {
                waitForUser();
            }
            List<User> userForChat = userList.getLookingForChatUsers(1, user);
            userList.removeUser(user);
            userList.removeUser(userForChat.get(0));
            Chat chat = new Chat(this, user, userForChat.get(0));
            System.out.println("Чат создан. " + chat);
            return chat;
        }
    }

    public void waitForUser() {
        try {
            userList.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void endChat(Chat chat) {
        synchronized (userList) {
            User user1 = chat.getUser1();
            User user2 = chat.getUser2();
            userLeaveChat(user1);
            userLeaveChat(user2);
            userList.notifyAll();
            System.out.println("Удаления чата. " + chat);
        }
    }

    public void userLeaveChat(User user) {
        if (user != null) {
            user.setLookingForChat(false);
            userList.addUser(user);
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_BATCH);
        UserList userList = new UserList();
        ChatManager manager = new ChatManager(userList);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < USERS_COUNT; i++) {
            String name = "user " + i;
            User newUser = new User(
                    name,
                    ThreadLocalRandom.current().nextBoolean(),
                    ThreadLocalRandom.current().nextBoolean()
            );
            users.add(newUser);
            manager.getUserList().addUser(newUser);
        }
        for (User user : users) {
            executor.execute(() -> {
                Chat chat = manager.startChat(user);
                try {
                    Thread.sleep(CHAT_DURATION);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                manager.endChat(chat);
            });
        }

        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
