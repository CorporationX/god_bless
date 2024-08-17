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
        String message = "banword";

        if (notificationManager.checkNotification(message, unacceptableNotification).isPresent()) {
            if (notificationManager.checkNotification(message, unacceptableNotification).get()) {
                System.out.println(unacceptableNotification + " is accepted");
            } else {
                System.out.println(unacceptableNotification + " is rejected");
                if (notificationManager.correctRejectedNotification(message, unacceptableNotification).isPresent()) {
                    unacceptableNotification = notificationManager.correctRejectedNotification(message, unacceptableNotification).get();
                    System.out.println(unacceptableNotification);
                } else {
                    System.out.println("Not registered corrector for that message : " + message);
                }
            }
        } else {
            System.out.println("Not registered filter for that message : " + message);
        }
    }
}
