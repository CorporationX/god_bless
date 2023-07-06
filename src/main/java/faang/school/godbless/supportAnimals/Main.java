package faang.school.godbless.supportAnimals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();

        int[] donations = {100, 200, 300, 350, 50};
        ExecutorService executorService = Executors.newFixedThreadPool(donations.length);

        for (int amount : donations) {
            executorService.execute(() -> organization.addDonation(new Donation(amount)));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Общий баланс организации: " + organization.getBalance());
    }

}
