package school.faang.meta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotificationManagerTest {

    private NotificationManager notificationManager;

    @BeforeEach
    public void setUp() {
        notificationManager = new NotificationManager();
    }

    @Test
    public void registerHandlerTest() {
        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );
        notificationManager.sendNotification(new Notification("email", "Ваша учетная запись успешно активирована"));
    }

    @Test
    public void sendNotificationTest() {
        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );
        notificationManager.sendNotification(new Notification("sms", "Вы успешно изменили свой пароль"));
    }

    @Test
    public void sendDefaultNotificationTest() {
        notificationManager.sendNotification(new Notification("anotherType", "Новый пост от пользователя: JohnDoe"));
    }

    @Test
    public void addCensureTest() {
        notificationManager.addCensure("badWord",
                notification -> notification.getMessage().toLowerCase().contains("плохим словом")
        );
        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );
        notificationManager.sendNotification(new Notification("sms", "Вы успешно изменили свой пароль с плохим словом"));
        notificationManager.removeCensure("badWord");
    }

    @Test
    public void addCorrectorsTest() {
        notificationManager.addCorrector("mrXCorrector",
                (notification -> {
                    notification.setMessage(notification.getMessage().replace("mrX", "noMrX"));
                    return notification;
                })
        );
        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );
        notificationManager.sendNotification(new Notification("sms", "Вы успешно изменили свой пароль mrX"));
        notificationManager.removeCorrector("mrXCorrector");
    }
}
