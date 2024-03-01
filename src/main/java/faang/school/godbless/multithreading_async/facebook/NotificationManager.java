package faang.school.godbless.multithreading_async.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NotificationManager {
    private final List<Notification> notificationList = new ArrayList<>();

    public void addNotification(Notification notification){
        notificationList.add(notification);
    }

    public CompletableFuture<Void> fetchNotification(Notification notification){
        return CompletableFuture.runAsync(() ->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            addNotification(notification);
            System.out.println("Уведомление отправлено, id: " + notification.getId());
        });
    }

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        List<Notification> notifications = getNotificationList();
        List<CompletableFuture<Void>> futureNotifications = new ArrayList<>();
        for (Notification notification : notifications) {
            futureNotifications.add(notificationManager.fetchNotification(notification));
        }
        CompletableFuture.allOf(futureNotifications.toArray(CompletableFuture[]::new))
                .join();
    }

    private static List<Notification> getNotificationList(){
        List<Notification> notificationList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            notificationList.add(new Notification(i, "Notification № " + i));
        }
        return notificationList;
    }
}
