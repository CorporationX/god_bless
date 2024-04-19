package faang.school.godbless.notifications;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", (notification) ->
                System.out.println("Отправка по электронной почте: " + notification.getMessage()));

        notificationManager.registerHandler("sms", (notification) ->
                System.out.println("Отправка SMS: " + notification.getMessage()));

        notificationManager.registerHandler("push", (notification) ->
                System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        notificationManager.registerHandler("defaultValue", (notification) ->
                System.out.println("Ошибка" + notification.getMessage()));

// Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification defaultValueNotification = new Notification("defaultValue", "Неверный тип оповещения");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(defaultValueNotification);
    }
}
