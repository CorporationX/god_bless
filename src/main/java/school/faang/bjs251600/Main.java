package school.faang.bjs251600;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {

    private static final int DONATIONS_AMOUNT = 199;
    private static final int MULTIPLIER = 1000;

    public static void main(String[] args) {

        Organization organization = new Organization();

        CompletableFuture.allOf(IntStream.range(0, DONATIONS_AMOUNT)
                        .mapToObj(i -> CompletableFuture
                                .supplyAsync(() -> organization.addDonation(
                                        new Donation(i,
                                                ThreadLocalRandom.current().nextDouble() * MULTIPLIER))))
                        .toArray(CompletableFuture[]::new))
                .thenRun(organization::printBalace)
                .join();
    }
}