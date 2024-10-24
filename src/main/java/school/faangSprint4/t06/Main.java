package school.faangSprint4.t06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("testUser");
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        List<CompletableFuture<Void>> tasks = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            tasks.add(system.followAccount(account));
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(
                tasks.toArray(new CompletableFuture[0])
        );
        allOf.join();
        System.out.println("Final follower count: " + account.getFollowers());
        System.out.println("Account details: " + account);
    }
}