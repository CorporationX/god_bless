package school.faang.twittercelebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterAddingFollowersApplication {

    public static void main(String[] args) {

        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        List<TwitterAccount> accounts = List.of(new TwitterAccount("@tolik", 1000),
                new TwitterAccount("@bolik", 500),
                new TwitterAccount("@pupa", 100));

        List<CompletableFuture<Void>> accountsFuture = accounts.stream()
                .map(subscriptionSystem::followAccount)
                .toList();
        CompletableFuture<Void> allAccountsFuture = CompletableFuture
                .allOf(accountsFuture.toArray(new CompletableFuture[0]));
        allAccountsFuture.thenRun(() -> log.info("Информация о подписчиках обновлена!"));
        allAccountsFuture.join();
    }
}
