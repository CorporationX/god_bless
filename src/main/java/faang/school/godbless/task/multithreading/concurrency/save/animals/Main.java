package faang.school.godbless.task.multithreading.concurrency.save.animals;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int MIN_DONATION = 1;
    private static final int MAX_DONATION = 500;
    private static final int NUMBER_OF_DONATION = 25;

    private static final Random random = new Random();
    private static final Organization organization = new Organization();

    public static void main(String[] args) {
        CompletableFuture.allOf(runTask().toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Balance of organization: {}", organization.getBalance().get()))
                .join();
    }

    private static List<CompletableFuture<Void>> runTask() {
        return IntStream
                .rangeClosed(1, NUMBER_OF_DONATION)
                .mapToObj(i -> CompletableFuture.runAsync(() -> organization.addDonation(getDonation(i))))
                .toList();
    }

    private static Donation getDonation(long id) {
        return new Donation(id, random.nextLong(MAX_DONATION - MIN_DONATION) + MIN_DONATION);
    }
}
