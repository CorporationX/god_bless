package school.faang.task_50821;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        TwitterAccount account = new TwitterAccount("JavaCoder");

        List<CompletableFuture<Void>> tasks = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            tasks.add(CompletableFuture.runAsync(() -> system.followAccount(account)));
        }

        CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).join();

        System.out.println("Final number of followers: " + account.getFollowers());
    }
}