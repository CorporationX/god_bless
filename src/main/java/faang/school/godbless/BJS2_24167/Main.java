package faang.school.godbless.BJS2_24167;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final List<String> availableRoles = List.of("Mage", "Knight", "Meister");
    private static final Random random = new Random();
    private static final List<House> houses = new ArrayList<>();
    private static final int USER_COUNT = 20;
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        House lannister = new House("Lannister");
        lannister.addRoleAndAmount("Mage", 3);
        lannister.addRoleAndAmount("Knight", 10);
        lannister.addRoleAndAmount("Meister", 2);
        houses.add(lannister);

        ExecutorService executorService = Executors.newFixedThreadPool(USER_COUNT);

        for (int i = 0; i < USER_COUNT; i++) {
            User user = new User("User" + i);
            int roleIndex = random.nextInt(availableRoles.size());

            houses.forEach(house -> executorService.execute(() -> {
                user.joinHouse(house, availableRoles.get(roleIndex));
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
                user.leaveHouse();
            }));
        }

        executorService.shutdown();
    }
}
