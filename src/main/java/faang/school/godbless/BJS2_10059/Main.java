package faang.school.godbless.BJS2_10059;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        ObscenityFilter obscenityFilter = new ObscenityFilter();

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        //Регистрация фильтра мата
        obscenityFilter.registerFilter("email", (notification) -> {
            if (notification.getMessage().contains("мат")) {
                Notification filteredNotification = new Notification(notification.getType(), notification.getMessage().replace("мат", "***"));
                System.out.println("Отправка по электронной почте: " + filteredNotification.getMessage());
            } else System.out.println("Отправка по электронной почте: " + notification.getMessage());
        });

        // Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        // Обработка и отправка оповещений после фильтра мата
        Notification emailNotificationWithObscenity = new Notification("email", "Ваша учетная запись успешно активирована, мат");

        obscenityFilter.applyFilter(emailNotificationWithObscenity);
    }
}
