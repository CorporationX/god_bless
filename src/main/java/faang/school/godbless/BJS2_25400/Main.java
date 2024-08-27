package faang.school.godbless.BJS2_25400;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Organization org = new Organization();

        IntStream.rangeClosed(1, 100).forEach(i -> executor.execute(
                () -> {
                    int amount = random.nextInt(1_000, 100_000);
                    org.addDonation(new Donation(i, amount));
                }
        ));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Balance: " + org.getBalance());
    }
}
