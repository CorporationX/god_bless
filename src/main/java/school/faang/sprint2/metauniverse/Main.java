package school.faang.sprint2.metauniverse;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );
        // Регистрация фильтров
        notificationManager.registerFilter("sms",
                (notification) -> notification.getMessage().length() <= 50 // Пример фильтра для SMS
        );

// Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification smsNotification1 = new Notification("sms", "Вы являетесь разработчиком в компании Meta и работаете над новым приложением для управления оповещениями. ");

        Notification unknownNotification = new Notification("unknown", "Это неизвестное уведомление");
        notificationManager.sendNotification(unknownNotification);
        notificationManager.sendNotification(smsNotification1);
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
