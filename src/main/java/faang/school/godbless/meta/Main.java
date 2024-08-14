package faang.school.godbless.meta;

public class Main {
    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.registerFilter("banword", (notification) -> !notification.getMessage().toLowerCase().contains("banword"));
        notificationManager.registerCorrector("banword", (notification) -> {
            notification.setMessage(notification.getMessage().replace("banword", "***"));
            return notification;
        });

        Notification unacceptableNotification = new Notification("push", "Some banword");

        if (notificationManager.checkNotification("banword", unacceptableNotification)) {
            System.out.println(unacceptableNotification + " is accepted");
        } else {
            System.out.println(unacceptableNotification + " is rejected");
            unacceptableNotification = notificationManager.correctRejectedNotification("banword", unacceptableNotification);
            System.out.println(unacceptableNotification);
        }
    }
}
