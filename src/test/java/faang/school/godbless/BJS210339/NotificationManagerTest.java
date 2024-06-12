package faang.school.godbless.BJS210339;

import org.junit.jupiter.api.Test;
import java.util.Set;

class NotificationManagerTest {

    @Test
    void test() {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("censored-email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
                , Set.of("дурак", "идиот", "кретин")::contains
                , obsceneWord -> new StringBuilder(obsceneWord).reverse().toString());

        Notification censoredNotification = new Notification("censored-email", "Вы дурак. Начитались идиотов и сами ведете себя как кретинушка");

        notificationManager.sendNotification(censoredNotification);
    }
}