package school.faang.sprint1.task_46827;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler("email", (notification) ->
                System.out.println("Отправка по почте " + notification.getMessage())
        );
        manager.registerHandler("sms", (notification) ->
                System.out.println("Отправка SMS " + notification.getMessage())
        );
        manager.registerHandler("push", (notification) ->
                System.out.println("Отправка Push уведомления " + notification.getMessage()));

        manager.addFilter(notification -> !notification.getMessage().toLowerCase().contains("spam"));

        Notification notificationEmail = new Notification("email", "Hello from email)");
        Notification notificationSms = new Notification("sms", "Hello from SMS");
        Notification notificationPush = new Notification("push", "Hello from push");
        Notification notificationSpam = new Notification("sms", "Я есть, SPAM");

        manager.sendNotification(notificationEmail);
        manager.sendNotification(notificationSms);
        manager.sendNotification(notificationPush);
        manager.sendNotification(notificationSpam);


    }
}