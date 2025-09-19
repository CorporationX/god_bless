package bjs2_91598;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler(NotificationType.EMAIL,
                n -> System.out.println("Email: " + n.getMessage()));

        manager.registerHandler(NotificationType.SMS,
                n -> System.out.println("SMS: " + n.getMessage()));

        manager.registerHandler(NotificationType.PUSH,
                n -> System.out.println("Push: " + n.getMessage()));

        manager.addFilter(n -> !n.getMessage().toLowerCase().contains("подстрахуй"));

        manager.addModifier(n -> new Notification(
                n.getType(),
                n.getMessage() + " (Meta Inc.)"
        ));

        Notification email = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification sms = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification push = new Notification(NotificationType.PUSH, "У вас новое сообщение!");
        Notification bad = new Notification(NotificationType.SMS, "Ваш аккаунт забанен!");

        manager.sendNotification(email);
        manager.sendNotification(sms);
        manager.sendNotification(push);
        manager.sendNotification(bad);
    }
}