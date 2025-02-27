package school.faang.BJS2_62480;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        TwitterAccount alex = new TwitterAccount("Alex");

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futures.add(system.followAccount(alex));
        }

        CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .join();

        System.out.printf("У %s всего %d подписчиков!", alex.getUsername(), alex.getFollowers());
    }
}
