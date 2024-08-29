package faang.school.godbless.bjs2_24780;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int USERS_AMOUNT = 100;

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Jack Dorsey");
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        CompletableFuture[] futures = IntStream.rangeClosed(1, USERS_AMOUNT)
                .mapToObj(i -> system.followAccount(account))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();
        system.finish();

        log.info("{}'s followers = {}", account.getUsername(), account.getFollowers());
    }
}
