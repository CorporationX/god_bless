package school.faang.bjs2_93026;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Slf4j
public class Main {
    public static void main(String[] args)  {
        TwitterAccount account = new TwitterAccount("exampleUser", 12_131);
        SubscriptionSystem system = new SubscriptionSystem();

        List<TwitterAccount> accounts = Stream.generate(() -> account)
                .limit(100_000)
                .toList();

        try {
            CompletableFuture<Void> allTasks = system.followMultipleTimes(accounts);
            allTasks.get(100, TimeUnit.SECONDS);
            log.info("Final number of followers: {}", account.getFollowers());
        } catch (Exception e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            system.exShutdown();
        }


    }
}
