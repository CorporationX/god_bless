package bjs2_37883;

public class Main {

    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount celebrityAccount = new TwitterAccount("John Cena", 500_000);

        twitterSubscriptionSystem.followAccountAll(celebrityAccount, 50_000);
        System.out.println(celebrityAccount.getFollowers());
    }
}
