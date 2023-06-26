package sprint3task2;
//класс NotificationManager содержит Map, связывающую идентификаторы оповещений
//с их обработчиками - популярными функциональными интерфейсами

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Data
public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String notificationIdentification, Consumer<Notification> consumer) {
//В параметрах (Идентификатор оповещений, функциональный интерфейс (о же обработчик оповещений))
//Тут функциональный интерфейс - значит отсюда пойдет лямбда.
//То есть тут в принципе возможно делать лямбду, тк есть функциональный интерфейс привносится в параметрах.
        map.put(notificationIdentification, consumer);
    }

    public void sendNotification(Notification notification) {
//вызывает соответствующий обработчик оповещения из Map.
//обработчики - функциональные интерфейсы Java.
//        if (map.containsKey(notification.getType()) || !map.isEmpty()) {
//            Consumer<Notification> consumer = map.get(notification.getType());
//            consumer.accept(notification);
//        } else throw new IllegalArgumentException("Исключение");
        Consumer<Notification> consumer = map.get(notification.getType());
        consumer.accept(notification);
//"Вызывает" ===> значит нужен сюда метод функционального интерфейса.
//Выдергивает значение из мапы, то есть функциональный интерфейс, и к этому объекту
//Функциональный интерфейс применяет его собственный метод accept с параметром notification,
//из самого метода, где находимся.

//за счет этого метода вообще сотворяется лямбда для использования ее в методе registerHandler.
    }

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
// Регистрация обработчиков оповещений

//Складываем в map ключи и значения
//С помощью Consumer уже можем делать лямбду, потому что это функциональный интерфейс.
//Сами пишем какой идентификатор оповещений и какое выражение будет в лямбде.
//Тк тут Consumer в методе, то прописываем как именно будет себя вести лямба ().

////// каркас для лямбды (!)
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

// Отправка оповещений
        //Создаем объекты класса Notification для их использования в sendNotification.
        //Здесь сотворяются объекты notification, чтобы их использовать для
        //сотворения лямбды в notificationManager.sendNotification(...);

///// объекты для метода в котором вызов лямбды (!!)
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

//вызываем соответствующи обработчик оповещения из Map с помощью метода sendNotification
//через объект класса делается
//вставляем созданные выше объекты класса
//это делаем чтобы был вообще объект notification
//для Consumer<Notification> Nikita из registerHandler

//если это не выполнять - лямбда не сотворяется.


/////собственно вызов лямбды (!!!)
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

///функциональный интерфейс в методе - это его вызов;
//функциональный интерфейс в передаваемых параметрах - значит будем лямбду прописывать.
    }
}