package faang.school.godbless.sprint2.meta;

public class Test {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        // Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", notification -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", notification -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", notification -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        // Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification emailNotification1 = new Notification("email", "SkillBox Дарит 1 курс");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.setFilters(notification -> notification.getMessage().contains("SkillBox"));

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(emailNotification1);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
