package faang.school.godbless.sprint2.metaUniverse;

import lombok.Data;

@Data
public class Notification {
    private String type;
    private String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
