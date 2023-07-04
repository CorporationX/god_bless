package faang.school.godbless.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
  public static void main(String[] args) {
    final int FOLLOWERS = 2000;

    TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
    TwitterAccount vladTwitterAccount = new TwitterAccount("Vlad Mishustin", 200_000);

    List<CompletableFuture<Void>> futures = new ArrayList<>();

    for (int i = 0; i < FOLLOWERS; i++) {
      futures.add(twitterSubscriptionSystem.followAccount(vladTwitterAccount));
    }

    CompletableFuture<Void> tasks = CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));

    tasks.thenRun(() -> {

    System.out.println("Total subscribers amount: " + vladTwitterAccount.getFollowersCount());
  }).join();
  }
}
