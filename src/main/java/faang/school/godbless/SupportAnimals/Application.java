package faang.school.godbless.SupportAnimals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Organization organization = new Organization();
        Donation donation1 = new Donation(1, 100);
        Donation donation2 = new Donation(2, 200);
        Donation donation3 = new Donation(3, 300);
        Donation donation4 = new Donation(4, 400);
        Donation donation5 = new Donation(5, 500);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.execute(() -> organization.addDonation(donation1));
        executorService.execute(() -> organization.addDonation(donation2));
        executorService.execute(() -> organization.addDonation(donation3));
        executorService.execute(() -> organization.addDonation(donation4));
        executorService.execute(() -> organization.addDonation(donation5));

        executorService.shutdown();

        if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println(organization.getBalance());
        }
    }
}
