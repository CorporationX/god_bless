package school.faang.task_62518;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount twitterAccount = new TwitterAccount("User1");

        int numberFollower = 500;
        CompletableFuture<?>[] task = new CompletableFuture<?>[numberFollower];

        for (int i = 0; i < numberFollower; i++) {
            task[i] = twitterSubscriptionSystem.followAccount(twitterAccount);
        }

        CompletableFuture.allOf(task).join();

        System.out.printf("Total followers: %d%n", twitterAccount.getFollowers());
    }
}
