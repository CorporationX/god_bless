package school.faang.Twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Slf4j
public class TwitterSubscriptionSystem {
    private final static Map<TwitterAccount, List<TwitterAccount>> accounts = new ConcurrentHashMap<>();
    private final static ExecutorService service = Executors.newFixedThreadPool(10);

    public static CompletableFuture<Void> subscribe(TwitterAccount follower, TwitterAccount following) {
        return CompletableFuture.runAsync(() -> {
            log.info("{} trying to subscribe to {}", following.getUsername(), follower.getUsername());
            follower.addFollower(following);
            accounts.computeIfAbsent(follower, k -> new ArrayList<>()).add(following);
        }, service);
    }

    public static CompletableFuture<Void> unsubscribe(TwitterAccount follower, TwitterAccount following) {
        return CompletableFuture.runAsync(() -> {
            log.info("{} trying to unsubscribe from {}", following.getUsername(), follower.getUsername());
            follower.removeFollower(following);
            accounts.computeIfAbsent(follower, k -> new ArrayList<>()).remove(following);
        }, service);
    }

    public static void main(String[] args) {
        TwitterAccount someCelebrity = new TwitterAccount("John");

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            TwitterAccount subscriber = new TwitterAccount("User" + i);
            futures.add(subscribe(someCelebrity, subscriber));
            if (i%10 == 0){
                futures.add(subscribe(subscriber, someCelebrity));
            }
        }

        service.shutdown();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenRun(() -> {
            log.info("{} have {} followers \n", someCelebrity.getUsername(), someCelebrity.getFollowers());
        });

        try {
            if (!service.awaitTermination(10, TimeUnit.SECONDS)){
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Something went wrong", e);
        }
    }
}
