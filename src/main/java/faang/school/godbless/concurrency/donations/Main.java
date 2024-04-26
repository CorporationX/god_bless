package faang.school.godbless.concurrency.donations;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();

        log.info("Organization balance at this point: " + organization.getCurrentBalance());

        List<CompletableFuture<Void>> donationOperations = new ArrayList<>();

        int expectedBalance = organization.getCurrentBalance();

        for (int i = 0; i < 100; i++) {
            var donationAmount = ThreadLocalRandom.current().nextInt(0, 10000);
            int donationId = i;

            expectedBalance += donationAmount;

            donationOperations.add(CompletableFuture.runAsync(() -> organization.addDonation(new Donation(donationId, donationAmount))));
        }

        CompletableFuture.allOf(donationOperations.toArray(new CompletableFuture[0])).join();

        log.info("Organization balance at this point: " + organization.getCurrentBalance());
        assertEquals(expectedBalance, organization.getCurrentBalance());
    }
}
