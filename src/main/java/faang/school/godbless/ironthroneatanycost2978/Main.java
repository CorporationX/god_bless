package faang.school.godbless.ironthroneatanycost2978;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<User> users = createUsersList();
        ExecutorService executor = Executors.newFixedThreadPool(20);
        Random random = new Random();
        for (User user : users) {
            executor.execute(() -> {
                try {
                    user.joinHouse();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(random.nextLong(5000, 20000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                user.leaveHouse();
            });
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("All users left the game. Good night i guess");
    }

    private static List<User> createUsersList() {
        List<User> result = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            result.add(new User("User #" + i));
        }
        return result;
    }
}
