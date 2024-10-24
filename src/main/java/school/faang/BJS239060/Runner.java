package school.faang.BJS239060;

public class Runner {
    public static void main(String[] args) {
        TwitterAccount twitterAccount = new TwitterAccount("Doniyor", 300);
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        twitterSubscriptionSystem.addFollower(twitterAccount);
        twitterSubscriptionSystem.followAccount(twitterAccount);
        twitterSubscriptionSystem.shutDown();
    }
}
