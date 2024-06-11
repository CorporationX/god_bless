package faang.school.godbless.lamdbastreamapi.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager  notificationManager = new NotificationManager();
        notificationManager.registerHandler(
                "email",
                (notification) -> System.out.println(
                        "Отправка сообщения по электронной почте: " + notification.getMessage()
                )
        );
        notificationManager.registerHandler(
                "push",
                (notification) -> System.out.println(
                        "Отправка push уведомления: " + notification.getMessage()
                )
        );
        notificationManager.registerHandler(
                "sms",
                (notification) -> System.out.println(
                        "Отправка sms-сообщения: " + notification.getMessage()
                )
        );
        notificationManager.registerHandler(
                "telegram",
                (notification) -> System.out.println(
                        "Отправка сообщение в телеграме: " + notification.getMessage()
                )
        );

        notificationManager.sendNotification(new Notification("email", "Оффер"));
        notificationManager.sendNotification(new Notification("push", "Оплата"));
        notificationManager.sendNotification(new Notification("sms", "Зачисление средств"));
        notificationManager.sendNotification(new Notification("sms", "Новое видео на канале"));
    }
}
