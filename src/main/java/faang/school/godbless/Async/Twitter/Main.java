package faang.school.godbless.Async.Twitter;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws Exception {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        TwitterAccount account1 = new TwitterAccount("Alex", 17);
        TwitterAccount account2 = new TwitterAccount("Josh", 190);
        TwitterAccount account3 = new TwitterAccount("Semjon", 12_000_456);
        TwitterAccount account4 = new TwitterAccount("Pasha", 1667);
        TwitterAccount account5 = new TwitterAccount("Masha", 0);

        CompletableFuture<Integer> future1 = system.followAccount(account1);
        CompletableFuture<Integer> future2 = system.followAccount(account2);
        CompletableFuture<Integer> future3 = system.followAccount(account3);
        CompletableFuture<Integer> future4 = system.followAccount(account4);
        CompletableFuture<Integer> future5 = system.followAccount(account5);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3, future4, future5);
        CompletableFuture<List<TwitterAccount>> allFuturesList = allFutures.thenApply(v -> List.of(account1, account2, account3, account4, account5));

        List<TwitterAccount> accounts = allFuturesList.get();

        accounts.forEach(account ->
                System.out.println("Account: " + account.getUsername() + " have " + account.getFollowers() + " followers"));

    }
}
