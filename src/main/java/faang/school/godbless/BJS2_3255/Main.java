package faang.school.godbless.BJS2_3255;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        House house1 = new House("1");
        house1.addRole("BaseRole1");
        house1.addRole("BaseRole2");
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            users.add(new User("user" + i));
        }
        users.forEach((user) -> executorService.execute(() -> user.joinHouse(house1)));
        Thread.sleep(1000);
        house1.addRole("newRole1");
        Thread.sleep(1000);
        house1.addRole("newRole2");
        Thread.sleep(1000);
        house1.getUser("BaseRole1").leaveHouse();
        Thread.sleep(1000);
        house1.getUser("BaseRole2").leaveHouse();
        Thread.sleep(1000);
        house1.addRole("newRole3");
        Thread.sleep(1000);
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
