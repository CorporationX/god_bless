package meta.notifications;

import java.util.function.Predicate;

public class Main {


    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification unregisteredNotification = new Notification("regular_mail", "Вам отправлено письмо до востребования");
        Notification explicitNotification = new Notification("sms", "Квадробер объявил себя чайлд-фри");

        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка по СМС: " + notification.getMessage()));

        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Отправка Push-уведомления: " + notification.getMessage()));

        Predicate<Notification> explicitFilter = (notification) -> {
            String message = notification.getMessage().toLowerCase();
            return !message.contains("квадробер") && !message.contains("чайлд-фри");
        };

        notificationManager.addContentFilter(explicitFilter);

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(unregisteredNotification);
        notificationManager.sendNotification(explicitNotification);


    }


}
