package become_selebrity_in_twitter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        TwitterAccount sharedAccount = new TwitterAccount("Pewdiepie");

        List<CompletableFuture<Void>> followTasks = IntStream.range(0, 10)
                .mapToObj(i -> subscriptionSystem.followAccount(sharedAccount))
                .collect(Collectors.toList());

        CompletableFuture<Void> allFollows = CompletableFuture.allOf(
                followTasks.toArray(new CompletableFuture[0])
        );

        allFollows.thenRun(() -> {
            System.out.println("Total followers for " + sharedAccount.getUsername() +
                    ": " + sharedAccount.getFollowers());
        }).join();
    }
}
