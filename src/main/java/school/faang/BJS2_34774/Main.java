package school.faang.BJS2_34774;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        NotificationManager notificationManager = new NotificationManager();

        Set<String> filterListBlock = new HashSet<>();
        filterListBlock.add("sex");
        filterListBlock.add("adult");
        filterListBlock.add("violence");

        Set<String> filterListAttention = new HashSet<>();
        filterListAttention.add("price request");
        filterListAttention.add("ceo");
        filterListAttention.add("contract");

        notificationManager.registerHandler(NotificationType.SMS,
                (notification -> System.out.println( "Отправка sms сообщения: " + notification.getMessage())));
        notificationManager.registerHandler(NotificationType.EMAIL,
                (notification -> System.out.println("Отправка сообщения по e-mail: " + notification.getMessage())));
        notificationManager.registerHandler(NotificationType.PUSH,
                (notification) -> System.out.println("Отправка push уведомления: " + notification.getMessage()));

        notificationManager.registerFilter(filterListBlock, notification -> {
            for (String filter : filterListBlock) {
                if (notification.getMessage().contains(filter)) {
                    notification.setMessage("Content blocked " + notification.getMessage());
                }
            }
            return notification;
        });

        notificationManager.registerFilter(filterListAttention, notification -> {
            for (String filter : filterListAttention) {
                if (notification.getMessage().contains(filter)) {
                    notification.setMessage("Attention!!!! " + notification.getMessage());
                }
            }
            return notification;
        });

        Notification smsNotification = new Notification(NotificationType.SMS, "Текст смс adult");
        Notification emailNotification = new Notification(NotificationType.EMAIL, "Текст ceo письма");
        Notification pushNotification = new Notification(NotificationType.PUSH, "Текст push уведомления");

        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.sendWithFilter(smsNotification);
        notificationManager.sendWithFilter(emailNotification);
    }
}
