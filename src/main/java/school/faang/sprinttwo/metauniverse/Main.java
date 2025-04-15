package school.faang.sprinttwo.metauniverse;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerCorrector(Notification.NotificationType.EMAIL, n ->
                n.withMessage(n.getMessage() + "\nС уважением, Компания ООО\n"));

        manager.registerCorrector(Notification.NotificationType.SMS, n ->
                n.withMessage(n.getMessage() + " - Company LTD"));

        manager.registerCorrector(Notification.NotificationType.PUSH, n ->
                n.withMessage(n.getMessage() + " | Компания ООО"));

        manager.registerCorrector(Notification.NotificationType.EMAIL, n -> {
            String currentDate = java.time.LocalDate.now().toString();
            return n.withMessage(currentDate + ": " + n.getMessage());
        });

        manager.registerCorrector(Notification.NotificationType.SMS, n ->
                n.withMessage(n.getMessage().toUpperCase()));

        manager.registerCorrector(Notification.NotificationType.PUSH, n ->
                n.withMessage("PUSH-" + n.getMessage()));

        manager.registerHandler(Notification.NotificationType.EMAIL, n ->
                System.out.println("Отправка EMAIL: " + n.getMessage()));

        manager.registerHandler(Notification.NotificationType.SMS, n ->
                System.out.println("Отправка SMS: " + n.getMessage()));

        manager.registerHandler(Notification.NotificationType.PUSH, n ->
                System.out.println("Отправка PUSH: " + n.getMessage()));

        manager.sendNotification(new Notification(Notification.NotificationType.EMAIL, "Письмо на почту"));
        manager.sendNotification(new Notification(Notification.NotificationType.SMS, "Notification by Phone"));
        manager.sendNotification(new Notification(Notification.NotificationType.PUSH, "Push-уведомление"));
    }
}
