package school.faang.async.twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class Main {

    private static final int FOLLOWERS_TO_GENERATE = 100;

    public static void main(String[] args) {
        TwitterAccount newAccount = new TwitterAccount(UsernameGenerator.generateUserName(), new AtomicInteger(1000));

        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        CompletableFuture
                .allOf(generateFollowers(system, newAccount).toArray(new CompletableFuture[0]))
                .join();

        log.info("Total followers of {}: {}", newAccount.getUserName(), newAccount.getFollowers());
    }

    private static List<CompletableFuture<Integer>> generateFollowers(TwitterSubscriptionSystem system,
                                                                      TwitterAccount account) {
        return IntStream.range(0, FOLLOWERS_TO_GENERATE)
                .mapToObj((follower) -> system.followAccount(account))
                .toList();
    }
}
