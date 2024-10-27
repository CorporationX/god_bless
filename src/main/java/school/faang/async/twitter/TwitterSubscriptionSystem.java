package school.faang.async.twitter;

public class TwitterSubscriptionSystem {

  private final Object lock = new Object();

  public void addFollower(TwitterAccount account) {

    synchronized (lock) {

    }

  }

  public void followAccount(TwitterAccount account) {
    synchronized (lock) {

    }
  }

}
