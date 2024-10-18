package school.faang.m1s3.bjs2_37057_ironThrone;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House stark = new House("Stark");

        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");
        User doug = new User("Doug");

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> alice.joinHouse(stark, Role.MAGE));
        service.execute(() -> bob.joinHouse(stark, Role.KNIGHT));
        service.execute(() -> charlie.joinHouse(stark, Role.LORD));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
        }

        service.execute(() -> doug.joinHouse(stark, Role.LORD));
        service.execute(() -> alice.leaveHouse());
        service.execute(() -> charlie.leaveHouse());

        service.shutdown();

        try {
            if (!service.awaitTermination(5, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
        }

    }
}
