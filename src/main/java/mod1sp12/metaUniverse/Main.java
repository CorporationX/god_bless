package mod1sp12.metaUniverse;

import java.util.List;

public class Main {

    private static final List<String> BAN_WORDS = List.of("golang", "c#");

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по" +
                " электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );
        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        notificationManager.registerFilter("ban_words", (notification) -> {
            for (String word : notification.getMessage().split(" ")) {
                word = word.replaceAll("[,!.:]", "").toLowerCase();
                if (BAN_WORDS.contains(word)) {
                    notification.setMessage("Сообщение заблокировано фильтром!");
                }
            }
            return notification;
        });

        Notification emailNotification = new Notification("email", "Ваша учётная запись успешное активирована");
        Notification firstSmsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification secondSmsNotification = new Notification("sms", "Бро, C# топчик!");
        Notification firstPushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification secondPushNotification = new Notification("push", "Вышел новый топовый язык: Golang! Нажмите, чтобы прочитать");

        notificationManager.sendNotification(emailNotification, "ban_words");
        notificationManager.sendNotification(firstSmsNotification, "ban_words");
        notificationManager.sendNotification(secondSmsNotification, "ban_words");
        notificationManager.sendNotification(firstPushNotification, "ban_words");
        notificationManager.sendNotification(secondPushNotification, "ban_words");
    }
}
