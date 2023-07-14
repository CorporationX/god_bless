package faang.school.godbless.sprint5.Multithreading_Async.task11_twitter;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        TwitterAccount twitterAccount = new TwitterAccount("Ilon Mask", 1_000_000);
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        CompletableFuture<Void>[] arrayCompletableFuture = new CompletableFuture[10];
        for (int i = 0; i < 10; i++) {
            arrayCompletableFuture[i] = twitterSubscriptionSystem.followAccount(twitterAccount);
        }

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(arrayCompletableFuture);

        voidCompletableFuture.join();

        System.out.println(twitterAccount.getFollowers());
    }
}
