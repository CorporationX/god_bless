package school.faang.bjs280575;

public class Main {
    public static void main(String[] args) {
        NotificationManager dataManager = new NotificationManager();
        dataManager.registerHandler(NotificationType.PUSH, notification -> {
                                    System.out.println("Push уведомление: " + notification.getMessage()))
            };
        dataManager.sendNotification(new Notification(NotificationType.PUSH, "Бака как ты мог купить 4 пельменя"));
        String message = "Вы звонили нам неделю назад с прозьбой.\n Она еще актуальна?"
        dataManager.sendNotification(new Notification(NotificationType.PUSH, message));

    }
}
