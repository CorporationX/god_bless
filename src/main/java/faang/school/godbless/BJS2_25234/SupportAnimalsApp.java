package faang.school.godbless.BJS2_25234;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SupportAnimalsApp {
    public static void main(String[] args) {
        var organization = new Organization("Mew-Mew");
        var donations = getDonations();
        var executorService = Executors.newFixedThreadPool(3);

        donations.forEach(donation ->
                executorService.submit(() -> {
                    var balance = organization.addDonation(donation);
                    System.out.printf("Donated %d! Balance is: %d\n", donation.getAmount(), balance);
                }));

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(2, TimeUnit.MINUTES))
                System.out.printf("Balance of organization: %d%n", organization.getBalance().get());
        } catch (InterruptedException e) {
            System.out.printf("%s was interrupted\n", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }

    public static List<Donation> getDonations() {
        var donations = new ArrayList<Donation>();

        for (int i = 0; i < 30; i++) {
            donations.add(new Donation((i + 1), (i + 1) * 100));
        }

        return donations;
    }
}
