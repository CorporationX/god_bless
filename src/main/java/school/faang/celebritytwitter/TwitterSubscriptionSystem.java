package school.faang.celebritytwitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    public static void main(String[] args) {
        TwitterSubscriptionSystem twitter = new TwitterSubscriptionSystem();
        ExecutorService service = Executors.newFixedThreadPool(5);
        TwitterAccount account = new TwitterAccount("Maksim");
        CompletableFuture<TwitterAccount> addFirstFollower = twitter.followAccount(account, service);
        CompletableFuture<TwitterAccount> addSecondFollower = twitter.followAccount(account, service);
        CompletableFuture<TwitterAccount> addThirdFollower = twitter.followAccount(account, service);
        CompletableFuture<Void> allOf = CompletableFuture.allOf(addFirstFollower, addSecondFollower, addThirdFollower);
        allOf.thenAccept(v -> System.out.println(account.getFollowers()));
        service.shutdown();
    }

    private synchronized void addFollower(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
    }

    private CompletableFuture<TwitterAccount> followAccount(TwitterAccount account, ExecutorService service) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new IllegalStateException("Ошибка в методе followAccount()", e);
            }
            for (int i = 0; i < 10; i++) {
                addFollower(account);
            }
            return account;
        }, service);
    }
}
