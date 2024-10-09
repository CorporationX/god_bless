package school.faang.godbless.bjs2_34616;

import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {
    private static final Set<String> BAD_WORDS = Set.of("badWord1", "badWord2", "badWord3");

    public static void main(String[] args) {
        NotificationManager notificationManager = getNotificationManager();

        Notification emailNotification = new Notification("email", "Ваша учетная запись badWord1 успешно активирована badWord3");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }

    private static NotificationManager getNotificationManager() {
        NotificationManager notificationManager = new NotificationManager();
        Function<String, String> censorMesssage = s -> {
            StringBuilder censored = new StringBuilder();
            StringTokenizer tokenizer = new StringTokenizer(s);
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken();
                censored.append(BAD_WORDS.contains(word) ? "@#*" : word);
                censored.append(" ");
            }
            return censored.toString();
        };

        notificationManager.registerHandler("email",
                (notification) -> {
                    notification.setMessage(censorMesssage.apply(notification.getMessage()));
                    System.out.println("Отправка по электронной почте: " + notification.getMessage());
                }
        );
        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );
        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );
        return notificationManager;
    }
}
