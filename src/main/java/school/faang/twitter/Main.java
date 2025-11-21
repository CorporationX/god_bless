package school.faang.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<CompletableFuture<Void>> cfs = new ArrayList<>();
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("My");
        for (int i = 0; i < 10_000; i++) {
            cfs.add(system.followAccount(account));
        }
        CompletableFuture.allOf(cfs.toArray(CompletableFuture[]::new)).thenRun(() -> {
            System.out.println("all of");
        });
        System.out.println(account.getFollowers());
    }
}
