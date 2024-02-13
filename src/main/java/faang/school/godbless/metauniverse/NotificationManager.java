package faang.school.godbless.metauniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private final static Map<String, Consumer<Notification>> map = new HashMap<>();
    public static void registerHandler(String type, Consumer<Notification> consumer){

        map.put(type, consumer);
    }
    public static void sendNotification(Notification notification){
        map.get(notification.getType()).accept(notification);
    }

    public static void main(String[] args) {
        NotificationManager.registerHandler("email", (notification -> System.out.println("The dispatch by email: " + notification.getMessage())));
        NotificationManager.registerHandler("sms", (notification -> System.out.println("The dispatch by sms: " + notification.getMessage())));
        NotificationManager.registerHandler("push", (notification -> System.out.println("The dispatch by push-notification: " + notification.getMessage())));

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        NotificationManager.sendNotification(emailNotification);
        NotificationManager.sendNotification(smsNotification);
        NotificationManager.sendNotification(pushNotification);
    }
}