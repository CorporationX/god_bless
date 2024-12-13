package school.faang.sprint1.task_46827;

import lombok.Getter;

@Getter
public class Notification {
    private String type;
    private String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notification{"
                + "type='"
                + type
                + '\''
                + ", massage='"
                + message
                + '\''
                + '}';
    }
}