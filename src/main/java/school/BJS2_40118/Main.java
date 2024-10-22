package school.BJS2_40118;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main {

    private static final int MIN_SUM_OF_DONATION = 150;
    private static final int MAX_SUM_OF_DONATION = 1000;

    public static void main(String[] args) {

        Random rand = new Random();
        Organization organization = new Organization();

        for (int i = 0; i < 10; i++) {
            Donation donation = new Donation(i, rand.nextInt(MIN_SUM_OF_DONATION,MAX_SUM_OF_DONATION));
            CompletableFuture.runAsync(() -> organization.addDonation(donation)).join();
        }

        organization.printDonations();

    }
}
