package sprint3task2;
//класс NotificationManager содержит Map, связывающую идентификаторы оповещений
//с их обработчиками - популярными функциональными интерфейсами
import lombok.Data;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
@Data
public class NotificationManager {
    Map <String, Consumer<Notification>> map = new HashMap<>();
    public void registerHandler (String notificationIdentification, Consumer<Notification> Nikita){
        //индентификатор оповещений; функц интерфейс = обработчик оповещений
        //тут функц интерфейс - значит тут будет лямбда
        //то есть тут вообще можно делать лямбду тк есть функц интерф в параметрах
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
        // вызывает ===значит нужен сюда метод функц интерфейса
        //выдергивает значение из мапы, то есть функц интерфейс, и к этому объекту
        // функц интерфейса применяем его собственный метод accept с параметром notification,
        // из самого метода, где находимся


        //за счет этого метода вообще сотворяется ляба для использования ее в методе registerHandler
    }
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
        //складываем в map ключи и значения
        //в Consumer уже можем делать лямбду потому что это функци интерфейс
        //сами пишем какой идентификатор оповещений и какое выражени в лямбде будет
        // тк тут Consumer в методе, то прописываем как именно будет себя вести лямба ()

        ////// каркас для лямбы (!!!!!!)
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

// Отправка оповещений
        //сохдаем объекты класса Notification для их использования в sendNotification
        //здесь сотворяются объекты notification, чтобы их использовать для
        //сотворения лямбды в notificationManager.sendNotification(...);


        ///// объекты для метода в котором вызов лямбы (!!!!!!!!)
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        //вызываем соответствующи обработчик оповещения из Map с помощью метода sendNotification
        //через объект класса делается
        //вставляем соданные выше объекты класса
        //это делаем чтобы был вообще объект notification
        // для Consumer<Notification> Nikita из registerHandler

        //если это не выполнять - лямба не сотворяется


        ///// собственно вызов лямбы (!!!!!!!)
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);


        ///функц интерфейс в методе - это его вызов;
        //функц интерфейс в передаваемых параметрах - это значит надо лямбу прописывать

    }
}