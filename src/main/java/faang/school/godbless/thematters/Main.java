package faang.school.godbless.thematters;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        UserList userList = new UserList(getUsers());
        ChatManager chatManager = new ChatManager(userList);
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> chatManager.startChat(userList.getUsers().get(0)));
        executorService.execute(() -> chatManager.startChat(userList.getUsers().get(1)));
        sleep();
        executorService.execute(() -> chatManager.startChat(userList.getUsers().get(2)));
        sleep();
        executorService.execute(() -> chatManager.endChat(userList.getUsers().get(1)));

        executorService.shutdown();
        awaitTermination(executorService);
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void awaitTermination(ExecutorService executorService) {
        try {
            executorService.awaitTermination(5L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static List<User> getUsers() {
        return List.of(new User("User1", true, true),
                new User("User2", true, true),
                new User("User3", true, true));
    }
}
