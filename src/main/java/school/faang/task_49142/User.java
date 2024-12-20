package school.faang.task_49142;

import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;


public class User {
    private final String name;
    private final boolean isOnline;

    private boolean isLookingForChat;

    @Getter
    private Chat chat;

    public User(@NonNull String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
        this.isOnline = true;
        this.isLookingForChat = true;
        this.chat = null;
    }

    public synchronized void setChat(@NonNull Chat chat) {
        this.chat = chat;
        this.isLookingForChat = false;
    }

    public synchronized void resetChat() {
        this.chat = null;
        this.isLookingForChat = true;
    }

    public synchronized boolean isAvailableForChat() {
        return isOnline && isLookingForChat;
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', isLookingForChat=%s}", name, isLookingForChat);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) {
            return false;
        }
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
