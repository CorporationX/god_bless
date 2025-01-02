package derschrank.sprint04.task06.bjstwo_50791;

import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public record TwitterAccount(
        int id,
        String name,
        Set<TwitterAccount> myFollowers,
        Set<TwitterAccount> ifollow
) {

    public TwitterAccount(String name) {
        this(
                new Random().nextInt(Integer.MAX_VALUE),
                name,
                ConcurrentHashMap.newKeySet(),
                ConcurrentHashMap.newKeySet()
        );
    }

    public void addFollower(TwitterAccount account) {
        if (account != this) {
            myFollowers.add(account);
        }
    }

    public void followAccount(TwitterAccount account) {
        if (account != this) {
            ifollow.add(account);
        }
    }

    public int getCountOfMyFollowers() {
        return myFollowers.size();
    }

    public int getCountOfIfollow() {
        return ifollow.size();
    }

    @Override
    public String toString() {
        return name + " has followers: " + getCountOfMyFollowers() + " and follows: " + getCountOfIfollow();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TwitterAccount account = (TwitterAccount) o;
        return id == account.id && Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
