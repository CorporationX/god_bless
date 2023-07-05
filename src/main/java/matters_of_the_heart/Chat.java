package matters_of_the_heart;

import java.util.Objects;

public class Chat {
    private final User user1;
    private final User user2;

    public Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return (Objects.equals(user1, chat.user1) && Objects.equals(user2, chat.user2)) || (Objects.equals(user2, chat.user1) && Objects.equals(user1, chat.user2));
    }

    @Override
    public int hashCode() {
        return Objects.hash(user1, user2);
    }
}
