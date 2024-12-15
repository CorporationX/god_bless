package school.faang.moduleone.sprinttwo.task_43535;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        NotificationFilter.BANNED_WORDS.addAll(List.of("cocaine", "hexogen"));

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        // Регистрация фильтров оповещений
        notificationManager.registerFilter("email", (notification -> {
            String message = notification.getMessage().toLowerCase().replaceAll("\\p{Punct}", " ");
            List<String> words = Arrays.asList(message.split("\\s+"));
            boolean isBannedWordPresent = false;
            for (String bannedWord : NotificationFilter.BANNED_WORDS) {
                if (words.stream()
                        .anyMatch(checkedWord -> checkedWord.contains(bannedWord))) {
                    isBannedWordPresent = true;
                    break;
                }
            }
            if (isBannedWordPresent) {
                return new Notification("email", "Сообщение удалено! Присутствовал запрещенный контент!");
            }
            return notification;
        }));

        // Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(new Notification(
                "email", "We are waiting for half a kilo of cocaine from you"));
        notificationManager.sendNotification(new Notification(
                "email", "and also send a box of hexogen"));
    }
}
