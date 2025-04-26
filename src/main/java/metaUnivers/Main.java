package metaUnivers;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler(NotificationType.EMAIL, notification -> System.out.println("Получено сообщение типа EMAIL" + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.PUSH, notification -> System.out.println("Получено сообщение типа PUSH" + notification.getMessage()));
        notificationManager.registerHandler(NotificationType.SMS, notification -> System.out.println("Получено сообщение типа SMS" + notification.getMessage()));

        notificationManager.sendNotification(new Notification(NotificationType.EMAIL, message:"Обновите пароль"));

    }
}
