package faang.school.godbless.multithreading.synchronizedPractice.mattersOfTheHeart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MattersOfTheHeart {
    public static void main(String[] args) {
        UserList userList = getUserList();

        ChatManager chatManager = new ChatManager(userList);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (User user : chatManager.getUserList().getUserList()) {
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
    }

    private static UserList getUserList() {
        User user1 = new User("user1", true);
        User user2 = new User("user2", true);
        User user3 = new User("user3", false);
        User user4 = new User("user4", true);
        User user5 = new User("user5", false);

        UserList userList = new UserList();
        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
        userList.addUser(user4);
        userList.addUser(user5);
        return userList;
    }
}
