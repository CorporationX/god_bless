package faang.school.godbless.synchronize.ironThrone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        House house = new House(new ArrayList<>(), 6);

        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            users.add(new User("User" + i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (User user : users) {
            executorService.execute(() -> {
                user.joinHouse(house);
                user.leaveHouse();
            });
        }

        executorService.shutdown();
    }
}
