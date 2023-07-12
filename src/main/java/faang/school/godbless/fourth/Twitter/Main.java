package faang.school.godbless.fourth.Twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int SUBSCRIBER_AMOUNT = 228;

    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Prince");
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        for (int i = 0; i < SUBSCRIBER_AMOUNT; i++) {
            futures.add(system.followAccount(account));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenAccept(v -> System.out.println("Account " + account.getUsername() + " has " +
                        account.getFollowers() + " followers"))
                .join();
    }
}
