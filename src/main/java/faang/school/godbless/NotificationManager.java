package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    static Map<String, Consumer<Notification>> interfacesMap = new HashMap<>();

    public static void registerHandler(Notification notification, Consumer<Notification> consumer) {
        interfacesMap.put(notification.getType(), consumer);
    }

    public static void sendNotification(String type) {
        interfacesMap.get(type);
    }

    public static void main(String[] args) {
        Notification notification1 = new Notification("PushNotification", "You received code");
        Notification notification2 = new Notification("PushNotification", "You received message");
        Notification notification3 = new Notification("WorkNotification", "New task added");
        Notification notification4 = new Notification("WorkNotification", "Task received");
        Notification notification5 = new Notification("WeatherNotification", "Weather is windy today");
        Consumer<Notification> first = param -> System.out.println("Регистр 1 установлен");
        Consumer<Notification> second = param -> System.out.println("Регистр 2 установлен");
        Consumer<Notification> third = param -> System.out.println("Регистр 3 установлен");
        first.accept(notification1);
        second.accept(notification2);
        third.accept(notification3);
    }
}
