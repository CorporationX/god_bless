package faang.school.godbless.BJS2_5478;

import lombok.Getter;

@Getter
public class Notification {

    private String type;
    private String message;

    public Notification(String type, String message) {
        validateData(type, message);
        this.type = type;
        this.message = message;
    }

    private void validateData(String type, String message) {
        if (type.isBlank() || message.isBlank()) {
            throw new IllegalArgumentException("Invalid data");
        }
    }
}
