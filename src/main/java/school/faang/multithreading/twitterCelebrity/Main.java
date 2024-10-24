package school.faang.multithreading.twitterCelebrity;

public class Main {
    public static void main(String[] args) {
        TwitterAccount twitterAccount = new TwitterAccount("Sergey", 0);
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        for (int i = 0; i < 10; i++) {
            system.followAccount(twitterAccount);
        }

        System.out.println(twitterAccount.getFollowers());
    }
}
