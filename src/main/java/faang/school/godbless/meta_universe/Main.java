package faang.school.godbless.meta_universe;

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

        Notification workNotification = new Notification("work", "Go to work");
        Notification importantNotification = new Notification("important", "Some important notification");
        Notification spamNotification = new Notification("spam", "Some spam");
        Notification advertisementNotification = new Notification("advertisement", "Some advertisement");

        notificationManager.addNotification(workNotification);
        notificationManager.addNotification(importantNotification);
        notificationManager.addNotification(spamNotification);
        notificationManager.addNotification(advertisementNotification);

        notificationManager.showFilteredNotifications(notification -> notification.getType().equals("work") ||
                notification.getType().equals("important"));

        Notification collegueNotification = new Notification("work",
                "Well you know we need a product that you know will you know earn a lot and waste a little");

        String result = notificationManager.filterMessageOfNotification(collegueNotification,
                (message) -> message.toLowerCase().replaceAll("(well)|(you know)", ""));
        System.out.println(result);
    }
}
