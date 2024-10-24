package school.faang.BJS2_39022_TwitterCelebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final TwitterSubscriptionSystem SYSTEM = new TwitterSubscriptionSystem();

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Celebrity");
        addFollowers(account, 5);
    }

    private static void addFollowers(TwitterAccount account, int followersCount) {
        CompletableFuture<?>[] subscriptionResults = new CompletableFuture[followersCount];
        for (int followerIndex = 0; followerIndex < followersCount; followerIndex++) {
            subscriptionResults[followerIndex] = SYSTEM.followAccount(account);
        }
        CompletableFuture.allOf(subscriptionResults)
                .thenRun(() -> log.info("Successfully added {} followers to {}'s account!", followersCount, account.getUsername()))
                .join();
    }
}
