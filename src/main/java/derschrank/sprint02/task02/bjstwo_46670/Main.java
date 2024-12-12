package derschrank.sprint02.task02.bjstwo_46670;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<NotificationType> types = new ArrayList<>();
        types.add(NotificationType.PUSH);
        types.add(NotificationType.EMAIL);
        types.add(NotificationType.SMS);

        NotificationManagerInterface notificationManager = new NotificationManager();


        for (NotificationType notificationType : types) {
            notificationManager.setTypeAndSenders(notificationType, notificationType.getSender());
        }


        final String greetingMessage = "Starting notifications";
        System.out.println(greetingMessage);
        for (NotificationType notificationType : types) {
            Notification notification = new Notification(notificationType, greetingMessage);

            notificationManager.sendNotification(notification);
        }
        notificationManager.start();



        for (int i = 0; i < 100; i++) {
            Notification notification = new Notification(types.get(i % types.size()), "Message ABIRVALG " + i);
            notificationManager.sendNotification(notification);
            Thread.sleep(100);
        }



        final String byeingMessage = "Sopping notifications";
        System.out.println(byeingMessage);
        for (NotificationType notificationType : types) {
            Notification notification = new Notification(notificationType, byeingMessage);

            notificationManager.sendNotification(notification);
        }
        notificationManager.stop();
    }
}
