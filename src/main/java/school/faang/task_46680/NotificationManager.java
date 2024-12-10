package school.faang.task_46680;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private HashMap<String, Consumer<Notification>> notifications = new HashMap<>();
    private static final HashMap<String, List<String>> FILTER_TEMPLATES = new HashMap<>();

    static {
        FILTER_TEMPLATES.put("Запрещенный товар", List.of("Оружие", "Алкоголь", "Никотин"));
        FILTER_TEMPLATES.put("Обман", List.of("Мошенничество", "Введение в заблуждение"));
        FILTER_TEMPLATES.put("Насилие и вражда", List.of("Оскорбления", "Призывы к травле"));
    }

    public void registerHandler(String type, Consumer<Notification> notification) {
        notifications.put(type, notification);
    }

    public void sendNotification(Notification object) {
        Consumer<Notification> notification = notifications.get(object.getType());
        if (notification == null) {
            System.out.println(String.format("По типу уведомления %s не найдено обработчика", object.getType()));
            return;
        }
        notification.accept(object);
    }

    public boolean isDeleteNotification(Notification notification) {
        for (Map.Entry<String, List<String>> entry : FILTER_TEMPLATES.entrySet()) {
            for (String value : entry.getValue()) {
                if (notification.getMessage().toLowerCase().indexOf(value.toLowerCase()) != -1) {
                    return true;
                }
            }
        }
        return false;
    }
}
