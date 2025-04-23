package school.faang;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

//Требования:
// 1️⃣ Создайте класс Notification с полями:

//NotificationType type — тип оповещения (перечисление: EMAIL, SMS, PUSH).

//String message — сообщение оповещения.

//      2️⃣ Создайте класс NotificationManager, который будет содержать Map<NotificationType, Consumer<Notification>>,
//где ключ — тип оповещения, а значение — обработчик. И методы:

//registerHandler(NotificationType type, Consumer<Notification> handler) — регистрирует обработчик для определенного
//типа оповещения.

//sendNotification(Notification notification) — вызывает обработчик для переданного типа оповещения.

//      3️⃣ Зарегистрируйте несколько обработчиков оповещений с помощью лямбда-выражений и функционального интерфейса
//    Consumer<Notification>.

//4️⃣* Продумайте, как можно расширить систему, используя дополнительные функциональные интерфейсы. В Meta от вас ждут
//инициативности и находчивости в разработке собственных креативных решений. Этот пункт мы оставили специально свободным
//      для вас, чтобы вы могли воплощать свои идеи! Вот парочка:

//Добавьте фильтры: Используйте функциональный интерфейс Predicate<Notification> для проверки допустимости содержания
//      оповещений. Например, блокируйте сообщения с нецензурной лексикой.

//Добавьте корректоры сообщений: Используйте Function<Notification, Notification>, чтобы корректировать содержание
//оповещений перед отправкой. Например, добавить подпись компании к каждому сообщению.

//Пример использования:


/*NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
notificationManager.registerHandler(NotificationType.EMAIL,
                                    notification -> System.out.println("Email: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS,
                                            notification -> System.out.println("SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH,
                                            notification -> System.out.println("Push Notification: " + notification.getMessage())
        );

// Отправка оповещений
Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

notificationManager.sendNotification(emailNotification);
notificationManager.sendNotification(smsNotification);
notificationManager.sendNotification(pushNotification);*/

public class NotificationManager {
    private final Map<NotificationType, Consumer<Notification>> handlers = new HashMap<>();

    public void registerHandler(NotificationType type, Consumer<Notification> handler) {
        handlers.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Нет обработчика для типа уведомления: " + notification.getType());
        }
    }
}

