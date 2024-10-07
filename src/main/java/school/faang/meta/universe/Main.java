package school.faang.meta.universe;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );
        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );
        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        Filter cruelContent = new Filter("жестокий", Set.of("кровь", "насилие", "смерть", "мясо"));
        Filter work = new Filter("работа", Set.of("отчет", "офис", "оффер", "300к", "наносек"));
        notificationManager.registerFilter(cruelContent, (notification) -> {
            String content = notification.getMessage();
            for (String word : cruelContent.getTriggerWords()) {
                content = content.replaceAll(word, "котики, сердечки и бабочки");
            }
            notification.setMessage(content);
        });
        notificationManager.registerFilter(work, (notification) -> {
            String[] words = notification.getMessage().split("\\PL+");
            for (String word : words) {
                if (work.getTriggerWords().contains(word)) {
                    return;
                }
            }
            throw new IllegalArgumentException("Сообщения не по работе не принимаются");
        });

        Notification emailNotification = new Notification("email", "кровь, мясо, жескач, офис");
        Notification smsNotification = new Notification("sms", "Предлагаем вам оффер на 300к в СБЕР!!!");
        Notification pushNotification = new Notification("push", "Привет, пойдем в парное программирование");

        notificationManager.sendNotification(emailNotification, List.of(cruelContent, work));
        notificationManager.sendNotification(smsNotification, List.of(work));

        try {
            notificationManager.sendNotification(pushNotification, List.of(work));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
