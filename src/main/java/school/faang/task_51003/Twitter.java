package school.faang.task_51003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Twitter {
    public static void main(String[] args) {

        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        List<TwitterAccount> accountList = Arrays.asList(
                new TwitterAccount("Clark Gable", 123_999),
                new TwitterAccount("Carlos Castaneda", 149_999),
                new TwitterAccount("Dooley Wilson", -199),
                new TwitterAccount("Donna Tartt", 3_199)
        );

        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();

        for (TwitterAccount twitterAccount : accountList) {
            completableFutures.add(subscriptionSystem.followAccount(twitterAccount));
        }

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();

        System.out.println(accountList);
    }
}