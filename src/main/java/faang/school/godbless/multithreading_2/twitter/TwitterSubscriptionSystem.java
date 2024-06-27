package faang.school.godbless.multithreading_2.twitter;

public class TwitterSubscriptionSystem {

    public void addFollower(TwitterAccount twitterAccount) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        twitterAccount.increaseFollowers(1);
    }
}
