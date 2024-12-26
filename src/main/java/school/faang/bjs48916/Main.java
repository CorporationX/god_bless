package school.faang.bjs48916;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int USERS_NUMBER = 10;
    public static final long TEST_TIME = 1_000;

    public static void main(String[] args) {
        House house = new House();
        List<User> users = new ArrayList<>();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(USERS_NUMBER);

        for (int i = 0; i < USERS_NUMBER; i++) {
            users.add(new User("User " + i, house));
        }

        users.forEach((user) -> {
            service.submit(user::joinHouse);
            try {
                Thread.sleep(House.GOVERNANCE_PERIOD / USERS_NUMBER);
            } catch (InterruptedException ignored) {

            }
        });

        service.shutdown();
        house.periodManager.shutdown();
        log.info("daf");
        try {
            if (!service.awaitTermination(TEST_TIME, TimeUnit.MILLISECONDS)) {
                log.info("daf");
                service.shutdownNow();
                house.periodManager.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
