package faang.school.godbless.thematters;

import lombok.Data;

import java.util.Objects;

@Data
public class User {

    private String name;
    private boolean isWantsToChat;
    private boolean isOnline;
    private Chat chat;

    public User(String name, boolean isOnline, boolean isWantsToChat) {
        this.name = name;
        this.isOnline = isOnline;
        this.isWantsToChat = isWantsToChat;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public boolean isWantsToChat() {
        return isWantsToChat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isWantsToChat == user.isWantsToChat && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isWantsToChat);
    }

    @Override
    public String toString() {
        return "User{" +
               "name='" + name + '\'' +
               ", isWantsToChat=" + isWantsToChat +
               '}';
    }
}
