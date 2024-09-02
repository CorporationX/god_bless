package faang.school.godbless.BJS2_24868;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        TwitterAccount twitterAccount = new TwitterAccount("Ilon Mask", 10);

        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        List<Integer> folowersCounts = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        CompletableFuture<Void> future = CompletableFuture.allOf(folowersCounts.stream()
                .map(integer -> twitterSubscriptionSystem.followAccount(twitterAccount))
                .toArray(CompletableFuture[]::new));
        future.get();
        System.out.println(twitterAccount.getFollowers());
    }
}
