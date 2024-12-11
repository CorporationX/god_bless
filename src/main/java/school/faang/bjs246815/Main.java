package school.faang.bjs246815;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        Notification notif = new Notification("EMAIL", "спам");
        Notification warn = new Notification("WARN", "предупреждение о погоде");
        Notification push = new Notification("PUSH", "что-то пушнуло");

        notificationManager.registerHandler(notif.getType(),
                notification -> System.out.println("EMAIL " + notification.getMessage()));
        notificationManager.registerHandler(warn.getType(),
                notification -> System.out.println("СРОЧНО " + notification.getMessage()));
        notificationManager.registerHandler(push.getType(),
                notification -> System.out.println("ПРОВЕРЬ ТЕЛЕФОН " + notification.getMessage()));

        List.of(notif, warn, push).forEach(notificationManager::sendNotification);
    }
}
