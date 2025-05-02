package school.faang.bjs2_74731;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {

    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        List<TwitterAccount> twitterAccounts = List.of(
                new TwitterAccount("Jon", new AtomicInteger(0)),
                new TwitterAccount("Kim", new AtomicInteger(100)),
                new TwitterAccount("Ron", new AtomicInteger(1)),
                new TwitterAccount("Dan", new AtomicInteger(30)),
                new TwitterAccount("Fring", new AtomicInteger(400)),
                new TwitterAccount("Fat", new AtomicInteger(560))
        );

        List<CompletableFuture<Void>> futures = twitterAccounts.stream()
                .map(twitterSubscriptionSystem::followAccount)
                .toList();

        CompletableFuture<Void> result = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        result.thenAccept(v -> twitterAccounts.forEach(
                        account -> log.info("User - {}, has {} followers",
                                account.getUsername(),
                                account.getFollowers())
                ))
                .join();
    }
}
