package school.faang.bjs2_82617_twitter_celeb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem twitter = new TwitterSubscriptionSystem();
        TwitterAccount celeb = new TwitterAccount("Famo Starro");
        List<CompletableFuture<Void>> promises = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            promises.add(twitter.followAccount(celeb));
        }

        CompletableFuture.allOf(promises.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.printf("Famo subscribers: %s \n", celeb.getFollowers()))
                .join();

        twitter.shutDown();
    }
}
