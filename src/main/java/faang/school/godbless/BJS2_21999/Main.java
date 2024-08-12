package faang.school.godbless.BJS2_21999;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        notificationManager.filterHandler("push", notification -> {
            if (notification.getMessage().contains("JohnDoe")) {
                return new Notification(notification.getType(), "JohnDoe is incorrect name");
            }
            return notification;
        });

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
