package school.faang.bjs2_93026;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_ACCOUNTS_FOR_TEST = 1_000;

    public static void main(String[] args)  {
        TwitterAccount account = new TwitterAccount("exampleUser", new AtomicInteger());
        SubscriptionSystem system = new SubscriptionSystem();

        List<TwitterAccount> accounts = IntStream.range(0, NUMBER_OF_ACCOUNTS_FOR_TEST)
                .mapToObj(i -> new TwitterAccount("Test account " + i, new AtomicInteger()))
                .toList();


        try {
            CompletableFuture<Void> allTasks = system.followMultipleTimes(accounts, account);
            allTasks.join();
            log.info("Final number of followers: {}", account.getFollowers());
        } catch (Exception e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            system.exShutdown();
        }


    }
}
