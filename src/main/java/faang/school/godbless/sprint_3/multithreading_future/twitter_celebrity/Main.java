package faang.school.godbless.sprint_3.multithreading_future.twitter_celebrity;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount firstAccount = new TwitterAccount("Yevhenii");
        CompletableFuture<Void> firstFuture = subscriptionSystem.followAccount(firstAccount);
        CompletableFuture<Void> secondFuture = subscriptionSystem.followAccount(firstAccount);
        CompletableFuture<Void> thirdFuture = subscriptionSystem.followAccount(firstAccount);
        CompletableFuture.allOf(firstFuture, secondFuture, thirdFuture)
                .thenRun(() -> System.out.println(firstAccount.getFollowers().get()))
                .join();
    }
}