package faang.school.godbless.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

// Отправка оповещений - Это можно назвать создание объекта класса Notification
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification watsNotification = new Notification("whatsApp", "у вас новое сообщение: JohnDoe");

// Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));
        notificationManager.registerHandler("whatsAp", (notification) -> System.out.println("Отправка watsApp-уведомления: " + notification.getMessage()));

// Проверил исключении кидает. На семнадцатой строчке с поля "WhatsAp" убрал одну букву чтобы не было данного ключа при запросе
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(watsNotification);
    }
}