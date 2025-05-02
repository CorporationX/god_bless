package faang.BJS2_74770;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public final class Main {
    private static final int TARGET_FOLLOWERS_COUNT = 10;

    public static void main(final String[] args) {
        final TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        final TwitterAccount mainAccount = new TwitterAccount("Lada", 2);
        final List<CompletableFuture<Void>> followers = generateFollowers(twitterSubscriptionSystem, mainAccount);

        CompletableFuture.allOf(followers.toArray(new CompletableFuture[0])).join();
        log.info("{} has followers {}", mainAccount.getUsername(), mainAccount.getFollowers());
    }

    private static List<CompletableFuture<Void>> generateFollowers(TwitterSubscriptionSystem twitterSubscriptionSystem, TwitterAccount mainAccount) {
        return IntStream.range(0, TARGET_FOLLOWERS_COUNT)
                .mapToObj(temp -> twitterSubscriptionSystem.followAccount(mainAccount))
                .toList();
    }
}


