package school.faang.irontron;

import lombok.extern.slf4j.Slf4j;

import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class HouseRunner {
    public static void main(String[] args) {
        House stark = new House("Stark", EnumSet.of(Role.MAG, Role.LORD, Role.KNIGHT));
        int playerCount = 3;
        ExecutorService executor = Executors.newFixedThreadPool(playerCount);
        for (int i = 0; i < playerCount; i++) {
            executor.execute(() -> {
                Random random = new Random();
                User user = new User("user:");
                List<Role> roles = List.of(Role.MAG, Role.LORD, Role.KNIGHT);
                Role randomRole = roles.get(random.nextInt(0, 3));
                user.joinHouse(stark, randomRole);
                try {
                    int sleep = 2000;
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    log.warn(e.getMessage());
                }
                user.leaveHouse();
            });
        }
        executor.shutdown();


    }
}
