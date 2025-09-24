package school.faang.bjs2_92949;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TwitterAccount accountOne = new TwitterAccount("One", 0);
        TwitterAccount accountTwo = new TwitterAccount("Two", 1);
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        twitterSubscriptionSystem.followAccount(accountOne);
        twitterSubscriptionSystem.followAccount(accountTwo);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
