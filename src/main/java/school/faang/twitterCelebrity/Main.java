package school.faang.twitterCelebrity;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("user123");

        subscriptionSystem.addAllFollowers(account, 100);

        subscriptionSystem.shutDown();
    }
}
