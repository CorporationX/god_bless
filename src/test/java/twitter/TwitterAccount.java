package twitter;

public class TwitterAccount {
    private String userName;
    private int followers;

    public TwitterAccount(String userName, int followers) {
        this.userName = userName;
        this.followers = followers;
    }

    public String getUserName() {
        return userName;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }
}
