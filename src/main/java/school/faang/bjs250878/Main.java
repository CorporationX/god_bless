package school.faang.bjs250878;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("user");

        int numberOfFollowers = new Random().nextInt(10000);
        CompletableFuture[] futureFollowers = new CompletableFuture[numberOfFollowers];

        for (int i = 0; i < numberOfFollowers; i++) {
            futureFollowers[i] = subscriptionSystem.followAccount(account);
        }

        CompletableFuture.allOf(futureFollowers).join();

        System.out.println("Final number of followers for account " + account.getUsername()
                + ": " + account.getFollowers());
    }
}