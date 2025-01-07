package school.faang.bjs250859;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem(Constants.NUM_THREADS);
        TwitterAccount account = new TwitterAccount("salikdev");

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < Constants.FOLLOWERS_NUMBER.getValue(); i++) {
                subscriptionSystem.followAccount(account);
            }
        });

        future.join();
        subscriptionSystem.shutdown();
    }
}
