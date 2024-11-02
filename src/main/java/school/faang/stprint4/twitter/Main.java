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

        System.out.println("Main thread in not blocked and continue...");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Interruption");;
        }
        System.out.println("Main thread is finished what ever work imitated by sleep");
    }
}
