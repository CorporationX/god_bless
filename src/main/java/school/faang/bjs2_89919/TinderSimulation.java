package school.faang.bjs2_89919;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TinderSimulation {

    public static void createUserTask(ChatManager chatManager, User user) {
        return () -> {
            try {
                chatManager.startChat(user);
                Thread.sleep(2000);
                chatManager.endChat(user);
                System.out.println(user.getName() + " завершил чат");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
    }

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

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}