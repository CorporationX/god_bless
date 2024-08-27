package faang.school.godbless.BJS2_24372;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int USER_COUNT = 10;

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < USER_COUNT; i++) {
            if (i % 2 == 0) {
                users.add(new User("Female" + i, Gender.FEMALE, Gender.MALE, Status.WANTS_CHATTING));
            } else {
                users.add(new User("Male" + i, Gender.MALE, Gender.FEMALE, Status.WANTS_CHATTING));
            }
        }

        for (int i = 0; i < USER_COUNT; i++) {
            users.add(new User("User" + i, Gender.MALE, Gender.FEMALE, Status.ONLINE));
        }

        UserList userList = new UserList(users);

        ChatManager chatManager = new ChatManager(userList);

        ExecutorService executorService = Executors.newFixedThreadPool(USER_COUNT);

        for (User user : userList.getUsersByStatus(Status.WANTS_CHATTING)) {
            executorService.execute(() -> {
                chatManager.startChat(user);

                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                    Thread.currentThread().interrupt();
                }

                chatManager.endChat(user);
            });
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("All conversations are ended");
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }

    }
}
