package school.faang.celebrityTwitter;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<TwitterAccount> users = List.of(new TwitterAccount("Богдан", 0),
                new TwitterAccount("Александр", 3),
                new TwitterAccount("Дмитрий", 100),
                new TwitterAccount("Артём", 5),
                new TwitterAccount("Денис", 20));
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        users.stream().filter(n -> !n.equals(users.get(0)))
                .forEach((n) -> twitterSubscriptionSystem.followAccount(users.get(0)).join());
        twitterSubscriptionSystem.getExecutor().shutdown();
        twitterSubscriptionSystem.getExecutor().awaitTermination(30, TimeUnit.SECONDS);
        System.out.println(users.get(0).getFollowers());
    }
}
