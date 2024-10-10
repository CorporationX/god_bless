package school.faang.meta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotificationManagerTest {
    private static final String SMS_TYPE_NAME = "sms";
    private static final String SMS_PREFIX = "Отправка SMS: ";
    private static final String EMAIL_TYPE_NAME = "email";
    private static final String EMAIL_PREFIX = "Отправка по электронной почте: ";
    private static final String DEFAULT_MESSAGE_PREFIX = "Отправка данным типом не возможна: ";
    private static final String CENSORED_MESSAGE = "Отправка данного сообщения не возможна. Цензура не пройдена.";

    private NotificationManager notificationManager;

    @BeforeEach
    public void setUp() {
        notificationManager = new NotificationManager();
    }

    @Test
    public void registerHandlerTest() {
        String notificationMessage = "Ваша учетная запись успешно активирована";
        notificationManager.registerHandler(EMAIL_TYPE_NAME, notification -> {
            notificationManager.getSentMessages().add(EMAIL_PREFIX + notification.getMessage());
            System.out.println(EMAIL_PREFIX + notification.getMessage());
        });

        notificationManager.sendNotification(new Notification(EMAIL_TYPE_NAME, notificationMessage));

        assertEquals(EMAIL_PREFIX + notificationMessage, notificationManager.getSentMessages().get(0));
    }

    @Test
    public void sendNotificationTest() {
        String notificationMessage = "Вы успешно изменили свой пароль";
        notificationManager.registerHandler(SMS_TYPE_NAME, notification -> {
                    notificationManager.getSentMessages().add(SMS_PREFIX + notification.getMessage());
                    System.out.println(SMS_PREFIX + notification.getMessage());
                }
        );

        notificationManager.sendNotification(new Notification(SMS_TYPE_NAME, notificationMessage));

        assertEquals(SMS_PREFIX + notificationMessage, notificationManager.getSentMessages().get(0));
    }

    @Test
    public void sendDefaultNotificationTest() {
        String invalidType = "invalidType";
        String notificationMessage = "Новый пост от пользователя: JohnDoe";

        notificationManager.sendNotification(new Notification(invalidType, notificationMessage));

        assertEquals(DEFAULT_MESSAGE_PREFIX + invalidType, notificationManager.getSentMessages().get(0));
    }

    @Test
    public void addCensureTest() {
        String notificationMessage = "Вы успешно изменили свой пароль с плохим словом";
        notificationManager.addCensure("badWord",
                notification -> notification.getMessage().toLowerCase().contains("плохим словом")
        );
        notificationManager.registerHandler(SMS_TYPE_NAME, notification -> {
            String message = SMS_PREFIX + notification.getMessage();
            notificationManager.getSentMessages().add(message);
            System.out.println(message);
        });

        notificationManager.sendNotification(new Notification(SMS_TYPE_NAME, notificationMessage));

        assertEquals(CENSORED_MESSAGE, notificationManager.getSentMessages().get(0));
    }

    @Test
    public void deleteCensureTest() {
        String notificationMessage = "Вы успешно изменили свой пароль с плохим словом";
        notificationManager.addCensure("badWord",
                notification -> notification.getMessage().toLowerCase().contains("плохим словом")
        );
        notificationManager.removeCensure("badWord");
        notificationManager.registerHandler(SMS_TYPE_NAME, notification -> {
            String message = SMS_PREFIX + notification.getMessage();
            notificationManager.getSentMessages().add(message);
            System.out.println(message);
        });

        notificationManager.sendNotification(new Notification(SMS_TYPE_NAME, notificationMessage));

        assertEquals(SMS_PREFIX + notificationMessage, notificationManager.getSentMessages().get(0));
    }

    @Test
    public void addCorrectorsTest() {
        String originalMessage = "Вы успешно изменили свой пароль mrX";
        String correctedMessage = "Вы успешно изменили свой пароль noMrX";
        notificationManager.addCorrector("mrXCorrector",
                (notification -> {
                    notification.setMessage(notification.getMessage().replace("mrX", "noMrX"));
                    return notification;
                })
        );
        notificationManager.registerHandler(SMS_TYPE_NAME, notification -> {
            String message = SMS_PREFIX + notification.getMessage();
            notificationManager.getSentMessages().add(message);
            System.out.println(message);
        });

        notificationManager.sendNotification(new Notification(SMS_TYPE_NAME, originalMessage));

        assertEquals(SMS_PREFIX + correctedMessage, notificationManager.getSentMessages().get(0));
    }

    @Test
    public void deleteCorrectorsTest() {
        String originalMessage = "Вы успешно изменили свой пароль mrX";
        notificationManager.addCorrector("mrXCorrector",
                (notification -> {
                    notification.setMessage(notification.getMessage().replace("mrX", "noMrX"));
                    return notification;
                })
        );
        notificationManager.removeCorrector("mrXCorrector");
        notificationManager.registerHandler(SMS_TYPE_NAME, notification -> {
            String message = SMS_PREFIX + notification.getMessage();
            notificationManager.getSentMessages().add(message);
            System.out.println(message);
        });

        notificationManager.sendNotification(new Notification(SMS_TYPE_NAME, originalMessage));

        assertEquals(SMS_PREFIX + originalMessage, notificationManager.getSentMessages().get(0));
    }
}
