package metauniverse;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler(NotificationType.EMAIL, n ->
                System.out.println(" Email: " + n.getMessage()));
        manager.registerHandler(NotificationType.SMS, n ->
                System.out.println(" SMS: " + n.getMessage()));
        manager.registerHandler(NotificationType.PUSH, n ->
                System.out.println(" PUSH: " + n.getMessage()));

        manager.addFilter(n -> !n.getMessage().toLowerCase().contains("бяка"));

        manager.addModifier(n -> new Notification(n.getType(), n.getMessage() + "\n-- From Meta Team"));

        manager.sendNotification(new Notification(NotificationType.EMAIL, "Привет, друг!"));
        manager.sendNotification(new Notification(NotificationType.SMS, "Это сообщение содержит бяка-слово"));
        manager.sendNotification(new Notification(NotificationType.PUSH, "У нас акция!"));
    }
}
