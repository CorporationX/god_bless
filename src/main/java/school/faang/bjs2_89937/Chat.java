package school.faang.bjs2_89937;

import java.util.Objects;

public record Chat(User user1, User user2) {

    public boolean isParticipant(User user) {
        return user1.equals(user) || user2.equals(user);
    }

    public User getPartner(User user) {
        if (user1.equals(user)) {
            return user2;
        }
        if (user2.equals(user)) {
            return user1;
        }
        return null;
    }
}
