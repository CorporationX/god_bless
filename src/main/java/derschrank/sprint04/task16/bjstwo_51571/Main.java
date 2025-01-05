package derschrank.sprint04.task16.bjstwo_51571;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int COUNT_OF_DONATIONS = 1000;
    private static final int AMOUNT_OF_DONATIONS = 100;

    public static void main(String[] args) {
        Organization org = new Organization();
        List<CompletableFuture<Void>> futures = new LinkedList<>();
        for (int i = 0; i < COUNT_OF_DONATIONS; i++) {
            final int id = i;
            futures.add(
                    CompletableFuture.supplyAsync(
                            () -> new Donation(id, AMOUNT_OF_DONATIONS)
                    )
                    .thenCompose(donat -> CompletableFuture.runAsync(
                            () -> org.addDonation(donat))
                    )
            );
        }

        futures.forEach(CompletableFuture::join);

        System.out.println("Sum of Donations is: " + org.getAmount());
    }
}
