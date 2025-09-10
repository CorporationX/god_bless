package school.faang.bjs2_87756;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler(NotificationType.EMAIL, notification -> {
            System.out.println("Отправляем EMAIL:");
            System.out.println("   Тема: Важное уведомление");
            System.out.println("   Тело: " + notification.getMessage());
            System.out.println("   Получатель: user@example.com");
            System.out.println("---");
        });

        manager.registerHandler(NotificationType.SMS, notification -> {
            System.out.println("Отправляем SMS:");
            System.out.println("   Номер: +7 900 123-45-67");
            System.out.println("   Текст: " + notification.getMessage());
            System.out.println("   Длина: " + notification.getMessage().length() + " символов");
            System.out.println("---");
        });

        manager.registerHandler(NotificationType.PUSH, notification -> {
            System.out.println("Отправляем PUSH-уведомление:");
            System.out.println("   Заголовок: Новое сообщение");
            System.out.println("   Контент: " + notification.getMessage());
            System.out.println("   Важность: Высокая");
            System.out.println("---");
        });

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);
    }
}
