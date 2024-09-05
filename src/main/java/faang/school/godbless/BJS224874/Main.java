package faang.school.godbless.BJS224874;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("rmnbks");

        var futures = IntStream.range(0, 100)
                .mapToObj(i -> TwitterSubscriptionSystem.followAccount(account))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }
}
