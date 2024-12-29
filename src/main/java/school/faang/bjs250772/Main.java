package school.faang.bjs250772;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        TwitterAccount account = new TwitterAccount("Moriarti");
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> tasks = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            tasks.add(system.followAccount(account));
        }

        CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).join();

        System.out.println("Total number of followers: " + account.getFollowerCount());
        long end = System.currentTimeMillis();
        System.out.println("time elapsed: " + (end - start));
    }

}
