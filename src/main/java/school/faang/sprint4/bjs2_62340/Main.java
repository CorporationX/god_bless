package school.faang.sprint4.bjs2_62340;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("AntonB", 0);
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> futures = List.of(
                subscriptionSystem.followAccount(account),
                subscriptionSystem.followAccount(account),
                subscriptionSystem.followAccount(account)
        );
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.thenRun(() -> {
            System.out.println("Учетная запись: " + account.getName());
            System.out.println("Количество подписчиков: " + account.getFollowers());
        }).join();
    }
}
