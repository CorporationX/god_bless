package faang.school.godbless.twitter;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {

    private static final int FROM_RANGE = 0;
    private static final int TO_RANGE = 101;

    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        TwitterAccount account = new TwitterAccount("Test");

        System.out.println(account.getFollowers());
        CompletableFuture.allOf(IntStream.range(FROM_RANGE, TO_RANGE)
                        .mapToObj(i -> subscriptionSystem.followAccount(account))
                        .toArray(CompletableFuture[]::new))
                .join();
        System.out.println(account.getFollowers());
    }
}
