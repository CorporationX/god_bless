package school.faang.task_46660;

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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Notification{")
                .append("type='").append(type).append('\'')
                .append(", message='").append(message).append('\'')
                .append('}');
        return stringBuilder.toString();
    }
}
