package faang.school.godbless.SupportAnimals;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final int NUM_DONATIONS = 1000;

    public static void main(String[] args) {
        List<Donation> donations = getDonations();
        Organization organization = new Organization(0);

        List<CompletableFuture<Void>> tasks = new ArrayList<>();
        for (Donation donation : donations) {
            tasks.add(CompletableFuture.runAsync(() -> {
                organization.addDonation(donation);
                log.info(organization.getBalance().toString());
            }));
        }
        CompletableFuture.allOf(tasks.toArray(CompletableFuture[]::new)).join();

        log.info("final balance -> {}", organization.getBalance().toString());
    }

    private static List<Donation> getDonations() {
        List<Donation> donations = new ArrayList<>();
        for (int i = 1; i <= NUM_DONATIONS; i++) {
            donations.add(new Donation(i, 1));
        }
        return donations;
    }
}
