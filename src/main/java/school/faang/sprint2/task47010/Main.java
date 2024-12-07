package school.faang.sprint2.task47010;

import school.faang.sprint2.task47010.manager.NotificationManager;
import school.faang.sprint2.task47010.model.MessageType;
import school.faang.sprint2.task47010.model.Notification;
import school.faang.sprint2.task47010.service.EmailService;
import school.faang.sprint2.task47010.service.PushService;
import school.faang.sprint2.task47010.service.SMSService;

public class Main {
    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();
        EmailService emailService = new EmailService();
        SMSService smsService = new SMSService();
        PushService pushService = new PushService();

        notificationManager.registerHandler(MessageType.EMAIL,
                (notification) -> emailService.sendMessage(notification.getMessage()));
        notificationManager.registerHandler(MessageType.SMS,
                (notification) -> smsService.sendMessage(notification.getMessage()));
        notificationManager.registerHandler(MessageType.PUSH,
                (notification) -> pushService.sendMessage(notification.getMessage()));

        Notification emailNotification = new Notification(MessageType.EMAIL, "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification(MessageType.SMS, "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification(MessageType.PUSH, "Новый пост от пользователя: JohnDoe");
        Notification pagerNotification = new Notification(MessageType.PAGER, "Затерявшееся сообщение из 90х");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(pagerNotification);

    }
}
