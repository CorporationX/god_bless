package faang.school.godbless.BJS2_25238;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();

        Runnable processingFirstDonate = () -> organization.addDonation(new Donation(1, 1000));
        Runnable processingSecondDonate = () -> organization.addDonation(new Donation(2, 3000));
        Runnable processingThirdDonate = () -> organization.addDonation(new Donation(3, 500));

        ExecutorService executor = Executors.newCachedThreadPool();
        Stream.of(processingFirstDonate, processingSecondDonate, processingThirdDonate)
                .forEach(executor::execute);

        executor.shutdown();
        try {
            if(!executor.awaitTermination(100, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Await error");
        }

        System.out.println(organization.getBalance().get());
    }
}
