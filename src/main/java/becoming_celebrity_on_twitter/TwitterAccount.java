package becoming_celebrity_on_twitter;

public class TwitterAccount {
    private String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.followers = 0;
    }

    public String getUsername() {
        return username;
    }

    public int getFollowers() {
        return followers;
    }

    public synchronized void addFollower() {
        followers++;
    }
}
