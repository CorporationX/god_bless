package school.faang.BJS234742.service;

import lombok.Data;
import school.faang.BJS234742.dto.Notification;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Data
public class NotificationManager {
     private Map<String, Consumer<Notification>> notificationConsumerMap;

     public NotificationManager(){
         this.notificationConsumerMap = new HashMap<>();
     }

     public void registerHandler(String typeNotification, Consumer<Notification> notificationConsumer) {
        this.getNotificationConsumerMap().put(typeNotification, notificationConsumer);
     }

     public void sendNotification(Notification notification) {
         this.getNotificationConsumerMap().get(notification.getType()).accept(notification);
     }
}
