package school.faang.ironthrone;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final House HOUSE = new House();
    private static final List<String> ROLES = List.of(
            "Lady", "Lord", "Knight"
    );
    private static final List<String> NAMES = List.of(
            "Max", "Bob", "Lina", "Alina", "Andrey", "Nick", "Alex", "Evgeniy"
    );
    private static final List<User> USERS = new ArrayList<>();
    private static final Random RANDOM = new Random();
    private static final int TIME_EXECUTION = 1;
    private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;

    private static ExecutorService executor;

    public static void main(String[] args) throws InterruptedException {
        HOUSE.addPackageRoles(ROLES);
        NAMES.forEach(name -> USERS.add(new User(name)));
        executor = Executors.newFixedThreadPool(USERS.size());
        USERS.forEach(user -> executor.submit(() -> executeWithException(() -> {
            user.joinHouse(HOUSE, ROLES.get(RANDOM.nextInt(ROLES.size())));
            user.leaveHouse(HOUSE);
        })));
        executor.shutdown();
        boolean isTerminated = executor.awaitTermination(TIME_EXECUTION, TIME_UNIT);
        if (isTerminated) {
            log.info("All users received and released random roles");
        } else {
            log.warn("Timed out {} {}", TIME_EXECUTION, TIME_UNIT);
            executor.shutdownNow();
        }
    }

    private static void executeWithException(RunnableWithException task) {
        try {
            task.run();
        } catch (InterruptedException exception) {
            log.error("Thread has been interrupted. Thread name: {}\nException: {}\nStack trace: {}",
                    Thread.currentThread().getName(), exception, exception.getStackTrace());
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }
}

