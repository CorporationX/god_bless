package faang.school.godbless.multithreading.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    public static CompletableFuture<Void> followAccount(TwitterAccount account) {
        return TwitterSubscriptionSystem.addFollower(account);
    }

    public static void main(String[] args) {
        AtomicInteger followers =  new AtomicInteger(0);
        TwitterAccount account = new TwitterAccount("MyTwitterAccount", followers);

        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
        IntStream.range(0, 10)
                .forEach((i) -> completableFutures.add(followAccount(account)));

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();

        System.out.printf("Total followers %d", account.followers().get());
    }
}
