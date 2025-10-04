package school.faang.m1.concurrency.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int threads = Math.max(4, Runtime.getRuntime().availableProcessors());
        ExecutorService pool = Executors.newFixedThreadPool(threads);

        try (Organization org = new Organization(pool)) {
            int volunteers = 16;
            int donationsPerVolunteer = 1_000;
            Random rnd = new Random(42);

            List<CompletableFuture<Void>> tasks = new ArrayList<>();

            for (int v = 0; v < volunteers; v++) {
                int volunteerId = v;

                // Каждый волонтёр создаёт пожертвования (в т.ч. с возможными дубликатами ID)
                tasks.add(CompletableFuture.runAsync(() -> {
                    for (int i = 0; i < donationsPerVolunteer; i++) {
                        // часть ID повторяется
                        int donationId = rnd.nextInt(donationsPerVolunteer / 2) + i / 4;
                        double amount = 1.00 + (rnd.nextInt(500) / 100.0); // 1.00..5.99

                        org.addDonation(new Donation(donationId, amount));
                    }
                    System.out.println("Volunteer #" + volunteerId + " done");
                }, org.executor()));
            }

            // Дождаться всех волонтёров
            CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).join();

            double total = org.getBalance();

            System.out.printf("Итоговый баланс организации: %.2f%n", total);
        }
    }
}
