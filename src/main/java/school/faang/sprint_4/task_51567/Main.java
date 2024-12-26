package school.faang.sprint_4.task_51567;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int AMOUNT_OF_DONATIONS = 1000;
    private static final double SUM_RATE_PER_DONATION = 100;

    public static void main(String[] args) {
        Organization organization = new Organization();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 1; i <= AMOUNT_OF_DONATIONS; i++) {
            int finalI = i;
            futures.add(CompletableFuture.runAsync(() -> organization.addDonation(finalI * SUM_RATE_PER_DONATION)));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println(organization.getTotalBalance());
    }
}
