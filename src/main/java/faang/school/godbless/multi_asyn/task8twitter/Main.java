package faang.school.godbless.multi_asyn.task8twitter;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("exampleUser");
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        final int countFutures = 100;
        CompletableFuture<Void>[] futures = new CompletableFuture[countFutures];

        for (int i = 0; i < 100; i++) {
            futures[i] = system.followAccount(account);
        }

        CompletableFuture.allOf(futures).join();

        System.out.println("Total followers: " + account.getFollowers());

        system.endProcess();
    }
}
