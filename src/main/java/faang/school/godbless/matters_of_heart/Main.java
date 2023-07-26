package faang.school.godbless.matters_of_heart;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("user1", true, true);
        User user2 = new User("user2", true, true);
        User user3 = new User("user3", true, true);
        User user4 = new User("user4", true, true);
        User user5 = new User("user5", true, true);

        UserList userList = new UserList(List.of(user1, user2, user3, user4, user5));

        ChatManager chatManager = new ChatManager(userList);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(() -> chatManager.startChat(user1));
        executor.execute(() -> chatManager.startChat(user3));
        executor.execute(() -> chatManager.startChat(user5));

        executor.execute(() -> chatManager.endChat(chatManager.getChatList().get(0)));

        executor.shutdown();

        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("done");
    }
}
