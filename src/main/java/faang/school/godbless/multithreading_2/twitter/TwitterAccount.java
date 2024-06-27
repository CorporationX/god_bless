package faang.school.godbless.multithreading_2.twitter;

public class TwitterAccount {
    private final String username;
    private volatile int followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = 0;
    }

    public synchronized void increaseFollowers(int followersAmount) {
        this.followers += followersAmount;
    }

    public synchronized void showFollowers() {
        System.out.println("Количество подписчиков равно: " + followers);
    }
}
