package faang.school.godbless.synchronization.task_7;

import faang.school.godbless.synchronization.task_7.model.User;
import faang.school.godbless.synchronization.task_7.model.UserList;
import faang.school.godbless.synchronization.task_7.util.ChatManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int POOL_SIZE = 2;
    public static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(POOL_SIZE);

    public static void main(String[] args) {
        UserList users = new UserList(getUsers());
        ChatManager chatManager = new ChatManager(users);
        for (User user : users.getOnlineUsers()) {
            EXECUTOR.execute(() -> chatManager.startChat(user));
            EXECUTOR.execute(() -> chatManager.sendMessageInChat(user));
            EXECUTOR.execute(() -> chatManager.endChat(user));
        }
        EXECUTOR.shutdown();

        try {
            EXECUTOR.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

    }

    private static List<User> getUsers() {
        User ignat = new User("ignat");
        User igor = new User("igor");
        User fedor = new User("fedor");
        User boris = new User("boris");
        User maga = new User("maga");
        User katya = new User("katya");
        igor.disconnect();
        return List.of(ignat, igor, fedor, boris, maga, katya);
    }
}
