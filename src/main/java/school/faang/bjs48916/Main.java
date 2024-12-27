package school.faang.bjs48916;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int USERS_NUMBER = 10;
    public static final long TEST_TIME = 15_000;

    public static void main(String[] args) {
        var service = Executors.newFixedThreadPool(5);
        var house = new House();
        try {
            test(service, house);

            Thread.sleep(TEST_TIME);
            service.shutdown();
            house.disband();
            if (!service.awaitTermination(TEST_TIME, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error while testing main features");
            service.shutdownNow();
        }
    }

    public static void test(ExecutorService service, House house) throws InterruptedException {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < USERS_NUMBER; i++) {
            users.add(new User("User " + i, house));
        }

        users.forEach((user) -> {
            service.submit(user::tryGetRole);
        });
    }
}
