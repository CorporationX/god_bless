package faang.school.godbless.lamdbastreamapi.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager  notificationManager = new NotificationManager();
        notificationManager.registerHandler(
                "email",
                (notification) -> System.out.println(
                        "Отправка сообщения по электронной почте: " + notification.message()
                )
        );
        notificationManager.registerHandler(
                "push",
                (notification) -> System.out.println(
                        "Отправка push уведомления: " + notification.message()
                )
        );
        notificationManager.registerHandler(
                "sms",
                (notification) -> System.out.println(
                        "Отправка sms-сообщения: " + notification.message()
                )
        );
        notificationManager.registerHandler(
                "telegram",
                (notification) -> System.out.println(
                        "Отправка сообщение в телеграме: " + notification.message()
                )
        );

        notificationManager.sendNotification(new Notification("email", "Оффер"));
        notificationManager.sendNotification(new Notification("push", "Оплата"));
        notificationManager.sendNotification(new Notification("sms", "Зачисление средств"));
        notificationManager.sendNotification(new Notification("sms", "Новое видео на канале"));
    }
}
