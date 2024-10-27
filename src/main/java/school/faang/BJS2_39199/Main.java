package school.faang.BJS2_39199;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Username1", 0);
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        subscriptionSystem.processSubscriptions(account, 10);
    }
}
