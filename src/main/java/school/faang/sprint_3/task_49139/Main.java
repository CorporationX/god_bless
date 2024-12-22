package school.faang.sprint_3.task_49139;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int AMOUNT_OF_THREADS = 4;
    private static final int AMOUNT_OF_USERS = 5;
    private static final int AMOUNT_OF_REQUESTS = 6;
    private static final int AWAIT_DELAY = 1;

    public static void main(String[] args) {
        UserList userList = generateUserList(AMOUNT_OF_USERS);
        ChatManager chatManager = new ChatManager(userList);

        ExecutorService executorService = Executors.newFixedThreadPool(AMOUNT_OF_THREADS);

        Random random = new Random();
        for (int i = 1; i <= AMOUNT_OF_REQUESTS; i++) {
            executorService.submit(() -> {
                User user = chatManager
                        .getUserList()
                        .getUsersReadyToChatWith(null)
                        .get(random.nextInt(AMOUNT_OF_REQUESTS));
                chatManager.startChat(user);
                chatManager.endChat(user);
            });
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_DELAY, TimeUnit.MINUTES)) {
                System.out.println("Await timed out. Shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted. Shutting down...");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private static UserList generateUserList(int amountOfUsers) {
        UserList userList = new UserList();
        for (int i = 1; i <= amountOfUsers; i++) {
            userList.addUser(new User("User " + i));
        }
        return userList;
    }
}
