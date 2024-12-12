package derschrank.sprint02.task02.bjstwo_46670;

import java.util.List;
import java.util.function.Consumer;

public interface NotificationManagerInterface {
    void sendNotification (Notification not);
    List<Notification> getListOfAwaitNotifications();
    List<Notification> getListOfSentNotifications();
    void start();
    void stop();

    void setTypeAndSenders(NotificationType type, Consumer<Notification> consumer);

}
