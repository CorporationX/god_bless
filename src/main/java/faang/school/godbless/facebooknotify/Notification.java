package faang.school.godbless.facebooknotify;

import lombok.Data;

@Data
public class Notification {

    private long id;
    private String message;
    private static long counter;

    public Notification(String message) {
        this.id = counter++;
        this.message = message;
    }
}
