package school.faang.sprint_4.bjs2_38983_twitterCelebrity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSystem = new TwitterSubscriptionSystem();
        List<String> usersToCreate = List.of(
                "Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Uma", "Heidi", "Ivan", "Judy",
                "Mallory", "Uma", "Olivia", "Charlie", "Quentin", "Rupert", "Sybil", "Trent", "Uma", "Victor"
        );

        CompletableFuture.allOf(twitterSystem.createUsers(usersToCreate).toArray(new CompletableFuture[0]))
                .thenRun(() ->
                        CompletableFuture.allOf(twitterSystem.subscribeEveryoneOnEveryone()
                                .toArray(new CompletableFuture[0])).join()).join();

        twitterSystem.shutdown();
        twitterSystem.printAllUsers();
    }
}
