package school.faang.sprint_4.task_50687;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        List<TwitterAccount> twitterAccounts = Arrays.asList(
                new TwitterAccount("Bob1", 0),
                new TwitterAccount("Bob2", 0),
                new TwitterAccount("Bob3", 0),
                new TwitterAccount("Bob4", 0)
        );
        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
        for (TwitterAccount twitterAccount : twitterAccounts) {
            completableFutures.add(twitterSubscriptionSystem.followAccount(twitterAccount));
        }
        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();
        System.out.println(twitterAccounts);
    }
}
