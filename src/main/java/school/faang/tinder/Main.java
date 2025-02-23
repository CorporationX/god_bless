package school.faang.tinder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int QUANTITY_OF_POOLS = 2;

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("John", "Kate", "Nik", "Sara", "Alex"));

        UserList userList = new UserList();
        for (String name : names) {
            User user = new User(name);
            userList.add(user);
            userList.switchLookingForChat(user);
        }

        ChatManager chatManager = new ChatManager(userList);
        ExecutorService executorService = Executors.newFixedThreadPool(QUANTITY_OF_POOLS);

        for (User user : userList.getUsersIsOnline()) {
            if (userList.getUsersIsLookingForChat().contains(user)) {
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
            executorService.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
