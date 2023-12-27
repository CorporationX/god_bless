package faang.school.godbless.multi_asyn.task8twitter;

public class TwitterAccount {
    private String username;
    private int followers = 0;

    public synchronized String getUsername() {
        return username;
    }

    public synchronized int getFollowers() {
        return followers;
    }

    public synchronized void setUsername(String username) {
        this.username = username;
    }

    public synchronized void setFollowers(int followers) {
        this.followers = followers;
    }

    public TwitterAccount(String username) {
        this.username = username;
    }
}
