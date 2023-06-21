package sprint3task2;
//класс NotificationManager содержит Map, связывающую идентификаторы оповещений
// с их обработчиками - популярными функциональными интерфейсами
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
//        if (map.containsKey(notification.getType()) || !map.isEmpty()) {
//            Consumer<Notification> consumer = map.get(notification.getType());
//            consumer.accept(notification);
//        } else throw new IllegalArgumentException("Исключение");
        Consumer <Notification> consumer = map.get(notification.getType());
        consumer.accept(notification);

    }
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
        //складываем в map ключи и значения
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

// Отправка оповещений
        //сохдаем объекты класса Notification для их использования в sendNotification
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        //вызываем соответствующи обработчик оповещения из Map с помощью метода sendNotification
        //через объект класса делается
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

    }
}