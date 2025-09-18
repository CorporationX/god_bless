package school.faang.bjs2_87818;

public class NotificationDemo {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler(NotificationType.EMAIL,
                n -> System.out.println("EMAIL: " + n.getMessage()));
        manager.registerHandler(NotificationType.SMS,
                n -> System.out.println("SMS: " + n.getMessage()));
        manager.registerHandler(NotificationType.PUSH,
                n -> System.out.println("PUSH: " + n.getMessage()));

        manager.addFilter(n -> !n.getMessage().isBlank());

        manager.addCorrector(n -> new Notification(n.getType(), n.getMessage() + " [Meta]"));

        manager.sendNotification(new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован"));
        manager.sendNotification(new Notification(NotificationType.SMS, ""));
        manager.sendNotification(new Notification(NotificationType.PUSH, "У вас новое сообщение!"));
    }
}
