package faang.school.godbless.sprint5.multithreading_conc.task3_animals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Organization org = new Organization();

        ExecutorService executor = Executors.newFixedThreadPool(5);


        for (int i = 0; i < 10_000; i++) {
            Donation donation = new Donation(i, 1);
            executor.execute(() -> org.addDonation(donation));
        }

        executor.shutdown();

        executor.awaitTermination(3, TimeUnit.SECONDS);

        System.out.println(org.getBalance());
    }
}
