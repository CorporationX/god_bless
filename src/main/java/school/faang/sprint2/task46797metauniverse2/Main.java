package school.faang.sprint2.task46797metauniverse2;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    private static final List<String> BANNED_WORDS = Arrays.asList("плохоеcлово1", "плохоеcлово2", "плохоеcлово3");
    private static final List<String> SPAM_KEYWORDS = Arrays.asList("скидки", "выйгрыш", "бесплатно", "казино");

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler("email",
                (notification) -> log.info("Отправлено email оповещение: {}", notification.getMessage())
        );

        notificationManager.registerHandler("sms",
                (notification) -> log.info("Отправлено SMS оповещение: {}", notification.getMessage())
        );

        notificationManager.registerHandler("push",
                (notification) -> log.info("Отправлено push-уведомление: {}", notification.getMessage())
        );

        notificationManager.addFilter("Спам",
                (notification) -> {
                    String message = notification.getMessage();
                    boolean hasBadWord = false;
                    for (String bannedWord : SPAM_KEYWORDS) {
                        if (message.toLowerCase().contains(bannedWord)) {
                            notification.setMessage(message + "\n" + "<<ПОДОЗРЕНИЕ НА СПАМ!!!>>");
                            log.info("Сообщение помечено как СПАМ: {}", notification.getMessage());
                            hasBadWord = true;
                        }
                    }
                    return hasBadWord;
                }
        );

        notificationManager.addFilter("Цензура",
                (notification) -> {
                    String[] words = notification.getMessage().toLowerCase().split(" ");
                    boolean hasBadWord = false;
                    for (int i = 0; i < words.length; i++) {
                        if (BANNED_WORDS.contains(words[i])) {
                            words[i] = "*".repeat(words[i].length());
                            hasBadWord = true;
                        }
                    }
                    if (hasBadWord) {
                        String filteredMessage = String.join(" ", words);
                        notification.setMessage(filteredMessage);
                        log.info("Сообщение отфильтровано (цензура): {}", notification.getMessage());
                    }
                    return hasBadWord;
                }
        );

        Filter filterBadWords = new Filter("Цензура");
        Filter filterSpam = new Filter("Спам");

        Notification emailNotification = new Notification("email", "Я твою маму плохоеcлово1");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Поздравляем! Вы выйграли в казино");
        Notification badWordAndSpam = new Notification("push", "бесплатно только для плохоеcлово2");
        // Список фильтров
        List<Filter> filters = Arrays.asList(filterBadWords, filterSpam);

        notificationManager.sendNotification(emailNotification, filters);  // Оповещение с фльтрами
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification, filters);
        notificationManager.sendNotification(badWordAndSpam, filters);

        for (Filter filter : filters) {
            System.out.printf("Отфильтрованные оповещения с помощью: %s%n", filter.getTypeFilter());
            int numberNotification = 1;
            for (Notification notification : filter.getFilteredNotifications()) {
                System.out.printf("    %d. %s%n", numberNotification, notification.getMessage());
                numberNotification++;
            }
            System.out.println();
        }

    }
}
