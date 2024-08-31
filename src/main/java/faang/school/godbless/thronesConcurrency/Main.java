package faang.school.godbless.thronesConcurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final List<String> ROLES = new ArrayList<>(Arrays.asList("Paladin", "Cleric", "Bard"));
    private static final List<User> users = new ArrayList<>();

    private static final int NUMBER_THREADS = 4;
    private static final int PLAYERS = 10000;

    private static final long MAIN_THREAD_WAITING = 5000L;

    public static void main(String[] args) throws InterruptedException {
        House house = new House("Vesteros", ROLES);

        for (int i = 0; i < PLAYERS; i++) {
            users.add(new User(String.valueOf(i), house));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_THREADS);
        users.forEach(u -> executorService.execute(() -> {
            u.joinHouse();
            u.leaveHouse();
        }));
        executorService.shutdown();
        executorService.awaitTermination(MAIN_THREAD_WAITING, TimeUnit.SECONDS);
    }
}
