package faang.school.godbless.BecomingACelebrityOnTwitter;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TwitterAccount popularAccount = new TwitterAccount("Ilon Mask");
        getTwitterAccounts().forEach(twitterAccount -> twitterAccount.followAccount(popularAccount));
        TwitterSubscriptionSystem.waitGettingAllNewFollowers();
        log.info(popularAccount.getUsername() + " has " + popularAccount.getFollowers() + " followers");
        TwitterSubscriptionSystem.shutdownTwitterSubscriptionSystem();
    }

    public static List<TwitterAccount> getTwitterAccounts() {
        return List.of(
                new TwitterAccount("1"),
                new TwitterAccount("2"),
                new TwitterAccount("3"),
                new TwitterAccount("4"),
                new TwitterAccount("5"),
                new TwitterAccount("6"),
                new TwitterAccount("7"),
                new TwitterAccount("8"),
                new TwitterAccount("9"),
                new TwitterAccount("10"),
                new TwitterAccount("11"),
                new TwitterAccount("12"),
                new TwitterAccount("13")
        );
    }
}
