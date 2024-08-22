package Meta_Universe;


import java.util.HashMap;
import java.util.Map;

public class NotificationManager {
    //Менеджер уведомлений
    private Map<String, Consumer> handlers = new HashMap<>(); // обработчики

    public void registerHandler(String alertID, Consumer handler) {
        // регистр обработчик
        handlers.put(alertID, handler);
    }

    public void sendNotification(Notification notification) {
        // отправить уведомление
        Consumer handler = handlers.get(notification.getType());
        if (handler != null) {
            handler.accept(notification);
        } else {
            System.out.println("Ни один обработчик не зарегистрирован для типа уведомления: " + notification.getType());
        }
    }
}

// Создан Мар "обработчики", который принимает в себя строку и интерфейс.
// Создан метод "регистр обработчик", который принимает в себя "индификатор оповещения" и интерфейс. Этими данными он наполняет Map.
/* Создан метод "Отправить уведомление", который принимает в себя поля класса "Менеджер уведомлений"
в мапе ищеться
если строка не пустая, то вызываеться метод интерфейса и ему передаеться
 */
