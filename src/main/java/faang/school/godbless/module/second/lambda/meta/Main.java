package faang.school.godbless.module.second.lambda.meta;

public class Main {
    public static void main(String[] args) {
        // Регистрация обработчиков оповещений
        NotificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        NotificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        NotificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));
        
        // Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification kushNotification = new Notification("kush", "lalala");
        
        NotificationManager.sendNotification(emailNotification);
        NotificationManager.sendNotification(smsNotification);
        NotificationManager.sendNotification(pushNotification);
        NotificationManager.sendNotification(kushNotification);
    }
}
