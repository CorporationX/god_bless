package school.faang.tinder;

import lombok.Data;

import java.util.Objects;

@Data
public class Chat {
    private final User user1;
    private final User user2;

    public Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        addChatToUser();
    }

    public void removeChatFromUser() {
        user1.setChat(null);
        user2.setChat(null);
        user1.setChatting(false);
        user2.setChatting(false);
    }


    private void addChatToUser() {
        user1.setChat(this);
        user2.setChat(this);
        user1.setChatting(true);
        user2.setChatting(true);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Chat chat = (Chat) o;
        return Objects.equals(user1, chat.user1) && Objects.equals(user2, chat.user2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user1, user2);
    }
}
