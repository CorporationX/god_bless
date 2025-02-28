package school.faang.task_62443;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("example_user");
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        List<CompletableFuture<Void>> futures = List.of(
                system.followAccount(account),
                system.followAccount(account),
                system.followAccount(account),
                system.followAccount(account)
        );

        startProcess(futures, account);
    }

    public static void startProcess(List<CompletableFuture<Void>> futures, TwitterAccount account) {
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join();
        log.info("Account {} has {} followers", account.getUsername(), account.getFollowers());
    }
}
