package faang.school.godbless.animalssup;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Organization organization = new Organization();

        addDonations(101, organization);

        System.out.println(organization.getBalance());
    }

    private static void addDonations(int count, Organization organization) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            final int finalI = i;
            executorService.execute(() -> organization.addDonation(new Donation(finalI, finalI)));
        }
        executorService.shutdown();
        awaitTermination(executorService, 5);
    }

    private static void awaitTermination(ExecutorService executorService, int minutes) {
        try {
            executorService.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
