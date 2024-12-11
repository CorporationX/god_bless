package school.faang.bjs246815;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        Notification notif = new Notification("EMAIL", "спам");
        Notification warn = new Notification("WARN", "предупреждение о погоде");
        Notification push = new Notification("PUSH", "что-то пушнуло");

        notificationManager.registerHandler(notif.getType(),
                notification -> printNotification("EMAIL ", notification));
        notificationManager.registerHandler(warn.getType(),
                notification -> printNotification("СРОЧНО ", notification));
        notificationManager.registerHandler(push.getType(),
                notification -> printNotification("ПРОВЕРЬ ТЕЛЕФОН ", notification));

        List.of(notif, warn, push).forEach(notificationManager::sendNotification);
    }

    private static void printNotification(String prefix, Notification notification) {
        System.out.println(prefix + notification.getMessage());
    }
}
