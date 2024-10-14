package school.faang.bjs2_34768;

import lombok.extern.java.Log;

import static school.faang.bjs2_34768.Notification.TypeOfNotification.EMAIL;
import static school.faang.bjs2_34768.Notification.TypeOfNotification.SMS;

@Log
public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(SMS, (notification -> log.info("Send sms: " + notification.getMessage())));
        notificationManager.registerHandler(EMAIL, (notification -> log.info("Send email: " + notification.getMessage())));

        Notification emailNotification = new Notification(EMAIL, "A user 121314 added a comment to your post: \"a-ha-ha-ha...shit\"");
        Notification smsNotification = new Notification(SMS, "New friend request. Look quickly!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);

        notificationManager.registerFilter(EMAIL, notification -> notification.getMessage().contains("shit"));

        notificationManager.isNotificationContainsCensorship(emailNotification);
    }
}
