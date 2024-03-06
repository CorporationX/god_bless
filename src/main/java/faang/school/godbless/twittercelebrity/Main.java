package faang.school.godbless.twittercelebrity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final TwitterSubscriptionSystem SUBSCRIPTION_SYSTEM = new TwitterSubscriptionSystem();
    public static void main(String[] args) {
        TwitterAccount account1 = new TwitterAccount("Elon Musk", 666666);
        System.out.printf("%s followers = %d", account1.getUsername(), account1.getFollowers());
        System.out.println();

        int followersToSubscribe = 1000001;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < followersToSubscribe; i++) {
            futureList.add(SUBSCRIPTION_SYSTEM.followAccount(account1));
        }
        CompletableFuture.allOf(futureList.toArray(CompletableFuture[]::new)).join();
        SUBSCRIPTION_SYSTEM.shutDownAndAwait(555);
        System.out.printf("%s followers = %d", account1.getUsername(), account1.getFollowers());
        System.out.println();
    }
}
