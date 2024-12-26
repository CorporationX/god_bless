package school.faang.task51570;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {
    private static final int END_RANGE_ID = 10;
    private static final int MULTIPLIER_AMOUNT = 100;

    public static void main(String[] args) {
        Organization organization = new Organization();

        CompletableFuture.allOf(IntStream.range(0, END_RANGE_ID)
                        .mapToObj(i -> CompletableFuture
                                .supplyAsync(() -> organization.addDonation(
                                        new Donation(i,
                                                ThreadLocalRandom.current().nextDouble() * MULTIPLIER_AMOUNT))))
                        .toArray(CompletableFuture[]::new))
                .thenRun(organization::getTotalAmount)
                .join();
    }
}
