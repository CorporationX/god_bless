package dima.evseenko.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Organization org = new Organization();

        ExecutorService executorService = Executors.newCachedThreadPool();

        getDonations().forEach(donation -> executorService.submit(() -> org.addDonation(donation)));

        executorService.shutdown();

        if (executorService.awaitTermination(100, TimeUnit.SECONDS)) {
            System.out.println(org.getTotalAmount());
        }
    }

    private static List<Donation> getDonations() {
        List<Donation> donations = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            donations.add(new Donation(i, i * 50));
        }

        return donations;
    }
}
