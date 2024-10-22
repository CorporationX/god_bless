package school.faang.becomingcelebrityontwitter;

import java.util.concurrent.TimeUnit;

public class TwitterApp {
    public static void main(String[] args) throws InterruptedException {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        TwitterAccount account = new TwitterAccount("CoolDev", 0);

        subscriptionSystem.followMultipleTimes(account, 10);

        TimeUnit.SECONDS.sleep(3);
    }
}