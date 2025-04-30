package school.faang.bjs2_74731;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    public static void main(String[] args) {
        TwitterSubscriptionSystem tss = new TwitterSubscriptionSystem();

        List<TwitterAccount> ta = List.of(
                new TwitterAccount("Jon", 0),
                new TwitterAccount("Kim", 100),
                new TwitterAccount("Ron", 1),
                new TwitterAccount("Dan", 30),
                new TwitterAccount("Fring", 400),
                new TwitterAccount("Fat", 560)
        );

        List<CompletableFuture<Void>> futures = ta.stream().map(tss::followAccount).toList();

        CompletableFuture<Void> result = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        result.thenAccept(v -> ta.forEach(
                        account -> log.info("User - {}, has {} followers",
                                account.getUsername(),
                                account.getFollowers())
                ))
                .join();
    }
}
