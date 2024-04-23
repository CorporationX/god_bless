package faang.school.godbless.MattersOfTheHeart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 10;
    private static final List<User> USERS = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        getUsers();
        System.out.println();
        List<ChatManager> managers = getManagers();

        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        for (ChatManager manager : managers) {
            pool.execute(() -> {
                try {
                    manager.waitForChat();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            pool.execute(() -> {
                try {
                    manager.startChat();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        getLikes();
        pool.shutdown();

        while (!pool.awaitTermination(10, TimeUnit.SECONDS)) ;
    }

    private static void getLikes() {
        USERS.get(0).like(USERS.get(1));
        USERS.get(1).like(USERS.get(2));
        USERS.get(2).like(USERS.get(3));
        USERS.get(3).like(USERS.get(4));
        USERS.get(4).like(USERS.get(0));
    }

    private static void getUsers() {
        USERS.add(new User(1, "John", true));
        USERS.add(new User(2, "Anna", true));
        USERS.add(new User(3, "Tom", true));
        USERS.add(new User(4, "Emma", true));
        USERS.add(new User(5, "Sam", true));
    }

    private static List<ChatManager> getManagers() {
        List<ChatManager> managers = new ArrayList<>();
        for (User user : USERS) {
            managers.add(new ChatManager(new UserList(USERS), user));
        }
        return managers;
    }
}
