package faang.school.godbless.sprint3.mattersOfTheHeart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        User user1 = new User("id1", "user1", true, false);
        User user2 = new User("id2", "user2", true, false);
        User user3 = new User("id3", "user3", true, false);
        User user4 = new User("id4", "user4", true, false);
        User user5 = new User("id5", "user5", true, false);
        User user6 = new User("id6", "user6", true, false);
        User user7 = new User("id7", "user7", true, false);
        User user8 = new User("id8", "user8", true, false);

        UserList userList = new UserList(Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8));

        ChatManager chatManager = new ChatManager(userList, new ArrayList<>());

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(() -> chatManager.startChat(user1));
        executorService.submit(() -> chatManager.startChat(user2));
        executorService.submit(() -> chatManager.startChat(user3));
        executorService.submit(() -> chatManager.startChat(user4));


        Thread.sleep(2000L);

        executorService.submit(chatManager::endChat);
        executorService.submit(chatManager::endChat);

        executorService.shutdown();

        if(!executorService.awaitTermination(10L, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}
