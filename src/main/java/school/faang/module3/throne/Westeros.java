package school.faang.module3.throne;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Westeros {
    private static final int BATCH_SIZE = 3;
    private static final int HOUSE_METHOD_COUNT = 2;
    private static final String HOUSE_NAME = "STARK";

    private static final List<String> HOUSE_MEMBERS = List.of(
            "Eddard Stark",
            "Catelyn Stark",
            "Robb Stark",
            "Sansa Stark",
            "Arya Stark",
            "Bran Stark",
            "Rickon Stark",
            "Jon Snow"
    );

    private static final List<String> ROLES = List.of(
            "Assassin",
            "Three-Eyed Raven",
            "Heir of Winterfell",
            "Bastard of Winterfell"
    );

    public static void main(String[] args) throws NoSuchMethodException {
        ExecutorService executor = Executors.newFixedThreadPool(BATCH_SIZE);
        House starkOfWinterfell = new House(HOUSE_NAME, ROLES);
        HOUSE_MEMBERS.stream()
                .forEach(role -> {
                    User user = new User(role);
                    Runnable joinHouse = () -> {
                        user.joinHouse(starkOfWinterfell);
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        user.leaveHouse();
                    };

                    executor.execute(joinHouse);
                });

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("time out. force termination starting...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            executor.shutdownNow();
        }
    }
}
