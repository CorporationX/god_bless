package faang.school.godbless.FacebookNotifications;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class NotificationManager {
    private List<Notification> notificationList = new ArrayList<>();

    public synchronized void addNotification(Notification notification) {
        notificationList.add(notification);
    }

}
