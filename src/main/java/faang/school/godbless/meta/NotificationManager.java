package main.java.faang.school.godbless.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NotificationManager {
    Map<String, Consumer<Notification>> map = new HashMap<>();
    List<Predicate<Notification>> list = new ArrayList<>();

    public void registerHandler(String type, Consumer<Notification> handler) {
        if (type == null && type.isEmpty()) {
            throw new IllegalArgumentException("Пустая строка");
        }
        map.put(type, handler);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> hdl = map.get(notification.getType());
        map.get(notification.getType());
        hdl.accept(notification);
    }

    void fillList(Predicate<Notification> nn) {
        list.add(nn);
    }

    public void filter(Notification notification) {
        for (Predicate<Notification> loopi : list) {
            if (!loopi.test(notification))
                throw new IllegalArgumentException();
        }
    }
}
