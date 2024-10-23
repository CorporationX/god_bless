package school.faang.m1s4.bjs2_38879_twitter;

public class Main {
    public static void main(String[] args) {
        TwitterAccount newCelebrity = new TwitterAccount("Freddy Krueger");
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        twitterSubscriptionSystem.addManyFollowers(100, newCelebrity);

    }
}
