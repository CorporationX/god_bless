package faang.school.godbless.Sprint3.Task_2_Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {

    private Map<String, Consumer> handlers = new HashMap<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        String type = notification.getType();
        Consumer<Notification> handler = handlers.get(type);
        if (handler != null) {
            handler.accept(notification);
        }
    }

    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        // Регистрация обработчиков оповещений
        manager.registerHandler("email", notification -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        manager.registerHandler("sms", notification -> System.out.println("Отправка SMS: " + notification.getMessage()));
        manager.registerHandler("push", notification -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        // Отправка оповещений
        manager.sendNotification(new Notification("email", "Ваша учетная запись успешно активирована"));
        manager.sendNotification(new Notification("sms", "Вы успешно изменили свой пароль"));
        manager.sendNotification(new Notification("push", "Новый пост от пользователя: JohnDoe"));
    }
}



