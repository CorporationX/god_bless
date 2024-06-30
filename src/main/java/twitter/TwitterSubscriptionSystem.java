package twitter;


import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    private final Object lock = new Object();

    public void addFollower(TwitterAccount twitterAccount) {
        synchronized (lock) {
            twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
        }
    }
    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount){
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount));
    }

    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount twitterAccount = new TwitterAccount("acc1",0);
        CompletableFuture<Void> completableFuture1= twitterSubscriptionSystem.followAccount(twitterAccount);
        CompletableFuture<Void> completableFuture2= twitterSubscriptionSystem.followAccount(twitterAccount);
        CompletableFuture<Void> completableFuture3= twitterSubscriptionSystem.followAccount(twitterAccount);
        CompletableFuture<Void> completableFuture4= twitterSubscriptionSystem.followAccount(twitterAccount);
        CompletableFuture<Void> completableFuture5= twitterSubscriptionSystem.followAccount(twitterAccount);
        CompletableFuture<Void> completableFuture6= twitterSubscriptionSystem.followAccount(twitterAccount);
        CompletableFuture.allOf(completableFuture1, completableFuture2,completableFuture3,completableFuture4
                ,completableFuture5,completableFuture6).join();
        System.out.println(twitterAccount.getFollowers());
    }
}
