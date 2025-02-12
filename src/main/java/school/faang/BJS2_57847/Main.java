package school.faang.BJS2_57847;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        Notification notification1 = new Notification(NotificationType.EMAIL, "Реши задачу Meta-вселенная!");
        Notification notification2 = new Notification(NotificationType.PUSH, "Посмотри лекцию по лямбда-выражениям");
        Notification notification3 = new Notification(NotificationType.SMS, "Вселенная говорит, что пора уволиться");

        manager.registerHandler(NotificationType.EMAIL, (handler) ->
                System.out.printf("Email: %s\n", handler.getMessage()));
        manager.registerHandler(NotificationType.PUSH, (handler) ->
                System.out.printf("Push: %s\n", handler.getMessage()));
        manager.registerHandler(NotificationType.SMS, (handler) ->
                System.out.printf("SMS: %s\n", handler.getMessage()));

        manager.sendNotification(notification1);
        manager.sendNotification(notification2);
        manager.sendNotification(notification3);

        manager.setFilter((notification ->
                notification.getMessage().contains("уволиться")));
        manager.setSpotter((notification ->
                notification.getMessage() + " " + LocalDate.now() + "\n"));

        manager.sendNotification(notification1);
        manager.sendNotification(notification2);
        manager.sendNotification(notification3);
    }
}
