package school.faang.module1.bjs2_80543;

import lombok.extern.slf4j.Slf4j;

import static school.faang.module1.bjs2_80543.NotificationType.*;

@Slf4j
public class Main {

    private static final String LONG_PUSH = "Это очень длинное push-уведомление, "
            + "которое превышает лимит в 100 символов. Оно должно быть отфильтровано.";
    private static final String LONG_SMS = "Очень длинное сообщение, которое превышает максимально "
            + "допустимое количество символов в 160 знаков. Это сообщение точно будет отфильтровано, "
            + "так как оно слишком большое для SMS.";

    private static final String EMAIL_SIGNATURE = " -- С уважением, Компания Meta";
    private static final String EMAIL_SUPPORT = " Тех. поддержка: +375(29)2129874";
    private static final String SMS_NOTICE = " Внимание: стоимость SMS может взиматься оператором";
    private static final String PUSH_HINT = " Проверьте приложение для деталей.";

    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        registerFilters(manager);
        registerCorrectors(manager);
        registerHandlers(manager);

        manager.sendNotification(new Notification(EMAIL, "Добро пожаловать, user@gmail.com!"));
        manager.sendNotification(new Notification(SMS, "Ваш код подтверждения: 1234"));
        manager.sendNotification(new Notification(PUSH, "9 непрочитанных сообщений"));
        manager.sendNotification(new Notification(EMAIL, "Добрый день, плохоеслово"));
        manager.sendNotification(new Notification(EMAIL, "   "));
        manager.sendNotification(new Notification(PUSH, LONG_PUSH));
        manager.sendNotification(new Notification(SMS, LONG_SMS));
    }

    private static void registerFilters(NotificationManager manager) {
        manager.registerFilter(EMAIL, notification -> !notification.getMessage().contains("плохоеслово"));
        manager.registerFilter(EMAIL, notification -> !notification.getMessage().trim().isEmpty());
        manager.registerFilter(SMS, notification -> notification.getMessage().length() <= 160);
        manager.registerFilter(PUSH, notification -> notification.getMessage().length() <= 100);
    }

    private static void registerCorrectors(NotificationManager manager) {
        manager.registerCorrector(EMAIL, notification -> new Notification(
                notification.getNotificationType(),
                notification.getMessage() + EMAIL_SIGNATURE
        ));
        manager.registerCorrector(EMAIL, notification -> new Notification(
                notification.getNotificationType(),
                notification.getMessage() + EMAIL_SUPPORT
        ));
        manager.registerCorrector(SMS, notification -> new Notification(
                notification.getNotificationType(),
                notification.getMessage() + SMS_NOTICE
        ));
        manager.registerCorrector(PUSH, notification -> new Notification(
                notification.getNotificationType(),
                notification.getMessage() + PUSH_HINT
        ));
    }

    private static void registerHandlers(NotificationManager manager) {
        manager.registerHandler(EMAIL, notification -> log.info("Отправка EMAIL: {}", notification.getMessage()));
        manager.registerHandler(SMS, notification -> log.info("Отправка SMS: {}", notification.getMessage()));
        manager.registerHandler(PUSH, notification -> log.info("Отправка PUSH: {}", notification.getMessage()));
    }
}