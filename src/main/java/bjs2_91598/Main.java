package bjs2_91598;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        // Регистрируем обработчики
        manager.registerHandler(NotificationType.EMAIL,
                n -> System.out.println("Email: " + n.getMessage()));

        manager.registerHandler(NotificationType.SMS,
                n -> System.out.println("SMS: " + n.getMessage()));

        manager.registerHandler(NotificationType.PUSH,
                n -> System.out.println("Push: " + n.getMessage()));

        // Добавляем фильтр (запрещаем слово "подстрахуй")
        manager.addFilter(n -> !n.getMessage().toLowerCase().contains("подстрахуй"));

        // Добавляем модификатор (подпись от компании)
        manager.addModifier(n -> new Notification(
                n.getType(),
                n.getMessage() + " (Meta Inc.)"
        ));

        // Создаём уведомления
        Notification email = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification sms = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification push = new Notification(NotificationType.PUSH, "У вас новое сообщение!");
        Notification bad = new Notification(NotificationType.SMS, "Ваш аккаунт забанен!");

        // Отправляем
        manager.sendNotification(email);
        manager.sendNotification(sms);
        manager.sendNotification(push);
        manager.sendNotification(bad);
    }
}