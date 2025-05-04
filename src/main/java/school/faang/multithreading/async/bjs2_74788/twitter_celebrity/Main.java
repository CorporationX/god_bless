package school.faang.multithreading.async.bjs2_74788.twitter_celebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int FOLLOWERS_AMOUNT = 10;

    public static void main(String[] args) {
        TwitterAccount celebrityAccount = new TwitterAccount("Celebrity");
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        List<TwitterAccount> followers = generateTwitterAccounts();

        List<CompletableFuture<Void>> futures = followers.stream()
                .map(account -> system.followAccount(celebrityAccount))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .join();
        system.shutdown();
        log.info("Total followers of {}: {}", celebrityAccount.getUsername(), celebrityAccount.getFollowers());
    }

    public static List<TwitterAccount> generateTwitterAccounts() {
        List<TwitterAccount> twitterAccounts = new ArrayList<>();
        IntStream.rangeClosed(1, FOLLOWERS_AMOUNT)
                .forEach(i ->
                    twitterAccounts.add(new TwitterAccount(String.format("Username #%d", i))));
        return twitterAccounts;
    }
}
