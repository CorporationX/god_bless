package school.faang.sprint2.task47010;

import school.faang.sprint2.task47010.manager.NotificationManager;
import school.faang.sprint2.task47010.model.MessageType;
import school.faang.sprint2.task47010.model.Notification;
import school.faang.sprint2.task47010.service.EmailService;
import school.faang.sprint2.task47010.service.PushService;
import school.faang.sprint2.task47010.service.Sender;
import school.faang.sprint2.task47010.service.SmsService;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();
        EmailService emailService = new EmailService();
        SmsService smsService = new SmsService();
        PushService pushService = new PushService();

        Map<MessageType, Sender> services = new HashMap<>();
        services.put(MessageType.EMAIL, emailService);
        services.put(MessageType.SMS, smsService);
        services.put(MessageType.PUSH, pushService);

        for(Map.Entry <MessageType, Sender> entry : services.entrySet())
        {
            notificationManager.registerHandler(entry.getKey(),
                    (notification) -> entry.getValue().sendMessage(notification.getMessage()));
        }

        Notification emailNotification = new Notification(MessageType.EMAIL,
                "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification(MessageType.SMS,
                "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification(MessageType.PUSH,
                "Новый пост от пользователя: JohnDoe");
        Notification pagerNotification = new Notification(MessageType.PAGER,
                "Затерявшееся сообщение из 90х");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(pagerNotification);

    }
}
