package school.faang.bjs2_93039;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static final int DEFAULT_VALUE = 1;
    public static final int DEFAULT_FOLLOWERS_COUNT = 100;


    public static void main(String[] args) {
        List<Integer> integers = List.of(DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE);
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount twitterAccount = new TwitterAccount("bestAccount", DEFAULT_FOLLOWERS_COUNT);

        List<CompletableFuture<Integer>> futures = integers.stream()
                .map(integer -> twitterSubscriptionSystem.followAccount(twitterAccount))
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();
        System.out.printf("Now Twitter account %s has %d followers\n",
                twitterAccount.getUsername(),
                twitterAccount.getFollowers());
        twitterSubscriptionSystem.shutdownExecutorService();
    }
}
