package faang.school.godbless.twittercelebrity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    private static final TwitterSubscriptionSystem SUBSCRIPTION_SYSTEM = new TwitterSubscriptionSystem();

    public static void main(String[] args) {
        TwitterAccount elonMask = new TwitterAccount("Elon Mask", 1000000000);
        System.out.println(String.format("Total %s followers: %d", elonMask.getUsername(), elonMask.getFollowers()));

        List<CompletableFuture<Void>> processedFollows = processFollows(elonMask, 100L);
        CompletableFuture.allOf(processedFollows.toArray(CompletableFuture[]::new)).join();

        SUBSCRIPTION_SYSTEM.shutDownAndAwaitExecutor(5L);
        System.out.println(String.format("Total %s followers: %d", elonMask.getUsername(), elonMask.getFollowers()));
    }

    private static List<CompletableFuture<Void>> processFollows(TwitterAccount account, Long count) {
        List<CompletableFuture<Void>> processedFollows = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            processedFollows.add(SUBSCRIPTION_SYSTEM.followAccount(account));
        }
        return processedFollows;
    }
}
