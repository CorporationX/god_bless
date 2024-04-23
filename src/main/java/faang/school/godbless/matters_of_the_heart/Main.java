package faang.school.godbless.matters_of_the_heart;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) throws InterruptedException {
        UserList userList = new UserList(List.of(
                new User("Test1"),
                new User("Test2"),
                new User("Test3"),
                new User("Test4"),
                new User("Test5")
        ));

        ChatManager chatManager = new ChatManager(userList);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        // Все пользователи начали искать чат, пользователь Test5 остался один.
        for (User user : userList.getAllUsers()) {
            executorService.execute(() -> chatManager.startChat(user));
        }

        // Пользователь Test4 покинул чат (в чате остался пользователь Test3),
        // пользователь Test3 начал искать чат и присоединился к пользователю Test5.
        executorService.execute(() -> chatManager.endChat(userList.getAllUsers().get(3)));

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}