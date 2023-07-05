package matters_of_the_heart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("A", true, true, true, false);
        User user2 = new User("B", true, true, true, false);
        User user3 = new User("C", false, true, true, false);
        User user4 = new User("D", true, false, true, false);
        User user5 = new User("E", true, true, true, false);

        UserList userList = new UserList();
        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
        userList.addUser(user4);
        userList.addUser(user5);

        ChatManager chatManager = new ChatManager(userList);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (User user : userList.getUserList()) {
            if (user.isEligible()) {
                executorService.submit(() -> {
                    chatManager.startChat(user);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    chatManager.endChat(user);
                });
            }
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
