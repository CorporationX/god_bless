package school.faang.task416;

import school.faang.task416.twitter.TwitterAccount;
import school.faang.task416.twitter.TwitterSubscriptionSystem;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TwitterAccount mainTwitterAccount = new TwitterAccount("Zubail", 234);
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        for (int i = 0; i <9 ; i++) {
            system.followAccount(mainTwitterAccount);
        }
        while (!system.isAllTaskDone()){
            Thread.sleep(500);
        }
        System.out.println(mainTwitterAccount.getFollowers());
    }
}
