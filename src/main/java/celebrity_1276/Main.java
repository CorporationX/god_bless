package celebrity_1276;

import java.util.concurrent.CompletableFuture;

public class Main {

    private static final int COUNT_FOLLOWERS_ADD = 30;

    public static void main(String[] args) {

        TwitterAccount account = new TwitterAccount("Ilon_Mask", 1000);
        TwitterSubscriptionSystem systemTwitter = new TwitterSubscriptionSystem();
        CompletableFuture[] futures1 = new CompletableFuture[COUNT_FOLLOWERS_ADD];

        for (int i = 0; i < COUNT_FOLLOWERS_ADD; i++) {
            futures1[i] = systemTwitter.followAccount(account);
        }
        CompletableFuture.allOf(futures1).join();
        System.out.printf("Count Followers of %s - %s \n", account.getUsername(), account.getFollowers());
    }
}