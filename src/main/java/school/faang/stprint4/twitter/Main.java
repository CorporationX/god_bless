package school.faang.stprint4.twitter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("Galay", 0);
        TwitterSubscriptionSystem subscriber = new TwitterSubscriptionSystem();
        List<String> followers = List.of("one", "two", "three", "four");

        for (String follower : followers) {
            subscriber.followAccount(account);
        }

        subscriber.getTotalSubscribers(account);
    }
}
