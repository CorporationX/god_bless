package Synchronization_7;

import java.util.Objects;

public class Chat {

    private User userMale;
    private User userFemale;

    public Chat(User user1, User user2) {
        if ((user1.isSex().equals(Sex.MALE)) && (user2.isSex().equals(Sex.FEMALE))) {
            this.userMale = user1;
            this.userFemale = user2;
        } else if ((user1.isSex().equals(Sex.FEMALE)) && (user2.isSex().equals(Sex.MALE))) {
            this.userMale = user2;
            this.userFemale = user1;
        }
        ChatManager.addChat(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(userMale, chat.userMale) && Objects.equals(userFemale, chat.userFemale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userMale, userFemale);
    }

    public User getUserMale() {
        return userMale;
    }

    public User getUserFemale() {
        return userFemale;
    }
}
