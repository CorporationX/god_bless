package faang.school.godbless.multithreading_2.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Аккаунт");
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            futures.add(CompletableFuture.runAsync(() -> system.addFollower(account)));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        account.showFollowers();
    }
}
