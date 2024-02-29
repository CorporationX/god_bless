package become_selebrity_in_twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

class TwitterSubscriptionSystem {
    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (account) {
                account.addFollower();
                System.out.println(Thread.currentThread().getName() +
                        " followed " + account.getUsername() +
                        ". Followers: " + account.getFollowers());
            }
        });
    }
}
