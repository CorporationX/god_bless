package school.faang.twittercelebrity;

public class Main {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("User-1", 0);
        TwitterSystem.followMany(account, 20)
                        .thenRun(() -> System.out.printf("Account %s has %d followers\n",
                                account.getUserName(), account.getFollowers().get()))
                .join();
        TwitterSystem.close();
    }
}
