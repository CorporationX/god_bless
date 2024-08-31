package faang.school.godbless.sprint4.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    private static final int QUANTITY_OF_DONATIONS = 10_000;
    private static final List<Donation> donations = new ArrayList<>(QUANTITY_OF_DONATIONS);
    private static final Random random = new Random();
    private static final Organization organization = new Organization();

    public static void main(String[] args) {
        createDonationsList();
        CompletableFuture.allOf(createFuturesList().toArray(CompletableFuture[]::new))
                .thenRun(() -> System.out.printf("Общая сумма пожертвований: %s", organization.getBalance()))
                .join();
    }

    private static void createDonationsList() {
        IntStream.rangeClosed(1, QUANTITY_OF_DONATIONS)
                .mapToObj(number -> new Donation(number, random.nextInt(1, 100_000)))
                .forEach(donations::add);
    }

    private static List<CompletableFuture<Void>> createFuturesList() {
        return donations.stream()
                .map(donation -> CompletableFuture
                        .runAsync(() -> organization.addDonation(donation)))
                .toList();
    }
}
