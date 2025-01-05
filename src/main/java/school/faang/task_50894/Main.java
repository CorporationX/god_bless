package school.faang.task_50894;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscription = new TwitterSubscriptionSystem();
        TwitterAccount twitterAccountMain = new TwitterAccount("Максим", 0);
        TwitterAccount twitterAccount1 = new TwitterAccount("Человек1", 1);
        TwitterAccount twitterAccount2 = new TwitterAccount("Человек2", 2);
        TwitterAccount twitterAccount3 = new TwitterAccount("Человек3", 3);

        CompletableFuture<Void> twitterAccountFuture1 = twitterSubscription.followAccount(twitterAccountMain,
                twitterAccount1);
        CompletableFuture<Void> twitterAccountFuture2 = twitterSubscription.followAccount(twitterAccountMain,
                twitterAccount2);
        CompletableFuture<Void> twitterAccountFuture3 = twitterSubscription.followAccount(twitterAccountMain,
                twitterAccount3);

        CompletableFuture<Void> allTwitterSubscription = CompletableFuture.allOf(twitterAccountFuture1,
                twitterAccountFuture2, twitterAccountFuture3);
        allTwitterSubscription.join();

        System.out.println("Подписчиков: " + twitterAccountMain.getFollowers());
    }
}
