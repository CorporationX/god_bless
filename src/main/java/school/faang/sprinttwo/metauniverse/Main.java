package school.faang.sprinttwo.metauniverse;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerCorrector(NotificationType.EMAIL, n ->
                n.withMessage("%s\nС уважением, Компания ООО\n".formatted(n.getMessage())));

        manager.registerCorrector(NotificationType.SMS, n ->
                n.withMessage("%s - Company LTD".formatted(n.getMessage())));

        manager.registerCorrector(NotificationType.PUSH, n ->
                n.withMessage("%s | Компания ООО".formatted(n.getMessage())));

        manager.registerCorrector(NotificationType.EMAIL, n -> {
            String currentDate = java.time.LocalDate.now().toString();
            return n.withMessage("%s: %s".formatted(currentDate, n.getMessage()));
        });

        manager.registerCorrector(NotificationType.SMS, n ->
                n.withMessage(n.getMessage().toUpperCase()));

        manager.registerCorrector(NotificationType.PUSH, n ->
                n.withMessage("PUSH-%s".formatted(n.getMessage())));

        manager.registerHandler(NotificationType.EMAIL, n ->
                System.out.printf("Отправка EMAIL: %s", n.getMessage()));

        manager.registerHandler(NotificationType.SMS, n ->
                System.out.printf("Отправка SMS: %s", n.getMessage()));

        manager.registerHandler(NotificationType.PUSH, n ->
                System.out.printf("Отправка PUSH: %s", n.getMessage()));

        manager.sendNotification(new Notification(NotificationType.EMAIL, "Письмо на почту"));
        manager.sendNotification(new Notification(NotificationType.SMS, "Notification by Phone"));
        manager.sendNotification(new Notification(NotificationType.PUSH, "Push-уведомление"));
    }
}