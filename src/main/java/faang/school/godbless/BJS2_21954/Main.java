package faang.school.godbless.BJS2_21954;

public class Main {
    public static void main(String[] args) {
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        NotificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.message()));
        NotificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.message()));
        NotificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.message()));

        NotificationManager.sendNotification(emailNotification);
        NotificationManager.sendNotification(smsNotification);
        NotificationManager.sendNotification(pushNotification);
    }
}
