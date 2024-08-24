package faang.school.godbless.BJS2_24312;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 2;

    public static void main(String[] args) throws InterruptedException {
        UserList usersList = new UserList();

        usersList.addUser(new User("Max", true, true, false));
        usersList.addUser(new User("Josh", true, true, false));
        usersList.addUser(new User("Sansa", false, true, false));
        usersList.addUser(new User("Marek", true, false, false));
        usersList.addUser(new User("Igor", true, true, false));

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        ChatManager chatManager = new ChatManager(usersList);

        for (User user: usersList.getUsers()){
            if(user.isOnline() && user.isLookingForChat() && !user.isChatting()){
                executorService.submit(() -> {
                        try {
                            chatManager.startChat(user);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        chatManager.endChat(user);
                });
            }
        }

        executorService.shutdown();

        if(!executorService.awaitTermination(6, TimeUnit.SECONDS)){
            executorService.shutdownNow();
        }
    }
}
