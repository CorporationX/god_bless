package faang.school.godbless.Sprint_2.BJS2_10137;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String, Consumer> alerts = new HashMap<>();
    public void registerHandler(String notification, Consumer<Notification> consumer){
        alerts.put(notification, consumer);
    }
    public void sendNotification(Notification notification){
        if(alerts.containsKey(notification.getType())){
            alerts.get(notification.getType()).accept(notification);
        }else{
            System.out.println("Нэма такого оповещателся");
        }
    }
}
