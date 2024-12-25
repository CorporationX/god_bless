package school.faang.task50663;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<TwitterAccount> accounts = IntStream.range(0, 10)
                .boxed()
                .map(i -> new TwitterAccount(String.format("name%s", i), new ArrayList<>()))
                .toList();

        Random random = new Random();
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        CompletableFuture
                .allOf(accounts.stream()
                        .parallel()
                        .map(account -> CompletableFuture.supplyAsync(() -> {
                            try {
                                return Optional.of(system.followAccount(account, accounts
                                        .get(random.nextInt(accounts.size()))));
                            } catch (IllegalArgumentException e) {
                                log.info(e.getMessage());
                            }
                            return Optional.empty();
                        }))
                        .toArray(CompletableFuture[]::new))
                .join();
    }
}
