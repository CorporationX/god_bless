package school.faang.gameofthrones;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        Role knight = new Role("Knight");
        Role lord = new Role("Lord");
        Role mag = new Role("Magician");
        List<Role> roles = Collections.synchronizedList(new ArrayList<>(Arrays.asList(knight, lord, mag)));

        House lannister = new House("Lannister", roles);

        User user1 = new User("Dimasik");
        User user2 = new User("Serega");
        User user3 = new User("Danya");
        User user4 = new User("Evgeny");
        User user5 = new User("Maksim");
        User user6 = new User("Alexey");
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        executorService.submit(() -> user1.joinHouse(lannister, mag));
        executorService.submit(() -> user2.joinHouse(lannister, knight));
        executorService.submit(() -> user3.joinHouse(lannister, lord));
        executorService.submit(() -> user1.leaveHouse(lannister));
        executorService.submit(() -> user4.joinHouse(lannister, mag));
        executorService.submit(() -> user5.joinHouse(lannister, knight));
        executorService.submit(() -> user6.joinHouse(lannister, lord));
        executorService.submit(() -> user2.leaveHouse(lannister));
        executorService.submit(() -> user3.leaveHouse(lannister));

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                System.out.println("Tasks not completed in 5 minutes, forced to disconnect");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            e.printStackTrace();
            log.error("The current thread is interrupted while waiting for the worker service to complete: ", e);
        }
    }
}
