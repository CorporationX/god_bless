package faang.school.godbless.CelebrityInTwitter;

import java.util.ArrayList;
import java.util.List;

public class TwitterSubscriptionSystem {
    List<TwitterAccount> twitterAccounts = new ArrayList<>();

    public void addFollower(TwitterAccount twitterAccount){
        synchronized (twitterAccount){
            twitterAccount.getFollowers().addAndGet(1);
        }

    }
}
