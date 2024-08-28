package faang.school.godbless.modul4.animals;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization(new AtomicLong());

        var donates = List.of(
                new Donation(1, 10000),
                new Donation(2, 15000),
                new Donation(3, 20000),
                new Donation(4, 30000),
                new Donation(5, 1)
        );

        CompletableFuture.allOf(donates.stream()
                .map(donation -> getRunAsync(organization, donation))
                .toArray(CompletableFuture[]::new)
        ).join();

        log.info("Total balance: " + organization.getBalance());
    }

    private static CompletableFuture<Void> getRunAsync(Organization organization, Donation donation) {
        return CompletableFuture.runAsync(() -> organization.addDonation(donation));
    }
}
