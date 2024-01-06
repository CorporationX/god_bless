package faang.school.godbless.CelebrityOnTwitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TwitterMain {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount twitterAccount = new TwitterAccount("MegaMozg", 10);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        System.out.println("Было подписчиков: " + twitterAccount.getFollowers());

        for (int i = 0; i < 190; i++) {
            CompletableFuture<Void> future = system.followAccount(twitterAccount);
            futures.add(future);
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Стало подписчиков: " + twitterAccount.getFollowers());
    }
}
