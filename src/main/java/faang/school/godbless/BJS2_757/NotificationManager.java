package faang.school.godbless.BJS2_757;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class NotificationManager{
    Map<String, Consumer<Notification>> mapOfNotification = new HashMap<>();
    public void registerHandler(String type, Consumer<Notification> notification){
        mapOfNotification.put(type, notification);
    }

    public void sendNotification(Notification notification){
        if(mapOfNotification.containsKey(notification.getType())){
            mapOfNotification.get(notification.getType()).accept(notification);
        }else{
            throw new RuntimeException("There are no this notification");
        }
    }
}
