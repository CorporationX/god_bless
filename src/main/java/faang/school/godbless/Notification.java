package faang.school.godbless;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Notification {
    private static final NotificationManager manager = new NotificationManager();

    private String type;
    private String message;
    private boolean isSpam;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
        manager.checkNotificationOnSpam(this);
    }

    public void changeIsSpam(boolean isSpam) {
        this.isSpam = isSpam;
    }
}
