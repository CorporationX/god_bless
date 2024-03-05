package faang.school.godbless.facebooknotifications3274;

import lombok.Getter;

@Getter
public class Notification {
    private int id;
    private String message;
    private static int counter;

    public Notification(String message) {
        this.id = ++counter;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("Notification #%d%nMessage: %s",
                this.id, this.message);
    }
}
