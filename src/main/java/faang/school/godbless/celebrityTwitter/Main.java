package faang.school.godbless.celebrityTwitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Celebrity", 0);
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        List<CompletableFuture<Void>> allFutures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            allFutures.add(system.followAccount(account));
        }
        CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0])).join();
        System.out.println("Общее число подписчиков - " + account.getFollowers());
    }
}
