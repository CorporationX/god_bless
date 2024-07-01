package faang.school.godbless.celebrity_twitter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    private static final int NEW_SUBSCRIPTIONS_NUM = 1000;

    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount twitterAccount = new TwitterAccount("SomeYouTuber", 0);

        List<CompletableFuture<Void>> futureFollowingList =
                IntStream.range(0, NEW_SUBSCRIPTIONS_NUM)
                        .mapToObj(subscriber -> twitterSubscriptionSystem.followAccount(twitterAccount))
                        .toList();

        CompletableFuture<Void> allOfCompletableFuture =
                CompletableFuture.allOf(futureFollowingList.toArray(CompletableFuture[]::new));

        allOfCompletableFuture.thenRun(() -> System.out.println(twitterAccount.getFollowers()))
                .join();
    }
}
