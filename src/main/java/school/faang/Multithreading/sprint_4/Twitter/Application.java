package school.faang.Multithreading.sprint_4.Twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Application {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount cats = new TwitterAccount("Смешные котики", 0);
        List<CompletableFuture<Void>> allOperations = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
           CompletableFuture<Void> future = CompletableFuture.runAsync(() -> subscriptionSystem.followAccount(cats));
           allOperations.add(future);
        }

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> subscriptionSystem.followAccount(cats));
        future2.join();

        CompletableFuture.allOf(allOperations.toArray(new CompletableFuture[0])).join();

        System.out.println(cats);
    }
}
