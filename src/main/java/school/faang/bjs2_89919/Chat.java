package school.faang.bjs2_89919;

import java.util.Objects;

public record Chat(User user1, User user2) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chat)) return false;
        Chat chat = (Chat) o;
        return (Objects.equals(user1, chat.user1) && Objects.equals(user2, chat.user2))
                || (Objects.equals(user1, chat.user2) && Objects.equals(user2, chat.user1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(user1) + Objects.hash(user2);
    }
}
