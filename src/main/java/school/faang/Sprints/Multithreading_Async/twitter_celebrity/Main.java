package school.faang.Sprints.Multithreading_Async.twitter_celebrity;

import static school.faang.Sprints.Multithreading_Async.twitter_celebrity.TwitterSubscriptionSystem.followAccount;

public class Main {
    public static void main(String[] args) {
        TwitterAccount twitterAccount = new TwitterAccount("Smurno");
        followAccount(twitterAccount);
    }

}