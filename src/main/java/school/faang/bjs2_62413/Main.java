package school.faang.bjs2_62413;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("John Connor", new AtomicInteger(0));

        system.followMultipleAccounts(account, 7).join();
    }
}
