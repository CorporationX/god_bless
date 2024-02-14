package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class NotificationManager {
    public String getNotificationId() {
        return notificationId;
    }

    private String notificationId;
    private String message;

    private Map<String, Consumer<Notification>>notificationHandlers=new HashMap<>();
    @FunctionalInterface
    public interface Consumer<Notification> {
        void accept(Notification param);
    }

    public void registerHandler(String notificationId, Consumer<Notification> handler){
        notificationHandlers.put(notificationId, handler);
    }
    public void setNotification(Notification notification){
        String notificationId=notification


    }

}
