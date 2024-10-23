package ru.kraiush.BJS2_38944;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        TwitterAccount account = new TwitterAccount("Tailor Swift");

        for (int i = 0; i < 100_000; ++i) {
            subscriptionSystem.followAccount(account);
        }

        System.out.println(account.getUsername() + " has " + account.getFollowers() + " followers");
    }
}
