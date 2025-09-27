package school.faang.bjs2_89937;

import java.util.concurrent.atomic.AtomicLong;

public class User {
    private static final AtomicLong ID_GENERATOR = new AtomicLong(1);

    private final long id;
    private final String name;
    private volatile boolean isOnline;
    private volatile boolean isLookingForChat;

    public User(String name) {
        this(name, true, false);
    }

    public User(String name, boolean isOnline, boolean isLookingForChat) {
        this(ID_GENERATOR.getAndIncrement(), name, isOnline, isLookingForChat);
    }

    public User(long id, String name, boolean isOnline, boolean isLookingForChat) {
        this.id = id;
        this.name = name;
        this.isOnline = isOnline;
        this.isLookingForChat = isLookingForChat;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public boolean isLookingForChat() {
        return isLookingForChat;
    }

    public void setOnline(boolean online) {
        this.isOnline = online;
    }

    public void setLookingForChat(boolean lookingForChat) {
        if (isOnline) {
            this.isLookingForChat = lookingForChat;
        }
    }

    public void joinChat() {
        this.isLookingForChat = false;
    }

    public void leaveChat() {
        this.isLookingForChat = true; // Снова ищет чат
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', online=%s, lookingForChat=%s}",
                id, name, isOnline, isLookingForChat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}