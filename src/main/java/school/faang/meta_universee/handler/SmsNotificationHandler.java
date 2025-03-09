package school.faang.meta_universee.handler;

import school.faang.meta_universee.Notification;

import java.util.function.Consumer;

public class SmsNotificationHandler implements Consumer<Notification> {
    @Override
    public void accept(Notification notification) {
        System.out.println("ОТПРАВИТЬ НОТИФИКЕЙШН ТУДА");
        System.out.println("ОТПРАВИТЬ НОТИФИКЕЙШН СЮДА");
        System.out.println("Notification for SMS! Content: " + notification.getMessage());
    }
}
