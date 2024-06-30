package faang.school.godbless.multithreading_async.task_8;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int MAX_ADDING_DURATION = 5000;

    public void addFollower(TwitterAccount twitterAccount) {
        try {
            Thread.sleep(MAX_ADDING_DURATION);
            synchronized (twitterAccount) {
                twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
            }
        } catch (InterruptedException e) {
            log.error("Adding follower to Twitter account {} was interrupted", twitterAccount.getUsername(), e);
        }
    }
}
