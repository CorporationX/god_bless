package faang.school.godbless.notifications_on_facebook;


import lombok.Getter;

@Getter
public class Notification {
    private final int id;
    private final String message;

    public Notification(int id, String message) {
        this.id = id;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}