package school.faang.sprint4.bjs_50992;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Twitter {
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        List<TwitterAccount> accounts = accountsInitialize();
        List<CompletableFuture<Void>> futures = futuresInitialize(subscriptionSystem, accounts);

        for (CompletableFuture<Void> future : futures) {
            future.join();
        }

        printFollowers(accounts);
    }

    private static List<CompletableFuture<Void>> futuresInitialize(TwitterSubscriptionSystem system,
                                                                   List<TwitterAccount> accounts) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (TwitterAccount account : accounts) {
            for (int i = 1; i <= 3; i++) {
                futures.add(system.followAccount(account));
            }
        }

        return futures;
    }

    private static List<TwitterAccount> accountsInitialize() {
        List<TwitterAccount> accounts = new ArrayList<>();

        String[] names = {
                "lockdown_20", "prettyX", "efafi", "jur",
                "KentIK", "Poc222", "OK", "3xTop", "SingleP",
                "Nepon", "Ladno", "Uhodi", "Net", "JavaGG"
        };

        for (String name : names) {
            accounts.add(new TwitterAccount(name, RANDOM.nextInt(1000)));
        }

        return accounts;
    }

    private static void printFollowers(List<TwitterAccount> accounts) {
        for (TwitterAccount account : accounts) {
            log.info("Никнейм: {}\nКоличество подписчиков: {}", account.getUsername(), account.getFollowers());
        }
    }
}
