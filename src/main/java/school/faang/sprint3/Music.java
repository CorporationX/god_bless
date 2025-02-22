package school.faang.sprint3;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(3);
    private static final List<String> USERS = List.of("user1", "user2", "user3");
    private static final int PROGRAM_OPERATION = 10;
    private static final Player PLAYER = new Player();
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        USERS.forEach(user -> EXECUTOR.submit(Music::userActions));
        EXECUTOR.shutdown();

        try {
            if (!EXECUTOR.awaitTermination(PROGRAM_OPERATION, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            EXECUTOR.shutdownNow();
        }
    }

    private static void userActions() {
        PLAYER.play();
        sleep(randomMillis());
        PLAYER.skip();
        sleep(randomMillis());
        PLAYER.pause();
        sleep(randomMillis());
        PLAYER.previous();
        sleep(randomMillis());
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private static long randomMillis() {
        return RANDOM.nextLong(1, 3) * 1000;
    }
}
