package animals.care;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Main {
    private static final int DONATION_COUNT = 100;

    public static void main(String[] args) {
        Organization organization = new Organization();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < DONATION_COUNT; i++) {
            futures.add(CompletableFuture.runAsync(() -> organization.addDonation(
                    new Donation(ThreadLocalRandom.current().nextInt(500) + 500))));
        }
        futures.forEach(CompletableFuture::join);
        log.info("Organization balance: " + organization.getBalance() + "$");
    }
}
