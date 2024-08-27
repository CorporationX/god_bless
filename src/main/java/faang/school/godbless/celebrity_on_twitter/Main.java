package faang.school.godbless.celebrity_on_twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    private static final int FOLLOWERS_COUNT = 10;

    public static void main(String[] args) {
        TwitterAccount varyaAccount = new TwitterAccount("Varya");

        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < FOLLOWERS_COUNT; i++) {
            futures.add(system.followAccount(varyaAccount));
        }

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        completableFuture.join();

        System.out.println("Кол-во подписчиков = " + varyaAccount.getFollowers());
    }
}
