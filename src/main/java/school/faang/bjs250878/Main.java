package school.faang.bjs250878;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        for (int i = 1; i <= new Random().nextInt(100); i++) {
            TwitterAccount account = new TwitterAccount("user " + i);
            subscriptionSystem.multipleFollowers(account, new Random().nextInt(10000));
        }
    }
}