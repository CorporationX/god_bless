package becoming_celebrity_on_twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount elonMusk = new TwitterAccount("Elon Musk");
        System.out.println("Подписчиков до: " + elonMusk.getFollowers()); // 0
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            futures.add(system.followAccount(elonMusk));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Подписчиков после: " + elonMusk.getFollowers()); // 100
    }
}
