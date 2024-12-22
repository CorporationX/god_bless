package school.faang.task50663;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
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
                        .map(account -> {
                            try {
                                return system.followAccount(account, accounts.get(random.nextInt(accounts.size())));
                            } catch (IllegalArgumentException e) {
                                log.info(e.getMessage());
                            }
                            return null;
                        })
                        .filter(Objects::nonNull)
                        .toArray(CompletableFuture[]::new))
                .join();
    }
}
