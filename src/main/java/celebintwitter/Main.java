package celebintwitter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TwitterAccount celebrityAccount = new TwitterAccount("TheRealCelebrity", 100);
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        int numberOfNewFollowers = 1000;

        List<CompletableFuture<Void>> futures = IntStream.range(0, numberOfNewFollowers)
                .mapToObj(i -> CompletableFuture.runAsync(() ->
                        system.followAccount(celebrityAccount)))
                .toList();

        CompletableFuture<Void> allFeaturesCompleted =
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allFeaturesCompleted.get();

        System.out.println("Итоговое количество подписчиков у @" + celebrityAccount.getUsername() + ": "
                + celebrityAccount.getFollowers());
    }
}
