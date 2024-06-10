package faang.school.godbless.Task_MetaUniverse;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


public class NotificationManager {

    private Map<String, Consumer<Notification>> noteService;

    public NotificationManager() {
        noteService = new HashMap<>();
    }

    public void registerHandler(String notificationType, Consumer<Notification> consumer) {
        noteService.put(notificationType, consumer);
    }

    public void sendNotification(Notification notification) {
        System.out.println(noteService.get(notification.getType()));
    }

}
