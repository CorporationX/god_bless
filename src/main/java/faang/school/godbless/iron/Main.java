package faang.school.godbless.iron;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMS_THREAD = 40;
    private static final int QUANTITY_ROLES = 3;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(NUMS_THREAD);
        House house = new House(Map.of(
                "ROLE1", QUANTITY_ROLES,
                "ROLE2", QUANTITY_ROLES,
                "ROLE3", QUANTITY_ROLES));
        List<User> users = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            users.add(new User(String.valueOf(i),
                    String.format("ROLE%s", random.nextInt(1, QUANTITY_ROLES + 1)), house));
        }
        users.stream()
                .peek(user -> executor.submit(user::joinHouse))
                .forEach(user -> executor.submit(() -> user.leaveHouse(QUANTITY_ROLES)));
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
