package sprint3task2;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
@Data
public class NotificationManager {
    Map <String, Consumer<Notification>> map = new HashMap<>();
    public void registerHandler (String notificationIdentification, Consumer<Notification> Nikita){
        //индентификатор оповещений; функц интерфейс)
        map.put(notificationIdentification, Nikita);
        //add
    }
    public void sendNotification (Notification notification) {
        //вызывает соответствующий обработчик оповещения из Map
        //обработчики - функциональные интерфейсы Java
        Consumer<Notification> consumer = map.entrySet().getValue();
    }
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

// Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

    }
}