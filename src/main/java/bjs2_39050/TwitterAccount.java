package bjs2_39050;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Data
public class TwitterAccount {
    private String name;
    private Set<String> followers;

    public TwitterAccount(String name) {
        this.name = name;
        this.followers = new HashSet<>();
    }

    public synchronized void addFollower(TwitterAccount account) {
        try {
            TimeUnit.MILLISECONDS.sleep(followers.size() * 100L);
            followers.add(account.getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
