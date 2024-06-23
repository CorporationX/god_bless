package faang.school.godbless.Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    static Map<String , Consumer<Notification>> handlers = new HashMap<>();

    public static void registrHandler(String obj , Consumer<Notification> consumerHandler){
        handlers.put(obj , consumerHandler);
    }

    public static void sendNotification(Notification notification){
        Consumer<Notification> handler = handlers.get(notification.type());
        if(handler != null){
            handler.accept(notification);
        } else {
            System.out.println("Объект не найден");
        }
    }

}
