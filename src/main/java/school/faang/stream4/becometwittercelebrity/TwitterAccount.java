package school.faang.stream4.becometwittercelebrity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TwitterAccount {
    private final String username;
    private int followers;
    private List<String> subscriptions;

    public TwitterAccount(String username, int followers) {
        this.username = username;
        this.followers = followers;
        subscriptions = new ArrayList<>();
    }

    public synchronized boolean addSubscription(TwitterAccount account) {
        return subscriptions.add(account.getUsername());
    }
}
