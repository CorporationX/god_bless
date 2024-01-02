package faang.school.godbless.BJS2_1286;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.stream.Stream;

public class UserPair extends AbstractMap.SimpleEntry<User, User> {

    public UserPair(User user1, User user2) {
        super(createSortedEntry(user1, user2));
    }

    private static AbstractMap.SimpleEntry<User, User> createSortedEntry(User user1, User user2) {
        User[] sortedUsers = Stream.of(user1, user2)
                .sorted(Comparator.comparing(User::getName))
                .toArray(User[]::new);

        return new AbstractMap.SimpleEntry<>(sortedUsers[0], sortedUsers[1]);
    }

    public User getUser1() {
        return getKey();
    }

    public User getUser2() {
        return getValue();
    }

    public boolean containsAny(User user) {
        return user.equals(getUser1()) || user.equals(getUser2());
    }

    public User getAnotherByUser(User user) {
        if (getUser1().equals(user)) {
            return getUser2();
        }
        if (getUser2().equals(user)) {
            return getUser1();
        }

        return null;
    }
}