package school.faang.stream4.twittercelebrity;

public class TwitterSubscriptionSystem {

    public static void addFollower(TwitterAccount account) {
        synchronized (account) {
            account.setFollowers(account.getFollowers() + 1);
        }
    }
}
