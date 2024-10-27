package school.faang.support_animals_BJS2_40112;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int DONATIONS_COUNT = 15;
    private static final int DONATION_AMOUNT = 1000;
    private static final int AWAITING_TIME = 3;

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Organization organization = new Organization();

        for (int i = 0; i < DONATIONS_COUNT; i++) {
            int count = i;
            service.submit(() -> organization.addDonation(new Donation(count, DONATION_AMOUNT + count)));
        }

        service.shutdown();
        try {
            if (service.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES)) {
                System.out.println("Total donations amount: " + organization.getTotalDonations());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}