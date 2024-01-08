package faang.school.godbless.BJS2_1286;

import java.util.AbstractMap;

public class UserPair extends AbstractMap.SimpleEntry<User, User> {

    public UserPair(User key, User value) {
        super(key, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        UserPair eqUserPair = (UserPair) obj;
        return getUser1().equals(eqUserPair.getUser1()) && getUser2().equals(eqUserPair.getUser2())
                || getUser1().equals(eqUserPair.getUser2()) && getUser2().equals(eqUserPair.getUser1());
    }

    public User getUser1() {
        return getKey();
    }

    public User getUser2() {
        return getValue();
    }

    public boolean contains(User user) {
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