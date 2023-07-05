package faang.school.godbless.twitter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
  private void addFollower(TwitterAccount twitterAccount) {
    synchronized (twitterAccount) {
      twitterAccount.setFollowersCount(twitterAccount.getFollowersCount() + 1);
    }
  }

  public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
    ExecutorService executor = Executors.newFixedThreadPool(10);
    return CompletableFuture.runAsync(() -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      addFollower(twitterAccount);
      executor.shutdown();
    }, executor);
  }
}
