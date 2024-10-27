package school.faang.async.twitter;

import java.util.concurrent.CompletableFuture;

public class Twitter {

  public static void main(String[] args) {
    TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
    TwitterAccount account = new TwitterAccount("JavaDeveloper50", 0);
    int subscribersNumber = 100_000_000;

    CompletableFuture[] futureSubscriptions = new CompletableFuture[subscribersNumber];

    for (int i = 0; i < subscribersNumber; i++) {
      futureSubscriptions[i] = system.followAccount(account);
    }

    CompletableFuture<Void> subscribed = CompletableFuture.allOf(futureSubscriptions);

    subscribed.thenRun(() -> System.out.println(account));
  }

}
