package org.example.service.meta;

import org.example.model.meta.Notification;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    public static Map<String, Consumer<Notification>> notificationByType = new HashMap<>();

    public static void registerHandler(String type, Consumer<Notification> notification) {
        NotificationManager.notificationByType.put(type, notification);
    }

    public static void sendNotification(Notification notification) {
        if(notificationByType.containsKey(notification.getType())){
            notificationByType.get(notification.getType()).accept(notification);
        }else{
            throw new IllegalArgumentException("we dont have such notification{" + notification.toString() + "}");
        }
    }

    public static void main(String[] args) {
        NotificationManager.registerHandler("email", notification -> {
            System.out.println("sent by email: " + notification.getMessage());
        });
        NotificationManager.registerHandler("what's app", notification -> {
            System.out.println("sent by what's App: " + notification.getMessage());
        });
        NotificationManager.registerHandler("sms", notification -> {
            System.out.println("sent by sms: " + notification.getMessage());
        });

        try{
            NotificationManager.sendNotification(new Notification("email", "hello we send email message to restore password!"));
            NotificationManager.sendNotification(new Notification("what's app", "welcome to our group"));
            NotificationManager.sendNotification(new Notification("asdf", "ticket to final game Aktobe - Atyrau"));
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
