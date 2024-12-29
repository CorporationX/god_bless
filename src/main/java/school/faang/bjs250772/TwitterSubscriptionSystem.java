package school.faang.bjs250772;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1_000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            account.addFollower();
        });
    }

}
