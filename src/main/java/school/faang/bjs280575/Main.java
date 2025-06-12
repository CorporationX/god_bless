package school.faang.bjs280575;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler(NotificationType.PUSH, notification -> {
            System.out.println("Push уведомление: " + notification.getMessage());
        });
        Strig message = "Бака как ты мог купить 4 пельменя";
        notificationManager.sendNotification(new Notification(NotificationType.PUSH, message));
        String message = "Вы звонили нам неделю назад с просьбой.\n Она еще актуальна?";
        notificationManager.sendNotification(new Notification(NotificationType.PUSH, message));

    }
}
