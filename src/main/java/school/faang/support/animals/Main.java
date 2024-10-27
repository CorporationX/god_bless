package school.faang.support.animals;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_OF_THREADS = 8;
    private static final int DONATION_AMOUNT = 60;

    public static void main(String[] args) {
        Organization organization = new Organization();
        List<CompletableFuture<Void>> futures = IntStream.range(0, NUM_OF_THREADS)
                .mapToObj(i -> CompletableFuture.runAsync(() ->
                        organization.addDonation(new Donation(i, DONATION_AMOUNT))))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println(organization.getBalance()))
                .join();
    }
}
