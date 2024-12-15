package school.faang.task_46867;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms",
                (notification -> System.out.println("Отправка SMS: " + notification.getMessage())));
        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        notificationManager.registerFilter("push",
                (notification) -> notification.getMessage().contains("TEST"));
        notificationManager.registerFilter("sms",
                (notification) -> notification.getMessage().contains("SMS"));

        notificationManager.registerFunction("sms",
                (notification) -> notification.getMessage().replaceAll("SMS", "смс"));

        Notification email = new Notification("email", "Hello from Email");
        Notification sms = new Notification("sms", "Hello from SMS");
        Notification push = new Notification("push", "PUSH TEST TEST");

        notificationManager.sendNotification(email);
        notificationManager.sendNotification(sms);
        notificationManager.sendNotification(push);
    }
}
