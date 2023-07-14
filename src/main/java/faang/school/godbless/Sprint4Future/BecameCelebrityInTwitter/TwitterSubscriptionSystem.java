package faang.school.godbless.Sprint4Future.BecameCelebrityInTwitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Zhugalcf", 100);
        List<CompletableFuture<TwitterAccount>> futureList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            futureList.add(system.followAccount(account));
        }
        CompletableFuture<Void> allOf = CompletableFuture
                .allOf(futureList.toArray(new CompletableFuture[futureList.size()]));

        allOf.thenRun(()-> System.out.println("Subscribers amount: " + account.getFollowers()));
        allOf.join();
    }

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount account) {
        return CompletableFuture.supplyAsync(() -> {
            addFollower(account);
            return account;
        });
    }
}
