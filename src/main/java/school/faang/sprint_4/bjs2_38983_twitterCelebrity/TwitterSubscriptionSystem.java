package school.faang.sprint_4.bjs2_38983_twitterCelebrity;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint_4.bjs2_38983_twitterCelebrity.account_manager.AccountManager;
import school.faang.sprint_4.bjs2_38983_twitterCelebrity.account_manager.TwitterAccount;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TwitterSubscriptionSystem {
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final AccountManager manager = new AccountManager();

    public List<CompletableFuture<Void>> createUsers(List<String> usersToCreate) {
        return usersToCreate.stream()
                .map(user -> CompletableFuture.runAsync(() -> manager.createTwitterAccount(user), executor))
                .toList();
    }

    private List<CompletableFuture<Void>> subscribeToSet(TwitterAccount follower, Set<TwitterAccount> targets) {
        return targets.stream()
                .filter(target -> !follower.equals(target))
                .map(target -> CompletableFuture.runAsync(() -> manager.follow(follower, target), executor))
                .toList();
    }

    public List<CompletableFuture<Void>> subscribeEveryoneOnEveryone() {
        Set<TwitterAccount> allAccounts = manager.getAllAccounts();

        return allAccounts.stream()
                .map(follower -> CompletableFuture.runAsync(() ->
                        CompletableFuture.allOf(subscribeToSet(follower, allAccounts).
                                toArray(new CompletableFuture[0])), executor))
                .toList();
    }

    public void printAllUsers() {
        manager.getAllAccounts().forEach(account -> {
            String username = manager.getAccountUsername(account);
            long followersCount = manager.getFollowersCount(account);
            log.info("User '{}' has {} followers.", username, followersCount);
        });
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                log.info("Something went wrong! Shutting down immediately!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("An error occurred while thread shutting down now.", e);
            throw new IllegalStateException(e);
        }
    }
}
