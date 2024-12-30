package school.faang.sprint3.bjs_48809;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 5;
    private static final int TIME_TO_LEAVE = 100;

    public static void main(String[] args) {
        List<Role> rolesList = List.of(Role.KNIGHT, Role.LORD, Role.MAGICIAN);
        List<User> users = List.of(
                new User("User1"),
                new User("User2"),
                new User("User3"),
                new User("User4"),
                new User("User5"));

        House house = new House(rolesList);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        users.forEach(user -> executorService.execute(() -> {
            try {
                user.joinHouse(house);
                Thread.sleep(TIME_TO_LEAVE);
                user.leaveHouse();
            } catch (InterruptedException e) {
                log.error("Unexpected error");
            }
        }));
        executorService.shutdown();
    }
}
