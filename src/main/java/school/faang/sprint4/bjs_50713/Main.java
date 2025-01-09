package school.faang.sprint4.bjs_50713;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int REQUESTS = 13;
    private static final int FOLLOWERS_INIT = 100;

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Celebrity", FOLLOWERS_INIT);
        TwitterSubscriptionSystem subscriber = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> followFutures = IntStream.range(0, REQUESTS)
                .mapToObj(follower -> subscriber.followAccount(account))
                .toList();

        CompletableFuture.allOf(followFutures.toArray(new CompletableFuture[0])).join();
        log.info("Now account {} has {} followers", account.getUserName(), account.getFollowers());
    }
}
