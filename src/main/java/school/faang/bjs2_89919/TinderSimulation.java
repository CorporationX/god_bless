package school.faang.bjs2_89919;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TinderSimulation {

    public static Runnable createUserTask(ChatManager chatManager, User user) {
        return () -> chatManager.startChat(user);
    }

    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) {
        UserList userList = new UserList();
        ChatManager chatManager = new ChatManager(userList);

        User user1 = new User("Betty");
        User user2 = new User("Elizabeth");
        User user3 = new User("John");
        User user4 = new User("Martin");

        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
        userList.addUser(user4);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(createUserTask(chatManager, user1));
        executorService.submit(createUserTask(chatManager, user2));
        executorService.submit(createUserTask(chatManager, user3));
        executorService.submit(createUserTask(chatManager, user4));

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}