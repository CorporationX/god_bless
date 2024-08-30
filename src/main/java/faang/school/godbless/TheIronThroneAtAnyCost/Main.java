package faang.school.godbless.TheIronThroneAtAnyCost;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        List<String> availableRoles = List.of("Mage", "Knight", "Meister");
        List<House> houses = createHouses();

        int userCount = 20;

        ExecutorService executorService = Executors.newFixedThreadPool(userCount);

        for (int i = 0; i < userCount; i++) {
            User user = new User("User" + i);
            int roleIndex = random.nextInt(availableRoles.size());

            houses.forEach(house -> executorService.execute(() -> {
                user.joinHouse(house, availableRoles.get(roleIndex));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.error("Error while sleeping: {}", e.getMessage());
                    Thread.currentThread().interrupt();
                }
                user.leaveHouse();
            }));
        }

        executorService.shutdown();
    }

    private static List<House> createHouses() {
        Map<String, Integer> roles = new HashMap<>();
        roles.put("Mage", 3);
        roles.put("Knight", 10);
        roles.put("Meister", 2);

        return List.of(new House("Lannister", roles));
    }
}
