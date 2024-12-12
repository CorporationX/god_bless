package school.faang.sprint_2.task_46688;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        try {
            notificationManager.registerHandler("email",
                    notification -> System.out.printf("Send by email: %s\n", notification.message()));

            notificationManager.registerHandler("sms",
                    notification -> System.out.printf("Sending SMS: %s\n", notification.message()));

            notificationManager.registerHandler("push",
                    notification -> System.out.printf("Sending a push notification: %s\n", notification.message()));

            Notification emailNotification = new Notification("email",
                    "Your account has been successfully activated");
            Notification smsNotification = new Notification("sms",
                    "You have successfully changed your password");
            Notification pushNotification = new Notification("push",
                    "New post from user: JohnDoe");

            notificationManager.sendNotification(emailNotification);
            notificationManager.sendNotification(smsNotification);
            notificationManager.sendNotification(pushNotification);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}