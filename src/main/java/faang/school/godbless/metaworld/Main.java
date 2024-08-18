package faang.school.godbless.metaworld;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();


// Регистрация обработчиков оповещений
        notificationManager.registerHandler(NotificationType.EMAIL, (notification) -> System.out.println("email: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS, (notification) -> System.out.println("SMS: " + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH, (notification) -> System.out.println("push: " + notification.getMessage()));

// Отправка оповещений
        Notification emailNotification = new Notification(NotificationType.EMAIL, "popa popa popa jopa Popa hello jopa POPa");
        Notification smsNotification = new Notification(NotificationType.SMS, "popa Hello my dear friend JoPa");
        Notification pushNotification = new Notification(NotificationType.PUSH,"Let's go!!! JoPa");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}


