package school.faang.sprint4.task_43580;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Mikle");

        CompletableFuture[] followAccountInProcess = Stream.generate(() -> subscriptionSystem.followAccount(account))
                .limit(5)
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(followAccountInProcess)
                .thenRun(() -> System.out.printf("Number of followers: %d", account.getNumOfFollowers()))
                .join();
    }
}
