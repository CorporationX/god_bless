package school.BJS2_38887;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {

        TwitterSubscriptionSystem ts = new TwitterSubscriptionSystem();

        TwitterAccount account = new TwitterAccount("Рома", 10);

        CompletableFuture<Void> future1 = ts.followAccount(account);
        CompletableFuture<Void> future2 = ts.followAccount(account);
        CompletableFuture<Void> future3 = ts.followAccount(account);
        CompletableFuture<Void> future4 = ts.followAccount(account);

        CompletableFuture[] futures = new CompletableFuture[]{future1, future2, future3, future4};

        CompletableFuture.allOf(futures)
                .thenRun(() -> System.out.println("Общее количество подписчиков стало: " + account.getFollowers()))
                .join();
    }
}
