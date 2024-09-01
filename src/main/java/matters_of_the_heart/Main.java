package matters_of_the_heart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 4;

    public static void main(String[] args) throws InterruptedException {
        UserList userList = new UserList();
        userList.addUser(new User(1, "user1", true));
        userList.addUser(new User(2, "user2", true));
        userList.addUser(new User(3, "user3", true));
        userList.addUser(new User(4, "user4", false));

        ChatManager chatManager = new ChatManager(userList);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (User user : userList.getUsers()) {
            if (user.isOnline()) {
                executorService.execute(() -> {
                    try {
                        chatManager.startChat(user);
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    chatManager.endChat(user);
                });
            }
        }

        if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
            executorService.shutdown();
        } else {
            executorService.shutdownNow();
        }

    }
}
