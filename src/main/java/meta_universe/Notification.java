package meta_universe;

import lombok.Data;

import java.util.Objects;

@Data
public class Notification {
    private static Long countId = 0L;
    private Long id;
    private TypNotification type;
    private String message;

    public Notification(TypNotification type, String message) {
        this.id = ++countId;
        this.type = type;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(id, that.id) && type == that.type && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, message);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "message='" + message + '\'' +
                '}';
    }
}