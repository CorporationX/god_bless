package faang.school.godbless.Task_MetaUniverse;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@NoArgsConstructor
public class NotificationManager {

    private static final Map<String, Consumer<Notification>> noteService = new HashMap<>();

    public void registerHandler(String notificationType, Consumer<Notification> consumer) {
        noteService.put(notificationType, consumer);
    }

    public void sendNotification(Notification notification) {
        System.out.println(noteService.get(notification.getType()));
    }

}
