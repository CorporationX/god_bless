package mod1sp4.bjs2_39140_celebrityTwitter;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Pearacle", 0);
        int amountAccountToSubscribe = 15_000_000;
        twitterSubscriptionSystem.addAllFollowers(amountAccountToSubscribe, account);
        twitterSubscriptionSystem.shuttingDownExecutor();
    }
}
