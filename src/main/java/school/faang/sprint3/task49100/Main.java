package school.faang.sprint3.task49100;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint3.task49100.model.House;
import school.faang.sprint3.task49100.model.Role;
import school.faang.sprint3.task49100.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int MAX_USERS = 20;

    public static void main(String[] args) {

        List<Role> starkHouseRoles = getRoles();
        House house = new House("Stark", starkHouseRoles);
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < MAX_USERS; i++) {
            UserScenario userScenario = new UserScenario(new User("User " + i), house);
            executor.submit(userScenario);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private static List<Role> getRoles() {
        List<Role> starkHouseRoles = new ArrayList<>();

        starkHouseRoles.add(Role.HEAD);
        starkHouseRoles.add(Role.APPLE_OF_THE_EYE);
        starkHouseRoles.add(Role.KNIGHT);
        starkHouseRoles.add(Role.KNIGHT);
        starkHouseRoles.add(Role.MASTER);
        starkHouseRoles.add(Role.JESTER);
        return starkHouseRoles;
    }
}
